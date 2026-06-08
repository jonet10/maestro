package com.google.android.gms.auth.api.signin;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e0.d;
import e0.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import l0.a;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Deprecated
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class GoogleSignInOptions extends a implements i0.a, ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInOptions> CREATOR;

    /* renamed from: t, reason: collision with root package name */
    public static final GoogleSignInOptions f2439t;

    /* renamed from: u, reason: collision with root package name */
    public static final Scope f2440u;
    public static final Scope v;

    /* renamed from: w, reason: collision with root package name */
    public static final Scope f2441w;

    /* renamed from: x, reason: collision with root package name */
    public static final Scope f2442x;

    /* renamed from: y, reason: collision with root package name */
    public static final d f2443y;

    /* renamed from: a, reason: collision with root package name */
    public final int f2444a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2445b;

    /* renamed from: l, reason: collision with root package name */
    public final Account f2446l;

    /* renamed from: m, reason: collision with root package name */
    public final boolean f2447m;

    /* renamed from: n, reason: collision with root package name */
    public final boolean f2448n;

    /* renamed from: o, reason: collision with root package name */
    public final boolean f2449o;

    /* renamed from: p, reason: collision with root package name */
    public final String f2450p;

    /* renamed from: q, reason: collision with root package name */
    public final String f2451q;

    /* renamed from: r, reason: collision with root package name */
    public final ArrayList f2452r;

    /* renamed from: s, reason: collision with root package name */
    public final String f2453s;

    static {
        Scope scope = new Scope(1, "profile");
        f2440u = new Scope(1, NotificationCompat.CATEGORY_EMAIL);
        Scope scope2 = new Scope(1, "openid");
        v = scope2;
        Scope scope3 = new Scope(1, "https://www.googleapis.com/auth/games_lite");
        f2441w = scope3;
        f2442x = new Scope(1, "https://www.googleapis.com/auth/games");
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        hashSet.add(scope2);
        hashSet.add(scope);
        if (hashSet.contains(f2442x)) {
            Scope scope4 = f2441w;
            if (hashSet.contains(scope4)) {
                hashSet.remove(scope4);
            }
        }
        f2439t = new GoogleSignInOptions(3, new ArrayList(hashSet), null, false, false, false, null, null, hashMap, null);
        HashSet hashSet2 = new HashSet();
        HashMap hashMap2 = new HashMap();
        hashSet2.add(scope3);
        hashSet2.addAll(Arrays.asList(new Scope[0]));
        if (hashSet2.contains(f2442x)) {
            Scope scope5 = f2441w;
            if (hashSet2.contains(scope5)) {
                hashSet2.remove(scope5);
            }
        }
        new GoogleSignInOptions(3, new ArrayList(hashSet2), null, false, false, false, null, null, hashMap2, null);
        CREATOR = new e(1);
        f2443y = new d(1);
    }

    public GoogleSignInOptions(int i, ArrayList arrayList, Account account, boolean z9, boolean z10, boolean z11, String str, String str2, HashMap hashMap, String str3) {
        this.f2444a = i;
        this.f2445b = arrayList;
        this.f2446l = account;
        this.f2447m = z9;
        this.f2448n = z10;
        this.f2449o = z11;
        this.f2450p = str;
        this.f2451q = str2;
        this.f2452r = new ArrayList(hashMap.values());
        this.f2453s = str3;
    }

    public static GoogleSignInOptions c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("scopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(1, jSONArray.getString(i)));
        }
        String optString = jSONObject.has("accountName") ? jSONObject.optString("accountName") : null;
        return new GoogleSignInOptions(3, new ArrayList(hashSet), !TextUtils.isEmpty(optString) ? new Account(optString, "com.google") : null, jSONObject.getBoolean("idTokenRequested"), jSONObject.getBoolean("serverAuthRequested"), jSONObject.getBoolean("forceCodeForRefreshToken"), jSONObject.has("serverClientId") ? jSONObject.optString("serverClientId") : null, jSONObject.has("hostedDomain") ? jSONObject.optString("hostedDomain") : null, new HashMap(), null);
    }

    public static HashMap d(ArrayList arrayList) {
        HashMap hashMap = new HashMap();
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                f0.a aVar = (f0.a) obj;
                hashMap.put(Integer.valueOf(aVar.f4795b), aVar);
            }
        }
        return hashMap;
    }

    public final boolean equals(Object obj) {
        String str = this.f2450p;
        ArrayList arrayList = this.f2445b;
        if (obj == null) {
            return false;
        }
        try {
            GoogleSignInOptions googleSignInOptions = (GoogleSignInOptions) obj;
            ArrayList arrayList2 = googleSignInOptions.f2445b;
            String str2 = googleSignInOptions.f2450p;
            if (this.f2452r.isEmpty() && googleSignInOptions.f2452r.isEmpty() && arrayList.size() == new ArrayList(arrayList2).size() && arrayList.containsAll(new ArrayList(arrayList2))) {
                Account account = this.f2446l;
                Account account2 = googleSignInOptions.f2446l;
                if (account == null) {
                    if (account2 != null) {
                        return false;
                    }
                } else if (!account.equals(account2)) {
                    return false;
                }
                if (TextUtils.isEmpty(str)) {
                    if (!TextUtils.isEmpty(str2)) {
                        return false;
                    }
                } else if (!str.equals(str2)) {
                    return false;
                }
                if (this.f2449o == googleSignInOptions.f2449o && this.f2447m == googleSignInOptions.f2447m && this.f2448n == googleSignInOptions.f2448n) {
                    return TextUtils.equals(this.f2453s, googleSignInOptions.f2453s);
                }
                return false;
            }
            return false;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final int hashCode() {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = this.f2445b;
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(((Scope) arrayList2.get(i)).f2468b);
        }
        Collections.sort(arrayList);
        int hashCode = (arrayList.hashCode() + (1 * 31)) * 31;
        Account account = this.f2446l;
        int hashCode2 = (hashCode + (account == null ? 0 : account.hashCode())) * 31;
        String str = this.f2450p;
        int hashCode3 = (((((((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + (this.f2449o ? 1 : 0)) * 31) + (this.f2447m ? 1 : 0)) * 31) + (this.f2448n ? 1 : 0)) * 31;
        String str2 = this.f2453s;
        return hashCode3 + (str2 != null ? str2.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.X(parcel, 1, 4);
        parcel.writeInt(this.f2444a);
        a.a.V(parcel, 2, new ArrayList(this.f2445b));
        a.a.S(parcel, 3, this.f2446l, i);
        a.a.X(parcel, 4, 4);
        parcel.writeInt(this.f2447m ? 1 : 0);
        a.a.X(parcel, 5, 4);
        parcel.writeInt(this.f2448n ? 1 : 0);
        a.a.X(parcel, 6, 4);
        parcel.writeInt(this.f2449o ? 1 : 0);
        a.a.T(parcel, 7, this.f2450p);
        a.a.T(parcel, 8, this.f2451q);
        a.a.V(parcel, 9, this.f2452r);
        a.a.T(parcel, 10, this.f2453s);
        a.a.a0(parcel, Y);
    }
}
