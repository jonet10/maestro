package k1;

import com.google.android.gms.internal.measurement.z5;
import java.io.Serializable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e implements d, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final z5 f6942a;

    /* renamed from: b, reason: collision with root package name */
    public volatile transient boolean f6943b;

    /* renamed from: l, reason: collision with root package name */
    public transient Object f6944l;

    public e(z5 z5Var) {
        this.f6942a = z5Var;
    }

    @Override // k1.d
    public final Object get() {
        if (!this.f6943b) {
            synchronized (this) {
                try {
                    if (!this.f6943b) {
                        Object obj = this.f6942a.get();
                        this.f6944l = obj;
                        this.f6943b = true;
                        return obj;
                    }
                } finally {
                }
            }
        }
        return this.f6944l;
    }

    public final String toString() {
        Object obj;
        if (this.f6943b) {
            String valueOf = String.valueOf(this.f6944l);
            StringBuilder sb = new StringBuilder(valueOf.length() + 25);
            sb.append("<supplier that returned ");
            sb.append(valueOf);
            sb.append(">");
            obj = sb.toString();
        } else {
            obj = this.f6942a;
        }
        String valueOf2 = String.valueOf(obj);
        StringBuilder sb2 = new StringBuilder(valueOf2.length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(valueOf2);
        sb2.append(")");
        return sb2.toString();
    }
}
