package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g2 extends l5 {
    private static final g2 zzd;
    private q5 zzb = k6.f2689n;

    static {
        g2 g2Var = new g2();
        zzd = g2Var;
        l5.l(g2.class, g2Var);
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", new Object[]{"zzb"});
        }
        if (i6 == 3) {
            return new g2();
        }
        if (i6 == 4) {
            return new r1(zzd);
        }
        if (i6 == 5) {
            return zzd;
        }
        throw null;
    }
}
