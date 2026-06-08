package q1;

import a4.d0;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import androidx.work.WorkRequest;
import androidx.work.multiprocess.RemoteWorkManager;
import b2.t1;
import com.google.android.gms.internal.measurement.z3;
import com.google.firebase.analytics.connector.internal.AnalyticsConnectorRegistrar;
import e1.p2;
import j$.util.DesugarCollections;
import j1.h;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executors;
import l7.u;
import org.json.JSONObject;
import s1.d;
import t0.e;
import w4.p;
import w8.k;
import w8.y;
import x4.d2;
import x4.k2;
import x8.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements d, t.b, t0.c, t5.b, p, w1.a, w7.a, h {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ a f8633b = new a(0);

    /* renamed from: l, reason: collision with root package name */
    public static a f8634l;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8635a;

    public /* synthetic */ a(int i) {
        this.f8635a = i;
    }

    public static final boolean f(y yVar) {
        y yVar2 = f.f11557c;
        return !u.k0(yVar.b(), ".class", true);
    }

    public static d2 g(JSONObject jSONObject) {
        d2 d2Var = new d2();
        if (!jSONObject.isNull("id")) {
            d2Var.f11107a = jSONObject.optLong("id");
        }
        if (!jSONObject.isNull("userName")) {
            d2Var.f11108b = jSONObject.optString("userName");
            if (!jSONObject.isNull("userAvatar")) {
                d2Var.f11110m = jSONObject.optString("userAvatar");
            }
            if (!jSONObject.isNull("userID")) {
                d2Var.f11109l = jSONObject.optString("userID");
            }
        }
        if (!jSONObject.isNull("text")) {
            d2Var.f11112o = jSONObject.optString("text");
        }
        if (!jSONObject.isNull("timeAgo")) {
            d2Var.f11113p = jSONObject.optString("timeAgo");
        }
        if (!jSONObject.isNull("likes")) {
            d2Var.f11114q = jSONObject.optInt("likes");
        }
        if (!jSONObject.isNull("isAuthorVerified")) {
            d2Var.f11115r = jSONObject.optInt("isAuthorVerified");
        }
        if (!jSONObject.isNull("isTurbo")) {
            d2Var.f11116s = jSONObject.optInt("isTurbo");
        }
        if (!jSONObject.isNull("usernameFormat")) {
            d2Var.f11117t = jSONObject.optString("usernameFormat");
        }
        if (!jSONObject.isNull("following")) {
            d2Var.f11118u = jSONObject.optInt("following");
        }
        return d2Var;
    }

    public static k2 h(JSONObject jSONObject) {
        k2 k2Var = new k2();
        if (!jSONObject.isNull("id")) {
            k2Var.f11258a = jSONObject.optLong("id");
        }
        if (!jSONObject.isNull("userID")) {
            k2Var.f11259b = jSONObject.optString("userID");
            if (!jSONObject.isNull("userName")) {
                k2Var.f11260l = jSONObject.optString("userName");
            }
            if (!jSONObject.isNull("userAvatar")) {
                k2Var.f11261m = jSONObject.optString("userAvatar");
            }
        }
        if (!jSONObject.isNull("text")) {
            k2Var.f11263o = jSONObject.optString("text");
        }
        if (!jSONObject.isNull("rating")) {
            k2Var.f11264p = jSONObject.optInt("rating");
        }
        if (!jSONObject.isNull("totalAnswers")) {
            k2Var.f11265q = jSONObject.optInt("totalAnswers");
        }
        if (!jSONObject.isNull("timeAgo")) {
            k2Var.f11266r = jSONObject.optString("timeAgo");
        }
        if (!jSONObject.isNull("likes")) {
            k2Var.f11267s = jSONObject.optInt("likes");
        }
        if (!jSONObject.isNull("isAuthorVerified")) {
            k2Var.f11268t = jSONObject.optInt("isAuthorVerified");
        }
        if (!jSONObject.isNull("isTurbo")) {
            k2Var.v = jSONObject.optInt("isTurbo");
        }
        if (!jSONObject.isNull("usernameFormat")) {
            k2Var.f11270w = jSONObject.optString("usernameFormat");
        }
        if (!jSONObject.isNull("following")) {
            k2Var.f11271x = jSONObject.optInt("following");
        }
        return k2Var;
    }

    public static y j(String str, boolean z9) {
        str.getClass();
        k kVar = x8.c.f11547a;
        w8.h hVar = new w8.h();
        hVar.G(str);
        return x8.c.d(hVar, z9);
    }

    public static boolean k(Context context, String str) {
        String y9 = z3.y(context, "last_review_text");
        String y10 = z3.y(context, "last_review_timestamp");
        if (y10 == null) {
            y10 = "0";
        }
        return str != null && str.equalsIgnoreCase(y9) && System.currentTimeMillis() - Long.parseLong(y10) < RemoteWorkManager.DEFAULT_SESSION_TIMEOUT_MILLIS;
    }

    public static void o(Context context, String str, String str2) {
        if (str != null && str.length() != 0) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
            sharedPreferences.getClass();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("last_review_text", str);
            edit.apply();
        }
        if (str2 == null || str2.length() == 0) {
            return;
        }
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("SettingsPreferences", 0);
        sharedPreferences2.getClass();
        SharedPreferences.Editor edit2 = sharedPreferences2.edit();
        edit2.putString("last_review_timestamp", str2);
        edit2.apply();
    }

    public static k2 r(JSONObject jSONObject) {
        k2 k2Var = new k2();
        if (!jSONObject.isNull("id")) {
            k2Var.f11258a = jSONObject.optLong("id");
        }
        if (!jSONObject.isNull("appName")) {
            k2Var.f11269u = jSONObject.optString("appName");
        }
        if (!jSONObject.isNull("appID")) {
            k2Var.f11262n = jSONObject.optLong("appID");
        }
        if (!jSONObject.isNull("appIcon")) {
            k2Var.f11261m = jSONObject.optString("appIcon");
        }
        if (!jSONObject.isNull("text")) {
            k2Var.f11263o = jSONObject.optString("text");
        }
        if (!jSONObject.isNull("rate")) {
            k2Var.f11264p = jSONObject.optInt("rate");
        }
        if (!jSONObject.isNull("publishedDate")) {
            k2Var.f11266r = jSONObject.optString("publishedDate");
        }
        if (!jSONObject.isNull("likes")) {
            k2Var.f11267s = jSONObject.optInt("likes");
        }
        if (!jSONObject.isNull("isTurbo")) {
            k2Var.v = jSONObject.optInt("isTurbo");
        }
        if (!jSONObject.isNull("usernameFormat")) {
            k2Var.f11270w = jSONObject.optString("usernameFormat");
        }
        if (!jSONObject.isNull("totalAnswers")) {
            k2Var.f11265q = jSONObject.optInt("totalAnswers");
        }
        return k2Var;
    }

    @Override // t0.c
    public int a(Context context, String str, boolean z9) {
        return e.d(context, str, z9);
    }

    @Override // t0.c
    public int b(Context context, String str) {
        return e.a(context, str);
    }

    @Override // s1.d
    public /* synthetic */ Object c(d0 d0Var) {
        p1.a lambda$getComponents$0;
        lambda$getComponents$0 = AnalyticsConnectorRegistrar.lambda$getComponents$0(d0Var);
        return lambda$getComponents$0;
    }

    @Override // t5.b
    public boolean draw(Canvas canvas) {
        return true;
    }

    @Override // m6.a
    public Object get() {
        int i = 2;
        switch (this.f8635a) {
            case 1:
                return new p2(Executors.newSingleThreadExecutor(), 2);
            default:
                q2.e eVar = new q2.e(i);
                HashMap hashMap = new HashMap();
                Set set = Collections.EMPTY_SET;
                if (set == null) {
                    com.google.gson.internal.a.i("Null flags");
                    return null;
                }
                hashMap.put(o.d.f8126a, new x.b(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS, 86400000L, set));
                if (set == null) {
                    com.google.gson.internal.a.i("Null flags");
                    return null;
                }
                hashMap.put(o.d.f8128l, new x.b(1000L, 86400000L, set));
                if (set == null) {
                    com.google.gson.internal.a.i("Null flags");
                    return null;
                }
                Set unmodifiableSet = DesugarCollections.unmodifiableSet(new HashSet(Arrays.asList(x.c.f11015b)));
                if (unmodifiableSet == null) {
                    com.google.gson.internal.a.i("Null flags");
                    return null;
                }
                hashMap.put(o.d.f8127b, new x.b(86400000L, 86400000L, unmodifiableSet));
                if (hashMap.keySet().size() >= o.d.values().length) {
                    new HashMap();
                    return new x.a(eVar, hashMap);
                }
                androidx.privacysandbox.ads.adservices.customaudience.a.i("Not all priorities have been configured");
                return null;
        }
    }

    @Override // w1.a
    public void i(Bundle bundle) {
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Skipping logging Crashlytics event to Firebase, no Firebase Analytics", null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object m(x4.d2 r11, android.content.Context r12, v6.c r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof x4.b2
            if (r0 == 0) goto L13
            r0 = r13
            x4.b2 r0 = (x4.b2) r0
            int r1 = r0.f11064o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f11064o = r1
            goto L18
        L13:
            x4.b2 r0 = new x4.b2
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f11062m
            int r1 = r0.f11064o
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2d
            kotlin.jvm.internal.v r11 = r0.f11061l
            kotlin.jvm.internal.v r12 = r0.f11060b
            x4.d2 r0 = r0.f11059a
            p6.a.e(r13)
            r6 = r11
            r11 = r0
            goto L6d
        L2d:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r11)
            r11 = 0
            return r11
        L34:
            p6.a.e(r13)
            long r3 = r11.f11107a
            java.util.ArrayList r13 = j5.t.f6710c
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r13.add(r1)
            kotlin.jvm.internal.v r7 = new kotlin.jvm.internal.v
            r7.<init>()
            kotlin.jvm.internal.v r6 = new kotlin.jvm.internal.v
            r6.<init>()
            v7.e r13 = o7.m0.f8288a
            v7.d r13 = v7.d.f10884a
            c4.w r3 = new c4.w
            r8 = 0
            r9 = 14
            r5 = r11
            r4 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r0.f11059a = r5
            r0.f11060b = r7
            r0.f11061l = r6
            r0.f11064o = r2
            java.lang.Object r11 = o7.c0.C(r3, r13, r0)
            u6.a r12 = u6.a.f10762a
            if (r11 != r12) goto L6b
            return r12
        L6b:
            r11 = r5
            r12 = r7
        L6d:
            x4.c2 r13 = new x4.c2
            int r12 = r12.f7022a
            int r0 = r6.f7022a
            r13.<init>(r11, r12, r0)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.a.m(x4.d2, android.content.Context, v6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object n(x4.k2 r11, android.content.Context r12, v6.c r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof x4.i2
            if (r0 == 0) goto L13
            r0 = r13
            x4.i2 r0 = (x4.i2) r0
            int r1 = r0.f11223o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f11223o = r1
            goto L18
        L13:
            x4.i2 r0 = new x4.i2
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f11221m
            int r1 = r0.f11223o
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2d
            kotlin.jvm.internal.v r11 = r0.f11220l
            kotlin.jvm.internal.v r12 = r0.f11219b
            x4.k2 r0 = r0.f11218a
            p6.a.e(r13)
            r6 = r11
            r11 = r0
            goto L6d
        L2d:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r11)
            r11 = 0
            return r11
        L34:
            p6.a.e(r13)
            long r3 = r11.f11258a
            java.util.ArrayList r13 = j5.t.f6709b
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r13.add(r1)
            kotlin.jvm.internal.v r7 = new kotlin.jvm.internal.v
            r7.<init>()
            kotlin.jvm.internal.v r6 = new kotlin.jvm.internal.v
            r6.<init>()
            v7.e r13 = o7.m0.f8288a
            v7.d r13 = v7.d.f10884a
            c4.w r3 = new c4.w
            r8 = 0
            r9 = 15
            r5 = r11
            r4 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r0.f11218a = r5
            r0.f11219b = r7
            r0.f11220l = r6
            r0.f11223o = r2
            java.lang.Object r11 = o7.c0.C(r3, r13, r0)
            u6.a r12 = u6.a.f10762a
            if (r11 != r12) goto L6b
            return r12
        L6b:
            r11 = r5
            r12 = r7
        L6d:
            x4.j2 r13 = new x4.j2
            int r12 = r12.f7022a
            int r0 = r6.f7022a
            r13.<init>(r11, r12, r0)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: q1.a.n(x4.k2, android.content.Context, v6.c):java.lang.Object");
    }

    public t0.d p(Context context, String str, t0.c cVar) {
        int a8;
        switch (this.f8635a) {
            case 4:
                t0.d dVar = new t0.d();
                int b7 = cVar.b(context, str);
                dVar.f9486a = b7;
                if (b7 != 0) {
                    dVar.f9488c = -1;
                } else {
                    int a10 = cVar.a(context, str, true);
                    dVar.f9487b = a10;
                    if (a10 != 0) {
                        dVar.f9488c = 1;
                    }
                }
                return dVar;
            case 5:
                t0.d dVar2 = new t0.d();
                dVar2.f9486a = cVar.b(context, str);
                int i = 1;
                int a11 = cVar.a(context, str, true);
                dVar2.f9487b = a11;
                int i6 = dVar2.f9486a;
                if (i6 == 0) {
                    i6 = 0;
                    if (a11 == 0) {
                        i = 0;
                        dVar2.f9488c = i;
                        return dVar2;
                    }
                }
                if (i6 >= a11) {
                    i = -1;
                }
                dVar2.f9488c = i;
                return dVar2;
            default:
                t0.d dVar3 = new t0.d();
                int b10 = cVar.b(context, str);
                dVar3.f9486a = b10;
                int i10 = 1;
                int i11 = 0;
                if (b10 != 0) {
                    a8 = cVar.a(context, str, false);
                    dVar3.f9487b = a8;
                } else {
                    a8 = cVar.a(context, str, true);
                    dVar3.f9487b = a8;
                }
                int i12 = dVar3.f9486a;
                if (i12 != 0) {
                    i11 = i12;
                } else if (a8 == 0) {
                    i10 = 0;
                    dVar3.f9488c = i10;
                    return dVar3;
                }
                if (i11 >= a8) {
                    i10 = -1;
                }
                dVar3.f9488c = i10;
                return dVar3;
        }
    }

    @Override // j1.h
    public j1.p q(Object obj) {
        return t1.x(Boolean.TRUE);
    }

    @Override // t5.b
    public void destroy() {
    }

    @Override // t5.b
    public void e() {
    }

    @Override // w4.p
    public void l() {
    }

    @Override // t5.b
    public t5.b d(boolean z9) {
        return this;
    }
}
