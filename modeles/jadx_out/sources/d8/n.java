package d8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n implements z7.b {

    /* renamed from: a, reason: collision with root package name */
    public static final n f3677a = new n();

    /* renamed from: b, reason: collision with root package name */
    public static final u0 f3678b = new u0("kotlin.Char", b8.d.j);

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        eVar.getClass();
        return Character.valueOf(eVar.decodeChar());
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return f3678b;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        fVar.encodeChar(((Character) obj).charValue());
    }
}
