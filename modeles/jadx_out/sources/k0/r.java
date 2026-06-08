package k0;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r extends l0.a {
    public static final Parcelable.Creator<r> CREATOR = new i0.l(3);

    /* renamed from: a, reason: collision with root package name */
    public final int f6922a;

    /* renamed from: b, reason: collision with root package name */
    public final Account f6923b;

    /* renamed from: l, reason: collision with root package name */
    public final int f6924l;

    /* renamed from: m, reason: collision with root package name */
    public final GoogleSignInAccount f6925m;

    public r(int i, Account account, int i6, GoogleSignInAccount googleSignInAccount) {
        this.f6922a = i;
        this.f6923b = account;
        this.f6924l = i6;
        this.f6925m = googleSignInAccount;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int Y = a.a.Y(parcel, 20293);
        a.a.X(parcel, 1, 4);
        parcel.writeInt(this.f6922a);
        a.a.S(parcel, 2, this.f6923b, i);
        a.a.X(parcel, 3, 4);
        parcel.writeInt(this.f6924l);
        a.a.S(parcel, 4, this.f6925m, i);
        a.a.a0(parcel, Y);
    }
}
