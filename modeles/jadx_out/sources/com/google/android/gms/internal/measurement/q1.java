package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q1 extends l5 {
    private static final q1 zzh;
    private int zzb;
    private w1 zzd;
    private t1 zze;
    private boolean zzf;
    private String zzg = "";

    static {
        q1 q1Var = new q1();
        zzh = q1Var;
        l5.l(q1.class, q1Var);
    }

    public static q1 w() {
        return zzh;
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        }
        if (i6 == 3) {
            return new q1();
        }
        if (i6 == 4) {
            return new p1(zzh);
        }
        if (i6 == 5) {
            return zzh;
        }
        throw null;
    }

    public final boolean o() {
        return (this.zzb & 1) != 0;
    }

    public final w1 p() {
        w1 w1Var = this.zzd;
        return w1Var == null ? w1.v() : w1Var;
    }

    public final boolean q() {
        return (this.zzb & 2) != 0;
    }

    public final t1 r() {
        t1 t1Var = this.zze;
        return t1Var == null ? t1.x() : t1Var;
    }

    public final boolean s() {
        return (this.zzb & 4) != 0;
    }

    public final boolean t() {
        return this.zzf;
    }

    public final boolean u() {
        return (this.zzb & 8) != 0;
    }

    public final String v() {
        return this.zzg;
    }

    public final /* synthetic */ void x(String str) {
        this.zzb |= 8;
        this.zzg = str;
    }
}
