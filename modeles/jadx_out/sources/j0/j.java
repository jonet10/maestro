package j0;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import e1.c0;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6503a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BasePendingResult f6504b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f6505c;

    public j(android.support.v4.media.g gVar, BasePendingResult basePendingResult) {
        this.f6505c = gVar;
        this.f6504b = basePendingResult;
    }

    public final void a(Status status) {
        i0.i iVar;
        switch (this.f6503a) {
            case 0:
                ((Map) ((android.support.v4.media.g) this.f6505c).f247b).remove(this.f6504b);
                return;
            default:
                if (status.f2474a > 0) {
                    ((j1.i) this.f6505c).f6539a.m(status.f2476l != null ? new i0.h(status) : new g0.m(status));
                    return;
                }
                BasePendingResult basePendingResult = this.f6504b;
                TimeUnit timeUnit = TimeUnit.MILLISECONDS;
                y.i(!basePendingResult.g, "Result has already been consumed.");
                try {
                    if (!basePendingResult.f2479b.await(0L, timeUnit)) {
                        basePendingResult.c(Status.f2472q);
                    }
                } catch (InterruptedException unused) {
                    basePendingResult.c(Status.f2470o);
                }
                y.i(basePendingResult.d(), "Result is not ready.");
                synchronized (basePendingResult.f2478a) {
                    y.i(!basePendingResult.g, "Result has already been consumed.");
                    y.i(basePendingResult.d(), "Result is not ready.");
                    iVar = basePendingResult.f2482e;
                    basePendingResult.f2482e = null;
                    basePendingResult.g = true;
                }
                if (basePendingResult.f2481d.getAndSet(null) != null) {
                    com.google.gson.internal.a.o();
                    return;
                } else {
                    y.g(iVar);
                    ((j1.i) this.f6505c).a(null);
                    return;
                }
        }
    }

    public j(BasePendingResult basePendingResult, j1.i iVar, c0 c0Var) {
        this.f6504b = basePendingResult;
        this.f6505c = iVar;
    }
}
