package c4;

import android.content.Context;
import java.io.Serializable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w2 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2250a = 1;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x2 f2251b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Context f2252l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f2253m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f2254n;

    /* renamed from: o, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.v f2255o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f2256p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ kotlin.jvm.internal.x f2257q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Serializable f2258r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w2(x2 x2Var, Context context, String str, String str2, String str3, kotlin.jvm.internal.v vVar, kotlin.jvm.internal.x xVar, kotlin.jvm.internal.x xVar2, t6.c cVar) {
        super(2, cVar);
        this.f2251b = x2Var;
        this.f2252l = context;
        this.f2253m = str;
        this.f2254n = str2;
        this.f2258r = str3;
        this.f2255o = vVar;
        this.f2256p = xVar;
        this.f2257q = xVar2;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2250a) {
            case 0:
                return new w2(this.f2251b, this.f2252l, this.f2253m, this.f2254n, this.f2256p, this.f2255o, this.f2257q, (kotlin.jvm.internal.x) this.f2258r, cVar);
            default:
                return new w2(this.f2251b, this.f2252l, this.f2253m, this.f2254n, (String) this.f2258r, this.f2255o, this.f2256p, this.f2257q, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2250a) {
            case 0:
                w2 w2Var = (w2) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                w2Var.invokeSuspend(xVar);
                return xVar;
            default:
                w2 w2Var2 = (w2) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                w2Var2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x016b  */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 494
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.w2.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w2(x2 x2Var, Context context, String str, String str2, kotlin.jvm.internal.x xVar, kotlin.jvm.internal.v vVar, kotlin.jvm.internal.x xVar2, kotlin.jvm.internal.x xVar3, t6.c cVar) {
        super(2, cVar);
        this.f2251b = x2Var;
        this.f2252l = context;
        this.f2253m = str;
        this.f2254n = str2;
        this.f2256p = xVar;
        this.f2255o = vVar;
        this.f2257q = xVar2;
        this.f2258r = xVar3;
    }
}
