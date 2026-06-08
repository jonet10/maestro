package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y5 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2346a;

    public y5(ArrayList arrayList) {
        this.f2346a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof y5) && this.f2346a.equals(((y5) obj).f2346a);
    }

    public final int hashCode() {
        return this.f2346a.hashCode();
    }

    public final String toString() {
        return "NotificationRegistryData(notificationsRegistry=" + this.f2346a + ")";
    }
}
