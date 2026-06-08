package l4;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f extends m {

    /* renamed from: a, reason: collision with root package name */
    public final a f7111a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7112b;

    /* renamed from: c, reason: collision with root package name */
    public final int f7113c;

    public f(a aVar, String str, int i) {
        this.f7111a = aVar;
        this.f7112b = str;
        this.f7113c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return kotlin.jvm.internal.l.a(this.f7111a, fVar.f7111a) && this.f7112b.equals(fVar.f7112b) && this.f7113c == fVar.f7113c;
    }

    public final int hashCode() {
        a aVar = this.f7111a;
        return androidx.lifecycle.l.o((aVar == null ? 0 : aVar.hashCode()) * 31, 31, this.f7112b) + this.f7113c;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("InstallFailed(appInstalling=");
        sb.append(this.f7111a);
        sb.append(", error=");
        sb.append(this.f7112b);
        sb.append(", status=");
        return androidx.lifecycle.l.x(sb, ")", this.f7113c);
    }
}
