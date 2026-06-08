package y1;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import j$.util.Objects;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Pattern;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x {
    public static final Pattern g = Pattern.compile("[^\\p{Alnum}]");
    public static final String h = Pattern.quote("/");

    /* renamed from: a, reason: collision with root package name */
    public final g2.a f11689a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f11690b;

    /* renamed from: c, reason: collision with root package name */
    public final String f11691c;

    /* renamed from: d, reason: collision with root package name */
    public final t2.d f11692d;

    /* renamed from: e, reason: collision with root package name */
    public final t f11693e;
    public c f;

    public x(Context context, String str, t2.d dVar, t tVar) {
        if (context == null) {
            com.google.gson.internal.a.p("appContext must not be null");
            throw null;
        }
        if (str == null) {
            com.google.gson.internal.a.p("appIdentifier must not be null");
            throw null;
        }
        this.f11690b = context;
        this.f11691c = str;
        this.f11692d = dVar;
        this.f11693e = tVar;
        this.f11689a = new g2.a();
    }

    public final synchronized String a(SharedPreferences sharedPreferences, String str) {
        String lowerCase;
        lowerCase = g.matcher(UUID.randomUUID().toString()).replaceAll("").toLowerCase(Locale.US);
        String str2 = "Created new Crashlytics installation ID: " + lowerCase + " for FID: " + str;
        if (Log.isLoggable("FirebaseCrashlytics", 2)) {
            Log.v("FirebaseCrashlytics", str2, null);
        }
        sharedPreferences.edit().putString("crashlytics.installation.id", lowerCase).putString("firebase.installation.id", str).apply();
        return lowerCase;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:0|1|(2:3|(1:5))|6|(7:18|19|9|10|11|12|13)|8|9|10|11|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0072, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0073, code lost:
    
        android.util.Log.w("FirebaseCrashlytics", "Error getting Firebase installation id.", r0);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final y1.w b(boolean r9) {
        /*
            r8 = this;
            z1.c r0 = new z1.c
            r6 = 0
            r7 = 2
            r1 = 0
            z1.d r2 = z1.e.f11907d
            java.lang.Class<z1.d> r3 = z1.d.class
            java.lang.String r4 = "isNotMainThread"
            java.lang.String r5 = "isNotMainThread()Z"
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            java.lang.Object r0 = r0.invoke()
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 0
            java.lang.String r2 = "FirebaseCrashlytics"
            if (r0 != 0) goto L44
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r3 = "Must not be called on a main thread, was called on "
            r0.<init>(r3)
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.String r3 = r3.getName()
            r0.append(r3)
            r3 = 46
            r0.append(r3)
            java.lang.String r0 = r0.toString()
            r3 = 3
            boolean r3 = android.util.Log.isLoggable(r2, r3)
            if (r3 == 0) goto L44
            android.util.Log.d(r2, r0, r1)
        L44:
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS
            r4 = 10000(0x2710, double:4.9407E-320)
            t2.d r6 = r8.f11692d
            if (r9 == 0) goto L63
            r9 = r6
            t2.c r9 = (t2.c) r9     // Catch: java.lang.Exception -> L5c
            j1.p r9 = r9.e()     // Catch: java.lang.Exception -> L5c
            java.lang.Object r9 = b2.t1.k(r9, r4, r3)     // Catch: java.lang.Exception -> L5c
            t2.a r9 = (t2.a) r9     // Catch: java.lang.Exception -> L5c
            java.lang.String r9 = r9.f9536a     // Catch: java.lang.Exception -> L5c
            goto L64
        L5c:
            r0 = move-exception
            r9 = r0
            java.lang.String r0 = "Error getting Firebase authentication token."
            android.util.Log.w(r2, r0, r9)
        L63:
            r9 = r1
        L64:
            t2.c r6 = (t2.c) r6     // Catch: java.lang.Exception -> L72
            j1.p r0 = r6.d()     // Catch: java.lang.Exception -> L72
            java.lang.Object r0 = b2.t1.k(r0, r4, r3)     // Catch: java.lang.Exception -> L72
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Exception -> L72
            r1 = r0
            goto L78
        L72:
            r0 = move-exception
            java.lang.String r3 = "Error getting Firebase installation id."
            android.util.Log.w(r2, r3, r0)
        L78:
            y1.w r0 = new y1.w
            r0.<init>(r1, r9)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: y1.x.b(boolean):y1.w");
    }

    public final synchronized c c() {
        String str;
        c cVar = this.f;
        if (cVar != null && (cVar.f11608b != null || !this.f11693e.a())) {
            return this.f;
        }
        v1.c cVar2 = v1.c.f10791a;
        cVar2.c("Determining Crashlytics installation ID...");
        SharedPreferences sharedPreferences = this.f11690b.getSharedPreferences("com.google.firebase.crashlytics", 0);
        String string = sharedPreferences.getString("firebase.installation.id", null);
        cVar2.c("Cached Firebase Installation ID: " + string);
        if (this.f11693e.a()) {
            w b7 = b(false);
            cVar2.c("Fetched Firebase Installation ID: " + b7.f11687a);
            if (b7.f11687a == null) {
                if (string == null) {
                    str = "SYN_" + UUID.randomUUID().toString();
                } else {
                    str = string;
                }
                b7 = new w(str, null);
            }
            if (Objects.equals(b7.f11687a, string)) {
                this.f = new c(sharedPreferences.getString("crashlytics.installation.id", null), b7.f11687a, b7.f11688b);
            } else {
                this.f = new c(a(sharedPreferences, b7.f11687a), b7.f11687a, b7.f11688b);
            }
        } else if (string == null || !string.startsWith("SYN_")) {
            this.f = new c(a(sharedPreferences, "SYN_" + UUID.randomUUID().toString()), null, null);
        } else {
            this.f = new c(sharedPreferences.getString("crashlytics.installation.id", null), null, null);
        }
        cVar2.c("Install IDs: " + this.f);
        return this.f;
    }

    public final String d() {
        String str;
        g2.a aVar = this.f11689a;
        Context context = this.f11690b;
        synchronized (aVar) {
            try {
                if (aVar.f5107a == null) {
                    String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                    if (installerPackageName == null) {
                        installerPackageName = "";
                    }
                    aVar.f5107a = installerPackageName;
                }
                str = "".equals(aVar.f5107a) ? null : aVar.f5107a;
            } finally {
            }
        }
        return str;
    }
}
