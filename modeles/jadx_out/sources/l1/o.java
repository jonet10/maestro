package l1;

import com.google.android.gms.internal.measurement.z3;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o extends g {

    /* renamed from: r, reason: collision with root package name */
    public static final Object[] f7080r;

    /* renamed from: s, reason: collision with root package name */
    public static final o f7081s;

    /* renamed from: m, reason: collision with root package name */
    public final transient Object[] f7082m;

    /* renamed from: n, reason: collision with root package name */
    public final transient int f7083n;

    /* renamed from: o, reason: collision with root package name */
    public final transient Object[] f7084o;

    /* renamed from: p, reason: collision with root package name */
    public final transient int f7085p;

    /* renamed from: q, reason: collision with root package name */
    public final transient int f7086q;

    static {
        Object[] objArr = new Object[0];
        f7080r = objArr;
        f7081s = new o(0, 0, 0, objArr, objArr);
    }

    public o(int i, int i6, int i10, Object[] objArr, Object[] objArr2) {
        this.f7082m = objArr;
        this.f7083n = i;
        this.f7084o = objArr2;
        this.f7085p = i6;
        this.f7086q = i10;
    }

    @Override // l1.a
    public final int b(Object[] objArr) {
        Object[] objArr2 = this.f7082m;
        int i = this.f7086q;
        System.arraycopy(objArr2, 0, objArr, 0, i);
        return i;
    }

    @Override // l1.a
    public final Object[] c() {
        return this.f7082m;
    }

    @Override // l1.a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.f7084o;
            if (objArr.length != 0) {
                int S = z3.S(obj.hashCode());
                while (true) {
                    int i = S & this.f7085p;
                    Object obj2 = objArr[i];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    S = i + 1;
                }
            }
        }
        return false;
    }

    @Override // l1.a
    public final int d() {
        return this.f7086q;
    }

    @Override // l1.a
    public final int e() {
        return 0;
    }

    @Override // l1.g, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f7083n;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return g().listIterator(0);
    }

    @Override // l1.g
    public final d l() {
        return d.g(this.f7086q, this.f7082m);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f7086q;
    }
}
