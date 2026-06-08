package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.view.View;
import android.widget.ImageButton;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import com.google.android.material.internal.FadeThroughDrawable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3012a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3013b;

    public /* synthetic */ a(Object obj, int i) {
        this.f3012a = i;
        this.f3013b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f3012a) {
            case 0:
                ((View) this.f3013b).setAlpha(0.0f);
                break;
            case 1:
                SearchViewAnimationHelper.lambda$addDrawerArrowDrawableAnimatorIfNeeded$4((DrawerArrowDrawable) this.f3013b, valueAnimator);
                break;
            case 2:
                SearchViewAnimationHelper.lambda$addFadeThroughDrawableAnimatorIfNeeded$5((FadeThroughDrawable) this.f3013b, valueAnimator);
                break;
            case 3:
                ((SearchViewAnimationHelper) this.f3013b).lambda$addTextFadeAnimatorIfNeeded$7(valueAnimator);
                break;
            default:
                SearchViewAnimationHelper.lambda$addBackButtonAnimatorIfNeeded$3((ImageButton) this.f3013b, valueAnimator);
                break;
        }
    }
}
