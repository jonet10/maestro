package a4;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h0 extends BitmapDrawable {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f116e = 0;

    /* renamed from: a, reason: collision with root package name */
    public Drawable f117a;

    /* renamed from: b, reason: collision with root package name */
    public final long f118b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f119c;

    /* renamed from: d, reason: collision with root package name */
    public int f120d;

    static {
        new Paint();
    }

    public h0(Context context, Bitmap bitmap, Drawable drawable, int i) {
        super(context.getResources(), bitmap);
        this.f120d = 255;
        float f = context.getResources().getDisplayMetrics().density;
        if (i != 1) {
            this.f117a = drawable;
            this.f119c = true;
            this.f118b = SystemClock.uptimeMillis();
        }
    }

    public static void a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).start();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        if (!this.f119c) {
            super.draw(canvas);
            return;
        }
        float uptimeMillis = (SystemClock.uptimeMillis() - this.f118b) / 200.0f;
        if (uptimeMillis >= 1.0f) {
            this.f119c = false;
            this.f117a = null;
            super.draw(canvas);
        } else {
            Drawable drawable = this.f117a;
            if (drawable != null) {
                drawable.draw(canvas);
            }
            super.setAlpha((int) (this.f120d * uptimeMillis));
            super.draw(canvas);
            super.setAlpha(this.f120d);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.f117a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.f120d = i;
        Drawable drawable = this.f117a;
        if (drawable != null) {
            drawable.setAlpha(i);
        }
        super.setAlpha(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f117a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
