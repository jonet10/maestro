package c4;

import androidx.fragment.app.Fragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import com.uptodown.activities.MyDownloads;
import com.uptodown.tv.ui.activity.TvMyDownloadsActivity;
import com.uptodown.tv.ui.activity.TvOldVersionsActivity;
import com.uptodown.tv.ui.fragment.TvMyDownloadsFragment;
import com.uptodown.tv.ui.fragment.TvOldVersionsFragment;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f5 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1591a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1592b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f1593l;

    public /* synthetic */ f5(Object obj, int i, int i6) {
        this.f1591a = i6;
        this.f1593l = obj;
        this.f1592b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f1591a) {
            case 0:
                MyDownloads myDownloads = (MyDownloads) this.f1593l;
                int i = this.f1592b;
                if (i != 302 && i != 352) {
                    e4.b bVar = myDownloads.Q;
                    if (bVar != null) {
                        bVar.notifyDataSetChanged();
                        break;
                    }
                } else {
                    myDownloads.C0(false);
                    break;
                }
                break;
            case 1:
                List<Fragment> fragments = ((TvMyDownloadsActivity) this.f1593l).getSupportFragmentManager().getFragments();
                fragments.getClass();
                if (!fragments.isEmpty()) {
                    Fragment fragment = fragments.get(0);
                    if (fragment instanceof TvMyDownloadsFragment) {
                        TvMyDownloadsFragment tvMyDownloadsFragment = (TvMyDownloadsFragment) fragment;
                        switch (this.f1592b) {
                            case 201:
                                ArrayObjectAdapter arrayObjectAdapter = tvMyDownloadsFragment.f3437a;
                                arrayObjectAdapter.getClass();
                                ArrayObjectAdapter arrayObjectAdapter2 = tvMyDownloadsFragment.f3437a;
                                arrayObjectAdapter2.getClass();
                                arrayObjectAdapter.notifyArrayItemRangeChanged(0, arrayObjectAdapter2.size());
                                break;
                            case 202:
                            case 203:
                                ArrayObjectAdapter arrayObjectAdapter3 = tvMyDownloadsFragment.f3437a;
                                arrayObjectAdapter3.getClass();
                                ArrayObjectAdapter arrayObjectAdapter4 = tvMyDownloadsFragment.f3437a;
                                arrayObjectAdapter4.getClass();
                                arrayObjectAdapter3.notifyArrayItemRangeChanged(0, arrayObjectAdapter4.size());
                                break;
                        }
                    }
                }
                break;
            case 2:
                List<Fragment> fragments2 = ((TvOldVersionsActivity) this.f1593l).getSupportFragmentManager().getFragments();
                fragments2.getClass();
                if (!fragments2.isEmpty()) {
                    Fragment fragment2 = fragments2.get(0);
                    if (fragment2 instanceof TvOldVersionsFragment) {
                        TvOldVersionsFragment tvOldVersionsFragment = (TvOldVersionsFragment) fragment2;
                        switch (this.f1592b) {
                            case 201:
                                g5.x xVar = tvOldVersionsFragment.f3443m;
                                xVar.getClass();
                                g5.x xVar2 = tvOldVersionsFragment.f3443m;
                                xVar2.getClass();
                                xVar.notifyArrayItemRangeChanged(0, xVar2.size());
                                break;
                            case 202:
                            case 203:
                                g5.x xVar3 = tvOldVersionsFragment.f3443m;
                                xVar3.getClass();
                                g5.x xVar4 = tvOldVersionsFragment.f3443m;
                                xVar4.getClass();
                                xVar3.notifyArrayItemRangeChanged(0, xVar4.size());
                                break;
                        }
                    }
                }
                break;
            default:
                ((j0.m) this.f1593l).i(this.f1592b);
                break;
        }
    }
}
