package c4;

import android.content.Intent;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.Updates;
import com.uptodown.activities.UserActivity;
import com.uptodown.activities.preferences.PreferencesActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class c3 implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1458a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MainActivity f1459b;

    public /* synthetic */ c3(int i, MainActivity mainActivity) {
        this.f1458a = i;
        this.f1459b = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f1458a;
        MainActivity mainActivity = this.f1459b;
        switch (i) {
            case 0:
                int i6 = MainActivity.G0;
                mainActivity.Q0();
                break;
            case 1:
                int i10 = MainActivity.G0;
                Intent intent = new Intent(mainActivity, (Class<?>) Updates.class);
                float f = UptodownApp.I;
                mainActivity.startActivity(intent, b4.d.a(mainActivity));
                break;
            case 2:
                int i11 = MainActivity.G0;
                Intent intent2 = new Intent(mainActivity, (Class<?>) MyApps.class);
                float f10 = UptodownApp.I;
                mainActivity.startActivity(intent2, b4.d.a(mainActivity));
                break;
            case 3:
                int i12 = MainActivity.G0;
                Intent intent3 = new Intent(mainActivity, (Class<?>) MyDownloads.class);
                float f11 = UptodownApp.I;
                mainActivity.startActivity(intent3, b4.d.a(mainActivity));
                break;
            case 4:
                int i13 = MainActivity.G0;
                Intent intent4 = new Intent(mainActivity, (Class<?>) PreferencesActivity.class);
                ActivityResultLauncher activityResultLauncher = mainActivity.B0;
                float f12 = UptodownApp.I;
                activityResultLauncher.launch(intent4, b4.d.b(mainActivity));
                break;
            case 5:
                int i14 = MainActivity.G0;
                mainActivity.m1();
                break;
            case 6:
                int i15 = MainActivity.G0;
                float f13 = UptodownApp.I;
                if (b4.d.t()) {
                    mainActivity.w0();
                    break;
                }
                break;
            case 7:
                int i16 = MainActivity.G0;
                mainActivity.j1();
                break;
            default:
                int i17 = MainActivity.G0;
                Intent intent5 = new Intent(mainActivity, (Class<?>) UserActivity.class);
                ActivityResultLauncher activityResultLauncher2 = mainActivity.D0;
                float f14 = UptodownApp.I;
                activityResultLauncher2.launch(intent5, b4.d.b(mainActivity));
                break;
        }
    }
}
