package j$.time;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class TimeConversions {
    public static Duration convert(java.time.Duration duration) {
        if (duration == null) {
            return null;
        }
        long seconds = duration.getSeconds();
        long nano = duration.getNano();
        Duration duration2 = Duration.f5733c;
        return Duration.e(j$.com.android.tools.r8.a.x(seconds, j$.com.android.tools.r8.a.B(nano, 1000000000L)), (int) j$.com.android.tools.r8.a.A(nano, 1000000000L));
    }

    public static java.time.Instant convert(Instant instant) {
        if (instant == null) {
            return null;
        }
        return java.time.Instant.ofEpochSecond(instant.f5737a, instant.f5738b);
    }

    public static java.time.Duration convert(Duration duration) {
        if (duration == null) {
            return null;
        }
        return java.time.Duration.ofSeconds(duration.f5734a, duration.f5735b);
    }
}
