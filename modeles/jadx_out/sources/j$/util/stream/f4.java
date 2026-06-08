package j$.util.stream;

import java.util.function.DoubleBinaryOperator;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class f4 extends w3 {
    public final /* synthetic */ DoubleBinaryOperator h;
    public final /* synthetic */ double i;

    @Override // j$.util.stream.w3
    public final r4 Z() {
        return new a4(this.i, this.h);
    }

    public f4(a7 a7Var, DoubleBinaryOperator doubleBinaryOperator, double d10) {
        this.h = doubleBinaryOperator;
        this.i = d10;
    }
}
