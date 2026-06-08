package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class b8 {

    /* renamed from: a, reason: collision with root package name */
    public final Spliterator f6146a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f6147b;

    /* renamed from: c, reason: collision with root package name */
    public final int f6148c;

    /* renamed from: d, reason: collision with root package name */
    public final long f6149d;

    /* renamed from: e, reason: collision with root package name */
    public final AtomicLong f6150e;

    public abstract Spliterator b(Spliterator spliterator);

    public b8(Spliterator spliterator, long j, long j6) {
        this.f6146a = spliterator;
        this.f6147b = j6 < 0;
        this.f6149d = j6 >= 0 ? j6 : 0L;
        this.f6148c = 128;
        this.f6150e = new AtomicLong(j6 >= 0 ? j + j6 : j);
    }

    public b8(Spliterator spliterator, b8 b8Var) {
        this.f6146a = spliterator;
        this.f6147b = b8Var.f6147b;
        this.f6150e = b8Var.f6150e;
        this.f6149d = b8Var.f6149d;
        this.f6148c = b8Var.f6148c;
    }

    public final long a(long j) {
        long j6;
        boolean z9;
        long min;
        do {
            j6 = this.f6150e.get();
            z9 = this.f6147b;
            if (j6 != 0) {
                min = Math.min(j6, j);
                if (min <= 0) {
                    break;
                }
            } else {
                if (z9) {
                    return j;
                }
                return 0L;
            }
        } while (!this.f6150e.compareAndSet(j6, j6 - min));
        if (z9) {
            return Math.max(j - min, 0L);
        }
        long j10 = this.f6149d;
        return j6 > j10 ? Math.max(min - (j6 - j10), 0L) : min;
    }

    public final a8 f() {
        if (this.f6150e.get() > 0) {
            return a8.MAYBE_MORE;
        }
        return this.f6147b ? a8.UNLIMITED : a8.NO_MORE;
    }

    public final Spliterator trySplit() {
        Spliterator trySplit;
        if (this.f6150e.get() == 0 || (trySplit = this.f6146a.trySplit()) == null) {
            return null;
        }
        return b(trySplit);
    }

    public final long estimateSize() {
        return this.f6146a.estimateSize();
    }

    public final int characteristics() {
        return this.f6146a.characteristics() & (-16465);
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.e1 m237trySplit() {
        return (j$.util.e1) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.y0 m239trySplit() {
        return (j$.util.y0) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.b1 m236trySplit() {
        return (j$.util.b1) trySplit();
    }

    /* renamed from: trySplit, reason: collision with other method in class */
    public /* bridge */ /* synthetic */ j$.util.v0 m238trySplit() {
        return (j$.util.v0) trySplit();
    }
}
