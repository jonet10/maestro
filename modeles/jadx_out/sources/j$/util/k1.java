package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class k1 implements Spliterator {

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f6085a;

    /* renamed from: b, reason: collision with root package name */
    public int f6086b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6087c;

    /* renamed from: d, reason: collision with root package name */
    public final int f6088d;

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return c.e(this, i);
    }

    public k1(Object[] objArr, int i, int i6, int i10) {
        this.f6085a = objArr;
        this.f6086b = i;
        this.f6087c = i6;
        this.f6088d = i10 | 16448;
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        int i = this.f6086b;
        int i6 = (this.f6087c + i) >>> 1;
        if (i >= i6) {
            return null;
        }
        this.f6086b = i6;
        return new k1(this.f6085a, i, i6, this.f6088d);
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        int i;
        consumer.getClass();
        Object[] objArr = this.f6085a;
        int length = objArr.length;
        int i6 = this.f6087c;
        if (length < i6 || (i = this.f6086b) < 0) {
            return;
        }
        this.f6086b = i6;
        if (i < i6) {
            do {
                consumer.accept(objArr[i]);
                i++;
            } while (i < i6);
        }
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        int i = this.f6086b;
        if (i < 0 || i >= this.f6087c) {
            return false;
        }
        this.f6086b = i + 1;
        consumer.accept(this.f6085a[i]);
        return true;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f6087c - this.f6086b;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f6088d;
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        if (c.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }
}
