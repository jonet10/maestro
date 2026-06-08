package a3;

import a4.d0;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Trace;
import androidx.collection.ArrayMap;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.widget.Action;
import androidx.leanback.widget.OnActionClickedListener;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.privacysandbox.ads.adservices.java.internal.CoroutineAdapterKt;
import androidx.work.WorkerKt;
import c4.ya;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MoreInfo;
import com.uptodown.tv.ui.activity.TvOldVersionsActivity;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import j1.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import o7.c0;
import o7.f0;
import o7.m0;
import p6.x;
import y.f;
import y.g;
import y.h;
import y2.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class e implements s1.d, CallbackToFutureAdapter.Resolver, OnActionClickedListener, s2.a, z.b, f, j1.d, j1.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f64a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f65b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f66l;

    public /* synthetic */ e(j jVar, String str) {
        this.f64a = 10;
        this.f66l = jVar;
        this.f65b = str;
    }

    @Override // y.f
    public Object apply(Object obj) {
        h hVar = (h) this.f65b;
        r.j jVar = (r.j) this.f66l;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        y.a aVar = hVar.f11590m;
        ArrayList e10 = hVar.e(sQLiteDatabase, jVar, aVar.f11575b);
        for (o.d dVar : o.d.values()) {
            if (dVar != jVar.f8833c) {
                int size = aVar.f11575b - e10.size();
                if (size <= 0) {
                    break;
                }
                e10.addAll(hVar.e(sQLiteDatabase, jVar.a(dVar), size));
            }
        }
        HashMap hashMap = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < e10.size(); i++) {
            sb.append(((y.b) e10.get(i)).f11579a);
            if (i < e10.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        Cursor query = sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null);
        while (query.moveToNext()) {
            try {
                long j = query.getLong(0);
                Set set = (Set) hashMap.get(Long.valueOf(j));
                if (set == null) {
                    set = new HashSet();
                    hashMap.put(Long.valueOf(j), set);
                }
                set.add(new g(query.getString(1), query.getString(2)));
            } catch (Throwable th) {
                query.close();
                throw th;
            }
        }
        query.close();
        ListIterator listIterator = e10.listIterator();
        while (listIterator.hasNext()) {
            y.b bVar = (y.b) listIterator.next();
            long j6 = bVar.f11579a;
            if (hashMap.containsKey(Long.valueOf(j6))) {
                r.h c9 = bVar.f11581c.c();
                for (g gVar : (Set) hashMap.get(Long.valueOf(j6))) {
                    c9.a(gVar.f11584a, gVar.f11585b);
                }
                listIterator.set(new y.b(j6, bVar.f11580b, c9.b()));
            }
        }
        return e10;
    }

    @Override // androidx.concurrent.futures.CallbackToFutureAdapter.Resolver
    public Object attachCompleter(CallbackToFutureAdapter.Completer completer) {
        Object asListenableFuture$lambda$0;
        x future$lambda$2;
        switch (this.f64a) {
            case 1:
                asListenableFuture$lambda$0 = CoroutineAdapterKt.asListenableFuture$lambda$0((f0) this.f65b, this.f66l, completer);
                return asListenableFuture$lambda$0;
            default:
                future$lambda$2 = WorkerKt.future$lambda$2((Executor) this.f65b, (d7.a) this.f66l, completer);
                return future$lambda$2;
        }
    }

    @Override // s2.a
    public void b(s2.b bVar) {
        s2.a aVar = (s2.a) this.f65b;
        s2.a aVar2 = (s2.a) this.f66l;
        aVar.b(bVar);
        aVar2.b(bVar);
    }

    @Override // s1.d
    public Object c(d0 d0Var) {
        String valueOf;
        switch (this.f64a) {
            case 0:
                String str = (String) this.f65b;
                com.google.gson.internal.a aVar = (com.google.gson.internal.a) this.f66l;
                Context context = (Context) d0Var.a(Context.class);
                switch (aVar.f3128a) {
                    case 20:
                        ApplicationInfo applicationInfo = context.getApplicationInfo();
                        if (applicationInfo != null) {
                            valueOf = String.valueOf(applicationInfo.targetSdkVersion);
                            break;
                        }
                        valueOf = "";
                        break;
                    case 21:
                        valueOf = FirebaseCommonRegistrar.a(context);
                        break;
                    case 22:
                        if (!context.getPackageManager().hasSystemFeature("android.hardware.type.television")) {
                            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.watch")) {
                                if (!context.getPackageManager().hasSystemFeature("android.hardware.type.automotive")) {
                                    if (Build.VERSION.SDK_INT >= 26 && context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                                        valueOf = "embedded";
                                        break;
                                    }
                                    valueOf = "";
                                    break;
                                } else {
                                    valueOf = "auto";
                                    break;
                                }
                            } else {
                                valueOf = "watch";
                                break;
                            }
                        } else {
                            valueOf = "tv";
                            break;
                        }
                    default:
                        String installerPackageName = context.getPackageManager().getInstallerPackageName(context.getPackageName());
                        if (installerPackageName != null) {
                            valueOf = FirebaseCommonRegistrar.b(installerPackageName);
                            break;
                        }
                        valueOf = "";
                        break;
                }
                return new a(str, valueOf);
            default:
                String str2 = (String) this.f65b;
                s1.a aVar2 = (s1.a) this.f66l;
                try {
                    Trace.beginSection(str2);
                    return aVar2.f.c(d0Var);
                } finally {
                    Trace.endSection();
                }
        }
    }

    @Override // z.b
    public Object execute() {
        switch (this.f64a) {
            case 6:
                x.g gVar = (x.g) this.f65b;
                Iterable iterable = (Iterable) this.f66l;
                h hVar = (h) gVar.f11030c;
                hVar.getClass();
                if (iterable.iterator().hasNext()) {
                    hVar.b().compileStatement("DELETE FROM events WHERE _id in ".concat(h.i(iterable))).execute();
                    break;
                }
                break;
            default:
                x.g gVar2 = (x.g) this.f65b;
                for (Map.Entry entry : ((HashMap) this.f66l).entrySet()) {
                    ((h) gVar2.i).f(((Integer) entry.getValue()).intValue(), u.c.INVALID_PAYLOD, (String) entry.getKey());
                }
                break;
        }
        return null;
    }

    @Override // j1.a
    public Object g(p pVar) {
        j jVar = (j) this.f66l;
        String str = (String) this.f65b;
        synchronized (jVar) {
            ((ArrayMap) jVar.f11739b).remove(str);
        }
        return pVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.leanback.widget.OnActionClickedListener
    public void onActionClicked(Action action) {
        TvAppDetailFragment tvAppDetailFragment = (TvAppDetailFragment) this.f65b;
        FragmentActivity fragmentActivity = (FragmentActivity) this.f66l;
        action.getClass();
        if (action.getId() == 1) {
            int i = tvAppDetailFragment.f3415l;
            if (i != 0) {
                if (i == 1) {
                    tvAppDetailFragment.h();
                    return;
                }
                if (i == 2) {
                    tvAppDetailFragment.h();
                    return;
                }
                if (i == 3) {
                    tvAppDetailFragment.b();
                    return;
                } else if (i == 5) {
                    tvAppDetailFragment.h();
                    return;
                } else {
                    if (i != 6) {
                        return;
                    }
                    tvAppDetailFragment.h();
                    return;
                }
            }
            x4.g gVar = tvAppDetailFragment.f3413a;
            if (gVar == null || gVar.F == null || tvAppDetailFragment.getContext() == null) {
                return;
            }
            PackageManager packageManager = tvAppDetailFragment.requireContext().getPackageManager();
            x4.g gVar2 = tvAppDetailFragment.f3413a;
            gVar2.getClass();
            String str = gVar2.F;
            str.getClass();
            Intent leanbackLaunchIntentForPackage = packageManager.getLeanbackLaunchIntentForPackage(str);
            if (leanbackLaunchIntentForPackage == null) {
                PackageManager packageManager2 = tvAppDetailFragment.requireContext().getPackageManager();
                x4.g gVar3 = tvAppDetailFragment.f3413a;
                gVar3.getClass();
                String str2 = gVar3.F;
                str2.getClass();
                leanbackLaunchIntentForPackage = packageManager2.getLaunchIntentForPackage(str2);
            }
            if (leanbackLaunchIntentForPackage != null) {
                tvAppDetailFragment.startActivity(leanbackLaunchIntentForPackage);
                return;
            }
            return;
        }
        if (action.getId() == 2) {
            x4.g gVar4 = tvAppDetailFragment.f3413a;
            if (gVar4 == null || gVar4.F == null) {
                return;
            }
            Context requireContext = tvAppDetailFragment.requireContext();
            requireContext.getClass();
            x4.g gVar5 = tvAppDetailFragment.f3413a;
            gVar5.getClass();
            String str3 = gVar5.F;
            str3.getClass();
            Intent intent = new Intent("android.intent.action.DELETE", Uri.parse("package:".concat(str3)));
            intent.addFlags(268435456);
            requireContext.startActivity(intent);
            return;
        }
        if (action.getId() == 3) {
            if (tvAppDetailFragment.f3413a != null) {
                Intent intent2 = new Intent(fragmentActivity, (Class<?>) TvOldVersionsActivity.class);
                intent2.putExtra("appInfo", tvAppDetailFragment.f3413a);
                float f = UptodownApp.I;
                tvAppDetailFragment.startActivity(intent2, b4.d.a(fragmentActivity));
                return;
            }
            return;
        }
        Bundle bundle = null;
        Object[] objArr = 0;
        if (action.getId() == 4) {
            if (tvAppDetailFragment.f3413a != null) {
                LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(tvAppDetailFragment);
                v7.e eVar = m0.f8288a;
                c0.s(lifecycleScope, v7.d.f10884a, null, new ya((Object) fragmentActivity, (Object) tvAppDetailFragment, (t6.c) (objArr == true ? 1 : 0), 11), 2);
                return;
            }
            return;
        }
        if (action.getId() != 5 || tvAppDetailFragment.f3413a == null) {
            return;
        }
        Intent intent3 = new Intent(tvAppDetailFragment.getContext(), (Class<?>) MoreInfo.class);
        intent3.putExtra("appInfo", tvAppDetailFragment.f3413a);
        FragmentActivity activity = tvAppDetailFragment.getActivity();
        if (activity != null) {
            float f10 = UptodownApp.I;
            bundle = b4.d.a(activity);
        }
        tvAppDetailFragment.startActivity(intent3, bundle);
    }

    @Override // j1.d
    public void s(p pVar) {
        ((FirebaseMessagingService) this.f65b).a((Intent) this.f66l);
    }

    public /* synthetic */ e(int i, Object obj, Object obj2) {
        this.f64a = i;
        this.f65b = obj;
        this.f66l = obj2;
    }
}
