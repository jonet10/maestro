package l8;

import a4.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f7180a;

    public b() {
        this.f7180a = "";
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b) && this.f7180a.equals(((b) obj).f7180a);
    }

    public final int hashCode() {
        return this.f7180a.hashCode();
    }

    public final String toString() {
        return x.m(new StringBuilder("CCPAPortalConfig(uspLspact="), this.f7180a, ')');
    }

    public b(String str) {
        this.f7180a = str;
    }
}
