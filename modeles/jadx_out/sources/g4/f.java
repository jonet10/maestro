package g4;

import android.app.AlertDialog;
import android.view.View;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5161a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f5162b;

    public /* synthetic */ f(h hVar, int i) {
        this.f5161a = i;
        this.f5162b = hVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f5161a) {
            case 0:
                h hVar = this.f5162b;
                AlertDialog alertDialog = hVar.f5176a;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                hVar.y();
                break;
            case 1:
                AlertDialog alertDialog2 = this.f5162b.f5176a;
                alertDialog2.getClass();
                alertDialog2.dismiss();
                break;
            default:
                AlertDialog alertDialog3 = this.f5162b.f5176a;
                alertDialog3.getClass();
                alertDialog3.dismiss();
                break;
        }
    }
}
