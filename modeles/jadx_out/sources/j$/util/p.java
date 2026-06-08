package j$.util;

import java.util.Comparator;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.UnaryOperator;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class p extends n implements java.util.List, List {
    private static final long serialVersionUID = -283967356065247728L;

    /* renamed from: b, reason: collision with root package name */
    public final java.util.List f6101b;

    public p(java.util.List list) {
        super(list);
        this.f6101b = list;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        return obj == this || this.f6101b.equals(obj);
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        return this.f6101b.hashCode();
    }

    @Override // java.util.List
    public final Object get(int i) {
        return this.f6101b.get(i);
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        return this.f6101b.indexOf(obj);
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        return this.f6101b.lastIndexOf(obj);
    }

    @Override // java.util.List
    public final boolean addAll(int i, java.util.Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, j$.util.List
    public final void replaceAll(UnaryOperator unaryOperator) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List, j$.util.List
    public final void sort(Comparator comparator) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return new o(this, 0);
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return new o(this, i);
    }

    @Override // java.util.List
    public java.util.List subList(int i, int i6) {
        return new p(this.f6101b.subList(i, i6));
    }

    private Object readResolve() {
        java.util.List list = this.f6101b;
        return list instanceof RandomAccess ? new v(list) : this;
    }
}
