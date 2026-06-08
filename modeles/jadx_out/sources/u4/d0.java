package u4;

import android.content.Context;
import com.uptodown.gcm.MyFirebaseMessagingService;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d0 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10451a;

    /* renamed from: b, reason: collision with root package name */
    public int f10452b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f10453l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ Object f10454m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d0(Object obj, Object obj2, t6.c cVar, int i) {
        super(2, cVar);
        this.f10451a = i;
        this.f10453l = obj;
        this.f10454m = obj2;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f10451a) {
            case 0:
                return new d0((f0) this.f10453l, (Context) this.f10454m, cVar, 0);
            case 1:
                return new d0((f0) this.f10453l, (q1.a) this.f10454m, cVar, 1);
            case 2:
                return new d0((z0) this.f10453l, (x4.g) this.f10454m, cVar, 2);
            case 3:
                return new d0((m1) this.f10453l, (x4.g) this.f10454m, cVar, 3);
            case 4:
                return new d0((y2.r) this.f10453l, (MyFirebaseMessagingService) this.f10454m, cVar, 4);
            default:
                return new d0((MyFirebaseMessagingService) this.f10453l, (String) this.f10454m, cVar, 5);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        o7.a0 a0Var = (o7.a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f10451a) {
        }
        return ((d0) create(a0Var, cVar)).invokeSuspend(p6.x.f8463a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:261:0x0797, code lost:
    
        if (r0 == r8) goto L263;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x07aa, code lost:
    
        r0 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x07ab, code lost:
    
        if (r0 != r8) goto L234;
     */
    /* JADX WARN: Code restructure failed: missing block: B:267:0x07a7, code lost:
    
        if (r0 == r8) goto L263;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01f1  */
    /* JADX WARN: Type inference failed for: r11v2, types: [x4.r] */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r25) {
        /*
            Method dump skipped, instructions count: 1980
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u4.d0.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
