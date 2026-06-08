package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import androidx.work.impl.constraints.IndividualNetworkCallback;
import d7.l;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.u;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(28)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class IndividualNetworkCallback extends ConnectivityManager.NetworkCallback {
    public static final Companion Companion = new Companion(null);
    private final l onConstraintState;

    private IndividualNetworkCallback(l lVar) {
        this.onConstraintState = lVar;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        String str;
        network.getClass();
        networkCapabilities.getClass();
        Logger logger = Logger.get();
        str = WorkConstraintsTrackerKt.TAG;
        logger.debug(str, "NetworkRequestConstraintController onCapabilitiesChanged callback");
        this.onConstraintState.invoke(ConstraintsState.ConstraintsMet.INSTANCE);
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        String str;
        network.getClass();
        Logger logger = Logger.get();
        str = WorkConstraintsTrackerKt.TAG;
        logger.debug(str, "NetworkRequestConstraintController onLost callback");
        this.onConstraintState.invoke(new ConstraintsState.ConstraintsNotMet(7));
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Companion {
        public /* synthetic */ Companion(g gVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final x addCallback$lambda$0(u uVar, ConnectivityManager connectivityManager, IndividualNetworkCallback individualNetworkCallback) {
            String str;
            if (uVar.f7021a) {
                Logger logger = Logger.get();
                str = WorkConstraintsTrackerKt.TAG;
                logger.debug(str, "NetworkRequestConstraintController unregister callback");
                connectivityManager.unregisterNetworkCallback(individualNetworkCallback);
            }
            return x.f8463a;
        }

        public final d7.a addCallback(final ConnectivityManager connectivityManager, NetworkRequest networkRequest, l lVar) {
            String str;
            String str2;
            connectivityManager.getClass();
            networkRequest.getClass();
            lVar.getClass();
            final IndividualNetworkCallback individualNetworkCallback = new IndividualNetworkCallback(lVar, null);
            final u uVar = new u();
            try {
                Logger logger = Logger.get();
                str2 = WorkConstraintsTrackerKt.TAG;
                logger.debug(str2, "NetworkRequestConstraintController register callback");
                connectivityManager.registerNetworkCallback(networkRequest, individualNetworkCallback);
                uVar.f7021a = true;
            } catch (RuntimeException e10) {
                if (!l7.u.k0(e10.getClass().getName(), "TooManyRequestsException", false)) {
                    throw e10;
                }
                Logger logger2 = Logger.get();
                str = WorkConstraintsTrackerKt.TAG;
                logger2.debug(str, "NetworkRequestConstraintController couldn't register callback", e10);
                lVar.invoke(new ConstraintsState.ConstraintsNotMet(7));
            }
            return new d7.a() { // from class: androidx.work.impl.constraints.a
                @Override // d7.a
                public final Object invoke() {
                    x addCallback$lambda$0;
                    addCallback$lambda$0 = IndividualNetworkCallback.Companion.addCallback$lambda$0(u.this, connectivityManager, individualNetworkCallback);
                    return addCallback$lambda$0;
                }
            };
        }

        private Companion() {
        }
    }

    public /* synthetic */ IndividualNetworkCallback(l lVar, g gVar) {
        this(lVar);
    }
}
