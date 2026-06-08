package c4;

import android.app.AlertDialog;
import android.content.Intent;
import android.view.View;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResultLauncher;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import com.uptodown.UptodownApp;
import com.uptodown.activities.FeedActivity;
import com.uptodown.activities.ListsActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.MyStatsActivity;
import com.uptodown.activities.NotificationsRegistryActivity;
import com.uptodown.activities.RollbackActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.UserActivity;
import com.uptodown.activities.UserAvatarActivity;
import com.uptodown.activities.UserCommentsActivity;
import com.uptodown.activities.UserDevicesActivity;
import com.uptodown.activities.preferences.PreferencesActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class fb implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1608a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserActivity f1609b;

    public /* synthetic */ fb(UserActivity userActivity, int i) {
        this.f1608a = i;
        this.f1609b = userActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        x4.w2 h;
        String str;
        String str2;
        int i = this.f1608a;
        int i6 = 1;
        t6.c cVar = null;
        UserActivity userActivity = this.f1609b;
        switch (i) {
            case 0:
                int i10 = UserActivity.W;
                userActivity.finish();
                break;
            case 1:
                int i11 = UserActivity.W;
                if (userActivity.T()) {
                    x4.w2 h6 = x4.u2.h(userActivity);
                    if (h6 == null) {
                        userActivity.B0();
                        break;
                    } else {
                        Intent intent = new Intent(userActivity, (Class<?>) UserAvatarActivity.class);
                        intent.putExtra("user", h6);
                        float f = UptodownApp.I;
                        userActivity.startActivity(intent, b4.d.a(userActivity));
                        break;
                    }
                }
                break;
            case 2:
                int i12 = UserActivity.W;
                if (x4.u2.h(userActivity) == null) {
                    userActivity.B0();
                    break;
                }
                break;
            case 3:
                int i13 = UserActivity.W;
                if (userActivity.T() && (h = x4.u2.h(userActivity)) != null && (str = h.f11431a) != null && str.length() != 0) {
                    o7.c0.s(LifecycleOwnerKt.getLifecycleScope(userActivity), null, null, new ya(userActivity, h, cVar, i6), 3);
                    break;
                }
                break;
            case 4:
                int i14 = UserActivity.W;
                Intent intent2 = new Intent(userActivity, (Class<?>) Updates.class);
                float f10 = UptodownApp.I;
                userActivity.startActivity(intent2, b4.d.a(userActivity));
                break;
            case 5:
                int i15 = UserActivity.W;
                Intent intent3 = new Intent(userActivity, (Class<?>) MyApps.class);
                float f11 = UptodownApp.I;
                userActivity.startActivity(intent3, b4.d.a(userActivity));
                break;
            case 6:
                int i16 = UserActivity.W;
                Intent intent4 = new Intent(userActivity, (Class<?>) MyDownloads.class);
                float f12 = UptodownApp.I;
                userActivity.startActivity(intent4, b4.d.a(userActivity));
                break;
            case 7:
                int i17 = UserActivity.W;
                Intent intent5 = new Intent(userActivity, (Class<?>) RollbackActivity.class);
                float f13 = UptodownApp.I;
                userActivity.startActivity(intent5, b4.d.a(userActivity));
                break;
            case 8:
                int i18 = UserActivity.W;
                if (userActivity.T()) {
                    x4.w2 h10 = x4.u2.h(userActivity);
                    if (h10 == null) {
                        userActivity.B0();
                        break;
                    } else {
                        Intent intent6 = new Intent(userActivity, (Class<?>) UserCommentsActivity.class);
                        intent6.putExtra("userID", h10.f11431a);
                        float f14 = UptodownApp.I;
                        userActivity.startActivity(intent6, b4.d.a(userActivity));
                        break;
                    }
                }
                break;
            case 9:
                int i19 = UserActivity.W;
                if (userActivity.T()) {
                    if (x4.u2.h(userActivity) == null) {
                        userActivity.B0();
                        break;
                    } else {
                        Intent intent7 = new Intent(userActivity, (Class<?>) FeedActivity.class);
                        float f15 = UptodownApp.I;
                        userActivity.startActivity(intent7, b4.d.a(userActivity));
                        break;
                    }
                }
                break;
            case 10:
                int i20 = UserActivity.W;
                if (userActivity.T()) {
                    if (x4.u2.h(userActivity) == null) {
                        userActivity.B0();
                        break;
                    } else {
                        Intent intent8 = new Intent(userActivity, (Class<?>) ListsActivity.class);
                        ActivityResultLauncher activityResultLauncher = userActivity.T;
                        float f16 = UptodownApp.I;
                        activityResultLauncher.launch(intent8, b4.d.b(userActivity));
                        break;
                    }
                }
                break;
            case 11:
                int i21 = UserActivity.W;
                if (userActivity.T()) {
                    if (x4.u2.h(userActivity) == null) {
                        userActivity.B0();
                        break;
                    } else {
                        userActivity.startActivity(new Intent(userActivity, (Class<?>) MyStatsActivity.class));
                        break;
                    }
                }
                break;
            case 12:
                int i22 = UserActivity.W;
                if (userActivity.T()) {
                    x4.w2 h11 = x4.u2.h(userActivity);
                    if (h11 != null && (str2 = h11.f11431a) != null && str2.length() != 0 && h11.d()) {
                        zc A0 = userActivity.A0();
                        A0.getClass();
                        o7.a0 viewModelScope = ViewModelKt.getViewModelScope(A0);
                        v7.e eVar = o7.m0.f8288a;
                        o7.c0.s(viewModelScope, v7.d.f10884a, null, new sc(userActivity, A0, cVar, i6), 2);
                        break;
                    } else {
                        userActivity.w0();
                        break;
                    }
                }
                break;
            case 13:
                int i23 = UserActivity.W;
                if (userActivity.T()) {
                    if (x4.u2.h(userActivity) == null) {
                        userActivity.B0();
                        break;
                    } else {
                        ActivityResultLauncher activityResultLauncher2 = userActivity.U;
                        Intent intent9 = new Intent(userActivity, (Class<?>) UserDevicesActivity.class);
                        float f17 = UptodownApp.I;
                        activityResultLauncher2.launch(intent9, b4.d.b(userActivity));
                        break;
                    }
                }
                break;
            case 14:
                int i24 = UserActivity.W;
                Intent intent10 = new Intent(userActivity, (Class<?>) NotificationsRegistryActivity.class);
                float f18 = UptodownApp.I;
                userActivity.startActivity(intent10, b4.d.a(userActivity));
                break;
            case 15:
                int i25 = UserActivity.W;
                Intent intent11 = new Intent(userActivity, (Class<?>) PreferencesActivity.class);
                ActivityResultLauncher activityResultLauncher3 = userActivity.S;
                float f19 = UptodownApp.I;
                activityResultLauncher3.launch(intent11, b4.d.b(userActivity));
                break;
            case 16:
                int i26 = UserActivity.W;
                if (userActivity.T()) {
                    j5.c.e(userActivity, userActivity.getString(2131952724) + "/android", null);
                    break;
                }
                break;
            case 17:
                int i27 = UserActivity.W;
                kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                a4.d0 k5 = a4.d0.k(userActivity.getLayoutInflater());
                TextView textView = (TextView) k5.f84n;
                textView.setTypeface(f4.c.f4883x);
                textView.setText(userActivity.getString(2131952170));
                TextView textView2 = (TextView) k5.f85o;
                textView2.setTypeface(f4.c.f4882w);
                textView2.setOnClickListener(new t(userActivity, userActivity, xVar, 7));
                TextView textView3 = (TextView) k5.f83m;
                textView3.setTypeface(f4.c.f4882w);
                textView3.setOnClickListener(new d5(xVar, i6));
                AlertDialog.Builder builder = new AlertDialog.Builder(userActivity);
                builder.setView((LinearLayout) k5.f81b);
                builder.setCancelable(true);
                AlertDialog create = builder.create();
                xVar.f7024a = create;
                if (create != null) {
                    Window window = create.getWindow();
                    if (window != null) {
                        a4.x.y(window, 0);
                    }
                    ((AlertDialog) xVar.f7024a).show();
                    break;
                }
                break;
            default:
                String str3 = userActivity.Q;
                if (str3 != null) {
                    j5.c.e(userActivity, str3, null);
                    break;
                }
                break;
        }
    }
}
