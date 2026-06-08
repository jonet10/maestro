package j$.util;

import java.util.ListIterator;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class o implements ListIterator, z {

    /* renamed from: a, reason: collision with root package name */
    public final ListIterator f6099a;

    public o(p pVar, int i) {
        this.f6099a = pVar.f6101b.listIterator(i);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.f6099a.hasNext();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final Object next() {
        return this.f6099a.next();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f6099a.hasPrevious();
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        return this.f6099a.previous();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f6099a.nextIndex();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f6099a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, j$.util.z
    public final void forEachRemaining(Consumer consumer) {
        c.r(this.f6099a, consumer);
    }
}
