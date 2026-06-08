package t7;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class k {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AtomicReferenceFieldUpdater f10341a = AtomicReferenceFieldUpdater.newUpdater(k.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile = new m(8, false);

    public final boolean a(Runnable runnable) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10341a;
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            int a8 = mVar.a(runnable);
            if (a8 == 0) {
                return true;
            }
            if (a8 == 1) {
                m c9 = mVar.c();
                while (!atomicReferenceFieldUpdater.compareAndSet(this, mVar, c9) && atomicReferenceFieldUpdater.get(this) == mVar) {
                }
            } else if (a8 == 2) {
                return false;
            }
        }
    }

    public final void b() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10341a;
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            if (mVar.b()) {
                return;
            }
            m c9 = mVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, mVar, c9) && atomicReferenceFieldUpdater.get(this) == mVar) {
            }
        }
    }

    public final int c() {
        m mVar = (m) f10341a.get(this);
        mVar.getClass();
        long j = m.f.get(mVar);
        return (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j))) & 1073741823;
    }

    public final Object d() {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f10341a;
            m mVar = (m) atomicReferenceFieldUpdater.get(this);
            Object d10 = mVar.d();
            if (d10 != m.g) {
                return d10;
            }
            m c9 = mVar.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, mVar, c9) && atomicReferenceFieldUpdater.get(this) == mVar) {
            }
        }
    }
}
