package l4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final String f7100a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7101b;

    /* renamed from: c, reason: collision with root package name */
    public String f7102c;

    public b(String str, String str2) {
        str.getClass();
        str2.getClass();
        this.f7100a = str;
        this.f7101b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return kotlin.jvm.internal.l.a(this.f7100a, bVar.f7100a) && kotlin.jvm.internal.l.a(this.f7101b, bVar.f7101b);
    }

    public final int hashCode() {
        return this.f7101b.hashCode() + (this.f7100a.hashCode() * 31);
    }

    public final String toString() {
        return "AppToBackup(packageName=" + this.f7100a + ", name=" + this.f7101b + ")";
    }
}
