package j$.util.stream;

import java.util.function.LongConsumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class g1 extends j1 {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f6200l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f6201m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g1(a aVar, int i, Object obj, int i6) {
        super(aVar, i);
        this.f6200l = i6;
        this.f6201m = obj;
    }

    @Override // j$.util.stream.a
    public final m5 M(int i, m5 m5Var) {
        switch (this.f6200l) {
            case 0:
                return new f1(this, m5Var);
            case 1:
                return new c1(this, m5Var, 1);
            case 2:
                return new z4(this, m5Var);
            default:
                return new m(this, m5Var, 5);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g1(k1 k1Var, LongConsumer longConsumer) {
        super(k1Var, 0);
        this.f6200l = 1;
        this.f6201m = longConsumer;
    }
}
