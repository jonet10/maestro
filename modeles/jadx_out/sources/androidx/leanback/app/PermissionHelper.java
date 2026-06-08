package androidx.leanback.app;

import android.annotation.SuppressLint;
import android.app.Fragment;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class PermissionHelper {
    private PermissionHelper() {
    }

    @SuppressLint({"ReferencesDeprecated"})
    public static void requestPermissions(Fragment fragment, String[] strArr, int i) {
        fragment.requestPermissions(strArr, i);
    }
}
