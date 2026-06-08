package a3;

import a4.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final String f56a;

    /* renamed from: b, reason: collision with root package name */
    public final String f57b;

    public a(String str, String str2) {
        this.f56a = str;
        if (str2 != null) {
            this.f57b = str2;
        } else {
            com.google.gson.internal.a.i("Null version");
            throw null;
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return this.f56a.equals(aVar.f56a) && this.f57b.equals(aVar.f57b);
    }

    public final int hashCode() {
        return ((this.f56a.hashCode() ^ 1000003) * 1000003) ^ this.f57b.hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LibraryVersion{libraryName=");
        sb.append(this.f56a);
        sb.append(", version=");
        return x.n(sb, this.f57b, "}");
    }
}
