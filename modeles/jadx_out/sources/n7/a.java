package n7;

import com.google.android.gms.internal.measurement.z3;
import java.io.Serializable;
import l7.u;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements Comparable, Serializable {

    /* renamed from: l, reason: collision with root package name */
    public static final a f8108l = new a(0, 0);

    /* renamed from: a, reason: collision with root package name */
    public final long f8109a;

    /* renamed from: b, reason: collision with root package name */
    public final long f8110b;

    public a(long j, long j6) {
        this.f8109a = j;
        this.f8110b = j6;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        a aVar = (a) obj;
        aVar.getClass();
        long j = aVar.f8109a;
        long j6 = this.f8109a;
        if (j6 != j) {
            return Long.compare(j6 ^ Long.MIN_VALUE, j ^ Long.MIN_VALUE);
        }
        return Long.compare(this.f8110b ^ Long.MIN_VALUE, aVar.f8110b ^ Long.MIN_VALUE);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f8109a == aVar.f8109a && this.f8110b == aVar.f8110b;
    }

    public final int hashCode() {
        long j = this.f8109a ^ this.f8110b;
        return (int) (j ^ (j >>> 32));
    }

    public final String toString() {
        byte[] bArr = new byte[36];
        z3.n(this.f8109a, bArr, 0, 0, 4);
        bArr[8] = 45;
        z3.n(this.f8109a, bArr, 9, 4, 6);
        bArr[13] = 45;
        z3.n(this.f8109a, bArr, 14, 6, 8);
        bArr[18] = 45;
        z3.n(this.f8110b, bArr, 19, 0, 2);
        bArr[23] = 45;
        z3.n(this.f8110b, bArr, 24, 2, 8);
        return u.j0(bArr);
    }
}
