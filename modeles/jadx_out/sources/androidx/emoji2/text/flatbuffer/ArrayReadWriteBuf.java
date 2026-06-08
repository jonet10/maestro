package androidx.emoji2.text.flatbuffer;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ArrayReadWriteBuf implements ReadWriteBuf {
    private byte[] buffer;
    private int writePos;

    public ArrayReadWriteBuf(byte[] bArr) {
        this.buffer = bArr;
        this.writePos = 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte[] data() {
        return this.buffer;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public byte get(int i) {
        return this.buffer[i];
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public boolean getBoolean(int i) {
        return this.buffer[i] != 0;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public double getDouble(int i) {
        return Double.longBitsToDouble(getLong(i));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public float getFloat(int i) {
        return Float.intBitsToFloat(getInt(i));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public int getInt(int i) {
        byte[] bArr = this.buffer;
        return (bArr[i] & 255) | (bArr[i + 3] << 24) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 1] & 255) << 8);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public long getLong(int i) {
        byte[] bArr = this.buffer;
        return (bArr[i + 7] << 56) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << 16) | ((bArr[i + 3] & 255) << 24) | ((bArr[i + 4] & 255) << 32) | ((bArr[i + 5] & 255) << 40) | ((255 & bArr[i + 6]) << 48);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public short getShort(int i) {
        byte[] bArr = this.buffer;
        return (short) ((bArr[i] & 255) | (bArr[i + 1] << 8));
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    public String getString(int i, int i6) {
        return Utf8Safe.decodeUtf8Array(this.buffer, i, i6);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf, androidx.emoji2.text.flatbuffer.ReadBuf
    public int limit() {
        return this.writePos;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte b7) {
        set(this.writePos, b7);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putBoolean(boolean z9) {
        setBoolean(this.writePos, z9);
        this.writePos++;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putDouble(double d10) {
        setDouble(this.writePos, d10);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putFloat(float f) {
        setFloat(this.writePos, f);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putInt(int i) {
        setInt(this.writePos, i);
        this.writePos += 4;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putLong(long j) {
        setLong(this.writePos, j);
        this.writePos += 8;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void putShort(short s6) {
        setShort(this.writePos, s6);
        this.writePos += 2;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public boolean requestCapacity(int i) {
        byte[] bArr = this.buffer;
        if (bArr.length > i) {
            return true;
        }
        int length = bArr.length;
        this.buffer = Arrays.copyOf(bArr, length + (length >> 1));
        return true;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i, byte[] bArr, int i6, int i10) {
        requestCapacity((i10 - i6) + i);
        System.arraycopy(bArr, i6, this.buffer, i, i10);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setBoolean(int i, boolean z9) {
        set(i, z9 ? (byte) 1 : (byte) 0);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setDouble(int i, double d10) {
        requestCapacity(i + 8);
        long doubleToRawLongBits = Double.doubleToRawLongBits(d10);
        int i6 = (int) doubleToRawLongBits;
        byte[] bArr = this.buffer;
        bArr[i] = (byte) (i6 & 255);
        bArr[i + 1] = (byte) ((i6 >> 8) & 255);
        bArr[i + 2] = (byte) ((i6 >> 16) & 255);
        bArr[i + 3] = (byte) ((i6 >> 24) & 255);
        int i10 = (int) (doubleToRawLongBits >> 32);
        bArr[i + 4] = (byte) (i10 & 255);
        bArr[i + 5] = (byte) ((i10 >> 8) & 255);
        bArr[i + 6] = (byte) ((i10 >> 16) & 255);
        bArr[i + 7] = (byte) ((i10 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setFloat(int i, float f) {
        requestCapacity(i + 4);
        int floatToRawIntBits = Float.floatToRawIntBits(f);
        byte[] bArr = this.buffer;
        bArr[i] = (byte) (floatToRawIntBits & 255);
        bArr[i + 1] = (byte) ((floatToRawIntBits >> 8) & 255);
        bArr[i + 2] = (byte) ((floatToRawIntBits >> 16) & 255);
        bArr[i + 3] = (byte) ((floatToRawIntBits >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setInt(int i, int i6) {
        requestCapacity(i + 4);
        byte[] bArr = this.buffer;
        bArr[i] = (byte) (i6 & 255);
        bArr[i + 1] = (byte) ((i6 >> 8) & 255);
        bArr[i + 2] = (byte) ((i6 >> 16) & 255);
        bArr[i + 3] = (byte) ((i6 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setLong(int i, long j) {
        requestCapacity(i + 8);
        int i6 = (int) j;
        byte[] bArr = this.buffer;
        bArr[i] = (byte) (i6 & 255);
        bArr[i + 1] = (byte) ((i6 >> 8) & 255);
        bArr[i + 2] = (byte) ((i6 >> 16) & 255);
        bArr[i + 3] = (byte) ((i6 >> 24) & 255);
        int i10 = (int) (j >> 32);
        bArr[i + 4] = (byte) (i10 & 255);
        bArr[i + 5] = (byte) ((i10 >> 8) & 255);
        bArr[i + 6] = (byte) ((i10 >> 16) & 255);
        bArr[i + 7] = (byte) ((i10 >> 24) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void setShort(int i, short s6) {
        requestCapacity(i + 2);
        byte[] bArr = this.buffer;
        bArr[i] = (byte) (s6 & 255);
        bArr[i + 1] = (byte) ((s6 >> 8) & 255);
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public int writePosition() {
        return this.writePos;
    }

    public ArrayReadWriteBuf(int i) {
        this(new byte[i]);
    }

    public ArrayReadWriteBuf() {
        this(10);
    }

    public ArrayReadWriteBuf(byte[] bArr, int i) {
        this.buffer = bArr;
        this.writePos = i;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void put(byte[] bArr, int i, int i6) {
        set(this.writePos, bArr, i, i6);
        this.writePos += i6;
    }

    @Override // androidx.emoji2.text.flatbuffer.ReadWriteBuf
    public void set(int i, byte b7) {
        requestCapacity(i + 1);
        this.buffer[i] = b7;
    }
}
