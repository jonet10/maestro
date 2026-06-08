package b;

import com.inmobi.cmp.ChoiceCmp;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class k extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public int f685a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f686b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(boolean z9, t6.c cVar) {
        super(2, cVar);
        this.f686b = z9;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new k(this.f686b, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return new k(this.f686b, (t6.c) obj2).invokeSuspend(x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f685a;
        if (i == 0) {
            p6.a.e(obj);
            ChoiceCmp choiceCmp = ChoiceCmp.INSTANCE;
            this.f685a = 1;
            Object access$handleGDPR = ChoiceCmp.access$handleGDPR(choiceCmp, this.f686b, this);
            u6.a aVar = u6.a.f10762a;
            if (access$handleGDPR == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return x.f8463a;
    }
}
