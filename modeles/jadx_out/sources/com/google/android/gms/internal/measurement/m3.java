package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m3 extends l5 {
    private static final m3 zzg;
    private p5 zzb;
    private p5 zzd;
    private q5 zze;
    private q5 zzf;

    static {
        m3 m3Var = new m3();
        zzg = m3Var;
        l5.l(m3.class, m3Var);
    }

    public m3() {
        y5 y5Var = y5.f2916n;
        this.zzb = y5Var;
        this.zzd = y5Var;
        k6 k6Var = k6.f2689n;
        this.zze = k6Var;
        this.zzf = k6Var;
    }

    public static l3 w() {
        return (l3) zzg.g();
    }

    public static m3 x() {
        return zzg;
    }

    public final void A(List list) {
        List list2 = this.zzd;
        if (!((t4) list2).f2807a) {
            int size = list2.size();
            this.zzd = ((y5) list2).j(size + size);
        }
        s4.c(list, this.zzd);
    }

    public final void B() {
        this.zzd = y5.f2916n;
    }

    public final void C(ArrayList arrayList) {
        q5 q5Var = this.zze;
        if (!((t4) q5Var).f2807a) {
            int size = q5Var.size();
            this.zze = q5Var.j(size + size);
        }
        s4.c(arrayList, this.zze);
    }

    public final void D() {
        this.zze = k6.f2689n;
    }

    public final void E(Iterable iterable) {
        q5 q5Var = this.zzf;
        if (!((t4) q5Var).f2807a) {
            int size = q5Var.size();
            this.zzf = q5Var.j(size + size);
        }
        s4.c(iterable, this.zzf);
    }

    public final void F() {
        this.zzf = k6.f2689n;
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzg, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zzb", "zzd", "zze", z2.class, "zzf", o3.class});
        }
        if (i6 == 3) {
            return new m3();
        }
        if (i6 == 4) {
            return new l3(zzg);
        }
        if (i6 == 5) {
            return zzg;
        }
        throw null;
    }

    public final List o() {
        return this.zzb;
    }

    public final int p() {
        return this.zzb.size();
    }

    public final List q() {
        return this.zzd;
    }

    public final int r() {
        return this.zzd.size();
    }

    public final q5 s() {
        return this.zze;
    }

    public final int t() {
        return this.zze.size();
    }

    public final List u() {
        return this.zzf;
    }

    public final int v() {
        return this.zzf.size();
    }

    public final void y(Iterable iterable) {
        List list = this.zzb;
        if (!((t4) list).f2807a) {
            int size = list.size();
            this.zzb = ((y5) list).j(size + size);
        }
        s4.c(iterable, this.zzb);
    }

    public final void z() {
        this.zzb = y5.f2916n;
    }
}
