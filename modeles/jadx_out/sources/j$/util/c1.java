package j$.util;

import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class c1 implements e1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Spliterator.OfPrimitive f5978a;

    public /* synthetic */ c1(Spliterator.OfPrimitive ofPrimitive) {
        this.f5978a = ofPrimitive;
    }

    public static /* synthetic */ e1 a(Spliterator.OfPrimitive ofPrimitive) {
        if (ofPrimitive == null) {
            return null;
        }
        return ofPrimitive instanceof d1 ? ((d1) ofPrimitive).f6035a : ofPrimitive instanceof Spliterator.OfDouble ? t0.a((Spliterator.OfDouble) ofPrimitive) : ofPrimitive instanceof Spliterator.OfInt ? w0.a((Spliterator.OfInt) ofPrimitive) : ofPrimitive instanceof Spliterator.OfLong ? z0.a((Spliterator.OfLong) ofPrimitive) : new c1(ofPrimitive);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f5978a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfPrimitive ofPrimitive = this.f5978a;
        if (obj instanceof c1) {
            obj = ((c1) obj).f5978a;
        }
        return ofPrimitive.equals(obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f5978a.estimateSize();
    }

    @Override // j$.util.e1
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f5978a.forEachRemaining((Spliterator.OfPrimitive) obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f5978a.forEachRemaining(consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f5978a.getComparator();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f5978a.getExactSizeIfKnown();
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f5978a.hasCharacteristics(i);
    }

    public final /* synthetic */ int hashCode() {
        return this.f5978a.hashCode();
    }

    @Override // j$.util.e1
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f5978a.tryAdvance((Spliterator.OfPrimitive) obj);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f5978a.tryAdvance(consumer);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ Spliterator trySplit() {
        return f1.a(this.f5978a.trySplit());
    }

    @Override // j$.util.e1, j$.util.Spliterator
    public final /* synthetic */ e1 trySplit() {
        return a(this.f5978a.trySplit());
    }
}
