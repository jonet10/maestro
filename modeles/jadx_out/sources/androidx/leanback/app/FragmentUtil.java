package androidx.leanback.app;

import android.app.Fragment;
import android.content.Context;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class FragmentUtil {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresApi(23)
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static Context getContext(Fragment fragment) {
            return fragment.getContext();
        }
    }

    private FragmentUtil() {
    }

    public static Context getContext(Fragment fragment) {
        return Api23Impl.getContext(fragment);
    }
}
