package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d implements Iterable, n, j {

    /* renamed from: a, reason: collision with root package name */
    public final TreeMap f2532a;

    /* renamed from: b, reason: collision with root package name */
    public final TreeMap f2533b;

    public d(List list) {
        this();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                q(i, (n) list.get(i));
            }
        }
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator b() {
        return new c(this, this.f2532a.keySet().iterator(), this.f2533b.keySet().iterator());
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final n c(String str) {
        n nVar;
        return "length".equals(str) ? new g(Double.valueOf(o())) : (!h(str) || (nVar = (n) this.f2533b.get(str)) == null) ? n.f2717c : nVar;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final void d(String str, n nVar) {
        TreeMap treeMap = this.f2533b;
        if (nVar == null) {
            treeMap.remove(str);
        } else {
            treeMap.put(str, nVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean e() {
        return Boolean.TRUE;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        if (o() != dVar.o()) {
            return false;
        }
        TreeMap treeMap = this.f2532a;
        if (treeMap.isEmpty()) {
            return dVar.f2532a.isEmpty();
        }
        for (int intValue = ((Integer) treeMap.firstKey()).intValue(); intValue <= ((Integer) treeMap.lastKey()).intValue(); intValue++) {
            if (!p(intValue).equals(dVar.p(intValue))) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String f() {
        return t(",");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double g() {
        TreeMap treeMap = this.f2532a;
        return treeMap.size() == 1 ? p(0).g() : treeMap.size() <= 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final boolean h(String str) {
        return "length".equals(str) || this.f2533b.containsKey(str);
    }

    public final int hashCode() {
        return this.f2532a.hashCode() * 31;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new p(this, 2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x02dc, code lost:
    
        if (t0.f.S(r7, r2, (com.google.android.gms.internal.measurement.m) r0, java.lang.Boolean.FALSE, java.lang.Boolean.TRUE).o() == r7.o()) goto L168;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x02e6  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x03f8  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x043f  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x045d  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0495  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0601  */
    /* JADX WARN: Removed duplicated region for block: B:351:0x071f  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x072d  */
    /* JADX WARN: Removed duplicated region for block: B:371:0x0794  */
    /* JADX WARN: Removed duplicated region for block: B:396:0x07fa  */
    /* JADX WARN: Removed duplicated region for block: B:400:0x0812  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01f2  */
    @Override // com.google.android.gms.internal.measurement.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.n k(java.lang.String r37, y2.s r38, java.util.ArrayList r39) {
        /*
            Method dump skipped, instructions count: 2156
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.d.k(java.lang.String, y2.s, java.util.ArrayList):com.google.android.gms.internal.measurement.n");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n l() {
        d dVar = new d();
        for (Map.Entry entry : this.f2532a.entrySet()) {
            boolean z9 = entry.getValue() instanceof j;
            TreeMap treeMap = dVar.f2532a;
            if (z9) {
                treeMap.put((Integer) entry.getKey(), (n) entry.getValue());
            } else {
                treeMap.put((Integer) entry.getKey(), ((n) entry.getValue()).l());
            }
        }
        return dVar;
    }

    public final List m() {
        ArrayList arrayList = new ArrayList(o());
        for (int i = 0; i < o(); i++) {
            arrayList.add(p(i));
        }
        return arrayList;
    }

    public final Iterator n() {
        return this.f2532a.keySet().iterator();
    }

    public final int o() {
        TreeMap treeMap = this.f2532a;
        if (treeMap.isEmpty()) {
            return 0;
        }
        return ((Integer) treeMap.lastKey()).intValue() + 1;
    }

    public final n p(int i) {
        n nVar;
        if (i < o()) {
            return (!r(i) || (nVar = (n) this.f2532a.get(Integer.valueOf(i))) == null) ? n.f2717c : nVar;
        }
        com.google.gson.internal.a.r("Attempting to get element outside of current array");
        return null;
    }

    public final void q(int i, n nVar) {
        if (i > 32468) {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Array too large");
            return;
        }
        if (i < 0) {
            StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
            sb.append("Out of bounds index: ");
            sb.append(i);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        TreeMap treeMap = this.f2532a;
        if (nVar == null) {
            treeMap.remove(Integer.valueOf(i));
        } else {
            treeMap.put(Integer.valueOf(i), nVar);
        }
    }

    public final boolean r(int i) {
        if (i >= 0) {
            TreeMap treeMap = this.f2532a;
            if (i <= ((Integer) treeMap.lastKey()).intValue()) {
                return treeMap.containsKey(Integer.valueOf(i));
            }
        }
        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
        sb.append("Out of bounds index: ");
        sb.append(i);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final void s(int i) {
        TreeMap treeMap = this.f2532a;
        int intValue = ((Integer) treeMap.lastKey()).intValue();
        if (i > intValue || i < 0) {
            return;
        }
        treeMap.remove(Integer.valueOf(i));
        if (i == intValue) {
            int i6 = i - 1;
            Integer valueOf = Integer.valueOf(i6);
            if (treeMap.containsKey(valueOf) || i6 < 0) {
                return;
            }
            treeMap.put(valueOf, n.f2717c);
            return;
        }
        while (true) {
            i++;
            if (i > ((Integer) treeMap.lastKey()).intValue()) {
                return;
            }
            Integer valueOf2 = Integer.valueOf(i);
            n nVar = (n) treeMap.get(valueOf2);
            if (nVar != null) {
                treeMap.put(Integer.valueOf(i - 1), nVar);
                treeMap.remove(valueOf2);
            }
        }
    }

    public final String t(String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        if (!this.f2532a.isEmpty()) {
            int i = 0;
            while (true) {
                str2 = str == null ? "" : str;
                if (i >= o()) {
                    break;
                }
                n p10 = p(i);
                sb.append(str2);
                if (!(p10 instanceof r) && !(p10 instanceof l)) {
                    sb.append(p10.f());
                }
                i++;
            }
            sb.delete(0, str2.length());
        }
        return sb.toString();
    }

    public final String toString() {
        return t(",");
    }

    public d() {
        this.f2532a = new TreeMap();
        this.f2533b = new TreeMap();
    }
}
