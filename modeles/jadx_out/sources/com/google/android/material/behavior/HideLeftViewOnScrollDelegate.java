package com.google.android.material.behavior;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
final class HideLeftViewOnScrollDelegate extends HideViewOnScrollDelegate {
    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    public <V extends View> int getSize(@NonNull V v, @NonNull ViewGroup.MarginLayoutParams marginLayoutParams) {
        return v.getMeasuredWidth() + marginLayoutParams.leftMargin;
    }

    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    public int getTargetTranslation() {
        return 0;
    }

    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    public int getViewEdge() {
        return 2;
    }

    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    public <V extends View> ViewPropertyAnimator getViewTranslationAnimator(@NonNull V v, int i) {
        return v.animate().translationX(-i);
    }

    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    public <V extends View> void setAdditionalHiddenOffset(@NonNull V v, int i, int i6) {
        v.setTranslationX(i - i6);
    }

    @Override // com.google.android.material.behavior.HideViewOnScrollDelegate
    public <V extends View> void setViewTranslation(@NonNull V v, int i) {
        v.setTranslationX(-i);
    }
}
