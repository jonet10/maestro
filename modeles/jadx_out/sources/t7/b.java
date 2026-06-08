package t7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10320a = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_next$volatile");

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10321b = AtomicReferenceFieldUpdater.newUpdater(b.class, Object.class, "_prev$volatile");
    private volatile /* synthetic */ Object _next$volatile;
    private volatile /* synthetic */ Object _prev$volatile;

    public b(s sVar) {
        this._prev$volatile = sVar;
    }

    public final void b() {
        f10321b.set(this, null);
    }

    public final b c() {
        Object obj = f10320a.get(this);
        if (obj == a.f10315a) {
            return null;
        }
        return (b) obj;
    }

    public abstract boolean d();

    public final void e() {
        b c9;
        if (c() == null) {
            return;
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10321b;
            b bVar = (b) atomicReferenceFieldUpdater.get(this);
            while (bVar != null && bVar.d()) {
                bVar = (b) atomicReferenceFieldUpdater.get(bVar);
            }
            b c10 = c();
            c10.getClass();
            while (c10.d() && (c9 = c10.c()) != null) {
                c10 = c9;
            }
            while (true) {
                Object obj = atomicReferenceFieldUpdater.get(c10);
                b bVar2 = ((b) obj) == null ? null : bVar;
                while (!atomicReferenceFieldUpdater.compareAndSet(c10, obj, bVar2)) {
                    if (atomicReferenceFieldUpdater.get(c10) != obj) {
                        break;
                    }
                }
            }
            if (bVar != null) {
                f10320a.set(bVar, c10);
            }
            if (!c10.d() || c10.c() == null) {
                if (bVar == null || !bVar.d()) {
                    return;
                }
            }
        }
    }
}
