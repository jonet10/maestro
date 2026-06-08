package c4;

import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h8 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1685a;

    /* renamed from: b, reason: collision with root package name */
    public int f1686b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ i8 f1687l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Context f1688m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h8(i8 i8Var, Context context, t6.c cVar, int i) {
        super(2, cVar);
        this.f1685a = i;
        this.f1687l = i8Var;
        this.f1688m = context;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1685a) {
            case 0:
                return new h8(this.f1687l, this.f1688m, cVar, 0);
            default:
                return new h8(this.f1687l, this.f1688m, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1685a) {
        }
        return ((h8) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:47:0x00fa, code lost:
    
        if (r10 == r1) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0120, code lost:
    
        if (r10 == r1) goto L43;
     */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.h8.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
