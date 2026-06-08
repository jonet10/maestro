package com.google.android.material.navigation;

import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public interface NavigationBarMenuItemView extends MenuView.ItemView {
    boolean isExpanded();

    boolean isOnlyVisibleWhenExpanded();

    void setExpanded(boolean z9);

    void setOnlyShowWhenExpanded(boolean z9);
}
