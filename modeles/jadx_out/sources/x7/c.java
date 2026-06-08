package x7;

import d7.q;
import f8.w;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import o7.c2;
import p6.x;
import t7.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c implements o7.j, c2 {

    /* renamed from: a, reason: collision with root package name */
    public final o7.l f11519a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11520b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ g f11521l;

    public c(g gVar, o7.l lVar, Object obj) {
        this.f11521l = gVar;
        this.f11519a = lVar;
        this.f11520b = obj;
    }

    @Override // o7.c2
    public final void a(s sVar, int i) {
        this.f11519a.a(sVar, i);
    }

    @Override // o7.j
    public final void g(Object obj, q qVar) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = g.f11527q;
        Object obj2 = this.f11520b;
        g gVar = this.f11521l;
        atomicReferenceFieldUpdater.set(gVar, obj2);
        this.f11519a.A(new androidx.work.impl.model.a(11, gVar, this), x.f8463a);
    }

    @Override // t6.c
    public final t6.h getContext() {
        return this.f11519a.f8281n;
    }

    @Override // o7.j
    public final w i(Object obj, q qVar) {
        g gVar = this.f11521l;
        b bVar = new b(gVar, this, 1);
        w E = this.f11519a.E((x) obj, bVar);
        if (E != null) {
            g.f11527q.set(gVar, this.f11520b);
        }
        return E;
    }

    @Override // o7.j
    public final boolean o(Throwable th) {
        return this.f11519a.o(th);
    }

    @Override // o7.j
    public final void q(Object obj) {
        this.f11519a.q(obj);
    }

    @Override // t6.c
    public final void resumeWith(Object obj) {
        this.f11519a.resumeWith(obj);
    }
}
