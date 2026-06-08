package e8;

import b2.t1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y implements z7.b {

    /* renamed from: a, reason: collision with root package name */
    public static final y f4790a = new y();

    /* renamed from: b, reason: collision with root package name */
    public static final b8.f f4791b = t1.p("kotlinx.serialization.json.JsonPrimitive", b8.d.f1111p, new b8.e[0]);

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        eVar.getClass();
        k a8 = d0.b.m(eVar).a();
        if (a8 instanceof x) {
            return (x) a8;
        }
        throw f8.m.e("Unexpected JSON element, expected JsonPrimitive, had " + kotlin.jvm.internal.y.a(a8.getClass()), a8.toString(), -1);
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return f4791b;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        x xVar = (x) obj;
        xVar.getClass();
        d0.b.i(fVar);
        if (xVar instanceof q) {
            fVar.encodeSerializableValue(r.f4782a, q.INSTANCE);
        } else {
            fVar.encodeSerializableValue(o.f4780a, (n) xVar);
        }
    }
}
