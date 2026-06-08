package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o6 extends AbstractMap {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f2734a;

    /* renamed from: b, reason: collision with root package name */
    public int f2735b;

    /* renamed from: l, reason: collision with root package name */
    public Map f2736l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f2737m;

    /* renamed from: n, reason: collision with root package name */
    public volatile com.google.gson.internal.j f2738n;

    /* renamed from: o, reason: collision with root package name */
    public Map f2739o;

    public o6() {
        Map map = Collections.EMPTY_MAP;
        this.f2736l = map;
        this.f2739o = map;
    }

    public final p6 a(int i) {
        if (i < this.f2735b) {
            return (p6) this.f2734a[i];
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public final Set c() {
        return this.f2736l.isEmpty() ? Collections.EMPTY_SET : this.f2736l.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        g();
        if (this.f2735b != 0) {
            this.f2734a = null;
            this.f2735b = 0;
        }
        if (this.f2736l.isEmpty()) {
            return;
        }
        this.f2736l.clear();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return f(comparable) >= 0 || this.f2736l.containsKey(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final Object put(Comparable comparable, Object obj) {
        g();
        int f = f(comparable);
        if (f >= 0) {
            return ((p6) this.f2734a[f]).setValue(obj);
        }
        g();
        if (this.f2734a == null) {
            this.f2734a = new Object[16];
        }
        int i = -(f + 1);
        if (i >= 16) {
            return h().put(comparable, obj);
        }
        if (this.f2735b == 16) {
            p6 p6Var = (p6) this.f2734a[15];
            this.f2735b = 15;
            h().put(p6Var.f2746a, p6Var.f2747b);
        }
        Object[] objArr = this.f2734a;
        int length = objArr.length;
        System.arraycopy(objArr, i, objArr, i + 1, 15 - i);
        this.f2734a[i] = new p6(this, comparable, obj);
        this.f2735b++;
        return null;
    }

    public final Object e(int i) {
        g();
        Object[] objArr = this.f2734a;
        Object obj = ((p6) objArr[i]).f2747b;
        System.arraycopy(objArr, i + 1, objArr, i, (this.f2735b - i) - 1);
        this.f2735b--;
        if (!this.f2736l.isEmpty()) {
            Iterator it = h().entrySet().iterator();
            Object[] objArr2 = this.f2734a;
            int i6 = this.f2735b;
            Map.Entry entry = (Map.Entry) it.next();
            objArr2[i6] = new p6(this, (Comparable) entry.getKey(), entry.getValue());
            this.f2735b++;
            it.remove();
        }
        return obj;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        if (this.f2738n == null) {
            this.f2738n = new com.google.gson.internal.j(this, 2);
        }
        return this.f2738n;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o6)) {
            return super.equals(obj);
        }
        o6 o6Var = (o6) obj;
        int size = size();
        if (size == o6Var.size()) {
            int i = this.f2735b;
            if (i != o6Var.f2735b) {
                return entrySet().equals(o6Var.entrySet());
            }
            for (int i6 = 0; i6 < i; i6++) {
                if (a(i6).equals(o6Var.a(i6))) {
                }
            }
            if (i != size) {
                return this.f2736l.equals(o6Var.f2736l);
            }
            return true;
        }
        return false;
    }

    public final int f(Comparable comparable) {
        int i = this.f2735b;
        int i6 = i - 1;
        int i10 = 0;
        if (i6 >= 0) {
            int compareTo = comparable.compareTo(((p6) this.f2734a[i6]).f2746a);
            if (compareTo > 0) {
                return -(i + 1);
            }
            if (compareTo == 0) {
                return i6;
            }
        }
        while (i10 <= i6) {
            int i11 = (i10 + i6) / 2;
            int compareTo2 = comparable.compareTo(((p6) this.f2734a[i11]).f2746a);
            if (compareTo2 < 0) {
                i6 = i11 - 1;
            } else {
                if (compareTo2 <= 0) {
                    return i11;
                }
                i10 = i11 + 1;
            }
        }
        return -(i10 + 1);
    }

    public final void g() {
        if (this.f2737m) {
            com.google.gson.internal.a.q();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int f = f(comparable);
        return f >= 0 ? ((p6) this.f2734a[f]).f2747b : this.f2736l.get(comparable);
    }

    public final SortedMap h() {
        g();
        if (this.f2736l.isEmpty() && !(this.f2736l instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f2736l = treeMap;
            this.f2739o = treeMap.descendingMap();
        }
        return (SortedMap) this.f2736l;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i = this.f2735b;
        int i6 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            i6 += this.f2734a[i10].hashCode();
        }
        return this.f2736l.size() > 0 ? this.f2736l.hashCode() + i6 : i6;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        g();
        Comparable comparable = (Comparable) obj;
        int f = f(comparable);
        if (f >= 0) {
            return e(f);
        }
        if (this.f2736l.isEmpty()) {
            return null;
        }
        return this.f2736l.remove(comparable);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f2736l.size() + this.f2735b;
    }
}
