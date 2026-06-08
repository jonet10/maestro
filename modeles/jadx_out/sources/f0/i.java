package f0;

import a4.x;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import androidx.viewbinding.ViewBindings;
import b.n;
import c3.d1;
import c3.p0;
import c4.da;
import c4.f9;
import c4.g9;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.measurement.h1;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.k1;
import com.google.android.gms.internal.measurement.x0;
import com.uptodown.UptodownApp;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.activities.ReviewsActivity;
import com.uptodown.activities.SecurityActivity;
import com.uptodown.activities.UserDeviceDetailsActivity;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.core.activities.InstallerActivity;
import e1.b2;
import e1.i2;
import e1.m1;
import e1.t1;
import e1.u0;
import e1.u4;
import e1.w0;
import e1.z4;
import e4.c1;
import e4.e1;
import e4.i0;
import e4.n0;
import j$.util.concurrent.ConcurrentHashMap;
import j5.t;
import java.io.File;
import java.io.FileInputStream;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import l7.u;
import o7.a0;
import o7.c0;
import o7.m0;
import org.json.JSONException;
import org.json.JSONObject;
import w4.m;
import x4.a3;
import x4.k2;
import x4.u2;
import x4.y2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i implements e3.b, m, w4.b, z4, k4.c {

    /* renamed from: l, reason: collision with root package name */
    public static i f4809l;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f4810a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f4811b;

    public i(Context context) {
        String d10;
        this.f4810a = 0;
        b a8 = b.a(context);
        this.f4811b = a8;
        a8.b();
        String d11 = a8.d("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(d11) || (d10 = a8.d(b.f("googleSignInOptions", d11))) == null) {
            return;
        }
        try {
            GoogleSignInOptions.c(d10);
        } catch (JSONException unused) {
        }
    }

    public static i f(Object obj) {
        if (obj != null) {
            return new i(obj, 24);
        }
        com.google.gson.internal.a.i("instance cannot be null");
        return null;
    }

    public static synchronized i o(Context context) {
        i s6;
        synchronized (i.class) {
            s6 = s(context.getApplicationContext());
        }
        return s6;
    }

    public static synchronized i s(Context context) {
        synchronized (i.class) {
            i iVar = f4809l;
            if (iVar != null) {
                return iVar;
            }
            i iVar2 = new i(context);
            f4809l = iVar2;
            return iVar2;
        }
    }

    public void A(i2 i2Var, e1.h hVar) {
        ((EnumMap) this.f4811b).put((EnumMap) i2Var, (i2) hVar);
    }

    @Override // e1.z4
    public void a(String str, String str2, Bundle bundle) {
        boolean isEmpty = TextUtils.isEmpty(str);
        u4 u4Var = (u4) this.f4811b;
        if (!isEmpty) {
            u4Var.b().p(new b2(this, str, str2, bundle));
            return;
        }
        t1 t1Var = u4Var.f4316u;
        if (t1Var != null) {
            w0 w0Var = t1Var.f4264o;
            t1.m(w0Var);
            w0Var.f4339o.c(str2, "AppId not known when logging event");
        }
    }

    @Override // w4.b
    public void b(int i) {
        e1 e1Var;
        e1 e1Var2;
        e1 e1Var3;
        int i6 = this.f4810a;
        int i10 = 2;
        t6.c cVar = null;
        int i11 = 1;
        Object obj = this.f4811b;
        switch (i6) {
            case 11:
                PublicListActivity publicListActivity = (PublicListActivity) obj;
                float f = UptodownApp.I;
                if (b4.d.t() && (e1Var = publicListActivity.f3336c0) != null && !e1Var.f4519a.isEmpty()) {
                    e1 e1Var4 = publicListActivity.f3336c0;
                    e1Var4.getClass();
                    Object obj2 = e1Var4.f4519a.get(i);
                    obj2.getClass();
                    a3 a3Var = (a3) obj2;
                    publicListActivity.j0(a3Var.f11046a, a3Var.i);
                    break;
                }
                break;
            case 12:
                RecommendedActivity recommendedActivity = (RecommendedActivity) obj;
                float f10 = UptodownApp.I;
                if (b4.d.t() && (e1Var2 = recommendedActivity.f3340c0) != null && !e1Var2.f4519a.isEmpty()) {
                    e1 e1Var5 = recommendedActivity.f3340c0;
                    e1Var5.getClass();
                    Object obj3 = e1Var5.f4519a.get(i);
                    obj3.getClass();
                    a3 a3Var2 = (a3) obj3;
                    recommendedActivity.j0(a3Var2.f11046a, a3Var2.i);
                    break;
                }
                break;
            case 13:
            case 15:
            default:
                WishlistActivity wishlistActivity = (WishlistActivity) obj;
                float f11 = UptodownApp.I;
                if (b4.d.t() && (e1Var3 = wishlistActivity.f3369c0) != null && !e1Var3.f4519a.isEmpty()) {
                    e1 e1Var6 = wishlistActivity.f3369c0;
                    e1Var6.getClass();
                    Object obj4 = e1Var6.f4519a.get(i);
                    obj4.getClass();
                    a3 a3Var3 = (a3) obj4;
                    wishlistActivity.j0(a3Var3.f11046a, a3Var3.i);
                    break;
                }
                break;
            case 14:
                SecurityActivity securityActivity = (SecurityActivity) obj;
                float f12 = UptodownApp.I;
                if (b4.d.t()) {
                    int i12 = SecurityActivity.f3349g0;
                    n0 n0Var = securityActivity.f3351c0;
                    n0Var.getClass();
                    if (n0Var.a().get(i) instanceof x4.e) {
                        n0 n0Var2 = securityActivity.f3351c0;
                        n0Var2.getClass();
                        Object obj5 = n0Var2.a().get(i);
                        obj5.getClass();
                        x4.e eVar = (x4.e) obj5;
                        if (!securityActivity.isFinishing()) {
                            int i13 = 0;
                            View inflate = securityActivity.getLayoutInflater().inflate(2131558522, (ViewGroup) null, false);
                            int i14 = 2131362373;
                            ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362373);
                            if (imageView != null) {
                                i14 = 2131363185;
                                if (((RelativeLayout) ViewBindings.findChildViewById(inflate, 2131363185)) != null) {
                                    i14 = 2131363637;
                                    TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363637);
                                    if (textView != null) {
                                        i14 = 2131364120;
                                        TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364120);
                                        if (textView2 != null) {
                                            i14 = 2131364255;
                                            TextView textView3 = (TextView) ViewBindings.findChildViewById(inflate, 2131364255);
                                            if (textView3 != null) {
                                                i14 = 2131364487;
                                                TextView textView4 = (TextView) ViewBindings.findChildViewById(inflate, 2131364487);
                                                if (textView4 != null) {
                                                    i14 = 2131364584;
                                                    TextView textView5 = (TextView) ViewBindings.findChildViewById(inflate, 2131364584);
                                                    if (textView5 != null) {
                                                        i14 = 2131364634;
                                                        if (ViewBindings.findChildViewById(inflate, 2131364634) != null) {
                                                            securityActivity.F = new AlertDialog.Builder(securityActivity).setView((RelativeLayout) inflate).create();
                                                            textView.setTypeface(f4.c.f4882w);
                                                            textView.setText(eVar.f11122b);
                                                            ConcurrentHashMap concurrentHashMap = t.f6708a;
                                                            imageView.setImageDrawable(t.b(securityActivity, eVar.f11123l));
                                                            if (eVar.f11123l == null || eVar.f11132u == null || eVar.F <= 0) {
                                                                textView2.setVisibility(8);
                                                                textView5.setVisibility(8);
                                                                textView3.setVisibility(8);
                                                            } else {
                                                                textView2.setTypeface(f4.c.f4883x);
                                                                textView2.setOnClickListener(new da(securityActivity, eVar, i13));
                                                                textView5.setTypeface(f4.c.f4883x);
                                                                textView5.setOnClickListener(new da(securityActivity, eVar, i11));
                                                                textView3.setTypeface(f4.c.f4883x);
                                                                textView3.setOnClickListener(new da(securityActivity, eVar, i10));
                                                            }
                                                            if (u.m0(securityActivity.getPackageName(), eVar.f11123l, true)) {
                                                                textView4.setVisibility(8);
                                                            } else {
                                                                textView4.setTypeface(f4.c.f4883x);
                                                                textView4.setOnClickListener(new da(eVar, securityActivity));
                                                            }
                                                            if (!securityActivity.isFinishing()) {
                                                                AlertDialog alertDialog = securityActivity.F;
                                                                alertDialog.getClass();
                                                                Window window = alertDialog.getWindow();
                                                                if (window != null) {
                                                                    x.y(window, 0);
                                                                }
                                                                AlertDialog alertDialog2 = securityActivity.F;
                                                                alertDialog2.getClass();
                                                                alertDialog2.show();
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i14)));
                            break;
                        }
                    }
                }
                break;
            case 16:
                UserDeviceDetailsActivity userDeviceDetailsActivity = (UserDeviceDetailsActivity) obj;
                c1 c1Var = userDeviceDetailsActivity.Q;
                if (c1Var != null) {
                    Object obj6 = c1Var.f4503a.get(i);
                    obj6.getClass();
                    y2 y2Var = (y2) obj6;
                    if (y2Var.f11476e != 1) {
                        String string = userDeviceDetailsActivity.getString(2131952264);
                        string.getClass();
                        userDeviceDetailsActivity.A(string);
                        break;
                    } else {
                        String str = y2Var.f11473b;
                        if (str != null && str.length() != 0) {
                            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(userDeviceDetailsActivity);
                            v7.e eVar2 = m0.f8288a;
                            c0.s(lifecycleScope, v7.d.f10884a, null, new b6.g(userDeviceDetailsActivity, y2Var, cVar, 13), 2);
                            break;
                        } else {
                            String string2 = userDeviceDetailsActivity.getString(2131952264);
                            string2.getClass();
                            userDeviceDetailsActivity.A(string2);
                            break;
                        }
                    }
                }
                break;
        }
    }

    @Override // k4.c
    public void c(File file, ArrayList arrayList) {
        ((InstallerActivity) this.f4811b).K(file, arrayList);
    }

    @Override // w4.m
    public void d(int i) {
        ReviewsActivity reviewsActivity = (ReviewsActivity) this.f4811b;
        float f = UptodownApp.I;
        if (b4.d.t() && reviewsActivity.T()) {
            if (u2.h(reviewsActivity) == null) {
                String string = reviewsActivity.getString(2131952181);
                string.getClass();
                String string2 = reviewsActivity.getString(2131952180);
                string2.getClass();
                b2.t1.v(reviewsActivity, string, string2);
                return;
            }
            i0 i0Var = reviewsActivity.Q;
            t6.c cVar = null;
            k2 k2Var = i0Var != null ? (k2) i0Var.f4560a.get(i) : null;
            if (k2Var != null) {
                g9 A0 = reviewsActivity.A0();
                int i6 = k2Var.f11271x;
                String valueOf = String.valueOf(k2Var.f11259b);
                A0.getClass();
                if (i6 == 1) {
                    a0 viewModelScope = ViewModelKt.getViewModelScope(A0);
                    v7.e eVar = m0.f8288a;
                    c0.s(viewModelScope, v7.d.f10884a, null, new f9(reviewsActivity, valueOf, A0, cVar, 1), 2);
                } else {
                    a0 viewModelScope2 = ViewModelKt.getViewModelScope(A0);
                    v7.e eVar2 = m0.f8288a;
                    c0.s(viewModelScope2, v7.d.f10884a, null, new f9(reviewsActivity, valueOf, A0, cVar, 0), 2);
                }
            }
        }
    }

    @Override // k4.c
    public void e(int i) {
        InstallerActivity installerActivity = (InstallerActivity) this.f4811b;
        installerActivity.runOnUiThread(new androidx.core.content.res.a(installerActivity, i, 2));
    }

    @Override // w4.m
    public void g(int i) {
        ArrayList arrayList;
        ReviewsActivity reviewsActivity = (ReviewsActivity) this.f4811b;
        float f = UptodownApp.I;
        if (b4.d.t() && reviewsActivity.T()) {
            i0 i0Var = reviewsActivity.Q;
            t6.c cVar = null;
            k2 k2Var = (i0Var == null || (arrayList = i0Var.f4560a) == null) ? null : (k2) arrayList.get(i);
            if (k2Var != null) {
                c0.s(LifecycleOwnerKt.getLifecycleScope(reviewsActivity), null, null, new n(reviewsActivity, k2Var, cVar, 27), 3);
            }
        }
    }

    @Override // m6.a
    public Object get() {
        int i = this.f4810a;
        Object obj = this.f4811b;
        switch (i) {
            case 3:
                n1.f fVar = (n1.f) ((i) obj).f4811b;
                fVar.getClass();
                p0 p0Var = p0.f1300a;
                return p0.a(fVar);
            case 4:
                return new c3.w0((d1) ((e3.c) obj).get());
            default:
                return obj;
        }
    }

    @Override // k4.c
    public void i(File file) {
        long j;
        InstallerActivity installerActivity = (InstallerActivity) this.f4811b;
        if (file != null) {
            installerActivity.S = file.getAbsolutePath();
            PackageManager packageManager = installerActivity.getPackageManager();
            packageManager.getClass();
            String str = installerActivity.S;
            str.getClass();
            PackageInfo d10 = n4.i.d(packageManager, str, 128);
            Drawable drawable = null;
            if ((d10 != null ? d10.applicationInfo : null) != null) {
                if (!installerActivity.f3399f0) {
                    ImageView imageView = installerActivity.O;
                    if (imageView != null) {
                        String absolutePath = file.getAbsolutePath();
                        absolutePath.getClass();
                        PackageManager packageManager2 = installerActivity.getPackageManager();
                        packageManager2.getClass();
                        PackageInfo d11 = n4.i.d(packageManager2, absolutePath, 128);
                        if ((d11 != null ? d11.applicationInfo : null) != null) {
                            ApplicationInfo applicationInfo = d11.applicationInfo;
                            applicationInfo.getClass();
                            applicationInfo.sourceDir = absolutePath;
                            ApplicationInfo applicationInfo2 = d11.applicationInfo;
                            applicationInfo2.getClass();
                            applicationInfo2.publicSourceDir = absolutePath;
                            ApplicationInfo applicationInfo3 = d11.applicationInfo;
                            applicationInfo3.getClass();
                            drawable = applicationInfo3.loadIcon(installerActivity.getPackageManager());
                        }
                        imageView.setImageDrawable(drawable);
                    }
                    installerActivity.f3399f0 = true;
                }
                LinearLayout linearLayout = installerActivity.F;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                ApplicationInfo applicationInfo4 = d10.applicationInfo;
                applicationInfo4.getClass();
                String str2 = installerActivity.S;
                str2.getClass();
                applicationInfo4.sourceDir = str2;
                applicationInfo4.publicSourceDir = str2;
                String obj = packageManager.getApplicationLabel(applicationInfo4).toString();
                long d12 = n4.d.d(d10);
                String str3 = installerActivity.S;
                str3.getClass();
                try {
                    j = new File(str3).length();
                } catch (Exception unused) {
                    j = -1;
                }
                f4.a aVar = f4.a.f4869a;
                String str4 = d10.packageName;
                str4.getClass();
                aVar.d(d12, j, str4, obj);
                if (installerActivity.f3398e0) {
                    return;
                }
                TextView textView = installerActivity.E;
                if (textView != null) {
                    textView.setText(obj);
                }
                TextView textView2 = installerActivity.E;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                TextView textView3 = installerActivity.G;
                if (textView3 != null) {
                    textView3.setText(file.getName());
                }
                TextView textView4 = installerActivity.G;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
                TextView textView5 = installerActivity.H;
                if (textView5 != null) {
                    textView5.setText(i5.G(j));
                }
                TextView textView6 = installerActivity.H;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
                TextView textView7 = installerActivity.I;
                if (textView7 != null) {
                    textView7.setText(d10.versionName);
                }
                TextView textView8 = installerActivity.I;
                if (textView8 != null) {
                    textView8.setVisibility(0);
                }
            }
        }
    }

    @Override // k4.c
    public void j(File file) {
        InstallerActivity installerActivity = (InstallerActivity) this.f4811b;
        if (installerActivity.R == null) {
            installerActivity.R = new ArrayList();
        }
        ArrayList arrayList = installerActivity.R;
        arrayList.getClass();
        arrayList.add(file);
    }

    public g2.d k(JSONObject jSONObject) {
        e1.c0 c0Var;
        int i = jSONObject.getInt("settings_version");
        if (i != 3) {
            Log.e("FirebaseCrashlytics", "Could not determine SettingsJsonTransform for settings version " + i + ". Using default settings values.", null);
            c0Var = new e1.c0(7);
        } else {
            c0Var = new e1.c0(8);
        }
        q1.a aVar = (q1.a) this.f4811b;
        switch (c0Var.f3842a) {
            case 7:
                return e1.c0.j(aVar);
            default:
                jSONObject.optInt("settings_version", 0);
                int optInt = jSONObject.optInt("cache_duration", 3600);
                double optDouble = jSONObject.optDouble("on_demand_upload_rate_per_minute", 10.0d);
                double optDouble2 = jSONObject.optDouble("on_demand_backoff_base", 1.2d);
                int optInt2 = jSONObject.optInt("on_demand_backoff_step_duration_seconds", 60);
                g2.c cVar = jSONObject.has("session") ? new g2.c(jSONObject.getJSONObject("session").optInt("max_custom_exception_events", 8)) : new g2.c(new JSONObject().optInt("max_custom_exception_events", 8));
                JSONObject jSONObject2 = jSONObject.getJSONObject("features");
                return new g2.d(jSONObject.has("expires_at") ? jSONObject.optLong("expires_at") : System.currentTimeMillis() + (optInt * 1000), cVar, new g2.b(jSONObject2.optBoolean("collect_reports", true), jSONObject2.optBoolean("collect_anrs", false), jSONObject2.optBoolean("collect_build_ids", false)), optDouble, optDouble2, optInt2);
        }
    }

    @Override // k4.c
    public void l() {
        InstallerActivity installerActivity = (InstallerActivity) this.f4811b;
        installerActivity.getWindow().clearFlags(128);
        TextView textView = installerActivity.L;
        if (textView != null) {
            textView.setText(2131952002);
        }
    }

    public JSONObject m() {
        FileInputStream fileInputStream;
        JSONObject jSONObject;
        FileInputStream fileInputStream2 = null;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Checking for cached settings...", null);
        }
        try {
            File file = (File) this.f4811b;
            if (file.exists()) {
                fileInputStream = new FileInputStream(file);
                try {
                    try {
                        jSONObject = new JSONObject(y1.g.i(fileInputStream));
                        fileInputStream2 = fileInputStream;
                    } catch (Exception e10) {
                        e = e10;
                        Log.e("FirebaseCrashlytics", "Failed to fetch cached settings", e);
                        y1.g.b(fileInputStream, "Error while closing settings cache file.");
                        return null;
                    }
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    y1.g.b(fileInputStream2, "Error while closing settings cache file.");
                    throw th;
                }
            } else {
                if (Log.isLoggable("FirebaseCrashlytics", 2)) {
                    Log.v("FirebaseCrashlytics", "Settings file does not exist.", null);
                }
                jSONObject = null;
            }
            y1.g.b(fileInputStream2, "Error while closing settings cache file.");
            return jSONObject;
        } catch (Exception e11) {
            e = e11;
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
            y1.g.b(fileInputStream2, "Error while closing settings cache file.");
            throw th;
        }
    }

    public void n(q1.c cVar) {
        k1 k1Var = (k1) this.f4811b;
        ArrayList arrayList = k1Var.f2681c;
        synchronized (arrayList) {
            for (int i = 0; i < arrayList.size(); i++) {
                try {
                    if (cVar.equals(((Pair) arrayList.get(i)).first)) {
                        Log.w("FA", "OnEventListener already registered.");
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            h1 h1Var = new h1(cVar);
            arrayList.add(new Pair(cVar, h1Var));
            if (k1Var.f != null) {
                try {
                    k1Var.f.registerOnMeasurementEventListener(h1Var);
                    return;
                } catch (BadParcelableException | NetworkOnMainThreadException | RemoteException | IllegalArgumentException | IllegalStateException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w("FA", "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            k1Var.a(new x0(k1Var, h1Var, 5));
        }
    }

    @Override // w4.m
    public void p(int i) {
        ArrayList arrayList;
        ReviewsActivity reviewsActivity = (ReviewsActivity) this.f4811b;
        float f = UptodownApp.I;
        if (b4.d.t() && reviewsActivity.T()) {
            if (u2.h(reviewsActivity) == null) {
                String string = reviewsActivity.getString(2131952183);
                string.getClass();
                String string2 = reviewsActivity.getString(2131952182);
                string2.getClass();
                b2.t1.v(reviewsActivity, string, string2);
                return;
            }
            i0 i0Var = reviewsActivity.Q;
            t6.c cVar = null;
            k2 k2Var = (i0Var == null || (arrayList = i0Var.f4560a) == null) ? null : (k2) arrayList.get(i);
            if (!b4.d.t() || k2Var == null) {
                return;
            }
            if (t.f6709b.contains(Long.valueOf(k2Var.f11258a))) {
                return;
            }
            g9 A0 = reviewsActivity.A0();
            A0.getClass();
            a0 viewModelScope = ViewModelKt.getViewModelScope(A0);
            v7.e eVar = m0.f8288a;
            c0.s(viewModelScope, v7.d.f10884a, null, new b6.g(k2Var, reviewsActivity, A0, cVar, 10), 2);
        }
    }

    @Override // w4.m
    public void q(int i) {
        ArrayList arrayList;
        ReviewsActivity reviewsActivity = (ReviewsActivity) this.f4811b;
        float f = UptodownApp.I;
        if (b4.d.t() && reviewsActivity.T()) {
            i0 i0Var = reviewsActivity.Q;
            k2 k2Var = (i0Var == null || (arrayList = i0Var.f4560a) == null) ? null : (k2) arrayList.get(i);
            Intent intent = new Intent(reviewsActivity, (Class<?>) RepliesActivity.class);
            intent.putExtra("review", k2Var);
            x4.g gVar = (x4.g) reviewsActivity.A0().i.getValue();
            intent.putExtra("appId", gVar != null ? gVar.f11158a : 0L);
            x4.g gVar2 = (x4.g) reviewsActivity.A0().i.getValue();
            intent.putExtra("appIconUrl", gVar2 != null ? gVar2.f11187u : null);
            x4.g gVar3 = (x4.g) reviewsActivity.A0().i.getValue();
            String str = gVar3 != null ? gVar3.f11159b : null;
            if (str != null && str.length() != 0) {
                Object value = reviewsActivity.A0().i.getValue();
                value.getClass();
                intent.putExtra("appName", ((x4.g) value).f11159b);
            }
            reviewsActivity.startActivity(intent, b4.d.a(reviewsActivity));
        }
    }

    public synchronized void r() {
        b bVar = (b) this.f4811b;
        ReentrantLock reentrantLock = bVar.f4799a;
        reentrantLock.lock();
        try {
            bVar.f4800b.edit().clear().apply();
        } finally {
            reentrantLock.unlock();
        }
    }

    @Override // k4.c
    public void t() {
        f4.a.f4869a.a();
        InstallerActivity installerActivity = (InstallerActivity) this.f4811b;
        installerActivity.getWindow().clearFlags(128);
        TextView textView = installerActivity.f3404z;
        if (textView != null) {
            textView.setText(installerActivity.getString(2131951876, installerActivity.getString(2131951718)));
        }
        TextView textView2 = installerActivity.f3404z;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        TextView textView3 = installerActivity.N;
        if (textView3 != null) {
            textView3.setOnClickListener(new g4.a0(installerActivity, 8));
        }
    }

    public String toString() {
        switch (this.f4810a) {
            case 20:
                StringBuilder sb = new StringBuilder("1");
                for (i2 i2Var : i2.values()) {
                    e1.h hVar = (e1.h) ((EnumMap) this.f4811b).get(i2Var);
                    if (hVar == null) {
                        hVar = e1.h.UNSET;
                    }
                    sb.append(hVar.f4013a);
                }
                return sb.toString();
            default:
                return super.toString();
        }
    }

    @Override // w4.m
    public void u() {
        float f = UptodownApp.I;
        if (b4.d.t()) {
            ((ReviewsActivity) this.f4811b).w0();
        }
    }

    @Override // k4.c
    public void v() {
        InstallerActivity installerActivity = (InstallerActivity) this.f4811b;
        installerActivity.runOnUiThread(new androidx.core.content.res.a(installerActivity, 0, 2));
    }

    @Override // k4.c
    public void w() {
        TextView textView = ((InstallerActivity) this.f4811b).L;
        if (textView != null) {
            textView.setText(2131952008);
        }
    }

    public void x(int i, String str, List list, boolean z9, boolean z10) {
        u0 u0Var;
        m1 m1Var = (m1) this.f4811b;
        int i6 = i - 1;
        if (i6 == 0) {
            w0 w0Var = m1Var.f3875a.f4264o;
            t1.m(w0Var);
            u0Var = w0Var.v;
        } else if (i6 != 1) {
            if (i6 == 3) {
                w0 w0Var2 = m1Var.f3875a.f4264o;
                t1.m(w0Var2);
                u0Var = w0Var2.f4346w;
            } else if (i6 != 4) {
                w0 w0Var3 = m1Var.f3875a.f4264o;
                t1.m(w0Var3);
                u0Var = w0Var3.f4345u;
            } else if (z9) {
                w0 w0Var4 = m1Var.f3875a.f4264o;
                t1.m(w0Var4);
                u0Var = w0Var4.f4343s;
            } else if (z10) {
                w0 w0Var5 = m1Var.f3875a.f4264o;
                t1.m(w0Var5);
                u0Var = w0Var5.f4342r;
            } else {
                w0 w0Var6 = m1Var.f3875a.f4264o;
                t1.m(w0Var6);
                u0Var = w0Var6.f4344t;
            }
        } else if (z9) {
            w0 w0Var7 = m1Var.f3875a.f4264o;
            t1.m(w0Var7);
            u0Var = w0Var7.f4340p;
        } else if (z10) {
            w0 w0Var8 = m1Var.f3875a.f4264o;
            t1.m(w0Var8);
            u0Var = w0Var8.f4339o;
        } else {
            w0 w0Var9 = m1Var.f3875a.f4264o;
            t1.m(w0Var9);
            u0Var = w0Var9.f4341q;
        }
        int size = list.size();
        if (size == 1) {
            u0Var.c(list.get(0), str);
            return;
        }
        if (size == 2) {
            u0Var.d(list.get(0), str, list.get(1));
        } else if (size != 3) {
            u0Var.b(str);
        } else {
            u0Var.e(str, list.get(0), list.get(1), list.get(2));
        }
    }

    public void y(i2 i2Var, int i) {
        e1.h hVar;
        if (i != -30) {
            if (i != -20) {
                if (i == -10) {
                    hVar = e1.h.MANIFEST;
                } else if (i != 0) {
                    hVar = i != 30 ? e1.h.UNSET : e1.h.INITIALIZATION;
                }
            }
            hVar = e1.h.API;
        } else {
            hVar = e1.h.TCF;
        }
        ((EnumMap) this.f4811b).put((EnumMap) i2Var, (i2) hVar);
    }

    @Override // k4.c
    public void z() {
        f4.a.f4869a.a();
        InstallerActivity installerActivity = (InstallerActivity) this.f4811b;
        installerActivity.getWindow().clearFlags(128);
        TextView textView = installerActivity.f3404z;
        if (textView != null) {
            textView.setText(installerActivity.getString(2131952274, installerActivity.getString(2131951718)));
        }
        installerActivity.j();
    }

    public /* synthetic */ i(Object obj, int i) {
        this.f4810a = i;
        this.f4811b = obj;
    }

    public i(EnumMap enumMap) {
        this.f4810a = 20;
        EnumMap enumMap2 = new EnumMap(i2.class);
        this.f4811b = enumMap2;
        enumMap2.putAll(enumMap);
    }

    public i(int i) {
        this.f4810a = i;
        switch (i) {
            case 20:
                this.f4811b = new EnumMap(i2.class);
                break;
            default:
                this.f4811b = new HashMap(3);
                break;
        }
    }

    public i(e2.d dVar) {
        this.f4810a = 25;
        this.f4811b = new File((File) dVar.f4468m, "com.crashlytics.settings.json");
    }

    public i(android.support.v4.media.session.f fVar) {
        this.f4810a = 2;
        this.f4811b = new WeakReference(fVar);
    }

    private final void h(View view, int i) {
    }
}
