package j5;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import androidx.core.content.ContextCompat;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class t {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f6708a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final ArrayList f6709b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList f6710c = new ArrayList();

    public static Spanned a(String str) {
        if (Build.VERSION.SDK_INT >= 24) {
            Spanned fromHtml = Html.fromHtml(str, 0);
            fromHtml.getClass();
            return fromHtml;
        }
        Spanned fromHtml2 = Html.fromHtml(str);
        fromHtml2.getClass();
        return fromHtml2;
    }

    public static Drawable b(Context context, String str) {
        Drawable drawable;
        context.getClass();
        if (str != null) {
            ConcurrentHashMap concurrentHashMap = f6708a;
            drawable = (Drawable) concurrentHashMap.get(str);
            if (drawable == null) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    packageManager.getClass();
                    ApplicationInfo applicationInfo = n4.i.e(packageManager, str, 0).applicationInfo;
                    if (applicationInfo != null) {
                        drawable = applicationInfo.loadIcon(context.getPackageManager());
                        concurrentHashMap.put(str, drawable);
                    }
                } catch (Exception unused) {
                }
            }
        } else {
            drawable = null;
        }
        return drawable == null ? ContextCompat.getDrawable(context, 2131231475) : drawable;
    }
}
