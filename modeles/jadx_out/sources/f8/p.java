package f8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p extends a {
    public final e8.k f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(e8.b bVar, e8.k kVar, String str) {
        super(bVar, str);
        bVar.getClass();
        kVar.getClass();
        this.f = kVar;
        this.f4924a.add("primitive");
    }

    @Override // f8.a
    public final e8.k b(String str) {
        str.getClass();
        if (str == "primitive") {
            return this.f;
        }
        com.google.gson.internal.a.p("This input can only handle primitives with 'primitive' tag");
        return null;
    }

    @Override // c8.c
    public final int decodeElementIndex(b8.e eVar) {
        eVar.getClass();
        return 0;
    }

    @Override // f8.a
    public final e8.k q() {
        return this.f;
    }
}
