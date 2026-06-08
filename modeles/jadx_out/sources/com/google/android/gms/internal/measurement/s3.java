package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class s3 extends l5 {
    private static final s3 zzj;
    private int zzb;
    private long zzd;
    private String zze = "";
    private String zzf = "";
    private long zzg;
    private float zzh;
    private double zzi;

    static {
        s3 s3Var = new s3();
        zzj = s3Var;
        l5.l(s3.class, s3Var);
    }

    public static r3 z() {
        return (r3) zzj.g();
    }

    public final /* synthetic */ void A(long j) {
        this.zzb |= 1;
        this.zzd = j;
    }

    public final /* synthetic */ void B(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zze = str;
    }

    public final /* synthetic */ void C(String str) {
        str.getClass();
        this.zzb |= 4;
        this.zzf = str;
    }

    public final /* synthetic */ void D() {
        this.zzb &= -5;
        this.zzf = zzj.zzf;
    }

    public final /* synthetic */ void E(long j) {
        this.zzb |= 8;
        this.zzg = j;
    }

    public final /* synthetic */ void F() {
        this.zzb &= -9;
        this.zzg = 0L;
    }

    public final /* synthetic */ void G(double d10) {
        this.zzb |= 32;
        this.zzi = d10;
    }

    public final /* synthetic */ void H() {
        this.zzb &= -33;
        this.zzi = 0.0d;
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i6 == 3) {
            return new s3();
        }
        if (i6 == 4) {
            return new r3(zzj);
        }
        if (i6 == 5) {
            return zzj;
        }
        throw null;
    }

    public final boolean o() {
        return (this.zzb & 1) != 0;
    }

    public final long p() {
        return this.zzd;
    }

    public final String q() {
        return this.zze;
    }

    public final boolean r() {
        return (this.zzb & 4) != 0;
    }

    public final String s() {
        return this.zzf;
    }

    public final boolean t() {
        return (this.zzb & 8) != 0;
    }

    public final long u() {
        return this.zzg;
    }

    public final boolean v() {
        return (this.zzb & 16) != 0;
    }

    public final float w() {
        return this.zzh;
    }

    public final boolean x() {
        return (this.zzb & 32) != 0;
    }

    public final double y() {
        return this.zzi;
    }
}
