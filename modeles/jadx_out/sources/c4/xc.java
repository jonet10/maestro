package c4;

import android.content.Context;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class xc extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2318a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f2319b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ xc(Context context, t6.c cVar, int i) {
        super(2, cVar);
        this.f2318a = i;
        this.f2319b = context;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f2318a) {
            case 0:
                return new xc(this.f2319b, cVar, 0);
            default:
                return new xc(this.f2319b, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f2318a) {
            case 0:
                xc xcVar = (xc) create(a0Var, cVar);
                p6.x xVar = p6.x.f8463a;
                xcVar.invokeSuspend(xVar);
                return xVar;
            default:
                xc xcVar2 = (xc) create(a0Var, cVar);
                p6.x xVar2 = p6.x.f8463a;
                xcVar2.invokeSuspend(xVar2);
                return xVar2;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(14:3|(2:4|5)|(3:7|(8:13|14|15|(2:17|(2:21|(11:23|(2:27|(14:30|31|32|(4:34|(1:36)|37|38)|40|41|42|43|44|(6:47|(3:54|(2:57|(2:59|60)(1:62))|61)|65|66|61|45)|67|68|(2:72|(1:74))|76))|85|42|43|44|(1:45)|67|68|(3:70|72|(0))|76)))|87|(1:19)|21|(0))|11)|91|(1:9)|13|14|15|(0)|87|(0)|21|(0)|11) */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x0048, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0049, code lost:
    
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043 A[Catch: Exception -> 0x0048, TRY_LEAVE, TryCatch #1 {Exception -> 0x0048, blocks: (B:15:0x0039, B:17:0x0043), top: B:14:0x0039 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0138 A[Catch: all -> 0x0191, TryCatch #0 {all -> 0x0191, blocks: (B:44:0x0122, B:45:0x0132, B:47:0x0138, B:49:0x014d, B:51:0x0151, B:54:0x0158, B:57:0x016f, B:59:0x018c, B:65:0x0193, B:70:0x019d, B:72:0x01a1, B:74:0x01ab), top: B:43:0x0122 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ab A[Catch: all -> 0x0191, TRY_LEAVE, TryCatch #0 {all -> 0x0191, blocks: (B:44:0x0122, B:45:0x0132, B:47:0x0138, B:49:0x014d, B:51:0x0151, B:54:0x0158, B:57:0x016f, B:59:0x018c, B:65:0x0193, B:70:0x019d, B:72:0x01a1, B:74:0x01ab), top: B:43:0x0122 }] */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c4.xc.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
