package f9;

import androidx.lifecycle.LiveDataScope;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public int f5055a;

    /* renamed from: b, reason: collision with root package name */
    public /* synthetic */ Object f5056b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f5057l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ int f5058m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ int f5059n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(String str, int i, int i6, t6.c cVar) {
        super(2, cVar);
        this.f5057l = str;
        this.f5058m = i;
        this.f5059n = i6;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        o oVar = new o(this.f5057l, this.f5058m, this.f5059n, cVar);
        oVar.f5056b = obj;
        return oVar;
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((o) create((LiveDataScope) obj, (t6.c) obj2)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x00f6, code lost:
    
        if (r2.emit((java.lang.String) r1, r25) == r5) goto L40;
     */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r26) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f9.o.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
