package p6;

import java.io.Serializable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Object f8444a;

    public static final Throwable a(Object obj) {
        if (obj instanceof j) {
            return ((j) obj).f8443a;
        }
        return null;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            return kotlin.jvm.internal.l.a(this.f8444a, ((k) obj).f8444a);
        }
        return false;
    }

    public final int hashCode() {
        Object obj = this.f8444a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public final String toString() {
        Object obj = this.f8444a;
        if (obj instanceof j) {
            return ((j) obj).toString();
        }
        return "Success(" + obj + ')';
    }
}
