package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d2 extends l5 {
    private static final d2 zzh;
    private int zzb;
    private String zzd = "";
    private boolean zze;
    private boolean zzf;
    private int zzg;

    static {
        d2 d2Var = new d2();
        zzh = d2Var;
        l5.l(d2.class, d2Var);
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzh, "\u0004\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg"});
        }
        if (i6 == 3) {
            return new d2();
        }
        if (i6 == 4) {
            return new c2(zzh);
        }
        if (i6 == 5) {
            return zzh;
        }
        throw null;
    }

    public final String o() {
        return this.zzd;
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

    public final boolean s() {
        return this.zzf;
    }

    public final boolean t() {
        return (this.zzb & 8) != 0;
    }

    public final int u() {
        return this.zzg;
    }

    public final /* synthetic */ void v(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zzd = str;
    }
}
