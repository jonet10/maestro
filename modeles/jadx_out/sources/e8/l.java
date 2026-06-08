package e8;

import d8.b1;
import d8.o0;
import f8.a0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final d8.y f4775a = o0.a("kotlinx.serialization.json.JsonUnquotedLiteral", b1.f3621a);

    public static final int a(x xVar) {
        try {
            long l10 = new a0(xVar.c()).l();
            if (-2147483648L <= l10 && l10 <= 2147483647L) {
                return (int) l10;
            }
            throw new NumberFormatException(xVar.c() + " is not an Int");
        } catch (f8.h e10) {
            throw new NumberFormatException(e10.getMessage());
        }
    }

    public static final x b(k kVar) {
        x xVar = kVar instanceof x ? (x) kVar : null;
        if (xVar != null) {
            return xVar;
        }
        a3.b.q(kotlin.jvm.internal.y.a(kVar.getClass()), "Element ", " is not a JsonPrimitive");
        return null;
    }
}
