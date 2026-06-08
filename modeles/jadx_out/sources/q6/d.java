package q6;

import java.util.List;
import java.util.RandomAccess;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends e implements RandomAccess {

    /* renamed from: a, reason: collision with root package name */
    public final e f8714a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8715b;

    /* renamed from: l, reason: collision with root package name */
    public final int f8716l;

    public d(e eVar, int i, int i6) {
        this.f8714a = eVar;
        this.f8715b = i;
        b bVar = e.Companion;
        int size = eVar.size();
        bVar.getClass();
        b.d(i, i6, size);
        this.f8716l = i6 - i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        e.Companion.getClass();
        b.b(i, this.f8716l);
        return this.f8714a.get(this.f8715b + i);
    }

    @Override // q6.a
    public final int getSize() {
        return this.f8716l;
    }

    @Override // q6.e, java.util.List
    public final List subList(int i, int i6) {
        e.Companion.getClass();
        b.d(i, i6, this.f8716l);
        int i10 = this.f8715b;
        return new d(this.f8714a, i + i10, i10 + i6);
    }
}
