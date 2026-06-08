package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w2 extends l5 {
    private static final w2 zzf;
    private int zzb;
    private int zzd;
    private int zze;

    static {
        w2 w2Var = new w2();
        zzf = w2Var;
        l5.l(w2.class, w2Var);
    }

    public static v2 o() {
        return (v2) zzf.g();
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001᠌\u0000\u0002᠌\u0001", new Object[]{"zzb", "zzd", s1.h, "zze", s1.i});
        }
        if (i6 == 3) {
            return new w2();
        }
        if (i6 == 4) {
            return new v2(zzf);
        }
        if (i6 == 5) {
            return zzf;
        }
        throw null;
    }

    public final int p() {
        int i;
        int i6 = this.zzd;
        if (i6 != 0) {
            i = 2;
            if (i6 != 1) {
                if (i6 != 2) {
                    i = 4;
                    if (i6 != 3) {
                        i = i6 != 4 ? 0 : 5;
                    }
                } else {
                    i = 3;
                }
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

    public final /* synthetic */ void r(int i) {
        this.zzd = i - 1;
        this.zzb |= 1;
    }

    public final /* synthetic */ void s(int i) {
        this.zze = i - 1;
        this.zzb |= 2;
    }
}
