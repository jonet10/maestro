package j$.util.stream;

import j$.util.Spliterator;
import java.util.Comparator;
import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class b7 implements Spliterator {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f6141a;

    /* renamed from: b, reason: collision with root package name */
    public final a f6142b;

    /* renamed from: c, reason: collision with root package name */
    public Supplier f6143c;

    /* renamed from: d, reason: collision with root package name */
    public Spliterator f6144d;

    /* renamed from: e, reason: collision with root package name */
    public m5 f6145e;
    public BooleanSupplier f;
    public long g;
    public c h;
    public boolean i;

    public abstract void d();

    public abstract b7 e(Spliterator spliterator);

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return j$.util.c.e(this, i);
    }

    public b7(a aVar, Supplier supplier, boolean z9) {
        this.f6142b = aVar;
        this.f6143c = supplier;
        this.f6144d = null;
        this.f6141a = z9;
    }

    public b7(a aVar, Spliterator spliterator, boolean z9) {
        this.f6142b = aVar;
        this.f6143c = null;
        this.f6144d = spliterator;
        this.f6141a = z9;
    }

    public final void c() {
        if (this.f6144d == null) {
            this.f6144d = (Spliterator) this.f6143c.get();
            this.f6143c = null;
        }
    }

    public final boolean a() {
        c cVar = this.h;
        if (cVar == null) {
            if (this.i) {
                return false;
            }
            c();
            d();
            this.g = 0L;
            this.f6145e.c(this.f6144d.getExactSizeIfKnown());
            return b();
        }
        long j = this.g + 1;
        this.g = j;
        boolean z9 = j < cVar.count();
        if (z9) {
            return z9;
        }
        this.g = 0L;
        this.h.clear();
        return b();
    }

    @Override // j$.util.Spliterator
    public Spliterator trySplit() {
        if (!this.f6141a || this.h != null || this.i) {
            return null;
        }
        c();
        Spliterator trySplit = this.f6144d.trySplit();
        if (trySplit == null) {
            return null;
        }
        return e(trySplit);
    }

    public final boolean b() {
        while (this.h.count() == 0) {
            if (this.f6145e.e() || !this.f.getAsBoolean()) {
                if (this.i) {
                    return false;
                }
                this.f6145e.end();
                this.i = true;
            }
        }
        return true;
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        c();
        return this.f6144d.estimateSize();
    }

    @Override // j$.util.Spliterator
    public final long getExactSizeIfKnown() {
        c();
        if (z6.SIZED.j(this.f6142b.f)) {
            return this.f6144d.getExactSizeIfKnown();
        }
        return -1L;
    }

    @Override // j$.util.Spliterator
    public final int characteristics() {
        c();
        int i = this.f6142b.f;
        int i6 = i & ((~i) >> 1) & z6.j & z6.f;
        return (i6 & 64) != 0 ? (i6 & (-16449)) | (this.f6144d.characteristics() & 16448) : i6;
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        if (j$.util.c.e(this, 4)) {
            return null;
        }
        throw new IllegalStateException();
    }

    public final String toString() {
        return String.format("%s[%s]", getClass().getName(), this.f6144d);
    }
}
