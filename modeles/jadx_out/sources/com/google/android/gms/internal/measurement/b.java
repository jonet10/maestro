package com.google.android.gms.internal.measurement;

import java.util.HashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final l1.g f2507d = l1.g.k(3, "_syn", "_err", "_el");

    /* renamed from: a, reason: collision with root package name */
    public String f2508a;

    /* renamed from: b, reason: collision with root package name */
    public final long f2509b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap f2510c;

    public b(String str, long j, HashMap hashMap) {
        this.f2508a = str;
        this.f2509b = j;
        HashMap hashMap2 = new HashMap();
        this.f2510c = hashMap2;
        if (hashMap != null) {
            hashMap2.putAll(hashMap);
        }
    }

    public static Object b(Object obj, String str, Object obj2) {
        if (f2507d.contains(str) && (obj2 instanceof Double)) {
            return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
        }
        if (str.startsWith("_")) {
            if (obj instanceof String) {
                return obj2;
            }
            if (obj != null) {
                return obj;
            }
        } else if (!(obj instanceof Double)) {
            if (obj instanceof Long) {
                return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
            }
            if (obj instanceof String) {
                return obj2.toString();
            }
        }
        return obj2;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final b clone() {
        return new b(this.f2508a, this.f2509b, new HashMap(this.f2510c));
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.f2509b == bVar.f2509b && this.f2508a.equals(bVar.f2508a)) {
            return this.f2510c.equals(bVar.f2510c);
        }
        return false;
    }

    public final int hashCode() {
        int hashCode = this.f2508a.hashCode() * 31;
        long j = this.f2509b;
        return this.f2510c.hashCode() + ((hashCode + ((int) (j ^ (j >>> 32)))) * 31);
    }

    public final String toString() {
        String str = this.f2508a;
        String obj = this.f2510c.toString();
        int length = String.valueOf(str).length();
        long j = this.f2509b;
        StringBuilder sb = new StringBuilder(length + 25 + String.valueOf(j).length() + 9 + obj.length() + 1);
        sb.append("Event{name='");
        sb.append(str);
        sb.append("', timestamp=");
        sb.append(j);
        sb.append(", params=");
        sb.append(obj);
        sb.append("}");
        return sb.toString();
    }
}
