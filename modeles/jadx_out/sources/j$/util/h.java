package j$.util;

import j$.util.Collection;
import j$.util.Spliterator;
import j$.util.stream.Stream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class h implements java.util.Collection, Serializable, Collection {
    private static final long serialVersionUID = 3053995032091335093L;

    /* renamed from: a, reason: collision with root package name */
    public final java.util.Collection f6064a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6065b;

    @Override // java.util.Collection, j$.util.Collection
    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        Object[] array;
        array = toArray((Object[]) intFunction.apply(0));
        return array;
    }

    public h(java.util.Collection collection) {
        this.f6064a = (java.util.Collection) Objects.requireNonNull(collection);
        this.f6065b = this;
    }

    public h(java.util.Collection collection, Object obj) {
        this.f6064a = (java.util.Collection) Objects.requireNonNull(collection);
        this.f6065b = Objects.requireNonNull(obj);
    }

    @Override // java.util.Collection
    public final int size() {
        int size;
        synchronized (this.f6065b) {
            size = this.f6064a.size();
        }
        return size;
    }

    @Override // java.util.Collection
    public final boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.f6065b) {
            isEmpty = this.f6064a.isEmpty();
        }
        return isEmpty;
    }

    @Override // java.util.Collection
    public final boolean contains(Object obj) {
        boolean contains;
        synchronized (this.f6065b) {
            contains = this.f6064a.contains(obj);
        }
        return contains;
    }

    @Override // java.util.Collection
    public final Object[] toArray() {
        Object[] array;
        synchronized (this.f6065b) {
            array = this.f6064a.toArray();
        }
        return array;
    }

    @Override // java.util.Collection
    public final Object[] toArray(Object[] objArr) {
        Object[] array;
        synchronized (this.f6065b) {
            array = this.f6064a.toArray(objArr);
        }
        return array;
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        return this.f6064a.iterator();
    }

    @Override // java.util.Collection
    public final boolean add(Object obj) {
        boolean add;
        synchronized (this.f6065b) {
            add = this.f6064a.add(obj);
        }
        return add;
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        boolean remove;
        synchronized (this.f6065b) {
            remove = this.f6064a.remove(obj);
        }
        return remove;
    }

    @Override // java.util.Collection
    public final boolean containsAll(java.util.Collection collection) {
        boolean containsAll;
        synchronized (this.f6065b) {
            containsAll = this.f6064a.containsAll(collection);
        }
        return containsAll;
    }

    @Override // java.util.Collection
    public final boolean addAll(java.util.Collection collection) {
        boolean addAll;
        synchronized (this.f6065b) {
            addAll = this.f6064a.addAll(collection);
        }
        return addAll;
    }

    @Override // java.util.Collection
    public final boolean removeAll(java.util.Collection collection) {
        boolean removeAll;
        synchronized (this.f6065b) {
            removeAll = this.f6064a.removeAll(collection);
        }
        return removeAll;
    }

    @Override // java.util.Collection
    public final boolean retainAll(java.util.Collection collection) {
        boolean retainAll;
        synchronized (this.f6065b) {
            retainAll = this.f6064a.retainAll(collection);
        }
        return retainAll;
    }

    @Override // java.util.Collection
    public final void clear() {
        synchronized (this.f6065b) {
            this.f6064a.clear();
        }
    }

    public final String toString() {
        String obj;
        synchronized (this.f6065b) {
            obj = this.f6064a.toString();
        }
        return obj;
    }

    @Override // java.lang.Iterable, j$.util.Collection
    public final void forEach(Consumer consumer) {
        synchronized (this.f6065b) {
            Collection.EL.a(this.f6064a, consumer);
        }
    }

    @Override // java.util.Collection, j$.util.Collection
    public final boolean removeIf(Predicate predicate) {
        boolean removeIf;
        synchronized (this.f6065b) {
            removeIf = Collection.EL.removeIf(this.f6064a, predicate);
        }
        return removeIf;
    }

    @Override // java.util.Collection, java.lang.Iterable, j$.util.Collection
    public final Spliterator spliterator() {
        return Collection.EL.c(this.f6064a);
    }

    @Override // java.util.Collection, java.lang.Iterable
    public final java.util.Spliterator spliterator() {
        return Spliterator.Wrapper.convert(Collection.EL.c(this.f6064a));
    }

    @Override // java.util.Collection, j$.util.Collection
    public final Stream stream() {
        return Collection.EL.stream(this.f6064a);
    }

    @Override // java.util.Collection
    public final java.util.stream.Stream stream() {
        return Stream.Wrapper.convert(Collection.EL.stream(this.f6064a));
    }

    @Override // java.util.Collection, j$.util.Collection
    public final Stream parallelStream() {
        return Collection.EL.b(this.f6064a);
    }

    @Override // java.util.Collection
    public final java.util.stream.Stream parallelStream() {
        return Stream.Wrapper.convert(Collection.EL.b(this.f6064a));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        synchronized (this.f6065b) {
            objectOutputStream.defaultWriteObject();
        }
    }
}
