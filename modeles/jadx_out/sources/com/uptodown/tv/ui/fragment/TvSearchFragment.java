package com.uptodown.tv.ui.fragment;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.inputmethod.a;
import androidx.leanback.R;
import androidx.leanback.app.SearchSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.SearchBar;
import androidx.lifecycle.LifecycleOwnerKt;
import g5.g0;
import g5.i0;
import o7.c0;
import o7.s1;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class TvSearchFragment extends SearchSupportFragment implements SearchSupportFragment.SearchResultProvider {

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f3444m = 0;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayObjectAdapter f3445a = new ArrayObjectAdapter(new ListRowPresenter());

    /* renamed from: b, reason: collision with root package name */
    public String f3446b;

    /* renamed from: l, reason: collision with root package name */
    public s1 f3447l;

    public final void a(String str) {
        this.f3445a.clear();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        s1 s1Var = this.f3447l;
        c cVar = null;
        if (s1Var != null) {
            s1Var.c(null);
        }
        this.f3447l = c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new g0(this, str, cVar, 0), 3);
    }

    @Override // androidx.leanback.app.SearchSupportFragment.SearchResultProvider
    public final ObjectAdapter getResultsAdapter() {
        return this.f3445a;
    }

    @Override // androidx.leanback.app.SearchSupportFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setSearchResultProvider(this);
        setOnItemViewClickedListener(new a(this, 23));
    }

    @Override // androidx.leanback.app.SearchSupportFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        s1 s1Var = this.f3447l;
        if (s1Var != null) {
            s1Var.c(null);
        }
    }

    @Override // androidx.leanback.app.SearchSupportFragment.SearchResultProvider
    public final boolean onQueryTextChange(String str) {
        if (str == null || str.length() <= 2 || str.equalsIgnoreCase(this.f3446b)) {
            return true;
        }
        this.f3446b = str;
        a(str);
        return true;
    }

    @Override // androidx.leanback.app.SearchSupportFragment.SearchResultProvider
    public final boolean onQueryTextSubmit(String str) {
        if (str == null || str.length() <= 2 || str.equalsIgnoreCase(this.f3446b)) {
            return true;
        }
        this.f3446b = str;
        a(str);
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        view.getClass();
        super.onViewCreated(view, bundle);
        SearchBar searchBar = (SearchBar) view.findViewById(R.id.lb_search_bar);
        if (searchBar != null) {
            searchBar.setSearchBarListener(new i0(this));
        }
    }
}
