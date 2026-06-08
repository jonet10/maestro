package n4;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final int f7984a;

    public l(int i) {
        this.f7984a = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.getClass();
        view.getClass();
        recyclerView.getClass();
        state.getClass();
        int i = this.f7984a;
        rect.left = i;
        rect.right = i;
        rect.bottom = i;
        rect.top = i;
        if (recyclerView.getChildLayoutPosition(view) > 0) {
            rect.top = 0;
        }
    }
}
