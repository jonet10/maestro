package com.google.android.material.behavior;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class a implements AccessibilityManager.TouchExplorationStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2957a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f2958b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout.Behavior f2959c;

    public /* synthetic */ a(CoordinatorLayout.Behavior behavior, View view, int i) {
        this.f2957a = i;
        this.f2959c = behavior;
        this.f2958b = view;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z9) {
        switch (this.f2957a) {
            case 0:
                ((HideBottomViewOnScrollBehavior) this.f2959c).lambda$disableIfTouchExplorationEnabled$0(this.f2958b, z9);
                break;
            default:
                ((HideViewOnScrollBehavior) this.f2959c).lambda$disableIfTouchExplorationEnabled$0(this.f2958b, z9);
                break;
        }
    }
}
