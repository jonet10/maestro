package j$.util.concurrent;

import j$.util.y0;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class w implements y0 {

    /* renamed from: a, reason: collision with root package name */
    public long f6022a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6023b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6024c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6025d;

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 17728;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.c.b(this, consumer);
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
        return j$.util.c.g(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public w(long j, long j6, int i, int i6) {
        this.f6022a = j;
        this.f6023b = j6;
        this.f6024c = i;
        this.f6025d = i6;
    }

    @Override // j$.util.y0, j$.util.e1, j$.util.Spliterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final w trySplit() {
        long j = this.f6022a;
        long j6 = (this.f6023b + j) >>> 1;
        if (j6 <= j) {
            return null;
        }
        this.f6022a = j6;
        return new w(j, j6, this.f6024c, this.f6025d);
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f6023b - this.f6022a;
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(IntConsumer intConsumer) {
        intConsumer.getClass();
        long j = this.f6022a;
        if (j >= this.f6023b) {
            return false;
        }
        intConsumer.accept(ThreadLocalRandom.current().b(this.f6024c, this.f6025d));
        this.f6022a = j + 1;
        return true;
    }

    @Override // j$.util.e1
    public final void forEachRemaining(IntConsumer intConsumer) {
        intConsumer.getClass();
        long j = this.f6022a;
        long j6 = this.f6023b;
        if (j < j6) {
            this.f6022a = j6;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                intConsumer.accept(current.b(this.f6024c, this.f6025d));
                j++;
            } while (j < j6);
        }
    }
}
