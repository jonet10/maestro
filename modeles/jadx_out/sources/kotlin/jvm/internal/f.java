package kotlin.jvm.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class f implements j7.c, e {

    /* renamed from: b, reason: collision with root package name */
    public static final Map f7017b;

    /* renamed from: a, reason: collision with root package name */
    public final Class f7018a;

    static {
        int i = 0;
        List d02 = q6.m.d0(d7.a.class, d7.l.class, d7.p.class, d7.q.class, d7.r.class, d7.s.class, d7.t.class, d7.u.class, d7.v.class, d7.w.class, d7.b.class, d7.c.class, d7.d.class, d7.e.class, d7.f.class, d7.g.class, d7.h.class, d7.i.class, d7.j.class, d7.k.class, d7.m.class, d7.n.class, d7.o.class);
        ArrayList arrayList = new ArrayList(q6.n.i0(d02, 10));
        for (Object obj : d02) {
            int i6 = i + 1;
            if (i < 0) {
                q6.m.h0();
                throw null;
            }
            arrayList.add(new p6.i((Class) obj, Integer.valueOf(i)));
            i = i6;
        }
        f7017b = q6.a0.k0(arrayList);
    }

    public f(Class cls) {
        cls.getClass();
        this.f7018a = cls;
    }

    @Override // kotlin.jvm.internal.e
    public final Class a() {
        return this.f7018a;
    }

    public final String b() {
        String b7;
        Class cls = this.f7018a;
        cls.getClass();
        String str = null;
        if (cls.isAnonymousClass() || cls.isLocalClass()) {
            return null;
        }
        if (!cls.isArray()) {
            String b10 = l.b(cls.getName());
            return b10 == null ? cls.getCanonicalName() : b10;
        }
        Class<?> componentType = cls.getComponentType();
        if (componentType.isPrimitive() && (b7 = l.b(componentType.getName())) != null) {
            str = b7.concat("Array");
        }
        return str == null ? "kotlin.Array" : str;
    }

    public final String c() {
        String f;
        Class cls = this.f7018a;
        cls.getClass();
        String str = null;
        if (cls.isAnonymousClass()) {
            return null;
        }
        if (!cls.isLocalClass()) {
            if (!cls.isArray()) {
                String f10 = l.f(cls.getName());
                return f10 == null ? cls.getSimpleName() : f10;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (f = l.f(componentType.getName())) != null) {
                str = f.concat("Array");
            }
            return str == null ? "Array" : str;
        }
        String simpleName = cls.getSimpleName();
        Method enclosingMethod = cls.getEnclosingMethod();
        if (enclosingMethod != null) {
            return l7.m.H0(simpleName, enclosingMethod.getName() + '$');
        }
        Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
        if (enclosingConstructor == null) {
            int x02 = l7.m.x0('$', 0, 6, simpleName);
            return x02 == -1 ? simpleName : simpleName.substring(x02 + 1, simpleName.length());
        }
        return l7.m.H0(simpleName, enclosingConstructor.getName() + '$');
    }

    public final boolean d(Object obj) {
        Class cls = this.f7018a;
        cls.getClass();
        Map map = f7017b;
        map.getClass();
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return a0.c(num.intValue(), obj);
        }
        if (cls.isPrimitive()) {
            cls = d0.b.G(y.a(cls));
        }
        return cls.isInstance(obj);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof f) && d0.b.G(this).equals(d0.b.G((j7.c) obj));
    }

    public final int hashCode() {
        return d0.b.G(this).hashCode();
    }

    public final String toString() {
        return this.f7018a + " (Kotlin reflection is not available)";
    }
}
