package j$.util.stream;

import java.util.function.BinaryOperator;
import java.util.function.DoubleBinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.LongBinaryOperator;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class z3 extends w3 {
    public final /* synthetic */ int h;
    public final /* synthetic */ Object i;

    public /* synthetic */ z3(a7 a7Var, Object obj, int i) {
        this.h = i;
        this.i = obj;
    }

    @Override // j$.util.stream.w3
    public final r4 Z() {
        switch (this.h) {
            case 0:
                return new q4((LongBinaryOperator) this.i);
            case 1:
                return new c4((DoubleBinaryOperator) this.i);
            case 2:
                return new h4((BinaryOperator) this.i);
            default:
                return new n4((IntBinaryOperator) this.i);
        }
    }
}
