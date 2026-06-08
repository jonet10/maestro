package f6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.Spanned;
import android.text.style.LeadingMarginSpan;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b implements LeadingMarginSpan {

    /* renamed from: o, reason: collision with root package name */
    public static final boolean f4900o;

    /* renamed from: a, reason: collision with root package name */
    public final d6.f f4901a;

    /* renamed from: b, reason: collision with root package name */
    public final Paint f4902b = g.f4919c;

    /* renamed from: l, reason: collision with root package name */
    public final RectF f4903l = g.f4918b;

    /* renamed from: m, reason: collision with root package name */
    public final Rect f4904m = g.f4917a;

    /* renamed from: n, reason: collision with root package name */
    public final int f4905n;

    static {
        int i = Build.VERSION.SDK_INT;
        f4900o = 24 == i || 25 == i;
    }

    public b(d6.f fVar, int i) {
        this.f4901a = fVar;
        this.f4905n = i;
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i6, int i10, int i11, int i12, CharSequence charSequence, int i13, int i14, boolean z9, Layout layout) {
        int i15;
        int i16;
        RectF rectF = this.f4903l;
        Rect rect = this.f4904m;
        if (z9 && (charSequence instanceof Spanned) && ((Spanned) charSequence).getSpanStart(this) == i13) {
            Paint paint2 = this.f4902b;
            paint2.set(paint);
            d6.f fVar = this.f4901a;
            fVar.getClass();
            int i17 = fVar.f3611a;
            paint2.setColor(paint2.getColor());
            int i18 = fVar.f3613c;
            if (i18 != 0) {
                paint2.setStrokeWidth(i18);
            }
            int save = canvas.save();
            try {
                int min = Math.min(i17, (int) ((paint2.descent() - paint2.ascent()) + 0.5f)) / 2;
                int i19 = (i17 - min) / 2;
                boolean z10 = f4900o;
                int i20 = this.f4905n;
                if (z10) {
                    int width = i6 < 0 ? i - (layout.getWidth() - (i17 * i20)) : (i17 * i20) - i;
                    int i21 = (i19 * i6) + i;
                    int i22 = (i6 * min) + i21;
                    int i23 = i6 * width;
                    i15 = Math.min(i21, i22) + i23;
                    i16 = Math.max(i21, i22) + i23;
                } else {
                    if (i6 <= 0) {
                        i -= i17;
                    }
                    i15 = i + i19;
                    i16 = i15 + min;
                }
                int descent = (i11 + ((int) (((paint2.descent() + paint2.ascent()) / 2.0f) + 0.5f))) - (min / 2);
                int i24 = min + descent;
                if (i20 != 0 && i20 != 1) {
                    rect.set(i15, descent, i16, i24);
                    paint2.setStyle(Paint.Style.FILL);
                    canvas.drawRect(rect, paint2);
                    canvas.restoreToCount(save);
                }
                rectF.set(i15, descent, i16, i24);
                paint2.setStyle(i20 == 0 ? Paint.Style.FILL : Paint.Style.STROKE);
                canvas.drawOval(rectF, paint2);
                canvas.restoreToCount(save);
            } catch (Throwable th) {
                canvas.restoreToCount(save);
                throw th;
            }
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean z9) {
        return this.f4901a.f3611a;
    }
}
