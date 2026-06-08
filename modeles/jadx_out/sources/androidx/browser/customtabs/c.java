package androidx.browser.customtabs;

import android.os.Bundle;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f319a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EngagementSignalsCallback f320b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f321l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Bundle f322m;

    public /* synthetic */ c(EngagementSignalsCallback engagementSignalsCallback, int i, Bundle bundle, int i6) {
        this.f319a = i6;
        this.f320b = engagementSignalsCallback;
        this.f321l = i;
        this.f322m = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f319a) {
            case 0:
                this.f320b.onGreatestScrollPercentageIncreased(this.f321l, this.f322m);
                break;
            default:
                this.f320b.onGreatestScrollPercentageIncreased(this.f321l, this.f322m);
                break;
        }
    }
}
