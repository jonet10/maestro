package u4;

import android.view.View;
import android.view.ViewTreeObserver;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b0 implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f10429a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f10430b;

    public b0(View view, f0 f0Var) {
        this.f10429a = view;
        this.f10430b = f0Var;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        this.f10429a.getViewTreeObserver().removeOnPreDrawListener(this);
        this.f10430b.startPostponedEnterTransition();
        return true;
    }
}
