package com.google.android.material.sidesheet;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
abstract class SheetDelegate {
    public abstract int calculateInnerMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract float calculateSlideOffset(int i);

    public abstract int getCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams);

    public abstract int getExpandedOffset();

    public abstract int getHiddenOffset();

    public abstract int getMaxViewPositionHorizontal();

    public abstract int getMinViewPositionHorizontal();

    public abstract <V extends View> int getOuterEdge(@NonNull V v);

    public abstract int getParentInnerEdge(@NonNull CoordinatorLayout coordinatorLayout);

    public abstract int getSheetEdge();

    public abstract boolean isExpandingOutwards(float f);

    public abstract boolean isReleasedCloseToInnerEdge(@NonNull View view);

    public abstract boolean isSwipeSignificant(float f, float f10);

    public abstract boolean shouldHide(@NonNull View view, float f);

    public abstract void updateCoplanarSiblingAdjacentMargin(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i);

    public abstract void updateCoplanarSiblingLayoutParams(@NonNull ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i6);
}
