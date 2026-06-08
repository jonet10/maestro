package c4;

import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.LinearLayout;
import com.uptodown.activities.LoginActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l2 implements Animation.AnimationListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1817a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LoginActivity f1818b;

    public /* synthetic */ l2(LoginActivity loginActivity, int i) {
        this.f1817a = i;
        this.f1818b = loginActivity;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationEnd(Animation animation) {
        int i = this.f1817a;
        LoginActivity loginActivity = this.f1818b;
        animation.getClass();
        switch (i) {
            case 0:
                int i6 = LoginActivity.W;
                ((LinearLayout) loginActivity.G0().f10132l.f5272q).setVisibility(8);
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation.setInterpolator(new AccelerateInterpolator());
                alphaAnimation.setDuration(200L);
                alphaAnimation.setAnimationListener(new l2(loginActivity, 3));
                ((LinearLayout) loginActivity.G0().f10133m.f8816b).setVisibility(0);
                ((LinearLayout) loginActivity.G0().f10133m.f8816b).startAnimation(alphaAnimation);
                break;
            case 1:
                int i10 = LoginActivity.W;
                ((LinearLayout) loginActivity.G0().f10133m.f8816b).setVisibility(8);
                AlphaAnimation alphaAnimation2 = new AlphaAnimation(0.0f, 1.0f);
                alphaAnimation2.setInterpolator(new AccelerateInterpolator());
                alphaAnimation2.setDuration(200L);
                alphaAnimation2.setAnimationListener(new l2(loginActivity, 2));
                ((LinearLayout) loginActivity.G0().f10132l.f5272q).setVisibility(0);
                ((LinearLayout) loginActivity.G0().f10132l.f5272q).startAnimation(alphaAnimation2);
                break;
            case 2:
                int i11 = LoginActivity.W;
                ((LinearLayout) loginActivity.G0().f10132l.f5272q).setVisibility(0);
                loginActivity.G0().f10135o.setText(2131952650);
                break;
            default:
                int i12 = LoginActivity.W;
                ((LinearLayout) loginActivity.G0().f10133m.f8816b).setVisibility(0);
                loginActivity.G0().f10135o.setText(2131952654);
                break;
        }
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationRepeat(Animation animation) {
        int i = this.f1817a;
        animation.getClass();
    }

    @Override // android.view.animation.Animation.AnimationListener
    public final void onAnimationStart(Animation animation) {
        int i = this.f1817a;
        animation.getClass();
    }
}
