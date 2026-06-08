package p6;

import java.io.Serializable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f8443a;

    public j(Throwable th) {
        th.getClass();
        this.f8443a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return kotlin.jvm.internal.l.a(this.f8443a, ((j) obj).f8443a);
        }
        return false;
    }

    public final int hashCode() {
        return this.f8443a.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.f8443a + ')';
    }
}
