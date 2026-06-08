package z0;

import b2.t1;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c extends e {

    /* renamed from: l, reason: collision with root package name */
    public final transient e f11893l;

    public c(e eVar) {
        this.f11893l = eVar;
    }

    @Override // z0.e, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return this.f11893l.contains(obj);
    }

    @Override // z0.e
    public final e g() {
        return this.f11893l;
    }

    @Override // java.util.List
    public final Object get(int i) {
        e eVar = this.f11893l;
        t1.T(i, eVar.size());
        return eVar.get((eVar.size() - 1) - i);
    }

    @Override // z0.e, java.util.List
    /* renamed from: h */
    public final e subList(int i, int i6) {
        e eVar = this.f11893l;
        t1.W(i, i6, eVar.size());
        return eVar.subList(eVar.size() - i6, eVar.size() - i).g();
    }

    @Override // z0.e, java.util.List
    public final int indexOf(Object obj) {
        int lastIndexOf = this.f11893l.lastIndexOf(obj);
        if (lastIndexOf >= 0) {
            return (r0.size() - 1) - lastIndexOf;
        }
        return -1;
    }

    @Override // z0.e, java.util.List
    public final int lastIndexOf(Object obj) {
        int indexOf = this.f11893l.indexOf(obj);
        if (indexOf >= 0) {
            return (r0.size() - 1) - indexOf;
        }
        return -1;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f11893l.size();
    }
}
