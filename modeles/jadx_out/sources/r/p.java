package r;

import a4.x;
import android.util.Base64;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class p {
    public final j a(o.d dVar) {
        j jVar = (j) this;
        String str = jVar.f8831a;
        if (str == null) {
            com.google.gson.internal.a.i("Null backendName");
            return null;
        }
        if (dVar != null) {
            return new j(str, jVar.f8832b, dVar);
        }
        com.google.gson.internal.a.i("Null priority");
        return null;
    }

    public final String toString() {
        j jVar = (j) this;
        byte[] bArr = jVar.f8832b;
        String encodeToString = bArr == null ? "" : Base64.encodeToString(bArr, 2);
        StringBuilder sb = new StringBuilder("TransportContext(");
        sb.append(jVar.f8831a);
        sb.append(", ");
        sb.append(jVar.f8833c);
        sb.append(", ");
        return x.n(sb, encodeToString, ")");
    }
}
