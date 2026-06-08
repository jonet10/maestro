package c4;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.activities.SecurityActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class da implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1519a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SecurityActivity f1520b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ x4.e f1521l;

    public /* synthetic */ da(x4.e eVar, SecurityActivity securityActivity) {
        this.f1519a = 3;
        this.f1521l = eVar;
        this.f1520b = securityActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f1519a;
        t6.c cVar = null;
        SecurityActivity securityActivity = this.f1520b;
        x4.e eVar = this.f1521l;
        switch (i) {
            case 0:
                int i6 = SecurityActivity.f3349g0;
                securityActivity.i0(eVar.F);
                AlertDialog alertDialog = securityActivity.F;
                alertDialog.getClass();
                alertDialog.dismiss();
                break;
            case 1:
                int i10 = SecurityActivity.f3349g0;
                o7.c0.s(LifecycleOwnerKt.getLifecycleScope(securityActivity), null, null, new fa(securityActivity, eVar, cVar, 1), 3);
                AlertDialog alertDialog2 = securityActivity.F;
                alertDialog2.getClass();
                alertDialog2.dismiss();
                break;
            case 2:
                int i11 = SecurityActivity.f3349g0;
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(securityActivity);
                v7.e eVar2 = o7.m0.f8288a;
                o7.c0.s(lifecycleScope, t7.n.f10348a, null, new fa(securityActivity, eVar, cVar, 0), 2);
                AlertDialog alertDialog3 = securityActivity.F;
                alertDialog3.getClass();
                alertDialog3.dismiss();
                break;
            default:
                int i12 = SecurityActivity.f3349g0;
                String str = eVar.f11123l;
                if (str != null) {
                    str.getClass();
                    Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str)));
                    intent.addFlags(268435456);
                    securityActivity.startActivity(intent);
                }
                AlertDialog alertDialog4 = securityActivity.F;
                alertDialog4.getClass();
                alertDialog4.dismiss();
                break;
        }
    }

    public /* synthetic */ da(SecurityActivity securityActivity, x4.e eVar, int i) {
        this.f1519a = i;
        this.f1520b = securityActivity;
        this.f1521l = eVar;
    }
}
