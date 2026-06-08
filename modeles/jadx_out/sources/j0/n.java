package j0;

import java.util.Arrays;
import k0.y;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n {

    /* renamed from: a, reason: collision with root package name */
    public final a f6517a;

    /* renamed from: b, reason: collision with root package name */
    public final h0.d f6518b;

    public /* synthetic */ n(a aVar, h0.d dVar) {
        this.f6517a = aVar;
        this.f6518b = dVar;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return y.j(this.f6517a, nVar.f6517a) && y.j(this.f6518b, nVar.f6518b);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f6517a, this.f6518b});
    }

    public final String toString() {
        android.support.v4.media.g gVar = new android.support.v4.media.g(this);
        gVar.p(this.f6517a, "key");
        gVar.p(this.f6518b, "feature");
        return gVar.toString();
    }
}
