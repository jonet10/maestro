package f8;

import com.google.android.gms.internal.measurement.z3;
import j$.util.concurrent.ConcurrentHashMap;
import java.lang.annotation.Annotation;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class m {

    /* renamed from: a, reason: collision with root package name */
    public static final n f4957a = new n();

    public static final h a(Number number, String str, String str2) {
        str.getClass();
        str2.getClass();
        return d(-1, "Unexpected special floating-point value " + number + " with key " + str + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) k(-1, str2)));
    }

    public static final k b(Number number, String str) {
        return new k("Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) k(-1, str)));
    }

    public static final k c(b8.e eVar) {
        return new k("Value of type '" + eVar.a() + "' can't be used in JSON as a key in the map. It should have either primitive or enum kind, but its kind is '" + eVar.getKind() + "'.\nUse 'allowStructuredMapKeys = true' in 'Json {}' builder to convert such maps to [key1, value1, key2, value2,...] arrays.");
    }

    public static final h d(int i, String str) {
        if (i >= 0) {
            str = "Unexpected JSON token at offset " + i + ": " + str;
        }
        return new h(str);
    }

    public static final h e(String str, CharSequence charSequence, int i) {
        charSequence.getClass();
        return d(i, str + "\nJSON input: " + ((Object) k(i, charSequence)));
    }

    public static final b8.e f(b8.e eVar, g8.f fVar) {
        b8.e f;
        eVar.getClass();
        fVar.getClass();
        if (!kotlin.jvm.internal.l.a(eVar.getKind(), b8.g.h)) {
            return eVar.isInline() ? f(eVar.h(0), fVar) : eVar;
        }
        j7.c A = a.a.A(eVar);
        b8.e eVar2 = null;
        if (A != null) {
            g8.c cVar = (g8.c) ((g8.d) fVar).f5376a.get(A);
            z7.b a8 = cVar != null ? cVar.a(q6.t.f8724a) : null;
            z7.b bVar = a8 instanceof z7.b ? a8 : null;
            if (bVar != null) {
                eVar2 = bVar.getDescriptor();
            }
        }
        return (eVar2 == null || (f = f(eVar2, fVar)) == null) ? eVar : f;
    }

    public static final byte g(char c9) {
        if (c9 < '~') {
            return d.f4950b[c9];
        }
        return (byte) 0;
    }

    public static final String h(b8.e eVar, e8.b bVar) {
        eVar.getClass();
        bVar.getClass();
        for (Annotation annotation : eVar.getAnnotations()) {
            if (annotation instanceof e8.g) {
                return ((e8.g) annotation).discriminator();
            }
        }
        return bVar.f4761a.f4772c;
    }

    public static final int i(b8.e eVar, e8.b bVar, String str) {
        eVar.getClass();
        bVar.getClass();
        str.getClass();
        e8.h hVar = bVar.f4761a;
        hVar.getClass();
        l(eVar, bVar);
        int d10 = eVar.d(str);
        if (d10 != -3 || !hVar.f4773d) {
            return d10;
        }
        a3.d dVar = bVar.f4763c;
        androidx.work.impl.utils.c cVar = new androidx.work.impl.utils.c(8, eVar, bVar);
        dVar.getClass();
        ConcurrentHashMap concurrentHashMap = (ConcurrentHashMap) dVar.f63b;
        Map map = (Map) concurrentHashMap.get(eVar);
        n nVar = f4957a;
        Object obj = map != null ? map.get(nVar) : null;
        Object obj2 = obj != null ? obj : null;
        if (obj2 == null) {
            obj2 = cVar.invoke();
            Object obj3 = concurrentHashMap.get(eVar);
            if (obj3 == null) {
                obj3 = new ConcurrentHashMap(2);
                concurrentHashMap.put(eVar, obj3);
            }
            ((Map) obj3).put(nVar, obj2);
        }
        Integer num = (Integer) ((Map) obj2).get(str);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    public static final void j(a0 a0Var, String str) {
        a0Var.o(a0Var.f4930b - 1, "Trailing comma before the end of JSON ".concat(str), "Trailing commas are non-complaint JSON and not allowed by default. Use 'allowTrailingCommas = true' in 'Json {}' builder to support them.");
        throw null;
    }

    public static final CharSequence k(int i, CharSequence charSequence) {
        charSequence.getClass();
        if (charSequence.length() >= 200) {
            if (i != -1) {
                int i6 = i - 30;
                int i10 = i + 30;
                String str = i6 <= 0 ? "" : ".....";
                String str2 = i10 >= charSequence.length() ? "" : ".....";
                StringBuilder t9 = a4.x.t(str);
                if (i6 < 0) {
                    i6 = 0;
                }
                int length = charSequence.length();
                if (i10 > length) {
                    i10 = length;
                }
                t9.append(charSequence.subSequence(i6, i10).toString());
                t9.append(str2);
                return t9.toString();
            }
            int length2 = charSequence.length() - 60;
            if (length2 > 0) {
                return "....." + charSequence.subSequence(length2, charSequence.length()).toString();
            }
        }
        return charSequence;
    }

    public static final void l(b8.e eVar, e8.b bVar) {
        eVar.getClass();
        bVar.getClass();
        if (kotlin.jvm.internal.l.a(eVar.getKind(), b8.i.h)) {
            bVar.f4761a.getClass();
        }
    }

    public static final Object m(e8.b bVar, String str, e8.t tVar, z7.a aVar) {
        bVar.getClass();
        str.getClass();
        return new r(bVar, tVar, str, aVar.getDescriptor()).decodeSerializableValue(aVar);
    }

    public static final c0 n(b8.e eVar, e8.b bVar) {
        eVar.getClass();
        z3 kind = eVar.getKind();
        if (kind instanceof b8.c) {
            return c0.f4944o;
        }
        if (kotlin.jvm.internal.l.a(kind, b8.i.i)) {
            return c0.f4942m;
        }
        if (!kotlin.jvm.internal.l.a(kind, b8.i.j)) {
            return c0.f4941l;
        }
        b8.e f = f(eVar.h(0), bVar.f4762b);
        z3 kind2 = f.getKind();
        if ((kind2 instanceof b8.d) || kotlin.jvm.internal.l.a(kind2, b8.h.h)) {
            return c0.f4943n;
        }
        bVar.f4761a.getClass();
        throw c(f);
    }

    public static final void o(a0 a0Var, Number number) {
        a0.p(a0Var, "Unexpected special floating-point value " + number + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, "It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'", 2);
        throw null;
    }

    public static final String p(byte b7) {
        return b7 == 1 ? "quotation mark '\"'" : b7 == 2 ? "string escape sequence '\\'" : b7 == 4 ? "comma ','" : b7 == 5 ? "colon ':'" : b7 == 6 ? "start of the object '{'" : b7 == 7 ? "end of the object '}'" : b7 == 8 ? "start of the array '['" : b7 == 9 ? "end of the array ']'" : b7 == 10 ? "end of the input" : b7 == Byte.MAX_VALUE ? "invalid token" : "valid token";
    }
}
