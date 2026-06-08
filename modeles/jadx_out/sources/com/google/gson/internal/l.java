package com.google.gson.internal;

import c4.n5;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Comparator;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l extends AbstractMap implements Serializable {

    /* renamed from: r, reason: collision with root package name */
    public static final n5 f3237r = new n5(11);

    /* renamed from: b, reason: collision with root package name */
    public final boolean f3239b;

    /* renamed from: l, reason: collision with root package name */
    public k f3240l;

    /* renamed from: o, reason: collision with root package name */
    public final k f3243o;

    /* renamed from: p, reason: collision with root package name */
    public j f3244p;

    /* renamed from: q, reason: collision with root package name */
    public j f3245q;

    /* renamed from: m, reason: collision with root package name */
    public int f3241m = 0;

    /* renamed from: n, reason: collision with root package name */
    public int f3242n = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Comparator f3238a = f3237r;

    public l(boolean z9) {
        this.f3239b = z9;
        this.f3243o = new k(z9);
    }

    public final k a(Object obj, boolean z9) {
        int i;
        k kVar;
        k kVar2 = this.f3240l;
        n5 n5Var = f3237r;
        Comparator comparator = this.f3238a;
        if (kVar2 != null) {
            Comparable comparable = comparator == n5Var ? (Comparable) obj : null;
            while (true) {
                Object obj2 = kVar2.f3233o;
                i = comparable != null ? comparable.compareTo(obj2) : comparator.compare(obj, obj2);
                if (i == 0) {
                    return kVar2;
                }
                k kVar3 = i < 0 ? kVar2.f3229b : kVar2.f3230l;
                if (kVar3 == null) {
                    break;
                }
                kVar2 = kVar3;
            }
        } else {
            i = 0;
        }
        k kVar4 = kVar2;
        if (!z9) {
            return null;
        }
        k kVar5 = this.f3243o;
        if (kVar4 != null) {
            kVar = new k(this.f3239b, kVar4, obj, kVar5, kVar5.f3232n);
            if (i < 0) {
                kVar4.f3229b = kVar;
            } else {
                kVar4.f3230l = kVar;
            }
            c(kVar4, true);
        } else {
            if (comparator == n5Var && !(obj instanceof Comparable)) {
                throw new ClassCastException(obj.getClass().getName().concat(" is not Comparable"));
            }
            kVar = new k(this.f3239b, kVar4, obj, kVar5, kVar5.f3232n);
            this.f3240l = kVar;
        }
        this.f3241m++;
        this.f3242n++;
        return kVar;
    }

    public final void c(k kVar, boolean z9) {
        while (kVar != null) {
            k kVar2 = kVar.f3229b;
            k kVar3 = kVar.f3230l;
            int i = kVar2 != null ? kVar2.f3236r : 0;
            int i6 = kVar3 != null ? kVar3.f3236r : 0;
            int i10 = i - i6;
            if (i10 == -2) {
                k kVar4 = kVar3.f3229b;
                k kVar5 = kVar3.f3230l;
                int i11 = (kVar4 != null ? kVar4.f3236r : 0) - (kVar5 != null ? kVar5.f3236r : 0);
                if (i11 == -1 || (i11 == 0 && !z9)) {
                    f(kVar);
                } else {
                    g(kVar3);
                    f(kVar);
                }
                if (z9) {
                    return;
                }
            } else if (i10 == 2) {
                k kVar6 = kVar2.f3229b;
                k kVar7 = kVar2.f3230l;
                int i12 = (kVar6 != null ? kVar6.f3236r : 0) - (kVar7 != null ? kVar7.f3236r : 0);
                if (i12 == 1 || (i12 == 0 && !z9)) {
                    g(kVar);
                } else {
                    f(kVar2);
                    g(kVar);
                }
                if (z9) {
                    return;
                }
            } else if (i10 == 0) {
                kVar.f3236r = i + 1;
                if (z9) {
                    return;
                }
            } else {
                kVar.f3236r = Math.max(i, i6) + 1;
                if (!z9) {
                    return;
                }
            }
            kVar = kVar.f3228a;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        this.f3240l = null;
        this.f3241m = 0;
        this.f3242n++;
        k kVar = this.f3243o;
        kVar.f3232n = kVar;
        kVar.f3231m = kVar;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        k kVar = null;
        if (obj != null) {
            try {
                kVar = a(obj, false);
            } catch (ClassCastException unused) {
            }
        }
        return kVar != null;
    }

    public final void d(k kVar, boolean z9) {
        k kVar2;
        k kVar3;
        int i;
        if (z9) {
            k kVar4 = kVar.f3232n;
            kVar4.f3231m = kVar.f3231m;
            kVar.f3231m.f3232n = kVar4;
        }
        k kVar5 = kVar.f3229b;
        k kVar6 = kVar.f3230l;
        k kVar7 = kVar.f3228a;
        int i6 = 0;
        if (kVar5 == null || kVar6 == null) {
            if (kVar5 != null) {
                e(kVar, kVar5);
                kVar.f3229b = null;
            } else if (kVar6 != null) {
                e(kVar, kVar6);
                kVar.f3230l = null;
            } else {
                e(kVar, null);
            }
            c(kVar7, false);
            this.f3241m--;
            this.f3242n++;
            return;
        }
        if (kVar5.f3236r > kVar6.f3236r) {
            k kVar8 = kVar5.f3230l;
            while (true) {
                k kVar9 = kVar8;
                kVar3 = kVar5;
                kVar5 = kVar9;
                if (kVar5 == null) {
                    break;
                } else {
                    kVar8 = kVar5.f3230l;
                }
            }
        } else {
            k kVar10 = kVar6.f3229b;
            while (true) {
                kVar2 = kVar6;
                kVar6 = kVar10;
                if (kVar6 == null) {
                    break;
                } else {
                    kVar10 = kVar6.f3229b;
                }
            }
            kVar3 = kVar2;
        }
        d(kVar3, false);
        k kVar11 = kVar.f3229b;
        if (kVar11 != null) {
            i = kVar11.f3236r;
            kVar3.f3229b = kVar11;
            kVar11.f3228a = kVar3;
            kVar.f3229b = null;
        } else {
            i = 0;
        }
        k kVar12 = kVar.f3230l;
        if (kVar12 != null) {
            i6 = kVar12.f3236r;
            kVar3.f3230l = kVar12;
            kVar12.f3228a = kVar3;
            kVar.f3230l = null;
        }
        kVar3.f3236r = Math.max(i, i6) + 1;
        e(kVar, kVar3);
    }

    public final void e(k kVar, k kVar2) {
        k kVar3 = kVar.f3228a;
        kVar.f3228a = null;
        if (kVar2 != null) {
            kVar2.f3228a = kVar3;
        }
        if (kVar3 == null) {
            this.f3240l = kVar2;
        } else if (kVar3.f3229b == kVar) {
            kVar3.f3229b = kVar2;
        } else {
            kVar3.f3230l = kVar2;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        j jVar = this.f3244p;
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j(this, 0);
        this.f3244p = jVar2;
        return jVar2;
    }

    public final void f(k kVar) {
        k kVar2 = kVar.f3229b;
        k kVar3 = kVar.f3230l;
        k kVar4 = kVar3.f3229b;
        k kVar5 = kVar3.f3230l;
        kVar.f3230l = kVar4;
        if (kVar4 != null) {
            kVar4.f3228a = kVar;
        }
        e(kVar, kVar3);
        kVar3.f3229b = kVar;
        kVar.f3228a = kVar3;
        int max = Math.max(kVar2 != null ? kVar2.f3236r : 0, kVar4 != null ? kVar4.f3236r : 0) + 1;
        kVar.f3236r = max;
        kVar3.f3236r = Math.max(max, kVar5 != null ? kVar5.f3236r : 0) + 1;
    }

    public final void g(k kVar) {
        k kVar2 = kVar.f3229b;
        k kVar3 = kVar.f3230l;
        k kVar4 = kVar2.f3229b;
        k kVar5 = kVar2.f3230l;
        kVar.f3229b = kVar5;
        if (kVar5 != null) {
            kVar5.f3228a = kVar;
        }
        e(kVar, kVar2);
        kVar2.f3230l = kVar;
        kVar.f3228a = kVar2;
        int max = Math.max(kVar3 != null ? kVar3.f3236r : 0, kVar5 != null ? kVar5.f3236r : 0) + 1;
        kVar.f3236r = max;
        kVar2.f3236r = Math.max(max, kVar4 != null ? kVar4.f3236r : 0) + 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x000f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object get(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L9
            r1 = 0
            com.google.gson.internal.k r3 = r2.a(r3, r1)     // Catch: java.lang.ClassCastException -> L9
            goto La
        L9:
            r3 = r0
        La:
            if (r3 == 0) goto Lf
            java.lang.Object r3 = r3.f3235q
            return r3
        Lf:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.l.get(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        j jVar = this.f3245q;
        if (jVar != null) {
            return jVar;
        }
        j jVar2 = new j(this, 1);
        this.f3245q = jVar2;
        return jVar2;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        if (obj == null) {
            a.i("key == null");
            return null;
        }
        if (obj2 == null && !this.f3239b) {
            a.i("value == null");
            return null;
        }
        k a8 = a(obj, true);
        Object obj3 = a8.f3235q;
        a8.f3235q = obj2;
        return obj3;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000c  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object remove(java.lang.Object r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L9
            r1 = 0
            com.google.gson.internal.k r3 = r2.a(r3, r1)     // Catch: java.lang.ClassCastException -> L9
            goto La
        L9:
            r3 = r0
        La:
            if (r3 == 0) goto L10
            r1 = 1
            r2.d(r3, r1)
        L10:
            if (r3 == 0) goto L15
            java.lang.Object r3 = r3.f3235q
            return r3
        L15:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.l.remove(java.lang.Object):java.lang.Object");
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        return this.f3241m;
    }
}
