package d8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j implements z7.b {

    /* renamed from: a, reason: collision with root package name */
    public static final j f3659a = new j();

    /* renamed from: b, reason: collision with root package name */
    public static final u0 f3660b = new u0("kotlin.Byte", b8.d.i);

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        eVar.getClass();
        return Byte.valueOf(eVar.decodeByte());
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return f3660b;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        fVar.encodeByte(((Number) obj).byteValue());
    }
}
