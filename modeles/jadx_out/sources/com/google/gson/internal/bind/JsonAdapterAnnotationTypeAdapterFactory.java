package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.internal.f;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;
import j$.util.concurrent.ConcurrentHashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class JsonAdapterAnnotationTypeAdapterFactory implements j {

    /* renamed from: l, reason: collision with root package name */
    public static final j f3144l;

    /* renamed from: a, reason: collision with root package name */
    public final a3.d f3145a;

    /* renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap f3146b = new ConcurrentHashMap();

    static {
        int i = 0;
        f3144l = new DummyTypeAdapterFactory(i);
        new DummyTypeAdapterFactory(i);
    }

    public JsonAdapterAnnotationTypeAdapterFactory(a3.d dVar) {
        this.f3145a = dVar;
    }

    @Override // com.google.gson.j
    public final i a(com.google.gson.b bVar, TypeToken typeToken) {
        h3.a aVar = (h3.a) typeToken.f3266a.getAnnotation(h3.a.class);
        if (aVar == null) {
            return null;
        }
        return b(this.f3145a, bVar, typeToken, aVar, true);
    }

    public final i b(a3.d dVar, com.google.gson.b bVar, TypeToken typeToken, h3.a aVar, boolean z9) {
        i a8;
        Object d10 = dVar.B(new TypeToken(aVar.value()), true).d();
        boolean nullSafe = aVar.nullSafe();
        if (d10 instanceof i) {
            a8 = (i) d10;
        } else {
            if (!(d10 instanceof j)) {
                throw new IllegalArgumentException("Invalid attempt to bind an instance of " + d10.getClass().getName() + " as a @JsonAdapter for " + f.k(typeToken.f3267b) + ". @JsonAdapter value must be a TypeAdapter, TypeAdapterFactory, JsonSerializer or JsonDeserializer.");
            }
            j jVar = (j) d10;
            if (z9) {
                j jVar2 = (j) this.f3146b.putIfAbsent(typeToken.f3266a, jVar);
                if (jVar2 != null) {
                    jVar = jVar2;
                }
            }
            a8 = jVar.a(bVar, typeToken);
        }
        return (a8 == null || !nullSafe) ? a8 : a8.a();
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class DummyTypeAdapterFactory implements j {
        private DummyTypeAdapterFactory() {
        }

        @Override // com.google.gson.j
        public final i a(com.google.gson.b bVar, TypeToken typeToken) {
            throw new AssertionError("Factory should not be used");
        }

        public /* synthetic */ DummyTypeAdapterFactory(int i) {
            this();
        }
    }
}
