package com.google.gson.internal.bind;

import a4.x;
import com.google.android.gms.internal.measurement.z3;
import com.google.gson.i;
import com.google.gson.internal.Excluder;
import com.google.gson.internal.f;
import com.google.gson.internal.m;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ReflectiveTypeAdapterFactory implements j {

    /* renamed from: a, reason: collision with root package name */
    public final a3.d f3159a;

    /* renamed from: b, reason: collision with root package name */
    public final int f3160b;

    /* renamed from: l, reason: collision with root package name */
    public final Excluder f3161l;

    /* renamed from: m, reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f3162m;

    /* renamed from: n, reason: collision with root package name */
    public final List f3163n;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory$1, reason: invalid class name */
    class AnonymousClass1 extends i {
        @Override // com.google.gson.i
        public final Object b(k3.a aVar) {
            aVar.N();
            return null;
        }

        @Override // com.google.gson.i
        public final void c(k3.b bVar, Object obj) {
            bVar.n();
        }

        public final String toString() {
            return "AnonymousOrNonStaticLocalClassAdapter";
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static abstract class Adapter<T, A> extends i {

        /* renamed from: a, reason: collision with root package name */
        public final d f3164a;

        public Adapter(d dVar) {
            this.f3164a = dVar;
        }

        @Override // com.google.gson.i
        public final Object b(k3.a aVar) {
            if (aVar.H() == 9) {
                aVar.D();
                return null;
            }
            Object d10 = d();
            Map map = this.f3164a.f3190a;
            try {
                aVar.c();
                while (aVar.n()) {
                    c cVar = (c) map.get(aVar.B());
                    if (cVar == null) {
                        aVar.N();
                    } else {
                        f(d10, aVar, cVar);
                    }
                }
                aVar.h();
                return e(d10);
            } catch (IllegalAccessException e10) {
                z3 z3Var = j3.c.f6566a;
                androidx.privacysandbox.ads.adservices.customaudience.a.m("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e10);
                return null;
            } catch (IllegalStateException e11) {
                throw new com.google.gson.e(e11);
            }
        }

        @Override // com.google.gson.i
        public final void c(k3.b bVar, Object obj) {
            if (obj == null) {
                bVar.n();
                return;
            }
            bVar.d();
            try {
                Iterator it = this.f3164a.f3191b.iterator();
                while (it.hasNext()) {
                    ((c) it.next()).a(bVar, obj);
                }
                bVar.h();
            } catch (IllegalAccessException e10) {
                z3 z3Var = j3.c.f6566a;
                androidx.privacysandbox.ads.adservices.customaudience.a.m("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e10);
            }
        }

        public abstract Object d();

        public abstract Object e(Object obj);

        public abstract void f(Object obj, k3.a aVar, c cVar);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class RecordAdapter<T> extends Adapter<T, Object[]> {

        /* renamed from: e, reason: collision with root package name */
        public static final HashMap f3166e;

        /* renamed from: b, reason: collision with root package name */
        public final Constructor f3167b;

        /* renamed from: c, reason: collision with root package name */
        public final Object[] f3168c;

        /* renamed from: d, reason: collision with root package name */
        public final HashMap f3169d;

        static {
            HashMap hashMap = new HashMap();
            hashMap.put(Byte.TYPE, (byte) 0);
            hashMap.put(Short.TYPE, (short) 0);
            hashMap.put(Integer.TYPE, 0);
            hashMap.put(Long.TYPE, 0L);
            hashMap.put(Float.TYPE, Float.valueOf(0.0f));
            hashMap.put(Double.TYPE, Double.valueOf(0.0d));
            hashMap.put(Character.TYPE, (char) 0);
            hashMap.put(Boolean.TYPE, Boolean.FALSE);
            f3166e = hashMap;
        }

        public RecordAdapter(Class cls, d dVar) {
            super(dVar);
            this.f3169d = new HashMap();
            z3 z3Var = j3.c.f6566a;
            Constructor q9 = z3Var.q(cls);
            this.f3167b = q9;
            j3.c.f(q9);
            String[] v = z3Var.v(cls);
            for (int i = 0; i < v.length; i++) {
                this.f3169d.put(v[i], Integer.valueOf(i));
            }
            Class<?>[] parameterTypes = this.f3167b.getParameterTypes();
            this.f3168c = new Object[parameterTypes.length];
            for (int i6 = 0; i6 < parameterTypes.length; i6++) {
                this.f3168c[i6] = f3166e.get(parameterTypes[i6]);
            }
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object d() {
            return (Object[]) this.f3168c.clone();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object e(Object obj) {
            Object[] objArr = (Object[]) obj;
            Constructor constructor = this.f3167b;
            try {
                return constructor.newInstance(objArr);
            } catch (IllegalAccessException e10) {
                z3 z3Var = j3.c.f6566a;
                androidx.privacysandbox.ads.adservices.customaudience.a.m("Unexpected IllegalAccessException occurred (Gson 2.13.2). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", e10);
                return null;
            } catch (IllegalArgumentException e11) {
                e = e11;
                throw new RuntimeException("Failed to invoke constructor '" + j3.c.b(constructor) + "' with args " + Arrays.toString(objArr), e);
            } catch (InstantiationException e12) {
                e = e12;
                throw new RuntimeException("Failed to invoke constructor '" + j3.c.b(constructor) + "' with args " + Arrays.toString(objArr), e);
            } catch (InvocationTargetException e13) {
                androidx.privacysandbox.ads.adservices.customaudience.a.m("Failed to invoke constructor '" + j3.c.b(constructor) + "' with args " + Arrays.toString(objArr), e13.getCause());
                return null;
            }
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final void f(Object obj, k3.a aVar, c cVar) {
            Object[] objArr = (Object[]) obj;
            String str = cVar.f3186c;
            Integer num = (Integer) this.f3169d.get(str);
            if (num == null) {
                androidx.privacysandbox.ads.adservices.customaudience.a.k("Could not find the index in the constructor '", j3.c.b(this.f3167b), "' for field with name '", str, "', unable to determine which argument in the constructor the field corresponds to. This is unexpected behavior, as we expect the RecordComponents to have the same names as the fields in the Java class, and that the order of the RecordComponents is the same as the order of the canonical constructor parameters.");
                return;
            }
            int intValue = num.intValue();
            Object b7 = cVar.f.b(aVar);
            if (b7 != null || !cVar.g) {
                objArr[intValue] = b7;
            } else {
                StringBuilder v = x.v("null is not allowed as value for record component '", str, "' of primitive type; at path ");
                v.append(aVar.j(false));
                throw new a1.b(v.toString());
            }
        }
    }

    public ReflectiveTypeAdapterFactory(a3.d dVar, int i, Excluder excluder, JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory) {
        List list = Collections.EMPTY_LIST;
        this.f3159a = dVar;
        this.f3160b = i;
        this.f3161l = excluder;
        this.f3162m = jsonAdapterAnnotationTypeAdapterFactory;
        this.f3163n = list;
    }

    public static void b(Class cls, String str, Field field, Field field2) {
        throw new IllegalArgumentException("Class " + cls.getName() + " declares multiple JSON fields named '" + str + "'; conflict is caused by fields " + j3.c.c(field) + " and " + j3.c.c(field2) + "\nSee " + "https://github.com/google/gson/blob/main/Troubleshooting.md#".concat("duplicate-fields"));
    }

    @Override // com.google.gson.j
    public final i a(com.google.gson.b bVar, TypeToken typeToken) {
        Class cls = typeToken.f3266a;
        if (!Object.class.isAssignableFrom(cls)) {
            return null;
        }
        z3 z3Var = j3.c.f6566a;
        if (!Modifier.isStatic(cls.getModifiers()) && (cls.isAnonymousClass() || cls.isLocalClass())) {
            return new AnonymousClass1();
        }
        List list = Collections.EMPTY_LIST;
        f.e();
        return j3.c.f6566a.A(cls) ? new RecordAdapter(cls, c(bVar, typeToken, cls, true)) : new FieldReflectionAdapter(this.f3159a.B(typeToken, true), c(bVar, typeToken, cls, false));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x017c  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x012c  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010d  */
    /* JADX WARN: Type inference failed for: r14v0 */
    /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r14v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.gson.internal.bind.d c(com.google.gson.b r30, com.google.gson.reflect.TypeToken r31, java.lang.Class r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.c(com.google.gson.b, com.google.gson.reflect.TypeToken, java.lang.Class, boolean):com.google.gson.internal.bind.d");
    }

    public final boolean d(Field field, boolean z9) {
        boolean z10;
        Excluder excluder = this.f3161l;
        excluder.getClass();
        if ((136 & field.getModifiers()) != 0 || field.isSynthetic() || excluder.b(field.getType(), z9)) {
            z10 = true;
        } else {
            List list = z9 ? excluder.f3121a : excluder.f3122b;
            if (!list.isEmpty()) {
                Iterator it = list.iterator();
                if (it.hasNext()) {
                    it.next().getClass();
                    com.google.gson.internal.a.o();
                    return false;
                }
            }
            z10 = false;
        }
        return !z10;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class FieldReflectionAdapter<T> extends Adapter<T, T> {

        /* renamed from: b, reason: collision with root package name */
        public final m f3165b;

        public FieldReflectionAdapter(m mVar, d dVar) {
            super(dVar);
            this.f3165b = mVar;
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object d() {
            return this.f3165b.d();
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final void f(Object obj, k3.a aVar, c cVar) {
            Field field = cVar.f3185b;
            Object b7 = cVar.f.b(aVar);
            if (b7 == null && cVar.g) {
                return;
            }
            if (cVar.h) {
                throw new com.google.gson.e("Cannot set value of 'static final' ".concat(j3.c.d(field, false)));
            }
            field.set(obj, b7);
        }

        @Override // com.google.gson.internal.bind.ReflectiveTypeAdapterFactory.Adapter
        public final Object e(Object obj) {
            return obj;
        }
    }
}
