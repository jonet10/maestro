package s4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f9198a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f9199b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9200c;

    public f0(ArrayList arrayList, int i, boolean z9) {
        this.f9198a = arrayList;
        this.f9199b = z9;
        this.f9200c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f0)) {
            return false;
        }
        f0 f0Var = (f0) obj;
        return this.f9198a.equals(f0Var.f9198a) && this.f9199b == f0Var.f9199b && this.f9200c == f0Var.f9200c;
    }

    public final int hashCode() {
        return (((this.f9198a.hashCode() * 31) + (this.f9199b ? 1231 : 1237)) * 31) + this.f9200c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("RecommendedAppsData(recommendedApps=");
        sb.append(this.f9198a);
        sb.append(", isPrivate=");
        sb.append(this.f9199b);
        sb.append(", countApps=");
        return androidx.lifecycle.l.x(sb, ")", this.f9200c);
    }
}
