package com.google.gson;

import com.google.gson.internal.bind.SerializationDelegatingTypeAdapter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
class Gson$FutureTypeAdapter<T> extends SerializationDelegatingTypeAdapter<T> {

    /* renamed from: a, reason: collision with root package name */
    public i f3101a = null;

    @Override // com.google.gson.i
    public final Object b(k3.a aVar) {
        i iVar = this.f3101a;
        if (iVar != null) {
            return iVar.b(aVar);
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        return null;
    }

    @Override // com.google.gson.i
    public final void c(k3.b bVar, Object obj) {
        i iVar = this.f3101a;
        if (iVar != null) {
            iVar.c(bVar, obj);
        } else {
            androidx.privacysandbox.ads.adservices.customaudience.a.i("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        }
    }

    @Override // com.google.gson.internal.bind.SerializationDelegatingTypeAdapter
    public final i d() {
        i iVar = this.f3101a;
        if (iVar != null) {
            return iVar;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("Adapter for type with cyclic dependency has been used before dependency has been resolved");
        return null;
    }
}
