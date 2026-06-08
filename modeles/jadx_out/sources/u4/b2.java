package u4;

import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b2 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10433a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f10434b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ d2 f10435l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f10436m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b2(Context context, d2 d2Var, int i, t6.c cVar) {
        super(2, cVar);
        this.f10433a = 1;
        this.f10434b = context;
        this.f10435l = d2Var;
        this.f10436m = i;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f10433a) {
            case 0:
                return new b2(this.f10434b, this.f10436m, this.f10435l, cVar, 0);
            case 1:
                return new b2(this.f10434b, this.f10435l, this.f10436m, cVar);
            default:
                return new b2(this.f10434b, this.f10436m, this.f10435l, cVar, 2);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f10433a) {
            case 0:
                b2 b2Var = (b2) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                b2Var.invokeSuspend(xVar);
                return xVar;
            case 1:
                b2 b2Var2 = (b2) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                b2Var2.invokeSuspend(xVar2);
                return xVar2;
            default:
                b2 b2Var3 = (b2) create(a0Var, cVar);
                p6.x xVar3 = p6.x.f8463a;
                b2Var3.invokeSuspend(xVar3);
                return xVar3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            Method dump skipped, instructions count: 280
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.b2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b2(Context context, int i, d2 d2Var, t6.c cVar, int i6) {
        super(2, cVar);
        this.f10433a = i6;
        this.f10434b = context;
        this.f10436m = i;
        this.f10435l = d2Var;
    }
}
