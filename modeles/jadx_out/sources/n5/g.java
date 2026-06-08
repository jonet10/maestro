package n5;

import a4.q0;
import a4.x;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements q0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f8085a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8086b;

    /* renamed from: c, reason: collision with root package name */
    public final f f8087c = f.f8083a;

    public g(int i) {
        this.f8085a = i;
        this.f8086b = i * 2;
    }

    @Override // a4.q0
    public final Bitmap a(Bitmap bitmap) {
        bitmap.getClass();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        createBitmap.getClass();
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        paint.setShader(new BitmapShader(bitmap, tileMode, tileMode));
        float f = 0;
        float f10 = width - f;
        float f11 = height - f;
        int ordinal = this.f8087c.ordinal();
        int i = this.f8086b;
        int i6 = this.f8085a;
        switch (ordinal) {
            case 0:
                RectF rectF = new RectF(f, f, f10, f11);
                float f12 = i6;
                canvas.drawRoundRect(rectF, f12, f12, paint);
                break;
            case 1:
                float f13 = i;
                RectF rectF2 = new RectF(f, f, f13, f13);
                float f14 = i6;
                canvas.drawRoundRect(rectF2, f14, f14, paint);
                canvas.drawRect(new RectF(f, f14, f14, f11), paint);
                canvas.drawRect(new RectF(f14, f, f10, f11), paint);
                break;
            case 2:
                float f15 = i;
                RectF rectF3 = new RectF(f10 - f15, f, f10, f15);
                float f16 = i6;
                canvas.drawRoundRect(rectF3, f16, f16, paint);
                float f17 = f10 - f16;
                canvas.drawRect(new RectF(f, f, f17, f11), paint);
                canvas.drawRect(new RectF(f17, f16, f10, f11), paint);
                break;
            case 3:
                float f18 = i;
                float f19 = i6;
                canvas.drawRoundRect(new RectF(f, f11 - f18, f18, f11), f19, f19, paint);
                canvas.drawRect(new RectF(f, f, f18, f11 - f19), paint);
                canvas.drawRect(new RectF(f19, f, f10, f11), paint);
                break;
            case 4:
                float f20 = i;
                RectF rectF4 = new RectF(f10 - f20, f11 - f20, f10, f11);
                float f21 = i6;
                canvas.drawRoundRect(rectF4, f21, f21, paint);
                float f22 = f10 - f21;
                canvas.drawRect(new RectF(f, f, f22, f11), paint);
                canvas.drawRect(new RectF(f22, f, f10, f11 - f21), paint);
                break;
            case 5:
                RectF rectF5 = new RectF(f, f, f10, i);
                float f23 = i6;
                canvas.drawRoundRect(rectF5, f23, f23, paint);
                canvas.drawRect(new RectF(f, f23, f10, f11), paint);
                break;
            case 6:
                RectF rectF6 = new RectF(f, f11 - i, f10, f11);
                float f24 = i6;
                canvas.drawRoundRect(rectF6, f24, f24, paint);
                canvas.drawRect(new RectF(f, f, f10, f11 - f24), paint);
                break;
            case 7:
                RectF rectF7 = new RectF(f, f, i, f11);
                float f25 = i6;
                canvas.drawRoundRect(rectF7, f25, f25, paint);
                canvas.drawRect(new RectF(f25, f, f10, f11), paint);
                break;
            case 8:
                RectF rectF8 = new RectF(f10 - i, f, f10, f11);
                float f26 = i6;
                canvas.drawRoundRect(rectF8, f26, f26, paint);
                canvas.drawRect(new RectF(f, f, f10 - f26, f11), paint);
                break;
            case 9:
                float f27 = i;
                float f28 = i6;
                canvas.drawRoundRect(new RectF(f, f11 - f27, f10, f11), f28, f28, paint);
                canvas.drawRoundRect(new RectF(f10 - f27, f, f10, f11), f28, f28, paint);
                canvas.drawRect(new RectF(f, f, f10 - f28, f11 - f28), paint);
                break;
            case 10:
                float f29 = i;
                float f30 = i6;
                canvas.drawRoundRect(new RectF(f, f, f29, f11), f30, f30, paint);
                canvas.drawRoundRect(new RectF(f, f11 - f29, f10, f11), f30, f30, paint);
                canvas.drawRect(new RectF(f30, f, f10, f11 - f30), paint);
                break;
            case 11:
                float f31 = i;
                float f32 = i6;
                canvas.drawRoundRect(new RectF(f, f, f10, f31), f32, f32, paint);
                canvas.drawRoundRect(new RectF(f10 - f31, f, f10, f11), f32, f32, paint);
                canvas.drawRect(new RectF(f, f32, f10 - f32, f11), paint);
                break;
            case 12:
                float f33 = i;
                float f34 = i6;
                canvas.drawRoundRect(new RectF(f, f, f10, f33), f34, f34, paint);
                canvas.drawRoundRect(new RectF(f, f, f33, f11), f34, f34, paint);
                canvas.drawRect(new RectF(f34, f34, f10, f11), paint);
                break;
            case 13:
                float f35 = i;
                float f36 = i6;
                canvas.drawRoundRect(new RectF(f, f, f35, f35), f36, f36, paint);
                canvas.drawRoundRect(new RectF(f10 - f35, f11 - f35, f10, f11), f36, f36, paint);
                canvas.drawRect(new RectF(f, f36, f10 - f36, f11), paint);
                canvas.drawRect(new RectF(f36, f, f10, f11 - f36), paint);
                break;
            case 14:
                float f37 = i;
                float f38 = i6;
                canvas.drawRoundRect(new RectF(f10 - f37, f, f10, f37), f38, f38, paint);
                canvas.drawRoundRect(new RectF(f, f11 - f37, f37, f11), f38, f38, paint);
                canvas.drawRect(new RectF(f, f, f10 - f38, f11 - f38), paint);
                canvas.drawRect(new RectF(f38, f38, f10, f11), paint);
                break;
            default:
                com.google.gson.internal.a.b();
                return null;
        }
        bitmap.recycle();
        return createBitmap;
    }

    @Override // a4.q0
    public final String b() {
        String name = this.f8087c.name();
        StringBuilder sb = new StringBuilder("RoundedTransformation(radius=");
        sb.append(this.f8085a);
        sb.append(", margin=0, diameter=");
        sb.append(this.f8086b);
        sb.append(", cornerType=");
        return x.n(sb, name, ")");
    }
}
