package j$.time.temporal;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class u implements Serializable {
    private static final long serialVersionUID = -7317881728594519368L;

    /* renamed from: a, reason: collision with root package name */
    public final long f5921a;

    /* renamed from: b, reason: collision with root package name */
    public final long f5922b;

    /* renamed from: c, reason: collision with root package name */
    public final long f5923c;

    /* renamed from: d, reason: collision with root package name */
    public final long f5924d;

    public static u e(long j, long j6) {
        if (j > j6) {
            j$.time.g.c("Minimum value must be less than maximum value");
            return null;
        }
        return new u(j, j, j6, j6);
    }

    public static u f(long j, long j6) {
        if (j > j6) {
            j$.time.g.c("Smallest maximum value must be less than largest maximum value");
            return null;
        }
        if (1 > j6) {
            j$.time.g.c("Minimum value must be less than maximum value");
            return null;
        }
        return new u(1L, 1L, j, j6);
    }

    public u(long j, long j6, long j10, long j11) {
        this.f5921a = j;
        this.f5922b = j6;
        this.f5923c = j10;
        this.f5924d = j11;
    }

    public final int a(long j, q qVar) {
        if (this.f5921a < -2147483648L || this.f5924d > 2147483647L || !d(j)) {
            throw new j$.time.b(c(j, qVar));
        }
        return (int) j;
    }

    public final boolean d(long j) {
        return j >= this.f5921a && j <= this.f5924d;
    }

    public final void b(long j, q qVar) {
        if (!d(j)) {
            throw new j$.time.b(c(j, qVar));
        }
    }

    public final String c(long j, q qVar) {
        if (qVar != null) {
            return "Invalid value for " + qVar + " (valid values " + this + "): " + j;
        }
        return "Invalid value (valid values " + this + "): " + j;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
        long j = this.f5921a;
        long j6 = this.f5922b;
        if (j > j6) {
            throw new InvalidObjectException("Smallest minimum value must be less than largest minimum value");
        }
        long j10 = this.f5923c;
        long j11 = this.f5924d;
        if (j10 > j11) {
            throw new InvalidObjectException("Smallest maximum value must be less than largest maximum value");
        }
        if (j6 > j11) {
            throw new InvalidObjectException("Minimum value must be less than maximum value");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof u) {
            u uVar = (u) obj;
            if (this.f5921a == uVar.f5921a && this.f5922b == uVar.f5922b && this.f5923c == uVar.f5923c && this.f5924d == uVar.f5924d) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j = this.f5921a;
        long j6 = this.f5922b;
        long j10 = j + (j6 << 16) + (j6 >> 48);
        long j11 = this.f5923c;
        long j12 = j10 + (j11 << 32) + (j11 >> 32);
        long j13 = this.f5924d;
        long j14 = j12 + (j13 << 48) + (j13 >> 16);
        return (int) (j14 ^ (j14 >>> 32));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f5921a);
        if (this.f5921a != this.f5922b) {
            sb.append('/');
            sb.append(this.f5922b);
        }
        sb.append(" - ");
        sb.append(this.f5923c);
        if (this.f5923c != this.f5924d) {
            sb.append('/');
            sb.append(this.f5924d);
        }
        return sb.toString();
    }
}
