package z4;

import android.content.BroadcastReceiver;
import d7.p;
import o7.a0;
import p6.x;
import v6.i;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11954a = 1;

    /* renamed from: b, reason: collision with root package name */
    public int f11955b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ a4.p f11956l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f11957m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ BroadcastReceiver.PendingResult f11958n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(a4.p pVar, String str, BroadcastReceiver.PendingResult pendingResult, t6.c cVar) {
        super(2, cVar);
        this.f11956l = pVar;
        this.f11957m = str;
        this.f11958n = pendingResult;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        switch (this.f11954a) {
            case 0:
                return new a(this.f11957m, this.f11956l, this.f11958n, cVar);
            default:
                return new a(this.f11956l, this.f11957m, this.f11958n, cVar);
        }
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        a0 a0Var = (a0) obj;
        t6.c cVar = (t6.c) obj2;
        switch (this.f11954a) {
        }
        return ((a) create(a0Var, cVar)).invokeSuspend(x.f8463a);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00bb  */
    @Override // v6.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            Method dump skipped, instructions count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: z4.a.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(String str, a4.p pVar, BroadcastReceiver.PendingResult pendingResult, t6.c cVar) {
        super(2, cVar);
        this.f11957m = str;
        this.f11956l = pVar;
        this.f11958n = pendingResult;
    }
}
