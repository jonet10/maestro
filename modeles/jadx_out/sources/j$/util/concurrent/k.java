package j$.util.concurrent;

import java.util.Map;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class k implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final Object f5997a;

    /* renamed from: b, reason: collision with root package name */
    public Object f5998b;

    /* renamed from: c, reason: collision with root package name */
    public final ConcurrentHashMap f5999c;

    public k(Object obj, Object obj2, ConcurrentHashMap concurrentHashMap) {
        this.f5997a = obj;
        this.f5998b = obj2;
        this.f5999c = concurrentHashMap;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f5997a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f5998b;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f5997a.hashCode() ^ this.f5998b.hashCode();
    }

    public final String toString() {
        return j$.com.android.tools.r8.a.D(this.f5997a, this.f5998b);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        Map.Entry entry;
        Object key;
        Object value;
        if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (value = entry.getValue()) == null) {
            return false;
        }
        Object obj2 = this.f5997a;
        if (key != obj2 && !key.equals(obj2)) {
            return false;
        }
        Object obj3 = this.f5998b;
        return value == obj3 || value.equals(obj3);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        obj.getClass();
        Object obj2 = this.f5998b;
        this.f5998b = obj;
        this.f5999c.put(this.f5997a, obj);
        return obj2;
    }
}
