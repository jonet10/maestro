package c4;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v extends ItemTouchHelper.SimpleCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ k0 f2189a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(MainActivity mainActivity) {
        super(0, 8);
        this.f2189a = mainActivity;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
        recyclerView.getClass();
        viewHolder.getClass();
        viewHolder2.getClass();
        return false;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper.Callback
    public final void onSwiped(RecyclerView.ViewHolder viewHolder, int i) {
        viewHolder.getClass();
        int absoluteAdapterPosition = viewHolder.getAbsoluteAdapterPosition();
        e4.c0 c0Var = this.f2189a.H;
        if (c0Var != null) {
            c0Var.a(absoluteAdapterPosition);
        }
    }
}
