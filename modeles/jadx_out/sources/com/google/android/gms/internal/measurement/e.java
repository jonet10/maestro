package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e implements n {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f2545a;

    public e(Boolean bool) {
        this.f2545a = bool == null ? false : bool.booleanValue();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator b() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean e() {
        return Boolean.valueOf(this.f2545a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && this.f2545a == ((e) obj).f2545a;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String f() {
        return Boolean.toString(this.f2545a);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double g() {
        return Double.valueOf(true != this.f2545a ? 0.0d : 1.0d);
    }

    public final int hashCode() {
        return Boolean.valueOf(this.f2545a).hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n k(String str, y2.s sVar, ArrayList arrayList) {
        boolean equals = "toString".equals(str);
        boolean z9 = this.f2545a;
        if (equals) {
            return new q(Boolean.toString(z9));
        }
        throw new IllegalArgumentException(Boolean.toString(z9) + "." + str + " is not a function.");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n l() {
        return new e(Boolean.valueOf(this.f2545a));
    }

    public final String toString() {
        return String.valueOf(this.f2545a);
    }
}
