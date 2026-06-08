package androidx.work.impl.constraints;

import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import androidx.annotation.GuardedBy;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.work.Logger;
import androidx.work.impl.constraints.ConstraintsState;
import d7.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import p6.i;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_BIAS)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class SharedNetworkCallback extends ConnectivityManager.NetworkCallback {

    @GuardedBy("requestsLock")
    private static NetworkCapabilities cachedCapabilities;

    @GuardedBy("requestsLock")
    private static boolean capabilitiesInitialized;

    @GuardedBy("requestsLock")
    private static boolean isBlocked;
    public static final SharedNetworkCallback INSTANCE = new SharedNetworkCallback();
    private static final Object requestsLock = new Object();

    @GuardedBy("requestsLock")
    private static final Map<l, NetworkRequest> requests = new LinkedHashMap();

    private SharedNetworkCallback() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final x addCallback$lambda$9(l lVar, ConnectivityManager connectivityManager) {
        String str;
        synchronized (requestsLock) {
            Map<l, NetworkRequest> map = requests;
            map.remove(lVar);
            if (map.isEmpty()) {
                Logger logger = Logger.get();
                str = WorkConstraintsTrackerKt.TAG;
                logger.debug(str, "NetworkRequestConstraintController unregister shared callback");
                connectivityManager.unregisterNetworkCallback(INSTANCE);
                isBlocked = false;
                cachedCapabilities = null;
                capabilitiesInitialized = false;
            }
        }
        return x.f8463a;
    }

    private final boolean areNetworkConstraintsSatisfied(NetworkRequest networkRequest, NetworkCapabilities networkCapabilities) {
        return !isBlocked && networkRequest.canBeSatisfiedBy(networkCapabilities);
    }

    @GuardedBy("requestsLock")
    private final void dispatchOnConstraintState() {
        ArrayList arrayList = new ArrayList();
        synchronized (requestsLock) {
            try {
                Iterator<T> it = requests.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    arrayList.add(new i((l) entry.getKey(), INSTANCE.areNetworkConstraintsSatisfied((NetworkRequest) entry.getValue(), cachedCapabilities) ? ConstraintsState.ConstraintsMet.INSTANCE : new ConstraintsState.ConstraintsNotMet(7)));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            i iVar = (i) obj;
            ((l) iVar.f8441a).invoke((ConstraintsState) iVar.f8442b);
        }
    }

    public final d7.a addCallback(final ConnectivityManager connectivityManager, NetworkRequest networkRequest, final l lVar) {
        String str;
        String str2;
        connectivityManager.getClass();
        networkRequest.getClass();
        lVar.getClass();
        synchronized (requestsLock) {
            try {
                Map<l, NetworkRequest> map = requests;
                boolean isEmpty = map.isEmpty();
                map.put(lVar, networkRequest);
                if (isEmpty) {
                    Logger logger = Logger.get();
                    str2 = WorkConstraintsTrackerKt.TAG;
                    logger.debug(str2, "NetworkRequestConstraintController register shared callback");
                    connectivityManager.registerDefaultNetworkCallback(INSTANCE);
                }
                Logger logger2 = Logger.get();
                str = WorkConstraintsTrackerKt.TAG;
                logger2.debug(str, "NetworkRequestConstraintController send initial capabilities");
                SharedNetworkCallback sharedNetworkCallback = INSTANCE;
                lVar.invoke(sharedNetworkCallback.areNetworkConstraintsSatisfied(networkRequest, sharedNetworkCallback.getCurrentNetworkCapabilities(connectivityManager)) ? ConstraintsState.ConstraintsMet.INSTANCE : new ConstraintsState.ConstraintsNotMet(7));
            } catch (Throwable th) {
                throw th;
            }
        }
        return new d7.a() { // from class: androidx.work.impl.constraints.d
            @Override // d7.a
            public final Object invoke() {
                x addCallback$lambda$9;
                addCallback$lambda$9 = SharedNetworkCallback.addCallback$lambda$9(l.this, connectivityManager);
                return addCallback$lambda$9;
            }
        };
    }

    public final NetworkCapabilities getCachedCapabilities() {
        return cachedCapabilities;
    }

    public final boolean getCapabilitiesInitialized() {
        return capabilitiesInitialized;
    }

    public final NetworkCapabilities getCurrentNetworkCapabilities(ConnectivityManager connectivityManager) {
        connectivityManager.getClass();
        if (capabilitiesInitialized) {
            return cachedCapabilities;
        }
        NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
        cachedCapabilities = networkCapabilities;
        capabilitiesInitialized = true;
        return networkCapabilities;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onBlockedStatusChanged(Network network, boolean z9) {
        String str;
        network.getClass();
        Logger logger = Logger.get();
        str = WorkConstraintsTrackerKt.TAG;
        logger.debug(str, "NetworkRequestConstraintController onBlockedStatusChanged callback");
        synchronized (requestsLock) {
            if (isBlocked == z9) {
                return;
            }
            isBlocked = z9;
            dispatchOnConstraintState();
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        String str;
        network.getClass();
        networkCapabilities.getClass();
        Logger logger = Logger.get();
        str = WorkConstraintsTrackerKt.TAG;
        logger.debug(str, "NetworkRequestConstraintController onCapabilitiesChanged callback");
        synchronized (requestsLock) {
            cachedCapabilities = networkCapabilities;
        }
        dispatchOnConstraintState();
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        String str;
        network.getClass();
        Logger logger = Logger.get();
        str = WorkConstraintsTrackerKt.TAG;
        logger.debug(str, "NetworkRequestConstraintController onLost callback");
        synchronized (requestsLock) {
            cachedCapabilities = null;
            Iterator<T> it = requests.keySet().iterator();
            while (it.hasNext()) {
                ((l) it.next()).invoke(new ConstraintsState.ConstraintsNotMet(7));
            }
        }
    }

    public final void setCachedCapabilities(NetworkCapabilities networkCapabilities) {
        cachedCapabilities = networkCapabilities;
    }

    public final void setCapabilitiesInitialized(boolean z9) {
        capabilitiesInitialized = z9;
    }
}
