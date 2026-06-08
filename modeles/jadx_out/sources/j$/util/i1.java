package j$.util;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class i1 implements q0, LongConsumer, z {

    /* renamed from: a, reason: collision with root package name */
    public boolean f6071a = false;

    /* renamed from: b, reason: collision with root package name */
    public long f6072b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ b1 f6073c;

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.f(this, longConsumer);
    }

    @Override // j$.util.r0
    public final void forEachRemaining(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        while (hasNext()) {
            longConsumer.accept(nextLong());
        }
    }

    @Override // java.util.Iterator
    public final Long next() {
        if (v1.f6472a) {
            v1.a(i1.class, "{0} calling PrimitiveIterator.OfLong.nextLong()");
            throw null;
        }
        return Long.valueOf(nextLong());
    }

    @Override // j$.util.q0, java.util.Iterator, j$.util.z
    public final void forEachRemaining(Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            forEachRemaining((LongConsumer) consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        if (v1.f6472a) {
            v1.a(i1.class, "{0} calling PrimitiveIterator.OfLong.forEachRemainingLong(action::accept)");
            throw null;
        }
        Objects.requireNonNull(consumer);
        forEachRemaining((LongConsumer) new n0(consumer, 0));
    }

    public i1(b1 b1Var) {
        this.f6073c = b1Var;
    }

    @Override // java.util.function.LongConsumer
    public final void accept(long j) {
        this.f6071a = true;
        this.f6072b = j;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (!this.f6071a) {
            this.f6073c.tryAdvance((LongConsumer) this);
        }
        return this.f6071a;
    }

    @Override // j$.util.q0
    public final long nextLong() {
        if (!this.f6071a && !hasNext()) {
            throw new NoSuchElementException();
        }
        this.f6071a = false;
        return this.f6072b;
    }
}
