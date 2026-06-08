package androidx.core.graphics.drawable;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.Px;
import com.google.gson.internal.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class DrawableKt {
    public static final Bitmap toBitmap(Drawable drawable, @Px int i, @Px int i6, Bitmap.Config config) {
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() == null) {
                a.p("bitmap is null");
                return null;
            }
            if (config == null || bitmapDrawable.getBitmap().getConfig() == config) {
                return (i == bitmapDrawable.getBitmap().getWidth() && i6 == bitmapDrawable.getBitmap().getHeight()) ? bitmapDrawable.getBitmap() : Bitmap.createScaledBitmap(bitmapDrawable.getBitmap(), i, i6, true);
            }
        }
        Rect bounds = drawable.getBounds();
        int i10 = bounds.left;
        int i11 = bounds.top;
        int i12 = bounds.right;
        int i13 = bounds.bottom;
        if (config == null) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap createBitmap = Bitmap.createBitmap(i, i6, config);
        drawable.setBounds(0, 0, i, i6);
        drawable.draw(new Canvas(createBitmap));
        drawable.setBounds(i10, i11, i12, i13);
        return createBitmap;
    }

    public static /* synthetic */ Bitmap toBitmap$default(Drawable drawable, int i, int i6, Bitmap.Config config, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = drawable.getIntrinsicWidth();
        }
        if ((i10 & 2) != 0) {
            i6 = drawable.getIntrinsicHeight();
        }
        if ((i10 & 4) != 0) {
            config = null;
        }
        return toBitmap(drawable, i, i6, config);
    }

    public static final Bitmap toBitmapOrNull(Drawable drawable, @Px int i, @Px int i6, Bitmap.Config config) {
        if ((drawable instanceof BitmapDrawable) && ((BitmapDrawable) drawable).getBitmap() == null) {
            return null;
        }
        return toBitmap(drawable, i, i6, config);
    }

    public static /* synthetic */ Bitmap toBitmapOrNull$default(Drawable drawable, int i, int i6, Bitmap.Config config, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i = drawable.getIntrinsicWidth();
        }
        if ((i10 & 2) != 0) {
            i6 = drawable.getIntrinsicHeight();
        }
        if ((i10 & 4) != 0) {
            config = null;
        }
        return toBitmapOrNull(drawable, i, i6, config);
    }

    public static final void updateBounds(Drawable drawable, @Px int i, @Px int i6, @Px int i10, @Px int i11) {
        drawable.setBounds(i, i6, i10, i11);
    }

    public static /* synthetic */ void updateBounds$default(Drawable drawable, int i, int i6, int i10, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i = drawable.getBounds().left;
        }
        if ((i12 & 2) != 0) {
            i6 = drawable.getBounds().top;
        }
        if ((i12 & 4) != 0) {
            i10 = drawable.getBounds().right;
        }
        if ((i12 & 8) != 0) {
            i11 = drawable.getBounds().bottom;
        }
        updateBounds(drawable, i, i6, i10, i11);
    }
}
