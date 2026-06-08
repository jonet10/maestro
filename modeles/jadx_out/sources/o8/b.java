package o8;

import androidx.browser.trusted.sharing.ShareTarget;
import java.io.IOException;
import m8.a0;
import m8.b0;
import m8.c0;
import m8.v;
import m8.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b implements v {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8341a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8342b;

    public /* synthetic */ b(Object obj, int i) {
        this.f8341a = i;
        this.f8342b = obj;
    }

    private final c0 b(q8.d dVar) {
        a0 a0Var = dVar.f;
        p8.e eVar = dVar.f8787b;
        boolean z9 = !a0Var.f7674b.equals(ShareTarget.METHOD_GET);
        x xVar = (x) this.f8342b;
        eVar.getClass();
        try {
            q8.a i = eVar.d(dVar.i, dVar.j, dVar.f8791k, xVar.D, z9).i(xVar, dVar, eVar);
            synchronized (eVar.f8489d) {
                eVar.f8492l = i;
            }
            return dVar.b(a0Var, eVar, i, eVar.a());
        } catch (IOException e10) {
            throw new p8.b(e10);
        }
    }

    public static boolean c(String str) {
        return ("Connection".equalsIgnoreCase(str) || "Keep-Alive".equalsIgnoreCase(str) || "Proxy-Authenticate".equalsIgnoreCase(str) || "Proxy-Authorization".equalsIgnoreCase(str) || "TE".equalsIgnoreCase(str) || "Trailers".equalsIgnoreCase(str) || "Transfer-Encoding".equalsIgnoreCase(str) || "Upgrade".equalsIgnoreCase(str)) ? false : true;
    }

    public static c0 d(c0 c0Var) {
        if (c0Var == null || c0Var.f7698p == null) {
            return c0Var;
        }
        b0 d10 = c0Var.d();
        d10.g = null;
        return d10.a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0499 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:113:0x04a2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:117:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x04e6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x06b3  */
    /* JADX WARN: Removed duplicated region for block: B:215:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x038b  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03a5  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x03ba  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x039f  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0469  */
    @Override // m8.v
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final m8.c0 a(q8.d r35) {
        /*
            Method dump skipped, instructions count: 1808
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: o8.b.a(q8.d):m8.c0");
    }
}
