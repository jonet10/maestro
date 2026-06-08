package com.google.gson;

import com.google.gson.internal.Excluder;
import com.google.gson.internal.bind.ArrayTypeAdapter;
import com.google.gson.internal.bind.CollectionTypeAdapterFactory;
import com.google.gson.internal.bind.DefaultDateTypeAdapter;
import com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory;
import com.google.gson.internal.bind.MapTypeAdapterFactory;
import com.google.gson.internal.bind.NumberTypeAdapter;
import com.google.gson.internal.bind.ObjectTypeAdapter;
import com.google.gson.internal.bind.ReflectiveTypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.inmobi.cmp.core.model.Vector;
import j$.util.DesugarCollections;
import j$.util.Objects;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.EOFException;
import java.io.IOException;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicLongArray;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: k, reason: collision with root package name */
    public static final a f3107k = a.f3103d;

    /* renamed from: l, reason: collision with root package name */
    public static final int f3108l = 1;

    /* renamed from: m, reason: collision with root package name */
    public static final int f3109m = 1;

    /* renamed from: n, reason: collision with root package name */
    public static final int f3110n = 2;

    /* renamed from: a, reason: collision with root package name */
    public final ThreadLocal f3111a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f3112b;

    /* renamed from: c, reason: collision with root package name */
    public final a3.d f3113c;

    /* renamed from: d, reason: collision with root package name */
    public final JsonAdapterAnnotationTypeAdapterFactory f3114d;

    /* renamed from: e, reason: collision with root package name */
    public final List f3115e;
    public final boolean f;
    public final a g;
    public final List h;
    public final List i;
    public final List j;

    public b() {
        Excluder excluder = Excluder.f3120l;
        Map map = Collections.EMPTY_MAP;
        List list = Collections.EMPTY_LIST;
        this.f3111a = new ThreadLocal();
        this.f3112b = new ConcurrentHashMap();
        a3.d dVar = new a3.d(20);
        this.f3113c = dVar;
        this.f = true;
        this.g = f3107k;
        this.h = list;
        this.i = list;
        this.j = list;
        ArrayList arrayList = new ArrayList();
        arrayList.add(com.google.gson.internal.bind.e.A);
        arrayList.add(ObjectTypeAdapter.d(f3109m));
        arrayList.add(excluder);
        arrayList.addAll(list);
        arrayList.add(com.google.gson.internal.bind.e.f3202p);
        arrayList.add(com.google.gson.internal.bind.e.g);
        arrayList.add(com.google.gson.internal.bind.e.f3195d);
        arrayList.add(com.google.gson.internal.bind.e.f3196e);
        arrayList.add(com.google.gson.internal.bind.e.f);
        final i iVar = com.google.gson.internal.bind.e.f3197k;
        arrayList.add(com.google.gson.internal.bind.e.b(Long.TYPE, Long.class, iVar));
        arrayList.add(com.google.gson.internal.bind.e.b(Double.TYPE, Double.class, new Gson$1()));
        arrayList.add(com.google.gson.internal.bind.e.b(Float.TYPE, Float.class, new Gson$2()));
        int i = f3110n;
        arrayList.add(i == 2 ? NumberTypeAdapter.f3152b : NumberTypeAdapter.d(i));
        arrayList.add(com.google.gson.internal.bind.e.h);
        arrayList.add(com.google.gson.internal.bind.e.i);
        arrayList.add(com.google.gson.internal.bind.e.a(AtomicLong.class, new i() { // from class: com.google.gson.Gson$4
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                return new AtomicLong(((Number) i.this.b(aVar)).longValue());
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                i.this.c(bVar, Long.valueOf(((AtomicLong) obj).get()));
            }
        }.a()));
        arrayList.add(com.google.gson.internal.bind.e.a(AtomicLongArray.class, new i() { // from class: com.google.gson.Gson$5
            @Override // com.google.gson.i
            public final Object b(k3.a aVar) {
                ArrayList arrayList2 = new ArrayList();
                aVar.b();
                while (aVar.n()) {
                    arrayList2.add(Long.valueOf(((Number) i.this.b(aVar)).longValue()));
                }
                aVar.f();
                int size = arrayList2.size();
                AtomicLongArray atomicLongArray = new AtomicLongArray(size);
                for (int i6 = 0; i6 < size; i6++) {
                    atomicLongArray.set(i6, ((Long) arrayList2.get(i6)).longValue());
                }
                return atomicLongArray;
            }

            @Override // com.google.gson.i
            public final void c(k3.b bVar, Object obj) {
                AtomicLongArray atomicLongArray = (AtomicLongArray) obj;
                bVar.c();
                int length = atomicLongArray.length();
                for (int i6 = 0; i6 < length; i6++) {
                    i.this.c(bVar, Long.valueOf(atomicLongArray.get(i6)));
                }
                bVar.f();
            }
        }.a()));
        arrayList.add(com.google.gson.internal.bind.e.j);
        arrayList.add(com.google.gson.internal.bind.e.f3198l);
        arrayList.add(com.google.gson.internal.bind.e.f3203q);
        arrayList.add(com.google.gson.internal.bind.e.f3204r);
        arrayList.add(com.google.gson.internal.bind.e.a(BigDecimal.class, com.google.gson.internal.bind.e.f3199m));
        arrayList.add(com.google.gson.internal.bind.e.a(BigInteger.class, com.google.gson.internal.bind.e.f3200n));
        arrayList.add(com.google.gson.internal.bind.e.a(com.google.gson.internal.h.class, com.google.gson.internal.bind.e.f3201o));
        arrayList.add(com.google.gson.internal.bind.e.f3205s);
        arrayList.add(com.google.gson.internal.bind.e.f3206t);
        arrayList.add(com.google.gson.internal.bind.e.v);
        arrayList.add(com.google.gson.internal.bind.e.f3208w);
        arrayList.add(com.google.gson.internal.bind.e.f3210y);
        arrayList.add(com.google.gson.internal.bind.e.f3207u);
        arrayList.add(com.google.gson.internal.bind.e.f3193b);
        arrayList.add(DefaultDateTypeAdapter.f3137c);
        arrayList.add(com.google.gson.internal.bind.e.f3209x);
        if (com.google.gson.internal.sql.b.f3261a) {
            arrayList.add(com.google.gson.internal.sql.b.f3263c);
            arrayList.add(com.google.gson.internal.sql.b.f3262b);
            arrayList.add(com.google.gson.internal.sql.b.f3264d);
        }
        arrayList.add(ArrayTypeAdapter.f3131c);
        arrayList.add(com.google.gson.internal.bind.e.f3192a);
        arrayList.add(new CollectionTypeAdapterFactory(dVar));
        arrayList.add(new MapTypeAdapterFactory(dVar));
        JsonAdapterAnnotationTypeAdapterFactory jsonAdapterAnnotationTypeAdapterFactory = new JsonAdapterAnnotationTypeAdapterFactory(dVar);
        this.f3114d = jsonAdapterAnnotationTypeAdapterFactory;
        arrayList.add(jsonAdapterAnnotationTypeAdapterFactory);
        arrayList.add(com.google.gson.internal.bind.e.B);
        arrayList.add(new ReflectiveTypeAdapterFactory(dVar, f3108l, excluder, jsonAdapterAnnotationTypeAdapterFactory));
        this.f3115e = DesugarCollections.unmodifiableList(arrayList);
    }

    public static void a(double d10) {
        if (Double.isNaN(d10) || Double.isInfinite(d10)) {
            throw new IllegalArgumentException(d10 + " is not a valid double value as per JSON specification. To override this behavior, use GsonBuilder.serializeSpecialFloatingPointValues() method.");
        }
    }

    /* JADX WARN: Finally extract failed */
    public final Object b(String str, Type type) {
        Object obj;
        TypeToken typeToken = new TypeToken(type);
        k3.a aVar = new k3.a(new StringReader(str));
        aVar.f6962x = 2;
        boolean z9 = true;
        aVar.f6962x = 1;
        try {
            try {
                try {
                    aVar.H();
                    z9 = false;
                    i c9 = c(typeToken);
                    Class cls = typeToken.f3266a;
                    obj = c9.b(aVar);
                    Class l10 = com.google.gson.internal.f.l(cls);
                    if (obj != null && !l10.isInstance(obj)) {
                        throw new ClassCastException("Type adapter '" + c9 + "' returned wrong type; requested " + cls + " but got instance of " + obj.getClass() + "\nVerify that the adapter was registered for the correct type.");
                    }
                    aVar.f6962x = 2;
                } catch (Throwable th) {
                    aVar.f6962x = 2;
                    throw th;
                }
            } catch (IOException e10) {
                throw new e(e10);
            } catch (IllegalStateException e11) {
                throw new e(e11);
            }
        } catch (EOFException e12) {
            if (!z9) {
                throw new e(e12);
            }
            aVar.f6962x = 2;
            obj = null;
        } catch (AssertionError e13) {
            throw new AssertionError("AssertionError (GSON 2.13.2): " + e13.getMessage(), e13);
        }
        if (obj != null) {
            try {
                if (aVar.H() != 10) {
                    throw new e("JSON document was not fully consumed.");
                }
            } catch (k3.c e14) {
                throw new e(e14);
            } catch (IOException e15) {
                throw new e(e15);
            }
        }
        return obj;
    }

    public final i c(TypeToken typeToken) {
        boolean z9;
        Objects.requireNonNull(typeToken, "type must not be null");
        ConcurrentHashMap concurrentHashMap = this.f3112b;
        i iVar = (i) concurrentHashMap.get(typeToken);
        if (iVar != null) {
            return iVar;
        }
        ThreadLocal threadLocal = this.f3111a;
        Map map = (Map) threadLocal.get();
        if (map == null) {
            map = new HashMap();
            threadLocal.set(map);
            z9 = true;
        } else {
            i iVar2 = (i) map.get(typeToken);
            if (iVar2 != null) {
                return iVar2;
            }
            z9 = false;
        }
        try {
            Gson$FutureTypeAdapter gson$FutureTypeAdapter = new Gson$FutureTypeAdapter();
            map.put(typeToken, gson$FutureTypeAdapter);
            Iterator it = this.f3115e.iterator();
            i iVar3 = null;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                iVar3 = ((j) it.next()).a(this, typeToken);
                if (iVar3 != null) {
                    if (gson$FutureTypeAdapter.f3101a != null) {
                        throw new AssertionError("Delegate is already set");
                    }
                    gson$FutureTypeAdapter.f3101a = iVar3;
                    map.put(typeToken, iVar3);
                }
            }
            if (z9) {
                threadLocal.remove();
            }
            if (iVar3 == null) {
                c2.a.h(typeToken, "GSON (2.13.2) cannot handle ");
                return null;
            }
            if (z9) {
                concurrentHashMap.putAll(map);
            }
            return iVar3;
        } catch (Throwable th) {
            if (z9) {
                threadLocal.remove();
            }
            throw th;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0056, code lost:
    
        if (r4 == r8) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x0021, code lost:
    
        if (r4 == r8) goto L19;
     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.google.gson.i d(com.google.gson.j r8, com.google.gson.reflect.TypeToken r9) {
        /*
            r7 = this;
            java.lang.String r0 = "skipPast must not be null"
            j$.util.Objects.requireNonNull(r8, r0)
            java.lang.String r0 = "type must not be null"
            j$.util.Objects.requireNonNull(r9, r0)
            com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory r0 = r7.f3114d
            r0.getClass()
            j$.util.concurrent.ConcurrentHashMap r1 = r0.f3146b
            com.google.gson.j r2 = com.google.gson.internal.bind.JsonAdapterAnnotationTypeAdapterFactory.f3144l
            r3 = 1
            if (r8 != r2) goto L17
            goto L58
        L17:
            java.lang.Class r2 = r9.f3266a
            java.lang.Object r4 = r1.get(r2)
            com.google.gson.j r4 = (com.google.gson.j) r4
            if (r4 == 0) goto L24
            if (r4 != r8) goto L59
            goto L58
        L24:
            java.lang.Class<h3.a> r4 = h3.a.class
            java.lang.annotation.Annotation r4 = r2.getAnnotation(r4)
            h3.a r4 = (h3.a) r4
            if (r4 != 0) goto L2f
            goto L59
        L2f:
            java.lang.Class r4 = r4.value()
            java.lang.Class<com.google.gson.j> r5 = com.google.gson.j.class
            boolean r5 = r5.isAssignableFrom(r4)
            if (r5 != 0) goto L3c
            goto L59
        L3c:
            a3.d r5 = r0.f3145a
            com.google.gson.reflect.TypeToken r6 = new com.google.gson.reflect.TypeToken
            r6.<init>(r4)
            com.google.gson.internal.m r4 = r5.B(r6, r3)
            java.lang.Object r4 = r4.d()
            com.google.gson.j r4 = (com.google.gson.j) r4
            java.lang.Object r1 = r1.putIfAbsent(r2, r4)
            com.google.gson.j r1 = (com.google.gson.j) r1
            if (r1 == 0) goto L56
            r4 = r1
        L56:
            if (r4 != r8) goto L59
        L58:
            r8 = r0
        L59:
            java.util.List r0 = r7.f3115e
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L60:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L79
            java.lang.Object r2 = r0.next()
            com.google.gson.j r2 = (com.google.gson.j) r2
            if (r1 != 0) goto L72
            if (r2 != r8) goto L60
            r1 = r3
            goto L60
        L72:
            com.google.gson.i r2 = r2.a(r7, r9)
            if (r2 == 0) goto L60
            return r2
        L79:
            if (r1 != 0) goto L80
            com.google.gson.i r8 = r7.c(r9)
            return r8
        L80:
            java.lang.String r8 = "GSON cannot serialize or deserialize "
            c2.a.h(r9, r8)
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.b.d(com.google.gson.j, com.google.gson.reflect.TypeToken):com.google.gson.i");
    }

    public final void e(Vector vector, Class cls, k3.b bVar) {
        i c9 = c(new TypeToken(cls));
        int i = bVar.f6972q;
        if (i == 2) {
            bVar.f6972q = 1;
        }
        boolean z9 = bVar.f6973r;
        boolean z10 = bVar.f6975t;
        bVar.f6973r = this.f;
        bVar.f6975t = false;
        try {
            try {
                c9.c(bVar, vector);
            } catch (IOException e10) {
                throw new e(e10);
            } catch (AssertionError e11) {
                throw new AssertionError("AssertionError (GSON 2.13.2): " + e11.getMessage(), e11);
            }
        } finally {
            bVar.u(i);
            bVar.f6973r = z9;
            bVar.f6975t = z10;
        }
    }

    public final String toString() {
        return "{serializeNulls:false,factories:" + this.f3115e + ",instanceCreators:" + this.f3113c + "}";
    }
}
