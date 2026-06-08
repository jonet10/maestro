package e8;

import b2.t1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r implements z7.b {

    /* renamed from: a, reason: collision with root package name */
    public static final r f4782a = new r();

    /* renamed from: b, reason: collision with root package name */
    public static final b8.f f4783b = t1.p("kotlinx.serialization.json.JsonNull", b8.h.h, new b8.e[0]);

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        eVar.getClass();
        d0.b.m(eVar);
        if (eVar.decodeNotNullMark()) {
            throw new f8.h("Expected 'null' literal");
        }
        eVar.decodeNull();
        return q.INSTANCE;
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return f4783b;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        ((q) obj).getClass();
        d0.b.i(fVar);
        fVar.encodeNull();
    }
}
