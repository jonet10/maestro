package j$.util.concurrent;

import j$.util.Spliterator;
import java.util.Comparator;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class f extends p implements Spliterator {
    public final ConcurrentHashMap i;
    public long j;

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 4353;
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

    public f(l[] lVarArr, int i, int i6, int i10, long j, ConcurrentHashMap concurrentHashMap) {
        super(lVarArr, i, i6, i10);
        this.i = concurrentHashMap;
        this.j = j;
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        int i = this.f;
        int i6 = this.g;
        int i10 = (i + i6) >>> 1;
        if (i10 <= i) {
            return null;
        }
        l[] lVarArr = this.f6008a;
        this.g = i10;
        long j = this.j >>> 1;
        this.j = j;
        return new f(lVarArr, this.h, i10, i6, j, this.i);
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        while (true) {
            l a8 = a();
            if (a8 == null) {
                return;
            } else {
                consumer.n(new k(a8.f6001b, a8.f6002c, this.i));
            }
        }
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        l a8 = a();
        if (a8 == null) {
            return false;
        }
        consumer.n(new k(a8.f6001b, a8.f6002c, this.i));
        return true;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.j;
    }
}
