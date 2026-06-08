package j$.time;

import androidx.core.location.LocationRequestCompat;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class Year implements j$.time.temporal.m, j$.time.temporal.o, Comparable<Year>, Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f5746b = 0;
    private static final long serialVersionUID = -23038383694477807L;

    /* renamed from: a, reason: collision with root package name */
    public final int f5747a;

    @Override // java.lang.Comparable
    public final int compareTo(Year year) {
        return this.f5747a - year.f5747a;
    }

    static {
        j$.time.format.n nVar = new j$.time.format.n();
        nVar.h(j$.time.temporal.a.YEAR, 4, 10, j$.time.format.u.EXCEEDS_PAD);
        nVar.l(Locale.getDefault(), j$.time.format.t.SMART, null);
    }

    public static Year now() {
        a F = j$.com.android.tools.r8.a.F();
        h hVar = h.f5864d;
        Objects.requireNonNull(F, "clock");
        Instant ofEpochMilli = Instant.ofEpochMilli(System.currentTimeMillis());
        ZoneId zoneId = F.f5757a;
        Objects.requireNonNull(ofEpochMilli, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return v(h.E(j$.com.android.tools.r8.a.B(ofEpochMilli.f5737a + zoneId.v().d(ofEpochMilli).f5751b, 86400)).f5866a);
    }

    public static Year v(int i) {
        j$.time.temporal.a.YEAR.k(i);
        return new Year(i);
    }

    public Year(int i) {
        this.f5747a = i;
    }

    public int getValue() {
        return this.f5747a;
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.YEAR || qVar == j$.time.temporal.a.YEAR_OF_ERA || qVar == j$.time.temporal.a.ERA : qVar != null && qVar.e(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.YEAR_OF_ERA) {
            return j$.time.temporal.u.e(1L, this.f5747a <= 0 ? 1000000000L : 999999999L);
        }
        return j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        return g(qVar).a(q(qVar), qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        int i = t.f5894a[((j$.time.temporal.a) qVar).ordinal()];
        if (i == 1) {
            int i6 = this.f5747a;
            if (i6 < 1) {
                i6 = 1 - i6;
            }
            return i6;
        }
        if (i == 2) {
            return this.f5747a;
        }
        if (i == 3) {
            return this.f5747a < 1 ? 0 : 1;
        }
        throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
    }

    @Override // j$.time.temporal.m
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public final Year a(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (Year) qVar.j(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.k(j);
        int i = t.f5894a[aVar.ordinal()];
        if (i == 1) {
            if (this.f5747a < 1) {
                j = 1 - j;
            }
            return v((int) j);
        }
        if (i == 2) {
            return v((int) j);
        }
        if (i == 3) {
            return q(j$.time.temporal.a.ERA) == j ? this : v(1 - this.f5747a);
        }
        throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
    }

    @Override // j$.time.temporal.m
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final Year b(long j, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            int i = t.f5895b[((j$.time.temporal.b) sVar).ordinal()];
            if (i == 1) {
                return x(j);
            }
            if (i == 2) {
                return x(j$.com.android.tools.r8.a.w(j, 10));
            }
            if (i == 3) {
                return x(j$.com.android.tools.r8.a.w(j, 100));
            }
            if (i == 4) {
                return x(j$.com.android.tools.r8.a.w(j, 1000));
            }
            if (i == 5) {
                j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                return a(j$.com.android.tools.r8.a.x(q(aVar), j), aVar);
            }
            g.b(sVar, "Unsupported unit: ");
            return null;
        }
        return (Year) sVar.e(this, j);
    }

    public final Year x(long j) {
        if (j == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return v(aVar.f5898b.a(this.f5747a + j, aVar));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j, j$.time.temporal.b bVar) {
        return j == Long.MIN_VALUE ? b(LocationRequestCompat.PASSIVE_INTERVAL, bVar).b(1L, bVar) : b(-j, bVar);
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        if (aVar == j$.time.temporal.r.f5917b) {
            return j$.time.chrono.s.f5797c;
        }
        if (aVar == j$.time.temporal.r.f5918c) {
            return j$.time.temporal.b.YEARS;
        }
        return j$.time.temporal.r.c(this, aVar);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        if (!j$.com.android.tools.r8.a.v(mVar).equals(j$.time.chrono.s.f5797c)) {
            throw new b("Adjustment only supported on ISO date-time");
        }
        return mVar.a(this.f5747a, j$.time.temporal.a.YEAR);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof Year) && this.f5747a == ((Year) obj).f5747a;
    }

    public final int hashCode() {
        return this.f5747a;
    }

    public final String toString() {
        return Integer.toString(this.f5747a);
    }

    private Object writeReplace() {
        return new s((byte) 11, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m f(h hVar) {
        return (Year) j$.com.android.tools.r8.a.a(hVar, this);
    }
}
