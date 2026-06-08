package s4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y0 extends Exception {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f9323l = 0;

    /* renamed from: a, reason: collision with root package name */
    public final int f9324a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9325b;

    public y0(int i, String str) {
        super(str);
        this.f9324a = i;
        this.f9325b = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y0)) {
            return false;
        }
        y0 y0Var = (y0) obj;
        return this.f9324a == y0Var.f9324a && kotlin.jvm.internal.l.a(this.f9325b, y0Var.f9325b);
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f9325b;
    }

    public final int hashCode() {
        return this.f9325b.hashCode() + (this.f9324a * 31);
    }

    @Override // java.lang.Throwable
    public final String toString() {
        return "ProgramException(statusCode=" + this.f9324a + ", message=" + this.f9325b + ")";
    }
}
