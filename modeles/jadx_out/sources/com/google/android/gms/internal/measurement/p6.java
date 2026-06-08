package com.google.android.gms.internal.measurement;

import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class p6 implements Map.Entry, Comparable {

    /* renamed from: a, reason: collision with root package name */
    public final Comparable f2746a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2747b;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ o6 f2748l;

    public p6(o6 o6Var, Comparable comparable, Object obj) {
        this.f2748l = o6Var;
        this.f2746a = comparable;
        this.f2747b = obj;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.f2746a.compareTo(((p6) obj).f2746a);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Comparable comparable = this.f2746a;
                if (comparable == null ? key == null : comparable.equals(key)) {
                    Object obj2 = this.f2747b;
                    Object value = entry.getValue();
                    if (obj2 == null ? value == null : obj2.equals(value)) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.f2746a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f2747b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.f2746a;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f2747b;
        return (obj != null ? obj.hashCode() : 0) ^ hashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.f2748l.g();
        Object obj2 = this.f2747b;
        this.f2747b = obj;
        return obj2;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.f2746a);
        String valueOf2 = String.valueOf(this.f2747b);
        return a4.x.o(new StringBuilder(valueOf.length() + 1 + valueOf2.length()), valueOf, "=", valueOf2);
    }
}
