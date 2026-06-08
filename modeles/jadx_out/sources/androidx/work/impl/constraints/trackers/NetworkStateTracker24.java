package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.NetworkApi24;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(24)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class NetworkStateTracker24 extends ConstraintTracker<NetworkState> {
    private final ConnectivityManager connectivityManager;
    private volatile boolean isBlocked;
    private final Object lock;
    private final NetworkStateTracker24$networkCallback$1 networkCallback;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Type inference failed for: r1v5, types: [androidx.work.impl.constraints.trackers.NetworkStateTracker24$networkCallback$1] */
    public NetworkStateTracker24(Context context, TaskExecutor taskExecutor) {
        super(context, taskExecutor);
        context.getClass();
        taskExecutor.getClass();
        Object systemService = getAppContext().getSystemService("connectivity");
        systemService.getClass();
        this.connectivityManager = (ConnectivityManager) systemService;
        this.lock = new Object();
        this.networkCallback = new ConnectivityManager.NetworkCallback() { // from class: androidx.work.impl.constraints.trackers.NetworkStateTracker24$networkCallback$1
            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onBlockedStatusChanged(Network network, boolean z9) {
                ConnectivityManager connectivityManager;
                String str;
                Object obj;
                boolean z10;
                network.getClass();
                connectivityManager = NetworkStateTracker24.this.connectivityManager;
                if (network.equals(connectivityManager.getActiveNetwork())) {
                    Logger logger = Logger.get();
                    str = NetworkStateTrackerKt.TAG;
                    logger.debug(str, "Network blocked status changed: " + z9);
                    NetworkState state = NetworkStateTracker24.this.getState();
                    obj = NetworkStateTracker24.this.lock;
                    NetworkStateTracker24 networkStateTracker24 = NetworkStateTracker24.this;
                    synchronized (obj) {
                        z10 = networkStateTracker24.isBlocked;
                        if (z10 == z9) {
                            return;
                        }
                        networkStateTracker24.isBlocked = z9;
                        NetworkStateTracker24.this.setState(NetworkState.copy$default(state, false, false, false, false, z9, 15, null));
                    }
                }
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
                String str;
                ConnectivityManager connectivityManager;
                boolean z9;
                NetworkState activeNetworkState;
                boolean z10;
                network.getClass();
                networkCapabilities.getClass();
                Logger logger = Logger.get();
                str = NetworkStateTrackerKt.TAG;
                logger.debug(str, "Network capabilities changed: " + networkCapabilities);
                NetworkStateTracker24 networkStateTracker24 = NetworkStateTracker24.this;
                if (Build.VERSION.SDK_INT >= 28) {
                    z10 = networkStateTracker24.isBlocked;
                    activeNetworkState = NetworkStateTrackerKt.getActiveNetworkState(networkCapabilities, z10);
                } else {
                    connectivityManager = networkStateTracker24.connectivityManager;
                    z9 = NetworkStateTracker24.this.isBlocked;
                    activeNetworkState = NetworkStateTrackerKt.getActiveNetworkState(connectivityManager, z9);
                }
                networkStateTracker24.setState(activeNetworkState);
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public void onLost(Network network) {
                String str;
                network.getClass();
                Logger logger = Logger.get();
                str = NetworkStateTrackerKt.TAG;
                logger.debug(str, "Network connection lost");
                NetworkStateTracker24.this.setState(new NetworkState(false, false, false, false, false));
            }
        };
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public NetworkState readSystemState() {
        if (Build.VERSION.SDK_INT >= 28) {
            ConnectivityManager connectivityManager = this.connectivityManager;
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null) {
                return NetworkStateTrackerKt.getActiveNetworkState(networkCapabilities, this.isBlocked);
            }
        }
        return NetworkStateTrackerKt.getActiveNetworkState(this.connectivityManager, this.isBlocked);
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void startTracking() {
        String str;
        String str2;
        String str3;
        try {
            Logger logger = Logger.get();
            str3 = NetworkStateTrackerKt.TAG;
            logger.debug(str3, "Registering network callback");
            NetworkApi24.registerDefaultNetworkCallbackCompat(this.connectivityManager, this.networkCallback);
        } catch (IllegalArgumentException e10) {
            Logger logger2 = Logger.get();
            str2 = NetworkStateTrackerKt.TAG;
            logger2.error(str2, "Received exception while registering network callback", e10);
        } catch (SecurityException e11) {
            Logger logger3 = Logger.get();
            str = NetworkStateTrackerKt.TAG;
            logger3.error(str, "Received exception while registering network callback", e11);
        }
    }

    @Override // androidx.work.impl.constraints.trackers.ConstraintTracker
    public void stopTracking() {
        String str;
        String str2;
        String str3;
        try {
            Logger logger = Logger.get();
            str3 = NetworkStateTrackerKt.TAG;
            logger.debug(str3, "Unregistering network callback");
            this.connectivityManager.unregisterNetworkCallback(this.networkCallback);
        } catch (IllegalArgumentException e10) {
            Logger logger2 = Logger.get();
            str2 = NetworkStateTrackerKt.TAG;
            logger2.error(str2, "Received exception while unregistering network callback", e10);
        } catch (SecurityException e11) {
            Logger logger3 = Logger.get();
            str = NetworkStateTrackerKt.TAG;
            logger3.error(str, "Received exception while unregistering network callback", e11);
        }
    }
}
