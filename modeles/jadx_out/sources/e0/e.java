package e0;

import android.accounts.Account;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.SignInAccount;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3738a;

    public /* synthetic */ e(int i) {
        this.f3738a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f3738a) {
            case 0:
                int L = f.L(parcel);
                String str = null;
                String str2 = null;
                String str3 = null;
                String str4 = null;
                Uri uri = null;
                String str5 = null;
                String str6 = null;
                ArrayList arrayList = null;
                String str7 = null;
                String str8 = null;
                long j = 0;
                int i = 0;
                while (parcel.dataPosition() < L) {
                    int readInt = parcel.readInt();
                    switch ((char) readInt) {
                        case 1:
                            i = f.E(parcel, readInt);
                            break;
                        case 2:
                            str = f.p(parcel, readInt);
                            break;
                        case 3:
                            str2 = f.p(parcel, readInt);
                            break;
                        case 4:
                            str3 = f.p(parcel, readInt);
                            break;
                        case 5:
                            str4 = f.p(parcel, readInt);
                            break;
                        case 6:
                            uri = (Uri) f.o(parcel, readInt, Uri.CREATOR);
                            break;
                        case 7:
                            str5 = f.p(parcel, readInt);
                            break;
                        case '\b':
                            j = f.F(parcel, readInt);
                            break;
                        case '\t':
                            str6 = f.p(parcel, readInt);
                            break;
                        case '\n':
                            arrayList = f.r(parcel, readInt, Scope.CREATOR);
                            break;
                        case 11:
                            str7 = f.p(parcel, readInt);
                            break;
                        case '\f':
                            str8 = f.p(parcel, readInt);
                            break;
                        default:
                            f.H(parcel, readInt);
                            break;
                    }
                }
                f.t(parcel, L);
                return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, arrayList, str7, str8);
            case 1:
                int L2 = f.L(parcel);
                ArrayList arrayList2 = null;
                ArrayList arrayList3 = null;
                Account account = null;
                String str9 = null;
                String str10 = null;
                String str11 = null;
                int i6 = 0;
                boolean z9 = false;
                boolean z10 = false;
                boolean z11 = false;
                while (parcel.dataPosition() < L2) {
                    int readInt2 = parcel.readInt();
                    switch ((char) readInt2) {
                        case 1:
                            i6 = f.E(parcel, readInt2);
                            break;
                        case 2:
                            arrayList3 = f.r(parcel, readInt2, Scope.CREATOR);
                            break;
                        case 3:
                            account = (Account) f.o(parcel, readInt2, Account.CREATOR);
                            break;
                        case 4:
                            z9 = f.C(parcel, readInt2);
                            break;
                        case 5:
                            z10 = f.C(parcel, readInt2);
                            break;
                        case 6:
                            z11 = f.C(parcel, readInt2);
                            break;
                        case 7:
                            str9 = f.p(parcel, readInt2);
                            break;
                        case '\b':
                            str10 = f.p(parcel, readInt2);
                            break;
                        case '\t':
                            arrayList2 = f.r(parcel, readInt2, f0.a.CREATOR);
                            break;
                        case '\n':
                            str11 = f.p(parcel, readInt2);
                            break;
                        default:
                            f.H(parcel, readInt2);
                            break;
                    }
                }
                f.t(parcel, L2);
                return new GoogleSignInOptions(i6, arrayList3, account, z9, z10, z11, str9, str10, GoogleSignInOptions.d(arrayList2), str11);
            default:
                int L3 = f.L(parcel);
                String str12 = "";
                GoogleSignInAccount googleSignInAccount = null;
                String str13 = "";
                while (parcel.dataPosition() < L3) {
                    int readInt3 = parcel.readInt();
                    char c9 = (char) readInt3;
                    if (c9 == 4) {
                        str12 = f.p(parcel, readInt3);
                    } else if (c9 == 7) {
                        googleSignInAccount = (GoogleSignInAccount) f.o(parcel, readInt3, GoogleSignInAccount.CREATOR);
                    } else if (c9 != '\b') {
                        f.H(parcel, readInt3);
                    } else {
                        str13 = f.p(parcel, readInt3);
                    }
                }
                f.t(parcel, L3);
                return new SignInAccount(str12, googleSignInAccount, str13);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.f3738a) {
            case 0:
                return new GoogleSignInAccount[i];
            case 1:
                return new GoogleSignInOptions[i];
            default:
                return new SignInAccount[i];
        }
    }
}
