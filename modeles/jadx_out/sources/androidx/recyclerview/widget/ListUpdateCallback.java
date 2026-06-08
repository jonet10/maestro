package androidx.recyclerview.widget;

import androidx.annotation.Nullable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface ListUpdateCallback {
    void onChanged(int i, int i6, @Nullable Object obj);

    void onInserted(int i, int i6);

    void onMoved(int i, int i6);

    void onRemoved(int i, int i6);
}
