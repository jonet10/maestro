package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class OffsetDateTime implements j$.time.temporal.m, j$.time.temporal.o, Comparable<OffsetDateTime>, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f5743c = 0;
    private static final long serialVersionUID = 2287754244819255394L;

    /* renamed from: a, reason: collision with root package name */
    public final LocalDateTime f5744a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset f5745b;

    @Override // java.lang.Comparable
    public final int compareTo(OffsetDateTime offsetDateTime) {
        int compare;
        OffsetDateTime offsetDateTime2 = offsetDateTime;
        if (this.f5745b.equals(offsetDateTime2.f5745b)) {
            compare = toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime());
        } else {
            LocalDateTime localDateTime = this.f5744a;
            ZoneOffset zoneOffset = this.f5745b;
            localDateTime.getClass();
            long t9 = j$.com.android.tools.r8.a.t(localDateTime, zoneOffset);
            LocalDateTime localDateTime2 = offsetDateTime2.f5744a;
            ZoneOffset zoneOffset2 = offsetDateTime2.f5745b;
            localDateTime2.getClass();
            compare = Long.compare(t9, j$.com.android.tools.r8.a.t(localDateTime2, zoneOffset2));
            if (compare == 0) {
                compare = this.f5744a.f5742b.f5876d - offsetDateTime2.f5744a.f5742b.f5876d;
            }
        }
        return compare == 0 ? toLocalDateTime().compareTo(offsetDateTime2.toLocalDateTime()) : compare;
    }

    static {
        LocalDateTime localDateTime = LocalDateTime.f5739c;
        ZoneOffset zoneOffset = ZoneOffset.g;
        localDateTime.getClass();
        new OffsetDateTime(localDateTime, zoneOffset);
        LocalDateTime localDateTime2 = LocalDateTime.f5740d;
        ZoneOffset zoneOffset2 = ZoneOffset.f;
        localDateTime2.getClass();
        new OffsetDateTime(localDateTime2, zoneOffset2);
    }

    public static OffsetDateTime v(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        ZoneOffset d10 = zoneId.v().d(instant);
        return new OffsetDateTime(LocalDateTime.z(instant.f5737a, instant.f5738b, d10), d10);
    }

    public OffsetDateTime(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        this.f5744a = (LocalDateTime) Objects.requireNonNull(localDateTime, "dateTime");
        this.f5745b = (ZoneOffset) Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
    }

    public final OffsetDateTime x(LocalDateTime localDateTime, ZoneOffset zoneOffset) {
        return (this.f5744a == localDateTime && this.f5745b.equals(zoneOffset)) ? this : new OffsetDateTime(localDateTime, zoneOffset);
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return true;
        }
        return qVar != null && qVar.e(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar != j$.time.temporal.a.INSTANT_SECONDS && qVar != j$.time.temporal.a.OFFSET_SECONDS) {
                return this.f5744a.g(qVar);
            }
            return ((j$.time.temporal.a) qVar).f5898b;
        }
        return qVar.f(this);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i = p.f5884a[((j$.time.temporal.a) qVar).ordinal()];
            if (i == 1) {
                throw new j$.time.temporal.t("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i == 2) {
                return this.f5745b.f5751b;
            }
            return this.f5744a.e(qVar);
        }
        return j$.time.temporal.r.a(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        int i = p.f5884a[((j$.time.temporal.a) qVar).ordinal()];
        if (i != 1) {
            return i != 2 ? this.f5744a.q(qVar) : this.f5745b.f5751b;
        }
        LocalDateTime localDateTime = this.f5744a;
        ZoneOffset zoneOffset = this.f5745b;
        localDateTime.getClass();
        return j$.com.android.tools.r8.a.t(localDateTime, zoneOffset);
    }

    public LocalDateTime toLocalDateTime() {
        return this.f5744a;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m f(h hVar) {
        LocalDateTime localDateTime = this.f5744a;
        return x(localDateTime.E(hVar, localDateTime.f5742b), this.f5745b);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            int i = p.f5884a[aVar.ordinal()];
            LocalDateTime localDateTime = this.f5744a;
            if (i == 1) {
                return v(Instant.w(j, localDateTime.f5742b.f5876d), this.f5745b);
            }
            if (i == 2) {
                return x(localDateTime, ZoneOffset.C(aVar.f5898b.a(j, aVar)));
            }
            return x(localDateTime.a(j, qVar), this.f5745b);
        }
        return (OffsetDateTime) qVar.j(this, j);
    }

    @Override // j$.time.temporal.m
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final OffsetDateTime b(long j, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            return x(this.f5744a.b(j, sVar), this.f5745b);
        }
        return (OffsetDateTime) sVar.e(this, j);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j, j$.time.temporal.b bVar) {
        return j == Long.MIN_VALUE ? b(LocationRequestCompat.PASSIVE_INTERVAL, bVar).b(1L, bVar) : b(-j, bVar);
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        if (aVar == j$.time.temporal.r.f5919d || aVar == j$.time.temporal.r.f5920e) {
            return this.f5745b;
        }
        if (aVar == j$.time.temporal.r.f5916a) {
            return null;
        }
        if (aVar == j$.time.temporal.r.f) {
            return this.f5744a.f5741a;
        }
        if (aVar == j$.time.temporal.r.g) {
            return this.f5744a.f5742b;
        }
        if (aVar == j$.time.temporal.r.f5917b) {
            return j$.time.chrono.s.f5797c;
        }
        if (aVar == j$.time.temporal.r.f5918c) {
            return j$.time.temporal.b.NANOS;
        }
        return aVar.a(this);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return mVar.a(this.f5744a.f5741a.r(), j$.time.temporal.a.EPOCH_DAY).a(this.f5744a.f5742b.G(), j$.time.temporal.a.NANO_OF_DAY).a(this.f5745b.f5751b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OffsetDateTime) {
            OffsetDateTime offsetDateTime = (OffsetDateTime) obj;
            if (this.f5744a.equals(offsetDateTime.f5744a) && this.f5745b.equals(offsetDateTime.f5745b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f5744a.hashCode() ^ this.f5745b.f5751b;
    }

    public final String toString() {
        return this.f5744a.toString() + this.f5745b.f5752c;
    }

    private Object writeReplace() {
        return new s((byte) 10, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
