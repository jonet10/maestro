package j$.util;

import java.io.Serializable;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class u implements java.util.Map, Serializable, Map {
    private static final long serialVersionUID = -1034234728574286014L;

    /* renamed from: a, reason: collision with root package name */
    public final java.util.Map f6466a;

    /* renamed from: b, reason: collision with root package name */
    public transient Set f6467b;

    /* renamed from: c, reason: collision with root package name */
    public transient t f6468c;

    /* renamed from: d, reason: collision with root package name */
    public transient n f6469d;

    public u(java.util.Map map) {
        map.getClass();
        this.f6466a = map;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f6466a.size();
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f6466a.isEmpty();
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return this.f6466a.containsKey(obj);
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return this.f6466a.containsValue(obj);
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        return this.f6466a.get(obj);
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(java.util.Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Set keySet() {
        if (this.f6467b == null) {
            this.f6467b = DesugarCollections.unmodifiableSet(this.f6466a.keySet());
        }
        return this.f6467b;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        if (this.f6468c == null) {
            this.f6468c = new t(this.f6466a.entrySet());
        }
        return this.f6468c;
    }

    @Override // java.util.Map
    public final java.util.Collection values() {
        if (this.f6469d == null) {
            this.f6469d = new n(this.f6466a.values());
        }
        return this.f6469d;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        return obj == this || this.f6466a.equals(obj);
    }

    @Override // java.util.Map
    public final int hashCode() {
        return this.f6466a.hashCode();
    }

    public final String toString() {
        return this.f6466a.toString();
    }

    @Override // java.util.Map, j$.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        return c.s(this.f6466a, obj, obj2);
    }

    @Override // java.util.Map, j$.util.Map
    public final void forEach(BiConsumer biConsumer) {
        c.q(this.f6466a, biConsumer);
    }

    @Override // java.util.Map, j$.util.Map
    public final void replaceAll(BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public final Object putIfAbsent(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public final Object replace(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public final Object computeIfAbsent(Object obj, Function function) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public final Object computeIfPresent(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public final Object compute(Object obj, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, j$.util.Map
    public final Object merge(Object obj, Object obj2, BiFunction biFunction) {
        throw new UnsupportedOperationException();
    }
}
