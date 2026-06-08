package j$.util.concurrent;

import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import j$.util.Map;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class ConcurrentHashMap<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable, Map {
    public static final int g = Runtime.getRuntime().availableProcessors();
    public static final j$.sun.misc.a h;
    public static final long i;
    public static final long j;

    /* renamed from: k, reason: collision with root package name */
    public static final long f5979k;

    /* renamed from: l, reason: collision with root package name */
    public static final long f5980l;

    /* renamed from: m, reason: collision with root package name */
    public static final long f5981m;

    /* renamed from: n, reason: collision with root package name */
    public static final int f5982n;

    /* renamed from: o, reason: collision with root package name */
    public static final int f5983o;
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 7249069246763182397L;

    /* renamed from: a, reason: collision with root package name */
    public volatile transient l[] f5984a;

    /* renamed from: b, reason: collision with root package name */
    public volatile transient l[] f5985b;
    private volatile transient long baseCount;

    /* renamed from: c, reason: collision with root package name */
    public volatile transient c[] f5986c;
    private volatile transient int cellsBusy;

    /* renamed from: d, reason: collision with root package name */
    public transient i f5987d;

    /* renamed from: e, reason: collision with root package name */
    public transient s f5988e;
    public transient e f;
    private volatile transient int sizeCtl;
    private volatile transient int transferIndex;

    public static final int i(int i6) {
        return (i6 ^ (i6 >>> 16)) & Integer.MAX_VALUE;
    }

    static {
        Class cls = Integer.TYPE;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("segments", n[].class), new ObjectStreamField("segmentMask", cls), new ObjectStreamField("segmentShift", cls)};
        j$.sun.misc.a aVar = j$.sun.misc.a.f5726b;
        h = aVar;
        i = aVar.h(ConcurrentHashMap.class, "sizeCtl");
        j = aVar.h(ConcurrentHashMap.class, "transferIndex");
        f5979k = aVar.h(ConcurrentHashMap.class, "baseCount");
        f5980l = aVar.h(ConcurrentHashMap.class, "cellsBusy");
        f5981m = aVar.h(c.class, "value");
        f5982n = aVar.a(l[].class);
        int b7 = aVar.b(l[].class);
        if (((b7 - 1) & b7) != 0) {
            throw new ExceptionInInitializerError("array index scale not a power of two");
        }
        f5983o = 31 - Integer.numberOfLeadingZeros(b7);
    }

    public static final int l(int i6) {
        int numberOfLeadingZeros = (-1) >>> Integer.numberOfLeadingZeros(i6 - 1);
        if (numberOfLeadingZeros < 0) {
            return 1;
        }
        return numberOfLeadingZeros >= 1073741824 ? BasicMeasure.EXACTLY : numberOfLeadingZeros + 1;
    }

    public static Class c(Object obj) {
        Type[] actualTypeArguments;
        if (!(obj instanceof Comparable)) {
            return null;
        }
        Class<?> cls = obj.getClass();
        if (cls != String.class) {
            Type[] genericInterfaces = cls.getGenericInterfaces();
            if (genericInterfaces == null) {
                return null;
            }
            for (Type type : genericInterfaces) {
                if (type instanceof ParameterizedType) {
                    ParameterizedType parameterizedType = (ParameterizedType) type;
                    if (parameterizedType.getRawType() == Comparable.class && (actualTypeArguments = parameterizedType.getActualTypeArguments()) != null && actualTypeArguments.length == 1 && actualTypeArguments[0] == cls) {
                    }
                }
            }
            return null;
        }
        return cls;
    }

    public static final l k(l[] lVarArr, int i6) {
        return (l) h.f(lVarArr, (i6 << f5983o) + f5982n);
    }

    public static final boolean b(l[] lVarArr, int i6, l lVar) {
        return j$.com.android.tools.r8.a.z(h.f5727a, lVarArr, (i6 << f5983o) + f5982n, lVar);
    }

    public static final void h(l[] lVarArr, int i6, l lVar) {
        h.j(lVarArr, (i6 << f5983o) + f5982n, lVar);
    }

    public ConcurrentHashMap() {
    }

    public ConcurrentHashMap(int i6) {
        this(i6, 0.75f, 1);
    }

    public ConcurrentHashMap(int i6, float f, int i10) {
        if (f <= 0.0f || i6 < 0 || i10 <= 0) {
            throw new IllegalArgumentException();
        }
        long j6 = (long) (((i6 < i10 ? i10 : i6) / f) + 1.0d);
        this.sizeCtl = j6 >= 1073741824 ? BasicMeasure.EXACTLY : l((int) j6);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        long j6 = j();
        if (j6 < 0) {
            return 0;
        }
        if (j6 > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j6;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return j() <= 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x004c, code lost:
    
        return (V) r1.f6002c;
     */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public V get(java.lang.Object r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            int r0 = i(r0)
            j$.util.concurrent.l[] r1 = r3.f5984a
            if (r1 == 0) goto L4d
            int r2 = r1.length
            if (r2 <= 0) goto L4d
            int r2 = r2 + (-1)
            r2 = r2 & r0
            j$.util.concurrent.l r1 = k(r1, r2)
            if (r1 == 0) goto L4d
            int r2 = r1.f6000a
            if (r2 != r0) goto L2b
            java.lang.Object r2 = r1.f6001b
            if (r2 == r4) goto L28
            if (r2 == 0) goto L36
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L36
        L28:
            java.lang.Object r4 = r1.f6002c
            return r4
        L2b:
            if (r2 >= 0) goto L36
            j$.util.concurrent.l r4 = r1.a(r0, r4)
            if (r4 == 0) goto L4d
            java.lang.Object r4 = r4.f6002c
            return r4
        L36:
            j$.util.concurrent.l r1 = r1.f6003d
            if (r1 == 0) goto L4d
            int r2 = r1.f6000a
            if (r2 != r0) goto L36
            java.lang.Object r2 = r1.f6001b
            if (r2 == r4) goto L4a
            if (r2 == 0) goto L36
            boolean r2 = r4.equals(r2)
            if (r2 == 0) goto L36
        L4a:
            java.lang.Object r4 = r1.f6002c
            return r4
        L4d:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        obj.getClass();
        l[] lVarArr = this.f5984a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a8 = pVar.a();
                if (a8 == null) {
                    break;
                }
                Object obj2 = a8.f6002c;
                if (obj2 == obj) {
                    return true;
                }
                if (obj2 != null && obj.equals(obj2)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V put(K k5, V v) {
        return (V) f(k5, v, false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x00b4, code lost:
    
        a(1, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00b9, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x00a5, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object f(java.lang.Object r9, java.lang.Object r10, boolean r11) {
        /*
            Method dump skipped, instructions count: 195
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.f(java.lang.Object, java.lang.Object, boolean):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(java.util.Map<? extends K, ? extends V> map) {
        o(map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            f(entry.getKey(), entry.getValue(), false);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        return (V) g(obj, null, null);
    }

    public final Object g(Object obj, Object obj2, Object obj3) {
        int length;
        int i6;
        l k5;
        boolean z9;
        Object obj4;
        r b7;
        Object obj5;
        int i10 = i(obj.hashCode());
        l[] lVarArr = this.f5984a;
        while (true) {
            if (lVarArr == null || (length = lVarArr.length) == 0 || (k5 = k(lVarArr, (i6 = (length - 1) & i10))) == null) {
                break;
            }
            int i11 = k5.f6000a;
            if (i11 == -1) {
                lVarArr = d(lVarArr, k5);
            } else {
                synchronized (k5) {
                    try {
                        if (k(lVarArr, i6) == k5) {
                            z9 = true;
                            if (i11 >= 0) {
                                l lVar = null;
                                l lVar2 = k5;
                                while (true) {
                                    if (lVar2.f6000a == i10 && ((obj5 = lVar2.f6001b) == obj || (obj5 != null && obj.equals(obj5)))) {
                                        break;
                                    }
                                    l lVar3 = lVar2.f6003d;
                                    if (lVar3 == null) {
                                        break;
                                    }
                                    lVar = lVar2;
                                    lVar2 = lVar3;
                                }
                                obj4 = lVar2.f6002c;
                                if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                    if (obj2 != null) {
                                        lVar2.f6002c = obj2;
                                    } else {
                                        l lVar4 = lVar2.f6003d;
                                        if (lVar != null) {
                                            lVar.f6003d = lVar4;
                                        } else {
                                            h(lVarArr, i6, lVar4);
                                        }
                                    }
                                }
                                obj4 = null;
                            } else if (k5 instanceof q) {
                                q qVar = (q) k5;
                                r rVar = qVar.f6013e;
                                if (rVar != null && (b7 = rVar.b(i10, obj, null)) != null) {
                                    obj4 = b7.f6002c;
                                    if (obj3 == null || obj3 == obj4 || (obj4 != null && obj3.equals(obj4))) {
                                        if (obj2 != null) {
                                            b7.f6002c = obj2;
                                        } else if (qVar.f(b7)) {
                                            h(lVarArr, i6, p(qVar.f));
                                        }
                                    }
                                }
                                obj4 = null;
                            } else if (k5 instanceof m) {
                                throw new IllegalStateException("Recursive update");
                            }
                        }
                        z9 = false;
                        obj4 = null;
                    } catch (Throwable th) {
                        throw th;
                    }
                }
                if (z9) {
                    if (obj4 != null) {
                        if (obj2 == null) {
                            a(-1L, -1);
                        }
                        return obj4;
                    }
                }
            }
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        l k5;
        l lVar;
        l[] lVarArr = this.f5984a;
        long j6 = 0;
        loop0: while (true) {
            int i6 = 0;
            while (lVarArr != null && i6 < lVarArr.length) {
                k5 = k(lVarArr, i6);
                if (k5 == null) {
                    i6++;
                } else {
                    int i10 = k5.f6000a;
                    if (i10 == -1) {
                        break;
                    }
                    synchronized (k5) {
                        try {
                            if (k(lVarArr, i6) == k5) {
                                if (i10 >= 0) {
                                    lVar = k5;
                                } else {
                                    lVar = k5 instanceof q ? ((q) k5).f : null;
                                }
                                while (lVar != null) {
                                    j6--;
                                    lVar = lVar.f6003d;
                                }
                                h(lVarArr, i6, null);
                                i6++;
                            }
                        } finally {
                        }
                    }
                }
            }
            lVarArr = d(lVarArr, k5);
        }
        if (j6 != 0) {
            a(j6, -1);
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set<K> keySet() {
        i iVar = this.f5987d;
        if (iVar != null) {
            return iVar;
        }
        i iVar2 = new i(this);
        this.f5987d = iVar2;
        return iVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection<V> values() {
        s sVar = this.f5988e;
        if (sVar != null) {
            return sVar;
        }
        s sVar2 = new s(this);
        this.f5988e = sVar2;
        return sVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        e eVar = this.f;
        if (eVar != null) {
            return eVar;
        }
        e eVar2 = new e(this);
        this.f = eVar2;
        return eVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        l[] lVarArr = this.f5984a;
        int i6 = 0;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a8 = pVar.a();
                if (a8 == null) {
                    break;
                }
                i6 += a8.f6002c.hashCode() ^ a8.f6001b.hashCode();
            }
        }
        return i6;
    }

    @Override // java.util.AbstractMap
    public final String toString() {
        l[] lVarArr = this.f5984a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        StringBuilder sb = new StringBuilder("{");
        l a8 = pVar.a();
        if (a8 != null) {
            while (true) {
                Object obj = a8.f6001b;
                Object obj2 = a8.f6002c;
                if (obj == this) {
                    obj = "(this Map)";
                }
                sb.append(obj);
                sb.append('=');
                if (obj2 == this) {
                    obj2 = "(this Map)";
                }
                sb.append(obj2);
                a8 = pVar.a();
                if (a8 == null) {
                    break;
                }
                sb.append(", ");
            }
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        V value;
        V v;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof java.util.Map)) {
            return false;
        }
        java.util.Map map = (java.util.Map) obj;
        l[] lVarArr = this.f5984a;
        int length = lVarArr == null ? 0 : lVarArr.length;
        p pVar = new p(lVarArr, length, 0, length);
        while (true) {
            l a8 = pVar.a();
            if (a8 != null) {
                Object obj2 = a8.f6002c;
                Object obj3 = map.get(a8.f6001b);
                if (obj3 == null || (obj3 != obj2 && !obj3.equals(obj2))) {
                    break;
                }
            } else {
                for (Map.Entry<K, V> entry : map.entrySet()) {
                    K key = entry.getKey();
                    if (key == null || (value = entry.getValue()) == null || (v = get(key)) == null || (value != v && !value.equals(v))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        int i6 = 0;
        int i10 = 1;
        while (i10 < 16) {
            i6++;
            i10 <<= 1;
        }
        int i11 = 32 - i6;
        int i12 = i10 - 1;
        n[] nVarArr = new n[16];
        for (int i13 = 0; i13 < 16; i13++) {
            nVarArr[i13] = new n();
        }
        ObjectOutputStream.PutField putFields = objectOutputStream.putFields();
        putFields.put("segments", nVarArr);
        putFields.put("segmentShift", i11);
        putFields.put("segmentMask", i12);
        objectOutputStream.writeFields();
        l[] lVarArr = this.f5984a;
        if (lVarArr != null) {
            p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
            while (true) {
                l a8 = pVar.a();
                if (a8 == null) {
                    break;
                }
                objectOutputStream.writeObject(a8.f6001b);
                objectOutputStream.writeObject(a8.f6002c);
            }
        }
        objectOutputStream.writeObject(null);
        objectOutputStream.writeObject(null);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        long j6;
        long j10;
        Object obj;
        this.sizeCtl = -1;
        objectInputStream.defaultReadObject();
        long j11 = 0;
        long j12 = 0;
        l lVar = null;
        while (true) {
            Object readObject = objectInputStream.readObject();
            Object readObject2 = objectInputStream.readObject();
            j6 = 1;
            if (readObject == null || readObject2 == null) {
                break;
            }
            j12++;
            lVar = new l(i(readObject.hashCode()), readObject, readObject2, lVar);
        }
        if (j12 == 0) {
            this.sizeCtl = 0;
            return;
        }
        long j13 = (long) ((j12 / 0.75f) + 1.0d);
        int l10 = j13 >= 1073741824 ? BasicMeasure.EXACTLY : l((int) j13);
        l[] lVarArr = new l[l10];
        int i6 = l10 - 1;
        while (lVar != null) {
            l lVar2 = lVar.f6003d;
            int i10 = lVar.f6000a;
            int i11 = i10 & i6;
            l k5 = k(lVarArr, i11);
            boolean z9 = true;
            if (k5 == null) {
                j10 = j6;
            } else {
                Object obj2 = lVar.f6001b;
                if (k5.f6000a < 0) {
                    if (((q) k5).e(i10, obj2, lVar.f6002c) == null) {
                        j11 += j6;
                    }
                    j10 = j6;
                } else {
                    j10 = j6;
                    int i12 = 0;
                    for (l lVar3 = k5; lVar3 != null; lVar3 = lVar3.f6003d) {
                        if (lVar3.f6000a == i10 && ((obj = lVar3.f6001b) == obj2 || (obj != null && obj2.equals(obj)))) {
                            z9 = false;
                            break;
                        }
                        i12++;
                    }
                    if (z9 && i12 >= 8) {
                        j11 += j10;
                        lVar.f6003d = k5;
                        l lVar4 = lVar;
                        r rVar = null;
                        r rVar2 = null;
                        while (lVar4 != null) {
                            r rVar3 = new r(lVar4.f6000a, lVar4.f6001b, lVar4.f6002c, null, null);
                            rVar3.h = rVar2;
                            if (rVar2 == null) {
                                rVar = rVar3;
                            } else {
                                rVar2.f6003d = rVar3;
                            }
                            lVar4 = lVar4.f6003d;
                            rVar2 = rVar3;
                        }
                        h(lVarArr, i11, new q(rVar));
                    }
                }
                z9 = false;
            }
            if (z9) {
                j11 += j10;
                lVar.f6003d = k5;
                h(lVarArr, i11, lVar);
            }
            lVar = lVar2;
            j6 = j10;
        }
        this.f5984a = lVarArr;
        this.sizeCtl = l10 - (l10 >>> 2);
        this.baseCount = j11;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public V putIfAbsent(K k5, V v) {
        return (V) f(k5, v, true);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public boolean remove(Object obj, Object obj2) {
        obj.getClass();
        return (obj2 == null || g(obj, null, obj2) == null) ? false : true;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final boolean replace(Object obj, Object obj2, Object obj3) {
        if (obj == null || obj2 == null || obj3 == null) {
            throw null;
        }
        return g(obj, obj3, obj2) != null;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object replace(Object obj, Object obj2) {
        if (obj == null) {
            throw null;
        }
        if (obj2 == null) {
            throw null;
        }
        return g(obj, obj2, null);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        V v = get(obj);
        return v == null ? obj2 : v;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final void forEach(BiConsumer biConsumer) {
        biConsumer.getClass();
        l[] lVarArr = this.f5984a;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l a8 = pVar.a();
            if (a8 == null) {
                return;
            } else {
                biConsumer.accept(a8.f6001b, a8.f6002c);
            }
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    public final void replaceAll(BiFunction biFunction) {
        biFunction.getClass();
        l[] lVarArr = this.f5984a;
        if (lVarArr == null) {
            return;
        }
        p pVar = new p(lVarArr, lVarArr.length, 0, lVarArr.length);
        while (true) {
            l a8 = pVar.a();
            if (a8 == null) {
                return;
            }
            Object obj = a8.f6002c;
            Object obj2 = a8.f6001b;
            do {
                Object apply = biFunction.apply(obj2, obj);
                apply.getClass();
                if (g(obj2, apply, obj) == null) {
                    obj = get(obj2);
                }
            } while (obj != null);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f2, code lost:
    
        if (r5 == null) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00f4, code lost:
    
        a(1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f9, code lost:
    
        return r5;
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object computeIfAbsent(java.lang.Object r12, java.util.function.Function r13) {
        /*
            Method dump skipped, instructions count: 259
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.computeIfAbsent(java.lang.Object, java.util.function.Function):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00aa, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object computeIfPresent(java.lang.Object r14, java.util.function.BiFunction r15) {
        /*
            r13 = this;
            r0 = 0
            if (r14 == 0) goto Lbd
            if (r15 == 0) goto Lbd
            int r1 = r14.hashCode()
            int r1 = i(r1)
            j$.util.concurrent.l[] r2 = r13.f5984a
            r3 = 0
            r5 = r0
            r4 = r3
        L12:
            if (r2 == 0) goto Lb7
            int r6 = r2.length
            if (r6 != 0) goto L19
            goto Lb7
        L19:
            int r6 = r6 + (-1)
            r6 = r6 & r1
            j$.util.concurrent.l r7 = k(r2, r6)
            if (r7 != 0) goto L24
            goto Lae
        L24:
            int r8 = r7.f6000a
            r9 = -1
            if (r8 != r9) goto L2e
            j$.util.concurrent.l[] r2 = r13.d(r2, r7)
            goto L12
        L2e:
            monitor-enter(r7)
            j$.util.concurrent.l r10 = k(r2, r6)     // Catch: java.lang.Throwable -> L4b
            if (r10 != r7) goto Lab
            if (r8 < 0) goto L70
            r4 = 1
            r10 = r0
            r8 = r7
        L3a:
            int r11 = r8.f6000a     // Catch: java.lang.Throwable -> L4b
            if (r11 != r1) goto L65
            java.lang.Object r11 = r8.f6001b     // Catch: java.lang.Throwable -> L4b
            if (r11 == r14) goto L4e
            if (r11 == 0) goto L65
            boolean r11 = r14.equals(r11)     // Catch: java.lang.Throwable -> L4b
            if (r11 == 0) goto L65
            goto L4e
        L4b:
            r14 = move-exception
            goto Lb5
        L4e:
            java.lang.Object r5 = r8.f6002c     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r5 = r15.apply(r14, r5)     // Catch: java.lang.Throwable -> L4b
            if (r5 == 0) goto L59
            r8.f6002c = r5     // Catch: java.lang.Throwable -> L4b
            goto Lab
        L59:
            j$.util.concurrent.l r3 = r8.f6003d     // Catch: java.lang.Throwable -> L4b
            if (r10 == 0) goto L60
            r10.f6003d = r3     // Catch: java.lang.Throwable -> L4b
            goto L63
        L60:
            h(r2, r6, r3)     // Catch: java.lang.Throwable -> L4b
        L63:
            r3 = r9
            goto Lab
        L65:
            j$.util.concurrent.l r10 = r8.f6003d     // Catch: java.lang.Throwable -> L4b
            if (r10 != 0) goto L6a
            goto Lab
        L6a:
            int r4 = r4 + 1
            r12 = r10
            r10 = r8
            r8 = r12
            goto L3a
        L70:
            boolean r8 = r7 instanceof j$.util.concurrent.q     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L9e
            r4 = r7
            j$.util.concurrent.q r4 = (j$.util.concurrent.q) r4     // Catch: java.lang.Throwable -> L4b
            j$.util.concurrent.r r8 = r4.f6013e     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L9c
            j$.util.concurrent.r r8 = r8.b(r1, r14, r0)     // Catch: java.lang.Throwable -> L4b
            if (r8 == 0) goto L9c
            java.lang.Object r5 = r8.f6002c     // Catch: java.lang.Throwable -> L4b
            java.lang.Object r5 = r15.apply(r14, r5)     // Catch: java.lang.Throwable -> L4b
            if (r5 == 0) goto L8c
            r8.f6002c = r5     // Catch: java.lang.Throwable -> L4b
            goto L9c
        L8c:
            boolean r3 = r4.f(r8)     // Catch: java.lang.Throwable -> L4b
            if (r3 == 0) goto L9b
            j$.util.concurrent.r r3 = r4.f     // Catch: java.lang.Throwable -> L4b
            j$.util.concurrent.l r3 = p(r3)     // Catch: java.lang.Throwable -> L4b
            h(r2, r6, r3)     // Catch: java.lang.Throwable -> L4b
        L9b:
            r3 = r9
        L9c:
            r4 = 2
            goto Lab
        L9e:
            boolean r6 = r7 instanceof j$.util.concurrent.m     // Catch: java.lang.Throwable -> L4b
            if (r6 != 0) goto La3
            goto Lab
        La3:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L4b
            java.lang.String r15 = "Recursive update"
            r14.<init>(r15)     // Catch: java.lang.Throwable -> L4b
            throw r14     // Catch: java.lang.Throwable -> L4b
        Lab:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4b
            if (r4 == 0) goto L12
        Lae:
            if (r3 == 0) goto Lb4
            long r14 = (long) r3
            r13.a(r14, r4)
        Lb4:
            return r5
        Lb5:
            monitor-exit(r7)     // Catch: java.lang.Throwable -> L4b
            throw r14
        Lb7:
            j$.util.concurrent.l[] r2 = r13.e()
            goto L12
        Lbd:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.computeIfPresent(java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:89:0x010e, code lost:
    
        if (r4 == 0) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0110, code lost:
    
        a(r4, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0114, code lost:
    
        return r5;
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object compute(java.lang.Object r14, java.util.function.BiFunction r15) {
        /*
            Method dump skipped, instructions count: 286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.compute(java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:73:0x00dd, code lost:
    
        throw new java.lang.IllegalStateException("Recursive update");
     */
    @Override // java.util.Map, java.util.concurrent.ConcurrentMap, j$.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object merge(java.lang.Object r18, java.lang.Object r19, java.util.function.BiFunction r20) {
        /*
            Method dump skipped, instructions count: 250
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.merge(java.lang.Object, java.lang.Object, java.util.function.BiFunction):java.lang.Object");
    }

    public final l[] e() {
        while (true) {
            l[] lVarArr = this.f5984a;
            if (lVarArr != null && lVarArr.length != 0) {
                return lVarArr;
            }
            int i6 = this.sizeCtl;
            if (i6 < 0) {
                Thread.yield();
            } else if (h.c(this, i, i6, -1)) {
                try {
                    l[] lVarArr2 = this.f5984a;
                    if (lVarArr2 != null) {
                        if (lVarArr2.length == 0) {
                        }
                        this.sizeCtl = i6;
                        return lVarArr2;
                    }
                    int i10 = i6 > 0 ? i6 : 16;
                    l[] lVarArr3 = new l[i10];
                    this.f5984a = lVarArr3;
                    i6 = i10 - (i10 >>> 2);
                    lVarArr2 = lVarArr3;
                    this.sizeCtl = i6;
                    return lVarArr2;
                } catch (Throwable th) {
                    this.sizeCtl = i6;
                    throw th;
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:125:0x0140, code lost:
    
        if (r1.f5986c != r6) goto L150;
     */
    /* JADX WARN: Code restructure failed: missing block: B:126:0x0142, code lost:
    
        r1.f5986c = (j$.util.concurrent.c[]) java.util.Arrays.copyOf(r6, r7 << 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0017, code lost:
    
        if (r0.d(r1, r2, r4, r6) == false) goto L6;
     */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01ab A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:0x00c2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(long r25, int r27) {
        /*
            Method dump skipped, instructions count: 432
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.concurrent.ConcurrentHashMap.a(long, int):void");
    }

    public final l[] d(l[] lVarArr, l lVar) {
        int i6;
        if (lVar instanceof g) {
            l[] lVarArr2 = ((g) lVar).f5995e;
            int numberOfLeadingZeros = Integer.numberOfLeadingZeros(lVarArr.length) | 32768;
            while (lVarArr2 == this.f5985b && this.f5984a == lVarArr && (i6 = this.sizeCtl) < 0 && (i6 >>> 16) == numberOfLeadingZeros && i6 != numberOfLeadingZeros + 1 && i6 != 65535 + numberOfLeadingZeros && this.transferIndex > 0) {
                if (h.c(this, i, i6, i6 + 1)) {
                    m(lVarArr, lVarArr2);
                    break;
                }
            }
            return lVarArr2;
        }
        return this.f5984a;
    }

    public final void o(int i6) {
        int length;
        int l10 = i6 >= 536870912 ? 1073741824 : l(i6 + (i6 >>> 1) + 1);
        while (true) {
            int i10 = this.sizeCtl;
            if (i10 >= 0) {
                l[] lVarArr = this.f5984a;
                if (lVarArr != null && (length = lVarArr.length) != 0) {
                    if (l10 <= i10 || length >= 1073741824) {
                        break;
                    } else if (lVarArr == this.f5984a) {
                        if (h.c(this, i, i10, ((Integer.numberOfLeadingZeros(length) | 32768) << 16) + 2)) {
                            m(lVarArr, null);
                        }
                    }
                } else {
                    int i11 = i10 > l10 ? i10 : l10;
                    if (h.c(this, i, i10, -1)) {
                        try {
                            if (this.f5984a == lVarArr) {
                                this.f5984a = new l[i11];
                                i10 = i11 - (i11 >>> 2);
                            }
                        } finally {
                            this.sizeCtl = i10;
                        }
                    } else {
                        continue;
                    }
                }
            } else {
                break;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v11, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r10v9, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r5v5, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r8v10, types: [j$.util.concurrent.l] */
    /* JADX WARN: Type inference failed for: r8v15, types: [j$.util.concurrent.l] */
    public final void m(l[] lVarArr, l[] lVarArr2) {
        l[] lVarArr3;
        int i6;
        int i10;
        int i11;
        int i12;
        boolean z9;
        char c9;
        int i13;
        int i14;
        l qVar;
        l qVar2;
        r rVar;
        int i15;
        ConcurrentHashMap<K, V> concurrentHashMap = this;
        int length = lVarArr.length;
        int i16 = g;
        boolean z10 = true;
        int i17 = i16 > 1 ? (length >>> 3) / i16 : length;
        char c10 = 16;
        int i18 = i17 < 16 ? 16 : i17;
        if (lVarArr2 == null) {
            try {
                l[] lVarArr4 = new l[length << 1];
                concurrentHashMap.f5985b = lVarArr4;
                concurrentHashMap.transferIndex = length;
                lVarArr3 = lVarArr4;
            } catch (Throwable unused) {
                concurrentHashMap.sizeCtl = Integer.MAX_VALUE;
                return;
            }
        } else {
            lVarArr3 = lVarArr2;
        }
        int length2 = lVarArr3.length;
        g gVar = new g(lVarArr3);
        boolean z11 = true;
        int i19 = 0;
        int i20 = 0;
        boolean z12 = false;
        while (true) {
            if (z11) {
                int i21 = i19 - 1;
                if (i21 >= i20 || z12) {
                    i20 = i20;
                    i19 = i21;
                } else {
                    int i22 = concurrentHashMap.transferIndex;
                    if (i22 <= 0) {
                        i19 = -1;
                    } else {
                        j$.sun.misc.a aVar = h;
                        int i23 = i20;
                        long j6 = j;
                        if (i22 > i18) {
                            i10 = i23;
                            i11 = i22 - i18;
                            i6 = i21;
                        } else {
                            i6 = i21;
                            i10 = i23;
                            i11 = 0;
                        }
                        boolean c11 = aVar.c(concurrentHashMap, j6, i22, i11);
                        i20 = i11;
                        if (c11) {
                            i19 = i22 - 1;
                        } else {
                            i20 = i10;
                            i19 = i6;
                        }
                    }
                }
                z11 = false;
            } else {
                int i24 = i20;
                r rVar2 = null;
                if (i19 < 0 || i19 >= length || (i14 = i19 + length) >= length2) {
                    i12 = length;
                    z9 = z10;
                    c9 = c10;
                    i13 = i18;
                    if (z12) {
                        concurrentHashMap.f5985b = null;
                        concurrentHashMap.f5984a = lVarArr3;
                        concurrentHashMap.sizeCtl = (i12 << 1) - (i12 >>> 1);
                        return;
                    }
                    int i25 = i19;
                    j$.sun.misc.a aVar2 = h;
                    long j10 = i;
                    int i26 = concurrentHashMap.sizeCtl;
                    if (!aVar2.c(concurrentHashMap, j10, i26, i26 - 1)) {
                        i19 = i25;
                    } else {
                        if (i26 - 2 != ((Integer.numberOfLeadingZeros(i12) | 32768) << 16)) {
                            return;
                        }
                        z11 = z9;
                        z12 = z11;
                        i19 = i12;
                    }
                } else {
                    ?? k5 = k(lVarArr, i19);
                    if (k5 == 0) {
                        z11 = b(lVarArr, i19, gVar);
                        i12 = length;
                        z9 = z10;
                        c9 = c10;
                        i13 = i18;
                    } else {
                        z9 = z10;
                        int i27 = k5.f6000a;
                        if (i27 == -1) {
                            i12 = length;
                            c9 = c10;
                            i13 = i18;
                            z11 = z9;
                        } else {
                            synchronized (k5) {
                                try {
                                    if (k(lVarArr, i19) == k5) {
                                        if (i27 >= 0) {
                                            int i28 = i27 & length;
                                            r rVar3 = k5;
                                            for (r rVar4 = k5.f6003d; rVar4 != null; rVar4 = rVar4.f6003d) {
                                                char c12 = c10;
                                                int i29 = rVar4.f6000a & length;
                                                if (i29 != i28) {
                                                    rVar3 = rVar4;
                                                    i28 = i29;
                                                }
                                                c10 = c12;
                                            }
                                            c9 = c10;
                                            if (i28 == 0) {
                                                rVar = null;
                                                rVar2 = rVar3;
                                            } else {
                                                rVar = rVar3;
                                            }
                                            l lVar = k5;
                                            while (lVar != rVar3) {
                                                int i30 = lVar.f6000a;
                                                Object obj = lVar.f6001b;
                                                int i31 = length;
                                                Object obj2 = lVar.f6002c;
                                                if ((i30 & i31) == 0) {
                                                    i15 = i18;
                                                    rVar2 = new l(i30, obj, obj2, rVar2);
                                                } else {
                                                    i15 = i18;
                                                    rVar = new l(i30, obj, obj2, rVar);
                                                }
                                                lVar = lVar.f6003d;
                                                length = i31;
                                                i18 = i15;
                                            }
                                            i12 = length;
                                            i13 = i18;
                                            h(lVarArr3, i19, rVar2);
                                            h(lVarArr3, i14, rVar);
                                            h(lVarArr, i19, gVar);
                                        } else {
                                            i12 = length;
                                            c9 = c10;
                                            i13 = i18;
                                            if (k5 instanceof q) {
                                                q qVar3 = (q) k5;
                                                r rVar5 = null;
                                                r rVar6 = null;
                                                l lVar2 = qVar3.f;
                                                int i32 = 0;
                                                int i33 = 0;
                                                r rVar7 = null;
                                                while (lVar2 != null) {
                                                    q qVar4 = qVar3;
                                                    int i34 = lVar2.f6000a;
                                                    r rVar8 = new r(i34, lVar2.f6001b, lVar2.f6002c, null, null);
                                                    if ((i34 & i12) == 0) {
                                                        rVar8.h = rVar6;
                                                        if (rVar6 == null) {
                                                            rVar2 = rVar8;
                                                        } else {
                                                            rVar6.f6003d = rVar8;
                                                        }
                                                        i32++;
                                                        rVar6 = rVar8;
                                                    } else {
                                                        rVar8.h = rVar5;
                                                        if (rVar5 == null) {
                                                            rVar7 = rVar8;
                                                        } else {
                                                            rVar5.f6003d = rVar8;
                                                        }
                                                        i33++;
                                                        rVar5 = rVar8;
                                                    }
                                                    lVar2 = lVar2.f6003d;
                                                    qVar3 = qVar4;
                                                }
                                                q qVar5 = qVar3;
                                                if (i32 <= 6) {
                                                    qVar = p(rVar2);
                                                } else {
                                                    qVar = i33 != 0 ? new q(rVar2) : qVar5;
                                                }
                                                if (i33 <= 6) {
                                                    qVar2 = p(rVar7);
                                                } else {
                                                    qVar2 = i32 != 0 ? new q(rVar7) : qVar5;
                                                }
                                                h(lVarArr3, i19, qVar);
                                                h(lVarArr3, i14, qVar2);
                                                h(lVarArr, i19, gVar);
                                            }
                                        }
                                        z11 = z9;
                                    } else {
                                        i12 = length;
                                        c9 = c10;
                                        i13 = i18;
                                    }
                                } finally {
                                }
                            }
                        }
                    }
                }
                concurrentHashMap = this;
                i20 = i24;
                z10 = z9;
                c10 = c9;
                length = i12;
                i18 = i13;
            }
        }
    }

    public final long j() {
        c[] cVarArr = this.f5986c;
        long j6 = this.baseCount;
        if (cVarArr != null) {
            for (c cVar : cVarArr) {
                if (cVar != null) {
                    j6 += cVar.value;
                }
            }
        }
        return j6;
    }

    public final void n(l[] lVarArr, int i6) {
        int length = lVarArr.length;
        if (length < 64) {
            o(length << 1);
            return;
        }
        l k5 = k(lVarArr, i6);
        if (k5 == null || k5.f6000a < 0) {
            return;
        }
        synchronized (k5) {
            try {
                if (k(lVarArr, i6) == k5) {
                    r rVar = null;
                    r rVar2 = null;
                    l lVar = k5;
                    while (lVar != null) {
                        r rVar3 = new r(lVar.f6000a, lVar.f6001b, lVar.f6002c, null, null);
                        rVar3.h = rVar2;
                        if (rVar2 == null) {
                            rVar = rVar3;
                        } else {
                            rVar2.f6003d = rVar3;
                        }
                        lVar = lVar.f6003d;
                        rVar2 = rVar3;
                    }
                    h(lVarArr, i6, new q(rVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v2, types: [j$.util.concurrent.l] */
    public static l p(r rVar) {
        l lVar = null;
        l lVar2 = null;
        for (r rVar2 = rVar; rVar2 != null; rVar2 = rVar2.f6003d) {
            l lVar3 = new l(rVar2.f6000a, rVar2.f6001b, rVar2.f6002c);
            if (lVar2 == null) {
                lVar = lVar3;
            } else {
                lVar2.f6003d = lVar3;
            }
            lVar2 = lVar3;
        }
        return lVar;
    }
}
