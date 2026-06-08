package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r2 extends l5 {
    private static final r2 zzk;
    private int zzb;
    private boolean zzd;
    private boolean zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        r2 r2Var = new r2();
        zzk = r2Var;
        l5.l(r2.class, r2Var);
    }

    public static q2 v() {
        return (q2) zzk.g();
    }

    public static r2 w() {
        return zzk;
    }

    public final /* synthetic */ void A(boolean z9) {
        this.zzb |= 8;
        this.zzg = z9;
    }

    public final /* synthetic */ void B(boolean z9) {
        this.zzb |= 16;
        this.zzh = z9;
    }

    public final /* synthetic */ void C(boolean z9) {
        this.zzb |= 32;
        this.zzi = z9;
    }

    public final /* synthetic */ void D(boolean z9) {
        this.zzb |= 64;
        this.zzj = z9;
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzk, "\u0004\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005\u0007ဇ\u0006", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i6 == 3) {
            return new r2();
        }
        if (i6 == 4) {
            return new q2(zzk);
        }
        if (i6 == 5) {
            return zzk;
        }
        throw null;
    }

    public final boolean o() {
        return this.zzd;
    }

    public final boolean p() {
        return this.zze;
    }

    public final boolean q() {
        return this.zzf;
    }

    public final boolean r() {
        return this.zzg;
    }

    public final boolean s() {
        return this.zzh;
    }

    public final boolean t() {
        return this.zzi;
    }

    public final boolean u() {
        return this.zzj;
    }

    public final /* synthetic */ void x(boolean z9) {
        this.zzb |= 1;
        this.zzd = z9;
    }

    public final /* synthetic */ void y(boolean z9) {
        this.zzb |= 2;
        this.zze = z9;
    }

    public final /* synthetic */ void z(boolean z9) {
        this.zzb |= 4;
        this.zzf = z9;
    }
}
