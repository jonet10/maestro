package c4;

import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.uptodown.UptodownApp;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r3 implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2041a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ KeyEvent.Callback f2042b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2043c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f2044d;

    public r3(k0 k0Var, n5.d dVar, n5.c cVar) {
        this.f2042b = k0Var;
        this.f2043c = dVar;
        this.f2044d = cVar;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        switch (this.f2041a) {
            case 0:
                new Handler(Looper.getMainLooper()).postDelayed(new a2.r((ImageView) this.f2042b, (Animation) this.f2044d, (ImageView) this.f2043c, animation, 2), 1500L);
                return;
            default:
                n5.d dVar = (n5.d) this.f2043c;
                RelativeLayout relativeLayout = dVar.f8073e;
                if (relativeLayout == null) {
                    kotlin.jvm.internal.l.i("rlAppInfoSelected");
                    throw null;
                }
                relativeLayout.setVisibility(8);
                dVar.f8070b.setVisibility(8);
                dVar.f8079p.set(false);
                return;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i = this.f2041a;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        switch (this.f2041a) {
            case 0:
                return;
            default:
                k0 k0Var = (k0) this.f2042b;
                k0Var.getClass();
                View view = ((n5.d) this.f2043c).f8072d;
                if (view == null) {
                    kotlin.jvm.internal.l.i("vBackground");
                    throw null;
                }
                n5.c cVar = (n5.c) this.f2044d;
                Animation loadAnimation = AnimationUtils.loadAnimation(k0Var, 2130771998);
                float f = UptodownApp.I;
                boolean z9 = true;
                try {
                    SharedPreferences sharedPreferences = k0Var.getSharedPreferences("SettingsPreferences", 0);
                    if (sharedPreferences.contains("animations")) {
                        z9 = sharedPreferences.getBoolean("animations", true);
                    }
                } catch (Exception unused) {
                }
                if (!z9) {
                    cVar.onAnimationEnd(loadAnimation);
                    return;
                }
                float f10 = UptodownApp.I;
                loadAnimation.setAnimationListener(cVar);
                view.startAnimation(loadAnimation);
                return;
        }
    }

    public r3(ImageView imageView, Animation animation, ImageView imageView2) {
        this.f2042b = imageView;
        this.f2044d = animation;
        this.f2043c = imageView2;
    }

    private final void a(Animation animation) {
    }

    private final void b(Animation animation) {
    }

    private final void c(Animation animation) {
    }
}
