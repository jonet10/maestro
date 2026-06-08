package b;

import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class a extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f647a;

    /* renamed from: b, reason: collision with root package name */
    public int f648b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ h f649l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(h hVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f647a = i;
        this.f649l = hVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f647a) {
            case 0:
                return new a(this.f649l, cVar, 0);
            case 1:
                return new a(this.f649l, cVar, 1);
            case 2:
                return new a(this.f649l, cVar, 2);
            case 3:
                return new a(this.f649l, cVar, 3);
            case 4:
                return new a(this.f649l, cVar, 4);
            default:
                return new a(this.f649l, cVar, 5);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        t6.c cVar = (t6.c) obj2;
        switch (this.f647a) {
            case 0:
                return new a(this.f649l, cVar, 0).invokeSuspend(x.f8463a);
            case 1:
                return new a(this.f649l, cVar, 1).invokeSuspend(x.f8463a);
            case 2:
                return new a(this.f649l, cVar, 2).invokeSuspend(x.f8463a);
            case 3:
                return new a(this.f649l, cVar, 3).invokeSuspend(x.f8463a);
            case 4:
                return new a(this.f649l, cVar, 4).invokeSuspend(x.f8463a);
            default:
                return new a(this.f649l, cVar, 5).invokeSuspend(x.f8463a);
        }
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        switch (this.f647a) {
            case 0:
                int i = this.f648b;
                if (i != 0) {
                    if (i == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                j9.e eVar = this.f649l.f671d;
                this.f648b = 1;
                Object a8 = eVar.a(this);
                u6.a aVar = u6.a.f10762a;
                return a8 == aVar ? aVar : a8;
            case 1:
                int i6 = this.f648b;
                if (i6 != 0) {
                    if (i6 == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                h hVar = this.f649l;
                j9.s sVar = hVar.f670c;
                int i10 = hVar.f678p.f7239n.f7201d;
                this.f648b = 1;
                Object a10 = sVar.a(i10, this);
                u6.a aVar2 = u6.a.f10762a;
                return a10 == aVar2 ? aVar2 : a10;
            case 2:
                int i11 = this.f648b;
                if (i11 != 0) {
                    if (i11 == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                j9.x xVar = this.f649l.f672e;
                this.f648b = 1;
                Object b7 = xVar.b(this);
                u6.a aVar3 = u6.a.f10762a;
                return b7 == aVar3 ? aVar3 : b7;
            case 3:
                int i12 = this.f648b;
                if (i12 != 0) {
                    if (i12 == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                j9.l lVar = this.f649l.h;
                this.f648b = 1;
                Object a11 = lVar.a(this);
                u6.a aVar4 = u6.a.f10762a;
                return a11 == aVar4 ? aVar4 : a11;
            case 4:
                int i13 = this.f648b;
                if (i13 != 0) {
                    if (i13 == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                j9.n nVar = this.f649l.g;
                this.f648b = 1;
                Object a12 = nVar.a(this);
                u6.a aVar5 = u6.a.f10762a;
                return a12 == aVar5 ? aVar5 : a12;
            default:
                int i14 = this.f648b;
                if (i14 != 0) {
                    if (i14 == 1) {
                        p6.a.e(obj);
                        return obj;
                    }
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                p6.a.e(obj);
                j9.f fVar = this.f649l.f;
                this.f648b = 1;
                Object d10 = fVar.d(this);
                u6.a aVar6 = u6.a.f10762a;
                return d10 == aVar6 ? aVar6 : d10;
        }
    }
}
