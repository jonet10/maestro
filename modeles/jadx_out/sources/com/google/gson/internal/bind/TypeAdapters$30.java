package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
class TypeAdapters$30 implements j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f3175a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Class f3176b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ i f3177l;

    public TypeAdapters$30(Class cls, Class cls2, i iVar) {
        this.f3175a = cls;
        this.f3176b = cls2;
        this.f3177l = iVar;
    }

    @Override // com.google.gson.j
    public final i a(com.google.gson.b bVar, TypeToken typeToken) {
        Class cls = typeToken.f3266a;
        if (cls == this.f3175a || cls == this.f3176b) {
            return this.f3177l;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.f3176b.getName() + "+" + this.f3175a.getName() + ",adapter=" + this.f3177l + "]";
    }
}
