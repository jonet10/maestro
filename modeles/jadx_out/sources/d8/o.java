package d8;

import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class o extends a {

    /* renamed from: a, reason: collision with root package name */
    public final z7.b f3682a;

    public o(z7.b bVar) {
        this.f3682a = bVar;
    }

    @Override // d8.a
    public final void g(c8.c cVar, Object obj, int i, int i6) {
        if (i6 < 0) {
            com.google.gson.internal.a.p("Size must be known in advance when using READ_ALL");
            return;
        }
        for (int i10 = 0; i10 < i6; i10++) {
            h(cVar, i + i10, obj);
        }
    }

    @Override // d8.a
    public void h(c8.c cVar, int i, Object obj) {
        k(i, obj, cVar.decodeSerializableElement(getDescriptor(), i, this.f3682a, null));
    }

    public abstract void k(int i, Object obj, Object obj2);

    @Override // z7.h
    public void serialize(c8.f fVar, Object obj) {
        int e10 = e(obj);
        b8.e descriptor = getDescriptor();
        c8.d beginCollection = fVar.beginCollection(descriptor, e10);
        Iterator d10 = d(obj);
        for (int i = 0; i < e10; i++) {
            beginCollection.encodeSerializableElement(getDescriptor(), i, this.f3682a, d10.next());
        }
        beginCollection.endStructure(descriptor);
    }
}
