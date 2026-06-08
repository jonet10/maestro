package c4;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.preferences.MobileDataUsageActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class c4 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1460a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MyApps f1461b;

    public /* synthetic */ c4(MyApps myApps, int i) {
        this.f1460a = i;
        this.f1461b = myApps;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f1460a;
        MyApps myApps = this.f1461b;
        switch (i) {
            case 0:
                int i6 = MyApps.f3328g0;
                myApps.finish();
                break;
            case 1:
                int i10 = MyApps.f3328g0;
                myApps.P0().f10224o.setIconified(false);
                break;
            case 2:
                float f = UptodownApp.I;
                if (b4.d.t()) {
                    myApps.startActivity(new Intent(myApps.getApplicationContext(), (Class<?>) MobileDataUsageActivity.class), b4.d.a(myApps));
                    AlertDialog alertDialog = myApps.F;
                    if (alertDialog != null) {
                        alertDialog.dismiss();
                        break;
                    }
                }
                break;
            default:
                AlertDialog alertDialog2 = myApps.F;
                if (alertDialog2 != null) {
                    alertDialog2.dismiss();
                    break;
                }
                break;
        }
    }
}
