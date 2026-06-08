package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f2 extends l5 {
    private static final f2 zzu;
    private int zzb;
    private long zzd;
    private String zze = "";
    private int zzf;
    private q5 zzg;
    private q5 zzh;
    private q5 zzi;
    private String zzj;
    private boolean zzk;
    private q5 zzl;
    private q5 zzm;
    private String zzn;
    private String zzo;
    private a2 zzp;
    private h2 zzq;
    private k2 zzr;
    private i2 zzs;
    private g2 zzt;

    static {
        f2 f2Var = new f2();
        zzu = f2Var;
        l5.l(f2.class, f2Var);
    }

    public f2() {
        k6 k6Var = k6.f2689n;
        this.zzg = k6Var;
        this.zzh = k6Var;
        this.zzi = k6Var;
        this.zzj = "";
        this.zzl = k6Var;
        this.zzm = k6Var;
        this.zzn = "";
        this.zzo = "";
    }

    public static e2 E() {
        return (e2) zzu.g();
    }

    public static f2 F() {
        return zzu;
    }

    public final boolean A() {
        return (this.zzb & 128) != 0;
    }

    public final a2 B() {
        a2 a2Var = this.zzp;
        return a2Var == null ? a2.u() : a2Var;
    }

    public final boolean C() {
        return (this.zzb & 512) != 0;
    }

    public final k2 D() {
        k2 k2Var = this.zzr;
        return k2Var == null ? k2.q() : k2Var;
    }

    public final void G(int i, d2 d2Var) {
        q5 q5Var = this.zzh;
        if (!((t4) q5Var).f2807a) {
            int size = q5Var.size();
            this.zzh = q5Var.j(size + size);
        }
        this.zzh.set(i, d2Var);
    }

    public final void H() {
        this.zzi = k6.f2689n;
    }

    public final void I() {
        this.zzl = k6.f2689n;
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzu, "\u0004\u0011\u0000\u0001\u0001\u0013\u0011\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005\u000eဈ\u0006\u000fဉ\u0007\u0010ဉ\b\u0011ဉ\t\u0012ဉ\n\u0013ဉ\u000b", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", j2.class, "zzh", d2.class, "zzi", m1.class, "zzj", "zzk", "zzl", v3.class, "zzm", b2.class, "zzn", "zzo", "zzp", "zzq", "zzr", "zzs", "zzt"});
        }
        if (i6 == 3) {
            return new f2();
        }
        if (i6 == 4) {
            return new e2(zzu);
        }
        if (i6 == 5) {
            return zzu;
        }
        throw null;
    }

    public final boolean o() {
        return (this.zzb & 1) != 0;
    }

    public final long p() {
        return this.zzd;
    }

    public final boolean q() {
        return (this.zzb & 2) != 0;
    }

    public final String r() {
        return this.zze;
    }

    public final q5 s() {
        return this.zzg;
    }

    public final int t() {
        return this.zzh.size();
    }

    public final d2 u(int i) {
        return (d2) this.zzh.get(i);
    }

    public final q5 v() {
        return this.zzi;
    }

    public final q5 w() {
        return this.zzl;
    }

    public final int x() {
        return this.zzl.size();
    }

    public final List y() {
        return this.zzm;
    }

    public final String z() {
        return this.zzn;
    }
}
