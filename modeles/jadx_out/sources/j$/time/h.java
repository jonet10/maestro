package j$.time;

import androidx.core.location.LocationRequestCompat;
import androidx.leanback.media.MediaPlayerGlue;
import j$.util.Objects;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class h implements j$.time.temporal.m, j$.time.temporal.o, j$.time.chrono.b, Serializable {

    /* renamed from: d, reason: collision with root package name */
    public static final h f5864d = D(-999999999, 1, 1);

    /* renamed from: e, reason: collision with root package name */
    public static final h f5865e = D(999999999, 12, 31);
    private static final long serialVersionUID = 2942565459149668126L;

    /* renamed from: a, reason: collision with root package name */
    public final int f5866a;

    /* renamed from: b, reason: collision with root package name */
    public final short f5867b;

    /* renamed from: c, reason: collision with root package name */
    public final short f5868c;

    static {
        D(1970, 1, 1);
    }

    public static h D(int i, int i6, int i10) {
        j$.time.temporal.a.YEAR.k(i);
        j$.time.temporal.a.MONTH_OF_YEAR.k(i6);
        j$.time.temporal.a.DAY_OF_MONTH.k(i10);
        return w(i, i6, i10);
    }

    public static h E(long j) {
        long j6;
        j$.time.temporal.a.EPOCH_DAY.k(j);
        long j10 = 719468 + j;
        if (j10 < 0) {
            long j11 = ((j + 719469) / 146097) - 1;
            j6 = j11 * 400;
            j10 += (-j11) * 146097;
        } else {
            j6 = 0;
        }
        long j12 = ((j10 * 400) + 591) / 146097;
        long j13 = j10 - ((j12 / 400) + (((j12 / 4) + (j12 * 365)) - (j12 / 100)));
        if (j13 < 0) {
            j12--;
            j13 = j10 - ((j12 / 400) + (((j12 / 4) + (365 * j12)) - (j12 / 100)));
        }
        int i = (int) j13;
        int i6 = ((i * 5) + 2) / 153;
        int i10 = ((i6 + 2) % 12) + 1;
        int i11 = (i - (((i6 * 306) + 5) / 10)) + 1;
        long j14 = j12 + j6 + (i6 / 10);
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return new h(aVar.f5898b.a(j14, aVar), i10, i11);
    }

    public static h x(j$.time.temporal.n nVar) {
        Objects.requireNonNull(nVar, "temporal");
        h hVar = (h) nVar.k(j$.time.temporal.r.f);
        if (hVar != null) {
            return hVar;
        }
        throw new b("Unable to obtain LocalDate from TemporalAccessor: " + nVar + " of type " + nVar.getClass().getName());
    }

    public static h w(int i, int i6, int i10) {
        int i11 = 28;
        if (i10 > 28) {
            if (i6 != 2) {
                i11 = (i6 == 4 || i6 == 6 || i6 == 9 || i6 == 11) ? 30 : 31;
            } else {
                j$.time.chrono.s.f5797c.getClass();
                if (j$.time.chrono.s.f(i)) {
                    i11 = 29;
                }
            }
            if (i10 > i11) {
                if (i10 == 29) {
                    g.e("Invalid date 'February 29' as '", i, "' is not a leap year");
                    return null;
                }
                throw new b("Invalid date '" + m.y(i6).name() + " " + i10 + "'");
            }
        }
        return new h(i, i6, i10);
    }

    public static h J(int i, int i6, int i10) {
        if (i6 == 2) {
            j$.time.chrono.s.f5797c.getClass();
            i10 = Math.min(i10, j$.time.chrono.s.f((long) i) ? 29 : 28);
        } else if (i6 == 4 || i6 == 6 || i6 == 9 || i6 == 11) {
            i10 = Math.min(i10, 30);
        }
        return new h(i, i6, i10);
    }

    public h(int i, int i6, int i10) {
        this.f5866a = i;
        this.f5867b = (short) i6;
        this.f5868c = (short) i10;
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        return j$.com.android.tools.r8.a.n(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.f(this);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        if (!aVar.isDateBased()) {
            throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
        int i = f.f5816a[aVar.ordinal()];
        if (i == 1) {
            return j$.time.temporal.u.e(1L, C());
        }
        if (i == 2) {
            return j$.time.temporal.u.e(1L, B() ? 366 : 365);
        }
        if (i != 3) {
            return i != 4 ? aVar.f5898b : this.f5866a <= 0 ? j$.time.temporal.u.e(1L, 1000000000L) : j$.time.temporal.u.e(1L, 999999999L);
        }
        return j$.time.temporal.u.e(1L, (m.y(this.f5867b) != m.FEBRUARY || B()) ? 5L : 4L);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return y(qVar);
        }
        return j$.time.temporal.r.a(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.EPOCH_DAY) {
                return r();
            }
            if (qVar != j$.time.temporal.a.PROLEPTIC_MONTH) {
                return y(qVar);
            }
            return ((this.f5866a * 12) + this.f5867b) - 1;
        }
        return qVar.g(this);
    }

    public final int y(j$.time.temporal.q qVar) {
        switch (f.f5816a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                return this.f5868c;
            case 2:
                return A();
            case 3:
                return ((this.f5868c - 1) / 7) + 1;
            case 4:
                int i = this.f5866a;
                return i >= 1 ? i : 1 - i;
            case 5:
                return z().getValue();
            case 6:
                return ((this.f5868c - 1) % 7) + 1;
            case 7:
                return ((A() - 1) % 7) + 1;
            case 8:
                throw new j$.time.temporal.t("Invalid field 'EpochDay' for get() method, use getLong() instead");
            case 9:
                return ((A() - 1) / 7) + 1;
            case 10:
                return this.f5867b;
            case 11:
                throw new j$.time.temporal.t("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
            case 12:
                return this.f5866a;
            case 13:
                return this.f5866a >= 1 ? 1 : 0;
            default:
                throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.l getChronology() {
        return j$.time.chrono.s.f5797c;
    }

    public final int A() {
        return (m.y(this.f5867b).v(B()) + this.f5868c) - 1;
    }

    public final d z() {
        return d.v(((int) j$.com.android.tools.r8.a.A(r() + 3, 7)) + 1);
    }

    public final boolean B() {
        j$.time.chrono.s sVar = j$.time.chrono.s.f5797c;
        long j = this.f5866a;
        sVar.getClass();
        return j$.time.chrono.s.f(j);
    }

    public final int C() {
        short s6 = this.f5867b;
        return s6 != 2 ? (s6 == 4 || s6 == 6 || s6 == 9 || s6 == 11) ? 30 : 31 : B() ? 29 : 28;
    }

    @Override // j$.time.temporal.m
    /* renamed from: L, reason: merged with bridge method [inline-methods] */
    public final h f(j$.time.temporal.o oVar) {
        if (oVar instanceof h) {
            return (h) oVar;
        }
        return (h) oVar.j(this);
    }

    @Override // j$.time.temporal.m
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public final h a(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (h) qVar.j(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.k(j);
        switch (f.f5816a[aVar.ordinal()]) {
            case 1:
                int i = (int) j;
                if (this.f5868c != i) {
                    return D(this.f5866a, this.f5867b, i);
                }
                return this;
            case 2:
                return M((int) j);
            case 3:
                return G(j$.com.android.tools.r8.a.w(j - q(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH), 7));
            case 4:
                if (this.f5866a < 1) {
                    j = 1 - j;
                }
                return N((int) j);
            case 5:
                return G(j - z().getValue());
            case 6:
                return G(j - q(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 7:
                return G(j - q(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 8:
                return E(j);
            case 9:
                return G(j$.com.android.tools.r8.a.w(j - q(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR), 7));
            case 10:
                int i6 = (int) j;
                if (this.f5867b != i6) {
                    j$.time.temporal.a.MONTH_OF_YEAR.k(i6);
                    return J(this.f5866a, i6, this.f5868c);
                }
                return this;
            case 11:
                return H(j - (((this.f5866a * 12) + this.f5867b) - 1));
            case 12:
                return N((int) j);
            case 13:
                if (q(j$.time.temporal.a.ERA) != j) {
                    return N(1 - this.f5866a);
                }
                return this;
            default:
                throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
    }

    public final h N(int i) {
        if (this.f5866a == i) {
            return this;
        }
        j$.time.temporal.a.YEAR.k(i);
        return J(i, this.f5867b, this.f5868c);
    }

    public final h M(int i) {
        if (A() == i) {
            return this;
        }
        int i6 = this.f5866a;
        long j = i6;
        j$.time.temporal.a.YEAR.k(j);
        j$.time.temporal.a.DAY_OF_YEAR.k(i);
        j$.time.chrono.s.f5797c.getClass();
        boolean f = j$.time.chrono.s.f(j);
        if (i == 366 && !f) {
            g.e("Invalid date 'DayOfYear 366' as '", i6, "' is not a leap year");
            return null;
        }
        m y9 = m.y(((i - 1) / 31) + 1);
        if (i > (y9.w(f) + y9.v(f)) - 1) {
            y9 = m.f5878a[((((int) 1) + 12) + y9.ordinal()) % 12];
        }
        return new h(i6, y9.getValue(), (i - y9.v(f)) + 1);
    }

    @Override // j$.time.temporal.m
    /* renamed from: F, reason: merged with bridge method [inline-methods] */
    public final h b(long j, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            switch (f.f5817b[((j$.time.temporal.b) sVar).ordinal()]) {
                case 1:
                    return G(j);
                case 2:
                    return G(j$.com.android.tools.r8.a.w(j, 7));
                case 3:
                    return H(j);
                case 4:
                    return I(j);
                case 5:
                    return I(j$.com.android.tools.r8.a.w(j, 10));
                case 6:
                    return I(j$.com.android.tools.r8.a.w(j, 100));
                case 7:
                    return I(j$.com.android.tools.r8.a.w(j, 1000));
                case 8:
                    j$.time.temporal.a aVar = j$.time.temporal.a.ERA;
                    return a(j$.com.android.tools.r8.a.x(q(aVar), j), aVar);
                default:
                    g.b(sVar, "Unsupported unit: ");
                    return null;
            }
        }
        return (h) sVar.e(this, j);
    }

    public final h I(long j) {
        if (j == 0) {
            return this;
        }
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        return J(aVar.f5898b.a(this.f5866a + j, aVar), this.f5867b, this.f5868c);
    }

    public final h H(long j) {
        if (j == 0) {
            return this;
        }
        long j6 = (this.f5866a * 12) + (this.f5867b - 1) + j;
        j$.time.temporal.a aVar = j$.time.temporal.a.YEAR;
        long j10 = 12;
        return J(aVar.f5898b.a(j$.com.android.tools.r8.a.B(j6, j10), aVar), ((int) j$.com.android.tools.r8.a.A(j6, j10)) + 1, this.f5868c);
    }

    public final h G(long j) {
        if (j == 0) {
            return this;
        }
        long j6 = this.f5868c + j;
        if (j6 > 0) {
            if (j6 <= 28) {
                return new h(this.f5866a, this.f5867b, (int) j6);
            }
            if (j6 <= 59) {
                long C = C();
                if (j6 <= C) {
                    return new h(this.f5866a, this.f5867b, (int) j6);
                }
                short s6 = this.f5867b;
                if (s6 < 12) {
                    return new h(this.f5866a, s6 + 1, (int) (j6 - C));
                }
                j$.time.temporal.a.YEAR.k(this.f5866a + 1);
                return new h(this.f5866a + 1, 1, (int) (j6 - C));
            }
        }
        return E(j$.com.android.tools.r8.a.x(r(), j));
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j, j$.time.temporal.b bVar) {
        return j == Long.MIN_VALUE ? b(LocationRequestCompat.PASSIVE_INTERVAL, bVar).b(1L, bVar) : b(-j, bVar);
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        return aVar == j$.time.temporal.r.f ? this : j$.com.android.tools.r8.a.p(this, aVar);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return j$.com.android.tools.r8.a.a(this, mVar);
    }

    @Override // j$.time.chrono.b
    public final j$.time.chrono.e s(k kVar) {
        return LocalDateTime.y(this, kVar);
    }

    @Override // j$.time.chrono.b
    public final long r() {
        long j = this.f5866a;
        long j6 = this.f5867b;
        long j10 = 365 * j;
        long j11 = (((367 * j6) - 362) / 12) + (j >= 0 ? ((j + 399) / 400) + (((3 + j) / 4) - ((99 + j) / 100)) + j10 : j10 - ((j / (-400)) + ((j / (-4)) - (j / (-100))))) + (this.f5868c - 1);
        if (j6 > 2) {
            j11 = !B() ? j11 - 2 : j11 - 1;
        }
        return j11 - 719528;
    }

    @Override // java.lang.Comparable
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public final int compareTo(j$.time.chrono.b bVar) {
        if (bVar instanceof h) {
            return v((h) bVar);
        }
        return j$.com.android.tools.r8.a.g(this, bVar);
    }

    public final int v(h hVar) {
        int i = this.f5866a - hVar.f5866a;
        if (i != 0) {
            return i;
        }
        int i6 = this.f5867b - hVar.f5867b;
        return i6 == 0 ? this.f5868c - hVar.f5868c : i6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h) && v((h) obj) == 0;
    }

    @Override // j$.time.chrono.b
    public final int hashCode() {
        int i = this.f5866a;
        return (((i << 11) + (this.f5867b << 6)) + this.f5868c) ^ (i & (-2048));
    }

    @Override // j$.time.chrono.b
    public final String toString() {
        int i = this.f5866a;
        short s6 = this.f5867b;
        short s9 = this.f5868c;
        int abs = Math.abs(i);
        StringBuilder sb = new StringBuilder(10);
        if (abs >= 1000) {
            if (i > 9999) {
                sb.append('+');
            }
            sb.append(i);
        } else if (i < 0) {
            sb.append(i - 10000);
            sb.deleteCharAt(1);
        } else {
            sb.append(i + MediaPlayerGlue.FAST_FORWARD_REWIND_STEP);
            sb.deleteCharAt(0);
        }
        sb.append(s6 < 10 ? "-0" : "-");
        sb.append((int) s6);
        sb.append(s9 < 10 ? "-0" : "-");
        sb.append((int) s9);
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 3, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
