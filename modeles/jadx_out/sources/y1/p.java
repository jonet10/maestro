package y1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11655a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ q f11656b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f11657l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f11658m;

    public /* synthetic */ p(q qVar, long j, String str, int i) {
        this.f11655a = i;
        this.f11656b = qVar;
        this.f11657l = j;
        this.f11658m = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f11655a) {
            case 0:
                q qVar = this.f11656b;
                qVar.f11668o.f11909b.a(new p(qVar, this.f11657l, this.f11658m, 1));
                break;
            default:
                l lVar = this.f11656b.g;
                s sVar = lVar.f11644n;
                if (sVar == null || !sVar.f11678e.get()) {
                    ((a2.d) lVar.i.f19b).e(this.f11657l, this.f11658m);
                    break;
                }
                break;
        }
    }
}
