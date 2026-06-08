package j$.util.concurrent;

import j$.util.b1;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class x implements b1 {

    /* renamed from: a, reason: collision with root package name */
    public long f6026a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6027b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6028c;

    /* renamed from: d, reason: collision with root package name */
    public final long f6029d;

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 17728;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.c(this, consumer);
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
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.c.h(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public x(long j, long j6, long j10, long j11) {
        this.f6026a = j;
        this.f6027b = j6;
        this.f6028c = j10;
        this.f6029d = j11;
    }

    @Override // j$.util.e1, j$.util.Spliterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final x trySplit() {
        long j = this.f6026a;
        long j6 = (this.f6027b + j) >>> 1;
        if (j6 <= j) {
            return null;
        }
        this.f6026a = j6;
        return new x(j, j6, this.f6028c, this.f6029d);
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f6027b - this.f6026a;
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(LongConsumer longConsumer) {
        longConsumer.getClass();
        long j = this.f6026a;
        if (j >= this.f6027b) {
            return false;
        }
        longConsumer.accept(ThreadLocalRandom.current().c(this.f6028c, this.f6029d));
        this.f6026a = j + 1;
        return true;
    }

    @Override // j$.util.e1
    public final void forEachRemaining(LongConsumer longConsumer) {
        longConsumer.getClass();
        long j = this.f6026a;
        long j6 = this.f6027b;
        if (j < j6) {
            this.f6026a = j6;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                longConsumer.accept(current.c(this.f6028c, this.f6029d));
                j++;
            } while (j < j6);
        }
    }
}
