package x7;

import o7.c2;
import t7.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d implements c2 {

    /* renamed from: a, reason: collision with root package name */
    public final d f11522a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11523b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ g f11524l;

    public d(g gVar, d dVar, Object obj) {
        this.f11524l = gVar;
        this.f11522a = dVar;
        this.f11523b = obj;
    }

    @Override // o7.c2
    public final void a(s sVar, int i) {
        this.f11522a.a(sVar, i);
    }

    public final void b(Object obj) {
        g.f11527q.set(this.f11524l, this.f11523b);
        this.f11522a.b(obj);
    }

    public final boolean c(Object obj, Object obj2) {
        boolean c9 = this.f11522a.c(obj, obj2);
        if (c9) {
            g.f11527q.set(this.f11524l, this.f11523b);
        }
        return c9;
    }
}
