package j4;

import java.io.File;
import kotlin.jvm.internal.x;
import o7.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6641a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f6642b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ x f6643l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(o oVar, x xVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f6641a = i;
        this.f6642b = oVar;
        this.f6643l = xVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f6641a) {
            case 0:
                return new m(this.f6642b, this.f6643l, cVar, 0);
            default:
                return new m(this.f6642b, this.f6643l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f6641a) {
        }
        return ((m) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f6641a) {
            case 0:
                p6.a.e(obj);
                k4.a aVar = this.f6642b.f6652c;
                if (aVar != null) {
                    aVar.r((File) this.f6643l.f7024a);
                    break;
                }
                break;
            default:
                p6.a.e(obj);
                k4.a aVar2 = this.f6642b.f6652c;
                if (aVar2 != null) {
                    aVar2.m((File) this.f6643l.f7024a);
                    break;
                }
                break;
        }
        return p6.x.f8463a;
    }
}
