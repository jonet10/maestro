package m8;

import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.Arrays;
import javax.net.ssl.SSLSocket;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o {

    /* renamed from: e, reason: collision with root package name */
    public static final o f7766e;
    public static final o f;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7767a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f7768b;

    /* renamed from: c, reason: collision with root package name */
    public final String[] f7769c;

    /* renamed from: d, reason: collision with root package name */
    public final String[] f7770d;

    static {
        l[] lVarArr = {l.f7750k, l.f7752m, l.f7751l, l.f7753n, l.f7755p, l.f7754o, l.i, l.j, l.g, l.h, l.f7749e, l.f, l.f7748d};
        n nVar = new n(true);
        String[] strArr = new String[13];
        for (int i = 0; i < 13; i++) {
            strArr[i] = lVarArr[i].f7756a;
        }
        nVar.a(strArr);
        g0 g0Var = g0.TLS_1_0;
        g0[] g0VarArr = {g0.TLS_1_3, g0.TLS_1_2, g0.TLS_1_1, g0Var};
        boolean z9 = nVar.f7762a;
        if (z9) {
            String[] strArr2 = new String[g0VarArr.length];
            for (int i6 = 0; i6 < g0VarArr.length; i6++) {
                strArr2[i6] = g0VarArr[i6].f7729a;
            }
            nVar.b(strArr2);
        } else {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("no TLS versions for cleartext connections");
        }
        if (!z9) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("no TLS extensions for cleartext connections");
            return;
        }
        nVar.f7765d = true;
        o oVar = new o(nVar);
        f7766e = oVar;
        g0[] g0VarArr2 = {g0Var};
        boolean z10 = oVar.f7767a;
        if (!z10) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("no TLS versions for cleartext connections");
            return;
        }
        String[] strArr3 = new String[g0VarArr2.length];
        for (int i10 = 0; i10 < g0VarArr2.length; i10++) {
            strArr3[i10] = g0VarArr2[i10].f7729a;
        }
        if (!z10) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("no TLS versions for cleartext connections");
            return;
        }
        if (strArr3.length == 0) {
            com.google.gson.internal.a.p("At least one TLS version is required");
        } else if (z10) {
            f = new o(new n(false));
        } else {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("no TLS extensions for cleartext connections");
        }
    }

    public o(n nVar) {
        this.f7767a = nVar.f7762a;
        this.f7769c = nVar.f7763b;
        this.f7770d = nVar.f7764c;
        this.f7768b = nVar.f7765d;
    }

    public final boolean a(SSLSocket sSLSocket) {
        if (!this.f7767a) {
            return false;
        }
        String[] strArr = this.f7770d;
        if (strArr != null && !n8.c.o(n8.c.f, strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f7769c;
        return strArr2 == null || n8.c.o(l.f7746b, strArr2, sSLSocket.getEnabledCipherSuites());
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof o)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        o oVar = (o) obj;
        boolean z9 = oVar.f7767a;
        boolean z10 = this.f7767a;
        if (z10 != z9) {
            return false;
        }
        if (z10) {
            return Arrays.equals(this.f7769c, oVar.f7769c) && Arrays.equals(this.f7770d, oVar.f7770d) && this.f7768b == oVar.f7768b;
        }
        return true;
    }

    public final int hashCode() {
        if (this.f7767a) {
            return ((((527 + Arrays.hashCode(this.f7769c)) * 31) + Arrays.hashCode(this.f7770d)) * 31) + (!this.f7768b ? 1 : 0);
        }
        return 17;
    }

    public final String toString() {
        String str;
        if (!this.f7767a) {
            return "ConnectionSpec()";
        }
        String str2 = "[all enabled]";
        String[] strArr = this.f7769c;
        if (strArr != null) {
            ArrayList arrayList = new ArrayList(strArr.length);
            for (String str3 : strArr) {
                arrayList.add(l.a(str3));
            }
            str = DesugarCollections.unmodifiableList(arrayList).toString();
        } else {
            str = "[all enabled]";
        }
        String[] strArr2 = this.f7770d;
        if (strArr2 != null) {
            ArrayList arrayList2 = new ArrayList(strArr2.length);
            for (String str4 : strArr2) {
                arrayList2.add(g0.a(str4));
            }
            str2 = DesugarCollections.unmodifiableList(arrayList2).toString();
        }
        return "ConnectionSpec(cipherSuites=" + str + ", tlsVersions=" + str2 + ", supportsTlsExtensions=" + this.f7768b + ")";
    }
}
