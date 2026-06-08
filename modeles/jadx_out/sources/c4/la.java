package c4;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.MenuItem;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.uptodown.UptodownApp;
import com.uptodown.activities.Updates;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class la implements ActivityResultCallback, Toolbar.OnMenuItemClickListener, SwipeRefreshLayout.OnRefreshListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Updates f1836a;

    public /* synthetic */ la(Updates updates) {
        this.f1836a = updates;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        int i = Updates.n0;
        if (((ActivityResult) obj).getResultCode() == -1) {
            Updates updates = this.f1836a;
            updates.E = new android.support.v4.media.g(updates, 20);
            updates.X0(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        int i = Updates.n0;
        menuItem.getClass();
        int itemId = menuItem.getItemId();
        Updates updates = this.f1836a;
        if (itemId == 2131361894) {
            boolean isChecked = menuItem.isChecked();
            boolean z9 = !isChecked;
            menuItem.setChecked(z9);
            Context applicationContext = updates.getApplicationContext();
            applicationContext.getClass();
            SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("SettingsPreferences", 0);
            sharedPreferences.getClass();
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putBoolean("show_system_apps", z9);
            edit.apply();
            if (isChecked) {
                Context applicationContext2 = updates.getApplicationContext();
                applicationContext2.getClass();
                SharedPreferences sharedPreferences2 = applicationContext2.getSharedPreferences("SettingsPreferences", 0);
                sharedPreferences2.getClass();
                SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                edit2.putBoolean("show_system_services", false);
                edit2.apply();
                w4.C0(updates.T0().f10253r, false);
                Toolbar toolbar = updates.T0().f10253r;
                if (toolbar.getMenu() != null) {
                    Menu menu = toolbar.getMenu();
                    menu.getClass();
                    menu.findItem(2131361895).setChecked(false);
                }
                updates.X0(true);
                return true;
            }
            w4.C0(updates.T0().f10253r, true);
            float f = UptodownApp.I;
            if (b4.d.F(updates)) {
                r7.o0 o0Var = updates.U0().f1568c;
                Boolean bool = Boolean.TRUE;
                o0Var.getClass();
                o0Var.g(null, bool);
                return true;
            }
        } else if (menuItem.getItemId() == 2131361895) {
            boolean isChecked2 = menuItem.isChecked();
            boolean z10 = !isChecked2;
            menuItem.setChecked(z10);
            Context applicationContext3 = updates.getApplicationContext();
            applicationContext3.getClass();
            SharedPreferences sharedPreferences3 = applicationContext3.getSharedPreferences("SettingsPreferences", 0);
            sharedPreferences3.getClass();
            SharedPreferences.Editor edit3 = sharedPreferences3.edit();
            edit3.putBoolean("show_system_services", z10);
            edit3.apply();
            if (isChecked2) {
                updates.X0(true);
            } else {
                float f10 = UptodownApp.I;
                if (b4.d.F(updates)) {
                    r7.o0 o0Var2 = updates.U0().f1568c;
                    Boolean bool2 = Boolean.TRUE;
                    o0Var2.getClass();
                    o0Var2.g(null, bool2);
                    return true;
                }
            }
        }
        return true;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        int i = Updates.n0;
        float f = UptodownApp.I;
        Updates updates = this.f1836a;
        if (!b4.d.F(updates)) {
            updates.T0().f10252q.setRefreshing(false);
            return;
        }
        r7.o0 o0Var = updates.U0().f1568c;
        Boolean bool = Boolean.TRUE;
        o0Var.getClass();
        o0Var.g(null, bool);
    }
}
