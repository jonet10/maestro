package androidx.emoji2.text.flatbuffer;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
interface ReadWriteBuf extends ReadBuf {
    @Override // androidx.emoji2.text.flatbuffer.ReadBuf
    int limit();

    void put(byte b7);

    void put(byte[] bArr, int i, int i6);

    void putBoolean(boolean z9);

    void putDouble(double d10);

    void putFloat(float f);

    void putInt(int i);

    void putLong(long j);

    void putShort(short s6);

    boolean requestCapacity(int i);

    void set(int i, byte b7);

    void set(int i, byte[] bArr, int i6, int i10);

    void setBoolean(int i, boolean z9);

    void setDouble(int i, double d10);

    void setFloat(int i, float f);

    void setInt(int i, int i6);

    void setLong(int i, long j);

    void setShort(int i, short s6);

    int writePosition();
}
