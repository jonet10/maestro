package j5;

import android.app.AppOpsManager;
import android.app.usage.UsageStats;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Process;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.measurement.z3;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class u {
    public static long a(Context context) {
        context.getClass();
        boolean z9 = false;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("stats_enabled")) {
                z9 = sharedPreferences.getBoolean("stats_enabled", false);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            Object systemService = context.getSystemService("usagestats");
            systemService.getClass();
            UsageStatsManager usageStatsManager = (UsageStatsManager) systemService;
            long currentTimeMillis = System.currentTimeMillis();
            long t9 = z3.t(currentTimeMillis - 86400000, context, "lastTimeUsageGetted");
            if (currentTimeMillis - t9 >= 82800000) {
                z3.Q(currentTimeMillis, context, "lastTimeUsageGetted");
                List<UsageStats> queryUsageStats = usageStatsManager.queryUsageStats(0, t9, currentTimeMillis);
                queryUsageStats.getClass();
                long j = 0;
                for (UsageStats usageStats : queryUsageStats) {
                    if (usageStats.getPackageName().equals(context.getPackageName())) {
                        j += Build.VERSION.SDK_INT >= 29 ? usageStats.getTotalTimeVisible() : usageStats.getTotalTimeInForeground();
                    }
                }
                return j >= 0 ? j / 1000 : j;
            }
        }
        return 0L;
    }

    public static boolean b(Context context) {
        Integer valueOf;
        context.getClass();
        AppOpsManager appOpsManager = (AppOpsManager) ContextCompat.getSystemService(context, AppOpsManager.class);
        if (Build.VERSION.SDK_INT >= 29) {
            valueOf = appOpsManager != null ? Integer.valueOf(appOpsManager.unsafeCheckOpNoThrow("android:get_usage_stats", Process.myUid(), context.getPackageName())) : null;
            return valueOf != null && valueOf.intValue() == 0;
        }
        valueOf = appOpsManager != null ? Integer.valueOf(appOpsManager.checkOpNoThrow("android:get_usage_stats", Process.myUid(), context.getPackageName())) : null;
        return valueOf != null && valueOf.intValue() == 0;
    }
}
