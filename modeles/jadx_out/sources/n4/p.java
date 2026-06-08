package n4;

import java.io.File;
import o7.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7988a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ k4.c f7989b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f7990l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ p(k4.c cVar, kotlin.jvm.internal.x xVar, t6.c cVar2, int i) {
        super(2, cVar2);
        this.f7988a = i;
        this.f7989b = cVar;
        this.f7990l = xVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f7988a) {
            case 0:
                return new p(this.f7989b, this.f7990l, cVar, 0);
            default:
                return new p(this.f7989b, this.f7990l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f7988a) {
        }
        return ((p) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f7988a) {
            case 0:
                p6.a.e(obj);
                k4.c cVar = this.f7989b;
                if (cVar != null) {
                    cVar.j((File) this.f7990l.f7024a);
                    break;
                }
                break;
            default:
                p6.a.e(obj);
                k4.c cVar2 = this.f7989b;
                if (cVar2 != null) {
                    cVar2.i((File) this.f7990l.f7024a);
                    break;
                }
                break;
        }
        return p6.x.f8463a;
    }
}
