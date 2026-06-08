package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import com.google.android.material.internal.ExpandCollapseAnimationHelper;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.DeterminateDrawable;
import com.google.android.material.shape.MaterialShapeDrawable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class b implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2954a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2955b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2956c;

    public /* synthetic */ b(int i, Object obj, Object obj2) {
        this.f2954a = i;
        this.f2955b = obj;
        this.f2956c = obj2;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f2954a) {
            case 0:
                ((AppBarLayout) this.f2955b).lambda$initializeLiftOnScrollWithElevation$1((MaterialShapeDrawable) this.f2956c, valueAnimator);
                break;
            case 1:
                ((ExpandCollapseAnimationHelper) this.f2955b).lambda$getExpandCollapseAnimator$0((Rect) this.f2956c, valueAnimator);
                break;
            default:
                ((DeterminateDrawable) this.f2955b).lambda$new$0((BaseProgressIndicatorSpec) this.f2956c, valueAnimator);
                break;
        }
    }
}
