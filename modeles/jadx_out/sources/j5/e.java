package j5;

import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends MetricAffectingSpan {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f6666m = 0;

    /* renamed from: a, reason: collision with root package name */
    public final float f6667a;

    /* renamed from: b, reason: collision with root package name */
    public final Typeface f6668b;

    /* renamed from: l, reason: collision with root package name */
    public final int f6669l;

    public e(float f, Typeface typeface, int i) {
        this.f6667a = f;
        this.f6668b = typeface;
        this.f6669l = i;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        textPaint.getClass();
        textPaint.setTextSize(this.f6667a);
        textPaint.setTypeface(this.f6668b);
        textPaint.setColor(this.f6669l);
    }

    @Override // android.text.style.MetricAffectingSpan
    public final void updateMeasureState(TextPaint textPaint) {
        textPaint.getClass();
        textPaint.setTextSize(this.f6667a);
        textPaint.setTypeface(this.f6668b);
        textPaint.setColor(this.f6669l);
    }
}
