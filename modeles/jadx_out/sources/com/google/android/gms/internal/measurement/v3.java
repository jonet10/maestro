package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class v3 extends l5 {
    private static final v3 zzf;
    private int zzb;
    private q5 zzd = k6.f2689n;
    private t3 zze;

    static {
        v3 v3Var = new v3();
        zzf = v3Var;
        l5.l(v3.class, v3Var);
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zzb", "zzd", w3.class, "zze"});
        }
        if (i6 == 3) {
            return new v3();
        }
        if (i6 == 4) {
            return new r1(zzf);
        }
        if (i6 == 5) {
            return zzf;
        }
        throw null;
    }

    public final List o() {
        return this.zzd;
    }

    public final t3 p() {
        t3 t3Var = this.zze;
        return t3Var == null ? t3.q() : t3Var;
    }
}
