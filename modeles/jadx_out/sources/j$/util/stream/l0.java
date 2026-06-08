package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class l0 extends b {
    public final f0 j;

    /* renamed from: k, reason: collision with root package name */
    public final boolean f6272k;

    public l0(f0 f0Var, boolean z9, a aVar, Spliterator spliterator) {
        super(aVar, spliterator);
        this.f6272k = z9;
        this.j = f0Var;
    }

    public l0(l0 l0Var, Spliterator spliterator) {
        super(l0Var, spliterator);
        this.f6272k = l0Var.f6272k;
        this.j = l0Var.j;
    }

    @Override // j$.util.stream.d
    public final d c(Spliterator spliterator) {
        return new l0(this, spliterator);
    }

    @Override // j$.util.stream.b
    public final Object h() {
        return this.j.f6189b;
    }

    @Override // j$.util.stream.d
    public final Object a() {
        a aVar = this.f6168a;
        g8 g8Var = (g8) this.j.f6191d.get();
        aVar.Q(this.f6169b, g8Var);
        Object obj = g8Var.get();
        if (this.f6272k) {
            if (obj != null) {
                d dVar = this;
                while (dVar != null) {
                    d dVar2 = (d) dVar.getCompleter();
                    if (dVar2 != null && dVar2.f6171d != dVar) {
                        g();
                        return obj;
                    }
                    dVar = dVar2;
                }
                AtomicReference atomicReference = this.h;
                while (!atomicReference.compareAndSet(null, obj) && atomicReference.get() == null) {
                }
                return obj;
            }
        } else if (obj != null) {
            AtomicReference atomicReference2 = this.h;
            while (!atomicReference2.compareAndSet(null, obj) && atomicReference2.get() == null) {
            }
        }
        return null;
    }

    @Override // j$.util.stream.d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        if (this.f6272k) {
            l0 l0Var = (l0) this.f6171d;
            l0 l0Var2 = null;
            while (true) {
                if (l0Var != l0Var2) {
                    Object i = l0Var.i();
                    if (i != null && this.j.f6190c.test(i)) {
                        d(i);
                        d dVar = this;
                        while (true) {
                            if (dVar != null) {
                                d dVar2 = (d) dVar.getCompleter();
                                if (dVar2 != null && dVar2.f6171d != dVar) {
                                    g();
                                    break;
                                }
                                dVar = dVar2;
                            } else {
                                AtomicReference atomicReference = this.h;
                                while (!atomicReference.compareAndSet(null, i) && atomicReference.get() == null) {
                                }
                            }
                        }
                    } else {
                        l0Var2 = l0Var;
                        l0Var = (l0) this.f6172e;
                    }
                } else {
                    break;
                }
            }
        }
        super.onCompletion(countedCompleter);
    }
}
