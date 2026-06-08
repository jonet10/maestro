package j$.util;

import java.util.Iterator;
import java.util.Map;
import java.util.function.Consumer;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class m implements Iterator, z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6094a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Iterator f6095b;

    public m(n nVar) {
        this.f6095b = nVar.f6096a.iterator();
    }

    public m(t tVar) {
        this.f6095b = tVar.f6096a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        switch (this.f6094a) {
        }
        return this.f6095b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        switch (this.f6094a) {
            case 0:
                return this.f6095b.next();
            default:
                return new r((Map.Entry) this.f6095b.next());
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        switch (this.f6094a) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Iterator, j$.util.z
    public final void forEachRemaining(Consumer consumer) {
        switch (this.f6094a) {
            case 0:
                c.r(this.f6095b, consumer);
                break;
            default:
                c.r(this.f6095b, new q(0, consumer));
                break;
        }
    }
}
