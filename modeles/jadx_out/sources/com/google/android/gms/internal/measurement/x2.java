package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class x2 extends l5 {
    private static final x2 zzd;
    private q5 zzb = k6.f2689n;

    static {
        x2 x2Var = new x2();
        zzd = x2Var;
        l5.l(x2.class, x2Var);
    }

    public static u2 p() {
        return (u2) zzd.g();
    }

    public static x2 q() {
        return zzd;
    }

    @Override // com.google.android.gms.internal.measurement.l5
    public final Object n(int i) {
        int i6 = i - 1;
        if (i6 == 0) {
            return (byte) 1;
        }
        if (i6 == 2) {
            return new l6(zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzb", w2.class});
        }
        if (i6 == 3) {
            return new x2();
        }
        if (i6 == 4) {
            return new u2(zzd);
        }
        if (i6 == 5) {
            return zzd;
        }
        throw null;
    }

    public final List o() {
        return this.zzb;
    }

    public final void r(ArrayList arrayList) {
        q5 q5Var = this.zzb;
        if (!((t4) q5Var).f2807a) {
            int size = q5Var.size();
            this.zzb = q5Var.j(size + size);
        }
        s4.c(arrayList, this.zzb);
    }
}
