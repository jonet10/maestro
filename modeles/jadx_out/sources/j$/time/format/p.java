package j$.time.format;

import j$.time.ZoneId;
import j$.util.Objects;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class p {

    /* renamed from: a, reason: collision with root package name */
    public final j$.time.temporal.n f5856a;

    /* renamed from: b, reason: collision with root package name */
    public final DateTimeFormatter f5857b;

    /* renamed from: c, reason: collision with root package name */
    public int f5858c;

    public p(j$.time.temporal.n nVar, DateTimeFormatter dateTimeFormatter) {
        j$.time.chrono.l lVar = dateTimeFormatter.f5822d;
        if (lVar != null) {
            j$.time.chrono.l lVar2 = (j$.time.chrono.l) nVar.k(j$.time.temporal.r.f5917b);
            ZoneId zoneId = (ZoneId) nVar.k(j$.time.temporal.r.f5916a);
            j$.time.chrono.b bVar = null;
            lVar = Objects.equals(lVar, lVar2) ? null : lVar;
            Objects.equals(null, zoneId);
            if (lVar != null) {
                j$.time.chrono.l lVar3 = lVar != null ? lVar : lVar2;
                if (lVar != null) {
                    if (nVar.c(j$.time.temporal.a.EPOCH_DAY)) {
                        bVar = lVar3.o(nVar);
                    } else if (lVar != j$.time.chrono.s.f5797c || lVar2 != null) {
                        for (j$.time.temporal.a aVar : j$.time.temporal.a.values()) {
                            if (aVar.isDateBased() && nVar.c(aVar)) {
                                throw new j$.time.b("Unable to apply override chronology '" + lVar + "' because the temporal object being formatted contains date fields but does not represent a whole date: " + nVar);
                            }
                        }
                    }
                }
                nVar = new o(bVar, nVar, lVar3, zoneId);
            }
        }
        this.f5856a = nVar;
        this.f5857b = dateTimeFormatter;
    }

    public final Long a(j$.time.temporal.q qVar) {
        int i = this.f5858c;
        j$.time.temporal.n nVar = this.f5856a;
        if (i <= 0 || nVar.c(qVar)) {
            return Long.valueOf(nVar.q(qVar));
        }
        return null;
    }

    public final String toString() {
        return this.f5856a.toString();
    }
}
