package x4;

import com.uptodown.UptodownApp;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class a3 {

    /* renamed from: a, reason: collision with root package name */
    public long f11046a;

    /* renamed from: b, reason: collision with root package name */
    public String f11047b;

    /* renamed from: c, reason: collision with root package name */
    public String f11048c;

    /* renamed from: d, reason: collision with root package name */
    public String f11049d;

    /* renamed from: e, reason: collision with root package name */
    public String f11050e;
    public long f;
    public String g;
    public ArrayList h;
    public String i;

    public final String a() {
        String str = this.f11048c;
        if (str == null) {
            return null;
        }
        float f = UptodownApp.I;
        return a4.x.k(str, UptodownApp.J, ":webp");
    }

    public final String toString() {
        long j = this.f11046a;
        String str = this.f11047b;
        String str2 = this.f11048c;
        String str3 = this.f11049d;
        StringBuilder sb = new StringBuilder("UserListItem(programId=");
        sb.append(j);
        sb.append(", name=");
        sb.append(str);
        a4.x.B(sb, ", icon=", str2, ", packagename=", str3);
        sb.append(")");
        return sb.toString();
    }
}
