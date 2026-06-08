package com.uptodown.tv.ui.fragment;

import a2.s;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.VerticalGridPresenter;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.l;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import b4.d;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadApkWorker;
import e5.p;
import g5.e0;
import g5.x;
import j5.a;
import java.util.Arrays;
import o7.c0;
import o7.m0;
import t6.c;
import x4.e;
import x4.g;
import x4.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class TvOldVersionsFragment extends VerticalGridSupportFragment {

    /* renamed from: a, reason: collision with root package name */
    public g f3440a;

    /* renamed from: b, reason: collision with root package name */
    public e f3441b;

    /* renamed from: l, reason: collision with root package name */
    public AlertDialog f3442l;

    /* renamed from: m, reason: collision with root package name */
    public x f3443m;

    public static final void a(TvOldVersionsFragment tvOldVersionsFragment, r rVar) {
        Context requireContext = tvOldVersionsFragment.requireContext();
        requireContext.getClass();
        int r9 = rVar.r(requireContext);
        if (r9 < 0) {
            Toast.makeText(tvOldVersionsFragment.getContext(), tvOldVersionsFragment.getString(2131951992) + " (108)", 1).show();
            return;
        }
        Context requireContext2 = tvOldVersionsFragment.requireContext();
        requireContext2.getClass();
        float f = UptodownApp.I;
        if (!d.p(requireContext2, "downloadApkWorker")) {
            WorkManager.Companion.getInstance(requireContext2).enqueue(((OneTimeWorkRequest.Builder) l.t(DownloadApkWorker.class, "downloadApkWorker")).setInputData(new Data.Builder().putInt("downloadId", r9).build()).build());
            return;
        }
        Context context = tvOldVersionsFragment.getContext();
        String string = tvOldVersionsFragment.getString(2131952261);
        string.getClass();
        g gVar = tvOldVersionsFragment.f3440a;
        gVar.getClass();
        Toast.makeText(context, String.format(string, Arrays.copyOf(new Object[]{gVar.f11159b}, 1)), 1).show();
    }

    @Override // androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null && (extras = activity.getIntent().getExtras()) != null) {
            if (extras.containsKey("app")) {
                this.f3441b = (e) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("app", e.class) : extras.getParcelable("app"));
            }
            if (extras.containsKey("appInfo")) {
                this.f3440a = (g) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("appInfo", g.class) : extras.getParcelable("appInfo"));
                Context requireContext = requireContext();
                requireContext.getClass();
                g gVar = this.f3440a;
                gVar.getClass();
                this.f3441b = a.h(requireContext, gVar.F);
            }
        }
        e eVar = this.f3441b;
        if (eVar != null) {
            p pVar = new p();
            pVar.f4752a = eVar.f11123l;
            pVar.f4753b = eVar;
            this.f3443m = new x(pVar);
        } else {
            g gVar2 = this.f3440a;
            if (gVar2 != null) {
                String str = gVar2.F;
                p pVar2 = new p();
                pVar2.f4752a = str;
                this.f3443m = new x(pVar2);
            }
        }
        setAdapter(this.f3443m);
        setTitle(getString(2131952552));
        if (bundle == null) {
            prepareEntranceTransition();
        }
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(2);
        setGridPresenter(verticalGridPresenter);
        new Handler(Looper.getMainLooper()).postDelayed(new s(this, 14), 500L);
        setOnItemViewClickedListener(new e0(this));
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        viewLifecycleOwner.getClass();
        LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner);
        v7.e eVar = m0.f8288a;
        c0.s(lifecycleScope, v7.d.f10884a, null, new b.s(this, (c) null, 22), 2);
    }
}
