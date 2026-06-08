package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Comparator;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class y7 extends b8 implements j$.util.e1 {
    public abstract void g(Object obj);

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return j$.util.c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return j$.util.c.e(this, i);
    }

    public abstract f7 j(int i);

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        while (f() != a8.NO_MORE && ((j$.util.e1) this.f6146a).tryAdvance(this)) {
            if (a(1L) == 1) {
                g(obj);
                return true;
            }
        }
        return false;
    }

    @Override // j$.util.e1
    public final void forEachRemaining(Object obj) {
        Objects.requireNonNull(obj);
        f7 f7Var = null;
        while (true) {
            a8 f = f();
            if (f == a8.NO_MORE) {
                return;
            }
            a8 a8Var = a8.MAYBE_MORE;
            Spliterator spliterator = this.f6146a;
            if (f == a8Var) {
                int i = this.f6148c;
                if (f7Var == null) {
                    f7Var = j(i);
                } else {
                    f7Var.f6197b = 0;
                }
                long j = 0;
                while (((j$.util.e1) spliterator).tryAdvance(f7Var)) {
                    j++;
                    if (j >= i) {
                        break;
                    }
                }
                if (j == 0) {
                    return;
                } else {
                    f7Var.a(obj, a(j));
                }
            } else {
                ((j$.util.e1) spliterator).forEachRemaining(obj);
                return;
            }
        }
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        forEachRemaining((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return tryAdvance((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        forEachRemaining((Object) longConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return tryAdvance((Object) longConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        forEachRemaining((Object) doubleConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return tryAdvance((Object) doubleConsumer);
    }
}
