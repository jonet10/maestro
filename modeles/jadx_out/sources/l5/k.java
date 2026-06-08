package l5;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import e4.q0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k extends RecyclerView.ItemDecoration {
    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.getClass();
        view.getClass();
        recyclerView.getClass();
        state.getClass();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        rect.top = recyclerView.getContext().getResources().getDimensionPixelSize(2131166251);
        if (!(adapter instanceof q0)) {
            rect.left = recyclerView.getContext().getResources().getDimensionPixelSize(2131166251);
            rect.right = recyclerView.getContext().getResources().getDimensionPixelSize(2131166251);
            return;
        }
        int itemViewType = ((q0) adapter).getItemViewType(childAdapterPosition);
        if (itemViewType == 3) {
            rect.left = 0;
            rect.right = 0;
        } else if (itemViewType != 6) {
            rect.left = recyclerView.getContext().getResources().getDimensionPixelSize(2131166251);
            rect.right = recyclerView.getContext().getResources().getDimensionPixelSize(2131166251);
        } else {
            rect.left = 0;
            rect.right = 0;
        }
    }
}
