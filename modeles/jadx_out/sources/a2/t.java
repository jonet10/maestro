package a2;

import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.documentfile.provider.DocumentFile;
import c4.w4;
import com.google.firebase.messaging.FirebaseMessaging;
import e1.g1;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import k0.y;
import o7.c0;
import o7.m0;
import w8.e0;
import w8.i0;
import w8.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t {

    /* renamed from: a, reason: collision with root package name */
    public boolean f52a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f53b;

    /* renamed from: c, reason: collision with root package name */
    public Object f54c;

    /* renamed from: d, reason: collision with root package name */
    public Object f55d;

    public t(Context context, String str, k4.c cVar, boolean z9) {
        str.getClass();
        cVar.getClass();
        this.f53b = context;
        this.f54c = str;
        this.f55d = cVar;
        this.f52a = z9;
        v7.e eVar = m0.f8288a;
        c0.s(c0.b(v7.d.f10884a), null, null, new b.s(this, (t6.c) null, 23), 3);
    }

    public void a() {
        synchronized (((o8.f) this.f55d)) {
            try {
                if (this.f52a) {
                    throw new IllegalStateException();
                }
                if (((o8.d) this.f53b).f == this) {
                    ((o8.f) this.f55d).c(this, false);
                }
                this.f52a = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:0|1|(2:3|(4:5|6|7|(4:(1:(1:(1:(1:(4:14|15|16|17)(2:19|20))(4:21|22|16|17)))(4:23|24|16|17))|25|16|17)(5:26|27|(4:29|30|(2:32|(4:34|(1:36)|37|(2:39|(1:41)))(3:43|(1:45)|24))(2:46|(4:48|49|(1:51)(2:66|(1:70))|(4:53|(1:55)|56|(2:58|(1:60))(3:61|(1:63)|22))(1:64)))|42)|16|17)))|73|6|7|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0179, code lost:
    
        if (r2 == r15) goto L71;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x003d, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x017f, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object b(l4.b r23, v6.c r24) {
        /*
            Method dump skipped, instructions count: 389
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.t.b(l4.b, v6.c):java.lang.Object");
    }

    public void c() {
        synchronized (((o8.f) this.f55d)) {
            try {
                if (this.f52a) {
                    throw new IllegalStateException();
                }
                if (((o8.d) this.f53b).f == this) {
                    ((o8.f) this.f55d).c(this, true);
                }
                this.f52a = true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x00e7, code lost:
    
        r7 = r18;
        r3 = true;
        r5 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0024  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00e3 -> B:10:0x00e6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(java.io.File r23, java.lang.Object r24, v6.c r25) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.t.d(java.io.File, java.lang.Object, v6.c):java.lang.Object");
    }

    public void e() {
        o8.d dVar = (o8.d) this.f53b;
        if (dVar.f != this) {
            return;
        }
        int i = 0;
        while (true) {
            o8.f fVar = (o8.f) this.f55d;
            if (i >= fVar.f8362q) {
                dVar.f = null;
                return;
            } else {
                try {
                    fVar.f8355a.a(dVar.f8349d[i]);
                } catch (IOException unused) {
                }
                i++;
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(19:0|1|(2:2|3)|(15:5|6|(1:8)(1:47)|9|10|11|(1:13)|15|(4:37|38|(1:40)(1:42)|41)|17|18|19|(2:21|(5:23|24|(1:26)|27|28)(1:33))|35|(0)(0))|49|6|(0)(0)|9|10|11|(0)|15|(0)|17|18|19|(0)|35|(0)(0)) */
    /* JADX WARN: Can't wrap try/catch for region: R(20:0|1|2|3|(15:5|6|(1:8)(1:47)|9|10|11|(1:13)|15|(4:37|38|(1:40)(1:42)|41)|17|18|19|(2:21|(5:23|24|(1:26)|27|28)(1:33))|35|(0)(0))|49|6|(0)(0)|9|10|11|(0)|15|(0)|17|18|19|(0)|35|(0)(0)) */
    /* JADX WARN: Removed duplicated region for block: B:13:0x005b A[Catch: Exception -> 0x005f, TRY_LEAVE, TryCatch #0 {Exception -> 0x005f, blocks: (B:11:0x0051, B:13:0x005b), top: B:10:0x0051 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x009e A[Catch: Exception -> 0x00a3, TRY_LEAVE, TryCatch #3 {Exception -> 0x00a3, blocks: (B:19:0x0094, B:21:0x009e), top: B:18:0x0094 }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String f(l4.b r10) {
        /*
            r9 = this;
            java.lang.String r0 = "CoreSettings"
            java.lang.Object r1 = r9.f53b
            c4.w4 r1 = (c4.w4) r1
            java.lang.String r2 = "app_name_included"
            r3 = 0
            r4 = 1
            android.content.SharedPreferences r5 = r1.getSharedPreferences(r0, r3)     // Catch: java.lang.Exception -> L19
            boolean r6 = r5.contains(r2)     // Catch: java.lang.Exception -> L19
            if (r6 == 0) goto L19
            boolean r2 = r5.getBoolean(r2, r4)     // Catch: java.lang.Exception -> L19
            goto L1a
        L19:
            r2 = r4
        L1a:
            java.lang.String r5 = ""
            java.lang.String r6 = "[/\\\\:*?\"<>|]"
            if (r2 == 0) goto L38
            java.lang.String r2 = r10.f7101b
            r2.getClass()
            java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6)
            r6.getClass()
            java.util.regex.Matcher r2 = r6.matcher(r2)
            java.lang.String r2 = r2.replaceAll(r5)
            r2.getClass()
            goto L4f
        L38:
            java.lang.String r2 = r10.f7100a
            r2.getClass()
            java.util.regex.Pattern r6 = java.util.regex.Pattern.compile(r6)
            r6.getClass()
            java.util.regex.Matcher r2 = r6.matcher(r2)
            java.lang.String r2 = r2.replaceAll(r5)
            r2.getClass()
        L4f:
            java.lang.String r5 = "versioncode_included"
            android.content.SharedPreferences r6 = r1.getSharedPreferences(r0, r3)     // Catch: java.lang.Exception -> L5f
            boolean r7 = r6.contains(r5)     // Catch: java.lang.Exception -> L5f
            if (r7 == 0) goto L5f
            boolean r4 = r6.getBoolean(r5, r4)     // Catch: java.lang.Exception -> L5f
        L5f:
            java.lang.String r5 = "_"
            r6 = 0
            if (r4 == 0) goto L92
            android.content.pm.PackageManager r4 = r1.getPackageManager()     // Catch: java.lang.Exception -> L72
            r4.getClass()     // Catch: java.lang.Exception -> L72
            java.lang.String r7 = r10.f7100a     // Catch: java.lang.Exception -> L72
            android.content.pm.PackageInfo r4 = n4.i.e(r4, r7, r3)     // Catch: java.lang.Exception -> L72
            goto L77
        L72:
            r4 = move-exception
            r4.printStackTrace()
            r4 = r6
        L77:
            if (r4 == 0) goto L7e
            long r7 = n4.d.d(r4)
            goto L80
        L7e:
            r7 = 0
        L80:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r2)
            r4.append(r5)
            r4.append(r7)
            java.lang.String r2 = r4.toString()
        L92:
            java.lang.String r4 = "versionname_included"
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r0, r3)     // Catch: java.lang.Exception -> La3
            boolean r7 = r0.contains(r4)     // Catch: java.lang.Exception -> La3
            if (r7 == 0) goto La3
            boolean r0 = r0.getBoolean(r4, r3)     // Catch: java.lang.Exception -> La3
            goto La4
        La3:
            r0 = r3
        La4:
            if (r0 == 0) goto Lc1
            android.content.pm.PackageManager r0 = r1.getPackageManager()     // Catch: java.lang.Exception -> Lb4
            r0.getClass()     // Catch: java.lang.Exception -> Lb4
            java.lang.String r10 = r10.f7100a     // Catch: java.lang.Exception -> Lb4
            android.content.pm.PackageInfo r10 = n4.i.e(r0, r10, r3)     // Catch: java.lang.Exception -> Lb4
            goto Lb9
        Lb4:
            r10 = move-exception
            r10.printStackTrace()
            r10 = r6
        Lb9:
            if (r10 == 0) goto Lbd
            java.lang.String r6 = r10.versionName
        Lbd:
            java.lang.String r2 = a4.x.k(r2, r5, r6)
        Lc1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.t.f(l4.b):java.lang.String");
    }

    public OutputStream g(Object obj) {
        if (obj instanceof File) {
            return new FileOutputStream((File) obj);
        }
        if (!(obj instanceof DocumentFile)) {
            throw new Exception("getOutputStream: Illegal parameter type");
        }
        DocumentFile documentFile = (DocumentFile) obj;
        if (documentFile.getName() == null) {
            throw new Exception("getOutputStream: DocumentFile name is null");
        }
        ContentResolver contentResolver = ((w4) this.f53b).getContentResolver();
        OutputStream openOutputStream = contentResolver != null ? contentResolver.openOutputStream(documentFile.getUri()) : null;
        openOutputStream.getClass();
        return openOutputStream;
    }

    public synchronized void h() {
        try {
            if (this.f52a) {
                return;
            }
            Boolean k5 = k();
            this.f54c = k5;
            if (k5 == null) {
                s1.o oVar = new s1.o(28);
                s1.k kVar = (s1.k) ((p2.c) this.f53b);
                kVar.a(kVar.f9139c, oVar);
            }
            this.f52a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean i() {
        Boolean bool;
        try {
            h();
            bool = (Boolean) this.f54c;
        } catch (Throwable th) {
            throw th;
        }
        return bool != null ? bool.booleanValue() : ((FirebaseMessaging) this.f55d).f3085a.h();
    }

    public e0 j(int i) {
        w8.b bVar;
        synchronized (((o8.f) this.f55d)) {
            try {
                if (this.f52a) {
                    throw new IllegalStateException();
                }
                o8.d dVar = (o8.d) this.f53b;
                if (dVar.f != this) {
                    return new w8.e();
                }
                int i6 = 1;
                if (!dVar.f8350e) {
                    ((boolean[]) this.f54c)[i] = true;
                }
                File file = dVar.f8349d[i];
                try {
                    ((o8.f) this.f55d).f8355a.getClass();
                    try {
                        Logger logger = x.f11003a;
                        file.getClass();
                        bVar = new w8.b(i6, new FileOutputStream(file, false), new i0());
                    } catch (FileNotFoundException unused) {
                        file.getParentFile().mkdirs();
                        Logger logger2 = x.f11003a;
                        bVar = new w8.b(i6, new FileOutputStream(file, false), new i0());
                    }
                    return new o8.c(this, bVar, i6);
                } catch (FileNotFoundException unused2) {
                    return new w8.e();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public Boolean k() {
        ApplicationInfo applicationInfo;
        Bundle bundle;
        n1.f fVar = ((FirebaseMessaging) this.f55d).f3085a;
        fVar.a();
        Context context = fVar.f7908a;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.firebase.messaging", 0);
        if (sharedPreferences.contains("auto_init")) {
            return Boolean.valueOf(sharedPreferences.getBoolean("auto_init", false));
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 128)) == null || (bundle = applicationInfo.metaData) == null || !bundle.containsKey("firebase_messaging_auto_init_enabled")) {
                return null;
            }
            return Boolean.valueOf(applicationInfo.metaData.getBoolean("firebase_messaging_auto_init_enabled"));
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    public boolean l(String str, String str2) {
        synchronized (this) {
            try {
                if (!((e) ((AtomicMarkableReference) this.f53b).getReference()).c(str, str2)) {
                    return false;
                }
                AtomicMarkableReference atomicMarkableReference = (AtomicMarkableReference) this.f53b;
                atomicMarkableReference.set((e) atomicMarkableReference.getReference(), true);
                s sVar = new s(this, 0);
                AtomicReference atomicReference = (AtomicReference) this.f54c;
                while (!atomicReference.compareAndSet(null, sVar)) {
                    if (atomicReference.get() != null) {
                        return true;
                    }
                }
                ((z1.e) ((e2.d) this.f55d).f4468m).f11909b.a(sVar);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:0|1|(2:3|(6:5|6|7|(1:(1:(8:11|12|13|14|15|16|17|(4:19|(5:25|15|16|17|(2:32|(3:34|17|(0)(0))(3:35|36|37))(0))|27|(1:30)(6:29|14|15|16|17|(0)(0)))(0))(2:38|39))(2:40|41))(4:43|(3:48|(1:50)(2:59|(2:61|(1:63)(2:64|65))(1:66))|(2:52|(2:54|55)(1:56))(2:57|58))|36|37)|42|(0)(0)))|69|6|7|(0)(0)|42|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x01a7, code lost:
    
        r9 = r11;
        r11 = r18;
        r1 = r20;
        r17 = r26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x005f, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x0235, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:19:0x017b A[Catch: Exception -> 0x005f, TryCatch #0 {Exception -> 0x005f, blocks: (B:12:0x004e, B:16:0x01fa, B:19:0x017b, B:21:0x018e, B:27:0x01a9, B:32:0x020b, B:34:0x013f, B:35:0x0229, B:41:0x007e, B:42:0x0138, B:46:0x008c, B:48:0x0096, B:50:0x00a7, B:52:0x00fc, B:57:0x022d, B:58:0x0234, B:59:0x00d2, B:61:0x00d6, B:63:0x00e0, B:64:0x00f0, B:65:0x00f7), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x020b A[Catch: Exception -> 0x005f, TryCatch #0 {Exception -> 0x005f, blocks: (B:12:0x004e, B:16:0x01fa, B:19:0x017b, B:21:0x018e, B:27:0x01a9, B:32:0x020b, B:34:0x013f, B:35:0x0229, B:41:0x007e, B:42:0x0138, B:46:0x008c, B:48:0x0096, B:50:0x00a7, B:52:0x00fc, B:57:0x022d, B:58:0x0234, B:59:0x00d2, B:61:0x00d6, B:63:0x00e0, B:64:0x00f0, B:65:0x00f7), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x013f A[Catch: Exception -> 0x005f, TryCatch #0 {Exception -> 0x005f, blocks: (B:12:0x004e, B:16:0x01fa, B:19:0x017b, B:21:0x018e, B:27:0x01a9, B:32:0x020b, B:34:0x013f, B:35:0x0229, B:41:0x007e, B:42:0x0138, B:46:0x008c, B:48:0x0096, B:50:0x00a7, B:52:0x00fc, B:57:0x022d, B:58:0x0234, B:59:0x00d2, B:61:0x00d6, B:63:0x00e0, B:64:0x00f0, B:65:0x00f7), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0229 A[Catch: Exception -> 0x005f, TryCatch #0 {Exception -> 0x005f, blocks: (B:12:0x004e, B:16:0x01fa, B:19:0x017b, B:21:0x018e, B:27:0x01a9, B:32:0x020b, B:34:0x013f, B:35:0x0229, B:41:0x007e, B:42:0x0138, B:46:0x008c, B:48:0x0096, B:50:0x00a7, B:52:0x00fc, B:57:0x022d, B:58:0x0234, B:59:0x00d2, B:61:0x00d6, B:63:0x00e0, B:64:0x00f0, B:65:0x00f7), top: B:7:0x002a }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0083  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x01ea -> B:14:0x01f2). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x013f -> B:17:0x0178). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m(java.util.ArrayList r26, java.util.ArrayList r27, java.lang.String r28, long r29, v6.c r31) {
        /*
            Method dump skipped, instructions count: 571
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: a2.t.m(java.util.ArrayList, java.util.ArrayList, java.lang.String, long, v6.c):java.lang.Object");
    }

    public String n() {
        if (!this.f52a) {
            this.f52a = true;
            g1 g1Var = (g1) this.f55d;
            this.f54c = g1Var.k().getString((String) this.f53b, null);
        }
        return (String) this.f54c;
    }

    public void o(String str) {
        SharedPreferences.Editor edit = ((g1) this.f55d).k().edit();
        edit.putString((String) this.f53b, str);
        edit.apply();
        this.f54c = str;
    }

    public t(g1 g1Var, String str) {
        this.f55d = g1Var;
        y.d(str);
        this.f53b = str;
    }

    public t(w4 w4Var, a3.d dVar) {
        this.f53b = w4Var;
        this.f54c = dVar;
    }

    public t(e2.d dVar, boolean z9) {
        this.f55d = dVar;
        this.f54c = new AtomicReference(null);
        this.f52a = z9;
        this.f53b = new AtomicMarkableReference(new e(z9 ? 8192 : 1024), false);
    }

    public t(FirebaseMessaging firebaseMessaging, p2.c cVar) {
        this.f55d = firebaseMessaging;
        this.f53b = cVar;
    }

    public t(o8.f fVar, o8.d dVar) {
        this.f55d = fVar;
        this.f53b = dVar;
        this.f54c = dVar.f8350e ? null : new boolean[fVar.f8362q];
    }
}
