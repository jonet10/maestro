package c4;

import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.uptodown.activities.MainActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p3 implements TabLayout.OnTabSelectedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MainActivity f1980a;

    public p3(MainActivity mainActivity) {
        this.f1980a = mainActivity;
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabReselected(TabLayout.Tab tab) {
        u4.f1 f1Var;
        tab.getClass();
        int position = tab.getPosition();
        MainActivity mainActivity = this.f1980a;
        if (position == 0) {
            int i = MainActivity.G0;
            mainActivity.q1();
            u4.m1 m1Var = mainActivity.f3316o0;
            if (m1Var != null) {
                m1Var.b().f10040m.smoothScrollToPosition(0);
                return;
            }
            return;
        }
        if (position == 1) {
            int i6 = MainActivity.G0;
            mainActivity.q1();
            u4.g1 g1Var = mainActivity.f3315m0;
            if (g1Var != null) {
                g1Var.h().smoothScrollToPosition(0);
                return;
            }
            return;
        }
        if (position != 2) {
            if (position == 3 && (f1Var = mainActivity.f3317p0) != null) {
                f1Var.a().f9935s.smoothScrollToPosition(0);
                return;
            }
            return;
        }
        int i10 = MainActivity.G0;
        mainActivity.q1();
        if (mainActivity.getSupportFragmentManager().getBackStackEntryCount() > 0) {
            mainActivity.getSupportFragmentManager().popBackStackImmediate("appsCategory", 1);
            return;
        }
        u4.w0 w0Var = mainActivity.n0;
        if (w0Var != null) {
            w0Var.h().smoothScrollToPosition(0);
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabSelected(TabLayout.Tab tab) {
        tab.getClass();
        MainActivity mainActivity = this.f1980a;
        ViewPager2 viewPager2 = mainActivity.f3310h0;
        viewPager2.getClass();
        viewPager2.setCurrentItem(tab.getPosition(), false);
        int i = MainActivity.G0;
        ViewPager2 viewPager22 = mainActivity.f3310h0;
        viewPager22.getClass();
        MainActivity.G0 = viewPager22.getCurrentItem();
        mainActivity.h1();
        mainActivity.q1();
        int position = tab.getPosition();
        if (position == 0) {
            MainActivity.L0(mainActivity, "home");
            return;
        }
        if (position == 1) {
            MainActivity.L0(mainActivity, "games");
            return;
        }
        if (position == 2) {
            MainActivity.L0(mainActivity, "apps");
            return;
        }
        if (position != 3) {
            return;
        }
        AppBarLayout appBarLayout = mainActivity.Y;
        appBarLayout.getClass();
        appBarLayout.setVisibility(0);
        AppBarLayout appBarLayout2 = mainActivity.Y;
        appBarLayout2.getClass();
        appBarLayout2.setExpanded(false, false);
        MainActivity.L0(mainActivity, "feed");
        TabLayout tabLayout = mainActivity.f3314l0;
        tabLayout.getClass();
        TabLayout.Tab tabAt = tabLayout.getTabAt(3);
        if (tabAt != null) {
            tabAt.setIcon(ContextCompat.getDrawable(mainActivity, 2131231170));
        }
    }

    @Override // com.google.android.material.tabs.TabLayout.BaseOnTabSelectedListener
    public final void onTabUnselected(TabLayout.Tab tab) {
        tab.getClass();
    }
}
