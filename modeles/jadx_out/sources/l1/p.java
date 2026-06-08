package l1;

import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p extends g {

    /* renamed from: m, reason: collision with root package name */
    public final transient Object f7087m;

    public p(Object obj) {
        this.f7087m = obj;
    }

    @Override // l1.a
    public final int b(Object[] objArr) {
        objArr[0] = this.f7087m;
        return 1;
    }

    @Override // l1.a, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.f7087m.equals(obj);
    }

    @Override // l1.g, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.f7087m.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new h(this.f7087m);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String obj = this.f7087m.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }
}
