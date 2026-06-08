package c4;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r2 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2038a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.google.android.gms.internal.measurement.i4 f2039b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ t2 f2040l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r2(com.google.android.gms.internal.measurement.i4 i4Var, t2 t2Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f2038a = i;
        this.f2039b = i4Var;
        this.f2040l = t2Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2038a) {
            case 0:
                return new r2(this.f2039b, this.f2040l, cVar, 0);
            default:
                return new r2(this.f2039b, this.f2040l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2038a) {
            case 0:
                r2 r2Var = (r2) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                r2Var.invokeSuspend(xVar);
                return xVar;
            default:
                r2 r2Var2 = (r2) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                r2Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        String str;
        SharedPreferences sharedPreferences;
        String str2;
        String str3;
        SharedPreferences sharedPreferences2;
        int i = this.f2038a;
        p6.x xVar = p6.x.f8463a;
        t2 t2Var = this.f2040l;
        com.google.android.gms.internal.measurement.i4 i4Var = this.f2039b;
        switch (i) {
            case 0:
                p6.a.e(obj);
                boolean z9 = i4Var.f2662a;
                x4.w2 w2Var = (x4.w2) i4Var.f2663b;
                if (z9) {
                    t2Var.D0(w2Var, (String) i4Var.f2664c);
                    t2Var.setResult(-1);
                } else {
                    t2Var.C0(w2Var);
                    t2Var.F0();
                    t2Var.setResult(1);
                    Bundle bundle = new Bundle();
                    bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "success");
                    bundle.putString("loginSource", "google");
                    android.support.v4.media.g gVar = t2Var.E;
                    if (gVar != null) {
                        gVar.E(bundle, "login");
                    }
                }
                t2Var.y0();
                SharedPreferences sharedPreferences3 = t2Var.getSharedPreferences("SharedPreferencesUser", 0);
                try {
                    sharedPreferences = t2Var.getSharedPreferences("SettingsPreferences", 0);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                if (sharedPreferences.contains("UTOKEN")) {
                    str = sharedPreferences.getString("UTOKEN", null);
                    if (str != null && sharedPreferences3.getString("is_turbo", null) == null) {
                        t2Var.getOnBackPressedDispatcher().onBackPressed();
                        break;
                    } else {
                        t2Var.finish();
                        break;
                    }
                }
                str = null;
                if (str != null) {
                }
                t2Var.finish();
            default:
                p6.a.e(obj);
                if (i4Var.f2662a) {
                    t2Var.setResult(-1);
                } else {
                    x4.w2 w2Var2 = (x4.w2) i4Var.f2663b;
                    int i6 = t2.R;
                    if (w2Var2 != null) {
                        w2Var2.e(t2Var);
                    }
                    if (w2Var2 != null) {
                        try {
                            str2 = w2Var2.f11434m;
                        } catch (Exception e11) {
                            e11.printStackTrace();
                        }
                    } else {
                        str2 = null;
                    }
                    if (str2 != null && str2.length() != 0) {
                        String str4 = w2Var2.f11434m;
                        str4.getClass();
                        AccountManager.get(t2Var.getBaseContext()).addAccountExplicitly(new Account(str4, t2Var.getString(2131951649)), null, null);
                    }
                    t2Var.F0();
                    t2Var.setResult(1);
                    Bundle bundle2 = new Bundle();
                    bundle2.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "success");
                    bundle2.putString("loginSource", "google");
                    android.support.v4.media.g gVar2 = t2Var.E;
                    if (gVar2 != null) {
                        gVar2.E(bundle2, "login");
                    }
                }
                SharedPreferences sharedPreferences4 = t2Var.getSharedPreferences("SharedPreferencesUser", 0);
                try {
                    sharedPreferences2 = t2Var.getSharedPreferences("SettingsPreferences", 0);
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
                if (sharedPreferences2.contains("UTOKEN")) {
                    str3 = sharedPreferences2.getString("UTOKEN", null);
                    if (str3 == null || sharedPreferences4.getString("is_turbo", null) != null) {
                        t2Var.z0();
                        t2Var.B0();
                        break;
                    }
                }
                str3 = null;
                if (str3 == null) {
                }
                t2Var.z0();
                t2Var.B0();
                break;
        }
        return xVar;
    }
}
