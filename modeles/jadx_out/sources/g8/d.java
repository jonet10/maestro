package g8;

import d7.l;
import java.util.Map;
import kotlin.jvm.internal.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends f {

    /* renamed from: a, reason: collision with root package name */
    public final Map f5376a;

    /* renamed from: b, reason: collision with root package name */
    public final Map f5377b;

    /* renamed from: c, reason: collision with root package name */
    public final Map f5378c;

    /* renamed from: d, reason: collision with root package name */
    public final Map f5379d;

    /* renamed from: e, reason: collision with root package name */
    public final Map f5380e;

    public d(Map map, Map map2, Map map3, Map map4, Map map5, boolean z9) {
        map.getClass();
        map2.getClass();
        map3.getClass();
        map4.getClass();
        map5.getClass();
        this.f5376a = map;
        this.f5377b = map2;
        this.f5378c = map3;
        this.f5379d = map4;
        this.f5380e = map5;
    }

    @Override // g8.f
    public final void a(h hVar) {
        for (Map.Entry entry : this.f5376a.entrySet()) {
            j7.c cVar = (j7.c) entry.getKey();
            c cVar2 = (c) entry.getValue();
            if (cVar2 instanceof a) {
                cVar.getClass();
                z7.b bVar = ((a) cVar2).f5374a;
                bVar.getClass();
                hVar.d(cVar, bVar);
            } else {
                if (!(cVar2 instanceof b)) {
                    com.google.gson.internal.a.b();
                    return;
                }
                hVar.b(cVar, ((b) cVar2).f5375a);
            }
        }
        for (Map.Entry entry2 : this.f5377b.entrySet()) {
            j7.c cVar3 = (j7.c) entry2.getKey();
            for (Map.Entry entry3 : ((Map) entry2.getValue()).entrySet()) {
                j7.c cVar4 = (j7.c) entry3.getKey();
                z7.b bVar2 = (z7.b) entry3.getValue();
                cVar3.getClass();
                cVar4.getClass();
                bVar2.getClass();
                hVar.a(cVar3, cVar4, bVar2);
            }
        }
        for (Map.Entry entry4 : this.f5378c.entrySet()) {
            j7.c cVar5 = (j7.c) entry4.getKey();
            l lVar = (l) entry4.getValue();
            cVar5.getClass();
            lVar.getClass();
            a0.b(1, lVar);
            hVar.f(cVar5, lVar);
        }
        for (Map.Entry entry5 : this.f5380e.entrySet()) {
            j7.c cVar6 = (j7.c) entry5.getKey();
            l lVar2 = (l) entry5.getValue();
            cVar6.getClass();
            lVar2.getClass();
            a0.b(1, lVar2);
            hVar.e(cVar6, lVar2);
        }
    }
}
