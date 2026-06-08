package e1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e0 {
    public static final Object f = new Object();

    /* renamed from: a, reason: collision with root package name */
    public final String f3893a;

    /* renamed from: b, reason: collision with root package name */
    public final v f3894b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f3895c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f3896d = new Object();

    /* renamed from: e, reason: collision with root package name */
    public volatile Object f3897e = null;

    public /* synthetic */ e0(String str, Object obj, v vVar) {
        this.f3893a = str;
        this.f3895c = obj;
        this.f3894b = vVar;
    }

    public final Object a(Object obj) {
        synchronized (this.f3896d) {
        }
        if (obj != null) {
            return obj;
        }
        if (k2.f4077k == null) {
            return this.f3895c;
        }
        synchronized (f) {
            try {
                if (q2.e.g()) {
                    return this.f3897e == null ? this.f3895c : this.f3897e;
                }
                try {
                    for (e0 e0Var : f0.f3913a) {
                        if (q2.e.g()) {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                        Object obj2 = null;
                        try {
                            v vVar = e0Var.f3894b;
                            if (vVar != null) {
                                obj2 = vVar.a();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (f) {
                            e0Var.f3897e = obj2;
                        }
                    }
                } catch (SecurityException unused2) {
                }
                v vVar2 = this.f3894b;
                if (vVar2 != null) {
                    try {
                        return vVar2.a();
                    } catch (IllegalStateException | SecurityException unused3) {
                    }
                }
                return this.f3895c;
            } finally {
            }
        }
    }
}
