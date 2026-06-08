package com.google.gson.internal;

import j$.util.Objects;
import java.io.Serializable;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class c implements GenericArrayType, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Type f3212a;

    public c(Type type) {
        Objects.requireNonNull(type);
        this.f3212a = f.a(type);
    }

    public final boolean equals(Object obj) {
        return (obj instanceof GenericArrayType) && f.d(this, (GenericArrayType) obj);
    }

    @Override // java.lang.reflect.GenericArrayType
    public final Type getGenericComponentType() {
        return this.f3212a;
    }

    public final int hashCode() {
        return this.f3212a.hashCode();
    }

    public final String toString() {
        return f.k(this.f3212a) + "[]";
    }
}
