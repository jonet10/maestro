package androidx.browser.customtabs;

import android.os.Bundle;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f315a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f316b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ boolean f317l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Bundle f318m;

    public /* synthetic */ b(EngagementSignalsCallback engagementSignalsCallback, boolean z9, Bundle bundle, int i) {
        this.f315a = i;
        this.f316b = engagementSignalsCallback;
        this.f317l = z9;
        this.f318m = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f315a) {
            case 0:
                this.f316b.onSessionEnded(this.f317l, this.f318m);
                break;
            case 1:
                this.f316b.onVerticalScrollEvent(this.f317l, this.f318m);
                break;
            case 2:
                this.f316b.onVerticalScrollEvent(this.f317l, this.f318m);
                break;
            default:
                this.f316b.onSessionEnded(this.f317l, this.f318m);
                break;
        }
    }
}
