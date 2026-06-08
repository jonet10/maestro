package androidx.core.view;

import a4.x;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Px;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ViewGroupKt {
    public static final boolean contains(ViewGroup viewGroup, View view) {
        return viewGroup.indexOfChild(view) != -1;
    }

    public static final void forEach(ViewGroup viewGroup, d7.l lVar) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            lVar.invoke(viewGroup.getChildAt(i));
        }
    }

    public static final void forEachIndexed(ViewGroup viewGroup, d7.p pVar) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            pVar.invoke(Integer.valueOf(i), viewGroup.getChildAt(i));
        }
    }

    public static final View get(ViewGroup viewGroup, int i) {
        View childAt = viewGroup.getChildAt(i);
        if (childAt != null) {
            return childAt;
        }
        com.google.gson.internal.a.g(viewGroup.getChildCount(), x.p(i, "Index: ", ", Size: "));
        return null;
    }

    public static final k7.f getChildren(final ViewGroup viewGroup) {
        return new k7.f() { // from class: androidx.core.view.ViewGroupKt$children$1
            @Override // k7.f
            public Iterator<View> iterator() {
                return ViewGroupKt.iterator(viewGroup);
            }
        };
    }

    public static final k7.f getDescendants(final ViewGroup viewGroup) {
        return new k7.f() { // from class: androidx.core.view.ViewGroupKt$special$$inlined$Sequence$1
            @Override // k7.f
            public Iterator<View> iterator() {
                return new TreeIterator(ViewGroupKt.getChildren(viewGroup).iterator(), ViewGroupKt$descendants$1$1.INSTANCE);
            }
        };
    }

    public static final i7.d getIndices(ViewGroup viewGroup) {
        return t0.f.K(0, viewGroup.getChildCount());
    }

    public static final int getSize(ViewGroup viewGroup) {
        return viewGroup.getChildCount();
    }

    public static final boolean isEmpty(ViewGroup viewGroup) {
        return viewGroup.getChildCount() == 0;
    }

    public static final boolean isNotEmpty(ViewGroup viewGroup) {
        return viewGroup.getChildCount() != 0;
    }

    public static final Iterator<View> iterator(ViewGroup viewGroup) {
        return new ViewGroupKt$iterator$1(viewGroup);
    }

    public static final void minusAssign(ViewGroup viewGroup, View view) {
        viewGroup.removeView(view);
    }

    public static final void plusAssign(ViewGroup viewGroup, View view) {
        viewGroup.addView(view);
    }

    public static final void setMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i) {
        marginLayoutParams.setMargins(i, i, i, i);
    }

    public static final void updateMargins(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i, @Px int i6, @Px int i10, @Px int i11) {
        marginLayoutParams.setMargins(i, i6, i10, i11);
    }

    public static /* synthetic */ void updateMargins$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = marginLayoutParams.leftMargin;
        }
        if ((i12 & 2) != 0) {
            i6 = marginLayoutParams.topMargin;
        }
        if ((i12 & 4) != 0) {
            i10 = marginLayoutParams.rightMargin;
        }
        if ((i12 & 8) != 0) {
            i11 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMargins(i, i6, i10, i11);
    }

    public static final void updateMarginsRelative(ViewGroup.MarginLayoutParams marginLayoutParams, @Px int i, @Px int i6, @Px int i10, @Px int i11) {
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i6;
        marginLayoutParams.setMarginEnd(i10);
        marginLayoutParams.bottomMargin = i11;
    }

    public static /* synthetic */ void updateMarginsRelative$default(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = marginLayoutParams.getMarginStart();
        }
        if ((i12 & 2) != 0) {
            i6 = marginLayoutParams.topMargin;
        }
        if ((i12 & 4) != 0) {
            i10 = marginLayoutParams.getMarginEnd();
        }
        if ((i12 & 8) != 0) {
            i11 = marginLayoutParams.bottomMargin;
        }
        marginLayoutParams.setMarginStart(i);
        marginLayoutParams.topMargin = i6;
        marginLayoutParams.setMarginEnd(i10);
        marginLayoutParams.bottomMargin = i11;
    }
}
