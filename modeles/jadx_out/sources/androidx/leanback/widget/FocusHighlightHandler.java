package androidx.leanback.widget;

import android.view.View;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
interface FocusHighlightHandler {
    void onInitializeView(View view);

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    void onItemFocused(View view, boolean z9);
}
