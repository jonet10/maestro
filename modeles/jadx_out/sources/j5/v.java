package j5;

import a4.x;
import android.content.Context;
import android.content.pm.PackageManager;
import android.provider.Settings;
import androidx.browser.trusted.sharing.ShareTarget;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.google.android.gms.internal.measurement.z3;
import com.uptodown.UptodownApp;
import com.uptodown.util.NativeApiKey;
import e1.x0;
import j$.util.Base64;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import x4.g2;
import x4.k2;
import x4.u2;
import x4.w2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v {

    /* renamed from: b, reason: collision with root package name */
    public static final Object f6711b = new Object();

    /* renamed from: c, reason: collision with root package name */
    public static String f6712c;

    /* renamed from: d, reason: collision with root package name */
    public static long f6713d;

    /* renamed from: a, reason: collision with root package name */
    public final Context f6714a;

    public v(Context context) {
        context.getClass();
        this.f6714a = context;
    }

    public static void B() {
        synchronized (f6711b) {
            f6712c = null;
            f6713d = 0L;
        }
    }

    public static ArrayList E(g2 g2Var) {
        JSONObject jSONObject;
        ArrayList arrayList = new ArrayList();
        if (!g2Var.b() && (jSONObject = g2Var.f11206d) != null) {
            JSONArray optJSONArray = jSONObject.optJSONArray("data");
            JSONObject jSONObject2 = g2Var.f11206d;
            jSONObject2.getClass();
            if (jSONObject2.optInt("success") == 1 && optJSONArray != null) {
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    optJSONObject.getClass();
                    x4.g gVar = new x4.g();
                    gVar.a(null, optJSONObject);
                    arrayList.add(gVar);
                }
            }
        }
        return arrayList;
    }

    public static HashMap g() {
        HashMap hashMap = new HashMap();
        String str = z3.g;
        if (str != null && str.length() != 0) {
            String str2 = z3.g;
            str2.getClass();
            hashMap.put("countryIsoCode", str2);
        }
        return hashMap;
    }

    public static String n(HashMap hashMap) {
        StringBuilder sb = new StringBuilder();
        boolean z9 = true;
        for (Map.Entry entry : hashMap.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (z9) {
                z9 = false;
            } else {
                sb.append("&");
            }
            sb.append(URLEncoder.encode(str, "UTF-8"));
            sb.append("=");
            sb.append(URLEncoder.encode(str2, "UTF-8"));
        }
        return sb.toString();
    }

    public final g2 A(long j) {
        g2 k5 = k(k0.k.g(j, "https://www.uptodown.app:443/eapi/apps/", "/video"), null, ShareTarget.METHOD_GET, false);
        k5.f11206d = i(k5, "/eapi/apps/appId/video");
        return k5;
    }

    public final void C(long j, String str, String str2, int i) {
        str2.getClass();
        HashMap hashMap = new HashMap();
        hashMap.put("appID", String.valueOf(j));
        hashMap.put(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
        hashMap.put(TypedValues.TransitionType.S_FROM, str2);
        hashMap.put("position", String.valueOf(i));
        hashMap.putAll(g());
        g2 k5 = k("https://www.uptodown.app:443".concat("/eapi/promo-track"), hashMap, ShareTarget.METHOD_POST, false);
        k5.f11206d = i(k5, "/eapi/promo-track");
    }

    public final g2 D(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EMAIL, str);
        hashMap.put("password", str2);
        Context context = this.f6714a;
        context.getClass();
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (string != null) {
            hashMap.put("deviceIdentifier", string);
        }
        g2 k5 = k("https://www.uptodown.app:443".concat("/eapi/v2/user/login"), hashMap, ShareTarget.METHOD_POST, false);
        if (k5.b()) {
            k5.f11206d = j(k5, "/eapi/v2/user/login");
            return k5;
        }
        k5.f11206d = i(k5, "/eapi/v2/user/login");
        return k5;
    }

    public final g2 F(long j, k2 k2Var) {
        String str;
        Context context = this.f6714a;
        HashMap hashMap = new HashMap();
        String str2 = k2Var.f11263o;
        if (str2 != null && str2.length() > 0) {
            String str3 = k2Var.f11263o;
            str3.getClass();
            hashMap.put("text", str3);
        }
        hashMap.put("rating", String.valueOf(k2Var.f11264p));
        try {
            PackageManager packageManager = context.getPackageManager();
            packageManager.getClass();
            String packageName = context.getPackageName();
            packageName.getClass();
            str = " " + n4.i.e(packageManager, packageName, 0).versionName;
        } catch (Exception e10) {
            e10.printStackTrace();
            str = "";
        }
        hashMap.put("uagent", "uptodownandroid".concat(str));
        w2 h = u2.h(context);
        if ((h != null ? h.f11431a : null) != null) {
            String str4 = h.f11431a;
            str4.getClass();
            hashMap.put("id_user", str4);
        }
        g2 k5 = k(k0.k.g(j, "https://www.uptodown.app:443/eapi/apps/", "/comments"), hashMap, ShareTarget.METHOD_POST, false);
        k5.f11206d = i(k5, "/eapi/apps/appId/comments/post");
        return k5;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0212 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final x4.g2 G(java.lang.String r18, java.util.ArrayList r19, boolean r20) {
        /*
            Method dump skipped, instructions count: 583
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.v.G(java.lang.String, java.util.ArrayList, boolean):x4.g2");
    }

    public final g2 H(int i, int i6, String str) {
        String str2;
        UnsupportedEncodingException e10;
        String str3;
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i));
        hashMap.put("page[offset]", String.valueOf(i6));
        hashMap.putAll(g());
        try {
            Pattern compile = Pattern.compile("\\n");
            compile.getClass();
            str2 = compile.matcher(str).replaceAll(" ");
            str2.getClass();
            try {
                int length = str2.length() - 1;
                int i10 = 0;
                boolean z9 = false;
                while (i10 <= length) {
                    boolean z10 = kotlin.jvm.internal.l.c(str2.charAt(!z9 ? i10 : length), 32) <= 0;
                    if (z9) {
                        if (!z10) {
                            break;
                        }
                        length--;
                    } else if (z10) {
                        i10++;
                    } else {
                        z9 = true;
                    }
                }
                str3 = URLEncoder.encode(str2.subSequence(i10, length + 1).toString(), "UTF-8");
            } catch (UnsupportedEncodingException e11) {
                e10 = e11;
                e10.printStackTrace();
                str3 = str2;
                g2 k5 = k(x.j("https://www.uptodown.app:443/eapi/v2/apps/search/", str3), hashMap, ShareTarget.METHOD_GET, false);
                k5.f11206d = i(k5, "/eapi/v2/apps/search");
                return k5;
            }
        } catch (UnsupportedEncodingException e12) {
            str2 = null;
            e10 = e12;
        }
        g2 k52 = k(x.j("https://www.uptodown.app:443/eapi/v2/apps/search/", str3), hashMap, ShareTarget.METHOD_GET, false);
        k52.f11206d = i(k52, "/eapi/v2/apps/search");
        return k52;
    }

    public final g2 I(String str) {
        str.getClass();
        HashMap hashMap = new HashMap();
        hashMap.put("fcmToken", str);
        Context context = this.f6714a;
        context.getClass();
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (string != null) {
            hashMap.put("identifier", string);
        }
        g2 k5 = k("https://www.uptodown.app:443".concat("/eapi/v3/device/fcm-token"), hashMap, ShareTarget.METHOD_POST, false);
        k5.f11206d = i(k5, "/eapi/v3/device/fcm-token");
        return k5;
    }

    public final g2 J(String str) {
        str.getClass();
        HashMap hashMap = new HashMap();
        hashMap.put("provider", "google");
        hashMap.put("accessToken", str);
        Context context = this.f6714a;
        context.getClass();
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (string != null) {
            hashMap.put("deviceIdentifier", string);
        }
        g2 k5 = k("https://www.uptodown.app:443".concat("/eapi/user/usertokenSignup"), hashMap, ShareTarget.METHOD_POST, false);
        if (k5.b()) {
            k5.f11206d = j(k5, "/eapi/user/usertokenSignup");
            return k5;
        }
        k5.f11206d = i(k5, "/eapi/user/usertokenSignup");
        return k5;
    }

    public final g2 a(long j) {
        g2 k5 = k(k0.k.g(j, "https://www.uptodown.app:443/eapi/app/", "/pre-register/add"), g(), ShareTarget.METHOD_POST, false);
        k5.f11206d = i(k5, "/eapi/app/appID/pre-register/add");
        return k5;
    }

    public final g2 b(long j) {
        g2 k5 = k(k0.k.g(j, "https://www.uptodown.app:443/eapi/app/", "/pre-register/cancel"), g(), ShareTarget.METHOD_POST, false);
        k5.f11206d = i(k5, "/eapi/app/appID/pre-register/cancel");
        return k5;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(7:5|(3:9|10|(5:12|13|14|15|16))|23|13|14|15|16) */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0059, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x005a, code lost:
    
        r0.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean c(x4.g2 r10) {
        /*
            r9 = this;
            java.lang.String r0 = "seconds"
            r10.getClass()
            boolean r1 = r10.b()
            r2 = 0
            if (r1 == 0) goto L6d
            int r1 = r10.f11204b
            r3 = 503(0x1f7, float:7.05E-43)
            if (r1 != r3) goto L6c
            java.lang.String r1 = r10.f11203a
            if (r1 == 0) goto L36
            int r1 = r1.length()
            if (r1 != 0) goto L1d
            goto L36
        L1d:
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Exception -> L32
            java.lang.String r10 = r10.f11203a     // Catch: java.lang.Exception -> L32
            r10.getClass()     // Catch: java.lang.Exception -> L32
            r1.<init>(r10)     // Catch: java.lang.Exception -> L32
            boolean r10 = r1.isNull(r0)     // Catch: java.lang.Exception -> L32
            if (r10 != 0) goto L36
            long r0 = r1.optLong(r0)     // Catch: java.lang.Exception -> L32
            goto L38
        L32:
            r10 = move-exception
            r10.printStackTrace()
        L36:
            r0 = 7200(0x1c20, double:3.5573E-320)
        L38:
            android.content.Context r10 = r9.f6714a
            r10.getClass()
            java.lang.String r3 = "SharedPreferencesTracking"
            android.content.SharedPreferences r3 = r10.getSharedPreferences(r3, r2)     // Catch: java.lang.Exception -> L59
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch: java.lang.Exception -> L59
            java.lang.String r4 = "maintenance_time"
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L59
            r7 = 1000(0x3e8, float:1.401E-42)
            long r7 = (long) r7     // Catch: java.lang.Exception -> L59
            long r0 = r0 * r7
            long r0 = r0 + r5
            r3.putLong(r4, r0)     // Catch: java.lang.Exception -> L59
            r3.apply()     // Catch: java.lang.Exception -> L59
            goto L5d
        L59:
            r0 = move-exception
            r0.printStackTrace()
        L5d:
            e1.c0 r0 = j5.g.D
            j5.g r10 = r0.l(r10)
            r10.b()
            r10.u()
            r10.c()
        L6c:
            return r2
        L6d:
            java.lang.String r10 = r10.f11203a
            r0 = 1
            if (r10 == 0) goto L78
            int r10 = r10.length()
            if (r10 != 0) goto L79
        L78:
            r2 = r0
        L79:
            r10 = r2 ^ 1
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.v.c(x4.g2):boolean");
    }

    public final String d() {
        HashMap hashMap = new HashMap();
        float f = UptodownApp.I;
        String authApikey = NativeApiKey.f3448a.getAuthApikey();
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        valueOf.getClass();
        authApikey.getClass();
        Mac mac = Mac.getInstance("HmacSHA256");
        Charset charset = l7.a.f7151a;
        byte[] bytes = authApikey.getBytes(charset);
        bytes.getClass();
        mac.init(new SecretKeySpec(bytes, "HmacSHA256"));
        byte[] bytes2 = valueOf.getBytes(charset);
        bytes2.getClass();
        byte[] doFinal = mac.doFinal(bytes2);
        doFinal.getClass();
        hashMap.put("hmac", q6.j.k0(doFinal, "", new androidx.room.f(27), 30));
        hashMap.put("unixtime", valueOf);
        g2 k5 = k("https://www.uptodown.app:443".concat("/eapi/auth/token"), hashMap, ShareTarget.METHOD_POST, false);
        if (k5.f11204b == 200 && k5.f11203a != null) {
            String str = k5.f11203a;
            str.getClass();
            JSONObject jSONObject = new JSONObject(str);
            r3 = jSONObject.isNull("token") ? null : jSONObject.getString("token");
            f6712c = r3;
            if (r3 != null) {
                byte[] decode = Base64.getUrlDecoder().decode((String) l7.m.G0(r3, new String[]{"."}).get(1));
                decode.getClass();
                f6713d = new JSONObject(new String(decode, charset)).getLong("exp");
            }
        }
        return r3;
    }

    public final g2 e(String str) {
        str.getClass();
        g2 k5 = k("https://www.uptodown.app:443/eapi/apps/byPackagename/".concat(str), null, ShareTarget.METHOD_GET, false);
        k5.f11206d = i(k5, "/eapi/apps/byPackagename");
        return k5;
    }

    public final g2 f(int i) {
        String g = x.g(i, "/eapi/v2/categories/", "/leaf-categories");
        g2 k5 = k("https://www.uptodown.app:443".concat(g), null, ShareTarget.METHOD_GET, false);
        k5.f11206d = i(k5, g);
        return k5;
    }

    public final g2 h(int i) {
        HashMap hashMap = new HashMap();
        hashMap.putAll(g());
        String str = "/eapi/category/" + i + "/features";
        g2 k5 = k("https://www.uptodown.app:443".concat(str), hashMap, ShareTarget.METHOD_GET, false);
        k5.f11206d = i(k5, str);
        return k5;
    }

    public final JSONObject i(g2 g2Var, String str) {
        String str2;
        g2Var.getClass();
        if (!g2Var.b() && (str2 = g2Var.f11203a) != null && str2.length() != 0) {
            try {
                String str3 = g2Var.f11203a;
                str3.getClass();
                return new JSONObject(str3);
            } catch (JSONException unused) {
                new android.support.v4.media.g(this.f6714a, 20).E(k0.k.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "jsonException", "url", str), "apiRead");
            }
        }
        return null;
    }

    public final JSONObject j(g2 g2Var, String str) {
        String str2 = g2Var.f11203a;
        if (str2 != null && str2.length() != 0) {
            try {
                String str3 = g2Var.f11203a;
                str3.getClass();
                return new JSONObject(str3);
            } catch (JSONException unused) {
                new android.support.v4.media.g(this.f6714a, 20).E(k0.k.f(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "jsonException", "url", str), "apiRead");
            }
        }
        return null;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(23:0|1|(2:136|137)(1:3)|4|5|(7:124|125|126|127|(3:129|130|131)|133|131)|7|(1:9)|10|(1:13)|14|15|(1:17)(2:119|(9:123|19|(3:21|22|23)|27|(1:29)|30|31|32|(20:34|35|36|37|(1:42)|48|(1:52)|53|(1:57)|58|(1:110)(1:62)|63|(2:64|(1:66)(1:67))|68|(2:71|(4:73|74|75|76))|103|(1:105)(1:109)|106|(1:108)|84)(20:115|114|37|(2:39|42)|48|(2:50|52)|53|(2:55|57)|58|(1:60)|110|63|(3:64|(0)(0)|66)|68|(2:71|(0))|103|(0)(0)|106|(0)|84))(1:122))|18|19|(0)|27|(0)|30|31|32|(0)(0)|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:117:0x013a, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:118:0x013b, code lost:
    
        r8 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0171, code lost:
    
        if (r8.length() != 0) goto L82;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0174, code lost:
    
        r1.setRequestProperty("TURBOTOKEN", r8);
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x021f A[Catch: all -> 0x0022, Exception -> 0x0236, IOException -> 0x023c, SSLHandshakeException -> 0x0242, ProtocolException -> 0x0248, MalformedURLException -> 0x024e, NullPointerException -> 0x0254, SecurityException -> 0x025a, IllegalArgumentException -> 0x0260, IllegalStateException -> 0x0266, SocketTimeoutException -> 0x026c, TryCatch #9 {IllegalArgumentException -> 0x0260, IllegalStateException -> 0x0266, NullPointerException -> 0x0254, SecurityException -> 0x025a, MalformedURLException -> 0x024e, ProtocolException -> 0x0248, SocketTimeoutException -> 0x026c, SSLHandshakeException -> 0x0242, IOException -> 0x023c, Exception -> 0x0236, all -> 0x0022, blocks: (B:137:0x001b, B:4:0x0026, B:75:0x020d, B:103:0x0212, B:105:0x021f, B:108:0x0230), top: B:136:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0230 A[Catch: all -> 0x0022, Exception -> 0x0236, IOException -> 0x023c, SSLHandshakeException -> 0x0242, ProtocolException -> 0x0248, MalformedURLException -> 0x024e, NullPointerException -> 0x0254, SecurityException -> 0x025a, IllegalArgumentException -> 0x0260, IllegalStateException -> 0x0266, SocketTimeoutException -> 0x026c, TRY_LEAVE, TryCatch #9 {IllegalArgumentException -> 0x0260, IllegalStateException -> 0x0266, NullPointerException -> 0x0254, SecurityException -> 0x025a, MalformedURLException -> 0x024e, ProtocolException -> 0x0248, SocketTimeoutException -> 0x026c, SSLHandshakeException -> 0x0242, IOException -> 0x023c, Exception -> 0x0236, all -> 0x0022, blocks: (B:137:0x001b, B:4:0x0026, B:75:0x020d, B:103:0x0212, B:105:0x021f, B:108:0x0230), top: B:136:0x001b }] */
    /* JADX WARN: Removed duplicated region for block: B:109:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f5 A[Catch: all -> 0x0054, Exception -> 0x0059, IOException -> 0x005d, SSLHandshakeException -> 0x0061, ProtocolException -> 0x0065, MalformedURLException -> 0x0069, NullPointerException -> 0x006d, SecurityException -> 0x0071, IllegalArgumentException -> 0x0075, IllegalStateException -> 0x0079, SocketTimeoutException -> 0x007d, TRY_LEAVE, TryCatch #20 {all -> 0x0054, blocks: (B:125:0x0031, B:127:0x0036, B:129:0x0040, B:131:0x004c, B:135:0x0048, B:7:0x0081, B:9:0x0087, B:10:0x008c, B:13:0x00a1, B:14:0x00a4, B:17:0x00b1, B:19:0x00f1, B:21:0x00f5, B:23:0x00f7, B:26:0x00fc, B:27:0x00ff, B:29:0x0122, B:32:0x0126, B:36:0x0131, B:37:0x0140, B:39:0x0161, B:42:0x0168, B:44:0x016d, B:47:0x0174, B:48:0x0179, B:50:0x017f, B:52:0x0185, B:53:0x018e, B:55:0x0194, B:57:0x019a, B:58:0x01b6, B:62:0x01c5, B:63:0x01e2, B:64:0x01e7, B:66:0x01ed, B:68:0x01f1, B:71:0x0202, B:73:0x0208, B:110:0x01d4, B:113:0x013c, B:119:0x00c9, B:122:0x00d1), top: B:124:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0122 A[Catch: all -> 0x0054, Exception -> 0x0059, IOException -> 0x005d, SSLHandshakeException -> 0x0061, ProtocolException -> 0x0065, MalformedURLException -> 0x0069, NullPointerException -> 0x006d, SecurityException -> 0x0071, IllegalArgumentException -> 0x0075, IllegalStateException -> 0x0079, SocketTimeoutException -> 0x007d, TRY_LEAVE, TryCatch #20 {all -> 0x0054, blocks: (B:125:0x0031, B:127:0x0036, B:129:0x0040, B:131:0x004c, B:135:0x0048, B:7:0x0081, B:9:0x0087, B:10:0x008c, B:13:0x00a1, B:14:0x00a4, B:17:0x00b1, B:19:0x00f1, B:21:0x00f5, B:23:0x00f7, B:26:0x00fc, B:27:0x00ff, B:29:0x0122, B:32:0x0126, B:36:0x0131, B:37:0x0140, B:39:0x0161, B:42:0x0168, B:44:0x016d, B:47:0x0174, B:48:0x0179, B:50:0x017f, B:52:0x0185, B:53:0x018e, B:55:0x0194, B:57:0x019a, B:58:0x01b6, B:62:0x01c5, B:63:0x01e2, B:64:0x01e7, B:66:0x01ed, B:68:0x01f1, B:71:0x0202, B:73:0x0208, B:110:0x01d4, B:113:0x013c, B:119:0x00c9, B:122:0x00d1), top: B:124:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0161 A[Catch: all -> 0x0054, Exception -> 0x0059, IOException -> 0x005d, SSLHandshakeException -> 0x0061, ProtocolException -> 0x0065, MalformedURLException -> 0x0069, NullPointerException -> 0x006d, SecurityException -> 0x0071, IllegalArgumentException -> 0x0075, IllegalStateException -> 0x0079, SocketTimeoutException -> 0x007d, TryCatch #20 {all -> 0x0054, blocks: (B:125:0x0031, B:127:0x0036, B:129:0x0040, B:131:0x004c, B:135:0x0048, B:7:0x0081, B:9:0x0087, B:10:0x008c, B:13:0x00a1, B:14:0x00a4, B:17:0x00b1, B:19:0x00f1, B:21:0x00f5, B:23:0x00f7, B:26:0x00fc, B:27:0x00ff, B:29:0x0122, B:32:0x0126, B:36:0x0131, B:37:0x0140, B:39:0x0161, B:42:0x0168, B:44:0x016d, B:47:0x0174, B:48:0x0179, B:50:0x017f, B:52:0x0185, B:53:0x018e, B:55:0x0194, B:57:0x019a, B:58:0x01b6, B:62:0x01c5, B:63:0x01e2, B:64:0x01e7, B:66:0x01ed, B:68:0x01f1, B:71:0x0202, B:73:0x0208, B:110:0x01d4, B:113:0x013c, B:119:0x00c9, B:122:0x00d1), top: B:124:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x017f A[Catch: all -> 0x0054, Exception -> 0x0059, IOException -> 0x005d, SSLHandshakeException -> 0x0061, ProtocolException -> 0x0065, MalformedURLException -> 0x0069, NullPointerException -> 0x006d, SecurityException -> 0x0071, IllegalArgumentException -> 0x0075, IllegalStateException -> 0x0079, SocketTimeoutException -> 0x007d, TryCatch #20 {all -> 0x0054, blocks: (B:125:0x0031, B:127:0x0036, B:129:0x0040, B:131:0x004c, B:135:0x0048, B:7:0x0081, B:9:0x0087, B:10:0x008c, B:13:0x00a1, B:14:0x00a4, B:17:0x00b1, B:19:0x00f1, B:21:0x00f5, B:23:0x00f7, B:26:0x00fc, B:27:0x00ff, B:29:0x0122, B:32:0x0126, B:36:0x0131, B:37:0x0140, B:39:0x0161, B:42:0x0168, B:44:0x016d, B:47:0x0174, B:48:0x0179, B:50:0x017f, B:52:0x0185, B:53:0x018e, B:55:0x0194, B:57:0x019a, B:58:0x01b6, B:62:0x01c5, B:63:0x01e2, B:64:0x01e7, B:66:0x01ed, B:68:0x01f1, B:71:0x0202, B:73:0x0208, B:110:0x01d4, B:113:0x013c, B:119:0x00c9, B:122:0x00d1), top: B:124:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0194 A[Catch: all -> 0x0054, Exception -> 0x0059, IOException -> 0x005d, SSLHandshakeException -> 0x0061, ProtocolException -> 0x0065, MalformedURLException -> 0x0069, NullPointerException -> 0x006d, SecurityException -> 0x0071, IllegalArgumentException -> 0x0075, IllegalStateException -> 0x0079, SocketTimeoutException -> 0x007d, TryCatch #20 {all -> 0x0054, blocks: (B:125:0x0031, B:127:0x0036, B:129:0x0040, B:131:0x004c, B:135:0x0048, B:7:0x0081, B:9:0x0087, B:10:0x008c, B:13:0x00a1, B:14:0x00a4, B:17:0x00b1, B:19:0x00f1, B:21:0x00f5, B:23:0x00f7, B:26:0x00fc, B:27:0x00ff, B:29:0x0122, B:32:0x0126, B:36:0x0131, B:37:0x0140, B:39:0x0161, B:42:0x0168, B:44:0x016d, B:47:0x0174, B:48:0x0179, B:50:0x017f, B:52:0x0185, B:53:0x018e, B:55:0x0194, B:57:0x019a, B:58:0x01b6, B:62:0x01c5, B:63:0x01e2, B:64:0x01e7, B:66:0x01ed, B:68:0x01f1, B:71:0x0202, B:73:0x0208, B:110:0x01d4, B:113:0x013c, B:119:0x00c9, B:122:0x00d1), top: B:124:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01ed A[Catch: all -> 0x0054, Exception -> 0x0059, IOException -> 0x005d, SSLHandshakeException -> 0x0061, ProtocolException -> 0x0065, MalformedURLException -> 0x0069, NullPointerException -> 0x006d, SecurityException -> 0x0071, IllegalArgumentException -> 0x0075, IllegalStateException -> 0x0079, SocketTimeoutException -> 0x007d, LOOP:0: B:64:0x01e7->B:66:0x01ed, LOOP_END, TryCatch #20 {all -> 0x0054, blocks: (B:125:0x0031, B:127:0x0036, B:129:0x0040, B:131:0x004c, B:135:0x0048, B:7:0x0081, B:9:0x0087, B:10:0x008c, B:13:0x00a1, B:14:0x00a4, B:17:0x00b1, B:19:0x00f1, B:21:0x00f5, B:23:0x00f7, B:26:0x00fc, B:27:0x00ff, B:29:0x0122, B:32:0x0126, B:36:0x0131, B:37:0x0140, B:39:0x0161, B:42:0x0168, B:44:0x016d, B:47:0x0174, B:48:0x0179, B:50:0x017f, B:52:0x0185, B:53:0x018e, B:55:0x0194, B:57:0x019a, B:58:0x01b6, B:62:0x01c5, B:63:0x01e2, B:64:0x01e7, B:66:0x01ed, B:68:0x01f1, B:71:0x0202, B:73:0x0208, B:110:0x01d4, B:113:0x013c, B:119:0x00c9, B:122:0x00d1), top: B:124:0x0031 }] */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01f1 A[EDGE_INSN: B:67:0x01f1->B:68:0x01f1 BREAK  A[LOOP:0: B:64:0x01e7->B:66:0x01ed], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0200 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0208 A[Catch: all -> 0x0054, Exception -> 0x0059, IOException -> 0x005d, SSLHandshakeException -> 0x0061, ProtocolException -> 0x0065, MalformedURLException -> 0x0069, NullPointerException -> 0x006d, SecurityException -> 0x0071, IllegalArgumentException -> 0x0075, IllegalStateException -> 0x0079, SocketTimeoutException -> 0x007d, TRY_LEAVE, TryCatch #20 {all -> 0x0054, blocks: (B:125:0x0031, B:127:0x0036, B:129:0x0040, B:131:0x004c, B:135:0x0048, B:7:0x0081, B:9:0x0087, B:10:0x008c, B:13:0x00a1, B:14:0x00a4, B:17:0x00b1, B:19:0x00f1, B:21:0x00f5, B:23:0x00f7, B:26:0x00fc, B:27:0x00ff, B:29:0x0122, B:32:0x0126, B:36:0x0131, B:37:0x0140, B:39:0x0161, B:42:0x0168, B:44:0x016d, B:47:0x0174, B:48:0x0179, B:50:0x017f, B:52:0x0185, B:53:0x018e, B:55:0x0194, B:57:0x019a, B:58:0x01b6, B:62:0x01c5, B:63:0x01e2, B:64:0x01e7, B:66:0x01ed, B:68:0x01f1, B:71:0x0202, B:73:0x0208, B:110:0x01d4, B:113:0x013c, B:119:0x00c9, B:122:0x00d1), top: B:124:0x0031 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final x4.g2 k(java.lang.String r18, java.util.HashMap r19, java.lang.String r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.v.k(java.lang.String, java.util.HashMap, java.lang.String, boolean):x4.g2");
    }

    public final g2 l(String str, HashMap hashMap) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry entry : hashMap.entrySet()) {
            jSONObject.put((String) entry.getKey(), entry.getValue());
        }
        Context context = this.f6714a;
        context.getClass();
        String string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        if (string != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("identifier", string);
            str = x.k(str, "?", n(hashMap2));
        }
        String z9 = z();
        g2 g2Var = new g2();
        try {
            String valueOf = String.valueOf(System.currentTimeMillis());
            x0 x0Var = new x0();
            x0Var.k("lang", d0.b.A(z3.y(context, "Language")));
            String jSONObject2 = jSONObject.toString();
            jSONObject2.getClass();
            byte[] y9 = d0.b.y(jSONObject2);
            x0Var.h(valueOf, y9);
            x0Var.j();
            x0Var.d(new URL(str), valueOf, z9);
            x0Var.c("lang", d0.b.A(z3.y(context, "Language")));
            x0Var.a(valueOf, y9);
            x0Var.e();
            g2Var = x0Var.f(true);
        } catch (Exception unused) {
            g2Var.f11205c = "Exception";
        }
        g2Var.a(context);
        return g2Var;
    }

    public final g2 m(int i, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i));
        hashMap.put("page[offset]", String.valueOf(i6));
        hashMap.putAll(g());
        g2 k5 = k("https://www.uptodown.app:443".concat("/eapi/apps/new-releases"), hashMap, ShareTarget.METHOD_GET, false);
        k5.f11206d = i(k5, "/eapi/apps/new-releases");
        return k5;
    }

    public final g2 o(long j) {
        if (j == 0) {
            g2 g2Var = new g2();
            g2Var.f11204b = 404;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("success", 0);
            g2Var.f11203a = jSONObject.toString();
            return g2Var;
        }
        Context context = this.f6714a;
        context.getClass();
        return k("https://www.uptodown.app:443/eapi/v3/apps/" + j + "/device/" + Settings.Secure.getString(context.getContentResolver(), "android_id"), g(), ShareTarget.METHOD_GET, false);
    }

    public final g2 p(int i, int i6, int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i6));
        hashMap.put("page[offset]", String.valueOf(i10));
        hashMap.putAll(g());
        String g = x.g(i, "/eapi/categories/", "/apps/news");
        g2 k5 = k("https://www.uptodown.app:443".concat(g), hashMap, ShareTarget.METHOD_GET, false);
        k5.f11206d = i(k5, g);
        return k5;
    }

    public final g2 q(int i, int i6, String str) {
        str.getClass();
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i));
        hashMap.put("page[offset]", String.valueOf(i6));
        hashMap.putAll(g());
        g2 k5 = k(androidx.lifecycle.l.w("https://www.uptodown.app:443/eapi/user/", str, "/recommended-list"), hashMap, ShareTarget.METHOD_GET, false);
        k5.f11206d = i(k5, "/eapi/user/" + str + "/recommended-list");
        return k5;
    }

    public final g2 r(long j) {
        g2 k5 = k(k0.k.g(j, "https://www.uptodown.app:443/eapi/app/", "/screenshots"), null, ShareTarget.METHOD_GET, false);
        k5.f11206d = i(k5, "/eapi/app/appId/screenshots");
        return k5;
    }

    public final g2 s(int i, int i6) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i));
        hashMap.put("page[offset]", String.valueOf(i6));
        hashMap.putAll(g());
        g2 k5 = k("https://www.uptodown.app:443".concat("/eapi/v2/app/top-platform"), hashMap, ShareTarget.METHOD_GET, false);
        k5.f11206d = i(k5, "/eapi/v2/app/top-platform");
        return k5;
    }

    public final g2 t(int i, int i6, int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i6));
        hashMap.put("page[offset]", String.valueOf(i10));
        hashMap.putAll(g());
        String g = x.g(i, "/eapi/category/", "/apps/top");
        g2 k5 = k("https://www.uptodown.app:443".concat(g), hashMap, ShareTarget.METHOD_GET, false);
        k5.f11206d = i(k5, g);
        return k5;
    }

    public final g2 u(int i, int i6, int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i6));
        hashMap.put("page[offset]", String.valueOf(i10));
        hashMap.putAll(g());
        String g = x.g(i, "/eapi/floating-category/", "/apps");
        g2 k5 = k("https://www.uptodown.app:443".concat(g), hashMap, ShareTarget.METHOD_GET, false);
        k5.f11206d = i(k5, g);
        return k5;
    }

    public final g2 v(int i, int i6, int i10) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i6));
        hashMap.put("page[offset]", String.valueOf(i10));
        hashMap.putAll(g());
        String g = x.g(i, "/eapi/v3/leaf-category/", "/apps/top");
        g2 k5 = k("https://www.uptodown.app:443".concat(g), hashMap, ShareTarget.METHOD_GET, false);
        k5.f11206d = i(k5, g);
        return k5;
    }

    public final g2 w(int i, String str, String str2) {
        str.getClass();
        str2.getClass();
        HashMap hashMap = new HashMap();
        hashMap.put("update", String.valueOf(i));
        StringBuilder sb = new StringBuilder("https://www.uptodown.app:443/eapi/apps/");
        sb.append(str2);
        return k(x.o(sb, "/file/", str, "/downloadUrl"), hashMap, ShareTarget.METHOD_GET, false);
    }

    public final g2 x(int i, String str, String str2) {
        str.getClass();
        str2.getClass();
        HashMap hashMap = new HashMap();
        hashMap.put("update", String.valueOf(i));
        StringBuilder sb = new StringBuilder("https://www.uptodown.app:443/eapi/apps/");
        sb.append(str2);
        return k(x.o(sb, "/file/", str, "/resumeDownloadURL"), hashMap, ShareTarget.METHOD_GET, false);
    }

    public final g2 y(int i, int i6, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("page[limit]", String.valueOf(i));
        hashMap.put("page[offset]", String.valueOf(i6));
        hashMap.putAll(g());
        g2 k5 = k(androidx.lifecycle.l.w("https://www.uptodown.app:443/eapi/user/", str, "/comments"), hashMap, ShareTarget.METHOD_GET, false);
        k5.f11206d = i(k5, "/eapi/user/userID/comments");
        return k5;
    }

    public final String z() {
        synchronized (f6711b) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            String str = f6712c;
            if (str != null && currentTimeMillis < f6713d - 60) {
                return str;
            }
            return d();
        }
    }

    public v(Context context, int i) {
        context.getClass();
        this.f6714a = context;
    }
}
