package z0;

import b2.t1;
import j$.util.Objects;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends e {

    /* renamed from: n, reason: collision with root package name */
    public static final f f11898n = new f(0, new Object[0]);

    /* renamed from: l, reason: collision with root package name */
    public final transient Object[] f11899l;

    /* renamed from: m, reason: collision with root package name */
    public final transient int f11900m;

    public f(int i, Object[] objArr) {
        this.f11899l = objArr;
        this.f11900m = i;
    }

    @Override // z0.a
    public final Object[] b() {
        return this.f11899l;
    }

    @Override // z0.a
    public final int c() {
        return 0;
    }

    @Override // z0.a
    public final int d() {
        return this.f11900m;
    }

    @Override // z0.e, z0.a
    public final int e(Object[] objArr) {
        Object[] objArr2 = this.f11899l;
        int i = this.f11900m;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // java.util.List
    public final Object get(int i) {
        t1.T(i, this.f11900m);
        Object obj = this.f11899l[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f11900m;
    }
}
