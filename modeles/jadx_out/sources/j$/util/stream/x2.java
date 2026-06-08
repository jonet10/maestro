package j$.util.stream;

import j$.util.Spliterator;
import j$.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class x2 extends a3 implements d2 {
    @Override // j$.util.stream.h2
    public final /* synthetic */ void forEach(Consumer consumer) {
        w3.r(this, consumer);
    }

    @Override // j$.util.stream.a3, j$.util.stream.h2
    public final /* synthetic */ h2 j(long j, long j6, IntFunction intFunction) {
        return w3.u(this, j, j6);
    }

    @Override // j$.util.stream.a3, j$.util.stream.h2
    public final /* bridge */ /* synthetic */ h2 a(int i) {
        a(i);
        throw null;
    }

    @Override // j$.util.stream.a3, j$.util.stream.h2
    public final g2 a(int i) {
        throw new IndexOutOfBoundsException();
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ void k(Object[] objArr, int i) {
        w3.o(this, (Integer[]) objArr, i);
    }

    @Override // j$.util.stream.g2
    public final /* bridge */ /* synthetic */ Object b() {
        return w3.f6411e;
    }

    @Override // j$.util.stream.h2
    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return Spliterators.f5964b;
    }

    @Override // j$.util.stream.h2
    public final /* bridge */ /* synthetic */ j$.util.e1 spliterator() {
        return Spliterators.f5964b;
    }
}
