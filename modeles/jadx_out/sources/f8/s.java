package f8;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s extends a {
    public final e8.d f;
    public final int g;
    public int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(e8.b bVar, e8.d dVar) {
        super(bVar, null);
        bVar.getClass();
        this.f = dVar;
        this.g = dVar.f4764a.size();
        this.h = -1;
    }

    @Override // f8.a
    public final e8.k b(String str) {
        str.getClass();
        return (e8.k) this.f.f4764a.get(Integer.parseInt(str));
    }

    @Override // c8.c
    public final int decodeElementIndex(b8.e eVar) {
        eVar.getClass();
        int i = this.h;
        if (i >= this.g - 1) {
            return -1;
        }
        int i6 = i + 1;
        this.h = i6;
        return i6;
    }

    @Override // f8.a
    public final String n(b8.e eVar, int i) {
        eVar.getClass();
        return String.valueOf(i);
    }

    @Override // f8.a
    public final e8.k q() {
        return this.f;
    }
}
