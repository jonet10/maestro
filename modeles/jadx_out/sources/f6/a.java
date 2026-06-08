package f6;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Layout;
import android.text.style.LeadingMarginSpan;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements LeadingMarginSpan {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4896a;

    /* renamed from: b, reason: collision with root package name */
    public final d6.f f4897b;

    /* renamed from: l, reason: collision with root package name */
    public final Rect f4898l;

    /* renamed from: m, reason: collision with root package name */
    public final Paint f4899m;

    public a(d6.f fVar, int i) {
        this.f4896a = i;
        switch (i) {
            case 1:
                this.f4898l = g.f4917a;
                this.f4899m = g.f4919c;
                this.f4897b = fVar;
                break;
            default:
                this.f4898l = g.f4917a;
                this.f4899m = g.f4919c;
                this.f4897b = fVar;
                break;
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public final void drawLeadingMargin(Canvas canvas, Paint paint, int i, int i6, int i10, int i11, int i12, CharSequence charSequence, int i13, int i14, boolean z9, Layout layout) {
        int i15;
        switch (this.f4896a) {
            case 0:
                d6.f fVar = this.f4897b;
                int i16 = fVar.f3612b;
                if (i16 == 0) {
                    i16 = (int) ((fVar.f3611a * 0.25f) + 0.5f);
                }
                Paint paint2 = this.f4899m;
                paint2.set(paint);
                fVar.getClass();
                int d10 = t0.f.d(paint2.getColor(), 25);
                paint2.setStyle(Paint.Style.FILL);
                paint2.setColor(d10);
                int i17 = i6 * i16;
                int i18 = i + i17;
                int i19 = i17 + i18;
                int min = Math.min(i18, i19);
                int max = Math.max(i18, i19);
                Rect rect = this.f4898l;
                rect.set(min, i10, max, i12);
                canvas.drawRect(rect, paint2);
                break;
            default:
                int i20 = ((i12 - i10) / 2) + i10;
                Paint paint3 = this.f4899m;
                paint3.set(paint);
                d6.f fVar2 = this.f4897b;
                fVar2.getClass();
                paint3.setColor(t0.f.d(paint3.getColor(), 25));
                paint3.setStyle(Paint.Style.FILL);
                int i21 = fVar2.f;
                if (i21 >= 0) {
                    paint3.setStrokeWidth(i21);
                }
                int strokeWidth = (int) ((((int) (paint3.getStrokeWidth() + 0.5f)) / 2.0f) + 0.5f);
                if (i6 > 0) {
                    i15 = canvas.getWidth();
                } else {
                    i15 = i;
                    i -= canvas.getWidth();
                }
                int i22 = i20 - strokeWidth;
                int i23 = i20 + strokeWidth;
                Rect rect2 = this.f4898l;
                rect2.set(i, i22, i15, i23);
                canvas.drawRect(rect2, paint3);
                break;
        }
    }

    @Override // android.text.style.LeadingMarginSpan
    public final int getLeadingMargin(boolean z9) {
        switch (this.f4896a) {
            case 0:
                return this.f4897b.f3611a;
            default:
                return 0;
        }
    }
}
