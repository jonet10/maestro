package com.google.android.material.slider;

import a4.x;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    private static final int DEFAULT_LABEL_ANIMATION_ENTER_DURATION = 83;
    private static final int DEFAULT_LABEL_ANIMATION_EXIT_DURATION = 117;
    private static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION = "minSeparation(%s) must be greater or equal to 0";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE = "minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE_UNIT = "minSeparation(%s) cannot be set as a dimension when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    private static final String EXCEPTION_ILLEGAL_VALUE = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom(%s) must be smaller than valueTo(%s)";
    private static final int HALO_ALPHA = 63;
    private static final float LEFT_LABEL_PIVOT_X = 1.2f;
    private static final float LEFT_LABEL_PIVOT_Y = 0.5f;
    private static final int MAX_TIMEOUT_TOOLTIP_WITH_ACCESSIBILITY = 120000;
    private static final int MIN_TIMEOUT_TOOLTIP_WITH_ACCESSIBILITY = 10000;
    private static final float RIGHT_LABEL_PIVOT_X = -0.2f;
    private static final float RIGHT_LABEL_PIVOT_Y = 0.5f;
    private static final String TAG = "BaseSlider";
    private static final double THRESHOLD = 1.0E-4d;
    private static final float THUMB_WIDTH_PRESSED_RATIO = 0.5f;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    private static final float TOP_LABEL_PIVOT_X = 0.5f;
    private static final float TOP_LABEL_PIVOT_Y = 1.2f;
    private static final float TOUCH_SLOP_RATIO = 0.8f;
    private static final int TRACK_CORNER_SIZE_UNSET = -1;
    static final int UNIT_PX = 0;
    static final int UNIT_VALUE = 1;
    private static final String WARNING_FLOATING_POINT_ERROR = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.";
    private static final String WARNING_PARSE_ERROR = "Error parsing value(%s), valueFrom(%s), and valueTo(%s) into a float.";
    private BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender;

    @NonNull
    private final AccessibilityHelper accessibilityHelper;
    private final AccessibilityManager accessibilityManager;
    private int activeThumbIdx;

    @NonNull
    private final Paint activeTicksPaint;

    @NonNull
    private final Paint activeTrackPaint;

    @NonNull
    private final RectF activeTrackRect;
    private boolean centered;

    @NonNull
    private final List<L> changeListeners;

    @NonNull
    private final RectF cornerRect;

    @Nullable
    private Drawable customThumbDrawable;

    @NonNull
    private List<Drawable> customThumbDrawablesForValues;

    @NonNull
    private final MaterialShapeDrawable defaultThumbDrawable;
    private int defaultThumbRadius;
    private int defaultThumbTrackGapSize;
    private int defaultThumbWidth;
    private int defaultTickActiveRadius;
    private int defaultTickInactiveRadius;
    private int defaultTrackThickness;
    private boolean dirtyConfig;
    private int focusedThumbIdx;
    private boolean forceDrawCompatHalo;
    private LabelFormatter formatter;

    @NonNull
    private ColorStateList haloColor;

    @NonNull
    private final Paint haloPaint;
    private int haloRadius;

    @NonNull
    private final Rect iconRect;

    @NonNull
    private final RectF iconRectF;

    @NonNull
    private final Paint inactiveTicksPaint;

    @NonNull
    private final RectF inactiveTrackLeftRect;

    @NonNull
    private final Paint inactiveTrackPaint;

    @NonNull
    private final RectF inactiveTrackRightRect;
    private boolean isLongPress;
    private int labelBehavior;
    private int labelPadding;

    @NonNull
    private final Rect labelRect;
    private int labelStyle;

    @NonNull
    private final List<TooltipDrawable> labels;
    private boolean labelsAreAnimatedIn;
    private ValueAnimator labelsInAnimator;
    private ValueAnimator labelsOutAnimator;
    private MotionEvent lastEvent;
    private int minTickSpacing;

    @Px
    private int minTouchTargetSize;
    private int minTrackSidePadding;
    private int minWidgetThickness;

    @NonNull
    private final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;

    @NonNull
    private final ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;

    @NonNull
    private final Runnable resetActiveThumbIndex;

    @NonNull
    private final Matrix rotationMatrix;
    private final int scaledTouchSlop;
    private int separationUnit;
    private float stepSize;

    @NonNull
    private final Paint stopIndicatorPaint;
    private boolean thisAndAncestorsVisible;
    private int thumbHeight;
    private boolean thumbIsPressed;

    @NonNull
    private final Paint thumbPaint;
    private int thumbTrackGapSize;
    private int thumbWidth;
    private int tickActiveRadius;

    @NonNull
    private ColorStateList tickColorActive;

    @NonNull
    private ColorStateList tickColorInactive;
    private int tickInactiveRadius;
    private int tickVisibilityMode;
    private float[] ticksCoordinates;
    private final int tooltipTimeoutMillis;
    private float touchDownAxis1;
    private float touchDownAxis2;

    @NonNull
    private final List<T> touchListeners;
    private float touchPosition;

    @NonNull
    private ColorStateList trackColorActive;

    @NonNull
    private ColorStateList trackColorInactive;
    private int trackCornerSize;

    @Nullable
    private ColorStateList trackIconActiveColor;

    @Nullable
    private Drawable trackIconActiveEnd;
    private boolean trackIconActiveEndMutated;

    @Nullable
    private Drawable trackIconActiveStart;
    private boolean trackIconActiveStartMutated;

    @Nullable
    private ColorStateList trackIconInactiveColor;

    @Nullable
    private Drawable trackIconInactiveEnd;
    private boolean trackIconInactiveEndMutated;

    @Nullable
    private Drawable trackIconInactiveStart;
    private boolean trackIconInactiveStartMutated;

    @Px
    private int trackIconPadding;

    @Px
    private int trackIconSize;
    private int trackInsideCornerSize;

    @NonNull
    private final Path trackPath;
    private int trackSidePadding;
    private int trackStopIndicatorSize;
    private int trackThickness;
    private int trackWidth;
    private float valueFrom;
    private float valueTo;
    private ArrayList<Float> values;
    private int widgetOrientation;
    private int widgetThickness;
    static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_Slider;
    private static final int LABEL_ANIMATION_ENTER_DURATION_ATTR = R.attr.motionDurationMedium4;
    private static final int LABEL_ANIMATION_EXIT_DURATION_ATTR = R.attr.motionDurationShort3;
    private static final int LABEL_ANIMATION_ENTER_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
    private static final int LABEL_ANIMATION_EXIT_EASING_ATTR = R.attr.motionEasingEmphasizedAccelerateInterpolator;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public class AccessibilityEventSender implements Runnable {
        int virtualViewId;

        private AccessibilityEventSender() {
            this.virtualViewId = -1;
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.this.accessibilityHelper.sendEventForVirtualView(this.virtualViewId, 4);
        }

        public void setVirtualViewId(int i) {
            this.virtualViewId = i;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class AccessibilityHelper extends ExploreByTouchHelper {
        private final BaseSlider<?, ?, ?> slider;
        final Rect virtualViewBounds;

        public AccessibilityHelper(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.virtualViewBounds = new Rect();
            this.slider = baseSlider;
        }

        @NonNull
        private String startOrEndDescription(int i) {
            return i == this.slider.getValues().size() + (-1) ? this.slider.getContext().getString(R.string.material_slider_range_end) : i == 0 ? this.slider.getContext().getString(R.string.material_slider_range_start) : "";
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float f, float f10) {
            for (int i = 0; i < this.slider.getValues().size(); i++) {
                this.slider.updateBoundsForVirtualViewId(i, this.virtualViewBounds);
                if (this.virtualViewBounds.contains((int) f, (int) f10)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(@NonNull List<Integer> list) {
            for (int i = 0; i < this.slider.getValues().size(); i++) {
                list.add(Integer.valueOf(i));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int i, int i6, @Nullable Bundle bundle) {
            if (!this.slider.isEnabled()) {
                return false;
            }
            if (i6 != 4096 && i6 != 8192) {
                if (i6 == 16908349 && bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                    if (this.slider.snapThumbToValue(i, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                        this.slider.updateHaloHotspot();
                        this.slider.postInvalidate();
                        invalidateVirtualView(i);
                        return true;
                    }
                }
                return false;
            }
            float calculateStepIncrement = this.slider.calculateStepIncrement(20);
            if (i6 == 8192) {
                calculateStepIncrement = -calculateStepIncrement;
            }
            if (this.slider.isRtl()) {
                calculateStepIncrement = -calculateStepIncrement;
            }
            if (!this.slider.snapThumbToValue(i, MathUtils.clamp(this.slider.getValues().get(i).floatValue() + calculateStepIncrement, this.slider.getValueFrom(), this.slider.getValueTo()))) {
                return false;
            }
            this.slider.setActiveThumbIndex(i);
            this.slider.scheduleTooltipTimeout();
            this.slider.updateHaloHotspot();
            this.slider.postInvalidate();
            invalidateVirtualView(i);
            return true;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int i, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> values = this.slider.getValues();
            Float f = values.get(i);
            float floatValue = f.floatValue();
            float valueFrom = this.slider.getValueFrom();
            float valueTo = this.slider.getValueTo();
            if (this.slider.isEnabled()) {
                if (floatValue > valueFrom) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (floatValue < valueTo) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            NumberFormat numberInstance = NumberFormat.getNumberInstance();
            numberInstance.setMaximumFractionDigits(2);
            try {
                valueFrom = numberInstance.parse(numberInstance.format(valueFrom)).floatValue();
                valueTo = numberInstance.parse(numberInstance.format(valueTo)).floatValue();
                floatValue = numberInstance.parse(numberInstance.format(floatValue)).floatValue();
            } catch (ParseException unused) {
                Log.w(BaseSlider.TAG, "Error parsing value(" + f + "), valueFrom(" + valueFrom + "), and valueTo(" + valueTo + ") into a float.");
            }
            accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, floatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.slider.getContentDescription() != null) {
                sb.append(this.slider.getContentDescription());
                sb.append(",");
            }
            String formatValue = this.slider.formatValue(floatValue);
            String string = this.slider.getContext().getString(R.string.material_slider_value);
            if (values.size() > 1) {
                string = startOrEndDescription(i);
            }
            CharSequence stateDescription = ViewCompat.getStateDescription(this.slider);
            if (TextUtils.isEmpty(stateDescription)) {
                Locale.getDefault();
                sb.append(string + ", " + formatValue);
            } else {
                accessibilityNodeInfoCompat.setStateDescription(stateDescription);
            }
            accessibilityNodeInfoCompat.setContentDescription(sb.toString());
            this.slider.updateBoundsForVirtualViewId(i, this.virtualViewBounds);
            accessibilityNodeInfoCompat.setBoundsInParent(this.virtualViewBounds);
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public enum FullCornerDirection {
        BOTH,
        LEFT,
        RIGHT,
        NONE
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    @Retention(RetentionPolicy.SOURCE)
    public @interface Orientation {
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.labelsAreAnimatedIn = false;
        this.defaultThumbWidth = -1;
        this.defaultThumbTrackGapSize = -1;
        this.centered = false;
        this.trackIconActiveStartMutated = false;
        this.trackIconActiveEndMutated = false;
        this.trackIconInactiveStartMutated = false;
        this.trackIconInactiveEndMutated = false;
        this.thumbIsPressed = false;
        this.values = new ArrayList<>();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.isLongPress = false;
        this.trackPath = new Path();
        this.activeTrackRect = new RectF();
        this.inactiveTrackLeftRect = new RectF();
        this.inactiveTrackRightRect = new RectF();
        this.cornerRect = new RectF();
        this.labelRect = new Rect();
        this.iconRectF = new RectF();
        this.iconRect = new Rect();
        this.rotationMatrix = new Matrix();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        this.defaultThumbDrawable = materialShapeDrawable;
        this.customThumbDrawablesForValues = Collections.EMPTY_LIST;
        this.separationUnit = 0;
        this.onScrollChangedListener = new ViewTreeObserver.OnScrollChangedListener() { // from class: com.google.android.material.slider.b
            @Override // android.view.ViewTreeObserver.OnScrollChangedListener
            public final void onScrollChanged() {
                BaseSlider.this.updateLabels();
            }
        };
        this.onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.google.android.material.slider.c
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                BaseSlider.this.updateLabels();
            }
        };
        this.resetActiveThumbIndex = new Runnable() { // from class: com.google.android.material.slider.d
            @Override // java.lang.Runnable
            public final void run() {
                BaseSlider.this.lambda$new$0();
            }
        };
        Context context2 = getContext();
        this.thisAndAncestorsVisible = isShown();
        this.inactiveTrackPaint = new Paint();
        this.activeTrackPaint = new Paint();
        Paint paint = new Paint(1);
        this.thumbPaint = paint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        Paint paint2 = new Paint(1);
        this.haloPaint = paint2;
        paint2.setStyle(style);
        Paint paint3 = new Paint();
        this.inactiveTicksPaint = paint3;
        Paint.Style style2 = Paint.Style.STROKE;
        paint3.setStyle(style2);
        Paint.Cap cap = Paint.Cap.ROUND;
        paint3.setStrokeCap(cap);
        Paint paint4 = new Paint();
        this.activeTicksPaint = paint4;
        paint4.setStyle(style2);
        paint4.setStrokeCap(cap);
        Paint paint5 = new Paint();
        this.stopIndicatorPaint = paint5;
        paint5.setStyle(style);
        paint5.setStrokeCap(cap);
        loadResources(context2.getResources());
        processAttributes(context2, attributeSet, i);
        setFocusable(true);
        setClickable(true);
        materialShapeDrawable.setShadowCompatibilityMode(2);
        this.scaledTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
        AccessibilityHelper accessibilityHelper = new AccessibilityHelper(this);
        this.accessibilityHelper = accessibilityHelper;
        ViewCompat.setAccessibilityDelegate(this, accessibilityHelper);
        AccessibilityManager accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        this.accessibilityManager = accessibilityManager;
        if (Build.VERSION.SDK_INT >= 29) {
            this.tooltipTimeoutMillis = accessibilityManager.getRecommendedTimeoutMillis(10000, 6);
        } else {
            this.tooltipTimeoutMillis = MAX_TIMEOUT_TOOLTIP_WITH_ACCESSIBILITY;
        }
    }

    private void adjustCustomThumbDrawableBounds(Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, this.thumbWidth, this.thumbHeight);
        } else {
            float max = Math.max(this.thumbWidth, this.thumbHeight) / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * max), (int) (intrinsicHeight * max));
        }
    }

    private void attachLabelToContentView(TooltipDrawable tooltipDrawable) {
        tooltipDrawable.setRelativeToView(ViewUtils.getContentView(this));
    }

    private void calculateBoundsAndDrawTrackIcon(@NonNull Canvas canvas, @NonNull RectF rectF, @Nullable Drawable drawable, boolean z9) {
        if (drawable != null) {
            calculateTrackIconBounds(rectF, this.iconRectF, this.trackIconSize, this.trackIconPadding, z9);
            if (this.iconRectF.isEmpty()) {
                return;
            }
            drawTrackIcon(canvas, this.iconRectF, drawable);
        }
    }

    private float calculateEndTrackCornerSize(float f) {
        if (this.values.isEmpty() || !hasGapBetweenThumbAndTrack()) {
            return f;
        }
        float valueToX = valueToX(this.values.get((isRtl() || isVertical()) ? 0 : this.values.size() - 1).floatValue()) - this.trackSidePadding;
        int i = this.trackWidth;
        return valueToX > ((float) i) - f ? Math.max(i - valueToX, this.trackInsideCornerSize) : f;
    }

    @Nullable
    private Float calculateIncrementForKey(int i) {
        float calculateStepIncrement = this.isLongPress ? calculateStepIncrement(20) : calculateStepIncrement();
        if (i == 69) {
            return Float.valueOf(-calculateStepIncrement);
        }
        if (i == 70 || i == 81) {
            return Float.valueOf(calculateStepIncrement);
        }
        switch (i) {
            case 19:
                if (isVertical()) {
                    return Float.valueOf(calculateStepIncrement);
                }
                return null;
            case 20:
                if (isVertical()) {
                    return Float.valueOf(-calculateStepIncrement);
                }
                return null;
            case 21:
                if (!isRtl()) {
                    calculateStepIncrement = -calculateStepIncrement;
                }
                return Float.valueOf(calculateStepIncrement);
            case 22:
                if (isRtl()) {
                    calculateStepIncrement = -calculateStepIncrement;
                }
                return Float.valueOf(calculateStepIncrement);
            default:
                return null;
        }
    }

    private void calculateLabelBounds(TooltipDrawable tooltipDrawable, float f) {
        int normalizeValue;
        int intrinsicWidth;
        int calculateTrackCenter;
        int intrinsicHeight;
        int i;
        boolean isVertical = isVertical();
        int i6 = this.trackSidePadding;
        if (isVertical) {
            normalizeValue = (i6 + ((int) (normalizeValue(f) * this.trackWidth))) - (tooltipDrawable.getIntrinsicHeight() / 2);
            intrinsicWidth = tooltipDrawable.getIntrinsicHeight() + normalizeValue;
            if (!isRtl()) {
                int calculateTrackCenter2 = calculateTrackCenter() + (this.thumbHeight / 2) + this.labelPadding;
                calculateTrackCenter = tooltipDrawable.getIntrinsicWidth() + calculateTrackCenter2;
                i = calculateTrackCenter2;
                this.labelRect.set(normalizeValue, i, intrinsicWidth, calculateTrackCenter);
            }
            calculateTrackCenter = calculateTrackCenter() - ((this.thumbHeight / 2) + this.labelPadding);
            intrinsicHeight = tooltipDrawable.getIntrinsicWidth();
        } else {
            normalizeValue = (i6 + ((int) (normalizeValue(f) * this.trackWidth))) - (tooltipDrawable.getIntrinsicWidth() / 2);
            intrinsicWidth = tooltipDrawable.getIntrinsicWidth() + normalizeValue;
            calculateTrackCenter = calculateTrackCenter() - ((this.thumbHeight / 2) + this.labelPadding);
            intrinsicHeight = tooltipDrawable.getIntrinsicHeight();
        }
        i = calculateTrackCenter - intrinsicHeight;
        this.labelRect.set(normalizeValue, i, intrinsicWidth, calculateTrackCenter);
    }

    private float calculateStartTrackCornerSize(float f) {
        if (this.values.isEmpty() || !hasGapBetweenThumbAndTrack()) {
            return f;
        }
        float valueToX = valueToX(this.values.get((isRtl() || isVertical()) ? this.values.size() - 1 : 0).floatValue()) - this.trackSidePadding;
        return valueToX < f ? Math.max(valueToX, this.trackInsideCornerSize) : f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float calculateStepIncrement(int i) {
        float calculateStepIncrement = calculateStepIncrement();
        return (this.valueTo - this.valueFrom) / calculateStepIncrement <= i ? calculateStepIncrement : Math.round(r1 / r4) * calculateStepIncrement;
    }

    private int calculateTrackCenter() {
        return (this.widgetThickness / 2) + ((this.labelBehavior == 1 || shouldAlwaysShowLabel()) ? this.labels.get(0).getIntrinsicHeight() : 0);
    }

    private void calculateTrackIconBounds(@NonNull RectF rectF, @NonNull RectF rectF2, @Px int i, @Px int i6, boolean z9) {
        if (rectF.right - rectF.left < (i6 * 2) + i) {
            rectF2.setEmpty();
            return;
        }
        float f = z9 ^ (isRtl() || isVertical()) ? rectF.left + i6 : (rectF.right - i6) - i;
        float f10 = i;
        float calculateTrackCenter = calculateTrackCenter() - (f10 / 2.0f);
        rectF2.set(f, calculateTrackCenter, f + f10, f10 + calculateTrackCenter);
    }

    private int convertToTickVisibilityMode(boolean z9) {
        return z9 ? 0 : 2;
    }

    private ValueAnimator createLabelAnimator(boolean z9) {
        int resolveThemeDuration;
        TimeInterpolator resolveThemeInterpolator;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(getAnimatorCurrentValueOrDefault(z9 ? this.labelsOutAnimator : this.labelsInAnimator, z9 ? 0.0f : 1.0f), z9 ? 1.0f : 0.0f);
        if (z9) {
            resolveThemeDuration = MotionUtils.resolveThemeDuration(getContext(), LABEL_ANIMATION_ENTER_DURATION_ATTR, DEFAULT_LABEL_ANIMATION_ENTER_DURATION);
            resolveThemeInterpolator = MotionUtils.resolveThemeInterpolator(getContext(), LABEL_ANIMATION_ENTER_EASING_ATTR, AnimationUtils.DECELERATE_INTERPOLATOR);
        } else {
            resolveThemeDuration = MotionUtils.resolveThemeDuration(getContext(), LABEL_ANIMATION_EXIT_DURATION_ATTR, DEFAULT_LABEL_ANIMATION_EXIT_DURATION);
            resolveThemeInterpolator = MotionUtils.resolveThemeInterpolator(getContext(), LABEL_ANIMATION_EXIT_EASING_ATTR, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        }
        ofFloat.setDuration(resolveThemeDuration);
        ofFloat.setInterpolator(resolveThemeInterpolator);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.slider.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                BaseSlider.this.lambda$createLabelAnimator$1(valueAnimator);
            }
        });
        return ofFloat;
    }

    private void createLabelPool() {
        if (this.labels.size() > this.values.size()) {
            List<TooltipDrawable> subList = this.labels.subList(this.values.size(), this.labels.size());
            for (TooltipDrawable tooltipDrawable : subList) {
                if (isAttachedToWindow()) {
                    detachLabelFromContentView(tooltipDrawable);
                }
            }
            subList.clear();
        }
        while (true) {
            if (this.labels.size() >= this.values.size()) {
                break;
            }
            TooltipDrawable createFromAttributes = TooltipDrawable.createFromAttributes(getContext(), null, 0, this.labelStyle);
            this.labels.add(createFromAttributes);
            if (isAttachedToWindow()) {
                attachLabelToContentView(createFromAttributes);
            }
        }
        int i = this.labels.size() != 1 ? 1 : 0;
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            it.next().setStrokeWidth(i);
        }
    }

    private void detachLabelFromContentView(TooltipDrawable tooltipDrawable) {
        ViewGroup contentView = ViewUtils.getContentView(this);
        if (contentView == null) {
            return;
        }
        contentView.getOverlay().remove(tooltipDrawable);
        tooltipDrawable.detachView(contentView);
    }

    private float dimenToValue(float f) {
        if (f == 0.0f) {
            return 0.0f;
        }
        float f10 = (f - this.trackSidePadding) / this.trackWidth;
        float f11 = this.valueFrom;
        return x.f(f11, this.valueTo, f10, f11);
    }

    private void dispatchOnChangedFromUser(int i) {
        Iterator<L> it = this.changeListeners.iterator();
        while (it.hasNext()) {
            it.next().onValueChange(this, this.values.get(i).floatValue(), true);
        }
        AccessibilityManager accessibilityManager = this.accessibilityManager;
        if (accessibilityManager == null || !accessibilityManager.isEnabled()) {
            return;
        }
        scheduleAccessibilityEventSender(i);
    }

    private void dispatchOnChangedProgrammatically() {
        for (L l10 : this.changeListeners) {
            ArrayList<Float> arrayList = this.values;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Float f = arrayList.get(i);
                i++;
                l10.onValueChange(this, f.floatValue(), false);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void drawActiveTracks(@androidx.annotation.NonNull android.graphics.Canvas r13, int r14, int r15) {
        /*
            Method dump skipped, instructions count: 243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.drawActiveTracks(android.graphics.Canvas, int, int):void");
    }

    private void drawInactiveTrackSection(float f, float f10, float f11, float f12, @NonNull Canvas canvas, RectF rectF, FullCornerDirection fullCornerDirection) {
        if (f10 - f > getTrackCornerSize() - this.thumbTrackGapSize) {
            rectF.set(f, f11, f10, f12);
        } else {
            rectF.setEmpty();
        }
        updateTrack(canvas, this.inactiveTrackPaint, rectF, getTrackCornerSize(), fullCornerDirection);
    }

    private void drawInactiveTracks(@NonNull Canvas canvas, int i, int i6) {
        float[] activeRange = getActiveRange();
        float f = i6;
        int i10 = this.trackThickness;
        float f10 = f - (i10 / 2.0f);
        float f11 = (i10 / 2.0f) + f;
        float f12 = i;
        drawInactiveTrackSection(this.trackSidePadding - getTrackCornerSize(), ((activeRange[0] * f12) + this.trackSidePadding) - this.thumbTrackGapSize, f10, f11, canvas, this.inactiveTrackLeftRect, FullCornerDirection.LEFT);
        drawInactiveTrackSection((activeRange[1] * f12) + this.trackSidePadding + this.thumbTrackGapSize, r13 + i + getTrackCornerSize(), f10, f11, canvas, this.inactiveTrackRightRect, FullCornerDirection.RIGHT);
    }

    private void drawStopIndicator(@NonNull Canvas canvas, float f, float f10) {
        ArrayList<Float> arrayList = this.values;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Float f11 = arrayList.get(i);
            i++;
            float valueToX = valueToX(f11.floatValue());
            float f12 = (this.thumbWidth / 2.0f) + this.thumbTrackGapSize;
            if (f >= valueToX - f12 && f <= valueToX + f12) {
                return;
            }
        }
        boolean isVertical = isVertical();
        Paint paint = this.stopIndicatorPaint;
        if (isVertical) {
            canvas.drawPoint(f10, f, paint);
        } else {
            canvas.drawPoint(f, f10, paint);
        }
    }

    private void drawThumbDrawable(@NonNull Canvas canvas, int i, int i6, float f, @NonNull Drawable drawable) {
        canvas.save();
        if (isVertical()) {
            canvas.concat(this.rotationMatrix);
        }
        canvas.translate((this.trackSidePadding + ((int) (normalizeValue(f) * i))) - (drawable.getBounds().width() / 2.0f), i6 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    private void drawThumbs(@NonNull Canvas canvas, int i, int i6) {
        Canvas canvas2;
        int i10;
        int i11;
        int i12 = 0;
        while (i12 < this.values.size()) {
            float floatValue = this.values.get(i12).floatValue();
            Drawable drawable = this.customThumbDrawable;
            if (drawable != null) {
                canvas2 = canvas;
                i10 = i;
                i11 = i6;
                drawThumbDrawable(canvas2, i10, i11, floatValue, drawable);
            } else {
                canvas2 = canvas;
                i10 = i;
                i11 = i6;
                if (i12 < this.customThumbDrawablesForValues.size()) {
                    drawThumbDrawable(canvas2, i10, i11, floatValue, this.customThumbDrawablesForValues.get(i12));
                } else {
                    if (!isEnabled()) {
                        canvas2.drawCircle((normalizeValue(floatValue) * i10) + this.trackSidePadding, i11, getThumbRadius(), this.thumbPaint);
                    }
                    drawThumbDrawable(canvas2, i10, i11, floatValue, this.defaultThumbDrawable);
                }
            }
            i12++;
            canvas = canvas2;
            i = i10;
            i6 = i11;
        }
    }

    private void drawTicks(int i, int i6, Canvas canvas, Paint paint) {
        while (i < i6) {
            boolean isVertical = isVertical();
            float[] fArr = this.ticksCoordinates;
            float f = isVertical ? fArr[i + 1] : fArr[i];
            if (!isOverlappingThumb(f) && (!isCentered() || !isOverlappingCenterGap(f))) {
                float[] fArr2 = this.ticksCoordinates;
                canvas.drawPoint(fArr2[i], fArr2[i + 1], paint);
            }
            i += 2;
        }
    }

    private void drawTrackIcon(@NonNull Canvas canvas, @NonNull RectF rectF, @NonNull Drawable drawable) {
        if (isVertical()) {
            this.rotationMatrix.mapRect(rectF);
        }
        rectF.round(this.iconRect);
        drawable.setBounds(this.iconRect);
        drawable.draw(canvas);
    }

    private void drawTrackIcons(@NonNull Canvas canvas, @NonNull RectF rectF, @NonNull RectF rectF2) {
        if (hasTrackIcons()) {
            if (this.values.size() > 1) {
                Log.w(TAG, "Track icons can only be used when only 1 thumb is present.");
            }
            calculateBoundsAndDrawTrackIcon(canvas, rectF, this.trackIconActiveStart, true);
            calculateBoundsAndDrawTrackIcon(canvas, rectF2, this.trackIconInactiveStart, true);
            calculateBoundsAndDrawTrackIcon(canvas, rectF, this.trackIconActiveEnd, false);
            calculateBoundsAndDrawTrackIcon(canvas, rectF2, this.trackIconInactiveEnd, false);
        }
    }

    private void ensureLabelsAdded() {
        if (!this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = true;
            ValueAnimator createLabelAnimator = createLabelAnimator(true);
            this.labelsInAnimator = createLabelAnimator;
            this.labelsOutAnimator = null;
            createLabelAnimator.start();
        }
        Iterator<TooltipDrawable> it = this.labels.iterator();
        for (int i = 0; i < this.values.size() && it.hasNext(); i++) {
            if (i != this.focusedThumbIdx) {
                setValueForLabel(it.next(), this.values.get(i).floatValue());
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size())));
        }
        setValueForLabel(it.next(), this.values.get(this.focusedThumbIdx).floatValue());
    }

    private void ensureLabelsRemoved() {
        if (this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = false;
            ValueAnimator createLabelAnimator = createLabelAnimator(false);
            this.labelsOutAnimator = createLabelAnimator;
            this.labelsInAnimator = null;
            createLabelAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.slider.BaseSlider.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    ViewOverlay contentViewOverlay = BaseSlider.this.getContentViewOverlay();
                    if (contentViewOverlay == null) {
                        return;
                    }
                    Iterator it = BaseSlider.this.labels.iterator();
                    while (it.hasNext()) {
                        contentViewOverlay.remove((TooltipDrawable) it.next());
                    }
                }
            });
            this.labelsOutAnimator.start();
        }
    }

    private void focusThumbOnFocusGained(int i) {
        if (i == 1) {
            moveFocus(Integer.MAX_VALUE);
            return;
        }
        if (i == 2) {
            moveFocus(Integer.MIN_VALUE);
        } else if (i == 17) {
            moveFocusInAbsoluteDirection(Integer.MAX_VALUE);
        } else {
            if (i != 66) {
                return;
            }
            moveFocusInAbsoluteDirection(Integer.MIN_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String formatValue(float f) {
        if (hasLabelFormatter()) {
            return this.formatter.getFormattedValue(f);
        }
        return String.format(((float) ((int) f)) == f ? "%.0f" : "%.2f", Float.valueOf(f));
    }

    private float[] getActiveRange() {
        float floatValue = this.values.get(0).floatValue();
        ArrayList<Float> arrayList = this.values;
        float floatValue2 = arrayList.get(arrayList.size() - 1).floatValue();
        if (this.values.size() == 1) {
            floatValue = this.valueFrom;
        }
        float normalizeValue = normalizeValue(floatValue);
        float normalizeValue2 = normalizeValue(floatValue2);
        if (isCentered()) {
            float min = Math.min(0.5f, normalizeValue2);
            normalizeValue2 = Math.max(0.5f, normalizeValue2);
            normalizeValue = min;
        }
        return (isCentered() || !(isRtl() || isVertical())) ? new float[]{normalizeValue, normalizeValue2} : new float[]{normalizeValue2, normalizeValue};
    }

    private static float getAnimatorCurrentValueOrDefault(ValueAnimator valueAnimator, float f) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return floatValue;
    }

    private float getClampedValue(int i, float f) {
        float minSeparation = getMinSeparation();
        if (this.separationUnit == 0) {
            minSeparation = dimenToValue(minSeparation);
        }
        if (isRtl() || isVertical()) {
            minSeparation = -minSeparation;
        }
        int i6 = i + 1;
        int i10 = i - 1;
        return MathUtils.clamp(f, i10 < 0 ? this.valueFrom : this.values.get(i10).floatValue() + minSeparation, i6 >= this.values.size() ? this.valueTo : this.values.get(i6).floatValue() - minSeparation);
    }

    @ColorInt
    private int getColorForState(@NonNull ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public ViewOverlay getContentViewOverlay() {
        ViewGroup contentView = ViewUtils.getContentView(this);
        if (contentView == null) {
            return null;
        }
        return contentView.getOverlay();
    }

    private float[] getCornerRadii(float f, float f10) {
        return isVertical() ? new float[]{f, f, f, f, f10, f10, f10, f10} : new float[]{f, f, f10, f10, f10, f10, f, f};
    }

    private int getDesiredTickCount() {
        return (int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f);
    }

    private int getMaxTickCount() {
        return (this.trackWidth / this.minTickSpacing) + 1;
    }

    private float getValueOfTouchPosition() {
        double snapPosition = snapPosition(this.touchPosition);
        if (isRtl() || isVertical()) {
            snapPosition = 1.0d - snapPosition;
        }
        float f = this.valueTo;
        return (float) ((snapPosition * (f - r3)) + this.valueFrom);
    }

    private float getValueOfTouchPositionAbsolute() {
        float f = this.touchPosition;
        if (isRtl() || isVertical()) {
            f = 1.0f - f;
        }
        float f10 = this.valueTo;
        float f11 = this.valueFrom;
        return x.f(f10, f11, f, f11);
    }

    private boolean hasGapBetweenThumbAndTrack() {
        return this.thumbTrackGapSize > 0;
    }

    private boolean hasTrackIcons() {
        return (this.trackIconActiveStart == null && this.trackIconActiveEnd == null && this.trackIconInactiveStart == null && this.trackIconInactiveEnd == null) ? false : true;
    }

    private Drawable initializeCustomThumbDrawable(Drawable drawable) {
        Drawable newDrawable = drawable.mutate().getConstantState().newDrawable();
        adjustCustomThumbDrawableBounds(newDrawable);
        return newDrawable;
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth(this.trackThickness);
        this.activeTrackPaint.setStrokeWidth(this.trackThickness);
    }

    private boolean isInHorizontalScrollingContainer() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollHorizontally(1) || viewGroup.canScrollHorizontally(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private boolean isInVerticalScrollingContainer() {
        for (ViewParent parent = getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
        }
        return false;
    }

    private static boolean isMouseEvent(MotionEvent motionEvent) {
        return motionEvent.getToolType(0) == 3;
    }

    private boolean isMultipleOfStepSize(double d10) {
        double doubleValue = new BigDecimal(Double.toString(d10)).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(doubleValue)) - doubleValue) < THRESHOLD;
    }

    private boolean isOverlappingCenterGap(float f) {
        float f10 = (this.thumbWidth / 2.0f) + this.thumbTrackGapSize;
        float f11 = ((this.trackSidePadding * 2) + this.trackWidth) / 2.0f;
        return f >= f11 - f10 && f <= f11 + f10;
    }

    private boolean isOverlappingThumb(float f) {
        float f10 = (this.thumbWidth / 2.0f) + this.thumbTrackGapSize;
        Iterator<Float> it = this.values.iterator();
        if (it.hasNext()) {
            float valueToX = valueToX(it.next().floatValue());
            if (f >= valueToX - f10 && f <= valueToX + f10) {
                return true;
            }
        }
        return false;
    }

    private boolean isPotentialHorizontalScroll(MotionEvent motionEvent) {
        return !isMouseEvent(motionEvent) && isInHorizontalScrollingContainer();
    }

    private boolean isPotentialVerticalScroll(MotionEvent motionEvent) {
        return !isMouseEvent(motionEvent) && isInVerticalScrollingContainer();
    }

    private boolean isSliderVisibleOnScreen() {
        Rect rect = new Rect();
        ViewUtils.getContentView(this).getHitRect(rect);
        return getLocalVisibleRect(rect) && isThisAndAncestorsVisible();
    }

    private boolean isThisAndAncestorsVisible() {
        return Build.VERSION.SDK_INT >= 24 ? this.thisAndAncestorsVisible : isShown();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createLabelAnimator$1(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            it.next().setRevealFraction(floatValue);
        }
        postInvalidateOnAnimation();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        setActiveThumbIndex(-1);
        invalidate();
    }

    private void loadResources(@NonNull Resources resources) {
        this.minWidgetThickness = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.minTrackSidePadding = dimensionPixelOffset;
        this.trackSidePadding = dimensionPixelOffset;
        this.defaultThumbRadius = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.defaultTrackThickness = resources.getDimensionPixelSize(R.dimen.mtrl_slider_track_height);
        this.defaultTickActiveRadius = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_radius);
        this.defaultTickInactiveRadius = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_radius);
        this.minTickSpacing = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_min_spacing);
        this.labelPadding = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
        this.trackIconPadding = resources.getDimensionPixelOffset(R.dimen.m3_slider_track_icon_padding);
    }

    private void maybeDrawCompatHalo(@NonNull Canvas canvas, int i, int i6) {
        Canvas canvas2;
        if (shouldDrawCompatHalo()) {
            float[] fArr = {(normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * i) + this.trackSidePadding, i6};
            if (isVertical()) {
                this.rotationMatrix.mapPoints(fArr);
            }
            if (Build.VERSION.SDK_INT < 28) {
                float f = fArr[0];
                int i10 = this.haloRadius;
                float f10 = fArr[1];
                canvas2 = canvas;
                canvas2.clipRect(f - i10, f10 - i10, f + i10, f10 + i10, Region.Op.UNION);
            } else {
                canvas2 = canvas;
            }
            canvas2.drawCircle(fArr[0], fArr[1], this.haloRadius, this.haloPaint);
        }
    }

    private void maybeDrawStopIndicator(@NonNull Canvas canvas, int i) {
        if (this.trackStopIndicatorSize <= 0 || this.values.isEmpty()) {
            return;
        }
        ArrayList<Float> arrayList = this.values;
        float floatValue = arrayList.get(arrayList.size() - 1).floatValue();
        float f = this.valueTo;
        if (floatValue < f) {
            drawStopIndicator(canvas, valueToX(f), i);
        }
        if (isCentered() || (this.values.size() > 1 && this.values.get(0).floatValue() > this.valueFrom)) {
            drawStopIndicator(canvas, valueToX(this.valueFrom), i);
        }
    }

    private void maybeDrawTicks(@NonNull Canvas canvas) {
        float[] fArr = this.ticksCoordinates;
        if (fArr == null || fArr.length == 0) {
            return;
        }
        float[] activeRange = getActiveRange();
        int ceil = (int) Math.ceil(((this.ticksCoordinates.length / 2.0f) - 1.0f) * activeRange[0]);
        int floor = (int) Math.floor(((this.ticksCoordinates.length / 2.0f) - 1.0f) * activeRange[1]);
        if (ceil > 0) {
            drawTicks(0, ceil * 2, canvas, this.inactiveTicksPaint);
        }
        if (ceil <= floor) {
            drawTicks(ceil * 2, (floor + 1) * 2, canvas, this.activeTicksPaint);
        }
        int i = (floor + 1) * 2;
        float[] fArr2 = this.ticksCoordinates;
        if (i < fArr2.length) {
            drawTicks(i, fArr2.length, canvas, this.inactiveTicksPaint);
        }
    }

    private boolean maybeIncreaseTrackSidePadding() {
        int max = Math.max(Math.max(Math.max((this.thumbWidth / 2) - this.defaultThumbRadius, 0), Math.max((this.trackThickness - this.defaultTrackThickness) / 2, 0)), Math.max(Math.max(this.tickActiveRadius - this.defaultTickActiveRadius, 0), Math.max(this.tickInactiveRadius - this.defaultTickInactiveRadius, 0))) + this.minTrackSidePadding;
        if (this.trackSidePadding == max) {
            return false;
        }
        this.trackSidePadding = max;
        if (!isLaidOut()) {
            return true;
        }
        updateTrackWidth(isVertical() ? getHeight() : getWidth());
        return true;
    }

    private boolean maybeIncreaseWidgetThickness() {
        int paddingTop;
        int paddingBottom;
        if (isVertical()) {
            paddingTop = getPaddingLeft();
            paddingBottom = getPaddingRight();
        } else {
            paddingTop = getPaddingTop();
            paddingBottom = getPaddingBottom();
        }
        int i = paddingBottom + paddingTop;
        int max = Math.max(this.minWidgetThickness, Math.max(this.trackThickness + i, this.thumbHeight + i));
        if (max == this.widgetThickness) {
            return false;
        }
        this.widgetThickness = max;
        return true;
    }

    private boolean moveFocus(int i) {
        int i6 = this.focusedThumbIdx;
        int clamp = (int) MathUtils.clamp(i6 + i, 0L, this.values.size() - 1);
        this.focusedThumbIdx = clamp;
        if (clamp == i6) {
            return false;
        }
        if (this.activeThumbIdx != -1) {
            this.activeThumbIdx = clamp;
        }
        updateHaloHotspot();
        postInvalidate();
        return true;
    }

    private boolean moveFocusInAbsoluteDirection(int i) {
        if (isRtl() || isVertical()) {
            i = i == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i;
        }
        return moveFocus(i);
    }

    private float normalizeValue(float f) {
        float f10 = this.valueFrom;
        float f11 = (f - f10) / (this.valueTo - f10);
        return (isRtl() || isVertical()) ? 1.0f - f11 : f11;
    }

    @Nullable
    private Boolean onKeyDownNoActiveThumb(int i, @NonNull KeyEvent keyEvent) {
        if (i == 61) {
            return keyEvent.hasNoModifiers() ? Boolean.valueOf(moveFocus(1)) : keyEvent.isShiftPressed() ? Boolean.valueOf(moveFocus(-1)) : Boolean.FALSE;
        }
        if (i != 66) {
            if (i != 81) {
                if (i == 69) {
                    moveFocus(-1);
                    return Boolean.TRUE;
                }
                if (i != 70) {
                    switch (i) {
                        case 21:
                            moveFocusInAbsoluteDirection(-1);
                            break;
                        case 22:
                            moveFocusInAbsoluteDirection(1);
                            break;
                    }
                    return Boolean.TRUE;
                }
            }
            moveFocus(1);
            return Boolean.TRUE;
        }
        this.activeThumbIdx = this.focusedThumbIdx;
        postInvalidate();
        return Boolean.TRUE;
    }

    private void onStartTrackingTouch() {
        Iterator<T> it = this.touchListeners.iterator();
        while (it.hasNext()) {
            it.next().onStartTrackingTouch(this);
        }
    }

    private void onStopTrackingTouch() {
        Iterator<T> it = this.touchListeners.iterator();
        while (it.hasNext()) {
            it.next().onStopTrackingTouch(this);
        }
    }

    private void positionLabel(TooltipDrawable tooltipDrawable, float f) {
        calculateLabelBounds(tooltipDrawable, f);
        if (isVertical()) {
            RectF rectF = new RectF(this.labelRect);
            this.rotationMatrix.mapRect(rectF);
            rectF.round(this.labelRect);
        }
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, this.labelRect);
        tooltipDrawable.setBounds(this.labelRect);
    }

    private void processAttributes(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.Slider, i, DEF_STYLE_RES, new int[0]);
        setOrientation(obtainStyledAttributes.getInt(R.styleable.Slider_android_orientation, 0));
        this.labelStyle = obtainStyledAttributes.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip);
        this.valueFrom = obtainStyledAttributes.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.valueTo = obtainStyledAttributes.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setValues(Float.valueOf(this.valueFrom));
        setCentered(obtainStyledAttributes.getBoolean(R.styleable.Slider_centered, false));
        this.stepSize = obtainStyledAttributes.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        this.minTouchTargetSize = (int) Math.ceil(obtainStyledAttributes.getDimension(R.styleable.Slider_minTouchTargetSize, MaterialAttributes.resolveMinimumAccessibleTouchTarget(context)));
        boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.Slider_trackColor);
        int i6 = hasValue ? R.styleable.Slider_trackColor : R.styleable.Slider_trackColorInactive;
        int i10 = hasValue ? R.styleable.Slider_trackColor : R.styleable.Slider_trackColorActive;
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, i6);
        if (colorStateList == null) {
            colorStateList = AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_track_color);
        }
        setTrackInactiveTintList(colorStateList);
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i10);
        if (colorStateList2 == null) {
            colorStateList2 = AppCompatResources.getColorStateList(context, R.color.material_slider_active_track_color);
        }
        setTrackActiveTintList(colorStateList2);
        this.defaultThumbDrawable.setFillColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_thumbColor));
        if (obtainStyledAttributes.hasValue(R.styleable.Slider_thumbStrokeColor)) {
            setThumbStrokeColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_thumbStrokeColor));
        }
        setThumbStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_haloColor);
        if (colorStateList3 == null) {
            colorStateList3 = AppCompatResources.getColorStateList(context, R.color.material_slider_halo_color);
        }
        setHaloTintList(colorStateList3);
        this.tickVisibilityMode = obtainStyledAttributes.hasValue(R.styleable.Slider_tickVisibilityMode) ? obtainStyledAttributes.getInt(R.styleable.Slider_tickVisibilityMode, -1) : convertToTickVisibilityMode(obtainStyledAttributes.getBoolean(R.styleable.Slider_tickVisible, true));
        boolean hasValue2 = obtainStyledAttributes.hasValue(R.styleable.Slider_tickColor);
        int i11 = hasValue2 ? R.styleable.Slider_tickColor : R.styleable.Slider_tickColorInactive;
        int i12 = hasValue2 ? R.styleable.Slider_tickColor : R.styleable.Slider_tickColorActive;
        ColorStateList colorStateList4 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i11);
        if (colorStateList4 == null) {
            colorStateList4 = AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_tick_marks_color);
        }
        setTickInactiveTintList(colorStateList4);
        ColorStateList colorStateList5 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i12);
        if (colorStateList5 == null) {
            colorStateList5 = AppCompatResources.getColorStateList(context, R.color.material_slider_active_tick_marks_color);
        }
        setTickActiveTintList(colorStateList5);
        setThumbTrackGapSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbTrackGapSize, 0));
        setTrackStopIndicatorSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackStopIndicatorSize, 0));
        setTrackCornerSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackCornerSize, -1));
        setTrackInsideCornerSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackInsideCornerSize, 0));
        setTrackIconActiveStart(MaterialResources.getDrawable(context, obtainStyledAttributes, R.styleable.Slider_trackIconActiveStart));
        setTrackIconActiveEnd(MaterialResources.getDrawable(context, obtainStyledAttributes, R.styleable.Slider_trackIconActiveEnd));
        setTrackIconActiveColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_trackIconActiveColor));
        setTrackIconInactiveStart(MaterialResources.getDrawable(context, obtainStyledAttributes, R.styleable.Slider_trackIconInactiveStart));
        setTrackIconInactiveEnd(MaterialResources.getDrawable(context, obtainStyledAttributes, R.styleable.Slider_trackIconInactiveEnd));
        setTrackIconInactiveColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_trackIconInactiveColor));
        setTrackIconSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackIconSize, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0) * 2;
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbWidth, dimensionPixelSize);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbHeight, dimensionPixelSize);
        setThumbWidth(dimensionPixelSize2);
        setThumbHeight(dimensionPixelSize3);
        setHaloRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(obtainStyledAttributes.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        setTickActiveRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_tickRadiusActive, this.trackStopIndicatorSize / 2));
        setTickInactiveRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_tickRadiusInactive, this.trackStopIndicatorSize / 2));
        setLabelBehavior(obtainStyledAttributes.getInt(R.styleable.Slider_labelBehavior, 0));
        if (!obtainStyledAttributes.getBoolean(R.styleable.Slider_android_enabled, true)) {
            setEnabled(false);
        }
        obtainStyledAttributes.recycle();
    }

    private void scheduleAccessibilityEventSender(int i) {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.accessibilityEventSender;
        if (accessibilityEventSender == null) {
            this.accessibilityEventSender = new AccessibilityEventSender();
        } else {
            removeCallbacks(accessibilityEventSender);
        }
        this.accessibilityEventSender.setVirtualViewId(i);
        postDelayed(this.accessibilityEventSender, 200L);
    }

    private void setValueForLabel(TooltipDrawable tooltipDrawable, float f) {
        tooltipDrawable.setText(formatValue(f));
        positionLabel(tooltipDrawable, f);
        ViewOverlay contentViewOverlay = getContentViewOverlay();
        if (contentViewOverlay == null) {
            return;
        }
        contentViewOverlay.add(tooltipDrawable);
    }

    private void setValuesInternal(@NonNull ArrayList<Float> arrayList) {
        if (arrayList.isEmpty()) {
            com.google.gson.internal.a.p("At least one value must be set");
            return;
        }
        Collections.sort(arrayList);
        if (this.values.size() == arrayList.size() && this.values.equals(arrayList)) {
            return;
        }
        this.values = arrayList;
        this.dirtyConfig = true;
        this.focusedThumbIdx = 0;
        updateHaloHotspot();
        createLabelPool();
        dispatchOnChangedProgrammatically();
        postInvalidate();
    }

    private boolean shouldAlwaysShowLabel() {
        return this.labelBehavior == 3;
    }

    private boolean shouldDrawCompatHalo() {
        return this.forceDrawCompatHalo || !(getBackground() instanceof RippleDrawable);
    }

    private boolean snapActiveThumbToValue(float f) {
        return snapThumbToValue(this.activeThumbIdx, f);
    }

    private double snapPosition(float f) {
        float f10 = this.stepSize;
        if (f10 <= 0.0f) {
            return f;
        }
        return Math.round(f * r0) / ((int) ((this.valueTo - this.valueFrom) / f10));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean snapThumbToValue(int i, float f) {
        this.focusedThumbIdx = i;
        if (Math.abs(f - this.values.get(i).floatValue()) < THRESHOLD) {
            return false;
        }
        this.values.set(i, Float.valueOf(getClampedValue(i, f)));
        dispatchOnChangedFromUser(i);
        return true;
    }

    private boolean snapTouchPosition() {
        return snapActiveThumbToValue(getValueOfTouchPosition());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateHaloHotspot() {
        if (shouldDrawCompatHalo() || getMeasuredWidth() <= 0) {
            return;
        }
        Drawable background = getBackground();
        if (background instanceof RippleDrawable) {
            float normalizeValue = (normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * this.trackWidth) + this.trackSidePadding;
            int calculateTrackCenter = calculateTrackCenter();
            int i = this.haloRadius;
            float[] fArr = {normalizeValue - i, calculateTrackCenter - i, normalizeValue + i, calculateTrackCenter + i};
            if (isVertical()) {
                this.rotationMatrix.mapPoints(fArr);
            }
            background.setHotspotBounds((int) fArr[0], (int) fArr[1], (int) fArr[2], (int) fArr[3]);
        }
    }

    private void updateLabelPivots() {
        float f;
        boolean isVertical = isVertical();
        boolean isRtl = isRtl();
        float f10 = 0.5f;
        if (isVertical && isRtl) {
            f = 0.5f;
            f10 = -0.2f;
        } else {
            f = 1.2f;
            if (isVertical) {
                f10 = 1.2f;
                f = 0.5f;
            }
        }
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            it.next().setPivots(f10, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateLabels() {
        updateLabelPivots();
        int i = this.labelBehavior;
        if (i == 0 || i == 1) {
            if (this.activeThumbIdx == -1 || !isEnabled()) {
                ensureLabelsRemoved();
                return;
            } else {
                ensureLabelsAdded();
                return;
            }
        }
        if (i == 2) {
            ensureLabelsRemoved();
            return;
        }
        if (i != 3) {
            androidx.core.view.contentcapture.a.f(this.labelBehavior, "Unexpected labelBehavior: ");
        } else if (isEnabled() && isSliderVisibleOnScreen()) {
            ensureLabelsAdded();
        } else {
            ensureLabelsRemoved();
        }
    }

    private void updateRotationMatrix() {
        float calculateTrackCenter = calculateTrackCenter();
        this.rotationMatrix.reset();
        this.rotationMatrix.setRotate(90.0f, calculateTrackCenter, calculateTrackCenter);
    }

    private void updateThumbWidthWhenPressed() {
        if (hasGapBetweenThumbAndTrack()) {
            int i = this.thumbWidth;
            this.defaultThumbWidth = i;
            this.defaultThumbTrackGapSize = this.thumbTrackGapSize;
            int round = Math.round(i * 0.5f);
            int i6 = this.thumbWidth - round;
            setThumbWidth(round);
            setThumbTrackGapSize(this.thumbTrackGapSize - (i6 / 2));
        }
    }

    private void updateTicksCoordinates(int i) {
        if (i == 0) {
            this.ticksCoordinates = null;
            return;
        }
        float[] fArr = this.ticksCoordinates;
        if (fArr == null || fArr.length != i * 2) {
            this.ticksCoordinates = new float[i * 2];
        }
        float f = this.trackWidth / (i - 1);
        float calculateTrackCenter = calculateTrackCenter();
        for (int i6 = 0; i6 < i * 2; i6 += 2) {
            float[] fArr2 = this.ticksCoordinates;
            fArr2[i6] = ((i6 / 2.0f) * f) + this.trackSidePadding;
            fArr2[i6 + 1] = calculateTrackCenter;
        }
        if (isVertical()) {
            this.rotationMatrix.mapPoints(this.ticksCoordinates);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void updateTrack(android.graphics.Canvas r7, android.graphics.Paint r8, android.graphics.RectF r9, float r10, com.google.android.material.slider.BaseSlider.FullCornerDirection r11) {
        /*
            r6 = this;
            boolean r0 = r9.isEmpty()
            if (r0 == 0) goto L7
            return
        L7:
            float r0 = r6.calculateStartTrackCornerSize(r10)
            float r10 = r6.calculateEndTrackCornerSize(r10)
            int r1 = r11.ordinal()
            r2 = 2
            r3 = 1
            if (r1 == r3) goto L26
            if (r1 == r2) goto L22
            r4 = 3
            if (r1 == r4) goto L1d
            goto L29
        L1d:
            int r10 = r6.trackInsideCornerSize
            float r0 = (float) r10
        L20:
            float r10 = (float) r10
            goto L29
        L22:
            int r0 = r6.trackInsideCornerSize
            float r0 = (float) r0
            goto L29
        L26:
            int r10 = r6.trackInsideCornerSize
            goto L20
        L29:
            android.graphics.Paint$Style r1 = android.graphics.Paint.Style.FILL
            r8.setStyle(r1)
            android.graphics.Paint$Cap r1 = android.graphics.Paint.Cap.BUTT
            r8.setStrokeCap(r1)
            boolean r1 = r6.hasGapBetweenThumbAndTrack()
            if (r1 == 0) goto L3c
            r8.setAntiAlias(r3)
        L3c:
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>(r9)
            boolean r4 = r6.isVertical()
            if (r4 == 0) goto L4c
            android.graphics.Matrix r4 = r6.rotationMatrix
            r4.mapRect(r1)
        L4c:
            android.graphics.Path r4 = r6.trackPath
            r4.reset()
            float r4 = r9.width()
            float r5 = r0 + r10
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 < 0) goto L6c
            android.graphics.Path r9 = r6.trackPath
            float[] r10 = r6.getCornerRadii(r0, r10)
            android.graphics.Path$Direction r11 = android.graphics.Path.Direction.CW
            r9.addRoundRect(r1, r10, r11)
            android.graphics.Path r9 = r6.trackPath
            r7.drawPath(r9, r8)
            return
        L6c:
            float r4 = java.lang.Math.min(r0, r10)
            float r10 = java.lang.Math.max(r0, r10)
            r7.save()
            android.graphics.Path r0 = r6.trackPath
            android.graphics.Path$Direction r5 = android.graphics.Path.Direction.CW
            r0.addRoundRect(r1, r4, r4, r5)
            android.graphics.Path r0 = r6.trackPath
            r7.clipPath(r0)
            int r11 = r11.ordinal()
            r0 = 1073741824(0x40000000, float:2.0)
            if (r11 == r3) goto Lae
            android.graphics.RectF r1 = r6.cornerRect
            if (r11 == r2) goto La1
            float r11 = r9.centerX()
            float r11 = r11 - r10
            float r0 = r9.top
            float r2 = r9.centerX()
            float r2 = r2 + r10
            float r9 = r9.bottom
            r1.set(r11, r0, r2, r9)
            goto Lbb
        La1:
            float r11 = r9.right
            float r0 = r0 * r10
            float r0 = r11 - r0
            float r2 = r9.top
            float r9 = r9.bottom
            r1.set(r0, r2, r11, r9)
            goto Lbb
        Lae:
            android.graphics.RectF r11 = r6.cornerRect
            float r1 = r9.left
            float r2 = r9.top
            float r0 = r0 * r10
            float r0 = r0 + r1
            float r9 = r9.bottom
            r11.set(r1, r2, r0, r9)
        Lbb:
            boolean r9 = r6.isVertical()
            if (r9 == 0) goto Lc8
            android.graphics.Matrix r9 = r6.rotationMatrix
            android.graphics.RectF r11 = r6.cornerRect
            r9.mapRect(r11)
        Lc8:
            android.graphics.RectF r9 = r6.cornerRect
            r7.drawRoundRect(r9, r10, r10, r8)
            r7.restore()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.updateTrack(android.graphics.Canvas, android.graphics.Paint, android.graphics.RectF, float, com.google.android.material.slider.BaseSlider$FullCornerDirection):void");
    }

    private void updateTrackIconActiveEnd() {
        Drawable drawable = this.trackIconActiveEnd;
        if (drawable != null) {
            if (!this.trackIconActiveEndMutated && this.trackIconActiveColor != null) {
                this.trackIconActiveEnd = DrawableCompat.wrap(drawable).mutate();
                this.trackIconActiveEndMutated = true;
            }
            if (this.trackIconActiveEndMutated) {
                this.trackIconActiveEnd.setTintList(this.trackIconActiveColor);
            }
        }
    }

    private void updateTrackIconActiveStart() {
        Drawable drawable = this.trackIconActiveStart;
        if (drawable != null) {
            if (!this.trackIconActiveStartMutated && this.trackIconActiveColor != null) {
                this.trackIconActiveStart = DrawableCompat.wrap(drawable).mutate();
                this.trackIconActiveStartMutated = true;
            }
            if (this.trackIconActiveStartMutated) {
                this.trackIconActiveStart.setTintList(this.trackIconActiveColor);
            }
        }
    }

    private void updateTrackIconInactiveEnd() {
        Drawable drawable = this.trackIconInactiveEnd;
        if (drawable != null) {
            if (!this.trackIconInactiveEndMutated && this.trackIconInactiveColor != null) {
                this.trackIconInactiveEnd = DrawableCompat.wrap(drawable).mutate();
                this.trackIconInactiveEndMutated = true;
            }
            if (this.trackIconInactiveEndMutated) {
                this.trackIconInactiveEnd.setTintList(this.trackIconInactiveColor);
            }
        }
    }

    private void updateTrackIconInactiveStart() {
        Drawable drawable = this.trackIconInactiveStart;
        if (drawable != null) {
            if (!this.trackIconInactiveStartMutated && this.trackIconInactiveColor != null) {
                this.trackIconInactiveStart = DrawableCompat.wrap(drawable).mutate();
                this.trackIconInactiveStartMutated = true;
            }
            if (this.trackIconInactiveStartMutated) {
                this.trackIconInactiveStart.setTintList(this.trackIconInactiveColor);
            }
        }
    }

    private void updateTrackWidth(int i) {
        this.trackWidth = Math.max(i - (this.trackSidePadding * 2), 0);
        updateTicksCoordinates();
    }

    private void updateWidgetLayout(boolean z9) {
        boolean maybeIncreaseWidgetThickness = maybeIncreaseWidgetThickness();
        boolean maybeIncreaseTrackSidePadding = maybeIncreaseTrackSidePadding();
        if (isVertical()) {
            updateRotationMatrix();
        }
        if (maybeIncreaseWidgetThickness || z9) {
            requestLayout();
        } else if (maybeIncreaseTrackSidePadding) {
            postInvalidate();
        }
    }

    private void validateConfigurationIfDirty() {
        if (this.dirtyConfig) {
            validateValues();
            validateStepSize();
            validateMinSeparation();
            warnAboutFloatingPointError();
            this.dirtyConfig = false;
        }
    }

    private void validateMinSeparation() {
        float minSeparation = getMinSeparation();
        if (minSeparation < 0.0f) {
            throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal to 0");
        }
        float f = this.stepSize;
        if (f <= 0.0f || minSeparation <= 0.0f) {
            return;
        }
        if (this.separationUnit != 1) {
            throw new IllegalStateException("minSeparation(" + minSeparation + ") cannot be set as a dimension when using stepSize(" + this.stepSize + ")");
        }
        if (minSeparation < f || !isMultipleOfStepSize(minSeparation)) {
            throw new IllegalStateException("minSeparation(" + minSeparation + ") must be greater or equal and a multiple of stepSize(" + this.stepSize + ") when using stepSize(" + this.stepSize + ")");
        }
    }

    private void validateStepSize() {
        if (this.stepSize <= 0.0f || valueLandsOnTick(this.valueTo)) {
            return;
        }
        throw new IllegalStateException("The stepSize(" + this.stepSize + ") must be 0, or a factor of the valueFrom(" + this.valueFrom + ")-valueTo(" + this.valueTo + ") range");
    }

    private void validateValues() {
        float f = this.valueFrom;
        if (f >= this.valueTo) {
            throw new IllegalStateException("valueFrom(" + f + ") must be smaller than valueTo(" + this.valueTo + ")");
        }
        ArrayList<Float> arrayList = this.values;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Float f10 = arrayList.get(i);
            i++;
            Float f11 = f10;
            if (f11.floatValue() < this.valueFrom || f11.floatValue() > this.valueTo) {
                throw new IllegalStateException("Slider value(" + f11 + ") must be greater or equal to valueFrom(" + this.valueFrom + "), and lower or equal to valueTo(" + this.valueTo + ")");
            }
            if (this.stepSize > 0.0f && !valueLandsOnTick(f11.floatValue())) {
                throw new IllegalStateException("Value(" + f11 + ") must be equal to valueFrom(" + this.valueFrom + ") plus a multiple of stepSize(" + this.stepSize + ") when using stepSize(" + this.stepSize + ")");
            }
        }
    }

    private boolean valueLandsOnTick(float f) {
        return isMultipleOfStepSize(new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Float.toString(this.valueFrom)), MathContext.DECIMAL64).doubleValue());
    }

    private float valueToX(float f) {
        return (normalizeValue(f) * this.trackWidth) + this.trackSidePadding;
    }

    private void warnAboutFloatingPointError() {
        float f = this.stepSize;
        if (f == 0.0f) {
            return;
        }
        if (((int) f) != f) {
            Log.w(TAG, "Floating point value used for stepSize(" + f + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
        }
        float f10 = this.valueFrom;
        if (((int) f10) != f10) {
            Log.w(TAG, "Floating point value used for valueFrom(" + f10 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
        }
        float f11 = this.valueTo;
        if (((int) f11) != f11) {
            Log.w(TAG, "Floating point value used for valueTo(" + f11 + "). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.");
        }
    }

    public void addOnChangeListener(@NonNull L l10) {
        this.changeListeners.add(l10);
    }

    public void addOnSliderTouchListener(@NonNull T t9) {
        this.touchListeners.add(t9);
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(@NonNull MotionEvent motionEvent) {
        return this.accessibilityHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        this.stopIndicatorPaint.setColor(getColorForState(this.tickColorInactive));
        for (TooltipDrawable tooltipDrawable : this.labels) {
            if (tooltipDrawable.isStateful()) {
                tooltipDrawable.setState(getDrawableState());
            }
        }
        if (this.defaultThumbDrawable.isStateful()) {
            this.defaultThumbDrawable.setState(getDrawableState());
        }
        this.haloPaint.setColor(getColorForState(this.haloColor));
        this.haloPaint.setAlpha(63);
    }

    @VisibleForTesting
    public void forceDrawCompatHalo(boolean z9) {
        this.forceDrawCompatHalo = z9;
    }

    @Override // android.view.View
    @NonNull
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    @VisibleForTesting
    public final int getAccessibilityFocusedVirtualViewId() {
        return this.accessibilityHelper.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    @Px
    public int getHaloRadius() {
        return this.haloRadius;
    }

    @NonNull
    public ColorStateList getHaloTintList() {
        return this.haloColor;
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    public float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public float getThumbElevation() {
        return this.defaultThumbDrawable.getElevation();
    }

    @Px
    public int getThumbHeight() {
        return this.thumbHeight;
    }

    @Px
    public int getThumbRadius() {
        return this.thumbWidth / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.defaultThumbDrawable.getStrokeColor();
    }

    public float getThumbStrokeWidth() {
        return this.defaultThumbDrawable.getStrokeWidth();
    }

    @NonNull
    public ColorStateList getThumbTintList() {
        return this.defaultThumbDrawable.getFillColor();
    }

    public int getThumbTrackGapSize() {
        return this.thumbTrackGapSize;
    }

    @Px
    public int getThumbWidth() {
        return this.thumbWidth;
    }

    @Px
    public int getTickActiveRadius() {
        return this.tickActiveRadius;
    }

    @NonNull
    public ColorStateList getTickActiveTintList() {
        return this.tickColorActive;
    }

    @Px
    public int getTickInactiveRadius() {
        return this.tickInactiveRadius;
    }

    @NonNull
    public ColorStateList getTickInactiveTintList() {
        return this.tickColorInactive;
    }

    @NonNull
    public ColorStateList getTickTintList() {
        if (this.tickColorInactive.equals(this.tickColorActive)) {
            return this.tickColorActive;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
        return null;
    }

    public int getTickVisibilityMode() {
        return this.tickVisibilityMode;
    }

    @NonNull
    public ColorStateList getTrackActiveTintList() {
        return this.trackColorActive;
    }

    @Px
    public int getTrackCornerSize() {
        int i = this.trackCornerSize;
        return i == -1 ? this.trackThickness / 2 : i;
    }

    @Px
    public int getTrackHeight() {
        return this.trackThickness;
    }

    @Nullable
    public ColorStateList getTrackIconActiveColor() {
        return this.trackIconActiveColor;
    }

    @Nullable
    public Drawable getTrackIconActiveEnd() {
        return this.trackIconActiveEnd;
    }

    @Nullable
    public Drawable getTrackIconActiveStart() {
        return this.trackIconActiveStart;
    }

    @Nullable
    public ColorStateList getTrackIconInactiveColor() {
        return this.trackIconInactiveColor;
    }

    @Nullable
    public Drawable getTrackIconInactiveEnd() {
        return this.trackIconInactiveEnd;
    }

    @Nullable
    public Drawable getTrackIconInactiveStart() {
        return this.trackIconInactiveStart;
    }

    public int getTrackIconSize() {
        return this.trackIconSize;
    }

    @NonNull
    public ColorStateList getTrackInactiveTintList() {
        return this.trackColorInactive;
    }

    public int getTrackInsideCornerSize() {
        return this.trackInsideCornerSize;
    }

    @Px
    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    public int getTrackStopIndicatorSize() {
        return this.trackStopIndicatorSize;
    }

    @NonNull
    public ColorStateList getTrackTintList() {
        if (this.trackColorInactive.equals(this.trackColorActive)) {
            return this.trackColorActive;
        }
        androidx.privacysandbox.ads.adservices.customaudience.a.i("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
        return null;
    }

    @Px
    public int getTrackWidth() {
        return this.trackWidth;
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public float getValueTo() {
        return this.valueTo;
    }

    @NonNull
    public List<Float> getValues() {
        return new ArrayList(this.values);
    }

    public boolean hasLabelFormatter() {
        return this.formatter != null;
    }

    public boolean isCentered() {
        return this.centered;
    }

    public final boolean isRtl() {
        return getLayoutDirection() == 1;
    }

    public boolean isTickVisible() {
        int i = this.tickVisibilityMode;
        if (i == 0) {
            return true;
        }
        if (i == 1) {
            return getDesiredTickCount() <= getMaxTickCount();
        }
        if (i == 2) {
            return false;
        }
        com.google.gson.internal.a.f(this.tickVisibilityMode, "Unexpected tickVisibilityMode: ");
        return false;
    }

    public boolean isVertical() {
        return this.widgetOrientation == 1;
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.thisAndAncestorsVisible = isShown();
        getViewTreeObserver().addOnScrollChangedListener(this.onScrollChangedListener);
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            attachLabelToContentView(it.next());
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender = this.accessibilityEventSender;
        if (accessibilityEventSender != null) {
            removeCallbacks(accessibilityEventSender);
        }
        this.labelsAreAnimatedIn = false;
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            detachLabelFromContentView(it.next());
        }
        getViewTreeObserver().removeOnScrollChangedListener(this.onScrollChangedListener);
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        if (this.dirtyConfig) {
            validateConfigurationIfDirty();
            updateTicksCoordinates();
        }
        super.onDraw(canvas);
        int calculateTrackCenter = calculateTrackCenter();
        drawInactiveTracks(canvas, this.trackWidth, calculateTrackCenter);
        drawActiveTracks(canvas, this.trackWidth, calculateTrackCenter);
        if (isRtl() || isVertical()) {
            drawTrackIcons(canvas, this.activeTrackRect, this.inactiveTrackLeftRect);
        } else {
            drawTrackIcons(canvas, this.activeTrackRect, this.inactiveTrackRightRect);
        }
        maybeDrawTicks(canvas);
        maybeDrawStopIndicator(canvas, calculateTrackCenter);
        if ((this.thumbIsPressed || isFocused()) && isEnabled()) {
            maybeDrawCompatHalo(canvas, this.trackWidth, calculateTrackCenter);
        }
        updateLabels();
        drawThumbs(canvas, this.trackWidth, calculateTrackCenter);
    }

    @Override // android.view.View
    public void onFocusChanged(boolean z9, int i, @Nullable Rect rect) {
        super.onFocusChanged(z9, i, rect);
        if (z9) {
            focusThumbOnFocusGained(i);
            this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
        } else {
            this.activeThumbIdx = -1;
            this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setVisibleToUser(false);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, @NonNull KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.values.size() == 1) {
            this.activeThumbIdx = 0;
        }
        if (this.activeThumbIdx == -1) {
            Boolean onKeyDownNoActiveThumb = onKeyDownNoActiveThumb(i, keyEvent);
            return onKeyDownNoActiveThumb != null ? onKeyDownNoActiveThumb.booleanValue() : super.onKeyDown(i, keyEvent);
        }
        this.isLongPress |= keyEvent.isLongPress();
        Float calculateIncrementForKey = calculateIncrementForKey(i);
        if (calculateIncrementForKey != null) {
            if (snapActiveThumbToValue(calculateIncrementForKey.floatValue() + this.values.get(this.activeThumbIdx).floatValue())) {
                updateHaloHotspot();
                postInvalidate();
            }
            return true;
        }
        if (i != 23) {
            if (i == 61) {
                if (keyEvent.hasNoModifiers()) {
                    return moveFocus(1);
                }
                if (keyEvent.isShiftPressed()) {
                    return moveFocus(-1);
                }
                return false;
            }
            if (i != 66) {
                return super.onKeyDown(i, keyEvent);
            }
        }
        this.activeThumbIdx = -1;
        postInvalidate();
        return true;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, @NonNull KeyEvent keyEvent) {
        this.isLongPress = false;
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i6) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.widgetThickness + ((this.labelBehavior == 1 || shouldAlwaysShowLabel()) ? this.labels.get(0).getIntrinsicHeight() : 0), BasicMeasure.EXACTLY);
        if (isVertical()) {
            super.onMeasure(makeMeasureSpec, i6);
        } else {
            super.onMeasure(i, makeMeasureSpec);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.valueFrom = sliderState.valueFrom;
        this.valueTo = sliderState.valueTo;
        setValuesInternal(sliderState.values);
        this.stepSize = sliderState.stepSize;
        if (sliderState.hasFocus) {
            requestFocus();
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.valueFrom = this.valueFrom;
        sliderState.valueTo = this.valueTo;
        sliderState.values = new ArrayList<>(this.values);
        sliderState.stepSize = this.stepSize;
        sliderState.hasFocus = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i6, int i10, int i11) {
        if (isVertical()) {
            i = i6;
        }
        updateTrackWidth(i);
        updateHaloHotspot();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004d, code lost:
    
        if (r3 != 3) goto L78;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(@androidx.annotation.NonNull android.view.MotionEvent r7) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.slider.BaseSlider.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z9) {
        super.onVisibilityAggregated(z9);
        this.thisAndAncestorsVisible = z9;
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        ViewOverlay contentViewOverlay;
        super.onVisibilityChanged(view, i);
        if (i == 0 || (contentViewOverlay = getContentViewOverlay()) == null) {
            return;
        }
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            contentViewOverlay.remove(it.next());
        }
    }

    public boolean pickActiveThumb() {
        if (this.activeThumbIdx != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float valueToX = valueToX(valueOfTouchPositionAbsolute);
        this.activeThumbIdx = 0;
        float abs = Math.abs(this.values.get(0).floatValue() - valueOfTouchPositionAbsolute);
        for (int i = 1; i < this.values.size(); i++) {
            float abs2 = Math.abs(this.values.get(i).floatValue() - valueOfTouchPositionAbsolute);
            float valueToX2 = valueToX(this.values.get(i).floatValue());
            if (Float.compare(abs2, abs) > 0) {
                break;
            }
            boolean z9 = isRtl() || isVertical() ? valueToX2 - valueToX > 0.0f : valueToX2 - valueToX < 0.0f;
            if (Float.compare(abs2, abs) < 0) {
                this.activeThumbIdx = i;
            } else {
                if (Float.compare(abs2, abs) != 0) {
                    continue;
                } else {
                    if (Math.abs(valueToX2 - valueToX) < this.scaledTouchSlop) {
                        this.activeThumbIdx = -1;
                        return false;
                    }
                    if (z9) {
                        this.activeThumbIdx = i;
                    }
                }
            }
            abs = abs2;
        }
        return this.activeThumbIdx != -1;
    }

    public void removeOnChangeListener(@NonNull L l10) {
        this.changeListeners.remove(l10);
    }

    public void removeOnSliderTouchListener(@NonNull T t9) {
        this.touchListeners.remove(t9);
    }

    public void scheduleTooltipTimeout() {
        removeCallbacks(this.resetActiveThumbIndex);
        postDelayed(this.resetActiveThumbIndex, this.tooltipTimeoutMillis);
    }

    public void setActiveThumbIndex(int i) {
        this.activeThumbIdx = i;
    }

    public void setCentered(boolean z9) {
        if (this.centered == z9) {
            return;
        }
        this.centered = z9;
        float f = this.valueFrom;
        if (z9) {
            setValues(Float.valueOf((f + this.valueTo) / 2.0f));
        } else {
            setValues(Float.valueOf(f));
        }
        updateWidgetLayout(true);
    }

    public void setCustomThumbDrawable(@NonNull Drawable drawable) {
        this.customThumbDrawable = initializeCustomThumbDrawable(drawable);
        this.customThumbDrawablesForValues.clear();
        postInvalidate();
    }

    public void setCustomThumbDrawablesForValues(@NonNull Drawable... drawableArr) {
        this.customThumbDrawable = null;
        this.customThumbDrawablesForValues = new ArrayList();
        for (Drawable drawable : drawableArr) {
            this.customThumbDrawablesForValues.add(initializeCustomThumbDrawable(drawable));
        }
        postInvalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z9) {
        super.setEnabled(z9);
        setLayerType(z9 ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i) {
        if (i < 0 || i >= this.values.size()) {
            com.google.gson.internal.a.p("index out of range");
            return;
        }
        this.focusedThumbIdx = i;
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(i);
        postInvalidate();
    }

    public void setHaloRadius(@IntRange(from = 0) @Px int i) {
        if (i == this.haloRadius) {
            return;
        }
        this.haloRadius = i;
        Drawable background = getBackground();
        if (shouldDrawCompatHalo() || !(background instanceof RippleDrawable)) {
            postInvalidate();
        } else {
            DrawableUtils.setRippleDrawableRadius((RippleDrawable) background, this.haloRadius);
        }
    }

    public void setHaloRadiusResource(@DimenRes int i) {
        setHaloRadius(getResources().getDimensionPixelSize(i));
    }

    public void setHaloTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.haloColor)) {
            return;
        }
        this.haloColor = colorStateList;
        Drawable background = getBackground();
        if (!shouldDrawCompatHalo() && (background instanceof RippleDrawable)) {
            ((RippleDrawable) background).setColor(colorStateList);
            return;
        }
        this.haloPaint.setColor(getColorForState(colorStateList));
        this.haloPaint.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i) {
        if (this.labelBehavior != i) {
            this.labelBehavior = i;
            updateWidgetLayout(true);
        }
    }

    public void setLabelFormatter(@Nullable LabelFormatter labelFormatter) {
        this.formatter = labelFormatter;
    }

    public void setOrientation(int i) {
        if (this.widgetOrientation == i) {
            return;
        }
        this.widgetOrientation = i;
        updateWidgetLayout(true);
    }

    public void setSeparationUnit(int i) {
        this.separationUnit = i;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setStepSize(float f) {
        if (f >= 0.0f) {
            if (this.stepSize != f) {
                this.stepSize = f;
                this.dirtyConfig = true;
                postInvalidate();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("The stepSize(" + f + ") must be 0, or a factor of the valueFrom(" + this.valueFrom + ")-valueTo(" + this.valueTo + ") range");
    }

    public void setThumbElevation(float f) {
        this.defaultThumbDrawable.setElevation(f);
    }

    public void setThumbElevationResource(@DimenRes int i) {
        setThumbElevation(getResources().getDimension(i));
    }

    public void setThumbHeight(@IntRange(from = 0) @Px int i) {
        if (i == this.thumbHeight) {
            return;
        }
        this.thumbHeight = i;
        this.defaultThumbDrawable.setBounds(0, 0, this.thumbWidth, i);
        Drawable drawable = this.customThumbDrawable;
        if (drawable != null) {
            adjustCustomThumbDrawableBounds(drawable);
        }
        Iterator<Drawable> it = this.customThumbDrawablesForValues.iterator();
        while (it.hasNext()) {
            adjustCustomThumbDrawableBounds(it.next());
        }
        updateWidgetLayout(false);
    }

    public void setThumbHeightResource(@DimenRes int i) {
        setThumbHeight(getResources().getDimensionPixelSize(i));
    }

    public void setThumbRadius(@IntRange(from = 0) @Px int i) {
        int i6 = i * 2;
        setThumbWidth(i6);
        setThumbHeight(i6);
    }

    public void setThumbRadiusResource(@DimenRes int i) {
        setThumbRadius(getResources().getDimensionPixelSize(i));
    }

    public void setThumbStrokeColor(@Nullable ColorStateList colorStateList) {
        this.defaultThumbDrawable.setStrokeColor(colorStateList);
        postInvalidate();
    }

    public void setThumbStrokeColorResource(@ColorRes int i) {
        if (i != 0) {
            setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setThumbStrokeWidth(float f) {
        this.defaultThumbDrawable.setStrokeWidth(f);
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(@DimenRes int i) {
        if (i != 0) {
            setThumbStrokeWidth(getResources().getDimension(i));
        }
    }

    public void setThumbTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.defaultThumbDrawable.getFillColor())) {
            return;
        }
        this.defaultThumbDrawable.setFillColor(colorStateList);
        invalidate();
    }

    public void setThumbTrackGapSize(@Px int i) {
        if (this.thumbTrackGapSize == i) {
            return;
        }
        this.thumbTrackGapSize = i;
        invalidate();
    }

    public void setThumbWidth(@IntRange(from = 0) @Px int i) {
        if (i == this.thumbWidth) {
            return;
        }
        this.thumbWidth = i;
        this.defaultThumbDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, this.thumbWidth / 2.0f).build());
        this.defaultThumbDrawable.setBounds(0, 0, this.thumbWidth, this.thumbHeight);
        Drawable drawable = this.customThumbDrawable;
        if (drawable != null) {
            adjustCustomThumbDrawableBounds(drawable);
        }
        Iterator<Drawable> it = this.customThumbDrawablesForValues.iterator();
        while (it.hasNext()) {
            adjustCustomThumbDrawableBounds(it.next());
        }
        updateWidgetLayout(false);
    }

    public void setThumbWidthResource(@DimenRes int i) {
        setThumbWidth(getResources().getDimensionPixelSize(i));
    }

    public void setTickActiveRadius(@IntRange(from = 0) @Px int i) {
        if (this.tickActiveRadius != i) {
            this.tickActiveRadius = i;
            this.activeTicksPaint.setStrokeWidth(i * 2);
            updateWidgetLayout(false);
        }
    }

    public void setTickActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.tickColorActive)) {
            return;
        }
        this.tickColorActive = colorStateList;
        this.activeTicksPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTickInactiveRadius(@IntRange(from = 0) @Px int i) {
        if (this.tickInactiveRadius != i) {
            this.tickInactiveRadius = i;
            this.inactiveTicksPaint.setStrokeWidth(i * 2);
            updateWidgetLayout(false);
        }
    }

    public void setTickInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.tickColorInactive)) {
            return;
        }
        this.tickColorInactive = colorStateList;
        this.inactiveTicksPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTickTintList(@NonNull ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisibilityMode(int i) {
        if (this.tickVisibilityMode != i) {
            this.tickVisibilityMode = i;
            postInvalidate();
        }
    }

    @Deprecated
    public void setTickVisible(boolean z9) {
        setTickVisibilityMode(convertToTickVisibilityMode(z9));
    }

    public void setTrackActiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.trackColorActive)) {
            return;
        }
        this.trackColorActive = colorStateList;
        this.activeTrackPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTrackCornerSize(@Px int i) {
        if (this.trackCornerSize == i) {
            return;
        }
        this.trackCornerSize = i;
        invalidate();
    }

    public void setTrackHeight(@IntRange(from = 0) @Px int i) {
        if (this.trackThickness != i) {
            this.trackThickness = i;
            invalidateTrack();
            updateWidgetLayout(false);
        }
    }

    public void setTrackIconActiveColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList == this.trackIconActiveColor) {
            return;
        }
        this.trackIconActiveColor = colorStateList;
        updateTrackIconActiveStart();
        updateTrackIconActiveEnd();
        invalidate();
    }

    public void setTrackIconActiveEnd(@Nullable Drawable drawable) {
        if (drawable == this.trackIconActiveEnd) {
            return;
        }
        this.trackIconActiveEnd = drawable;
        this.trackIconActiveEndMutated = false;
        updateTrackIconActiveEnd();
        invalidate();
    }

    public void setTrackIconActiveStart(@Nullable Drawable drawable) {
        if (drawable == this.trackIconActiveStart) {
            return;
        }
        this.trackIconActiveStart = drawable;
        this.trackIconActiveStartMutated = false;
        updateTrackIconActiveStart();
        invalidate();
    }

    public void setTrackIconInactiveColor(@Nullable ColorStateList colorStateList) {
        if (colorStateList == this.trackIconInactiveColor) {
            return;
        }
        this.trackIconInactiveColor = colorStateList;
        updateTrackIconInactiveStart();
        updateTrackIconInactiveEnd();
        invalidate();
    }

    public void setTrackIconInactiveEnd(@Nullable Drawable drawable) {
        if (drawable == this.trackIconInactiveEnd) {
            return;
        }
        this.trackIconInactiveEnd = drawable;
        this.trackIconInactiveEndMutated = false;
        updateTrackIconInactiveEnd();
        invalidate();
    }

    public void setTrackIconInactiveStart(@Nullable Drawable drawable) {
        if (drawable == this.trackIconInactiveStart) {
            return;
        }
        this.trackIconInactiveStart = drawable;
        this.trackIconInactiveStartMutated = false;
        updateTrackIconInactiveStart();
        invalidate();
    }

    public void setTrackIconSize(@Px int i) {
        if (this.trackIconSize == i) {
            return;
        }
        this.trackIconSize = i;
        invalidate();
    }

    public void setTrackInactiveTintList(@NonNull ColorStateList colorStateList) {
        if (colorStateList.equals(this.trackColorInactive)) {
            return;
        }
        this.trackColorInactive = colorStateList;
        this.inactiveTrackPaint.setColor(getColorForState(colorStateList));
        invalidate();
    }

    public void setTrackInsideCornerSize(@Px int i) {
        if (this.trackInsideCornerSize == i) {
            return;
        }
        this.trackInsideCornerSize = i;
        invalidate();
    }

    public void setTrackStopIndicatorSize(@Px int i) {
        if (this.trackStopIndicatorSize == i) {
            return;
        }
        this.trackStopIndicatorSize = i;
        this.stopIndicatorPaint.setStrokeWidth(i);
        invalidate();
    }

    public void setTrackTintList(@NonNull ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f) {
        this.valueFrom = f;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValueTo(float f) {
        this.valueTo = f;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValues(@NonNull Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    public void updateBoundsForVirtualViewId(int i, Rect rect) {
        int normalizeValue = this.trackSidePadding + ((int) (normalizeValue(getValues().get(i).floatValue()) * this.trackWidth));
        int calculateTrackCenter = calculateTrackCenter();
        int max = Math.max(this.thumbWidth / 2, this.minTouchTargetSize / 2);
        int max2 = Math.max(this.thumbHeight / 2, this.minTouchTargetSize / 2);
        RectF rectF = new RectF(normalizeValue - max, calculateTrackCenter - max2, normalizeValue + max, calculateTrackCenter + max2);
        if (isVertical()) {
            this.rotationMatrix.mapRect(rectF);
        }
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }

    public void setValues(@NonNull List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }

    public void setCustomThumbDrawable(@DrawableRes int i) {
        setCustomThumbDrawable(getResources().getDrawable(i));
    }

    public void setTrackIconActiveEnd(@DrawableRes int i) {
        setTrackIconActiveEnd(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setTrackIconActiveStart(@DrawableRes int i) {
        setTrackIconActiveStart(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setTrackIconInactiveEnd(@DrawableRes int i) {
        setTrackIconInactiveEnd(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setTrackIconInactiveStart(@DrawableRes int i) {
        setTrackIconInactiveStart(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    private float calculateStepIncrement() {
        float f = this.stepSize;
        if (f == 0.0f) {
            return 1.0f;
        }
        return f;
    }

    public void setCustomThumbDrawablesForValues(@NonNull @DrawableRes int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            drawableArr[i] = getResources().getDrawable(iArr[i]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new Parcelable.Creator<SliderState>() { // from class: com.google.android.material.slider.BaseSlider.SliderState.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SliderState createFromParcel(@NonNull Parcel parcel) {
                return new SliderState(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            @NonNull
            public SliderState[] newArray(int i) {
                return new SliderState[i];
            }
        };
        boolean hasFocus;
        float stepSize;
        float valueFrom;
        float valueTo;
        ArrayList<Float> values;

        private SliderState(@NonNull Parcel parcel) {
            super(parcel);
            this.valueFrom = parcel.readFloat();
            this.valueTo = parcel.readFloat();
            ArrayList<Float> arrayList = new ArrayList<>();
            this.values = arrayList;
            parcel.readList(arrayList, Float.class.getClassLoader());
            this.stepSize = parcel.readFloat();
            this.hasFocus = parcel.createBooleanArray()[0];
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.valueFrom);
            parcel.writeFloat(this.valueTo);
            parcel.writeList(this.values);
            parcel.writeFloat(this.stepSize);
            parcel.writeBooleanArray(new boolean[]{this.hasFocus});
        }

        public SliderState(Parcelable parcelable) {
            super(parcelable);
        }
    }

    private void updateTicksCoordinates() {
        validateConfigurationIfDirty();
        int i = 0;
        if (this.stepSize <= 0.0f) {
            updateTicksCoordinates(0);
            return;
        }
        int i6 = this.tickVisibilityMode;
        if (i6 == 0) {
            i = Math.min(getDesiredTickCount(), getMaxTickCount());
        } else if (i6 == 1) {
            int desiredTickCount = getDesiredTickCount();
            if (desiredTickCount <= getMaxTickCount()) {
                i = desiredTickCount;
            }
        } else if (i6 != 2) {
            com.google.gson.internal.a.f(this.tickVisibilityMode, "Unexpected tickVisibilityMode: ");
            return;
        }
        updateTicksCoordinates(i);
    }

    public BaseSlider(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    public BaseSlider(@NonNull Context context) {
        this(context, null);
    }
}
