package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class s1 implements b1 {

    /* renamed from: a, reason: collision with root package name */
    public final long[] f6116a;

    /* renamed from: b, reason: collision with root package name */
    public int f6117b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6118c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6119d;

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        c.c(this, consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return c.e(this, i);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return c.h(this, consumer);
    }

    public s1(long[] jArr, int i, int i6, int i10) {
        this.f6116a = jArr;
        this.f6117b = i;
        this.f6118c = i6;
        this.f6119d = i10 | 16448;
    }

    @Override // j$.util.e1, j$.util.Spliterator
    public final b1 trySplit() {
        int i = this.f6117b;
        int i6 = (this.f6118c + i) >>> 1;
        if (i >= i6) {
            return null;
        }
        this.f6117b = i6;
        return new s1(this.f6116a, i, i6, this.f6119d);
    }

    @Override // j$.util.e1
    public final void forEachRemaining(LongConsumer longConsumer) {
        int i;
        longConsumer.getClass();
        long[] jArr = this.f6116a;
        int length = jArr.length;
        int i6 = this.f6118c;
        if (length < i6 || (i = this.f6117b) < 0) {
            return;
        }
        this.f6117b = i6;
        if (i < i6) {
            do {
                longConsumer.accept(jArr[i]);
                i++;
            } while (i < i6);
        }
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(LongConsumer longConsumer) {
        longConsumer.getClass();
        int i = this.f6117b;
        if (i < 0 || i >= this.f6118c) {
            return false;
        }
        this.f6117b = i + 1;
        longConsumer.accept(this.f6116a[i]);
        return true;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f6118c - this.f6117b;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f6119d;
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        if (c.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
