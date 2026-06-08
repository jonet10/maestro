package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class v1 extends b {
    public final j$.util.concurrent.t j;

    public v1(j$.util.concurrent.t tVar, a aVar, Spliterator spliterator) {
        super(aVar, spliterator);
        this.j = tVar;
    }

    public v1(v1 v1Var, Spliterator spliterator) {
        super(v1Var, spliterator);
        this.j = v1Var.j;
    }

    @Override // j$.util.stream.d
    public final d c(Spliterator spliterator) {
        return new v1(this, spliterator);
    }

    @Override // j$.util.stream.d
    public final Object a() {
        a aVar = this.f6168a;
        t1 t1Var = (t1) ((Supplier) this.j.f6017c).get();
        aVar.Q(this.f6169b, t1Var);
        boolean z9 = t1Var.f6363b;
        if (z9 == ((u1) this.j.f6016b).f6379b) {
            Boolean valueOf = Boolean.valueOf(z9);
            AtomicReference atomicReference = this.h;
            while (!atomicReference.compareAndSet(null, valueOf) && atomicReference.get() == null) {
            }
        }
        return null;
    }

    @Override // j$.util.stream.b
    public final Object h() {
        return Boolean.valueOf(!((u1) this.j.f6016b).f6379b);
    }
}
