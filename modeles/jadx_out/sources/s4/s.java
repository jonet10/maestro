package s4;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.List;
import x4.g2;
import x4.h2;
import x4.p2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9284a;

    /* renamed from: b, reason: collision with root package name */
    public int f9285b;

    /* renamed from: c, reason: collision with root package name */
    public int f9286c;

    /* renamed from: d, reason: collision with root package name */
    public Object f9287d;

    /* renamed from: e, reason: collision with root package name */
    public Object f9288e;

    public s(Context context, w4.i iVar, LifecycleCoroutineScope lifecycleCoroutineScope) {
        iVar.getClass();
        lifecycleCoroutineScope.getClass();
        this.f9284a = context;
        this.f9287d = iVar;
        this.f9288e = lifecycleCoroutineScope;
        this.f9285b = -1;
        o7.c0.s(lifecycleCoroutineScope, null, null, new p9.c(this, (t6.c) null, 5), 3);
    }

    public static final p2 a(s sVar, x4.j jVar, j5.v vVar, j5.g gVar) {
        String u7;
        int i = 5;
        int i6 = 20;
        if (jVar.f11227m) {
            u7 = androidx.lifecycle.l.u(jVar.f11224a, "floating_category_top_");
        } else {
            boolean z9 = jVar.f11228n;
            int i10 = jVar.f11224a;
            if (z9) {
                u7 = androidx.lifecycle.l.u(i10, "leaf_category_top_");
            } else {
                u7 = androidx.lifecycle.l.u(i10, "category_top_");
                int i11 = jVar.f11224a;
                if (i11 != 521) {
                    if (i11 == 523) {
                        float f = UptodownApp.I;
                        i6 = 8;
                        i = 4;
                    } else if (i11 != 524) {
                        i6 = 12;
                        i = 6;
                    }
                }
                i = 1;
            }
        }
        ArrayList arrayList = new ArrayList();
        h2 X = gVar.X(u7);
        if (X == null || !X.a()) {
            boolean z10 = jVar.f11227m;
            int i12 = jVar.f11224a;
            g2 u9 = z10 ? vVar.u(i12, i6, 0) : vVar.t(i12, i6, 0);
            if (!u9.b() && u9.f11206d != null) {
                arrayList = j5.v.E(u9);
                String str = u9.f11203a;
                str.getClass();
                long currentTimeMillis = System.currentTimeMillis();
                gVar.r(u7);
                ContentValues contentValues = new ContentValues();
                contentValues.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, u7);
                contentValues.put("json", str);
                contentValues.put("timestamp", String.valueOf(currentTimeMillis));
                SQLiteDatabase sQLiteDatabase = gVar.f6673a;
                sQLiteDatabase.getClass();
                sQLiteDatabase.insert("responses", null, contentValues);
            }
        } else {
            arrayList = j5.v.E(X.c());
        }
        p2 p2Var = new p2(jVar, arrayList, 4);
        p2Var.f11331c = i;
        return p2Var;
    }

    public static String d(n1.f fVar) {
        fVar.a();
        n1.h hVar = fVar.f7910c;
        String str = hVar.f7922e;
        if (str != null) {
            return str;
        }
        fVar.a();
        String str2 = hVar.f7919b;
        if (!str2.startsWith("1:")) {
            return str2;
        }
        String[] split = str2.split(":");
        if (split.length < 2) {
            return null;
        }
        String str3 = split[1];
        if (str3.isEmpty()) {
            return null;
        }
        return str3;
    }

    public synchronized String b() {
        try {
            if (((String) this.f9287d) == null) {
                g();
            }
        } catch (Throwable th) {
            throw th;
        }
        return (String) this.f9287d;
    }

    public synchronized String c() {
        try {
            if (((String) this.f9288e) == null) {
                g();
            }
        } catch (Throwable th) {
            throw th;
        }
        return (String) this.f9288e;
    }

    public PackageInfo e(String str) {
        try {
            return this.f9284a.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException e10) {
            Log.w("FirebaseMessaging", "Failed to find package " + e10);
            return null;
        }
    }

    public boolean f() {
        int i;
        synchronized (this) {
            i = this.f9286c;
            if (i == 0) {
                PackageManager packageManager = this.f9284a.getPackageManager();
                if (packageManager.checkPermission("com.google.android.c2dm.permission.SEND", "com.google.android.gms") == -1) {
                    Log.e("FirebaseMessaging", "Google Play services missing or without correct permission.");
                    i = 0;
                } else {
                    if (!p0.b.a()) {
                        Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
                        intent.setPackage("com.google.android.gms");
                        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
                        if (queryIntentServices != null && queryIntentServices.size() > 0) {
                            this.f9286c = 1;
                            i = 1;
                        }
                    }
                    Intent intent2 = new Intent("com.google.iid.TOKEN_REQUEST");
                    intent2.setPackage("com.google.android.gms");
                    List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent2, 0);
                    if (queryBroadcastReceivers == null || queryBroadcastReceivers.size() <= 0) {
                        Log.w("FirebaseMessaging", "Failed to resolve IID implementation package, falling back");
                        if (p0.b.a()) {
                            this.f9286c = 2;
                        } else {
                            this.f9286c = 1;
                        }
                        i = this.f9286c;
                    } else {
                        this.f9286c = 2;
                        i = 2;
                    }
                }
            }
        }
        return i != 0;
    }

    public synchronized void g() {
        PackageInfo e10 = e(this.f9284a.getPackageName());
        if (e10 != null) {
            this.f9287d = Integer.toString(e10.versionCode);
            this.f9288e = e10.versionName;
        }
    }

    public s(Context context) {
        this.f9286c = 0;
        this.f9284a = context;
    }
}
