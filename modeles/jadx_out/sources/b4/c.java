package b4;

import d7.p;
import kotlin.jvm.internal.x;
import o7.a0;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f994a = 1;

    /* renamed from: b, reason: collision with root package name */
    public x f995b;

    /* renamed from: l, reason: collision with root package name */
    public int f996l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f997m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f998n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(x xVar, String str, boolean z9, t6.c cVar) {
        super(2, cVar);
        this.f995b = xVar;
        this.f997m = str;
        this.f998n = z9;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f994a) {
            case 0:
                return new c(this.f995b, this.f997m, this.f998n, cVar);
            default:
                return new c(this.f997m, this.f998n, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f994a) {
        }
        return ((c) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
    
        if (o7.c0.j(1000, r12) == r5) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x00ed, code lost:
    
        if (r13 == r5) goto L116;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b4.c.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, boolean z9, t6.c cVar) {
        super(2, cVar);
        this.f997m = str;
        this.f998n = z9;
    }
}
