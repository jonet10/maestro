package j0;

import java.util.Arrays;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final int f6478a;

    /* renamed from: b, reason: collision with root package name */
    public final android.support.v4.media.g f6479b;

    /* renamed from: c, reason: collision with root package name */
    public final i0.a f6480c;

    /* renamed from: d, reason: collision with root package name */
    public final String f6481d;

    public a(android.support.v4.media.g gVar, i0.a aVar, String str) {
        this.f6479b = gVar;
        this.f6480c = aVar;
        this.f6481d = str;
        this.f6478a = Arrays.hashCode(new Object[]{gVar, aVar, str});
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return y.j(this.f6479b, aVar.f6479b) && y.j(this.f6480c, aVar.f6480c) && y.j(this.f6481d, aVar.f6481d);
    }

    public final int hashCode() {
        return this.f6478a;
    }
}
