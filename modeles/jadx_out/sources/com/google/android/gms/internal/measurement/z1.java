package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class z1 extends l5 {
    private static final z1 zzf;
    private int zzb;
    private String zzd = "";
    private String zze = "";

    static {
        z1 z1Var = new z1();
        zzf = z1Var;
        l5.l(z1.class, z1Var);
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i6 == 3) {
            return new z1();
        }
        if (i6 == 4) {
            return new r1(zzf);
        }
        if (i6 == 5) {
            return zzf;
        }
        throw null;
    }

    public final String o() {
        return this.zzd;
    }
}
