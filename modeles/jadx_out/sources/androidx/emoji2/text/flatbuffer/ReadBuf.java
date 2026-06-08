package androidx.emoji2.text.flatbuffer;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
interface ReadBuf {
    byte[] data();

    byte get(int i);

    boolean getBoolean(int i);

    double getDouble(int i);

    float getFloat(int i);

    int getInt(int i);

    long getLong(int i);

    short getShort(int i);

    String getString(int i, int i6);

    int limit();
}
