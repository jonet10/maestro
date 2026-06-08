package com.uptodown.tv.ui.fragment;

import a3.e;
import a4.g0;
import a5.c;
import android.R;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.inputmethod.a;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.BackgroundManager;
import androidx.leanback.app.DetailsSupportFragment;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ClassPresenterSelector;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.FullWidthDetailsOverviewSharedElementHelper;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.SparseArrayObjectAdapter;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.l;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import b4.d;
import c4.ya;
import com.google.android.gms.internal.measurement.i5;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadApkWorker;
import e1.c0;
import e5.b;
import g5.f;
import java.util.Arrays;
import k0.k;
import l7.u;
import o7.m0;
import t7.n;
import x4.g;
import x4.q2;
import x4.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class TvAppDetailFragment extends DetailsSupportFragment {

    /* renamed from: a, reason: collision with root package name */
    public g f3413a;

    /* renamed from: m, reason: collision with root package name */
    public ArrayObjectAdapter f3416m;

    /* renamed from: n, reason: collision with root package name */
    public BackgroundManager f3417n;

    /* renamed from: o, reason: collision with root package name */
    public AlertDialog f3418o;

    /* renamed from: p, reason: collision with root package name */
    public AlertDialog f3419p;

    /* renamed from: q, reason: collision with root package name */
    public DetailsOverviewRow f3420q;

    /* renamed from: r, reason: collision with root package name */
    public boolean f3421r;

    /* renamed from: s, reason: collision with root package name */
    public q2 f3422s;

    /* renamed from: t, reason: collision with root package name */
    public b f3423t;

    /* renamed from: x, reason: collision with root package name */
    public final ActivityResultLauncher f3426x;

    /* renamed from: b, reason: collision with root package name */
    public long f3414b = -1;

    /* renamed from: l, reason: collision with root package name */
    public int f3415l = -1;

    /* renamed from: u, reason: collision with root package name */
    public boolean f3424u = true;
    public boolean v = true;

    /* renamed from: w, reason: collision with root package name */
    public final c0 f3425w = new c0(this);

    public TvAppDetailFragment() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new a(this, 20));
        registerForActivityResult.getClass();
        this.f3426x = registerForActivityResult;
    }

    public static void a(TvAppDetailFragment tvAppDetailFragment) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 30 ? Environment.isExternalStorageManager() : i >= 33 || ContextCompat.checkSelfPermission(tvAppDetailFragment.requireContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            tvAppDetailFragment.j();
        }
    }

    public final void b() {
        if (this.f3413a == null || getContext() == null) {
            return;
        }
        g gVar = this.f3413a;
        gVar.getClass();
        long j = gVar.f11158a;
        if (a5.b.c(j) || c.b(j) || a5.b.e(j)) {
            a5.b.f();
        }
    }

    public final void c(r rVar, String str) {
        AlertDialog alertDialog = this.f3418o;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(str);
        builder.setPositiveButton(R.string.ok, new g5.c(this, rVar));
        builder.setNegativeButton(R.string.cancel, new f5.b(5));
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        this.f3418o = create;
        if (create != null) {
            create.show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0041  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d() {
        /*
            r6 = this;
            java.lang.String r0 = "SettingsPreferences"
            android.app.AlertDialog r1 = r6.f3419p
            if (r1 == 0) goto L9
            r1.dismiss()
        L9:
            android.content.Context r1 = r6.requireContext()
            r1.getClass()
            java.lang.String r2 = "is_in_eea"
            r3 = 1
            r4 = 0
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r0, r4)     // Catch: java.lang.Exception -> L23
            boolean r5 = r1.contains(r2)     // Catch: java.lang.Exception -> L23
            if (r5 == 0) goto L23
            boolean r1 = r1.getBoolean(r2, r3)     // Catch: java.lang.Exception -> L23
            goto L24
        L23:
            r1 = r3
        L24:
            if (r1 == 0) goto L86
            android.content.Context r1 = r6.requireContext()
            r1.getClass()
            java.lang.String r2 = "gdpr_tracking_allowed"
            android.content.SharedPreferences r0 = r1.getSharedPreferences(r0, r4)     // Catch: java.lang.Exception -> L3e
            boolean r1 = r0.contains(r2)     // Catch: java.lang.Exception -> L3e
            if (r1 == 0) goto L3e
            boolean r0 = r0.getBoolean(r2, r4)     // Catch: java.lang.Exception -> L3e
            goto L3f
        L3e:
            r0 = r4
        L3f:
            if (r0 != 0) goto L86
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            android.content.Context r1 = r6.requireContext()
            r0.<init>(r1)
            r1 = 2131952663(0x7f130417, float:1.9541775E38)
            java.lang.String r1 = r6.getString(r1)
            r0.setMessage(r1)
            d4.p r1 = new d4.p
            r2 = 2
            r1.<init>(r6, r2)
            r2 = 2131952044(0x7f1301ac, float:1.954052E38)
            r0.setPositiveButton(r2, r1)
            f5.b r1 = new f5.b
            r2 = 4
            r1.<init>(r2)
            r2 = 17039360(0x1040000, float:2.424457E-38)
            r0.setNegativeButton(r2, r1)
            r0.setCancelable(r3)
            android.app.AlertDialog r0 = r0.create()
            r6.f3419p = r0
            androidx.fragment.app.FragmentActivity r0 = r6.requireActivity()
            boolean r0 = r0.isFinishing()
            if (r0 != 0) goto L86
            android.app.AlertDialog r0 = r6.f3419p
            if (r0 == 0) goto L85
            r0.show()
        L85:
            return r3
        L86:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.tv.ui.fragment.TvAppDetailFragment.d():boolean");
    }

    public final void g(String str) {
        AlertDialog alertDialog = this.f3418o;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(str);
        builder.setPositiveButton(R.string.ok, new f5.b(2));
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        this.f3418o = create;
        if (create != null) {
            create.show();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            Method dump skipped, instructions count: 287
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.tv.ui.fragment.TvAppDetailFragment.h():void");
    }

    public final void i(r rVar) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            g gVar = this.f3413a;
            gVar.getClass();
            rVar.a(gVar);
            int r9 = rVar.r(activity);
            if (r9 < 0) {
                String string = getString(2131951915);
                string.getClass();
                g(string);
                o();
                return;
            }
            float f = UptodownApp.I;
            if (!d.p(activity, "downloadApkWorker")) {
                WorkManager.Companion.getInstance(activity).enqueue(((OneTimeWorkRequest.Builder) l.t(DownloadApkWorker.class, "downloadApkWorker")).setInputData(new Data.Builder().putInt("downloadId", r9).build()).build());
                return;
            }
            String string2 = getString(2131952261);
            string2.getClass();
            g gVar2 = this.f3413a;
            gVar2.getClass();
            g(String.format(string2, Arrays.copyOf(new Object[]{gVar2.f11159b}, 1)));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0091  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void j() {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.tv.ui.fragment.TvAppDetailFragment.j():void");
    }

    public final boolean k() {
        g gVar = this.f3413a;
        gVar.getClass();
        long j = gVar.f11158a;
        return a5.b.c(j) || c.b(j);
    }

    public final void l(String str) {
        boolean k5;
        if (this.f3413a != null) {
            Bundle e10 = k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
            g gVar = this.f3413a;
            gVar.getClass();
            e10.putString("packagename", gVar.F);
            g gVar2 = this.f3413a;
            gVar2.getClass();
            if (gVar2.f11158a >= 0) {
                g gVar3 = this.f3413a;
                gVar3.getClass();
                e10.putString("appId", String.valueOf(gVar3.f11158a));
            }
            g gVar4 = this.f3413a;
            gVar4.getClass();
            if (gVar4.J >= 0) {
                g gVar5 = this.f3413a;
                gVar5.getClass();
                e10.putString("fileId", String.valueOf(gVar5.J));
            }
            g gVar6 = this.f3413a;
            if (gVar6 == null) {
                k5 = false;
            } else {
                float f = UptodownApp.I;
                k5 = d.k(gVar6.F);
            }
            if (k5) {
                e10.putInt("deeplink", 1);
            } else {
                e10.putInt("deeplink", 0);
            }
            new android.support.v4.media.g(requireActivity(), 20).E(e10, "warning");
        }
    }

    public final void m() {
        if (Build.VERSION.SDK_INT >= 33 || ContextCompat.checkSelfPermission(requireContext(), "android.permission.WRITE_EXTERNAL_STORAGE") == 0) {
            j();
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 645);
        }
    }

    public final void n() {
        if (Build.VERSION.SDK_INT < 30) {
            m();
            return;
        }
        if (Environment.isExternalStorageManager()) {
            m();
            return;
        }
        try {
            this.f3426x.launch(new Intent("android.settings.MANAGE_APP_ALL_FILES_ACCESS_PERMISSION", Uri.parse("package:" + requireContext().getPackageName())));
        } catch (ActivityNotFoundException unused) {
            m();
        }
    }

    public final void o() {
        SparseArrayObjectAdapter sparseArrayObjectAdapter;
        long j;
        g gVar;
        if (getActivity() != null) {
            if (this.f3415l != 1) {
                try {
                    sparseArrayObjectAdapter = new SparseArrayObjectAdapter(new e5.a());
                    try {
                        gVar = this.f3413a;
                    } catch (NumberFormatException e10) {
                        e10.printStackTrace();
                    }
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
                if (gVar != null && gVar.f11177p != null) {
                    gVar.getClass();
                    String str = gVar.f11177p;
                    str.getClass();
                    j = Long.parseLong(str);
                    String string = requireActivity().getString(2131952712);
                    Context requireContext = requireContext();
                    requireContext.getClass();
                    sparseArrayObjectAdapter.set(1, new Action(1L, string, i5.H(requireContext, j)));
                    sparseArrayObjectAdapter.set(3, new Action(3L, requireActivity().getString(2131951947)));
                    sparseArrayObjectAdapter.set(4, new Action(4L, requireActivity().getString(2131952781)));
                    sparseArrayObjectAdapter.set(5, new Action(5L, requireActivity().getString(2131951691)));
                    DetailsOverviewRow detailsOverviewRow = this.f3420q;
                    detailsOverviewRow.getClass();
                    detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                    this.f3415l = 1;
                }
                j = 0;
                String string2 = requireActivity().getString(2131952712);
                Context requireContext2 = requireContext();
                requireContext2.getClass();
                sparseArrayObjectAdapter.set(1, new Action(1L, string2, i5.H(requireContext2, j)));
                sparseArrayObjectAdapter.set(3, new Action(3L, requireActivity().getString(2131951947)));
                sparseArrayObjectAdapter.set(4, new Action(4L, requireActivity().getString(2131952781)));
                sparseArrayObjectAdapter.set(5, new Action(5L, requireActivity().getString(2131951691)));
                DetailsOverviewRow detailsOverviewRow2 = this.f3420q;
                detailsOverviewRow2.getClass();
                detailsOverviewRow2.setActionsAdapter(sparseArrayObjectAdapter);
                this.f3415l = 1;
            }
            b bVar = this.f3423t;
            bVar.getClass();
            i5.b bVar2 = bVar.f4734b;
            if (bVar2 != null) {
                bVar2.a(0);
            }
        }
    }

    @Override // androidx.leanback.app.DetailsSupportFragment, androidx.leanback.app.BaseSupportFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle bundle) {
        BackgroundManager backgroundManager;
        super.onCreate(bundle);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            Bundle extras = activity.getIntent().getExtras();
            if (extras != null) {
                if (extras.containsKey("appId")) {
                    this.f3414b = extras.getLong("appId");
                }
                if (extras.containsKey("appInfo")) {
                    g gVar = (g) (Build.VERSION.SDK_INT >= 34 ? (Parcelable) extras.getParcelable("appInfo", g.class) : extras.getParcelable("appInfo"));
                    this.f3413a = gVar;
                    if (gVar != null) {
                        this.f3414b = gVar.f11158a;
                    }
                }
            }
            BackgroundManager backgroundManager2 = BackgroundManager.getInstance(activity);
            this.f3417n = backgroundManager2;
            if (backgroundManager2 != null && !backgroundManager2.isAttached() && (backgroundManager = this.f3417n) != null) {
                backgroundManager.attach(activity.getWindow());
            }
            Drawable drawable = ContextCompat.getDrawable(activity, 2131231285);
            BackgroundManager backgroundManager3 = this.f3417n;
            if (backgroundManager3 != null) {
                backgroundManager3.setDrawable(drawable);
            }
            this.f3423t = new b(this.f3425w);
            FullWidthDetailsOverviewRowPresenter fullWidthDetailsOverviewRowPresenter = new FullWidthDetailsOverviewRowPresenter(this.f3423t, new e5.d());
            fullWidthDetailsOverviewRowPresenter.setBackgroundColor(ContextCompat.getColor(activity, 2131099686));
            int i = 0;
            fullWidthDetailsOverviewRowPresenter.setInitialState(0);
            FullWidthDetailsOverviewSharedElementHelper fullWidthDetailsOverviewSharedElementHelper = new FullWidthDetailsOverviewSharedElementHelper();
            fullWidthDetailsOverviewSharedElementHelper.setSharedElementEnterTransition(activity, "transition_name");
            fullWidthDetailsOverviewRowPresenter.setListener(fullWidthDetailsOverviewSharedElementHelper);
            fullWidthDetailsOverviewRowPresenter.setParticipatingEntranceTransition(false);
            prepareEntranceTransition();
            fullWidthDetailsOverviewRowPresenter.setOnActionClickedListener(new e(4, this, activity));
            fullWidthDetailsOverviewRowPresenter.setActionsBackgroundColor(ContextCompat.getColor(activity, 2131100500));
            ClassPresenterSelector classPresenterSelector = new ClassPresenterSelector();
            classPresenterSelector.addClassPresenter(DetailsOverviewRow.class, fullWidthDetailsOverviewRowPresenter);
            classPresenterSelector.addClassPresenter(ListRow.class, new ListRowPresenter());
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter(classPresenterSelector);
            this.f3416m = arrayObjectAdapter;
            setAdapter(arrayObjectAdapter);
            if (this.f3413a != null) {
                SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter(new e5.a());
                g gVar2 = this.f3413a;
                gVar2.getClass();
                DetailsOverviewRow detailsOverviewRow = new DetailsOverviewRow(gVar2);
                this.f3420q = detailsOverviewRow;
                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                g gVar3 = this.f3413a;
                gVar3.getClass();
                if (gVar3.e() != null) {
                    g0 d10 = g0.d();
                    g gVar4 = this.f3413a;
                    gVar4.getClass();
                    d10.e(gVar4.e()).b(new f(this, i));
                } else if (getContext() != null) {
                    Drawable drawable2 = ContextCompat.getDrawable(requireContext(), 2131230977);
                    BackgroundManager backgroundManager4 = this.f3417n;
                    backgroundManager4.getClass();
                    backgroundManager4.setDrawable(drawable2);
                }
                g0 d11 = g0.d();
                g gVar5 = this.f3413a;
                gVar5.getClass();
                d11.e(gVar5.h()).b(new g5.g(this, i));
                ArrayObjectAdapter arrayObjectAdapter2 = this.f3416m;
                arrayObjectAdapter2.getClass();
                DetailsOverviewRow detailsOverviewRow2 = this.f3420q;
                detailsOverviewRow2.getClass();
                arrayObjectAdapter2.add(detailsOverviewRow2);
            }
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this);
            v7.e eVar = m0.f8288a;
            o7.c0.s(lifecycleScope, n.f10348a, null, new ya(this, null, 9), 2);
            d();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        strArr.getClass();
        iArr.getClass();
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (i == 831) {
            if ((iArr.length == 0) || iArr[0] != 0) {
                return;
            }
            j();
        }
    }

    @Override // androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.v) {
            this.v = false;
        } else {
            u();
        }
    }

    @Override // androidx.leanback.app.DetailsSupportFragment, androidx.leanback.app.BrandedSupportFragment, androidx.fragment.app.Fragment
    public final void onStart() {
        super.onStart();
        if (!this.f3424u) {
            o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new g5.e(this, null, 1), 3);
        }
        this.f3424u = false;
    }

    @Override // androidx.leanback.app.DetailsSupportFragment, androidx.fragment.app.Fragment
    public final void onStop() {
        BackgroundManager backgroundManager = this.f3417n;
        backgroundManager.getClass();
        backgroundManager.release();
        super.onStop();
    }

    public final void p(r rVar) {
        if (getActivity() != null) {
            if (this.f3415l != 3) {
                SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter(new e5.a());
                sparseArrayObjectAdapter.set(1, new Action(1L, requireActivity().getString(R.string.cancel)));
                if (this.f3413a != null) {
                    String packageName = requireActivity().getPackageName();
                    g gVar = this.f3413a;
                    gVar.getClass();
                    if (!u.m0(packageName, gVar.F, true)) {
                        sparseArrayObjectAdapter.set(3, new Action(3L, getString(2131951947)));
                    }
                }
                sparseArrayObjectAdapter.set(4, new Action(4L, getString(2131952781)));
                sparseArrayObjectAdapter.set(5, new Action(5L, getString(2131951691)));
                DetailsOverviewRow detailsOverviewRow = this.f3420q;
                detailsOverviewRow.getClass();
                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                this.f3415l = 3;
            }
            b bVar = this.f3423t;
            bVar.getClass();
            int i = rVar.i();
            i5.b bVar2 = bVar.f4734b;
            if (bVar2 != null) {
                bVar2.a(i);
            }
        }
    }

    public final void q() {
        if (getActivity() != null) {
            if (this.f3415l != 2) {
                SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter(new e5.a());
                sparseArrayObjectAdapter.set(1, new Action(1L, getString(2131952428)));
                if (getActivity() != null && this.f3413a != null) {
                    String packageName = requireActivity().getPackageName();
                    g gVar = this.f3413a;
                    gVar.getClass();
                    if (!u.m0(packageName, gVar.F, true)) {
                        sparseArrayObjectAdapter.set(3, new Action(3L, getString(2131951947)));
                    }
                }
                sparseArrayObjectAdapter.set(4, new Action(4L, getString(2131952781)));
                sparseArrayObjectAdapter.set(5, new Action(5L, getString(2131951691)));
                DetailsOverviewRow detailsOverviewRow = this.f3420q;
                detailsOverviewRow.getClass();
                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                this.f3415l = 2;
            }
            b bVar = this.f3423t;
            bVar.getClass();
            i5.b bVar2 = bVar.f4734b;
            if (bVar2 != null) {
                bVar2.a(0);
            }
        }
    }

    public final void r() {
        if (getActivity() != null) {
            if (this.f3415l != 7) {
                SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter(new e5.a());
                sparseArrayObjectAdapter.set(1, new Action(1L, getString(2131952095)));
                if (getActivity() != null && this.f3413a != null) {
                    String packageName = requireActivity().getPackageName();
                    g gVar = this.f3413a;
                    gVar.getClass();
                    if (!u.m0(packageName, gVar.F, true)) {
                        sparseArrayObjectAdapter.set(3, new Action(3L, getString(2131951947)));
                    }
                }
                sparseArrayObjectAdapter.set(4, new Action(4L, getString(2131952781)));
                sparseArrayObjectAdapter.set(5, new Action(5L, getString(2131951691)));
                DetailsOverviewRow detailsOverviewRow = this.f3420q;
                detailsOverviewRow.getClass();
                detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
                this.f3415l = 7;
            }
            b bVar = this.f3423t;
            bVar.getClass();
            i5.b bVar2 = bVar.f4734b;
            if (bVar2 != null) {
                bVar2.f5667p.setIndeterminate(true);
            }
        }
    }

    public final void s() {
        if (getActivity() == null || this.f3415l == 0) {
            return;
        }
        SparseArrayObjectAdapter sparseArrayObjectAdapter = new SparseArrayObjectAdapter(new e5.a());
        if (getActivity() != null && this.f3413a != null) {
            String packageName = requireActivity().getPackageName();
            g gVar = this.f3413a;
            gVar.getClass();
            if (!u.m0(packageName, gVar.F, true)) {
                sparseArrayObjectAdapter.set(1, new Action(1L, getString(2131952419)));
                sparseArrayObjectAdapter.set(2, new Action(2L, getString(2131951948)));
                sparseArrayObjectAdapter.set(3, new Action(3L, getString(2131951947)));
            }
        }
        sparseArrayObjectAdapter.set(4, new Action(4L, getString(2131952781)));
        sparseArrayObjectAdapter.set(5, new Action(5L, getString(2131951691)));
        DetailsOverviewRow detailsOverviewRow = this.f3420q;
        detailsOverviewRow.getClass();
        detailsOverviewRow.setActionsAdapter(sparseArrayObjectAdapter);
        this.f3415l = 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0068 A[Catch: Exception -> 0x002d, TryCatch #0 {Exception -> 0x002d, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000b, B:9:0x0015, B:11:0x001e, B:12:0x0036, B:14:0x0068, B:15:0x008c, B:20:0x0031), top: B:2:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void t() {
        /*
            r8 = this;
            r0 = 5
            androidx.fragment.app.FragmentActivity r1 = r8.getActivity()     // Catch: java.lang.Exception -> L2d
            if (r1 == 0) goto Lbb
            x4.g r1 = r8.f3413a     // Catch: java.lang.Exception -> L2d
            if (r1 == 0) goto Lbb
            androidx.leanback.widget.SparseArrayObjectAdapter r1 = new androidx.leanback.widget.SparseArrayObjectAdapter     // Catch: java.lang.Exception -> L2d
            e5.a r2 = new e5.a     // Catch: java.lang.Exception -> L2d
            r2.<init>()     // Catch: java.lang.Exception -> L2d
            r1.<init>(r2)     // Catch: java.lang.Exception -> L2d
            x4.g r2 = r8.f3413a     // Catch: java.lang.Exception -> L2d java.lang.NumberFormatException -> L30
            r2.getClass()     // Catch: java.lang.Exception -> L2d java.lang.NumberFormatException -> L30
            java.lang.String r2 = r2.f11177p     // Catch: java.lang.Exception -> L2d java.lang.NumberFormatException -> L30
            if (r2 == 0) goto L34
            x4.g r2 = r8.f3413a     // Catch: java.lang.Exception -> L2d java.lang.NumberFormatException -> L30
            r2.getClass()     // Catch: java.lang.Exception -> L2d java.lang.NumberFormatException -> L30
            java.lang.String r2 = r2.f11177p     // Catch: java.lang.Exception -> L2d java.lang.NumberFormatException -> L30
            r2.getClass()     // Catch: java.lang.Exception -> L2d java.lang.NumberFormatException -> L30
            long r2 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Exception -> L2d java.lang.NumberFormatException -> L30
            goto L36
        L2d:
            r1 = move-exception
            goto Lb8
        L30:
            r2 = move-exception
            r2.printStackTrace()     // Catch: java.lang.Exception -> L2d
        L34:
            r2 = 0
        L36:
            androidx.leanback.widget.Action r4 = new androidx.leanback.widget.Action     // Catch: java.lang.Exception -> L2d
            r5 = 2131952712(0x7f130448, float:1.9541874E38)
            java.lang.String r5 = r8.getString(r5)     // Catch: java.lang.Exception -> L2d
            android.content.Context r6 = r8.requireContext()     // Catch: java.lang.Exception -> L2d
            r6.getClass()     // Catch: java.lang.Exception -> L2d
            java.lang.String r2 = com.google.android.gms.internal.measurement.i5.H(r6, r2)     // Catch: java.lang.Exception -> L2d
            r6 = 1
            r4.<init>(r6, r5, r2)     // Catch: java.lang.Exception -> L2d
            r2 = 1
            r1.set(r2, r4)     // Catch: java.lang.Exception -> L2d
            androidx.fragment.app.FragmentActivity r3 = r8.requireActivity()     // Catch: java.lang.Exception -> L2d
            java.lang.String r3 = r3.getPackageName()     // Catch: java.lang.Exception -> L2d
            x4.g r4 = r8.f3413a     // Catch: java.lang.Exception -> L2d
            r4.getClass()     // Catch: java.lang.Exception -> L2d
            java.lang.String r4 = r4.F     // Catch: java.lang.Exception -> L2d
            boolean r2 = l7.u.m0(r3, r4, r2)     // Catch: java.lang.Exception -> L2d
            if (r2 != 0) goto L8c
            androidx.leanback.widget.Action r2 = new androidx.leanback.widget.Action     // Catch: java.lang.Exception -> L2d
            r3 = 2131951948(0x7f13014c, float:1.9540325E38)
            java.lang.String r3 = r8.getString(r3)     // Catch: java.lang.Exception -> L2d
            r4 = 2
            r2.<init>(r4, r3)     // Catch: java.lang.Exception -> L2d
            r3 = 2
            r1.set(r3, r2)     // Catch: java.lang.Exception -> L2d
            androidx.leanback.widget.Action r2 = new androidx.leanback.widget.Action     // Catch: java.lang.Exception -> L2d
            r3 = 2131951947(0x7f13014b, float:1.9540323E38)
            java.lang.String r3 = r8.getString(r3)     // Catch: java.lang.Exception -> L2d
            r4 = 3
            r2.<init>(r4, r3)     // Catch: java.lang.Exception -> L2d
            r3 = 3
            r1.set(r3, r2)     // Catch: java.lang.Exception -> L2d
        L8c:
            androidx.leanback.widget.Action r2 = new androidx.leanback.widget.Action     // Catch: java.lang.Exception -> L2d
            r3 = 2131952781(0x7f13048d, float:1.9542014E38)
            java.lang.String r3 = r8.getString(r3)     // Catch: java.lang.Exception -> L2d
            r4 = 4
            r2.<init>(r4, r3)     // Catch: java.lang.Exception -> L2d
            r3 = 4
            r1.set(r3, r2)     // Catch: java.lang.Exception -> L2d
            androidx.leanback.widget.Action r2 = new androidx.leanback.widget.Action     // Catch: java.lang.Exception -> L2d
            r3 = 2131951691(0x7f13004b, float:1.9539804E38)
            java.lang.String r3 = r8.getString(r3)     // Catch: java.lang.Exception -> L2d
            r4 = 5
            r2.<init>(r4, r3)     // Catch: java.lang.Exception -> L2d
            r1.set(r0, r2)     // Catch: java.lang.Exception -> L2d
            androidx.leanback.widget.DetailsOverviewRow r2 = r8.f3420q     // Catch: java.lang.Exception -> L2d
            r2.getClass()     // Catch: java.lang.Exception -> L2d
            r2.setActionsAdapter(r1)     // Catch: java.lang.Exception -> L2d
            goto Lbb
        Lb8:
            r1.printStackTrace()
        Lbb:
            r8.f3415l = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.tv.ui.fragment.TvAppDetailFragment.t():void");
    }

    public final void u() {
        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(this), null, null, new g5.e(this, null, 4), 3);
    }
}
