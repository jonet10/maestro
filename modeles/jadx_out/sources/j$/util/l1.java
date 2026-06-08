package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class l1 implements v0 {

    /* renamed from: a, reason: collision with root package name */
    public final double[] f6090a;

    /* renamed from: b, reason: collision with root package name */
    public int f6091b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6092c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6093d;

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        c.a(this, consumer);
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
        return c.f(this, consumer);
    }

    public l1(double[] dArr, int i, int i6, int i10) {
        this.f6090a = dArr;
        this.f6091b = i;
        this.f6092c = i6;
        this.f6093d = i10 | 16448;
    }

    @Override // j$.util.e1, j$.util.Spliterator
    public final v0 trySplit() {
        int i = this.f6091b;
        int i6 = (this.f6092c + i) >>> 1;
        if (i >= i6) {
            return null;
        }
        this.f6091b = i6;
        return new l1(this.f6090a, i, i6, this.f6093d);
    }

    @Override // j$.util.e1
    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        int i;
        doubleConsumer.getClass();
        double[] dArr = this.f6090a;
        int length = dArr.length;
        int i6 = this.f6092c;
        if (length < i6 || (i = this.f6091b) < 0) {
            return;
        }
        this.f6091b = i6;
        if (i < i6) {
            do {
                doubleConsumer.accept(dArr[i]);
                i++;
            } while (i < i6);
        }
    }

    @Override // j$.util.e1
    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        doubleConsumer.getClass();
        int i = this.f6091b;
        if (i < 0 || i >= this.f6092c) {
            return false;
        }
        this.f6091b = i + 1;
        doubleConsumer.accept(this.f6090a[i]);
        return true;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f6092c - this.f6091b;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f6093d;
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        if (c.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
