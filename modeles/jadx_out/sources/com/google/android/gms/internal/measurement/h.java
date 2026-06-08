package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class h implements n, j {

    /* renamed from: a, reason: collision with root package name */
    public final String f2650a;

    /* renamed from: b, reason: collision with root package name */
    public final HashMap f2651b = new HashMap();

    public h(String str) {
        this.f2650a = str;
    }

    public abstract n a(y2.s sVar, List list);

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator b() {
        return new i(this.f2651b.keySet().iterator());
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final n c(String str) {
        HashMap hashMap = this.f2651b;
        return hashMap.containsKey(str) ? (n) hashMap.get(str) : n.f2717c;
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final void d(String str, n nVar) {
        HashMap hashMap = this.f2651b;
        if (nVar == null) {
            hashMap.remove(str);
        } else {
            hashMap.put(str, nVar);
        }
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean e() {
        return Boolean.TRUE;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        String str = this.f2650a;
        if (str != null) {
            return str.equals(hVar.f2650a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String f() {
        return this.f2650a;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double g() {
        return Double.valueOf(Double.NaN);
    }

    @Override // com.google.android.gms.internal.measurement.j
    public final boolean h(String str) {
        return this.f2651b.containsKey(str);
    }

    public final int hashCode() {
        String str = this.f2650a;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n k(String str, y2.s sVar, ArrayList arrayList) {
        return "toString".equals(str) ? new q(this.f2650a) : androidx.lifecycle.l.I(this, new q(str), sVar, arrayList);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public n l() {
        return this;
    }
}
