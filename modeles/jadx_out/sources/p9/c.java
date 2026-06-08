package p9;

import com.inmobi.cmp.presentation.components.CmpActivity;
import d7.p;
import m8.q;
import o7.a0;
import p6.x;
import s4.p0;
import u4.a1;
import u4.m1;
import y2.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends v6.i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8509a;

    /* renamed from: b, reason: collision with root package name */
    public int f8510b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f8511l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(q qVar, int i, t6.c cVar) {
        super(2, cVar);
        this.f8509a = 6;
        this.f8511l = qVar;
        this.f8510b = i;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f8509a) {
            case 0:
                return new c((CmpActivity) this.f8511l, cVar, 0);
            case 1:
                return new c((d) this.f8511l, cVar, 1);
            case 2:
                return new c((q5.i) this.f8511l, cVar, 2);
            case 3:
                return new c((r7.o) this.f8511l, cVar, 3);
            case 4:
                return new c((s) this.f8511l, cVar, 4);
            case 5:
                return new c((s4.s) this.f8511l, cVar, 5);
            case 6:
                return new c((q) this.f8511l, this.f8510b, cVar);
            case 7:
                return new c((s4.e) this.f8511l, cVar, 7);
            case 8:
                return new c((b5.m) this.f8511l, cVar, 8);
            case 9:
                return new c((p0) this.f8511l, cVar, 9);
            case 10:
                return new c((s5.d) this.f8511l, cVar, 10);
            case 11:
                return new c((a1) this.f8511l, cVar, 11);
            case 12:
                return new c((m1) this.f8511l, cVar, 12);
            default:
                return new c((z5.d) this.f8511l, cVar, 13);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f8509a) {
            case 0:
                return new c((CmpActivity) this.f8511l, cVar, 0).invokeSuspend(x.f8463a);
            case 1:
                return new c((d) this.f8511l, cVar, 1).invokeSuspend(x.f8463a);
            case 2:
                return new c((q5.i) this.f8511l, cVar, 2).invokeSuspend(x.f8463a);
            case 3:
                return ((c) create(a0Var, cVar)).invokeSuspend(x.f8463a);
            case 4:
                return ((c) create(a0Var, cVar)).invokeSuspend(x.f8463a);
            case 5:
                return ((c) create(a0Var, cVar)).invokeSuspend(x.f8463a);
            case 6:
                return ((c) create(a0Var, cVar)).invokeSuspend(x.f8463a);
            case 7:
                return ((c) create(a0Var, cVar)).invokeSuspend(x.f8463a);
            case 8:
                return ((c) create(a0Var, cVar)).invokeSuspend(x.f8463a);
            case 9:
                return ((c) create(a0Var, cVar)).invokeSuspend(x.f8463a);
            case 10:
                return new c((s5.d) this.f8511l, cVar, 10).invokeSuspend(x.f8463a);
            case 11:
                ((c) create(a0Var, cVar)).invokeSuspend(x.f8463a);
                return u6.a.f10762a;
            case 12:
                return ((c) create(a0Var, cVar)).invokeSuspend(x.f8463a);
            default:
                return new c((z5.d) this.f8511l, cVar, 13).invokeSuspend(x.f8463a);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:289:0x0565, code lost:
    
        if (r1 != false) goto L241;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0, types: [t6.c] */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r13v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r13v9 */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r32) {
        /*
            Method dump skipped, instructions count: 2528
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p9.c.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(Object obj, t6.c cVar, int i) {
        super(2, cVar);
        this.f8509a = i;
        this.f8511l = obj;
    }
}
