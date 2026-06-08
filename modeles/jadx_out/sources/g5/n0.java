package g5;

import android.os.Bundle;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.VerticalGridPresenter;
import androidx.lifecycle.LifecycleOwnerKt;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n0 extends VerticalGridSupportFragment implements BrowseSupportFragment.MainFragmentAdapterProvider {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayObjectAdapter f5339a;

    /* renamed from: b, reason: collision with root package name */
    public x4.j f5340b;

    /* renamed from: l, reason: collision with root package name */
    public int f5341l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f5342m;

    /* renamed from: n, reason: collision with root package name */
    public final m0 f5343n = new m0(this);

    public n0() {
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(5);
        setGridPresenter(verticalGridPresenter);
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new e5.f());
        this.f5339a = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
    }

    @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentAdapterProvider
    public final BrowseSupportFragment.MainFragmentAdapter getMainFragmentAdapter() {
        return this.f5343n;
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        Bundle arguments;
        super.onCreate(bundle);
        if (this.f5340b == null && (arguments = getArguments()) != null) {
            x4.j jVar = new x4.j(0, (String) null, 7);
            this.f5340b = jVar;
            jVar.c(arguments);
        }
        startEntranceTransition();
        setOnItemViewClickedListener(new j0(this));
        setOnItemViewSelectedListener(new k0(this));
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f5341l == 0) {
            o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new l0(this, null, 1), 3);
        }
    }
}
