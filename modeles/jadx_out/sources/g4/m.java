package g4;

import com.uptodown.core.activities.FileExplorerActivity;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5215a;

    /* renamed from: b, reason: collision with root package name */
    public int f5216b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f5217l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f5218m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ String f5219n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m(FileExplorerActivity fileExplorerActivity, String str, String str2, t6.c cVar, int i) {
        super(2, cVar);
        this.f5215a = i;
        this.f5217l = fileExplorerActivity;
        this.f5218m = str;
        this.f5219n = str2;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f5215a) {
            case 0:
                return new m(this.f5217l, this.f5218m, this.f5219n, cVar, 0);
            default:
                return new m(this.f5217l, this.f5218m, this.f5219n, cVar, 1);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f5215a) {
        }
        return ((m) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x011a, code lost:
    
        if (com.uptodown.core.activities.FileExplorerActivity.O(r7, r17) == r4) goto L71;
     */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00cb  */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r18) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g4.m.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
