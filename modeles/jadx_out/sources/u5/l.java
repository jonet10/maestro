package u5;

import d7.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import p6.x;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class l extends kotlin.jvm.internal.m implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10735a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f10736b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(m mVar, int i) {
        super(2);
        this.f10735a = i;
        this.f10736b = mVar;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Iterable, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7, types: [java.lang.Object, java.util.List] */
    /* JADX WARN: Type inference failed for: r5v0, types: [java.lang.Object, java.util.List] */
    @Override // d7.p
    public final Object invoke(Object obj, Object obj2) {
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        LinkedHashMap linkedHashMap3;
        LinkedHashMap linkedHashMap4;
        switch (this.f10735a) {
            case 0:
                int intValue = ((Number) obj).intValue();
                ((Boolean) obj2).getClass();
                l8.i iVar = m9.c.e().f7239n;
                ?? r02 = iVar.f7212t.f7228a;
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : r02) {
                    if (intValue == ((l8.l) obj3).f7223a) {
                        arrayList.add(obj3);
                    }
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj4 = arrayList.get(i);
                    i++;
                    ?? r52 = iVar.g;
                    ArrayList arrayList2 = ((l8.l) obj4).f;
                    if (!arrayList2.isEmpty()) {
                        int size2 = arrayList2.size();
                        int i6 = 0;
                        while (true) {
                            if (i6 < size2) {
                                Object obj5 = arrayList2.get(i6);
                                i6++;
                                if (r52.contains(Integer.valueOf(((Number) obj5).intValue()))) {
                                    this.f10736b.A.set(intValue);
                                }
                            }
                        }
                    }
                }
                break;
            case 1:
                int intValue2 = ((Number) obj).intValue();
                ((Boolean) obj2).getClass();
                m mVar = this.f10736b;
                h8.c cVar = mVar.f10737a;
                h8.i iVar2 = (cVar == null || (linkedHashMap = cVar.h) == null) ? null : (h8.i) linkedHashMap.get(String.valueOf(intValue2));
                if (iVar2 != null && m.b(iVar2)) {
                    mVar.f10756z.set(intValue2);
                }
                break;
            case 2:
                int intValue3 = ((Number) obj).intValue();
                ((Boolean) obj2).getClass();
                m mVar2 = this.f10736b;
                h8.c cVar2 = mVar2.f10737a;
                h8.i iVar3 = (cVar2 == null || (linkedHashMap2 = cVar2.h) == null) ? null : (h8.i) linkedHashMap2.get(String.valueOf(intValue3));
                if (iVar3 != null && m.c(mVar2, iVar3)) {
                    mVar2.C.set(intValue3);
                }
                break;
            case 3:
                int intValue4 = ((Number) obj).intValue();
                ((Boolean) obj2).getClass();
                m mVar3 = this.f10736b;
                h8.c cVar3 = mVar3.f10737a;
                h8.i iVar4 = (cVar3 == null || (linkedHashMap3 = cVar3.h) == null) ? null : (h8.i) linkedHashMap3.get(String.valueOf(intValue4));
                if (iVar4 != null && !m.b(iVar4) && !m.c(mVar3, iVar4)) {
                    ?? r12 = m9.c.e().f7239n.f7203k;
                    Set set = iVar4.g;
                    if (set == null || !set.isEmpty()) {
                        Iterator it = set.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (r12.contains(Integer.valueOf(((Number) it.next()).intValue()))) {
                                    mVar3.C.set(intValue4);
                                }
                            }
                        }
                    }
                }
                break;
            default:
                int intValue5 = ((Number) obj).intValue();
                ((Boolean) obj2).getClass();
                m mVar4 = this.f10736b;
                h8.c cVar4 = mVar4.f10737a;
                h8.i iVar5 = (cVar4 == null || (linkedHashMap4 = cVar4.h) == null) ? null : (h8.i) linkedHashMap4.get(String.valueOf(intValue5));
                if (iVar5 != null && m.b(iVar5)) {
                    mVar4.f10756z.unset(intValue5);
                }
                break;
        }
        return x.f8463a;
    }
}
