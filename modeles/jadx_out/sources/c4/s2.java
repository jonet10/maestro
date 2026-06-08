package c4;

import com.google.android.gms.auth.api.signin.GoogleSignInAccount;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s2 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2068a;

    /* renamed from: b, reason: collision with root package name */
    public com.google.android.gms.internal.measurement.i4 f2069b;

    /* renamed from: l, reason: collision with root package name */
    public int f2070l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ GoogleSignInAccount f2071m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ t2 f2072n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ s2(GoogleSignInAccount googleSignInAccount, t2 t2Var, t6.c cVar, int i) {
        super(2, cVar);
        this.f2068a = i;
        this.f2071m = googleSignInAccount;
        this.f2072n = t2Var;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2068a) {
            case 0:
                return new s2(this.f2071m, this.f2072n, cVar, 0);
            default:
                return new s2(this.f2071m, this.f2072n, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2068a) {
        }
        return ((s2) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x009d, code lost:
    
        if (o7.c0.C(r4, r2, r10) == r3) goto L48;
     */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) {
        /*
            Method dump skipped, instructions count: 214
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.s2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
