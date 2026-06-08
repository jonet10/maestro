package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o3 extends l5 {
    private static final o3 zzf;
    private int zzb;
    private int zzd;
    private p5 zze = y5.f2916n;

    static {
        o3 o3Var = new o3();
        zzf = o3Var;
        l5.l(o3.class, o3Var);
    }

    public static n3 t() {
        return (n3) zzf.g();
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzf, "\u0004\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zzb", "zzd", "zze"});
        }
        if (i6 == 3) {
            return new o3();
        }
        if (i6 == 4) {
            return new n3(zzf);
        }
        if (i6 == 5) {
            return zzf;
        }
        throw null;
    }

    public final boolean o() {
        return (this.zzb & 1) != 0;
    }

    public final int p() {
        return this.zzd;
    }

    public final List q() {
        return this.zze;
    }

    public final int r() {
        return this.zze.size();
    }

    public final long s(int i) {
        return ((y5) this.zze).c(i);
    }

    public final /* synthetic */ void u(int i) {
        this.zzb |= 1;
        this.zzd = i;
    }

    public final void v(List list) {
        List list2 = this.zze;
        if (!((t4) list2).f2807a) {
            int size = list2.size();
            this.zze = ((y5) list2).j(size + size);
        }
        s4.c(list, this.zze);
    }
}
