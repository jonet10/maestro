package c3;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p0 {

    /* renamed from: a, reason: collision with root package name */
    public static final p0 f1300a = new p0();

    /* renamed from: b, reason: collision with root package name */
    public static final g5.f f1301b;

    static {
        n2.d dVar = new n2.d();
        dVar.a(o0.class, g.f1242a);
        dVar.a(v0.class, h.f1250a);
        dVar.a(k.class, e.f1228a);
        dVar.a(b.class, d.f1212a);
        dVar.a(a.class, c.f1200a);
        dVar.a(e0.class, f.f1237a);
        dVar.f7930d = true;
        f1301b = new g5.f(dVar, 10);
    }

    public static b a(n1.f fVar) {
        fVar.a();
        Context context = fVar.f7908a;
        context.getClass();
        String packageName = context.getPackageName();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String valueOf = Build.VERSION.SDK_INT >= 28 ? String.valueOf(packageInfo.getLongVersionCode()) : String.valueOf(packageInfo.versionCode);
        fVar.a();
        String str = fVar.f7910c.f7919b;
        str.getClass();
        Build.MODEL.getClass();
        Build.VERSION.RELEASE.getClass();
        packageName.getClass();
        String str2 = packageInfo.versionName;
        if (str2 == null) {
            str2 = valueOf;
        }
        Build.MANUFACTURER.getClass();
        fVar.a();
        e0 b7 = f0.b(context);
        fVar.a();
        return new b(str, new a(packageName, str2, valueOf, b7, f0.a(context)));
    }
}
