package com.google.android.gms.internal.measurement;

import androidx.exifinterface.media.ExifInterface;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class g implements n {

    /* renamed from: a, reason: collision with root package name */
    public final Double f2589a;

    public g(Double d10) {
        if (d10 == null) {
            this.f2589a = Double.valueOf(Double.NaN);
        } else {
            this.f2589a = d10;
        }
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Iterator b() {
        return null;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Boolean e() {
        Double d10 = this.f2589a;
        boolean z9 = false;
        if (!Double.isNaN(d10.doubleValue()) && d10.doubleValue() != 0.0d) {
            z9 = true;
        }
        return Boolean.valueOf(z9);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof g) {
            return this.f2589a.equals(((g) obj).f2589a);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final String f() {
        Double d10 = this.f2589a;
        if (Double.isNaN(d10.doubleValue())) {
            return "NaN";
        }
        if (Double.isInfinite(d10.doubleValue())) {
            return d10.doubleValue() > 0.0d ? "Infinity" : "-Infinity";
        }
        BigDecimal valueOf = BigDecimal.valueOf(d10.doubleValue());
        BigDecimal bigDecimal = valueOf.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : valueOf.stripTrailingZeros();
        DecimalFormat decimalFormat = new DecimalFormat("0E0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.setMinimumFractionDigits((bigDecimal.scale() > 0 ? bigDecimal.precision() : bigDecimal.scale()) - 1);
        String format = decimalFormat.format(bigDecimal);
        int indexOf = format.indexOf(ExifInterface.LONGITUDE_EAST);
        if (indexOf <= 0) {
            return format;
        }
        int parseInt = Integer.parseInt(format.substring(indexOf + 1));
        return ((parseInt >= 0 || parseInt <= -7) && (parseInt < 0 || parseInt >= 21)) ? format.replace("E-", "e-").replace(ExifInterface.LONGITUDE_EAST, "e+") : bigDecimal.toPlainString();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final Double g() {
        return this.f2589a;
    }

    public final int hashCode() {
        return this.f2589a.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n k(String str, y2.s sVar, ArrayList arrayList) {
        if ("toString".equals(str)) {
            return new q(f());
        }
        throw new IllegalArgumentException(f() + "." + str + " is not a function.");
    }

    @Override // com.google.android.gms.internal.measurement.n
    public final n l() {
        return new g(this.f2589a);
    }

    public final String toString() {
        return f();
    }
}
