package u8;

import com.google.android.gms.internal.measurement.z3;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends z3 {
    public final Object h;
    public final Method i;

    public a(Object obj, Method method) {
        super(19);
        this.h = obj;
        this.i = method;
    }

    public final boolean equals(Object obj) {
        return obj instanceof a;
    }

    @Override // com.google.android.gms.internal.measurement.z3
    public final int hashCode() {
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.z3
    public final List j(String str, List list) {
        try {
            return (List) this.i.invoke(this.h, (X509Certificate[]) list.toArray(new X509Certificate[list.size()]), "RSA", str);
        } catch (IllegalAccessException e10) {
            o.j(e10);
            return null;
        } catch (InvocationTargetException e11) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e11.getMessage());
            sSLPeerUnverifiedException.initCause(e11);
            throw sSLPeerUnverifiedException;
        }
    }
}
