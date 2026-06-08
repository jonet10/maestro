package j$.time;

import androidx.core.location.LocationRequestCompat;
import j$.time.format.DateTimeFormatter;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class Instant implements j$.time.temporal.m, j$.time.temporal.o, Comparable<Instant>, Serializable {
    private static final long serialVersionUID = -665713676816604388L;

    /* renamed from: a, reason: collision with root package name */
    public final long f5737a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5738b;

    /* renamed from: c, reason: collision with root package name */
    public static final Instant f5736c = new Instant(0, 0);
    public static final Instant MIN = w(-31557014167219200L, 0);
    public static final Instant MAX = w(31556889864403199L, 999999999);

    @Override // java.lang.Comparable
    public final int compareTo(Instant instant) {
        Instant instant2 = instant;
        int compare = Long.compare(this.f5737a, instant2.f5737a);
        return compare != 0 ? compare : this.f5738b - instant2.f5738b;
    }

    public static Instant w(long j, long j6) {
        return v(j$.com.android.tools.r8.a.x(j, j$.com.android.tools.r8.a.B(j6, 1000000000L)), (int) j$.com.android.tools.r8.a.A(j6, 1000000000L));
    }

    public static Instant ofEpochMilli(long j) {
        long j6 = 1000;
        return v(j$.com.android.tools.r8.a.B(j, j6), ((int) j$.com.android.tools.r8.a.A(j, j6)) * 1000000);
    }

    public static Instant v(long j, int i) {
        if ((i | j) == 0) {
            return f5736c;
        }
        if (j < -31557014167219200L || j > 31556889864403199L) {
            throw new b("Instant exceeds minimum or maximum instant");
        }
        return new Instant(j, i);
    }

    public Instant(long j, int i) {
        this.f5737a = j;
        this.f5738b = i;
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.NANO_OF_SECOND || qVar == j$.time.temporal.a.MICRO_OF_SECOND || qVar == j$.time.temporal.a.MILLI_OF_SECOND : qVar != null && qVar.e(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return j$.time.temporal.r.d(this, qVar).a(qVar.g(this), qVar);
        }
        int i = e.f5814a[((j$.time.temporal.a) qVar).ordinal()];
        if (i == 1) {
            return this.f5738b;
        }
        if (i == 2) {
            return this.f5738b / 1000;
        }
        if (i == 3) {
            return this.f5738b / 1000000;
        }
        if (i == 4) {
            j$.time.temporal.a aVar = j$.time.temporal.a.INSTANT_SECONDS;
            aVar.f5898b.a(this.f5737a, aVar);
        }
        throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        int i;
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        int i6 = e.f5814a[((j$.time.temporal.a) qVar).ordinal()];
        if (i6 == 1) {
            i = this.f5738b;
        } else if (i6 == 2) {
            i = this.f5738b / 1000;
        } else {
            if (i6 != 3) {
                if (i6 == 4) {
                    return this.f5737a;
                }
                throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
            }
            i = this.f5738b / 1000000;
        }
        return i;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (Instant) qVar.j(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.k(j);
        int i = e.f5814a[aVar.ordinal()];
        if (i != 1) {
            if (i == 2) {
                int i6 = ((int) j) * 1000;
                if (i6 != this.f5738b) {
                    return v(this.f5737a, i6);
                }
            } else if (i == 3) {
                int i10 = ((int) j) * 1000000;
                if (i10 != this.f5738b) {
                    return v(this.f5737a, i10);
                }
            } else {
                if (i != 4) {
                    throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
                }
                if (j != this.f5737a) {
                    return v(j, this.f5738b);
                }
            }
        } else if (j != this.f5738b) {
            return v(this.f5737a, (int) j);
        }
        return this;
    }

    @Override // j$.time.temporal.m
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public final Instant b(long j, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (Instant) sVar.e(this, j);
        }
        switch (e.f5815b[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return x(0L, j);
            case 2:
                return x(j / 1000000, (j % 1000000) * 1000);
            case 3:
                return x(j / 1000, (j % 1000) * 1000000);
            case 4:
                return x(j, 0L);
            case 5:
                return x(j$.com.android.tools.r8.a.w(j, 60), 0L);
            case 6:
                return x(j$.com.android.tools.r8.a.w(j, 3600), 0L);
            case 7:
                return x(j$.com.android.tools.r8.a.w(j, 43200), 0L);
            case 8:
                return x(j$.com.android.tools.r8.a.w(j, 86400), 0L);
            default:
                g.b(sVar, "Unsupported unit: ");
                return null;
        }
    }

    public final Instant x(long j, long j6) {
        if ((j | j6) == 0) {
            return this;
        }
        return w(j$.com.android.tools.r8.a.x(j$.com.android.tools.r8.a.x(this.f5737a, j), j6 / 1000000000), this.f5738b + (j6 % 1000000000));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j, j$.time.temporal.b bVar) {
        return j == Long.MIN_VALUE ? b(LocationRequestCompat.PASSIVE_INTERVAL, bVar).b(1L, bVar) : b(-j, bVar);
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        if (aVar == j$.time.temporal.r.f5918c) {
            return j$.time.temporal.b.NANOS;
        }
        if (aVar == j$.time.temporal.r.f5917b || aVar == j$.time.temporal.r.f5916a || aVar == j$.time.temporal.r.f5920e || aVar == j$.time.temporal.r.f5919d || aVar == j$.time.temporal.r.f || aVar == j$.time.temporal.r.g) {
            return null;
        }
        return aVar.a(this);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return mVar.a(this.f5737a, j$.time.temporal.a.INSTANT_SECONDS).a(this.f5738b, j$.time.temporal.a.NANO_OF_SECOND);
    }

    public OffsetDateTime atOffset(ZoneOffset zoneOffset) {
        return OffsetDateTime.v(this, zoneOffset);
    }

    public long toEpochMilli() {
        long j = this.f5737a;
        if (j < 0 && this.f5738b > 0) {
            return j$.com.android.tools.r8.a.x(j$.com.android.tools.r8.a.w(j + 1, 1000), (this.f5738b / 1000000) - 1000);
        }
        return j$.com.android.tools.r8.a.x(j$.com.android.tools.r8.a.w(j, 1000), this.f5738b / 1000000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Instant) {
            Instant instant = (Instant) obj;
            if (this.f5737a == instant.f5737a && this.f5738b == instant.f5738b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.f5737a;
        return (this.f5738b * 51) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        return DateTimeFormatter.f5818e.a(this);
    }

    private Object writeReplace() {
        return new s((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m f(h hVar) {
        return (Instant) j$.com.android.tools.r8.a.a(hVar, this);
    }
}
