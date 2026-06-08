package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.location.LocationRequestCompat;
import androidx.exifinterface.media.ExifInterface;
import j$.time.chrono.ChronoZonedDateTime;
import j$.time.format.DateTimeFormatter;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class LocalDateTime implements j$.time.temporal.m, j$.time.temporal.o, j$.time.chrono.e, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final LocalDateTime f5739c = y(h.f5864d, k.f5872e);

    /* renamed from: d, reason: collision with root package name */
    public static final LocalDateTime f5740d = y(h.f5865e, k.f);
    private static final long serialVersionUID = 6207766400415563566L;

    /* renamed from: a, reason: collision with root package name */
    public final h f5741a;

    /* renamed from: b, reason: collision with root package name */
    public final k f5742b;

    @Override // j$.time.chrono.e
    public final j$.time.chrono.l getChronology() {
        return ((h) toLocalDate()).getChronology();
    }

    @Override // j$.time.chrono.e
    public final ChronoZonedDateTime h(ZoneOffset zoneOffset) {
        return ZonedDateTime.v(this, zoneOffset, null);
    }

    public static LocalDateTime y(h hVar, k kVar) {
        Objects.requireNonNull(hVar, "date");
        Objects.requireNonNull(kVar, "time");
        return new LocalDateTime(hVar, kVar);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return mVar.a(((h) toLocalDate()).r(), j$.time.temporal.a.EPOCH_DAY).a(toLocalTime().G(), j$.time.temporal.a.NANO_OF_DAY);
    }

    public static LocalDateTime z(long j, int i, ZoneOffset zoneOffset) {
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        long j6 = i;
        j$.time.temporal.a.NANO_OF_SECOND.k(j6);
        return new LocalDateTime(h.E(j$.com.android.tools.r8.a.B(j + zoneOffset.f5751b, 86400)), k.z((((int) j$.com.android.tools.r8.a.A(r5, r7)) * 1000000000) + j6));
    }

    public static LocalDateTime w(j$.time.temporal.n nVar) {
        if (nVar instanceof LocalDateTime) {
            return (LocalDateTime) nVar;
        }
        if (!(nVar instanceof ZonedDateTime)) {
            if (nVar instanceof OffsetDateTime) {
                return ((OffsetDateTime) nVar).toLocalDateTime();
            }
            try {
                return new LocalDateTime(h.x(nVar), k.x(nVar));
            } catch (b e10) {
                throw new b("Unable to obtain LocalDateTime from TemporalAccessor: " + nVar + " of type " + nVar.getClass().getName(), e10);
            }
        }
        return ((ZonedDateTime) nVar).f5753a;
    }

    public LocalDateTime(h hVar, k kVar) {
        this.f5741a = hVar;
        this.f5742b = kVar;
    }

    public final LocalDateTime E(h hVar, k kVar) {
        return (this.f5741a == hVar && this.f5742b == kVar) ? this : new LocalDateTime(hVar, kVar);
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar != null && qVar.e(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        return aVar.isDateBased() || aVar.n();
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (((j$.time.temporal.a) qVar).n()) {
                k kVar = this.f5742b;
                kVar.getClass();
                return j$.time.temporal.r.d(kVar, qVar);
            }
            return this.f5741a.g(qVar);
        }
        return qVar.f(this);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).n() ? this.f5742b.e(qVar) : this.f5741a.e(qVar);
        }
        return j$.time.temporal.r.a(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).n() ? this.f5742b.q(qVar) : this.f5741a.q(qVar);
        }
        return qVar.g(this);
    }

    @Override // j$.time.chrono.e
    public final j$.time.chrono.b toLocalDate() {
        return this.f5741a;
    }

    @Override // j$.time.chrono.e
    public final k toLocalTime() {
        return this.f5742b;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m f(h hVar) {
        return E(hVar, this.f5742b);
    }

    @Override // j$.time.temporal.m
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime a(long j, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            boolean n10 = ((j$.time.temporal.a) qVar).n();
            h hVar = this.f5741a;
            if (n10) {
                return E(hVar, this.f5742b.a(j, qVar));
            }
            return E(hVar.a(j, qVar), this.f5742b);
        }
        return (LocalDateTime) qVar.j(this, j);
    }

    @Override // j$.time.temporal.m
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final LocalDateTime b(long j, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return (LocalDateTime) sVar.e(this, j);
        }
        switch (i.f5869a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return C(this.f5741a, 0L, 0L, 0L, j);
            case 2:
                LocalDateTime E = E(this.f5741a.G(j / 86400000000L), this.f5742b);
                return E.C(E.f5741a, 0L, 0L, 0L, (j % 86400000000L) * 1000);
            case 3:
                LocalDateTime E2 = E(this.f5741a.G(j / 86400000), this.f5742b);
                return E2.C(E2.f5741a, 0L, 0L, 0L, (j % 86400000) * 1000000);
            case 4:
                return B(j);
            case 5:
                return C(this.f5741a, 0L, j, 0L, 0L);
            case 6:
                return C(this.f5741a, j, 0L, 0L, 0L);
            case 7:
                LocalDateTime E3 = E(this.f5741a.G(j / 256), this.f5742b);
                return E3.C(E3.f5741a, (j % 256) * 12, 0L, 0L, 0L);
            default:
                return E(this.f5741a.b(j, sVar), this.f5742b);
        }
    }

    public final LocalDateTime B(long j) {
        return C(this.f5741a, 0L, 0L, j, 0L);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j, j$.time.temporal.b bVar) {
        return j == Long.MIN_VALUE ? b(LocationRequestCompat.PASSIVE_INTERVAL, bVar).b(1L, bVar) : b(-j, bVar);
    }

    public final LocalDateTime C(h hVar, long j, long j6, long j10, long j11) {
        long j12 = j | j6 | j10 | j11;
        k kVar = this.f5742b;
        if (j12 == 0) {
            return E(hVar, kVar);
        }
        long j13 = 1;
        long G = kVar.G();
        long j14 = ((((j % 24) * 3600000000000L) + ((j6 % 1440) * 60000000000L) + ((j10 % 86400) * 1000000000) + (j11 % 86400000000000L)) * j13) + G;
        long B = j$.com.android.tools.r8.a.B(j14, 86400000000000L) + (((j / 24) + (j6 / 1440) + (j10 / 86400) + (j11 / 86400000000000L)) * j13);
        long A = j$.com.android.tools.r8.a.A(j14, 86400000000000L);
        return E(hVar.G(B), A == G ? this.f5742b : k.z(A));
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        if (aVar == j$.time.temporal.r.f) {
            return this.f5741a;
        }
        return j$.com.android.tools.r8.a.q(this, aVar);
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.a(this);
    }

    @Override // java.lang.Comparable
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public final int compareTo(j$.time.chrono.e eVar) {
        if (eVar instanceof LocalDateTime) {
            return v((LocalDateTime) eVar);
        }
        return j$.com.android.tools.r8.a.h(this, eVar);
    }

    public final int v(LocalDateTime localDateTime) {
        int v = this.f5741a.v(localDateTime.f5741a);
        return v == 0 ? this.f5742b.compareTo(localDateTime.f5742b) : v;
    }

    public final boolean x(j$.time.chrono.e eVar) {
        if (eVar instanceof LocalDateTime) {
            return v((LocalDateTime) eVar) < 0;
        }
        long r9 = this.f5741a.r();
        long r10 = eVar.toLocalDate().r();
        if (r9 >= r10) {
            return r9 == r10 && this.f5742b.G() < eVar.toLocalTime().G();
        }
        return true;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            if (this.f5741a.equals(localDateTime.f5741a) && this.f5742b.equals(localDateTime.f5742b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f5741a.hashCode() ^ this.f5742b.hashCode();
    }

    public final String toString() {
        return this.f5741a.toString() + ExifInterface.GPS_DIRECTION_TRUE + this.f5742b.toString();
    }

    private Object writeReplace() {
        return new s((byte) 5, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
