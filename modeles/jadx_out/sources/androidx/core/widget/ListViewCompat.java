package androidx.core.widget;

import android.widget.ListView;
import androidx.annotation.NonNull;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@Deprecated
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ListViewCompat {
    private ListViewCompat() {
    }

    @Deprecated
    public static boolean canScrollList(@NonNull ListView listView, int i) {
        return listView.canScrollList(i);
    }

    @Deprecated
    public static void scrollListBy(@NonNull ListView listView, int i) {
        listView.scrollListBy(i);
    }
}
