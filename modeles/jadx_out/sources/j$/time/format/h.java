package j$.time.format;

import j$.time.LocalDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class h implements f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f5830a;

    public /* synthetic */ h(int i) {
        this.f5830a = i;
    }

    @Override // j$.time.format.f
    public final boolean e(p pVar, StringBuilder sb) {
        switch (this.f5830a) {
            case 0:
                Long a8 = pVar.a(j$.time.temporal.a.INSTANT_SECONDS);
                j$.time.temporal.n nVar = pVar.f5856a;
                j$.time.temporal.a aVar = j$.time.temporal.a.NANO_OF_SECOND;
                Long valueOf = nVar.c(aVar) ? Long.valueOf(nVar.q(aVar)) : null;
                int i = 0;
                if (a8 == null) {
                    return false;
                }
                long longValue = a8.longValue();
                int a10 = aVar.f5898b.a(valueOf != null ? valueOf.longValue() : 0L, aVar);
                if (longValue >= -62167219200L) {
                    long j = longValue - 253402300800L;
                    long B = j$.com.android.tools.r8.a.B(j, 315569520000L) + 1;
                    LocalDateTime z9 = LocalDateTime.z(j$.com.android.tools.r8.a.A(j, 315569520000L) - 62167219200L, 0, ZoneOffset.UTC);
                    if (B > 0) {
                        sb.append('+');
                        sb.append(B);
                    }
                    sb.append(z9);
                    if (z9.f5742b.f5875c == 0) {
                        sb.append(":00");
                    }
                } else {
                    long j6 = longValue + 62167219200L;
                    long j10 = j6 / 315569520000L;
                    long j11 = j6 % 315569520000L;
                    LocalDateTime z10 = LocalDateTime.z(j11 - 62167219200L, 0, ZoneOffset.UTC);
                    int length = sb.length();
                    sb.append(z10);
                    if (z10.f5742b.f5875c == 0) {
                        sb.append(":00");
                    }
                    if (j10 < 0) {
                        if (z10.f5741a.f5866a == -10000) {
                            sb.replace(length, length + 2, Long.toString(j10 - 1));
                        } else if (j11 == 0) {
                            sb.insert(length, j10);
                        } else {
                            sb.insert(length + 1, Math.abs(j10));
                        }
                    }
                }
                if (a10 > 0) {
                    sb.append('.');
                    int i6 = 100000000;
                    while (true) {
                        if (a10 > 0 || i % 3 != 0 || i < -2) {
                            int i10 = a10 / i6;
                            sb.append((char) (i10 + 48));
                            a10 -= i10 * i6;
                            i6 /= 10;
                            i++;
                        }
                    }
                }
                sb.append('Z');
                return true;
            default:
                a aVar2 = n.f;
                j$.time.temporal.n nVar2 = pVar.f5856a;
                Object k5 = nVar2.k(aVar2);
                if (k5 == null && pVar.f5858c == 0) {
                    throw new j$.time.b("Unable to extract " + aVar2 + " from temporal " + nVar2);
                }
                ZoneId zoneId = (ZoneId) k5;
                if (zoneId == null) {
                    return false;
                }
                sb.append(zoneId.d());
                return true;
        }
    }

    public final String toString() {
        switch (this.f5830a) {
            case 0:
                return "Instant()";
            default:
                return "ZoneRegionId()";
        }
    }
}
