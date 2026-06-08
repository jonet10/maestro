package v6;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class c extends a {
    private final t6.h _context;
    private transient t6.c intercepted;

    public c(t6.c cVar) {
        this(cVar, cVar != null ? cVar.getContext() : null);
    }

    @Override // t6.c
    public t6.h getContext() {
        t6.h hVar = this._context;
        hVar.getClass();
        return hVar;
    }

    public final t6.c intercepted() {
        t6.c cVar = this.intercepted;
        if (cVar == null) {
            t6.e eVar = (t6.e) getContext().get(t6.d.f10313a);
            if (eVar == null || (cVar = eVar.interceptContinuation(this)) == null) {
                cVar = this;
            }
            this.intercepted = cVar;
        }
        return cVar;
    }

    @Override // v6.a
    public void releaseIntercepted() {
        t6.c cVar = this.intercepted;
        if (cVar != null && cVar != this) {
            t6.f fVar = getContext().get(t6.d.f10313a);
            fVar.getClass();
            ((t6.e) fVar).releaseInterceptedContinuation(cVar);
        }
        this.intercepted = b.f10855a;
    }

    public c(t6.c cVar, t6.h hVar) {
        super(cVar);
        this._context = hVar;
    }
}
