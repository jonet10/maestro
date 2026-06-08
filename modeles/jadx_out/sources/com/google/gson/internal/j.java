package com.google.gson.internal;

import com.google.android.gms.internal.measurement.o6;
import com.google.android.gms.internal.measurement.q6;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3226a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractMap f3227b;

    public /* synthetic */ j(AbstractMap abstractMap, int i) {
        this.f3226a = i;
        this.f3227b = abstractMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        switch (this.f3226a) {
            case 2:
                Map.Entry entry = (Map.Entry) obj;
                if (contains(entry)) {
                    return false;
                }
                ((o6) this.f3227b).put((Comparable) entry.getKey(), entry.getValue());
                return true;
            default:
                return super.add(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f3226a) {
            case 0:
                ((l) this.f3227b).clear();
                break;
            case 1:
                ((l) this.f3227b).clear();
                break;
            default:
                ((o6) this.f3227b).clear();
                break;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0058 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean contains(java.lang.Object r5) {
        /*
            r4 = this;
            int r0 = r4.f3226a
            switch(r0) {
                case 0: goto L2f;
                case 1: goto L26;
                default: goto L5;
            }
        L5:
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r0 = r5.getKey()
            java.util.AbstractMap r1 = r4.f3227b
            com.google.android.gms.internal.measurement.o6 r1 = (com.google.android.gms.internal.measurement.o6) r1
            java.lang.Object r0 = r1.get(r0)
            java.lang.Object r5 = r5.getValue()
            r1 = 1
            if (r0 == r5) goto L25
            r2 = 0
            if (r0 == 0) goto L24
            boolean r5 = r0.equals(r5)
            if (r5 == 0) goto L24
            goto L25
        L24:
            r1 = r2
        L25:
            return r1
        L26:
            java.util.AbstractMap r0 = r4.f3227b
            com.google.gson.internal.l r0 = (com.google.gson.internal.l) r0
            boolean r5 = r0.containsKey(r5)
            return r5
        L2f:
            boolean r0 = r5 instanceof java.util.Map.Entry
            r1 = 0
            if (r0 == 0) goto L59
            java.util.AbstractMap r0 = r4.f3227b
            com.google.gson.internal.l r0 = (com.google.gson.internal.l) r0
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            java.lang.Object r2 = r5.getKey()
            r3 = 0
            if (r2 == 0) goto L46
            com.google.gson.internal.k r0 = r0.a(r2, r1)     // Catch: java.lang.ClassCastException -> L46
            goto L47
        L46:
            r0 = r3
        L47:
            if (r0 == 0) goto L56
            java.lang.Object r2 = r0.f3235q
            java.lang.Object r5 = r5.getValue()
            boolean r5 = j$.util.Objects.equals(r2, r5)
            if (r5 == 0) goto L56
            r3 = r0
        L56:
            if (r3 == 0) goto L59
            r1 = 1
        L59:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.j.contains(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f3226a) {
            case 0:
                return new i((l) this.f3227b, 0);
            case 1:
                return new i((l) this.f3227b, 1);
            default:
                return new q6((o6) this.f3227b);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x005d  */
    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean remove(java.lang.Object r6) {
        /*
            r5 = this;
            int r0 = r5.f3226a
            switch(r0) {
                case 0: goto L32;
                case 1: goto L1c;
                default: goto L5;
            }
        L5:
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            boolean r0 = r5.contains(r6)
            if (r0 == 0) goto L1a
            java.util.AbstractMap r0 = r5.f3227b
            com.google.android.gms.internal.measurement.o6 r0 = (com.google.android.gms.internal.measurement.o6) r0
            java.lang.Object r6 = r6.getKey()
            r0.remove(r6)
            r6 = 1
            goto L1b
        L1a:
            r6 = 0
        L1b:
            return r6
        L1c:
            java.util.AbstractMap r0 = r5.f3227b
            com.google.gson.internal.l r0 = (com.google.gson.internal.l) r0
            r1 = 0
            r2 = 0
            if (r6 == 0) goto L28
            com.google.gson.internal.k r2 = r0.a(r6, r1)     // Catch: java.lang.ClassCastException -> L28
        L28:
            r6 = 1
            if (r2 == 0) goto L2e
            r0.d(r2, r6)
        L2e:
            if (r2 == 0) goto L31
            r1 = r6
        L31:
            return r1
        L32:
            java.util.AbstractMap r0 = r5.f3227b
            com.google.gson.internal.l r0 = (com.google.gson.internal.l) r0
            boolean r1 = r6 instanceof java.util.Map.Entry
            r2 = 0
            if (r1 != 0) goto L3c
            goto L61
        L3c:
            java.util.Map$Entry r6 = (java.util.Map.Entry) r6
            java.lang.Object r1 = r6.getKey()
            r3 = 0
            if (r1 == 0) goto L4a
            com.google.gson.internal.k r1 = r0.a(r1, r2)     // Catch: java.lang.ClassCastException -> L4a
            goto L4b
        L4a:
            r1 = r3
        L4b:
            if (r1 == 0) goto L5a
            java.lang.Object r4 = r1.f3235q
            java.lang.Object r6 = r6.getValue()
            boolean r6 = j$.util.Objects.equals(r4, r6)
            if (r6 == 0) goto L5a
            r3 = r1
        L5a:
            if (r3 != 0) goto L5d
            goto L61
        L5d:
            r2 = 1
            r0.d(r3, r2)
        L61:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.j.remove(java.lang.Object):boolean");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f3226a) {
            case 0:
                return ((l) this.f3227b).f3241m;
            case 1:
                return ((l) this.f3227b).f3241m;
            default:
                return ((o6) this.f3227b).size();
        }
    }
}
