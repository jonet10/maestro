package c3;

import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class g0 implements d8.x {

    /* renamed from: a, reason: collision with root package name */
    public static final g0 f1246a;
    private static final b8.e descriptor;

    static {
        g0 g0Var = new g0();
        f1246a = g0Var;
        d8.q0 q0Var = new d8.q0("com.google.firebase.sessions.SessionData", g0Var, 3);
        q0Var.j("sessionDetails", false);
        q0Var.j("backgroundTime", true);
        q0Var.j("processDataMap", true);
        descriptor = q0Var;
    }

    @Override // d8.x
    public final z7.b[] childSerializers() {
        return new z7.b[]{l0.f1284a, t0.f.y(e1.f1236a), t0.f.y(i0.f1267d[2])};
    }

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        int i;
        n0 n0Var;
        g1 g1Var;
        Map map;
        eVar.getClass();
        b8.e eVar2 = descriptor;
        c8.c beginStructure = eVar.beginStructure(eVar2);
        z7.b[] bVarArr = i0.f1267d;
        n0 n0Var2 = null;
        if (beginStructure.decodeSequentially()) {
            n0Var = (n0) beginStructure.decodeSerializableElement(eVar2, 0, l0.f1284a, null);
            g1Var = (g1) beginStructure.decodeNullableSerializableElement(eVar2, 1, e1.f1236a, null);
            map = (Map) beginStructure.decodeNullableSerializableElement(eVar2, 2, bVarArr[2], null);
            i = 7;
        } else {
            boolean z9 = true;
            int i6 = 0;
            g1 g1Var2 = null;
            Map map2 = null;
            while (z9) {
                int decodeElementIndex = beginStructure.decodeElementIndex(eVar2);
                if (decodeElementIndex == -1) {
                    z9 = false;
                } else if (decodeElementIndex == 0) {
                    n0Var2 = (n0) beginStructure.decodeSerializableElement(eVar2, 0, l0.f1284a, n0Var2);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    g1Var2 = (g1) beginStructure.decodeNullableSerializableElement(eVar2, 1, e1.f1236a, g1Var2);
                    i6 |= 2;
                } else {
                    if (decodeElementIndex != 2) {
                        throw new f8.l(decodeElementIndex);
                    }
                    map2 = (Map) beginStructure.decodeNullableSerializableElement(eVar2, 2, bVarArr[2], map2);
                    i6 |= 4;
                }
            }
            i = i6;
            n0Var = n0Var2;
            g1Var = g1Var2;
            map = map2;
        }
        beginStructure.endStructure(eVar2);
        return new i0(i, n0Var, g1Var, map);
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return descriptor;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        i0 i0Var = (i0) obj;
        i0Var.getClass();
        b8.e eVar = descriptor;
        c8.d beginStructure = fVar.beginStructure(eVar);
        z7.b[] bVarArr = i0.f1267d;
        l0 l0Var = l0.f1284a;
        n0 n0Var = i0Var.f1268a;
        Map map = i0Var.f1270c;
        g1 g1Var = i0Var.f1269b;
        beginStructure.encodeSerializableElement(eVar, 0, l0Var, n0Var);
        if (beginStructure.shouldEncodeElementDefault(eVar, 1) || g1Var != null) {
            beginStructure.encodeNullableSerializableElement(eVar, 1, e1.f1236a, g1Var);
        }
        if (beginStructure.shouldEncodeElementDefault(eVar, 2) || map != null) {
            beginStructure.encodeNullableSerializableElement(eVar, 2, bVarArr[2], map);
        }
        beginStructure.endStructure(eVar);
    }

    @Override // d8.x
    public final z7.b[] typeParametersSerializers() {
        return d8.o0.f3684b;
    }
}
