package s4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9230a;

    /* renamed from: b, reason: collision with root package name */
    public int f9231b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ s f9232l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ j5.v f9233m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f9234n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(s sVar, j5.v vVar, kotlin.jvm.internal.x xVar, t6.c cVar, int i) {
        super(2, cVar);
        this.f9230a = i;
        this.f9232l = sVar;
        this.f9233m = vVar;
        this.f9234n = xVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f9230a) {
            case 0:
                return new l(this.f9232l, this.f9233m, this.f9234n, cVar, 0);
            default:
                return new l(this.f9232l, this.f9233m, this.f9234n, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f9230a) {
        }
        return ((l) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f9230a;
        kotlin.jvm.internal.x xVar = this.f9234n;
        j5.v vVar = this.f9233m;
        s sVar = this.f9232l;
        u6.a aVar = u6.a.f10762a;
        p6.x xVar2 = p6.x.f8463a;
        switch (i) {
            case 0:
                int i6 = this.f9231b;
                if (i6 == 0) {
                    p6.a.e(obj);
                    ArrayList arrayList = (ArrayList) xVar.f7024a;
                    this.f9231b = 1;
                    v7.e eVar = o7.m0.f8288a;
                    Object C = o7.c0.C(new r(sVar, arrayList, vVar, (t6.c) null), v7.d.f10884a, this);
                    if (C != aVar) {
                        C = xVar2;
                    }
                    if (C == aVar) {
                    }
                } else if (i6 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
            default:
                int i10 = this.f9231b;
                if (i10 == 0) {
                    p6.a.e(obj);
                    ArrayList arrayList2 = (ArrayList) xVar.f7024a;
                    this.f9231b = 1;
                    v7.e eVar2 = o7.m0.f8288a;
                    Object C2 = o7.c0.C(new r(arrayList2, sVar, vVar, (t6.c) null), v7.d.f10884a, this);
                    if (C2 != aVar) {
                        C2 = xVar2;
                    }
                    if (C2 == aVar) {
                    }
                } else if (i10 != 1) {
                    androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                    break;
                } else {
                    p6.a.e(obj);
                }
                break;
        }
        return xVar2;
    }
}
