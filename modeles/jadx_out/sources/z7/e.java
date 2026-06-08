package z7;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e extends d8.b {

    /* renamed from: a, reason: collision with root package name */
    public final j7.c f11986a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f11987b;

    public e(j7.c cVar) {
        cVar.getClass();
        this.f11986a = cVar;
        this.f11987b = p6.a.c(p6.g.f8438a, new d(this, 0));
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, p6.f] */
    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return (b8.e) this.f11987b.getValue();
    }

    public final String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + this.f11986a + ')';
    }
}
