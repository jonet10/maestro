package c3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class l0 implements d8.x {

    /* renamed from: a, reason: collision with root package name */
    public static final l0 f1284a;
    private static final b8.e descriptor;

    static {
        l0 l0Var = new l0();
        f1284a = l0Var;
        d8.q0 q0Var = new d8.q0("com.google.firebase.sessions.SessionDetails", l0Var, 4);
        q0Var.j("sessionId", false);
        q0Var.j("firstSessionId", false);
        q0Var.j("sessionIndex", false);
        q0Var.j("sessionStartTimestampUs", false);
        descriptor = q0Var;
    }

    @Override // d8.x
    public final z7.b[] childSerializers() {
        d8.b1 b1Var = d8.b1.f3621a;
        return new z7.b[]{b1Var, b1Var, d8.c0.f3624a, d8.i0.f3655a};
    }

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        String str;
        int i;
        int i6;
        String str2;
        long j;
        eVar.getClass();
        b8.e eVar2 = descriptor;
        c8.c beginStructure = eVar.beginStructure(eVar2);
        if (beginStructure.decodeSequentially()) {
            str = beginStructure.decodeStringElement(eVar2, 0);
            String decodeStringElement = beginStructure.decodeStringElement(eVar2, 1);
            i = 15;
            i6 = beginStructure.decodeIntElement(eVar2, 2);
            str2 = decodeStringElement;
            j = beginStructure.decodeLongElement(eVar2, 3);
        } else {
            str = null;
            String str3 = null;
            boolean z9 = true;
            long j6 = 0;
            int i10 = 0;
            int i11 = 0;
            while (z9) {
                int decodeElementIndex = beginStructure.decodeElementIndex(eVar2);
                if (decodeElementIndex == -1) {
                    z9 = false;
                } else if (decodeElementIndex == 0) {
                    str = beginStructure.decodeStringElement(eVar2, 0);
                    i10 |= 1;
                } else if (decodeElementIndex == 1) {
                    str3 = beginStructure.decodeStringElement(eVar2, 1);
                    i10 |= 2;
                } else if (decodeElementIndex == 2) {
                    i11 = beginStructure.decodeIntElement(eVar2, 2);
                    i10 |= 4;
                } else {
                    if (decodeElementIndex != 3) {
                        throw new f8.l(decodeElementIndex);
                    }
                    j6 = beginStructure.decodeLongElement(eVar2, 3);
                    i10 |= 8;
                }
            }
            i = i10;
            i6 = i11;
            str2 = str3;
            j = j6;
        }
        String str4 = str;
        beginStructure.endStructure(eVar2);
        return new n0(i, i6, j, str4, str2);
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return descriptor;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        n0 n0Var = (n0) obj;
        n0Var.getClass();
        b8.e eVar = descriptor;
        c8.d beginStructure = fVar.beginStructure(eVar);
        beginStructure.encodeStringElement(eVar, 0, n0Var.f1290a);
        beginStructure.encodeStringElement(eVar, 1, n0Var.f1291b);
        beginStructure.encodeIntElement(eVar, 2, n0Var.f1292c);
        beginStructure.encodeLongElement(eVar, 3, n0Var.f1293d);
        beginStructure.endStructure(eVar);
    }

    @Override // d8.x
    public final z7.b[] typeParametersSerializers() {
        return d8.o0.f3684b;
    }
}
