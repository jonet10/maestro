package r6;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g extends q6.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8944a;

    /* renamed from: b, reason: collision with root package name */
    public final f f8945b;

    public /* synthetic */ g(f fVar, int i) {
        this.f8944a = i;
        this.f8945b = fVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean add(Object obj) {
        switch (this.f8944a) {
            case 0:
                ((Map.Entry) obj).getClass();
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean addAll(Collection collection) {
        int i = this.f8944a;
        collection.getClass();
        switch (i) {
            case 0:
                throw new UnsupportedOperationException();
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // q6.g
    public final int c() {
        switch (this.f8944a) {
        }
        return this.f8945b.f8940r;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f8944a) {
            case 0:
                this.f8945b.clear();
                break;
            default:
                this.f8945b.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        switch (this.f8944a) {
            case 0:
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                f fVar = this.f8945b;
                fVar.getClass();
                int h = fVar.h(entry.getKey());
                if (h < 0) {
                    return false;
                }
                Object[] objArr = fVar.f8933b;
                objArr.getClass();
                return l.a(objArr[h], entry.getValue());
            default:
                return this.f8945b.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean containsAll(Collection collection) {
        switch (this.f8944a) {
            case 0:
                collection.getClass();
                return this.f8945b.f(collection);
            default:
                return super.containsAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.f8944a) {
        }
        return this.f8945b.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f8944a) {
            case 0:
                f fVar = this.f8945b;
                fVar.getClass();
                return new d(fVar, 0);
            default:
                f fVar2 = this.f8945b;
                fVar2.getClass();
                return new d(fVar2, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        switch (this.f8944a) {
            case 0:
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    f fVar = this.f8945b;
                    fVar.getClass();
                    fVar.d();
                    int h = fVar.h(entry.getKey());
                    if (h >= 0) {
                        Object[] objArr = fVar.f8933b;
                        objArr.getClass();
                        if (l.a(objArr[h], entry.getValue())) {
                            fVar.l(h);
                            break;
                        }
                    }
                }
                break;
            default:
                f fVar2 = this.f8945b;
                fVar2.d();
                int h6 = fVar2.h(obj);
                if (h6 >= 0) {
                    fVar2.l(h6);
                    break;
                }
                break;
        }
        return true;
    }

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean removeAll(Collection collection) {
        int i = this.f8944a;
        collection.getClass();
        switch (i) {
            case 0:
                this.f8945b.d();
                break;
            default:
                this.f8945b.d();
                break;
        }
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean retainAll(Collection collection) {
        int i = this.f8944a;
        collection.getClass();
        switch (i) {
            case 0:
                this.f8945b.d();
                break;
            default:
                this.f8945b.d();
                break;
        }
        return super.retainAll(collection);
    }
}
