package androidx.core.graphics;

import android.annotation.SuppressLint;
import android.graphics.Typeface;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.LongSparseArray;
import com.google.gson.internal.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RequiresApi(21)
@SuppressLint({"SoonBlockedPrivateApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class WeightTypefaceApi21 {
    private static final String NATIVE_CREATE_FROM_TYPEFACE_METHOD = "nativeCreateFromTypeface";
    private static final String NATIVE_CREATE_WEIGHT_ALIAS_METHOD = "nativeCreateWeightAlias";
    private static final String NATIVE_INSTANCE_FIELD = "native_instance";
    private static final String TAG = "WeightTypeface";
    private static final Constructor<Typeface> sConstructor;
    private static final Method sNativeCreateFromTypeface;
    private static final Method sNativeCreateWeightAlias;
    private static final Field sNativeInstance;
    private static final Object sWeightCacheLock;

    @GuardedBy("sWeightCacheLock")
    private static final LongSparseArray<SparseArray<Typeface>> sWeightTypefaceCache;

    static {
        Field field;
        Constructor<Typeface> constructor;
        Method method;
        Method method2;
        try {
            field = Typeface.class.getDeclaredField(NATIVE_INSTANCE_FIELD);
            Class cls = Long.TYPE;
            Class cls2 = Integer.TYPE;
            try {
                method = Typeface.class.getDeclaredMethod(NATIVE_CREATE_FROM_TYPEFACE_METHOD, cls, cls2);
                method.setAccessible(true);
                method2 = Typeface.class.getDeclaredMethod(NATIVE_CREATE_WEIGHT_ALIAS_METHOD, cls, cls2);
                method2.setAccessible(true);
                constructor = Typeface.class.getDeclaredConstructor(cls);
                constructor.setAccessible(true);
            } catch (NoSuchMethodException e10) {
                e = e10;
                Log.e(TAG, e.getClass().getName(), e);
                field = null;
                constructor = null;
                method = null;
                method2 = null;
                sNativeInstance = field;
                sNativeCreateFromTypeface = method;
                sNativeCreateWeightAlias = method2;
                sConstructor = constructor;
                sWeightTypefaceCache = new LongSparseArray<>(3);
                sWeightCacheLock = new Object();
            }
        } catch (NoSuchFieldException | NoSuchMethodException e11) {
            e = e11;
        }
        sNativeInstance = field;
        sNativeCreateFromTypeface = method;
        sNativeCreateWeightAlias = method2;
        sConstructor = constructor;
        sWeightTypefaceCache = new LongSparseArray<>(3);
        sWeightCacheLock = new Object();
    }

    private WeightTypefaceApi21() {
    }

    @Nullable
    private static Typeface create(long j) {
        try {
            return sConstructor.newInstance(Long.valueOf(j));
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException unused) {
            return null;
        }
    }

    @Nullable
    public static Typeface createWeightStyle(@NonNull Typeface typeface, int i, boolean z9) {
        if (!isPrivateApiAvailable()) {
            return null;
        }
        int i6 = (i << 1) | (z9 ? 1 : 0);
        synchronized (sWeightCacheLock) {
            try {
                long nativeInstance = getNativeInstance(typeface);
                LongSparseArray<SparseArray<Typeface>> longSparseArray = sWeightTypefaceCache;
                SparseArray<Typeface> sparseArray = longSparseArray.get(nativeInstance);
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>(4);
                    longSparseArray.put(nativeInstance, sparseArray);
                } else {
                    Typeface typeface2 = sparseArray.get(i6);
                    if (typeface2 != null) {
                        return typeface2;
                    }
                }
                Typeface create = z9 == typeface.isItalic() ? create(nativeCreateWeightAlias(nativeInstance, i)) : create(nativeCreateFromTypefaceWithExactStyle(nativeInstance, i, z9));
                sparseArray.put(i6, create);
                return create;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private static long getNativeInstance(@NonNull Typeface typeface) {
        try {
            return sNativeInstance.getLong(typeface);
        } catch (IllegalAccessException e10) {
            a.k(e10);
            return 0L;
        }
    }

    private static boolean isPrivateApiAvailable() {
        return sNativeInstance != null;
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static long nativeCreateFromTypefaceWithExactStyle(long j, int i, boolean z9) {
        try {
            Long l10 = (Long) sNativeCreateFromTypeface.invoke(null, Long.valueOf(j), Integer.valueOf(z9 ? 2 : 0));
            l10.longValue();
            return ((Long) sNativeCreateWeightAlias.invoke(null, l10, Integer.valueOf(i))).longValue();
        } catch (IllegalAccessException e10) {
            a.k(e10);
            return 0L;
        } catch (InvocationTargetException e11) {
            a.k(e11);
            return 0L;
        }
    }

    @SuppressLint({"BanUncheckedReflection"})
    private static long nativeCreateWeightAlias(long j, int i) {
        try {
            return ((Long) sNativeCreateWeightAlias.invoke(null, Long.valueOf(j), Integer.valueOf(i))).longValue();
        } catch (IllegalAccessException e10) {
            a.k(e10);
            return 0L;
        } catch (InvocationTargetException e11) {
            a.k(e11);
            return 0L;
        }
    }
}
