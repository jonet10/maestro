package androidx.leanback.widget;

import a3.b;
import android.animation.PropertyValuesHolder;
import android.util.Property;
import androidx.annotation.RestrictTo;
import androidx.leanback.widget.Parallax;
import androidx.leanback.widget.ParallaxTarget;
import java.util.ArrayList;
import java.util.List;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class ParallaxEffect {
    final List<Parallax.PropertyMarkerValue> mMarkerValues = new ArrayList(2);
    final List<Float> mWeights = new ArrayList(2);
    final List<Float> mTotalWeights = new ArrayList(2);
    final List<ParallaxTarget> mTargets = new ArrayList(4);

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class FloatEffect extends ParallaxEffect {
        @Override // androidx.leanback.widget.ParallaxEffect
        public Number calculateDirectValue(Parallax parallax) {
            if (this.mMarkerValues.size() != 2) {
                b.n("Must use two marker values for direct mapping");
                return null;
            }
            if (this.mMarkerValues.get(0).getProperty() != this.mMarkerValues.get(1).getProperty()) {
                b.n("Marker value must use same Property for direct mapping");
                return null;
            }
            float markerValue = ((Parallax.FloatPropertyMarkerValue) this.mMarkerValues.get(0)).getMarkerValue(parallax);
            float markerValue2 = ((Parallax.FloatPropertyMarkerValue) this.mMarkerValues.get(1)).getMarkerValue(parallax);
            if (markerValue > markerValue2) {
                markerValue2 = markerValue;
                markerValue = markerValue2;
            }
            Float f = ((Parallax.FloatProperty) this.mMarkerValues.get(0).getProperty()).get(parallax);
            return f.floatValue() < markerValue ? Float.valueOf(markerValue) : f.floatValue() > markerValue2 ? Float.valueOf(markerValue2) : f;
        }

        @Override // androidx.leanback.widget.ParallaxEffect
        public float calculateFraction(Parallax parallax) {
            float maxValue;
            int i = 0;
            int i6 = 0;
            float f = 0.0f;
            float f10 = 0.0f;
            while (i < this.mMarkerValues.size()) {
                Parallax.FloatPropertyMarkerValue floatPropertyMarkerValue = (Parallax.FloatPropertyMarkerValue) this.mMarkerValues.get(i);
                int index = floatPropertyMarkerValue.getProperty().getIndex();
                float markerValue = floatPropertyMarkerValue.getMarkerValue(parallax);
                float floatPropertyValue = parallax.getFloatPropertyValue(index);
                if (i == 0) {
                    if (floatPropertyValue >= markerValue) {
                        return 0.0f;
                    }
                } else {
                    if (i6 == index && f < markerValue) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("marker value of same variable must be descendant order");
                        return 0.0f;
                    }
                    if (floatPropertyValue == Float.MAX_VALUE) {
                        return getFractionWithWeightAdjusted((f - f10) / parallax.getMaxValue(), i);
                    }
                    if (floatPropertyValue >= markerValue) {
                        if (i6 == index) {
                            maxValue = (f - floatPropertyValue) / (f - markerValue);
                        } else if (f10 != -3.4028235E38f) {
                            float f11 = (floatPropertyValue - f10) + f;
                            maxValue = (f11 - floatPropertyValue) / (f11 - markerValue);
                        } else {
                            maxValue = 1.0f - ((floatPropertyValue - markerValue) / parallax.getMaxValue());
                        }
                        return getFractionWithWeightAdjusted(maxValue, i);
                    }
                }
                i++;
                f = markerValue;
                i6 = index;
                f10 = floatPropertyValue;
            }
            return 1.0f;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class IntEffect extends ParallaxEffect {
        @Override // androidx.leanback.widget.ParallaxEffect
        public Number calculateDirectValue(Parallax parallax) {
            if (this.mMarkerValues.size() != 2) {
                b.n("Must use two marker values for direct mapping");
                return null;
            }
            if (this.mMarkerValues.get(0).getProperty() != this.mMarkerValues.get(1).getProperty()) {
                b.n("Marker value must use same Property for direct mapping");
                return null;
            }
            int markerValue = ((Parallax.IntPropertyMarkerValue) this.mMarkerValues.get(0)).getMarkerValue(parallax);
            int markerValue2 = ((Parallax.IntPropertyMarkerValue) this.mMarkerValues.get(1)).getMarkerValue(parallax);
            if (markerValue > markerValue2) {
                markerValue2 = markerValue;
                markerValue = markerValue2;
            }
            Integer num = ((Parallax.IntProperty) this.mMarkerValues.get(0).getProperty()).get(parallax);
            return num.intValue() < markerValue ? Integer.valueOf(markerValue) : num.intValue() > markerValue2 ? Integer.valueOf(markerValue2) : num;
        }

        @Override // androidx.leanback.widget.ParallaxEffect
        public float calculateFraction(Parallax parallax) {
            float maxValue;
            int i = 0;
            int i6 = 0;
            int i10 = 0;
            int i11 = 0;
            while (i < this.mMarkerValues.size()) {
                Parallax.IntPropertyMarkerValue intPropertyMarkerValue = (Parallax.IntPropertyMarkerValue) this.mMarkerValues.get(i);
                int index = intPropertyMarkerValue.getProperty().getIndex();
                int markerValue = intPropertyMarkerValue.getMarkerValue(parallax);
                int intPropertyValue = parallax.getIntPropertyValue(index);
                if (i == 0) {
                    if (intPropertyValue >= markerValue) {
                        return 0.0f;
                    }
                } else {
                    if (i6 == index && i10 < markerValue) {
                        androidx.privacysandbox.ads.adservices.customaudience.a.i("marker value of same variable must be descendant order");
                        return 0.0f;
                    }
                    if (intPropertyValue == Integer.MAX_VALUE) {
                        return getFractionWithWeightAdjusted((i10 - i11) / parallax.getMaxValue(), i);
                    }
                    if (intPropertyValue >= markerValue) {
                        if (i6 == index) {
                            maxValue = (i10 - intPropertyValue) / (i10 - markerValue);
                        } else if (i11 != Integer.MIN_VALUE) {
                            int i12 = (intPropertyValue - i11) + i10;
                            maxValue = (i12 - intPropertyValue) / (i12 - markerValue);
                        } else {
                            maxValue = 1.0f - ((intPropertyValue - markerValue) / parallax.getMaxValue());
                        }
                        return getFractionWithWeightAdjusted(maxValue, i);
                    }
                }
                i++;
                i10 = markerValue;
                i6 = index;
                i11 = intPropertyValue;
            }
            return 1.0f;
        }
    }

    public final void addTarget(ParallaxTarget parallaxTarget) {
        this.mTargets.add(parallaxTarget);
    }

    public abstract Number calculateDirectValue(Parallax parallax);

    public abstract float calculateFraction(Parallax parallax);

    public final float getFractionWithWeightAdjusted(float f, int i) {
        if (this.mMarkerValues.size() >= 3) {
            if (this.mWeights.size() == this.mMarkerValues.size() - 1) {
                float floatValue = this.mTotalWeights.get(r0.size() - 1).floatValue();
                float floatValue2 = (this.mWeights.get(i - 1).floatValue() * f) / floatValue;
                return i >= 2 ? (this.mTotalWeights.get(i - 2).floatValue() / floatValue) + floatValue2 : floatValue2;
            }
            float size = this.mMarkerValues.size() - 1;
            f /= size;
            if (i >= 2) {
                return ((i - 1) / size) + f;
            }
        }
        return f;
    }

    public final List<Parallax.PropertyMarkerValue> getPropertyRanges() {
        return this.mMarkerValues;
    }

    public final List<ParallaxTarget> getTargets() {
        return this.mTargets;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final List<Float> getWeights() {
        return this.mWeights;
    }

    public final void performMapping(Parallax parallax) {
        if (this.mMarkerValues.size() < 2) {
            return;
        }
        if (this instanceof IntEffect) {
            parallax.verifyIntProperties();
        } else {
            parallax.verifyFloatProperties();
        }
        Number number = null;
        float f = 0.0f;
        boolean z9 = false;
        for (int i = 0; i < this.mTargets.size(); i++) {
            ParallaxTarget parallaxTarget = this.mTargets.get(i);
            if (parallaxTarget.isDirectMapping()) {
                if (number == null) {
                    number = calculateDirectValue(parallax);
                }
                parallaxTarget.directUpdate(number);
            } else {
                if (!z9) {
                    f = calculateFraction(parallax);
                    z9 = true;
                }
                parallaxTarget.update(f);
            }
        }
    }

    public final void removeTarget(ParallaxTarget parallaxTarget) {
        this.mTargets.remove(parallaxTarget);
    }

    public final void setPropertyRanges(Parallax.PropertyMarkerValue... propertyMarkerValueArr) {
        this.mMarkerValues.clear();
        for (Parallax.PropertyMarkerValue propertyMarkerValue : propertyMarkerValueArr) {
            this.mMarkerValues.add(propertyMarkerValue);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final void setWeights(float... fArr) {
        int length = fArr.length;
        int i = 0;
        while (true) {
            float f = 0.0f;
            if (i >= length) {
                this.mWeights.clear();
                this.mTotalWeights.clear();
                for (float f10 : fArr) {
                    this.mWeights.add(Float.valueOf(f10));
                    f += f10;
                    this.mTotalWeights.add(Float.valueOf(f));
                }
                return;
            }
            if (fArr[i] <= 0.0f) {
                o.n();
                return;
            }
            i++;
        }
    }

    public final ParallaxEffect target(Object obj, PropertyValuesHolder propertyValuesHolder) {
        this.mTargets.add(new ParallaxTarget.PropertyValuesHolderTarget(obj, propertyValuesHolder));
        return this;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final ParallaxEffect weights(float... fArr) {
        setWeights(fArr);
        return this;
    }

    public final ParallaxEffect target(ParallaxTarget parallaxTarget) {
        this.mTargets.add(parallaxTarget);
        return this;
    }

    public final <T, V extends Number> ParallaxEffect target(T t9, Property<T, V> property) {
        this.mTargets.add(new ParallaxTarget.DirectPropertyTarget(t9, property));
        return this;
    }
}
