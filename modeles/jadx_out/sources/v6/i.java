package v6;

import kotlin.jvm.internal.y;
import kotlin.jvm.internal.z;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class i extends c implements kotlin.jvm.internal.i {
    private final int arity;

    public i(int i, t6.c cVar) {
        super(cVar);
        this.arity = i;
    }

    @Override // kotlin.jvm.internal.i
    public int getArity() {
        return this.arity;
    }

    @Override // v6.a
    public String toString() {
        if (getCompletion() != null) {
            return super.toString();
        }
        y.f7025a.getClass();
        return z.a(this);
    }
}
