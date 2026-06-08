package g8;

import java.util.List;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a extends c {

    /* renamed from: a, reason: collision with root package name */
    public final z7.b f5374a;

    public a(z7.b bVar) {
        bVar.getClass();
        this.f5374a = bVar;
    }

    @Override // g8.c
    public final z7.b a(List list) {
        return this.f5374a;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof a) && l.a(((a) obj).f5374a, this.f5374a);
    }

    public final int hashCode() {
        return this.f5374a.hashCode();
    }
}
