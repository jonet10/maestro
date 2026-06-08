package y1;

import b2.b0;
import java.io.File;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final b0 f11604a;

    /* renamed from: b, reason: collision with root package name */
    public final String f11605b;

    /* renamed from: c, reason: collision with root package name */
    public final File f11606c;

    public b(b0 b0Var, String str, File file) {
        this.f11604a = b0Var;
        if (str == null) {
            com.google.gson.internal.a.i("Null sessionId");
            throw null;
        }
        this.f11605b = str;
        this.f11606c = file;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f11604a.equals(bVar.f11604a) && this.f11605b.equals(bVar.f11605b) && this.f11606c.equals(bVar.f11606c);
    }

    public final int hashCode() {
        return ((((this.f11604a.hashCode() ^ 1000003) * 1000003) ^ this.f11605b.hashCode()) * 1000003) ^ this.f11606c.hashCode();
    }

    public final String toString() {
        return "CrashlyticsReportWithSessionId{report=" + this.f11604a + ", sessionId=" + this.f11605b + ", reportFile=" + this.f11606c + "}";
    }
}
