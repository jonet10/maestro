package m8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a0 {

    /* renamed from: a, reason: collision with root package name */
    public final u f7673a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7674b;

    /* renamed from: c, reason: collision with root package name */
    public final s f7675c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f7676d;

    /* renamed from: e, reason: collision with root package name */
    public volatile i f7677e;

    public a0(y2.s sVar) {
        this.f7673a = (u) sVar.f11756l;
        this.f7674b = (String) sVar.f11755b;
        g5.f fVar = (g5.f) sVar.f11757m;
        fVar.getClass();
        this.f7675c = new s(fVar);
        Object obj = sVar.f11758n;
        this.f7676d = obj == null ? this : obj;
    }

    public final y2.s a() {
        y2.s sVar = new y2.s(false);
        sVar.f11756l = this.f7673a;
        sVar.f11755b = this.f7674b;
        sVar.f11758n = this.f7676d;
        sVar.f11757m = this.f7675c.c();
        return sVar;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.f7674b);
        sb.append(", url=");
        sb.append(this.f7673a);
        sb.append(", tag=");
        Object obj = this.f7676d;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }
}
