package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o implements n {

    /* renamed from: a, reason: collision with root package name */
    public final String f2731a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2732b;

    public o(String str, ArrayList arrayList) {
        this.f2731a = str;
        ArrayList arrayList2 = new ArrayList();
        this.f2732b = arrayList2;
        arrayList2.addAll(arrayList);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator b() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean e() {
        throw new IllegalStateException("Statement cannot be cast as Boolean");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof o)) {
            return false;
        }
        o oVar = (o) obj;
        String str = oVar.f2731a;
        String str2 = this.f2731a;
        if (str2 == null ? str == null : str2.equals(str)) {
            return this.f2732b.equals(oVar.f2732b);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String f() {
        throw new IllegalStateException("Statement cannot be cast as String");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double g() {
        throw new IllegalStateException("Statement cannot be cast as Double");
    }

    public final int hashCode() {
        String str = this.f2731a;
        return this.f2732b.hashCode() + ((str != null ? str.hashCode() : 0) * 31);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n k(String str, y2.s sVar, ArrayList arrayList) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n l() {
        return this;
    }
}
