package g5;

import com.uptodown.tv.ui.fragment.TvAppDetailFragment;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5304a;

    /* renamed from: b, reason: collision with root package name */
    public int f5305b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ TvAppDetailFragment f5306l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(TvAppDetailFragment tvAppDetailFragment, t6.c cVar, int i) {
        super(2, cVar);
        this.f5304a = i;
        this.f5306l = tvAppDetailFragment;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f5304a) {
            case 0:
                return new e(this.f5306l, cVar, 0);
            case 1:
                return new e(this.f5306l, cVar, 1);
            case 2:
                return new e(this.f5306l, cVar, 2);
            case 3:
                return new e(this.f5306l, cVar, 3);
            default:
                return new e(this.f5306l, cVar, 4);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f5304a) {
        }
        return ((e) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f8, code lost:
    
        if (r8.isEmpty() != false) goto L61;
     */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.e.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
