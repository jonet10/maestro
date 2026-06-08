package k6;

import java.util.List;
import kotlin.jvm.internal.l;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f6982a;

    /* renamed from: b, reason: collision with root package name */
    public final a f6983b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f6984c;

    public /* synthetic */ c() {
        this("", new a(15, null, null), t.f8724a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return l.a(this.f6982a, cVar.f6982a) && l.a(this.f6983b, cVar.f6983b) && l.a(this.f6984c, cVar.f6984c);
    }

    public final int hashCode() {
        String str = this.f6982a;
        return this.f6984c.hashCode() + ((this.f6983b.hashCode() + ((str == null ? 0 : str.hashCode()) * 31)) * 31);
    }

    public final String toString() {
        return "GBCPurposeResponse(language=" + ((Object) this.f6982a) + ", banner=" + this.f6983b + ", purposes=" + this.f6984c + ')';
    }

    public c(String str, a aVar, List list) {
        this.f6982a = str;
        this.f6983b = aVar;
        this.f6984c = list;
    }
}
