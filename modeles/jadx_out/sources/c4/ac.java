package c4;

import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ac {

    /* renamed from: a, reason: collision with root package name */
    public final x4.w2 f1395a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f1396b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f1397c;

    public ac(x4.w2 w2Var, ArrayList arrayList, boolean z9) {
        this.f1395a = w2Var;
        this.f1396b = arrayList;
        this.f1397c = z9;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ac)) {
            return false;
        }
        ac acVar = (ac) obj;
        return kotlin.jvm.internal.l.a(this.f1395a, acVar.f1395a) && this.f1396b.equals(acVar.f1396b) && this.f1397c == acVar.f1397c;
    }

    public final int hashCode() {
        x4.w2 w2Var = this.f1395a;
        return ((this.f1396b.hashCode() + ((w2Var == null ? 0 : w2Var.hashCode()) * 31)) * 31) + (this.f1397c ? 1231 : 1237);
    }

    public final String toString() {
        return "UserCommentsData(user=" + this.f1395a + ", reviews=" + this.f1396b + ", userExists=" + this.f1397c + ")";
    }
}
