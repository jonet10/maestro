package com.uptodown.tv.ui.fragment;

import android.R;
import android.app.AlertDialog;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.VerticalGridPresenter;
import androidx.lifecycle.LifecycleOwnerKt;
import e5.f;
import f5.b;
import g5.h;
import g5.i;
import java.util.ArrayList;
import o7.c0;
import x4.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class TvAppsListFragment extends VerticalGridSupportFragment {

    /* renamed from: a, reason: collision with root package name */
    public ArrayObjectAdapter f3427a;

    /* renamed from: b, reason: collision with root package name */
    public j f3428b;

    /* renamed from: l, reason: collision with root package name */
    public int f3429l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3430m;

    public static final void a(TvAppsListFragment tvAppsListFragment, ArrayList arrayList) {
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                ArrayObjectAdapter arrayObjectAdapter = tvAppsListFragment.f3427a;
                arrayObjectAdapter.getClass();
                arrayObjectAdapter.add(arrayList.get(i));
            }
            return;
        }
        String string = tvAppsListFragment.getString(2131952381);
        string.getClass();
        FragmentActivity activity = tvAppsListFragment.getActivity();
        if (activity == null || activity.isFinishing()) {
            return;
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setMessage(string);
        builder.setPositiveButton(R.string.ok, new b(6));
        builder.setCancelable(true);
        builder.create().show();
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(new f());
        this.f3427a = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
        FragmentActivity activity = getActivity();
        if (activity != null && (extras = activity.getIntent().getExtras()) != null && extras.containsKey("category")) {
            this.f3428b = (j) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("category", j.class) : extras.getParcelable("category"));
        }
        j jVar = this.f3428b;
        setTitle(jVar != null ? jVar.f11225b : null);
        if (bundle == null) {
            prepareEntranceTransition();
        }
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(5);
        setGridPresenter(verticalGridPresenter);
        startEntranceTransition();
        setOnItemViewClickedListener(new h(this));
        setOnItemViewSelectedListener(new i(this));
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new g5.j(this, null, 1), 3);
    }
}
