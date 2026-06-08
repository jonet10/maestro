package androidx.core.graphics.drawable;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@SuppressLint({"ClassVerificationFailure"})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class IconKt {
    @RequiresApi(26)
    public static final Icon toAdaptiveIcon(Bitmap bitmap) {
        return Icon.createWithAdaptiveBitmap(bitmap);
    }

    @RequiresApi(26)
    public static final Icon toIcon(byte[] bArr) {
        return Icon.createWithData(bArr, 0, bArr.length);
    }

    @RequiresApi(26)
    public static final Icon toIcon(Uri uri) {
        return Icon.createWithContentUri(uri);
    }

    @RequiresApi(26)
    public static final Icon toIcon(Bitmap bitmap) {
        return Icon.createWithBitmap(bitmap);
    }
}
