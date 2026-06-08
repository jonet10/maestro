package com.google.gson;

import j$.util.Objects;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends d {

    /* renamed from: a, reason: collision with root package name */
    public final Serializable f3119a;

    public h(Boolean bool) {
        Objects.requireNonNull(bool);
        this.f3119a = bool;
    }

    public static boolean e(h hVar) {
        Serializable serializable = hVar.f3119a;
        if (!(serializable instanceof Number)) {
            return false;
        }
        Number number = (Number) serializable;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    public final BigInteger b() {
        Serializable serializable = this.f3119a;
        if (serializable instanceof BigInteger) {
            return (BigInteger) serializable;
        }
        if (e(this)) {
            return BigInteger.valueOf(c().longValue());
        }
        String d10 = d();
        com.google.gson.internal.f.c(d10);
        return new BigInteger(d10);
    }

    public final Number c() {
        Serializable serializable = this.f3119a;
        if (serializable instanceof Number) {
            return (Number) serializable;
        }
        if (serializable instanceof String) {
            return new com.google.gson.internal.h((String) serializable);
        }
        a3.b.r("Primitive is neither a number nor a string");
        return null;
    }

    public final String d() {
        Serializable serializable = this.f3119a;
        if (serializable instanceof String) {
            return (String) serializable;
        }
        if (serializable instanceof Number) {
            return c().toString();
        }
        if (serializable instanceof Boolean) {
            return ((Boolean) serializable).toString();
        }
        throw new AssertionError("Unexpected value type: " + serializable.getClass());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || h.class != obj.getClass()) {
            return false;
        }
        h hVar = (h) obj;
        Serializable serializable = hVar.f3119a;
        Serializable serializable2 = this.f3119a;
        if (serializable2 == null) {
            return serializable == null;
        }
        if (e(this) && e(hVar)) {
            return ((serializable2 instanceof BigInteger) || (serializable instanceof BigInteger)) ? b().equals(hVar.b()) : c().longValue() == hVar.c().longValue();
        }
        if (!(serializable2 instanceof Number) || !(serializable instanceof Number)) {
            return serializable2.equals(serializable);
        }
        if ((serializable2 instanceof BigDecimal) && (serializable instanceof BigDecimal)) {
            return (serializable2 instanceof BigDecimal ? (BigDecimal) serializable2 : com.google.gson.internal.f.i(d())).compareTo(serializable instanceof BigDecimal ? (BigDecimal) serializable : com.google.gson.internal.f.i(hVar.d())) == 0;
        }
        double doubleValue = serializable2 instanceof Number ? c().doubleValue() : Double.parseDouble(d());
        double doubleValue2 = serializable instanceof Number ? hVar.c().doubleValue() : Double.parseDouble(hVar.d());
        if (doubleValue != doubleValue2) {
            return Double.isNaN(doubleValue) && Double.isNaN(doubleValue2);
        }
        return true;
    }

    public final int hashCode() {
        long doubleToLongBits;
        Serializable serializable = this.f3119a;
        if (serializable == null) {
            return 31;
        }
        if (e(this)) {
            doubleToLongBits = c().longValue();
        } else {
            if (!(serializable instanceof Number)) {
                return serializable.hashCode();
            }
            doubleToLongBits = Double.doubleToLongBits(c().doubleValue());
        }
        return (int) (doubleToLongBits ^ (doubleToLongBits >>> 32));
    }

    public h(Number number) {
        Objects.requireNonNull(number);
        this.f3119a = number;
    }

    public h(String str) {
        Objects.requireNonNull(str);
        this.f3119a = str;
    }
}
