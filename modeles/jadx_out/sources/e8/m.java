package e8;

import b2.t1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m implements z7.b {

    /* renamed from: a, reason: collision with root package name */
    public static final m f4776a = new m();

    /* renamed from: b, reason: collision with root package name */
    public static final b8.f f4777b = t1.o("kotlinx.serialization.json.JsonElement", b8.c.i, new b8.e[0], new androidx.room.f(24));

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        eVar.getClass();
        return d0.b.m(eVar).a();
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return f4777b;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        k kVar = (k) obj;
        kVar.getClass();
        d0.b.i(fVar);
        if (kVar instanceof x) {
            fVar.encodeSerializableValue(y.f4790a, kVar);
            return;
        }
        if (kVar instanceof t) {
            fVar.encodeSerializableValue(v.f4788a, kVar);
        } else if (kVar instanceof d) {
            fVar.encodeSerializableValue(f.f4768a, kVar);
        } else {
            com.google.gson.internal.a.b();
        }
    }
}
