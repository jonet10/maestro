package q2;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f8642a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f8643b;

    public a(String str, ArrayList arrayList) {
        if (str == null) {
            com.google.gson.internal.a.i("Null userAgent");
            throw null;
        }
        this.f8642a = str;
        this.f8643b = arrayList;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f8642a.equals(aVar.f8642a) && this.f8643b.equals(aVar.f8643b);
    }

    public final int hashCode() {
        return ((this.f8642a.hashCode() ^ 1000003) * 1000003) ^ this.f8643b.hashCode();
    }

    public final String toString() {
        return "HeartBeatResult{userAgent=" + this.f8642a + ", usedDates=" + this.f8643b + "}";
    }
}
