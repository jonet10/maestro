package e1;

import android.os.Bundle;
import android.text.TextUtils;
import j$.util.Objects;
import java.util.HashMap;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g4 {

    /* renamed from: a, reason: collision with root package name */
    public final HashMap f4002a;

    public g4(Map map) {
        HashMap hashMap = new HashMap();
        this.f4002a = hashMap;
        hashMap.putAll(map);
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        l1.i iVar = i4.f4047a;
        int i = iVar.f7066m;
        for (int i6 = 0; i6 < i; i6++) {
            String str = (String) iVar.get(i6);
            HashMap hashMap = this.f4002a;
            if (hashMap.containsKey(str)) {
                if (sb.length() > 0) {
                    sb.append(";");
                }
                sb.append(str);
                sb.append("=");
                sb.append((String) hashMap.get(str));
            }
        }
        return sb.toString();
    }

    public final Bundle b() {
        e0 e0Var = f0.f3914a1;
        boolean booleanValue = ((Boolean) e0Var.a(null)).booleanValue();
        HashMap hashMap = this.f4002a;
        if (!booleanValue ? !(!"1".equals(hashMap.get("GoogleConsent")) || !"1".equals(hashMap.get("gdprApplies")) || !"1".equals(hashMap.get("EnableAdvertiserConsentMode"))) : !(!"1".equals(hashMap.get("gdprApplies")) || !"1".equals(hashMap.get("EnableAdvertiserConsentMode")))) {
            if (!((Boolean) e0Var.a(null)).booleanValue()) {
                return d();
            }
            if (hashMap.get("Version") == null) {
                return d();
            }
            if (e() >= 0) {
                Bundle bundle = new Bundle();
                bundle.putString("ad_storage", true != Objects.equals(hashMap.get("AuthorizePurpose1"), "1") ? "denied" : "granted");
                bundle.putString("ad_personalization", (Objects.equals(hashMap.get("AuthorizePurpose3"), "1") && Objects.equals(hashMap.get("AuthorizePurpose4"), "1")) ? "granted" : "denied");
                if (e() >= 4) {
                    bundle.putString("ad_user_data", (Objects.equals(hashMap.get("AuthorizePurpose1"), "1") && Objects.equals(hashMap.get("AuthorizePurpose7"), "1")) ? "granted" : "denied");
                }
                return bundle;
            }
        }
        return Bundle.EMPTY;
    }

    public final String c() {
        HashMap hashMap = this.f4002a;
        StringBuilder sb = new StringBuilder("1");
        int i = -1;
        try {
            String str = (String) hashMap.get("CmpSdkID");
            if (!TextUtils.isEmpty(str)) {
                i = Integer.parseInt(str);
            }
        } catch (NumberFormatException unused) {
        }
        if (i < 0 || i > 4095) {
            sb.append("00");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i >> 6));
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i & 63));
        }
        int e10 = e();
        if (e10 < 0 || e10 > 63) {
            sb.append("0");
        } else {
            sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(e10));
        }
        int i6 = true != "1".equals(hashMap.get("gdprApplies")) ? 0 : 2;
        int i10 = i6 | 4;
        if ("1".equals(hashMap.get("EnableAdvertiserConsentMode"))) {
            i10 = i6 | 12;
        }
        sb.append("0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_".charAt(i10));
        return sb.toString();
    }

    public final Bundle d() {
        int e10;
        HashMap hashMap = this.f4002a;
        if ("1".equals(hashMap.get("GoogleConsent")) && (e10 = e()) >= 0) {
            String str = (String) hashMap.get("PurposeConsents");
            if (!TextUtils.isEmpty(str)) {
                Bundle bundle = new Bundle();
                String str2 = "denied";
                if (str.length() > 0) {
                    bundle.putString("ad_storage", str.charAt(0) == '1' ? "granted" : "denied");
                }
                if (str.length() > 3) {
                    bundle.putString("ad_personalization", (str.charAt(2) == '1' && str.charAt(3) == '1') ? "granted" : "denied");
                }
                if (str.length() > 6 && e10 >= 4) {
                    if (str.charAt(0) == '1' && str.charAt(6) == '1') {
                        str2 = "granted";
                    }
                    bundle.putString("ad_user_data", str2);
                }
                return bundle;
            }
        }
        return Bundle.EMPTY;
    }

    public final int e() {
        try {
            String str = (String) this.f4002a.get("PolicyVersion");
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof g4) {
            return a().equalsIgnoreCase(((g4) obj).a());
        }
        return false;
    }

    public final int hashCode() {
        return a().hashCode();
    }

    public final String toString() {
        return a();
    }
}
