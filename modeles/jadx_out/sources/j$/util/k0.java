package j$.util;

import java.util.PrimitiveIterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class k0 implements m0, z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrimitiveIterator.OfInt f6084a;

    public /* synthetic */ k0(PrimitiveIterator.OfInt ofInt) {
        this.f6084a = ofInt;
    }

    public final /* synthetic */ boolean equals(Object obj) {
        PrimitiveIterator.OfInt ofInt = this.f6084a;
        if (obj instanceof k0) {
            obj = ((k0) obj).f6084a;
        }
        return ofInt.equals(obj);
    }

    @Override // j$.util.r0
    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.f6084a.forEachRemaining((PrimitiveIterator.OfInt) obj);
    }

    @Override // j$.util.m0, java.util.Iterator, j$.util.z
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.f6084a.forEachRemaining((Consumer<? super Integer>) consumer);
    }

    @Override // j$.util.m0
    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.f6084a.forEachRemaining(intConsumer);
    }

    @Override // java.util.Iterator
    public final /* synthetic */ boolean hasNext() {
        return this.f6084a.hasNext();
    }

    public final /* synthetic */ int hashCode() {
        return this.f6084a.hashCode();
    }

    @Override // j$.util.m0, java.util.Iterator
    public final /* synthetic */ Integer next() {
        return this.f6084a.next();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.f6084a.next();
    }

    @Override // j$.util.m0
    public final /* synthetic */ int nextInt() {
        return this.f6084a.nextInt();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ void remove() {
        this.f6084a.remove();
    }
}
