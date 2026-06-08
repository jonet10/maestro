package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z2 extends l5 {
    private static final z2 zzf;
    private int zzb;
    private int zzd;
    private long zze;

    static {
        z2 z2Var = new z2();
        zzf = z2Var;
        l5.l(z2.class, z2Var);
    }

    public static y2 s() {
        return (y2) zzf.g();
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i6 == 3) {
            return new z2();
        }
        if (i6 == 4) {
            return new y2(zzf);
        }
        if (i6 == 5) {
            return zzf;
        }
        throw null;
    }

    public final boolean o() {
        return (this.zzb & 1) != 0;
    }

    public final int p() {
        return this.zzd;
    }

    public final boolean q() {
        return (this.zzb & 2) != 0;
    }

    public final long r() {
        return this.zze;
    }

    public final /* synthetic */ void t(int i) {
        this.zzb |= 1;
        this.zzd = i;
    }

    public final /* synthetic */ void u(long j) {
        this.zzb |= 2;
        this.zze = j;
    }
}
