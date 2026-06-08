package j5;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.content.pm.SigningInfo;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import c4.j1;
import c4.k1;
import com.google.android.gms.internal.measurement.z3;
import e1.c0;
import java.io.File;
import java.lang.Character;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Pattern;
import x4.e1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {
    public static long a(ApplicationInfo applicationInfo) {
        File parentFile;
        long j;
        applicationInfo.getClass();
        long j6 = 0;
        if (applicationInfo.sourceDir == null || (parentFile = new File(applicationInfo.sourceDir).getParentFile()) == null || !parentFile.isDirectory()) {
            return 0L;
        }
        long k5 = c0.k(parentFile);
        String str = applicationInfo.packageName;
        str.getClass();
        try {
            j = c0.k(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/obb/" + str + "/"));
        } catch (Exception e10) {
            e10.printStackTrace();
            j = 0;
        }
        long j10 = k5 + j;
        String str2 = applicationInfo.packageName;
        str2.getClass();
        try {
            j6 = c0.k(new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + str2 + "/"));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return j10 + j6;
    }

    public static String b(Context context, String str) {
        context.getClass();
        str.getClass();
        try {
            return Build.VERSION.SDK_INT >= 30 ? context.getPackageManager().getInstallSourceInfo(str).getInstallingPackageName() : context.getPackageManager().getInstallerPackageName(str);
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00b6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList c(android.content.pm.PackageManager r6, java.lang.String r7) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L49
            r3 = 28
            r4 = 1
            r5 = 0
            if (r2 < r3) goto L77
            r2 = 134217728(0x8000000, float:3.85186E-34)
            android.content.pm.PackageInfo r6 = n4.i.e(r6, r7, r2)     // Catch: java.lang.Exception -> L49
            android.content.pm.SigningInfo r6 = r6.signingInfo     // Catch: java.lang.Exception -> L49
            if (r6 == 0) goto La9
            boolean r7 = r6.hasPastSigningCertificates()     // Catch: java.lang.Exception -> L49
            if (r7 == 0) goto L4c
            android.content.pm.Signature[] r7 = r6.getSigningCertificateHistory()     // Catch: java.lang.Exception -> L49
            r7.getClass()     // Catch: java.lang.Exception -> L49
            int r7 = r7.length     // Catch: java.lang.Exception -> L49
            if (r7 != 0) goto L2d
            goto L4c
        L2d:
            android.content.pm.Signature[] r6 = r6.getSigningCertificateHistory()     // Catch: java.lang.Exception -> L49
            kotlin.jvm.internal.b r6 = kotlin.jvm.internal.a0.d(r6)     // Catch: java.lang.Exception -> L49
        L35:
            boolean r7 = r6.hasNext()     // Catch: java.lang.Exception -> L49
            if (r7 == 0) goto La9
            java.lang.Object r7 = r6.next()     // Catch: java.lang.Exception -> L49
            android.content.pm.Signature r7 = (android.content.pm.Signature) r7     // Catch: java.lang.Exception -> L49
            byte[] r7 = r7.toByteArray()     // Catch: java.lang.Exception -> L49
            r1.add(r7)     // Catch: java.lang.Exception -> L49
            goto L35
        L49:
            r6 = move-exception
            goto La6
        L4c:
            android.content.pm.Signature[] r6 = r6.getApkContentsSigners()     // Catch: java.lang.Exception -> L49
            if (r6 == 0) goto La9
            int r7 = r6.length     // Catch: java.lang.Exception -> L49
            if (r7 != 0) goto L56
            goto La9
        L56:
            r7 = r5
        L57:
            int r2 = r6.length     // Catch: java.lang.Exception -> L49
            if (r7 >= r2) goto L5c
            r2 = r4
            goto L5d
        L5c:
            r2 = r5
        L5d:
            if (r2 == 0) goto La9
            int r2 = r7 + 1
            r7 = r6[r7]     // Catch: java.lang.Exception -> L49 java.lang.ArrayIndexOutOfBoundsException -> L6c
            byte[] r7 = r7.toByteArray()     // Catch: java.lang.Exception -> L49
            r1.add(r7)     // Catch: java.lang.Exception -> L49
            r7 = r2
            goto L57
        L6c:
            r6 = move-exception
            java.util.NoSuchElementException r7 = new java.util.NoSuchElementException     // Catch: java.lang.Exception -> L49
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Exception -> L49
            r7.<init>(r6)     // Catch: java.lang.Exception -> L49
            throw r7     // Catch: java.lang.Exception -> L49
        L77:
            r2 = 64
            android.content.pm.PackageInfo r6 = n4.i.e(r6, r7, r2)     // Catch: java.lang.Exception -> L49
            android.content.pm.Signature[] r6 = r6.signatures     // Catch: java.lang.Exception -> L49
            if (r6 == 0) goto La9
            int r7 = r6.length     // Catch: java.lang.Exception -> L49
            if (r7 != 0) goto L85
            goto La9
        L85:
            r7 = r5
        L86:
            int r2 = r6.length     // Catch: java.lang.Exception -> L49
            if (r7 >= r2) goto L8b
            r2 = r4
            goto L8c
        L8b:
            r2 = r5
        L8c:
            if (r2 == 0) goto La9
            int r2 = r7 + 1
            r7 = r6[r7]     // Catch: java.lang.Exception -> L49 java.lang.ArrayIndexOutOfBoundsException -> L9b
            byte[] r7 = r7.toByteArray()     // Catch: java.lang.Exception -> L49
            r1.add(r7)     // Catch: java.lang.Exception -> L49
            r7 = r2
            goto L86
        L9b:
            r6 = move-exception
            java.util.NoSuchElementException r7 = new java.util.NoSuchElementException     // Catch: java.lang.Exception -> L49
            java.lang.String r6 = r6.getMessage()     // Catch: java.lang.Exception -> L49
            r7.<init>(r6)     // Catch: java.lang.Exception -> L49
            throw r7     // Catch: java.lang.Exception -> L49
        La6:
            r6.printStackTrace()
        La9:
            java.util.Iterator r6 = r1.iterator()
            r6.getClass()
        Lb0:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto Lc9
            java.lang.Object r7 = r6.next()
            r7.getClass()
            byte[] r7 = (byte[]) r7
            java.lang.String r7 = com.google.android.gms.internal.measurement.z3.D(r7)
            if (r7 == 0) goto Lb0
            r0.add(r7)
            goto Lb0
        Lc9:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.a.c(android.content.pm.PackageManager, java.lang.String):java.util.ArrayList");
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x005d -> B:29:0x0060). Please report as a decompilation issue!!! */
    public static String d(PackageManager packageManager, String str, String str2) {
        byte[] bArr;
        try {
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (Build.VERSION.SDK_INT >= 28) {
            SigningInfo signingInfo = n4.i.e(packageManager, str, 134217728).signingInfo;
            if (signingInfo != null) {
                if (signingInfo.hasPastSigningCertificates()) {
                    Signature[] signingCertificateHistory = signingInfo.getSigningCertificateHistory();
                    signingCertificateHistory.getClass();
                    if (signingCertificateHistory.length != 0) {
                        bArr = signingInfo.getSigningCertificateHistory()[signingInfo.getSigningCertificateHistory().length - 1].toByteArray();
                    }
                }
                Signature[] apkContentsSigners = signingInfo.getApkContentsSigners();
                if (apkContentsSigners != null && apkContentsSigners.length != 0) {
                    bArr = apkContentsSigners[0].toByteArray();
                }
            }
            bArr = null;
        } else {
            Signature[] signatureArr = n4.i.e(packageManager, str, 64).signatures;
            if (signatureArr != null && signatureArr.length != 0) {
                bArr = signatureArr[0].toByteArray();
            }
            bArr = null;
        }
        if (bArr == null) {
            return null;
        }
        if (str2.equals("MD5")) {
            return z3.D(bArr);
        }
        if (str2.equals("SHA256")) {
            return z3.w(bArr);
        }
        return null;
    }

    public static String e(ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            x4.e eVar = (x4.e) next;
            String str = eVar.B;
            if (str != null) {
                arrayList2.add(str);
                ArrayList arrayList3 = eVar.I;
                if (arrayList3 != null && !arrayList3.isEmpty()) {
                    ArrayList arrayList4 = eVar.I;
                    arrayList4.getClass();
                    Iterator it2 = arrayList4.iterator();
                    it2.getClass();
                    while (it2.hasNext()) {
                        Object next2 = it2.next();
                        next2.getClass();
                        String str2 = ((e1) next2).f11138a;
                        if (str2 != null) {
                            arrayList2.add(str2);
                        }
                    }
                }
                ArrayList arrayList5 = eVar.J;
                if (arrayList5 != null && !arrayList5.isEmpty()) {
                    ArrayList arrayList6 = eVar.J;
                    arrayList6.getClass();
                    Iterator it3 = arrayList6.iterator();
                    it3.getClass();
                    while (it3.hasNext()) {
                        Object next3 = it3.next();
                        next3.getClass();
                        String str3 = ((e1) next3).f11138a;
                        if (str3 != null) {
                            arrayList2.add(str3);
                        }
                    }
                }
            }
        }
        q6.q.j0(arrayList2, new k1(new j1(3), 4));
        Iterator it4 = arrayList2.iterator();
        it4.getClass();
        String str4 = null;
        while (it4.hasNext()) {
            Object next4 = it4.next();
            next4.getClass();
            String str5 = (String) next4;
            str4 = str4 == null ? str5 : String.format("%s%s", Arrays.copyOf(new Object[]{str4, str5}, 2));
        }
        if (str4 == null) {
            return str4;
        }
        byte[] bytes = (str4 + Build.VERSION.SDK_INT).getBytes(l7.a.f7151a);
        bytes.getClass();
        return z3.D(bytes);
    }

    public static boolean f(Context context) {
        context.getClass();
        String str = Build.BRAND;
        String str2 = Build.MANUFACTURER;
        if (!l7.u.m0(str, "Xiaomi", true) && !l7.u.m0(str2, "Xiaomi", true) && !l7.u.m0(str, "Poco", true)) {
            g l10 = g.D.l(context);
            l10.b();
            ArrayList E = l10.E();
            l10.c();
            Iterator it = E.iterator();
            it.getClass();
            int i = 0;
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                x4.e eVar = (x4.e) next;
                if (eVar.f11123l != null && (eVar.c() || eVar.d())) {
                    String str3 = eVar.f11123l;
                    str3.getClass();
                    if (l7.u.p0(str3, "com.miui.", false) || l7.u.p0(str3, "com.xiaomi.", false)) {
                        i++;
                        if (i > 5) {
                            break;
                        }
                    }
                }
            }
            if (i <= 5) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x02ff, code lost:
    
        if (r0 != 4) goto L167;
     */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00d0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static x4.e g(android.content.pm.ApplicationInfo r23, x4.e r24, android.content.pm.PackageInfo r25, j5.g r26, android.content.Context r27, android.content.pm.PackageManager r28, boolean r29, boolean r30) {
        /*
            Method dump skipped, instructions count: 788
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.a.g(android.content.pm.ApplicationInfo, x4.e, android.content.pm.PackageInfo, j5.g, android.content.Context, android.content.pm.PackageManager, boolean, boolean):x4.e");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:15|16|17|(11:19|20|21|22|23|(1:25)|27|28|29|30|(1:32))|37|21|22|23|(0)|27|28|29|30|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0063, code lost:
    
        r3 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:25:0x004f A[Catch: all -> 0x0026, Exception -> 0x0053, TRY_LEAVE, TryCatch #2 {, blocks: (B:9:0x000b, B:12:0x0019, B:17:0x002e, B:19:0x003a, B:23:0x0043, B:25:0x004f, B:29:0x0054, B:32:0x0066, B:39:0x0077), top: B:8:0x000b }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0066 A[Catch: all -> 0x0026, TRY_ENTER, TryCatch #2 {, blocks: (B:9:0x000b, B:12:0x0019, B:17:0x002e, B:19:0x003a, B:23:0x0043, B:25:0x004f, B:29:0x0054, B:32:0x0066, B:39:0x0077), top: B:8:0x000b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static x4.e h(android.content.Context r11, java.lang.String r12) {
        /*
            r11.getClass()
            java.lang.Object r1 = com.uptodown.UptodownApp.f3298l0
            monitor-enter(r1)
            r0 = 0
            if (r12 != 0) goto Lb
            monitor-exit(r1)
            return r0
        Lb:
            e1.c0 r2 = j5.g.D     // Catch: java.lang.Throwable -> L26
            j5.g r6 = r2.l(r11)     // Catch: java.lang.Throwable -> L26
            r6.b()     // Catch: java.lang.Throwable -> L26
            android.content.pm.PackageManager r8 = r11.getPackageManager()     // Catch: java.lang.Throwable -> L26
            r2 = 0
            android.content.pm.PackageManager r3 = r11.getPackageManager()     // Catch: java.lang.Throwable -> L26 android.content.pm.PackageManager.NameNotFoundException -> L29
            r3.getClass()     // Catch: java.lang.Throwable -> L26 android.content.pm.PackageManager.NameNotFoundException -> L29
            android.content.pm.PackageInfo r3 = n4.i.e(r3, r12, r2)     // Catch: java.lang.Throwable -> L26 android.content.pm.PackageManager.NameNotFoundException -> L29
            r5 = r3
            goto L2a
        L26:
            r0 = move-exception
            r11 = r0
            goto L7c
        L29:
            r5 = r0
        L2a:
            if (r5 == 0) goto L77
            java.lang.String r3 = "show_system_apps"
            java.lang.String r4 = "SettingsPreferences"
            android.content.SharedPreferences r4 = r11.getSharedPreferences(r4, r2)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L40
            boolean r7 = r4.contains(r3)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L40
            if (r7 == 0) goto L40
            boolean r3 = r4.getBoolean(r3, r2)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L40
            r9 = r3
            goto L41
        L40:
            r9 = r2
        L41:
            java.lang.String r3 = "show_system_services"
            java.lang.String r4 = "SettingsPreferences"
            android.content.SharedPreferences r4 = r11.getSharedPreferences(r4, r2)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L53
            boolean r7 = r4.contains(r3)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L53
            if (r7 == 0) goto L53
            boolean r2 = r4.getBoolean(r3, r2)     // Catch: java.lang.Throwable -> L26 java.lang.Exception -> L53
        L53:
            r10 = r2
            android.content.pm.PackageManager r2 = r11.getPackageManager()     // Catch: java.lang.Throwable -> L26 android.content.pm.PackageManager.NameNotFoundException -> L63
            r2.getClass()     // Catch: java.lang.Throwable -> L26 android.content.pm.PackageManager.NameNotFoundException -> L63
            r3 = 128(0x80, float:1.8E-43)
            android.content.pm.ApplicationInfo r12 = n4.i.b(r2, r12, r3)     // Catch: java.lang.Throwable -> L26 android.content.pm.PackageManager.NameNotFoundException -> L63
            r3 = r12
            goto L64
        L63:
            r3 = r0
        L64:
            if (r3 == 0) goto L77
            java.lang.String r12 = r3.packageName     // Catch: java.lang.Throwable -> L26
            r12.getClass()     // Catch: java.lang.Throwable -> L26
            x4.e r4 = r6.B(r12)     // Catch: java.lang.Throwable -> L26
            r8.getClass()     // Catch: java.lang.Throwable -> L26
            r7 = r11
            x4.e r0 = g(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L26
        L77:
            r6.c()     // Catch: java.lang.Throwable -> L26
            monitor-exit(r1)
            return r0
        L7c:
            monitor-exit(r1)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.a.h(android.content.Context, java.lang.String):x4.e");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:3|4|5|(2:6|7)|(15:9|10|11|12|13|(10:15|16|17|(6:20|21|22|(6:28|29|(2:30|(2:32|(2:35|36)(1:34))(2:41|42))|(1:38)|39|40)(3:24|25|26)|27|18)|45|46|(4:49|(3:51|52|53)(1:55)|54|47)|56|57|58)|63|17|(1:18)|45|46|(1:47)|56|57|58)|66|11|12|13|(0)|63|17|(1:18)|45|46|(1:47)|56|57|58) */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0049 A[Catch: Exception -> 0x004f, all -> 0x006a, TRY_LEAVE, TryCatch #0 {Exception -> 0x004f, blocks: (B:13:0x003d, B:15:0x0049), top: B:12:0x003d }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005a A[Catch: all -> 0x006a, TRY_LEAVE, TryCatch #2 {, blocks: (B:4:0x0008, B:7:0x0028, B:9:0x0034, B:13:0x003d, B:15:0x0049, B:17:0x0050, B:18:0x0054, B:20:0x005a, B:22:0x0060, B:29:0x0070, B:30:0x0075, B:32:0x007b, B:38:0x00a3, B:39:0x00a6, B:46:0x00b6, B:47:0x00bd, B:49:0x00c3, B:52:0x00d3, B:57:0x00d7), top: B:3:0x0008 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c3 A[Catch: all -> 0x006a, TryCatch #2 {, blocks: (B:4:0x0008, B:7:0x0028, B:9:0x0034, B:13:0x003d, B:15:0x0049, B:17:0x0050, B:18:0x0054, B:20:0x005a, B:22:0x0060, B:29:0x0070, B:30:0x0075, B:32:0x007b, B:38:0x00a3, B:39:0x00a6, B:46:0x00b6, B:47:0x00bd, B:49:0x00c3, B:52:0x00d3, B:57:0x00d7), top: B:3:0x0008 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.ArrayList i(android.content.Context r19) {
        /*
            r4 = r19
            r4.getClass()
            java.lang.Object r8 = com.uptodown.UptodownApp.f3298l0
            monitor-enter(r8)
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L6a
            r9.<init>()     // Catch: java.lang.Throwable -> L6a
            e1.c0 r0 = j5.g.D     // Catch: java.lang.Throwable -> L6a
            j5.g r3 = r0.l(r4)     // Catch: java.lang.Throwable -> L6a
            r3.b()     // Catch: java.lang.Throwable -> L6a
            android.content.pm.PackageManager r5 = r4.getPackageManager()     // Catch: java.lang.Throwable -> L6a
            r5.getClass()     // Catch: java.lang.Throwable -> L6a
            java.util.List r0 = n4.i.c(r5)     // Catch: java.lang.Throwable -> L6a
            java.util.ArrayList r10 = r3.E()     // Catch: java.lang.Throwable -> L6a
            java.lang.String r1 = "show_system_apps"
            r11 = 0
            java.lang.String r2 = "SettingsPreferences"
            android.content.SharedPreferences r2 = r4.getSharedPreferences(r2, r11)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L6a
            boolean r6 = r2.contains(r1)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L6a
            if (r6 == 0) goto L3a
            boolean r1 = r2.getBoolean(r1, r11)     // Catch: java.lang.Exception -> L3a java.lang.Throwable -> L6a
            r6 = r1
            goto L3b
        L3a:
            r6 = r11
        L3b:
            java.lang.String r1 = "show_system_services"
            java.lang.String r2 = "SettingsPreferences"
            android.content.SharedPreferences r2 = r4.getSharedPreferences(r2, r11)     // Catch: java.lang.Exception -> L4f java.lang.Throwable -> L6a
            boolean r7 = r2.contains(r1)     // Catch: java.lang.Exception -> L4f java.lang.Throwable -> L6a
            if (r7 == 0) goto L4f
            boolean r1 = r2.getBoolean(r1, r11)     // Catch: java.lang.Exception -> L4f java.lang.Throwable -> L6a
            r7 = r1
            goto L50
        L4f:
            r7 = r11
        L50:
            java.util.Iterator r12 = r0.iterator()     // Catch: java.lang.Throwable -> L6a
        L54:
            boolean r0 = r12.hasNext()     // Catch: java.lang.Throwable -> L6a
            if (r0 == 0) goto Lb6
            java.lang.Object r0 = r12.next()     // Catch: java.lang.Throwable -> L6a
            android.content.pm.ApplicationInfo r0 = (android.content.pm.ApplicationInfo) r0     // Catch: java.lang.Throwable -> L6a
            java.lang.String r2 = r0.packageName     // Catch: java.lang.Throwable -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6d
            r2.getClass()     // Catch: java.lang.Throwable -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6d
            android.content.pm.PackageInfo r2 = n4.i.e(r5, r2, r11)     // Catch: java.lang.Throwable -> L6a android.content.pm.PackageManager.NameNotFoundException -> L6d
            goto L6e
        L6a:
            r0 = move-exception
            goto Ldc
        L6d:
            r2 = 0
        L6e:
            if (r2 == 0) goto Lb3
            java.util.Iterator r13 = r10.iterator()     // Catch: java.lang.Throwable -> L6a
            r14 = r11
        L75:
            boolean r15 = r13.hasNext()     // Catch: java.lang.Throwable -> L6a
            if (r15 == 0) goto L9c
            int r15 = r14 + 1
            java.lang.Object r16 = r13.next()     // Catch: java.lang.Throwable -> L6a
            r1 = r16
            x4.e r1 = (x4.e) r1     // Catch: java.lang.Throwable -> L6a
            java.lang.String r11 = r1.f11123l     // Catch: java.lang.Throwable -> L6a
            r17 = r1
            java.lang.String r1 = r0.packageName     // Catch: java.lang.Throwable -> L6a
            r18 = r12
            r12 = 0
            boolean r1 = l7.u.m0(r11, r1, r12)     // Catch: java.lang.Throwable -> L6a
            if (r1 == 0) goto L97
            r1 = r17
            goto La1
        L97:
            r11 = r12
            r14 = r15
            r12 = r18
            goto L75
        L9c:
            r18 = r12
            r12 = r11
            r14 = -1
            r1 = 0
        La1:
            if (r14 < 0) goto La6
            r10.remove(r14)     // Catch: java.lang.Throwable -> L6a
        La6:
            x4.e r0 = g(r0, r1, r2, r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L6a
            r9.add(r0)     // Catch: java.lang.Throwable -> L6a
            r4 = r19
            r11 = r12
            r12 = r18
            goto L54
        Lb3:
            r4 = r19
            goto L54
        Lb6:
            java.util.Iterator r0 = r10.iterator()     // Catch: java.lang.Throwable -> L6a
            r0.getClass()     // Catch: java.lang.Throwable -> L6a
        Lbd:
            boolean r1 = r0.hasNext()     // Catch: java.lang.Throwable -> L6a
            if (r1 == 0) goto Ld7
            java.lang.Object r1 = r0.next()     // Catch: java.lang.Throwable -> L6a
            r1.getClass()     // Catch: java.lang.Throwable -> L6a
            x4.e r1 = (x4.e) r1     // Catch: java.lang.Throwable -> L6a
            r3.f(r1)     // Catch: java.lang.Throwable -> L6a
            java.lang.String r1 = r1.f11123l     // Catch: java.lang.Throwable -> L6a
            if (r1 == 0) goto Lbd
            r3.s(r1)     // Catch: java.lang.Throwable -> L6a
            goto Lbd
        Ld7:
            r3.c()     // Catch: java.lang.Throwable -> L6a
            monitor-exit(r8)
            return r9
        Ldc:
            monitor-exit(r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.a.i(android.content.Context):java.util.ArrayList");
    }

    public static void j(x4.e eVar, PackageInfo packageInfo, Context context) {
        eVar.getClass();
        context.getClass();
        try {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            if (applicationInfo != null) {
                eVar.f11122b = applicationInfo.loadLabel(context.getPackageManager()).toString();
            }
        } catch (Exception unused) {
            eVar.f11122b = eVar.f11123l;
        }
        try {
            Configuration configuration = new Configuration();
            configuration.setLocale(new Locale("xx"));
            if (packageInfo.applicationInfo != null) {
                PackageManager packageManager = context.getPackageManager();
                ApplicationInfo applicationInfo2 = packageInfo.applicationInfo;
                applicationInfo2.getClass();
                Resources resourcesForApplication = packageManager.getResourcesForApplication(applicationInfo2.packageName);
                resourcesForApplication.getClass();
                resourcesForApplication.updateConfiguration(configuration, context.getResources().getDisplayMetrics());
                ApplicationInfo applicationInfo3 = packageInfo.applicationInfo;
                applicationInfo3.getClass();
                eVar.f11136z = resourcesForApplication.getString(applicationInfo3.labelRes);
            }
        } catch (Exception unused2) {
            eVar.f11136z = eVar.f11122b;
        }
        String str = eVar.f11136z;
        str.getClass();
        int length = str.length();
        boolean z9 = false;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            char charAt = str.charAt(i);
            if (Build.VERSION.SDK_INT >= 24 ? Character.UnicodeScript.of(charAt) == Character.UnicodeScript.HAN : Character.isIdeographic(charAt)) {
                z9 = true;
                break;
            }
            i++;
        }
        if (z9) {
            eVar.f11136z = eVar.f11123l;
        } else {
            String str2 = eVar.f11136z;
            str2.getClass();
            Normalizer.Form form = Normalizer.Form.NFD;
            if (!Normalizer.isNormalized(str2, form)) {
                String normalize = Normalizer.normalize(str2, form);
                normalize.getClass();
                Pattern compile = Pattern.compile("[\\p{InCombiningDiacriticalMarks}]");
                compile.getClass();
                str2 = compile.matcher(normalize).replaceAll("");
                str2.getClass();
            }
            eVar.f11136z = str2;
        }
        if (l7.u.m0(eVar.f11136z, "null", true)) {
            eVar.f11135y = 1;
        }
    }
}
