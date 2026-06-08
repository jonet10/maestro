package androidx.core.view.inputmethod;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.g;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.appcompat.widget.Toolbar;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.sqlite.db.SupportSQLiteOpenHelper;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.work.Constraints;
import androidx.work.ListenableWorker;
import androidx.work.NetworkType;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.impl.WorkDatabase;
import b.n;
import c4.a6;
import c4.b6;
import c4.k0;
import c4.s5;
import c4.sc;
import c4.t0;
import c4.tc;
import c4.w4;
import c4.z5;
import com.google.android.gms.internal.measurement.z3;
import com.google.android.material.bottomsheet.BottomSheetDragHandleView;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.carousel.MaskableFrameLayout;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.gson.internal.m;
import com.google.gson.internal.t;
import com.uptodown.UptodownApp;
import com.uptodown.activities.ListsActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.MyStatsActivity;
import com.uptodown.activities.NotificationsRegistryActivity;
import com.uptodown.activities.PreregistrationActivity;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.activities.RollbackActivity;
import com.uptodown.activities.SearchActivity;
import com.uptodown.activities.UserDevicesActivity;
import com.uptodown.core.activities.ConfirmationIntentWrapperActivity;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.tv.ui.activity.TvAppsListActivity;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import com.uptodown.tv.ui.fragment.TvSearchFragment;
import com.uptodown.views.InstantAutoCompleteTextView;
import com.uptodown.workers.SendUserUsageStatsWorker;
import g5.f;
import g5.f0;
import g5.p;
import g5.q;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import n2.e;
import n4.h;
import o7.a0;
import o7.c0;
import o7.m0;
import p.b;
import p.c;
import q.u;
import s1.d;
import u4.d2;
import u4.f1;
import u4.z1;
import x4.j;
import x4.u2;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final /* synthetic */ class a implements InputConnectionCompat.OnCommitContentListener, SupportSQLiteOpenHelper.Factory, ActivityResultCallback, Toolbar.OnMenuItemClickListener, OnApplyWindowInsetsListener, AccessibilityViewCommand, MaterialShapeDrawable.OnCornerSizeChangeListener, CanvasCompat.CanvasOperation, m, OnItemViewClickedListener, d, SwipeRefreshLayout.OnRefreshListener, s2.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f394a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f395b;

    public /* synthetic */ a(Object obj, int i) {
        this.f394a = i;
        this.f395b = obj;
    }

    public b a(b5.m mVar) {
        c cVar = (c) this.f395b;
        URL url = (URL) mVar.f1061b;
        String D = a.a.D("CctTransportBackend");
        if (Log.isLoggable(D, 4)) {
            Log.i(D, String.format("Making request to: %s", url));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(cVar.g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod(ShareTarget.METHOD_POST);
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/3.3.0 android/");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = (String) mVar.f1063m;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    f fVar = cVar.f8398a;
                    q.m mVar2 = (q.m) mVar.f1062l;
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream));
                    n2.d dVar = (n2.d) fVar.f5309b;
                    e eVar = new e(bufferedWriter, dVar.f7927a, dVar.f7928b, dVar.f7929c, dVar.f7930d);
                    eVar.h(mVar2);
                    eVar.j();
                    eVar.f7932b.flush();
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Integer valueOf = Integer.valueOf(responseCode);
                    String D2 = a.a.D("CctTransportBackend");
                    if (Log.isLoggable(D2, 4)) {
                        Log.i(D2, String.format("Status Code: %d", valueOf));
                    }
                    a.a.u("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    a.a.u("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new b(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new b(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            b bVar = new b(responseCode, null, u.a(new BufferedReader(new InputStreamReader(gZIPInputStream))).f8622a);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return bVar;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (ConnectException e10) {
            e = e10;
            a.a.v("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (UnknownHostException e11) {
            e = e11;
            a.a.v("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new b(500, null, 0L);
        } catch (IOException e12) {
            e = e12;
            a.a.v("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        } catch (l2.b e13) {
            e = e13;
            a.a.v("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new b(400, null, 0L);
        }
    }

    @Override // s2.a
    public void b(s2.b bVar) {
        v1.b bVar2 = (v1.b) this.f395b;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Crashlytics native component now available.", null);
        }
        bVar2.f10790b.set((v1.b) bVar.get());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(35:3|(1:5)(1:160)|6|7|(1:9)|(1:11)(1:159)|12|(3:154|155|(1:157)(1:158))(3:16|(3:150|151|(1:153))(4:20|(2:23|21)|24|25)|26)|27|(1:29)|30|(3:32|(3:34|35|36)(1:38)|37)|39|40|(19:41|42|43|(1:45)|46|(1:48)|(1:50)(1:146)|51|(4:54|(2:56|57)(1:59)|58|52)|60|61|(1:63)|64|65|(1:67)(1:145)|(1:69)(1:144)|70|(5:131|(1:133)|134|3d4|139)(1:74)|75)|(17:79|(1:81)(2:127|(1:129))|82|(2:84|(1:86))(2:123|(2:125|126))|87|88|89|90|91|92|93|(3:115|(1:117)|118)(3:101|(1:103)|104)|105|106|(2:108|(1:110))|111|112)|130|82|(0)(0)|87|88|89|90|91|92|93|(2:95|97)|115|(0)|118|105|106|(0)|111|112) */
    /* JADX WARN: Can't wrap try/catch for region: R(53:3|(1:5)(1:160)|6|7|(1:9)|(1:11)(1:159)|12|(3:154|155|(1:157)(1:158))(3:16|(3:150|151|(1:153))(4:20|(2:23|21)|24|25)|26)|27|(1:29)|30|(3:32|(3:34|35|36)(1:38)|37)|39|40|41|42|43|(1:45)|46|(1:48)|(1:50)(1:146)|51|(4:54|(2:56|57)(1:59)|58|52)|60|61|(1:63)|64|65|(1:67)(1:145)|(1:69)(1:144)|70|(5:131|(1:133)|134|3d4|139)(1:74)|75|(17:79|(1:81)(2:127|(1:129))|82|(2:84|(1:86))(2:123|(2:125|126))|87|88|89|90|91|92|93|(3:115|(1:117)|118)(3:101|(1:103)|104)|105|106|(2:108|(1:110))|111|112)|130|82|(0)(0)|87|88|89|90|91|92|93|(2:95|97)|115|(0)|118|105|106|(0)|111|112) */
    /* JADX WARN: Code restructure failed: missing block: B:121:0x0573, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x058e, code lost:
    
        android.util.Log.e("FirebaseCrashlytics", "Crashlytics was not started due to an exception during initialization", r0);
        r3.g = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0602  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x042d  */
    @Override // s1.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object c(a4.d0 r51) {
        /*
            Method dump skipped, instructions count: 1568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.inputmethod.a.c(a4.d0):java.lang.Object");
    }

    @Override // androidx.sqlite.db.SupportSQLiteOpenHelper.Factory
    public SupportSQLiteOpenHelper create(SupportSQLiteOpenHelper.Configuration configuration) {
        SupportSQLiteOpenHelper create$lambda$0;
        create$lambda$0 = WorkDatabase.Companion.create$lambda$0((Context) this.f395b, configuration);
        return create$lambda$0;
    }

    @Override // com.google.gson.internal.m
    public Object d() {
        int i = this.f394a;
        Object obj = this.f395b;
        switch (i) {
            case 17:
                Constructor constructor = (Constructor) obj;
                try {
                    return constructor.newInstance(null);
                } catch (IllegalAccessException e10) {
                    z3 z3Var = j3.c.f6566a;
                    androidx.privacysandbox.ads.adservices.customaudience.a.m("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e10);
                    return null;
                } catch (InstantiationException e11) {
                    throw new RuntimeException("Failed to invoke constructor '" + j3.c.b(constructor) + "' with no args", e11);
                } catch (InvocationTargetException e12) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.m("Failed to invoke constructor '" + j3.c.b(constructor) + "' with no args", e12.getCause());
                    return null;
                }
            default:
                Class cls = (Class) obj;
                try {
                    return t.f3265a.a(cls);
                } catch (Exception e13) {
                    throw new RuntimeException("Unable to create instance of " + cls + ". Registering an InstanceCreator or a TypeAdapter for this type, or adding a no-args constructor may fix this problem.", e13);
                }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.activity.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        w2 h;
        String str;
        int i = this.f394a;
        int i6 = 0;
        int i10 = 2;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object obj2 = this.f395b;
        switch (i) {
            case 2:
                ListsActivity listsActivity = (ListsActivity) obj2;
                int i11 = ListsActivity.S;
                int resultCode = ((ActivityResult) obj).getResultCode();
                if (resultCode == 1) {
                    listsActivity.setResult(1);
                    listsActivity.finish();
                    break;
                } else if (resultCode == 2) {
                    listsActivity.D0();
                    break;
                }
                break;
            case 5:
                MyStatsActivity myStatsActivity = (MyStatsActivity) obj2;
                int i12 = MyStatsActivity.R;
                if (!j5.u.b(myStatsActivity)) {
                    SharedPreferences sharedPreferences = myStatsActivity.getSharedPreferences("SettingsPreferences", 0);
                    sharedPreferences.getClass();
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putBoolean("stats_enabled", false);
                    edit.apply();
                    float f = UptodownApp.I;
                    if (b4.d.p(myStatsActivity, "SendUserUsageStatsWorker")) {
                        WorkManager.Companion.getInstance(myStatsActivity).cancelAllWorkByTag("SendUserUsageStatsWorker");
                    }
                    myStatsActivity.finish();
                    break;
                } else {
                    myStatsActivity.z0();
                    s5 s5Var = (s5) myStatsActivity.P.getValue();
                    s5Var.getClass();
                    a0 viewModelScope = ViewModelKt.getViewModelScope(s5Var);
                    v7.e eVar = m0.f8288a;
                    c0.s(viewModelScope, v7.d.f10884a, null, new b6.a(s5Var, myStatsActivity, objArr == true ? 1 : 0, 16), 2);
                    SharedPreferences sharedPreferences2 = myStatsActivity.getSharedPreferences("SettingsPreferences", 0);
                    sharedPreferences2.getClass();
                    SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                    edit2.putBoolean("stats_enabled", true);
                    edit2.apply();
                    float f10 = UptodownApp.I;
                    if (!b4.d.p(myStatsActivity, "SendUserUsageStatsWorker")) {
                        WorkManager.Companion.getInstance(myStatsActivity).enqueue(new PeriodicWorkRequest.Builder((Class<? extends ListenableWorker>) SendUserUsageStatsWorker.class, 24L, TimeUnit.HOURS).addTag("SendUserUsageStatsWorker").setConstraints(new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()).build());
                        break;
                    }
                }
                break;
            case 7:
                PreregistrationActivity preregistrationActivity = (PreregistrationActivity) obj2;
                int i13 = PreregistrationActivity.T;
                if (((ActivityResult) obj).getResultCode() == 1 && u2.g(preregistrationActivity)) {
                    u2.i(preregistrationActivity, LifecycleOwnerKt.getLifecycleScope(preregistrationActivity));
                    break;
                }
                break;
            case 8:
                PublicProfileActivity publicProfileActivity = (PublicProfileActivity) obj2;
                int i14 = PublicProfileActivity.R;
                if (((ActivityResult) obj).getResultCode() == 10 && (h = u2.h(publicProfileActivity)) != null && (str = h.f11431a) != null && str.length() != 0) {
                    c0.s(LifecycleOwnerKt.getLifecycleScope(publicProfileActivity), null, null, new n((Object) publicProfileActivity, (Object) h, (t6.c) (objArr2 == true ? 1 : 0), 25), 3);
                    break;
                }
                break;
            case 10:
                RollbackActivity rollbackActivity = (RollbackActivity) obj2;
                int i15 = RollbackActivity.f3344f0;
                if (((ActivityResult) obj).getResultCode() == -1) {
                    rollbackActivity.E = new g(rollbackActivity, 20);
                    rollbackActivity.N0().f10112n.setVisibility(8);
                    rollbackActivity.N0().f10113o.setText(rollbackActivity.getString(2131952266));
                    break;
                }
                break;
            case 11:
                SearchActivity searchActivity = (SearchActivity) obj2;
                ActivityResult activityResult = (ActivityResult) obj;
                int i16 = SearchActivity.Y;
                if (activityResult.getResultCode() == -1 && activityResult.getData() != null) {
                    Intent data = activityResult.getData();
                    data.getClass();
                    ArrayList<String> stringArrayListExtra = data.getStringArrayListExtra("android.speech.extra.RESULTS");
                    ((InstantAutoCompleteTextView) searchActivity.z0().f10137b.f11756l).setText(stringArrayListExtra != null ? stringArrayListExtra.get(0) : null);
                    break;
                }
                break;
            case 12:
                UserDevicesActivity userDevicesActivity = (UserDevicesActivity) obj2;
                int i17 = UserDevicesActivity.R;
                int resultCode2 = ((ActivityResult) obj).getResultCode();
                if (resultCode2 != 3 && resultCode2 != 4) {
                    if (resultCode2 == 5) {
                        userDevicesActivity.setResult(5);
                        userDevicesActivity.finish();
                        break;
                    }
                } else {
                    tc tcVar = (tc) userDevicesActivity.P.getValue();
                    tcVar.getClass();
                    a0 viewModelScope2 = ViewModelKt.getViewModelScope(tcVar);
                    v7.e eVar2 = m0.f8288a;
                    c0.s(viewModelScope2, v7.d.f10884a, null, new sc(userDevicesActivity, tcVar, objArr3 == true ? 1 : 0, i6), 2);
                    break;
                }
                break;
            case 19:
                ConfirmationIntentWrapperActivity confirmationIntentWrapperActivity = (ConfirmationIntentWrapperActivity) obj2;
                int i18 = ConfirmationIntentWrapperActivity.f3374n;
                ConcurrentHashMap concurrentHashMap = h.f7966c;
                d0.b.x(confirmationIntentWrapperActivity.f3376b, true);
                confirmationIntentWrapperActivity.f3375a = true;
                confirmationIntentWrapperActivity.finish();
                break;
            case 20:
                TvAppDetailFragment.a((TvAppDetailFragment) obj2);
                break;
            default:
                z1 z1Var = (z1) obj2;
                if (((ActivityResult) obj).getResultCode() == 1 && z1Var.f10683m.f11227m && z1Var.getContext() != null) {
                    d2 d10 = z1Var.d();
                    Context requireContext = z1Var.requireContext();
                    requireContext.getClass();
                    d10.c(requireContext, z1Var.f10683m.f11224a);
                    Context requireContext2 = z1Var.requireContext();
                    requireContext2.getClass();
                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(z1Var);
                    lifecycleScope.getClass();
                    float f11 = UptodownApp.I;
                    b4.d.A(requireContext2);
                    b4.d.z(requireContext2);
                    v7.e eVar3 = m0.f8288a;
                    c0.s(lifecycleScope, v7.d.f10884a, null, new a6(requireContext2, (t6.c) (objArr4 == true ? 1 : 0), i10), 2);
                    break;
                }
                break;
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        RepliesActivity repliesActivity = (RepliesActivity) this.f395b;
        int i = RepliesActivity.S;
        view.getClass();
        windowInsetsCompat.getClass();
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.statusBars());
        insets.getClass();
        Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.ime());
        insets2.getClass();
        Insets insets3 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.navigationBars());
        insets3.getClass();
        ViewGroup.LayoutParams layoutParams = repliesActivity.y0().f10033w.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.topMargin = insets.top;
            repliesActivity.y0().f10033w.setLayoutParams(layoutParams2);
        }
        int max = Math.max(insets2.bottom, insets3.bottom);
        ViewGroup.LayoutParams layoutParams3 = repliesActivity.y0().f10032u.getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = layoutParams3 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams4 != null) {
            layoutParams4.bottomMargin = max;
            repliesActivity.y0().f10032u.setLayoutParams(layoutParams4);
        }
        return windowInsetsCompat;
    }

    @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
    public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        boolean lambda$createOnCommitContentListenerUsingPerformReceiveContent$0;
        lambda$createOnCommitContentListenerUsingPerformReceiveContent$0 = InputConnectionCompat.lambda$createOnCommitContentListenerUsingPerformReceiveContent$0((View) this.f395b, inputContentInfoCompat, i, bundle);
        return lambda$createOnCommitContentListenerUsingPerformReceiveContent$0;
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable.OnCornerSizeChangeListener
    public void onCornerSizeChange(float f) {
        ((MaterialButton) this.f395b).lambda$setOpticalCenterEnabled$0(f);
    }

    @Override // androidx.leanback.widget.BaseOnItemViewClickedListener
    public void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        int i = this.f394a;
        t6.c cVar = null;
        Object obj2 = this.f395b;
        switch (i) {
            case 21:
                g5.n nVar = (g5.n) obj2;
                if (!(obj instanceof x4.g)) {
                    if (!(obj instanceof c5.c)) {
                        if (obj instanceof j) {
                            Intent intent = new Intent(nVar.getContext(), (Class<?>) TvAppsListActivity.class);
                            intent.putExtra("category", (Parcelable) obj);
                            nVar.startActivity(intent);
                            break;
                        }
                    } else {
                        Intent intent2 = new Intent(nVar.getContext(), (Class<?>) TvAppsListActivity.class);
                        intent2.putExtra("category", ((c5.c) obj).f2417a);
                        nVar.startActivity(intent2);
                        break;
                    }
                } else if (viewHolder != null && nVar.getContext() != null) {
                    LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(nVar);
                    v7.e eVar = m0.f8288a;
                    c0.s(lifecycleScope, t7.n.f10348a, null, new g5.m(nVar, (x4.g) obj, viewHolder, null), 2);
                    break;
                }
                break;
            case 22:
                q qVar = (q) obj2;
                if (!(obj instanceof x4.g)) {
                    if (!(obj instanceof c5.c)) {
                        if (obj instanceof j) {
                            Intent intent3 = new Intent(qVar.getContext(), (Class<?>) TvAppsListActivity.class);
                            intent3.putExtra("category", (Parcelable) obj);
                            qVar.startActivity(intent3);
                            break;
                        }
                    } else {
                        Intent intent4 = new Intent(qVar.getContext(), (Class<?>) TvAppsListActivity.class);
                        intent4.putExtra("category", ((c5.c) obj).f2417a);
                        qVar.startActivity(intent4);
                        break;
                    }
                } else if (viewHolder != null) {
                    LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(qVar);
                    v7.e eVar2 = m0.f8288a;
                    c0.s(lifecycleScope2, t7.n.f10348a, null, new p(qVar, (x4.g) obj, viewHolder, null), 2);
                    break;
                }
                break;
            default:
                TvSearchFragment tvSearchFragment = (TvSearchFragment) obj2;
                int i6 = TvSearchFragment.f3444m;
                obj.getClass();
                c0.s(LifecycleOwnerKt.getLifecycleScope(tvSearchFragment), null, null, new f0(tvSearchFragment, (x4.g) obj, cVar, 1), 3);
                break;
        }
    }

    @Override // androidx.appcompat.widget.Toolbar.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem menuItem) {
        int i = this.f394a;
        int i6 = 0;
        Object obj = this.f395b;
        switch (i) {
            case 3:
                MyApps myApps = (MyApps) obj;
                int i10 = MyApps.f3328g0;
                menuItem.getClass();
                if (menuItem.getItemId() != 2131361894) {
                    if (menuItem.getItemId() != 2131361895) {
                        if (menuItem.getItemId() == 2131361892) {
                            if (myApps.P0().f10224o.getVisibility() != 0) {
                                myApps.P0().f10224o.setVisibility(0);
                                myApps.P0().f10224o.requestFocus();
                                myApps.showKeyboard(myApps.P0().f10224o);
                                break;
                            } else {
                                myApps.P0().f10224o.setVisibility(8);
                                myApps.P0().f10224o.clearFocus();
                                break;
                            }
                        }
                    } else {
                        boolean z9 = !menuItem.isChecked();
                        menuItem.setChecked(z9);
                        Context applicationContext = myApps.getApplicationContext();
                        applicationContext.getClass();
                        SharedPreferences sharedPreferences = applicationContext.getSharedPreferences("SettingsPreferences", 0);
                        sharedPreferences.getClass();
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        edit.putBoolean("show_system_services", z9);
                        edit.apply();
                        myApps.S0(true);
                        break;
                    }
                } else {
                    boolean isChecked = menuItem.isChecked();
                    boolean z10 = !isChecked;
                    menuItem.setChecked(z10);
                    Context applicationContext2 = myApps.getApplicationContext();
                    applicationContext2.getClass();
                    SharedPreferences sharedPreferences2 = applicationContext2.getSharedPreferences("SettingsPreferences", 0);
                    sharedPreferences2.getClass();
                    SharedPreferences.Editor edit2 = sharedPreferences2.edit();
                    edit2.putBoolean("show_system_apps", z10);
                    edit2.apply();
                    if (isChecked) {
                        Context applicationContext3 = myApps.getApplicationContext();
                        applicationContext3.getClass();
                        SharedPreferences sharedPreferences3 = applicationContext3.getSharedPreferences("SettingsPreferences", 0);
                        sharedPreferences3.getClass();
                        SharedPreferences.Editor edit3 = sharedPreferences3.edit();
                        edit3.putBoolean("show_system_services", false);
                        edit3.apply();
                        w4.C0(myApps.P0().f10225p, false);
                        Toolbar toolbar = myApps.P0().f10225p;
                        if (toolbar.getMenu() != null) {
                            Menu menu = toolbar.getMenu();
                            menu.getClass();
                            menu.findItem(2131361895).setChecked(false);
                        }
                    } else {
                        w4.C0(myApps.P0().f10225p, true);
                    }
                    myApps.S0(true);
                    break;
                }
                break;
            case 4:
                MyDownloads myDownloads = (MyDownloads) obj;
                int i11 = MyDownloads.V;
                if (menuItem.getItemId() == 2131361877) {
                    myDownloads.startActivity(new Intent(myDownloads, (Class<?>) FileExplorerActivity.class));
                }
                if (menuItem.getItemId() == 2131361892) {
                    if (myDownloads.A0().f10242o.getVisibility() != 0) {
                        myDownloads.A0().f10242o.setVisibility(0);
                        myDownloads.A0().f10242o.requestFocus();
                        myDownloads.showKeyboard(myDownloads.A0().f10242o);
                        break;
                    } else {
                        myDownloads.A0().f10242o.setVisibility(8);
                        myDownloads.A0().f10242o.clearFocus();
                        break;
                    }
                }
                break;
            default:
                NotificationsRegistryActivity notificationsRegistryActivity = (NotificationsRegistryActivity) obj;
                int i12 = NotificationsRegistryActivity.T;
                menuItem.getClass();
                if (menuItem.getItemId() == 2131361873) {
                    b6 B0 = notificationsRegistryActivity.B0();
                    B0.getClass();
                    a0 viewModelScope = ViewModelKt.getViewModelScope(B0);
                    v7.e eVar = m0.f8288a;
                    c0.s(viewModelScope, v7.d.f10884a, null, new z5(notificationsRegistryActivity, B0, null, i6), 2);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        f1 f1Var = (f1) this.f395b;
        FragmentActivity activity = f1Var.getActivity();
        activity.getClass();
        if (!((k0) activity).T()) {
            f1Var.a().f9936t.setRefreshing(false);
            return;
        }
        Context requireContext = f1Var.requireContext();
        requireContext.getClass();
        if (u2.h(requireContext) == null) {
            f1Var.a().f9936t.setRefreshing(false);
            return;
        }
        t0 b7 = f1Var.b();
        Context requireContext2 = f1Var.requireContext();
        requireContext2.getClass();
        b7.getClass();
        b7.f2109e = 0;
        b7.f = true;
        b7.a(requireContext2);
        f1Var.a().f9936t.setRefreshing(true);
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        boolean lambda$onBottomSheetStateChanged$0;
        lambda$onBottomSheetStateChanged$0 = ((BottomSheetDragHandleView) this.f395b).lambda$onBottomSheetStateChanged$0(view, commandArguments);
        return lambda$onBottomSheetStateChanged$0;
    }

    @Override // com.google.android.material.canvas.CanvasCompat.CanvasOperation
    public void run(Canvas canvas) {
        switch (this.f394a) {
            case 15:
                ((MaskableFrameLayout) this.f395b).lambda$dispatchDraw$1(canvas);
                break;
            default:
                ((NavigationView) this.f395b).lambda$dispatchDraw$0(canvas);
                break;
        }
    }
}
