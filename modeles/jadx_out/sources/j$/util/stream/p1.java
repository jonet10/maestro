package j$.util.stream;

import java.util.function.Predicate;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class p1 extends t1 {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ u1 f6320c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Predicate f6321d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p1(u1 u1Var, Predicate predicate) {
        super(u1Var);
        this.f6320c = u1Var;
        this.f6321d = predicate;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        if (this.f6362a) {
            return;
        }
        boolean test = this.f6321d.test(obj);
        u1 u1Var = this.f6320c;
        if (test == u1Var.f6378a) {
            this.f6362a = true;
            this.f6363b = u1Var.f6379b;
        }
    }
}
