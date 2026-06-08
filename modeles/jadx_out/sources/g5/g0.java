package g5;

import com.uptodown.tv.ui.fragment.TvSearchFragment;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5316a;

    /* renamed from: b, reason: collision with root package name */
    public int f5317b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ TvSearchFragment f5318l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f5319m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g0(TvSearchFragment tvSearchFragment, String str, t6.c cVar, int i) {
        super(2, cVar);
        this.f5316a = i;
        this.f5318l = tvSearchFragment;
        this.f5319m = str;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f5316a) {
            case 0:
                return new g0(this.f5318l, this.f5319m, cVar, 0);
            default:
                return new g0(this.f5318l, this.f5319m, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f5316a) {
        }
        return ((g0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00dc, code lost:
    
        if (o7.c0.j(300, r13) == r3) goto L49;
     */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r14) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.g0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
