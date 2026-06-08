package u4;

import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10577a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v0 f10578b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Context f10579l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ j5.v f10580m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ long f10581n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(Context context, j5.v vVar, long j, v0 v0Var, t6.c cVar) {
        super(2, cVar);
        this.f10579l = context;
        this.f10580m = vVar;
        this.f10581n = j;
        this.f10578b = v0Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f10577a) {
            case 0:
                return new q0(this.f10579l, this.f10580m, this.f10581n, this.f10578b, cVar);
            default:
                return new q0(this.f10578b, this.f10579l, this.f10580m, this.f10581n, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f10577a) {
            case 0:
                q0 q0Var = (q0) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                q0Var.invokeSuspend(xVar);
                return xVar;
            default:
                q0 q0Var2 = (q0) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                q0Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x00cc  */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 486
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.q0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(v0 v0Var, Context context, j5.v vVar, long j, t6.c cVar) {
        super(2, cVar);
        this.f10578b = v0Var;
        this.f10579l = context;
        this.f10580m = vVar;
        this.f10581n = j;
    }
}
