package j$.util.stream;

import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class s extends f5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6341b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s(a aVar, m5 m5Var, int i) {
        super(m5Var);
        this.f6341b = i;
    }

    @Override // j$.util.stream.f5, j$.util.stream.m5
    public void c(long j) {
        switch (this.f6341b) {
            case 3:
                this.f6195a.c(-1L);
                break;
            default:
                super.c(j);
                break;
        }
    }

    @Override // j$.util.stream.j5, java.util.function.DoubleConsumer
    public final void accept(double d10) {
        switch (this.f6341b) {
            case 0:
                DoubleUnaryOperator doubleUnaryOperator = null;
                doubleUnaryOperator.applyAsDouble(d10);
                throw null;
            case 1:
                DoubleToIntFunction doubleToIntFunction = null;
                doubleToIntFunction.applyAsInt(d10);
                throw null;
            case 2:
                DoubleToLongFunction doubleToLongFunction = null;
                doubleToLongFunction.applyAsLong(d10);
                throw null;
            default:
                DoublePredicate doublePredicate = null;
                doublePredicate.test(d10);
                throw null;
        }
    }
}
