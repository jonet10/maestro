package j$.time.zone;

import j$.time.Instant;
import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import j$.time.chrono.s;
import j$.time.k;
import j$.time.m;
import j$.time.temporal.o;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class f implements Serializable {
    public static final long[] i = new long[0];
    public static final e[] j = new e[0];

    /* renamed from: k, reason: collision with root package name */
    public static final LocalDateTime[] f5948k = new LocalDateTime[0];

    /* renamed from: l, reason: collision with root package name */
    public static final b[] f5949l = new b[0];
    private static final long serialVersionUID = 3044319355680032515L;

    /* renamed from: a, reason: collision with root package name */
    public final long[] f5950a;

    /* renamed from: b, reason: collision with root package name */
    public final ZoneOffset[] f5951b;

    /* renamed from: c, reason: collision with root package name */
    public final long[] f5952c;

    /* renamed from: d, reason: collision with root package name */
    public final LocalDateTime[] f5953d;

    /* renamed from: e, reason: collision with root package name */
    public final ZoneOffset[] f5954e;
    public final e[] f;
    public final TimeZone g;
    public final transient ConcurrentHashMap h = new ConcurrentHashMap();

    public static Object a(LocalDateTime localDateTime, b bVar) {
        LocalDateTime localDateTime2 = bVar.f5938b;
        if (bVar.e()) {
            if (localDateTime.x(localDateTime2)) {
                return bVar.f5939c;
            }
            if (!localDateTime.x(bVar.f5938b.B(bVar.f5940d.f5751b - bVar.f5939c.f5751b))) {
                return bVar.f5940d;
            }
        } else {
            if (!localDateTime.x(localDateTime2)) {
                return bVar.f5940d;
            }
            if (localDateTime.x(bVar.f5938b.B(bVar.f5940d.f5751b - bVar.f5939c.f5751b))) {
                return bVar.f5939c;
            }
        }
        return bVar;
    }

    public f(long[] jArr, ZoneOffset[] zoneOffsetArr, long[] jArr2, ZoneOffset[] zoneOffsetArr2, e[] eVarArr) {
        this.f5950a = jArr;
        this.f5951b = zoneOffsetArr;
        this.f5952c = jArr2;
        this.f5954e = zoneOffsetArr2;
        this.f = eVarArr;
        if (jArr2.length == 0) {
            this.f5953d = f5948k;
        } else {
            ArrayList arrayList = new ArrayList();
            int i6 = 0;
            while (i6 < jArr2.length) {
                int i10 = i6 + 1;
                b bVar = new b(jArr2[i6], zoneOffsetArr2[i6], zoneOffsetArr2[i10]);
                boolean e10 = bVar.e();
                LocalDateTime localDateTime = bVar.f5938b;
                if (e10) {
                    arrayList.add(localDateTime);
                    arrayList.add(bVar.f5938b.B(bVar.f5940d.f5751b - bVar.f5939c.f5751b));
                } else {
                    arrayList.add(localDateTime.B(bVar.f5940d.f5751b - bVar.f5939c.f5751b));
                    arrayList.add(bVar.f5938b);
                }
                i6 = i10;
            }
            this.f5953d = (LocalDateTime[]) arrayList.toArray(new LocalDateTime[arrayList.size()]);
        }
        this.g = null;
    }

    public f(ZoneOffset zoneOffset) {
        ZoneOffset[] zoneOffsetArr = {zoneOffset};
        this.f5951b = zoneOffsetArr;
        long[] jArr = i;
        this.f5950a = jArr;
        this.f5952c = jArr;
        this.f5953d = f5948k;
        this.f5954e = zoneOffsetArr;
        this.f = j;
        this.g = null;
    }

    public f(TimeZone timeZone) {
        ZoneOffset[] zoneOffsetArr = {g(timeZone.getRawOffset())};
        this.f5951b = zoneOffsetArr;
        long[] jArr = i;
        this.f5950a = jArr;
        this.f5952c = jArr;
        this.f5953d = f5948k;
        this.f5954e = zoneOffsetArr;
        this.f = j;
        this.g = timeZone;
    }

    public static ZoneOffset g(int i6) {
        return ZoneOffset.C(i6 / 1000);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a(this.g != null ? (byte) 100 : (byte) 1, this);
    }

    public static int c(long j6, ZoneOffset zoneOffset) {
        return j$.time.h.E(j$.com.android.tools.r8.a.B(j6 + zoneOffset.f5751b, 86400)).f5866a;
    }

    public final ZoneOffset d(Instant instant) {
        TimeZone timeZone = this.g;
        if (timeZone != null) {
            return g(timeZone.getOffset(instant.toEpochMilli()));
        }
        long[] jArr = this.f5952c;
        if (jArr.length == 0) {
            return this.f5951b[0];
        }
        long j6 = instant.f5737a;
        if (this.f.length > 0 && j6 > jArr[jArr.length - 1]) {
            b[] b7 = b(c(j6, this.f5954e[r8.length - 1]));
            b bVar = null;
            for (int i6 = 0; i6 < b7.length; i6++) {
                bVar = b7[i6];
                if (j6 < bVar.f5937a) {
                    return bVar.f5939c;
                }
            }
            return bVar.f5940d;
        }
        int binarySearch = Arrays.binarySearch(jArr, j6);
        if (binarySearch < 0) {
            binarySearch = (-binarySearch) - 2;
        }
        return this.f5954e[binarySearch + 1];
    }

    public final List f(LocalDateTime localDateTime) {
        Object e10 = e(localDateTime);
        if (!(e10 instanceof b)) {
            return Collections.singletonList((ZoneOffset) e10);
        }
        b bVar = (b) e10;
        if (bVar.e()) {
            return Collections.EMPTY_LIST;
        }
        Object[] objArr = {bVar.f5939c, bVar.f5940d};
        ArrayList arrayList = new ArrayList(2);
        for (int i6 = 0; i6 < 2; i6++) {
            arrayList.add(Objects.requireNonNull(objArr[i6]));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0062, code lost:
    
        if (r8.v(r0) > 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0085, code lost:
    
        if (r8.f5742b.G() <= r0.f5742b.G()) goto L44;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object e(j$.time.LocalDateTime r8) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.zone.f.e(j$.time.LocalDateTime):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final b[] b(int i6) {
        j$.time.h w2;
        b[] bVarArr = f5949l;
        Integer valueOf = Integer.valueOf(i6);
        b[] bVarArr2 = (b[]) this.h.get(valueOf);
        if (bVarArr2 != null) {
            return bVarArr2;
        }
        long j6 = 1;
        final int i10 = 0;
        final int i11 = 1;
        if (this.g != null) {
            if (i6 < 1800) {
                return bVarArr;
            }
            LocalDateTime localDateTime = LocalDateTime.f5739c;
            j$.time.h D = j$.time.h.D(i6 - 1, 12, 31);
            j$.time.temporal.a.HOUR_OF_DAY.k(0);
            long t9 = j$.com.android.tools.r8.a.t(new LocalDateTime(D, k.h[0]), this.f5951b[0]);
            long j10 = 1000;
            int offset = this.g.getOffset(t9 * 1000);
            long j11 = 31968000 + t9;
            while (t9 < j11) {
                long j12 = t9 + 7776000;
                long j13 = j10;
                if (offset != this.g.getOffset(j12 * j13)) {
                    while (j12 - t9 > j6) {
                        long B = j$.com.android.tools.r8.a.B(j12 + t9, 2L);
                        if (this.g.getOffset(B * j13) == offset) {
                            t9 = B;
                        } else {
                            j12 = B;
                        }
                        j6 = 1;
                    }
                    if (this.g.getOffset(t9 * j13) == offset) {
                        t9 = j12;
                    }
                    ZoneOffset g = g(offset);
                    int offset2 = this.g.getOffset(t9 * j13);
                    ZoneOffset g3 = g(offset2);
                    if (c(t9, g3) == i6) {
                        bVarArr = (b[]) Arrays.copyOf(bVarArr, bVarArr.length + 1);
                        bVarArr[bVarArr.length - 1] = new b(t9, g, g3);
                    }
                    offset = offset2;
                } else {
                    t9 = j12;
                }
                j10 = j13;
                j6 = 1;
            }
            if (1916 <= i6 && i6 < 2100) {
                this.h.putIfAbsent(valueOf, bVarArr);
            }
            return bVarArr;
        }
        e[] eVarArr = this.f;
        b[] bVarArr3 = new b[eVarArr.length];
        int i12 = 0;
        while (i12 < eVarArr.length) {
            e eVar = eVarArr[i12];
            byte b7 = eVar.f5944b;
            m mVar = eVar.f5943a;
            if (b7 < 0) {
                long j14 = i6;
                s.f5797c.getClass();
                int w9 = mVar.w(s.f(j14)) + 1 + eVar.f5944b;
                j$.time.h hVar = j$.time.h.f5864d;
                j$.time.temporal.a.YEAR.k(j14);
                Objects.requireNonNull(mVar, "month");
                j$.time.temporal.a.DAY_OF_MONTH.k(w9);
                w2 = j$.time.h.w(i6, mVar.getValue(), w9);
                j$.time.d dVar = eVar.f5945c;
                if (dVar != null) {
                    final int value = dVar.getValue();
                    w2 = w2.f(new o() { // from class: j$.time.temporal.p
                        @Override // j$.time.temporal.o
                        public final m j(m mVar2) {
                            switch (i11) {
                                case 0:
                                    int e10 = mVar2.e(a.DAY_OF_WEEK);
                                    int i13 = value;
                                    if (e10 == i13) {
                                        return mVar2;
                                    }
                                    return mVar2.b(e10 - i13 >= 0 ? 7 - r0 : -r0, b.DAYS);
                                default:
                                    int e11 = mVar2.e(a.DAY_OF_WEEK);
                                    int i14 = value;
                                    if (e11 == i14) {
                                        return mVar2;
                                    }
                                    return mVar2.n(i14 - e11 >= 0 ? 7 - r1 : -r1, b.DAYS);
                            }
                        }
                    });
                }
            } else {
                j$.time.h hVar2 = j$.time.h.f5864d;
                j$.time.temporal.a.YEAR.k(i6);
                Objects.requireNonNull(mVar, "month");
                j$.time.temporal.a.DAY_OF_MONTH.k(b7);
                w2 = j$.time.h.w(i6, mVar.getValue(), b7);
                j$.time.d dVar2 = eVar.f5945c;
                if (dVar2 != null) {
                    final int value2 = dVar2.getValue();
                    w2 = w2.f(new o() { // from class: j$.time.temporal.p
                        @Override // j$.time.temporal.o
                        public final m j(m mVar2) {
                            switch (i10) {
                                case 0:
                                    int e10 = mVar2.e(a.DAY_OF_WEEK);
                                    int i13 = value2;
                                    if (e10 == i13) {
                                        return mVar2;
                                    }
                                    return mVar2.b(e10 - i13 >= 0 ? 7 - r0 : -r0, b.DAYS);
                                default:
                                    int e11 = mVar2.e(a.DAY_OF_WEEK);
                                    int i14 = value2;
                                    if (e11 == i14) {
                                        return mVar2;
                                    }
                                    return mVar2.n(i14 - e11 >= 0 ? 7 - r1 : -r1, b.DAYS);
                            }
                        }
                    });
                }
            }
            if (eVar.f5947e) {
                w2 = w2.G(1L);
            }
            LocalDateTime y9 = LocalDateTime.y(w2, eVar.f5946d);
            d dVar3 = eVar.f;
            ZoneOffset zoneOffset = eVar.g;
            ZoneOffset zoneOffset2 = eVar.h;
            dVar3.getClass();
            int i13 = c.f5941a[dVar3.ordinal()];
            if (i13 == 1) {
                y9 = y9.B(zoneOffset2.f5751b - ZoneOffset.UTC.f5751b);
            } else if (i13 == 2) {
                y9 = y9.B(zoneOffset2.f5751b - zoneOffset.f5751b);
            }
            bVarArr3[i12] = new b(y9, eVar.h, eVar.i);
            i12++;
            i10 = 0;
        }
        if (i6 < 2100) {
            this.h.putIfAbsent(valueOf, bVarArr3);
        }
        return bVarArr3;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof f) {
            f fVar = (f) obj;
            if (Objects.equals(this.g, fVar.g) && Arrays.equals(this.f5950a, fVar.f5950a) && Arrays.equals(this.f5951b, fVar.f5951b) && Arrays.equals(this.f5952c, fVar.f5952c) && Arrays.equals(this.f5954e, fVar.f5954e) && Arrays.equals(this.f, fVar.f)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((Objects.hashCode(this.g) ^ Arrays.hashCode(this.f5950a)) ^ Arrays.hashCode(this.f5951b)) ^ Arrays.hashCode(this.f5952c)) ^ Arrays.hashCode(this.f5954e)) ^ Arrays.hashCode(this.f);
    }

    public final String toString() {
        TimeZone timeZone = this.g;
        if (timeZone != null) {
            return "ZoneRules[timeZone=" + timeZone.getID() + "]";
        }
        return "ZoneRules[currentStandardOffset=" + this.f5951b[r0.length - 1] + "]";
    }
}
