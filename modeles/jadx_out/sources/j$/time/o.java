package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Locale;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class o implements j$.time.temporal.n, j$.time.temporal.o, Comparable, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f5881c = 0;
    private static final long serialVersionUID = -939150713474957432L;

    /* renamed from: a, reason: collision with root package name */
    public final int f5882a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5883b;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        o oVar = (o) obj;
        int i = this.f5882a - oVar.f5882a;
        return i == 0 ? this.f5883b - oVar.f5883b : i;
    }

    static {
        j$.time.format.n nVar = new j$.time.format.n();
        nVar.d("--");
        nVar.g(j$.time.temporal.a.MONTH_OF_YEAR, 2);
        nVar.c('-');
        nVar.g(j$.time.temporal.a.DAY_OF_MONTH, 2);
        nVar.l(Locale.getDefault(), j$.time.format.t.SMART, null);
    }

    public o(int i, int i6) {
        this.f5882a = i;
        this.f5883b = i6;
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.MONTH_OF_YEAR || qVar == j$.time.temporal.a.DAY_OF_MONTH : qVar != null && qVar.e(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.MONTH_OF_YEAR) {
            return qVar.range();
        }
        if (qVar != j$.time.temporal.a.DAY_OF_MONTH) {
            return j$.time.temporal.r.d(this, qVar);
        }
        m y9 = m.y(this.f5882a);
        y9.getClass();
        int i = l.f5877a[y9.ordinal()];
        return j$.time.temporal.u.f(i != 1 ? (i == 2 || i == 3 || i == 4 || i == 5) ? 30 : 31 : 28, m.y(this.f5882a).x());
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        return g(qVar).a(q(qVar), qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        int i;
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        int i6 = n.f5880a[((j$.time.temporal.a) qVar).ordinal()];
        if (i6 == 1) {
            i = this.f5883b;
        } else {
            if (i6 != 2) {
                throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
            }
            i = this.f5882a;
        }
        return i;
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        if (aVar == j$.time.temporal.r.f5917b) {
            return j$.time.chrono.s.f5797c;
        }
        return j$.time.temporal.r.c(this, aVar);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        if (!j$.com.android.tools.r8.a.v(mVar).equals(j$.time.chrono.s.f5797c)) {
            throw new b("Adjustment only supported on ISO date-time");
        }
        j$.time.temporal.m a8 = mVar.a(this.f5882a, j$.time.temporal.a.MONTH_OF_YEAR);
        j$.time.temporal.a aVar = j$.time.temporal.a.DAY_OF_MONTH;
        return a8.a(Math.min(a8.g(aVar).f5924d, this.f5883b), aVar);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.f5882a == oVar.f5882a && this.f5883b == oVar.f5883b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f5882a << 6) + this.f5883b;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(10);
        sb.append("--");
        sb.append(this.f5882a < 10 ? "0" : "");
        sb.append(this.f5882a);
        sb.append(this.f5883b < 10 ? "-0" : "-");
        sb.append(this.f5883b);
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 13, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
