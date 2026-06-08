package androidx.collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class PackingUtilsKt {
    public static final long packFloats(float f, float f10) {
        return (Float.floatToRawIntBits(f10) & 4294967295L) | (Float.floatToRawIntBits(f) << 32);
    }

    public static final long packInts(int i, int i6) {
        return (i6 & 4294967295L) | (i << 32);
    }
}
