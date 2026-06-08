package j$.time.chrono;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class x extends d {

    /* renamed from: d, reason: collision with root package name */
    public static final j$.time.h f5802d = j$.time.h.D(1873, 1, 1);
    private static final long serialVersionUID = -305327627230580483L;

    /* renamed from: a, reason: collision with root package name */
    public final transient j$.time.h f5803a;

    /* renamed from: b, reason: collision with root package name */
    public final transient y f5804b;

    /* renamed from: c, reason: collision with root package name */
    public final transient int f5805c;

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final e s(j$.time.k kVar) {
        return new g(this, kVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0022, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0020, code lost:
    
        if (r6.r() < r0.r()) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0013, code lost:
    
        if (r6.v(r0) < 0) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0024, code lost:
    
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public x(j$.time.h r6) {
        /*
            r5 = this;
            r5.<init>()
            j$.time.h r0 = j$.time.chrono.x.f5802d
            boolean r1 = j$.time.c.b(r0)
            r2 = 1
            if (r1 == 0) goto L16
            r6.getClass()
            int r0 = r6.v(r0)
            if (r0 >= 0) goto L24
            goto L22
        L16:
            long r3 = r6.r()
            long r0 = r0.r()
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 >= 0) goto L24
        L22:
            r0 = r2
            goto L25
        L24:
            r0 = 0
        L25:
            if (r0 != 0) goto L3a
            j$.time.chrono.y r0 = j$.time.chrono.y.d(r6)
            r5.f5804b = r0
            int r1 = r6.f5866a
            j$.time.h r0 = r0.f5809b
            int r0 = r0.f5866a
            int r1 = r1 - r0
            int r1 = r1 + r2
            r5.f5805c = r1
            r5.f5803a = r6
            return
        L3a:
            j$.time.b r6 = new j$.time.b
            java.lang.String r0 = "JapaneseDate before Meiji 6 is not supported"
            r6.<init>(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.x.<init>(j$.time.h):void");
    }

    @Override // j$.time.chrono.b
    public final l getChronology() {
        return v.f5800c;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final int hashCode() {
        v.f5800c.getClass();
        return this.f5803a.hashCode() ^ (-688086063);
    }

    @Override // j$.time.chrono.d
    public final m w() {
        return this.f5804b;
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_MONTH || qVar == j$.time.temporal.a.ALIGNED_DAY_OF_WEEK_IN_YEAR || qVar == j$.time.temporal.a.ALIGNED_WEEK_OF_MONTH || qVar == j$.time.temporal.a.ALIGNED_WEEK_OF_YEAR) {
            return false;
        }
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).isDateBased();
        }
        return qVar != null && qVar.e(this);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0071  */
    @Override // j$.time.chrono.d, j$.time.temporal.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.time.temporal.u g(j$.time.temporal.q r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof j$.time.temporal.a
            if (r0 == 0) goto L99
            boolean r0 = r5.c(r6)
            if (r0 == 0) goto L8d
            j$.time.temporal.a r6 = (j$.time.temporal.a) r6
            int[] r0 = j$.time.chrono.w.f5801a
            int r1 = r6.ordinal()
            r0 = r0[r1]
            r1 = 1
            r2 = 1
            if (r0 == r1) goto L81
            r4 = 2
            if (r0 == r4) goto L48
            r4 = 3
            if (r0 == r4) goto L26
            j$.time.chrono.v r0 = j$.time.chrono.v.f5800c
            j$.time.temporal.u r6 = r0.f(r6)
            return r6
        L26:
            j$.time.chrono.y r6 = r5.f5804b
            j$.time.h r0 = r6.f5809b
            int r0 = r0.f5866a
            j$.time.chrono.y r6 = r6.i()
            if (r6 == 0) goto L3e
            j$.time.h r6 = r6.f5809b
            int r6 = r6.f5866a
            int r6 = r6 - r0
            int r6 = r6 + r1
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.e(r2, r0)
            return r6
        L3e:
            r6 = 999999999(0x3b9ac9ff, float:0.004723787)
            int r6 = r6 - r0
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.e(r2, r0)
            return r6
        L48:
            j$.time.chrono.y r6 = r5.f5804b
            j$.time.chrono.y r6 = r6.i()
            if (r6 == 0) goto L60
            j$.time.h r6 = r6.f5809b
            int r0 = r6.f5866a
            j$.time.h r4 = r5.f5803a
            int r4 = r4.f5866a
            if (r0 != r4) goto L60
            int r6 = r6.A()
            int r6 = r6 - r1
            goto L6d
        L60:
            j$.time.h r6 = r5.f5803a
            boolean r6 = r6.B()
            if (r6 == 0) goto L6b
            r6 = 366(0x16e, float:5.13E-43)
            goto L6d
        L6b:
            r6 = 365(0x16d, float:5.11E-43)
        L6d:
            int r0 = r5.f5805c
            if (r0 != r1) goto L7b
            j$.time.chrono.y r0 = r5.f5804b
            j$.time.h r0 = r0.f5809b
            int r0 = r0.A()
            int r0 = r0 - r1
            int r6 = r6 - r0
        L7b:
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.e(r2, r0)
            return r6
        L81:
            j$.time.h r6 = r5.f5803a
            int r6 = r6.C()
            long r0 = (long) r6
            j$.time.temporal.u r6 = j$.time.temporal.u.e(r2, r0)
            return r6
        L8d:
            j$.time.temporal.t r0 = new j$.time.temporal.t
            java.lang.String r1 = "Unsupported field: "
            java.lang.String r6 = j$.time.c.a(r1, r6)
            r0.<init>(r6)
            throw r0
        L99:
            j$.time.temporal.u r6 = r6.f(r5)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.chrono.x.g(j$.time.temporal.q):j$.time.temporal.u");
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return qVar.g(this);
        }
        switch (w.f5801a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 2:
                int i = this.f5805c;
                j$.time.h hVar = this.f5803a;
                return i == 1 ? (hVar.A() - this.f5804b.f5809b.A()) + 1 : hVar.A();
            case 3:
                return this.f5805c;
            case 4:
            case 5:
            case 6:
            case 7:
                throw new j$.time.temporal.t(j$.time.c.a("Unsupported field: ", qVar));
            case 8:
                return this.f5804b.f5808a;
            default:
                return this.f5803a.q(qVar);
        }
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    /* renamed from: C, reason: merged with bridge method [inline-methods] */
    public final x a(long j, j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
            if (q(aVar) == j) {
                return this;
            }
            int[] iArr = w.f5801a;
            int i = iArr[aVar.ordinal()];
            if (i == 3 || i == 8 || i == 9) {
                int a8 = v.f5800c.f(aVar).a(j, aVar);
                int i6 = iArr[aVar.ordinal()];
                if (i6 == 3) {
                    return E(this.f5804b, a8);
                }
                if (i6 == 8) {
                    return E(y.l(a8), this.f5805c);
                }
                if (i6 == 9) {
                    return D(this.f5803a.N(a8));
                }
            }
            return D(this.f5803a.a(j, qVar));
        }
        return (x) super.a(j, qVar);
    }

    @Override // j$.time.chrono.d
    /* renamed from: B */
    public final b f(j$.time.temporal.o oVar) {
        return (x) super.f(oVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m f(j$.time.h hVar) {
        return (x) super.f(hVar);
    }

    public final x E(y yVar, int i) {
        v.f5800c.getClass();
        if (yVar == null) {
            throw new ClassCastException("Era must be JapaneseEra");
        }
        int i6 = yVar.f5809b.f5866a;
        int i10 = (i6 + i) - 1;
        if (i != 1 && (i10 < -999999999 || i10 > 999999999 || i10 < i6 || yVar != y.d(j$.time.h.D(i10, 1, 1)))) {
            throw new j$.time.b("Invalid yearOfEra value");
        }
        return D(this.f5803a.N(i10));
    }

    @Override // j$.time.chrono.d
    public final b A(long j) {
        return D(this.f5803a.I(j));
    }

    @Override // j$.time.chrono.d
    public final b z(long j) {
        return D(this.f5803a.H(j));
    }

    @Override // j$.time.chrono.d
    public final b y(long j) {
        return D(this.f5803a.G(j));
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b, j$.time.temporal.m
    public final b b(long j, j$.time.temporal.s sVar) {
        return (x) super.b(j, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m b(long j, j$.time.temporal.s sVar) {
        return (x) super.b(j, sVar);
    }

    @Override // j$.time.chrono.d, j$.time.temporal.m
    public final j$.time.temporal.m n(long j, j$.time.temporal.b bVar) {
        return (x) super.n(j, bVar);
    }

    @Override // j$.time.chrono.d
    /* renamed from: x */
    public final b n(long j, j$.time.temporal.s sVar) {
        return (x) super.n(j, sVar);
    }

    public final x D(j$.time.h hVar) {
        return hVar.equals(this.f5803a) ? this : new x(hVar);
    }

    @Override // j$.time.chrono.d, j$.time.chrono.b
    public final long r() {
        return this.f5803a.r();
    }

    @Override // j$.time.chrono.d
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof x) {
            return this.f5803a.equals(((x) obj).f5803a);
        }
        return false;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new e0((byte) 4, this);
    }
}
