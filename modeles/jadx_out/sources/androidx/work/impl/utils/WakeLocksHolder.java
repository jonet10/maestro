package androidx.work.impl.utils;

import android.os.PowerManager;
import java.util.WeakHashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class WakeLocksHolder {
    public static final WakeLocksHolder INSTANCE = new WakeLocksHolder();
    private static final WeakHashMap<PowerManager.WakeLock, String> wakeLocks = new WeakHashMap<>();

    private WakeLocksHolder() {
    }

    public final WeakHashMap<PowerManager.WakeLock, String> getWakeLocks() {
        return wakeLocks;
    }
}
