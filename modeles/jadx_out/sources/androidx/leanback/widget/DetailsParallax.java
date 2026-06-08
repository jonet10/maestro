package androidx.leanback.widget;

import androidx.leanback.widget.Parallax;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class DetailsParallax extends RecyclerViewParallax {
    final Parallax.IntProperty mFrameTop = addProperty("overviewRowTop").adapterPosition(0).viewId(androidx.leanback.R.id.details_frame);
    final Parallax.IntProperty mFrameBottom = addProperty("overviewRowBottom").adapterPosition(0).viewId(androidx.leanback.R.id.details_frame).fraction(1.0f);

    public Parallax.IntProperty getOverviewRowBottom() {
        return this.mFrameBottom;
    }

    public Parallax.IntProperty getOverviewRowTop() {
        return this.mFrameTop;
    }
}
