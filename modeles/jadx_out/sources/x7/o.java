package x7;

import java.util.concurrent.atomic.AtomicReferenceArray;
import t7.s;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o extends s {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ AtomicReferenceArray f11544e;

    public o(long j, o oVar, int i) {
        super(j, oVar, i);
        this.f11544e = new AtomicReferenceArray(n.f);
    }

    @Override // t7.s
    public final int g() {
        return n.f;
    }

    @Override // t7.s
    public final void h(int i, t6.h hVar) {
        this.f11544e.set(i, n.f11543e);
        i();
    }

    public final String toString() {
        return "SemaphoreSegment[id=" + this.f10355c + ", hashCode=" + hashCode() + ']';
    }
}
