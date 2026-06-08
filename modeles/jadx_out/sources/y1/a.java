package y1;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f11599a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11600b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f11601c;

    /* renamed from: d, reason: collision with root package name */
    public final String f11602d;

    /* renamed from: e, reason: collision with root package name */
    public final String f11603e;
    public final String f;
    public final String g;
    public final m8.q h;

    public a(String str, String str2, ArrayList arrayList, String str3, String str4, String str5, String str6, m8.q qVar) {
        this.f11599a = str;
        this.f11600b = str2;
        this.f11601c = arrayList;
        this.f11602d = str3;
        this.f11603e = str4;
        this.f = str5;
        this.g = str6;
        this.h = qVar;
    }

    public static a a(Context context, x xVar, String str, String str2, ArrayList arrayList, m8.q qVar) {
        String packageName = context.getPackageName();
        String d10 = xVar.d();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        String l10 = Build.VERSION.SDK_INT >= 28 ? Long.toString(packageInfo.getLongVersionCode()) : Integer.toString(packageInfo.versionCode);
        String str3 = packageInfo.versionName;
        if (str3 == null) {
            str3 = "0.0";
        }
        return new a(str, str2, arrayList, d10, packageName, l10, str3, qVar);
    }
}
