package c4;

import com.uptodown.activities.MyDownloads;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g5 extends v6.i implements d7.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MyDownloads f1626a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f1627b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g5(MyDownloads myDownloads, boolean z9, t6.c cVar) {
        super(2, cVar);
        this.f1626a = myDownloads;
        this.f1627b = z9;
    }

    @Override // v6.a
    public final t6.c create(Object obj, t6.c cVar) {
        return new g5(this.f1626a, this.f1627b, cVar);
    }

    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        g5 g5Var = (g5) create((o7.a0) obj, (t6.c) obj2);
        p6.x xVar = p6.x.f8463a;
        g5Var.invokeSuspend(xVar);
        return xVar;
    }

    @Override // v6.a
    public final Object invokeSuspend(Object obj) {
        p6.a.e(obj);
        MyDownloads myDownloads = this.f1626a;
        e4.b bVar = myDownloads.Q;
        if (bVar != null && !bVar.f4485b.isEmpty()) {
            e4.b bVar2 = myDownloads.Q;
            if (this.f1627b) {
                bVar2.getClass();
                Iterator it = bVar2.f4485b.iterator();
                it.getClass();
                while (it.hasNext()) {
                    Object next = it.next();
                    next.getClass();
                    e4.b bVar3 = myDownloads.Q;
                    bVar3.getClass();
                    myDownloads.z0(bVar3.f4485b.indexOf((x4.r) next));
                }
            } else {
                bVar2.getClass();
                Iterator it2 = bVar2.f4485b.iterator();
                it2.getClass();
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    next2.getClass();
                    x4.r rVar = (x4.r) next2;
                    if (!rVar.m()) {
                        r7.o0 o0Var = a5.b.f193a;
                        if (!a5.b.c(rVar.f11361q)) {
                            e4.b bVar4 = myDownloads.Q;
                            bVar4.getClass();
                            myDownloads.z0(bVar4.f4485b.indexOf(rVar));
                        }
                    }
                }
            }
            myDownloads.F0();
            myDownloads.C0(false);
        }
        return p6.x.f8463a;
    }
}
