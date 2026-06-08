package g5;

import android.os.Handler;
import android.os.Looper;
import androidx.leanback.widget.SearchBar;
import com.uptodown.tv.ui.fragment.TvSearchFragment;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i0 implements SearchBar.SearchBarListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TvSearchFragment f5323a;

    public i0(TvSearchFragment tvSearchFragment) {
        this.f5323a = tvSearchFragment;
    }

    @Override // androidx.leanback.widget.SearchBar.SearchBarListener
    public final void onKeyboardDismiss(String str) {
        str.getClass();
        new Handler(Looper.getMainLooper()).postDelayed(new h0(this.f5323a), 2000L);
    }

    @Override // androidx.leanback.widget.SearchBar.SearchBarListener
    public final void onSearchQueryChange(String str) {
        if (str == null || str.length() <= 2) {
            return;
        }
        TvSearchFragment tvSearchFragment = this.f5323a;
        if (str.equalsIgnoreCase(tvSearchFragment.f3446b)) {
            return;
        }
        tvSearchFragment.f3446b = str;
        tvSearchFragment.a(str);
    }

    @Override // androidx.leanback.widget.SearchBar.SearchBarListener
    public final void onSearchQuerySubmit(String str) {
        if (str == null || str.length() <= 2) {
            return;
        }
        TvSearchFragment tvSearchFragment = this.f5323a;
        if (str.equalsIgnoreCase(tvSearchFragment.f3446b)) {
            return;
        }
        tvSearchFragment.f3446b = str;
        tvSearchFragment.a(str);
    }
}
