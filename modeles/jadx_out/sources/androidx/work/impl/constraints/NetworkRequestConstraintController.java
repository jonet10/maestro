package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import androidx.annotation.RequiresApi;
import androidx.work.Constraints;
import androidx.work.impl.constraints.controllers.ConstraintController;
import androidx.work.impl.model.WorkSpec;
import kotlin.jvm.internal.g;
import r7.h;
import r7.k0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(28)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class NetworkRequestConstraintController implements ConstraintController {
    private final ConnectivityManager connManager;
    private final long timeoutMs;

    public NetworkRequestConstraintController(ConnectivityManager connectivityManager, long j) {
        connectivityManager.getClass();
        this.connManager = connectivityManager;
        this.timeoutMs = j;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean hasConstraint(WorkSpec workSpec) {
        workSpec.getClass();
        return workSpec.constraints.getRequiredNetworkRequest() != null;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public boolean isCurrentlyConstrained(WorkSpec workSpec) {
        workSpec.getClass();
        if (!hasConstraint(workSpec)) {
            return false;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("isCurrentlyConstrained() must never be called onNetworkRequestConstraintController. isCurrentlyConstrained() is called only on older platforms where NetworkRequest isn't supported");
        return false;
    }

    @Override // androidx.work.impl.constraints.controllers.ConstraintController
    public h track(Constraints constraints) {
        constraints.getClass();
        return k0.e(new NetworkRequestConstraintController$track$1(constraints, this, null));
    }

    public /* synthetic */ NetworkRequestConstraintController(ConnectivityManager connectivityManager, long j, int i, g gVar) {
        this(connectivityManager, (i & 2) != 0 ? 1000L : j);
    }
}
