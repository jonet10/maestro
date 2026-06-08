package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f implements n {

    /* renamed from: a, reason: collision with root package name */
    public final n f2567a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2568b;

    public f(String str) {
        this.f2567a = n.f2717c;
        this.f2568b = str;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator b() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean e() {
        throw new IllegalStateException("Control is not a boolean");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f2568b.equals(fVar.f2568b) && this.f2567a.equals(fVar.f2567a);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String f() {
        throw new IllegalStateException("Control is not a String");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double g() {
        throw new IllegalStateException("Control is not a double");
    }

    public final int hashCode() {
        return this.f2567a.hashCode() + (this.f2568b.hashCode() * 31);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n k(String str, y2.s sVar, ArrayList arrayList) {
        throw new IllegalStateException("Control does not have functions");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n l() {
        return new f(this.f2568b, this.f2567a.l());
    }

    public f(String str, n nVar) {
        this.f2567a = nVar;
        this.f2568b = str;
    }
}
