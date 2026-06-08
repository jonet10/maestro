package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e3 extends l5 {
    private static final e3 zzj;
    private int zzb;
    private long zzf;
    private float zzg;
    private double zzh;
    private String zzd = "";
    private String zze = "";
    private q5 zzi = k6.f2689n;

    static {
        e3 e3Var = new e3();
        zzj = e3Var;
        l5.l(e3.class, e3Var);
    }

    public static d3 A() {
        return (d3) zzj.g();
    }

    public final /* synthetic */ void B(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zzd = str;
    }

    public final /* synthetic */ void C(String str) {
        str.getClass();
        this.zzb |= 2;
        this.zze = str;
    }

    public final /* synthetic */ void D() {
        this.zzb &= -3;
        this.zze = zzj.zze;
    }

    public final /* synthetic */ void E(long j) {
        this.zzb |= 4;
        this.zzf = j;
    }

    public final /* synthetic */ void F() {
        this.zzb &= -5;
        this.zzf = 0L;
    }

    public final /* synthetic */ void G(double d10) {
        this.zzb |= 16;
        this.zzh = d10;
    }

    public final /* synthetic */ void H() {
        this.zzb &= -17;
        this.zzh = 0.0d;
    }

    public final void I(e3 e3Var) {
        q5 q5Var = this.zzi;
        if (!((t4) q5Var).f2807a) {
            int size = q5Var.size();
            this.zzi = q5Var.j(size + size);
        }
        this.zzi.add(e3Var);
    }

    public final void J(ArrayList arrayList) {
        q5 q5Var = this.zzi;
        if (!((t4) q5Var).f2807a) {
            int size = q5Var.size();
            this.zzi = q5Var.j(size + size);
        }
        s4.c(arrayList, this.zzi);
    }

    public final void K() {
        this.zzi = k6.f2689n;
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zzb", "zzd", "zze", "zzf", "zzg", "zzh", "zzi", e3.class});
        }
        if (i6 == 3) {
            return new e3();
        }
        if (i6 == 4) {
            return new d3(zzj);
        }
        if (i6 == 5) {
            return zzj;
        }
        throw null;
    }

    public final boolean o() {
        return (this.zzb & 1) != 0;
    }

    public final String p() {
        return this.zzd;
    }

    public final boolean q() {
        return (this.zzb & 2) != 0;
    }

    public final String r() {
        return this.zze;
    }

    public final boolean s() {
        return (this.zzb & 4) != 0;
    }

    public final long t() {
        return this.zzf;
    }

    public final boolean u() {
        return (this.zzb & 8) != 0;
    }

    public final float v() {
        return this.zzg;
    }

    public final boolean w() {
        return (this.zzb & 16) != 0;
    }

    public final double x() {
        return this.zzh;
    }

    public final List y() {
        return this.zzi;
    }

    public final int z() {
        return this.zzi.size();
    }
}
