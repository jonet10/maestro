package v3;

import java.util.Iterator;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10842a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f10843b;

    public /* synthetic */ g(h hVar, float f, int i) {
        this.f10842a = i;
        this.f10843b = hVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f10842a) {
            case 0:
                z3.f fVar = this.f10843b.f10844a;
                androidx.room.b bVar = fVar.f11943m;
                if (bVar != null) {
                    bVar.invoke(fVar.f11942l);
                    return;
                } else {
                    l.i("youTubePlayerInitListener");
                    throw null;
                }
            case 1:
                z3.f fVar2 = this.f10843b.f10844a;
                for (w3.a aVar : fVar2.getListeners()) {
                    e fVar3 = fVar2.getInstance();
                    aVar.getClass();
                    fVar3.getClass();
                }
                return;
            case 2:
                z3.f fVar4 = this.f10843b.f10844a;
                Iterator<T> it = fVar4.getListeners().iterator();
                while (it.hasNext()) {
                    ((w3.a) it.next()).e(fVar4.getInstance());
                }
                return;
            case 3:
                z3.f fVar5 = this.f10843b.f10844a;
                for (w3.a aVar2 : fVar5.getListeners()) {
                    e fVar6 = fVar5.getInstance();
                    aVar2.getClass();
                    fVar6.getClass();
                }
                return;
            case 4:
                z3.f fVar7 = this.f10843b.f10844a;
                for (w3.a aVar3 : fVar7.getListeners()) {
                    e fVar8 = fVar7.getInstance();
                    aVar3.getClass();
                    fVar8.getClass();
                }
                return;
            case 5:
                z3.f fVar9 = this.f10843b.f10844a;
                Iterator<T> it2 = fVar9.getListeners().iterator();
                while (it2.hasNext()) {
                    ((w3.a) it2.next()).c(fVar9.getInstance());
                }
                return;
            default:
                z3.f fVar10 = this.f10843b.f10844a;
                for (w3.a aVar4 : fVar10.getListeners()) {
                    e fVar11 = fVar10.getInstance();
                    aVar4.getClass();
                    fVar11.getClass();
                }
                return;
        }
    }

    public /* synthetic */ g(h hVar, int i) {
        this.f10842a = i;
        this.f10843b = hVar;
    }

    public /* synthetic */ g(h hVar, Enum r22, int i) {
        this.f10842a = i;
        this.f10843b = hVar;
    }
}
