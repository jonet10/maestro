package s;

import a4.x;
import c.j;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f9104a;

    /* renamed from: b, reason: collision with root package name */
    public final long f9105b;

    public a(int i, long j) {
        if (i == 0) {
            com.google.gson.internal.a.i("Null status");
            throw null;
        }
        this.f9104a = i;
        this.f9105b = j;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return j.a(this.f9104a, aVar.f9104a) && this.f9105b == aVar.f9105b;
    }

    public final int hashCode() {
        int c9 = (j.c(this.f9104a) ^ 1000003) * 1000003;
        long j = this.f9105b;
        return c9 ^ ((int) (j ^ (j >>> 32)));
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("BackendResponse{status=");
        int i = this.f9104a;
        sb.append(i != 1 ? i != 2 ? i != 3 ? i != 4 ? "null" : "INVALID_PAYLOAD" : "FATAL_ERROR" : "TRANSIENT_ERROR" : "OK");
        sb.append(", nextRequestWaitMillis=");
        return x.l(sb, this.f9105b, "}");
    }
}
