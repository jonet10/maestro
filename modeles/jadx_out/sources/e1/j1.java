package e1;

import androidx.collection.LruCache;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j1 extends LruCache {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ m1 f4053a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j1(m1 m1Var) {
        super(20);
        this.f4053a = m1Var;
    }

    @Override // androidx.collection.LruCache
    public final Object create(Object obj) {
        String str = (String) obj;
        k0.y.d(str);
        m1 m1Var = this.f4053a;
        m1Var.h();
        k0.y.d(str);
        m mVar = m1Var.f4092b.f4307l;
        u4.U(mVar);
        b5.m m02 = mVar.m0(str);
        if (m02 == null) {
            return null;
        }
        w0 w0Var = m1Var.f3875a.f4264o;
        t1.m(w0Var);
        w0Var.f4346w.c(str, "Populate EES config from database on cache miss. appId");
        m1Var.o(str, m1Var.p(str, (byte[]) m02.f1061b));
        return (com.google.android.gms.internal.measurement.e0) m1Var.f4111s.snapshot().get(str);
    }
}
