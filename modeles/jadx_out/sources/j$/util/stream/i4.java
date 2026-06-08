package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class i4 extends w3 {
    public final /* synthetic */ BinaryOperator h;
    public final /* synthetic */ BiConsumer i;
    public final /* synthetic */ Supplier j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ Collector f6223k;

    @Override // j$.util.stream.w3
    public final r4 Z() {
        return new j4(this.j, this.i, this.h);
    }

    @Override // j$.util.stream.w3, j$.util.stream.f8
    public final int f() {
        if (this.f6223k.characteristics().contains(h.UNORDERED)) {
            return z6.f6449r;
        }
        return 0;
    }

    public i4(a7 a7Var, BinaryOperator binaryOperator, BiConsumer biConsumer, Supplier supplier, Collector collector) {
        this.h = binaryOperator;
        this.i = biConsumer;
        this.j = supplier;
        this.f6223k = collector;
    }
}
