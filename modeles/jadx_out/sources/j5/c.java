package j5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import com.uptodown.UptodownApp;
import com.uptodown.activities.CustomWebView;
import java.io.File;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class c {
    /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067 A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.app.AlertDialog a(android.app.AlertDialog r5, androidx.fragment.app.FragmentActivity r6) {
        /*
            java.lang.String r0 = "SettingsPreferences"
            if (r5 == 0) goto L7
            r5.dismiss()
        L7:
            java.lang.String r5 = "is_in_eea"
            r1 = 1
            r2 = 0
            android.content.SharedPreferences r3 = r6.getSharedPreferences(r0, r2)     // Catch: java.lang.Exception -> L1a
            boolean r4 = r3.contains(r5)     // Catch: java.lang.Exception -> L1a
            if (r4 == 0) goto L1a
            boolean r5 = r3.getBoolean(r5, r1)     // Catch: java.lang.Exception -> L1a
            goto L1b
        L1a:
            r5 = r1
        L1b:
            if (r5 == 0) goto L67
            java.lang.String r5 = "gdpr_tracking_allowed"
            android.content.SharedPreferences r0 = r6.getSharedPreferences(r0, r2)     // Catch: java.lang.Exception -> L2d
            boolean r3 = r0.contains(r5)     // Catch: java.lang.Exception -> L2d
            if (r3 == 0) goto L2d
            boolean r2 = r0.getBoolean(r5, r2)     // Catch: java.lang.Exception -> L2d
        L2d:
            if (r2 != 0) goto L67
            android.app.AlertDialog$Builder r5 = new android.app.AlertDialog$Builder
            r5.<init>(r6)
            r0 = 2131952663(0x7f130417, float:1.9541775E38)
            java.lang.String r0 = r6.getString(r0)
            r5.setMessage(r0)
            d4.p r0 = new d4.p
            r2 = 3
            r0.<init>(r6, r2)
            r2 = 2131952044(0x7f1301ac, float:1.954052E38)
            r5.setPositiveButton(r2, r0)
            f5.b r0 = new f5.b
            r2 = 12
            r0.<init>(r2)
            r2 = 17039360(0x1040000, float:2.424457E-38)
            r5.setNegativeButton(r2, r0)
            r5.setCancelable(r1)
            android.app.AlertDialog r5 = r5.create()
            boolean r6 = r6.isFinishing()
            if (r6 != 0) goto L66
            r5.show()
        L66:
            return r5
        L67:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.c.a(android.app.AlertDialog, androidx.fragment.app.FragmentActivity):android.app.AlertDialog");
    }

    public static void b(Context context, String str, String str2) {
        context.getClass();
        str.getClass();
        str2.getClass();
        try {
            if (str.equalsIgnoreCase(str2)) {
                Iterator it = a.a.E(context).iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    File file = (File) next;
                    String name = file.getName();
                    name.getClass();
                    String C = a.a.C(name);
                    if (C != null && C.equalsIgnoreCase(str2)) {
                        String absolutePath = file.getAbsolutePath();
                        if (file.delete()) {
                            g l10 = g.D.l(context);
                            l10.b();
                            absolutePath.getClass();
                            SQLiteDatabase sQLiteDatabase = l10.f6673a;
                            sQLiteDatabase.getClass();
                            sQLiteDatabase.delete("deep_link_files", "path=?", new String[]{absolutePath});
                            l10.c();
                            return;
                        }
                        return;
                    }
                }
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public static String c(int i) {
        if (i >= 1000000) {
            double d10 = i / 1000000.0d;
            int i6 = (int) d10;
            if (d10 != i6) {
                return l7.u.o0(String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(d10)}, 1)), ",0", "", false).concat("M");
            }
            return i6 + "M";
        }
        if (i < 1000) {
            return String.valueOf(i);
        }
        double d11 = i / 1000.0d;
        int i10 = (int) d11;
        if (d11 != i10) {
            return l7.u.o0(String.format(Locale.getDefault(), "%.1f", Arrays.copyOf(new Object[]{Double.valueOf(d11)}, 1)), ",0", "", false).concat("K");
        }
        return i10 + "K";
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0041, code lost:
    
        if (l7.u.p0(r1, "https://play.google.com", false) != false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String d(android.net.Uri r5) {
        /*
            java.lang.String r0 = r5.toString()
            r0.getClass()
            java.lang.String r1 = "utd://"
            r2 = 0
            boolean r1 = l7.u.p0(r0, r1, r2)
            r3 = 6
            if (r1 == 0) goto L16
            java.lang.String r5 = r0.substring(r3)
            return r5
        L16:
            java.lang.String r1 = r5.toString()
            r1.getClass()
            java.lang.String r4 = "market://"
            boolean r1 = l7.u.p0(r1, r4, r2)
            if (r1 != 0) goto L43
            java.lang.String r1 = r5.toString()
            r1.getClass()
            java.lang.String r4 = "http://play.google.com"
            boolean r1 = l7.u.p0(r1, r4, r2)
            if (r1 != 0) goto L43
            java.lang.String r1 = r5.toString()
            r1.getClass()
            java.lang.String r4 = "https://play.google.com"
            boolean r1 = l7.u.p0(r1, r4, r2)
            if (r1 == 0) goto L6e
        L43:
            java.lang.String r1 = r5.toString()
            r1.getClass()
            java.lang.String r4 = "details?id="
            boolean r1 = l7.m.q0(r1, r4, r2)
            if (r1 == 0) goto L6e
            int r5 = l7.m.y0(r0, r4, r2, r2, r3)
            int r5 = r5 + 11
            java.lang.String r1 = "&"
            boolean r4 = l7.m.q0(r0, r1, r2)
            if (r4 == 0) goto L69
            int r1 = l7.m.y0(r0, r1, r2, r2, r3)
            java.lang.String r5 = r0.substring(r5, r1)
            return r5
        L69:
            java.lang.String r5 = r0.substring(r5)
            return r5
        L6e:
            java.lang.String r5 = r5.toString()
            r5.getClass()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.c.d(android.net.Uri):java.lang.String");
    }

    public static void e(Activity activity, String str, String str2) {
        activity.getClass();
        str.getClass();
        if (l7.m.q0(str, ".uptodown.com/", false)) {
            str = (l7.m.q0(str, "?", false) ? str.concat("&") : str.concat("?")).concat("userAgent=uptodownandroid");
        }
        try {
            new CustomTabsIntent.Builder().build().launchUrl(activity, Uri.parse(str));
        } catch (Exception unused) {
            Intent intent = new Intent(activity, (Class<?>) CustomWebView.class);
            if (str2 != null) {
                intent.putExtra("title", str2);
            }
            intent.putExtra("url", str);
            float f = UptodownApp.I;
            activity.startActivity(intent, b4.d.a(activity));
        }
    }
}
