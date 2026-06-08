package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class m7 extends b7 implements j$.util.y0 {
    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.b(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.g(this, consumer);
    }

    @Override // j$.util.stream.b7
    public final b7 e(Spliterator spliterator) {
        return new m7(this.f6142b, spliterator, this.f6141a);
    }

    @Override // j$.util.stream.b7
    public final void d() {
        r6 r6Var = new r6();
        this.h = r6Var;
        Objects.requireNonNull(r6Var);
        this.f6145e = this.f6142b.R(new l7(r6Var, 1));
        this.f = new j$.util.q(11, this);
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final Spliterator trySplit() {
        return (j$.util.y0) super.trySplit();
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final j$.util.e1 trySplit() {
        return (j$.util.y0) super.trySplit();
    }

    @Override // j$.util.stream.b7, j$.util.Spliterator
    public final j$.util.y0 trySplit() {
        return (j$.util.y0) super.trySplit();
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(IntConsumer intConsumer) {
        int i;
        Objects.requireNonNull(intConsumer);
        boolean a8 = a();
        if (a8) {
            r6 r6Var = (r6) this.h;
            long j = this.g;
            int r9 = r6Var.r(j);
            if (r6Var.f6153c == 0 && r9 == 0) {
                i = ((int[]) r6Var.f6401e)[(int) j];
            } else {
                i = ((int[][]) r6Var.f)[r9][(int) (j - r6Var.f6154d[r9])];
            }
            intConsumer.accept(i);
        }
        return a8;
    }

    @Override // j$.util.e1
    public final void forEachRemaining(IntConsumer intConsumer) {
        if (this.h == null && !this.i) {
            Objects.requireNonNull(intConsumer);
            c();
            Objects.requireNonNull(intConsumer);
            l7 l7Var = new l7(intConsumer, 0);
            this.f6142b.Q(this.f6144d, l7Var);
            this.i = true;
            return;
        }
        while (tryAdvance(intConsumer)) {
        }
    }
}
