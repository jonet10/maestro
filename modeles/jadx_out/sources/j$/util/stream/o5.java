package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class o5 extends c5 {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ long f6314l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ long f6315m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o5(e5 e5Var, int i, long j, long j6) {
        super(e5Var, i);
        this.f6314l = j;
        this.f6315m = j6;
    }

    @Override // j$.util.stream.a
    public final Spliterator K(a aVar, Spliterator spliterator) {
        long F = aVar.F(spliterator);
        if (F > 0 && spliterator.hasCharacteristics(16384)) {
            Spliterator S = aVar.S(spliterator);
            long j = this.f6314l;
            return new t7(S, j, w3.A(j, this.f6315m));
        }
        if (z6.ORDERED.j(aVar.f)) {
            return ((h2) new w5(this, aVar, spliterator, new d1(9), this.f6314l, this.f6315m).invoke()).spliterator();
        }
        Spliterator S2 = aVar.S(spliterator);
        long j6 = this.f6314l;
        long j10 = this.f6315m;
        if (j6 <= F) {
            long j11 = F - j6;
            if (j10 >= 0) {
                j11 = Math.min(j10, j11);
            }
            j10 = j11;
            j6 = 0;
        }
        return new z7(S2, j6, j10);
    }

    @Override // j$.util.stream.a
    public final h2 J(a aVar, Spliterator spliterator, IntFunction intFunction) {
        long j;
        long j6;
        long F = aVar.F(spliterator);
        if (F <= 0 || !spliterator.hasCharacteristics(16384)) {
            if (!z6.ORDERED.j(aVar.f)) {
                Spliterator S = aVar.S(spliterator);
                long j10 = this.f6314l;
                long j11 = this.f6315m;
                if (j10 <= F) {
                    long j12 = F - j10;
                    j = j11 >= 0 ? Math.min(j11, j12) : j12;
                    j6 = 0;
                } else {
                    j = j11;
                    j6 = j10;
                }
                return w3.B(this, new z7(S, j6, j), true, intFunction);
            }
            return (h2) new w5(this, aVar, spliterator, intFunction, this.f6314l, this.f6315m).invoke();
        }
        a aVar2 = aVar;
        while (aVar2.f6129e > 0) {
            aVar2 = aVar2.f6126b;
        }
        return w3.B(aVar, w3.y(aVar2.H(), spliterator, this.f6314l, this.f6315m), true, intFunction);
    }

    @Override // j$.util.stream.a
    public final m5 M(int i, m5 m5Var) {
        return new n5(this, m5Var);
    }
}
