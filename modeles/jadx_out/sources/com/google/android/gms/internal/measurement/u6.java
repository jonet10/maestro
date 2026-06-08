package com.google.android.gms.internal.measurement;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class u6 extends v6 {
    @Override // com.google.android.gms.internal.measurement.v6
    public final void a(Object obj, long j, byte b7) {
        if (w6.g) {
            w6.c(obj, j, b7);
        } else {
            w6.d(obj, j, b7);
        }
    }

    @Override // com.google.android.gms.internal.measurement.v6
    public final boolean b(Object obj, long j) {
        return w6.g ? w6.n(obj, j) : w6.o(obj, j);
    }

    @Override // com.google.android.gms.internal.measurement.v6
    public final void c(Object obj, long j, boolean z9) {
        if (w6.g) {
            w6.c(obj, j, z9 ? (byte) 1 : (byte) 0);
        } else {
            w6.d(obj, j, z9 ? (byte) 1 : (byte) 0);
        }
    }

    @Override // com.google.android.gms.internal.measurement.v6
    public final float d(Object obj, long j) {
        return Float.intBitsToFloat(this.f2841a.getInt(obj, j));
    }

    @Override // com.google.android.gms.internal.measurement.v6
    public final void e(Object obj, long j, float f) {
        this.f2841a.putInt(obj, j, Float.floatToIntBits(f));
    }

    @Override // com.google.android.gms.internal.measurement.v6
    public final double f(Object obj, long j) {
        return Double.longBitsToDouble(this.f2841a.getLong(obj, j));
    }

    @Override // com.google.android.gms.internal.measurement.v6
    public final void g(Object obj, long j, double d10) {
        this.f2841a.putLong(obj, j, Double.doubleToLongBits(d10));
    }
}
