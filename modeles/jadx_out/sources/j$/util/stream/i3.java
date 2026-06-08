package j$.util.stream;

import j$.util.Spliterator;
import java.util.Deque;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class i3 extends k3 implements j$.util.e1 {
    @Override // j$.util.e1
    public final boolean tryAdvance(Object obj) {
        g2 g2Var;
        if (!c()) {
            return false;
        }
        boolean tryAdvance = ((j$.util.e1) this.f6261d).tryAdvance(obj);
        if (!tryAdvance) {
            if (this.f6260c == null && (g2Var = (g2) k3.a(this.f6262e)) != null) {
                j$.util.e1 spliterator = g2Var.spliterator();
                this.f6261d = spliterator;
                return spliterator.tryAdvance(obj);
            }
            this.f6258a = null;
        }
        return tryAdvance;
    }

    @Override // j$.util.e1
    public final void forEachRemaining(Object obj) {
        if (this.f6258a == null) {
            return;
        }
        if (this.f6261d == null) {
            Spliterator spliterator = this.f6260c;
            if (spliterator == null) {
                Deque b7 = b();
                while (true) {
                    g2 g2Var = (g2) k3.a(b7);
                    if (g2Var != null) {
                        g2Var.g(obj);
                    } else {
                        this.f6258a = null;
                        return;
                    }
                }
            } else {
                ((j$.util.e1) spliterator).forEachRemaining(obj);
            }
        } else {
            while (tryAdvance(obj)) {
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
