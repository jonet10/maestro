package d8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t {

    /* renamed from: e, reason: collision with root package name */
    public static final long[] f3705e = new long[0];

    /* renamed from: a, reason: collision with root package name */
    public final b8.e f3706a;

    /* renamed from: b, reason: collision with root package name */
    public final f8.i f3707b;

    /* renamed from: c, reason: collision with root package name */
    public long f3708c;

    /* renamed from: d, reason: collision with root package name */
    public final long[] f3709d;

    public t(b8.e eVar, f8.i iVar) {
        eVar.getClass();
        this.f3706a = eVar;
        this.f3707b = iVar;
        int e10 = eVar.e();
        if (e10 <= 64) {
            this.f3708c = e10 != 64 ? (-1) << e10 : 0L;
            this.f3709d = f3705e;
            return;
        }
        this.f3708c = 0L;
        int i = (e10 - 1) >>> 6;
        long[] jArr = new long[i];
        if ((e10 & 63) != 0) {
            jArr[i - 1] = (-1) << e10;
        }
        this.f3709d = jArr;
    }
}
