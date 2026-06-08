package k0;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Scope;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends l0.a {

    @NonNull
    public static final Parcelable.Creator<g> CREATOR = new i0.l(8);

    /* renamed from: x, reason: collision with root package name */
    public static final Scope[] f6861x = new Scope[0];

    /* renamed from: y, reason: collision with root package name */
    public static final h0.d[] f6862y = new h0.d[0];

    /* renamed from: a, reason: collision with root package name */
    public final int f6863a;

    /* renamed from: b, reason: collision with root package name */
    public final int f6864b;

    /* renamed from: l, reason: collision with root package name */
    public final int f6865l;

    /* renamed from: m, reason: collision with root package name */
    public String f6866m;

    /* renamed from: n, reason: collision with root package name */
    public IBinder f6867n;

    /* renamed from: o, reason: collision with root package name */
    public Scope[] f6868o;

    /* renamed from: p, reason: collision with root package name */
    public Bundle f6869p;

    /* renamed from: q, reason: collision with root package name */
    public Account f6870q;

    /* renamed from: r, reason: collision with root package name */
    public h0.d[] f6871r;

    /* renamed from: s, reason: collision with root package name */
    public h0.d[] f6872s;

    /* renamed from: t, reason: collision with root package name */
    public final boolean f6873t;

    /* renamed from: u, reason: collision with root package name */
    public final int f6874u;
    public boolean v;

    /* renamed from: w, reason: collision with root package name */
    public final String f6875w;

    public g(int i, int i6, int i10, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, h0.d[] dVarArr, h0.d[] dVarArr2, boolean z9, int i11, boolean z10, String str2) {
        Scope[] scopeArr2 = scopeArr == null ? f6861x : scopeArr;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        h0.d[] dVarArr3 = f6862y;
        h0.d[] dVarArr4 = dVarArr == null ? dVarArr3 : dVarArr;
        dVarArr3 = dVarArr2 != null ? dVarArr2 : dVarArr3;
        this.f6863a = i;
        this.f6864b = i6;
        this.f6865l = i10;
        if ("com.google.android.gms".equals(str)) {
            this.f6866m = "com.google.android.gms";
        } else {
            this.f6866m = str;
        }
        if (i < 2) {
            Account account2 = null;
            if (iBinder != null) {
                int i12 = a.j;
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
                i l0Var = queryLocalInterface instanceof i ? (i) queryLocalInterface : new l0(iBinder, "com.google.android.gms.common.internal.IAccountAccessor", 3);
                long clearCallingIdentity = Binder.clearCallingIdentity();
                try {
                    try {
                        l0 l0Var2 = (l0) l0Var;
                        Parcel c9 = l0Var2.c(l0Var2.G(), 2);
                        Account account3 = (Account) z0.g.a(c9, Account.CREATOR);
                        c9.recycle();
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                        account2 = account3;
                    } catch (RemoteException unused) {
                        Log.w("AccountAccessor", "Remote account accessor probably died");
                        Binder.restoreCallingIdentity(clearCallingIdentity);
                    }
                } catch (Throwable th) {
                    Binder.restoreCallingIdentity(clearCallingIdentity);
                    throw th;
                }
            }
            this.f6870q = account2;
        } else {
            this.f6867n = iBinder;
            this.f6870q = account;
        }
        this.f6868o = scopeArr2;
        this.f6869p = bundle2;
        this.f6871r = dVarArr4;
        this.f6872s = dVarArr3;
        this.f6873t = z9;
        this.f6874u = i11;
        this.v = z10;
        this.f6875w = str2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        i0.l.a(this, parcel, i);
    }
}
