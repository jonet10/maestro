package t7;

import androidx.core.internal.view.SupportMenu;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import o7.r1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class s extends b implements r1 {

    /* renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ AtomicIntegerFieldUpdater f10354d = AtomicIntegerFieldUpdater.newUpdater(s.class, "cleanedAndPointers$volatile");

    /* renamed from: c, reason: collision with root package name */
    public final long f10355c;
    private volatile /* synthetic */ int cleanedAndPointers$volatile;

    public s(long j, s sVar, int i) {
        super(sVar);
        this.f10355c = j;
        this.cleanedAndPointers$volatile = i << 16;
    }

    @Override // t7.b
    public final boolean d() {
        return f10354d.get(this) == g() && c() != null;
    }

    public final boolean f() {
        return f10354d.addAndGet(this, SupportMenu.CATEGORY_MASK) == g() && c() != null;
    }

    public abstract int g();

    public abstract void h(int i, t6.h hVar);

    public final void i() {
        if (f10354d.incrementAndGet(this) == g()) {
            e();
        }
    }

    public final boolean j() {
        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater;
        int i;
        do {
            atomicIntegerFieldUpdater = f10354d;
            i = atomicIntegerFieldUpdater.get(this);
            if (i == g() && c() != null) {
                return false;
            }
        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i, 65536 + i));
        return true;
    }
}
