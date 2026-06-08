package j$.util.stream;

import j$.util.Collection;
import j$.util.Spliterator;
import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class l2 implements h2 {

    /* renamed from: a, reason: collision with root package name */
    public final Collection f6274a;

    @Override // j$.util.stream.h2
    public final /* synthetic */ h2 j(long j, long j6, IntFunction intFunction) {
        return w3.w(this, j, j6, intFunction);
    }

    @Override // j$.util.stream.h2
    public final /* synthetic */ int o() {
        return 0;
    }

    @Override // j$.util.stream.h2
    public final h2 a(int i) {
        throw new IndexOutOfBoundsException();
    }

    public l2(Collection collection) {
        this.f6274a = collection;
    }

    @Override // j$.util.stream.h2
    public final Spliterator spliterator() {
        return Collection.EL.stream(this.f6274a).spliterator();
    }

    @Override // j$.util.stream.h2
    public final void k(Object[] objArr, int i) {
        Iterator it = this.f6274a.iterator();
        while (it.hasNext()) {
            objArr[i] = it.next();
            i++;
        }
    }

    @Override // j$.util.stream.h2
    public final Object[] m(IntFunction intFunction) {
        java.util.Collection collection = this.f6274a;
        return collection.toArray((Object[]) intFunction.apply(collection.size()));
    }

    @Override // j$.util.stream.h2
    public final long count() {
        return this.f6274a.size();
    }

    @Override // j$.util.stream.h2
    public final void forEach(Consumer consumer) {
        Collection.EL.a(this.f6274a, consumer);
    }

    public final String toString() {
        return String.format("CollectionNode[%d][%s]", Integer.valueOf(this.f6274a.size()), this.f6274a);
    }
}
