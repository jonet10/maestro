package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class q6 extends u6 implements j$.util.y0 {
    public final /* synthetic */ r6 g;

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.b(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.g(this, consumer);
    }

    @Override // j$.util.stream.u6
    public final void a(int i, Object obj, Object obj2) {
        ((IntConsumer) obj2).accept(((int[]) obj)[i]);
    }

    @Override // j$.util.stream.u6
    public final j$.util.e1 b(Object obj, int i, int i6) {
        int[] iArr = (int[]) obj;
        int i10 = i6 + i;
        Spliterators.a(((int[]) Objects.requireNonNull(iArr)).length, i, i10);
        return new j$.util.q1(iArr, i, i10, 1040);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q6(r6 r6Var, int i, int i6, int i10, int i11) {
        super(r6Var, i, i6, i10, i11);
        this.g = r6Var;
    }

    @Override // j$.util.stream.u6
    public final j$.util.e1 c(int i, int i6, int i10, int i11) {
        return new q6(this.g, i, i6, i10, i11);
    }
}
