package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e0.e;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import k0.y;
import l0.a;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Deprecated
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class GoogleSignInAccount extends a implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new e(0);

    /* renamed from: a, reason: collision with root package name */
    public final int f2427a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2428b;

    /* renamed from: l, reason: collision with root package name */
    public final String f2429l;

    /* renamed from: m, reason: collision with root package name */
    public final String f2430m;

    /* renamed from: n, reason: collision with root package name */
    public final String f2431n;

    /* renamed from: o, reason: collision with root package name */
    public final Uri f2432o;

    /* renamed from: p, reason: collision with root package name */
    public String f2433p;

    /* renamed from: q, reason: collision with root package name */
    public final long f2434q;

    /* renamed from: r, reason: collision with root package name */
    public final String f2435r;

    /* renamed from: s, reason: collision with root package name */
    public final List f2436s;

    /* renamed from: t, reason: collision with root package name */
    public final String f2437t;

    /* renamed from: u, reason: collision with root package name */
    public final String f2438u;
    public final HashSet v = new HashSet();

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, ArrayList arrayList, String str7, String str8) {
        this.f2427a = i;
        this.f2428b = str;
        this.f2429l = str2;
        this.f2430m = str3;
        this.f2431n = str4;
        this.f2432o = uri;
        this.f2433p = str5;
        this.f2434q = j;
        this.f2435r = str6;
        this.f2436s = arrayList;
        this.f2437t = str7;
        this.f2438u = str8;
    }

    public static GoogleSignInAccount c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String optString = jSONObject.optString("photoUrl");
        Uri parse = !TextUtils.isEmpty(optString) ? Uri.parse(optString) : null;
        long parseLong = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(1, jSONArray.getString(i)));
        }
        String optString2 = jSONObject.optString("id");
        String optString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String optString4 = jSONObject.has(NotificationCompat.CATEGORY_EMAIL) ? jSONObject.optString(NotificationCompat.CATEGORY_EMAIL) : null;
        String optString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String optString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String optString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        String string = jSONObject.getString("obfuscatedIdentifier");
        y.d(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, optString2, optString3, optString4, optString5, parse, null, parseLong, string, new ArrayList(hashSet), optString6, optString7);
        googleSignInAccount.f2433p = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.f2435r.equals(this.f2435r)) {
            return false;
        }
        HashSet hashSet = new HashSet(googleSignInAccount.f2436s);
        hashSet.addAll(googleSignInAccount.v);
        HashSet hashSet2 = new HashSet(this.f2436s);
        hashSet2.addAll(this.v);
        return hashSet.equals(hashSet2);
    }

    public final int hashCode() {
        int hashCode = this.f2435r.hashCode() + 527;
        HashSet hashSet = new HashSet(this.f2436s);
        hashSet.addAll(this.v);
        return (hashCode * 31) + hashSet.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.X(parcel, 1, 4);
        parcel.writeInt(this.f2427a);
        a.a.T(parcel, 2, this.f2428b);
        a.a.T(parcel, 3, this.f2429l);
        a.a.T(parcel, 4, this.f2430m);
        a.a.T(parcel, 5, this.f2431n);
        a.a.S(parcel, 6, this.f2432o, i);
        a.a.T(parcel, 7, this.f2433p);
        a.a.X(parcel, 8, 8);
        parcel.writeLong(this.f2434q);
        a.a.T(parcel, 9, this.f2435r);
        a.a.V(parcel, 10, this.f2436s);
        a.a.T(parcel, 11, this.f2437t);
        a.a.T(parcel, 12, this.f2438u);
        a.a.a0(parcel, Y);
    }
}
