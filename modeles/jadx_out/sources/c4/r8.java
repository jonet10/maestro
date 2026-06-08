package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r8 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2053a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f2054b;

    public r8(ArrayList arrayList, boolean z9) {
        arrayList.getClass();
        this.f2053a = arrayList;
        this.f2054b = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r8)) {
            return false;
        }
        r8 r8Var = (r8) obj;
        return kotlin.jvm.internal.l.a(this.f2053a, r8Var.f2053a) && this.f2054b == r8Var.f2054b;
    }

    public final int hashCode() {
        return (this.f2053a.hashCode() * 31) + (this.f2054b ? 1231 : 1237);
    }

    public final String toString() {
        return "RepliesData(replies=" + this.f2053a + ", moreDataAdded=" + this.f2054b + ")";
    }
}
