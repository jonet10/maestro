package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o2 extends l5 {
    private static final o2 zzn;
    private int zzb;
    private String zzd;
    private String zze;
    private String zzf;
    private long zzg;
    private String zzh;
    private String zzi;
    private String zzj;
    private long zzk;
    private b6 zzl;
    private b6 zzm;

    static {
        o2 o2Var = new o2();
        zzn = o2Var;
        l5.l(o2.class, o2Var);
    }

    public o2() {
        b6 b6Var = b6.f2516b;
        this.zzl = b6Var;
        this.zzm = b6Var;
        this.zzd = "";
        this.zze = "";
        this.zzf = "";
        this.zzh = "";
        this.zzi = "";
        this.zzj = "";
    }

    public static l2 N() {
        return (l2) zzn.g();
    }

    public static o2 O() {
        return zzn;
    }

    public final String A() {
        return this.zze;
    }

    public final boolean B() {
        return (this.zzb & 4) != 0;
    }

    public final String C() {
        return this.zzf;
    }

    public final boolean D() {
        return (this.zzb & 8) != 0;
    }

    public final long E() {
        return this.zzg;
    }

    public final boolean F() {
        return (this.zzb & 16) != 0;
    }

    public final String G() {
        return this.zzh;
    }

    public final boolean H() {
        return (this.zzb & 32) != 0;
    }

    public final String I() {
        return this.zzi;
    }

    public final boolean J() {
        return (this.zzb & 64) != 0;
    }

    public final String K() {
        return this.zzj;
    }

    public final boolean L() {
        return (this.zzb & 128) != 0;
    }

    public final long M() {
        return this.zzk;
    }

    public final /* synthetic */ void P(String str) {
        this.zzb |= 1;
        this.zzd = str;
    }

    public final /* synthetic */ void Q() {
        this.zzb &= -2;
        this.zzd = zzn.zzd;
    }

    public final /* synthetic */ void R(String str) {
        this.zzb |= 2;
        this.zze = str;
    }

    public final /* synthetic */ void S() {
        this.zzb &= -3;
        this.zze = zzn.zze;
    }

    public final /* synthetic */ void T(String str) {
        this.zzb |= 4;
        this.zzf = str;
    }

    public final /* synthetic */ void U() {
        this.zzb &= -5;
        this.zzf = zzn.zzf;
    }

    public final /* synthetic */ void V(long j) {
        this.zzb |= 8;
        this.zzg = j;
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzn, "\u0004\n\u0000\u0001\u0001\n\n\u0002\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ဈ\u0004\u0006ဈ\u0005\u0007ဈ\u0006\bဂ\u0007\t2\n2", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", "zzl", m2.f2708a, "zzm", n2.f2720a});
        }
        if (i6 == 3) {
            return new o2();
        }
        if (i6 == 4) {
            return new l2(zzn);
        }
        if (i6 == 5) {
            return zzn;
        }
        throw null;
    }

    public final /* synthetic */ void o(String str) {
        this.zzb |= 16;
        this.zzh = str;
    }

    public final /* synthetic */ void p() {
        this.zzb &= -17;
        this.zzh = zzn.zzh;
    }

    public final /* synthetic */ void q(String str) {
        this.zzb |= 32;
        this.zzi = str;
    }

    public final /* synthetic */ void r() {
        this.zzb &= -33;
        this.zzi = zzn.zzi;
    }

    public final /* synthetic */ void s(String str) {
        this.zzb |= 64;
        this.zzj = str;
    }

    public final /* synthetic */ void t() {
        this.zzb &= -65;
        this.zzj = zzn.zzj;
    }

    public final /* synthetic */ void u(long j) {
        this.zzb |= 128;
        this.zzk = j;
    }

    public final b6 v() {
        b6 b6Var = this.zzl;
        if (!b6Var.f2517a) {
            this.zzl = b6Var.a();
        }
        return this.zzl;
    }

    public final b6 w() {
        b6 b6Var = this.zzm;
        if (!b6Var.f2517a) {
            this.zzm = b6Var.a();
        }
        return this.zzm;
    }

    public final boolean x() {
        return (this.zzb & 1) != 0;
    }

    public final String y() {
        return this.zzd;
    }

    public final boolean z() {
        return (this.zzb & 2) != 0;
    }
}
