package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a2 extends l5 {
    private static final a2 zzi;
    private int zzb;
    private q5 zzd;
    private q5 zze;
    private q5 zzf;
    private boolean zzg;
    private q5 zzh;

    static {
        a2 a2Var = new a2();
        zzi = a2Var;
        l5.l(a2.class, a2Var);
    }

    public a2() {
        k6 k6Var = k6.f2689n;
        this.zzd = k6Var;
        this.zze = k6Var;
        this.zzf = k6Var;
        this.zzh = k6Var;
    }

    public static a2 u() {
        return zzi;
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001b\u0002\u001b\u0003\u001b\u0004ဇ\u0000\u0005\u001b", new Object[]{"zzb", "zzd", x1.class, "zze", y1.class, "zzf", z1.class, "zzg", "zzh", x1.class});
        }
        if (i6 == 3) {
            return new a2();
        }
        if (i6 == 4) {
            return new r1(zzi);
        }
        if (i6 == 5) {
            return zzi;
        }
        throw null;
    }

    public final List o() {
        return this.zzd;
    }

    public final List p() {
        return this.zze;
    }

    public final List q() {
        return this.zzf;
    }

    public final boolean r() {
        return (this.zzb & 1) != 0;
    }

    public final boolean s() {
        return this.zzg;
    }

    public final q5 t() {
        return this.zzh;
    }
}
