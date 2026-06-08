package com.google.gson.internal;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class h extends Number {

    /* renamed from: a, reason: collision with root package name */
    public final String f3220a;

    public h(String str) {
        this.f3220a = str;
    }

    @Override // java.lang.Number
    public final double doubleValue() {
        return Double.parseDouble(this.f3220a);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof h) {
            return this.f3220a.equals(((h) obj).f3220a);
        }
        return false;
    }

    @Override // java.lang.Number
    public final float floatValue() {
        return Float.parseFloat(this.f3220a);
    }

    public final int hashCode() {
        return this.f3220a.hashCode();
    }

    @Override // java.lang.Number
    public final int intValue() {
        String str = this.f3220a;
        try {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                return (int) Long.parseLong(str);
            }
        } catch (NumberFormatException unused2) {
            return f.i(str).intValue();
        }
    }

    @Override // java.lang.Number
    public final long longValue() {
        String str = this.f3220a;
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return f.i(str).longValue();
        }
    }

    public final String toString() {
        return this.f3220a;
    }
}
