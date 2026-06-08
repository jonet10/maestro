package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class k7 extends b7 implements j$.util.v0 {
    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.a(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.f(this, consumer);
    }

    @Override // j$.util.stream.b7
    public final b7 e(Spliterator spliterator) {
        return new k7(this.f6142b, spliterator, this.f6141a);
    }

    @Override // j$.util.stream.b7
    public final void d() {
        p6 p6Var = new p6();
        this.h = p6Var;
        Objects.requireNonNull(p6Var);
        this.f6145e = this.f6142b.R(new j7(p6Var, 1));
        this.f = new j$.util.q(10, this);
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final Spliterator trySplit() {
        return (j$.util.v0) super.trySplit();
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final j$.util.e1 trySplit() {
        return (j$.util.v0) super.trySplit();
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final j$.util.v0 trySplit() {
        return (j$.util.v0) super.trySplit();
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        double d10;
        Objects.requireNonNull(doubleConsumer);
        boolean a8 = a();
        if (a8) {
            p6 p6Var = (p6) this.h;
            long j = this.g;
            int r9 = p6Var.r(j);
            if (p6Var.f6153c == 0 && r9 == 0) {
                d10 = ((double[]) p6Var.f6401e)[(int) j];
            } else {
                d10 = ((double[][]) p6Var.f)[r9][(int) (j - p6Var.f6154d[r9])];
            }
            doubleConsumer.accept(d10);
        }
        return a8;
    }

    @Override // j$.util.e1
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        if (this.h == null && !this.i) {
            Objects.requireNonNull(doubleConsumer);
            c();
            Objects.requireNonNull(doubleConsumer);
            j7 j7Var = new j7(doubleConsumer, 0);
            this.f6142b.Q(this.f6144d, j7Var);
            this.i = true;
            return;
        }
        while (tryAdvance(doubleConsumer)) {
        }
    }
}
