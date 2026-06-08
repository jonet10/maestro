package l5;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.UserAvatarActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l extends RecyclerView.ItemDecoration {

    /* renamed from: a, reason: collision with root package name */
    public final int f7142a;

    public l(UserAvatarActivity userAvatarActivity) {
        this.f7142a = userAvatarActivity.getResources().getDimensionPixelSize(2131166251);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    public final void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.getClass();
        view.getClass();
        recyclerView.getClass();
        state.getClass();
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        int i = this.f7142a;
        if (childAdapterPosition != 0) {
            rect.right = i;
        } else {
            rect.left = i;
            rect.right = i;
        }
    }
}
