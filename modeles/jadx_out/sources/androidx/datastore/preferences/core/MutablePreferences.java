package androidx.datastore.preferences.core;

import androidx.datastore.preferences.core.Preferences;
import androidx.privacysandbox.ads.adservices.customaudience.a;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.g;
import p6.i;
import q6.a0;
import q6.l;
import q6.n;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class MutablePreferences extends Preferences {
    private final AtomicBoolean frozen;
    private final Map<Preferences.Key<?>, Object> preferencesMap;

    public /* synthetic */ MutablePreferences(Map map, boolean z9, int i, g gVar) {
        this((i & 1) != 0 ? new LinkedHashMap() : map, (i & 2) != 0 ? true : z9);
    }

    @Override // androidx.datastore.preferences.core.Preferences
    public Map<Preferences.Key<?>, Object> asMap() {
        i iVar;
        Set<Map.Entry<Preferences.Key<?>, Object>> entrySet = this.preferencesMap.entrySet();
        int h02 = a0.h0(n.i0(entrySet, 10));
        if (h02 < 16) {
            h02 = 16;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(h02);
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object value = entry.getValue();
            if (value instanceof byte[]) {
                byte[] bArr = (byte[]) value;
                iVar = new i(entry.getKey(), Arrays.copyOf(bArr, bArr.length));
            } else {
                iVar = new i(entry.getKey(), entry.getValue());
            }
            linkedHashMap.put(iVar.f8441a, iVar.f8442b);
        }
        return Actual_jvmAndroidKt.immutableMap(linkedHashMap);
    }

    public final void checkNotFrozen$datastore_preferences_core_release() {
        if (this.frozen.get()) {
            a.i("Do mutate preferences once returned to DataStore.");
        }
    }

    public final void clear() {
        checkNotFrozen$datastore_preferences_core_release();
        this.preferencesMap.clear();
    }

    @Override // androidx.datastore.preferences.core.Preferences
    public <T> boolean contains(Preferences.Key<T> key) {
        key.getClass();
        return this.preferencesMap.containsKey(key);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0066 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[LOOP:0: B:15:0x002e->B:30:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean equals(java.lang.Object r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof androidx.datastore.preferences.core.MutablePreferences
            r1 = 0
            if (r0 != 0) goto L6
            return r1
        L6:
            androidx.datastore.preferences.core.MutablePreferences r6 = (androidx.datastore.preferences.core.MutablePreferences) r6
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r0 = r6.preferencesMap
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            r3 = 1
            if (r0 != r2) goto L10
            return r3
        L10:
            int r0 = r0.size()
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            int r2 = r2.size()
            if (r0 == r2) goto L1d
            return r1
        L1d:
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r6 = r6.preferencesMap
            boolean r0 = r6.isEmpty()
            if (r0 == 0) goto L26
            return r3
        L26:
            java.util.Set r6 = r6.entrySet()
            java.util.Iterator r6 = r6.iterator()
        L2e:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L67
            java.lang.Object r0 = r6.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.util.Map<androidx.datastore.preferences.core.Preferences$Key<?>, java.lang.Object> r2 = r5.preferencesMap
            java.lang.Object r4 = r0.getKey()
            java.lang.Object r2 = r2.get(r4)
            if (r2 == 0) goto L63
            java.lang.Object r0 = r0.getValue()
            boolean r4 = r0 instanceof byte[]
            if (r4 == 0) goto L5e
            boolean r4 = r2 instanceof byte[]
            if (r4 == 0) goto L63
            byte[] r0 = (byte[]) r0
            byte[] r2 = (byte[]) r2
            boolean r0 = java.util.Arrays.equals(r0, r2)
            if (r0 == 0) goto L63
            r0 = r3
            goto L64
        L5e:
            boolean r0 = kotlin.jvm.internal.l.a(r0, r2)
            goto L64
        L63:
            r0 = r1
        L64:
            if (r0 != 0) goto L2e
            return r1
        L67:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.datastore.preferences.core.MutablePreferences.equals(java.lang.Object):boolean");
    }

    public final void freeze$datastore_preferences_core_release() {
        this.frozen.set(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.datastore.preferences.core.Preferences
    public <T> T get(Preferences.Key<T> key) {
        key.getClass();
        T t9 = (T) this.preferencesMap.get(key);
        if (!(t9 instanceof byte[])) {
            return t9;
        }
        byte[] bArr = (byte[]) t9;
        return (T) Arrays.copyOf(bArr, bArr.length);
    }

    public final Map<Preferences.Key<?>, Object> getPreferencesMap$datastore_preferences_core_release() {
        return this.preferencesMap;
    }

    public int hashCode() {
        Iterator<T> it = this.preferencesMap.entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Object value = ((Map.Entry) it.next()).getValue();
            i += value instanceof byte[] ? Arrays.hashCode((byte[]) value) : value.hashCode();
        }
        return i;
    }

    public final void minusAssign(Preferences.Key<?> key) {
        key.getClass();
        checkNotFrozen$datastore_preferences_core_release();
        remove(key);
    }

    public final void plusAssign(Preferences preferences) {
        preferences.getClass();
        checkNotFrozen$datastore_preferences_core_release();
        this.preferencesMap.putAll(preferences.asMap());
    }

    public final void putAll(Preferences.Pair<?>... pairArr) {
        pairArr.getClass();
        checkNotFrozen$datastore_preferences_core_release();
        for (Preferences.Pair<?> pair : pairArr) {
            setUnchecked$datastore_preferences_core_release(pair.getKey$datastore_preferences_core_release(), pair.getValue$datastore_preferences_core_release());
        }
    }

    public final <T> T remove(Preferences.Key<T> key) {
        key.getClass();
        checkNotFrozen$datastore_preferences_core_release();
        return (T) this.preferencesMap.remove(key);
    }

    public final <T> void set(Preferences.Key<T> key, T t9) {
        key.getClass();
        setUnchecked$datastore_preferences_core_release(key, t9);
    }

    public final void setUnchecked$datastore_preferences_core_release(Preferences.Key<?> key, Object obj) {
        key.getClass();
        checkNotFrozen$datastore_preferences_core_release();
        if (obj == null) {
            remove(key);
            return;
        }
        if (obj instanceof Set) {
            this.preferencesMap.put(key, Actual_jvmAndroidKt.immutableCopyOfSet((Set) obj));
            return;
        }
        boolean z9 = obj instanceof byte[];
        Map<Preferences.Key<?>, Object> map = this.preferencesMap;
        if (!z9) {
            map.put(key, obj);
        } else {
            byte[] bArr = (byte[]) obj;
            map.put(key, Arrays.copyOf(bArr, bArr.length));
        }
    }

    public String toString() {
        return l.x0(this.preferencesMap.entrySet(), ",\n", "{\n", "\n}", MutablePreferences$toString$1.INSTANCE, 24);
    }

    public final void plusAssign(Preferences.Pair<?> pair) {
        pair.getClass();
        checkNotFrozen$datastore_preferences_core_release();
        putAll(pair);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MutablePreferences() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    public MutablePreferences(Map<Preferences.Key<?>, Object> map, boolean z9) {
        map.getClass();
        this.preferencesMap = map;
        this.frozen = new AtomicBoolean(z9);
    }
}
