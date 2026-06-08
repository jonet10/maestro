package f8;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.gms.internal.measurement.i5;
import com.google.android.gms.internal.measurement.z3;
import d8.f0;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public abstract class a implements e8.i, c8.e, c8.c {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f4924a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public boolean f4925b;

    /* renamed from: c, reason: collision with root package name */
    public final e8.b f4926c;

    /* renamed from: d, reason: collision with root package name */
    public final String f4927d;

    /* renamed from: e, reason: collision with root package name */
    public final e8.h f4928e;

    public a(e8.b bVar, String str) {
        this.f4926c = bVar;
        this.f4927d = str;
        this.f4928e = bVar.f4761a;
    }

    @Override // e8.i
    public final e8.k a() {
        return c();
    }

    public abstract e8.k b(String str);

    @Override // c8.e
    public c8.c beginStructure(b8.e eVar) {
        eVar.getClass();
        e8.k c9 = c();
        z3 kind = eVar.getKind();
        boolean a8 = kotlin.jvm.internal.l.a(kind, b8.i.i);
        e8.b bVar = this.f4926c;
        if (a8 || (kind instanceof b8.c)) {
            String a10 = eVar.a();
            if (c9 instanceof e8.d) {
                return new s(bVar, (e8.d) c9);
            }
            throw m.e("Expected " + kotlin.jvm.internal.y.a(e8.d.class).c() + ", but had " + kotlin.jvm.internal.y.a(c9.getClass()).c() + " as the serialized body of " + a10 + " at element: " + s(), c9.toString(), -1);
        }
        if (!kotlin.jvm.internal.l.a(kind, b8.i.j)) {
            String a11 = eVar.a();
            if (c9 instanceof e8.t) {
                return new r(bVar, (e8.t) c9, this.f4927d, 8);
            }
            throw m.e("Expected " + kotlin.jvm.internal.y.a(e8.t.class).c() + ", but had " + kotlin.jvm.internal.y.a(c9.getClass()).c() + " as the serialized body of " + a11 + " at element: " + s(), c9.toString(), -1);
        }
        b8.e f = m.f(eVar.h(0), bVar.f4762b);
        z3 kind2 = f.getKind();
        if (!(kind2 instanceof b8.d) && !kotlin.jvm.internal.l.a(kind2, b8.h.h)) {
            bVar.f4761a.getClass();
            throw m.c(f);
        }
        String a12 = eVar.a();
        if (c9 instanceof e8.t) {
            return new t(bVar, (e8.t) c9);
        }
        throw m.e("Expected " + kotlin.jvm.internal.y.a(e8.t.class).c() + ", but had " + kotlin.jvm.internal.y.a(c9.getClass()).c() + " as the serialized body of " + a12 + " at element: " + s(), c9.toString(), -1);
    }

    public final e8.k c() {
        e8.k b7;
        String str = (String) o();
        return (str == null || (b7 = b(str)) == null) ? q() : b7;
    }

    public final boolean d(Object obj) {
        String str = (String) obj;
        str.getClass();
        e8.k b7 = b(str);
        if (!(b7 instanceof e8.x)) {
            throw m.e("Expected " + kotlin.jvm.internal.y.a(e8.x.class).c() + ", but had " + kotlin.jvm.internal.y.a(b7.getClass()).c() + " as the serialized body of boolean at element: " + t(str), b7.toString(), -1);
        }
        e8.x xVar = (e8.x) b7;
        try {
            d8.y yVar = e8.l.f4775a;
            String c9 = xVar.c();
            String[] strArr = b0.f4936a;
            c9.getClass();
            Boolean bool = c9.equalsIgnoreCase("true") ? Boolean.TRUE : c9.equalsIgnoreCase("false") ? Boolean.FALSE : null;
            if (bool != null) {
                return bool.booleanValue();
            }
            u(xVar, TypedValues.Custom.S_BOOLEAN, str);
            throw null;
        } catch (IllegalArgumentException unused) {
            u(xVar, TypedValues.Custom.S_BOOLEAN, str);
            throw null;
        }
    }

    @Override // c8.e
    public final boolean decodeBoolean() {
        return d(r());
    }

    @Override // c8.c
    public final boolean decodeBooleanElement(b8.e eVar, int i) {
        eVar.getClass();
        return d(p(eVar, i));
    }

    @Override // c8.e
    public final byte decodeByte() {
        return e(r());
    }

    @Override // c8.c
    public final byte decodeByteElement(b8.e eVar, int i) {
        eVar.getClass();
        return e(p(eVar, i));
    }

    @Override // c8.e
    public final char decodeChar() {
        return f(r());
    }

    @Override // c8.c
    public final char decodeCharElement(b8.e eVar, int i) {
        eVar.getClass();
        return f(p(eVar, i));
    }

    @Override // c8.c
    public final int decodeCollectionSize(b8.e eVar) {
        eVar.getClass();
        return -1;
    }

    @Override // c8.e
    public final double decodeDouble() {
        return g(r());
    }

    @Override // c8.c
    public final double decodeDoubleElement(b8.e eVar, int i) {
        eVar.getClass();
        return g(p(eVar, i));
    }

    @Override // c8.e
    public final float decodeFloat() {
        return h(r());
    }

    @Override // c8.c
    public final float decodeFloatElement(b8.e eVar, int i) {
        eVar.getClass();
        return h(p(eVar, i));
    }

    @Override // c8.e
    public final c8.e decodeInline(b8.e eVar) {
        eVar.getClass();
        if (o() != null) {
            return i(r(), eVar);
        }
        return new p(this.f4926c, q(), this.f4927d).decodeInline(eVar);
    }

    @Override // c8.c
    public final c8.e decodeInlineElement(b8.e eVar, int i) {
        eVar.getClass();
        return i(p(eVar, i), ((f0) eVar).h(i));
    }

    @Override // c8.e
    public final int decodeInt() {
        return j(r());
    }

    @Override // c8.c
    public final int decodeIntElement(b8.e eVar, int i) {
        eVar.getClass();
        return j(p(eVar, i));
    }

    @Override // c8.e
    public final long decodeLong() {
        return k(r());
    }

    @Override // c8.c
    public final long decodeLongElement(b8.e eVar, int i) {
        eVar.getClass();
        return k(p(eVar, i));
    }

    @Override // c8.e
    public boolean decodeNotNullMark() {
        return !(c() instanceof e8.q);
    }

    @Override // c8.e
    public final Void decodeNull() {
        return null;
    }

    @Override // c8.c
    public final Object decodeNullableSerializableElement(b8.e eVar, int i, z7.a aVar, Object obj) {
        eVar.getClass();
        aVar.getClass();
        this.f4924a.add(p(eVar, i));
        Object decodeSerializableValue = (aVar.getDescriptor().c() || decodeNotNullMark()) ? decodeSerializableValue(aVar) : null;
        if (!this.f4925b) {
            r();
        }
        this.f4925b = false;
        return decodeSerializableValue;
    }

    @Override // c8.c
    public final boolean decodeSequentially() {
        return false;
    }

    @Override // c8.c
    public final Object decodeSerializableElement(b8.e eVar, int i, z7.a aVar, Object obj) {
        eVar.getClass();
        aVar.getClass();
        this.f4924a.add(p(eVar, i));
        aVar.getClass();
        Object decodeSerializableValue = decodeSerializableValue(aVar);
        if (!this.f4925b) {
            r();
        }
        this.f4925b = false;
        return decodeSerializableValue;
    }

    @Override // c8.e
    public final Object decodeSerializableValue(z7.a aVar) {
        aVar.getClass();
        if (!(aVar instanceof d8.b)) {
            return aVar.deserialize(this);
        }
        e8.b bVar = this.f4926c;
        bVar.f4761a.getClass();
        z7.e eVar = (z7.e) ((d8.b) aVar);
        String h = m.h(eVar.getDescriptor(), bVar);
        e8.k c9 = c();
        String a8 = eVar.getDescriptor().a();
        if (!(c9 instanceof e8.t)) {
            throw m.e("Expected " + kotlin.jvm.internal.y.a(e8.t.class).c() + ", but had " + kotlin.jvm.internal.y.a(c9.getClass()).c() + " as the serialized body of " + a8 + " at element: " + s(), c9.toString(), -1);
        }
        e8.t tVar = (e8.t) c9;
        e8.k kVar = (e8.k) tVar.get(h);
        String str = null;
        if (kVar != null) {
            e8.x b7 = e8.l.b(kVar);
            if (!(b7 instanceof e8.q)) {
                str = b7.c();
            }
        }
        try {
            return m.m(bVar, h, tVar, i5.t((d8.b) aVar, this, str));
        } catch (z7.g e10) {
            String message = e10.getMessage();
            message.getClass();
            throw m.e(message, tVar.toString(), -1);
        }
    }

    @Override // c8.e
    public final short decodeShort() {
        return l(r());
    }

    @Override // c8.c
    public final short decodeShortElement(b8.e eVar, int i) {
        eVar.getClass();
        return l(p(eVar, i));
    }

    @Override // c8.e
    public final String decodeString() {
        return m(r());
    }

    @Override // c8.c
    public final String decodeStringElement(b8.e eVar, int i) {
        eVar.getClass();
        return m(p(eVar, i));
    }

    public final byte e(Object obj) {
        String str = (String) obj;
        str.getClass();
        e8.k b7 = b(str);
        if (!(b7 instanceof e8.x)) {
            throw m.e("Expected " + kotlin.jvm.internal.y.a(e8.x.class).c() + ", but had " + kotlin.jvm.internal.y.a(b7.getClass()).c() + " as the serialized body of byte at element: " + t(str), b7.toString(), -1);
        }
        e8.x xVar = (e8.x) b7;
        try {
            int a8 = e8.l.a(xVar);
            Byte valueOf = (-128 > a8 || a8 > 127) ? null : Byte.valueOf((byte) a8);
            if (valueOf != null) {
                return valueOf.byteValue();
            }
            u(xVar, "byte", str);
            throw null;
        } catch (IllegalArgumentException unused) {
            u(xVar, "byte", str);
            throw null;
        }
    }

    @Override // c8.c
    public void endStructure(b8.e eVar) {
        eVar.getClass();
    }

    public final char f(Object obj) {
        String str = (String) obj;
        str.getClass();
        e8.k b7 = b(str);
        if (!(b7 instanceof e8.x)) {
            throw m.e("Expected " + kotlin.jvm.internal.y.a(e8.x.class).c() + ", but had " + kotlin.jvm.internal.y.a(b7.getClass()).c() + " as the serialized body of char at element: " + t(str), b7.toString(), -1);
        }
        e8.x xVar = (e8.x) b7;
        try {
            String c9 = xVar.c();
            c9.getClass();
            int length = c9.length();
            if (length == 0) {
                throw new NoSuchElementException("Char sequence is empty.");
            }
            if (length == 1) {
                return c9.charAt(0);
            }
            throw new IllegalArgumentException("Char sequence has more than one element.");
        } catch (IllegalArgumentException unused) {
            u(xVar, "char", str);
            throw null;
        }
    }

    public final double g(Object obj) {
        String str = (String) obj;
        str.getClass();
        e8.k b7 = b(str);
        if (!(b7 instanceof e8.x)) {
            throw m.e("Expected " + kotlin.jvm.internal.y.a(e8.x.class).c() + ", but had " + kotlin.jvm.internal.y.a(b7.getClass()).c() + " as the serialized body of double at element: " + t(str), b7.toString(), -1);
        }
        e8.x xVar = (e8.x) b7;
        try {
            d8.y yVar = e8.l.f4775a;
            double parseDouble = Double.parseDouble(xVar.c());
            this.f4926c.f4761a.getClass();
            if (Double.isInfinite(parseDouble) || Double.isNaN(parseDouble)) {
                throw m.a(Double.valueOf(parseDouble), str, c().toString());
            }
            return parseDouble;
        } catch (IllegalArgumentException unused) {
            u(xVar, "double", str);
            throw null;
        }
    }

    @Override // c8.c
    public final g8.f getSerializersModule() {
        return this.f4926c.f4762b;
    }

    public final float h(Object obj) {
        String str = (String) obj;
        str.getClass();
        e8.k b7 = b(str);
        if (!(b7 instanceof e8.x)) {
            throw m.e("Expected " + kotlin.jvm.internal.y.a(e8.x.class).c() + ", but had " + kotlin.jvm.internal.y.a(b7.getClass()).c() + " as the serialized body of float at element: " + t(str), b7.toString(), -1);
        }
        e8.x xVar = (e8.x) b7;
        try {
            d8.y yVar = e8.l.f4775a;
            float parseFloat = Float.parseFloat(xVar.c());
            this.f4926c.f4761a.getClass();
            if (Float.isInfinite(parseFloat) || Float.isNaN(parseFloat)) {
                throw m.a(Float.valueOf(parseFloat), str, c().toString());
            }
            return parseFloat;
        } catch (IllegalArgumentException unused) {
            u(xVar, TypedValues.Custom.S_FLOAT, str);
            throw null;
        }
    }

    public final c8.e i(Object obj, b8.e eVar) {
        String str = (String) obj;
        str.getClass();
        eVar.getClass();
        if (!z.a(eVar)) {
            this.f4924a.add(str);
            return this;
        }
        e8.k b7 = b(str);
        String a8 = eVar.a();
        if (b7 instanceof e8.x) {
            String c9 = ((e8.x) b7).c();
            e8.b bVar = this.f4926c;
            bVar.getClass();
            c9.getClass();
            bVar.f4761a.getClass();
            return new g(new a0(c9), bVar);
        }
        throw m.e("Expected " + kotlin.jvm.internal.y.a(e8.x.class).c() + ", but had " + kotlin.jvm.internal.y.a(b7.getClass()).c() + " as the serialized body of " + a8 + " at element: " + t(str), b7.toString(), -1);
    }

    public final int j(Object obj) {
        String str = (String) obj;
        str.getClass();
        e8.k b7 = b(str);
        if (b7 instanceof e8.x) {
            e8.x xVar = (e8.x) b7;
            try {
                return e8.l.a(xVar);
            } catch (IllegalArgumentException unused) {
                u(xVar, "int", str);
                throw null;
            }
        }
        throw m.e("Expected " + kotlin.jvm.internal.y.a(e8.x.class).c() + ", but had " + kotlin.jvm.internal.y.a(b7.getClass()).c() + " as the serialized body of int at element: " + t(str), b7.toString(), -1);
    }

    public final long k(Object obj) {
        String str = (String) obj;
        str.getClass();
        e8.k b7 = b(str);
        if (b7 instanceof e8.x) {
            e8.x xVar = (e8.x) b7;
            try {
                d8.y yVar = e8.l.f4775a;
                try {
                    return new a0(xVar.c()).l();
                } catch (h e10) {
                    throw new NumberFormatException(e10.getMessage());
                }
            } catch (IllegalArgumentException unused) {
                u(xVar, "long", str);
                throw null;
            }
        }
        throw m.e("Expected " + kotlin.jvm.internal.y.a(e8.x.class).c() + ", but had " + kotlin.jvm.internal.y.a(b7.getClass()).c() + " as the serialized body of long at element: " + t(str), b7.toString(), -1);
    }

    public final short l(Object obj) {
        String str = (String) obj;
        str.getClass();
        e8.k b7 = b(str);
        if (!(b7 instanceof e8.x)) {
            throw m.e("Expected " + kotlin.jvm.internal.y.a(e8.x.class).c() + ", but had " + kotlin.jvm.internal.y.a(b7.getClass()).c() + " as the serialized body of short at element: " + t(str), b7.toString(), -1);
        }
        e8.x xVar = (e8.x) b7;
        try {
            int a8 = e8.l.a(xVar);
            Short valueOf = (-32768 > a8 || a8 > 32767) ? null : Short.valueOf((short) a8);
            if (valueOf != null) {
                return valueOf.shortValue();
            }
            u(xVar, "short", str);
            throw null;
        } catch (IllegalArgumentException unused) {
            u(xVar, "short", str);
            throw null;
        }
    }

    public final String m(Object obj) {
        String str = (String) obj;
        str.getClass();
        e8.k b7 = b(str);
        if (!(b7 instanceof e8.x)) {
            throw m.e("Expected " + kotlin.jvm.internal.y.a(e8.x.class).c() + ", but had " + kotlin.jvm.internal.y.a(b7.getClass()).c() + " as the serialized body of string at element: " + t(str), b7.toString(), -1);
        }
        e8.x xVar = (e8.x) b7;
        if (!(xVar instanceof e8.n)) {
            StringBuilder v = a4.x.v("Expected string value for a non-null key '", str, "', got null literal instead at element: ");
            v.append(t(str));
            throw m.e(v.toString(), c().toString(), -1);
        }
        e8.n nVar = (e8.n) xVar;
        if (nVar.f4778a) {
            return nVar.f4779b;
        }
        this.f4926c.f4761a.getClass();
        throw m.e("String literal for key '" + str + "' should be quoted at element: " + t(str) + ".\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON.", c().toString(), -1);
    }

    public String n(b8.e eVar, int i) {
        eVar.getClass();
        return eVar.f(i);
    }

    public final Object o() {
        ArrayList arrayList = this.f4924a;
        arrayList.getClass();
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList.get(arrayList.size() - 1);
    }

    public final String p(b8.e eVar, int i) {
        eVar.getClass();
        String n10 = n(eVar, i);
        n10.getClass();
        return n10;
    }

    public abstract e8.k q();

    public final Object r() {
        ArrayList arrayList = this.f4924a;
        Object remove = arrayList.remove(q6.m.c0(arrayList));
        this.f4925b = true;
        return remove;
    }

    public final String s() {
        ArrayList arrayList = this.f4924a;
        return arrayList.isEmpty() ? "$" : q6.l.x0(arrayList, ".", "$.", null, null, 60);
    }

    public final String t(String str) {
        str.getClass();
        return s() + '.' + str;
    }

    public final void u(e8.x xVar, String str, String str2) {
        throw m.e("Failed to parse literal '" + xVar + "' as " + (l7.u.p0(str, "i", false) ? "an " : "a ").concat(str) + " value at element: " + t(str2), c().toString(), -1);
    }
}
