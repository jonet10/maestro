package j0;

import android.os.DeadObjectException;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u extends x {

    /* renamed from: b, reason: collision with root package name */
    public final f0.g f6533b;

    public u(f0.g gVar) {
        super(1);
        this.f6533b = gVar;
    }

    @Override // j0.x
    public final void a(Status status) {
        try {
            this.f6533b.g(status);
        } catch (IllegalStateException e10) {
            Log.w("ApiCallRunner", "Exception reporting failure", e10);
        }
    }

    @Override // j0.x
    public final void b(Exception exc) {
        try {
            this.f6533b.g(new Status(10, a4.x.k(exc.getClass().getSimpleName(), ": ", exc.getLocalizedMessage()), null, null));
        } catch (IllegalStateException e10) {
            Log.w("ApiCallRunner", "Exception reporting failure", e10);
        }
    }

    @Override // j0.x
    public final void c(m mVar) {
        try {
            f0.g gVar = this.f6533b;
            i0.b bVar = mVar.j;
            gVar.getClass();
            try {
                gVar.f(bVar);
            } catch (DeadObjectException e10) {
                gVar.g(new Status(8, e10.getLocalizedMessage(), null, null));
                throw e10;
            } catch (RemoteException e11) {
                gVar.g(new Status(8, e11.getLocalizedMessage(), null, null));
            }
        } catch (RuntimeException e12) {
            b(e12);
        }
    }

    @Override // j0.x
    public final void d(android.support.v4.media.g gVar, boolean z9) {
        Boolean valueOf = Boolean.valueOf(z9);
        Map map = (Map) gVar.f247b;
        f0.g gVar2 = this.f6533b;
        map.put(gVar2, valueOf);
        gVar2.a(new j(gVar, gVar2));
    }
}
