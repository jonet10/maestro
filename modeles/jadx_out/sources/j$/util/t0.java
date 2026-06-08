package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class t0 implements v0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Spliterator.OfDouble f6460a;

    public /* synthetic */ t0(Spliterator.OfDouble ofDouble) {
        this.f6460a = ofDouble;
    }

    public static /* synthetic */ v0 a(Spliterator.OfDouble ofDouble) {
        if (ofDouble == null) {
            return null;
        }
        return ofDouble instanceof u0 ? ((u0) ofDouble).f6470a : new t0(ofDouble);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f6460a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfDouble ofDouble = this.f6460a;
        if (obj instanceof t0) {
            obj = ((t0) obj).f6460a;
        }
        return ofDouble.equals(obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f6460a.estimateSize();
    }

    @Override // j$.util.e1
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f6460a.forEachRemaining((Spliterator.OfDouble) obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f6460a.forEachRemaining((Consumer<? super Double>) consumer);
    }

    @Override // j$.util.v0
    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.f6460a.forEachRemaining(doubleConsumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f6460a.getComparator();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f6460a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f6460a.hasCharacteristics(i);
    }

    public final /* synthetic */ int hashCode() {
        return this.f6460a.hashCode();
    }

    @Override // j$.util.e1
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f6460a.tryAdvance((Spliterator.OfDouble) obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f6460a.tryAdvance((Consumer<? super Double>) consumer);
    }

    @Override // j$.util.v0
    public final /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return this.f6460a.tryAdvance(doubleConsumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return f1.a(this.f6460a.trySplit());
    }

    @Override // j$.util.e1, j$.util.Spliterator
    public final /* synthetic */ e1 trySplit() {
        return c1.a(this.f6460a.trySplit());
    }

    @Override // j$.util.v0, j$.util.e1, j$.util.Spliterator
    public final /* synthetic */ v0 trySplit() {
        return a(this.f6460a.trySplit());
    }
}
