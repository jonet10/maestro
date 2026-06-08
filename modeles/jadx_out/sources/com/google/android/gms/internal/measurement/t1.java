package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class t1 extends l5 {
    private static final t1 zzi;
    private int zzb;
    private int zzd;
    private boolean zze;
    private String zzf = "";
    private String zzg = "";
    private String zzh = "";

    static {
        t1 t1Var = new t1();
        zzi = t1Var;
        l5.l(t1.class, t1Var);
    }

    public static t1 x() {
        return zzi;
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zzb", "zzd", s1.f2791b, "zze", "zzf", "zzg", "zzh"});
        }
        if (i6 == 3) {
            return new t1();
        }
        if (i6 == 4) {
            return new r1(zzi);
        }
        if (i6 == 5) {
            return zzi;
        }
        throw null;
    }

    public final boolean o() {
        return (this.zzb & 1) != 0;
    }

    public final boolean p() {
        return (this.zzb & 2) != 0;
    }

    public final boolean q() {
        return this.zze;
    }

    public final boolean r() {
        return (this.zzb & 4) != 0;
    }

    public final String s() {
        return this.zzf;
    }

    public final boolean t() {
        return (this.zzb & 8) != 0;
    }

    public final String u() {
        return this.zzg;
    }

    public final boolean v() {
        return (this.zzb & 16) != 0;
    }

    public final String w() {
        return this.zzh;
    }

    public final int y() {
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
}
