package j$.time.chrono;

import androidx.exifinterface.media.ExifInterface;
import j$.time.ZoneOffset;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class g implements e, j$.time.temporal.m, j$.time.temporal.o, Serializable {
    private static final long serialVersionUID = 4556003607393004514L;

    /* renamed from: a, reason: collision with root package name */
    public final transient b f5769a;

    /* renamed from: b, reason: collision with root package name */
    public final transient j$.time.k f5770b;

    @Override // j$.time.temporal.n
    public final /* synthetic */ Object k(j$.time.format.a aVar) {
        return j$.com.android.tools.r8.a.q(this, aVar);
    }

    @Override // java.lang.Comparable
    /* renamed from: t */
    public final /* synthetic */ int compareTo(e eVar) {
        return j$.com.android.tools.r8.a.h(this, eVar);
    }

    public static g v(l lVar, j$.time.temporal.m mVar) {
        g gVar = (g) mVar;
        if (lVar.equals(gVar.f5769a.getChronology())) {
            return gVar;
        }
        j$.time.g.f("Chronology mismatch, required: ", lVar.d(), gVar.f5769a.getChronology().d());
        return null;
    }

    public g(b bVar, j$.time.k kVar) {
        Objects.requireNonNull(bVar, "date");
        Objects.requireNonNull(kVar, "time");
        this.f5769a = bVar;
        this.f5770b = kVar;
    }

    public final g z(j$.time.temporal.m mVar, j$.time.k kVar) {
        b bVar = this.f5769a;
        return (bVar == mVar && this.f5770b == kVar) ? this : new g(d.v(bVar.getChronology(), mVar), kVar);
    }

    @Override // j$.time.chrono.e
    public final l getChronology() {
        return this.f5769a.getChronology();
    }

    public final int hashCode() {
        return this.f5769a.hashCode() ^ this.f5770b.hashCode();
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j, j$.time.temporal.b bVar) {
        return v(this.f5769a.getChronology(), j$.time.temporal.r.b(this, j, bVar));
    }

    @Override // j$.time.chrono.e
    public final b toLocalDate() {
        return this.f5769a;
    }

    public final String toString() {
        return this.f5769a.toString() + ExifInterface.GPS_DIRECTION_TRUE + this.f5770b.toString();
    }

    @Override // j$.time.chrono.e
    public final j$.time.k toLocalTime() {
        return this.f5770b;
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
            if (!((j$.time.temporal.a) qVar).n()) {
                return this.f5769a.g(qVar);
            }
            j$.time.k kVar = this.f5770b;
            kVar.getClass();
            return j$.time.temporal.r.d(kVar, qVar);
        }
        return qVar.f(this);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).n() ? this.f5770b.e(qVar) : this.f5769a.e(qVar);
        }
        return g(qVar).a(q(qVar), qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).n() ? this.f5770b.q(qVar) : this.f5769a.q(qVar);
        }
        return qVar.g(this);
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m f(j$.time.h hVar) {
        return z(hVar, this.f5770b);
    }

    @Override // j$.time.temporal.m
    /* renamed from: y, reason: merged with bridge method [inline-methods] */
    public final g a(long j, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            boolean n10 = ((j$.time.temporal.a) qVar).n();
            b bVar = this.f5769a;
            if (n10) {
                return z(bVar, this.f5770b.a(j, qVar));
            }
            return z(bVar.a(j, qVar), this.f5770b);
        }
        return v(this.f5769a.getChronology(), qVar.j(this, j));
    }

    @Override // j$.time.temporal.m
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public final g b(long j, j$.time.temporal.s sVar) {
        if (!(sVar instanceof j$.time.temporal.b)) {
            return v(this.f5769a.getChronology(), sVar.e(this, j));
        }
        switch (f.f5767a[((j$.time.temporal.b) sVar).ordinal()]) {
            case 1:
                return x(this.f5769a, 0L, 0L, 0L, j);
            case 2:
                g z9 = z(this.f5769a.b(j / 86400000000L, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.f5770b);
                return z9.x(z9.f5769a, 0L, 0L, 0L, (j % 86400000000L) * 1000);
            case 3:
                g z10 = z(this.f5769a.b(j / 86400000, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.f5770b);
                return z10.x(z10.f5769a, 0L, 0L, 0L, (j % 86400000) * 1000000);
            case 4:
                return x(this.f5769a, 0L, 0L, j, 0L);
            case 5:
                return x(this.f5769a, 0L, j, 0L, 0L);
            case 6:
                return x(this.f5769a, j, 0L, 0L, 0L);
            case 7:
                g z11 = z(this.f5769a.b(j / 256, (j$.time.temporal.s) j$.time.temporal.b.DAYS), this.f5770b);
                return z11.x(z11.f5769a, (j % 256) * 12, 0L, 0L, 0L);
            default:
                return z(this.f5769a.b(j, sVar), this.f5770b);
        }
    }

    public final g x(b bVar, long j, long j6, long j10, long j11) {
        long j12 = j | j6 | j10 | j11;
        j$.time.k kVar = this.f5770b;
        if (j12 == 0) {
            return z(bVar, kVar);
        }
        long j13 = j / 24;
        long G = kVar.G();
        long j14 = ((j % 24) * 3600000000000L) + ((j6 % 1440) * 60000000000L) + ((j10 % 86400) * 1000000000) + (j11 % 86400000000000L) + G;
        long B = j$.com.android.tools.r8.a.B(j14, 86400000000000L) + j13 + (j6 / 1440) + (j10 / 86400) + (j11 / 86400000000000L);
        long A = j$.com.android.tools.r8.a.A(j14, 86400000000000L);
        return z(bVar.b(B, (j$.time.temporal.s) j$.time.temporal.b.DAYS), A == G ? this.f5770b : j$.time.k.z(A));
    }

    @Override // j$.time.chrono.e
    public final ChronoZonedDateTime h(ZoneOffset zoneOffset) {
        return k.v(zoneOffset, null, this);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return mVar.a(toLocalDate().r(), j$.time.temporal.a.EPOCH_DAY).a(toLocalTime().G(), j$.time.temporal.a.NANO_OF_DAY);
    }

    private Object writeReplace() {
        return new e0((byte) 2, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof e) && j$.com.android.tools.r8.a.h(this, (e) obj) == 0;
    }
}
