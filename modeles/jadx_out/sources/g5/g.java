package g5;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.widget.SearchView;
import androidx.core.content.ContextCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelKt;
import b2.t1;
import c4.t0;
import com.inmobi.cmp.ChoiceCmp;
import com.inmobi.cmp.ChoiceCmpCallback;
import com.inmobi.cmp.model.ChoiceError;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.tv.ui.fragment.TvAppDetailFragment;
import e4.q0;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u4.f1;
import x4.d1;
import x4.k2;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements a4.i, j1.f, j1.e, j1.c, SearchView.OnQueryTextListener, t.b, w4.d, w4.h, w1.b, x1.a, j1.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5314a;

    /* renamed from: b, reason: collision with root package name */
    public Object f5315b;

    public g(Context context) {
        boolean isEmpty;
        this.f5314a = 20;
        SharedPreferences sharedPreferences = context.getSharedPreferences("com.google.android.gms.appid", 0);
        this.f5315b = sharedPreferences;
        File file = new File(ContextCompat.getNoBackupFilesDir(context), "com.google.android.gms.appid-no-backup");
        if (file.exists()) {
            return;
        }
        try {
            if (file.createNewFile()) {
                synchronized (this) {
                    isEmpty = sharedPreferences.getAll().isEmpty();
                }
                if (isEmpty) {
                    return;
                }
                Log.i("FirebaseMessaging", "App restored, clearing state");
                s();
            }
        } catch (IOException e10) {
            if (Log.isLoggable("FirebaseMessaging", 3)) {
                Log.d("FirebaseMessaging", "Error creating file in no backup dir: " + e10.getMessage());
            }
        }
    }

    public static String B(Bundle bundle, String str) {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        for (String str2 : bundle.keySet()) {
            jSONObject2.put(str2, bundle.get(str2));
        }
        jSONObject.put("name", str);
        jSONObject.put("parameters", jSONObject2);
        return jSONObject.toString();
    }

    public static h9.a k(JSONObject jSONObject) {
        p6.x xVar;
        if (jSONObject == null) {
            xVar = null;
        } else {
            try {
                String optString = jSONObject.optString("initScreenSettingsButton");
                String optString2 = jSONObject.optString("initScreenRejectButton");
                String optString3 = jSONObject.optString("privacyBody");
                String optString4 = jSONObject.optString("secondScreenPrivacyBody");
                String optString5 = jSONObject.optString("privacyHeader");
                ArrayList u7 = u(jSONObject);
                optString.getClass();
                optString2.getClass();
                optString3.getClass();
                optString5.getClass();
                optString4.getClass();
                return new h9.a(optString, optString2, optString3, optString5, optString4, u7);
            } catch (JSONException e10) {
                a.a.h("TranslationsTextResolver", "Error in parsing AdvancedUILabels", e10, 8);
                xVar = p6.x.f8463a;
            }
        }
        if (xVar == null) {
            a.a.g("TranslationsTextResolver", "AdvancedUILabels not present");
        }
        return new h9.a((String) null, (String) null, (String) null, (String) null, (List) null, 63);
    }

    public static h9.e m(JSONObject jSONObject) {
        p6.x xVar;
        if (jSONObject == null) {
            xVar = null;
        } else {
            try {
                String optString = jSONObject.optString("initScreenSettingsButton");
                optString.getClass();
                String optString2 = jSONObject.optString("action1");
                optString2.getClass();
                String optString3 = jSONObject.optString("action2");
                optString3.getClass();
                String optString4 = jSONObject.optString("privacyBody");
                optString4.getClass();
                String optString5 = jSONObject.optString("secondScreenPrivacyBody");
                optString5.getClass();
                String optString6 = jSONObject.optString("privacyHeader");
                optString6.getClass();
                return new h9.e(optString, optString2, optString3, optString4, optString5, optString6, u(jSONObject));
            } catch (JSONException e10) {
                a.a.h("TranslationsTextResolver", "Error in parsing ConsentOrPayUILabels", e10, 8);
                xVar = p6.x.f8463a;
            }
        }
        if (xVar == null) {
            a.a.g("TranslationsTextResolver", "ConsentOrPayUILabels not present");
        }
        return new h9.e((String) null, (String) null, (String) null, (String) null, (String) null, (List) null, 127);
    }

    public static h9.k n(JSONObject jSONObject) {
        p6.x xVar;
        if (jSONObject == null) {
            xVar = null;
        } else {
            try {
                String optString = jSONObject.optString("doneLabel");
                String optString2 = jSONObject.optString("searchLabel");
                String optString3 = jSONObject.optString("cancelLabel");
                String optString4 = jSONObject.optString("consentLabel");
                String optString5 = jSONObject.optString("flexPurposesLabel");
                String optString6 = jSONObject.optString("cookieAccessBodyText");
                String optString7 = jSONObject.optString("showVendorsLabel");
                String optString8 = jSONObject.optString("showIabLabel");
                String optString9 = jSONObject.optString("noneLabel");
                String optString10 = jSONObject.optString("someLabel");
                String optString11 = jSONObject.optString("allLabel");
                String optString12 = jSONObject.optString("closeLabel");
                String optString13 = jSONObject.optString("allVendorsLabel");
                ArrayList q9 = d0.b.q(jSONObject, "summaryScreenBodyRejectService");
                ArrayList q10 = d0.b.q(jSONObject, "summaryScreenBodyTextReject");
                ArrayList q11 = d0.b.q(jSONObject, "summaryScreenBodyTextRejectNew");
                optString.getClass();
                optString2.getClass();
                optString3.getClass();
                optString7.getClass();
                optString8.getClass();
                optString4.getClass();
                optString5.getClass();
                optString6.getClass();
                optString9.getClass();
                optString10.getClass();
                optString11.getClass();
                optString12.getClass();
                optString13.getClass();
                return new h9.k(optString, optString2, optString3, optString7, optString8, optString4, optString5, optString6, optString9, optString10, optString11, optString12, optString13, q9, q10, q11);
            } catch (JSONException e10) {
                a.a.h("TranslationsTextResolver", "Error in parsing MobileUiLabels", e10, 8);
                xVar = p6.x.f8463a;
            }
        }
        if (xVar == null) {
            a.a.g("TranslationsTextResolver", "MobileUiLabels not present");
        }
        return new h9.k();
    }

    public static String o(int i, int i6, byte[] bArr) {
        if (i6 < 0) {
            return null;
        }
        int x3 = x((i6 * 4) + 36, bArr) + i;
        int i10 = ((bArr[x3 + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (bArr[x3] & 255);
        byte[] bArr2 = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            bArr2[i11] = bArr[(i11 * 2) + x3 + 2];
        }
        return new String(bArr2, l7.a.f7151a);
    }

    public static h9.p p(JSONObject jSONObject) {
        p6.x xVar;
        if (jSONObject == null) {
            xVar = null;
        } else {
            try {
                String optString = jSONObject.optString("uspDnsTitle");
                optString.getClass();
                ArrayList q9 = d0.b.q(jSONObject, "uspDnsText");
                String optString2 = jSONObject.optString("uspPrivacyPolicyLinkText");
                optString2.getClass();
                String optString3 = jSONObject.optString("uspDeleteDataLinkText");
                optString3.getClass();
                String optString4 = jSONObject.optString("uspAccessDataLinkText");
                optString4.getClass();
                return new h9.p(optString, q9, optString2, optString3, optString4, 787);
            } catch (JSONException e10) {
                a.a.h("TranslationsTextResolver", "Error in parsing PremiumUiLabels", e10, 8);
                xVar = p6.x.f8463a;
            }
        }
        if (xVar == null) {
            a.a.g("TranslationsTextResolver", "PremiumUiLabels not present");
        }
        return new h9.p(null, null, null, null, null, 1023);
    }

    public static ArrayList u(JSONObject jSONObject) {
        ArrayList arrayList = new ArrayList();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("customFooterLinks");
            int length = jSONArray.length();
            int i = 0;
            while (i < length) {
                int i6 = i + 1;
                JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                jSONObject2.getClass();
                String optString = jSONObject2.optString("label");
                optString.getClass();
                String optString2 = jSONObject2.optString("link");
                optString2.getClass();
                arrayList.add(new h9.q(optString, optString2));
                i = i6;
            }
            return arrayList;
        } catch (Exception unused) {
            a.a.g("ChoiceCMP", "COP publisher link is null");
            return arrayList;
        }
    }

    public static int x(int i, byte[] bArr) {
        return (bArr[i] & 255) | ((bArr[i + 3] << 24) & ViewCompat.MEASURED_STATE_MASK) | ((bArr[i + 2] << 16) & 16711680) | ((bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK);
    }

    public void A(int i, String str) {
        String concat = "                                             ".substring(0, (int) Math.min(i * 2, 45)).concat(str);
        StringBuilder sb = (StringBuilder) this.f5315b;
        sb.append(concat);
        sb.append('\n');
    }

    public void C() {
        synchronized (((m8.g) this.f5315b)) {
        }
    }

    @Override // x1.a
    public void a(y1.o oVar) {
        this.f5315b = oVar;
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Registered Firebase Analytics event receiver for breadcrumbs", null);
        }
    }

    @Override // w4.d
    public void b(x4.g gVar) {
        u4.d dVar = (u4.d) this.f5315b;
        gVar.getClass();
        float f = UptodownApp.I;
        if (b4.d.t() && dVar.getContext() != null && (dVar.getActivity() instanceof c4.k0)) {
            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(dVar);
            v7.e eVar = o7.m0.f8288a;
            o7.c0.s(lifecycleScope, t7.n.f10348a, null, new u4.b(dVar, gVar, null, 1), 2);
        }
    }

    @Override // j1.f
    public void c(Object obj) {
        ((CountDownLatch) this.f5315b).countDown();
    }

    @Override // w4.d
    public void d(x4.g gVar, int i) {
        u4.d dVar = (u4.d) this.f5315b;
        gVar.getClass();
        float f = UptodownApp.I;
        if (b4.d.t()) {
            long j = gVar.f11158a;
            String str = gVar.F;
            Context requireContext = dVar.requireContext();
            requireContext.getClass();
            d0.b.t(j, requireContext, str);
            q0 q0Var = dVar.f10448l;
            if (q0Var != null) {
                q0Var.notifyItemChanged(i);
            }
        }
    }

    @Override // w4.h
    public void e() {
        f1 f1Var = (f1) this.f5315b;
        float f = UptodownApp.I;
        if (b4.d.t()) {
            FragmentActivity activity = f1Var.getActivity();
            activity.getClass();
            if (((c4.k0) activity).T()) {
                FragmentActivity requireActivity = f1Var.requireActivity();
                requireActivity.getClass();
                String string = f1Var.getString(2131952739);
                string.getClass();
                j5.c.e(requireActivity, string, f1Var.getString(2131952723));
            }
        }
    }

    @Override // j1.c
    public void f() {
        ((CountDownLatch) this.f5315b).countDown();
    }

    @Override // w1.b
    public void g(Bundle bundle, String str) {
        y1.o oVar = (y1.o) this.f5315b;
        if (oVar != null) {
            try {
                String str2 = "$A$:" + B(bundle, str);
                y1.q qVar = oVar.f11654a;
                qVar.f11668o.f11908a.a(new y1.p(qVar, System.currentTimeMillis() - qVar.f11662d, str2, 0));
            } catch (JSONException unused) {
                Log.w("FirebaseCrashlytics", "Unable to serialize Firebase Analytics event to breadcrumb.", null);
            }
        }
    }

    @Override // m6.a
    public Object get() {
        switch (this.f5314a) {
            case 11:
                return new b5.m((Context) ((f) this.f5315b).f5309b, new q2.e(2), new q2.e(1), 21);
            default:
                String packageName = ((Context) ((m6.a) this.f5315b).get()).getPackageName();
                if (packageName != null) {
                    return packageName;
                }
                com.google.gson.internal.a.i("Cannot return null from a non-@Nullable @Provides method");
                return null;
        }
    }

    @Override // a4.i
    public void h(Exception exc) {
        exc.getClass();
    }

    @Override // j1.e
    public void i(Exception exc) {
        ((CountDownLatch) this.f5315b).countDown();
    }

    @Override // w4.h
    public void j(long j) {
        f1 f1Var = (f1) this.f5315b;
        float f = UptodownApp.I;
        if (b4.d.t()) {
            FragmentActivity activity = f1Var.getActivity();
            activity.getClass();
            if (((c4.k0) activity).T()) {
                f1Var.a().f9931o.setVisibility(0);
                o7.c0.s(LifecycleOwnerKt.getLifecycleScope(f1Var), null, null, new c4.c(f1Var, j, null, 2), 3);
            }
        }
    }

    public Object l(String str) {
        str.getClass();
        try {
            JSONObject jSONObject = new JSONObject(str);
            ((k9.a) this.f5315b).getClass();
            return new h9.t(k9.a.a(str), p(jSONObject.optJSONObject("premiumUiLabels")), n(jSONObject.optJSONObject("mobileUiLabels")), m(jSONObject.optJSONObject("consentOrPay")), k(jSONObject.optJSONObject("advanced")));
        } catch (JSONException unused) {
            ChoiceCmpCallback callback = ChoiceCmp.INSTANCE.getCallback();
            if (callback != null) {
                callback.onCmpError(ChoiceError.INVALID_JSON_FORMAT);
            }
            return new h9.t();
        }
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextChange(String str) {
        str.getClass();
        n.d dVar = (n.d) this.f5315b;
        c.h hVar = dVar.F;
        if (hVar == null) {
            kotlin.jvm.internal.l.i("switchAdapter");
            throw null;
        }
        n.e eVar = dVar.D;
        if (eVar == null) {
            kotlin.jvm.internal.l.i("viewModel");
            throw null;
        }
        ArrayList b7 = eVar.b(str);
        boolean z9 = str.length() > 0;
        hVar.f1155a = b7;
        if (!z9) {
            hVar.a();
        }
        hVar.notifyDataSetChanged();
        return true;
    }

    @Override // androidx.appcompat.widget.SearchView.OnQueryTextListener
    public boolean onQueryTextSubmit(String str) {
        return true;
    }

    @Override // a4.i
    public void onSuccess() {
        TvAppDetailFragment tvAppDetailFragment = (TvAppDetailFragment) this.f5315b;
        o7.c0.s(LifecycleOwnerKt.getLifecycleScope(tvAppDetailFragment), null, null, new e(tvAppDetailFragment, null, 3), 3);
    }

    @Override // j1.h
    public j1.p q(Object obj) {
        g2.d dVar = (g2.d) obj;
        m8.q qVar = (m8.q) this.f5315b;
        if (dVar == null) {
            Log.w("FirebaseCrashlytics", "Received null app settings at app startup. Cannot send cached reports", null);
            return t1.x(null);
        }
        y1.l lVar = (y1.l) qVar.f7781l;
        y1.l.a(lVar);
        lVar.f11643m.o(null, lVar.f11640e.f11908a);
        lVar.f11647q.c(null);
        return t1.x(null);
    }

    public void r(byte[] bArr) {
        int x3 = (x(16, bArr) * 4) + 36;
        int x9 = x(12, bArr);
        int i = x9;
        while (true) {
            if (i >= bArr.length - 4) {
                break;
            }
            if (x(i, bArr) == 1048834) {
                x9 = i;
                break;
            }
            i += 4;
        }
        int i6 = 0;
        while (x9 < bArr.length) {
            int x10 = x(x9, bArr);
            int x11 = x(x9 + 20, bArr);
            switch (x10) {
                case 1048834:
                    int x12 = x(x9 + 28, bArr);
                    x9 += 36;
                    String o10 = o(x3, x11, bArr);
                    StringBuilder sb = new StringBuilder();
                    for (int i10 = 0; i10 < x12; i10++) {
                        int x13 = x(x9 + 4, bArr);
                        int x14 = x(x9 + 8, bArr);
                        int x15 = x(x9 + 16, bArr);
                        x9 += 20;
                        sb.append(" " + o(x3, x13, bArr) + "=\"" + (x14 != -1 ? o(x3, x14, bArr) : String.valueOf(x15)) + "\"");
                    }
                    A(i6, "<" + o10 + ((Object) sb) + ">");
                    i6++;
                    break;
                case 1048835:
                    i6--;
                    x9 += 24;
                    A(i6, "</" + o(x3, x11, bArr) + ">");
                    break;
                default:
                    return;
            }
        }
    }

    public synchronized void s() {
        ((SharedPreferences) this.f5315b).edit().clear().commit();
    }

    @Override // w4.h
    public void t(long j, String str) {
        f1 f1Var = (f1) this.f5315b;
        float f = UptodownApp.I;
        if (b4.d.t()) {
            FragmentActivity activity = f1Var.getActivity();
            activity.getClass();
            if (((c4.k0) activity).T()) {
                w2 w2Var = new w2();
                w2Var.f11431a = String.valueOf(j);
                w2Var.f11434m = str;
                Intent intent = new Intent(f1Var.requireContext(), (Class<?>) PublicListActivity.class);
                intent.putExtra("user", w2Var);
                FragmentActivity requireActivity = f1Var.requireActivity();
                requireActivity.getClass();
                f1Var.startActivity(intent, b4.d.a(requireActivity));
            }
        }
    }

    @Override // w4.h
    public void v(d1 d1Var) {
        f1 f1Var = (f1) this.f5315b;
        float f = UptodownApp.I;
        if (b4.d.t()) {
            FragmentActivity activity = f1Var.getActivity();
            activity.getClass();
            if (((c4.k0) activity).T()) {
                k2 k2Var = new k2();
                k2Var.f11258a = d1Var.A;
                k2Var.f11259b = String.valueOf(d1Var.f11101t);
                k2Var.f11260l = d1Var.f11094m;
                k2Var.f11270w = d1Var.f11100s;
                k2Var.f11263o = d1Var.f11102u;
                k2Var.v = d1Var.f11097p;
                k2Var.f11264p = d1Var.v;
                k2Var.f11261m = d1Var.f11098q;
                k2Var.f11266r = d1Var.f11099r;
                k2Var.f11269u = d1Var.C;
                k2Var.f11267s = d1Var.G;
                k2Var.f11271x = 1;
                k2Var.f11262n = d1Var.B;
                Intent intent = new Intent(f1Var.requireContext(), (Class<?>) RepliesActivity.class);
                intent.putExtra("review", k2Var);
                intent.putExtra("appId", d1Var.B);
                intent.putExtra("appName", d1Var.C);
                intent.putExtra("appIconUrl", d1Var.F);
                intent.putExtra("appUrl", d1Var.D);
                FragmentActivity requireActivity = f1Var.requireActivity();
                requireActivity.getClass();
                f1Var.startActivity(intent, b4.d.a(requireActivity));
            }
        }
    }

    @Override // w4.h
    public void w(long j) {
        f1 f1Var = (f1) this.f5315b;
        float f = UptodownApp.I;
        if (b4.d.t()) {
            FragmentActivity activity = f1Var.getActivity();
            activity.getClass();
            if (((c4.k0) activity).T()) {
                t0 b7 = f1Var.b();
                Context requireContext = f1Var.requireContext();
                requireContext.getClass();
                String valueOf = String.valueOf(j);
                b7.getClass();
                valueOf.getClass();
                o7.a0 viewModelScope = ViewModelKt.getViewModelScope(b7);
                v7.e eVar = o7.m0.f8288a;
                o7.c0.s(viewModelScope, v7.d.f10884a, null, new b6.g(b7, requireContext, valueOf, (t6.c) null, 4), 2);
            }
        }
    }

    public void y(g2.e eVar, Thread thread, Throwable th) {
        y1.l lVar = (y1.l) this.f5315b;
        synchronized (lVar) {
            String str = "Handling uncaught exception \"" + th + "\" from thread " + thread.getName();
            if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                Log.d("FirebaseCrashlytics", str, null);
            }
            t1.H();
            try {
                y1.z.a(lVar.f11640e.f11908a.b(new y1.j(lVar, System.currentTimeMillis(), th, thread, eVar)));
            } catch (TimeoutException unused) {
                Log.e("FirebaseCrashlytics", "Cannot send reports. Timed out while fetching settings.", null);
            } catch (Exception e10) {
                Log.e("FirebaseCrashlytics", "Error handling uncaught exception", e10);
            }
        }
    }

    @Override // w4.h
    public void z(long j, String str) {
        f1 f1Var = (f1) this.f5315b;
        float f = UptodownApp.I;
        if (b4.d.t() && (f1Var.getActivity() instanceof MainActivity)) {
            FragmentActivity activity = f1Var.getActivity();
            activity.getClass();
            ((MainActivity) activity).j0(j, str);
        }
    }

    public /* synthetic */ g(int i, boolean z9) {
        this.f5314a = i;
    }

    public /* synthetic */ g(Object obj, int i) {
        this.f5314a = i;
        this.f5315b = obj;
    }

    public g(f0.i iVar, m8.q qVar) {
        this.f5314a = 10;
        this.f5315b = qVar;
        iVar.n(new q1.c(this, 1));
    }

    public g(k9.a aVar) {
        this.f5314a = 5;
        aVar.getClass();
        this.f5315b = aVar;
    }

    public g(int i) {
        this.f5314a = i;
        switch (i) {
            case 3:
                this.f5315b = new CountDownLatch(1);
                break;
            case 9:
                this.f5315b = new StringBuilder();
                break;
            default:
                this.f5315b = new f(4);
                break;
        }
    }
}
