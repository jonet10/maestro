package j$.util.stream;

import j$.util.Spliterator;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class u7 {

    /* renamed from: a, reason: collision with root package name */
    public final long f6387a;

    /* renamed from: b, reason: collision with root package name */
    public final long f6388b;

    /* renamed from: c, reason: collision with root package name */
    public Spliterator f6389c;

    /* renamed from: d, reason: collision with root package name */
    public long f6390d;

    /* renamed from: e, reason: collision with root package name */
    public long f6391e;

    public abstract Spliterator a(Spliterator spliterator, long j, long j6, long j10, long j11);

    public u7(Spliterator spliterator, long j, long j6, long j10, long j11) {
        this.f6389c = spliterator;
        this.f6387a = j;
        this.f6388b = j6;
        this.f6390d = j10;
        this.f6391e = j11;
    }

    public final Spliterator trySplit() {
        long j = this.f6391e;
        if (this.f6387a >= j || this.f6390d >= j) {
            return null;
        }
        while (true) {
            Spliterator trySplit = this.f6389c.trySplit();
            if (trySplit == null) {
                return null;
            }
            long estimateSize = trySplit.estimateSize() + this.f6390d;
            long min = Math.min(estimateSize, this.f6388b);
            long j6 = this.f6387a;
            if (j6 >= min) {
                this.f6390d = min;
            } else {
                long j10 = this.f6388b;
                if (min >= j10) {
                    this.f6389c = trySplit;
                    this.f6391e = min;
                } else {
                    long j11 = this.f6390d;
                    if (j11 >= j6 && estimateSize <= j10) {
                        this.f6390d = min;
                        return trySplit;
                    }
                    this.f6390d = min;
                    return a(trySplit, j6, j10, j11, min);
                }
            }
        }
    }

    public final long estimateSize() {
        long j = this.f6391e;
        long j6 = this.f6387a;
        if (j6 < j) {
            return j - Math.max(j6, this.f6390d);
        }
        return 0L;
    }

    public final int characteristics() {
        return this.f6389c.characteristics();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.e1 m241trySplit() {
        return (j$.util.e1) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.y0 m243trySplit() {
        return (j$.util.y0) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.b1 m240trySplit() {
        return (j$.util.b1) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.v0 m242trySplit() {
        return (j$.util.v0) trySplit();
    }
}
