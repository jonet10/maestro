package d8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends o {

    /* renamed from: b, reason: collision with root package name */
    public final c f3628b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(z7.b bVar) {
        super(bVar);
        bVar.getClass();
        b8.e descriptor = bVar.getDescriptor();
        descriptor.getClass();
        this.f3628b = new c(descriptor, 1);
    }

    @Override // d8.a
    public final Object a() {
        return new ArrayList();
    }

    @Override // d8.a
    public final int b(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        arrayList.getClass();
        return arrayList.size();
    }

    @Override // d8.a
    public final void c(int i, Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        arrayList.getClass();
        arrayList.ensureCapacity(i);
    }

    @Override // d8.a
    public final Iterator d(Object obj) {
        Collection collection = (Collection) obj;
        collection.getClass();
        return collection.iterator();
    }

    @Override // d8.a
    public final int e(Object obj) {
        Collection collection = (Collection) obj;
        collection.getClass();
        return collection.size();
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return this.f3628b;
    }

    @Override // d8.a
    public final Object i(Object obj) {
        throw null;
    }

    @Override // d8.a
    public final Object j(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        arrayList.getClass();
        return arrayList;
    }

    @Override // d8.o
    public final void k(int i, Object obj, Object obj2) {
        ArrayList arrayList = (ArrayList) obj;
        arrayList.getClass();
        arrayList.add(i, obj2);
    }
}
