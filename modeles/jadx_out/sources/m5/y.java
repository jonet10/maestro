package m5;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ z f7638a;

    public y(z zVar) {
        this.f7638a = zVar;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.getClass();
        view.getClass();
        recyclerView.getClass();
        state.getClass();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int itemCount = state.getItemCount();
        z zVar = this.f7638a;
        int spanCount = zVar.f7648m.getSpanCount();
        if (itemCount <= 0 || childAdapterPosition < ((itemCount - 1) / spanCount) * spanCount) {
            return;
        }
        rect.right = zVar.itemView.getContext().getResources().getDimensionPixelSize(2131166251);
    }
}
