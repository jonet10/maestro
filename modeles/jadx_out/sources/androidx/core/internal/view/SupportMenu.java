package androidx.core.internal.view;

import android.view.Menu;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface SupportMenu extends Menu {
    public static final int CATEGORY_MASK = -65536;
    public static final int CATEGORY_SHIFT = 16;
    public static final int FLAG_KEEP_OPEN_ON_SUBMENU_OPENED = 4;
    public static final int SUPPORTED_MODIFIERS_MASK = 69647;
    public static final int USER_MASK = 65535;
    public static final int USER_SHIFT = 0;

    @Override // android.view.Menu
    void setGroupDividerEnabled(boolean z9);
}
