package l1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f7054a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f7055b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f7056c;

    public e(Object obj, Object obj2, Object obj3) {
        this.f7054a = obj;
        this.f7055b = obj2;
        this.f7056c = obj3;
    }

    public final IllegalArgumentException a() {
        Object obj = this.f7054a;
        String valueOf = String.valueOf(obj);
        String valueOf2 = String.valueOf(this.f7055b);
        String valueOf3 = String.valueOf(obj);
        String valueOf4 = String.valueOf(this.f7056c);
        StringBuilder sb = new StringBuilder(valueOf4.length() + valueOf3.length() + valueOf2.length() + valueOf.length() + 39);
        sb.append("Multiple entries with same key: ");
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        sb.append(" and ");
        sb.append(valueOf3);
        sb.append("=");
        sb.append(valueOf4);
        return new IllegalArgumentException(sb.toString());
    }
}
