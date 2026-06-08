package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import j$.time.chrono.ChronoZonedDateTime;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.List;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class ZonedDateTime implements j$.time.temporal.m, ChronoZonedDateTime<h>, Serializable {
    private static final long serialVersionUID = -6260982410461394882L;

    /* renamed from: a, reason: collision with root package name */
    public final LocalDateTime f5753a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset f5754b;

    /* renamed from: c, reason: collision with root package name */
    public final ZoneId f5755c;

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final /* synthetic */ long toEpochSecond() {
        return j$.com.android.tools.r8.a.u(this);
    }

    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(ChronoZonedDateTime<?> chronoZonedDateTime) {
        return j$.com.android.tools.r8.a.i(this, chronoZonedDateTime);
    }

    public static ZonedDateTime now() {
        a F = j$.com.android.tools.r8.a.F();
        Objects.requireNonNull(F, "clock");
        return ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), F.f5757a);
    }

    public static ZonedDateTime now(ZoneId zoneId) {
        a aVar;
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId == ZoneOffset.UTC) {
            aVar = a.f5756b;
        } else {
            aVar = new a(zoneId);
        }
        Objects.requireNonNull(aVar, "clock");
        aVar.getClass();
        return ofInstant(Instant.ofEpochMilli(System.currentTimeMillis()), aVar.f5757a);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final j$.time.chrono.l getChronology() {
        return ((h) toLocalDate()).getChronology();
    }

    public static ZonedDateTime of(int i, int i6, int i10, int i11, int i12, int i13, int i14, ZoneId zoneId) {
        LocalDateTime localDateTime = LocalDateTime.f5739c;
        h D = h.D(i, i6, i10);
        j$.time.temporal.a.HOUR_OF_DAY.k(i11);
        j$.time.temporal.a.MINUTE_OF_HOUR.k(i12);
        j$.time.temporal.a.SECOND_OF_MINUTE.k(i13);
        j$.time.temporal.a.NANO_OF_SECOND.k(i14);
        return v(new LocalDateTime(D, k.w(i11, i12, i13, i14)), zoneId, null);
    }

    public static ZonedDateTime v(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        Objects.requireNonNull(localDateTime, "localDateTime");
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId instanceof ZoneOffset) {
            return new ZonedDateTime(localDateTime, zoneId, (ZoneOffset) zoneId);
        }
        j$.time.zone.f v = zoneId.v();
        List f = v.f(localDateTime);
        if (f.size() == 1) {
            zoneOffset = (ZoneOffset) f.get(0);
        } else if (f.size() != 0) {
            if (zoneOffset == null || !f.contains(zoneOffset)) {
                zoneOffset = (ZoneOffset) Objects.requireNonNull((ZoneOffset) f.get(0), TypedValues.CycleType.S_WAVE_OFFSET);
            }
        } else {
            Object e10 = v.e(localDateTime);
            j$.time.zone.b bVar = e10 instanceof j$.time.zone.b ? (j$.time.zone.b) e10 : null;
            localDateTime = localDateTime.B(Duration.e(bVar.f5940d.f5751b - bVar.f5939c.f5751b, 0).f5734a);
            zoneOffset = bVar.f5940d;
        }
        return new ZonedDateTime(localDateTime, zoneId, zoneOffset);
    }

    public static ZonedDateTime ofInstant(Instant instant, ZoneId zoneId) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(zoneId, "zone");
        return j(instant.f5737a, instant.f5738b, zoneId);
    }

    public static ZonedDateTime j(long j, int i, ZoneId zoneId) {
        ZoneOffset d10 = zoneId.v().d(Instant.w(j, i));
        return new ZonedDateTime(LocalDateTime.z(j, i, d10), zoneId, d10);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final Instant toInstant() {
        return Instant.w(toEpochSecond(), toLocalTime().f5876d);
    }

    public ZonedDateTime(LocalDateTime localDateTime, ZoneId zoneId, ZoneOffset zoneOffset) {
        this.f5753a = localDateTime;
        this.f5754b = zoneOffset;
        this.f5755c = zoneId;
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
            if (qVar == j$.time.temporal.a.INSTANT_SECONDS || qVar == j$.time.temporal.a.OFFSET_SECONDS) {
                return ((j$.time.temporal.a) qVar).f5898b;
            }
            return this.f5753a.g(qVar);
        }
        return qVar.f(this);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            int i = x.f5933a[((j$.time.temporal.a) qVar).ordinal()];
            if (i == 1) {
                throw new j$.time.temporal.t("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            }
            if (i == 2) {
                return this.f5754b.f5751b;
            }
            return this.f5753a.e(qVar);
        }
        return j$.com.android.tools.r8.a.k(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        int i = x.f5933a[((j$.time.temporal.a) qVar).ordinal()];
        return i != 1 ? i != 2 ? this.f5753a.q(qVar) : this.f5754b.f5751b : j$.com.android.tools.r8.a.u(this);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneOffset getOffset() {
        return this.f5754b;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ZoneId getZone() {
        return this.f5755c;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final ChronoZonedDateTime m(ZoneId zoneId) {
        Objects.requireNonNull(zoneId, "zone");
        return this.f5755c.equals(zoneId) ? this : v(this.f5753a, zoneId, this.f5754b);
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final j$.time.chrono.e toLocalDateTime() {
        return this.f5753a;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final j$.time.chrono.b toLocalDate() {
        return this.f5753a.f5741a;
    }

    public int getYear() {
        return this.f5753a.f5741a.f5866a;
    }

    public int getMonthValue() {
        return this.f5753a.f5741a.f5867b;
    }

    public int getDayOfMonth() {
        return this.f5753a.f5741a.f5868c;
    }

    @Override // j$.time.chrono.ChronoZonedDateTime
    public final k toLocalTime() {
        return this.f5753a.f5742b;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m f(h hVar) {
        return v(LocalDateTime.y(hVar, this.f5753a.f5742b), this.f5755c, this.f5754b);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m a(long j, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            int i = x.f5933a[aVar.ordinal()];
            if (i == 1) {
                return j(j, this.f5753a.f5742b.f5876d, this.f5755c);
            }
            if (i != 2) {
                return v(this.f5753a.a(j, qVar), this.f5755c, this.f5754b);
            }
            ZoneOffset C = ZoneOffset.C(aVar.f5898b.a(j, aVar));
            return (C.equals(this.f5754b) || !this.f5755c.v().f(this.f5753a).contains(C)) ? this : new ZonedDateTime(this.f5753a, this.f5755c, C);
        }
        return (ZonedDateTime) qVar.j(this, j);
    }

    @Override // j$.time.temporal.m
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final ZonedDateTime b(long j, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (ZonedDateTime) sVar.e(this, j);
        }
        j$.time.temporal.b bVar = (j$.time.temporal.b) sVar;
        if (bVar.compareTo(j$.time.temporal.b.DAYS) >= 0 && bVar != j$.time.temporal.b.FOREVER) {
            return v(this.f5753a.b(j, sVar), this.f5755c, this.f5754b);
        }
        LocalDateTime b7 = this.f5753a.b(j, sVar);
        ZoneOffset zoneOffset = this.f5754b;
        ZoneId zoneId = this.f5755c;
        Objects.requireNonNull(b7, "localDateTime");
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        Objects.requireNonNull(zoneId, "zone");
        if (zoneId.v().f(b7).contains(zoneOffset)) {
            return new ZonedDateTime(b7, zoneId, zoneOffset);
        }
        b7.getClass();
        return j(j$.com.android.tools.r8.a.t(b7, zoneOffset), b7.f5742b.f5876d, zoneId);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j, j$.time.temporal.b bVar) {
        return j == Long.MIN_VALUE ? b(LocationRequestCompat.PASSIVE_INTERVAL, bVar).b(1L, bVar) : b(-j, bVar);
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        if (aVar == j$.time.temporal.r.f) {
            return this.f5753a.f5741a;
        }
        return j$.com.android.tools.r8.a.r(this, aVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZonedDateTime) {
            ZonedDateTime zonedDateTime = (ZonedDateTime) obj;
            if (this.f5753a.equals(zonedDateTime.f5753a) && this.f5754b.equals(zonedDateTime.f5754b) && this.f5755c.equals(zonedDateTime.f5755c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f5753a.hashCode() ^ this.f5754b.f5751b) ^ Integer.rotateLeft(this.f5755c.hashCode(), 3);
    }

    public final String toString() {
        String str = this.f5753a.toString() + this.f5754b.f5752c;
        ZoneOffset zoneOffset = this.f5754b;
        ZoneId zoneId = this.f5755c;
        if (zoneOffset == zoneId) {
            return str;
        }
        return str + "[" + zoneId.toString() + "]";
    }

    private Object writeReplace() {
        return new s((byte) 6, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
