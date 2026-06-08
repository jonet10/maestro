package a2;

import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f11a;

    /* renamed from: b, reason: collision with root package name */
    public final long f12b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f13c;

    public c(String str, long j, Map map) {
        map.getClass();
        this.f11a = str;
        this.f12b = j;
        this.f13c = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f11a.equals(cVar.f11a) && this.f12b == cVar.f12b && kotlin.jvm.internal.l.a(this.f13c, cVar.f13c);
    }

    public final int hashCode() {
        int hashCode = this.f11a.hashCode() * 31;
        long j = this.f12b;
        return this.f13c.hashCode() + ((hashCode + ((int) (j ^ (j >>> 32)))) * 31);
    }

    public final String toString() {
        return "EventMetadata(sessionId=" + this.f11a + ", timestamp=" + this.f12b + ", additionalCustomKeys=" + this.f13c + ')';
    }
}
