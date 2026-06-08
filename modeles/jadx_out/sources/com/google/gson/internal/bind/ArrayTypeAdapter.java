package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.internal.f;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class ArrayTypeAdapter<E> extends i {

    /* renamed from: c, reason: collision with root package name */
    public static final j f3131c = new j() { // from class: com.google.gson.internal.bind.ArrayTypeAdapter.1
        @Override // com.google.gson.j
        public final i a(com.google.gson.b bVar, TypeToken typeToken) {
            Type type = typeToken.f3267b;
            boolean z9 = type instanceof GenericArrayType;
            if (!z9 && (!(type instanceof Class) || !((Class) type).isArray())) {
                return null;
            }
            Type genericComponentType = z9 ? ((GenericArrayType) type).getGenericComponentType() : ((Class) type).getComponentType();
            return new ArrayTypeAdapter(bVar, bVar.c(new TypeToken(genericComponentType)), f.g(genericComponentType));
        }
    };

    /* renamed from: a, reason: collision with root package name */
    public final Class f3132a;

    /* renamed from: b, reason: collision with root package name */
    public final i f3133b;

    public ArrayTypeAdapter(com.google.gson.b bVar, i iVar, Class cls) {
        this.f3133b = new TypeAdapterRuntimeTypeWrapper(bVar, iVar, cls);
        this.f3132a = cls;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.gson.i
    public final Object b(k3.a aVar) {
        if (aVar.H() == 9) {
            aVar.D();
            return null;
        }
        ArrayList arrayList = new ArrayList();
        aVar.b();
        while (aVar.n()) {
            arrayList.add(((TypeAdapterRuntimeTypeWrapper) this.f3133b).f3171b.b(aVar));
        }
        aVar.f();
        int size = arrayList.size();
        Class cls = this.f3132a;
        if (!cls.isPrimitive()) {
            return arrayList.toArray((Object[]) Array.newInstance((Class<?>) cls, size));
        }
        Object newInstance = Array.newInstance((Class<?>) cls, size);
        for (int i = 0; i < size; i++) {
            Array.set(newInstance, i, arrayList.get(i));
        }
        return newInstance;
    }

    @Override // com.google.gson.i
    public final void c(k3.b bVar, Object obj) {
        if (obj == null) {
            bVar.n();
            return;
        }
        bVar.c();
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            this.f3133b.c(bVar, Array.get(obj, i));
        }
        bVar.f();
    }
}
