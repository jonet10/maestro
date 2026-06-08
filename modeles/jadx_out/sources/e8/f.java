package e8;

import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f implements z7.b {

    /* renamed from: a, reason: collision with root package name */
    public static final f f4768a = new f();

    /* renamed from: b, reason: collision with root package name */
    public static final e f4769b = e.f4765b;

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        eVar.getClass();
        d0.b.m(eVar);
        return new d((List) new d8.d(m.f4776a).f(eVar));
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return f4769b;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        d dVar = (d) obj;
        dVar.getClass();
        d0.b.i(fVar);
        m mVar = m.f4776a;
        b8.f fVar2 = m.f4777b;
        fVar2.getClass();
        d8.c cVar = new d8.c(fVar2, 1);
        List list = dVar.f4764a;
        int size = list.size();
        c8.d beginCollection = fVar.beginCollection(cVar, size);
        Iterator it = list.iterator();
        for (int i = 0; i < size; i++) {
            beginCollection.encodeSerializableElement(cVar, i, mVar, it.next());
        }
        beginCollection.endStructure(cVar);
    }
}
