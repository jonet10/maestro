package androidx.leanback.graphics;

import a4.x;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import androidx.leanback.R;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ColorOverlayDimmer {
    private final float mActiveLevel;
    private int mAlpha;
    private float mAlphaFloat;
    private final float mDimmedLevel;
    private final Paint mPaint;

    private ColorOverlayDimmer(int i, float f, float f10) {
        f = f > 1.0f ? 1.0f : f;
        f = f < 0.0f ? 0.0f : f;
        f10 = f10 > 1.0f ? 1.0f : f10;
        float f11 = f10 >= 0.0f ? f10 : 0.0f;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(Color.rgb(Color.red(i), Color.green(i), Color.blue(i)));
        this.mActiveLevel = f;
        this.mDimmedLevel = f11;
        setActiveLevel(1.0f);
    }

    public static ColorOverlayDimmer createColorOverlayDimmer(int i, float f, float f10) {
        return new ColorOverlayDimmer(i, f, f10);
    }

    public static ColorOverlayDimmer createDefault(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(R.styleable.LeanbackTheme);
        int color = obtainStyledAttributes.getColor(R.styleable.LeanbackTheme_overlayDimMaskColor, context.getResources().getColor(R.color.lb_view_dim_mask_color));
        float fraction = obtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimActiveLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_active_level, 1, 0));
        float fraction2 = obtainStyledAttributes.getFraction(R.styleable.LeanbackTheme_overlayDimDimmedLevel, 1, 1, context.getResources().getFraction(R.fraction.lb_view_dimmed_level, 1, 1));
        obtainStyledAttributes.recycle();
        return new ColorOverlayDimmer(color, fraction, fraction2);
    }

    public int applyToColor(int i) {
        float f = 1.0f - this.mAlphaFloat;
        return Color.argb(Color.alpha(i), (int) (Color.red(i) * f), (int) (Color.green(i) * f), (int) (Color.blue(i) * f));
    }

    public void drawColorOverlay(Canvas canvas, View view, boolean z9) {
        Canvas canvas2;
        canvas.save();
        float translationX = view.getTranslationX() + view.getLeft();
        float translationY = view.getTranslationY() + view.getTop();
        canvas.translate(translationX, translationY);
        canvas.concat(view.getMatrix());
        canvas.translate(-translationX, -translationY);
        if (z9) {
            canvas2 = canvas;
            canvas2.drawRect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom(), this.mPaint);
        } else {
            canvas2 = canvas;
            canvas2.drawRect(view.getPaddingLeft() + view.getLeft(), view.getPaddingTop() + view.getTop(), view.getRight() - view.getPaddingRight(), view.getBottom() - view.getPaddingBottom(), this.mPaint);
        }
        canvas2.restore();
    }

    public int getAlpha() {
        return this.mAlpha;
    }

    public float getAlphaFloat() {
        return this.mAlphaFloat;
    }

    public Paint getPaint() {
        return this.mPaint;
    }

    public boolean needsDraw() {
        return this.mAlpha != 0;
    }

    public void setActiveLevel(float f) {
        float f10 = this.mDimmedLevel;
        float f11 = x.f(this.mActiveLevel, f10, f, f10);
        this.mAlphaFloat = f11;
        int i = (int) (f11 * 255.0f);
        this.mAlpha = i;
        this.mPaint.setAlpha(i);
    }
}
