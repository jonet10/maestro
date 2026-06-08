package j$.util.stream;

import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class e1 extends h5 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6178b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e1(a aVar, m5 m5Var, int i) {
        super(m5Var);
        this.f6178b = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e1(m5 m5Var) {
        super(m5Var);
        this.f6178b = 0;
    }

    @Override // j$.util.stream.h5, j$.util.stream.m5
    public void c(long j) {
        switch (this.f6178b) {
            case 4:
                this.f6214a.c(-1L);
                break;
            default:
                super.c(j);
                break;
        }
    }

    @Override // j$.util.stream.l5, j$.util.stream.m5
    public final void accept(long j) {
        switch (this.f6178b) {
            case 0:
                this.f6214a.accept(j);
                return;
            case 1:
                LongUnaryOperator longUnaryOperator = null;
                longUnaryOperator.applyAsLong(j);
                throw null;
            case 2:
                LongToIntFunction longToIntFunction = null;
                longToIntFunction.applyAsInt(j);
                throw null;
            case 3:
                LongToDoubleFunction longToDoubleFunction = null;
                longToDoubleFunction.applyAsDouble(j);
                throw null;
            default:
                LongPredicate longPredicate = null;
                longPredicate.test(j);
                throw null;
        }
    }
}
