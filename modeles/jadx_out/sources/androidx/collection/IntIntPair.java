package androidx.collection;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class IntIntPair {
    public final long packedValue;

    private /* synthetic */ IntIntPair(long j) {
        this.packedValue = j;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ IntIntPair m18boximpl(long j) {
        return new IntIntPair(j);
    }

    /* renamed from: component1-impl, reason: not valid java name */
    public static final int m19component1impl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: component2-impl, reason: not valid java name */
    public static final int m20component2impl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m21constructorimpl(int i, int i6) {
        return m22constructorimpl((i6 & 4294967295L) | (i << 32));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m23equalsimpl(long j, Object obj) {
        return (obj instanceof IntIntPair) && j == ((IntIntPair) obj).m29unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m24equalsimpl0(long j, long j6) {
        return j == j6;
    }

    /* renamed from: getFirst-impl, reason: not valid java name */
    public static final int m25getFirstimpl(long j) {
        return (int) (j >> 32);
    }

    /* renamed from: getSecond-impl, reason: not valid java name */
    public static final int m26getSecondimpl(long j) {
        return (int) (j & 4294967295L);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m27hashCodeimpl(long j) {
        return (int) (j ^ (j >>> 32));
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m28toStringimpl(long j) {
        return "(" + m25getFirstimpl(j) + ", " + m26getSecondimpl(j) + ')';
    }

    public boolean equals(Object obj) {
        return m23equalsimpl(this.packedValue, obj);
    }

    public int hashCode() {
        return m27hashCodeimpl(this.packedValue);
    }

    public String toString() {
        return m28toStringimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m29unboximpl() {
        return this.packedValue;
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m22constructorimpl(long j) {
        return j;
    }

    public static /* synthetic */ void getPackedValue$annotations() {
    }
}
