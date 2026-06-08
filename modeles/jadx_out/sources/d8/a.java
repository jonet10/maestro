package d8;

import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a implements z7.b {
    public abstract Object a();

    public abstract int b(Object obj);

    public abstract void c(int i, Object obj);

    public abstract Iterator d(Object obj);

    @Override // z7.a
    public Object deserialize(c8.e eVar) {
        eVar.getClass();
        return f(eVar);
    }

    public abstract int e(Object obj);

    public final Object f(c8.e eVar) {
        eVar.getClass();
        Object a8 = a();
        int b7 = b(a8);
        c8.c beginStructure = eVar.beginStructure(getDescriptor());
        if (!beginStructure.decodeSequentially()) {
            while (true) {
                int decodeElementIndex = beginStructure.decodeElementIndex(getDescriptor());
                if (decodeElementIndex == -1) {
                    break;
                }
                h(beginStructure, decodeElementIndex + b7, a8);
            }
        } else {
            int decodeCollectionSize = beginStructure.decodeCollectionSize(getDescriptor());
            c(decodeCollectionSize, a8);
            g(beginStructure, a8, b7, decodeCollectionSize);
        }
        beginStructure.endStructure(getDescriptor());
        return j(a8);
    }

    public abstract void g(c8.c cVar, Object obj, int i, int i6);

    public abstract void h(c8.c cVar, int i, Object obj);

    public abstract Object i(Object obj);

    public abstract Object j(Object obj);
}
