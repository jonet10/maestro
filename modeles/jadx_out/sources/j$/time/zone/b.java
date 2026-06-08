package j$.time.zone;

import j$.time.LocalDateTime;
import j$.time.ZoneOffset;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class b implements Comparable, Serializable {

    /* renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f5936e = 0;
    private static final long serialVersionUID = -6946044323557704546L;

    /* renamed from: a, reason: collision with root package name */
    public final long f5937a;

    /* renamed from: b, reason: collision with root package name */
    public final LocalDateTime f5938b;

    /* renamed from: c, reason: collision with root package name */
    public final ZoneOffset f5939c;

    /* renamed from: d, reason: collision with root package name */
    public final ZoneOffset f5940d;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return Long.compare(this.f5937a, ((b) obj).f5937a);
    }

    public b(LocalDateTime localDateTime, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        localDateTime.getClass();
        this.f5937a = j$.com.android.tools.r8.a.t(localDateTime, zoneOffset);
        this.f5938b = localDateTime;
        this.f5939c = zoneOffset;
        this.f5940d = zoneOffset2;
    }

    public b(long j, ZoneOffset zoneOffset, ZoneOffset zoneOffset2) {
        this.f5937a = j;
        this.f5938b = LocalDateTime.z(j, 0, zoneOffset);
        this.f5939c = zoneOffset;
        this.f5940d = zoneOffset2;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new a((byte) 2, this);
    }

    public final boolean e() {
        return this.f5940d.f5751b > this.f5939c.f5751b;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f5937a == bVar.f5937a && this.f5939c.equals(bVar.f5939c) && this.f5940d.equals(bVar.f5940d)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (this.f5938b.hashCode() ^ this.f5939c.f5751b) ^ Integer.rotateLeft(this.f5940d.f5751b, 16);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Transition[");
        sb.append(e() ? "Gap" : "Overlap");
        sb.append(" at ");
        sb.append(this.f5938b);
        sb.append(this.f5939c);
        sb.append(" to ");
        sb.append(this.f5940d);
        sb.append(']');
        return sb.toString();
    }
}
