package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.internal.f;
import com.google.gson.internal.m;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class CollectionTypeAdapterFactory implements j {

    /* renamed from: a, reason: collision with root package name */
    public final a3.d f3134a;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Adapter<E> extends i {

        /* renamed from: a, reason: collision with root package name */
        public final i f3135a;

        /* renamed from: b, reason: collision with root package name */
        public final m f3136b;

        public Adapter(i iVar, m mVar) {
            this.f3135a = iVar;
            this.f3136b = mVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.gson.i
        public final Object b(k3.a aVar) {
            if (aVar.H() == 9) {
                aVar.D();
                return null;
            }
            Collection collection = (Collection) this.f3136b.d();
            aVar.b();
            while (aVar.n()) {
                collection.add(((TypeAdapterRuntimeTypeWrapper) this.f3135a).f3171b.b(aVar));
            }
            aVar.f();
            return collection;
        }

        @Override // com.google.gson.i
        public final void c(k3.b bVar, Object obj) {
            Collection collection = (Collection) obj;
            if (collection == null) {
                bVar.n();
                return;
            }
            bVar.c();
            Iterator<E> it = collection.iterator();
            while (it.hasNext()) {
                this.f3135a.c(bVar, it.next());
            }
            bVar.f();
        }
    }

    public CollectionTypeAdapterFactory(a3.d dVar) {
        this.f3134a = dVar;
    }

    @Override // com.google.gson.j
    public final i a(com.google.gson.b bVar, TypeToken typeToken) {
        Type type = typeToken.f3267b;
        Class cls = typeToken.f3266a;
        if (!Collection.class.isAssignableFrom(cls)) {
            return null;
        }
        Type h = f.h(type, cls, Collection.class);
        Class cls2 = h instanceof ParameterizedType ? ((ParameterizedType) h).getActualTypeArguments()[0] : Object.class;
        return new Adapter(new TypeAdapterRuntimeTypeWrapper(bVar, bVar.c(new TypeToken(cls2)), cls2), this.f3134a.B(typeToken, false));
    }
}
