package c4;

import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.PointerIconCompat;
import androidx.viewbinding.ViewBindings;
import com.uptodown.UptodownApp;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.UserActivity;
import com.uptodown.activities.UserEditProfileActivity;
import com.uptodown.activities.preferences.PreferencesActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class gb implements Toolbar.OnMenuItemClickListener, ActivityResultCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1647a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ UserActivity f1648b;

    public /* synthetic */ gb(UserActivity userActivity, int i) {
        this.f1647a = i;
        this.f1648b = userActivity;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        int i = this.f1647a;
        UserActivity userActivity = this.f1648b;
        ActivityResult activityResult = (ActivityResult) obj;
        switch (i) {
            case 1:
                int i6 = UserActivity.W;
                int resultCode = activityResult.getResultCode();
                if (resultCode == -1) {
                    userActivity.y0(userActivity);
                    userActivity.setResult(-1);
                    break;
                } else if (resultCode == 1) {
                    userActivity.setResult(1);
                    break;
                } else if (resultCode == 1002) {
                    Intent intent = new Intent(userActivity, (Class<?>) PreferencesActivity.class);
                    ActivityResultLauncher activityResultLauncher = userActivity.S;
                    float f = UptodownApp.I;
                    activityResultLauncher.launch(intent, b4.d.b(userActivity));
                    break;
                }
                break;
            case 2:
                int i10 = UserActivity.W;
                if (activityResult.getResultCode() == 1003) {
                    j5.g l10 = j5.g.D.l(userActivity);
                    l10.b();
                    SQLiteDatabase sQLiteDatabase = l10.f6673a;
                    sQLiteDatabase.getClass();
                    sQLiteDatabase.delete("responses", null, null);
                    l10.c();
                    userActivity.setResult(PointerIconCompat.TYPE_HELP);
                    userActivity.finish();
                    break;
                }
                break;
            case 3:
                int i11 = UserActivity.W;
                if (activityResult.getResultCode() == 1) {
                    userActivity.finish();
                    break;
                }
                break;
            case 4:
                int i12 = UserActivity.W;
                if (activityResult.getResultCode() == 5) {
                    userActivity.y0(userActivity);
                    break;
                }
                break;
            default:
                int i13 = UserActivity.W;
                if (activityResult.getResultCode() == 2) {
                    userActivity.y0(userActivity);
                    userActivity.B0();
                    break;
                }
                break;
        }
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        String str;
        SharedPreferences sharedPreferences;
        int i = UserActivity.W;
        menuItem.getClass();
        int itemId = menuItem.getItemId();
        final UserActivity userActivity = this.f1648b;
        final int i6 = 1;
        if (itemId == 2131361889) {
            float f = UptodownApp.I;
            if (b4.d.t() && userActivity.T()) {
                userActivity.startActivity(new Intent(userActivity, (Class<?>) SecurityActivity.class), b4.d.a(userActivity));
                return true;
            }
        } else {
            final int i10 = 0;
            if (menuItem.getItemId() == 2131361871) {
                final kotlin.jvm.internal.x xVar = new kotlin.jvm.internal.x();
                View inflate = userActivity.getLayoutInflater().inflate(2131558502, (ViewGroup) null, false);
                int i11 = 2131363061;
                RadioButton radioButton = (RadioButton) ViewBindings.findChildViewById(inflate, 2131363061);
                if (radioButton != null) {
                    i11 = 2131363062;
                    RadioButton radioButton2 = (RadioButton) ViewBindings.findChildViewById(inflate, 2131363062);
                    if (radioButton2 != null) {
                        i11 = 2131363063;
                        RadioButton radioButton3 = (RadioButton) ViewBindings.findChildViewById(inflate, 2131363063);
                        if (radioButton3 != null) {
                            i11 = 2131364373;
                            TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131364373);
                            if (textView != null) {
                                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
                                textView.setTypeface(f4.c.f4882w);
                                radioButton2.setTypeface(f4.c.f4883x);
                                radioButton.setTypeface(f4.c.f4883x);
                                radioButton3.setTypeface(f4.c.f4883x);
                                String str2 = "system";
                                try {
                                    SharedPreferences sharedPreferences2 = userActivity.getSharedPreferences("SettingsPreferences", 0);
                                    if (sharedPreferences2.contains("dark_mode")) {
                                        String string = sharedPreferences2.getString("dark_mode", "system");
                                        string.getClass();
                                        str2 = string;
                                    }
                                } catch (Exception unused) {
                                }
                                if (str2.equalsIgnoreCase("yes")) {
                                    radioButton2.setChecked(true);
                                } else if (str2.equalsIgnoreCase("no")) {
                                    radioButton.setChecked(true);
                                } else {
                                    radioButton3.setChecked(true);
                                }
                                radioButton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: c4.hb
                                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z9) {
                                        int i12 = i10;
                                        UserActivity userActivity2 = userActivity;
                                        kotlin.jvm.internal.x xVar2 = xVar;
                                        switch (i12) {
                                            case 0:
                                                int i13 = UserActivity.W;
                                                if (z9) {
                                                    Object obj = xVar2.f7024a;
                                                    obj.getClass();
                                                    ((AlertDialog) obj).dismiss();
                                                    SharedPreferences sharedPreferences3 = userActivity2.getSharedPreferences("SettingsPreferences", 0);
                                                    sharedPreferences3.getClass();
                                                    SharedPreferences.Editor edit = sharedPreferences3.edit();
                                                    edit.putString("dark_mode", "yes");
                                                    edit.apply();
                                                    AppCompatDelegate.setDefaultNightMode(2);
                                                    UptodownApp.f3292f0 = true;
                                                    break;
                                                }
                                                break;
                                            default:
                                                int i14 = UserActivity.W;
                                                if (z9) {
                                                    Object obj2 = xVar2.f7024a;
                                                    obj2.getClass();
                                                    ((AlertDialog) obj2).dismiss();
                                                    SharedPreferences sharedPreferences4 = userActivity2.getSharedPreferences("SettingsPreferences", 0);
                                                    sharedPreferences4.getClass();
                                                    SharedPreferences.Editor edit2 = sharedPreferences4.edit();
                                                    edit2.putString("dark_mode", "no");
                                                    edit2.apply();
                                                    AppCompatDelegate.setDefaultNightMode(1);
                                                    UptodownApp.f3292f0 = true;
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                });
                                radioButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: c4.hb
                                    @Override // android.widget.CompoundButton.OnCheckedChangeListener
                                    public final void onCheckedChanged(CompoundButton compoundButton, boolean z9) {
                                        int i12 = i6;
                                        UserActivity userActivity2 = userActivity;
                                        kotlin.jvm.internal.x xVar2 = xVar;
                                        switch (i12) {
                                            case 0:
                                                int i13 = UserActivity.W;
                                                if (z9) {
                                                    Object obj = xVar2.f7024a;
                                                    obj.getClass();
                                                    ((AlertDialog) obj).dismiss();
                                                    SharedPreferences sharedPreferences3 = userActivity2.getSharedPreferences("SettingsPreferences", 0);
                                                    sharedPreferences3.getClass();
                                                    SharedPreferences.Editor edit = sharedPreferences3.edit();
                                                    edit.putString("dark_mode", "yes");
                                                    edit.apply();
                                                    AppCompatDelegate.setDefaultNightMode(2);
                                                    UptodownApp.f3292f0 = true;
                                                    break;
                                                }
                                                break;
                                            default:
                                                int i14 = UserActivity.W;
                                                if (z9) {
                                                    Object obj2 = xVar2.f7024a;
                                                    obj2.getClass();
                                                    ((AlertDialog) obj2).dismiss();
                                                    SharedPreferences sharedPreferences4 = userActivity2.getSharedPreferences("SettingsPreferences", 0);
                                                    sharedPreferences4.getClass();
                                                    SharedPreferences.Editor edit2 = sharedPreferences4.edit();
                                                    edit2.putString("dark_mode", "no");
                                                    edit2.apply();
                                                    AppCompatDelegate.setDefaultNightMode(1);
                                                    UptodownApp.f3292f0 = true;
                                                    break;
                                                }
                                                break;
                                        }
                                    }
                                });
                                radioButton3.setOnCheckedChangeListener(new ib(xVar, userActivity));
                                AlertDialog.Builder builder = new AlertDialog.Builder(userActivity);
                                builder.setView(coordinatorLayout);
                                builder.setCancelable(true);
                                AlertDialog create = builder.create();
                                xVar.f7024a = create;
                                if (create != null) {
                                    Window window = create.getWindow();
                                    if (window != null) {
                                        a4.x.y(window, 0);
                                    }
                                    ((AlertDialog) xVar.f7024a).show();
                                }
                            }
                        }
                    }
                }
                com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i11)));
                return false;
            }
            if (menuItem.getItemId() == 2131361875) {
                SharedPreferences sharedPreferences3 = userActivity.getSharedPreferences("SharedPreferencesUser", 0);
                try {
                    sharedPreferences = userActivity.getSharedPreferences("SettingsPreferences", 0);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                if (sharedPreferences.contains("UTOKEN")) {
                    str = sharedPreferences.getString("UTOKEN", null);
                    if (str == null || sharedPreferences3.getString("is_turbo", null) != null) {
                        Intent intent = new Intent(userActivity, (Class<?>) UserEditProfileActivity.class);
                        ActivityResultLauncher activityResultLauncher = userActivity.V;
                        float f10 = UptodownApp.I;
                        activityResultLauncher.launch(intent, b4.d.b(userActivity));
                    } else {
                        userActivity.B0();
                    }
                }
                str = null;
                if (str == null) {
                }
                Intent intent2 = new Intent(userActivity, (Class<?>) UserEditProfileActivity.class);
                ActivityResultLauncher activityResultLauncher2 = userActivity.V;
                float f102 = UptodownApp.I;
                activityResultLauncher2.launch(intent2, b4.d.b(userActivity));
            }
        }
        return true;
    }
}
