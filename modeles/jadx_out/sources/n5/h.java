package n5;

import android.animation.ValueAnimator;
import android.widget.ImageView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class h implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8088a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f8089b;

    public /* synthetic */ h(ImageView imageView, int i) {
        this.f8088a = i;
        this.f8089b = imageView;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f8088a) {
            case 0:
                valueAnimator.getClass();
                Object animatedValue = valueAnimator.getAnimatedValue();
                animatedValue.getClass();
                float floatValue = ((Float) animatedValue).floatValue();
                ImageView imageView = this.f8089b;
                imageView.setScaleX(floatValue);
                imageView.setScaleY(floatValue);
                int i = (int) ((1 - floatValue) * 10);
                imageView.setPadding(i, i, i, i);
                break;
            default:
                valueAnimator.getClass();
                Object animatedValue2 = valueAnimator.getAnimatedValue();
                animatedValue2.getClass();
                float floatValue2 = ((Float) animatedValue2).floatValue();
                ImageView imageView2 = this.f8089b;
                imageView2.setScaleX(floatValue2);
                imageView2.setScaleY(floatValue2);
                int i6 = (int) ((1 - floatValue2) * 10);
                imageView2.setPadding(i6, i6, i6, i6);
                break;
        }
    }
}
