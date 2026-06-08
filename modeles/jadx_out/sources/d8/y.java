package d8;

import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class y extends q0 {

    /* renamed from: l, reason: collision with root package name */
    public final boolean f3722l;

    public y(String str, z zVar) {
        super(str, zVar, 1);
        this.f3722l = true;
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, p6.f] */
    /* JADX WARN: Type inference failed for: r6v3, types: [java.lang.Object, p6.f] */
    @Override // d8.q0
    public final boolean equals(Object obj) {
        int i;
        if (this == obj) {
            return true;
        }
        if (obj instanceof y) {
            b8.e eVar = (b8.e) obj;
            if (this.f3694a.equals(eVar.a())) {
                y yVar = (y) obj;
                if (yVar.f3722l && Arrays.equals((b8.e[]) this.j.getValue(), (b8.e[]) yVar.j.getValue())) {
                    int e10 = eVar.e();
                    int i6 = this.f3696c;
                    if (i6 == e10) {
                        for (0; i < i6; i + 1) {
                            i = (kotlin.jvm.internal.l.a(h(i).a(), eVar.h(i).a()) && kotlin.jvm.internal.l.a(h(i).getKind(), eVar.h(i).getKind())) ? i + 1 : 0;
                        }
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // d8.q0
    public final int hashCode() {
        return super.hashCode() * 31;
    }

    @Override // d8.q0, b8.e
    public final boolean isInline() {
        return this.f3722l;
    }
}
