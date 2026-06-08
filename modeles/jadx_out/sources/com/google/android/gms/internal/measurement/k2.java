package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k2 extends l5 {
    private static final k2 zzi;
    private int zzb;
    private int zzg;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";
    private String zzh = "";

    static {
        k2 k2Var = new k2();
        zzi = k2Var;
        l5.l(k2.class, k2Var);
    }

    public static k2 q() {
        return zzi;
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003\u0005ဈ\u0004", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i6 == 3) {
            return new k2();
        }
        if (i6 == 4) {
            return new r1(zzi);
        }
        if (i6 == 5) {
            return zzi;
        }
        throw null;
    }

    public final int o() {
        return this.zzg;
    }

    public final String p() {
        return this.zzh;
    }
}
