package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b3 extends l5 {
    private static final b3 zzj;
    private int zzb;
    private q5 zzd = k6.f2689n;
    private String zze = "";
    private long zzf;
    private long zzg;
    private int zzh;
    private long zzi;

    static {
        b3 b3Var = new b3();
        zzj = b3Var;
        l5.l(b3.class, b3Var);
    }

    public static a3 y() {
        return (a3) zzj.g();
    }

    public final /* synthetic */ void A(e3 e3Var) {
        e3Var.getClass();
        I();
        this.zzd.add(e3Var);
    }

    public final /* synthetic */ void B(Iterable iterable) {
        I();
        s4.c(iterable, this.zzd);
    }

    public final void C() {
        this.zzd = k6.f2689n;
    }

    public final /* synthetic */ void D(int i) {
        I();
        this.zzd.remove(i);
    }

    public final /* synthetic */ void E(String str) {
        str.getClass();
        this.zzb |= 1;
        this.zze = str;
    }

    public final /* synthetic */ void F(long j) {
        this.zzb |= 2;
        this.zzf = j;
    }

    public final /* synthetic */ void G(long j) {
        this.zzb |= 4;
        this.zzg = j;
    }

    public final /* synthetic */ void H(long j) {
        this.zzb |= 16;
        this.zzi = j;
    }

    public final void I() {
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
            return new l6(zzj, "\u0004\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003\u0006ဂ\u0004", new Object[]{"zzb", "zzd", e3.class, "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i6 == 3) {
            return new b3();
        }
        if (i6 == 4) {
            return new a3(zzj);
        }
        if (i6 == 5) {
            return zzj;
        }
        throw null;
    }

    public final List o() {
        return this.zzd;
    }

    public final int p() {
        return this.zzd.size();
    }

    public final e3 q(int i) {
        return (e3) this.zzd.get(i);
    }

    public final String r() {
        return this.zze;
    }

    public final boolean s() {
        return (this.zzb & 2) != 0;
    }

    public final long t() {
        return this.zzf;
    }

    public final boolean u() {
        return (this.zzb & 4) != 0;
    }

    public final long v() {
        return this.zzg;
    }

    public final boolean w() {
        return (this.zzb & 8) != 0;
    }

    public final int x() {
        return this.zzh;
    }

    public final /* synthetic */ void z(int i, e3 e3Var) {
        I();
        this.zzd.set(i, e3Var);
    }
}
