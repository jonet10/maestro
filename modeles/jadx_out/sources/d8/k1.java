package d8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k1 implements z7.b {

    /* renamed from: a, reason: collision with root package name */
    public static final k1 f3665a = new k1();

    /* renamed from: b, reason: collision with root package name */
    public static final y f3666b = o0.a("kotlin.ULong", i0.f3655a);

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        eVar.getClass();
        return new p6.s(eVar.decodeInline(f3666b).decodeLong());
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return f3666b;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        fVar.encodeInline(f3666b).encodeLong(((p6.s) obj).f8458a);
    }
}
