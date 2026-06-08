package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class o7 extends b7 implements j$.util.b1 {
    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.c(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.h(this, consumer);
    }

    @Override // j$.util.stream.b7
    public final b7 e(Spliterator spliterator) {
        return new o7(this.f6142b, spliterator, this.f6141a);
    }

    @Override // j$.util.stream.b7
    public final void d() {
        t6 t6Var = new t6();
        this.h = t6Var;
        Objects.requireNonNull(t6Var);
        this.f6145e = this.f6142b.R(new n7(t6Var, 1));
        this.f = new j$.util.q(12, this);
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final Spliterator trySplit() {
        return (j$.util.b1) super.trySplit();
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final j$.util.b1 trySplit() {
        return (j$.util.b1) super.trySplit();
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final j$.util.e1 trySplit() {
        return (j$.util.b1) super.trySplit();
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(LongConsumer longConsumer) {
        long j;
        Objects.requireNonNull(longConsumer);
        boolean a8 = a();
        if (a8) {
            t6 t6Var = (t6) this.h;
            long j6 = this.g;
            int r9 = t6Var.r(j6);
            if (t6Var.f6153c == 0 && r9 == 0) {
                j = ((long[]) t6Var.f6401e)[(int) j6];
            } else {
                j = ((long[][]) t6Var.f)[r9][(int) (j6 - t6Var.f6154d[r9])];
            }
            longConsumer.accept(j);
        }
        return a8;
    }

    @Override // j$.util.e1
    public final void forEachRemaining(LongConsumer longConsumer) {
        if (this.h == null && !this.i) {
            Objects.requireNonNull(longConsumer);
            c();
            Objects.requireNonNull(longConsumer);
            n7 n7Var = new n7(longConsumer, 0);
            this.f6142b.Q(this.f6144d, n7Var);
            this.i = true;
            return;
        }
        while (tryAdvance(longConsumer)) {
        }
    }
}
