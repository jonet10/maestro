package j$.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.math.BigInteger;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class Duration implements Comparable<Duration>, Serializable {

    /* renamed from: c, reason: collision with root package name */
    public static final Duration f5733c = new Duration(0, 0);
    private static final long serialVersionUID = 3078945930695997490L;

    /* renamed from: a, reason: collision with root package name */
    public final long f5734a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5735b;

    @Override // java.lang.Comparable
    public final int compareTo(Duration duration) {
        Duration duration2 = duration;
        int compare = Long.compare(this.f5734a, duration2.f5734a);
        return compare != 0 ? compare : this.f5735b - duration2.f5735b;
    }

    static {
        BigInteger.valueOf(1000000000L);
    }

    public static Duration ofMillis(long j) {
        long j6 = j / 1000;
        int i = (int) (j % 1000);
        if (i < 0) {
            i += 1000;
            j6--;
        }
        return e(j6, i * 1000000);
    }

    public static Duration f(long j) {
        long j6 = j / 1000000000;
        int i = (int) (j % 1000000000);
        if (i < 0) {
            i = (int) (i + 1000000000);
            j6--;
        }
        return e(j6, i);
    }

    public static Duration e(long j, int i) {
        if ((i | j) == 0) {
            return f5733c;
        }
        return new Duration(j, i);
    }

    public Duration(long j, int i) {
        this.f5734a = j;
        this.f5735b = i;
    }

    public long toMillis() {
        long j = this.f5734a;
        long j6 = this.f5735b;
        if (j < 0) {
            j++;
            j6 -= 1000000000;
        }
        return j$.com.android.tools.r8.a.x(j$.com.android.tools.r8.a.w(j, 1000), j6 / 1000000);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Duration) {
            Duration duration = (Duration) obj;
            if (this.f5734a == duration.f5734a && this.f5735b == duration.f5735b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        long j = this.f5734a;
        return (this.f5735b * 51) + ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        if (this == f5733c) {
            return "PT0S";
        }
        long j = this.f5734a;
        if (j < 0 && this.f5735b > 0) {
            j++;
        }
        long j6 = j / 3600;
        int i = (int) ((j % 3600) / 60);
        int i6 = (int) (j % 60);
        StringBuilder sb = new StringBuilder(24);
        sb.append("PT");
        if (j6 != 0) {
            sb.append(j6);
            sb.append('H');
        }
        if (i != 0) {
            sb.append(i);
            sb.append('M');
        }
        if (i6 == 0 && this.f5735b == 0 && sb.length() > 2) {
            return sb.toString();
        }
        if (this.f5734a >= 0 || this.f5735b <= 0) {
            sb.append(i6);
        } else if (i6 == 0) {
            sb.append("-0");
        } else {
            sb.append(i6);
        }
        if (this.f5735b > 0) {
            int length = sb.length();
            long j10 = this.f5734a;
            int i10 = this.f5735b;
            if (j10 < 0) {
                sb.append(2000000000 - i10);
            } else {
                sb.append(i10 + 1000000000);
            }
            while (sb.charAt(sb.length() - 1) == '0') {
                sb.setLength(sb.length() - 1);
            }
            sb.setCharAt(length, '.');
        }
        sb.append('S');
        return sb.toString();
    }

    private Object writeReplace() {
        return new s((byte) 1, this);
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }
}
