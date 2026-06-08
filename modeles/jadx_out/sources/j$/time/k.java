package j$.time;

import androidx.core.location.LocationRequestCompat;
import j$.util.Objects;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class k implements j$.time.temporal.m, j$.time.temporal.o, Comparable, Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final k f5872e;
    public static final k f;
    public static final k g;
    public static final k[] h = new k[24];
    private static final long serialVersionUID = 6414437269572265201L;

    /* renamed from: a, reason: collision with root package name */
    public final byte f5873a;

    /* renamed from: b, reason: collision with root package name */
    public final byte f5874b;

    /* renamed from: c, reason: collision with root package name */
    public final byte f5875c;

    /* renamed from: d, reason: collision with root package name */
    public final int f5876d;

    static {
        int i = 0;
        while (true) {
            k[] kVarArr = h;
            if (i < kVarArr.length) {
                kVarArr[i] = new k(i, 0, 0, 0);
                i++;
            } else {
                k kVar = kVarArr[0];
                g = kVar;
                k kVar2 = kVarArr[12];
                f5872e = kVar;
                f = new k(23, 59, 59, 999999999);
                return;
            }
        }
    }

    public static k z(long j) {
        j$.time.temporal.a.NANO_OF_DAY.k(j);
        int i = (int) (j / 3600000000000L);
        long j6 = j - (i * 3600000000000L);
        int i6 = (int) (j6 / 60000000000L);
        long j10 = j6 - (i6 * 60000000000L);
        int i10 = (int) (j10 / 1000000000);
        return w(i, i6, i10, (int) (j10 - (i10 * 1000000000)));
    }

    public static k x(j$.time.temporal.n nVar) {
        Objects.requireNonNull(nVar, "temporal");
        k kVar = (k) nVar.k(j$.time.temporal.r.g);
        if (kVar != null) {
            return kVar;
        }
        throw new b("Unable to obtain LocalTime from TemporalAccessor: " + nVar + " of type " + nVar.getClass().getName());
    }

    public static k w(int i, int i6, int i10, int i11) {
        if ((i6 | i10 | i11) == 0) {
            return h[i];
        }
        return new k(i, i6, i10, i11);
    }

    public k(int i, int i6, int i10, int i11) {
        this.f5873a = (byte) i;
        this.f5874b = (byte) i6;
        this.f5875c = (byte) i10;
        this.f5876d = i11;
    }

    @Override // j$.time.temporal.n
    public final boolean c(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return ((j$.time.temporal.a) qVar).n();
        }
        return qVar != null && qVar.e(this);
    }

    @Override // j$.time.temporal.n
    public final j$.time.temporal.u g(j$.time.temporal.q qVar) {
        return j$.time.temporal.r.d(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final int e(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            return y(qVar);
        }
        return j$.time.temporal.r.a(this, qVar);
    }

    @Override // j$.time.temporal.n
    public final long q(j$.time.temporal.q qVar) {
        if (qVar instanceof j$.time.temporal.a) {
            if (qVar == j$.time.temporal.a.NANO_OF_DAY) {
                return G();
            }
            if (qVar == j$.time.temporal.a.MICRO_OF_DAY) {
                return G() / 1000;
            }
            return y(qVar);
        }
        return qVar.g(this);
    }

    public final int y(j$.time.temporal.q qVar) {
        switch (j.f5870a[((j$.time.temporal.a) qVar).ordinal()]) {
            case 1:
                return this.f5876d;
            case 2:
                throw new j$.time.temporal.t("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
            case 3:
                return this.f5876d / 1000;
            case 4:
                throw new j$.time.temporal.t("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
            case 5:
                return this.f5876d / 1000000;
            case 6:
                return (int) (G() / 1000000);
            case 7:
                return this.f5875c;
            case 8:
                return H();
            case 9:
                return this.f5874b;
            case 10:
                return (this.f5873a * 60) + this.f5874b;
            case 11:
                return this.f5873a % 12;
            case 12:
                int i = this.f5873a % 12;
                if (i % 12 == 0) {
                    return 12;
                }
                return i;
            case 13:
                return this.f5873a;
            case 14:
                byte b7 = this.f5873a;
                if (b7 == 0) {
                    return 24;
                }
                return b7;
            case 15:
                return this.f5873a / 12;
            default:
                throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
    }

    @Override // j$.time.temporal.m
    /* renamed from: I, reason: merged with bridge method [inline-methods] */
    public final k a(long j, j$.time.temporal.q qVar) {
        if (!(qVar instanceof j$.time.temporal.a)) {
            return (k) qVar.j(this, j);
        }
        j$.time.temporal.a aVar = (j$.time.temporal.a) qVar;
        aVar.k(j);
        switch (j.f5870a[aVar.ordinal()]) {
            case 1:
                return J((int) j);
            case 2:
                return z(j);
            case 3:
                return J(((int) j) * 1000);
            case 4:
                return z(j * 1000);
            case 5:
                return J(((int) j) * 1000000);
            case 6:
                return z(j * 1000000);
            case 7:
                int i = (int) j;
                if (this.f5875c != i) {
                    j$.time.temporal.a.SECOND_OF_MINUTE.k(i);
                    return w(this.f5873a, this.f5874b, i, this.f5876d);
                }
                return this;
            case 8:
                return E(j - H());
            case 9:
                int i6 = (int) j;
                if (this.f5874b != i6) {
                    j$.time.temporal.a.MINUTE_OF_HOUR.k(i6);
                    return w(this.f5873a, i6, this.f5875c, this.f5876d);
                }
                return this;
            case 10:
                return C(j - ((this.f5873a * 60) + this.f5874b));
            case 11:
                return B(j - (this.f5873a % 12));
            case 12:
                if (j == 12) {
                    j = 0;
                }
                return B(j - (this.f5873a % 12));
            case 13:
                int i10 = (int) j;
                if (this.f5873a != i10) {
                    j$.time.temporal.a.HOUR_OF_DAY.k(i10);
                    return w(i10, this.f5874b, this.f5875c, this.f5876d);
                }
                return this;
            case 14:
                if (j == 24) {
                    j = 0;
                }
                int i11 = (int) j;
                if (this.f5873a != i11) {
                    j$.time.temporal.a.HOUR_OF_DAY.k(i11);
                    return w(i11, this.f5874b, this.f5875c, this.f5876d);
                }
                return this;
            case 15:
                return B((j - (this.f5873a / 12)) * 12);
            default:
                throw new j$.time.temporal.t(c.a("Unsupported field: ", qVar));
        }
    }

    public final k J(int i) {
        if (this.f5876d == i) {
            return this;
        }
        j$.time.temporal.a.NANO_OF_SECOND.k(i);
        return w(this.f5873a, this.f5874b, this.f5875c, i);
    }

    @Override // j$.time.temporal.m
    /* renamed from: A, reason: merged with bridge method [inline-methods] */
    public final k b(long j, j$.time.temporal.s sVar) {
        if (sVar instanceof j$.time.temporal.b) {
            switch (j.f5871b[((j$.time.temporal.b) sVar).ordinal()]) {
                case 1:
                    return D(j);
                case 2:
                    return D((j % 86400000000L) * 1000);
                case 3:
                    return D((j % 86400000) * 1000000);
                case 4:
                    return E(j);
                case 5:
                    return C(j);
                case 6:
                    return B(j);
                case 7:
                    return B((j % 2) * 12);
                default:
                    g.b(sVar, "Unsupported unit: ");
                    return null;
            }
        }
        return (k) sVar.e(this, j);
    }

    public final k B(long j) {
        return j == 0 ? this : w(((((int) (j % 24)) + this.f5873a) + 24) % 24, this.f5874b, this.f5875c, this.f5876d);
    }

    public final k C(long j) {
        if (j != 0) {
            int i = (this.f5873a * 60) + this.f5874b;
            int i6 = ((((int) (j % 1440)) + i) + 1440) % 1440;
            if (i != i6) {
                return w(i6 / 60, i6 % 60, this.f5875c, this.f5876d);
            }
        }
        return this;
    }

    public final k E(long j) {
        if (j != 0) {
            int i = (this.f5874b * 60) + (this.f5873a * 3600) + this.f5875c;
            int i6 = ((((int) (j % 86400)) + i) + 86400) % 86400;
            if (i != i6) {
                return w(i6 / 3600, (i6 / 60) % 60, i6 % 60, this.f5876d);
            }
        }
        return this;
    }

    public final k D(long j) {
        if (j != 0) {
            long G = G();
            long j6 = (((j % 86400000000000L) + G) + 86400000000000L) % 86400000000000L;
            if (G != j6) {
                return w((int) (j6 / 3600000000000L), (int) ((j6 / 60000000000L) % 60), (int) ((j6 / 1000000000) % 60), (int) (j6 % 1000000000));
            }
        }
        return this;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m n(long j, j$.time.temporal.b bVar) {
        return j == Long.MIN_VALUE ? b(LocationRequestCompat.PASSIVE_INTERVAL, bVar).b(1L, bVar) : b(-j, bVar);
    }

    @Override // j$.time.temporal.n
    public final Object k(j$.time.format.a aVar) {
        if (aVar == j$.time.temporal.r.f5917b || aVar == j$.time.temporal.r.f5916a || aVar == j$.time.temporal.r.f5920e || aVar == j$.time.temporal.r.f5919d) {
            return null;
        }
        if (aVar == j$.time.temporal.r.g) {
            return this;
        }
        if (aVar == j$.time.temporal.r.f) {
            return null;
        }
        if (aVar == j$.time.temporal.r.f5918c) {
            return j$.time.temporal.b.NANOS;
        }
        return aVar.a(this);
    }

    @Override // j$.time.temporal.o
    public final j$.time.temporal.m j(j$.time.temporal.m mVar) {
        return mVar.a(G(), j$.time.temporal.a.NANO_OF_DAY);
    }

    public final int H() {
        return (this.f5874b * 60) + (this.f5873a * 3600) + this.f5875c;
    }

    public final long G() {
        return (this.f5875c * 1000000000) + (this.f5874b * 60000000000L) + (this.f5873a * 3600000000000L) + this.f5876d;
    }

    @Override // java.lang.Comparable
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public final int compareTo(k kVar) {
        int compare = Integer.compare(this.f5873a, kVar.f5873a);
        return (compare == 0 && (compare = Integer.compare(this.f5874b, kVar.f5874b)) == 0 && (compare = Integer.compare(this.f5875c, kVar.f5875c)) == 0) ? Integer.compare(this.f5876d, kVar.f5876d) : compare;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.f5873a == kVar.f5873a && this.f5874b == kVar.f5874b && this.f5875c == kVar.f5875c && this.f5876d == kVar.f5876d) {
                return true;
            }
        }
        return false;
    }

    @Override // j$.time.temporal.m
    public final j$.time.temporal.m f(h hVar) {
        return (k) j$.com.android.tools.r8.a.a(hVar, this);
    }

    public final int hashCode() {
        long G = G();
        return (int) (G ^ (G >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(18);
        byte b7 = this.f5873a;
        byte b10 = this.f5874b;
        byte b11 = this.f5875c;
        int i = this.f5876d;
        sb.append(b7 < 10 ? "0" : "");
        sb.append((int) b7);
        sb.append(b10 < 10 ? ":0" : ":");
        sb.append((int) b10);
        if (b11 > 0 || i > 0) {
            sb.append(b11 < 10 ? ":0" : ":");
            sb.append((int) b11);
            if (i > 0) {
                sb.append('.');
                if (i % 1000000 == 0) {
                    sb.append(Integer.toString((i / 1000000) + 1000).substring(1));
                } else if (i % 1000 == 0) {
                    sb.append(Integer.toString((i / 1000) + 1000000).substring(1));
                } else {
                    sb.append(Integer.toString(i + 1000000000).substring(1));
                }
            }
        }
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 4, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public final void K(DataOutput dataOutput) {
        if (this.f5876d == 0) {
            if (this.f5875c == 0) {
                byte b7 = this.f5874b;
                byte b10 = this.f5873a;
                if (b7 == 0) {
                    dataOutput.writeByte(~b10);
                    return;
                } else {
                    dataOutput.writeByte(b10);
                    dataOutput.writeByte(~this.f5874b);
                    return;
                }
            }
            dataOutput.writeByte(this.f5873a);
            dataOutput.writeByte(this.f5874b);
            dataOutput.writeByte(~this.f5875c);
            return;
        }
        dataOutput.writeByte(this.f5873a);
        dataOutput.writeByte(this.f5874b);
        dataOutput.writeByte(this.f5875c);
        dataOutput.writeInt(this.f5876d);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v4, types: [int] */
    public static k F(DataInput dataInput) {
        int readInt;
        int i;
        int readByte = dataInput.readByte();
        byte b7 = 0;
        if (readByte < 0) {
            readByte = ~readByte;
            i = 0;
            readInt = 0;
        } else {
            byte readByte2 = dataInput.readByte();
            if (readByte2 < 0) {
                ?? r72 = ~readByte2;
                readInt = 0;
                b7 = r72;
                i = 0;
            } else {
                byte readByte3 = dataInput.readByte();
                if (readByte3 < 0) {
                    i = ~readByte3;
                    readInt = 0;
                    b7 = readByte2;
                } else {
                    readInt = dataInput.readInt();
                    b7 = readByte2;
                    i = readByte3;
                }
            }
        }
        j$.time.temporal.a.HOUR_OF_DAY.k(readByte);
        j$.time.temporal.a.MINUTE_OF_HOUR.k(b7);
        j$.time.temporal.a.SECOND_OF_MINUTE.k(i);
        j$.time.temporal.a.NANO_OF_SECOND.k(readInt);
        return w(readByte, b7, i, readInt);
    }
}
