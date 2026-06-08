package androidx.core.view;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import q6.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class TreeIterator<T> implements Iterator<T>, e7.a {
    private final d7.l getChildIterator;
    private Iterator<? extends T> iterator;
    private final List<Iterator<T>> stack = new ArrayList();

    public TreeIterator(Iterator<? extends T> it, d7.l lVar) {
        this.getChildIterator = lVar;
        this.iterator = it;
    }

    private final void prepareNextIterator(T t9) {
        Iterator<? extends T> it = (Iterator) this.getChildIterator.invoke(t9);
        if (it != null && it.hasNext()) {
            this.stack.add(this.iterator);
            this.iterator = it;
        } else {
            while (!this.iterator.hasNext() && !this.stack.isEmpty()) {
                this.iterator = (Iterator) q6.l.y0(this.stack);
                r.n0(this.stack);
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // java.util.Iterator
    public T next() {
        T next = this.iterator.next();
        prepareNextIterator(next);
        return next;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
