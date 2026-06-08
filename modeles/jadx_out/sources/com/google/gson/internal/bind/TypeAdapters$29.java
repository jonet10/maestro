package com.google.gson.internal.bind;

import com.google.gson.i;
import com.google.gson.j;
import com.google.gson.reflect.TypeToken;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
class TypeAdapters$29 implements j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Class f3173a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f3174b;

    public TypeAdapters$29(Class cls, i iVar) {
        this.f3173a = cls;
        this.f3174b = iVar;
    }

    @Override // com.google.gson.j
    public final i a(com.google.gson.b bVar, TypeToken typeToken) {
        if (typeToken.f3266a == this.f3173a) {
            return this.f3174b;
        }
        return null;
    }

    public final String toString() {
        return "Factory[type=" + this.f3173a.getName() + ",adapter=" + this.f3174b + "]";
    }
}
