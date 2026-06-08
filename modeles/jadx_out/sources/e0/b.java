package e0;

import android.accounts.Account;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import java.util.HashMap;
import java.util.HashSet;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final HashSet f3729a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3730b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f3731c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f3732d;

    /* renamed from: e, reason: collision with root package name */
    public final String f3733e;
    public final Account f;
    public final String g;
    public final HashMap h;
    public String i;

    public b(GoogleSignInOptions googleSignInOptions) {
        this.f3729a = new HashSet();
        this.h = new HashMap();
        y.g(googleSignInOptions);
        this.f3729a = new HashSet(googleSignInOptions.f2445b);
        this.f3730b = googleSignInOptions.f2448n;
        this.f3731c = googleSignInOptions.f2449o;
        this.f3732d = googleSignInOptions.f2447m;
        this.f3733e = googleSignInOptions.f2450p;
        this.f = googleSignInOptions.f2446l;
        this.g = googleSignInOptions.f2451q;
        this.h = GoogleSignInOptions.d(googleSignInOptions.f2452r);
        this.i = googleSignInOptions.f2453s;
    }

    public b() {
        this.f3729a = new HashSet();
        this.h = new HashMap();
    }
}
