package m8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d0 extends e0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7705a;

    /* renamed from: b, reason: collision with root package name */
    public final long f7706b;

    /* renamed from: l, reason: collision with root package name */
    public final w8.j f7707l;

    public /* synthetic */ d0(long j, w8.j jVar, int i) {
        this.f7705a = i;
        this.f7706b = j;
        this.f7707l = jVar;
    }

    @Override // m8.e0
    public final long b() {
        switch (this.f7705a) {
        }
        return this.f7706b;
    }

    @Override // m8.e0
    public final w8.j c() {
        switch (this.f7705a) {
            case 0:
                return (w8.h) this.f7707l;
            default:
                return (w8.a0) this.f7707l;
        }
    }
}
