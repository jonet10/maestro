package j$.util;

import j$.util.List;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.function.UnaryOperator;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class i extends h implements java.util.List, List {
    private static final long serialVersionUID = -7754090372962971524L;

    /* renamed from: c, reason: collision with root package name */
    public final java.util.List f6070c;

    public i(java.util.List list) {
        super(list);
        this.f6070c = list;
    }

    public i(java.util.List list, Object obj) {
        super(list, obj);
        this.f6070c = list;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        synchronized (this.f6065b) {
            equals = this.f6070c.equals(obj);
        }
        return equals;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int hashCode;
        synchronized (this.f6065b) {
            hashCode = this.f6070c.hashCode();
        }
        return hashCode;
    }

    @Override // java.util.List
    public final Object get(int i) {
        Object obj;
        synchronized (this.f6065b) {
            obj = this.f6070c.get(i);
        }
        return obj;
    }

    @Override // java.util.List
    public final Object set(int i, Object obj) {
        Object obj2;
        synchronized (this.f6065b) {
            obj2 = this.f6070c.set(i, obj);
        }
        return obj2;
    }

    @Override // java.util.List
    public final void add(int i, Object obj) {
        synchronized (this.f6065b) {
            this.f6070c.add(i, obj);
        }
    }

    @Override // java.util.List
    public final Object remove(int i) {
        Object remove;
        synchronized (this.f6065b) {
            remove = this.f6070c.remove(i);
        }
        return remove;
    }

    @Override // java.util.List
    public final int indexOf(Object obj) {
        int indexOf;
        synchronized (this.f6065b) {
            indexOf = this.f6070c.indexOf(obj);
        }
        return indexOf;
    }

    @Override // java.util.List
    public final int lastIndexOf(Object obj) {
        int lastIndexOf;
        synchronized (this.f6065b) {
            lastIndexOf = this.f6070c.lastIndexOf(obj);
        }
        return lastIndexOf;
    }

    @Override // java.util.List
    public final boolean addAll(int i, java.util.Collection collection) {
        boolean addAll;
        synchronized (this.f6065b) {
            addAll = this.f6070c.addAll(i, collection);
        }
        return addAll;
    }

    @Override // java.util.List
    public final ListIterator listIterator() {
        return this.f6070c.listIterator();
    }

    @Override // java.util.List
    public final ListIterator listIterator(int i) {
        return this.f6070c.listIterator(i);
    }

    @Override // java.util.List
    public java.util.List subList(int i, int i6) {
        i iVar;
        synchronized (this.f6065b) {
            iVar = new i(this.f6070c.subList(i, i6), this.f6065b);
        }
        return iVar;
    }

    @Override // java.util.List, j$.util.List
    public final void replaceAll(UnaryOperator unaryOperator) {
        synchronized (this.f6065b) {
            java.util.List list = this.f6070c;
            if (list instanceof List) {
                ((List) list).replaceAll(unaryOperator);
            } else {
                List.CC.$default$replaceAll(list, unaryOperator);
            }
        }
    }

    @Override // java.util.List, j$.util.List
    public final void sort(Comparator comparator) {
        synchronized (this.f6065b) {
            c.u(this.f6070c, comparator);
        }
    }

    private Object readResolve() {
        java.util.List list = this.f6070c;
        return list instanceof RandomAccess ? new k(list) : this;
    }
}
