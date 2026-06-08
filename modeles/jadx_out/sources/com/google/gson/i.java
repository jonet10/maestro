package com.google.gson;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class i {
    public final i a() {
        return !(this instanceof TypeAdapter$NullSafeTypeAdapter) ? new i() { // from class: com.google.gson.TypeAdapter$NullSafeTypeAdapter
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                if (aVar.H() != 9) {
                    return i.this.b(aVar);
                }
                aVar.D();
                return null;
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                if (obj == null) {
                    bVar.n();
                } else {
                    i.this.c(bVar, obj);
                }
            }

            public final String toString() {
                return "NullSafeTypeAdapter[" + i.this + "]";
            }
        } : this;
    }

    public abstract Object b(k3.a aVar);

    public abstract void c(k3.b bVar, Object obj);
}
