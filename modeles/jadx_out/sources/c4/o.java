package c4;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import com.uptodown.activities.LoginActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class o implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1930a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k0 f1931b;

    public /* synthetic */ o(k0 k0Var, int i) {
        this.f1930a = i;
        this.f1931b = k0Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f1930a;
        k0 k0Var = this.f1931b;
        switch (i) {
            case 0:
                k0Var.Q();
                break;
            case 1:
                k0Var.Q();
                String string = k0Var.getString(2131952730);
                string.getClass();
                j5.c.e(k0Var, string, null);
                break;
            case 2:
                k0Var.Q();
                break;
            case 3:
                k0Var.Q();
                break;
            case 4:
                k0Var.Q();
                break;
            case 5:
                k0Var.Q();
                break;
            case 6:
                k0Var.Q();
                break;
            case 7:
                AlertDialog alertDialog = k0Var.F;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                k0Var.startActivity(new Intent(k0Var, (Class<?>) LoginActivity.class));
                break;
            case 8:
                AlertDialog alertDialog2 = k0Var.F;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                    break;
                }
                break;
            case 9:
                AlertDialog alertDialog3 = k0Var.F;
                if (alertDialog3 != null) {
                    alertDialog3.dismiss();
                    break;
                }
                break;
            default:
                AlertDialog alertDialog4 = k0Var.F;
                if (alertDialog4 != null) {
                    alertDialog4.dismiss();
                    break;
                }
                break;
        }
    }
}
