package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class s6 extends u6 implements j$.util.b1 {
    public final /* synthetic */ t6 g;

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.c(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.h(this, consumer);
    }

    @Override // j$.util.stream.u6
    public final void a(int i, Object obj, Object obj2) {
        ((LongConsumer) obj2).accept(((long[]) obj)[i]);
    }

    @Override // j$.util.stream.u6
    public final j$.util.e1 b(Object obj, int i, int i6) {
        long[] jArr = (long[]) obj;
        int i10 = i6 + i;
        Spliterators.a(((long[]) Objects.requireNonNull(jArr)).length, i, i10);
        return new j$.util.s1(jArr, i, i10, 1040);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s6(t6 t6Var, int i, int i6, int i10, int i11) {
        super(t6Var, i, i6, i10, i11);
        this.g = t6Var;
    }

    @Override // j$.util.stream.u6
    public final j$.util.e1 c(int i, int i6, int i10, int i11) {
        return new s6(this.g, i, i6, i10, i11);
    }
}
