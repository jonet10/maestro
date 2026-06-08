package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.ObjIntConsumer;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class b4 extends w3 {
    public final /* synthetic */ int h;
    public final /* synthetic */ Object i;
    public final /* synthetic */ Object j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Object f6139k;

    public /* synthetic */ b4(a7 a7Var, Object obj, Object obj2, Object obj3, int i) {
        this.h = i;
        this.j = obj;
        this.f6139k = obj2;
        this.i = obj3;
    }

    @Override // j$.util.stream.w3
    public final r4 Z() {
        switch (this.h) {
            case 0:
                return new y3((Supplier) this.i, (ObjLongConsumer) this.f6139k, (p) this.j);
            case 1:
                return new e4((Supplier) this.i, (ObjDoubleConsumer) this.f6139k, (p) this.j);
            case 2:
                return new g4(this.i, (BiFunction) this.f6139k, (BinaryOperator) this.j);
            case 3:
                return new k4((Supplier) this.i, (BiConsumer) this.f6139k, (BiConsumer) this.j);
            default:
                return new o4((Supplier) this.i, (ObjIntConsumer) this.f6139k, (p) this.j);
        }
    }
}
