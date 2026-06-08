package androidx.emoji2.text.flatbuffer;

import androidx.emoji2.text.flatbuffer.FlexBuffers;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class FlexBuffersBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final int BUILDER_FLAG_NONE = 0;
    public static final int BUILDER_FLAG_SHARE_ALL = 7;
    public static final int BUILDER_FLAG_SHARE_KEYS = 1;
    public static final int BUILDER_FLAG_SHARE_KEYS_AND_STRINGS = 3;
    public static final int BUILDER_FLAG_SHARE_KEY_VECTORS = 4;
    public static final int BUILDER_FLAG_SHARE_STRINGS = 2;
    private static final int WIDTH_16 = 1;
    private static final int WIDTH_32 = 2;
    private static final int WIDTH_64 = 3;
    private static final int WIDTH_8 = 0;
    private final ReadWriteBuf bb;
    private boolean finished;
    private final int flags;
    private Comparator<Value> keyComparator;
    private final HashMap<String, Integer> keyPool;
    private final ArrayList<Value> stack;
    private final HashMap<String, Integer> stringPool;

    public FlexBuffersBuilder(ReadWriteBuf readWriteBuf, int i) {
        this.stack = new ArrayList<>();
        this.keyPool = new HashMap<>();
        this.stringPool = new HashMap<>();
        this.finished = false;
        this.keyComparator = new Comparator<Value>() { // from class: androidx.emoji2.text.flatbuffer.FlexBuffersBuilder.1
            @Override // java.util.Comparator
            public int compare(Value value, Value value2) {
                byte b7;
                byte b10;
                int i6 = value.key;
                int i10 = value2.key;
                do {
                    b7 = FlexBuffersBuilder.this.bb.get(i6);
                    b10 = FlexBuffersBuilder.this.bb.get(i10);
                    if (b7 == 0) {
                        return b7 - b10;
                    }
                    i6++;
                    i10++;
                } while (b7 == b10);
                return b7 - b10;
            }
        };
        this.bb = readWriteBuf;
        this.flags = i;
    }

    private int align(int i) {
        int i6 = 1 << i;
        int paddingBytes = Value.paddingBytes(this.bb.writePosition(), i6);
        while (true) {
            int i10 = paddingBytes - 1;
            if (paddingBytes == 0) {
                return i6;
            }
            this.bb.put((byte) 0);
            paddingBytes = i10;
        }
    }

    private Value createKeyVector(int i, int i6) {
        long j = i6;
        int max = Math.max(0, widthUInBits(j));
        int i10 = i;
        while (i10 < this.stack.size()) {
            int i11 = i10 + 1;
            max = Math.max(max, Value.elemWidth(4, 0, this.stack.get(i10).key, this.bb.writePosition(), i11));
            i10 = i11;
        }
        int align = align(max);
        writeInt(j, align);
        int writePosition = this.bb.writePosition();
        while (i < this.stack.size()) {
            int i12 = this.stack.get(i).key;
            writeOffset(this.stack.get(i).key, align);
            i++;
        }
        return new Value(-1, FlexBuffers.toTypedVector(4, 0), max, writePosition);
    }

    private Value createVector(int i, int i6, int i10, boolean z9, boolean z10, Value value) {
        int i11;
        int i12;
        int i13 = i10;
        long j = i13;
        int max = Math.max(0, widthUInBits(j));
        if (value != null) {
            max = Math.max(max, value.elemWidth(this.bb.writePosition(), 0));
            i11 = 3;
        } else {
            i11 = 1;
        }
        int i14 = 4;
        int i15 = max;
        for (int i16 = i6; i16 < this.stack.size(); i16++) {
            i15 = Math.max(i15, this.stack.get(i16).elemWidth(this.bb.writePosition(), i16 + i11));
            if (z9 && i16 == i6) {
                i14 = this.stack.get(i16).type;
                if (!FlexBuffers.isTypedVectorElementType(i14)) {
                    throw new FlexBuffers.FlexBufferException("TypedVector does not support this element type");
                }
            }
        }
        int i17 = i6;
        int align = align(i15);
        if (value != null) {
            writeOffset(value.iValue, align);
            writeInt(1 << value.minBitWidth, align);
        }
        if (!z10) {
            writeInt(j, align);
        }
        int writePosition = this.bb.writePosition();
        for (int i18 = i17; i18 < this.stack.size(); i18++) {
            writeAny(this.stack.get(i18), align);
        }
        if (!z9) {
            while (i17 < this.stack.size()) {
                this.bb.put(this.stack.get(i17).storedPackedType(i15));
                i17++;
            }
        }
        if (value != null) {
            i12 = 9;
        } else if (z9) {
            if (!z10) {
                i13 = 0;
            }
            i12 = FlexBuffers.toTypedVector(i14, i13);
        } else {
            i12 = 10;
        }
        return new Value(i, i12, i15, writePosition);
    }

    private int putKey(String str) {
        if (str == null) {
            return -1;
        }
        int writePosition = this.bb.writePosition();
        if ((this.flags & 1) == 0) {
            byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
            this.bb.put(bytes, 0, bytes.length);
            this.bb.put((byte) 0);
            this.keyPool.put(str, Integer.valueOf(writePosition));
            return writePosition;
        }
        Integer num = this.keyPool.get(str);
        if (num != null) {
            return num.intValue();
        }
        byte[] bytes2 = str.getBytes(StandardCharsets.UTF_8);
        this.bb.put(bytes2, 0, bytes2.length);
        this.bb.put((byte) 0);
        this.keyPool.put(str, Integer.valueOf(writePosition));
        return writePosition;
    }

    private void putUInt(String str, long j) {
        int putKey = putKey(str);
        int widthUInBits = widthUInBits(j);
        this.stack.add(widthUInBits == 0 ? Value.uInt8(putKey, (int) j) : widthUInBits == 1 ? Value.uInt16(putKey, (int) j) : widthUInBits == 2 ? Value.uInt32(putKey, (int) j) : Value.uInt64(putKey, j));
    }

    private void putUInt64(String str, long j) {
        this.stack.add(Value.uInt64(putKey(str), j));
    }

    public static int widthUInBits(long j) {
        if (j <= FlexBuffers.Unsigned.byteToUnsignedInt((byte) -1)) {
            return 0;
        }
        if (j <= FlexBuffers.Unsigned.shortToUnsignedInt((short) -1)) {
            return 1;
        }
        return j <= FlexBuffers.Unsigned.intToUnsignedLong(-1) ? 2 : 3;
    }

    private void writeAny(Value value, int i) {
        int i6 = value.type;
        if (i6 != 0 && i6 != 1 && i6 != 2) {
            if (i6 == 3) {
                writeDouble(value.dValue, i);
                return;
            } else if (i6 != 26) {
                writeOffset(value.iValue, i);
                return;
            }
        }
        writeInt(value.iValue, i);
    }

    private Value writeBlob(int i, byte[] bArr, int i6, boolean z9) {
        int widthUInBits = widthUInBits(bArr.length);
        writeInt(bArr.length, align(widthUInBits));
        int writePosition = this.bb.writePosition();
        this.bb.put(bArr, 0, bArr.length);
        if (z9) {
            this.bb.put((byte) 0);
        }
        return Value.blob(i, writePosition, i6, widthUInBits);
    }

    private void writeDouble(double d10, int i) {
        if (i == 4) {
            this.bb.putFloat((float) d10);
        } else if (i == 8) {
            this.bb.putDouble(d10);
        }
    }

    private void writeInt(long j, int i) {
        if (i == 1) {
            this.bb.put((byte) j);
            return;
        }
        if (i == 2) {
            this.bb.putShort((short) j);
        } else if (i == 4) {
            this.bb.putInt((int) j);
        } else {
            if (i != 8) {
                return;
            }
            this.bb.putLong(j);
        }
    }

    private void writeOffset(long j, int i) {
        writeInt((int) (this.bb.writePosition() - j), i);
    }

    private Value writeString(int i, String str) {
        return writeBlob(i, str.getBytes(StandardCharsets.UTF_8), 5, true);
    }

    public int endMap(String str, int i) {
        int putKey = putKey(str);
        ArrayList<Value> arrayList = this.stack;
        Collections.sort(arrayList.subList(i, arrayList.size()), this.keyComparator);
        Value createVector = createVector(putKey, i, this.stack.size() - i, false, false, createKeyVector(i, this.stack.size() - i));
        while (true) {
            int size = this.stack.size();
            ArrayList<Value> arrayList2 = this.stack;
            if (size <= i) {
                arrayList2.add(createVector);
                return (int) createVector.iValue;
            }
            arrayList2.remove(arrayList2.size() - 1);
        }
    }

    public int endVector(String str, int i, boolean z9, boolean z10) {
        Value createVector = createVector(putKey(str), i, this.stack.size() - i, z9, z10, null);
        while (true) {
            int size = this.stack.size();
            ArrayList<Value> arrayList = this.stack;
            if (size <= i) {
                arrayList.add(createVector);
                return (int) createVector.iValue;
            }
            arrayList.remove(arrayList.size() - 1);
        }
    }

    public ByteBuffer finish() {
        int align = align(this.stack.get(0).elemWidth(this.bb.writePosition(), 0));
        writeAny(this.stack.get(0), align);
        this.bb.put(this.stack.get(0).storedPackedType());
        this.bb.put((byte) align);
        this.finished = true;
        return ByteBuffer.wrap(this.bb.data(), 0, this.bb.writePosition());
    }

    public ReadWriteBuf getBuffer() {
        return this.bb;
    }

    public int putBlob(String str, byte[] bArr) {
        Value writeBlob = writeBlob(putKey(str), bArr, 25, false);
        this.stack.add(writeBlob);
        return (int) writeBlob.iValue;
    }

    public void putBoolean(String str, boolean z9) {
        this.stack.add(Value.bool(putKey(str), z9));
    }

    public void putFloat(String str, float f) {
        this.stack.add(Value.float32(putKey(str), f));
    }

    public void putInt(String str, long j) {
        int putKey = putKey(str);
        if (-128 <= j && j <= 127) {
            this.stack.add(Value.int8(putKey, (int) j));
            return;
        }
        if (-32768 <= j && j <= 32767) {
            this.stack.add(Value.int16(putKey, (int) j));
        } else if (-2147483648L > j || j > 2147483647L) {
            this.stack.add(Value.int64(putKey, j));
        } else {
            this.stack.add(Value.int32(putKey, (int) j));
        }
    }

    public int putString(String str, String str2) {
        int putKey = putKey(str);
        if ((this.flags & 2) == 0) {
            Value writeString = writeString(putKey, str2);
            this.stack.add(writeString);
            return (int) writeString.iValue;
        }
        Integer num = this.stringPool.get(str2);
        if (num != null) {
            this.stack.add(Value.blob(putKey, num.intValue(), 5, widthUInBits(str2.length())));
            return num.intValue();
        }
        Value writeString2 = writeString(putKey, str2);
        this.stringPool.put(str2, Integer.valueOf((int) writeString2.iValue));
        this.stack.add(writeString2);
        return (int) writeString2.iValue;
    }

    public int startMap() {
        return this.stack.size();
    }

    public int startVector() {
        return this.stack.size();
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class Value {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        final double dValue;
        long iValue;
        int key;
        final int minBitWidth;
        final int type;

        public Value(int i, int i6, int i10, long j) {
            this.key = i;
            this.type = i6;
            this.minBitWidth = i10;
            this.iValue = j;
            this.dValue = Double.MIN_VALUE;
        }

        public static Value blob(int i, int i6, int i10, int i11) {
            return new Value(i, i10, i11, i6);
        }

        public static Value bool(int i, boolean z9) {
            return new Value(i, 26, 0, z9 ? 1L : 0L);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int elemWidth(int i, int i6, long j, int i10, int i11) {
            if (FlexBuffers.isTypeInline(i)) {
                return i6;
            }
            for (int i12 = 1; i12 <= 32; i12 *= 2) {
                int widthUInBits = FlexBuffersBuilder.widthUInBits((int) (((i11 * i12) + (paddingBytes(i10, i12) + i10)) - j));
                if ((1 << widthUInBits) == i12) {
                    return widthUInBits;
                }
            }
            return 3;
        }

        public static Value float32(int i, float f) {
            return new Value(i, 3, 2, f);
        }

        public static Value float64(int i, double d10) {
            return new Value(i, 3, 3, d10);
        }

        public static Value int16(int i, int i6) {
            return new Value(i, 1, 1, i6);
        }

        public static Value int32(int i, int i6) {
            return new Value(i, 1, 2, i6);
        }

        public static Value int64(int i, long j) {
            return new Value(i, 1, 3, j);
        }

        public static Value int8(int i, int i6) {
            return new Value(i, 1, 0, i6);
        }

        private static byte packedType(int i, int i6) {
            return (byte) (i | (i6 << 2));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int paddingBytes(int i, int i6) {
            return ((~i) + 1) & (i6 - 1);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte storedPackedType(int i) {
            return packedType(storedWidth(i), this.type);
        }

        private int storedWidth(int i) {
            boolean isTypeInline = FlexBuffers.isTypeInline(this.type);
            int i6 = this.minBitWidth;
            return isTypeInline ? Math.max(i6, i) : i6;
        }

        public static Value uInt16(int i, int i6) {
            return new Value(i, 2, 1, i6);
        }

        public static Value uInt32(int i, int i6) {
            return new Value(i, 2, 2, i6);
        }

        public static Value uInt64(int i, long j) {
            return new Value(i, 2, 3, j);
        }

        public static Value uInt8(int i, int i6) {
            return new Value(i, 2, 0, i6);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public byte storedPackedType() {
            return storedPackedType(0);
        }

        public Value(int i, int i6, int i10, double d10) {
            this.key = i;
            this.type = i6;
            this.minBitWidth = i10;
            this.dValue = d10;
            this.iValue = Long.MIN_VALUE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public int elemWidth(int i, int i6) {
            return elemWidth(this.type, this.minBitWidth, this.iValue, i, i6);
        }
    }

    public void putBoolean(boolean z9) {
        putBoolean(null, z9);
    }

    public void putFloat(float f) {
        putFloat((String) null, f);
    }

    public void putUInt64(BigInteger bigInteger) {
        putUInt64(null, bigInteger.longValue());
    }

    public void putFloat(double d10) {
        putFloat((String) null, d10);
    }

    public void putFloat(String str, double d10) {
        this.stack.add(Value.float64(putKey(str), d10));
    }

    public int putBlob(byte[] bArr) {
        return putBlob(null, bArr);
    }

    public FlexBuffersBuilder() {
        this(256);
    }

    @Deprecated
    public FlexBuffersBuilder(ByteBuffer byteBuffer, int i) {
        this(new ArrayReadWriteBuf(byteBuffer.array()), i);
    }

    public FlexBuffersBuilder(int i) {
        this(new ArrayReadWriteBuf(i), 1);
    }

    public FlexBuffersBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, 1);
    }

    public void putUInt(long j) {
        putUInt(null, j);
    }

    public void putUInt(int i) {
        putUInt(null, i);
    }

    public void putInt(String str, int i) {
        putInt(str, i);
    }

    public void putInt(int i) {
        putInt((String) null, i);
    }

    public int putString(String str) {
        return putString(null, str);
    }

    public void putInt(long j) {
        putInt((String) null, j);
    }
}
