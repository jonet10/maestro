package h9;

import a4.x;
import com.google.android.gms.internal.measurement.i5;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final int f5598a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5599b;

    /* renamed from: c, reason: collision with root package name */
    public final String f5600c;

    public r(String str, int i, String str2) {
        str.getClass();
        str2.getClass();
        this.f5598a = i;
        this.f5599b = str;
        this.f5600c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f5598a == rVar.f5598a && kotlin.jvm.internal.l.a(this.f5599b, rVar.f5599b) && kotlin.jvm.internal.l.a(this.f5600c, rVar.f5600c);
    }

    public final int hashCode() {
        return this.f5600c.hashCode() + i5.b(this.f5598a * 31, this.f5599b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("StackInfo(id=");
        sb.append(this.f5598a);
        sb.append(", label=");
        sb.append(this.f5599b);
        sb.append(", state=");
        return x.m(sb, this.f5600c, ')');
    }
}
