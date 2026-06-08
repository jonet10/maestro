package l5;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final int f7137a;

    /* renamed from: b, reason: collision with root package name */
    public final int f7138b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7139c;

    /* renamed from: d, reason: collision with root package name */
    public final int f7140d;

    public i(int i, int i6, int i10, int i11) {
        this.f7137a = i;
        this.f7138b = i6;
        this.f7139c = i10;
        this.f7140d = i11;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.getClass();
        view.getClass();
        recyclerView.getClass();
        state.getClass();
        rect.left = this.f7137a;
        rect.right = this.f7138b;
        rect.bottom = this.f7139c;
        rect.top = this.f7140d;
        if (recyclerView.getChildLayoutPosition(view) > 0) {
            rect.top = 0;
        }
    }
}
