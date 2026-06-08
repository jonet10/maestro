package c4;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class hd extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1696a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f1697b;

    /* renamed from: l, reason: collision with root package name */
    public Object f1698l;

    /* renamed from: m, reason: collision with root package name */
    public Object f1699m;

    /* renamed from: n, reason: collision with root package name */
    public Object f1700n;

    /* renamed from: o, reason: collision with root package name */
    public /* synthetic */ Object f1701o;

    /* renamed from: p, reason: collision with root package name */
    public final /* synthetic */ Object f1702p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ Object f1703q;

    /* renamed from: r, reason: collision with root package name */
    public final /* synthetic */ Object f1704r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hd(id idVar, Context context, String str, int i, kotlin.jvm.internal.x xVar, kotlin.jvm.internal.v vVar, x4.w2 w2Var, String str2, t6.c cVar) {
        super(2, cVar);
        this.f1698l = idVar;
        this.f1699m = context;
        this.f1700n = str;
        this.f1697b = i;
        this.f1702p = xVar;
        this.f1703q = vVar;
        this.f1704r = w2Var;
        this.f1701o = str2;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f1696a) {
            case 0:
                return new hd((id) this.f1698l, (Context) this.f1699m, (String) this.f1700n, this.f1697b, (kotlin.jvm.internal.x) this.f1702p, (kotlin.jvm.internal.v) this.f1703q, (x4.w2) this.f1704r, (String) this.f1701o, cVar);
            case 1:
                return new hd((File) this.f1701o, (ArrayList) this.f1702p, (a2.n) this.f1703q, (g4.u) this.f1704r, cVar);
            default:
                hd hdVar = new hd((y2.s) this.f1702p, (ArrayList) this.f1703q, (j5.v) this.f1704r, cVar);
                hdVar.f1701o = obj;
                return hdVar;
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f1696a) {
            case 0:
                hd hdVar = (hd) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                hdVar.invokeSuspend(xVar);
                break;
        }
        return ((hd) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0129  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0242  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ef -> B:20:0x004c). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:56:0x0237 -> B:46:0x023d). Please report as a decompilation issue!!! */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            Method dump skipped, instructions count: 778
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.hd.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hd(File file, ArrayList arrayList, a2.n nVar, g4.u uVar, t6.c cVar) {
        super(2, cVar);
        this.f1701o = file;
        this.f1702p = arrayList;
        this.f1703q = nVar;
        this.f1704r = uVar;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hd(y2.s sVar, ArrayList arrayList, j5.v vVar, t6.c cVar) {
        super(2, cVar);
        this.f1702p = sVar;
        this.f1703q = arrayList;
        this.f1704r = vVar;
    }
}
