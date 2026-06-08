package j4;

import java.io.File;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6611a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f6612b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ File f6613l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(File file, o oVar, t6.c cVar) {
        super(2, cVar);
        this.f6611a = 0;
        this.f6613l = file;
        this.f6612b = oVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f6611a) {
            case 0:
                return new h(this.f6613l, this.f6612b, cVar);
            case 1:
                return new h(this.f6612b, this.f6613l, cVar, 1);
            case 2:
                return new h(this.f6612b, this.f6613l, cVar, 2);
            case 3:
                return new h(this.f6612b, this.f6613l, cVar, 3);
            default:
                return new h(this.f6612b, this.f6613l, cVar, 4);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f6611a) {
            case 0:
                h hVar = (h) create(a0Var, cVar);
                x xVar = x.f8463a;
                hVar.invokeSuspend(xVar);
                break;
        }
        return ((h) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        k4.a aVar;
        switch (this.f6611a) {
            case 0:
                p6.a.e(obj);
                File file = this.f6613l;
                if (file != null && (aVar = this.f6612b.f6652c) != null) {
                    aVar.x(file);
                }
                break;
            case 1:
                p6.a.e(obj);
                k4.a aVar2 = this.f6612b.f6652c;
                if (aVar2 != null) {
                    aVar2.r(this.f6613l);
                    break;
                }
                break;
            case 2:
                p6.a.e(obj);
                k4.a aVar3 = this.f6612b.f6652c;
                if (aVar3 != null) {
                    aVar3.m(this.f6613l);
                    break;
                }
                break;
            case 3:
                p6.a.e(obj);
                k4.a aVar4 = this.f6612b.f6652c;
                if (aVar4 != null) {
                    aVar4.r(this.f6613l);
                    break;
                }
                break;
            default:
                p6.a.e(obj);
                k4.a aVar5 = this.f6612b.f6652c;
                if (aVar5 != null) {
                    aVar5.m(this.f6613l);
                    break;
                }
                break;
        }
        return x.f8463a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h(o oVar, File file, t6.c cVar, int i) {
        super(2, cVar);
        this.f6611a = i;
        this.f6612b = oVar;
        this.f6613l = file;
    }
}
