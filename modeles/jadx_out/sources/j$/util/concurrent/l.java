package j$.util.concurrent;

import java.util.Map;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public class l implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final int f6000a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f6001b;

    /* renamed from: c, reason: collision with root package name */
    public volatile Object f6002c;

    /* renamed from: d, reason: collision with root package name */
    public volatile l f6003d;

    public l(int i, Object obj, Object obj2) {
        this.f6000a = i;
        this.f6001b = obj;
        this.f6002c = obj2;
    }

    public l(int i, Object obj, Object obj2, l lVar) {
        this(i, obj, obj2);
        this.f6003d = lVar;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f6001b;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f6002c;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f6001b.hashCode() ^ this.f6002c.hashCode();
    }

    public final String toString() {
        return j$.com.android.tools.r8.a.D(this.f6001b, this.f6002c);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        Map.Entry entry;
        Object key;
        Object value;
        if (!(obj instanceof Map.Entry) || (key = (entry = (Map.Entry) obj).getKey()) == null || (value = entry.getValue()) == null) {
            return false;
        }
        Object obj2 = this.f6001b;
        if (key != obj2 && !key.equals(obj2)) {
            return false;
        }
        Object obj3 = this.f6002c;
        return value == obj3 || value.equals(obj3);
    }

    public l a(int i, Object obj) {
        Object obj2;
        l lVar = this;
        do {
            if (lVar.f6000a == i && ((obj2 = lVar.f6001b) == obj || (obj2 != null && obj.equals(obj2)))) {
                return lVar;
            }
            lVar = lVar.f6003d;
        } while (lVar != null);
        return null;
    }
}
