package d8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h1 implements z7.b {

    /* renamed from: a, reason: collision with root package name */
    public static final h1 f3652a = new h1();

    /* renamed from: b, reason: collision with root package name */
    public static final y f3653b = o0.a("kotlin.UInt", c0.f3624a);

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        eVar.getClass();
        return new p6.q(eVar.decodeInline(f3653b).decodeInt());
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return f3653b;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        fVar.encodeInline(f3653b).encodeInt(((p6.q) obj).f8456a);
    }
}
