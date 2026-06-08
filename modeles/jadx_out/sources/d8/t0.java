package d8;

import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class t0 extends o {

    /* renamed from: b, reason: collision with root package name */
    public final s0 f3710b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t0(z7.b bVar) {
        super(bVar);
        bVar.getClass();
        this.f3710b = new s0(bVar.getDescriptor());
    }

    @Override // d8.a
    public final Object a() {
        return (r0) i(l());
    }

    @Override // d8.a
    public final int b(Object obj) {
        r0 r0Var = (r0) obj;
        r0Var.getClass();
        return r0Var.d();
    }

    @Override // d8.a
    public final void c(int i, Object obj) {
        r0 r0Var = (r0) obj;
        r0Var.getClass();
        r0Var.b(i);
    }

    @Override // d8.a
    public final Iterator d(Object obj) {
        throw new IllegalStateException("This method lead to boxing and must not be used, use writeContents instead");
    }

    @Override // d8.a, z7.a
    public final Object deserialize(c8.e eVar) {
        eVar.getClass();
        return f(eVar);
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return this.f3710b;
    }

    @Override // d8.a
    public final Object j(Object obj) {
        r0 r0Var = (r0) obj;
        r0Var.getClass();
        return r0Var.a();
    }

    @Override // d8.o
    public final void k(int i, Object obj, Object obj2) {
        ((r0) obj).getClass();
        throw new IllegalStateException("This method lead to boxing and must not be used, use Builder.append instead");
    }

    public abstract Object l();

    public abstract void m(c8.d dVar, Object obj, int i);

    @Override // d8.o, z7.h
    public final void serialize(c8.f fVar, Object obj) {
        int e10 = e(obj);
        s0 s0Var = this.f3710b;
        c8.d beginCollection = fVar.beginCollection(s0Var, e10);
        m(beginCollection, obj, e10);
        beginCollection.endStructure(s0Var);
    }
}
