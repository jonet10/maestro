package com.google.android.material.textfield;

import android.animation.ValueAnimator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class c implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3056a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ EndIconDelegate f3057b;

    public /* synthetic */ c(EndIconDelegate endIconDelegate, int i) {
        this.f3056a = i;
        this.f3057b = endIconDelegate;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f3056a) {
            case 0:
                ((ClearTextEndIconDelegate) this.f3057b).lambda$getAlphaAnimator$3(valueAnimator);
                break;
            case 1:
                ((ClearTextEndIconDelegate) this.f3057b).lambda$getScaleAnimator$4(valueAnimator);
                break;
            default:
                ((DropdownMenuEndIconDelegate) this.f3057b).lambda$getAlphaAnimator$6(valueAnimator);
                break;
        }
    }
}
