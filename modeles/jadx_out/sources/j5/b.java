package j5;

import android.graphics.LinearGradient;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends CharacterStyle implements UpdateAppearance {

    /* renamed from: a, reason: collision with root package name */
    public final LinearGradient f6663a;

    /* renamed from: b, reason: collision with root package name */
    public final float f6664b;

    public b(LinearGradient linearGradient, float f) {
        this.f6663a = linearGradient;
        this.f6664b = f;
    }

    @Override // android.text.style.CharacterStyle
    public final void updateDrawState(TextPaint textPaint) {
        textPaint.getClass();
        textPaint.setShader(this.f6663a);
        textPaint.setTextSize(this.f6664b);
        textPaint.setColor(textPaint.linkColor);
    }
}
