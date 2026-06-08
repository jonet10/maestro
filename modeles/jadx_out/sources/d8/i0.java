package d8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i0 implements z7.b {

    /* renamed from: a, reason: collision with root package name */
    public static final i0 f3655a = new i0();

    /* renamed from: b, reason: collision with root package name */
    public static final u0 f3656b = new u0("kotlin.Long", b8.d.f1109n);

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        eVar.getClass();
        return Long.valueOf(eVar.decodeLong());
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return f3656b;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        fVar.encodeLong(((Number) obj).longValue());
    }
}
