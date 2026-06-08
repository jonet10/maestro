package g5;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import b2.t1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v extends RowsSupportFragment {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayObjectAdapter f5359a;

    /* renamed from: b, reason: collision with root package name */
    public final ActivityResultLauncher f5360b;

    public v() {
        ListRowPresenter listRowPresenter = new ListRowPresenter(4);
        listRowPresenter.setShadowEnabled(false);
        this.f5359a = new ArrayObjectAdapter(listRowPresenter);
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new u(this));
        registerForActivityResult.getClass();
        this.f5360b = registerForActivityResult;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        BrowseSupportFragment.FragmentHost fragmentHost;
        super.onCreate(bundle);
        if (getContext() != null) {
            HeaderItem headerItem = new HeaderItem(getString(2131952207));
            Context requireContext = requireContext();
            requireContext.getClass();
            int size = t1.z(requireContext).size();
            String g = size > 0 ? a4.x.g(size, " (", ")") : "";
            e5.l lVar = new e5.l();
            lVar.f4743a = -1;
            lVar.f4744b = -1;
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(lVar);
            c5.b bVar = new c5.b();
            bVar.f2414a = 0;
            bVar.f2415b = a4.x.C(getString(2131952709), g);
            bVar.f2416c = 2131231469;
            arrayObjectAdapter.add(bVar);
            c5.b bVar2 = new c5.b();
            bVar2.f2414a = 1;
            bVar2.f2415b = getString(2131952094);
            bVar2.f2416c = 2131231466;
            arrayObjectAdapter.add(bVar2);
            c5.b bVar3 = new c5.b();
            bVar3.f2414a = 2;
            bVar3.f2415b = getString(2131952552);
            bVar3.f2416c = 2131231467;
            arrayObjectAdapter.add(bVar3);
            c5.b bVar4 = new c5.b();
            bVar4.f2414a = 3;
            bVar4.f2415b = getString(2131951976);
            bVar4.f2416c = 2131231461;
            arrayObjectAdapter.add(bVar4);
            c5.b bVar5 = new c5.b();
            bVar5.f2414a = 4;
            bVar5.f2415b = getString(2131952586);
            bVar5.f2416c = 2131231468;
            arrayObjectAdapter.add(bVar5);
            ListRow listRow = new ListRow(headerItem, arrayObjectAdapter);
            ArrayObjectAdapter arrayObjectAdapter2 = this.f5359a;
            arrayObjectAdapter2.add(listRow);
            setAdapter(arrayObjectAdapter2);
            BrowseSupportFragment.MainFragmentAdapter mainFragmentAdapter = getMainFragmentAdapter();
            if (mainFragmentAdapter == null || (fragmentHost = mainFragmentAdapter.getFragmentHost()) == null) {
                return;
            }
            fragmentHost.notifyDataReady(getMainFragmentAdapter());
        }
    }

    @Override // androidx.leanback.app.RowsSupportFragment, androidx.leanback.app.BaseRowSupportFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        setOnItemViewClickedListener(new u(this));
    }
}
