package x4;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.work.WorkManager;
import c4.a6;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.internal.measurement.i5;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u2 {
    public static w2 a(JSONObject jSONObject) {
        w2 w2Var = new w2();
        if (!jSONObject.isNull("userID")) {
            w2Var.f11431a = jSONObject.optString("userID");
        }
        if (!jSONObject.isNull("username")) {
            w2Var.f11434m = jSONObject.optString("username");
        }
        if (!jSONObject.isNull("avatarURL")) {
            w2Var.f11433l = jSONObject.optString("avatarURL");
        }
        if (!jSONObject.isNull("isTurbo")) {
            w2Var.f11443w = jSONObject.optInt("isTurbo") == 1;
        }
        if (!jSONObject.isNull("usernameFormat")) {
            w2Var.f11436o = jSONObject.optString("usernameFormat");
        }
        if (!jSONObject.isNull("isAuthorVerified")) {
            w2Var.f11444x = jSONObject.optInt("isAuthorVerified") == 1;
        }
        if (!jSONObject.isNull("following")) {
            w2Var.f11439r = jSONObject.optInt("following");
        }
        return w2Var;
    }

    public static void b(Context context) {
        context.getClass();
        c(context);
        SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
        sharedPreferences.getClass();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("UTOKEN", null);
        edit.apply();
        float f = UptodownApp.I;
        if (b4.d.p(context, "PreRegisterWorker")) {
            WorkManager.Companion.getInstance(context).cancelAllWorkByTag("PreRegisterWorker");
        }
        if (b4.d.p(context, "GetUserDataWorker")) {
            WorkManager.Companion.getInstance(context).cancelAllWorkByTag("GetUserDataWorker");
        }
        UptodownApp.f3291e0 = false;
        j5.g l10 = j5.g.D.l(context);
        l10.b();
        SQLiteDatabase sQLiteDatabase = l10.f6673a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.delete("preregistrations", null, null);
        l10.c();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.f2439t;
        new HashSet();
        new HashMap();
        k0.y.g(googleSignInOptions);
        HashSet hashSet = new HashSet(googleSignInOptions.f2445b);
        boolean z9 = googleSignInOptions.f2448n;
        boolean z10 = googleSignInOptions.f2449o;
        String str = googleSignInOptions.f2450p;
        Account account = googleSignInOptions.f2446l;
        String str2 = googleSignInOptions.f2451q;
        HashMap d10 = GoogleSignInOptions.d(googleSignInOptions.f2452r);
        String str3 = googleSignInOptions.f2453s;
        hashSet.add(GoogleSignInOptions.f2440u);
        k0.y.d("699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com");
        k0.y.a("two different server client ids provided", str == null || str.equals("699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com"));
        if (hashSet.contains(GoogleSignInOptions.f2442x)) {
            Scope scope = GoogleSignInOptions.f2441w;
            if (hashSet.contains(scope)) {
                hashSet.remove(scope);
            }
        }
        if (account == null || !hashSet.isEmpty()) {
            hashSet.add(GoogleSignInOptions.v);
        }
        i5.w(context, new GoogleSignInOptions(3, new ArrayList(hashSet), account, true, z9, z10, "699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com", str2, d10, str3)).c();
    }

    public static void c(Context context) {
        context.getClass();
        SharedPreferences.Editor edit = context.getSharedPreferences("SharedPreferencesUser", 0).edit();
        edit.remove("user_id");
        edit.remove("user_email");
        edit.remove("user_name");
        edit.remove("user_picture");
        edit.remove("registered_timestamp");
        edit.remove("is_turbo");
        edit.remove("username_format");
        edit.remove("background_image");
        edit.remove("has_news_on_feed");
        edit.apply();
        SharedPreferences sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
        sharedPreferences.getClass();
        SharedPreferences.Editor edit2 = sharedPreferences.edit();
        edit2.putBoolean("welcome_popup_shown", false);
        edit2.apply();
    }

    public static String e(String str) {
        if (str != null) {
            return a4.x.k(str, UptodownApp.K, ":webp");
        }
        return null;
    }

    public static ArrayList f(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        try {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                optJSONObject.getClass();
                arrayList.add(a(optJSONObject));
            }
            return arrayList;
        } catch (Exception e10) {
            e10.printStackTrace();
            return arrayList;
        }
    }

    public static boolean g(Context context) {
        String str;
        SharedPreferences sharedPreferences;
        context.getClass();
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("SharedPreferencesUser", 0);
        try {
            sharedPreferences = context.getSharedPreferences("SettingsPreferences", 0);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        if (sharedPreferences.contains("UTOKEN")) {
            str = sharedPreferences.getString("UTOKEN", null);
            return (str == null && sharedPreferences2.getString("is_turbo", null) == null) ? false : true;
        }
        str = null;
        if (str == null) {
            return true;
        }
    }

    public static w2 h(Context context) {
        w2 w2Var;
        context.getClass();
        SharedPreferences sharedPreferences = context.getSharedPreferences("SharedPreferencesUser", 0);
        if (sharedPreferences.contains("user_id")) {
            w2Var = new w2();
            w2Var.f11431a = sharedPreferences.getString("user_id", null);
        } else {
            w2Var = null;
        }
        if (sharedPreferences.contains("user_email")) {
            if (w2Var == null) {
                w2Var = new w2();
            }
            w2Var.f11432b = sharedPreferences.getString("user_email", null);
        }
        if (sharedPreferences.contains("user_name")) {
            if (w2Var == null) {
                w2Var = new w2();
            }
            w2Var.f11434m = sharedPreferences.getString("user_name", null);
        }
        if (w2Var != null) {
            if (sharedPreferences.contains("user_picture")) {
                w2Var.f11433l = sharedPreferences.getString("user_picture", null);
            }
            if (sharedPreferences.contains("registered_timestamp")) {
                w2Var.f11435n = sharedPreferences.getLong("registered_timestamp", -1L);
            }
            if (sharedPreferences.contains("is_turbo")) {
                w2Var.v = sharedPreferences.getString("is_turbo", null);
            }
            if (sharedPreferences.contains("username_format")) {
                w2Var.f11436o = sharedPreferences.getString("username_format", "type0");
            }
            if (sharedPreferences.contains("background_image")) {
                w2Var.f11437p = sharedPreferences.getString("background_image", null);
            }
            if (sharedPreferences.contains("has_news_on_feed")) {
                w2Var.f11445y = sharedPreferences.getBoolean("has_news_on_feed", false);
            }
        }
        return w2Var;
    }

    public static void i(Context context, LifecycleCoroutineScope lifecycleCoroutineScope) {
        lifecycleCoroutineScope.getClass();
        float f = UptodownApp.I;
        b4.d.A(context);
        b4.d.z(context);
        v7.e eVar = o7.m0.f8288a;
        o7.c0.s(lifecycleCoroutineScope, v7.d.f10884a, null, new a6(context, (t6.c) null, 2), 2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d(android.content.Context r11, java.lang.String r12, v6.c r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof x4.r2
            if (r0 == 0) goto L13
            r0 = r13
            x4.r2 r0 = (x4.r2) r0
            int r1 = r0.f11381o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f11381o = r1
            goto L18
        L13:
            x4.r2 r0 = new x4.r2
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f11379m
            int r1 = r0.f11381o
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2d
            kotlin.jvm.internal.v r11 = r0.f11378l
            kotlin.jvm.internal.v r12 = r0.f11377b
            java.lang.String r0 = r0.f11376a
            p6.a.e(r13)
            r7 = r12
            r12 = r0
            goto L61
        L2d:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r11)
            r11 = 0
            return r11
        L34:
            p6.a.e(r13)
            kotlin.jvm.internal.v r7 = new kotlin.jvm.internal.v
            r7.<init>()
            kotlin.jvm.internal.v r6 = new kotlin.jvm.internal.v
            r6.<init>()
            v7.e r13 = o7.m0.f8288a
            v7.d r13 = v7.d.f10884a
            x4.s2 r3 = new x4.s2
            r8 = 0
            r9 = 0
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r0.f11376a = r5
            r0.f11377b = r7
            r0.f11378l = r6
            r0.f11381o = r2
            java.lang.Object r11 = o7.c0.C(r3, r13, r0)
            u6.a r12 = u6.a.f10762a
            if (r11 != r12) goto L5f
            return r12
        L5f:
            r12 = r5
            r11 = r6
        L61:
            x4.v2 r13 = new x4.v2
            int r0 = r7.f7022a
            int r11 = r11.f7022a
            r13.<init>(r12, r0, r11, r2)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.u2.d(android.content.Context, java.lang.String, v6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object j(android.content.Context r11, java.lang.String r12, v6.c r13) {
        /*
            r10 = this;
            boolean r0 = r13 instanceof x4.t2
            if (r0 == 0) goto L13
            r0 = r13
            x4.t2 r0 = (x4.t2) r0
            int r1 = r0.f11410o
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f11410o = r1
            goto L18
        L13:
            x4.t2 r0 = new x4.t2
            r0.<init>(r10, r13)
        L18:
            java.lang.Object r13 = r0.f11408m
            int r1 = r0.f11410o
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2d
            kotlin.jvm.internal.v r11 = r0.f11407l
            kotlin.jvm.internal.v r12 = r0.f11406b
            java.lang.String r0 = r0.f11405a
            p6.a.e(r13)
            r7 = r12
            r12 = r0
            goto L61
        L2d:
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r11)
            r11 = 0
            return r11
        L34:
            p6.a.e(r13)
            kotlin.jvm.internal.v r7 = new kotlin.jvm.internal.v
            r7.<init>()
            kotlin.jvm.internal.v r6 = new kotlin.jvm.internal.v
            r6.<init>()
            v7.e r13 = o7.m0.f8288a
            v7.d r13 = v7.d.f10884a
            x4.s2 r3 = new x4.s2
            r8 = 0
            r9 = 1
            r4 = r11
            r5 = r12
            r3.<init>(r4, r5, r6, r7, r8, r9)
            r0.f11405a = r5
            r0.f11406b = r7
            r0.f11407l = r6
            r0.f11410o = r2
            java.lang.Object r11 = o7.c0.C(r3, r13, r0)
            u6.a r12 = u6.a.f10762a
            if (r11 != r12) goto L5f
            return r12
        L5f:
            r12 = r5
            r11 = r6
        L61:
            x4.v2 r13 = new x4.v2
            int r0 = r7.f7022a
            int r11 = r11.f7022a
            r1 = 0
            r13.<init>(r12, r0, r11, r1)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.u2.j(android.content.Context, java.lang.String, v6.c):java.lang.Object");
    }
}
