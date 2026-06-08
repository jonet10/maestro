package androidx.emoji2.text.flatbuffer;

import a4.x;
import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class FlatBufferBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    ByteBuffer bb;
    ByteBufferFactory bb_factory;
    boolean finished;
    boolean force_defaults;
    int minalign;
    boolean nested;
    int num_vtables;
    int object_start;
    int space;
    final Utf8 utf8;
    int vector_num_elems;
    int[] vtable;
    int vtable_in_use;
    int[] vtables;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class ByteBufferBackedInputStream extends InputStream {
        ByteBuffer buf;

        public ByteBufferBackedInputStream(ByteBuffer byteBuffer) {
            this.buf = byteBuffer;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            try {
                return this.buf.get() & 255;
            } catch (BufferUnderflowException unused) {
                return -1;
            }
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class HeapByteBufferFactory extends ByteBufferFactory {
        public static final HeapByteBufferFactory INSTANCE = new HeapByteBufferFactory();

        @Override // androidx.emoji2.text.flatbuffer.FlatBufferBuilder.ByteBufferFactory
        public ByteBuffer newByteBuffer(int i) {
            return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
        }
    }

    public FlatBufferBuilder(int i, ByteBufferFactory byteBufferFactory, ByteBuffer byteBuffer, Utf8 utf8) {
        this.minalign = 1;
        this.vtable = null;
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.vtables = new int[16];
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        this.force_defaults = false;
        i = i <= 0 ? 1 : i;
        this.bb_factory = byteBufferFactory;
        if (byteBuffer != null) {
            this.bb = byteBuffer;
            byteBuffer.clear();
            this.bb.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.bb = byteBufferFactory.newByteBuffer(i);
        }
        this.utf8 = utf8;
        this.space = this.bb.capacity();
    }

    @Deprecated
    private int dataStart() {
        finished();
        return this.space;
    }

    public static ByteBuffer growByteBuffer(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        int capacity = byteBuffer.capacity();
        if (((-1073741824) & capacity) != 0) {
            o.j("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
            return null;
        }
        int i = capacity == 0 ? 1 : capacity << 1;
        byteBuffer.position(0);
        ByteBuffer newByteBuffer = byteBufferFactory.newByteBuffer(i);
        newByteBuffer.position(newByteBuffer.clear().capacity() - capacity);
        newByteBuffer.put(byteBuffer);
        return newByteBuffer;
    }

    public static boolean isFieldPresent(Table table, int i) {
        return table.__offset(i) != 0;
    }

    public void Nested(int i) {
        if (i == offset()) {
            return;
        }
        o.j("FlatBuffers: struct must be serialized inline.");
    }

    public void addBoolean(int i, boolean z9, boolean z10) {
        if (this.force_defaults || z9 != z10) {
            addBoolean(z9);
            slot(i);
        }
    }

    public void addByte(int i, byte b7, int i6) {
        if (this.force_defaults || b7 != i6) {
            addByte(b7);
            slot(i);
        }
    }

    public void addDouble(int i, double d10, double d11) {
        if (this.force_defaults || d10 != d11) {
            addDouble(d10);
            slot(i);
        }
    }

    public void addFloat(int i, float f, double d10) {
        if (this.force_defaults || f != d10) {
            addFloat(f);
            slot(i);
        }
    }

    public void addInt(int i, int i6, int i10) {
        if (this.force_defaults || i6 != i10) {
            addInt(i6);
            slot(i);
        }
    }

    public void addLong(int i, long j, long j6) {
        if (this.force_defaults || j != j6) {
            addLong(j);
            slot(i);
        }
    }

    public void addOffset(int i) {
        prep(4, 0);
        putInt((offset() - i) + 4);
    }

    public void addShort(int i, short s6, int i6) {
        if (this.force_defaults || s6 != i6) {
            addShort(s6);
            slot(i);
        }
    }

    public void addStruct(int i, int i6, int i10) {
        if (i6 != i10) {
            Nested(i6);
            slot(i);
        }
    }

    public void clear() {
        this.space = this.bb.capacity();
        this.bb.clear();
        this.minalign = 1;
        while (true) {
            int i = this.vtable_in_use;
            if (i <= 0) {
                this.vtable_in_use = 0;
                this.nested = false;
                this.finished = false;
                this.object_start = 0;
                this.num_vtables = 0;
                this.vector_num_elems = 0;
                return;
            }
            int[] iArr = this.vtable;
            int i6 = i - 1;
            this.vtable_in_use = i6;
            iArr[i6] = 0;
        }
    }

    public int createByteVector(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        startVector(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.bb;
        int i = this.space - remaining;
        this.space = i;
        byteBuffer2.position(i);
        this.bb.put(byteBuffer);
        return endVector();
    }

    public <T extends Table> int createSortedVectorOfTables(T t9, int[] iArr) {
        t9.sortTables(iArr, this.bb);
        return createVectorOfTables(iArr);
    }

    public int createString(CharSequence charSequence) {
        int encodedLength = this.utf8.encodedLength(charSequence);
        addByte((byte) 0);
        startVector(1, encodedLength, 1);
        ByteBuffer byteBuffer = this.bb;
        int i = this.space - encodedLength;
        this.space = i;
        byteBuffer.position(i);
        this.utf8.encodeUtf8(charSequence, this.bb);
        return endVector();
    }

    public ByteBuffer createUnintializedVector(int i, int i6, int i10) {
        int i11 = i * i6;
        startVector(i, i6, i10);
        ByteBuffer byteBuffer = this.bb;
        int i12 = this.space - i11;
        this.space = i12;
        byteBuffer.position(i12);
        ByteBuffer order = this.bb.slice().order(ByteOrder.LITTLE_ENDIAN);
        order.limit(i11);
        return order;
    }

    public int createVectorOfTables(int[] iArr) {
        notNested();
        startVector(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            addOffset(iArr[length]);
        }
        return endVector();
    }

    public ByteBuffer dataBuffer() {
        finished();
        return this.bb;
    }

    public int endTable() {
        int i;
        if (this.vtable == null || !this.nested) {
            o.j("FlatBuffers: endTable called without startTable");
            return 0;
        }
        addInt(0);
        int offset = offset();
        int i6 = this.vtable_in_use - 1;
        while (i6 >= 0 && this.vtable[i6] == 0) {
            i6--;
        }
        for (int i10 = i6; i10 >= 0; i10--) {
            int i11 = this.vtable[i10];
            addShort((short) (i11 != 0 ? offset - i11 : 0));
        }
        addShort((short) (offset - this.object_start));
        addShort((short) ((i6 + 3) * 2));
        int i12 = 0;
        loop2: while (true) {
            if (i12 >= this.num_vtables) {
                i = 0;
                break;
            }
            int capacity = this.bb.capacity() - this.vtables[i12];
            int i13 = this.space;
            short s6 = this.bb.getShort(capacity);
            if (s6 == this.bb.getShort(i13)) {
                for (int i14 = 2; i14 < s6; i14 += 2) {
                    if (this.bb.getShort(capacity + i14) != this.bb.getShort(i13 + i14)) {
                        break;
                    }
                }
                i = this.vtables[i12];
                break loop2;
            }
            i12++;
        }
        if (i != 0) {
            int capacity2 = this.bb.capacity() - offset;
            this.space = capacity2;
            this.bb.putInt(capacity2, i - offset);
        } else {
            int i15 = this.num_vtables;
            int[] iArr = this.vtables;
            if (i15 == iArr.length) {
                this.vtables = Arrays.copyOf(iArr, i15 * 2);
            }
            int[] iArr2 = this.vtables;
            int i16 = this.num_vtables;
            this.num_vtables = i16 + 1;
            iArr2[i16] = offset();
            ByteBuffer byteBuffer = this.bb;
            byteBuffer.putInt(byteBuffer.capacity() - offset, offset() - offset);
        }
        this.nested = false;
        return offset;
    }

    public int endVector() {
        if (!this.nested) {
            o.j("FlatBuffers: endVector called without startVector");
            return 0;
        }
        this.nested = false;
        putInt(this.vector_num_elems);
        return offset();
    }

    public void finish(int i, String str, boolean z9) {
        prep(this.minalign, (z9 ? 4 : 0) + 8);
        if (str.length() != 4) {
            o.j("FlatBuffers: file identifier must be length 4");
            return;
        }
        for (int i6 = 3; i6 >= 0; i6--) {
            addByte((byte) str.charAt(i6));
        }
        finish(i, z9);
    }

    public void finishSizePrefixed(int i) {
        finish(i, true);
    }

    public void finished() {
        if (this.finished) {
            return;
        }
        o.j("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
    }

    public FlatBufferBuilder forceDefaults(boolean z9) {
        this.force_defaults = z9;
        return this;
    }

    public FlatBufferBuilder init(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this.bb_factory = byteBufferFactory;
        this.bb = byteBuffer;
        byteBuffer.clear();
        this.bb.order(ByteOrder.LITTLE_ENDIAN);
        this.minalign = 1;
        this.space = this.bb.capacity();
        this.vtable_in_use = 0;
        this.nested = false;
        this.finished = false;
        this.object_start = 0;
        this.num_vtables = 0;
        this.vector_num_elems = 0;
        return this;
    }

    public void notNested() {
        if (this.nested) {
            o.j("FlatBuffers: object serialization must not be nested.");
        }
    }

    public int offset() {
        return this.bb.capacity() - this.space;
    }

    public void pad(int i) {
        for (int i6 = 0; i6 < i; i6++) {
            ByteBuffer byteBuffer = this.bb;
            int i10 = this.space - 1;
            this.space = i10;
            byteBuffer.put(i10, (byte) 0);
        }
    }

    public void prep(int i, int i6) {
        if (i > this.minalign) {
            this.minalign = i;
        }
        int i10 = ((~((this.bb.capacity() - this.space) + i6)) + 1) & (i - 1);
        while (this.space < i10 + i + i6) {
            int capacity = this.bb.capacity();
            ByteBuffer byteBuffer = this.bb;
            ByteBuffer growByteBuffer = growByteBuffer(byteBuffer, this.bb_factory);
            this.bb = growByteBuffer;
            if (byteBuffer != growByteBuffer) {
                this.bb_factory.releaseByteBuffer(byteBuffer);
            }
            this.space = (this.bb.capacity() - capacity) + this.space;
        }
        pad(i10);
    }

    public void putBoolean(boolean z9) {
        ByteBuffer byteBuffer = this.bb;
        int i = this.space - 1;
        this.space = i;
        byteBuffer.put(i, z9 ? (byte) 1 : (byte) 0);
    }

    public void putByte(byte b7) {
        ByteBuffer byteBuffer = this.bb;
        int i = this.space - 1;
        this.space = i;
        byteBuffer.put(i, b7);
    }

    public void putDouble(double d10) {
        ByteBuffer byteBuffer = this.bb;
        int i = this.space - 8;
        this.space = i;
        byteBuffer.putDouble(i, d10);
    }

    public void putFloat(float f) {
        ByteBuffer byteBuffer = this.bb;
        int i = this.space - 4;
        this.space = i;
        byteBuffer.putFloat(i, f);
    }

    public void putInt(int i) {
        ByteBuffer byteBuffer = this.bb;
        int i6 = this.space - 4;
        this.space = i6;
        byteBuffer.putInt(i6, i);
    }

    public void putLong(long j) {
        ByteBuffer byteBuffer = this.bb;
        int i = this.space - 8;
        this.space = i;
        byteBuffer.putLong(i, j);
    }

    public void putShort(short s6) {
        ByteBuffer byteBuffer = this.bb;
        int i = this.space - 2;
        this.space = i;
        byteBuffer.putShort(i, s6);
    }

    public void required(int i, int i6) {
        int capacity = this.bb.capacity() - i;
        if (this.bb.getShort((capacity - this.bb.getInt(capacity)) + i6) != 0) {
            return;
        }
        o.j(x.g(i6, "FlatBuffers: field ", " must be set"));
    }

    public byte[] sizedByteArray(int i, int i6) {
        finished();
        byte[] bArr = new byte[i6];
        this.bb.position(i);
        this.bb.get(bArr);
        return bArr;
    }

    public InputStream sizedInputStream() {
        finished();
        ByteBuffer duplicate = this.bb.duplicate();
        duplicate.position(this.space);
        duplicate.limit(this.bb.capacity());
        return new ByteBufferBackedInputStream(duplicate);
    }

    public void slot(int i) {
        this.vtable[i] = offset();
    }

    public void startTable(int i) {
        notNested();
        int[] iArr = this.vtable;
        if (iArr == null || iArr.length < i) {
            this.vtable = new int[i];
        }
        this.vtable_in_use = i;
        Arrays.fill(this.vtable, 0, i, 0);
        this.nested = true;
        this.object_start = offset();
    }

    public void startVector(int i, int i6, int i10) {
        notNested();
        this.vector_num_elems = i6;
        int i11 = i * i6;
        prep(4, i11);
        prep(i10, i11);
        this.nested = true;
    }

    public void finishSizePrefixed(int i, String str) {
        finish(i, str, true);
    }

    public void addBoolean(boolean z9) {
        prep(1, 0);
        putBoolean(z9);
    }

    public void addByte(byte b7) {
        prep(1, 0);
        putByte(b7);
    }

    public void addInt(int i) {
        prep(4, 0);
        putInt(i);
    }

    public void addOffset(int i, int i6, int i10) {
        if (this.force_defaults || i6 != i10) {
            addOffset(i6);
            slot(i);
        }
    }

    public void addShort(short s6) {
        prep(2, 0);
        putShort(s6);
    }

    public byte[] sizedByteArray() {
        return sizedByteArray(this.space, this.bb.capacity() - this.space);
    }

    public void addDouble(double d10) {
        prep(8, 0);
        putDouble(d10);
    }

    public void addLong(long j) {
        prep(8, 0);
        putLong(j);
    }

    public void addFloat(float f) {
        prep(4, 0);
        putFloat(f);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class ByteBufferFactory {
        public abstract ByteBuffer newByteBuffer(int i);

        public void releaseByteBuffer(ByteBuffer byteBuffer) {
        }
    }

    public int createByteVector(byte[] bArr, int i, int i6) {
        startVector(1, i6, 1);
        ByteBuffer byteBuffer = this.bb;
        int i10 = this.space - i6;
        this.space = i10;
        byteBuffer.position(i10);
        this.bb.put(bArr, i, i6);
        return endVector();
    }

    public int createByteVector(byte[] bArr) {
        int length = bArr.length;
        startVector(1, length, 1);
        ByteBuffer byteBuffer = this.bb;
        int i = this.space - length;
        this.space = i;
        byteBuffer.position(i);
        this.bb.put(bArr);
        return endVector();
    }

    public int createString(ByteBuffer byteBuffer) {
        int remaining = byteBuffer.remaining();
        addByte((byte) 0);
        startVector(1, remaining, 1);
        ByteBuffer byteBuffer2 = this.bb;
        int i = this.space - remaining;
        this.space = i;
        byteBuffer2.position(i);
        this.bb.put(byteBuffer);
        return endVector();
    }

    public void finish(int i) {
        finish(i, false);
    }

    public void finish(int i, boolean z9) {
        prep(this.minalign, (z9 ? 4 : 0) + 4);
        addOffset(i);
        if (z9) {
            addInt(this.bb.capacity() - this.space);
        }
        this.bb.position(this.space);
        this.finished = true;
    }

    public void finish(int i, String str) {
        finish(i, str, false);
    }

    public FlatBufferBuilder(int i, ByteBufferFactory byteBufferFactory) {
        this(i, byteBufferFactory, null, Utf8.getDefault());
    }

    public FlatBufferBuilder(int i) {
        this(i, HeapByteBufferFactory.INSTANCE, null, Utf8.getDefault());
    }

    public FlatBufferBuilder() {
        this(1024);
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer, ByteBufferFactory byteBufferFactory) {
        this(byteBuffer.capacity(), byteBufferFactory, byteBuffer, Utf8.getDefault());
    }

    public FlatBufferBuilder(ByteBuffer byteBuffer) {
        this(byteBuffer, new HeapByteBufferFactory());
    }
}
