package m8;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z implements Cloneable {

    /* renamed from: a, reason: collision with root package name */
    public final x f7836a;

    /* renamed from: b, reason: collision with root package name */
    public final q8.e f7837b;

    /* renamed from: l, reason: collision with root package name */
    public b f7838l;

    /* renamed from: m, reason: collision with root package name */
    public final a0 f7839m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f7840n;

    public z(x xVar, a0 a0Var) {
        this.f7836a = xVar;
        this.f7839m = a0Var;
        this.f7837b = new q8.e(xVar);
    }

    public final c0 a() {
        ArrayList arrayList = new ArrayList();
        x xVar = this.f7836a;
        arrayList.addAll(xVar.f7816m);
        arrayList.add(this.f7837b);
        arrayList.add(new o8.b(xVar.f7820q, 2));
        g gVar = xVar.f7821r;
        arrayList.add(new o8.b(gVar != null ? gVar.f7721a : null, 0));
        int i = 1;
        arrayList.add(new o8.b(xVar, i));
        arrayList.addAll(xVar.f7817n);
        arrayList.add(new j5.h(i));
        b bVar = this.f7838l;
        int i6 = xVar.E;
        int i10 = xVar.F;
        int i11 = xVar.G;
        a0 a0Var = this.f7839m;
        return new q8.d(arrayList, null, null, null, 0, a0Var, this, bVar, i6, i10, i11).a(a0Var);
    }

    public final Object clone() {
        x xVar = this.f7836a;
        z zVar = new z(xVar, this.f7839m);
        xVar.f7818o.getClass();
        zVar.f7838l = b.f7681d;
        return zVar;
    }
}
