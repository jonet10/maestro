package androidx.lifecycle;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f436a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f437b;

    public /* synthetic */ a(Object obj, int i) {
        this.f436a = i;
        this.f437b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f436a) {
            case 0:
                ComputableLiveData.refreshRunnable$lambda$0((ComputableLiveData) this.f437b);
                break;
            case 1:
                ComputableLiveData.invalidationRunnable$lambda$0((ComputableLiveData) this.f437b);
                break;
            default:
                ProcessLifecycleOwner.delayedPauseRunnable$lambda$0((ProcessLifecycleOwner) this.f437b);
                break;
        }
    }
}
