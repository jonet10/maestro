package f6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import java.util.Arrays;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends MetricAffectingSpan implements LeadingMarginSpan {

    /* renamed from: a, reason: collision with root package name */
    public final d6.f f4910a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f4911b = g.f4917a;

    /* renamed from: l, reason: collision with root package name */
    public final Paint f4912l = g.f4919c;

    /* renamed from: m, reason: collision with root package name */
    public final int f4913m;

    public e(d6.f fVar, int i) {
        this.f4910a = fVar;
        this.f4913m = i;
    }

    public final void a(TextPaint textPaint) {
        this.f4910a.getClass();
        textPaint.setFakeBoldText(true);
        int i = this.f4913m;
        float[] fArr = d6.f.g;
        if (6 >= i) {
            textPaint.setTextSize(textPaint.getTextSize() * fArr[i - 1]);
            return;
        }
        Locale locale = Locale.US;
        throw new IllegalStateException("Supplied heading level: " + i + " is invalid, where configured heading sizes are: `" + Arrays.toString(fArr) + "`");
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i6, int i10, int i11, int i12, CharSequence charSequence, int i13, int i14, boolean z9, Layout layout) {
        int i15;
        int i16 = this.f4913m;
        if ((i16 == 1 || i16 == 2) && (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanEnd(this) == i14) {
            Paint paint2 = this.f4912l;
            paint2.set(paint);
            d6.f fVar = this.f4910a;
            fVar.getClass();
            paint2.setColor(t0.f.d(paint2.getColor(), 75));
            paint2.setStyle(Paint.Style.FILL);
            int i17 = fVar.f3615e;
            if (i17 >= 0) {
                paint2.setStrokeWidth(i17);
            }
            float strokeWidth = paint2.getStrokeWidth();
            if (strokeWidth > 0.0f) {
                int i18 = (int) ((i12 - strokeWidth) + 0.5f);
                if (i6 > 0) {
                    i15 = canvas.getWidth();
                } else {
                    i15 = i;
                    i -= canvas.getWidth();
                }
                Rect rect = this.f4911b;
                rect.set(i, i18, i15, i12);
                canvas.drawRect(rect, paint2);
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean z9) {
        return 0;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        a(textPaint);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        a(textPaint);
    }
}
