package j$.time.format;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class g extends i {
    public final boolean g;

    public g(j$.time.temporal.q qVar, int i, int i6, boolean z9, int i10) {
        super(qVar, i, i6, u.NOT_NEGATIVE, i10);
        this.g = z9;
    }

    @Override // j$.time.format.i
    public final i a() {
        if (this.f5835e == -1) {
            return this;
        }
        return new g(this.f5831a, this.f5832b, this.f5833c, this.g, -1);
    }

    @Override // j$.time.format.i
    public final i b(int i) {
        return new g(this.f5831a, this.f5832b, this.f5833c, this.g, this.f5835e + i);
    }

    @Override // j$.time.format.i, j$.time.format.f
    public final boolean e(p pVar, StringBuilder sb) {
        j$.time.temporal.q qVar = this.f5831a;
        Long a8 = pVar.a(qVar);
        if (a8 == null) {
            return false;
        }
        s sVar = pVar.f5857b.f5821c;
        long longValue = a8.longValue();
        j$.time.temporal.u range = qVar.range();
        range.b(longValue, qVar);
        BigDecimal valueOf = BigDecimal.valueOf(range.f5921a);
        BigDecimal add = BigDecimal.valueOf(range.f5924d).subtract(valueOf).add(BigDecimal.ONE);
        BigDecimal subtract = BigDecimal.valueOf(longValue).subtract(valueOf);
        RoundingMode roundingMode = RoundingMode.FLOOR;
        BigDecimal divide = subtract.divide(add, 9, roundingMode);
        BigDecimal bigDecimal = BigDecimal.ZERO;
        if (divide.compareTo(bigDecimal) != 0) {
            bigDecimal = divide.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : divide.stripTrailingZeros();
        }
        int scale = bigDecimal.scale();
        boolean z9 = this.g;
        int i = this.f5832b;
        if (scale != 0) {
            String substring = bigDecimal.setScale(Math.min(Math.max(bigDecimal.scale(), i), this.f5833c), roundingMode).toPlainString().substring(2);
            sVar.getClass();
            if (z9) {
                sb.append('.');
            }
            sb.append(substring);
            return true;
        }
        if (i > 0) {
            if (z9) {
                sVar.getClass();
                sb.append('.');
            }
            for (int i6 = 0; i6 < i; i6++) {
                sVar.getClass();
                sb.append('0');
            }
        }
        return true;
    }

    @Override // j$.time.format.i
    public final String toString() {
        return "Fraction(" + this.f5831a + "," + this.f5832b + "," + this.f5833c + (this.g ? ",DecimalPoint" : "") + ")";
    }
}
