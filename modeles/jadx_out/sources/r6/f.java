package r6;

import b2.t1;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f implements Map, Serializable, e7.a {

    /* renamed from: w, reason: collision with root package name */
    public static final f f8931w;

    /* renamed from: a, reason: collision with root package name */
    public Object[] f8932a;

    /* renamed from: b, reason: collision with root package name */
    public Object[] f8933b;

    /* renamed from: l, reason: collision with root package name */
    public int[] f8934l;

    /* renamed from: m, reason: collision with root package name */
    public int[] f8935m;

    /* renamed from: n, reason: collision with root package name */
    public int f8936n;

    /* renamed from: o, reason: collision with root package name */
    public int f8937o;

    /* renamed from: p, reason: collision with root package name */
    public int f8938p;

    /* renamed from: q, reason: collision with root package name */
    public int f8939q;

    /* renamed from: r, reason: collision with root package name */
    public int f8940r;

    /* renamed from: s, reason: collision with root package name */
    public g f8941s;

    /* renamed from: t, reason: collision with root package name */
    public h f8942t;

    /* renamed from: u, reason: collision with root package name */
    public g f8943u;
    public boolean v;

    static {
        f fVar = new f(0);
        fVar.v = true;
        f8931w = fVar;
    }

    public f(int i) {
        if (i < 0) {
            com.google.gson.internal.a.p("capacity must be non-negative.");
            throw null;
        }
        Object[] objArr = new Object[i];
        int[] iArr = new int[i];
        int highestOneBit = Integer.highestOneBit((i < 1 ? 1 : i) * 3);
        this.f8932a = objArr;
        this.f8933b = null;
        this.f8934l = iArr;
        this.f8935m = new int[highestOneBit];
        this.f8936n = 2;
        this.f8937o = 0;
        this.f8938p = Integer.numberOfLeadingZeros(highestOneBit) + 1;
    }

    public final int a(Object obj) {
        d();
        while (true) {
            int j = j(obj);
            int i = this.f8936n * 2;
            int length = this.f8935m.length / 2;
            if (i > length) {
                i = length;
            }
            int i6 = 0;
            while (true) {
                int[] iArr = this.f8935m;
                int i10 = iArr[j];
                if (i10 <= 0) {
                    int i11 = this.f8937o;
                    Object[] objArr = this.f8932a;
                    if (i11 < objArr.length) {
                        int i12 = i11 + 1;
                        this.f8937o = i12;
                        objArr[i11] = obj;
                        this.f8934l[i11] = j;
                        iArr[j] = i12;
                        this.f8940r++;
                        this.f8939q++;
                        if (i6 > this.f8936n) {
                            this.f8936n = i6;
                        }
                        return i11;
                    }
                    g(1);
                } else {
                    if (l.a(this.f8932a[i10 - 1], obj)) {
                        return -i10;
                    }
                    i6++;
                    if (i6 > i) {
                        k(this.f8935m.length * 2);
                        break;
                    }
                    j = j == 0 ? this.f8935m.length - 1 : j - 1;
                }
            }
        }
    }

    public final f c() {
        d();
        this.v = true;
        if (this.f8940r > 0) {
            return this;
        }
        f fVar = f8931w;
        fVar.getClass();
        return fVar;
    }

    @Override // java.util.Map
    public final void clear() {
        d();
        int i = this.f8937o - 1;
        if (i >= 0) {
            int i6 = 0;
            while (true) {
                int[] iArr = this.f8934l;
                int i10 = iArr[i6];
                if (i10 >= 0) {
                    this.f8935m[i10] = 0;
                    iArr[i6] = -1;
                }
                if (i6 == i) {
                    break;
                } else {
                    i6++;
                }
            }
        }
        t1.L(this.f8932a, 0, this.f8937o);
        Object[] objArr = this.f8933b;
        if (objArr != null) {
            t1.L(objArr, 0, this.f8937o);
        }
        this.f8940r = 0;
        this.f8937o = 0;
        this.f8939q++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return h(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return i(obj) >= 0;
    }

    public final void d() {
        if (this.v) {
            com.google.gson.internal.a.q();
        }
    }

    public final void e(boolean z9) {
        int i;
        Object[] objArr = this.f8933b;
        int i6 = 0;
        int i10 = 0;
        while (true) {
            i = this.f8937o;
            if (i6 >= i) {
                break;
            }
            int[] iArr = this.f8934l;
            int i11 = iArr[i6];
            if (i11 >= 0) {
                Object[] objArr2 = this.f8932a;
                objArr2[i10] = objArr2[i6];
                if (objArr != null) {
                    objArr[i10] = objArr[i6];
                }
                if (z9) {
                    iArr[i10] = i11;
                    this.f8935m[i11] = i10 + 1;
                }
                i10++;
            }
            i6++;
        }
        t1.L(this.f8932a, i10, i);
        if (objArr != null) {
            t1.L(objArr, i10, this.f8937o);
        }
        this.f8937o = i10;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        g gVar = this.f8943u;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 0);
        this.f8943u = gVar2;
        return gVar2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        return this.f8940r == map.size() && f(map.entrySet());
    }

    public final boolean f(Collection collection) {
        boolean a8;
        collection.getClass();
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    Map.Entry entry = (Map.Entry) obj;
                    int h = h(entry.getKey());
                    if (h < 0) {
                        a8 = false;
                    } else {
                        Object[] objArr = this.f8933b;
                        objArr.getClass();
                        a8 = l.a(objArr[h], entry.getValue());
                    }
                    if (!a8) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    public final void g(int i) {
        Object[] objArr = this.f8932a;
        int length = objArr.length;
        int i6 = this.f8937o;
        int i10 = length - i6;
        int i11 = i6 - this.f8940r;
        if (i10 < i && i10 + i11 >= i && i11 >= objArr.length / 4) {
            e(true);
            return;
        }
        int i12 = i6 + i;
        if (i12 < 0) {
            throw new OutOfMemoryError();
        }
        if (i12 > objArr.length) {
            q6.b bVar = q6.e.Companion;
            int length2 = objArr.length;
            bVar.getClass();
            int e10 = q6.b.e(length2, i12);
            Object[] objArr2 = this.f8932a;
            objArr2.getClass();
            this.f8932a = Arrays.copyOf(objArr2, e10);
            Object[] objArr3 = this.f8933b;
            this.f8933b = objArr3 != null ? Arrays.copyOf(objArr3, e10) : null;
            this.f8934l = Arrays.copyOf(this.f8934l, e10);
            int highestOneBit = Integer.highestOneBit((e10 >= 1 ? e10 : 1) * 3);
            if (highestOneBit > this.f8935m.length) {
                k(highestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int h = h(obj);
        if (h < 0) {
            return null;
        }
        Object[] objArr = this.f8933b;
        objArr.getClass();
        return objArr[h];
    }

    public final int h(Object obj) {
        int j = j(obj);
        int i = this.f8936n;
        while (true) {
            int i6 = this.f8935m[j];
            if (i6 == 0) {
                return -1;
            }
            if (i6 > 0) {
                int i10 = i6 - 1;
                if (l.a(this.f8932a[i10], obj)) {
                    return i10;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            j = j == 0 ? this.f8935m.length - 1 : j - 1;
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        d dVar = new d(this, 0);
        int i = 0;
        while (dVar.hasNext()) {
            int i6 = dVar.f8924b;
            f fVar = dVar.f8923a;
            if (i6 >= fVar.f8937o) {
                com.google.gson.internal.a.l();
                return 0;
            }
            dVar.f8924b = i6 + 1;
            dVar.f8925l = i6;
            Object obj = fVar.f8932a[i6];
            int hashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = fVar.f8933b;
            objArr.getClass();
            Object obj2 = objArr[dVar.f8925l];
            int hashCode2 = obj2 != null ? obj2.hashCode() : 0;
            dVar.c();
            i += hashCode ^ hashCode2;
        }
        return i;
    }

    public final int i(Object obj) {
        int i = this.f8937o;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.f8934l[i] >= 0) {
                Object[] objArr = this.f8933b;
                objArr.getClass();
                if (l.a(objArr[i], obj)) {
                    return i;
                }
            }
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.f8940r == 0;
    }

    public final int j(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.f8938p;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0032, code lost:
    
        r3[r0] = r6;
        r5.f8934l[r2] = r0;
        r2 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(int r6) {
        /*
            r5 = this;
            int r0 = r5.f8939q
            int r0 = r0 + 1
            r5.f8939q = r0
            int r0 = r5.f8937o
            int r1 = r5.f8940r
            r2 = 0
            if (r0 <= r1) goto L10
            r5.e(r2)
        L10:
            int[] r0 = new int[r6]
            r5.f8935m = r0
            int r6 = java.lang.Integer.numberOfLeadingZeros(r6)
            int r6 = r6 + 1
            r5.f8938p = r6
        L1c:
            int r6 = r5.f8937o
            if (r2 >= r6) goto L4d
            int r6 = r2 + 1
            java.lang.Object[] r0 = r5.f8932a
            r0 = r0[r2]
            int r0 = r5.j(r0)
            int r1 = r5.f8936n
        L2c:
            int[] r3 = r5.f8935m
            r4 = r3[r0]
            if (r4 != 0) goto L3a
            r3[r0] = r6
            int[] r1 = r5.f8934l
            r1[r2] = r0
            r2 = r6
            goto L1c
        L3a:
            int r1 = r1 + (-1)
            if (r1 < 0) goto L48
            int r4 = r0 + (-1)
            if (r0 != 0) goto L46
            int r0 = r3.length
            int r0 = r0 + (-1)
            goto L2c
        L46:
            r0 = r4
            goto L2c
        L48:
            java.lang.String r6 = "This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?"
            androidx.privacysandbox.ads.adservices.customaudience.a.i(r6)
        L4d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r6.f.k(int):void");
    }

    @Override // java.util.Map
    public final Set keySet() {
        g gVar = this.f8941s;
        if (gVar != null) {
            return gVar;
        }
        g gVar2 = new g(this, 1);
        this.f8941s = gVar2;
        return gVar2;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0064 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:? A[LOOP:0: B:8:0x0022->B:25:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.f8932a
            r0.getClass()
            r1 = 0
            r0[r12] = r1
            java.lang.Object[] r0 = r11.f8933b
            if (r0 == 0) goto Le
            r0[r12] = r1
        Le:
            int[] r0 = r11.f8934l
            r0 = r0[r12]
            int r1 = r11.f8936n
            int r1 = r1 * 2
            int[] r2 = r11.f8935m
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L1e
            r1 = r2
        L1e:
            r2 = 0
            r3 = r1
            r4 = r2
            r1 = r0
        L22:
            int r5 = r0 + (-1)
            if (r0 != 0) goto L2c
            int[] r0 = r11.f8935m
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L2d
        L2c:
            r0 = r5
        L2d:
            int r4 = r4 + 1
            int r5 = r11.f8936n
            int[] r6 = r11.f8935m
            r7 = -1
            if (r4 <= r5) goto L39
            r6[r1] = r2
            goto L68
        L39:
            r5 = r6[r0]
            if (r5 != 0) goto L40
            r6[r1] = r2
            goto L68
        L40:
            if (r5 >= 0) goto L47
            r6[r1] = r7
        L44:
            r1 = r0
            r4 = r2
            goto L61
        L47:
            java.lang.Object[] r6 = r11.f8932a
            int r8 = r5 + (-1)
            r6 = r6[r8]
            int r6 = r11.j(r6)
            int r6 = r6 - r0
            int[] r9 = r11.f8935m
            int r10 = r9.length
            int r10 = r10 + (-1)
            r6 = r6 & r10
            if (r6 < r4) goto L61
            r9[r1] = r5
            int[] r4 = r11.f8934l
            r4[r8] = r1
            goto L44
        L61:
            int r3 = r3 + r7
            if (r3 >= 0) goto L22
            int[] r0 = r11.f8935m
            r0[r1] = r7
        L68:
            int[] r0 = r11.f8934l
            r0[r12] = r7
            int r12 = r11.f8940r
            int r12 = r12 + r7
            r11.f8940r = r12
            int r12 = r11.f8939q
            int r12 = r12 + 1
            r11.f8939q = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: r6.f.l(int):void");
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        d();
        int a8 = a(obj);
        Object[] objArr = this.f8933b;
        if (objArr == null) {
            int length = this.f8932a.length;
            if (length < 0) {
                com.google.gson.internal.a.p("capacity must be non-negative.");
                return null;
            }
            objArr = new Object[length];
            this.f8933b = objArr;
        }
        if (a8 >= 0) {
            objArr[a8] = obj2;
            return null;
        }
        int i = (-a8) - 1;
        Object obj3 = objArr[i];
        objArr[i] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        map.getClass();
        d();
        Set<Map.Entry> entrySet = map.entrySet();
        if (entrySet.isEmpty()) {
            return;
        }
        g(entrySet.size());
        for (Map.Entry entry : entrySet) {
            int a8 = a(entry.getKey());
            Object[] objArr = this.f8933b;
            if (objArr == null) {
                int length = this.f8932a.length;
                if (length < 0) {
                    com.google.gson.internal.a.p("capacity must be non-negative.");
                    return;
                } else {
                    objArr = new Object[length];
                    this.f8933b = objArr;
                }
            }
            if (a8 >= 0) {
                objArr[a8] = entry.getValue();
            } else {
                int i = (-a8) - 1;
                if (!l.a(entry.getValue(), objArr[i])) {
                    objArr[i] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        d();
        int h = h(obj);
        if (h < 0) {
            return null;
        }
        Object[] objArr = this.f8933b;
        objArr.getClass();
        Object obj2 = objArr[h];
        l(h);
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.f8940r;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.f8940r * 3) + 2);
        sb.append("{");
        int i = 0;
        d dVar = new d(this, 0);
        while (dVar.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            int i6 = dVar.f8924b;
            f fVar = dVar.f8923a;
            if (i6 >= fVar.f8937o) {
                com.google.gson.internal.a.l();
                return null;
            }
            dVar.f8924b = i6 + 1;
            dVar.f8925l = i6;
            Object obj = fVar.f8932a[i6];
            if (obj == fVar) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = fVar.f8933b;
            objArr.getClass();
            Object obj2 = objArr[dVar.f8925l];
            if (obj2 == fVar) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            dVar.c();
            i++;
        }
        sb.append("}");
        return sb.toString();
    }

    @Override // java.util.Map
    public final Collection values() {
        h hVar = this.f8942t;
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(this);
        this.f8942t = hVar2;
        return hVar2;
    }

    public f() {
        this(8);
    }
}
