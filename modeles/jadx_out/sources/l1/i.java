package l1;

import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i extends d {

    /* renamed from: n, reason: collision with root package name */
    public static final i f7064n = new i(0, new Object[0]);

    /* renamed from: l, reason: collision with root package name */
    public final transient Object[] f7065l;

    /* renamed from: m, reason: collision with root package name */
    public final transient int f7066m;

    public i(int i, Object[] objArr) {
        this.f7065l = objArr;
        this.f7066m = i;
    }

    @Override // l1.d, l1.a
    public final int b(Object[] objArr) {
        Object[] objArr2 = this.f7065l;
        int i = this.f7066m;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // l1.a
    public final Object[] c() {
        return this.f7065l;
    }

    @Override // l1.a
    public final int d() {
        return this.f7066m;
    }

    @Override // l1.a
    public final int e() {
        return 0;
    }

    @Override // java.util.List
    public final Object get(int i) {
        a.a.n(i, this.f7066m);
        Object obj = this.f7065l[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f7066m;
    }
}
