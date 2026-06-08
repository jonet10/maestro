package n4;

import android.content.pm.IPackageInstallObserver;
import android.os.Bundle;
import g4.h0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n extends IPackageInstallObserver.Stub {
    public final /* synthetic */ m8.q i;

    public n(m8.q qVar) {
        this.i = qVar;
    }

    @Override // android.content.pm.IPackageInstallObserver
    public final void packageInstalled(String str, int i) {
        str.getClass();
        if (i == 1) {
            h0 h0Var = (h0) this.i.f7781l;
            if (h0Var != null) {
                h0Var.f5190a.finish();
            }
            if (f4.c.f4881u != null) {
                Bundle e10 = k0.k.e("packageName", str);
                z4.d dVar = f4.c.f4881u;
                if (dVar != null) {
                    dVar.send(352, e10);
                }
            }
        }
        f4.a.f4869a.a();
    }
}
