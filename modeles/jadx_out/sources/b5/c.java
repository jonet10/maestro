package b5;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1009a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f1010b;

    public c(ArrayList arrayList, boolean z9) {
        arrayList.getClass();
        this.f1009a = arrayList;
        this.f1010b = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kotlin.jvm.internal.l.a(this.f1009a, cVar.f1009a) && this.f1010b == cVar.f1010b;
    }

    public final int hashCode() {
        return (this.f1009a.hashCode() * 31) + (this.f1010b ? 1231 : 1237);
    }

    public final String toString() {
        return "FeaturedResult(apps=" + this.f1009a + ", success=" + this.f1010b + ")";
    }
}
