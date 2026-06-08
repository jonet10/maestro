package s4;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f9271a = 0;

    /* renamed from: b, reason: collision with root package name */
    public j5.g f9272b;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f9273l;

    /* renamed from: m, reason: collision with root package name */
    public Iterator f9274m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f9275n;

    /* renamed from: o, reason: collision with root package name */
    public int f9276o;

    /* renamed from: p, reason: collision with root package name */
    public /* synthetic */ Object f9277p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ s f9278q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ ArrayList f9279r;

    /* renamed from: s, reason: collision with root package name */
    public final /* synthetic */ j5.v f9280s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(ArrayList arrayList, s sVar, j5.v vVar, t6.c cVar) {
        super(2, cVar);
        this.f9279r = arrayList;
        this.f9278q = sVar;
        this.f9280s = vVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f9271a) {
            case 0:
                r rVar = new r(this.f9279r, this.f9278q, this.f9280s, cVar);
                rVar.f9277p = obj;
                return rVar;
            default:
                r rVar2 = new r(this.f9278q, this.f9279r, this.f9280s, cVar);
                rVar2.f9277p = obj;
                return rVar2;
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f9271a) {
        }
        return ((r) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01a9  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x00e0 -> B:12:0x00e3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:51:0x019f -> B:46:0x01a2). Please report as a decompilation issue!!! */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 464
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: s4.r.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r(s sVar, ArrayList arrayList, j5.v vVar, t6.c cVar) {
        super(2, cVar);
        this.f9278q = sVar;
        this.f9279r = arrayList;
        this.f9280s = vVar;
    }
}
