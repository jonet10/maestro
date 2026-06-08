package l1;

import java.util.ListIterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends q implements ListIterator {

    /* renamed from: b, reason: collision with root package name */
    public final int f7047b;

    /* renamed from: l, reason: collision with root package name */
    public int f7048l;

    /* renamed from: m, reason: collision with root package name */
    public final d f7049m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(d dVar, int i) {
        super(0);
        int size = dVar.size();
        a.a.p(i, size);
        this.f7047b = size;
        this.f7048l = i;
        this.f7049m = dVar;
    }

    public final Object a(int i) {
        return this.f7049m.get(i);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f7048l < this.f7047b;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f7048l > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            com.google.gson.internal.a.l();
            return null;
        }
        int i = this.f7048l;
        this.f7048l = i + 1;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f7048l;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            com.google.gson.internal.a.l();
            return null;
        }
        int i = this.f7048l - 1;
        this.f7048l = i;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f7048l - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
