package l1;

import b2.t1;
import j$.util.Map;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class f implements Map, Serializable, j$.util.Map {

    /* renamed from: a, reason: collision with root package name */
    public transient k f7057a;

    /* renamed from: b, reason: collision with root package name */
    public transient l f7058b;

    /* renamed from: l, reason: collision with root package name */
    public transient m f7059l;

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.CC.$default$compute(this, obj, biFunction);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.CC.$default$computeIfAbsent(this, obj, function);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.CC.$default$computeIfPresent(this, obj, biFunction);
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        m mVar = this.f7059l;
        if (mVar == null) {
            n nVar = (n) this;
            m mVar2 = new m(nVar.f7078n, 1, nVar.f7079o);
            this.f7059l = mVar2;
            mVar = mVar2;
        }
        return mVar.contains(obj);
    }

    @Override // java.util.Map
    public final Set entrySet() {
        k kVar = this.f7057a;
        if (kVar != null) {
            return kVar;
        }
        n nVar = (n) this;
        k kVar2 = new k(nVar, nVar.f7078n, nVar.f7079o);
        this.f7057a = kVar2;
        return kVar2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof java.util.Map)) {
            return false;
        }
        return ((g) entrySet()).equals(((java.util.Map) obj).entrySet());
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.CC.$default$forEach(this, biConsumer);
    }

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map, j$.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override // java.util.Map
    public final int hashCode() {
        k kVar = this.f7057a;
        if (kVar == null) {
            n nVar = (n) this;
            k kVar2 = new k(nVar, nVar.f7078n, nVar.f7079o);
            this.f7057a = kVar2;
            kVar = kVar2;
        }
        Iterator it = kVar.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return ((n) this).size() == 0;
    }

    @Override // java.util.Map
    public final Set keySet() {
        l lVar = this.f7058b;
        if (lVar != null) {
            return lVar;
        }
        n nVar = (n) this;
        l lVar2 = new l(nVar, new m(nVar.f7078n, 0, nVar.f7079o));
        this.f7058b = lVar2;
        return lVar2;
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(java.util.Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.CC.$default$putIfAbsent(this, obj, obj2);
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ Object replace(Object obj, Object obj2) {
        return Map.CC.$default$replace(this, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.CC.$default$replaceAll(this, biFunction);
    }

    public final String toString() {
        int i = ((n) this).f7079o;
        t1.r(i, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(i * 8, 1073741824L));
        sb.append('{');
        q it = ((k) entrySet()).iterator();
        boolean z9 = true;
        while (true) {
            b bVar = (b) it;
            if (!bVar.hasNext()) {
                sb.append('}');
                return sb.toString();
            }
            Map.Entry entry = (Map.Entry) bVar.next();
            if (!z9) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z9 = false;
        }
    }

    @Override // java.util.Map
    public final Collection values() {
        m mVar = this.f7059l;
        if (mVar != null) {
            return mVar;
        }
        n nVar = (n) this;
        m mVar2 = new m(nVar.f7078n, 1, nVar.f7079o);
        this.f7059l = mVar2;
        return mVar2;
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.CC.$default$replace(this, obj, obj2, obj3);
    }

    @Override // java.util.Map, j$.util.Map
    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.CC.$default$remove(this, obj, obj2);
    }
}
