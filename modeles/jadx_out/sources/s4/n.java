package s4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9244a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f9245b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ s f9246l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(kotlin.jvm.internal.x xVar, s sVar, t6.c cVar) {
        super(2, cVar);
        this.f9244a = 1;
        this.f9245b = xVar;
        this.f9246l = sVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f9244a) {
            case 0:
                return new n(this.f9246l, this.f9245b, cVar, 0);
            case 1:
                return new n(this.f9245b, this.f9246l, cVar);
            default:
                return new n(this.f9246l, this.f9245b, cVar, 2);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f9244a) {
            case 0:
                n nVar = (n) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                nVar.invokeSuspend(xVar);
                return xVar;
            case 1:
                n nVar2 = (n) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                nVar2.invokeSuspend(xVar2);
                return xVar2;
            default:
                n nVar3 = (n) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                nVar3.invokeSuspend(xVar3);
                return xVar3;
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f9244a) {
            case 0:
                p6.a.e(obj);
                ((w4.i) this.f9246l.f9287d).d((ArrayList) this.f9245b.f7024a);
                break;
            case 1:
                p6.a.e(obj);
                Object obj2 = this.f9245b.f7024a;
                if (obj2 != null) {
                    ((w4.i) this.f9246l.f9287d).l((x4.g) obj2);
                }
                break;
            default:
                p6.a.e(obj);
                ((w4.i) this.f9246l.f9287d).a((x4.g) this.f9245b.f7024a);
                break;
        }
        return p6.x.f8463a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ n(s sVar, kotlin.jvm.internal.x xVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f9244a = i;
        this.f9246l = sVar;
        this.f9245b = xVar;
    }
}
