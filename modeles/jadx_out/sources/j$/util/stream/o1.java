package j$.util.stream;

import java.util.function.Supplier;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final /* synthetic */ class o1 implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6309a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ u1 f6310b;

    public /* synthetic */ o1(u1 u1Var, int i) {
        this.f6309a = i;
        this.f6310b = u1Var;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        switch (this.f6309a) {
            case 0:
                return new r1(this.f6310b);
            case 1:
                return new q1(this.f6310b);
            default:
                return new s1(this.f6310b);
        }
    }
}
