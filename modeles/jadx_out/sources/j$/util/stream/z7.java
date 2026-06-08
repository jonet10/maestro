package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.function.Consumer$CC;
import java.util.Comparator;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class z7 extends b8 implements Spliterator, Consumer {
    public Object f;

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return j$.util.c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return j$.util.c.e(this, i);
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    @Override // java.util.function.Consumer
    /* renamed from: accept */
    public final void n(Object obj) {
        this.f = obj;
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        while (f() != a8.NO_MORE && this.f6146a.tryAdvance(this)) {
            if (a(1L) == 1) {
                consumer.n(this.f);
                this.f = null;
                return true;
            }
        }
        return false;
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        g7 g7Var = null;
        while (true) {
            a8 f = f();
            if (f == a8.NO_MORE) {
                return;
            }
            a8 a8Var = a8.MAYBE_MORE;
            Spliterator spliterator = this.f6146a;
            if (f == a8Var) {
                int i = this.f6148c;
                if (g7Var == null) {
                    g7Var = new g7(i);
                } else {
                    g7Var.f6217a = 0;
                }
                long j = 0;
                while (spliterator.tryAdvance(g7Var)) {
                    j++;
                    if (j >= i) {
                        break;
                    }
                }
                if (j == 0) {
                    return;
                }
                long a8 = a(j);
                for (int i6 = 0; i6 < a8; i6++) {
                    consumer.n(g7Var.f6207b[i6]);
                }
            } else {
                spliterator.forEachRemaining(consumer);
                return;
            }
        }
    }

    @Override // j$.util.stream.b8
    public final Spliterator b(Spliterator spliterator) {
        return new z7(spliterator, this);
    }
}
