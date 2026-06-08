package c4;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.LifecycleOwnerKt;
import com.uptodown.activities.ReviewsActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class y8 implements ActivityResultCallback, NestedScrollView.OnScrollChangeListener, OnApplyWindowInsetsListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReviewsActivity f2359a;

    public /* synthetic */ y8(ReviewsActivity reviewsActivity) {
        this.f2359a = reviewsActivity;
    }

    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        int i = ReviewsActivity.T;
        if (((ActivityResult) obj).getResultCode() == 1) {
            ReviewsActivity reviewsActivity = this.f2359a;
            if (x4.u2.g(reviewsActivity)) {
                x4.u2.i(reviewsActivity, LifecycleOwnerKt.getLifecycleScope(reviewsActivity));
                reviewsActivity.C0(reviewsActivity.y0().f10088b.getText().toString());
            }
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        int i = ReviewsActivity.T;
        view.getClass();
        windowInsetsCompat.getClass();
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.statusBars());
        insets.getClass();
        Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime());
        insets2.getClass();
        Insets insets3 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars());
        insets3.getClass();
        ReviewsActivity reviewsActivity = this.f2359a;
        ViewGroup.LayoutParams layoutParams = reviewsActivity.y0().f10099w.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.topMargin = insets.top;
            reviewsActivity.y0().f10099w.setLayoutParams(layoutParams2);
        }
        int max = Math.max(insets2.bottom, insets3.bottom);
        ViewGroup.LayoutParams layoutParams3 = reviewsActivity.y0().f10096s.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = layoutParams3 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams4 != null) {
            layoutParams4.bottomMargin = max;
            reviewsActivity.y0().f10096s.setLayoutParams(layoutParams4);
        }
        return windowInsetsCompat;
    }

    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
    public void onScrollChange(NestedScrollView nestedScrollView, int i, int i6, int i10, int i11) {
        int i12 = ReviewsActivity.T;
        nestedScrollView.getClass();
        if (i6 == nestedScrollView.getChildAt(0).getMeasuredHeight() - nestedScrollView.getMeasuredHeight()) {
            ReviewsActivity reviewsActivity = this.f2359a;
            if (reviewsActivity.A0().f1643n || !reviewsActivity.A0().f1642m) {
                return;
            }
            reviewsActivity.A0().f1643n = true;
            e4.i0 i0Var = reviewsActivity.Q;
            if (i0Var != null) {
                i0Var.f4563d = true;
                i0Var.notifyItemInserted(i0Var.getItemCount());
            }
            reviewsActivity.z0();
        }
    }
}
