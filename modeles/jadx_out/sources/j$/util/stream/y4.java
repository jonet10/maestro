package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class y4 extends d {
    public final w3 h;

    @Override // j$.util.stream.d, java.util.concurrent.CountedCompleter
    public final void onCompletion(CountedCompleter countedCompleter) {
        d dVar = this.f6171d;
        if (dVar != null) {
            r4 r4Var = (r4) ((y4) dVar).f;
            r4Var.i((r4) ((y4) this.f6172e).f);
            this.f = r4Var;
        }
        super.onCompletion(countedCompleter);
    }

    public y4(w3 w3Var, a aVar, Spliterator spliterator) {
        super(aVar, spliterator);
        this.h = w3Var;
    }

    public y4(y4 y4Var, Spliterator spliterator) {
        super(y4Var, spliterator);
        this.h = y4Var.h;
    }

    @Override // j$.util.stream.d
    public final d c(Spliterator spliterator) {
        return new y4(this, spliterator);
    }

    @Override // j$.util.stream.d
    public final Object a() {
        a aVar = this.f6168a;
        r4 Z = this.h.Z();
        aVar.Q(this.f6169b, Z);
        return Z;
    }
}
