package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class y0 extends b1 {
    @Override // j$.util.stream.a, j$.util.stream.g
    public final IntStream sequential() {
        this.f6125a.f6130k = false;
        return this;
    }

    @Override // j$.util.stream.a, j$.util.stream.g
    public final IntStream parallel() {
        this.f6125a.f6130k = true;
        return this;
    }

    @Override // j$.util.stream.b1, j$.util.stream.IntStream
    public final void forEach(IntConsumer intConsumer) {
        if (this.f6125a.f6130k) {
            super.forEach(intConsumer);
        } else {
            b1.T(O()).forEachRemaining(intConsumer);
        }
    }

    @Override // j$.util.stream.b1, j$.util.stream.IntStream
    public final void forEachOrdered(IntConsumer intConsumer) {
        if (this.f6125a.f6130k) {
            super.forEachOrdered(intConsumer);
        } else {
            b1.T(O()).forEachRemaining(intConsumer);
        }
    }

    @Override // j$.util.stream.g
    public final g unordered() {
        return !z6.ORDERED.j(this.f) ? this : new u(this, z6.f6449r, 2);
    }

    @Override // j$.util.stream.a, j$.util.stream.g
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    @Override // j$.util.stream.a
    public final boolean L() {
        throw new UnsupportedOperationException();
    }

    @Override // j$.util.stream.a
    public final m5 M(int i, m5 m5Var) {
        throw new UnsupportedOperationException();
    }
}
