package e1;

import android.net.Uri;
import android.text.TextUtils;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r4 extends l4 {
    public static final boolean j(String str) {
        String str2 = (String) f0.f3954t.a(null);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        for (String str3 : str2.split(",")) {
            if (str.equalsIgnoreCase(str3.trim())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x0092, code lost:
    
        if (java.lang.Math.abs(r6.hashCode() % 100) < r8.D().o()) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final e1.q4 h(java.lang.String r14) {
        /*
            Method dump skipped, instructions count: 479
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: e1.r4.h(java.lang.String):e1.q4");
    }

    public final String i(String str) {
        m1 m1Var = this.f4092b.f4305a;
        u4.U(m1Var);
        String t9 = m1Var.t(str);
        if (TextUtils.isEmpty(t9)) {
            return (String) f0.f3950r.a(null);
        }
        Uri parse = Uri.parse((String) f0.f3950r.a(null));
        Uri.Builder buildUpon = parse.buildUpon();
        String authority = parse.getAuthority();
        StringBuilder sb = new StringBuilder(String.valueOf(t9).length() + 1 + String.valueOf(authority).length());
        sb.append(t9);
        sb.append(".");
        sb.append(authority);
        buildUpon.authority(sb.toString());
        return buildUpon.build().toString();
    }
}
