package androidx.browser.customtabs;

import android.os.Bundle;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(33)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class Api33Impl {
    private Api33Impl() {
    }

    @DoNotInline
    public static <T> T getParcelable(@NonNull Bundle bundle, @Nullable String str, @NonNull Class<T> cls) {
        return (T) bundle.getParcelable(str, cls);
    }
}
