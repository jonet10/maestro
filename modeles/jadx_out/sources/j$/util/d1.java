package j$.util;

import j$.util.Spliterator;
import java.util.Comparator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class d1 implements Spliterator.OfPrimitive {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e1 f6035a;

    public /* synthetic */ d1(e1 e1Var) {
        this.f6035a = e1Var;
    }

    public static /* synthetic */ Spliterator.OfPrimitive a(e1 e1Var) {
        if (e1Var == null) {
            return null;
        }
        return e1Var instanceof c1 ? ((c1) e1Var).f5978a : e1Var instanceof v0 ? u0.a((v0) e1Var) : e1Var instanceof y0 ? x0.a((y0) e1Var) : e1Var instanceof b1 ? a1.a((b1) e1Var) : new d1(e1Var);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ int characteristics() {
        return this.f6035a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        e1 e1Var = this.f6035a;
        if (obj instanceof d1) {
            obj = ((d1) obj).f6035a;
        }
        return e1Var.equals(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long estimateSize() {
        return this.f6035a.estimateSize();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f6035a.forEachRemaining(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f6035a.forEachRemaining(consumer);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ Comparator getComparator() {
        return this.f6035a.getComparator();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.f6035a.getExactSizeIfKnown();
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return this.f6035a.hasCharacteristics(i);
    }

    public final /* synthetic */ int hashCode() {
        return this.f6035a.hashCode();
    }

    @Override // java.util.Spliterator.OfPrimitive
    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.f6035a.tryAdvance(obj);
    }

    @Override // java.util.Spliterator
    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.f6035a.tryAdvance(consumer);
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return a(this.f6035a.trySplit());
    }

    @Override // java.util.Spliterator.OfPrimitive, java.util.Spliterator
    public final /* synthetic */ java.util.Spliterator trySplit() {
        return Spliterator.Wrapper.convert(this.f6035a.trySplit());
    }
}
