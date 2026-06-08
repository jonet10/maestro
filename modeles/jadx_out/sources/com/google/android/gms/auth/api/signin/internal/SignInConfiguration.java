package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.f;
import androidx.annotation.NonNull;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import k0.y;
import l0.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class SignInConfiguration extends a implements ReflectedParcelable {

    @NonNull
    public static final Parcelable.Creator<SignInConfiguration> CREATOR = new f(22);

    /* renamed from: a, reason: collision with root package name */
    public final String f2457a;

    /* renamed from: b, reason: collision with root package name */
    public final GoogleSignInOptions f2458b;

    public SignInConfiguration(String str, GoogleSignInOptions googleSignInOptions) {
        y.d(str);
        this.f2457a = str;
        this.f2458b = googleSignInOptions;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof SignInConfiguration)) {
            return false;
        }
        SignInConfiguration signInConfiguration = (SignInConfiguration) obj;
        if (this.f2457a.equals(signInConfiguration.f2457a)) {
            GoogleSignInOptions googleSignInOptions = signInConfiguration.f2458b;
            GoogleSignInOptions googleSignInOptions2 = this.f2458b;
            if (googleSignInOptions2 == null) {
                if (googleSignInOptions == null) {
                    return true;
                }
            } else if (googleSignInOptions2.equals(googleSignInOptions)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = 1 * 31;
        String str = this.f2457a;
        int hashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        GoogleSignInOptions googleSignInOptions = this.f2458b;
        return hashCode + (googleSignInOptions != null ? googleSignInOptions.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.T(parcel, 2, this.f2457a);
        a.a.S(parcel, 5, this.f2458b, i);
        a.a.a0(parcel, Y);
    }
}
