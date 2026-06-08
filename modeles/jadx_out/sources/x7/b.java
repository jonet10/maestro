package x7;

import d7.q;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class b implements q {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11516a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ g f11517b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ Object f11518l;

    public /* synthetic */ b(g gVar, Object obj, int i) {
        this.f11516a = i;
        this.f11517b = gVar;
        this.f11518l = obj;
    }

    @Override // d7.q
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        switch (this.f11516a) {
            case 0:
                this.f11517b.unlock(this.f11518l);
                break;
            default:
                c cVar = (c) this.f11518l;
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g.f11527q;
                Object obj4 = cVar.f11520b;
                g gVar = this.f11517b;
                atomicReferenceFieldUpdater.set(gVar, obj4);
                gVar.unlock(obj4);
                break;
        }
        return x.f8463a;
    }
}
