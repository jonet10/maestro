package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x1 extends l5 {
    private static final x1 zzg;
    private int zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        x1 x1Var = new x1();
        zzg = x1Var;
        l5.l(x1.class, x1Var);
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzg, "\u0004\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001\u0003᠌\u0002", new Object[]{"zzb", "zzd", s1.f2794e, "zze", s1.f2793d, "zzf", s1.f});
        }
        if (i6 == 3) {
            return new x1();
        }
        if (i6 == 4) {
            return new r1(zzg);
        }
        if (i6 == 5) {
            return zzg;
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
        int i;
        int i6 = this.zze;
        if (i6 != 0) {
            i = 2;
            if (i6 != 1) {
                i = i6 != 2 ? 0 : 3;
            }
        } else {
            i = 1;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public final int q() {
        int i;
        int i6 = this.zzf;
        if (i6 != 0) {
            i = 2;
            if (i6 != 1) {
                i = i6 != 2 ? 0 : 3;
            }
        } else {
            i = 1;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }
}
