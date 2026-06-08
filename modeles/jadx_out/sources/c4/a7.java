package c4;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import com.uptodown.UptodownApp;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.PreregistrationActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a7 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1381a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ PreregistrationActivity f1382b;

    public /* synthetic */ a7(PreregistrationActivity preregistrationActivity, int i) {
        this.f1381a = i;
        this.f1382b = preregistrationActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f1381a;
        PreregistrationActivity preregistrationActivity = this.f1382b;
        switch (i) {
            case 0:
                int i6 = PreregistrationActivity.T;
                preregistrationActivity.finish();
                break;
            case 1:
                int i10 = PreregistrationActivity.T;
                if (preregistrationActivity.T()) {
                    x4.j jVar = new x4.j(1090, (String) null, 6);
                    jVar.f11227m = true;
                    preregistrationActivity.z0(jVar);
                    break;
                }
                break;
            case 2:
                int i11 = PreregistrationActivity.T;
                Intent intent = new Intent(preregistrationActivity.getApplicationContext(), (Class<?>) LoginActivity.class);
                ActivityResultLauncher activityResultLauncher = preregistrationActivity.S;
                float f = UptodownApp.I;
                activityResultLauncher.launch(intent, b4.d.b(preregistrationActivity));
                AlertDialog alertDialog = preregistrationActivity.F;
                alertDialog.getClass();
                alertDialog.dismiss();
                break;
            case 3:
                int i12 = PreregistrationActivity.T;
                AlertDialog alertDialog2 = preregistrationActivity.F;
                alertDialog2.getClass();
                alertDialog2.dismiss();
                break;
            case 4:
                int i13 = PreregistrationActivity.T;
                AlertDialog alertDialog3 = preregistrationActivity.F;
                alertDialog3.getClass();
                alertDialog3.dismiss();
                break;
            default:
                int i14 = PreregistrationActivity.T;
                AlertDialog alertDialog4 = preregistrationActivity.F;
                alertDialog4.getClass();
                alertDialog4.dismiss();
                break;
        }
    }
}
