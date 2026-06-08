package e1;

import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f4241a;

    public s(t tVar) {
        this.f4241a = tVar.f4251a.keySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f4241a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return (String) this.f4241a.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
