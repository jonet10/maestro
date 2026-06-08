package kotlin.jvm.internal;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class q extends t implements j7.j {
    @Override // kotlin.jvm.internal.d
    public j7.b computeReflected() {
        y.f7025a.getClass();
        return this;
    }

    @Override // j7.j
    public Object getDelegate(Object obj) {
        return ((j7.j) getReflected()).getDelegate(obj);
    }

    @Override // j7.j
    /* renamed from: getGetter */
    public j7.i mo244getGetter() {
        ((j7.j) getReflected()).mo244getGetter();
        return null;
    }

    @Override // d7.l
    public Object invoke(Object obj) {
        return get(obj);
    }

    public /* bridge */ /* synthetic */ j7.h getGetter() {
        mo244getGetter();
        return null;
    }
}
