package androidx.core.view;

import android.view.ViewParent;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public /* synthetic */ class ViewKt$ancestors$1 extends kotlin.jvm.internal.k implements d7.l {
    public static final ViewKt$ancestors$1 INSTANCE = new ViewKt$ancestors$1();

    public ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    @Override // d7.l
    public final ViewParent invoke(ViewParent viewParent) {
        return viewParent.getParent();
    }
}
