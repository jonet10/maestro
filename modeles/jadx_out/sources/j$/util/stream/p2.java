package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class p2 extends r2 implements d2 {
    @Override // j$.util.stream.h2
    public final /* synthetic */ void forEach(Consumer consumer) {
        w3.r(this, consumer);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ h2 j(long j, long j6, IntFunction intFunction) {
        return w3.u(this, j, j6);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ void k(Object[] objArr, int i) {
        w3.o(this, (Integer[]) objArr, i);
    }

    @Override // j$.util.stream.g2
    public final Object newArray(int i) {
        return new int[i];
    }

    @Override // j$.util.stream.h2
    public final Spliterator spliterator() {
        return new g3(this);
    }

    @Override // j$.util.stream.h2
    public final j$.util.e1 spliterator() {
        return new g3(this);
    }
}
