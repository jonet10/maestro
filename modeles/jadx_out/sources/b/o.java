package b;

import com.inmobi.cmp.ChoiceCmp;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class o extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f700a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChoiceCmp f701b;

    /* renamed from: l, reason: collision with root package name */
    public int f702l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(ChoiceCmp choiceCmp, t6.c cVar) {
        super(cVar);
        this.f701b = choiceCmp;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f700a = obj;
        this.f702l |= Integer.MIN_VALUE;
        return ChoiceCmp.access$loadCmpList(this.f701b, this);
    }
}
