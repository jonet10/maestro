package androidx.core.util;

import android.util.LruCache;
import d7.l;
import d7.p;
import d7.r;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LruCacheKt$lruCache$4<K, V> extends LruCache<K, V> {
    final /* synthetic */ l $create;
    final /* synthetic */ r $onEntryRemoved;
    final /* synthetic */ p $sizeOf;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LruCacheKt$lruCache$4(int i, p pVar, l lVar, r rVar) {
        super(i);
        this.$sizeOf = pVar;
        this.$create = lVar;
        this.$onEntryRemoved = rVar;
    }

    @Override // android.util.LruCache
    public V create(K k5) {
        return (V) this.$create.invoke(k5);
    }

    @Override // android.util.LruCache
    public void entryRemoved(boolean z9, K k5, V v, V v9) {
        this.$onEntryRemoved.invoke(Boolean.valueOf(z9), k5, v, v9);
    }

    @Override // android.util.LruCache
    public int sizeOf(K k5, V v) {
        return ((Number) this.$sizeOf.invoke(k5, v)).intValue();
    }
}
