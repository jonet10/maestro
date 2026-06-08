package f5;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.media.g;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import androidx.core.app.ActivityOptionsCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import androidx.lifecycle.LifecycleOwnerKt;
import c4.sc;
import com.uptodown.UptodownApp;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import com.uptodown.tv.ui.activity.TvSearchActivity;
import r7.k0;
import r7.o;
import t0.f;
import x4.d0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a extends FragmentActivity {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f4891b = 0;

    /* renamed from: a, reason: collision with root package name */
    public g f4892a;

    @Override // android.app.Activity, android.view.ContextThemeWrapper, android.content.ContextWrapper
    public final void attachBaseContext(Context context) {
        if (context != null) {
            Activity activity = f4.c.f4875o;
            context = f.e(context);
        }
        super.attachBaseContext(context);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent == null || motionEvent.getSource() != 8194) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return true;
    }

    public void h(d0 d0Var) {
        d0Var.getClass();
    }

    public boolean i() {
        return !(this instanceof TvAppDetailActivity);
    }

    public final void j(x4.g gVar, Presenter.ViewHolder viewHolder) {
        gVar.getClass();
        Intent intent = new Intent(this, (Class<?>) TvAppDetailActivity.class);
        intent.putExtra("appInfo", gVar);
        View view = viewHolder.view;
        ImageCardView imageCardView = view instanceof ImageCardView ? (ImageCardView) view : null;
        ImageView mainImageView = imageCardView != null ? imageCardView.getMainImageView() : null;
        float f = UptodownApp.I;
        boolean z9 = true;
        try {
            SharedPreferences sharedPreferences = getSharedPreferences("SettingsPreferences", 0);
            if (sharedPreferences.contains("animations")) {
                z9 = sharedPreferences.getBoolean("animations", true);
            }
        } catch (Exception unused) {
        }
        if (!z9 || mainImageView == null) {
            startActivity(intent);
        } else {
            startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this, mainImageView, "transition_name").toBundle());
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f4892a = new g(this, 20);
        k0.n(new o(a5.b.f196d, new sc(this, (t6.c) null, 5)), LifecycleOwnerKt.getLifecycleScope(this));
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public final boolean onSearchRequested() {
        startActivity(new Intent(this, (Class<?>) TvSearchActivity.class));
        return true;
    }
}
