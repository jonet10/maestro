package b;

import com.inmobi.cmp.ChoiceCmp;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class g extends v6.c {

    /* renamed from: a, reason: collision with root package name */
    public /* synthetic */ Object f665a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ChoiceCmp f666b;

    /* renamed from: l, reason: collision with root package name */
    public int f667l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(ChoiceCmp choiceCmp, t6.c cVar) {
        super(cVar);
        this.f666b = choiceCmp;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        this.f665a = obj;
        this.f667l |= Integer.MIN_VALUE;
        return ChoiceCmp.access$handleMSPA(this.f666b, null, this);
    }
}
