package e8;

import b2.t1;
import d8.u0;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class o implements z7.b {

    /* renamed from: a, reason: collision with root package name */
    public static final o f4780a = new o();

    /* renamed from: b, reason: collision with root package name */
    public static final u0 f4781b = t1.a("kotlinx.serialization.json.JsonLiteral", b8.d.f1111p);

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        eVar.getClass();
        k a8 = d0.b.m(eVar).a();
        if (a8 instanceof n) {
            return (n) a8;
        }
        throw f8.m.e("Unexpected JSON element, expected JsonLiteral, had " + kotlin.jvm.internal.y.a(a8.getClass()), a8.toString(), -1);
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return f4781b;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x004d  */
    @Override // z7.h
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void serialize(c8.f r4, java.lang.Object r5) {
        /*
            r3 = this;
            e8.n r5 = (e8.n) r5
            r5.getClass()
            java.lang.String r0 = r5.f4779b
            d0.b.i(r4)
            boolean r5 = r5.f4778a
            if (r5 == 0) goto L12
            r4.encodeString(r0)
            return
        L12:
            java.lang.Long r5 = l7.t.i0(r0)
            if (r5 == 0) goto L20
            long r0 = r5.longValue()
            r4.encodeLong(r0)
            return
        L20:
            p6.s r5 = b2.t1.P(r0)
            if (r5 == 0) goto L32
            long r0 = r5.f8458a
            d8.y r5 = d8.k1.f3666b
            c8.f r4 = r4.encodeInline(r5)
            r4.encodeLong(r0)
            return
        L32:
            r5 = 0
            boolean r1 = l7.s.f0(r0)     // Catch: java.lang.NumberFormatException -> L42
            if (r1 == 0) goto L42
            double r1 = java.lang.Double.parseDouble(r0)     // Catch: java.lang.NumberFormatException -> L42
            java.lang.Double r1 = java.lang.Double.valueOf(r1)     // Catch: java.lang.NumberFormatException -> L42
            goto L43
        L42:
            r1 = r5
        L43:
            if (r1 == 0) goto L4d
            double r0 = r1.doubleValue()
            r4.encodeDouble(r0)
            goto L6f
        L4d:
            java.lang.String r1 = "true"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L58
            java.lang.Boolean r5 = java.lang.Boolean.TRUE
            goto L62
        L58:
            java.lang.String r1 = "false"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L62
            java.lang.Boolean r5 = java.lang.Boolean.FALSE
        L62:
            if (r5 == 0) goto L6c
            boolean r5 = r5.booleanValue()
            r4.encodeBoolean(r5)
            goto L6f
        L6c:
            r4.encodeString(r0)
        L6f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e8.o.serialize(c8.f, java.lang.Object):void");
    }
}
