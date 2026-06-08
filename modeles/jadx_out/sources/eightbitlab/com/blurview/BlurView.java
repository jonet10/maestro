package eightbitlab.com.blurview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import q1.a;
import t5.b;
import t5.d;
import t5.e;
import t5.f;
import t5.g;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class BlurView extends FrameLayout {

    /* renamed from: a, reason: collision with root package name */
    public b f4792a;

    /* renamed from: b, reason: collision with root package name */
    public int f4793b;

    public BlurView(Context context) {
        super(context);
        this.f4792a = new a(7);
        a(null, 0);
    }

    @NonNull
    @RequiresApi(api = 17)
    private t5.a getBlurAlgorithm() {
        return Build.VERSION.SDK_INT >= 31 ? new f() : new g(getContext());
    }

    public final void a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, e.f10300a, i, 0);
        this.f4793b = obtainStyledAttributes.getColor(0, 0);
        obtainStyledAttributes.recycle();
    }

    public final d b(ViewGroup viewGroup) {
        this.f4792a.destroy();
        d dVar = new d(this, viewGroup, this.f4793b, getBlurAlgorithm());
        this.f4792a = dVar;
        return dVar;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        if (this.f4792a.draw(canvas)) {
            super.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isHardwareAccelerated()) {
            this.f4792a.d(true);
        } else {
            Log.e("BlurView", "BlurView can't be used in not hardware-accelerated window!");
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f4792a.d(false);
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i6, int i10, int i11) {
        super.onSizeChanged(i, i6, i10, i11);
        this.f4792a.e();
    }

    public BlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4792a = new a(7);
        a(attributeSet, 0);
    }

    public BlurView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4792a = new a(7);
        a(attributeSet, i);
    }
}
