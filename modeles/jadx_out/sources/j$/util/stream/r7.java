package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class r7 extends s7 implements j$.util.b1 {
    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.c(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.h(this, consumer);
    }

    @Override // j$.util.stream.u7
    public final Spliterator a(Spliterator spliterator, long j, long j6, long j10, long j11) {
        return new r7((j$.util.b1) spliterator, j, j6, j10, j11);
    }

    @Override // j$.util.stream.s7
    public final Object b() {
        return new e2(1);
    }
}
