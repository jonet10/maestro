package n4;

import java.util.ArrayList;
import o7.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8007a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g4.u f8008b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ ArrayList f8009l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ r(g4.u uVar, ArrayList arrayList, t6.c cVar, int i) {
        super(2, cVar);
        this.f8007a = i;
        this.f8008b = uVar;
        this.f8009l = arrayList;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f8007a) {
            case 0:
                return new r(this.f8008b, this.f8009l, cVar, 0);
            default:
                return new r(this.f8008b, this.f8009l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f8007a) {
            case 0:
                r rVar = (r) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                rVar.invokeSuspend(xVar);
                return xVar;
            default:
                r rVar2 = (r) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                rVar2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f8007a) {
            case 0:
                p6.a.e(obj);
                this.f8008b.b(String.valueOf(this.f8009l.size()));
                break;
            default:
                p6.a.e(obj);
                this.f8008b.b(String.valueOf(this.f8009l.size()));
                break;
        }
        return p6.x.f8463a;
    }
}
