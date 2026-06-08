package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t2 extends l5 {
    private static final t2 zzh;
    private int zzb;
    private int zzd;
    private m3 zze;
    private m3 zzf;
    private boolean zzg;

    static {
        t2 t2Var = new t2();
        zzh = t2Var;
        l5.l(t2.class, t2Var);
    }

    public static s2 v() {
        return (s2) zzh.g();
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        }
        if (i6 == 3) {
            return new t2();
        }
        if (i6 == 4) {
            return new s2(zzh);
        }
        if (i6 == 5) {
            return zzh;
        }
        throw null;
    }

    public final boolean o() {
        return (this.zzb & 1) != 0;
    }

    public final int p() {
        return this.zzd;
    }

    public final m3 q() {
        m3 m3Var = this.zze;
        return m3Var == null ? m3.x() : m3Var;
    }

    public final boolean r() {
        return (this.zzb & 4) != 0;
    }

    public final m3 s() {
        m3 m3Var = this.zzf;
        return m3Var == null ? m3.x() : m3Var;
    }

    public final boolean t() {
        return (this.zzb & 8) != 0;
    }

    public final boolean u() {
        return this.zzg;
    }

    public final /* synthetic */ void w(int i) {
        this.zzb |= 1;
        this.zzd = i;
    }

    public final /* synthetic */ void x(m3 m3Var) {
        this.zze = m3Var;
        this.zzb |= 2;
    }

    public final /* synthetic */ void y(m3 m3Var) {
        this.zzf = m3Var;
        this.zzb |= 4;
    }

    public final /* synthetic */ void z(boolean z9) {
        this.zzb |= 8;
        this.zzg = z9;
    }
}
