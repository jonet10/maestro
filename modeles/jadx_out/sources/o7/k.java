package o7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class k implements d7.q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8270a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f8271b;

    public /* synthetic */ k(Object obj, int i) {
        this.f8270a = i;
        this.f8271b = obj;
    }

    @Override // d7.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f8270a) {
            case 0:
                ((d7.l) this.f8271b).invoke((Throwable) obj);
                return p6.x.f8463a;
            case 1:
                return new x7.b((x7.g) this.f8271b, obj2, 0);
            default:
                ((x7.l) this.f8271b).b();
                return p6.x.f8463a;
        }
    }
}
