package f9;

import kotlin.jvm.internal.x;
import o7.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public int f5060a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f5061b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ x f5062l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ String f5063m;

    /* renamed from: n, reason: collision with root package name */
    public final /* synthetic */ boolean f5064n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(x xVar, x xVar2, String str, boolean z9, t6.c cVar) {
        super(2, cVar);
        this.f5061b = xVar;
        this.f5062l = xVar2;
        this.f5063m = str;
        this.f5064n = z9;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new p(this.f5061b, this.f5062l, this.f5063m, this.f5064n, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        return ((p) create((a0) obj, (t6.c) obj2)).invokeSuspend(p6.x.f8463a);
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        int i = this.f5060a;
        if (i == 0) {
            p6.a.e(obj);
            h hVar = q.f5066b;
            d dVar = (d) this.f5061b.f7024a;
            c cVar = (c) this.f5062l.f7024a;
            boolean z9 = !this.f5064n;
            this.f5060a = 1;
            Object d10 = hVar.d(dVar, cVar, this.f5063m, z9, this);
            u6.a aVar = u6.a.f10762a;
            if (d10 == aVar) {
                return aVar;
            }
        } else {
            if (i != 1) {
                androidx.privacysandbox.ads.adservices.customaudience.a.i("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            p6.a.e(obj);
        }
        return p6.x.f8463a;
    }
}
