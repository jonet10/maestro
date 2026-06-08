package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i2 extends l5 {
    private static final i2 zzf;
    private int zzb;
    private String zzd = "";
    private String zze = "";

    static {
        i2 i2Var = new i2();
        zzf = i2Var;
        l5.l(i2.class, i2Var);
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
            return new i2();
        }
        if (i6 == 4) {
            return new r1(zzf);
        }
        if (i6 == 5) {
            return zzf;
        }
        throw null;
    }
}
