package l2;

import java.util.Collections;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final String f7089a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f7090b;

    public c(String str, Map map) {
        this.f7089a = str;
        this.f7090b = map;
    }

    public static c a(String str) {
        return new c(str, Collections.EMPTY_MAP);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return this.f7089a.equals(cVar.f7089a) && this.f7090b.equals(cVar.f7090b);
    }

    public final int hashCode() {
        return this.f7090b.hashCode() + (this.f7089a.hashCode() * 31);
    }

    public final String toString() {
        return "FieldDescriptor{name=" + this.f7089a + ", properties=" + this.f7090b.values() + "}";
    }
}
