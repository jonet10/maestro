package com.uptodown.tv.ui.fragment;

import a2.s;
import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.VerticalGridPresenter;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import e5.n;
import g5.a0;
import g5.x;
import g5.y;
import o7.c0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class TvMyAppsFragment extends VerticalGridSupportFragment {

    /* renamed from: b, reason: collision with root package name */
    public x f3432b;

    /* renamed from: l, reason: collision with root package name */
    public AlertDialog f3433l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f3434m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f3435n;

    /* renamed from: a, reason: collision with root package name */
    public final LifecycleCoroutineScope f3431a = LifecycleOwnerKt.getLifecycleScope(this);

    /* renamed from: o, reason: collision with root package name */
    public final int f3436o = 5;

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        n nVar = new n();
        nVar.f4746a = -1;
        nVar.f4747b = -1;
        nVar.f4748l = -1;
        nVar.f4749m = -1;
        x xVar = new x(nVar);
        this.f3432b = xVar;
        setAdapter(xVar);
        FragmentActivity activity = getActivity();
        if (activity != null && (extras = activity.getIntent().getExtras()) != null) {
            if (extras.containsKey("updates")) {
                this.f3434m = extras.getBoolean("updates");
            }
            if (extras.containsKey("rollback")) {
                this.f3435n = extras.getBoolean("rollback");
            }
        }
        if (this.f3434m) {
            setTitle(getString(2131952709));
        } else if (this.f3435n) {
            setTitle(getString(2131952552));
        } else {
            setTitle(getString(2131952094));
        }
        if (bundle == null) {
            prepareEntranceTransition();
        }
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(this.f3436o);
        setGridPresenter(verticalGridPresenter);
        new Handler(Looper.getMainLooper()).postDelayed(new s(this, 13), 500L);
        setOnItemViewClickedListener(new y(this));
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        c0.s(this.f3431a, null, null, new a0(this, null, 0), 3);
    }
}
