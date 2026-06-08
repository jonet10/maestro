package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m1 extends l5 {
    private static final m1 zzi;
    private int zzb;
    private int zzd;
    private q5 zze;
    private q5 zzf;
    private boolean zzg;
    private boolean zzh;

    static {
        m1 m1Var = new m1();
        zzi = m1Var;
        l5.l(m1.class, m1Var);
    }

    public m1() {
        k6 k6Var = k6.f2689n;
        this.zze = k6Var;
        this.zzf = k6Var;
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzb", "zzd", "zze", v1.class, "zzf", o1.class, "zzg", "zzh"});
        }
        if (i6 == 3) {
            return new m1();
        }
        if (i6 == 4) {
            return new l1(zzi);
        }
        if (i6 == 5) {
            return zzi;
        }
        throw null;
    }

    public final boolean o() {
        return (this.zzb & 1) != 0;
    }

    public final int p() {
        return this.zzd;
    }

    public final List q() {
        return this.zze;
    }

    public final int r() {
        return this.zze.size();
    }

    public final v1 s(int i) {
        return (v1) this.zze.get(i);
    }

    public final q5 t() {
        return this.zzf;
    }

    public final int u() {
        return this.zzf.size();
    }

    public final o1 v(int i) {
        return (o1) this.zzf.get(i);
    }

    public final void w(int i, v1 v1Var) {
        q5 q5Var = this.zze;
        if (!((t4) q5Var).f2807a) {
            int size = q5Var.size();
            this.zze = q5Var.j(size + size);
        }
        this.zze.set(i, v1Var);
    }

    public final void x(int i, o1 o1Var) {
        q5 q5Var = this.zzf;
        if (!((t4) q5Var).f2807a) {
            int size = q5Var.size();
            this.zzf = q5Var.j(size + size);
        }
        this.zzf.set(i, o1Var);
    }
}
