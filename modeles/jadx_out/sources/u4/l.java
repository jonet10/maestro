package u4;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class l implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10521a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f10522b;

    public /* synthetic */ l(f0 f0Var, int i) {
        this.f10521a = i;
        this.f10522b = f0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10521a) {
            case 0:
                f0 f0Var = this.f10522b;
                if (f0Var.getContext() != null) {
                    Context requireContext = f0Var.requireContext();
                    requireContext.getClass();
                    boolean z9 = false;
                    try {
                        SharedPreferences sharedPreferences = requireContext.getSharedPreferences("SettingsPreferences", 0);
                        if (sharedPreferences.contains("is_device_tracking_registered")) {
                            z9 = sharedPreferences.getBoolean("is_device_tracking_registered", false);
                        }
                    } catch (Exception unused) {
                    }
                    if (!z9) {
                        f0Var.a0();
                        break;
                    } else {
                        t4.b bVar = f0Var.f10473b;
                        bVar.getClass();
                        if (bVar.f9615n.getChildCount() != 0) {
                            t4.b bVar2 = f0Var.f10473b;
                            bVar2.getClass();
                            bVar2.f9615n.removeAllViews();
                            break;
                        }
                    }
                }
                break;
            default:
                f0 f0Var2 = this.f10522b;
                r7.o0 o0Var = f0Var2.G().Q;
                t4.b bVar3 = f0Var2.f10473b;
                bVar3.getClass();
                Integer valueOf = Integer.valueOf(((View) bVar3.D.f8822q).getMeasuredWidth());
                o0Var.getClass();
                o0Var.g(null, valueOf);
                if (((Boolean) f0Var2.G().N.getValue()).booleanValue()) {
                    f0Var2.w0();
                    break;
                }
                break;
        }
    }
}
