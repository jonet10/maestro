package k7;

import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l implements Iterator, e7.a {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f7003a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f7004b;

    public l(d dVar) {
        this.f7004b = dVar;
        this.f7003a = ((f) dVar.f6992b).iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f7003a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return ((d7.l) this.f7004b.f6993c).invoke(this.f7003a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
