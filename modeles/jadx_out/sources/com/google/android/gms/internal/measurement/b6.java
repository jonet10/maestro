package com.google.android.gms.internal.measurement;

import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class b6 extends LinkedHashMap {

    /* renamed from: b, reason: collision with root package name */
    public static final b6 f2516b;

    /* renamed from: a, reason: collision with root package name */
    public boolean f2517a = true;

    static {
        b6 b6Var = new b6();
        f2516b = b6Var;
        b6Var.f2517a = false;
    }

    public static int c(Object obj) {
        if (!(obj instanceof byte[])) {
            if (!(obj instanceof n5)) {
                return obj.hashCode();
            }
            com.google.gson.internal.a.q();
            return 0;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        Charset charset = r5.f2778a;
        int i = length;
        for (byte b7 : bArr) {
            i = (i * 31) + b7;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public final b6 a() {
        if (isEmpty()) {
            return new b6();
        }
        b6 b6Var = new b6(this);
        b6Var.f2517a = true;
        return b6Var;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        d();
        super.clear();
    }

    public final void d() {
        if (this.f2517a) {
            return;
        }
        com.google.gson.internal.a.q();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        return isEmpty() ? Collections.EMPTY_SET : super.entrySet();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i = 0;
        for (Map.Entry entry : entrySet()) {
            i += c(entry.getValue()) ^ c(entry.getKey());
        }
        return i;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        d();
        Charset charset = r5.f2778a;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        d();
        for (Object obj : map.keySet()) {
            Charset charset = r5.f2778a;
            obj.getClass();
            map.get(obj).getClass();
        }
        super.putAll(map);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        d();
        return super.remove(obj);
    }
}
