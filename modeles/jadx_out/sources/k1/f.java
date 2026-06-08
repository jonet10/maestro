package k1;

import com.google.android.gms.internal.measurement.z5;
import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f implements d {

    /* renamed from: a, reason: collision with root package name */
    public volatile z5 f6945a;

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f6946b;

    /* renamed from: l, reason: collision with root package name */
    public Object f6947l;

    @Override // k1.d
    public final Object get() {
        if (!this.f6946b) {
            synchronized (this) {
                try {
                    if (!this.f6946b) {
                        z5 z5Var = this.f6945a;
                        Objects.requireNonNull(z5Var);
                        Object obj = z5Var.get();
                        this.f6947l = obj;
                        this.f6946b = true;
                        this.f6945a = null;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.f6947l;
    }

    public final String toString() {
        Object obj = this.f6945a;
        if (obj == null) {
            String valueOf = String.valueOf(this.f6947l);
            StringBuilder sb = new StringBuilder(valueOf.length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(valueOf2.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
