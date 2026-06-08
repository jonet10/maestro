package androidx.activity;

import android.view.View;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(19)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class Api19Impl {
    public static final Api19Impl INSTANCE = new Api19Impl();

    private Api19Impl() {
    }

    public final boolean isAttachedToWindow(View view) {
        return view.isAttachedToWindow();
    }
}
