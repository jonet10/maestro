package a4;

import java.util.concurrent.FutureTask;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class i0 extends FutureTask implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final h f121a;

    public i0(h hVar) {
        super(hVar, null);
        this.f121a = hVar;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        h hVar = this.f121a;
        int i = hVar.A;
        h hVar2 = ((i0) obj).f121a;
        int i6 = hVar2.A;
        return i == i6 ? hVar.f100a - hVar2.f100a : c.j.c(i6) - c.j.c(i);
    }
}
