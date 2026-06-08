package c4;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.widget.SwitchCompat;
import com.uptodown.UptodownApp;
import com.uptodown.activities.GdprPrivacySettings;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.SearchActivity;
import com.uptodown.activities.Updates;
import java.io.File;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2062a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f2063b;

    public /* synthetic */ s(int i, MainActivity mainActivity) {
        this.f2062a = i;
        this.f2063b = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f2062a;
        File file = null;
        MainActivity mainActivity = this.f2063b;
        switch (i) {
            case 0:
                mainActivity.Q();
                mainActivity.z();
                break;
            case 1:
                mainActivity.Q();
                mainActivity.finish();
                break;
            case 2:
                int i6 = MainActivity.G0;
                AlertDialog alertDialog = mainActivity.F;
                alertDialog.getClass();
                alertDialog.dismiss();
                if (Build.VERSION.SDK_INT >= 33) {
                    mainActivity.x();
                }
                SharedPreferences sharedPreferences = mainActivity.getSharedPreferences("SettingsPreferences", 0);
                sharedPreferences.getClass();
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putBoolean("recibir_notificaciones", true);
                edit.apply();
                break;
            case 3:
                int i10 = MainActivity.G0;
                try {
                    j5.g l10 = j5.g.D.l(mainActivity);
                    l10.b();
                    String packageName = mainActivity.getPackageName();
                    packageName.getClass();
                    x4.q2 Y = l10.Y(packageName);
                    x4.r a8 = Y != null ? Y.a(mainActivity) : null;
                    if (a8 != null && a8.c()) {
                        file = a8.g();
                    }
                    l10.c();
                    if (file != null && file.exists()) {
                        mainActivity.M(file);
                        break;
                    } else {
                        mainActivity.k1();
                        break;
                    }
                } catch (Exception unused) {
                    mainActivity.s1();
                    return;
                }
                break;
            case 4:
                int i11 = MainActivity.G0;
                mainActivity.finish();
                break;
            case 5:
                int i12 = MainActivity.G0;
                String string = mainActivity.getString(2131952660);
                string.getClass();
                String string2 = mainActivity.getString(2131952735);
                string2.getClass();
                j5.c.e(mainActivity, string2, string);
                break;
            case 6:
                int i13 = MainActivity.G0;
                Intent intent = new Intent(mainActivity, (Class<?>) GdprPrivacySettings.class);
                ActivityResultLauncher activityResultLauncher = mainActivity.A0;
                float f = UptodownApp.I;
                activityResultLauncher.launch(intent, b4.d.b(mainActivity));
                break;
            case 7:
                int i14 = MainActivity.G0;
                AlertDialog alertDialog2 = mainActivity.F;
                alertDialog2.getClass();
                alertDialog2.dismiss();
                break;
            case 8:
                int i15 = MainActivity.G0;
                j5.g l11 = j5.g.D.l(mainActivity);
                l11.b();
                String packageName2 = mainActivity.getPackageName();
                packageName2.getClass();
                x4.q2 Y2 = l11.Y(packageName2);
                x4.r a10 = Y2 != null ? Y2.a(mainActivity) : null;
                if (a10 != null && a10.c()) {
                    file = a10.g();
                }
                l11.c();
                if (file == null) {
                    mainActivity.s1();
                    break;
                } else {
                    float f10 = UptodownApp.I;
                    b4.d.r(mainActivity, file);
                    break;
                }
                break;
            case 9:
                int i16 = MainActivity.G0;
                mainActivity.A0();
                break;
            case 10:
                int i17 = MainActivity.G0;
                Intent intent2 = new Intent(mainActivity, (Class<?>) LoginActivity.class);
                ActivityResultLauncher activityResultLauncher2 = mainActivity.C0;
                float f11 = UptodownApp.I;
                activityResultLauncher2.launch(intent2, b4.d.b(mainActivity));
                break;
            case 11:
                int i18 = MainActivity.G0;
                mainActivity.Q0();
                break;
            case 12:
                int i19 = MainActivity.G0;
                AlertDialog alertDialog3 = mainActivity.F;
                if (alertDialog3 != null) {
                    alertDialog3.dismiss();
                    break;
                }
                break;
            case 13:
                int i20 = MainActivity.G0;
                AlertDialog alertDialog4 = mainActivity.F;
                if (alertDialog4 != null) {
                    alertDialog4.dismiss();
                }
                mainActivity.n1();
                Intent intent3 = new Intent(mainActivity, (Class<?>) Updates.class);
                float f12 = UptodownApp.I;
                mainActivity.startActivity(intent3, b4.d.a(mainActivity));
                break;
            case 14:
                int i21 = MainActivity.G0;
                AlertDialog alertDialog5 = mainActivity.F;
                if (alertDialog5 != null) {
                    alertDialog5.dismiss();
                }
                mainActivity.n1();
                Intent intent4 = new Intent(mainActivity, (Class<?>) MyDownloads.class);
                float f13 = UptodownApp.I;
                mainActivity.startActivity(intent4, b4.d.a(mainActivity));
                break;
            case 15:
                int i22 = MainActivity.G0;
                AlertDialog alertDialog6 = mainActivity.F;
                if (alertDialog6 != null) {
                    alertDialog6.dismiss();
                    break;
                }
                break;
            case 16:
                int i23 = MainActivity.G0;
                AlertDialog alertDialog7 = mainActivity.F;
                if (alertDialog7 != null) {
                    alertDialog7.dismiss();
                    break;
                }
                break;
            case 17:
                int i24 = MainActivity.G0;
                mainActivity.X0();
                break;
            case 18:
                int i25 = MainActivity.G0;
                mainActivity.X0();
                mainActivity.w0();
                break;
            case 19:
                SwitchCompat switchCompat = mainActivity.a0;
                if (switchCompat != null && !switchCompat.isChecked()) {
                    mainActivity.x();
                    break;
                }
                break;
            case 20:
                int i26 = MainActivity.G0;
                float f14 = UptodownApp.I;
                if (b4.d.t()) {
                    mainActivity.S0(0);
                    u4.m1 m1Var = mainActivity.f3316o0;
                    if (m1Var != null) {
                        m1Var.b().f10040m.smoothScrollToPosition(0);
                    }
                    u4.g1 g1Var = mainActivity.f3315m0;
                    if (g1Var != null) {
                        g1Var.h().smoothScrollToPosition(0);
                    }
                    u4.w0 w0Var = mainActivity.n0;
                    if (w0Var != null) {
                        w0Var.h().smoothScrollToPosition(0);
                    }
                    u4.f1 f1Var = mainActivity.f3317p0;
                    if (f1Var != null) {
                        f1Var.a().f9935s.smoothScrollToPosition(0);
                        break;
                    }
                }
                break;
            case 21:
                SwitchCompat switchCompat2 = mainActivity.Z;
                if (switchCompat2 != null && !switchCompat2.isChecked() && !mainActivity.m()) {
                    mainActivity.y();
                    break;
                }
                break;
            case 22:
                int i27 = MainActivity.G0;
                mainActivity.Q0();
                break;
            case 23:
                int i28 = MainActivity.G0;
                mainActivity.P0();
                break;
            case 24:
                int i29 = MainActivity.G0;
                Intent intent5 = new Intent(mainActivity, (Class<?>) LoginActivity.class);
                float f15 = UptodownApp.I;
                mainActivity.startActivity(intent5, b4.d.a(mainActivity));
                mainActivity.U0();
                break;
            case 25:
                int i30 = MainActivity.G0;
                mainActivity.U0();
                break;
            case 26:
                int i31 = MainActivity.G0;
                String string3 = mainActivity.getString(2131952660);
                string3.getClass();
                String string4 = mainActivity.getString(2131952735);
                string4.getClass();
                j5.c.e(mainActivity, string4, string3);
                break;
            case 27:
                int i32 = MainActivity.G0;
                Intent intent6 = new Intent(mainActivity, (Class<?>) GdprPrivacySettings.class);
                ActivityResultLauncher activityResultLauncher3 = mainActivity.A0;
                float f16 = UptodownApp.I;
                activityResultLauncher3.launch(intent6, b4.d.b(mainActivity));
                break;
            case 28:
                int i33 = MainActivity.G0;
                if (mainActivity.T()) {
                    Intent intent7 = new Intent(mainActivity, (Class<?>) SearchActivity.class);
                    float f17 = UptodownApp.I;
                    mainActivity.startActivity(intent7, b4.d.a(mainActivity));
                    mainActivity.Y0();
                    break;
                }
                break;
            default:
                int i34 = MainActivity.G0;
                mainActivity.G0();
                break;
        }
    }
}
