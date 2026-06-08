package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f462a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f463b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f464l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f465m;

    public /* synthetic */ a(int i, Object obj, int i6, Object obj2) {
        this.f462a = i6;
        this.f463b = obj;
        this.f464l = i;
        this.f465m = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f462a) {
            case 0:
                ((ProfileInstaller.DiagnosticsCallback) this.f463b).onResultReceived(this.f464l, this.f465m);
                break;
            case 1:
                ((ProfileInstaller.DiagnosticsCallback) this.f463b).onDiagnosticReceived(this.f464l, this.f465m);
                break;
            default:
                ((DeviceProfileWriter) this.f463b).lambda$result$0(this.f464l, this.f465m);
                break;
        }
    }
}
