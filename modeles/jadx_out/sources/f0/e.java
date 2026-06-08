package f0;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.util.Base64;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import g4.v;
import j0.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends k0.h {
    public final GoogleSignInOptions I;

    public e(Context context, Looper looper, v vVar, GoogleSignInOptions googleSignInOptions, m mVar, m mVar2) {
        super(context, looper, 91, vVar, mVar, mVar2, 0);
        Set<Scope> set = (Set) vVar.f5276l;
        e0.b bVar = googleSignInOptions != null ? new e0.b(googleSignInOptions) : new e0.b();
        byte[] bArr = new byte[16];
        w0.a.f10910a.nextBytes(bArr);
        bVar.i = Base64.encodeToString(bArr, 11);
        if (!set.isEmpty()) {
            for (Scope scope : set) {
                HashSet hashSet = bVar.f3729a;
                hashSet.add(scope);
                hashSet.addAll(Arrays.asList(new Scope[0]));
            }
        }
        Scope scope2 = GoogleSignInOptions.f2442x;
        HashSet hashSet2 = bVar.f3729a;
        if (hashSet2.contains(scope2)) {
            Scope scope3 = GoogleSignInOptions.f2441w;
            if (hashSet2.contains(scope3)) {
                hashSet2.remove(scope3);
            }
        }
        if (bVar.f3732d && (bVar.f == null || !hashSet2.isEmpty())) {
            hashSet2.add(GoogleSignInOptions.v);
        }
        this.I = new GoogleSignInOptions(3, new ArrayList(hashSet2), bVar.f, bVar.f3732d, bVar.f3730b, bVar.f3731c, bVar.f3733e, bVar.g, bVar.h, bVar.i);
    }

    @Override // k0.e
    public final int i() {
        return 12451000;
    }

    @Override // k0.e
    public final IInterface n(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.api.signin.internal.ISignInService");
        return queryLocalInterface instanceof j ? (j) queryLocalInterface : new j(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService", 1);
    }

    @Override // k0.e
    public final String u() {
        return "com.google.android.gms.auth.api.signin.internal.ISignInService";
    }

    @Override // k0.e
    public final String v() {
        return "com.google.android.gms.auth.api.signin.service.START";
    }
}
