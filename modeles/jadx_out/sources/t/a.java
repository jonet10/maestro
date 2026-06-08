package t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class a implements m6.a {

    /* renamed from: l, reason: collision with root package name */
    public static final Object f9483l = new Object();

    /* renamed from: a, reason: collision with root package name */
    public volatile b f9484a;

    /* renamed from: b, reason: collision with root package name */
    public volatile Object f9485b;

    public static m6.a a(b bVar) {
        if (bVar instanceof a) {
            return bVar;
        }
        a aVar = new a();
        aVar.f9485b = f9483l;
        aVar.f9484a = bVar;
        return aVar;
    }

    @Override // m6.a
    public final Object get() {
        Object obj;
        Object obj2 = this.f9485b;
        Object obj3 = f9483l;
        if (obj2 != obj3) {
            return obj2;
        }
        synchronized (this) {
            try {
                obj = this.f9485b;
                if (obj == obj3) {
                    obj = this.f9484a.get();
                    Object obj4 = this.f9485b;
                    if (obj4 != obj3 && obj4 != obj) {
                        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj4 + " & " + obj + ". This is likely due to a circular dependency.");
                    }
                    this.f9485b = obj;
                    this.f9484a = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }
}
