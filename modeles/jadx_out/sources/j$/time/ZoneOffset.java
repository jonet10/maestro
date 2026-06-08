package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class ZoneOffset extends ZoneId implements j$.time.temporal.n, j$.time.temporal.o, Comparable<ZoneOffset>, Serializable {
    private static final long serialVersionUID = 2357656521762053153L;

    /* renamed from: b, reason: collision with root package name */
    public final int f5751b;

    /* renamed from: c, reason: collision with root package name */
    public final transient String f5752c;

    /* renamed from: d, reason: collision with root package name */
    public static final ConcurrentHashMap f5749d = new ConcurrentHashMap(16, 0.75f, 4);

    /* renamed from: e, reason: collision with root package name */
    public static final ConcurrentHashMap f5750e = new ConcurrentHashMap(16, 0.75f, 4);
    public static final ZoneOffset UTC = C(0);
    public static final ZoneOffset f = C(-64800);
    public static final ZoneOffset g = C(64800);

    @Override // java.lang.Comparable
    public final int compareTo(ZoneOffset zoneOffset) {
        return zoneOffset.f5751b - this.f5751b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:20:0x008f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static j$.time.ZoneOffset A(java.lang.String r7) {
        /*
            java.lang.String r0 = "offsetId"
            j$.util.Objects.requireNonNull(r7, r0)
            j$.util.concurrent.ConcurrentHashMap r0 = j$.time.ZoneOffset.f5750e
            java.lang.Object r0 = r0.get(r7)
            j$.time.ZoneOffset r0 = (j$.time.ZoneOffset) r0
            if (r0 == 0) goto L10
            return r0
        L10:
            int r0 = r7.length()
            r1 = 2
            r2 = 1
            r3 = 0
            if (r0 == r1) goto L63
            r1 = 3
            if (r0 == r1) goto L7f
            r4 = 5
            if (r0 == r4) goto L5a
            r5 = 6
            r6 = 4
            if (r0 == r5) goto L50
            r5 = 7
            if (r0 == r5) goto L43
            r1 = 9
            if (r0 != r1) goto L37
            int r0 = D(r7, r2, r3)
            int r1 = D(r7, r6, r2)
            int r2 = D(r7, r5, r2)
            goto L85
        L37:
            j$.time.b r0 = new j$.time.b
            java.lang.String r1 = "Invalid ID for ZoneOffset, invalid format: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L43:
            int r0 = D(r7, r2, r3)
            int r1 = D(r7, r1, r3)
            int r2 = D(r7, r4, r3)
            goto L85
        L50:
            int r0 = D(r7, r2, r3)
            int r1 = D(r7, r6, r2)
        L58:
            r2 = r3
            goto L85
        L5a:
            int r0 = D(r7, r2, r3)
            int r1 = D(r7, r1, r3)
            goto L58
        L63:
            char r0 = r7.charAt(r3)
            char r7 = r7.charAt(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "0"
            r1.append(r0)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
        L7f:
            int r0 = D(r7, r2, r3)
            r1 = r3
            r2 = r1
        L85:
            char r3 = r7.charAt(r3)
            r4 = 43
            r5 = 45
            if (r3 == r4) goto L9e
            if (r3 != r5) goto L92
            goto L9e
        L92:
            j$.time.b r0 = new j$.time.b
            java.lang.String r1 = "Invalid ID for ZoneOffset, plus/minus not found when expected: "
            java.lang.String r7 = r1.concat(r7)
            r0.<init>(r7)
            throw r0
        L9e:
            if (r3 != r5) goto La8
            int r7 = -r0
            int r0 = -r1
            int r1 = -r2
            j$.time.ZoneOffset r7 = B(r7, r0, r1)
            return r7
        La8:
            j$.time.ZoneOffset r7 = B(r0, r1, r2)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.time.ZoneOffset.A(java.lang.String):j$.time.ZoneOffset");
    }

    @Override // j$.time.ZoneId
    public final j$.time.zone.f v() {
        Objects.requireNonNull(this, TypedValues.CycleType.S_WAVE_OFFSET);
        return new j$.time.zone.f(this);
    }

    public static int D(CharSequence charSequence, int i, boolean z9) {
        if (z9) {
            String str = (String) charSequence;
            if (str.charAt(i - 1) != ':') {
                g.h(str, "Invalid ID for ZoneOffset, colon not found when expected: ");
                return 0;
            }
        }
        String str2 = (String) charSequence;
        char charAt = str2.charAt(i);
        char charAt2 = str2.charAt(i + 1);
        if (charAt < '0' || charAt > '9' || charAt2 < '0' || charAt2 > '9') {
            g.h(str2, "Invalid ID for ZoneOffset, non numeric characters found: ");
            return 0;
        }
        return (charAt2 - '0') + ((charAt - '0') * 10);
    }

    public static ZoneOffset B(int i, int i6, int i10) {
        if (i < -18 || i > 18) {
            g.e("Zone offset hours not in valid range: value ", i, " is not in the range -18 to 18");
            return null;
        }
        if (i > 0) {
            if (i6 < 0 || i10 < 0) {
                throw new b("Zone offset minutes and seconds must be positive because hours is positive");
            }
        } else if (i < 0) {
            if (i6 > 0 || i10 > 0) {
                throw new b("Zone offset minutes and seconds must be negative because hours is negative");
            }
        } else if ((i6 > 0 && i10 < 0) || (i6 < 0 && i10 > 0)) {
            throw new b("Zone offset minutes and seconds must have the same sign");
        }
        if (i6 < -59 || i6 > 59) {
            g.e("Zone offset minutes not in valid range: value ", i6, " is not in the range -59 to 59");
            return null;
        }
        if (i10 < -59 || i10 > 59) {
            g.e("Zone offset seconds not in valid range: value ", i10, " is not in the range -59 to 59");
            return null;
        }
        if (Math.abs(i) == 18 && (i6 | i10) != 0) {
            throw new b("Zone offset not in valid range: -18:00 to +18:00");
        }
        return C((i6 * 60) + (i * 3600) + i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ZoneOffset C(int i) {
        if (i < -64800 || i > 64800) {
            throw new b("Zone offset not in valid range: -18:00 to +18:00");
        }
        if (i % 900 == 0) {
            Integer valueOf = Integer.valueOf(i);
            ConcurrentHashMap concurrentHashMap = f5749d;
            ZoneOffset zoneOffset = (ZoneOffset) concurrentHashMap.get(valueOf);
            if (zoneOffset != null) {
                return zoneOffset;
            }
            concurrentHashMap.putIfAbsent(valueOf, new ZoneOffset(i));
            ZoneOffset zoneOffset2 = (ZoneOffset) concurrentHashMap.get(valueOf);
            f5750e.putIfAbsent(zoneOffset2.f5752c, zoneOffset2);
            return zoneOffset2;
        }
        return new ZoneOffset(i);
    }

    public ZoneOffset(int i) {
        String sb;
        this.f5751b = i;
        if (i == 0) {
            sb = "Z";
        } else {
            int abs = Math.abs(i);
            StringBuilder sb2 = new StringBuilder();
            int i6 = abs / 3600;
            int i10 = (abs / 60) % 60;
            sb2.append(i < 0 ? "-" : "+");
            sb2.append(i6 < 10 ? "0" : "");
            sb2.append(i6);
            sb2.append(i10 < 10 ? ":0" : ":");
            sb2.append(i10);
            int i11 = abs % 60;
            if (i11 != 0) {
                sb2.append(i11 < 10 ? ":0" : ":");
                sb2.append(i11);
            }
            sb = sb2.toString();
        }
        this.f5752c = sb;
    }

    @Override // j$.time.ZoneId
    public final String d() {
        return this.f5752c;
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        return qVar instanceof j$.time.temporal.a ? qVar == j$.time.temporal.a.OFFSET_SECONDS : qVar != null && qVar.e(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.f5751b;
        }
        if (c.b(qVar)) {
            throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
        return j$.time.temporal.r.d(this, qVar).a(q(qVar), qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (qVar == j$.time.temporal.a.OFFSET_SECONDS) {
            return this.f5751b;
        }
        if (qVar instanceof j$.time.temporal.a) {
            throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
        return qVar.g(this);
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        return (aVar == j$.time.temporal.r.f5919d || aVar == j$.time.temporal.r.f5920e) ? this : j$.time.temporal.r.c(this, aVar);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return mVar.a(this.f5751b, j$.time.temporal.a.OFFSET_SECONDS);
    }

    @Override // j$.time.ZoneId
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ZoneOffset) && this.f5751b == ((ZoneOffset) obj).f5751b;
    }

    @Override // j$.time.ZoneId
    public final int hashCode() {
        return this.f5751b;
    }

    @Override // j$.time.ZoneId
    public final String toString() {
        return this.f5752c;
    }

    private Object writeReplace() {
        return new s((byte) 8, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // j$.time.ZoneId
    public final void z(DataOutput dataOutput) {
        dataOutput.writeByte(8);
        F(dataOutput);
    }

    public final void F(DataOutput dataOutput) {
        int i = this.f5751b;
        int i6 = i % 900 == 0 ? i / 900 : 127;
        dataOutput.writeByte(i6);
        if (i6 == 127) {
            dataOutput.writeInt(i);
        }
    }

    public static ZoneOffset E(DataInput dataInput) {
        byte readByte = dataInput.readByte();
        return readByte == Byte.MAX_VALUE ? C(dataInput.readInt()) : C(readByte * 900);
    }
}
