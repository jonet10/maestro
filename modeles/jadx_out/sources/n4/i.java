package n4;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class i {
    public static final Parcelable a(Bundle bundle, String str, Class cls) {
        Parcelable parcelable;
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) bundle.getParcelable(str, cls);
            if (parcelable == null) {
                parcelable = (Parcelable) cls.getDeclaredConstructor(null).newInstance(null);
            }
        } else {
            parcelable = bundle.getParcelable(str);
            if (parcelable == null) {
                parcelable = (Parcelable) cls.getDeclaredConstructor(null).newInstance(null);
            }
        }
        if (parcelable != null) {
            return parcelable;
        }
        Object newInstance = cls.getDeclaredConstructor(null).newInstance(null);
        newInstance.getClass();
        return (Parcelable) newInstance;
    }

    public static final ApplicationInfo b(PackageManager packageManager, String str, int i) {
        str.getClass();
        if (Build.VERSION.SDK_INT >= 33) {
            ApplicationInfo applicationInfo = packageManager.getApplicationInfo(str, PackageManager.ApplicationInfoFlags.of(i));
            applicationInfo.getClass();
            return applicationInfo;
        }
        ApplicationInfo applicationInfo2 = packageManager.getApplicationInfo(str, i);
        applicationInfo2.getClass();
        return applicationInfo2;
    }

    public static final List c(PackageManager packageManager) {
        if (Build.VERSION.SDK_INT >= 33) {
            List<ApplicationInfo> installedApplications = packageManager.getInstalledApplications(PackageManager.ApplicationInfoFlags.of(128));
            installedApplications.getClass();
            return installedApplications;
        }
        List<ApplicationInfo> installedApplications2 = packageManager.getInstalledApplications(128);
        installedApplications2.getClass();
        return installedApplications2;
    }

    public static final PackageInfo d(PackageManager packageManager, String str, int i) {
        str.getClass();
        try {
            return Build.VERSION.SDK_INT >= 33 ? packageManager.getPackageArchiveInfo(str, PackageManager.PackageInfoFlags.of(i)) : packageManager.getPackageArchiveInfo(str, i);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public static final PackageInfo e(PackageManager packageManager, String str, int i) {
        str.getClass();
        if (Build.VERSION.SDK_INT >= 33) {
            PackageInfo packageInfo = packageManager.getPackageInfo(str, PackageManager.PackageInfoFlags.of(i));
            packageInfo.getClass();
            return packageInfo;
        }
        PackageInfo packageInfo2 = packageManager.getPackageInfo(str, i);
        packageInfo2.getClass();
        return packageInfo2;
    }
}
