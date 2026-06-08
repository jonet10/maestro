package j5;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends MetricAffectingSpan {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f6670l = 0;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6671a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6672b;

    public /* synthetic */ f(Object obj, int i) {
        this.f6671a = i;
        this.f6672b = obj;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        switch (this.f6671a) {
            case 0:
                textPaint.getClass();
                textPaint.setTypeface((Typeface) this.f6672b);
                break;
            case 1:
                textPaint.getClass();
                textPaint.setTypeface((Typeface) this.f6672b);
                break;
            default:
                d6.f fVar = (d6.f) this.f6672b;
                fVar.getClass();
                textPaint.setTypeface(Typeface.MONOSPACE);
                textPaint.setTextSize(textPaint.getTextSize() * 0.87f);
                fVar.getClass();
                textPaint.bgColor = t0.f.d(textPaint.getColor(), 25);
                break;
        }
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        switch (this.f6671a) {
            case 0:
                textPaint.getClass();
                textPaint.setTypeface((Typeface) this.f6672b);
                break;
            case 1:
                textPaint.getClass();
                textPaint.setTypeface((Typeface) this.f6672b);
                break;
            default:
                ((d6.f) this.f6672b).getClass();
                textPaint.setTypeface(Typeface.MONOSPACE);
                textPaint.setTextSize(textPaint.getTextSize() * 0.87f);
                break;
        }
    }
}
