package a4;

import android.graphics.Bitmap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r extends b {
    public final Object h;
    public i i;

    public r(g0 g0Var, k0 k0Var, String str, i iVar) {
        super(g0Var, null, k0Var, str);
        this.h = new Object();
        this.i = iVar;
    }

    @Override // a4.b
    public final void a() {
        this.g = true;
        this.i = null;
    }

    @Override // a4.b
    public final void b(Bitmap bitmap, int i) {
        i iVar = this.i;
        if (iVar != null) {
            iVar.onSuccess();
        }
    }

    @Override // a4.b
    public final void c(Exception exc) {
        i iVar = this.i;
        if (iVar != null) {
            iVar.h(exc);
        }
    }

    @Override // a4.b
    public final Object d() {
        return this.h;
    }
}
