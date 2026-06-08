package l5;

import a4.q0;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import androidx.core.content.ContextCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements q0 {

    /* renamed from: a, reason: collision with root package name */
    public final Context f7129a;

    public a(Context context) {
        this.f7129a = context;
    }

    @Override // a4.q0
    public final Bitmap a(Bitmap bitmap) {
        bitmap.getClass();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = height / 3;
        Bitmap createBitmap = Bitmap.createBitmap(bitmap);
        createBitmap.getClass();
        if (bitmap.getConfig() != null) {
            Bitmap.Config config = bitmap.getConfig();
            config.getClass();
            createBitmap = Bitmap.createBitmap(width, height, config);
        }
        Canvas canvas = new Canvas(createBitmap);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        float f = height - i;
        float f10 = height;
        LinearGradient linearGradient = new LinearGradient(0.0f, f, 0.0f, f10, 0, ContextCompat.getColor(this.f7129a, 2131099686), Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(linearGradient);
        canvas.drawRect(0.0f, f, width, f10, paint);
        bitmap.recycle();
        return createBitmap;
    }

    @Override // a4.q0
    public final String b() {
        return "bottomGradient";
    }
}
