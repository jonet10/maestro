package m5;

import android.animation.ValueAnimator;
import android.widget.TextView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class j0 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7433a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l0 f7434b;

    public /* synthetic */ j0(l0 l0Var, int i) {
        this.f7433a = i;
        this.f7434b = l0Var;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f7433a) {
            case 0:
                valueAnimator.getClass();
                Object animatedValue = valueAnimator.getAnimatedValue();
                animatedValue.getClass();
                float floatValue = ((Float) animatedValue).floatValue();
                TextView textView = this.f7434b.f7457m;
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
                int i = (int) ((1 - floatValue) * 10);
                textView.setPadding(i, i, i, i);
                break;
            default:
                valueAnimator.getClass();
                Object animatedValue2 = valueAnimator.getAnimatedValue();
                animatedValue2.getClass();
                float floatValue2 = ((Float) animatedValue2).floatValue();
                TextView textView2 = this.f7434b.f7457m;
                textView2.setScaleX(floatValue2);
                textView2.setScaleY(floatValue2);
                int i6 = (int) ((1 - floatValue2) * 10);
                textView2.setPadding(i6, i6, i6, i6);
                break;
        }
    }
}
