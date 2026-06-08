package androidx.leanback.widget;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.RestrictTo;
import androidx.leanback.widget.RowPresenter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class InvisibleRowPresenter extends RowPresenter {
    public InvisibleRowPresenter() {
        setHeaderPresenter(null);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        RelativeLayout relativeLayout = new RelativeLayout(viewGroup.getContext());
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(0, 0));
        return new RowPresenter.ViewHolder(relativeLayout);
    }
}
