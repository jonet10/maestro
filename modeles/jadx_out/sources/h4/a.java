package h4;

import android.content.Context;
import android.content.SharedPreferences;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final Context f5456a;

    public a(Context context) {
        context.getClass();
        this.f5456a = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00c6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a() {
        /*
            r9 = this;
            android.content.Context r0 = r9.f5456a
            java.lang.String r1 = "outputdir"
            r2 = 0
            r3 = 0
            java.lang.String r4 = "CoreSettings"
            android.content.SharedPreferences r4 = r0.getSharedPreferences(r4, r2)     // Catch: java.lang.Exception -> L17
            boolean r5 = r4.contains(r1)     // Catch: java.lang.Exception -> L17
            if (r5 == 0) goto L17
            java.lang.String r4 = r4.getString(r1, r3)     // Catch: java.lang.Exception -> L17
            goto L18
        L17:
            r4 = r3
        L18:
            if (r4 == 0) goto Lb8
            java.lang.String r5 = "sdcard_as_backup_storage"
            boolean r5 = r9.c(r5, r2)
            if (r5 == 0) goto La5
            r0.getClass()
            android.content.ContentResolver r5 = r0.getContentResolver()
            java.util.List r5 = r5.getPersistedUriPermissions()
            r5.getClass()
            java.util.Iterator r5 = r5.iterator()
        L34:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L67
            java.lang.Object r6 = r5.next()
            android.content.UriPermission r6 = (android.content.UriPermission) r6
            android.net.Uri r7 = r6.getUri()
            r7.getClass()
            java.lang.String r7 = r7.getPath()
            if (r7 == 0) goto L5f
            java.lang.String r8 = ".*\\b[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]-[ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]][ABCDEF[0-9]]:.*"
            java.util.regex.Pattern r8 = java.util.regex.Pattern.compile(r8)
            r8.getClass()
            java.util.regex.Matcher r7 = r8.matcher(r7)
            boolean r7 = r7.matches()
            goto L60
        L5f:
            r7 = r2
        L60:
            if (r7 == 0) goto L34
            android.net.Uri r2 = r6.getUri()
            goto L68
        L67:
            r2 = r3
        L68:
            if (r2 == 0) goto La2
            androidx.documentfile.provider.DocumentFile r2 = androidx.documentfile.provider.DocumentFile.fromTreeUri(r0, r2)
            if (r2 == 0) goto L99
            java.lang.String r5 = "/"
            java.lang.String[] r5 = new java.lang.String[]{r5}
            java.util.List r5 = l7.m.G0(r4, r5)
            java.util.Iterator r5 = r5.iterator()
        L7e:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L99
            java.lang.Object r6 = r5.next()
            java.lang.String r6 = (java.lang.String) r6
            androidx.documentfile.provider.DocumentFile r7 = r2.findFile(r6)
            if (r7 != 0) goto L97
            androidx.documentfile.provider.DocumentFile r2 = r2.createDirectory(r6)
            if (r2 != 0) goto L7e
            goto L99
        L97:
            r2 = r7
            goto L7e
        L99:
            if (r2 == 0) goto La2
            boolean r5 = r2.exists()
            if (r5 == 0) goto La2
            return r2
        La2:
            r9.f()
        La5:
            java.io.File r2 = new java.io.File
            r2.<init>(r4)
            boolean r4 = r2.exists()
            if (r4 == 0) goto Lb1
            goto Lb7
        Lb1:
            boolean r4 = r2.mkdirs()
            if (r4 == 0) goto Lb8
        Lb7:
            return r2
        Lb8:
            java.io.File r0 = n4.d.a(r0)
            if (r0 == 0) goto Lc6
            java.lang.String r2 = r0.getAbsolutePath()
            r9.h(r1, r2)
            return r0
        Lc6:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.a.a():java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b() {
        /*
            r5 = this;
            android.content.Context r0 = r5.f5456a
            java.lang.String r1 = "outputdir"
            r2 = 0
            java.lang.String r3 = "CoreSettings"
            r4 = 0
            android.content.SharedPreferences r3 = r0.getSharedPreferences(r3, r4)     // Catch: java.lang.Exception -> L17
            boolean r4 = r3.contains(r1)     // Catch: java.lang.Exception -> L17
            if (r4 == 0) goto L17
            java.lang.String r3 = r3.getString(r1, r2)     // Catch: java.lang.Exception -> L17
            goto L18
        L17:
            r3 = r2
        L18:
            if (r3 == 0) goto L1b
            return r3
        L1b:
            java.io.File r0 = n4.d.a(r0)
            if (r0 == 0) goto L29
            java.lang.String r0 = r0.getAbsolutePath()
            r5.h(r1, r0)
            return r0
        L29:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.a.b():java.lang.String");
    }

    public final boolean c(String str, boolean z9) {
        try {
            SharedPreferences sharedPreferences = this.f5456a.getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences.contains(str)) {
                return sharedPreferences.getBoolean(str, z9);
            }
        } catch (Exception unused) {
        }
        return z9;
    }

    public final boolean d() {
        return c("storage_sdcard", false);
    }

    public final void e(String str, boolean z9) {
        try {
            SharedPreferences.Editor edit = this.f5456a.getSharedPreferences("CoreSettings", 0).edit();
            edit.putBoolean(str, z9);
            edit.apply();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void f() {
        e("sdcard_as_backup_storage", false);
    }

    public final void g() {
        e("storage_sdcard", false);
    }

    public final void h(String str, String str2) {
        try {
            SharedPreferences.Editor edit = this.f5456a.getSharedPreferences("CoreSettings", 0).edit();
            edit.putString(str, str2);
            edit.apply();
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public final void i(boolean z9) {
        e("user_asked_for_show_permissions", z9);
    }
}
