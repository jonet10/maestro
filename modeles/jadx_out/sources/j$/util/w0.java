package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class w0 implements y0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Spliterator.OfInt f6473a;

    public /* synthetic */ w0(Spliterator.OfInt ofInt) {
        this.f6473a = ofInt;
    }

    public static /* synthetic */ y0 a(Spliterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        return ofInt instanceof x0 ? ((x0) ofInt).f6476a : new w0(ofInt);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f6473a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfInt ofInt = this.f6473a;
        if (obj instanceof w0) {
            obj = ((w0) obj).f6473a;
        }
        return ofInt.equals(obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f6473a.estimateSize();
    }

    @Override // j$.util.e1
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f6473a.forEachRemaining((Spliterator.OfInt) obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f6473a.forEachRemaining((Consumer<? super Integer>) consumer);
    }

    @Override // j$.util.y0
    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f6473a.forEachRemaining(intConsumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f6473a.getComparator();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f6473a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f6473a.hasCharacteristics(i);
    }

    public final /* synthetic */ int hashCode() {
        return this.f6473a.hashCode();
    }

    @Override // j$.util.e1
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f6473a.tryAdvance((Spliterator.OfInt) obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f6473a.tryAdvance((Consumer<? super Integer>) consumer);
    }

    @Override // j$.util.y0
    public final /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return this.f6473a.tryAdvance(intConsumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return f1.a(this.f6473a.trySplit());
    }

    @Override // j$.util.e1, j$.util.Spliterator
    public final /* synthetic */ e1 trySplit() {
        return c1.a(this.f6473a.trySplit());
    }

    @Override // j$.util.y0, j$.util.e1, j$.util.Spliterator
    public final /* synthetic */ y0 trySplit() {
        return a(this.f6473a.trySplit());
    }
}
