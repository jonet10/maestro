package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Comparator;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class Table {
    protected ByteBuffer bb;
    protected int bb_pos;
    Utf8 utf8 = Utf8.getDefault();
    private int vtable_size;
    private int vtable_start;

    public static boolean __has_identifier(ByteBuffer byteBuffer, String str) {
        if (str.length() != 4) {
            o.j("FlatBuffers: file identifier must be length 4");
            return false;
        }
        for (int i = 0; i < 4; i++) {
            if (str.charAt(i) != ((char) byteBuffer.get(byteBuffer.position() + 4 + i))) {
                return false;
            }
        }
        return true;
    }

    public static int __offset(int i, int i6, ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity() - i6;
        return byteBuffer.getShort((i + capacity) - byteBuffer.getInt(capacity)) + capacity;
    }

    public static String __string(int i, ByteBuffer byteBuffer, Utf8 utf8) {
        int i6 = byteBuffer.getInt(i) + i;
        return utf8.decodeUtf8(byteBuffer, i6 + 4, byteBuffer.getInt(i6));
    }

    public static Table __union(Table table, int i, ByteBuffer byteBuffer) {
        table.__reset(__indirect(i, byteBuffer), byteBuffer);
        return table;
    }

    public static int compareStrings(int i, int i6, ByteBuffer byteBuffer) {
        int i10 = byteBuffer.getInt(i) + i;
        int i11 = byteBuffer.getInt(i6) + i6;
        int i12 = byteBuffer.getInt(i10);
        int i13 = byteBuffer.getInt(i11);
        int i14 = i10 + 4;
        int i15 = i11 + 4;
        int min = Math.min(i12, i13);
        for (int i16 = 0; i16 < min; i16++) {
            int i17 = i16 + i14;
            int i18 = i16 + i15;
            if (byteBuffer.get(i17) != byteBuffer.get(i18)) {
                return byteBuffer.get(i17) - byteBuffer.get(i18);
            }
        }
        return i12 - i13;
    }

    public int __indirect(int i) {
        return this.bb.getInt(i) + i;
    }

    public void __reset(int i, ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        if (byteBuffer == null) {
            this.bb_pos = 0;
            this.vtable_start = 0;
            this.vtable_size = 0;
        } else {
            this.bb_pos = i;
            int i6 = i - byteBuffer.getInt(i);
            this.vtable_start = i6;
            this.vtable_size = this.bb.getShort(i6);
        }
    }

    public int __vector(int i) {
        int i6 = i + this.bb_pos;
        return this.bb.getInt(i6) + i6 + 4;
    }

    public ByteBuffer __vector_as_bytebuffer(int i, int i6) {
        int __offset = __offset(i);
        if (__offset == 0) {
            return null;
        }
        ByteBuffer order = this.bb.duplicate().order(ByteOrder.LITTLE_ENDIAN);
        int __vector = __vector(__offset);
        order.position(__vector);
        order.limit((__vector_len(__offset) * i6) + __vector);
        return order;
    }

    public ByteBuffer __vector_in_bytebuffer(ByteBuffer byteBuffer, int i, int i6) {
        int __offset = __offset(i);
        if (__offset == 0) {
            return null;
        }
        int __vector = __vector(__offset);
        byteBuffer.rewind();
        byteBuffer.limit((__vector_len(__offset) * i6) + __vector);
        byteBuffer.position(__vector);
        return byteBuffer;
    }

    public int __vector_len(int i) {
        int i6 = i + this.bb_pos;
        return this.bb.getInt(this.bb.getInt(i6) + i6);
    }

    public ByteBuffer getByteBuffer() {
        return this.bb;
    }

    public int keysCompare(Integer num, Integer num2, ByteBuffer byteBuffer) {
        return 0;
    }

    public void sortTables(int[] iArr, final ByteBuffer byteBuffer) {
        Integer[] numArr = new Integer[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        Arrays.sort(numArr, new Comparator<Integer>() { // from class: androidx.emoji2.text.flatbuffer.Table.1
            @Override // java.util.Comparator
            public int compare(Integer num, Integer num2) {
                return Table.this.keysCompare(num, num2, byteBuffer);
            }
        });
        for (int i6 = 0; i6 < iArr.length; i6++) {
            iArr[i6] = numArr[i6].intValue();
        }
    }

    public static int __indirect(int i, ByteBuffer byteBuffer) {
        return byteBuffer.getInt(i) + i;
    }

    public Table __union(Table table, int i) {
        return __union(table, i, this.bb);
    }

    public String __string(int i) {
        return __string(i, this.bb, this.utf8);
    }

    public int __offset(int i) {
        if (i < this.vtable_size) {
            return this.bb.getShort(this.vtable_start + i);
        }
        return 0;
    }

    public void __reset() {
        __reset(0, null);
    }

    public static int compareStrings(int i, byte[] bArr, ByteBuffer byteBuffer) {
        int i6 = byteBuffer.getInt(i) + i;
        int i10 = byteBuffer.getInt(i6);
        int length = bArr.length;
        int i11 = i6 + 4;
        int min = Math.min(i10, length);
        for (int i12 = 0; i12 < min; i12++) {
            int i13 = i12 + i11;
            if (byteBuffer.get(i13) != bArr[i12]) {
                return byteBuffer.get(i13) - bArr[i12];
            }
        }
        return i10 - length;
    }
}
