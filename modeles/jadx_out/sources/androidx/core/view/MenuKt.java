package androidx.core.view;

import android.view.Menu;
import android.view.MenuItem;
import java.util.Iterator;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MenuKt {
    public static final boolean contains(Menu menu, MenuItem menuItem) {
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            if (kotlin.jvm.internal.l.a(menu.getItem(i), menuItem)) {
                return true;
            }
        }
        return false;
    }

    public static final void forEach(Menu menu, d7.l lVar) {
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            lVar.invoke(menu.getItem(i));
        }
    }

    public static final void forEachIndexed(Menu menu, d7.p pVar) {
        int size = menu.size();
        for (int i = 0; i < size; i++) {
            pVar.invoke(Integer.valueOf(i), menu.getItem(i));
        }
    }

    public static final MenuItem get(Menu menu, int i) {
        return menu.getItem(i);
    }

    public static final k7.f getChildren(final Menu menu) {
        return new k7.f() { // from class: androidx.core.view.MenuKt$children$1
            @Override // k7.f
            public Iterator<MenuItem> iterator() {
                return MenuKt.iterator(menu);
            }
        };
    }

    public static final int getSize(Menu menu) {
        return menu.size();
    }

    public static final boolean isEmpty(Menu menu) {
        return menu.size() == 0;
    }

    public static final boolean isNotEmpty(Menu menu) {
        return menu.size() != 0;
    }

    public static final Iterator<MenuItem> iterator(Menu menu) {
        return new MenuKt$iterator$1(menu);
    }

    public static final void minusAssign(Menu menu, MenuItem menuItem) {
        menu.removeItem(menuItem.getItemId());
    }

    public static final void removeItemAt(Menu menu, int i) {
        x xVar;
        MenuItem item = menu.getItem(i);
        if (item != null) {
            menu.removeItem(item.getItemId());
            xVar = x.f8463a;
        } else {
            xVar = null;
        }
        if (xVar == null) {
            throw new IndexOutOfBoundsException();
        }
    }
}
