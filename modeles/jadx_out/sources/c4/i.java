package c4;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.View;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.AppFilesActivity;
import com.uptodown.activities.AppInstalledDetailsActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class i implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1705a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppInstalledDetailsActivity f1706b;

    public /* synthetic */ i(AppInstalledDetailsActivity appInstalledDetailsActivity, int i) {
        this.f1705a = i;
        this.f1706b = appInstalledDetailsActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i = this.f1705a;
        AppInstalledDetailsActivity appInstalledDetailsActivity = this.f1706b;
        switch (i) {
            case 0:
                int i6 = AppInstalledDetailsActivity.f3300e0;
                appInstalledDetailsActivity.getOnBackPressedDispatcher().onBackPressed();
                break;
            case 1:
                int i10 = AppInstalledDetailsActivity.f3300e0;
                j5.g l10 = j5.g.D.l(appInstalledDetailsActivity);
                l10.b();
                x4.e eVar = appInstalledDetailsActivity.f3301b0;
                eVar.getClass();
                String str = eVar.f11123l;
                str.getClass();
                x4.q2 Y = l10.Y(str);
                if (Y != null) {
                    float f = UptodownApp.I;
                    boolean l11 = b4.d.l(Y);
                    String str2 = Y.f11344b;
                    if (l11) {
                        str2.getClass();
                        x4.r b7 = a5.b.b();
                        if (kotlin.jvm.internal.l.a(b7 != null ? b7.f11355b : null, str2)) {
                            a5.b.f();
                        } else {
                            a5.c.d();
                        }
                        b4.d.u(Y);
                    } else if (b4.d.m(str2)) {
                        b4.d.v(Y);
                    }
                }
                l10.c();
                break;
            case 2:
                int i11 = AppInstalledDetailsActivity.f3300e0;
                PackageManager packageManager = appInstalledDetailsActivity.getPackageManager();
                x4.e eVar2 = appInstalledDetailsActivity.f3301b0;
                eVar2.getClass();
                String str3 = eVar2.f11123l;
                str3.getClass();
                Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(str3);
                if (launchIntentForPackage != null) {
                    appInstalledDetailsActivity.startActivity(launchIntentForPackage);
                    break;
                }
                break;
            case 3:
                int i12 = AppInstalledDetailsActivity.f3300e0;
                x4.e eVar3 = appInstalledDetailsActivity.f3301b0;
                eVar3.getClass();
                String str4 = eVar3.f11123l;
                str4.getClass();
                Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str4)));
                intent.addFlags(268435456);
                appInstalledDetailsActivity.startActivity(intent);
                appInstalledDetailsActivity.finish();
                break;
            case 4:
                int i13 = AppInstalledDetailsActivity.f3300e0;
                Intent intent2 = new Intent(appInstalledDetailsActivity, (Class<?>) AppFilesActivity.class);
                intent2.putExtra("appInstalled", appInstalledDetailsActivity.f3301b0);
                float f10 = UptodownApp.I;
                appInstalledDetailsActivity.startActivity(intent2, b4.d.a(appInstalledDetailsActivity));
                break;
            case 5:
                int i14 = AppInstalledDetailsActivity.f3300e0;
                if (appInstalledDetailsActivity.R0().f9739q.getVisibility() != 0) {
                    appInstalledDetailsActivity.R0().f9739q.setVisibility(0);
                    appInstalledDetailsActivity.R0().f9732m.setImageResource(2131231415);
                    appInstalledDetailsActivity.R0().F.post(new a2.s(appInstalledDetailsActivity, 5));
                    break;
                } else {
                    appInstalledDetailsActivity.R0().f9739q.setVisibility(8);
                    appInstalledDetailsActivity.R0().f9732m.setImageResource(2131231293);
                    break;
                }
            default:
                if (appInstalledDetailsActivity.f3302c0 == null) {
                    appInstalledDetailsActivity.Q0();
                    break;
                } else {
                    Intent intent3 = new Intent(appInstalledDetailsActivity, (Class<?>) AppDetailActivity.class);
                    intent3.putExtra("appInfo", appInstalledDetailsActivity.f3302c0);
                    float f11 = UptodownApp.I;
                    appInstalledDetailsActivity.startActivity(intent3, b4.d.a(appInstalledDetailsActivity));
                    break;
                }
        }
    }
}
