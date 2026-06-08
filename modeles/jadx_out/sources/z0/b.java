package z0;

import b2.t1;
import java.util.ListIterator;
import l1.q;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b extends q implements ListIterator {

    /* renamed from: b, reason: collision with root package name */
    public final int f11890b;

    /* renamed from: l, reason: collision with root package name */
    public int f11891l;

    /* renamed from: m, reason: collision with root package name */
    public final e f11892m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(e eVar, int i) {
        super(1);
        int size = eVar.size();
        if (i < 0 || i > size) {
            com.google.gson.internal.a.r(t1.Z(i, size, "index"));
            throw null;
        }
        this.f11890b = size;
        this.f11891l = i;
        this.f11892m = eVar;
    }

    public final Object a(int i) {
        return this.f11892m.get(i);
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.f11891l < this.f11890b;
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f11891l > 0;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final Object next() {
        if (!hasNext()) {
            com.google.gson.internal.a.l();
            return null;
        }
        int i = this.f11891l;
        this.f11891l = i + 1;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f11891l;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            com.google.gson.internal.a.l();
            return null;
        }
        int i = this.f11891l - 1;
        this.f11891l = i;
        return a(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f11891l - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException();
    }
}
