package q6;

import java.util.ListIterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends kotlin.jvm.internal.b implements ListIterator {

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ e f8713m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(e eVar, int i) {
        super(eVar, 5);
        this.f8713m = eVar;
        b bVar = e.Companion;
        int size = eVar.size();
        bVar.getClass();
        b.c(i, size);
        this.f7014b = i;
    }

    @Override // java.util.ListIterator
    public final void add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.f7014b > 0;
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.f7014b;
    }

    @Override // java.util.ListIterator
    public final Object previous() {
        if (!hasPrevious()) {
            com.google.gson.internal.a.l();
            return null;
        }
        int i = this.f7014b - 1;
        this.f7014b = i;
        return this.f8713m.get(i);
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.f7014b - 1;
    }

    @Override // java.util.ListIterator
    public final void set(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
