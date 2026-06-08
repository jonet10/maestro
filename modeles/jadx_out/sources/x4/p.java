package x4;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public String f11312a;

    /* renamed from: b, reason: collision with root package name */
    public String f11313b;

    /* renamed from: c, reason: collision with root package name */
    public String f11314c;

    /* renamed from: d, reason: collision with root package name */
    public String f11315d;

    /* renamed from: e, reason: collision with root package name */
    public String f11316e;
    public String f;
    public int g;
    public int h;
    public int i;
    public float j;

    /* renamed from: k, reason: collision with root package name */
    public String f11317k;

    /* renamed from: l, reason: collision with root package name */
    public long f11318l;

    /* renamed from: m, reason: collision with root package name */
    public String[] f11319m;

    /* renamed from: n, reason: collision with root package name */
    public String[] f11320n;

    /* renamed from: o, reason: collision with root package name */
    public String[] f11321o;

    /* renamed from: p, reason: collision with root package name */
    public String f11322p;

    /* renamed from: q, reason: collision with root package name */
    public int f11323q;

    /* renamed from: r, reason: collision with root package name */
    public String f11324r;

    /* renamed from: s, reason: collision with root package name */
    public int f11325s;

    /* renamed from: t, reason: collision with root package name */
    public String f11326t;

    /* renamed from: u, reason: collision with root package name */
    public int f11327u;

    public static ArrayList c(Context context, ArrayList arrayList) {
        arrayList.getClass();
        context.getClass();
        ArrayList arrayList2 = new ArrayList();
        if (!arrayList.isEmpty()) {
            String[] systemSharedLibraryNames = context.getPackageManager().getSystemSharedLibraryNames();
            Iterator it = arrayList.iterator();
            it.getClass();
            while (it.hasNext()) {
                Object next = it.next();
                next.getClass();
                String str = (String) next;
                boolean hasSystemFeature = context.getPackageManager().hasSystemFeature(str);
                if (!hasSystemFeature && str.equalsIgnoreCase("android.hardware.ram.low")) {
                    hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.ram.normal");
                }
                boolean z9 = false;
                if (!hasSystemFeature && systemSharedLibraryNames != null) {
                    int i = 0;
                    while (true) {
                        if (!(i < systemSharedLibraryNames.length)) {
                            break;
                        }
                        int i6 = i + 1;
                        try {
                            if (str.equalsIgnoreCase(systemSharedLibraryNames[i])) {
                                z9 = true;
                                break;
                            }
                            i = i6;
                        } catch (ArrayIndexOutOfBoundsException e10) {
                            androidx.privacysandbox.ads.adservices.customaudience.a.s(e10.getMessage());
                            return null;
                        }
                    }
                }
                if (!hasSystemFeature && !z9) {
                    arrayList2.add(str);
                }
            }
        }
        return arrayList2;
    }

    public final String a() {
        String str = this.f11312a + this.g;
        String str2 = this.f11313b;
        if (str2 != null) {
            str = str.concat(str2);
        }
        String str3 = this.f11314c;
        if (str3 != null) {
            str = str.concat(str3);
        }
        Charset forName = Charset.forName("UTF-8");
        forName.getClass();
        byte[] bytes = str.getBytes(forName);
        bytes.getClass();
        return z3.w(bytes);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0045, code lost:
    
        if (r0.equals("0") != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(java.lang.String r6) {
        /*
            r5 = this;
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>(r6)
            java.lang.String r6 = "success"
            boolean r1 = r0.isNull(r6)
            r2 = 0
            if (r1 != 0) goto L79
            int r6 = r0.optInt(r6)
            r1 = 1
            if (r6 != r1) goto L79
            java.lang.String r6 = "data"
            org.json.JSONObject r6 = r0.optJSONObject(r6)
            if (r6 == 0) goto L79
            java.lang.String r0 = "sdk"
            boolean r3 = r6.isNull(r0)
            if (r3 != 0) goto L2f
            int r3 = r5.g
            int r0 = r6.optInt(r0)
            if (r3 != r0) goto L2f
            r0 = r1
            goto L30
        L2f:
            r0 = r2
        L30:
            if (r0 == 0) goto L78
            java.lang.String r0 = "userID"
            boolean r3 = r6.isNull(r0)
            r4 = 0
            if (r3 != 0) goto L47
            java.lang.String r0 = r6.optString(r0)
            java.lang.String r3 = "0"
            boolean r3 = r0.equals(r3)
            if (r3 == 0) goto L48
        L47:
            r0 = r4
        L48:
            java.lang.String r3 = r5.f11313b
            if (r0 != 0) goto L50
            if (r3 == 0) goto L50
        L4e:
            r0 = r2
            goto L59
        L50:
            if (r0 == 0) goto L55
            if (r3 != 0) goto L55
            goto L4e
        L55:
            boolean r0 = l7.u.m0(r0, r3, r1)
        L59:
            if (r0 == 0) goto L78
            java.lang.String r0 = "language"
            boolean r3 = r6.isNull(r0)
            if (r3 != 0) goto L67
            java.lang.String r4 = r6.optString(r0)
        L67:
            java.lang.String r6 = r5.f11314c
            if (r4 != 0) goto L6e
            if (r6 == 0) goto L6e
            goto L79
        L6e:
            if (r4 == 0) goto L73
            if (r6 != 0) goto L73
            goto L79
        L73:
            boolean r6 = l7.u.m0(r4, r6, r1)
            return r6
        L78:
            return r0
        L79:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.p.b(java.lang.String):boolean");
    }

    public final boolean d(r rVar) {
        List list;
        String str = rVar.f11364t;
        if (str == null || this.f11319m == null) {
            return true;
        }
        Pattern compile = Pattern.compile(",");
        compile.getClass();
        Matcher matcher = compile.matcher(str);
        if (matcher.find()) {
            ArrayList arrayList = new ArrayList(10);
            int i = 0;
            do {
                arrayList.add(str.subSequence(i, matcher.start()).toString());
                i = matcher.end();
            } while (matcher.find());
            arrayList.add(str.subSequence(i, str.length()).toString());
            list = arrayList;
        } else {
            list = a.a.H(str.toString());
        }
        String[] strArr = (String[]) list.toArray(new String[0]);
        String[] strArr2 = this.f11319m;
        strArr2.getClass();
        int length = strArr2.length;
        int i6 = 0;
        while (true) {
            if (i6 >= length) {
                break;
            }
            if (!l7.u.m0(strArr2[i6], "arm64-v8a", true)) {
                i6++;
            } else if (Build.VERSION.SDK_INT > 34) {
                boolean z9 = false;
                for (String str2 : strArr) {
                    if (l7.u.m0(str2, "arm64-v8a", true)) {
                        z9 = true;
                    }
                }
                return z9;
            }
        }
        String[] strArr3 = this.f11319m;
        strArr3.getClass();
        boolean z10 = false;
        for (String str3 : strArr3) {
            if (z10) {
                break;
            }
            for (String str4 : strArr) {
                if (l7.u.m0(str4, "universal", true) || l7.u.m0(str3, str4, true)) {
                    z10 = true;
                    break;
                }
            }
        }
        return z10;
    }

    public final boolean e(r rVar) {
        ArrayList arrayList = rVar.f11368y;
        if (arrayList == null || arrayList.size() <= 0) {
            return true;
        }
        ArrayList arrayList2 = rVar.f11368y;
        arrayList2.getClass();
        Iterator it = arrayList2.iterator();
        it.getClass();
        while (it.hasNext()) {
            Object next = it.next();
            next.getClass();
            String str = (String) next;
            if (Integer.parseInt(str) == this.f11325s || Integer.parseInt(str) == 65534 || Integer.parseInt(str) == 65535) {
                return true;
            }
        }
        return false;
    }

    public final void f(Context context) {
        context.getClass();
        this.f11312a = Settings.Secure.getString(context.getContentResolver(), "android_id");
        w2 h = u2.h(context);
        if ((h != null ? h.f11431a : null) != null) {
            this.f11313b = h.f11431a;
        } else {
            this.f11313b = null;
        }
        this.g = Build.VERSION.SDK_INT;
        boolean z9 = false;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("CoreSettings", 0);
            if (sharedPreferences.contains("device_rooted")) {
                z9 = sharedPreferences.getBoolean("device_rooted", false);
            }
        } catch (Exception unused) {
        }
        if (z9) {
            this.f11323q = 1;
        }
    }

    public final void g(Context context) {
        context.getClass();
        f(context);
        this.h = context.getResources().getDisplayMetrics().widthPixels;
        this.i = context.getResources().getDisplayMetrics().heightPixels;
        this.j = context.getResources().getDisplayMetrics().density;
        this.f11325s = context.getResources().getDisplayMetrics().densityDpi;
        this.f11326t = context.getString(2131951977);
        this.f11314c = Locale.getDefault().getLanguage();
        this.f11315d = Build.BRAND;
        this.f = Build.MANUFACTURER;
        this.f11316e = Build.MODEL;
        Object systemService = context.getSystemService("phone");
        systemService.getClass();
        this.f11317k = ((TelephonyManager) systemService).getNetworkOperatorName();
        try {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            Object systemService2 = context.getSystemService("activity");
            systemService2.getClass();
            ((ActivityManager) systemService2).getMemoryInfo(memoryInfo);
            this.f11318l = memoryInfo.totalMem;
        } catch (Error e10) {
            e10.getMessage();
        } catch (Exception e11) {
            e11.getMessage();
        }
        this.f11319m = Build.SUPPORTED_ABIS;
        this.f11320n = Build.SUPPORTED_32_BIT_ABIS;
        this.f11321o = Build.SUPPORTED_64_BIT_ABIS;
        this.f11322p = context.getString(2131952765, context.getString(2131951718), "7.28", "728");
        this.f11324r = Build.HARDWARE;
        float f = UptodownApp.I;
        if (b4.d.n(context)) {
            this.f11327u = 1;
        } else {
            this.f11327u = 0;
        }
    }

    public final JSONObject h() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("identifier", this.f11312a);
        jSONObject.put("userID", this.f11313b);
        jSONObject.put("country", z3.g);
        jSONObject.put("language", this.f11314c);
        jSONObject.put("brand", this.f11315d);
        jSONObject.put("model", this.f11316e);
        jSONObject.put("manufacturer", this.f);
        int i = this.g;
        if (i > 0) {
            jSONObject.put("sdk", i);
        }
        int i6 = this.h;
        if (i6 > 0) {
            jSONObject.put("displayWidth", i6);
        }
        int i10 = this.i;
        if (i10 > 0) {
            jSONObject.put("displayHeight", i10);
        }
        float f = this.j;
        if (f > 0.0f) {
            jSONObject.put("displayDensity", f);
        }
        String str = this.f11326t;
        if (str != null && str.length() > 0) {
            jSONObject.put("density", this.f11326t);
        }
        long j = this.f11318l;
        if (j > 0) {
            jSONObject.put("ram", j);
        }
        jSONObject.put("operador", this.f11317k);
        String[] strArr = this.f11319m;
        if (strArr != null && strArr.length != 0) {
            JSONArray jSONArray = new JSONArray();
            int i11 = 0;
            while (true) {
                if (!(i11 < strArr.length)) {
                    break;
                }
                int i12 = i11 + 1;
                try {
                    jSONArray.put(strArr[i11]);
                    i11 = i12;
                } catch (ArrayIndexOutOfBoundsException e10) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.s(e10.getMessage());
                    return null;
                }
            }
            jSONObject.put("supportedABIs", jSONArray);
        }
        String[] strArr2 = this.f11320n;
        if (strArr2 != null && strArr2.length != 0) {
            JSONArray jSONArray2 = new JSONArray();
            int i13 = 0;
            while (true) {
                if (!(i13 < strArr2.length)) {
                    break;
                }
                int i14 = i13 + 1;
                try {
                    jSONArray2.put(strArr2[i13]);
                    i13 = i14;
                } catch (ArrayIndexOutOfBoundsException e11) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.s(e11.getMessage());
                    return null;
                }
            }
            jSONObject.put("supported32BitsABIs", jSONArray2);
        }
        String[] strArr3 = this.f11321o;
        if (strArr3 != null && strArr3.length != 0) {
            JSONArray jSONArray3 = new JSONArray();
            int i15 = 0;
            while (true) {
                if (!(i15 < strArr3.length)) {
                    break;
                }
                int i16 = i15 + 1;
                try {
                    jSONArray3.put(strArr3[i15]);
                    i15 = i16;
                } catch (ArrayIndexOutOfBoundsException e12) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.s(e12.getMessage());
                    return null;
                }
            }
            jSONObject.put("supported64BitsABIs", jSONArray3);
        }
        jSONObject.put("appVersion", this.f11322p);
        jSONObject.put("rooted", this.f11323q);
        jSONObject.put("isTV", this.f11327u);
        return jSONObject;
    }

    public final String toString() {
        String str = this.f11312a;
        String str2 = this.f11313b;
        String str3 = this.f11314c;
        String str4 = this.f11315d;
        String str5 = this.f11316e;
        String str6 = this.f;
        int i = this.g;
        int i6 = this.h;
        int i10 = this.i;
        float f = this.j;
        int i11 = this.f11325s;
        String str7 = this.f11326t;
        String str8 = this.f11317k;
        long j = this.f11318l;
        String arrays = Arrays.toString(this.f11319m);
        arrays.getClass();
        String arrays2 = Arrays.toString(this.f11320n);
        arrays2.getClass();
        String arrays3 = Arrays.toString(this.f11321o);
        arrays3.getClass();
        String str9 = this.f11322p;
        int i12 = this.f11323q;
        String str10 = this.f11324r;
        int i13 = this.f11327u;
        StringBuilder sb = new StringBuilder("DeviceInfo(identifier=");
        sb.append(str);
        sb.append(", userId=");
        sb.append(str2);
        sb.append(", language=");
        a4.x.B(sb, str3, ", brand=", str4, ", model=");
        a4.x.B(sb, str5, ", manufacturer=", str6, ", sdk=");
        sb.append(i);
        sb.append(", displayWidth=");
        sb.append(i6);
        sb.append(", displayHeight=");
        sb.append(i10);
        sb.append(", displayDensity=");
        sb.append(f);
        sb.append(", densityDpi=");
        sb.append(i11);
        sb.append(", density=");
        sb.append(str7);
        sb.append(", operador=");
        sb.append(str8);
        sb.append(", ram=");
        sb.append(j);
        a4.x.B(sb, ", supportedAbis=", arrays, ", supported32BitsAbis=", arrays2);
        a4.x.B(sb, ", supported64BitsAbis=", arrays3, ", appVersion=", str9);
        sb.append(", rooted=");
        sb.append(i12);
        sb.append(", hardware=");
        sb.append(str10);
        sb.append(", isTv=");
        sb.append(i13);
        sb.append(")");
        return sb.toString();
    }
}
