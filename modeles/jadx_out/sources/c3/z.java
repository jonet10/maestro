package c3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class z implements d8.x {

    /* renamed from: a, reason: collision with root package name */
    public static final z f1354a;
    private static final b8.e descriptor;

    static {
        z zVar = new z();
        f1354a = zVar;
        d8.q0 q0Var = new d8.q0("com.google.firebase.sessions.ProcessData", zVar, 2);
        q0Var.j("pid", false);
        q0Var.j("uuid", false);
        descriptor = q0Var;
    }

    @Override // d8.x
    public final z7.b[] childSerializers() {
        return new z7.b[]{d8.c0.f3624a, d8.b1.f3621a};
    }

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        int i;
        String str;
        int i6;
        eVar.getClass();
        b8.e eVar2 = descriptor;
        c8.c beginStructure = eVar.beginStructure(eVar2);
        if (beginStructure.decodeSequentially()) {
            i = beginStructure.decodeIntElement(eVar2, 0);
            str = beginStructure.decodeStringElement(eVar2, 1);
            i6 = 3;
        } else {
            String str2 = null;
            boolean z9 = true;
            i = 0;
            int i10 = 0;
            while (z9) {
                int decodeElementIndex = beginStructure.decodeElementIndex(eVar2);
                if (decodeElementIndex == -1) {
                    z9 = false;
                } else if (decodeElementIndex == 0) {
                    i = beginStructure.decodeIntElement(eVar2, 0);
                    i10 |= 1;
                } else {
                    if (decodeElementIndex != 1) {
                        throw new f8.l(decodeElementIndex);
                    }
                    str2 = beginStructure.decodeStringElement(eVar2, 1);
                    i10 |= 2;
                }
            }
            str = str2;
            i6 = i10;
        }
        beginStructure.endStructure(eVar2);
        return new b0(i6, i, str);
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return descriptor;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        b0 b0Var = (b0) obj;
        b0Var.getClass();
        b8.e eVar = descriptor;
        c8.d beginStructure = fVar.beginStructure(eVar);
        beginStructure.encodeIntElement(eVar, 0, b0Var.f1195a);
        beginStructure.encodeStringElement(eVar, 1, b0Var.f1196b);
        beginStructure.endStructure(eVar);
    }

    @Override // d8.x
    public final z7.b[] typeParametersSerializers() {
        return d8.o0.f3684b;
    }
}
