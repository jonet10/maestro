package androidx.core.widget;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f403a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ContentLoadingProgressBar f404b;

    public /* synthetic */ a(ContentLoadingProgressBar contentLoadingProgressBar, int i) {
        this.f403a = i;
        this.f404b = contentLoadingProgressBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f403a) {
            case 0:
                this.f404b.lambda$new$0();
                break;
            case 1:
                this.f404b.lambda$new$1();
                break;
            case 2:
                this.f404b.showOnUiThread();
                break;
            default:
                this.f404b.hideOnUiThread();
                break;
        }
    }
}
