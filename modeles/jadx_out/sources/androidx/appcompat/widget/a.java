package androidx.appcompat.widget;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f307a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Toolbar f308b;

    public /* synthetic */ a(Toolbar toolbar, int i) {
        this.f307a = i;
        this.f308b = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f307a) {
            case 0:
                this.f308b.collapseActionView();
                break;
            default:
                this.f308b.invalidateMenu();
                break;
        }
    }
}
