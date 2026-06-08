package f0;

import a4.x;
import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import k0.y;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: c, reason: collision with root package name */
    public static final ReentrantLock f4797c = new ReentrantLock();

    /* renamed from: d, reason: collision with root package name */
    public static b f4798d;

    /* renamed from: a, reason: collision with root package name */
    public final ReentrantLock f4799a = new ReentrantLock();

    /* renamed from: b, reason: collision with root package name */
    public final SharedPreferences f4800b;

    public b(Context context) {
        this.f4800b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    public static b a(Context context) {
        y.g(context);
        ReentrantLock reentrantLock = f4797c;
        reentrantLock.lock();
        try {
            if (f4798d == null) {
                f4798d = new b(context.getApplicationContext());
            }
            b bVar = f4798d;
            reentrantLock.unlock();
            return bVar;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public static final String f(String str, String str2) {
        return x.k(str, ":", str2);
    }

    public final GoogleSignInAccount b() {
        String d10;
        String d11 = d("defaultGoogleSignInAccount");
        if (!TextUtils.isEmpty(d11) && (d10 = d(f("googleSignInAccount", d11))) != null) {
            try {
                return GoogleSignInAccount.c(d10);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    public final void c(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        y.g(googleSignInAccount);
        y.g(googleSignInOptions);
        String str = googleSignInAccount.f2435r;
        e("defaultGoogleSignInAccount", str);
        String f = f("googleSignInAccount", str);
        JSONObject jSONObject = new JSONObject();
        try {
            String str2 = googleSignInAccount.f2428b;
            if (str2 != null) {
                jSONObject.put("id", str2);
            }
            String str3 = googleSignInAccount.f2429l;
            if (str3 != null) {
                jSONObject.put("tokenId", str3);
            }
            String str4 = googleSignInAccount.f2430m;
            if (str4 != null) {
                jSONObject.put(NotificationCompat.CATEGORY_EMAIL, str4);
            }
            String str5 = googleSignInAccount.f2431n;
            if (str5 != null) {
                jSONObject.put("displayName", str5);
            }
            String str6 = googleSignInAccount.f2437t;
            if (str6 != null) {
                jSONObject.put("givenName", str6);
            }
            String str7 = googleSignInAccount.f2438u;
            if (str7 != null) {
                jSONObject.put("familyName", str7);
            }
            Uri uri = googleSignInAccount.f2432o;
            if (uri != null) {
                jSONObject.put("photoUrl", uri.toString());
            }
            String str8 = googleSignInAccount.f2433p;
            if (str8 != null) {
                jSONObject.put("serverAuthCode", str8);
            }
            jSONObject.put("expirationTime", googleSignInAccount.f2434q);
            jSONObject.put("obfuscatedIdentifier", str);
            JSONArray jSONArray = new JSONArray();
            List list = googleSignInAccount.f2436s;
            Scope[] scopeArr = (Scope[]) list.toArray(new Scope[list.size()]);
            Arrays.sort(scopeArr, e0.d.f3736b);
            int i = 0;
            for (Scope scope : scopeArr) {
                jSONArray.put(scope.f2468b);
            }
            jSONObject.put("grantedScopes", jSONArray);
            jSONObject.remove("serverAuthCode");
            e(f, jSONObject.toString());
            String f10 = f("googleSignInOptions", str);
            String str9 = googleSignInOptions.f2451q;
            String str10 = googleSignInOptions.f2450p;
            ArrayList arrayList = googleSignInOptions.f2445b;
            JSONObject jSONObject2 = new JSONObject();
            try {
                JSONArray jSONArray2 = new JSONArray();
                Collections.sort(arrayList, GoogleSignInOptions.f2443y);
                int size = arrayList.size();
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    jSONArray2.put(((Scope) obj).f2468b);
                }
                jSONObject2.put("scopes", jSONArray2);
                Account account = googleSignInOptions.f2446l;
                if (account != null) {
                    jSONObject2.put("accountName", account.name);
                }
                jSONObject2.put("idTokenRequested", googleSignInOptions.f2447m);
                jSONObject2.put("forceCodeForRefreshToken", googleSignInOptions.f2449o);
                jSONObject2.put("serverAuthRequested", googleSignInOptions.f2448n);
                if (!TextUtils.isEmpty(str10)) {
                    jSONObject2.put("serverClientId", str10);
                }
                if (!TextUtils.isEmpty(str9)) {
                    jSONObject2.put("hostedDomain", str9);
                }
                e(f10, jSONObject2.toString());
            } catch (JSONException e10) {
                com.google.gson.internal.a.k(e10);
            }
        } catch (JSONException e11) {
            com.google.gson.internal.a.k(e11);
        }
    }

    public final String d(String str) {
        ReentrantLock reentrantLock = this.f4799a;
        reentrantLock.lock();
        try {
            return this.f4800b.getString(str, null);
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void e(String str, String str2) {
        ReentrantLock reentrantLock = this.f4799a;
        reentrantLock.lock();
        try {
            this.f4800b.edit().putString(str, str2).apply();
        } finally {
            reentrantLock.unlock();
        }
    }
}
