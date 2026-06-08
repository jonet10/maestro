package a4;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import java.lang.ref.WeakReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final l0 f131a;

    /* renamed from: b, reason: collision with root package name */
    public final WeakReference f132b;

    /* renamed from: l, reason: collision with root package name */
    public i f133l;

    public l(l0 l0Var, ImageView imageView, i iVar) {
        this.f131a = l0Var;
        this.f132b = new WeakReference(imageView);
        this.f133l = iVar;
        imageView.addOnAttachStateChangeListener(this);
        if (imageView.getWindowToken() != null) {
            imageView.getViewTreeObserver().addOnPreDrawListener(this);
        }
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        WeakReference weakReference = this.f132b;
        ImageView imageView = (ImageView) weakReference.get();
        if (imageView != null) {
            ViewTreeObserver viewTreeObserver = imageView.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                int width = imageView.getWidth();
                int height = imageView.getHeight();
                if (width > 0 && height > 0) {
                    imageView.removeOnAttachStateChangeListener(this);
                    viewTreeObserver.removeOnPreDrawListener(this);
                    weakReference.clear();
                    l0 l0Var = this.f131a;
                    l0Var.f136c = false;
                    l0Var.f135b.e(width, height);
                    l0Var.e(imageView, this.f133l);
                }
            }
        }
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        view.getViewTreeObserver().addOnPreDrawListener(this);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        view.getViewTreeObserver().removeOnPreDrawListener(this);
    }
}
