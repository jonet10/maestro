package n4;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Build;
import c4.ya;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import o7.c0;
import o7.m0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h {

    /* renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap f7966c = new ConcurrentHashMap();

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap f7967d = new ConcurrentHashMap();

    /* renamed from: a, reason: collision with root package name */
    public final Context f7968a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f7969b;

    public h(Context context) {
        context.getClass();
        Context applicationContext = context.getApplicationContext();
        applicationContext.getClass();
        this.f7968a = applicationContext;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x006a A[Catch: all -> 0x0029, TryCatch #0 {all -> 0x0029, blocks: (B:11:0x0025, B:12:0x0066, B:14:0x006a, B:15:0x0070, B:29:0x004e), top: B:7:0x001f }] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object a(n4.h r5, int r6, v6.c r7) {
        /*
            boolean r0 = r7 instanceof n4.e
            if (r0 == 0) goto L13
            r0 = r7
            n4.e r0 = (n4.e) r0
            int r1 = r0.f7947m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7947m = r1
            goto L18
        L13:
            n4.e r0 = new n4.e
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r5 = r0.f7945b
            int r7 = r0.f7947m
            j$.util.concurrent.ConcurrentHashMap r1 = n4.h.f7966c
            r2 = 1
            if (r7 == 0) goto L32
            if (r7 != r2) goto L2b
            int r6 = r0.f7944a
            p6.a.e(r5)     // Catch: java.lang.Throwable -> L29
            goto L66
        L29:
            r5 = move-exception
            goto L7d
        L2b:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            r5 = 0
            return r5
        L32:
            p6.a.e(r5)
            java.lang.Integer r5 = new java.lang.Integer
            r5.<init>(r6)
            java.lang.Object r7 = r1.get(r5)
            if (r7 != 0) goto L4c
            o7.r r7 = o7.c0.a()
            java.lang.Object r5 = r1.putIfAbsent(r5, r7)
            if (r5 != 0) goto L4b
            goto L4c
        L4b:
            r7 = r5
        L4c:
            o7.q r7 = (o7.q) r7
            b.s r5 = new b.s     // Catch: java.lang.Throwable -> L29
            r3 = 25
            r4 = 0
            r5.<init>(r7, r4, r3)     // Catch: java.lang.Throwable -> L29
            r0.f7944a = r6     // Catch: java.lang.Throwable -> L29
            r0.f7947m = r2     // Catch: java.lang.Throwable -> L29
            r2 = 600000(0x927c0, double:2.964394E-318)
            java.lang.Object r5 = o7.c0.E(r2, r5, r0)     // Catch: java.lang.Throwable -> L29
            u6.a r7 = u6.a.f10762a
            if (r5 != r7) goto L66
            return r7
        L66:
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch: java.lang.Throwable -> L29
            if (r5 == 0) goto L6f
            boolean r5 = r5.booleanValue()     // Catch: java.lang.Throwable -> L29
            goto L70
        L6f:
            r5 = 0
        L70:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch: java.lang.Throwable -> L29
            java.lang.Integer r7 = new java.lang.Integer
            r7.<init>(r6)
            r1.remove(r7)
            return r5
        L7d:
            java.lang.Integer r7 = new java.lang.Integer
            r7.<init>(r6)
            r1.remove(r7)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.h.a(n4.h, int, v6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object b(n4.h r4, int r5, v6.c r6) {
        /*
            boolean r0 = r6 instanceof n4.f
            if (r0 == 0) goto L13
            r0 = r6
            n4.f r0 = (n4.f) r0
            int r1 = r0.f7951m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7951m = r1
            goto L18
        L13:
            n4.f r0 = new n4.f
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r4 = r0.f7949b
            int r6 = r0.f7951m
            j$.util.concurrent.ConcurrentHashMap r1 = n4.h.f7967d
            r2 = 1
            if (r6 == 0) goto L32
            if (r6 != r2) goto L2b
            int r5 = r0.f7948a
            p6.a.e(r4)     // Catch: java.lang.Throwable -> L29
            goto L5d
        L29:
            r4 = move-exception
            goto L66
        L2b:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r4)
            r4 = 0
            return r4
        L32:
            p6.a.e(r4)
            java.lang.Integer r4 = new java.lang.Integer
            r4.<init>(r5)
            java.lang.Object r6 = r1.get(r4)
            if (r6 != 0) goto L4c
            o7.r r6 = o7.c0.a()
            java.lang.Object r4 = r1.putIfAbsent(r4, r6)
            if (r4 != 0) goto L4b
            goto L4c
        L4b:
            r6 = r4
        L4c:
            o7.q r6 = (o7.q) r6
            r0.f7948a = r5     // Catch: java.lang.Throwable -> L29
            r0.f7951m = r2     // Catch: java.lang.Throwable -> L29
            o7.r r6 = (o7.r) r6     // Catch: java.lang.Throwable -> L29
            java.lang.Object r4 = r6.w(r0)     // Catch: java.lang.Throwable -> L29
            u6.a r6 = u6.a.f10762a
            if (r4 != r6) goto L5d
            return r6
        L5d:
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r5)
            r1.remove(r6)
            return r4
        L66:
            java.lang.Integer r6 = new java.lang.Integer
            r6.<init>(r5)
            r1.remove(r6)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: n4.h.b(n4.h, int, v6.c):java.lang.Object");
    }

    public static final void c(h hVar, PackageInstaller packageInstaller) {
        Iterator<PackageInstaller.SessionInfo> it = packageInstaller.getMySessions().iterator();
        while (it.hasNext()) {
            try {
                packageInstaller.abandonSession(it.next().getSessionId());
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public static final Object d(h hVar, File file, File file2, g gVar) {
        v7.e eVar = m0.f8288a;
        Object C = c0.C(new b6.g(file2, file, hVar, (t6.c) null, 18), v7.d.f10884a, gVar);
        return C == u6.a.f10762a ? C : p6.x.f8463a;
    }

    public static final String f(h hVar, int i, PackageInstaller.Session session, int i6) {
        Context context = hVar.f7968a;
        if (i == 0) {
            String string = context.getString(2131951993, "102");
            string.getClass();
            return string;
        }
        if (session == null) {
            String string2 = context.getString(2131951993, "103");
            string2.getClass();
            return string2;
        }
        if (i6 == 0) {
            String string3 = context.getString(2131952092);
            string3.getClass();
            return string3;
        }
        if (i6 == 1) {
            String string4 = context.getString(2131951993, "105");
            string4.getClass();
            return string4;
        }
        if (i6 == 2) {
            String string5 = context.getString(2131951993, "106");
            string5.getClass();
            return string5;
        }
        if (i6 == 3) {
            String string6 = context.getString(2131951993, "107");
            string6.getClass();
            return string6;
        }
        if (i6 == 4) {
            String string7 = context.getString(2131951993, "108");
            string7.getClass();
            return string7;
        }
        String string8 = context.getString(2131951993, "101");
        string8.getClass();
        return string8;
    }

    public static final OutputStream g(h hVar, PackageInstaller.Session session, File file) {
        OutputStream openWrite = session.openWrite(file.getName(), 0L, file.length());
        openWrite.getClass();
        return openWrite;
    }

    public static final int h(h hVar, String str, Long l10, ArrayList arrayList) {
        PackageInfo packageInfo;
        if (str == null) {
            return 1;
        }
        try {
            PackageManager packageManager = hVar.f7968a.getPackageManager();
            packageManager.getClass();
            packageInfo = i.e(packageManager, str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        if (packageInfo != null) {
            return (l10 != null && d.d(packageInfo) == l10.longValue() && arrayList.size() > 1) ? 2 : 1;
        }
        return 1;
    }

    public static boolean l(int i) {
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 31) {
            return false;
        }
        if (i6 == 31 && i >= 29) {
            return true;
        }
        if (i6 == 32 && i >= 29) {
            return true;
        }
        if (i6 != 33 || i < 30) {
            return i6 >= 34 && i >= 31;
        }
        return true;
    }

    public final void k(ArrayList arrayList, boolean z9) {
        this.f7969b = z9;
        ArrayList arrayList2 = new ArrayList();
        arrayList2.addAll(arrayList);
        v7.e eVar = m0.f8288a;
        c0.s(c0.b(v7.d.f10884a), null, null, new ya(this, arrayList2, (t6.c) null, 21), 3);
    }
}
