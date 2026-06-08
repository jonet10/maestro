package g5;

import com.uptodown.tv.ui.fragment.TvMyAppsFragment;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5290a;

    /* renamed from: b, reason: collision with root package name */
    public int f5291b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ TvMyAppsFragment f5292l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a0(TvMyAppsFragment tvMyAppsFragment, t6.c cVar, int i) {
        super(2, cVar);
        this.f5290a = i;
        this.f5292l = tvMyAppsFragment;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f5290a) {
            case 0:
                return new a0(this.f5292l, cVar, 0);
            default:
                return new a0(this.f5292l, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f5290a) {
        }
        return ((a0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b3, code lost:
    
        if (r0 != 4) goto L45;
     */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00d7 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0055 A[SYNTHETIC] */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            Method dump skipped, instructions count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g5.a0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
