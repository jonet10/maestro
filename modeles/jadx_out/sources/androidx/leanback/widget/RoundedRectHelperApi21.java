package androidx.leanback.widget;

import android.graphics.Outline;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(21)
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class RoundedRectHelperApi21 {
    private static final int MAX_CACHED_PROVIDER = 32;
    private static SparseArray<ViewOutlineProvider> sRoundedRectProvider;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class RoundedRectOutlineProvider extends ViewOutlineProvider {
        private int mRadius;

        public RoundedRectOutlineProvider(int i) {
            this.mRadius = i;
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), this.mRadius);
            outline.setAlpha(1.0f);
        }
    }

    private RoundedRectHelperApi21() {
    }

    public static void setClipToRoundedOutline(View view, boolean z9, int i) {
        if (z9) {
            if (sRoundedRectProvider == null) {
                sRoundedRectProvider = new SparseArray<>();
            }
            ViewOutlineProvider viewOutlineProvider = sRoundedRectProvider.get(i);
            if (viewOutlineProvider == null) {
                viewOutlineProvider = new RoundedRectOutlineProvider(i);
                if (sRoundedRectProvider.size() < 32) {
                    sRoundedRectProvider.put(i, viewOutlineProvider);
                }
            }
            view.setOutlineProvider(viewOutlineProvider);
        } else {
            view.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        }
        view.setClipToOutline(z9);
    }
}
