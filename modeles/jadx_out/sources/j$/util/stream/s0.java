package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountedCompleter;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class s0 extends CountedCompleter {

    /* renamed from: a, reason: collision with root package name */
    public final a f6342a;

    /* renamed from: b, reason: collision with root package name */
    public Spliterator f6343b;

    /* renamed from: c, reason: collision with root package name */
    public final long f6344c;

    /* renamed from: d, reason: collision with root package name */
    public final ConcurrentHashMap f6345d;

    /* renamed from: e, reason: collision with root package name */
    public final r0 f6346e;
    public final s0 f;
    public h2 g;

    public s0(a aVar, Spliterator spliterator, r0 r0Var) {
        super(null);
        this.f6342a = aVar;
        this.f6343b = spliterator;
        this.f6344c = d.e(spliterator.estimateSize());
        this.f6345d = new ConcurrentHashMap(Math.max(16, d.g << 1));
        this.f6346e = r0Var;
        this.f = null;
    }

    public s0(s0 s0Var, Spliterator spliterator, s0 s0Var2) {
        super(s0Var);
        this.f6342a = s0Var.f6342a;
        this.f6343b = spliterator;
        this.f6344c = s0Var.f6344c;
        this.f6345d = s0Var.f6345d;
        this.f6346e = s0Var.f6346e;
        this.f = s0Var2;
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void compute() {
        Spliterator trySplit;
        Spliterator spliterator = this.f6343b;
        long j = this.f6344c;
        boolean z9 = false;
        s0 s0Var = this;
        while (spliterator.estimateSize() > j && (trySplit = spliterator.trySplit()) != null) {
            s0 s0Var2 = new s0(s0Var, trySplit, s0Var.f);
            s0 s0Var3 = new s0(s0Var, spliterator, s0Var2);
            s0Var.addToPendingCount(1);
            s0Var3.addToPendingCount(1);
            s0Var.f6345d.put(s0Var2, s0Var3);
            if (s0Var.f != null) {
                s0Var2.addToPendingCount(1);
                if (s0Var.f6345d.replace(s0Var.f, s0Var, s0Var2)) {
                    s0Var.addToPendingCount(-1);
                } else {
                    s0Var2.addToPendingCount(-1);
                }
            }
            if (z9) {
                spliterator = trySplit;
                s0Var = s0Var2;
                s0Var2 = s0Var3;
            } else {
                s0Var = s0Var3;
            }
            z9 = !z9;
            s0Var2.fork();
        }
        if (s0Var.getPendingCount() > 0) {
            q qVar = new q(15);
            a aVar = s0Var.f6342a;
            z1 I = aVar.I(aVar.F(spliterator), qVar);
            s0Var.f6342a.Q(spliterator, I);
            s0Var.g = I.build();
            s0Var.f6343b = null;
        }
        s0Var.tryComplete();
    }

    @Override // java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        h2 h2Var = this.g;
        if (h2Var != null) {
            h2Var.forEach(this.f6346e);
            this.g = null;
        } else {
            Spliterator spliterator = this.f6343b;
            if (spliterator != null) {
                this.f6342a.Q(spliterator, this.f6346e);
                this.f6343b = null;
            }
        }
        s0 s0Var = (s0) this.f6345d.remove(this);
        if (s0Var != null) {
            s0Var.tryComplete();
        }
    }
}
