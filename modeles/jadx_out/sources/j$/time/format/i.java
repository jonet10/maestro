package j$.time.format;

import androidx.work.WorkRequest;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class i implements f {
    public static final long[] f = {0, 10, 100, 1000, WorkRequest.MIN_BACKOFF_MILLIS, 100000, 1000000, 10000000, 100000000, 1000000000, 10000000000L};

    /* renamed from: a, reason: collision with root package name */
    public final j$.time.temporal.q f5831a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5832b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5833c;

    /* renamed from: d, reason: collision with root package name */
    public final u f5834d;

    /* renamed from: e, reason: collision with root package name */
    public final int f5835e;

    public i(j$.time.temporal.q qVar, int i, int i6, u uVar) {
        this.f5831a = qVar;
        this.f5832b = i;
        this.f5833c = i6;
        this.f5834d = uVar;
        this.f5835e = 0;
    }

    public i(j$.time.temporal.q qVar, int i, int i6, u uVar, int i10) {
        this.f5831a = qVar;
        this.f5832b = i;
        this.f5833c = i6;
        this.f5834d = uVar;
        this.f5835e = i10;
    }

    public i a() {
        if (this.f5835e == -1) {
            return this;
        }
        return new i(this.f5831a, this.f5832b, this.f5833c, this.f5834d, -1);
    }

    public i b(int i) {
        return new i(this.f5831a, this.f5832b, this.f5833c, this.f5834d, this.f5835e + i);
    }

    @Override // j$.time.format.f
    public boolean e(p pVar, StringBuilder sb) {
        j$.time.temporal.q qVar = this.f5831a;
        Long a8 = pVar.a(qVar);
        if (a8 == null) {
            return false;
        }
        long longValue = a8.longValue();
        s sVar = pVar.f5857b.f5821c;
        String l10 = longValue == Long.MIN_VALUE ? "9223372036854775808" : Long.toString(Math.abs(longValue));
        int length = l10.length();
        int i = this.f5833c;
        if (length > i) {
            throw new j$.time.b("Field " + qVar + " cannot be printed as the value " + longValue + " exceeds the maximum print width of " + i);
        }
        sVar.getClass();
        int i6 = this.f5832b;
        u uVar = this.f5834d;
        if (longValue >= 0) {
            int i10 = c.f5826a[uVar.ordinal()];
            if (i10 != 1) {
                if (i10 == 2) {
                    sb.append('+');
                }
            } else if (i6 < 19 && longValue >= f[i6]) {
                sb.append('+');
            }
        } else {
            int i11 = c.f5826a[uVar.ordinal()];
            if (i11 == 1 || i11 == 2 || i11 == 3) {
                sb.append('-');
            } else if (i11 == 4) {
                throw new j$.time.b("Field " + qVar + " cannot be printed as the value " + longValue + " cannot be negative according to the SignStyle");
            }
        }
        for (int i12 = 0; i12 < i6 - l10.length(); i12++) {
            sb.append('0');
        }
        sb.append(l10);
        return true;
    }

    public String toString() {
        int i = this.f5833c;
        j$.time.temporal.q qVar = this.f5831a;
        u uVar = this.f5834d;
        int i6 = this.f5832b;
        if (i6 == 1 && i == 19 && uVar == u.NORMAL) {
            return "Value(" + qVar + ")";
        }
        if (i6 == i && uVar == u.NOT_NEGATIVE) {
            return "Value(" + qVar + "," + i6 + ")";
        }
        return "Value(" + qVar + "," + i6 + "," + i + "," + uVar + ")";
    }
}
