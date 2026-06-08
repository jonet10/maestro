package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;
import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class s8 extends d {
    public final a h;
    public final IntFunction i;
    public final boolean j;

    /* renamed from: k, reason: collision with root package name */
    public long f6355k;

    /* renamed from: l, reason: collision with root package name */
    public long f6356l;

    @Override // j$.util.stream.d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        d dVar = this.f6171d;
        if (dVar != null) {
            if (this.j) {
                s8 s8Var = (s8) dVar;
                long j = s8Var.f6356l;
                this.f6356l = j;
                if (j == s8Var.f6355k) {
                    this.f6356l = j + ((s8) this.f6172e).f6356l;
                }
            }
            s8 s8Var2 = (s8) dVar;
            long j6 = s8Var2.f6355k;
            s8 s8Var3 = (s8) this.f6172e;
            this.f6355k = j6 + s8Var3.f6355k;
            h2 F = s8Var2.f6355k == 0 ? (h2) s8Var3.f : s8Var3.f6355k == 0 ? (h2) s8Var2.f : w3.F(this.h.H(), (h2) ((s8) this.f6171d).f, (h2) ((s8) this.f6172e).f);
            if (b() && this.j) {
                F = F.j(this.f6356l, F.count(), this.i);
            }
            this.f = F;
        }
        super.onCompletion(countedCompleter);
    }

    public s8(a aVar, a aVar2, Spliterator spliterator, IntFunction intFunction) {
        super(aVar2, spliterator);
        this.h = aVar;
        this.i = intFunction;
        this.j = z6.ORDERED.j(aVar2.f);
    }

    public s8(s8 s8Var, Spliterator spliterator) {
        super(s8Var, spliterator);
        this.h = s8Var.h;
        this.i = s8Var.i;
        this.j = s8Var.j;
    }

    @Override // j$.util.stream.d
    public final d c(Spliterator spliterator) {
        return new s8(this, spliterator);
    }

    @Override // j$.util.stream.d
    public final Object a() {
        long j;
        boolean b7 = b();
        if (!b7 && this.j) {
            z6 z6Var = z6.SIZED;
            a aVar = this.h;
            int i = aVar.f6127c;
            int i6 = z6Var.f6457e;
            if ((i & i6) == i6) {
                j = aVar.F(this.f6169b);
                z1 I = this.f6168a.I(j, this.i);
                r8 g = ((q8) this.h).g(I, (this.j || b7) ? false : true);
                this.f6168a.Q(this.f6169b, g);
                h2 build = I.build();
                this.f6355k = build.count();
                this.f6356l = g.h();
                return build;
            }
        }
        j = -1;
        z1 I2 = this.f6168a.I(j, this.i);
        r8 g3 = ((q8) this.h).g(I2, (this.j || b7) ? false : true);
        this.f6168a.Q(this.f6169b, g3);
        h2 build2 = I2.build();
        this.f6355k = build2.count();
        this.f6356l = g3.h();
        return build2;
    }
}
