package r;

import a4.d0;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class q implements o.f {

    /* renamed from: a, reason: collision with root package name */
    public final Set f8845a;

    /* renamed from: b, reason: collision with root package name */
    public final j f8846b;

    /* renamed from: c, reason: collision with root package name */
    public final r f8847c;

    public q(Set set, j jVar, r rVar) {
        this.f8845a = set;
        this.f8846b = jVar;
        this.f8847c = rVar;
    }

    public final d0 a(String str, o.c cVar, o.e eVar) {
        Set set = this.f8845a;
        if (set.contains(cVar)) {
            return new d0(this.f8846b, str, cVar, eVar, this.f8847c, 5);
        }
        androidx.core.view.contentcapture.a.o("%s is not supported byt this factory. Supported encodings are: %s.", new Object[]{cVar, set});
        return null;
    }
}
