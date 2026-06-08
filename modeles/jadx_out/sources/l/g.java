package l;

import com.inmobi.cmp.core.model.Vector;
import com.inmobi.cmp.core.model.gbc.GoogleBasicConsents;
import com.inmobi.cmp.core.model.portalconfig.GBCConsentValue;
import kotlin.jvm.internal.l;
import kotlin.jvm.internal.u;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class g {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f7044a;

    /* renamed from: b, reason: collision with root package name */
    public static final Vector f7045b = new Vector(null, 1, null);

    public static GoogleBasicConsents a() {
        return new GoogleBasicConsents(b("adStorage"), b("adUserData"), b("adPersonalization"), b("analyticsStorage"));
    }

    public static GBCConsentValue b(String str) {
        int d10 = d(str);
        Vector vector = f7045b;
        return (vector.contains(d10) && l.a(vector.get(d10), Boolean.TRUE)) ? GBCConsentValue.GRANTED : GBCConsentValue.DENIED;
    }

    public static String c(l9.a aVar) {
        aVar.getClass();
        if (!f7044a) {
            return null;
        }
        String j = aVar.j(93);
        return j.length() == 0 ? aVar.f7262a.getBoolean("GBCShown", false) ? "Bounce" : "NA" : j;
    }

    public static int d(String str) {
        if (str.equals("adStorage")) {
            return 1;
        }
        if (str.equals("adUserData")) {
            return 2;
        }
        if (str.equals("adPersonalization")) {
            return 3;
        }
        return str.equals("analyticsStorage") ? 4 : 0;
    }

    public static String e() {
        if (!f7044a) {
            return null;
        }
        u uVar = new u();
        uVar.f7021a = true;
        f fVar = new f(uVar, 0);
        Vector vector = f7045b;
        vector.forEach(fVar);
        if (uVar.f7021a) {
            return "All";
        }
        u uVar2 = new u();
        uVar2.f7021a = true;
        vector.forEach(new f(uVar2, 1));
        return uVar2.f7021a ? "Reject" : "Partial";
    }
}
