package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorSpace;
import android.graphics.Point;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import d7.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class BitmapKt {
    public static final Bitmap applyCanvas(Bitmap bitmap, l lVar) {
        lVar.invoke(new Canvas(bitmap));
        return bitmap;
    }

    public static final boolean contains(Bitmap bitmap, PointF pointF) {
        float f = pointF.x;
        if (f < 0.0f || f >= bitmap.getWidth()) {
            return false;
        }
        float f10 = pointF.y;
        return f10 >= 0.0f && f10 < ((float) bitmap.getHeight());
    }

    public static final Bitmap createBitmap(int i, int i6, Bitmap.Config config) {
        return Bitmap.createBitmap(i, i6, config);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i6, Bitmap.Config config, boolean z9, ColorSpace colorSpace, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        if ((i10 & 8) != 0) {
            z9 = true;
        }
        if ((i10 & 16) != 0) {
            colorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
        }
        return Bitmap.createBitmap(i, i6, config, z9, colorSpace);
    }

    public static final int get(Bitmap bitmap, int i, int i6) {
        return bitmap.getPixel(i, i6);
    }

    public static final Bitmap scale(Bitmap bitmap, int i, int i6, boolean z9) {
        return Bitmap.createScaledBitmap(bitmap, i, i6, z9);
    }

    public static /* synthetic */ Bitmap scale$default(Bitmap bitmap, int i, int i6, boolean z9, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            z9 = true;
        }
        return Bitmap.createScaledBitmap(bitmap, i, i6, z9);
    }

    public static final void set(Bitmap bitmap, int i, int i6, @ColorInt int i10) {
        bitmap.setPixel(i, i6, i10);
    }

    @RequiresApi(26)
    @SuppressLint({"ClassVerificationFailure"})
    public static final Bitmap createBitmap(int i, int i6, Bitmap.Config config, boolean z9, ColorSpace colorSpace) {
        return Bitmap.createBitmap(i, i6, config, z9, colorSpace);
    }

    public static /* synthetic */ Bitmap createBitmap$default(int i, int i6, Bitmap.Config config, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            config = Bitmap.Config.ARGB_8888;
        }
        return Bitmap.createBitmap(i, i6, config);
    }

    public static final boolean contains(Bitmap bitmap, Point point) {
        int i;
        int width = bitmap.getWidth();
        int i6 = point.x;
        return i6 >= 0 && i6 < width && (i = point.y) >= 0 && i < bitmap.getHeight();
    }
}
