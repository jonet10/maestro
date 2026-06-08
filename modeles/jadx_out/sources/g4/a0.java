package g4;

import android.app.AlertDialog;
import android.view.View;
import android.widget.TextView;
import com.uptodown.core.activities.InstallerActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a0 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5136a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ InstallerActivity f5137b;

    public /* synthetic */ a0(InstallerActivity installerActivity, int i) {
        this.f5136a = i;
        this.f5137b = installerActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f5136a;
        InstallerActivity installerActivity = this.f5137b;
        switch (i) {
            case 0:
                int i6 = InstallerActivity.f3394j0;
                f4.a aVar = f4.a.f4869a;
                f4.a.f4872d.n(l4.j.f7117a);
                installerActivity.finish();
                break;
            case 1:
                AlertDialog alertDialog = installerActivity.V;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                f4.a aVar2 = f4.a.f4869a;
                l4.a c9 = aVar2.c();
                aVar2.a();
                f4.a.f4872d.n(new l4.e(c9));
                installerActivity.D();
                break;
            case 2:
                AlertDialog alertDialog2 = installerActivity.U;
                alertDialog2.getClass();
                alertDialog2.dismiss();
                f4.a.f4869a.a();
                installerActivity.D();
                break;
            case 3:
                int i10 = InstallerActivity.f3394j0;
                f4.a aVar3 = f4.a.f4869a;
                f4.a.f4872d.n(l4.k.f7118a);
                installerActivity.E();
                break;
            case 4:
                int i11 = InstallerActivity.f3394j0;
                installerActivity.D();
                break;
            case 5:
                int i12 = InstallerActivity.f3394j0;
                installerActivity.finish();
                break;
            case 6:
                TextView textView = installerActivity.M;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                installerActivity.L(installerActivity.S);
                break;
            case 7:
                int i13 = InstallerActivity.f3394j0;
                installerActivity.D();
                break;
            default:
                installerActivity.finish();
                break;
        }
    }
}
