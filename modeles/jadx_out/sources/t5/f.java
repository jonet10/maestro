package t5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RenderEffect;
import android.graphics.RenderNode;
import android.graphics.Shader;
import androidx.core.view.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f implements a {

    /* renamed from: b, reason: collision with root package name */
    public int f10302b;

    /* renamed from: c, reason: collision with root package name */
    public int f10303c;

    /* renamed from: e, reason: collision with root package name */
    public g f10305e;
    public Context f;

    /* renamed from: a, reason: collision with root package name */
    public final RenderNode f10301a = o.a();

    /* renamed from: d, reason: collision with root package name */
    public float f10304d = 1.0f;

    @Override // t5.a
    public final void a() {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
    }

    @Override // t5.a
    public final void b(Canvas canvas, Bitmap bitmap) {
        if (canvas.isHardwareAccelerated()) {
            canvas.drawRenderNode(this.f10301a);
            return;
        }
        if (this.f10305e == null) {
            this.f10305e = new g(this.f);
        }
        this.f10305e.c(bitmap, this.f10304d);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f10305e.f10306a);
    }

    @Override // t5.a
    public final Bitmap c(Bitmap bitmap, float f) {
        this.f10304d = f;
        if (bitmap.getHeight() != this.f10302b || bitmap.getWidth() != this.f10303c) {
            this.f10302b = bitmap.getHeight();
            int width = bitmap.getWidth();
            this.f10303c = width;
            this.f10301a.setPosition(0, 0, width, this.f10302b);
        }
        this.f10301a.beginRecording().drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        this.f10301a.endRecording();
        this.f10301a.setRenderEffect(RenderEffect.createBlurEffect(f, f, Shader.TileMode.MIRROR));
        return bitmap;
    }

    @Override // t5.a
    public final void destroy() {
        this.f10301a.discardDisplayList();
        g gVar = this.f10305e;
        if (gVar != null) {
            gVar.destroy();
        }
    }
}
