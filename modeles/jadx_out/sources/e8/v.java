package e8;

import d8.b1;
import d8.e0;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v implements z7.b {

    /* renamed from: a, reason: collision with root package name */
    public static final v f4788a = new v();

    /* renamed from: b, reason: collision with root package name */
    public static final u f4789b = u.f4785b;

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        eVar.getClass();
        d0.b.m(eVar);
        b1 b1Var = b1.f3621a;
        m mVar = m.f4776a;
        return new t((Map) new e0(b1.f3621a, m.f4776a).deserialize(eVar));
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return f4789b;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        t tVar = (t) obj;
        tVar.getClass();
        d0.b.i(fVar);
        b1 b1Var = b1.f3621a;
        m mVar = m.f4776a;
        new e0(b1.f3621a, m.f4776a).serialize(fVar, tVar);
    }
}
