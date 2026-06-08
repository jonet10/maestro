package j$.time.temporal;

import androidx.core.location.LocationRequestCompat;
import j$.util.Objects;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public abstract class r {

    /* renamed from: a, reason: collision with root package name */
    public static final j$.time.format.a f5916a = new j$.time.format.a(1);

    /* renamed from: b, reason: collision with root package name */
    public static final j$.time.format.a f5917b = new j$.time.format.a(2);

    /* renamed from: c, reason: collision with root package name */
    public static final j$.time.format.a f5918c = new j$.time.format.a(3);

    /* renamed from: d, reason: collision with root package name */
    public static final j$.time.format.a f5919d = new j$.time.format.a(4);

    /* renamed from: e, reason: collision with root package name */
    public static final j$.time.format.a f5920e = new j$.time.format.a(5);
    public static final j$.time.format.a f = new j$.time.format.a(6);
    public static final j$.time.format.a g = new j$.time.format.a(7);

    public static u d(n nVar, q qVar) {
        if (!(qVar instanceof a)) {
            Objects.requireNonNull(qVar, "field");
            return qVar.f(nVar);
        }
        if (nVar.c(qVar)) {
            return ((a) qVar).f5898b;
        }
        throw new t(j$.time.c.a("Unsupported field: ", qVar));
    }

    public static int a(n nVar, q qVar) {
        u g3 = nVar.g(qVar);
        if (g3.f5921a < -2147483648L || g3.f5924d > 2147483647L) {
            throw new t("Invalid field " + qVar + " for get() method, use getLong() instead");
        }
        long q9 = nVar.q(qVar);
        if (g3.d(q9)) {
            return (int) q9;
        }
        throw new j$.time.b("Invalid value for " + qVar + " (valid values " + g3 + "): " + q9);
    }

    public static Object c(n nVar, j$.time.format.a aVar) {
        if (aVar == f5916a || aVar == f5917b || aVar == f5918c) {
            return null;
        }
        return aVar.a(nVar);
    }

    public static m b(m mVar, long j, s sVar) {
        long j6;
        if (j == Long.MIN_VALUE) {
            mVar = mVar.b(LocationRequestCompat.PASSIVE_INTERVAL, sVar);
            j6 = 1;
        } else {
            j6 = -j;
        }
        return mVar.b(j6, sVar);
    }
}
