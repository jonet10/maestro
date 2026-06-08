package k1;

import java.io.Serializable;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements d, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f6948a;

    public g(Object obj) {
        this.f6948a = obj;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        Object obj2 = ((g) obj).f6948a;
        Object obj3 = this.f6948a;
        return obj3 == obj2 || obj3.equals(obj2);
    }

    @Override // k1.d
    public final Object get() {
        return this.f6948a;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6948a});
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f6948a);
        StringBuilder sb = new StringBuilder(valueOf.length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(valueOf);
        sb.append(")");
        return sb.toString();
    }
}
