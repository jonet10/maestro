package f0;

import android.content.Context;
import android.os.Binder;
import android.os.Parcel;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.RevocationBoundService;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BasePendingResult;
import com.google.android.gms.internal.measurement.i5;
import e1.c0;
import j0.o;
import k0.y;
import org.json.JSONException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k extends w0.b {
    public final RevocationBoundService j;

    public k(RevocationBoundService revocationBoundService) {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService", 0);
        this.j = revocationBoundService;
    }

    @Override // w0.b
    public final boolean G(int i, Parcel parcel, Parcel parcel2) {
        BasePendingResult basePendingResult;
        String d10;
        RevocationBoundService revocationBoundService = this.j;
        if (i != 1) {
            if (i != 2) {
                return false;
            }
            I();
            i.o(revocationBoundService).r();
            return true;
        }
        I();
        b a8 = b.a(revocationBoundService);
        GoogleSignInAccount b7 = a8.b();
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.f2439t;
        if (b7 != null) {
            String d11 = a8.d("defaultGoogleSignInAccount");
            if (!TextUtils.isEmpty(d11) && (d10 = a8.d(b.f("googleSignInOptions", d11))) != null) {
                try {
                    googleSignInOptions = GoogleSignInOptions.c(d10);
                } catch (JSONException unused) {
                }
            }
            googleSignInOptions = null;
        }
        e0.a w2 = i5.w(revocationBoundService, googleSignInOptions);
        if (b7 != null) {
            o oVar = w2.h;
            Context context = w2.f5614a;
            boolean z9 = w2.d() == 3;
            h.f4808a.b("Revoking access", new Object[0]);
            String d12 = b.a(context).d("refreshToken");
            h.b(context);
            if (!z9) {
                g gVar = new g(oVar, 1);
                oVar.b(gVar);
                basePendingResult = gVar;
            } else if (d12 == null) {
                f8.o oVar2 = c.f4801l;
                Status status = new Status(4, null, null, null);
                y.a("Status code must not be SUCCESS", !false);
                basePendingResult = new i0.k(status);
                basePendingResult.e(status);
            } else {
                c cVar = new c(d12);
                new Thread(cVar).start();
                basePendingResult = cVar.f4803b;
            }
            basePendingResult.a(new j0.j(basePendingResult, new j1.i(), new c0(21)));
        } else {
            w2.c();
        }
        return true;
    }

    public final void I() {
        if (p0.b.b(this.j, Binder.getCallingUid())) {
            return;
        }
        int callingUid = Binder.getCallingUid();
        StringBuilder sb = new StringBuilder(String.valueOf(callingUid).length() + 41);
        sb.append("Calling UID ");
        sb.append(callingUid);
        sb.append(" is not Google Play services.");
        throw new SecurityException(sb.toString());
    }
}
