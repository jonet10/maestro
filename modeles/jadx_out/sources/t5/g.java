package t5;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements a {

    /* renamed from: b, reason: collision with root package name */
    public final RenderScript f10307b;

    /* renamed from: c, reason: collision with root package name */
    public final ScriptIntrinsicBlur f10308c;

    /* renamed from: d, reason: collision with root package name */
    public Allocation f10309d;

    /* renamed from: a, reason: collision with root package name */
    public final Paint f10306a = new Paint(2);

    /* renamed from: e, reason: collision with root package name */
    public int f10310e = -1;
    public int f = -1;

    public g(Context context) {
        RenderScript create = RenderScript.create(context);
        this.f10307b = create;
        this.f10308c = ScriptIntrinsicBlur.create(create, Element.U8_4(create));
    }

    @Override // t5.a
    public final void a() {
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
    }

    @Override // t5.a
    public final void b(Canvas canvas, Bitmap bitmap) {
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.f10306a);
    }

    @Override // t5.a
    public final Bitmap c(Bitmap bitmap, float f) {
        RenderScript renderScript = this.f10307b;
        Allocation createFromBitmap = Allocation.createFromBitmap(renderScript, bitmap);
        if (bitmap.getHeight() != this.f || bitmap.getWidth() != this.f10310e) {
            Allocation allocation = this.f10309d;
            if (allocation != null) {
                allocation.destroy();
            }
            this.f10309d = Allocation.createTyped(renderScript, createFromBitmap.getType());
            this.f10310e = bitmap.getWidth();
            this.f = bitmap.getHeight();
        }
        ScriptIntrinsicBlur scriptIntrinsicBlur = this.f10308c;
        scriptIntrinsicBlur.setRadius(f);
        scriptIntrinsicBlur.setInput(createFromBitmap);
        scriptIntrinsicBlur.forEach(this.f10309d);
        this.f10309d.copyTo(bitmap);
        createFromBitmap.destroy();
        return bitmap;
    }

    @Override // t5.a
    public final void destroy() {
        this.f10308c.destroy();
        this.f10307b.destroy();
        Allocation allocation = this.f10309d;
        if (allocation != null) {
            allocation.destroy();
        }
    }
}
