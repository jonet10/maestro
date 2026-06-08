package com.google.android.material.search;

import android.animation.Animator;
import android.view.View;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.animation.AnimatableView;
import com.google.android.material.internal.ViewUtils;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class i implements ViewUtils.OnApplyWindowInsetsListener, OnApplyWindowInsetsListener, AnimatableView.Listener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f3032a;

    public /* synthetic */ i(Object obj) {
        this.f3032a = obj;
    }

    @Override // com.google.android.material.animation.AnimatableView.Listener
    public void onAnimationEnd() {
        ((Animator) this.f3032a).start();
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat lambda$setUpStatusBarSpacerInsetListener$5;
        lambda$setUpStatusBarSpacerInsetListener$5 = ((SearchView) this.f3032a).lambda$setUpStatusBarSpacerInsetListener$5(view, windowInsetsCompat);
        return lambda$setUpStatusBarSpacerInsetListener$5;
    }

    @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
        WindowInsetsCompat lambda$setUpToolbarInsetListener$4;
        lambda$setUpToolbarInsetListener$4 = ((SearchView) this.f3032a).lambda$setUpToolbarInsetListener$4(view, windowInsetsCompat, relativePadding);
        return lambda$setUpToolbarInsetListener$4;
    }
}
