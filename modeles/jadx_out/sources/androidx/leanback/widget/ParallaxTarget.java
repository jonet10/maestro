package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import android.view.animation.LinearInterpolator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class ParallaxTarget {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class DirectPropertyTarget<T, V extends Number> extends ParallaxTarget {
        Object mObject;
        Property<T, V> mProperty;

        public DirectPropertyTarget(Object obj, Property<T, V> property) {
            this.mObject = obj;
            this.mProperty = property;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.leanback.widget.ParallaxTarget
        public void directUpdate(Number number) {
            this.mProperty.set(this.mObject, number);
        }

        @Override // androidx.leanback.widget.ParallaxTarget
        public boolean isDirectMapping() {
            return true;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class PropertyValuesHolderTarget extends ParallaxTarget {
        private static final long PSEUDO_DURATION = 1000000;
        private final ObjectAnimator mAnimator;

        public PropertyValuesHolderTarget(Object obj, PropertyValuesHolder propertyValuesHolder) {
            ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(obj, propertyValuesHolder);
            this.mAnimator = ofPropertyValuesHolder;
            ofPropertyValuesHolder.setInterpolator(new LinearInterpolator());
            ofPropertyValuesHolder.setDuration(PSEUDO_DURATION);
        }

        @Override // androidx.leanback.widget.ParallaxTarget
        public void update(float f) {
            this.mAnimator.setCurrentPlayTime((long) (f * 1000000.0f));
        }
    }

    public boolean isDirectMapping() {
        return false;
    }

    public void directUpdate(Number number) {
    }

    public void update(float f) {
    }
}
