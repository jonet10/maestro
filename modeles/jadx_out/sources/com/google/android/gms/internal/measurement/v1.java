package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v1 extends l5 {
    private static final v1 zzj;
    private int zzb;
    private int zzd;
    private String zze = "";
    private q1 zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    static {
        v1 v1Var = new v1();
        zzj = v1Var;
        l5.l(v1.class, v1Var);
    }

    public static u1 w() {
        return (u1) zzj.g();
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i6 == 3) {
            return new v1();
        }
        if (i6 == 4) {
            return new u1(zzj);
        }
        if (i6 == 5) {
            return zzj;
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

    public final q1 r() {
        q1 q1Var = this.zzf;
        return q1Var == null ? q1.w() : q1Var;
    }

    public final boolean s() {
        return this.zzg;
    }

    public final boolean t() {
        return this.zzh;
    }

    public final boolean u() {
        return (this.zzb & 32) != 0;
    }

    public final boolean v() {
        return this.zzi;
    }

    public final /* synthetic */ void x(String str) {
        this.zzb |= 2;
        this.zze = str;
    }
}
