package l8;

import a4.x;
import com.google.android.gms.internal.measurement.i5;
import java.util.List;
import q6.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class m {

    /* renamed from: a, reason: collision with root package name */
    public final Object f7228a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7229b;

    /* renamed from: c, reason: collision with root package name */
    public final String f7230c;

    public m(String str, String str2, List list) {
        this.f7228a = list;
        this.f7229b = str;
        this.f7230c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m)) {
            return false;
        }
        m mVar = (m) obj;
        return kotlin.jvm.internal.l.a(this.f7228a, mVar.f7228a) && kotlin.jvm.internal.l.a(this.f7229b, mVar.f7229b) && kotlin.jvm.internal.l.a(this.f7230c, mVar.f7230c);
    }

    public final int hashCode() {
        return this.f7230c.hashCode() + i5.b(this.f7228a.hashCode() * 31, this.f7229b);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("NonIabVendorsInfo(nonIabVendorList=");
        sb.append(this.f7228a);
        sb.append(", updateAt=");
        sb.append(this.f7229b);
        sb.append(", nonIabVendorsHash=");
        return x.m(sb, this.f7230c, ')');
    }

    public /* synthetic */ m() {
        this("", "", t.f8724a);
    }
}
