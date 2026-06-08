package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import com.google.android.material.shape.MaterialShapeDrawable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class d implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3020a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f3021b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f3022c;

    public /* synthetic */ d(int i, Object obj, Object obj2) {
        this.f3020a = i;
        this.f3021b = obj;
        this.f3022c = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f3020a) {
            case 0:
                SearchBarAnimationHelper.lambda$getExpandedViewBackgroundUpdateListener$1((MaterialShapeDrawable) this.f3021b, (View) this.f3022c, valueAnimator);
                break;
            default:
                ((SearchViewAnimationHelper) this.f3021b).lambda$addEditTextClipAnimator$6((Rect) this.f3022c, valueAnimator);
                break;
        }
    }
}
