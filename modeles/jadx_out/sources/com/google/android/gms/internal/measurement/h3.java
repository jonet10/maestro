package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h3 extends l5 {
    private static final h3 zzh;
    private int zzb;
    private q5 zzd = k6.f2689n;
    private String zze = "";
    private String zzf = "";
    private int zzg;

    static {
        h3 h3Var = new h3();
        zzh = h3Var;
        l5.l(h3.class, h3Var);
    }

    public static g3 v() {
        return (g3) zzh.g();
    }

    public static g3 w(h3 h3Var) {
        k5 g = zzh.g();
        g.e(h3Var);
        return (g3) g;
    }

    public final void A() {
        this.zzd = k6.f2689n;
    }

    public final /* synthetic */ void B(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void C(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zzf = str;
    }

    public final void D() {
        q5 q5Var = this.zzd;
        if (((t4) q5Var).f2807a) {
            return;
        }
        int size = q5Var.size();
        this.zzd = q5Var.j(size + size);
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzh, "\u0004\u0004\u0000\u0001\u0001\t\u0004\u0000\u0001\u0000\u0001\u001b\u0007ဈ\u0000\bဈ\u0001\t᠌\u0002", new Object[]{"zzb", "zzd", j3.class, "zze", "zzf", "zzg", s1.j});
        }
        if (i6 == 3) {
            return new h3();
        }
        if (i6 == 4) {
            return new g3(zzh);
        }
        if (i6 == 5) {
            return zzh;
        }
        throw null;
    }

    public final List o() {
        return this.zzd;
    }

    public final int p() {
        return this.zzd.size();
    }

    public final j3 q(int i) {
        return (j3) this.zzd.get(i);
    }

    public final boolean r() {
        return (this.zzb & 1) != 0;
    }

    public final String s() {
        return this.zze;
    }

    public final boolean t() {
        return (this.zzb & 2) != 0;
    }

    public final String u() {
        return this.zzf;
    }

    public final /* synthetic */ void x(int i, j3 j3Var) {
        D();
        this.zzd.set(i, j3Var);
    }

    public final /* synthetic */ void y(j3 j3Var) {
        D();
        this.zzd.add(j3Var);
    }

    public final /* synthetic */ void z(ArrayList arrayList) {
        D();
        s4.c(arrayList, this.zzd);
    }
}
