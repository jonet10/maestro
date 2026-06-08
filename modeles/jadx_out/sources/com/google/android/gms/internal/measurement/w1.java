package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w1 extends l5 {
    private static final w1 zzh;
    private int zzb;
    private int zzd;
    private boolean zzf;
    private String zze = "";
    private q5 zzg = k6.f2689n;

    static {
        w1 w1Var = new w1();
        zzh = w1Var;
        l5.l(w1.class, w1Var);
    }

    public static w1 v() {
        return zzh;
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001᠌\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zzb", "zzd", s1.f2792c, "zze", "zzf", "zzg"});
        }
        if (i6 == 3) {
            return new w1();
        }
        if (i6 == 4) {
            return new r1(zzh);
        }
        if (i6 == 5) {
            return zzh;
        }
        throw null;
    }

    public final boolean o() {
        return (this.zzb & 1) != 0;
    }

    public final boolean p() {
        return (this.zzb & 2) != 0;
    }

    public final String q() {
        return this.zze;
    }

    public final boolean r() {
        return (this.zzb & 4) != 0;
    }

    public final boolean s() {
        return this.zzf;
    }

    public final q5 t() {
        return this.zzg;
    }

    public final int u() {
        return this.zzg.size();
    }

    public final int w() {
        int i;
        switch (this.zzd) {
            case 0:
                i = 1;
                break;
            case 1:
                i = 2;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 7;
                break;
            default:
                i = 0;
                break;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }
}
