package androidx.collection;

import e7.c;
import java.util.Map;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class MutableMapEntry<K, V> implements Map.Entry<K, V>, c {
    private final int index;
    private final Object[] keys;
    private final Object[] values;

    public MutableMapEntry(Object[] objArr, Object[] objArr2, int i) {
        objArr.getClass();
        objArr2.getClass();
        this.keys = objArr;
        this.values = objArr2;
        this.index = i;
    }

    public final int getIndex() {
        return this.index;
    }

    @Override // java.util.Map.Entry
    public K getKey() {
        return (K) this.keys[this.index];
    }

    public final Object[] getKeys() {
        return this.keys;
    }

    @Override // java.util.Map.Entry
    public V getValue() {
        return (V) this.values[this.index];
    }

    public final Object[] getValues() {
        return this.values;
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        Object[] objArr = this.values;
        int i = this.index;
        V v9 = (V) objArr[i];
        objArr[i] = v;
        return v9;
    }

    public static /* synthetic */ void getKey$annotations() {
    }

    public static /* synthetic */ void getValue$annotations() {
    }
}
