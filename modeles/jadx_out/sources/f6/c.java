package f6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.TextPaint;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends MetricAffectingSpan implements LeadingMarginSpan {

    /* renamed from: a, reason: collision with root package name */
    public final d6.f f4906a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f4907b = g.f4917a;

    /* renamed from: l, reason: collision with root package name */
    public final Paint f4908l = g.f4919c;

    public c(d6.f fVar) {
        this.f4906a = fVar;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i6, int i10, int i11, int i12, CharSequence charSequence, int i13, int i14, boolean z9, Layout layout) {
        int i15;
        Paint.Style style = Paint.Style.FILL;
        Paint paint2 = this.f4908l;
        paint2.setStyle(style);
        this.f4906a.getClass();
        paint2.setColor(t0.f.d(paint.getColor(), 25));
        if (i6 > 0) {
            i15 = canvas.getWidth();
        } else {
            i -= canvas.getWidth();
            i15 = i;
        }
        Rect rect = this.f4907b;
        rect.set(i, i10, i15, i12);
        canvas.drawRect(rect, paint2);
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean z9) {
        return this.f4906a.f3614d;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        this.f4906a.getClass();
        textPaint.setTypeface(Typeface.MONOSPACE);
        textPaint.setTextSize(textPaint.getTextSize() * 0.87f);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        this.f4906a.getClass();
        textPaint.setTypeface(Typeface.MONOSPACE);
        textPaint.setTextSize(textPaint.getTextSize() * 0.87f);
    }
}
