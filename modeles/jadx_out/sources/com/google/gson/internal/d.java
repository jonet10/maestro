package com.google.gson.internal;

import j$.util.Objects;
import java.io.Serializable;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d implements ParameterizedType, Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final Type f3213a;

    /* renamed from: b, reason: collision with root package name */
    public final Type f3214b;

    /* renamed from: l, reason: collision with root package name */
    public final Type[] f3215l;

    public d(Type type, Class cls, Type... typeArr) {
        Objects.requireNonNull(cls);
        if (type == null && !Modifier.isStatic(cls.getModifiers()) && cls.getDeclaringClass() != null) {
            c2.a.h(cls, "Must specify owner type for ");
            throw null;
        }
        this.f3213a = type == null ? null : f.a(type);
        this.f3214b = f.a(cls);
        Type[] typeArr2 = (Type[]) typeArr.clone();
        this.f3215l = typeArr2;
        int length = typeArr2.length;
        for (int i = 0; i < length; i++) {
            Objects.requireNonNull(this.f3215l[i]);
            f.b(this.f3215l[i]);
            Type[] typeArr3 = this.f3215l;
            typeArr3[i] = f.a(typeArr3[i]);
        }
    }

    public final boolean equals(Object obj) {
        return (obj instanceof ParameterizedType) && f.d(this, (ParameterizedType) obj);
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type[] getActualTypeArguments() {
        return (Type[]) this.f3215l.clone();
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getOwnerType() {
        return this.f3213a;
    }

    @Override // java.lang.reflect.ParameterizedType
    public final Type getRawType() {
        return this.f3214b;
    }

    public final int hashCode() {
        int hashCode = Arrays.hashCode(this.f3215l) ^ this.f3214b.hashCode();
        Type type = this.f3213a;
        return hashCode ^ (type != null ? type.hashCode() : 0);
    }

    public final String toString() {
        Type[] typeArr = this.f3215l;
        int length = typeArr.length;
        Type type = this.f3214b;
        if (length == 0) {
            return f.k(type);
        }
        StringBuilder sb = new StringBuilder((length + 1) * 30);
        sb.append(f.k(type));
        sb.append("<");
        sb.append(f.k(typeArr[0]));
        for (int i = 1; i < length; i++) {
            sb.append(", ");
            sb.append(f.k(typeArr[i]));
        }
        sb.append(">");
        return sb.toString();
    }
}
