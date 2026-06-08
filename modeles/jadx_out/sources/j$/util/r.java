package j$.util;

import java.util.Map;

/* loaded from: C:\Users\herod\Downloads\Jeux\classes2.dex */
public final class r implements Map.Entry {

    /* renamed from: a, reason: collision with root package name */
    public final Map.Entry f6109a;

    public r(Map.Entry entry) {
        this.f6109a = (Map.Entry) Objects.requireNonNull(entry);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f6109a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f6109a.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.f6109a.hashCode();
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        boolean equals;
        boolean equals2;
        if (this != obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = this.f6109a.getKey();
                Object key2 = entry.getKey();
                if (key == null) {
                    equals = key2 == null;
                } else {
                    equals = key.equals(key2);
                }
                if (equals) {
                    Object value = this.f6109a.getValue();
                    Object value2 = entry.getValue();
                    if (value == null) {
                        equals2 = value2 == null;
                    } else {
                        equals2 = value.equals(value2);
                    }
                    if (equals2) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final String toString() {
        return this.f6109a.toString();
    }
}
