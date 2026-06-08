package androidx.work.impl.constraints.trackers;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.work.Logger;
import androidx.work.impl.constraints.NetworkState;
import androidx.work.impl.utils.taskexecutor.TaskExecutor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class NetworkStateTrackerKt {
    private static final String TAG;

    static {
        String tagWithPrefix = Logger.tagWithPrefix("NetworkStateTracker");
        tagWithPrefix.getClass();
        TAG = tagWithPrefix;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final ConstraintTracker<NetworkState> NetworkStateTracker(Context context, TaskExecutor taskExecutor) {
        context.getClass();
        taskExecutor.getClass();
        return Build.VERSION.SDK_INT >= 24 ? new NetworkStateTracker24(context, taskExecutor) : new NetworkStateTrackerPre24(context, taskExecutor);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0029, code lost:
    
        if (r0.isRoaming() == false) goto L18;
     */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0025 A[Catch: SecurityException -> 0x0015, TRY_ENTER, TRY_LEAVE, TryCatch #1 {SecurityException -> 0x0015, blocks: (B:28:0x000b, B:9:0x0025), top: B:27:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.work.impl.constraints.NetworkState getActiveNetworkState(android.net.ConnectivityManager r7, boolean r8) {
        /*
            r7.getClass()
            android.net.NetworkInfo r0 = r7.getActiveNetworkInfo()     // Catch: java.lang.SecurityException -> L38
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L19
            boolean r3 = r0.isConnected()     // Catch: java.lang.SecurityException -> L15
            if (r3 == 0) goto L19
            r3 = r1
            r1 = r2
            r4 = r1
            goto L1b
        L15:
            r0 = move-exception
            r7 = r0
            r5 = r8
            goto L3b
        L19:
            r3 = r1
            r4 = r2
        L1b:
            boolean r2 = isActiveNetworkValidated(r7)     // Catch: java.lang.SecurityException -> L38
            boolean r7 = androidx.core.net.ConnectivityManagerCompat.isActiveNetworkMetered(r7)     // Catch: java.lang.SecurityException -> L38
            if (r0 == 0) goto L2c
            boolean r0 = r0.isRoaming()     // Catch: java.lang.SecurityException -> L15
            if (r0 != 0) goto L2c
            goto L2d
        L2c:
            r4 = r3
        L2d:
            androidx.work.impl.constraints.NetworkState r0 = new androidx.work.impl.constraints.NetworkState     // Catch: java.lang.SecurityException -> L38
            r3 = r7
            r5 = r8
            r0.<init>(r1, r2, r3, r4, r5)     // Catch: java.lang.SecurityException -> L35
            return r0
        L35:
            r0 = move-exception
        L36:
            r7 = r0
            goto L3b
        L38:
            r0 = move-exception
            r5 = r8
            goto L36
        L3b:
            androidx.work.Logger r8 = androidx.work.Logger.get()
            java.lang.String r0 = androidx.work.impl.constraints.trackers.NetworkStateTrackerKt.TAG
            java.lang.String r1 = "Unable to get active network state"
            r8.error(r0, r1, r7)
            androidx.work.impl.constraints.NetworkState r1 = new androidx.work.impl.constraints.NetworkState
            r4 = 0
            r6 = r5
            r5 = 1
            r2 = 0
            r3 = 0
            r1.<init>(r2, r3, r4, r5, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.constraints.trackers.NetworkStateTrackerKt.getActiveNetworkState(android.net.ConnectivityManager, boolean):androidx.work.impl.constraints.NetworkState");
    }

    public static final boolean isActiveNetworkValidated(ConnectivityManager connectivityManager) {
        connectivityManager.getClass();
        try {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            if (networkCapabilities != null) {
                return networkCapabilities.hasCapability(16);
            }
            return false;
        } catch (SecurityException e10) {
            Logger.get().error(TAG, "Unable to validate active network", e10);
            return false;
        }
    }

    @RequiresApi(28)
    public static final NetworkState getActiveNetworkState(NetworkCapabilities networkCapabilities, boolean z9) {
        networkCapabilities.getClass();
        return new NetworkState(networkCapabilities.hasCapability(12), networkCapabilities.hasCapability(16), !networkCapabilities.hasCapability(11), networkCapabilities.hasCapability(18), z9);
    }
}
