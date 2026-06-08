package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class o6 extends u6 implements j$.util.v0 {
    public final /* synthetic */ p6 g;

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.a(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.f(this, consumer);
    }

    @Override // j$.util.stream.u6
    public final void a(int i, Object obj, Object obj2) {
        ((DoubleConsumer) obj2).accept(((double[]) obj)[i]);
    }

    @Override // j$.util.stream.u6
    public final j$.util.e1 b(Object obj, int i, int i6) {
        double[] dArr = (double[]) obj;
        int i10 = i6 + i;
        Spliterators.a(((double[]) Objects.requireNonNull(dArr)).length, i, i10);
        return new j$.util.l1(dArr, i, i10, 1040);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o6(p6 p6Var, int i, int i6, int i10, int i11) {
        super(p6Var, i, i6, i10, i11);
        this.g = p6Var;
    }

    @Override // j$.util.stream.u6
    public final j$.util.e1 c(int i, int i6, int i10, int i11) {
        return new o6(this.g, i, i6, i10, i11);
    }
}
