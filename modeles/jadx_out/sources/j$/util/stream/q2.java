package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class q2 extends r2 implements f2 {
    @Override // j$.util.stream.h2
    public final /* synthetic */ void forEach(Consumer consumer) {
        w3.s(this, consumer);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ h2 j(long j, long j6, IntFunction intFunction) {
        return w3.v(this, j, j6);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ void k(Object[] objArr, int i) {
        w3.p(this, (Long[]) objArr, i);
    }

    @Override // j$.util.stream.g2
    public final Object newArray(int i) {
        return new long[i];
    }

    @Override // j$.util.stream.h2
    public final Spliterator spliterator() {
        return new h3(this);
    }

    @Override // j$.util.stream.h2
    public final j$.util.e1 spliterator() {
        return new h3(this);
    }
}
