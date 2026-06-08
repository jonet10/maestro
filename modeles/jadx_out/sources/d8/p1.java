package d8;

import com.google.android.gms.internal.measurement.z3;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p1 implements z7.b {

    /* renamed from: a, reason: collision with root package name */
    public static final p1 f3691a = new p1();

    /* renamed from: b, reason: collision with root package name */
    public static final u0 f3692b = new u0("kotlin.uuid.Uuid", b8.d.f1111p);

    @Override // z7.a
    public final Object deserialize(c8.e eVar) {
        eVar.getClass();
        String decodeString = eVar.decodeString();
        decodeString.getClass();
        int length = decodeString.length();
        if (length == 32) {
            long b7 = l7.c.b(0, 16, decodeString);
            long b10 = l7.c.b(16, 32, decodeString);
            if (b7 != 0 || b10 != 0) {
                return new n7.a(b7, b10);
            }
        } else {
            if (length != 36) {
                StringBuilder sb = new StringBuilder("Expected either a 36-char string in the standard hex-and-dash UUID format or a 32-char hexadecimal string, but was \"");
                sb.append(decodeString.length() <= 64 ? decodeString : decodeString.substring(0, 64).concat("..."));
                sb.append("\" of length ");
                sb.append(decodeString.length());
                throw new IllegalArgumentException(sb.toString());
            }
            long b11 = l7.c.b(0, 8, decodeString);
            z3.i(8, decodeString);
            long b12 = l7.c.b(9, 13, decodeString);
            z3.i(13, decodeString);
            long b13 = l7.c.b(14, 18, decodeString);
            z3.i(18, decodeString);
            long b14 = l7.c.b(19, 23, decodeString);
            z3.i(23, decodeString);
            long j = (b12 << 16) | (b11 << 32) | b13;
            long b15 = l7.c.b(24, 36, decodeString) | (b14 << 48);
            if (j != 0 || b15 != 0) {
                return new n7.a(j, b15);
            }
        }
        return n7.a.f8108l;
    }

    @Override // z7.h, z7.a
    public final b8.e getDescriptor() {
        return f3692b;
    }

    @Override // z7.h
    public final void serialize(c8.f fVar, Object obj) {
        n7.a aVar = (n7.a) obj;
        aVar.getClass();
        fVar.encodeString(aVar.toString());
    }
}
