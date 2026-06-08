package androidx.transition;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.util.Property;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class ObjectAnimatorUtils {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @RequiresApi(21)
    public static class Api21Impl {
        private Api21Impl() {
        }

        @DoNotInline
        public static <T, V> ObjectAnimator ofObject(T t9, Property<T, V> property, Path path) {
            return ObjectAnimator.ofObject(t9, property, (TypeConverter) null, path);
        }
    }

    private ObjectAnimatorUtils() {
    }

    public static <T> ObjectAnimator ofPointF(T t9, Property<T, PointF> property, Path path) {
        return Api21Impl.ofObject(t9, property, path);
    }
}
