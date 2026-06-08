package o2;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements e {

    /* renamed from: a, reason: collision with root package name */
    public final int f8134a;

    public a(int i) {
        this.f8134a = i;
    }

    @Override // java.lang.annotation.Annotation
    public final Class annotationType() {
        return e.class;
    }

    @Override // java.lang.annotation.Annotation
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f8134a == eVar.tag() && d.f8136a.equals(eVar.intEncoding());
    }

    @Override // java.lang.annotation.Annotation
    public final int hashCode() {
        return (14552422 ^ this.f8134a) + (d.f8136a.hashCode() ^ 2041407134);
    }

    @Override // o2.e
    public final d intEncoding() {
        return d.f8136a;
    }

    @Override // o2.e
    public final int tag() {
        return this.f8134a;
    }

    @Override // java.lang.annotation.Annotation
    public final String toString() {
        return "@com.google.firebase.encoders.proto.Protobuf(tag=" + this.f8134a + "intEncoding=" + d.f8136a + ')';
    }
}
