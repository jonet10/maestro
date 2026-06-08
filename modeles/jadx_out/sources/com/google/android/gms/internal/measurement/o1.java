package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o1 extends l5 {
    private static final o1 zzl;
    private int zzb;
    private int zzd;
    private String zze = "";
    private q5 zzf = k6.f2689n;
    private boolean zzg;
    private t1 zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    static {
        o1 o1Var = new o1();
        zzl = o1Var;
        l5.l(o1.class, o1Var);
    }

    public static n1 A() {
        return (n1) zzl.g();
    }

    public final /* synthetic */ void B(String str) {
        this.zzb |= 2;
        this.zze = str;
    }

    public final void C(int i, q1 q1Var) {
        q5 q5Var = this.zzf;
        if (!((t4) q5Var).f2807a) {
            int size = q5Var.size();
            this.zzf = q5Var.j(size + size);
        }
        this.zzf.set(i, q1Var);
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzl, "\u0004\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", q1.class, "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i6 == 3) {
            return new o1();
        }
        if (i6 == 4) {
            return new n1(zzl);
        }
        if (i6 == 5) {
            return zzl;
        }
        throw null;
    }

    public final boolean o() {
        return (this.zzb & 1) != 0;
    }

    public final int p() {
        return this.zzd;
    }

    public final String q() {
        return this.zze;
    }

    public final List r() {
        return this.zzf;
    }

    public final int s() {
        return this.zzf.size();
    }

    public final q1 t(int i) {
        return (q1) this.zzf.get(i);
    }

    public final boolean u() {
        return (this.zzb & 8) != 0;
    }

    public final t1 v() {
        t1 t1Var = this.zzh;
        return t1Var == null ? t1.x() : t1Var;
    }

    public final boolean w() {
        return this.zzi;
    }

    public final boolean x() {
        return this.zzj;
    }

    public final boolean y() {
        return (this.zzb & 64) != 0;
    }

    public final boolean z() {
        return this.zzk;
    }
}
