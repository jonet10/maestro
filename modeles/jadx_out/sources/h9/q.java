package h9;

import a4.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public final String f5596a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5597b;

    public q(String str, String str2) {
        this.f5596a = str;
        this.f5597b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f5596a.equals(qVar.f5596a) && this.f5597b.equals(qVar.f5597b);
    }

    public final int hashCode() {
        return this.f5597b.hashCode() + (this.f5596a.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("PublisherCustomLink(label=");
        sb.append(this.f5596a);
        sb.append(", link=");
        return x.m(sb, this.f5597b, ')');
    }
}
