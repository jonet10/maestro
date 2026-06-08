package androidx.core.content;

import android.content.ContentProvider;
import android.content.Context;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ContentProviderCompat {
    private ContentProviderCompat() {
    }

    @NonNull
    public static Context requireContext(@NonNull ContentProvider contentProvider) {
        Context context = contentProvider.getContext();
        if (context != null) {
            return context;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Cannot find context from the provider.");
        return null;
    }
}
