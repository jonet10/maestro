package j$.util.stream;

import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class r extends d5 {

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ int f6335l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f6336m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(a aVar, int i, Object obj, int i6) {
        super(aVar, i);
        this.f6335l = i6;
        this.f6336m = obj;
    }

    @Override // j$.util.stream.a
    public final m5 M(int i, m5 m5Var) {
        switch (this.f6335l) {
            case 0:
                return new o(this, m5Var, 0);
            case 1:
                return new u0(this, m5Var, 0);
            case 2:
                return new c1(this, m5Var, 0);
            case 3:
                return new m(this, m5Var, 1);
            case 4:
                return new m(this, m5Var, 2);
            case 5:
                return new m(this, m5Var, 3);
            default:
                return new l(this, m5Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(e5 e5Var, Consumer consumer) {
        super(e5Var, 0);
        this.f6335l = 3;
        this.f6336m = consumer;
    }
}
