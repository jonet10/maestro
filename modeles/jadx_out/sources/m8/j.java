package m8;

import com.google.android.gms.internal.measurement.z3;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    public static final j f7743c = new j(new LinkedHashSet(new ArrayList()), null);

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashSet f7744a;

    /* renamed from: b, reason: collision with root package name */
    public final z3 f7745b;

    public j(LinkedHashSet linkedHashSet, z3 z3Var) {
        this.f7744a = linkedHashSet;
        this.f7745b = z3Var;
    }

    public static String b(X509Certificate x509Certificate) {
        if (!androidx.lifecycle.l.D(x509Certificate)) {
            com.google.gson.internal.a.p("Certificate pinning requires X509 certificates");
            return null;
        }
        return "sha256/" + w8.k.n(x509Certificate.getPublicKey().getEncoded()).e("SHA-256").a();
    }

    public final void a(String str, List list) {
        List list2 = Collections.EMPTY_LIST;
        Iterator it = this.f7744a.iterator();
        if (it.hasNext()) {
            it.next().getClass();
            com.google.gson.internal.a.o();
            return;
        }
        if (list2.isEmpty()) {
            return;
        }
        z3 z3Var = this.f7745b;
        if (z3Var != null) {
            list = z3Var.j(str, list);
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list2.size() > 0) {
                list2.get(0).getClass();
                com.google.gson.internal.a.o();
                return;
            }
        }
        StringBuilder sb = new StringBuilder("Certificate pinning failure!\n  Peer certificate chain:");
        int size2 = list.size();
        for (int i6 = 0; i6 < size2; i6++) {
            X509Certificate x509Certificate = (X509Certificate) list.get(i6);
            sb.append("\n    ");
            sb.append(b(x509Certificate));
            sb.append(": ");
            sb.append(x509Certificate.getSubjectDN().getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        int size3 = list2.size();
        for (int i10 = 0; i10 < size3; i10++) {
            if (list2.get(i10) != null) {
                com.google.gson.internal.a.o();
                return;
            }
            sb.append("\n    null");
        }
        throw new SSLPeerUnverifiedException(sb.toString());
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return n8.c.i(this.f7745b, jVar.f7745b) && this.f7744a.equals(jVar.f7744a);
    }

    public final int hashCode() {
        z3 z3Var = this.f7745b;
        return this.f7744a.hashCode() + ((z3Var != null ? z3Var.hashCode() : 0) * 31);
    }
}
