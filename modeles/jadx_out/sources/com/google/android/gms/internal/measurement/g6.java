package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g6 implements m6 {

    /* renamed from: a, reason: collision with root package name */
    public final s4 f2602a;

    /* renamed from: b, reason: collision with root package name */
    public final j5 f2603b;

    public g6(j5 j5Var, s4 s4Var) {
        j5 j5Var2 = e5.f2559a;
        this.f2603b = j5Var;
        this.f2602a = s4Var;
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final l5 a() {
        s4 s4Var = this.f2602a;
        if (s4Var instanceof l5) {
            return (l5) ((l5) s4Var).n(4);
        }
        k5 k5Var = (k5) ((l5) s4Var).n(5);
        boolean e10 = k5Var.f2687b.e();
        l5 l5Var = k5Var.f2687b;
        if (!e10) {
            return l5Var;
        }
        l5Var.getClass();
        j6.f2671c.a(l5Var.getClass()).g(l5Var);
        l5Var.f();
        return k5Var.f2687b;
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final void b(Object obj, Object obj2) {
        n6.b(obj, obj2);
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final int c(s4 s4Var) {
        r6 r6Var = ((l5) s4Var).zzc;
        int i = r6Var.f2783d;
        if (i != -1) {
            return i;
        }
        int i6 = 0;
        for (int i10 = 0; i10 < r6Var.f2780a; i10++) {
            int i11 = r6Var.f2781b[i10] >>> 3;
            a5 a5Var = (a5) r6Var.f2782c[i10];
            int s6 = b5.s(8);
            int s9 = b5.s(i11) + b5.s(16);
            int s10 = b5.s(24);
            int d10 = a5Var.d();
            i6 += s6 + s6 + s9 + androidx.lifecycle.l.m(d10, d10, s10);
        }
        r6Var.f2783d = i6;
        return i6;
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final void d(Object obj, z5 z5Var) {
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final boolean e(Object obj) {
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final boolean f(l5 l5Var, l5 l5Var2) {
        return l5Var.zzc.equals(l5Var2.zzc);
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final void g(Object obj) {
        this.f2603b.getClass();
        r6 r6Var = ((l5) obj).zzc;
        if (r6Var.f2784e) {
            r6Var.f2784e = false;
        }
        j5 j5Var = e5.f2559a;
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final void h(Object obj, byte[] bArr, int i, int i6, v4 v4Var) {
        l5 l5Var = (l5) obj;
        if (l5Var.zzc == r6.f) {
            l5Var.zzc = r6.a();
        }
        obj.getClass();
        throw new ClassCastException();
    }

    @Override // com.google.android.gms.internal.measurement.m6
    public final int i(l5 l5Var) {
        return l5Var.zzc.hashCode();
    }
}
