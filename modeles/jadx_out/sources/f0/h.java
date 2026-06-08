package f0;

import a4.c0;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.internal.SignInConfiguration;
import com.google.android.gms.auth.api.signin.internal.SignInHubActivity;
import f8.o;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final o f4808a = new o("GoogleSignInCommon", new String[0]);

    public static Intent a(Context context, GoogleSignInOptions googleSignInOptions) {
        f4808a.b("getSignInIntent()", new Object[0]);
        SignInConfiguration signInConfiguration = new SignInConfiguration(context.getPackageName(), googleSignInOptions);
        Intent intent = new Intent("com.google.android.gms.auth.GOOGLE_SIGN_IN");
        intent.setPackage(context.getPackageName());
        intent.setClass(context, SignInHubActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable("config", signInConfiguration);
        intent.putExtra("config", bundle);
        return intent;
    }

    public static void b(Context context) {
        i.o(context).r();
        Iterator it = i0.g.a().iterator();
        if (it.hasNext()) {
            ((i0.g) it.next()).getClass();
            com.google.gson.internal.a.q();
            return;
        }
        synchronized (j0.e.f6489z) {
            try {
                j0.e eVar = j0.e.A;
                if (eVar != null) {
                    eVar.f6498r.incrementAndGet();
                    c0 c0Var = eVar.v;
                    c0Var.sendMessageAtFrontOfQueue(c0Var.obtainMessage(10));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
