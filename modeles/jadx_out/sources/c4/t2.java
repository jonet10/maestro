package c4;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.lifecycle.LifecycleOwnerKt;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class t2 extends k0 {
    public static final /* synthetic */ int R = 0;
    public e0.a O;
    public final ActivityResultLauncher P;
    public final ActivityResultLauncher Q;

    public t2() {
        final int i = 0;
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: c4.q2

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t2 f2009b;

            {
                this.f2009b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GoogleSignInAccount googleSignInAccount;
                GoogleSignInAccount googleSignInAccount2;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i) {
                    case 0:
                        Intent data = activityResult.getData();
                        t2 t2Var = this.f2009b;
                        if (data != null) {
                            j1.p x3 = com.google.android.gms.internal.measurement.i5.x(activityResult.getData());
                            if (x3.i() && (googleSignInAccount = (GoogleSignInAccount) x3.g()) != null) {
                                o7.c0.s(LifecycleOwnerKt.getLifecycleScope(t2Var), null, null, new s2(googleSignInAccount, t2Var, null, 0), 3);
                            }
                        }
                        t2Var.y0();
                        break;
                    default:
                        if (activityResult.getData() != null) {
                            j1.p x9 = com.google.android.gms.internal.measurement.i5.x(activityResult.getData());
                            if (x9.i() && (googleSignInAccount2 = (GoogleSignInAccount) x9.g()) != null) {
                                t2 t2Var2 = this.f2009b;
                                o7.c0.s(LifecycleOwnerKt.getLifecycleScope(t2Var2), null, null, new s2(googleSignInAccount2, t2Var2, null, 1), 3);
                                break;
                            }
                        }
                        break;
                }
            }
        });
        registerForActivityResult.getClass();
        this.P = registerForActivityResult;
        final int i6 = 1;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback(this) { // from class: c4.q2

            /* renamed from: b, reason: collision with root package name */
            public final /* synthetic */ t2 f2009b;

            {
                this.f2009b = this;
            }

            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                GoogleSignInAccount googleSignInAccount;
                GoogleSignInAccount googleSignInAccount2;
                ActivityResult activityResult = (ActivityResult) obj;
                switch (i6) {
                    case 0:
                        Intent data = activityResult.getData();
                        t2 t2Var = this.f2009b;
                        if (data != null) {
                            j1.p x3 = com.google.android.gms.internal.measurement.i5.x(activityResult.getData());
                            if (x3.i() && (googleSignInAccount = (GoogleSignInAccount) x3.g()) != null) {
                                o7.c0.s(LifecycleOwnerKt.getLifecycleScope(t2Var), null, null, new s2(googleSignInAccount, t2Var, null, 0), 3);
                            }
                        }
                        t2Var.y0();
                        break;
                    default:
                        if (activityResult.getData() != null) {
                            j1.p x9 = com.google.android.gms.internal.measurement.i5.x(activityResult.getData());
                            if (x9.i() && (googleSignInAccount2 = (GoogleSignInAccount) x9.g()) != null) {
                                t2 t2Var2 = this.f2009b;
                                o7.c0.s(LifecycleOwnerKt.getLifecycleScope(t2Var2), null, null, new s2(googleSignInAccount2, t2Var2, null, 1), 3);
                                break;
                            }
                        }
                        break;
                }
            }
        });
        registerForActivityResult2.getClass();
        this.Q = registerForActivityResult2;
    }

    public final void A0() {
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.f2439t;
        new HashSet();
        new HashMap();
        k0.y.g(googleSignInOptions);
        HashSet hashSet = new HashSet(googleSignInOptions.f2445b);
        boolean z9 = googleSignInOptions.f2448n;
        boolean z10 = googleSignInOptions.f2449o;
        String str = googleSignInOptions.f2450p;
        Account account = googleSignInOptions.f2446l;
        String str2 = googleSignInOptions.f2451q;
        HashMap d10 = GoogleSignInOptions.d(googleSignInOptions.f2452r);
        String str3 = googleSignInOptions.f2453s;
        hashSet.add(GoogleSignInOptions.f2440u);
        k0.y.d("699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com");
        k0.y.a("two different server client ids provided", str == null || str.equals("699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com"));
        if (hashSet.contains(GoogleSignInOptions.f2442x)) {
            Scope scope = GoogleSignInOptions.f2441w;
            if (hashSet.contains(scope)) {
                hashSet.remove(scope);
            }
        }
        if (account == null || !hashSet.isEmpty()) {
            hashSet.add(GoogleSignInOptions.v);
        }
        this.Q.launch(com.google.android.gms.internal.measurement.i5.w(this, new GoogleSignInOptions(3, new ArrayList(hashSet), account, true, z9, z10, "699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com", str2, d10, str3)).b());
    }

    public abstract void C0(x4.w2 w2Var);

    public abstract void D0(x4.w2 w2Var, String str);

    public abstract void E0();

    public abstract void F0();

    @Override // c4.k0, g4.h, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        GoogleSignInOptions googleSignInOptions = GoogleSignInOptions.f2439t;
        new HashSet();
        new HashMap();
        k0.y.g(googleSignInOptions);
        HashSet hashSet = new HashSet(googleSignInOptions.f2445b);
        boolean z9 = googleSignInOptions.f2448n;
        boolean z10 = googleSignInOptions.f2449o;
        String str = googleSignInOptions.f2450p;
        Account account = googleSignInOptions.f2446l;
        String str2 = googleSignInOptions.f2451q;
        HashMap d10 = GoogleSignInOptions.d(googleSignInOptions.f2452r);
        String str3 = googleSignInOptions.f2453s;
        hashSet.add(GoogleSignInOptions.f2440u);
        k0.y.d("699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com");
        k0.y.a("two different server client ids provided", str == null || str.equals("699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com"));
        if (hashSet.contains(GoogleSignInOptions.f2442x)) {
            Scope scope = GoogleSignInOptions.f2441w;
            if (hashSet.contains(scope)) {
                hashSet.remove(scope);
            }
        }
        if (account == null || !hashSet.isEmpty()) {
            hashSet.add(GoogleSignInOptions.v);
        }
        this.O = com.google.android.gms.internal.measurement.i5.w(this, new GoogleSignInOptions(3, new ArrayList(hashSet), account, true, z9, z10, "699621046070-qajra0rrsahiqmumvkg7fagujfd78tm8.apps.googleusercontent.com", str2, d10, str3));
    }

    public abstract void y0();

    public x4.w2 z0() {
        return null;
    }

    public void B0() {
    }
}
