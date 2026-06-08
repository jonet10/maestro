package j$.util;

import java.util.Comparator;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class s implements Spliterator {

    /* renamed from: a, reason: collision with root package name */
    public final Spliterator f6115a;

    public s(Spliterator spliterator) {
        this.f6115a = spliterator;
    }

    @Override // j$.util.Spliterator
    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        return this.f6115a.tryAdvance(new q(0, consumer));
    }

    @Override // j$.util.Spliterator
    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        this.f6115a.forEachRemaining(new q(0, consumer));
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        Spliterator trySplit = this.f6115a.trySplit();
        if (trySplit == null) {
            return null;
        }
        return new s(trySplit);
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        return this.f6115a.estimateSize();
    }

    @Override // j$.util.Spliterator
    public final long getExactSizeIfKnown() {
        return this.f6115a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return this.f6115a.characteristics();
    }

    @Override // j$.util.Spliterator
    public final boolean hasCharacteristics(int i) {
        return this.f6115a.hasCharacteristics(i);
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        return this.f6115a.getComparator();
    }
}
