package j$.util.stream;

import java.util.function.LongBinaryOperator;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class x3 extends w3 {
    public final /* synthetic */ LongBinaryOperator h;
    public final /* synthetic */ long i;

    @Override // j$.util.stream.w3
    public final r4 Z() {
        return new p4(this.i, this.h);
    }

    public x3(a7 a7Var, LongBinaryOperator longBinaryOperator, long j) {
        this.h = longBinaryOperator;
        this.i = j;
    }
}
