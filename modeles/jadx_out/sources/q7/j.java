package q7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j extends k {

    /* renamed from: a, reason: collision with root package name */
    public final Throwable f8770a;

    public j(Throwable th) {
        this.f8770a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof j) {
            return kotlin.jvm.internal.l.a(this.f8770a, ((j) obj).f8770a);
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.f8770a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // q7.k
    public final String toString() {
        return "Closed(" + this.f8770a + ')';
    }
}
