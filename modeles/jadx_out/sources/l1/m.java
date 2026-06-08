package l1;

import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m extends d {

    /* renamed from: l, reason: collision with root package name */
    public final transient Object[] f7073l;

    /* renamed from: m, reason: collision with root package name */
    public final transient int f7074m;

    /* renamed from: n, reason: collision with root package name */
    public final transient int f7075n;

    public m(Object[] objArr, int i, int i6) {
        this.f7073l = objArr;
        this.f7074m = i;
        this.f7075n = i6;
    }

    @Override // java.util.List
    public final Object get(int i) {
        a.a.n(i, this.f7075n);
        Object obj = this.f7073l[(i * 2) + this.f7074m];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7075n;
    }
}
