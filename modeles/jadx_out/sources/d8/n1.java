package d8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n1 implements z7.b {

    /* renamed from: a, reason: collision with root package name */
    public static final n1 f3680a = new n1();

    /* renamed from: b, reason: collision with root package name */
    public static final y f3681b = o0.a("kotlin.UShort", a1.f3618a);

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        eVar.getClass();
        return new p6.v(eVar.decodeInline(f3681b).decodeShort());
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return f3681b;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        fVar.encodeInline(f3681b).encodeShort(((p6.v) obj).f8461a);
    }
}
