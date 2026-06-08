package androidx.leanback.graphics;

import android.graphics.Rect;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class BoundsRule {
    public ValueRule bottom;
    public ValueRule left;
    public ValueRule right;
    public ValueRule top;

    public BoundsRule(BoundsRule boundsRule) {
        ValueRule valueRule = boundsRule.left;
        this.left = valueRule != null ? new ValueRule(valueRule) : null;
        ValueRule valueRule2 = boundsRule.right;
        this.right = valueRule2 != null ? new ValueRule(valueRule2) : null;
        ValueRule valueRule3 = boundsRule.top;
        this.top = valueRule3 != null ? new ValueRule(valueRule3) : null;
        ValueRule valueRule4 = boundsRule.bottom;
        this.bottom = valueRule4 != null ? new ValueRule(valueRule4) : null;
    }

    private int doCalculate(int i, ValueRule valueRule, int i6) {
        return i + valueRule.mAbsoluteValue + ((int) (valueRule.mFraction * i6));
    }

    public void calculateBounds(Rect rect, Rect rect2) {
        ValueRule valueRule = this.left;
        if (valueRule == null) {
            rect2.left = rect.left;
        } else {
            rect2.left = doCalculate(rect.left, valueRule, rect.width());
        }
        ValueRule valueRule2 = this.right;
        if (valueRule2 == null) {
            rect2.right = rect.right;
        } else {
            rect2.right = doCalculate(rect.left, valueRule2, rect.width());
        }
        ValueRule valueRule3 = this.top;
        if (valueRule3 == null) {
            rect2.top = rect.top;
        } else {
            rect2.top = doCalculate(rect.top, valueRule3, rect.height());
        }
        ValueRule valueRule4 = this.bottom;
        if (valueRule4 == null) {
            rect2.bottom = rect.bottom;
        } else {
            rect2.bottom = doCalculate(rect.top, valueRule4, rect.height());
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class ValueRule {
        int mAbsoluteValue;
        float mFraction;

        public ValueRule(ValueRule valueRule) {
            this.mFraction = valueRule.mFraction;
            this.mAbsoluteValue = valueRule.mAbsoluteValue;
        }

        public static ValueRule absoluteValue(int i) {
            return new ValueRule(i, 0.0f);
        }

        public static ValueRule inheritFromParent(float f) {
            return new ValueRule(0, f);
        }

        public static ValueRule inheritFromParentWithOffset(float f, int i) {
            return new ValueRule(i, f);
        }

        public int getAbsoluteValue() {
            return this.mAbsoluteValue;
        }

        public float getFraction() {
            return this.mFraction;
        }

        public void setAbsoluteValue(int i) {
            this.mAbsoluteValue = i;
        }

        public void setFraction(float f) {
            this.mFraction = f;
        }

        public ValueRule(int i, float f) {
            this.mAbsoluteValue = i;
            this.mFraction = f;
        }
    }

    public BoundsRule() {
    }
}
