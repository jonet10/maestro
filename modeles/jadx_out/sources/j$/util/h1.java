package j$.util;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class h1 implements m0, IntConsumer, z {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6067a = false;

    /* renamed from: b, reason: collision with root package name */
    public int f6068b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ y0 f6069c;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.e(this, intConsumer);
    }

    @Override // j$.util.r0
    public final void forEachRemaining(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        while (hasNext()) {
            intConsumer.accept(nextInt());
        }
    }

    @Override // java.util.Iterator
    public final Integer next() {
        if (v1.f6472a) {
            v1.a(h1.class, "{0} calling PrimitiveIterator.OfInt.nextInt()");
            throw null;
        }
        return Integer.valueOf(nextInt());
    }

    @Override // j$.util.m0, java.util.Iterator, j$.util.z
    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            forEachRemaining((IntConsumer) consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        if (v1.f6472a) {
            v1.a(h1.class, "{0} calling PrimitiveIterator.OfInt.forEachRemainingInt(action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        forEachRemaining((IntConsumer) new j0(consumer, 0));
    }

    public h1(y0 y0Var) {
        this.f6069c = y0Var;
    }

    @Override // java.util.function.IntConsumer
    public final void accept(int i) {
        this.f6067a = true;
        this.f6068b = i;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f6067a) {
            this.f6069c.tryAdvance((IntConsumer) this);
        }
        return this.f6067a;
    }

    @Override // j$.util.m0
    public final int nextInt() {
        if (!this.f6067a && !hasNext()) {
            throw new NoSuchElementException();
        }
        this.f6067a = false;
        return this.f6068b;
    }
}
