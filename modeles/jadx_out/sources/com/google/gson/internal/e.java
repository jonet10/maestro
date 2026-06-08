package com.google.gson.internal;

import j$.util.Objects;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.lang.reflect.WildcardType;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class e implements WildcardType, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Type f3216a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f3217b;

    public e(Type[] typeArr, Type[] typeArr2) {
        if (typeArr2.length > 1) {
            a.p("At most one lower bound is supported");
            throw null;
        }
        if (typeArr.length != 1) {
            a.p("Exactly one upper bound must be specified");
            throw null;
        }
        if (typeArr2.length != 1) {
            Objects.requireNonNull(typeArr[0]);
            f.b(typeArr[0]);
            this.f3217b = null;
            this.f3216a = f.a(typeArr[0]);
            return;
        }
        Objects.requireNonNull(typeArr2[0]);
        f.b(typeArr2[0]);
        if (typeArr[0] != Object.class) {
            a.p("When lower bound is specified, upper bound must be Object");
            throw null;
        }
        this.f3217b = f.a(typeArr2[0]);
        this.f3216a = Object.class;
    }

    public final boolean equals(Object obj) {
        return (obj instanceof WildcardType) && f.d(this, (WildcardType) obj);
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getLowerBounds() {
        Type type = this.f3217b;
        return type != null ? new Type[]{type} : f.f3218a;
    }

    @Override // java.lang.reflect.WildcardType
    public final Type[] getUpperBounds() {
        return new Type[]{this.f3216a};
    }

    public final int hashCode() {
        Type type = this.f3217b;
        return (type != null ? type.hashCode() + 31 : 1) ^ (this.f3216a.hashCode() + 31);
    }

    public final String toString() {
        Type type = this.f3217b;
        if (type != null) {
            return "? super " + f.k(type);
        }
        Type type2 = this.f3216a;
        if (type2 == Object.class) {
            return "?";
        }
        return "? extends " + f.k(type2);
    }
}
