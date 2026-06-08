package c4;

import com.uptodown.activities.PublicProfileActivity;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v7 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2205a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f2206b;

    /* renamed from: l, reason: collision with root package name */
    public int f2207l;

    /* renamed from: m, reason: collision with root package name */
    public int f2208m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f2209n;

    /* renamed from: o, reason: collision with root package name */
    public Object f2210o;

    /* renamed from: p, reason: collision with root package name */
    public Object f2211p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f2212q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v7(y7 y7Var, int i, PublicProfileActivity publicProfileActivity, String str, int i6, t6.c cVar) {
        super(2, cVar);
        this.f2210o = y7Var;
        this.f2207l = i;
        this.f2211p = publicProfileActivity;
        this.f2212q = str;
        this.f2208m = i6;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2205a) {
            case 0:
                return new v7((y7) this.f2210o, this.f2207l, (PublicProfileActivity) this.f2211p, (String) this.f2212q, this.f2208m, cVar);
            default:
                return new v7(this.f2209n, (a2.t) this.f2212q, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2205a) {
        }
        return ((v7) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:23|24|25|27|28|(12:30|(3:32|(5:35|36|37|38|33)|42)|43|(2:46|44)|47|48|(8:50|(2:52|(1:54))|55|(2:57|(2:59|(5:61|62|63|(1:98)(2:65|(5:67|(9:69|70|71|(5:73|(1:77)|(1:79)(1:87)|80|81)|88|(2:75|77)|(0)(0)|80|81)(3:91|(2:93|(1:95))|83)|15|16|(2:109|(0))(0))(1:97))|(0)(4:85|15|16|(0)(0)))(4:99|63|(0)(0)|(0))))|100|63|(0)(0)|(0)(0))|101|62|63|(0)(0)|(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x00cb, code lost:
    
        r0 = e;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x00cf, code lost:
    
        r0.printStackTrace();
        r0 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0244, code lost:
    
        if (r0 != r9) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x026d, code lost:
    
        if (r0 == r9) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:109:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0285  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:83:0x02a1 -> B:15:0x02a2). Please report as a decompilation issue!!! */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r30) {
        /*
            Method dump skipped, instructions count: 932
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.v7.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v7(ArrayList arrayList, a2.t tVar, t6.c cVar) {
        super(2, cVar);
        this.f2209n = arrayList;
        this.f2212q = tVar;
    }
}
