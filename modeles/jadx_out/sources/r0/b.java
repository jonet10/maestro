package r0;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.os.Binder;
import android.os.Process;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Context f8855a;

    public b(Context context) {
        this.f8855a = context;
    }

    public final ApplicationInfo a(int i, String str) {
        return this.f8855a.getPackageManager().getApplicationInfo(str, i);
    }

    public final PackageInfo b(int i, String str) {
        return this.f8855a.getPackageManager().getPackageInfo(str, i);
    }

    public final boolean c() {
        String nameForUid;
        int callingUid = Binder.getCallingUid();
        int myUid = Process.myUid();
        Context context = this.f8855a;
        if (callingUid == myUid) {
            return a.a(context);
        }
        if (!p0.b.a() || (nameForUid = context.getPackageManager().getNameForUid(Binder.getCallingUid())) == null) {
            return false;
        }
        return context.getPackageManager().isInstantApp(nameForUid);
    }
}
