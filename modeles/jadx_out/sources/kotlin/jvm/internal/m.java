package kotlin.jvm.internal;

import java.io.Serializable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class m implements i, Serializable {
    private final int arity;

    public m(int i) {
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.i
    public int getArity() {
        return this.arity;
    }

    public String toString() {
        y.f7025a.getClass();
        return z.a(this);
    }
}
