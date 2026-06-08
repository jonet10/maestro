package e0;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;
import i0.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c implements i {

    /* renamed from: a, reason: collision with root package name */
    public final Status f3734a;

    /* renamed from: b, reason: collision with root package name */
    public final GoogleSignInAccount f3735b;

    public c(GoogleSignInAccount googleSignInAccount, Status status) {
        this.f3735b = googleSignInAccount;
        this.f3734a = status;
    }

    @Override // i0.i
    public final Status b() {
        return this.f3734a;
    }
}
