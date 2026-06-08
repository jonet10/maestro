package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y1 extends l5 {
    private static final y1 zzf;
    private int zzb;
    private int zzd;
    private int zze;

    static {
        y1 y1Var = new y1();
        zzf = y1Var;
        l5.l(y1.class, y1Var);
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            s1 s1Var = s1.f2794e;
            return new l6(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzb", "zzd", s1Var, "zze", s1Var});
        }
        if (i6 == 3) {
            return new y1();
        }
        if (i6 == 4) {
            return new r1(zzf);
        }
        if (i6 == 5) {
            return zzf;
        }
        throw null;
    }

    public final int o() {
        int W = a.a.W(this.zzd);
        if (W == 0) {
            return 1;
        }
        return W;
    }

    public final int p() {
        int W = a.a.W(this.zze);
        if (W == 0) {
            return 1;
        }
        return W;
    }
}
