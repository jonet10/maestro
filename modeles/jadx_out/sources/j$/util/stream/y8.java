package j$.util.stream;

import j$.util.Spliterator;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class y8 implements Spliterator {

    /* renamed from: a, reason: collision with root package name */
    public final Spliterator f6433a;

    /* renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f6434b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6435c;

    /* renamed from: d, reason: collision with root package name */
    public int f6436d;

    public abstract Spliterator b(Spliterator spliterator);

    @Override // j$.util.Spliterator
    public final long getExactSizeIfKnown() {
        return -1L;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return j$.util.c.e(this, i);
    }

    @Override // j$.util.Spliterator
    public void forEachRemaining(Consumer consumer) {
        while (tryAdvance(consumer)) {
        }
    }

    public y8(Spliterator spliterator) {
        this.f6435c = true;
        this.f6433a = spliterator;
        this.f6434b = new AtomicBoolean();
    }

    public y8(Spliterator spliterator, y8 y8Var) {
        this.f6435c = true;
        this.f6433a = spliterator;
        y8Var.getClass();
        this.f6434b = y8Var.f6434b;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f6433a.estimateSize();
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f6433a.characteristics() & (-16449);
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        return this.f6433a.getComparator();
    }

    @Override // j$.util.Spliterator
    public Spliterator trySplit() {
        Spliterator trySplit = this.f6433a.trySplit();
        if (trySplit != null) {
            return b(trySplit);
        }
        return null;
    }

    public final boolean a() {
        return (this.f6436d == 0 && this.f6434b.get()) ? false : true;
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.y0 trySplit() {
        return (j$.util.y0) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.b1 trySplit() {
        return (j$.util.b1) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.e1 trySplit() {
        return (j$.util.e1) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.v0 trySplit() {
        return (j$.util.v0) trySplit();
    }
}
