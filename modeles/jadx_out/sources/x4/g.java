package x4;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements Parcelable {
    public static Parcelable.Creator<g> CREATOR = new i0.l(10);
    public int A;
    public boolean A0;
    public int B;
    public int B0;
    public int C;
    public int C0;
    public int D;
    public ArrayList D0;
    public int E;
    public transient ArrayList E0;
    public String F;
    public ArrayList F0;
    public j G;
    public y1 G0;
    public int H;
    public String H0;
    public String I;
    public int I0;
    public long J;
    public String J0;
    public long K;
    public int L;
    public String M;
    public String N;
    public String O;
    public String P;
    public String Q;
    public String R;
    public ArrayList S;
    public ArrayList T;
    public ArrayList U;
    public String V;
    public String W;
    public ArrayList X;
    public ArrayList Y;
    public f2 Z;

    /* renamed from: a, reason: collision with root package name */
    public long f11158a;
    public String a0;

    /* renamed from: b, reason: collision with root package name */
    public String f11159b;

    /* renamed from: b0, reason: collision with root package name */
    public String f11160b0;

    /* renamed from: c0, reason: collision with root package name */
    public String f11161c0;

    /* renamed from: d0, reason: collision with root package name */
    public int f11162d0;

    /* renamed from: e0, reason: collision with root package name */
    public String f11163e0;

    /* renamed from: f0, reason: collision with root package name */
    public String f11164f0;

    /* renamed from: g0, reason: collision with root package name */
    public String f11165g0;

    /* renamed from: h0, reason: collision with root package name */
    public String f11166h0;

    /* renamed from: i0, reason: collision with root package name */
    public String f11167i0;

    /* renamed from: j0, reason: collision with root package name */
    public String f11168j0;

    /* renamed from: k0, reason: collision with root package name */
    public long f11169k0;

    /* renamed from: l, reason: collision with root package name */
    public String f11170l;

    /* renamed from: l0, reason: collision with root package name */
    public String f11171l0;

    /* renamed from: m, reason: collision with root package name */
    public long f11172m;

    /* renamed from: m0, reason: collision with root package name */
    public String f11173m0;

    /* renamed from: n, reason: collision with root package name */
    public String f11174n;
    public String n0;

    /* renamed from: o, reason: collision with root package name */
    public String f11175o;

    /* renamed from: o0, reason: collision with root package name */
    public int f11176o0;

    /* renamed from: p, reason: collision with root package name */
    public String f11177p;

    /* renamed from: p0, reason: collision with root package name */
    public String f11178p0;

    /* renamed from: q, reason: collision with root package name */
    public String f11179q;

    /* renamed from: q0, reason: collision with root package name */
    public int f11180q0;

    /* renamed from: r, reason: collision with root package name */
    public int f11181r;

    /* renamed from: r0, reason: collision with root package name */
    public String f11182r0;

    /* renamed from: s, reason: collision with root package name */
    public int f11183s;

    /* renamed from: s0, reason: collision with root package name */
    public f f11184s0;

    /* renamed from: t, reason: collision with root package name */
    public String f11185t;

    /* renamed from: t0, reason: collision with root package name */
    public HashMap f11186t0;

    /* renamed from: u, reason: collision with root package name */
    public String f11187u;

    /* renamed from: u0, reason: collision with root package name */
    public int f11188u0;
    public String v;

    /* renamed from: v0, reason: collision with root package name */
    public String f11189v0;

    /* renamed from: w, reason: collision with root package name */
    public String f11190w;

    /* renamed from: w0, reason: collision with root package name */
    public int f11191w0;

    /* renamed from: x, reason: collision with root package name */
    public String f11192x;

    /* renamed from: x0, reason: collision with root package name */
    public boolean f11193x0;

    /* renamed from: y, reason: collision with root package name */
    public int f11194y;

    /* renamed from: y0, reason: collision with root package name */
    public int f11195y0;

    /* renamed from: z, reason: collision with root package name */
    public int f11196z;

    /* renamed from: z0, reason: collision with root package name */
    public int f11197z0;

    public g(Parcel parcel) {
        this.f11172m = -1L;
        this.J = -1L;
        this.K = -1L;
        this.f11184s0 = f.f11148o;
        this.f11186t0 = new HashMap();
        this.F0 = new ArrayList();
        this.I0 = 1;
        this.f11158a = parcel.readLong();
        this.f11159b = parcel.readString();
        this.f11170l = parcel.readString();
        this.f11172m = parcel.readLong();
        this.f11174n = parcel.readString();
        this.f11175o = parcel.readString();
        this.f11177p = parcel.readString();
        this.f11179q = parcel.readString();
        this.f11181r = parcel.readInt();
        this.f11183s = parcel.readInt();
        this.f11185t = parcel.readString();
        this.f11187u = parcel.readString();
        this.v = parcel.readString();
        this.f11190w = parcel.readString();
        this.f11192x = parcel.readString();
        this.f11194y = parcel.readInt();
        this.f11196z = parcel.readInt();
        this.A = parcel.readInt();
        this.B = parcel.readInt();
        this.C = parcel.readInt();
        this.D = parcel.readInt();
        this.E = parcel.readInt();
        this.F = parcel.readString();
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            this.G = (j) parcel.readParcelable(j.class.getClassLoader(), j.class);
        } else {
            this.G = (j) parcel.readParcelable(j.class.getClassLoader());
        }
        this.H = parcel.readInt();
        this.I = parcel.readString();
        this.M = parcel.readString();
        this.N = parcel.readString();
        this.J = parcel.readLong();
        this.L = parcel.readInt();
        this.P = parcel.readString();
        this.Q = parcel.readString();
        this.R = parcel.readString();
        this.S = parcel.createStringArrayList();
        this.T = parcel.createStringArrayList();
        this.U = parcel.createStringArrayList();
        this.V = parcel.readString();
        this.W = parcel.readString();
        this.O = parcel.readString();
        this.f11162d0 = parcel.readInt();
        this.f11165g0 = parcel.readString();
        HashMap readHashMap = parcel.readHashMap(ClassLoader.getSystemClassLoader());
        readHashMap.getClass();
        this.f11186t0 = readHashMap;
        this.f11166h0 = parcel.readString();
        this.f11167i0 = parcel.readString();
        this.f11168j0 = parcel.readString();
        this.f11169k0 = parcel.readLong();
        this.f11171l0 = parcel.readString();
        this.f11176o0 = parcel.readInt();
        this.f11163e0 = parcel.readString();
        this.f11161c0 = parcel.readString();
        this.a0 = parcel.readString();
        this.f11160b0 = parcel.readString();
        this.f11173m0 = parcel.readString();
        this.n0 = parcel.readString();
        this.f11178p0 = parcel.readString();
        this.f11180q0 = parcel.readInt();
        this.f11195y0 = parcel.readInt();
        this.f11197z0 = parcel.readInt();
        this.B0 = parcel.readInt();
        this.D0 = parcel.createStringArrayList();
        this.C0 = parcel.readInt();
        this.f11188u0 = parcel.readInt();
        this.f11189v0 = parcel.readString();
        this.f11191w0 = parcel.readInt();
        parcel.readTypedList(this.F0, j0.CREATOR);
        if (i >= 34) {
            this.G0 = (y1) parcel.readParcelable(y1.class.getClassLoader(), y1.class);
        } else {
            this.G0 = (y1) parcel.readParcelable(y1.class.getClassLoader());
        }
        this.H0 = parcel.readString();
        this.I0 = parcel.readInt();
        this.J0 = parcel.readString();
    }

    public static long c(g2 g2Var) {
        JSONObject jSONObject;
        try {
            if (g2Var.b() || (jSONObject = g2Var.f11206d) == null) {
                return 0L;
            }
            int optInt = !jSONObject.isNull("success") ? jSONObject.optInt("success") : 0;
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optInt != 1 || optJSONObject == null || optJSONObject.isNull("appID")) {
                return 0L;
            }
            return optJSONObject.optLong("appID");
        } catch (JSONException e10) {
            e10.printStackTrace();
            return -1L;
        }
    }

    public final void a(Context context, JSONObject jSONObject) {
        if (jSONObject.has("app")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("app");
            if (optJSONObject != null) {
                n(context, optJSONObject);
            }
        } else {
            n(context, jSONObject);
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("videos");
        if (optJSONArray != null) {
            this.Y = new ArrayList();
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                if (optJSONArray.get(i) instanceof JSONObject) {
                    Object obj = optJSONArray.get(i);
                    obj.getClass();
                    JSONObject jSONObject2 = (JSONObject) obj;
                    d3 d3Var = new d3();
                    if (!jSONObject2.isNull("youtubeID")) {
                        d3Var.f11119a = jSONObject2.optString("youtubeID");
                    }
                    if (!jSONObject2.isNull("image")) {
                        d3Var.f11120b = jSONObject2.optString("image");
                    }
                    ArrayList arrayList = this.Y;
                    arrayList.getClass();
                    arrayList.add(d3Var);
                }
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray("screenshots");
        if (optJSONArray2 != null) {
            this.X = new ArrayList();
            int length2 = optJSONArray2.length();
            for (int i6 = 0; i6 < length2; i6++) {
                if (optJSONArray2.get(i6) instanceof JSONObject) {
                    Object obj2 = optJSONArray2.get(i6);
                    obj2.getClass();
                    JSONObject jSONObject3 = (JSONObject) obj2;
                    l2 l2Var = new l2();
                    if (!jSONObject3.isNull("screenshotURL")) {
                        l2Var.f11277a = jSONObject3.optString("screenshotURL");
                    }
                    if (!jSONObject3.isNull("isVertical")) {
                        l2Var.f11280m = jSONObject3.optInt("isVertical");
                    }
                    ArrayList arrayList2 = this.X;
                    if (arrayList2 != null) {
                        arrayList2.add(l2Var);
                    }
                }
            }
        }
    }

    public final boolean b() {
        return (kotlin.jvm.internal.l.a(this.W, "ReadingMode") || kotlin.jvm.internal.l.a(this.W, "ExternalDownload") || this.f11176o0 <= 1 || kotlin.jvm.internal.l.a(this.W, "AppNotAvailableInThisCountry") || l()) ? false : true;
    }

    public final String d() {
        String str = this.v;
        if (str == null) {
            return null;
        }
        float f = UptodownApp.I;
        int i = UptodownApp.U;
        if (i <= 0) {
            return e();
        }
        return str + ":" + i + ":webp";
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return hashCode();
    }

    public final String e() {
        String str = this.v;
        if (str == null) {
            return null;
        }
        float f = UptodownApp.I;
        return a4.x.k(str, UptodownApp.L, ":webp");
    }

    public final String f() {
        String str = this.v;
        if (str == null) {
            return null;
        }
        float f = UptodownApp.I;
        return a4.x.k(str, UptodownApp.N, ":webp");
    }

    public final String g(int i) {
        if (this.f11187u == null) {
            return null;
        }
        return a4.x.k(this.f11187u, androidx.lifecycle.l.u(i, ":"), ":webp");
    }

    public final String h() {
        String str = this.f11187u;
        if (str == null) {
            return null;
        }
        float f = UptodownApp.I;
        return a4.x.k(str, UptodownApp.K, ":webp");
    }

    public final String i() {
        String str = this.f11187u;
        if (str == null) {
            return null;
        }
        float f = UptodownApp.I;
        return a4.x.k(str, UptodownApp.J, ":webp");
    }

    public final boolean j() {
        return this.J >= 0;
    }

    public final boolean k() {
        String str = this.W;
        return (str == null || str.equals("PreRegister") || str.equals("Discontinued") || str.equals("ExternalDownload") || str.equals("ReadingMode") || str.equals("AppNotAvailableInThisCountry")) ? false : true;
    }

    public final boolean l() {
        return kotlin.jvm.internal.l.a(this.W, "PreRegister");
    }

    public final boolean m() {
        return this.f11188u0 == 1;
    }

    public final void n(Context context, JSONObject jSONObject) {
        JSONObject optJSONObject;
        ArrayList arrayList;
        if (!jSONObject.isNull("appID")) {
            this.f11158a = jSONObject.optLong("appID");
        }
        if (!jSONObject.isNull("name")) {
            this.f11159b = jSONObject.optString("name");
        }
        if (!jSONObject.isNull("license")) {
            this.f11179q = jSONObject.optString("license");
        }
        if (!jSONObject.isNull("lastVersionCode")) {
            this.f11172m = jSONObject.optLong("lastVersionCode");
        }
        if (!jSONObject.isNull("shortDescription")) {
            this.f11175o = jSONObject.optString("shortDescription");
        }
        if (!jSONObject.isNull("iconURL")) {
            this.f11187u = jSONObject.optString("iconURL");
        } else if (!jSONObject.isNull("icon")) {
            this.f11187u = jSONObject.optString("icon");
        }
        if (!jSONObject.isNull("feature")) {
            this.v = jSONObject.optString("feature");
        } else if (!jSONObject.isNull("imageURL")) {
            this.v = jSONObject.optString("imageURL");
        }
        if (!jSONObject.isNull("author")) {
            this.f11190w = jSONObject.optString("author");
        }
        if (!jSONObject.isNull("size")) {
            this.f11177p = jSONObject.optString("size");
        }
        if (!jSONObject.isNull("downloads")) {
            this.f11181r = jSONObject.optInt("downloads");
        }
        if (!jSONObject.isNull("weeklyDownloads")) {
            this.f11183s = jSONObject.optInt("weeklyDownloads");
        }
        if (!jSONObject.isNull("lastUpdate")) {
            this.f11185t = jSONObject.optString("lastUpdate");
        }
        if (!jSONObject.isNull("urlShare")) {
            this.f11174n = jSONObject.optString("urlShare");
        } else if (!jSONObject.isNull("url")) {
            this.f11174n = jSONObject.optString("url");
        }
        if (!jSONObject.isNull("description")) {
            String optString = jSONObject.optString("description");
            optString.getClass();
            this.f11192x = l7.u.o0(optString, "\n", "<br />", false);
        }
        if (!jSONObject.isNull("rating")) {
            this.f11194y = jSONObject.optInt("rating");
        }
        if (!jSONObject.isNull("ratingCount")) {
            this.f11196z = jSONObject.optInt("ratingCount");
        }
        if (!jSONObject.isNull("ratingCount1")) {
            this.A = jSONObject.optInt("ratingCount1");
        }
        if (!jSONObject.isNull("ratingCount2")) {
            this.B = jSONObject.optInt("ratingCount2");
        }
        if (!jSONObject.isNull("ratingCount3")) {
            this.C = jSONObject.optInt("ratingCount3");
        }
        if (!jSONObject.isNull("ratingCount4")) {
            this.D = jSONObject.optInt("ratingCount4");
        }
        if (!jSONObject.isNull("ratingCount5")) {
            this.E = jSONObject.optInt("ratingCount5");
        }
        if (!jSONObject.isNull("packagename")) {
            this.F = jSONObject.optString("packagename");
        } else if (!jSONObject.isNull("packageName")) {
            this.F = jSONObject.optString("packageName");
        }
        JSONObject optJSONObject2 = jSONObject.optJSONObject("categoryData");
        if (optJSONObject2 != null) {
            j jVar = new j(0, (String) null, 7);
            this.G = jVar;
            if (!optJSONObject2.isNull("name")) {
                jVar.f11225b = optJSONObject2.optString("name");
            }
            if (!optJSONObject2.isNull("id")) {
                jVar.f11224a = optJSONObject2.optInt("id");
            }
            if (!optJSONObject2.isNull("isGame")) {
                jVar.f11230p = optJSONObject2.optInt("isGame");
            }
        }
        if (!jSONObject.isNull("permissionCount")) {
            this.H = jSONObject.optInt("permissionCount");
        }
        if (!jSONObject.isNull("md5Signature")) {
            this.M = jSONObject.optString("md5Signature");
        }
        if (!jSONObject.isNull("activeADEX")) {
            this.L = jSONObject.optInt("activeADEX");
        }
        if (!jSONObject.isNull("pegi")) {
            this.O = jSONObject.optString("pegi");
        }
        if (!jSONObject.isNull("technicalData")) {
            this.Q = jSONObject.optString("technicalData");
        }
        if (!jSONObject.isNull("versionRequired")) {
            this.R = jSONObject.optString("versionRequired");
        }
        JSONObject optJSONObject3 = jSONObject.optJSONObject("compatibleFile");
        if (optJSONObject3 != null) {
            JSONArray optJSONArray = optJSONObject3.optJSONArray("densities");
            if (optJSONArray != null) {
                this.S = new ArrayList();
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    ArrayList arrayList2 = this.S;
                    if (arrayList2 != null) {
                        arrayList2.add(optJSONArray.optString(i));
                    }
                }
            }
            JSONArray optJSONArray2 = optJSONObject3.optJSONArray("abis");
            if (optJSONArray2 != null) {
                this.T = new ArrayList();
                int length2 = optJSONArray2.length();
                for (int i6 = 0; i6 < length2; i6++) {
                    ArrayList arrayList3 = this.T;
                    if (arrayList3 != null) {
                        arrayList3.add(optJSONArray2.optString(i6));
                    }
                }
            }
            if (!optJSONObject3.isNull("fileID")) {
                this.J = optJSONObject3.optLong("fileID");
            }
            if (!optJSONObject3.isNull("minSDK")) {
                this.I = optJSONObject3.optString("minSDK");
            }
            if (!optJSONObject3.isNull("fileType")) {
                this.H0 = optJSONObject3.optString("fileType");
            }
            if (!optJSONObject3.isNull("version")) {
                this.f11170l = optJSONObject3.optString("version");
            }
            if (!optJSONObject3.isNull("versionCode")) {
                this.K = optJSONObject3.optLong("versionCode");
            }
            if (!optJSONObject3.isNull("sha256")) {
                this.P = optJSONObject3.optString("sha256");
            }
            if (!optJSONObject3.isNull("url_apk")) {
                this.N = optJSONObject3.optString("url_apk");
            }
            JSONArray optJSONArray3 = optJSONObject3.optJSONArray("requiredFeatures");
            if (optJSONArray3 != null) {
                this.U = new ArrayList();
                int length3 = optJSONArray3.length();
                int i10 = 0;
                while (true) {
                    arrayList = this.U;
                    if (i10 >= length3) {
                        break;
                    }
                    if (arrayList != null) {
                        arrayList.add(optJSONArray3.optString(i10));
                    }
                    i10++;
                }
                arrayList.getClass();
                if (!arrayList.isEmpty() && context != null) {
                    ArrayList arrayList4 = this.U;
                    arrayList4.getClass();
                    ArrayList c9 = p.c(context, arrayList4);
                    if (!c9.isEmpty()) {
                        Iterator it = c9.iterator();
                        it.getClass();
                        while (it.hasNext()) {
                            Object next = it.next();
                            next.getClass();
                            Bundle bundle = new Bundle();
                            bundle.putInt("update", 0);
                            bundle.putString("feature", (String) next);
                            new android.support.v4.media.g(context, 20).E(bundle, "required_features_not_supported");
                        }
                    }
                }
            }
            JSONArray optJSONArray4 = optJSONObject3.optJSONArray("containedFiles");
            if (optJSONArray4 != null) {
                this.F0 = new ArrayList();
                int length4 = optJSONArray4.length();
                for (int i11 = 0; i11 < length4; i11++) {
                    JSONObject jSONObject2 = optJSONArray4.getJSONObject(i11);
                    jSONObject2.getClass();
                    j0 j0Var = new j0();
                    if (!jSONObject2.isNull("fileID")) {
                        j0Var.f11235l = jSONObject2.optLong("fileID");
                    }
                    if (!jSONObject2.isNull(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY)) {
                        j0Var.f11236m = jSONObject2.optString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
                    }
                    if (!jSONObject2.isNull("size")) {
                        j0Var.f11237n = jSONObject2.optLong("size");
                    }
                    if (!jSONObject2.isNull("sha256")) {
                        j0Var.f11239p = jSONObject2.optString("sha256");
                    }
                    this.F0.add(j0Var);
                }
            }
        }
        if (!jSONObject.isNull("website")) {
            this.V = jSONObject.optString("website");
        }
        if (!jSONObject.isNull("downloadStatus")) {
            String optString2 = jSONObject.optString("downloadStatus");
            this.W = optString2;
            if (l7.u.m0(optString2, "PreRegister", false) && (optJSONObject = jSONObject.optJSONObject("preRegister")) != null) {
                if (!optJSONObject.isNull("date")) {
                    this.a0 = optJSONObject.optString("date");
                }
                if (!optJSONObject.isNull("countPreRegistered")) {
                    this.f11160b0 = optJSONObject.optString("countPreRegistered");
                }
            }
        }
        if (!jSONObject.isNull("newFeatures")) {
            this.f11161c0 = jSONObject.optString("newFeatures");
        }
        if (!jSONObject.isNull("onBoard")) {
            this.f11162d0 = jSONObject.optInt("onBoard");
        }
        if (!jSONObject.isNull("responsibilities")) {
            this.f11163e0 = jSONObject.optString("responsibilities");
        }
        if (!jSONObject.isNull(TypedValues.CycleType.S_WAVE_PHASE)) {
            this.f11164f0 = jSONObject.optString(TypedValues.CycleType.S_WAVE_PHASE);
        }
        if (!jSONObject.isNull("deviceType")) {
            this.f11165g0 = jSONObject.optString("deviceType");
        }
        JSONObject optJSONObject4 = jSONObject.optJSONObject("translations");
        if (optJSONObject4 != null) {
            this.f11186t0 = new HashMap();
            if (!optJSONObject4.isNull("try")) {
                HashMap hashMap = this.f11186t0;
                hashMap.getClass();
                hashMap.put("try", optJSONObject4.optString("try"));
            }
            if (!optJSONObject4.isNull("supportedDevice")) {
                HashMap hashMap2 = this.f11186t0;
                hashMap2.getClass();
                hashMap2.put("supportedDevice", optJSONObject4.optString("supportedDevice"));
            }
        }
        if (!jSONObject.isNull("readingModeText")) {
            this.f11166h0 = jSONObject.optString("readingModeText");
        }
        if (!jSONObject.isNull("externalDownloadURL")) {
            this.f11167i0 = jSONObject.optString("externalDownloadURL");
        }
        if (!jSONObject.isNull("externalDownloadText")) {
            this.f11168j0 = jSONObject.optString("externalDownloadText");
        }
        if (!jSONObject.isNull("organizationID")) {
            this.f11169k0 = jSONObject.optLong("organizationID");
        }
        if (!jSONObject.isNull("editorNameNew")) {
            this.f11171l0 = jSONObject.optString("editorNameNew");
        }
        if (!jSONObject.isNull("editorAvatar")) {
            this.f11173m0 = jSONObject.optString("editorAvatar");
        }
        if (!jSONObject.isNull("showReviewedBy")) {
            this.f11180q0 = jSONObject.optInt("showReviewedBy");
        }
        if (!jSONObject.isNull("editorJobTitle")) {
            this.n0 = jSONObject.optString("editorJobTitle");
        }
        if (!jSONObject.isNull("totalVersions")) {
            this.f11176o0 = jSONObject.optInt("totalVersions");
        }
        if (!jSONObject.isNull("disclaimerText")) {
            this.f11178p0 = jSONObject.optString("disclaimerText");
        }
        if (!jSONObject.isNull("tagID")) {
            int optInt = jSONObject.optInt("tagID");
            if (optInt == 0) {
                this.f11184s0 = f.f11148o;
            } else if (optInt == 1) {
                this.f11184s0 = f.f11147n;
            } else if (optInt == 2) {
                this.f11184s0 = f.f11145l;
            } else if (optInt == 3) {
                this.f11184s0 = f.f11143a;
            } else if (optInt == 4) {
                this.f11184s0 = f.f11144b;
            } else if (optInt == 5) {
                this.f11184s0 = f.f11146m;
            }
            if (!jSONObject.isNull("tag")) {
                this.f11182r0 = jSONObject.optString("tag");
            }
        }
        if (!jSONObject.isNull("promoted")) {
            this.f11188u0 = jSONObject.optInt("promoted");
        }
        if (this.f11188u0 == 1 && !jSONObject.isNull("positionPromoted")) {
            this.f11191w0 = jSONObject.optInt("positionPromoted");
        }
        if (!jSONObject.isNull("containsAds")) {
            this.f11195y0 = jSONObject.optInt("containsAds");
        }
        if (!jSONObject.isNull("hasAlternatives")) {
            if (jSONObject.optBoolean("hasAlternatives")) {
                this.f11197z0 = 1;
            } else {
                this.f11197z0 = 0;
            }
        }
        if (!jSONObject.isNull("wishlist")) {
            this.B0 = jSONObject.optInt("wishlist");
        }
        JSONArray optJSONArray5 = jSONObject.optJSONArray("userSays");
        if (optJSONArray5 != null) {
            this.D0 = new ArrayList();
            int length5 = optJSONArray5.length();
            for (int i12 = 0; i12 < length5; i12++) {
                ArrayList arrayList5 = this.D0;
                arrayList5.getClass();
                arrayList5.add(optJSONArray5.getString(i12));
            }
        }
        if (!jSONObject.isNull("recommended-apps")) {
            this.C0 = jSONObject.optInt("recommended-apps");
        }
        JSONObject optJSONObject5 = jSONObject.optJSONObject("ranking");
        if (optJSONObject5 != null) {
            y1 y1Var = new y1();
            if (!optJSONObject5.isNull("text")) {
                y1Var.f11467a = optJSONObject5.optString("text");
            }
            if (!optJSONObject5.isNull("floatingCategoryID")) {
                y1Var.f11468b = optJSONObject5.optInt("floatingCategoryID");
            }
            if (!optJSONObject5.isNull("categoryID")) {
                y1Var.f11469l = optJSONObject5.optInt("categoryID");
            }
            if (!optJSONObject5.isNull("name")) {
                y1Var.f11470m = optJSONObject5.optString("name");
            }
            if (!optJSONObject5.isNull("parentCategoryID")) {
                y1Var.f11471n = optJSONObject5.optInt("parentCategoryID");
            }
            this.G0 = y1Var;
        }
        if (!jSONObject.isNull("ads")) {
            if (jSONObject.optBoolean("ads")) {
                this.I0 = 1;
            } else {
                this.I0 = 0;
            }
        }
        if (jSONObject.isNull("isForYouIf")) {
            return;
        }
        this.J0 = jSONObject.optString("isForYouIf");
    }

    public final String toString() {
        long j = this.f11158a;
        String str = this.f11159b;
        String str2 = this.f11170l;
        long j6 = this.f11172m;
        String str3 = this.f11174n;
        String str4 = this.f11175o;
        String str5 = this.f11177p;
        String str6 = this.f11179q;
        int i = this.f11181r;
        int i6 = this.f11183s;
        String str7 = this.f11185t;
        String str8 = this.f11187u;
        String str9 = this.v;
        String str10 = this.f11190w;
        String str11 = this.f11192x;
        int i10 = this.f11194y;
        int i11 = this.f11196z;
        int i12 = this.A;
        int i13 = this.B;
        int i14 = this.C;
        int i15 = this.D;
        int i16 = this.E;
        String str12 = this.F;
        ArrayList arrayList = this.X;
        j jVar = this.G;
        int i17 = this.H;
        String str13 = this.I;
        String str14 = this.H0;
        String str15 = this.M;
        String str16 = this.N;
        long j10 = this.J;
        ArrayList arrayList2 = this.E0;
        int i18 = this.L;
        String str17 = this.P;
        String str18 = this.Q;
        String str19 = this.R;
        String str20 = this.V;
        String str21 = this.W;
        int i19 = this.f11162d0;
        String str22 = this.f11163e0;
        String str23 = this.f11164f0;
        String str24 = this.f11166h0;
        String str25 = this.f11167i0;
        String str26 = this.f11161c0;
        String str27 = this.a0;
        String str28 = this.f11160b0;
        String str29 = this.f11173m0;
        String str30 = this.n0;
        int i20 = this.f11180q0;
        int i21 = this.f11195y0;
        int i22 = this.f11197z0;
        int i23 = this.B0;
        String str31 = this.f11165g0;
        HashMap hashMap = this.f11186t0;
        ArrayList arrayList3 = this.S;
        ArrayList arrayList4 = this.T;
        ArrayList arrayList5 = this.U;
        String str32 = this.O;
        String str33 = this.f11168j0;
        long j11 = this.f11169k0;
        String str34 = this.f11171l0;
        int i24 = this.f11176o0;
        String str35 = this.f11178p0;
        int i25 = this.f11188u0;
        int i26 = this.I0;
        String str36 = this.f11189v0;
        String str37 = this.J0;
        StringBuilder sb = new StringBuilder("AppInfo(appID=");
        sb.append(j);
        sb.append(", name=");
        sb.append(str);
        sb.append(", versionName=");
        sb.append(str2);
        sb.append(", lastVersionCode=");
        sb.append(j6);
        sb.append(", urlShare=");
        sb.append(str3);
        a4.x.B(sb, ", shortDescription=", str4, ", size=", str5);
        sb.append(", license=");
        sb.append(str6);
        sb.append(", downloads=");
        sb.append(i);
        sb.append(", weeklyDownloads=");
        sb.append(i6);
        sb.append(", lastUpdate=");
        sb.append(str7);
        a4.x.B(sb, ", icon=", str8, ", feature=", str9);
        a4.x.B(sb, ", author=", str10, ", description=", str11);
        sb.append(", rating=");
        sb.append(i10);
        sb.append(", ratingCount=");
        sb.append(i11);
        sb.append(", ratingCount1=");
        sb.append(i12);
        sb.append(", ratingCount2=");
        sb.append(i13);
        sb.append(", ratingCount3=");
        sb.append(i14);
        sb.append(", ratingCount4=");
        sb.append(i15);
        sb.append(", ratingCount5=");
        sb.append(i16);
        sb.append(", packagename=");
        sb.append(str12);
        sb.append(", screenShots=");
        sb.append(arrayList);
        sb.append(", category=");
        sb.append(jVar);
        sb.append(", permissionCount=");
        sb.append(i17);
        sb.append(", minsdk=");
        sb.append(str13);
        a4.x.B(sb, ", fileType=", str14, ", md5signature=", str15);
        sb.append(", downloadUrl=");
        sb.append(str16);
        sb.append(", fileID=");
        sb.append(j10);
        sb.append(", oldVersions=");
        sb.append(arrayList2);
        sb.append(", activeADEX=");
        sb.append(i18);
        sb.append(", sha256=");
        sb.append(str17);
        a4.x.B(sb, ", technicalData=", str18, ", versionRequired=", str19);
        a4.x.B(sb, ", webAuthor=", str20, ", downloadStatus=", str21);
        sb.append(", devOnBoard=");
        sb.append(i19);
        sb.append(", responsibilities=");
        sb.append(str22);
        a4.x.B(sb, ", phase=", str23, ", readingModeText=", str24);
        a4.x.B(sb, ", externalDownloadUrl=", str25, ", newFeatures=", str26);
        a4.x.B(sb, ", preRegisterDate=", str27, ", preRegistersCount=", str28);
        a4.x.B(sb, ", editorAvatar=", str29, ", editorJobTitle=", str30);
        sb.append(", showReviewedBy=");
        sb.append(i20);
        sb.append(", containAds=");
        sb.append(i21);
        sb.append(", hasAlternatives=");
        sb.append(i22);
        sb.append(", wishlist=");
        sb.append(i23);
        sb.append(", deviceType=");
        sb.append(str31);
        sb.append(", translations=");
        sb.append(hashMap);
        sb.append(", supportedDensities=");
        sb.append(arrayList3);
        sb.append(", supportedAbis=");
        sb.append(arrayList4);
        sb.append(", requiredFeatures=");
        sb.append(arrayList5);
        sb.append(", pegi=");
        sb.append(str32);
        sb.append(", externalDownloadText=");
        sb.append(str33);
        sb.append(", organizationID=");
        sb.append(j11);
        sb.append(", editorName=");
        sb.append(str34);
        sb.append(", totalVersions=");
        sb.append(i24);
        sb.append(", disclaimerText=");
        sb.append(str35);
        sb.append(", promoted=");
        sb.append(i25);
        sb.append(", showAds=");
        sb.append(i26);
        a4.x.B(sb, ", promotedFrom=", str36, ", isForYouIf=", str37);
        sb.append(")");
        return sb.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.getClass();
        parcel.writeLong(this.f11158a);
        parcel.writeString(this.f11159b);
        parcel.writeString(this.f11170l);
        parcel.writeLong(this.f11172m);
        parcel.writeString(this.f11174n);
        parcel.writeString(this.f11175o);
        parcel.writeString(this.f11177p);
        parcel.writeString(this.f11179q);
        parcel.writeInt(this.f11181r);
        parcel.writeInt(this.f11183s);
        parcel.writeString(this.f11185t);
        parcel.writeString(this.f11187u);
        parcel.writeString(this.v);
        parcel.writeString(this.f11190w);
        parcel.writeString(this.f11192x);
        parcel.writeInt(this.f11194y);
        parcel.writeInt(this.f11196z);
        parcel.writeInt(this.A);
        parcel.writeInt(this.B);
        parcel.writeInt(this.C);
        parcel.writeInt(this.D);
        parcel.writeInt(this.E);
        parcel.writeString(this.F);
        parcel.writeParcelable(this.G, i);
        parcel.writeInt(this.H);
        parcel.writeString(this.I);
        parcel.writeString(this.M);
        parcel.writeString(this.N);
        parcel.writeLong(this.J);
        parcel.writeInt(this.L);
        parcel.writeString(this.P);
        parcel.writeString(this.Q);
        parcel.writeString(this.R);
        parcel.writeStringList(this.S);
        parcel.writeStringList(this.T);
        parcel.writeStringList(this.U);
        parcel.writeString(this.V);
        parcel.writeString(this.W);
        parcel.writeString(this.O);
        parcel.writeInt(this.f11162d0);
        parcel.writeString(this.f11165g0);
        parcel.writeMap(this.f11186t0);
        parcel.writeString(this.f11166h0);
        parcel.writeString(this.f11167i0);
        parcel.writeString(this.f11168j0);
        parcel.writeLong(this.f11169k0);
        parcel.writeString(this.f11171l0);
        parcel.writeInt(this.f11176o0);
        parcel.writeString(this.f11163e0);
        parcel.writeString(this.f11161c0);
        parcel.writeString(this.a0);
        parcel.writeString(this.f11160b0);
        parcel.writeString(this.f11173m0);
        parcel.writeString(this.n0);
        parcel.writeString(this.f11178p0);
        parcel.writeInt(this.f11180q0);
        parcel.writeInt(this.f11195y0);
        parcel.writeInt(this.f11197z0);
        parcel.writeInt(this.B0);
        parcel.writeStringList(this.D0);
        parcel.writeInt(this.C0);
        parcel.writeInt(this.f11188u0);
        parcel.writeString(this.f11189v0);
        parcel.writeInt(this.f11191w0);
        parcel.writeTypedList(this.F0);
        parcel.writeParcelable(this.G0, i);
        parcel.writeString(this.H0);
        parcel.writeInt(this.I0);
        parcel.writeString(this.J0);
    }

    public g() {
        this.f11172m = -1L;
        this.J = -1L;
        this.K = -1L;
        this.f11184s0 = f.f11148o;
        this.f11186t0 = new HashMap();
        this.F0 = new ArrayList();
        this.I0 = 1;
    }
}
