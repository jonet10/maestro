package b;

import c4.e7;
import com.uptodown.activities.PreregistrationActivity;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class f extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f660a = 2;

    /* renamed from: b, reason: collision with root package name */
    public int f661b;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f662l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ boolean f663m;

    /* renamed from: n, reason: collision with root package name */
    public Object f664n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(e7 e7Var, boolean z9, PreregistrationActivity preregistrationActivity, t6.c cVar) {
        super(2, cVar);
        this.f664n = e7Var;
        this.f663m = z9;
        this.f662l = preregistrationActivity;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f660a) {
            case 0:
                f fVar = new f(this.f663m, cVar);
                fVar.f662l = obj;
                return fVar;
            case 1:
                f fVar2 = new f((l8.n) this.f664n, this.f663m, cVar);
                fVar2.f662l = obj;
                return fVar2;
            case 2:
                return new f((e7) this.f664n, this.f663m, (PreregistrationActivity) this.f662l, cVar);
            default:
                return new f((String) this.f664n, (f9.d) this.f662l, this.f663m, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f660a) {
            case 0:
                f fVar = new f(this.f663m, cVar);
                fVar.f662l = a0Var;
                break;
        }
        return ((f) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:166:0x056b  */
    /* JADX WARN: Removed duplicated region for block: B:173:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0302  */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v13 */
    /* JADX WARN: Type inference failed for: r10v14 */
    /* JADX WARN: Type inference failed for: r10v15 */
    /* JADX WARN: Type inference failed for: r10v16 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r10v8 */
    /* JADX WARN: Type inference failed for: r10v9 */
    /* JADX WARN: Type inference failed for: r4v14, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r4v27, types: [o7.f0] */
    /* JADX WARN: Type inference failed for: r6v11, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r9v6, types: [java.lang.Object, java.util.List] */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            Method dump skipped, instructions count: 1410
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.f.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(String str, f9.d dVar, boolean z9, t6.c cVar) {
        super(2, cVar);
        this.f664n = str;
        this.f662l = dVar;
        this.f663m = z9;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(l8.n nVar, boolean z9, t6.c cVar) {
        super(2, cVar);
        this.f664n = nVar;
        this.f663m = z9;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(boolean z9, t6.c cVar) {
        super(2, cVar);
        this.f663m = z9;
    }
}
