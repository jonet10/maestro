package m0;

import android.support.v4.media.g;
import com.google.android.gms.internal.measurement.i4;
import e1.c0;
import g5.f;
import i0.d;
import j0.e;
import j0.s;
import j0.v;
import j1.i;
import j1.p;
import k0.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends d {

    /* renamed from: k, reason: collision with root package name */
    public static final g f7267k = new g("ClientTelemetry.API", new d0.b(4), new c0(16));

    public final p b(n nVar) {
        g5.g gVar = new g5.g(1, false);
        h0.d[] dVarArr = {x0.b.f11034a};
        gVar.f5315b = new f(nVar, 8);
        i4 i4Var = new i4();
        i4Var.f2664c = gVar;
        i4Var.f2663b = dVarArr;
        i4Var.f2662a = false;
        i iVar = new i();
        e eVar = this.j;
        eVar.getClass();
        s sVar = new s(new v(i4Var, iVar, this.i), eVar.f6498r.get(), this);
        a4.c0 c0Var = eVar.v;
        c0Var.sendMessage(c0Var.obtainMessage(4, sVar));
        return iVar.f6539a;
    }
}
