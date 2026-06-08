package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b2 extends l5 {
    private static final b2 zzg;
    private int zzb;
    private String zzd = "";
    private q5 zze = k6.f2689n;
    private boolean zzf;

    static {
        b2 b2Var = new b2();
        zzg = b2Var;
        l5.l(b2.class, b2Var);
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzb", "zzd", "zze", i2.class, "zzf"});
        }
        if (i6 == 3) {
            return new b2();
        }
        if (i6 == 4) {
            return new r1(zzg);
        }
        if (i6 == 5) {
            return zzg;
        }
        throw null;
    }

    public final String o() {
        return this.zzd;
    }
}
