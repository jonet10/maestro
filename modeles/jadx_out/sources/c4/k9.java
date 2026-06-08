package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class k9 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f1797a;

    public k9(ArrayList arrayList) {
        this.f1797a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof k9) && this.f1797a.equals(((k9) obj).f1797a);
    }

    public final int hashCode() {
        return this.f1797a.hashCode();
    }

    public final String toString() {
        return "RollbackData(rollbackApps=" + this.f1797a + ")";
    }
}
