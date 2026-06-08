package com.google.android.material.navigation;

import a3.b;
import a4.x;
import android.content.Context;
import android.view.MenuItem;
import android.view.SubMenu;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class NavigationBarMenu extends MenuBuilder {
    public static final int NO_MAX_ITEM_LIMIT = Integer.MAX_VALUE;
    private final int maxItemCount;
    private final boolean subMenuSupported;

    @NonNull
    private final Class<?> viewClass;

    public NavigationBarMenu(@NonNull Context context, @NonNull Class<?> cls, int i, boolean z9) {
        super(context);
        this.viewClass = cls;
        this.maxItemCount = i;
        this.subMenuSupported = z9;
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder
    @NonNull
    public MenuItem addInternal(int i, int i6, int i10, @NonNull CharSequence charSequence) {
        if (size() + 1 <= this.maxItemCount) {
            stopDispatchingItemsChanged();
            MenuItem addInternal = super.addInternal(i, i6, i10, charSequence);
            startDispatchingItemsChanged();
            return addInternal;
        }
        String simpleName = this.viewClass.getSimpleName();
        StringBuilder v = x.v("Maximum number of items supported by ", simpleName, " is ");
        v.append(this.maxItemCount);
        v.append(". Limit can be checked with ");
        v.append(simpleName);
        v.append("#getMaxItemCount()");
        throw new IllegalArgumentException(v.toString());
    }

    @Override // androidx.appcompat.view.menu.MenuBuilder, android.view.Menu
    @NonNull
    public SubMenu addSubMenu(int i, int i6, int i10, @NonNull CharSequence charSequence) {
        if (!this.subMenuSupported) {
            b.r(this.viewClass.getSimpleName().concat(" does not support submenus"));
            return null;
        }
        MenuItemImpl menuItemImpl = (MenuItemImpl) addInternal(i, i6, i10, charSequence);
        NavigationBarSubMenu navigationBarSubMenu = new NavigationBarSubMenu(getContext(), this, menuItemImpl);
        menuItemImpl.setSubMenu(navigationBarSubMenu);
        return navigationBarSubMenu;
    }

    public int getMaxItemCount() {
        return this.maxItemCount;
    }
}
