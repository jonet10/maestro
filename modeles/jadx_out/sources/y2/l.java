package y2;

import com.google.firebase.messaging.FirebaseMessaging;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class l implements j1.f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11742a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FirebaseMessaging f11743b;

    public /* synthetic */ l(FirebaseMessaging firebaseMessaging, int i) {
        this.f11742a = i;
        this.f11743b = firebaseMessaging;
    }

    @Override // j1.f
    public final void c(Object obj) {
        boolean z9;
        switch (this.f11742a) {
            case 0:
                x xVar = (x) obj;
                if (!this.f11743b.f3089e.i() || xVar.h.a() == null) {
                    return;
                }
                synchronized (xVar) {
                    z9 = xVar.g;
                }
                if (z9) {
                    return;
                }
                xVar.h(0L);
                return;
            default:
                FirebaseMessaging firebaseMessaging = this.f11743b;
                g0.a aVar = (g0.a) obj;
                if (aVar != null) {
                    a0.f(aVar.f5067a);
                    firebaseMessaging.e();
                    return;
                }
                return;
        }
    }
}
