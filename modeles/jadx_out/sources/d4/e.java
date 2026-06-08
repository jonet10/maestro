package d4;

import android.app.Activity;
import android.content.Context;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class e extends AppCompatActivity {
    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        if (context != null) {
            Activity activity = f4.c.f4875o;
            context = t0.f.e(context);
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity
    public final void finish() {
        super.finish();
        overridePendingTransition(2130771997, 2130772025);
    }

    @Override // android.app.Activity
    public final boolean onOptionsItemSelected(MenuItem menuItem) {
        menuItem.getClass();
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        getOnBackPressedDispatcher().onBackPressed();
        return true;
    }
}
