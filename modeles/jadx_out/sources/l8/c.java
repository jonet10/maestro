package l8;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f7181a;

    /* renamed from: b, reason: collision with root package name */
    public final a f7182b;

    public /* synthetic */ c() {
        this(new ArrayList(), new a(false, false));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kotlin.jvm.internal.l.a(this.f7181a, cVar.f7181a) && kotlin.jvm.internal.l.a(this.f7182b, cVar.f7182b);
    }

    public final int hashCode() {
        return this.f7182b.hashCode() + (this.f7181a.hashCode() * 31);
    }

    public final String toString() {
        return "ConsentOrPayConfig(countries=" + this.f7181a + ", actionButtonSettings=" + this.f7182b + ')';
    }

    public c(ArrayList arrayList, a aVar) {
        this.f7181a = arrayList;
        this.f7182b = aVar;
    }
}
