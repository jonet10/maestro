package j$.util.stream;

import j$.util.Spliterator;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class k3 implements Spliterator {

    /* renamed from: a, reason: collision with root package name */
    public h2 f6258a;

    /* renamed from: b, reason: collision with root package name */
    public int f6259b;

    /* renamed from: c, reason: collision with root package name */
    public Spliterator f6260c;

    /* renamed from: d, reason: collision with root package name */
    public Spliterator f6261d;

    /* renamed from: e, reason: collision with root package name */
    public Deque f6262e;

    @Override // j$.util.Spliterator
    public final int characteristics() {
        return 64;
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ long getExactSizeIfKnown() {
        return j$.util.c.d(this);
    }

    @Override // j$.util.Spliterator
    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return j$.util.c.e(this, i);
    }

    @Override // j$.util.Spliterator
    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public k3(h2 h2Var) {
        this.f6258a = h2Var;
    }

    public final Deque b() {
        ArrayDeque arrayDeque = new ArrayDeque(8);
        int o10 = this.f6258a.o();
        while (true) {
            o10--;
            if (o10 < this.f6259b) {
                return arrayDeque;
            }
            arrayDeque.addFirst(this.f6258a.a(o10));
        }
    }

    public static h2 a(Deque deque) {
        while (true) {
            ArrayDeque arrayDeque = (ArrayDeque) deque;
            h2 h2Var = (h2) arrayDeque.pollFirst();
            if (h2Var == null) {
                return null;
            }
            if (h2Var.o() != 0) {
                for (int o10 = h2Var.o() - 1; o10 >= 0; o10--) {
                    arrayDeque.addFirst(h2Var.a(o10));
                }
            } else if (h2Var.count() > 0) {
                return h2Var;
            }
        }
    }

    public final boolean c() {
        if (this.f6258a == null) {
            return false;
        }
        if (this.f6261d != null) {
            return true;
        }
        Spliterator spliterator = this.f6260c;
        if (spliterator == null) {
            Deque b7 = b();
            this.f6262e = b7;
            h2 a8 = a(b7);
            if (a8 != null) {
                this.f6261d = a8.spliterator();
                return true;
            }
            this.f6258a = null;
            return false;
        }
        this.f6261d = spliterator;
        return true;
    }

    @Override // j$.util.Spliterator
    public final Spliterator trySplit() {
        h2 h2Var = this.f6258a;
        if (h2Var == null || this.f6261d != null) {
            return null;
        }
        Spliterator spliterator = this.f6260c;
        if (spliterator != null) {
            return spliterator.trySplit();
        }
        int i = this.f6259b;
        int o10 = h2Var.o() - 1;
        h2 h2Var2 = this.f6258a;
        int i6 = this.f6259b;
        if (i < o10) {
            this.f6259b = i6 + 1;
            return h2Var2.a(i6).spliterator();
        }
        h2 a8 = h2Var2.a(i6);
        this.f6258a = a8;
        int o11 = a8.o();
        h2 h2Var3 = this.f6258a;
        if (o11 == 0) {
            Spliterator spliterator2 = h2Var3.spliterator();
            this.f6260c = spliterator2;
            return spliterator2.trySplit();
        }
        this.f6259b = 1;
        return h2Var3.a(0).spliterator();
    }

    @Override // j$.util.Spliterator
    public final long estimateSize() {
        long j = 0;
        if (this.f6258a == null) {
            return 0L;
        }
        Spliterator spliterator = this.f6260c;
        if (spliterator != null) {
            return spliterator.estimateSize();
        }
        for (int i = this.f6259b; i < this.f6258a.o(); i++) {
            j += this.f6258a.a(i).count();
        }
        return j;
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.e1 trySplit() {
        return (j$.util.e1) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.y0 trySplit() {
        return (j$.util.y0) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.b1 trySplit() {
        return (j$.util.b1) trySplit();
    }

    @Override // j$.util.Spliterator
    public /* bridge */ /* synthetic */ j$.util.v0 trySplit() {
        return (j$.util.v0) trySplit();
    }
}
