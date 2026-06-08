package com.google.android.material.motion;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.navigation.DrawerLayoutUtils;
import com.google.android.material.progressindicator.DeterminateDrawable;
import com.uptodown.util.views.UsernameTextView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3009a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3010b;

    public /* synthetic */ c(Object obj, int i) {
        this.f3009a = i;
        this.f3010b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f3009a) {
            case 0:
                MaterialMainContainerBackHelper.lambda$createCornerAnimator$1((ClippableRoundedCornerLayout) this.f3010b, valueAnimator);
                break;
            case 1:
                DrawerLayoutUtils.lambda$getScrimCloseAnimatorUpdateListener$0((DrawerLayout) this.f3010b, valueAnimator);
                break;
            case 2:
                ((DeterminateDrawable) this.f3010b).lambda$maybeInitializeAmplitudeAnimator$1(valueAnimator);
                break;
            case 3:
                UsernameTextView usernameTextView = (UsernameTextView) this.f3010b;
                valueAnimator.getClass();
                Object animatedValue = valueAnimator.getAnimatedValue();
                animatedValue.getClass();
                usernameTextView.f3454b = ((Float) animatedValue).floatValue();
                usernameTextView.invalidate();
                break;
            default:
                View view = (View) this.f3010b;
                valueAnimator.getClass();
                Object animatedValue2 = valueAnimator.getAnimatedValue();
                animatedValue2.getClass();
                view.setAlpha(((Float) animatedValue2).floatValue());
                break;
        }
    }
}
