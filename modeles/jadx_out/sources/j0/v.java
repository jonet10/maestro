package j0;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.measurement.i4;
import e1.c0;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v extends q {

    /* renamed from: b, reason: collision with root package name */
    public final i4 f6534b;

    /* renamed from: c, reason: collision with root package name */
    public final j1.i f6535c;

    /* renamed from: d, reason: collision with root package name */
    public final c0 f6536d;

    public v(i4 i4Var, j1.i iVar, c0 c0Var) {
        super(2);
        this.f6535c = iVar;
        this.f6534b = i4Var;
        this.f6536d = c0Var;
        if (i4Var.f2662a) {
            com.google.gson.internal.a.p("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
            throw null;
        }
    }

    @Override // j0.x
    public final void a(Status status) {
        this.f6536d.getClass();
        this.f6535c.b(status.f2476l != null ? new i0.h(status) : new g0.m(status));
    }

    @Override // j0.x
    public final void b(Exception exc) {
        this.f6535c.b(exc);
    }

    @Override // j0.x
    public final void c(m mVar) {
        j1.i iVar = this.f6535c;
        try {
            this.f6534b.b(mVar.j, iVar);
        } catch (DeadObjectException e10) {
            throw e10;
        } catch (RemoteException e11) {
            a(x.e(e11));
        } catch (RuntimeException e12) {
            iVar.b(e12);
        }
    }

    @Override // j0.x
    public final void d(android.support.v4.media.g gVar, boolean z9) {
        Boolean valueOf = Boolean.valueOf(z9);
        Map map = (Map) gVar.f248l;
        j1.i iVar = this.f6535c;
        map.put(iVar, valueOf);
        j1.p pVar = iVar.f6539a;
        android.support.v4.media.g gVar2 = new android.support.v4.media.g(gVar, iVar, 17, false);
        pVar.getClass();
        pVar.f6561b.e(new j1.m(j1.j.f6540a, gVar2));
        pVar.p();
    }

    @Override // j0.q
    public final boolean f(m mVar) {
        return this.f6534b.f2662a;
    }

    @Override // j0.q
    public final h0.d[] g(m mVar) {
        return (h0.d[]) this.f6534b.f2663b;
    }
}
