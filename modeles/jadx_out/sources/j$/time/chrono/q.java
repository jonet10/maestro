package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Arrays;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class q extends d {
    private static final long serialVersionUID = -5207853542612002020L;

    /* renamed from: a, reason: collision with root package name */
    public final transient o f5792a;

    /* renamed from: b, reason: collision with root package name */
    public final transient int f5793b;

    /* renamed from: c, reason: collision with root package name */
    public final transient int f5794c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f5795d;

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final e s(j$.time.k kVar) {
        return new g(this, kVar);
    }

    public q(o oVar, int i, int i6, int i10) {
        oVar.j(i, i6, i10);
        this.f5792a = oVar;
        this.f5793b = i;
        this.f5794c = i6;
        this.f5795d = i10;
    }

    public q(o oVar, long j) {
        int i = (int) j;
        oVar.f();
        if (i < oVar.f5789e || i >= oVar.f) {
            throw new j$.time.b("Hijrah date out of range");
        }
        int binarySearch = Arrays.binarySearch(oVar.f5788d, i);
        binarySearch = binarySearch < 0 ? (-binarySearch) - 2 : binarySearch;
        int i6 = oVar.g;
        int[] iArr = {(binarySearch + i6) / 12, ((i6 + binarySearch) % 12) + 1, (i - oVar.f5788d[binarySearch]) + 1};
        this.f5792a = oVar;
        this.f5793b = iArr[0];
        this.f5794c = iArr[1];
        this.f5795d = iArr[2];
    }

    @Override // j$.time.chrono.b
    public final l getChronology() {
        return this.f5792a;
    }

    @Override // j$.time.chrono.d
    public final m w() {
        return r.AH;
    }

    @Override // j$.time.chrono.d, j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.f(this);
        }
        if (!j$.com.android.tools.r8.a.n(this, qVar)) {
            throw new j$.time.temporal.t(j$.time.c.a("Unsupported field: ", qVar));
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        int i = p.f5791a[aVar.ordinal()];
        return i != 1 ? i != 2 ? i != 3 ? this.f5792a.q(aVar) : j$.time.temporal.u.e(1L, 5L) : j$.time.temporal.u.e(1L, this.f5792a.v(this.f5793b, 12)) : j$.time.temporal.u.e(1L, this.f5792a.k(this.f5793b, this.f5794c));
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        switch (p.f5791a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                return this.f5795d;
            case 2:
                return C();
            case 3:
                return ((this.f5795d - 1) / 7) + 1;
            case 4:
                return ((int) j$.com.android.tools.r8.a.A(r() + 3, 7)) + 1;
            case 5:
                return ((this.f5795d - 1) % 7) + 1;
            case 6:
                return ((C() - 1) % 7) + 1;
            case 7:
                return r();
            case 8:
                return ((C() - 1) / 7) + 1;
            case 9:
                return this.f5794c;
            case 10:
                return ((this.f5793b * 12) + this.f5794c) - 1;
            case 11:
                return this.f5793b;
            case 12:
                return this.f5793b;
            case 13:
                return this.f5793b <= 1 ? 0 : 1;
            default:
                throw new j$.time.temporal.t(j$.time.c.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    /* renamed from: G, reason: merged with bridge method [inline-methods] */
    public final q a(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (q) super.a(j, qVar);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        this.f5792a.q(aVar).b(j, aVar);
        int i = (int) j;
        switch (p.f5791a[aVar.ordinal()]) {
            case 1:
                return F(this.f5793b, this.f5794c, i);
            case 2:
                return y(Math.min(i, this.f5792a.v(this.f5793b, 12)) - C());
            case 3:
                return y((j - q(j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH)) * 7);
            case 4:
                return y(j - (((int) j$.com.android.tools.r8.a.A(r() + 3, 7)) + 1));
            case 5:
                return y(j - q(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH));
            case 6:
                return y(j - q(j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR));
            case 7:
                return new q(this.f5792a, j);
            case 8:
                return y((j - q(j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR)) * 7);
            case 9:
                return F(this.f5793b, i, this.f5795d);
            case 10:
                return z(j - (((this.f5793b * 12) + this.f5794c) - 1));
            case 11:
                if (this.f5793b < 1) {
                    i = 1 - i;
                }
                return F(i, this.f5794c, this.f5795d);
            case 12:
                return F(i, this.f5794c, this.f5795d);
            case 13:
                return F(1 - this.f5793b, this.f5794c, this.f5795d);
            default:
                throw new j$.time.temporal.t(j$.time.c.a("Unsupported field: ", qVar));
        }
    }

    public final q F(int i, int i6, int i10) {
        int k5 = this.f5792a.k(i, i6);
        if (i10 > k5) {
            i10 = k5;
        }
        return new q(this.f5792a, i, i6, i10);
    }

    @Override // j$.time.chrono.d
    /* renamed from: B */
    public final b f(j$.time.temporal.o oVar) {
        return (q) super.f(oVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m f(j$.time.h hVar) {
        return (q) super.f(hVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final long r() {
        return this.f5792a.j(this.f5793b, this.f5794c, this.f5795d);
    }

    public final int C() {
        return this.f5792a.v(this.f5793b, this.f5794c - 1) + this.f5795d;
    }

    @Override // j$.time.chrono.d
    public final b A(long j) {
        if (j == 0) {
            return this;
        }
        long j6 = this.f5793b + ((int) j);
        int i = (int) j6;
        if (j6 == i) {
            return F(i, this.f5794c, this.f5795d);
        }
        throw new ArithmeticException();
    }

    @Override // j$.time.chrono.d
    /* renamed from: E, reason: merged with bridge method [inline-methods] */
    public final q z(long j) {
        if (j == 0) {
            return this;
        }
        long j6 = (this.f5793b * 12) + (this.f5794c - 1) + j;
        o oVar = this.f5792a;
        long B = j$.com.android.tools.r8.a.B(j6, 12L);
        int i = oVar.g;
        if (B >= i / 12 && B <= (((oVar.f5788d.length - 1) + i) / 12) - 1) {
            return F((int) B, ((int) j$.com.android.tools.r8.a.A(j6, 12L)) + 1, this.f5795d);
        }
        throw new j$.time.b("Invalid Hijrah year: " + B);
    }

    @Override // j$.time.chrono.d
    /* renamed from: D, reason: merged with bridge method [inline-methods] */
    public final q y(long j) {
        return new q(this.f5792a, r() + j);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.m
    public final b b(long j, j$.time.temporal.s sVar) {
        return (q) super.b(j, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m b(long j, j$.time.temporal.s sVar) {
        return (q) super.b(j, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m n(long j, j$.time.temporal.b bVar) {
        return (q) super.n(j, bVar);
    }

    @Override // j$.time.chrono.d
    /* renamed from: x */
    public final b n(long j, j$.time.temporal.s sVar) {
        return (q) super.n(j, sVar);
    }

    @Override // j$.time.chrono.d
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof q) {
            q qVar = (q) obj;
            if (this.f5793b == qVar.f5793b && this.f5794c == qVar.f5794c && this.f5795d == qVar.f5795d && this.f5792a.equals(qVar.f5792a)) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        int i = this.f5793b;
        int i6 = this.f5794c;
        int i10 = this.f5795d;
        this.f5792a.getClass();
        return (((i << 11) + (i6 << 6)) + i10) ^ ((i & (-2048)) ^ 2100100019);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 6, this);
    }
}
