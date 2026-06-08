package e3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements c {

    /* renamed from: l, reason: collision with root package name */
    public static final Object f4473l = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile b f4474a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f4475b;

    public static c a(b bVar) {
        if (bVar instanceof a) {
            return bVar;
        }
        a aVar = new a();
        aVar.f4475b = f4473l;
        aVar.f4474a = bVar;
        return aVar;
    }

    @Override // m6.a
    public final Object get() {
        Object obj;
        Object obj2 = this.f4475b;
        Object obj3 = f4473l;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f4475b;
                if (obj == obj3) {
                    obj = this.f4474a.get();
                    Object obj4 = this.f4475b;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f4475b = obj;
                    this.f4474a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
