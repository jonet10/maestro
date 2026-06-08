package j$.time.chrono;

import j$.time.LocalDateTime;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Locale;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class a implements l {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f5758a = new ConcurrentHashMap();

    /* renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap f5759b = new ConcurrentHashMap();

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return d().compareTo(((l) obj).d());
    }

    static {
        new Locale("ja", "JP", "JP");
    }

    public static l e(l lVar, String str) {
        String i;
        l lVar2 = (l) f5758a.putIfAbsent(str, lVar);
        if (lVar2 == null && (i = lVar.i()) != null) {
            f5759b.putIfAbsent(i, lVar);
        }
        return lVar2;
    }

    @Override // j$.time.chrono.l
    public e p(LocalDateTime localDateTime) {
        try {
            return o(localDateTime).s(j$.time.k.x(localDateTime));
        } catch (j$.time.b e10) {
            throw new j$.time.b("Unable to obtain ChronoLocalDateTime from TemporalAccessor: " + LocalDateTime.class, e10);
        }
    }

    @Override // j$.time.chrono.l
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a) && d().compareTo(((a) obj).d()) == 0;
    }

    @Override // j$.time.chrono.l
    public final int hashCode() {
        return getClass().hashCode() ^ d().hashCode();
    }

    @Override // j$.time.chrono.l
    public final String toString() {
        return d();
    }
}
