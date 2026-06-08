package j$.util;

import j$.util.Map;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class j implements java.util.Map, Serializable, Map {
    private static final long serialVersionUID = 1978198479659022715L;

    /* renamed from: a, reason: collision with root package name */
    public final java.util.Map f6074a;

    /* renamed from: b, reason: collision with root package name */
    public final j f6075b = this;

    /* renamed from: c, reason: collision with root package name */
    public transient l f6076c;

    /* renamed from: d, reason: collision with root package name */
    public transient l f6077d;

    /* renamed from: e, reason: collision with root package name */
    public transient h f6078e;

    public j(java.util.Map map) {
        this.f6074a = (java.util.Map) Objects.requireNonNull(map);
    }

    @Override // java.util.Map
    public final int size() {
        int size;
        synchronized (this.f6075b) {
            size = this.f6074a.size();
        }
        return size;
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        boolean isEmpty;
        synchronized (this.f6075b) {
            isEmpty = this.f6074a.isEmpty();
        }
        return isEmpty;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        boolean containsKey;
        synchronized (this.f6075b) {
            containsKey = this.f6074a.containsKey(obj);
        }
        return containsKey;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        boolean containsValue;
        synchronized (this.f6075b) {
            containsValue = this.f6074a.containsValue(obj);
        }
        return containsValue;
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        Object obj2;
        synchronized (this.f6075b) {
            obj2 = this.f6074a.get(obj);
        }
        return obj2;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        Object put;
        synchronized (this.f6075b) {
            put = this.f6074a.put(obj, obj2);
        }
        return put;
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        Object remove;
        synchronized (this.f6075b) {
            remove = this.f6074a.remove(obj);
        }
        return remove;
    }

    @Override // java.util.Map
    public final void putAll(java.util.Map map) {
        synchronized (this.f6075b) {
            this.f6074a.putAll(map);
        }
    }

    @Override // java.util.Map
    public final void clear() {
        synchronized (this.f6075b) {
            this.f6074a.clear();
        }
    }

    @Override // java.util.Map
    public final Set keySet() {
        l lVar;
        synchronized (this.f6075b) {
            try {
                if (this.f6076c == null) {
                    this.f6076c = new l(this.f6074a.keySet(), this.f6075b);
                }
                lVar = this.f6076c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        l lVar;
        synchronized (this.f6075b) {
            try {
                if (this.f6077d == null) {
                    this.f6077d = new l(this.f6074a.entrySet(), this.f6075b);
                }
                lVar = this.f6077d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return lVar;
    }

    @Override // java.util.Map
    public final java.util.Collection values() {
        h hVar;
        synchronized (this.f6075b) {
            try {
                if (this.f6078e == null) {
                    this.f6078e = new h(this.f6074a.values(), this.f6075b);
                }
                hVar = this.f6078e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return hVar;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        boolean equals;
        if (this == obj) {
            return true;
        }
        synchronized (this.f6075b) {
            equals = this.f6074a.equals(obj);
        }
        return equals;
    }

    @Override // java.util.Map
    public final int hashCode() {
        int hashCode;
        synchronized (this.f6075b) {
            hashCode = this.f6074a.hashCode();
        }
        return hashCode;
    }

    public final String toString() {
        String obj;
        synchronized (this.f6075b) {
            obj = this.f6074a.toString();
        }
        return obj;
    }

    @Override // java.util.Map, j$.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object s6;
        synchronized (this.f6075b) {
            s6 = c.s(this.f6074a, obj, obj2);
        }
        return s6;
    }

    @Override // java.util.Map, j$.util.Map
    public final void forEach(BiConsumer biConsumer) {
        synchronized (this.f6075b) {
            c.q(this.f6074a, biConsumer);
        }
    }

    @Override // java.util.Map, j$.util.Map
    public final void replaceAll(BiFunction biFunction) {
        synchronized (this.f6075b) {
            java.util.Map map = this.f6074a;
            if (map instanceof Map) {
                ((Map) map).replaceAll(biFunction);
            } else if (map instanceof ConcurrentMap) {
                ConcurrentMap concurrentMap = (ConcurrentMap) map;
                Objects.requireNonNull(biFunction);
                j$.util.concurrent.t tVar = new j$.util.concurrent.t(0, concurrentMap, biFunction);
                if (concurrentMap instanceof ConcurrentHashMap) {
                    ((ConcurrentHashMap) concurrentMap).forEach(tVar);
                } else {
                    j$.com.android.tools.r8.a.j(concurrentMap, tVar);
                }
            } else {
                Map.CC.$default$replaceAll(map, biFunction);
            }
        }
    }

    @Override // java.util.Map, j$.util.Map
    public final Object putIfAbsent(Object obj, Object obj2) {
        Object t9;
        synchronized (this.f6075b) {
            t9 = c.t(this.f6074a, obj, obj2);
        }
        return t9;
    }

    @Override // java.util.Map, j$.util.Map
    public final boolean remove(Object obj, Object obj2) {
        boolean remove;
        synchronized (this.f6075b) {
            java.util.Map map = this.f6074a;
            remove = map instanceof Map ? ((Map) map).remove(obj, obj2) : Map.CC.$default$remove(map, obj, obj2);
        }
        return remove;
    }

    @Override // java.util.Map, j$.util.Map
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        boolean replace;
        synchronized (this.f6075b) {
            java.util.Map map = this.f6074a;
            replace = map instanceof Map ? ((Map) map).replace(obj, obj2, obj3) : Map.CC.$default$replace(map, obj, obj2, obj3);
        }
        return replace;
    }

    @Override // java.util.Map, j$.util.Map
    public final Object replace(Object obj, Object obj2) {
        Object replace;
        synchronized (this.f6075b) {
            java.util.Map map = this.f6074a;
            replace = map instanceof Map ? ((Map) map).replace(obj, obj2) : Map.CC.$default$replace(map, obj, obj2);
        }
        return replace;
    }

    @Override // java.util.Map, j$.util.Map
    public final Object computeIfAbsent(Object obj, Function function) {
        Object $default$computeIfAbsent;
        Object apply;
        synchronized (this.f6075b) {
            java.util.Map map = this.f6074a;
            if (map instanceof Map) {
                $default$computeIfAbsent = ((Map) map).computeIfAbsent(obj, function);
            } else if (map instanceof ConcurrentMap) {
                ConcurrentMap concurrentMap = (ConcurrentMap) map;
                Objects.requireNonNull(function);
                Object obj2 = concurrentMap.get(obj);
                if (obj2 != null || (apply = function.apply(obj)) == null) {
                    $default$computeIfAbsent = obj2;
                } else {
                    $default$computeIfAbsent = concurrentMap.putIfAbsent(obj, apply);
                    if ($default$computeIfAbsent == null) {
                        $default$computeIfAbsent = apply;
                    }
                }
            } else {
                $default$computeIfAbsent = Map.CC.$default$computeIfAbsent(map, obj, function);
            }
        }
        return $default$computeIfAbsent;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0032, code lost:
    
        r5 = r3;
     */
    @Override // java.util.Map, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object computeIfPresent(java.lang.Object r5, java.util.function.BiFunction r6) {
        /*
            r4 = this;
            j$.util.j r0 = r4.f6075b
            monitor-enter(r0)
            java.util.Map r1 = r4.f6074a     // Catch: java.lang.Throwable -> L3c
            boolean r2 = r1 instanceof j$.util.Map     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto L10
            j$.util.Map r1 = (j$.util.Map) r1     // Catch: java.lang.Throwable -> L3c
            java.lang.Object r5 = r1.computeIfPresent(r5, r6)     // Catch: java.lang.Throwable -> L3c
            goto L3a
        L10:
            boolean r2 = r1 instanceof java.util.concurrent.ConcurrentMap     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto L36
            java.util.concurrent.ConcurrentMap r1 = (java.util.concurrent.ConcurrentMap) r1     // Catch: java.lang.Throwable -> L3c
            j$.util.Objects.requireNonNull(r6)     // Catch: java.lang.Throwable -> L3c
        L19:
            java.lang.Object r2 = r1.get(r5)     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto L34
            java.lang.Object r3 = r6.apply(r5, r2)     // Catch: java.lang.Throwable -> L3c
            if (r3 != 0) goto L2c
            boolean r2 = r1.remove(r5, r2)     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto L19
            goto L32
        L2c:
            boolean r2 = r1.replace(r5, r2, r3)     // Catch: java.lang.Throwable -> L3c
            if (r2 == 0) goto L19
        L32:
            r5 = r3
            goto L3a
        L34:
            r5 = 0
            goto L3a
        L36:
            java.lang.Object r5 = j$.util.Map.CC.$default$computeIfPresent(r1, r5, r6)     // Catch: java.lang.Throwable -> L3c
        L3a:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3c
            return r5
        L3c:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L3c
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.j.computeIfPresent(java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x002f, code lost:
    
        r5 = r3;
     */
    @Override // java.util.Map, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object compute(java.lang.Object r5, java.util.function.BiFunction r6) {
        /*
            r4 = this;
            j$.util.j r0 = r4.f6075b
            monitor-enter(r0)
            java.util.Map r1 = r4.f6074a     // Catch: java.lang.Throwable -> L41
            boolean r2 = r1 instanceof j$.util.Map     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L10
            j$.util.Map r1 = (j$.util.Map) r1     // Catch: java.lang.Throwable -> L41
            java.lang.Object r5 = r1.compute(r5, r6)     // Catch: java.lang.Throwable -> L41
            goto L3f
        L10:
            boolean r2 = r1 instanceof java.util.concurrent.ConcurrentMap     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L3b
            java.util.concurrent.ConcurrentMap r1 = (java.util.concurrent.ConcurrentMap) r1     // Catch: java.lang.Throwable -> L41
        L16:
            java.lang.Object r2 = r1.get(r5)     // Catch: java.lang.Throwable -> L41
        L1a:
            java.lang.Object r3 = r6.apply(r5, r2)     // Catch: java.lang.Throwable -> L41
            if (r3 == 0) goto L31
            if (r2 == 0) goto L29
            boolean r2 = r1.replace(r5, r2, r3)     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L16
            goto L2f
        L29:
            java.lang.Object r2 = r1.putIfAbsent(r5, r3)     // Catch: java.lang.Throwable -> L41
            if (r2 != 0) goto L1a
        L2f:
            r5 = r3
            goto L3f
        L31:
            if (r2 == 0) goto L39
            boolean r2 = r1.remove(r5, r2)     // Catch: java.lang.Throwable -> L41
            if (r2 == 0) goto L16
        L39:
            r5 = 0
            goto L3f
        L3b:
            java.lang.Object r5 = j$.util.Map.CC.$default$compute(r1, r5, r6)     // Catch: java.lang.Throwable -> L41
        L3f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L41
            return r5
        L41:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L41
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.j.compute(java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x0022, code lost:
    
        r3 = r7.apply(r2, r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0026, code lost:
    
        if (r3 == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0034, code lost:
    
        if (r1.remove(r5, r2) == false) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0036, code lost:
    
        r6 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x002c, code lost:
    
        if (r1.replace(r5, r2, r3) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x002e, code lost:
    
        r6 = r3;
     */
    @Override // java.util.Map, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object merge(java.lang.Object r5, java.lang.Object r6, java.util.function.BiFunction r7) {
        /*
            r4 = this;
            j$.util.j r0 = r4.f6075b
            monitor-enter(r0)
            java.util.Map r1 = r4.f6074a     // Catch: java.lang.Throwable -> L45
            boolean r2 = r1 instanceof j$.util.Map     // Catch: java.lang.Throwable -> L45
            if (r2 == 0) goto L10
            j$.util.Map r1 = (j$.util.Map) r1     // Catch: java.lang.Throwable -> L45
            java.lang.Object r6 = r1.merge(r5, r6, r7)     // Catch: java.lang.Throwable -> L45
            goto L43
        L10:
            boolean r2 = r1 instanceof java.util.concurrent.ConcurrentMap     // Catch: java.lang.Throwable -> L45
            if (r2 == 0) goto L3f
            java.util.concurrent.ConcurrentMap r1 = (java.util.concurrent.ConcurrentMap) r1     // Catch: java.lang.Throwable -> L45
            j$.util.Objects.requireNonNull(r7)     // Catch: java.lang.Throwable -> L45
            j$.util.Objects.requireNonNull(r6)     // Catch: java.lang.Throwable -> L45
        L1c:
            java.lang.Object r2 = r1.get(r5)     // Catch: java.lang.Throwable -> L45
        L20:
            if (r2 == 0) goto L38
            java.lang.Object r3 = r7.apply(r2, r6)     // Catch: java.lang.Throwable -> L45
            if (r3 == 0) goto L30
            boolean r2 = r1.replace(r5, r2, r3)     // Catch: java.lang.Throwable -> L45
            if (r2 == 0) goto L1c
            r6 = r3
            goto L43
        L30:
            boolean r2 = r1.remove(r5, r2)     // Catch: java.lang.Throwable -> L45
            if (r2 == 0) goto L1c
            r6 = 0
            goto L43
        L38:
            java.lang.Object r2 = r1.putIfAbsent(r5, r6)     // Catch: java.lang.Throwable -> L45
            if (r2 != 0) goto L20
            goto L43
        L3f:
            java.lang.Object r6 = j$.util.Map.CC.$default$merge(r1, r5, r6, r7)     // Catch: java.lang.Throwable -> L45
        L43:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L45
            return r6
        L45:
            r5 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L45
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.j.merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        synchronized (this.f6075b) {
            objectOutputStream.defaultWriteObject();
        }
    }
}
