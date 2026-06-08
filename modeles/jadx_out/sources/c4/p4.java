package c4;

import android.app.AlertDialog;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class p4 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1981a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ w4 f1982b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ x4.q2 f1983l;

    public /* synthetic */ p4(w4 w4Var, x4.q2 q2Var) {
        this.f1982b = w4Var;
        this.f1983l = q2Var;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f1981a;
        x4.q2 q2Var = this.f1983l;
        w4 w4Var = this.f1982b;
        int i6 = 0;
        switch (i) {
            case 0:
                float f = UptodownApp.I;
                if (b4.d.t()) {
                    b4.d.v(q2Var);
                    x4.r rVar = q2Var.f11352s;
                    if (rVar != null) {
                        rVar.t(w4Var);
                    }
                    b4.d.F(w4Var);
                    AlertDialog alertDialog = w4Var.F;
                    alertDialog.getClass();
                    alertDialog.dismiss();
                    w4Var.U = false;
                    break;
                }
                break;
            default:
                float f10 = UptodownApp.I;
                if (b4.d.t()) {
                    AlertDialog alertDialog2 = w4Var.F;
                    alertDialog2.getClass();
                    alertDialog2.dismiss();
                    w4Var.U = false;
                    String str = q2Var.f11350q;
                    str.getClass();
                    AlertDialog.Builder builder = new AlertDialog.Builder(w4Var);
                    View inflate = w4Var.getLayoutInflater().inflate(2131558495, (ViewGroup) null, false);
                    int i10 = 2131362642;
                    LinearLayout linearLayout = (LinearLayout) ViewBindings.findChildViewById(inflate, 2131362642);
                    if (linearLayout != null) {
                        i10 = 2131363604;
                        TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363604);
                        if (textView != null) {
                            i10 = 2131363709;
                            TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363709);
                            if (textView2 != null) {
                                i10 = 2131364370;
                                TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364370);
                                if (textView3 != null) {
                                    LinearLayout linearLayout2 = (LinearLayout) inflate;
                                    linearLayout2.setOnClickListener(new q4(w4Var, i6));
                                    linearLayout.setOnClickListener(new e(11));
                                    textView3.setTypeface(f4.c.f4882w);
                                    textView2.setTypeface(f4.c.f4883x);
                                    textView2.setText(str);
                                    textView.setTypeface(f4.c.f4882w);
                                    textView.setOnClickListener(new q4(w4Var, 1));
                                    builder.setView(linearLayout2);
                                    w4Var.F = builder.create();
                                    if (!w4Var.isFinishing()) {
                                        AlertDialog alertDialog3 = w4Var.F;
                                        alertDialog3.getClass();
                                        Window window = alertDialog3.getWindow();
                                        if (window != null) {
                                            a4.x.y(window, 0);
                                        }
                                        AlertDialog alertDialog4 = w4Var.F;
                                        alertDialog4.getClass();
                                        alertDialog4.show();
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
                    break;
                }
                break;
        }
    }

    public /* synthetic */ p4(x4.q2 q2Var, w4 w4Var) {
        this.f1983l = q2Var;
        this.f1982b = w4Var;
    }
}
