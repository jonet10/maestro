package androidx.core.util;

import android.util.LruCache;
import d7.l;
import d7.p;
import d7.r;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class LruCacheKt {
    public static final <K, V> LruCache<K, V> lruCache(int i, p pVar, l lVar, r rVar) {
        return new LruCacheKt$lruCache$4(i, pVar, lVar, rVar);
    }

    public static /* synthetic */ LruCache lruCache$default(int i, p pVar, l lVar, r rVar, int i6, Object obj) {
        if ((i6 & 2) != 0) {
            pVar = LruCacheKt$lruCache$1.INSTANCE;
        }
        if ((i6 & 4) != 0) {
            lVar = LruCacheKt$lruCache$2.INSTANCE;
        }
        if ((i6 & 8) != 0) {
            rVar = LruCacheKt$lruCache$3.INSTANCE;
        }
        return new LruCacheKt$lruCache$4(i, pVar, lVar, rVar);
    }
}
