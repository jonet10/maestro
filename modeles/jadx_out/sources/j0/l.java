package j0;

import a4.c0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l implements b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e f6506a;

    public l(e eVar) {
        this.f6506a = eVar;
    }

    @Override // j0.b
    public final void a(boolean z9) {
        c0 c0Var = this.f6506a.v;
        c0Var.sendMessage(c0Var.obtainMessage(1, Boolean.valueOf(z9)));
    }
}
