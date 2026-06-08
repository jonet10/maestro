package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class w3 extends l5 {
    private static final w3 zzj;
    private int zzb;
    private int zzd;
    private q5 zze = k6.f2689n;
    private String zzf = "";
    private String zzg = "";
    private boolean zzh;
    private double zzi;

    static {
        w3 w3Var = new w3();
        zzj = w3Var;
        l5.l(w3.class, w3Var);
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001᠌\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zzb", "zzd", s1.f2799o, "zze", w3.class, "zzf", "zzg", "zzh", "zzi"});
        }
        if (i6 == 3) {
            return new w3();
        }
        if (i6 == 4) {
            return new r1(zzj);
        }
        if (i6 == 5) {
            return zzj;
        }
        throw null;
    }

    public final List o() {
        return this.zze;
    }

    public final String p() {
        return this.zzf;
    }

    public final boolean q() {
        return (this.zzb & 4) != 0;
    }

    public final String r() {
        return this.zzg;
    }

    public final boolean s() {
        return (this.zzb & 8) != 0;
    }

    public final boolean t() {
        return this.zzh;
    }

    public final boolean u() {
        return (this.zzb & 16) != 0;
    }

    public final double v() {
        return this.zzi;
    }

    public final int w() {
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
