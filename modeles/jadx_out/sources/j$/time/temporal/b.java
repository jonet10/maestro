package j$.time.temporal;

import androidx.core.location.LocationRequestCompat;
import j$.time.Duration;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public enum b implements s {
    NANOS("Nanos"),
    MICROS("Micros"),
    MILLIS("Millis"),
    SECONDS("Seconds"),
    MINUTES("Minutes"),
    HOURS("Hours"),
    HALF_DAYS("HalfDays"),
    DAYS("Days"),
    WEEKS("Weeks"),
    MONTHS("Months"),
    YEARS("Years"),
    DECADES("Decades"),
    CENTURIES("Centuries"),
    MILLENNIA("Millennia"),
    ERAS("Eras"),
    FOREVER("Forever");


    /* renamed from: a, reason: collision with root package name */
    public final String f5900a;

    static {
        Duration.f(1L);
        Duration.f(1000L);
        Duration.f(1000000L);
        Duration.e(1L, 0);
        Duration.e(60L, 0);
        Duration.e(3600L, 0);
        Duration.e(43200L, 0);
        Duration.e(86400L, 0);
        Duration.e(604800L, 0);
        Duration.e(2629746L, 0);
        Duration.e(31556952L, 0);
        Duration.e(315569520L, 0);
        Duration.e(3155695200L, 0);
        Duration.e(31556952000L, 0);
        Duration.e(31556952000000000L, 0);
        Duration.e(j$.com.android.tools.r8.a.x(LocationRequestCompat.PASSIVE_INTERVAL, j$.com.android.tools.r8.a.B(999999999L, 1000000000L)), (int) j$.com.android.tools.r8.a.A(999999999L, 1000000000L));
    }

    b(String str) {
        this.f5900a = str;
    }

    @Override // j$.time.temporal.s
    public final m e(m mVar, long j) {
        return mVar.b(j, this);
    }

    @Override // java.lang.Enum
    public final String toString() {
        return this.f5900a;
    }
}
