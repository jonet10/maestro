package b5;

import a4.d0;
import a4.x;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.datastore.core.DataStore;
import androidx.datastore.core.DataStoreFactory;
import androidx.datastore.core.MultiProcessDataStoreFactory;
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler;
import androidx.documentfile.provider.DocumentFile;
import androidx.lifecycle.ViewModelKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import c3.h1;
import c4.k0;
import c4.u7;
import c4.y7;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.workers.DownloadApkWorker;
import e1.d3;
import e1.s0;
import e1.t1;
import e1.u4;
import e1.y0;
import j1.p;
import j5.s;
import j5.v;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.atomic.AtomicLong;
import k0.n;
import k0.o;
import kotlin.jvm.internal.w;
import o7.a0;
import o7.c0;
import o7.m0;
import org.json.JSONArray;
import org.json.JSONObject;
import q6.t;
import x4.f2;
import x4.g1;
import x4.g2;
import x4.j0;
import x4.k2;
import x4.m2;
import x4.q2;
import x4.r;
import x4.u2;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m implements e3.b, k4.a, a4.i, w4.m, d3, y0, j1.d, o5.e, t.b, ViewBinding {

    /* renamed from: n, reason: collision with root package name */
    public static m f1059n;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1060a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1061b;

    /* renamed from: l, reason: collision with root package name */
    public Object f1062l;

    /* renamed from: m, reason: collision with root package name */
    public Object f1063m;

    public m(int i) {
        this.f1060a = i;
        switch (i) {
            case 14:
                break;
            default:
                this.f1061b = new com.google.android.gms.internal.measurement.b("", 0L, null);
                this.f1062l = new com.google.android.gms.internal.measurement.b("", 0L, null);
                this.f1063m = new ArrayList();
                break;
        }
    }

    public static String A(String str, HashMap hashMap) {
        StringBuilder sb = new StringBuilder();
        Iterator it = hashMap.entrySet().iterator();
        Map.Entry entry = (Map.Entry) it.next();
        sb.append((String) entry.getKey());
        sb.append("=");
        sb.append(entry.getValue() != null ? URLEncoder.encode((String) entry.getValue(), "UTF-8") : "");
        while (it.hasNext()) {
            Map.Entry entry2 = (Map.Entry) it.next();
            sb.append("&");
            sb.append((String) entry2.getKey());
            sb.append("=");
            sb.append(entry2.getValue() != null ? URLEncoder.encode((String) entry2.getValue(), "UTF-8") : "");
        }
        String sb2 = sb.toString();
        if (sb2.isEmpty()) {
            return str;
        }
        if (!str.contains("?")) {
            return x.k(str, "?", sb2);
        }
        if (!str.endsWith("&")) {
            sb2 = "&".concat(sb2);
        }
        return str.concat(sb2);
    }

    public static final String j(m mVar, Context context, String str, String str2) {
        v vVar = new v(context);
        str.getClass();
        str2.getClass();
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("packagename", str);
        jSONObject.put("md5Signature", str2);
        hashMap.put("app", jSONObject.toString());
        hashMap.putAll(v.g());
        g2 k5 = vVar.k("https://www.uptodown.app:443".concat("/eapi/nativeapp/getappurlbypackagenamemd5signature"), hashMap, ShareTarget.METHOD_POST, false);
        JSONObject i = vVar.i(k5, "/eapi/nativeapp/getappurlbypackagenamemd5signature");
        k5.f11206d = i;
        if (i == null) {
            return null;
        }
        int optInt = i.isNull("success") ? 0 : i.optInt("success");
        JSONObject optJSONObject = i.optJSONObject("data");
        if (optInt != 1 || optJSONObject == null || optJSONObject.isNull("app_url")) {
            return null;
        }
        return optJSONObject.optString("app_url");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object l(b5.m r5, java.lang.String r6, v6.c r7) {
        /*
            boolean r0 = r7 instanceof s4.z
            if (r0 == 0) goto L13
            r0 = r7
            s4.z r0 = (s4.z) r0
            int r1 = r0.f9328l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9328l = r1
            goto L18
        L13:
            s4.z r0 = new s4.z
            r0.<init>(r5, r7)
        L18:
            java.lang.Object r7 = r0.f9326a
            int r1 = r0.f9328l
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2c
            if (r1 != r3) goto L26
            p6.a.e(r7)
            goto L44
        L26:
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r5)
            return r2
        L2c:
            p6.a.e(r7)
            v7.e r7 = o7.m0.f8288a
            v7.d r7 = v7.d.f10884a
            s4.a0 r1 = new s4.a0
            r4 = 0
            r1.<init>(r5, r6, r2, r4)
            r0.f9328l = r3
            java.lang.Object r7 = o7.c0.C(r1, r7, r0)
            u6.a r5 = u6.a.f10762a
            if (r7 != r5) goto L44
            return r5
        L44:
            p6.k r7 = (p6.k) r7
            java.lang.Object r5 = r7.f8444a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: b5.m.l(b5.m, java.lang.String, v6.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object t(b5.m r4, java.lang.String r5, v6.c r6) {
        /*
            boolean r0 = r6 instanceof s4.b0
            if (r0 == 0) goto L13
            r0 = r6
            s4.b0 r0 = (s4.b0) r0
            int r1 = r0.f9175l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9175l = r1
            goto L18
        L13:
            s4.b0 r0 = new s4.b0
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f9173a
            int r1 = r0.f9175l
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2c
            if (r1 != r3) goto L26
            p6.a.e(r6)
            goto L43
        L26:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r4)
            return r2
        L2c:
            p6.a.e(r6)
            v7.e r6 = o7.m0.f8288a
            v7.d r6 = v7.d.f10884a
            s4.a0 r1 = new s4.a0
            r1.<init>(r4, r5, r2, r3)
            r0.f9175l = r3
            java.lang.Object r6 = o7.c0.C(r1, r6, r0)
            u6.a r4 = u6.a.f10762a
            if (r6 != r4) goto L43
            return r4
        L43:
            p6.k r6 = (p6.k) r6
            java.lang.Object r4 = r6.f8444a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: b5.m.t(b5.m, java.lang.String, v6.c):java.lang.Object");
    }

    public static final f2 v(m mVar, JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (jSONObject.optInt("success") != 1 || optJSONObject == null) {
            return null;
        }
        f2 f2Var = new f2();
        if (!optJSONObject.isNull("sha256")) {
            f2Var.f11151a = optJSONObject.optString("sha256");
        }
        if (!optJSONObject.isNull("scans")) {
            f2Var.f11153l = optJSONObject.optInt("scans");
        }
        if (!optJSONObject.isNull("positives")) {
            f2Var.f11154m = optJSONObject.optInt("positives");
        }
        if (!optJSONObject.isNull("lastAnalysis")) {
            f2Var.f11155n = optJSONObject.optString("lastAnalysis");
        }
        if (!optJSONObject.isNull("md5Signature")) {
            f2Var.f11152b = optJSONObject.optString("md5Signature");
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("infections");
        if (optJSONArray != null) {
            f2Var.f11156o = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                g1 g1Var = new g1();
                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i);
                if (optJSONObject2 != null) {
                    if (!optJSONObject2.isNull("antivirusName")) {
                        g1Var.f11199a = optJSONObject2.optString("antivirusName");
                    }
                    if (!optJSONObject2.isNull("virusName")) {
                        g1Var.f11200b = optJSONObject2.optString("virusName");
                    }
                    if (!optJSONObject2.isNull("isPup")) {
                        g1Var.f11201l = optJSONObject2.optInt("isPup");
                    }
                    if (!optJSONObject2.isNull("isAdware")) {
                        g1Var.f11202m = optJSONObject2.optInt("isAdware");
                    }
                }
                ArrayList arrayList = f2Var.f11156o;
                arrayList.getClass();
                arrayList.add(g1Var);
            }
        }
        if (!optJSONObject.isNull("vtReportLink")) {
            f2Var.f11157p = optJSONObject.optString("vtReportLink");
        }
        return f2Var;
    }

    public static m w(View view) {
        int i = 2131362545;
        if (((ImageView) ViewBindings.findChildViewById(view, 2131362545)) != null) {
            i = 2131364131;
            TextView textView = (TextView) ViewBindings.findChildViewById(view, 2131364131);
            if (textView != null) {
                i = 2131364132;
                TextView textView2 = (TextView) ViewBindings.findChildViewById(view, 2131364132);
                if (textView2 != null) {
                    return new m((LinearLayout) view, textView, textView2, 26);
                }
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public static m z(View view) {
        RelativeLayout relativeLayout = (RelativeLayout) view;
        int i = 2131364174;
        TextView textView = (TextView) ViewBindings.findChildViewById(view, 2131364174);
        if (textView != null) {
            i = 2131364175;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view, 2131364175);
            if (textView2 != null) {
                return new m(relativeLayout, textView, textView2, 29);
            }
        }
        com.google.gson.internal.a.i("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
        return null;
    }

    public void B(Object obj, ByteArrayOutputStream byteArrayOutputStream) {
        HashMap hashMap = (HashMap) this.f1061b;
        o2.f fVar = new o2.f(byteArrayOutputStream, hashMap, (HashMap) this.f1062l, (l2.d) this.f1063m);
        l2.d dVar = (l2.d) hashMap.get(obj.getClass());
        if (dVar != null) {
            dVar.a(obj, fVar);
            return;
        }
        throw new l2.b("No encoder for " + obj.getClass());
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d2.a C() {
        /*
            r8 = this;
            java.lang.String r0 = "GET Request URL: "
            java.lang.String r1 = "FirebaseCrashlytics"
            z1.e.b()
            r2 = 0
            java.lang.Object r3 = r8.f1061b     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> Lb5
            java.lang.Object r4 = r8.f1062l     // Catch: java.lang.Throwable -> Lb5
            java.util.HashMap r4 = (java.util.HashMap) r4     // Catch: java.lang.Throwable -> Lb5
            java.lang.String r3 = A(r3, r4)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r0 = r0.concat(r3)     // Catch: java.lang.Throwable -> Lb0
            r4 = 2
            boolean r4 = android.util.Log.isLoggable(r1, r4)     // Catch: java.lang.Throwable -> L23
            if (r4 == 0) goto L26
            android.util.Log.v(r1, r0, r2)     // Catch: java.lang.Throwable -> L23
            goto L26
        L23:
            r0 = move-exception
            goto Lb3
        L26:
            java.net.URL r0 = new java.net.URL     // Catch: java.lang.Throwable -> Lb0
            r0.<init>(r3)     // Catch: java.lang.Throwable -> Lb0
            java.net.URLConnection r0 = r0.openConnection()     // Catch: java.lang.Throwable -> Lb0
            javax.net.ssl.HttpsURLConnection r0 = (javax.net.ssl.HttpsURLConnection) r0     // Catch: java.lang.Throwable -> Lb0
            r1 = 10000(0x2710, float:1.4013E-41)
            r0.setReadTimeout(r1)     // Catch: java.lang.Throwable -> L66
            r0.setConnectTimeout(r1)     // Catch: java.lang.Throwable -> L66
            java.lang.String r1 = "GET"
            r0.setRequestMethod(r1)     // Catch: java.lang.Throwable -> L66
            java.lang.Object r1 = r8.f1063m     // Catch: java.lang.Throwable -> L66
            java.util.HashMap r1 = (java.util.HashMap) r1     // Catch: java.lang.Throwable -> L66
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L66
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L66
        L4a:
            boolean r3 = r1.hasNext()     // Catch: java.lang.Throwable -> L66
            if (r3 == 0) goto L68
            java.lang.Object r3 = r1.next()     // Catch: java.lang.Throwable -> L66
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch: java.lang.Throwable -> L66
            java.lang.Object r4 = r3.getKey()     // Catch: java.lang.Throwable -> L66
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L66
            java.lang.Object r3 = r3.getValue()     // Catch: java.lang.Throwable -> L66
            java.lang.String r3 = (java.lang.String) r3     // Catch: java.lang.Throwable -> L66
            r0.addRequestProperty(r4, r3)     // Catch: java.lang.Throwable -> L66
            goto L4a
        L66:
            r1 = move-exception
            goto Lb7
        L68:
            r0.connect()     // Catch: java.lang.Throwable -> L66
            int r1 = r0.getResponseCode()     // Catch: java.lang.Throwable -> L66
            java.io.InputStream r3 = r0.getInputStream()     // Catch: java.lang.Throwable -> L66
            if (r3 == 0) goto L9e
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L9b
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L9b
            java.lang.String r5 = "UTF-8"
            r4.<init>(r3, r5)     // Catch: java.lang.Throwable -> L9b
            r2.<init>(r4)     // Catch: java.lang.Throwable -> L9b
            r4 = 8192(0x2000, float:1.148E-41)
            char[] r4 = new char[r4]     // Catch: java.lang.Throwable -> L9b
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L9b
            r5.<init>()     // Catch: java.lang.Throwable -> L9b
        L8a:
            int r6 = r2.read(r4)     // Catch: java.lang.Throwable -> L9b
            r7 = -1
            if (r6 == r7) goto L96
            r7 = 0
            r5.append(r4, r7, r6)     // Catch: java.lang.Throwable -> L9b
            goto L8a
        L96:
            java.lang.String r2 = r5.toString()     // Catch: java.lang.Throwable -> L9b
            goto L9e
        L9b:
            r1 = move-exception
            r2 = r3
            goto Lb7
        L9e:
            if (r3 == 0) goto La3
            r3.close()
        La3:
            r0.disconnect()
            d2.a r0 = new d2.a
            r0.<init>()
            r0.f3538a = r1
            r0.f3539b = r2
            return r0
        Lb0:
            r1 = move-exception
        Lb1:
            r0 = r2
            goto Lb7
        Lb3:
            r1 = r0
            goto Lb1
        Lb5:
            r0 = move-exception
            goto Lb3
        Lb7:
            if (r2 == 0) goto Lbc
            r2.close()
        Lbc:
            if (r0 == 0) goto Lc1
            r0.disconnect()
        Lc1:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: b5.m.C():d2.a");
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object D(t6.c r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof s4.y
            if (r0 == 0) goto L13
            r0 = r6
            s4.y r0 = (s4.y) r0
            int r1 = r0.f9322l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9322l = r1
            goto L18
        L13:
            s4.y r0 = new s4.y
            r0.<init>(r5, r6)
        L18:
            java.lang.Object r6 = r0.f9320a
            int r1 = r0.f9322l
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L2c
            if (r1 != r3) goto L26
            p6.a.e(r6)
            goto L45
        L26:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
            return r2
        L2c:
            p6.a.e(r6)
            v7.e r6 = o7.m0.f8288a
            v7.d r6 = v7.d.f10884a
            p9.c r1 = new p9.c
            r4 = 8
            r1.<init>(r5, r2, r4)
            r0.f9322l = r3
            java.lang.Object r6 = o7.c0.C(r1, r6, r0)
            u6.a r0 = u6.a.f10762a
            if (r6 != r0) goto L45
            return r0
        L45:
            p6.k r6 = (p6.k) r6
            java.lang.Object r6 = r6.f8444a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: b5.m.D(t6.c):java.lang.Object");
    }

    public void E(String str, String str2) {
        ((HashMap) this.f1063m).put(str, str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0065, code lost:
    
        if (o7.c0.C(r6, r9, r0) != r5) goto L22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0067, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
    
        if (o7.c0.C(r6, r9, r0) == r5) goto L21;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object F(v6.c r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof s4.q0
            if (r0 == 0) goto L13
            r0 = r9
            s4.q0 r0 = (s4.q0) r0
            int r1 = r0.f9270m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f9270m = r1
            goto L18
        L13:
            s4.q0 r0 = new s4.q0
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.f9268b
            int r1 = r0.f9270m
            r2 = 2
            r3 = 1
            r4 = 0
            u6.a r5 = u6.a.f10762a
            if (r1 == 0) goto L37
            if (r1 == r3) goto L31
            if (r1 != r2) goto L2b
            p6.a.e(r9)
            goto L68
        L2b:
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r9)
            return r4
        L31:
            kotlin.jvm.internal.x r1 = r0.f9267a
            p6.a.e(r9)
            goto L54
        L37:
            p6.a.e(r9)
            kotlin.jvm.internal.x r1 = new kotlin.jvm.internal.x
            r1.<init>()
            v7.e r9 = o7.m0.f8288a
            v7.d r9 = v7.d.f10884a
            s4.r0 r6 = new s4.r0
            r7 = 0
            r6.<init>(r8, r1, r4, r7)
            r0.f9267a = r1
            r0.f9270m = r3
            java.lang.Object r9 = o7.c0.C(r6, r9, r0)
            if (r9 != r5) goto L54
            goto L67
        L54:
            v7.e r9 = o7.m0.f8288a
            p7.c r9 = t7.n.f10348a
            s4.r0 r6 = new s4.r0
            r6.<init>(r8, r1, r4, r3)
            r0.f9267a = r4
            r0.f9270m = r2
            java.lang.Object r9 = o7.c0.C(r6, r9, r0)
            if (r9 != r5) goto L68
        L67:
            return r5
        L68:
            p6.x r9 = p6.x.f8463a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: b5.m.F(v6.c):java.lang.Object");
    }

    public synchronized void G(int i, int i6, long j, long j6) {
        ((t1) this.f1061b).f4269t.getClass();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        AtomicLong atomicLong = (AtomicLong) this.f1063m;
        if (atomicLong.get() != -1 && elapsedRealtime - atomicLong.get() <= 1800000) {
            return;
        }
        p b7 = ((m0.b) this.f1062l).b(new n(0, Arrays.asList(new k0.j(36301, i, 0, j, j6, null, null, 0, i6))));
        s0 s0Var = new s0();
        s0Var.f4243b = this;
        s0Var.f4242a = elapsedRealtime;
        b7.getClass();
        b7.b(j1.j.f6540a, s0Var);
    }

    @Override // o5.e
    public void a(long j) {
        ((w) this.f1061b).f7023a = j;
    }

    @Override // o5.e
    public void b(long j) {
        ((w) this.f1062l).f7023a = j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:12:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0174 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0132  */
    /* JADX WARN: Type inference failed for: r12v19, types: [java.lang.String] */
    @Override // e1.d3, e1.y0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void c(java.lang.String r9, int r10, java.lang.Throwable r11, byte[] r12, java.util.Map r13) {
        /*
            Method dump skipped, instructions count: 392
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b5.m.c(java.lang.String, int, java.lang.Throwable, byte[], java.util.Map):void");
    }

    public /* bridge */ /* synthetic */ Object clone() {
        switch (this.f1060a) {
            case 5:
                m mVar = new m(((com.google.android.gms.internal.measurement.b) this.f1061b).clone());
                ArrayList arrayList = (ArrayList) this.f1063m;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    ((ArrayList) mVar.f1063m).add(((com.google.android.gms.internal.measurement.b) obj).clone());
                }
                return mVar;
            default:
                return super.clone();
        }
    }

    @Override // o5.e
    public void e() {
        Bundle e10 = k0.k.e(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "reconnected");
        DownloadApkWorker downloadApkWorker = (DownloadApkWorker) this.f1063m;
        String str = downloadApkWorker.f3476c;
        r rVar = downloadApkWorker.f3477d;
        rVar.getClass();
        downloadApkWorker.r(e10, str, (j0) rVar.F.get(0));
    }

    @Override // w4.m
    public void g(int i) {
        PublicProfileActivity publicProfileActivity = (PublicProfileActivity) this.f1061b;
        if (publicProfileActivity.T()) {
            Object obj = ((u7) ((j5.r) ((s) this.f1062l)).f6707a).f2169b.get(i);
            obj.getClass();
            publicProfileActivity.i0(((k2) obj).f11262n);
        }
    }

    @Override // m6.a
    public Object get() {
        DataStore create;
        switch (this.f1060a) {
            case 1:
                Context context = (Context) ((f0.i) this.f1061b).f4811b;
                t6.h hVar = (t6.h) ((m6.a) this.f1062l).get();
                c3.j0 j0Var = (c3.j0) ((e3.c) this.f1063m).get();
                context.getClass();
                hVar.getClass();
                j0Var.getClass();
                ReplaceFileCorruptionHandler replaceFileCorruptionHandler = new ReplaceFileCorruptionHandler(new androidx.room.b(j0Var, 11));
                t7.c b7 = c0.b(hVar);
                c3.p pVar = new c3.p(context, 1);
                t tVar = t.f8724a;
                try {
                    System.loadLibrary("datastore_shared_counter");
                    create = MultiProcessDataStoreFactory.INSTANCE.create(j0Var, replaceFileCorruptionHandler, tVar, b7, pVar);
                } catch (SecurityException | UnsatisfiedLinkError unused) {
                    create = DataStoreFactory.INSTANCE.create(j0Var, replaceFileCorruptionHandler, tVar, b7, pVar);
                }
                if (create != null) {
                    return create;
                }
                com.google.gson.internal.a.i("Cannot return null from a non-@Nullable @Provides method");
                return null;
            case 12:
                return new f3.n((t6.h) ((m6.a) this.f1061b).get(), (h1) ((m6.a) this.f1062l).get(), (DataStore) ((e3.c) this.f1063m).get());
            default:
                return new r.r(new q2.e(2), new q2.e(1), (w.a) ((d0) this.f1061b).get(), (x.g) ((e2.d) this.f1062l).get(), (y2.s) ((y2.s) this.f1063m).get());
        }
    }

    @Override // androidx.viewbinding.ViewBinding
    public View getRoot() {
        switch (this.f1060a) {
            case 25:
                return (LinearLayout) this.f1061b;
            case 26:
                return (LinearLayout) this.f1061b;
            case 27:
                return (RelativeLayout) this.f1061b;
            case 28:
                return (LinearLayout) this.f1061b;
            default:
                return (RelativeLayout) this.f1061b;
        }
    }

    @Override // a4.i
    public void h(Exception exc) {
        MainActivity mainActivity = (MainActivity) this.f1063m;
        int dimension = (int) mainActivity.getResources().getDimension(2131166250);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(dimension, (int) mainActivity.getResources().getDimension(2131166253), dimension, 0);
        RelativeLayout relativeLayout = (RelativeLayout) this.f1061b;
        relativeLayout.setLayoutParams(layoutParams);
        relativeLayout.setVisibility(0);
        ((LinearLayout) this.f1062l).setVisibility(0);
    }

    public LinkedHashMap i() {
        String str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = (JSONObject) this.f1063m;
        if (jSONObject == null) {
            kotlin.jvm.internal.l.i("cmpListJson");
            throw null;
        }
        JSONObject jSONObject2 = jSONObject.getJSONObject("cmps");
        JSONArray names = jSONObject2.names();
        int i = 0;
        int length = names == null ? 0 : names.length();
        while (i < length) {
            int i6 = i + 1;
            if (names == null || (str = names.getString(i)) == null) {
                str = "0";
            }
            JSONObject jSONObject3 = jSONObject2.getJSONObject(str);
            jSONObject3.getInt("id");
            jSONObject3.getString("name").getClass();
            jSONObject3.getBoolean("isCommercial");
            linkedHashMap.put(str, new q1.a(9));
            i = i6;
        }
        return linkedHashMap;
    }

    @Override // k4.a
    public void k(Object obj, int i, int i6, long j) {
        obj.getClass();
    }

    @Override // k4.a
    public void m(File file) {
        file.getClass();
    }

    @Override // k4.a
    public void o(int i, String str, long j, long j6) {
        str.getClass();
    }

    @Override // a4.i
    public void onSuccess() {
        ((RelativeLayout) this.f1061b).setVisibility(0);
        ((LinearLayout) this.f1062l).setVisibility(0);
    }

    @Override // w4.m
    public void p(int i) {
        PublicProfileActivity publicProfileActivity = (PublicProfileActivity) this.f1061b;
        if (publicProfileActivity.T()) {
            if (u2.h(publicProfileActivity) == null) {
                String string = publicProfileActivity.getString(2131952183);
                string.getClass();
                String string2 = publicProfileActivity.getString(2131952182);
                string2.getClass();
                b2.t1.v(publicProfileActivity, string, string2);
                return;
            }
            Object obj = ((u7) ((j5.r) ((s) this.f1062l)).f6707a).f2169b.get(i);
            obj.getClass();
            k2 k2Var = (k2) obj;
            y7 z02 = publicProfileActivity.z0();
            z02.getClass();
            a0 viewModelScope = ViewModelKt.getViewModelScope(z02);
            v7.e eVar = m0.f8288a;
            c0.s(viewModelScope, v7.d.f10884a, null, new b6.g(k2Var, publicProfileActivity, z02, (t6.c) null, 7), 2);
        }
    }

    @Override // w4.m
    public void q(int i) {
        kotlin.jvm.internal.x xVar = (kotlin.jvm.internal.x) this.f1063m;
        PublicProfileActivity publicProfileActivity = (PublicProfileActivity) this.f1061b;
        if (publicProfileActivity.T()) {
            Object obj = ((u7) ((j5.r) ((s) this.f1062l)).f6707a).f2169b.get(i);
            obj.getClass();
            k2 k2Var = (k2) obj;
            String str = k2Var.f11261m;
            w2 w2Var = (w2) xVar.f7024a;
            k2Var.f11259b = w2Var != null ? w2Var.f11431a : null;
            Intent intent = new Intent(publicProfileActivity, (Class<?>) RepliesActivity.class);
            intent.putExtra("review", k2Var);
            intent.putExtra("appId", k2Var.f11262n);
            intent.putExtra("appName", k2Var.f11269u);
            intent.putExtra("appIconUrl", str);
            intent.putExtra("username", k2Var.f11260l);
            w2 w2Var2 = (w2) xVar.f7024a;
            intent.putExtra("userAvatarUrl", w2Var2 != null ? w2Var2.f11433l : null);
            float f = UptodownApp.I;
            publicProfileActivity.startActivity(intent, b4.d.a(publicProfileActivity));
        }
    }

    @Override // k4.a
    public void r(File file) {
        file.getClass();
    }

    @Override // j1.d
    public void s(p pVar) {
        g0.b bVar = (g0.b) this.f1061b;
        String str = (String) this.f1062l;
        ScheduledFuture scheduledFuture = (ScheduledFuture) this.f1063m;
        synchronized (bVar.f5068a) {
            bVar.f5068a.remove(str);
        }
        scheduledFuture.cancel(false);
    }

    public String toString() {
        switch (this.f1060a) {
            case 15:
                StringBuilder sb = new StringBuilder(32);
                sb.append((String) this.f1061b);
                sb.append('{');
                android.support.v4.media.g gVar = (android.support.v4.media.g) ((android.support.v4.media.g) this.f1062l).f248l;
                String str = "";
                while (gVar != null) {
                    Object obj = gVar.f247b;
                    sb.append(str);
                    if (obj == null || !obj.getClass().isArray()) {
                        sb.append(obj);
                    } else {
                        String deepToString = Arrays.deepToString(new Object[]{obj});
                        sb.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                    }
                    gVar = (android.support.v4.media.g) gVar.f248l;
                    str = ", ";
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    @Override // w4.m
    public void u() {
        ((PublicProfileActivity) this.f1061b).w0();
    }

    @Override // k4.a
    public void x(Object obj) {
        obj.getClass();
    }

    @Override // k4.a
    public void y() {
        ((k0) this.f1061b).W((File) this.f1062l, ((q2) this.f1063m).f11350q);
    }

    @Override // w4.m
    public void d(int i) {
    }

    @Override // k4.a
    public void f(DocumentFile documentFile) {
    }

    @Override // k4.a
    public void n(DocumentFile documentFile) {
    }

    public /* synthetic */ m(Object obj, Object obj2, Object obj3, int i) {
        this.f1060a = i;
        this.f1061b = obj;
        this.f1062l = obj2;
        this.f1063m = obj3;
    }

    public /* synthetic */ m(u4 u4Var, String str, Object obj, int i) {
        this.f1060a = i;
        this.f1061b = str;
        this.f1062l = obj;
        this.f1063m = u4Var;
    }

    public m(Application application, Locale locale) {
        this.f1060a = 16;
        this.f1061b = application;
        this.f1062l = locale;
    }

    public m(Context context, t1 t1Var) {
        this.f1060a = 8;
        this.f1063m = new AtomicLong(-1L);
        this.f1062l = new m0.b(context, m0.b.f7267k, new o("measurement:api"), i0.c.f5611c);
        this.f1061b = t1Var;
    }

    public m(com.google.android.gms.internal.measurement.b bVar) {
        this.f1060a = 5;
        this.f1061b = bVar;
        this.f1062l = bVar.clone();
        this.f1063m = new ArrayList();
    }

    public m(Context context, x4.p pVar, m2 m2Var) {
        this.f1060a = 23;
        context.getClass();
        pVar.getClass();
        this.f1061b = context;
        this.f1062l = pVar;
        this.f1063m = m2Var;
    }

    public m(Context context, g5.l lVar) {
        this.f1060a = 0;
        this.f1061b = context;
        this.f1062l = lVar;
        this.f1063m = new x4.j(523, "Games", 4);
    }

    public m(LinearLayout linearLayout, ScrollView scrollView, TextView textView, TextView textView2) {
        this.f1060a = 25;
        this.f1061b = linearLayout;
        this.f1062l = scrollView;
        this.f1063m = textView;
    }

    public m(String str, HashMap hashMap) {
        this.f1060a = 6;
        this.f1061b = str;
        this.f1062l = hashMap;
        this.f1063m = new HashMap();
    }

    public m(String str) {
        this.f1060a = 15;
        android.support.v4.media.g gVar = new android.support.v4.media.g(26, false);
        this.f1062l = gVar;
        this.f1063m = gVar;
        this.f1061b = str;
    }
}
