package s1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m implements s2.b {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f9140c = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile Object f9141a = f9140c;

    /* renamed from: b, reason: collision with root package name */
    public volatile s2.b f9142b;

    public m(s2.b bVar) {
        this.f9142b = bVar;
    }

    @Override // s2.b
    public final Object get() {
        Object obj;
        Object obj2 = this.f9141a;
        Object obj3 = f9140c;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f9141a;
                if (obj == obj3) {
                    obj = this.f9142b.get();
                    this.f9141a = obj;
                    this.f9142b = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
