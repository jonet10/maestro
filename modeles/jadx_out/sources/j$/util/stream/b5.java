package j$.util.stream;

import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class b5 extends e5 {
    @Override // j$.util.stream.e5, j$.util.stream.Stream
    public final void forEach(Consumer consumer) {
        if (!this.f6125a.f6130k) {
            O().forEachRemaining(consumer);
        } else {
            super.forEach(consumer);
        }
    }

    @Override // j$.util.stream.e5, j$.util.stream.Stream
    public final void forEachOrdered(Consumer consumer) {
        if (!this.f6125a.f6130k) {
            O().forEachRemaining(consumer);
        } else {
            super.forEachOrdered(consumer);
        }
    }

    @Override // j$.util.stream.g
    public final g unordered() {
        return !z6.ORDERED.j(this.f) ? this : new a5(this, z6.f6449r);
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
