package com.uptodown.tv.ui.fragment;

import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.VerticalGridPresenter;
import androidx.lifecycle.LifecycleOwnerKt;
import b.s;
import e5.o;
import g5.c0;
import g5.d0;
import j5.g;
import t6.c;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class TvMyDownloadsFragment extends VerticalGridSupportFragment implements BrowseSupportFragment.MainFragmentAdapterProvider {

    /* renamed from: a, reason: collision with root package name */
    public ArrayObjectAdapter f3437a;

    /* renamed from: b, reason: collision with root package name */
    public AlertDialog f3438b;

    /* renamed from: l, reason: collision with root package name */
    public final d0 f3439l = new d0(this);

    @Override // androidx.leanback.app.BrowseSupportFragment.MainFragmentAdapterProvider
    public final BrowseSupportFragment.MainFragmentAdapter getMainFragmentAdapter() {
        return this.f3439l;
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        o oVar = new o();
        oVar.f4751a = -1;
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(oVar);
        this.f3437a = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
        setTitle(getString(2131951976));
        if (bundle == null) {
            prepareEntranceTransition();
        }
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(2);
        setGridPresenter(verticalGridPresenter);
        startEntranceTransition();
        setOnItemViewClickedListener(new c0(this));
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onPause() {
        e1.c0 c0Var = g.D;
        Context requireContext = requireContext();
        requireContext.getClass();
        g l10 = c0Var.l(requireContext);
        l10.b();
        ContentValues contentValues = new ContentValues();
        contentValues.put("checked", (Integer) 1);
        SQLiteDatabase sQLiteDatabase = l10.f6673a;
        sQLiteDatabase.getClass();
        sQLiteDatabase.update("downloads", contentValues, null, null);
        l10.c();
        super.onPause();
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        Context context = getContext();
        if (context != null) {
            Object systemService = context.getSystemService("notification");
            systemService.getClass();
            ((NotificationManager) systemService).cancel(258);
        }
        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new s(this, (c) null, 21), 3);
    }
}
