package j$.util;

import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class a implements Spliterator {

    /* renamed from: a, reason: collision with root package name */
    public final java.util.List f5967a;

    /* renamed from: b, reason: collision with root package name */
    public int f5968b;

    /* renamed from: c, reason: collision with root package name */
    public int f5969c;

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 16464;
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
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public a(java.util.List list) {
        this.f5967a = list;
        this.f5968b = 0;
        this.f5969c = -1;
    }

    public a(a aVar, int i, int i6) {
        this.f5967a = aVar.f5967a;
        this.f5968b = i;
        this.f5969c = i6;
    }

    public final int a() {
        java.util.List list = this.f5967a;
        int i = this.f5969c;
        if (i >= 0) {
            return i;
        }
        int size = list.size();
        this.f5969c = size;
        return size;
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        int a8 = a();
        int i = this.f5968b;
        int i6 = (a8 + i) >>> 1;
        if (i >= i6) {
            return null;
        }
        this.f5968b = i6;
        return new a(this, i, i6);
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        int a8 = a();
        int i = this.f5968b;
        if (i >= a8) {
            return false;
        }
        this.f5968b = i + 1;
        try {
            consumer.accept(this.f5967a.get(i));
            return true;
        } catch (IndexOutOfBoundsException unused) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        java.util.List list = this.f5967a;
        int a8 = a();
        this.f5968b = a8;
        for (int i = this.f5968b; i < a8; i++) {
            try {
                consumer.accept(list.get(i));
            } catch (IndexOutOfBoundsException unused) {
                throw new ConcurrentModificationException();
            }
        }
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return a() - this.f5968b;
    }
}
