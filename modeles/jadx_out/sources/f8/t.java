package f8;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t extends r {
    public final e8.t j;

    /* renamed from: k, reason: collision with root package name */
    public final List f4966k;

    /* renamed from: l, reason: collision with root package name */
    public final int f4967l;

    /* renamed from: m, reason: collision with root package name */
    public int f4968m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(e8.b bVar, e8.t tVar) {
        super(bVar, tVar, (String) null, 12);
        bVar.getClass();
        this.j = tVar;
        List G0 = q6.l.G0(tVar.f4784a.keySet());
        this.f4966k = G0;
        this.f4967l = G0.size() * 2;
        this.f4968m = -1;
    }

    @Override // f8.r, f8.a
    public final e8.k b(String str) {
        str.getClass();
        if (this.f4968m % 2 != 0) {
            return (e8.k) q6.a0.g0(this.j, str);
        }
        d8.y yVar = e8.l.f4775a;
        return new e8.n(str, true);
    }

    @Override // f8.r, c8.c
    public final int decodeElementIndex(b8.e eVar) {
        eVar.getClass();
        int i = this.f4968m;
        if (i >= this.f4967l - 1) {
            return -1;
        }
        int i6 = i + 1;
        this.f4968m = i6;
        return i6;
    }

    @Override // f8.r, f8.a, c8.c
    public final void endStructure(b8.e eVar) {
        eVar.getClass();
    }

    @Override // f8.r, f8.a
    public final String n(b8.e eVar, int i) {
        eVar.getClass();
        return (String) this.f4966k.get(i / 2);
    }

    @Override // f8.r, f8.a
    public final e8.k q() {
        return this.j;
    }

    @Override // f8.r
    /* renamed from: v */
    public final e8.t q() {
        return this.j;
    }
}
