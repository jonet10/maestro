package c3;

import android.content.Context;
import androidx.documentfile.provider.DocumentFile;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1302a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f1303b;

    /* renamed from: l, reason: collision with root package name */
    public Object f1304l;

    /* renamed from: m, reason: collision with root package name */
    public Object f1305m;

    /* renamed from: n, reason: collision with root package name */
    public Object f1306n;

    /* renamed from: o, reason: collision with root package name */
    public Object f1307o;

    /* renamed from: p, reason: collision with root package name */
    public Object f1308p;

    /* renamed from: q, reason: collision with root package name */
    public Object f1309q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f1310r;

    /* renamed from: s, reason: collision with root package name */
    public Object f1311s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(Context context, DocumentFile documentFile, ArrayList arrayList, a2.n nVar, g4.u uVar, t6.c cVar) {
        super(2, cVar);
        this.f1307o = context;
        this.f1308p = documentFile;
        this.f1309q = arrayList;
        this.f1310r = nVar;
        this.f1311s = uVar;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1302a) {
            case 0:
                return new q0((s0) this.f1306n, (n0) this.f1310r, cVar);
            default:
                return new q0((Context) this.f1307o, (DocumentFile) this.f1308p, (ArrayList) this.f1309q, (a2.n) this.f1310r, (g4.u) this.f1311s, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1302a) {
        }
        return ((q0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(9:3|(1:(1:(1:(1:(1:(2:10|11)(1:14))(4:16|17|18|(3:20|(1:22)|(0)(3:24|25|(0)(4:27|17|18|(5:30|(1:32)|33|(0)|11)(0))))(0)))(3:36|25|(0)))(5:37|38|39|18|(0)(0)))(1:40))(2:49|(0))|41|42|(4:44|39|18|(0)(0))|38|39|18|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00a9, code lost:
    
        r2 = o7.m0.f8288a;
        r2 = t7.n.f10348a;
        r11 = new c4.g(r10, null, 14);
        r22.f1304l = null;
        r22.f1303b = 2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00bc, code lost:
    
        if (o7.c0.C(r11, r2, r22) == r3) goto L101;
     */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0249  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x020a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x014b -> B:16:0x014e). Please report as a decompilation issue!!! */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 684
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c3.q0.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q0(s0 s0Var, n0 n0Var, t6.c cVar) {
        super(2, cVar);
        this.f1306n = s0Var;
        this.f1310r = n0Var;
    }
}
