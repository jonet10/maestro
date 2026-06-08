package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.concurrent.ForkJoinPool;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class d extends CountedCompleter {
    public static final int g = ForkJoinPool.getCommonPoolParallelism() << 2;

    /* renamed from: a, reason: collision with root package name */
    public final a f6168a;

    /* renamed from: b, reason: collision with root package name */
    public Spliterator f6169b;

    /* renamed from: c, reason: collision with root package name */
    public long f6170c;

    /* renamed from: d, reason: collision with root package name */
    public d f6171d;

    /* renamed from: e, reason: collision with root package name */
    public d f6172e;
    public Object f;

    public abstract Object a();

    public abstract d c(Spliterator spliterator);

    public d(a aVar, Spliterator spliterator) {
        super(null);
        this.f6168a = aVar;
        this.f6169b = spliterator;
        this.f6170c = 0L;
    }

    public d(d dVar, Spliterator spliterator) {
        super(dVar);
        this.f6169b = spliterator;
        this.f6168a = dVar.f6168a;
        this.f6170c = dVar.f6170c;
    }

    public static long e(long j) {
        long j6 = j / g;
        if (j6 > 0) {
            return j6;
        }
        return 1L;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public Object getRawResult() {
        return this.f;
    }

    @Override // java.util.concurrent.CountedCompleter, java.util.concurrent.ForkJoinTask
    public final void setRawResult(Object obj) {
        if (obj != null) {
            throw new IllegalStateException();
        }
    }

    public void d(Object obj) {
        this.f = obj;
    }

    public final boolean b() {
        return ((d) getCompleter()) == null;
    }

    @Override // java.util.concurrent.CountedCompleter
    public void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f6169b;
        long estimateSize = spliterator.estimateSize();
        long j = this.f6170c;
        if (j == 0) {
            j = e(estimateSize);
            this.f6170c = j;
        }
        boolean z9 = false;
        d dVar = this;
        while (estimateSize > j && (trySplit = spliterator.trySplit()) != null) {
            d c9 = dVar.c(trySplit);
            dVar.f6171d = c9;
            d c10 = dVar.c(spliterator);
            dVar.f6172e = c10;
            dVar.setPendingCount(1);
            if (z9) {
                spliterator = trySplit;
                dVar = c9;
                c9 = c10;
            } else {
                dVar = c10;
            }
            z9 = !z9;
            c9.fork();
            estimateSize = spliterator.estimateSize();
        }
        dVar.d(dVar.a());
        dVar.tryComplete();
    }

    @Override // java.util.concurrent.CountedCompleter
    public void onCompletion(CountedCompleter countedCompleter) {
        this.f6169b = null;
        this.f6172e = null;
        this.f6171d = null;
    }
}
