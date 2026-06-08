package m7;

import androidx.core.location.LocationRequestCompat;
import com.google.android.gms.internal.measurement.i5;
import kotlin.jvm.internal.l;
import l7.m;
import t0.f;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements Comparable {

    /* renamed from: b, reason: collision with root package name */
    public static final long f7655b;

    /* renamed from: l, reason: collision with root package name */
    public static final long f7656l;

    /* renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f7657m = 0;

    /* renamed from: a, reason: collision with root package name */
    public final long f7658a;

    static {
        int i = b.f7659a;
        f7655b = i5.m(4611686018427387903L);
        f7656l = i5.m(-4611686018427387903L);
    }

    public static final long a(long j, long j6) {
        long j10 = 1000000;
        long j11 = j6 / j10;
        long j12 = j + j11;
        if (-4611686018426L > j12 || j12 >= 4611686018427L) {
            return i5.m(f.k(j12, -4611686018427387903L, 4611686018427387903L));
        }
        return i5.o((j12 * j10) + (j6 - (j11 * j10)));
    }

    public static final void b(StringBuilder sb, int i, int i6, int i10, String str, boolean z9) {
        sb.append(i);
        if (i6 != 0) {
            sb.append('.');
            String D0 = m.D0(i10, String.valueOf(i6));
            int i11 = -1;
            int length = D0.length() - 1;
            if (length >= 0) {
                while (true) {
                    int i12 = length - 1;
                    if (D0.charAt(length) != '0') {
                        i11 = length;
                        break;
                    } else if (i12 < 0) {
                        break;
                    } else {
                        length = i12;
                    }
                }
            }
            int i13 = i11 + 1;
            if (z9 || i13 >= 3) {
                sb.append((CharSequence) D0, 0, ((i11 + 3) / 3) * 3);
            } else {
                sb.append((CharSequence) D0, 0, i13);
            }
        }
        sb.append(str);
    }

    public static int c(long j, long j6) {
        long j10 = j ^ j6;
        if (j10 < 0 || (((int) j10) & 1) == 0) {
            return l.d(j, j6);
        }
        int i = (((int) j) & 1) - (((int) j6) & 1);
        return j < 0 ? -i : i;
    }

    public static final int d(long j) {
        if (e(j)) {
            return 0;
        }
        return (int) ((((int) j) & 1) == 1 ? ((j >> 1) % 1000) * 1000000 : (j >> 1) % 1000000000);
    }

    public static final boolean e(long j) {
        return j == f7655b || j == f7656l;
    }

    public static final long f(long j, long j6) {
        if (e(j)) {
            if (!e(j6) || (j6 ^ j) >= 0) {
                return j;
            }
            com.google.gson.internal.a.p("Summing infinite durations of different signs yields an undefined result.");
            return 0L;
        }
        if (e(j6)) {
            return j6;
        }
        int i = ((int) j) & 1;
        if (i != (((int) j6) & 1)) {
            return i == 1 ? a(j >> 1, j6 >> 1) : a(j6 >> 1, j >> 1);
        }
        long j10 = (j >> 1) + (j6 >> 1);
        return i == 0 ? (-4611686018426999999L > j10 || j10 >= 4611686018427000000L) ? i5.m(j10 / 1000000) : i5.o(j10) : i5.n(j10);
    }

    public static final long g(long j, c cVar) {
        if (j == f7655b) {
            return LocationRequestCompat.PASSIVE_INTERVAL;
        }
        if (j == f7656l) {
            return Long.MIN_VALUE;
        }
        return cVar.f7667a.convert(j >> 1, ((((int) j) & 1) == 0 ? c.NANOSECONDS : c.MILLISECONDS).f7667a);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return c(this.f7658a, ((a) obj).f7658a);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.f7658a == ((a) obj).f7658a;
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f7658a;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        long j;
        int g;
        long j6 = this.f7658a;
        if (j6 == 0) {
            return "0s";
        }
        if (j6 == f7655b) {
            return "Infinity";
        }
        if (j6 == f7656l) {
            return "-Infinity";
        }
        int i = 0;
        boolean z9 = j6 < 0;
        StringBuilder sb = new StringBuilder();
        if (z9) {
            sb.append('-');
        }
        if (j6 < 0) {
            j6 = (((int) j6) & 1) + ((-(j6 >> 1)) << 1);
            int i6 = b.f7659a;
        }
        long g3 = g(j6, c.DAYS);
        int g10 = e(j6) ? 0 : (int) (g(j6, c.HOURS) % 24);
        if (e(j6)) {
            j = 0;
            g = 0;
        } else {
            j = 0;
            g = (int) (g(j6, c.MINUTES) % 60);
        }
        int g11 = e(j6) ? 0 : (int) (g(j6, c.SECONDS) % 60);
        int d10 = d(j6);
        boolean z10 = g3 != j;
        boolean z11 = g10 != 0;
        boolean z12 = g != 0;
        boolean z13 = (g11 == 0 && d10 == 0) ? false : true;
        if (z10) {
            sb.append(g3);
            sb.append('d');
            i = 1;
        }
        if (z11 || (z10 && (z12 || z13))) {
            int i10 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(g10);
            sb.append('h');
            i = i10;
        }
        if (z12 || (z13 && (z11 || z10))) {
            int i11 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            sb.append(g);
            sb.append('m');
            i = i11;
        }
        if (z13) {
            int i12 = i + 1;
            if (i > 0) {
                sb.append(' ');
            }
            if (g11 != 0 || z10 || z11 || z12) {
                b(sb, g11, d10, 9, "s", false);
            } else if (d10 >= 1000000) {
                b(sb, d10 / 1000000, d10 % 1000000, 6, "ms", false);
            } else if (d10 >= 1000) {
                b(sb, d10 / 1000, d10 % 1000, 3, "us", false);
            } else {
                sb.append(d10);
                sb.append("ns");
            }
            i = i12;
        }
        if (z9 && i > 1) {
            sb.insert(1, '(').append(')');
        }
        return sb.toString();
    }
}
