package i7;

import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public class b implements Iterable, e7.a {

    /* renamed from: a, reason: collision with root package name */
    public final int f5695a;

    /* renamed from: b, reason: collision with root package name */
    public final int f5696b;

    /* renamed from: l, reason: collision with root package name */
    public final int f5697l;

    public b(int i, int i6, int i10) {
        if (i10 == 0) {
            com.google.gson.internal.a.p("Step must be non-zero.");
            throw null;
        }
        if (i10 == Integer.MIN_VALUE) {
            com.google.gson.internal.a.p("Step must be greater than Int.MIN_VALUE to avoid overflow on negation.");
            throw null;
        }
        this.f5695a = i;
        if (i10 > 0) {
            if (i < i6) {
                int i11 = i6 % i10;
                int i12 = i % i10;
                int i13 = ((i11 < 0 ? i11 + i10 : i11) - (i12 < 0 ? i12 + i10 : i12)) % i10;
                i6 -= i13 < 0 ? i13 + i10 : i13;
            }
        } else {
            if (i10 >= 0) {
                com.google.gson.internal.a.p("Step is zero.");
                throw null;
            }
            if (i > i6) {
                int i14 = -i10;
                int i15 = i % i14;
                int i16 = i6 % i14;
                int i17 = ((i15 < 0 ? i15 + i14 : i15) - (i16 < 0 ? i16 + i14 : i16)) % i14;
                i6 += i17 < 0 ? i17 + i14 : i17;
            }
        }
        this.f5696b = i6;
        this.f5697l = i10;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof b)) {
            return false;
        }
        if (isEmpty() && ((b) obj).isEmpty()) {
            return true;
        }
        b bVar = (b) obj;
        return this.f5695a == bVar.f5695a && this.f5696b == bVar.f5696b && this.f5697l == bVar.f5697l;
    }

    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (((this.f5695a * 31) + this.f5696b) * 31) + this.f5697l;
    }

    public boolean isEmpty() {
        int i = this.f5696b;
        int i6 = this.f5697l;
        int i10 = this.f5695a;
        return i6 > 0 ? i10 > i : i10 < i;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new c(this.f5695a, this.f5696b, this.f5697l);
    }

    public String toString() {
        StringBuilder sb;
        int i = this.f5696b;
        int i6 = this.f5697l;
        int i10 = this.f5695a;
        if (i6 > 0) {
            sb = new StringBuilder();
            sb.append(i10);
            sb.append("..");
            sb.append(i);
            sb.append(" step ");
            sb.append(i6);
        } else {
            sb = new StringBuilder();
            sb.append(i10);
            sb.append(" downTo ");
            sb.append(i);
            sb.append(" step ");
            sb.append(-i6);
        }
        return sb.toString();
    }
}
