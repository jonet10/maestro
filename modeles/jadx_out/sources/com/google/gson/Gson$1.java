package com.google.gson;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
class Gson$1 extends i {
    @Override // com.google.gson.i
    public final Object b(k3.a aVar) {
        if (aVar.H() != 9) {
            return Double.valueOf(aVar.y());
        }
        aVar.D();
        return null;
    }

    @Override // com.google.gson.i
    public final void c(k3.b bVar, Object obj) {
        Number number = (Number) obj;
        if (number == null) {
            bVar.n();
            return;
        }
        double doubleValue = number.doubleValue();
        b.a(doubleValue);
        bVar.z(doubleValue);
    }
}
