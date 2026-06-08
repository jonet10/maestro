package a2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j {

    /* renamed from: c, reason: collision with root package name */
    public static final j f24c = new j(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final int f25a;

    /* renamed from: b, reason: collision with root package name */
    public final int f26b;

    public j(int i, int i6) {
        this.f25a = i;
        this.f26b = i6;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(j.class.getSimpleName());
        sb.append("[position = ");
        sb.append(this.f25a);
        sb.append(", length = ");
        return androidx.lifecycle.l.x(sb, "]", this.f26b);
    }
}
