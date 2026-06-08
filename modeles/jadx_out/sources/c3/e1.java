package c3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final /* synthetic */ class e1 implements d8.x {

    /* renamed from: a, reason: collision with root package name */
    public static final e1 f1236a;
    private static final b8.e descriptor;

    static {
        e1 e1Var = new e1();
        f1236a = e1Var;
        d8.q0 q0Var = new d8.q0("com.google.firebase.sessions.Time", e1Var, 3);
        q0Var.j("ms", false);
        q0Var.j("us", true);
        q0Var.j("seconds", true);
        descriptor = q0Var;
    }

    @Override // d8.x
    public final z7.b[] childSerializers() {
        d8.i0 i0Var = d8.i0.f3655a;
        return new z7.b[]{i0Var, i0Var, i0Var};
    }

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        int i;
        long j;
        long j6;
        long j10;
        eVar.getClass();
        b8.e eVar2 = descriptor;
        c8.c beginStructure = eVar.beginStructure(eVar2);
        if (beginStructure.decodeSequentially()) {
            long decodeLongElement = beginStructure.decodeLongElement(eVar2, 0);
            long decodeLongElement2 = beginStructure.decodeLongElement(eVar2, 1);
            j = beginStructure.decodeLongElement(eVar2, 2);
            i = 7;
            j6 = decodeLongElement;
            j10 = decodeLongElement2;
        } else {
            long j11 = 0;
            boolean z9 = true;
            int i6 = 0;
            long j12 = 0;
            long j13 = 0;
            while (z9) {
                int decodeElementIndex = beginStructure.decodeElementIndex(eVar2);
                if (decodeElementIndex == -1) {
                    z9 = false;
                } else if (decodeElementIndex == 0) {
                    j12 = beginStructure.decodeLongElement(eVar2, 0);
                    i6 |= 1;
                } else if (decodeElementIndex == 1) {
                    j13 = beginStructure.decodeLongElement(eVar2, 1);
                    i6 |= 2;
                } else {
                    if (decodeElementIndex != 2) {
                        throw new f8.l(decodeElementIndex);
                    }
                    j11 = beginStructure.decodeLongElement(eVar2, 2);
                    i6 |= 4;
                }
            }
            i = i6;
            j = j11;
            j6 = j12;
            j10 = j13;
        }
        beginStructure.endStructure(eVar2);
        return new g1(i, j6, j10, j);
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return descriptor;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        g1 g1Var = (g1) obj;
        g1Var.getClass();
        b8.e eVar = descriptor;
        c8.d beginStructure = fVar.beginStructure(eVar);
        long j = g1Var.f1247a;
        long j6 = g1Var.f1249c;
        long j10 = g1Var.f1248b;
        beginStructure.encodeLongElement(eVar, 0, j);
        if (beginStructure.shouldEncodeElementDefault(eVar, 1) || j10 != 1000 * j) {
            beginStructure.encodeLongElement(eVar, 1, j10);
        }
        if (beginStructure.shouldEncodeElementDefault(eVar, 2) || j6 != j / 1000) {
            beginStructure.encodeLongElement(eVar, 2, j6);
        }
        beginStructure.endStructure(eVar);
    }

    @Override // d8.x
    public final z7.b[] typeParametersSerializers() {
        return d8.o0.f3684b;
    }
}
