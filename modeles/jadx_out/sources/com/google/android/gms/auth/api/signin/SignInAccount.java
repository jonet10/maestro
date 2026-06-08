package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e0.e;
import k0.y;
import l0.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class SignInAccount extends a implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<SignInAccount> CREATOR = new e(2);

    /* renamed from: a, reason: collision with root package name */
    public final String f2454a;

    /* renamed from: b, reason: collision with root package name */
    public final GoogleSignInAccount f2455b;

    /* renamed from: l, reason: collision with root package name */
    public final String f2456l;

    public SignInAccount(String str, GoogleSignInAccount googleSignInAccount, String str2) {
        this.f2455b = googleSignInAccount;
        y.e(str, "8.3 and 8.4 SDKs require non-null email");
        this.f2454a = str;
        y.e(str2, "8.3 and 8.4 SDKs require non-null userId");
        this.f2456l = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.T(parcel, 4, this.f2454a);
        a.a.S(parcel, 7, this.f2455b, i);
        a.a.T(parcel, 8, this.f2456l);
        a.a.a0(parcel, Y);
    }
}
