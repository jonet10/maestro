package m5;

import android.animation.ValueAnimator;
import android.widget.ImageView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class n1 implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7485a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p1 f7486b;

    public /* synthetic */ n1(p1 p1Var, int i) {
        this.f7485a = i;
        this.f7486b = p1Var;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f7485a) {
            case 0:
                valueAnimator.getClass();
                ImageView imageView = this.f7486b.f7507b;
                Object animatedValue = valueAnimator.getAnimatedValue();
                animatedValue.getClass();
                int intValue = ((Integer) animatedValue).intValue();
                imageView.setPadding(intValue, intValue, intValue, intValue);
                break;
            default:
                valueAnimator.getClass();
                ImageView imageView2 = this.f7486b.f7507b;
                Object animatedValue2 = valueAnimator.getAnimatedValue();
                animatedValue2.getClass();
                int intValue2 = ((Integer) animatedValue2).intValue();
                imageView2.setPadding(intValue2, intValue2, intValue2, intValue2);
                break;
        }
    }
}
