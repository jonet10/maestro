package k7;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a implements f {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicReference f6985a;

    public a(f fVar) {
        this.f6985a = new AtomicReference(fVar);
    }

    @Override // k7.f
    public final Iterator iterator() {
        f fVar = (f) this.f6985a.getAndSet(null);
        if (fVar != null) {
            return fVar.iterator();
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("This sequence can be consumed only once.");
        return null;
    }
}
