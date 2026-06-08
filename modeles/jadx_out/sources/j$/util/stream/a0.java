package j$.util.stream;

import j$.util.Spliterator;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class a0 extends b0 {
    @Override // j$.util.stream.a
    public final boolean L() {
        return false;
    }

    @Override // j$.util.stream.a, j$.util.stream.g
    public final e0 sequential() {
        this.f6125a.f6130k = false;
        return this;
    }

    @Override // j$.util.stream.a, j$.util.stream.g
    public final e0 parallel() {
        this.f6125a.f6130k = true;
        return this;
    }

    @Override // j$.util.stream.g
    public final g unordered() {
        return !z6.ORDERED.j(this.f) ? this : new t(this, z6.f6449r, 1);
    }

    @Override // j$.util.stream.a, j$.util.stream.g
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }
}
