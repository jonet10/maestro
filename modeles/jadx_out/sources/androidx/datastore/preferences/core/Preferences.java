package androidx.datastore.preferences.core;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.l;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class Preferences {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Key<T> {
        private final String name;

        public Key(String str) {
            str.getClass();
            this.name = str;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Key) {
                return l.a(this.name, ((Key) obj).name);
            }
            return false;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public final Pair<T> to(T t9) {
            return new Pair<>(this, t9);
        }

        public String toString() {
            return this.name;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Pair<T> {
        private final Key<T> key;
        private final T value;

        public Pair(Key<T> key, T t9) {
            key.getClass();
            this.key = key;
            this.value = t9;
        }

        public final Key<T> getKey$datastore_preferences_core_release() {
            return this.key;
        }

        public final T getValue$datastore_preferences_core_release() {
            return this.value;
        }
    }

    public abstract Map<Key<?>, Object> asMap();

    public abstract <T> boolean contains(Key<T> key);

    public abstract <T> T get(Key<T> key);

    public final MutablePreferences toMutablePreferences() {
        Map<Key<?>, Object> asMap = asMap();
        asMap.getClass();
        return new MutablePreferences(new LinkedHashMap(asMap), false);
    }

    public final Preferences toPreferences() {
        Map<Key<?>, Object> asMap = asMap();
        asMap.getClass();
        return new MutablePreferences(new LinkedHashMap(asMap), true);
    }
}
