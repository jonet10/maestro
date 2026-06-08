package androidx.activity;

import android.view.View;
import k7.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ViewTreeOnBackPressedDispatcherOwner {
    public static final OnBackPressedDispatcherOwner get(View view) {
        view.getClass();
        k7.f h02 = i.h0(ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$1.INSTANCE, view);
        ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2 viewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2 = ViewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2.INSTANCE;
        viewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2.getClass();
        k7.c cVar = new k7.c(new k7.d(new k7.d(h02, viewTreeOnBackPressedDispatcherOwner$findViewTreeOnBackPressedDispatcherOwner$2), new androidx.room.f(28)));
        return (OnBackPressedDispatcherOwner) (!cVar.hasNext() ? null : cVar.next());
    }

    public static final void set(View view, OnBackPressedDispatcherOwner onBackPressedDispatcherOwner) {
        view.getClass();
        onBackPressedDispatcherOwner.getClass();
        view.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, onBackPressedDispatcherOwner);
    }
}
