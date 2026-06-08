package j$.time.temporal;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class h implements q {
    public static final h DAY_OF_QUARTER;
    public static final h QUARTER_OF_YEAR;
    public static final h WEEK_BASED_YEAR;
    public static final h WEEK_OF_WEEK_BASED_YEAR;

    /* renamed from: a, reason: collision with root package name */
    public static final int[] f5902a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ h[] f5903b;

    @Override // j$.time.temporal.q
    public final boolean isDateBased() {
        return true;
    }

    public static h valueOf(String str) {
        return (h) Enum.valueOf(h.class, str);
    }

    public static h[] values() {
        return (h[]) f5903b.clone();
    }

    static {
        h hVar = new h() { // from class: j$.time.temporal.d
            @Override // j$.time.temporal.q
            public final u range() {
                return u.f(90L, 92L);
            }

            @Override // j$.time.temporal.q
            public final boolean e(n nVar) {
                if (!nVar.c(a.DAY_OF_YEAR) || !nVar.c(a.MONTH_OF_YEAR) || !nVar.c(a.YEAR)) {
                    return false;
                }
                h hVar2 = j.f5906a;
                return j$.com.android.tools.r8.a.v(nVar).equals(j$.time.chrono.s.f5797c);
            }

            @Override // j$.time.temporal.q
            public final u f(n nVar) {
                if (!e(nVar)) {
                    throw new t("Unsupported field: DayOfQuarter");
                }
                long q9 = nVar.q(h.QUARTER_OF_YEAR);
                if (q9 == 1) {
                    long q10 = nVar.q(a.YEAR);
                    j$.time.chrono.s.f5797c.getClass();
                    return j$.time.chrono.s.f(q10) ? u.e(1L, 91L) : u.e(1L, 90L);
                }
                if (q9 == 2) {
                    return u.e(1L, 91L);
                }
                if (q9 == 3 || q9 == 4) {
                    return u.e(1L, 92L);
                }
                return range();
            }

            @Override // j$.time.temporal.q
            public final long g(n nVar) {
                if (!e(nVar)) {
                    throw new t("Unsupported field: DayOfQuarter");
                }
                int e10 = nVar.e(a.DAY_OF_YEAR);
                int e11 = nVar.e(a.MONTH_OF_YEAR);
                long q9 = nVar.q(a.YEAR);
                int i = (e11 - 1) / 3;
                j$.time.chrono.s.f5797c.getClass();
                return e10 - h.f5902a[i + (j$.time.chrono.s.f(q9) ? 4 : 0)];
            }

            @Override // j$.time.temporal.q
            public final m j(m mVar, long j) {
                long g = g(mVar);
                range().b(j, this);
                a aVar = a.DAY_OF_YEAR;
                return mVar.a((j - g) + mVar.q(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "DayOfQuarter";
            }
        };
        DAY_OF_QUARTER = hVar;
        h hVar2 = new h() { // from class: j$.time.temporal.e
            @Override // j$.time.temporal.q
            public final u range() {
                return u.e(1L, 4L);
            }

            @Override // j$.time.temporal.q
            public final boolean e(n nVar) {
                if (!nVar.c(a.MONTH_OF_YEAR)) {
                    return false;
                }
                h hVar3 = j.f5906a;
                return j$.com.android.tools.r8.a.v(nVar).equals(j$.time.chrono.s.f5797c);
            }

            @Override // j$.time.temporal.q
            public final long g(n nVar) {
                if (!e(nVar)) {
                    throw new t("Unsupported field: QuarterOfYear");
                }
                return (nVar.q(a.MONTH_OF_YEAR) + 2) / 3;
            }

            @Override // j$.time.temporal.q
            public final u f(n nVar) {
                if (!e(nVar)) {
                    throw new t("Unsupported field: QuarterOfYear");
                }
                return range();
            }

            @Override // j$.time.temporal.q
            public final m j(m mVar, long j) {
                long g = g(mVar);
                range().b(j, this);
                a aVar = a.MONTH_OF_YEAR;
                return mVar.a(((j - g) * 3) + mVar.q(aVar), aVar);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "QuarterOfYear";
            }
        };
        QUARTER_OF_YEAR = hVar2;
        h hVar3 = new h() { // from class: j$.time.temporal.f
            @Override // j$.time.temporal.q
            public final u range() {
                return u.f(52L, 53L);
            }

            @Override // j$.time.temporal.q
            public final boolean e(n nVar) {
                if (!nVar.c(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar4 = j.f5906a;
                return j$.com.android.tools.r8.a.v(nVar).equals(j$.time.chrono.s.f5797c);
            }

            @Override // j$.time.temporal.q
            public final u f(n nVar) {
                if (!e(nVar)) {
                    throw new t("Unsupported field: WeekOfWeekBasedYear");
                }
                return u.e(1L, h.q(h.n(j$.time.h.x(nVar))));
            }

            @Override // j$.time.temporal.q
            public final long g(n nVar) {
                if (!e(nVar)) {
                    throw new t("Unsupported field: WeekOfWeekBasedYear");
                }
                return h.k(j$.time.h.x(nVar));
            }

            @Override // j$.time.temporal.q
            public final m j(m mVar, long j) {
                range().b(j, this);
                return mVar.b(j$.com.android.tools.r8.a.C(j, g(mVar)), b.WEEKS);
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekOfWeekBasedYear";
            }
        };
        WEEK_OF_WEEK_BASED_YEAR = hVar3;
        h hVar4 = new h() { // from class: j$.time.temporal.g
            @Override // j$.time.temporal.q
            public final u range() {
                return a.YEAR.f5898b;
            }

            @Override // j$.time.temporal.q
            public final boolean e(n nVar) {
                if (!nVar.c(a.EPOCH_DAY)) {
                    return false;
                }
                h hVar5 = j.f5906a;
                return j$.com.android.tools.r8.a.v(nVar).equals(j$.time.chrono.s.f5797c);
            }

            @Override // j$.time.temporal.q
            public final long g(n nVar) {
                if (e(nVar)) {
                    return h.n(j$.time.h.x(nVar));
                }
                throw new t("Unsupported field: WeekBasedYear");
            }

            @Override // j$.time.temporal.q
            public final u f(n nVar) {
                if (!e(nVar)) {
                    throw new t("Unsupported field: WeekBasedYear");
                }
                return a.YEAR.f5898b;
            }

            @Override // j$.time.temporal.q
            public final m j(m mVar, long j) {
                if (!e(mVar)) {
                    throw new t("Unsupported field: WeekBasedYear");
                }
                int a8 = a.YEAR.f5898b.a(j, h.WEEK_BASED_YEAR);
                j$.time.h x3 = j$.time.h.x(mVar);
                int e10 = x3.e(a.DAY_OF_WEEK);
                int k5 = h.k(x3);
                if (k5 == 53 && h.q(a8) == 52) {
                    k5 = 52;
                }
                return mVar.f(j$.time.h.D(a8, 1, 4).G(((k5 - 1) * 7) + (e10 - r6.e(r0))));
            }

            @Override // java.lang.Enum
            public final String toString() {
                return "WeekBasedYear";
            }
        };
        WEEK_BASED_YEAR = hVar4;
        f5903b = new h[]{hVar, hVar2, hVar3, hVar4};
        f5902a = new int[]{0, 90, 181, 273, 0, 91, 182, 274};
    }

    public static int q(int i) {
        j$.time.h D = j$.time.h.D(i, 1, 1);
        if (D.z() != j$.time.d.THURSDAY) {
            return (D.z() == j$.time.d.WEDNESDAY && D.B()) ? 53 : 52;
        }
        return 53;
    }

    public static int k(j$.time.h hVar) {
        int ordinal = hVar.z().ordinal();
        int A = hVar.A() - 1;
        int i = (3 - ordinal) + A;
        int i6 = i - ((i / 7) * 7);
        int i10 = i6 - 3;
        if (i10 < -3) {
            i10 = i6 + 4;
        }
        if (A < i10) {
            return (int) u.e(1L, q(n(hVar.M(SubsamplingScaleImageView.ORIENTATION_180).I(-1L)))).f5924d;
        }
        int i11 = ((A - i10) / 7) + 1;
        if (i11 != 53 || i10 == -3 || (i10 == -2 && hVar.B())) {
            return i11;
        }
        return 1;
    }

    public static int n(j$.time.h hVar) {
        int i = hVar.f5866a;
        int A = hVar.A();
        if (A <= 3) {
            return A - hVar.z().ordinal() < -2 ? i - 1 : i;
        }
        if (A >= 363) {
            return ((A - 363) - (hVar.B() ? 1 : 0)) - hVar.z().ordinal() >= 0 ? i + 1 : i;
        }
        return i;
    }
}
