package j$.time.temporal;

import j$.time.Duration;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public enum i implements s {
    WEEK_BASED_YEARS("WeekBasedYears"),
    QUARTER_YEARS("QuarterYears");


    /* renamed from: a, reason: collision with root package name */
    public final String f5905a;

    static {
        Duration.e(31556952L, 0);
        Duration.e(7889238L, 0);
    }

    i(String str) {
        this.f5905a = str;
    }

    @Override // j$.time.temporal.s
    public final m e(m mVar, long j) {
        int i = c.f5901a[ordinal()];
        if (i == 1) {
            return mVar.a(j$.com.android.tools.r8.a.x(mVar.e(r0), j), j.f5908c);
        }
        if (i == 2) {
            return mVar.b(j / 4, b.YEARS).b((j % 4) * 3, b.MONTHS);
        }
        throw new IllegalStateException("Unreachable");
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f5905a;
    }
}
