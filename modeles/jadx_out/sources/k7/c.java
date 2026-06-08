package k7;

import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c implements Iterator, e7.a {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f6987a;

    /* renamed from: b, reason: collision with root package name */
    public int f6988b = -1;

    /* renamed from: l, reason: collision with root package name */
    public Object f6989l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ d f6990m;

    public c(d dVar) {
        this.f6990m = dVar;
        this.f6987a = new l((d) dVar.f6992b);
    }

    public final void a() {
        Object next;
        do {
            Iterator it = this.f6987a;
            if (!it.hasNext()) {
                this.f6988b = 0;
                return;
            }
            next = it.next();
        } while (((Boolean) ((androidx.room.f) this.f6990m.f6993c).invoke(next)).booleanValue());
        this.f6989l = next;
        this.f6988b = 1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.f6988b == -1) {
            a();
        }
        return this.f6988b == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f6988b == -1) {
            a();
        }
        if (this.f6988b == 0) {
            com.google.gson.internal.a.l();
            return null;
        }
        Object obj = this.f6989l;
        this.f6989l = null;
        this.f6988b = -1;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
