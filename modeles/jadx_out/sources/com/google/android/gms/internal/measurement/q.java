package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q implements Iterable, n {

    /* renamed from: a, reason: collision with root package name */
    public final String f2753a;

    public q(String str) {
        if (str != null) {
            this.f2753a = str;
        } else {
            com.google.gson.internal.a.p("StringValue cannot be null.");
            throw null;
        }
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator b() {
        return new p(this, 0);
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean e() {
        return Boolean.valueOf(!this.f2753a.isEmpty());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            return this.f2753a.equals(((q) obj).f2753a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String f() {
        return this.f2753a;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double g() {
        String str = this.f2753a;
        if (str.isEmpty()) {
            return Double.valueOf(0.0d);
        }
        try {
            return Double.valueOf(str);
        } catch (NumberFormatException unused) {
            return Double.valueOf(Double.NaN);
        }
    }

    public final int hashCode() {
        return this.f2753a.hashCode();
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new p(this, 1);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:102:0x02e2, code lost:
    
        if (r4[r1].isEmpty() == false) goto L104;
     */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.measurement.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.android.gms.internal.measurement.n k(java.lang.String r29, y2.s r30, java.util.ArrayList r31) {
        /*
            Method dump skipped, instructions count: 1606
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.measurement.q.k(java.lang.String, y2.s, java.util.ArrayList):com.google.android.gms.internal.measurement.n");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n l() {
        return new q(this.f2753a);
    }

    public final String toString() {
        String str = this.f2753a;
        return a4.x.o(new StringBuilder(str.length() + 2), "\"", str, "\"");
    }
}
