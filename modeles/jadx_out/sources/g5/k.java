package g5;

import androidx.core.content.ContextCompat;
import androidx.leanback.R;
import androidx.leanback.app.ErrorSupportFragment;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k extends ErrorSupportFragment {
    @Override // androidx.leanback.app.ErrorSupportFragment, androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        setBadgeDrawable(ContextCompat.getDrawable(requireContext(), 2131231473));
        setImageDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.lb_ic_sad_cloud));
        setMessage(getString(2131952001));
        setButtonText(getString(2131952524));
        setButtonClickListener(new c4.d(this, 19));
    }
}
