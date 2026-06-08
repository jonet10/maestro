package j5;

import android.content.Context;
import o7.a0;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6690a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Context f6691b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f6692l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i(Context context, String str, t6.c cVar, int i) {
        super(2, cVar);
        this.f6690a = i;
        this.f6691b = context;
        this.f6692l = str;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f6690a) {
            case 0:
                return new i(this.f6691b, this.f6692l, cVar, 0);
            case 1:
                return new i(this.f6691b, this.f6692l, cVar, 1);
            case 2:
                return new i(this.f6691b, this.f6692l, cVar, 2);
            default:
                return new i(this.f6691b, this.f6692l, cVar, 3);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f6690a) {
            case 0:
                i iVar = (i) create(a0Var, cVar);
                x xVar = x.f8463a;
                iVar.invokeSuspend(xVar);
                return xVar;
            case 1:
                i iVar2 = (i) create(a0Var, cVar);
                x xVar2 = x.f8463a;
                iVar2.invokeSuspend(xVar2);
                return xVar2;
            case 2:
                return new i(this.f6691b, this.f6692l, cVar, 2).invokeSuspend(x.f8463a);
            default:
                i iVar3 = (i) create(a0Var, cVar);
                x xVar3 = x.f8463a;
                iVar3.invokeSuspend(xVar3);
                return xVar3;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x008b A[Catch: Exception -> 0x00a5, TRY_ENTER, TryCatch #3 {Exception -> 0x00a5, blocks: (B:21:0x006b, B:26:0x008b, B:28:0x0091, B:29:0x00a7, B:34:0x00c2, B:37:0x00d4, B:38:0x00b1, B:45:0x00de, B:46:0x007a), top: B:20:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00c2 A[Catch: Exception -> 0x00a5, TRY_ENTER, TryCatch #3 {Exception -> 0x00a5, blocks: (B:21:0x006b, B:26:0x008b, B:28:0x0091, B:29:0x00a7, B:34:0x00c2, B:37:0x00d4, B:38:0x00b1, B:45:0x00de, B:46:0x007a), top: B:20:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00d4 A[Catch: Exception -> 0x00a5, TryCatch #3 {Exception -> 0x00a5, blocks: (B:21:0x006b, B:26:0x008b, B:28:0x0091, B:29:0x00a7, B:34:0x00c2, B:37:0x00d4, B:38:0x00b1, B:45:0x00de, B:46:0x007a), top: B:20:0x006b }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00de A[Catch: Exception -> 0x00a5, TRY_LEAVE, TryCatch #3 {Exception -> 0x00a5, blocks: (B:21:0x006b, B:26:0x008b, B:28:0x0091, B:29:0x00a7, B:34:0x00c2, B:37:0x00d4, B:38:0x00b1, B:45:0x00de, B:46:0x007a), top: B:20:0x006b }] */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        /*
            Method dump skipped, instructions count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j5.i.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
