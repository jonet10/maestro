package androidx.collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class FloatFloatPair {
    public final long packedValue;

    private /* synthetic */ FloatFloatPair(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FloatFloatPair m6boximpl(long j) {
        return new FloatFloatPair(j);
    }

    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m7component1impl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m8component2impl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m9constructorimpl(float f, float f10) {
        return m10constructorimpl((Float.floatToRawIntBits(f10) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m11equalsimpl(long j, Object obj) {
        return (obj instanceof FloatFloatPair) && j == ((FloatFloatPair) obj).m17unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m12equalsimpl0(long j, long j6) {
        return j == j6;
    }

    /* renamed from: getFirst-impl, reason: not valid java name */
    public static final float m13getFirstimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getSecond-impl, reason: not valid java name */
    public static final float m14getSecondimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m15hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m16toStringimpl(long j) {
        return "(" + Float.intBitsToFloat((int) (j >> 32)) + ", " + Float.intBitsToFloat((int) (j & 4294967295L)) + ')';
    }

    public boolean equals(Object obj) {
        return m11equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m15hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m16toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m17unboximpl() {
        return this.packedValue;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m10constructorimpl(long j) {
        return j;
    }
}
