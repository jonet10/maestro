package z8;

import b9.e;
import b9.q;
import b9.u;
import b9.v;
import y8.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements e9.a {

    /* renamed from: a, reason: collision with root package name */
    public final char f11988a;

    public a(char c9) {
        this.f11988a = c9;
    }

    @Override // e9.a
    public final void a(v vVar, v vVar2, int i) {
        String.valueOf(this.f11988a);
        q eVar = i == 1 ? new e() : new u();
        q qVar = vVar.f1125e;
        while (qVar != null && qVar != vVar2) {
            q qVar2 = qVar.f1125e;
            eVar.b(qVar);
            qVar = qVar2;
        }
        eVar.f();
        q qVar3 = vVar.f1125e;
        eVar.f1125e = qVar3;
        if (qVar3 != null) {
            qVar3.f1124d = eVar;
        }
        eVar.f1124d = vVar;
        vVar.f1125e = eVar;
        q qVar4 = vVar.f1121a;
        eVar.f1121a = qVar4;
        if (eVar.f1125e == null) {
            qVar4.f1123c = eVar;
        }
    }

    @Override // e9.a
    public final char b() {
        return this.f11988a;
    }

    @Override // e9.a
    public final int c() {
        return 1;
    }

    @Override // e9.a
    public final char d() {
        return this.f11988a;
    }

    @Override // e9.a
    public final int e(f fVar, f fVar2) {
        if (fVar.f11826d || fVar2.f11825c) {
            int i = fVar2.h;
            if (i % 3 != 0 && (fVar.h + i) % 3 == 0) {
                return 0;
            }
        }
        return (fVar.g < 2 || fVar2.g < 2) ? 1 : 2;
    }
}
