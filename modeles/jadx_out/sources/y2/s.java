package y2;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.documentfile.provider.DocumentFile;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.gms.internal.measurement.a9;
import com.google.android.gms.internal.measurement.d1;
import com.google.android.gms.internal.measurement.f8;
import com.google.android.gms.internal.measurement.w3;
import com.google.android.gms.internal.measurement.z3;
import com.google.android.gms.internal.measurement.z5;
import com.inmobi.cmp.core.model.mspa.USRegulationData;
import com.inmobi.cmp.model.ChoiceError;
import com.uptodown.core.activities.FileExplorerActivity;
import com.uptodown.workers.DownloadUpdatesWorker;
import e1.f0;
import e1.g1;
import e1.t1;
import e1.w0;
import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import o7.m0;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import t4.n0;
import u4.y0;
import x4.j0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class s implements e3.b, o5.e, ViewBinding, t.b {

    /* renamed from: o, reason: collision with root package name */
    public static s f11753o;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11754a;

    /* renamed from: b, reason: collision with root package name */
    public Object f11755b;

    /* renamed from: l, reason: collision with root package name */
    public Object f11756l;

    /* renamed from: m, reason: collision with root package name */
    public Object f11757m;

    /* renamed from: n, reason: collision with root package name */
    public Object f11758n;

    public s(int i) {
        this.f11754a = i;
        switch (i) {
            case 3:
                com.google.android.gms.internal.measurement.t tVar = new com.google.android.gms.internal.measurement.t(0);
                this.f11755b = tVar;
                s sVar = new s((s) null, tVar);
                this.f11757m = sVar;
                this.f11756l = sVar.L();
                z5 z5Var = new z5(1);
                this.f11758n = z5Var;
                sVar.N("require", new a9(z5Var));
                ((HashMap) z5Var.f2934a).put("internal.platform", d1.f2536a);
                sVar.N("runtime.counter", new com.google.android.gms.internal.measurement.g(Double.valueOf(0.0d)));
                break;
            case 8:
                this.f11755b = m9.c.c();
                this.f11756l = m9.c.e();
                this.f11757m = (l9.a) m9.c.v.getValue();
                this.f11758n = new USRegulationData(0, null, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, null, 0, 0, 0, 0, 0, 524287, null);
                break;
            case 9:
                this.f11755b = ShareTarget.METHOD_GET;
                this.f11757m = new g5.f(9);
                break;
            case 18:
                break;
            default:
                this.f11755b = null;
                this.f11756l = null;
                this.f11757m = null;
                this.f11758n = new ArrayDeque();
                break;
        }
    }

    public static final void j(s sVar, String str, String str2) {
        if (l7.u.k0(str2, ".apk", false)) {
            HashMap hashMap = n4.m.f7985a;
            if (hashMap.containsKey(str2)) {
                return;
            }
            FileExplorerActivity fileExplorerActivity = (FileExplorerActivity) sVar.f11757m;
            PackageManager packageManager = fileExplorerActivity.getPackageManager();
            packageManager.getClass();
            PackageInfo d10 = n4.i.d(packageManager, str, 128);
            Drawable drawable = null;
            if ((d10 != null ? d10.applicationInfo : null) != null) {
                ApplicationInfo applicationInfo = d10.applicationInfo;
                applicationInfo.getClass();
                applicationInfo.sourceDir = str;
                ApplicationInfo applicationInfo2 = d10.applicationInfo;
                applicationInfo2.getClass();
                applicationInfo2.publicSourceDir = str;
                ApplicationInfo applicationInfo3 = d10.applicationInfo;
                applicationInfo3.getClass();
                drawable = applicationInfo3.loadIcon(fileExplorerActivity.getPackageManager());
            }
            if (drawable != null) {
                hashMap.put(str2, drawable);
            }
        }
    }

    public static synchronized s t() {
        s sVar;
        synchronized (s.class) {
            try {
                if (f11753o == null) {
                    f11753o = new s(0);
                }
                sVar = f11753o;
            } catch (Throwable th) {
                throw th;
            }
        }
        return sVar;
    }

    public static s x(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(2131558531, (ViewGroup) null, false);
        int i = 2131363093;
        RadioGroup radioGroup = (RadioGroup) ViewBindings.findChildViewById(inflate, 2131363093);
        if (radioGroup != null) {
            i = 2131363605;
            TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363605);
            if (textView != null) {
                i = 2131364394;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131364394);
                if (textView2 != null) {
                    return new s((LinearLayout) inflate, radioGroup, textView, textView2, 12);
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
        return null;
    }

    public static s y(LayoutInflater layoutInflater) {
        View inflate = layoutInflater.inflate(2131558586, (ViewGroup) null, false);
        int i = 2131362291;
        ImageView imageView = (ImageView) ViewBindings.findChildViewById(inflate, 2131362291);
        if (imageView != null) {
            i = 2131363637;
            TextView textView = (TextView) ViewBindings.findChildViewById(inflate, 2131363637);
            if (textView != null) {
                i = 2131363656;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(inflate, 2131363656);
                if (textView2 != null) {
                    return new s((LinearLayout) inflate, imageView, textView, textView2, 13);
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i)));
        return null;
    }

    public void A(String str, t0.f fVar) {
        if (str == null) {
            com.google.gson.internal.a.i("method == null");
            return;
        }
        if (str.length() == 0) {
            com.google.gson.internal.a.p("method.length() == 0");
            return;
        }
        if (str.equals(ShareTarget.METHOD_POST) || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT")) {
            com.google.gson.internal.a.p(androidx.lifecycle.l.w("method ", str, " must have a request body."));
        } else {
            this.f11755b = str;
        }
    }

    public void B(String str) {
        ((g5.f) this.f11757m).Q(str);
    }

    public void C(b9.q qVar, int i) {
        Class<?> cls = qVar.getClass();
        a4.d0 d0Var = (a4.d0) this.f11755b;
        e6.a aVar = (e6.a) ((Map) ((a3.d) d0Var.f85o).f63b).get(cls);
        if (aVar != null) {
            Object a8 = aVar.a(d0Var, (f0.i) this.f11756l);
            c6.e eVar = (c6.e) this.f11757m;
            StringBuilder sb = eVar.f2423a;
            int length = sb.length();
            int length2 = sb.length();
            if (length <= i || i < 0 || length > length2) {
                return;
            }
            c6.e.c(eVar, a8, i, length);
        }
    }

    public void D(String str) {
        if (str == null) {
            com.google.gson.internal.a.i("url == null");
            return;
        }
        String concat = str.regionMatches(true, 0, "ws:", 0, 3) ? "http:".concat(str.substring(3)) : str.regionMatches(true, 0, "wss:", 0, 4) ? "https:".concat(str.substring(4)) : str;
        m8.t tVar = new m8.t();
        m8.u a8 = tVar.b(null, concat) == 1 ? tVar.a() : null;
        if (a8 != null) {
            this.f11756l = a8;
        } else {
            com.google.gson.internal.a.p("unexpected url: ".concat(concat));
        }
    }

    public void E(b9.q qVar) {
        c6.a aVar = (c6.a) ((Map) this.f11758n).get(qVar.getClass());
        if (aVar != null) {
            aVar.a(this, qVar);
        } else {
            F(qVar);
        }
    }

    public void F(b9.q qVar) {
        b9.q qVar2 = qVar.f1122b;
        while (qVar2 != null) {
            b9.q qVar3 = qVar2.f1125e;
            qVar2.a(this);
            qVar2 = qVar3;
        }
    }

    public Bundle G() {
        JSONObject jSONObject;
        String string;
        String string2;
        int hashCode;
        g1 g1Var = (g1) this.f11758n;
        if (((Bundle) this.f11757m) == null) {
            String str = (String) this.f11755b;
            SharedPreferences k5 = g1Var.k();
            t1 t1Var = g1Var.f3875a;
            String string3 = k5.getString(str, null);
            if (string3 != null) {
                try {
                    Bundle bundle = new Bundle();
                    JSONArray jSONArray = new JSONArray(string3);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        try {
                            jSONObject = jSONArray.getJSONObject(i);
                            string = jSONObject.getString("n");
                            string2 = jSONObject.getString("t");
                            hashCode = string2.hashCode();
                        } catch (NumberFormatException | JSONException unused) {
                            w0 w0Var = t1Var.f4264o;
                            t1.m(w0Var);
                            w0Var.f4339o.b("Error reading value from SharedPreferences. Value dropped");
                        }
                        if (hashCode != 100) {
                            if (hashCode != 108) {
                                if (hashCode != 115) {
                                    if (hashCode != 3352) {
                                        if (hashCode == 3445 && string2.equals("la")) {
                                            f8.a();
                                            if (t1Var.f4262m.q(null, f0.R0)) {
                                                JSONArray jSONArray2 = new JSONArray(jSONObject.getString("v"));
                                                int length = jSONArray2.length();
                                                long[] jArr = new long[length];
                                                for (int i6 = 0; i6 < length; i6++) {
                                                    jArr[i6] = jSONArray2.optLong(i6);
                                                }
                                                bundle.putLongArray(string, jArr);
                                            }
                                        }
                                    } else if (string2.equals("ia")) {
                                        f8.a();
                                        if (t1Var.f4262m.q(null, f0.R0)) {
                                            JSONArray jSONArray3 = new JSONArray(jSONObject.getString("v"));
                                            int length2 = jSONArray3.length();
                                            int[] iArr = new int[length2];
                                            for (int i10 = 0; i10 < length2; i10++) {
                                                iArr[i10] = jSONArray3.optInt(i10);
                                            }
                                            bundle.putIntArray(string, iArr);
                                        }
                                    }
                                } else if (string2.equals("s")) {
                                    bundle.putString(string, jSONObject.getString("v"));
                                }
                            } else if (string2.equals("l")) {
                                bundle.putLong(string, Long.parseLong(jSONObject.getString("v")));
                            }
                        } else if (string2.equals("d")) {
                            bundle.putDouble(string, Double.parseDouble(jSONObject.getString("v")));
                        }
                        w0 w0Var2 = t1Var.f4264o;
                        t1.m(w0Var2);
                        w0Var2.f4339o.c(string2, "Unrecognized persisted bundle type. Type");
                    }
                    this.f11757m = bundle;
                } catch (JSONException unused2) {
                    w0 w0Var3 = t1Var.f4264o;
                    t1.m(w0Var3);
                    w0Var3.f4339o.b("Error loading bundle from SharedPreferences. Values will be lost");
                }
            }
            if (((Bundle) this.f11757m) == null) {
                this.f11757m = (Bundle) this.f11756l;
            }
        }
        Bundle bundle2 = (Bundle) this.f11757m;
        k0.y.g(bundle2);
        return new Bundle(bundle2);
    }

    public com.google.android.gms.internal.measurement.n H(com.google.android.gms.internal.measurement.n nVar) {
        return ((com.google.android.gms.internal.measurement.t) this.f11756l).c(this, nVar);
    }

    public com.google.android.gms.internal.measurement.n I(s sVar, w3... w3VarArr) {
        com.google.android.gms.internal.measurement.n nVar = com.google.android.gms.internal.measurement.n.f2717c;
        for (w3 w3Var : w3VarArr) {
            nVar = z3.X(w3Var);
            b2.t1.f0((s) this.f11757m);
            if ((nVar instanceof com.google.android.gms.internal.measurement.o) || (nVar instanceof com.google.android.gms.internal.measurement.m)) {
                nVar = ((com.google.android.gms.internal.measurement.t) this.f11755b).c(sVar, nVar);
            }
        }
        return nVar;
    }

    public com.google.android.gms.internal.measurement.n J(com.google.android.gms.internal.measurement.d dVar) {
        com.google.android.gms.internal.measurement.n nVar = com.google.android.gms.internal.measurement.n.f2717c;
        Iterator n10 = dVar.n();
        while (n10.hasNext()) {
            nVar = ((com.google.android.gms.internal.measurement.t) this.f11756l).c(this, dVar.p(((Integer) n10.next()).intValue()));
            if (nVar instanceof com.google.android.gms.internal.measurement.f) {
                break;
            }
        }
        return nVar;
    }

    public void K(Bundle bundle) {
        g1 g1Var = (g1) this.f11758n;
        Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        SharedPreferences k5 = g1Var.k();
        t1 t1Var = g1Var.f3875a;
        SharedPreferences.Editor edit = k5.edit();
        int size = bundle2.size();
        String str = (String) this.f11755b;
        if (size == 0) {
            edit.remove(str);
        } else {
            JSONArray jSONArray = new JSONArray();
            for (String str2 : bundle2.keySet()) {
                Object obj = bundle2.get(str2);
                if (obj != null) {
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("n", str2);
                        f8.a();
                        if (!t1Var.f4262m.q(null, f0.R0)) {
                            jSONObject.put("v", obj.toString());
                            if (obj instanceof String) {
                                jSONObject.put("t", "s");
                            } else if (obj instanceof Long) {
                                jSONObject.put("t", "l");
                            } else if (obj instanceof Double) {
                                jSONObject.put("t", "d");
                            } else {
                                w0 w0Var = t1Var.f4264o;
                                t1.m(w0Var);
                                w0Var.f4339o.c(obj.getClass(), "Cannot serialize bundle value to SharedPreferences. Type");
                            }
                        } else if (obj instanceof String) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "s");
                        } else if (obj instanceof Long) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "l");
                        } else if (obj instanceof int[]) {
                            jSONObject.put("v", Arrays.toString((int[]) obj));
                            jSONObject.put("t", "ia");
                        } else if (obj instanceof long[]) {
                            jSONObject.put("v", Arrays.toString((long[]) obj));
                            jSONObject.put("t", "la");
                        } else if (obj instanceof Double) {
                            jSONObject.put("v", obj.toString());
                            jSONObject.put("t", "d");
                        } else {
                            w0 w0Var2 = t1Var.f4264o;
                            t1.m(w0Var2);
                            w0Var2.f4339o.c(obj.getClass(), "Cannot serialize bundle value to SharedPreferences. Type");
                        }
                        jSONArray.put(jSONObject);
                    } catch (JSONException e10) {
                        w0 w0Var3 = t1Var.f4264o;
                        t1.m(w0Var3);
                        w0Var3.f4339o.c(e10, "Cannot serialize bundle value to SharedPreferences");
                    }
                }
            }
            edit.putString(str, jSONArray.toString());
        }
        edit.apply();
        this.f11757m = bundle2;
    }

    public s L() {
        return new s(this, (com.google.android.gms.internal.measurement.t) this.f11756l);
    }

    public boolean M(String str) {
        if (((HashMap) this.f11757m).containsKey(str)) {
            return true;
        }
        s sVar = (s) this.f11755b;
        if (sVar != null) {
            return sVar.M(str);
        }
        return false;
    }

    public void N(String str, com.google.android.gms.internal.measurement.n nVar) {
        s sVar;
        HashMap hashMap = (HashMap) this.f11757m;
        if (!hashMap.containsKey(str) && (sVar = (s) this.f11755b) != null && sVar.M(str)) {
            sVar.N(str, nVar);
        } else {
            if (((HashMap) this.f11758n).containsKey(str)) {
                return;
            }
            if (nVar == null) {
                hashMap.remove(str);
            } else {
                hashMap.put(str, nVar);
            }
        }
    }

    public void O(String str, com.google.android.gms.internal.measurement.n nVar) {
        if (((HashMap) this.f11758n).containsKey(str)) {
            return;
        }
        HashMap hashMap = (HashMap) this.f11757m;
        if (nVar == null) {
            hashMap.remove(str);
        } else {
            hashMap.put(str, nVar);
        }
    }

    public com.google.android.gms.internal.measurement.n P(String str) {
        HashMap hashMap = (HashMap) this.f11757m;
        if (hashMap.containsKey(str)) {
            return (com.google.android.gms.internal.measurement.n) hashMap.get(str);
        }
        s sVar = (s) this.f11755b;
        if (sVar != null) {
            return sVar.P(str);
        }
        com.google.gson.internal.a.p(a4.x.C(str, " is not defined"));
        return null;
    }

    @Override // o5.e
    public void a(long j) {
        ((kotlin.jvm.internal.w) this.f11755b).f7023a = j;
    }

    @Override // o5.e
    public void b(long j) {
        ((kotlin.jvm.internal.w) this.f11756l).f7023a = j;
    }

    public String c(int i) {
        if (i == 0) {
            throw null;
        }
        switch (c.j.c(i)) {
            case 0:
                List list = r3.o.f8883a;
                return "SharingNotice";
            case 1:
                List list2 = r3.o.f8883a;
                return "SaleOptOutNotice";
            case 2:
                List list3 = r3.o.f8883a;
                return "SharingOptOutNotice";
            case 3:
                List list4 = r3.o.f8883a;
                return "TargetedAdvertisingOptOutNotice";
            case 4:
                List list5 = r3.o.f8883a;
                return "SensitiveDataProcessingOptOutNotice";
            case 5:
                List list6 = r3.o.f8883a;
                return "SensitiveDataLimitUseNotice";
            case 6:
            default:
                return "";
            case 7:
                List list7 = r3.o.f8883a;
                return "SaleOptOut";
            case 8:
                List list8 = r3.o.f8883a;
                return "SharingOptOut";
            case 9:
                List list9 = r3.o.f8883a;
                return "TargetedAdvertisingOptOut";
            case 10:
                List list10 = r3.o.f8883a;
                return "SensitiveDataProcessing";
            case 11:
                List list11 = r3.o.f8883a;
                return "KnownChildSensitiveDataConsents";
            case 12:
                List list12 = r3.o.f8883a;
                return "PersonalDataConsents";
            case 13:
                List list13 = r3.o.f8883a;
                return "MspaCoveredTransaction";
            case 14:
                List list14 = r3.o.f8883a;
                return "MspaOptOutOptionMode";
            case 15:
                List list15 = r3.o.f8883a;
                return "MspaServiceProviderMode";
        }
    }

    public void d(int i, Object obj) {
        if (i == 0) {
            throw null;
        }
        try {
            ((l3.a) this.f11755b).h(k(), c(i), obj);
        } catch (Exception unused) {
            a.a.h(null, ChoiceError.ERROR_WHILE_SAVING_CONSENT.getMessage(), null, 5);
        }
    }

    @Override // o5.e
    public void e() {
        Bundle e10 = k0.k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "reconnected");
        DownloadUpdatesWorker downloadUpdatesWorker = (DownloadUpdatesWorker) this.f11757m;
        downloadUpdatesWorker.r(e10, downloadUpdatesWorker.f3476c, (j0) this.f11758n);
    }

    public void f(int i, boolean z9) {
        if (i == 0) {
            throw null;
        }
        List<Integer> d02 = z9 ? q6.m.d0(1, 1, 1) : q6.m.d0(2, 2, 2);
        d(i, d02);
        ((USRegulationData) this.f11758n).setKnownChildSensitiveDataConsents(d02);
    }

    public void g(Boolean bool, int i) {
        if (i == 0) {
            throw null;
        }
        Boolean bool2 = Boolean.TRUE;
        int i6 = kotlin.jvm.internal.l.a(bool, bool2) ? 1 : 2;
        ((USRegulationData) this.f11758n).setPersonalDataConsents(kotlin.jvm.internal.l.a(bool, bool2) ? 1 : 2);
        d(i, Integer.valueOf(i6));
    }

    @Override // m6.a
    public Object get() {
        switch (this.f11754a) {
            case 1:
                return new c3.o((n1.f) ((f0.i) this.f11755b).f4811b, (f3.j) ((m6.a) this.f11756l).get(), (t6.h) ((m6.a) this.f11757m).get(), (c3.w0) ((e3.c) this.f11758n).get());
            default:
                return new s((Executor) ((m6.a) this.f11755b).get(), (y.d) ((m6.a) this.f11756l).get(), (n0) ((n0) this.f11757m).get(), (z.c) ((m6.a) this.f11758n).get(), 20);
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        switch (this.f11754a) {
        }
        return (RelativeLayout) this.f11755b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:133:0x026d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00e1  */
    /* JADX WARN: Type inference failed for: r15v8, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v25, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r31v0, types: [d7.l] */
    /* JADX WARN: Type inference failed for: r6v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v1, types: [q6.t] */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r7v31, types: [java.util.ArrayList] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void h(java.util.List r29, boolean r30, d7.l r31) {
        /*
            Method dump skipped, instructions count: 1064
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.s.h(java.util.List, boolean, d7.l):void");
    }

    public void i(boolean z9) {
        int i = z9 ? 1 : 2;
        d(6, Integer.valueOf(i));
        ((USRegulationData) this.f11758n).setSensitiveDataLimitUseNotice(i);
    }

    public String k() {
        return "usnat";
    }

    public void l(boolean z9) {
        int i = z9 ? 1 : 2;
        d(5, Integer.valueOf(i));
        ((USRegulationData) this.f11758n).setSensitiveDataProcessingOptOutNotice(i);
    }

    public void m(b9.q qVar) {
        if (qVar.f1125e != null) {
            s();
            ((c6.e) this.f11757m).a('\n');
        }
    }

    public m8.a0 n() {
        if (((m8.u) this.f11756l) != null) {
            return new m8.a0(this);
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("url == null");
        return null;
    }

    public int o() {
        return 7;
    }

    public void p(boolean z9) {
        int i = z9 ? 1 : 2;
        d(1, Integer.valueOf(i));
        ((USRegulationData) this.f11758n).setSharingNotice(i);
    }

    public void q(boolean z9) {
        int i = z9 ? 1 : 2;
        d(3, Integer.valueOf(i));
        ((USRegulationData) this.f11758n).setSharingOptOutNotice(i);
    }

    public void r(boolean z9) {
        int i = z9 ? 1 : 2;
        d(4, Integer.valueOf(i));
        ((USRegulationData) this.f11758n).setTargetedAdvertisingOptOutNotice(i);
    }

    public void s() {
        c6.e eVar = (c6.e) this.f11757m;
        StringBuilder sb = eVar.f2423a;
        if (sb.length() <= 0 || '\n' == sb.charAt(sb.length() - 1)) {
            return;
        }
        eVar.a('\n');
    }

    public boolean u(Context context) {
        if (((Boolean) this.f11757m) == null) {
            this.f11757m = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!((Boolean) this.f11756l).booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return ((Boolean) this.f11757m).booleanValue();
    }

    public boolean v(Context context) {
        if (((Boolean) this.f11756l) == null) {
            this.f11756l = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!((Boolean) this.f11756l).booleanValue() && Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return ((Boolean) this.f11756l).booleanValue();
    }

    public void w(String str, String str2) {
        g5.f fVar = (g5.f) this.f11757m;
        fVar.getClass();
        g5.f.v(str, str2);
        fVar.Q(str);
        fVar.o(str, str2);
    }

    public int z() {
        return ((c6.e) this.f11757m).f2423a.length();
    }

    public /* synthetic */ s(boolean z9) {
        this.f11754a = 9;
    }

    public s(g1 g1Var, String str) {
        this.f11754a = 5;
        this.f11758n = g1Var;
        k0.y.d(str);
        this.f11755b = str;
        this.f11756l = new Bundle();
    }

    public s(s sVar, com.google.android.gms.internal.measurement.t tVar) {
        this.f11754a = 4;
        this.f11757m = new HashMap();
        this.f11758n = new HashMap();
        this.f11755b = sVar;
        this.f11756l = tVar;
    }

    public s(DocumentFile documentFile, File file, FileExplorerActivity fileExplorerActivity, android.support.v4.media.g gVar) {
        this.f11754a = 7;
        this.f11755b = documentFile;
        this.f11756l = file;
        this.f11757m = fileExplorerActivity;
        this.f11758n = gVar;
        v7.e eVar = m0.f8288a;
        o7.c0.s(o7.c0.b(v7.d.f10884a), null, null, new j4.q(this, null, 0), 3);
    }

    public s(Context context, y0 y0Var, x4.j jVar) {
        this.f11754a = 11;
        y0Var.getClass();
        jVar.getClass();
        this.f11755b = context;
        this.f11756l = y0Var;
        this.f11757m = jVar;
        this.f11758n = new ArrayList();
    }

    public s(a4.d0 d0Var, f0.i iVar, c6.e eVar, Map map, q2.e eVar2) {
        this.f11754a = 2;
        this.f11755b = d0Var;
        this.f11756l = iVar;
        this.f11757m = eVar;
        this.f11758n = map;
    }

    public /* synthetic */ s(Object obj, Object obj2, Object obj3, Object obj4, int i) {
        this.f11754a = i;
        this.f11755b = obj;
        this.f11756l = obj2;
        this.f11757m = obj3;
        this.f11758n = obj4;
    }
}
