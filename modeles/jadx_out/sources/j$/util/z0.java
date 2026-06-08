package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class z0 implements b1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Spliterator.OfLong f6477a;

    public /* synthetic */ z0(Spliterator.OfLong ofLong) {
        this.f6477a = ofLong;
    }

    public static /* synthetic */ b1 a(Spliterator.OfLong ofLong) {
        if (ofLong == null) {
            return null;
        }
        return ofLong instanceof a1 ? ((a1) ofLong).f5970a : new z0(ofLong);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f6477a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfLong ofLong = this.f6477a;
        if (obj instanceof z0) {
            obj = ((z0) obj).f6477a;
        }
        return ofLong.equals(obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f6477a.estimateSize();
    }

    @Override // j$.util.e1
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f6477a.forEachRemaining((Spliterator.OfLong) obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f6477a.forEachRemaining((Consumer<? super Long>) consumer);
    }

    @Override // j$.util.b1
    public final /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        this.f6477a.forEachRemaining(longConsumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f6477a.getComparator();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f6477a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f6477a.hasCharacteristics(i);
    }

    public final /* synthetic */ int hashCode() {
        return this.f6477a.hashCode();
    }

    @Override // j$.util.e1
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f6477a.tryAdvance((Spliterator.OfLong) obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f6477a.tryAdvance((Consumer<? super Long>) consumer);
    }

    @Override // j$.util.b1
    public final /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return this.f6477a.tryAdvance(longConsumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return f1.a(this.f6477a.trySplit());
    }

    @Override // j$.util.b1, j$.util.e1, j$.util.Spliterator
    public final /* synthetic */ b1 trySplit() {
        return a(this.f6477a.trySplit());
    }

    @Override // j$.util.e1, j$.util.Spliterator
    public final /* synthetic */ e1 trySplit() {
        return c1.a(this.f6477a.trySplit());
    }
}
