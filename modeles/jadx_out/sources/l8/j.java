package l8;

import com.google.android.gms.internal.measurement.i5;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class j {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f7215a;

    /* renamed from: b, reason: collision with root package name */
    public final String f7216b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f7217c;

    public /* synthetic */ j() {
        this("", new ArrayList(), true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        return this.f7215a == jVar.f7215a && kotlin.jvm.internal.l.a(this.f7216b, jVar.f7216b) && kotlin.jvm.internal.l.a(this.f7217c, jVar.f7217c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    public final int hashCode() {
        boolean z9 = this.f7215a;
        ?? r02 = z9;
        if (z9) {
            r02 = 1;
        }
        return this.f7217c.hashCode() + i5.b(r02 * 31, this.f7216b);
    }

    public final String toString() {
        return "GDPRUiLabels(initScreenRejectButtonShowing=" + this.f7215a + ", initScreenRejectButton=" + this.f7216b + ", initScreenCustomLinks=" + this.f7217c + ')';
    }

    public j(String str, ArrayList arrayList, boolean z9) {
        this.f7215a = z9;
        this.f7216b = str;
        this.f7217c = arrayList;
    }
}
