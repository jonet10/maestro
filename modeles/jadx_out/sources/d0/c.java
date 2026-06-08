package d0;

import android.support.v4.media.g;
import java.util.Arrays;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c implements i0.a {

    /* renamed from: l, reason: collision with root package name */
    public static final c f3535l;

    /* renamed from: a, reason: collision with root package name */
    public final boolean f3536a;

    /* renamed from: b, reason: collision with root package name */
    public final String f3537b;

    static {
        g gVar = new g(5, false);
        gVar.f247b = Boolean.FALSE;
        f3535l = new c(gVar);
    }

    public c(g gVar) {
        this.f3536a = ((Boolean) gVar.f247b).booleanValue();
        this.f3537b = (String) gVar.f248l;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return y.j(null, null) && this.f3536a == cVar.f3536a && y.j(this.f3537b, cVar.f3537b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{null, Boolean.valueOf(this.f3536a), this.f3537b});
    }
}
