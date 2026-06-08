package androidx.activity;

import androidx.activity.ComponentActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f291a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f292b;

    public /* synthetic */ d(Object obj, int i) {
        this.f291a = i;
        this.f292b = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f291a) {
            case 0:
                ((ComponentActivity.ReportFullyDrawnExecutorApi16Impl) this.f292b).lambda$execute$0();
                break;
            case 1:
                ((ComponentActivity) this.f292b).invalidateMenu();
                break;
            case 2:
                ComponentDialog.onBackPressedDispatcher$lambda$1((ComponentDialog) this.f292b);
                break;
            default:
                FullyDrawnReporter.reportRunnable$lambda$2((FullyDrawnReporter) this.f292b);
                break;
        }
    }
}
