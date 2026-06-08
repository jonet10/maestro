package com.uptodown.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.google.android.gms.internal.measurement.i5;
import f4.c;
import java.util.List;
import kotlin.jvm.internal.g;
import n5.e;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class DonutChartView extends View {

    /* renamed from: a, reason: collision with root package name */
    public List f3462a;

    /* renamed from: b, reason: collision with root package name */
    public String f3463b;

    /* renamed from: l, reason: collision with root package name */
    public final float f3464l;

    /* renamed from: m, reason: collision with root package name */
    public final Paint f3465m;

    /* renamed from: n, reason: collision with root package name */
    public final Paint f3466n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DonutChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        context.getClass();
        this.f3462a = t.f8724a;
        this.f3463b = "";
        this.f3464l = 50.0f;
        Paint paint = new Paint(1);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.BUTT);
        this.f3465m = paint;
        Paint paint2 = new Paint(1);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setTextAlign(Paint.Align.CENTER);
        paint2.setTypeface(c.f4882w);
        paint2.setColor(ContextCompat.getColor(context, 2131099713));
        paint2.setTextSize(context.getResources().getDimension(2131165353));
        this.f3466n = paint2;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        Canvas canvas2;
        canvas.getClass();
        super.onDraw(canvas);
        if (this.f3462a.isEmpty()) {
            return;
        }
        float min = Math.min(getWidth(), getHeight());
        float f = this.f3464l;
        float f10 = (min - f) / 2.0f;
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        Paint paint = this.f3465m;
        paint.setStrokeWidth(f);
        double d10 = 0.0d;
        while (this.f3462a.iterator().hasNext()) {
            d10 += ((e) r1.next()).f8081a;
        }
        float f11 = (float) d10;
        RectF rectF = new RectF(width - f10, height - f10, width + f10, f10 + height);
        if (f11 <= 0.0f) {
            paint.setColor(ContextCompat.getColor(getContext(), 2131099889));
            canvas2 = canvas;
            canvas2.drawArc(rectF, 0.0f, 360.0f, false, paint);
        } else {
            canvas2 = canvas;
            float f12 = -90.0f;
            for (e eVar : this.f3462a) {
                float f13 = (eVar.f8081a / f11) * 360.0f;
                paint.setColor(eVar.f8082b);
                canvas2.drawArc(rectF, f12, f13, false, paint);
                f12 += f13;
            }
        }
        int length = this.f3463b.length();
        Paint paint2 = this.f3466n;
        if (length > 0) {
            canvas2.drawText(this.f3463b, width, height - ((paint2.ascent() + paint2.descent()) / 2.0f), paint2);
        } else {
            float ascent = height - ((paint2.ascent() + paint2.descent()) / 2.0f);
            Context context = getContext();
            context.getClass();
            canvas2.drawText(i5.H(context, 0L), width, ascent, paint2);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i6) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i6);
        int size2 = View.MeasureSpec.getSize(i6);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(240, size);
        } else if (mode != 1073741824) {
            size = 240;
        }
        if (mode2 == Integer.MIN_VALUE) {
            size2 = Math.min(240, size2);
        } else if (mode2 != 1073741824) {
            size2 = 240;
        }
        setMeasuredDimension(size, size2);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DonutChartView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        context.getClass();
    }

    public /* synthetic */ DonutChartView(Context context, AttributeSet attributeSet, int i, int i6, g gVar) {
        this(context, (i6 & 2) != 0 ? null : attributeSet, (i6 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DonutChartView(Context context) {
        this(context, null, 0, 6, null);
        context.getClass();
    }
}
