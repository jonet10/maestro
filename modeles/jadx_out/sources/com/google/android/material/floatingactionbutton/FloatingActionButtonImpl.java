package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
class FloatingActionButtonImpl {
    static final int ANIM_STATE_HIDING = 1;
    static final int ANIM_STATE_NONE = 0;
    static final int ANIM_STATE_SHOWING = 2;
    static final long ELEVATION_ANIM_DELAY = 100;
    static final long ELEVATION_ANIM_DURATION = 100;
    private static final float HIDE_ICON_SCALE = 0.4f;
    private static final float HIDE_OPACITY = 0.0f;
    private static final float HIDE_SCALE = 0.4f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    private static final float SHOW_ICON_SCALE = 1.0f;
    private static final float SHOW_OPACITY = 1.0f;
    private static final float SHOW_SCALE = 1.0f;
    private static final float SPEC_HIDE_ICON_SCALE = 0.0f;
    private static final float SPEC_HIDE_SCALE = 0.0f;

    @Nullable
    BorderDrawable borderDrawable;

    @Nullable
    Drawable contentBackground;

    @Nullable
    private Animator currentAnimator;
    float elevation;
    boolean ensureMinTouchTargetSize;
    private ArrayList<Animator.AnimatorListener> hideListeners;

    @Nullable
    private MotionSpec hideMotionSpec;
    float hoveredFocusedTranslationZ;
    private int maxImageSize;
    int minTouchTargetSize;

    @Nullable
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    float pressedTranslationZ;

    @Nullable
    Drawable rippleDrawable;
    final ShadowViewDelegate shadowViewDelegate;

    @Nullable
    ShapeAppearanceModel shapeAppearance;

    @Nullable
    MaterialShapeDrawable shapeDrawable;
    private ArrayList<Animator.AnimatorListener> showListeners;

    @Nullable
    private MotionSpec showMotionSpec;

    @Nullable
    private StateListAnimator stateListAnimator;
    private ArrayList<InternalTransformationCallback> transformationCallbacks;
    final FloatingActionButton view;
    static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    private static final int SHOW_ANIM_DURATION_ATTR = R.attr.motionDurationLong2;
    private static final int SHOW_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
    private static final int HIDE_ANIM_DURATION_ATTR = R.attr.motionDurationMedium1;
    private static final int HIDE_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    static final int[] PRESSED_ENABLED_STATE_SET = {android.R.attr.state_pressed, android.R.attr.state_enabled};
    static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = {android.R.attr.state_hovered, android.R.attr.state_focused, android.R.attr.state_enabled};
    static final int[] FOCUSED_ENABLED_STATE_SET = {android.R.attr.state_focused, android.R.attr.state_enabled};
    static final int[] HOVERED_ENABLED_STATE_SET = {android.R.attr.state_hovered, android.R.attr.state_enabled};
    static final int[] ENABLED_STATE_SET = {android.R.attr.state_enabled};
    static final int[] EMPTY_STATE_SET = new int[0];
    boolean shadowPaddingEnabled = true;
    private float imageMatrixScale = 1.0f;
    private int animState = 0;
    private final Rect tmpRect = new Rect();
    private final RectF tmpRectF1 = new RectF();
    private final RectF tmpRectF2 = new RectF();
    private final Matrix tmpMatrix = new Matrix();

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        public AlwaysStatefulMaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel) {
            super(shapeAppearanceModel);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface InternalTransformationCallback {
        void onScaleChanged();

        void onTranslationChanged();
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    public FloatingActionButtonImpl(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        this.view = floatingActionButton;
        this.shadowViewDelegate = shadowViewDelegate;
    }

    private void calculateImageMatrixFromScale(float f, @NonNull Matrix matrix) {
        matrix.reset();
        if (this.view.getDrawable() == null || this.maxImageSize == 0) {
            return;
        }
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        int i = this.maxImageSize;
        rectF2.set(0.0f, 0.0f, i, i);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i6 = this.maxImageSize;
        matrix.postScale(f, f, i6 / 2.0f, i6 / 2.0f);
    }

    @NonNull
    private AnimatorSet createAnimator(@NonNull MotionSpec motionSpec, float f, float f10, float f11) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.view, (Property<FloatingActionButton, Float>) View.ALPHA, f);
        motionSpec.getTiming("opacity").apply(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.view, (Property<FloatingActionButton, Float>) View.SCALE_X, f10);
        motionSpec.getTiming("scale").apply(ofFloat2);
        workAroundOreoBug(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.view, (Property<FloatingActionButton, Float>) View.SCALE_Y, f10);
        motionSpec.getTiming("scale").apply(ofFloat3);
        workAroundOreoBug(ofFloat3);
        arrayList.add(ofFloat3);
        calculateImageMatrixFromScale(f11, this.tmpMatrix);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.view, new ImageMatrixProperty(), new MatrixEvaluator() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.3
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.google.android.material.animation.MatrixEvaluator, android.animation.TypeEvaluator
            public Matrix evaluate(float f12, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
                FloatingActionButtonImpl.this.imageMatrixScale = f12;
                return super.evaluate(f12, matrix, matrix2);
            }
        }, new Matrix(this.tmpMatrix));
        motionSpec.getTiming("iconScale").apply(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet createDefaultAnimator(final float f, final float f10, final float f11, int i, int i6) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        final float alpha = this.view.getAlpha();
        final float scaleX = this.view.getScaleX();
        final float scaleY = this.view.getScaleY();
        final float f12 = this.imageMatrixScale;
        final Matrix matrix = new Matrix(this.tmpMatrix);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.google.android.material.floatingactionbutton.a
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                FloatingActionButtonImpl.this.lambda$createDefaultAnimator$0(alpha, f, scaleX, f10, scaleY, f12, f11, matrix, valueAnimator);
            }
        });
        arrayList.add(ofFloat);
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        animatorSet.setDuration(MotionUtils.resolveThemeDuration(this.view.getContext(), i, this.view.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(MotionUtils.resolveThemeInterpolator(this.view.getContext(), i6, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return animatorSet;
    }

    @NonNull
    private StateListAnimator createDefaultStateListAnimator(float f, float f10, float f11) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(f, f11));
        stateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f, f10));
        stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f, f10));
        stateListAnimator.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(f, f10));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.view, "elevation", f).setDuration(0L));
        if (Build.VERSION.SDK_INT <= 24) {
            FloatingActionButton floatingActionButton = this.view;
            arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.view, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        stateListAnimator.addState(ENABLED_STATE_SET, animatorSet);
        stateListAnimator.addState(EMPTY_STATE_SET, createElevationAnimator(0.0f, 0.0f));
        return stateListAnimator;
    }

    @NonNull
    private Animator createElevationAnimator(float f, float f10) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.view, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.view, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f10).setDuration(100L));
        animatorSet.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        return animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$createDefaultAnimator$0(float f, float f10, float f11, float f12, float f13, float f14, float f15, Matrix matrix, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.view.setAlpha(AnimationUtils.lerp(f, f10, 0.0f, 0.2f, floatValue));
        this.view.setScaleX(AnimationUtils.lerp(f11, f12, floatValue));
        this.view.setScaleY(AnimationUtils.lerp(f13, f12, floatValue));
        this.imageMatrixScale = AnimationUtils.lerp(f14, f15, floatValue);
        calculateImageMatrixFromScale(AnimationUtils.lerp(f14, f15, floatValue), matrix);
        this.view.setImageMatrix(matrix);
    }

    private boolean shouldAnimateVisibilityChange() {
        return this.view.isLaidOut() && !this.view.isInEditMode();
    }

    private void workAroundOreoBug(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new TypeEvaluator<Float>() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.4
            final FloatEvaluator floatEvaluator = new FloatEvaluator();

            @Override // android.animation.TypeEvaluator
            public Float evaluate(float f, Float f10, Float f11) {
                float floatValue = this.floatEvaluator.evaluate(f, (Number) f10, (Number) f11).floatValue();
                if (floatValue < 0.1f) {
                    floatValue = 0.0f;
                }
                return Float.valueOf(floatValue);
            }
        });
    }

    public void addOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.hideListeners == null) {
            this.hideListeners = new ArrayList<>();
        }
        this.hideListeners.add(animatorListener);
    }

    public void addOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        if (this.showListeners == null) {
            this.showListeners = new ArrayList<>();
        }
        this.showListeners.add(animatorListener);
    }

    public void addTransformationCallback(@NonNull InternalTransformationCallback internalTransformationCallback) {
        if (this.transformationCallbacks == null) {
            this.transformationCallbacks = new ArrayList<>();
        }
        this.transformationCallbacks.add(internalTransformationCallback);
    }

    @NonNull
    public BorderDrawable createBorderDrawable(int i, ColorStateList colorStateList) {
        Context context = this.view.getContext();
        BorderDrawable borderDrawable = new BorderDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
        borderDrawable.setGradientColors(ContextCompat.getColor(context, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_outer_color));
        borderDrawable.setBorderWidth(i);
        borderDrawable.setBorderTint(colorStateList);
        return borderDrawable;
    }

    public MaterialShapeDrawable createShapeDrawable() {
        return new AlwaysStatefulMaterialShapeDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
    }

    @Nullable
    public final Drawable getContentBackground() {
        return this.contentBackground;
    }

    public float getElevation() {
        return this.view.getElevation();
    }

    public boolean getEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }

    @Nullable
    public final MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public float getHoveredFocusedTranslationZ() {
        return this.hoveredFocusedTranslationZ;
    }

    public void getPadding(@NonNull Rect rect) {
        if (this.shadowViewDelegate.isCompatPaddingEnabled()) {
            int touchTargetPadding = getTouchTargetPadding();
            int max = Math.max(touchTargetPadding, (int) Math.ceil(this.shadowPaddingEnabled ? getElevation() + this.pressedTranslationZ : 0.0f));
            int max2 = Math.max(touchTargetPadding, (int) Math.ceil(r1 * SHADOW_MULTIPLIER));
            rect.set(max, max2, max, max2);
            return;
        }
        if (!ignoreExpandBoundsForA11y()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.minTouchTargetSize - this.view.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    public float getPressedTranslationZ() {
        return this.pressedTranslationZ;
    }

    @Nullable
    public final ShapeAppearanceModel getShapeAppearance() {
        return this.shapeAppearance;
    }

    @Nullable
    public final MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    public int getTouchTargetPadding() {
        if (this.ensureMinTouchTargetSize) {
            return Math.max((this.minTouchTargetSize - this.view.getSizeDimension()) / 2, 0);
        }
        return 0;
    }

    public void hide(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z9) {
        FloatingActionButtonImpl floatingActionButtonImpl;
        AnimatorSet createDefaultAnimator;
        if (isOrWillBeHidden()) {
            return;
        }
        Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        if (!shouldAnimateVisibilityChange()) {
            this.view.internalSetVisibility(z9 ? 8 : 4, z9);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.onHidden();
                return;
            }
            return;
        }
        MotionSpec motionSpec = this.hideMotionSpec;
        if (motionSpec != null) {
            createDefaultAnimator = createAnimator(motionSpec, 0.0f, 0.0f, 0.0f);
            floatingActionButtonImpl = this;
        } else {
            floatingActionButtonImpl = this;
            createDefaultAnimator = floatingActionButtonImpl.createDefaultAnimator(0.0f, 0.4f, 0.4f, HIDE_ANIM_DURATION_ATTR, HIDE_ANIM_EASING_ATTR);
        }
        createDefaultAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.1
            private boolean cancelled;

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator2) {
                this.cancelled = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                FloatingActionButtonImpl.this.animState = 0;
                FloatingActionButtonImpl.this.currentAnimator = null;
                if (this.cancelled) {
                    return;
                }
                FloatingActionButton floatingActionButton = FloatingActionButtonImpl.this.view;
                boolean z10 = z9;
                floatingActionButton.internalSetVisibility(z10 ? 8 : 4, z10);
                InternalVisibilityChangedListener internalVisibilityChangedListener2 = internalVisibilityChangedListener;
                if (internalVisibilityChangedListener2 != null) {
                    internalVisibilityChangedListener2.onHidden();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                FloatingActionButtonImpl.this.view.internalSetVisibility(0, z9);
                FloatingActionButtonImpl.this.animState = 1;
                FloatingActionButtonImpl.this.currentAnimator = animator2;
                this.cancelled = false;
            }
        });
        ArrayList<Animator.AnimatorListener> arrayList = floatingActionButtonImpl.hideListeners;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Animator.AnimatorListener animatorListener = arrayList.get(i);
                i++;
                createDefaultAnimator.addListener(animatorListener);
            }
        }
        createDefaultAnimator.start();
    }

    public final boolean ignoreExpandBoundsForA11y() {
        return this.ensureMinTouchTargetSize && this.view.getSizeDimension() < this.minTouchTargetSize;
    }

    public void initializeBackgroundDrawable(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable drawable;
        MaterialShapeDrawable createShapeDrawable = createShapeDrawable();
        this.shapeDrawable = createShapeDrawable;
        createShapeDrawable.setTintList(colorStateList);
        if (mode != null) {
            this.shapeDrawable.setTintMode(mode);
        }
        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        if (i > 0) {
            this.borderDrawable = createBorderDrawable(i, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.borderDrawable), (Drawable) Preconditions.checkNotNull(this.shapeDrawable)});
        } else {
            this.borderDrawable = null;
            drawable = this.shapeDrawable;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(colorStateList2), drawable, null);
        this.rippleDrawable = rippleDrawable;
        this.contentBackground = rippleDrawable;
    }

    public boolean isOrWillBeHidden() {
        int visibility = this.view.getVisibility();
        int i = this.animState;
        return visibility == 0 ? i == 1 : i != 2;
    }

    public boolean isOrWillBeShown() {
        int visibility = this.view.getVisibility();
        int i = this.animState;
        return visibility != 0 ? i == 2 : i != 1;
    }

    public void onAttachedToWindow() {
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            MaterialShapeUtils.setParentAbsoluteElevation(this.view, materialShapeDrawable);
        }
    }

    public void onCompatShadowChanged() {
        updatePadding();
    }

    public void onDetachedFromWindow() {
        ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
        ViewTreeObserver.OnPreDrawListener onPreDrawListener = this.preDrawListener;
        if (onPreDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(onPreDrawListener);
            this.preDrawListener = null;
        }
    }

    public void onDrawableStateChangedForLollipop() {
        boolean isEnabled = this.view.isEnabled();
        FloatingActionButton floatingActionButton = this.view;
        if (!isEnabled) {
            floatingActionButton.setElevation(0.0f);
            this.view.setTranslationZ(0.0f);
            return;
        }
        floatingActionButton.setElevation(this.elevation);
        boolean isPressed = this.view.isPressed();
        FloatingActionButton floatingActionButton2 = this.view;
        if (isPressed) {
            floatingActionButton2.setTranslationZ(this.pressedTranslationZ);
        } else if (floatingActionButton2.isFocused() || this.view.isHovered()) {
            this.view.setTranslationZ(this.hoveredFocusedTranslationZ);
        } else {
            this.view.setTranslationZ(0.0f);
        }
    }

    public void onElevationsChanged(float f, float f10, float f11) {
        if (this.view.getStateListAnimator() == this.stateListAnimator) {
            StateListAnimator createDefaultStateListAnimator = createDefaultStateListAnimator(f, f10, f11);
            this.stateListAnimator = createDefaultStateListAnimator;
            this.view.setStateListAnimator(createDefaultStateListAnimator);
        }
        if (shouldAddPadding()) {
            updatePadding();
        }
    }

    public void onPaddingUpdated(@NonNull Rect rect) {
        Preconditions.checkNotNull(this.contentBackground, "Didn't initialize content background");
        if (!shouldAddPadding()) {
            this.shadowViewDelegate.setBackgroundDrawable(this.contentBackground);
        } else {
            this.shadowViewDelegate.setBackgroundDrawable(new InsetDrawable(this.contentBackground, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    public void onScaleChanged() {
        ArrayList<InternalTransformationCallback> arrayList = this.transformationCallbacks;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                InternalTransformationCallback internalTransformationCallback = arrayList.get(i);
                i++;
                internalTransformationCallback.onScaleChanged();
            }
        }
    }

    public void onTranslationChanged() {
        ArrayList<InternalTransformationCallback> arrayList = this.transformationCallbacks;
        if (arrayList != null) {
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                InternalTransformationCallback internalTransformationCallback = arrayList.get(i);
                i++;
                internalTransformationCallback.onTranslationChanged();
            }
        }
    }

    public void removeOnHideAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.hideListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void removeOnShowAnimationListener(@NonNull Animator.AnimatorListener animatorListener) {
        ArrayList<Animator.AnimatorListener> arrayList = this.showListeners;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(animatorListener);
    }

    public void removeTransformationCallback(@NonNull InternalTransformationCallback internalTransformationCallback) {
        ArrayList<InternalTransformationCallback> arrayList = this.transformationCallbacks;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(internalTransformationCallback);
    }

    public void setBackgroundTintList(@Nullable ColorStateList colorStateList) {
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintList(colorStateList);
        }
        BorderDrawable borderDrawable = this.borderDrawable;
        if (borderDrawable != null) {
            borderDrawable.setBorderTint(colorStateList);
        }
    }

    public void setBackgroundTintMode(@Nullable PorterDuff.Mode mode) {
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setTintMode(mode);
        }
    }

    public final void setElevation(float f) {
        if (this.elevation != f) {
            this.elevation = f;
            onElevationsChanged(f, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z9) {
        this.ensureMinTouchTargetSize = z9;
    }

    public final void setHideMotionSpec(@Nullable MotionSpec motionSpec) {
        this.hideMotionSpec = motionSpec;
    }

    public final void setHoveredFocusedTranslationZ(float f) {
        if (this.hoveredFocusedTranslationZ != f) {
            this.hoveredFocusedTranslationZ = f;
            onElevationsChanged(this.elevation, f, this.pressedTranslationZ);
        }
    }

    public final void setImageMatrixScale(float f) {
        this.imageMatrixScale = f;
        Matrix matrix = this.tmpMatrix;
        calculateImageMatrixFromScale(f, matrix);
        this.view.setImageMatrix(matrix);
    }

    public final void setMaxImageSize(int i) {
        if (this.maxImageSize != i) {
            this.maxImageSize = i;
            updateImageMatrixScale();
        }
    }

    public void setMinTouchTargetSize(int i) {
        this.minTouchTargetSize = i;
    }

    public final void setPressedTranslationZ(float f) {
        if (this.pressedTranslationZ != f) {
            this.pressedTranslationZ = f;
            onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, f);
        }
    }

    public void setRippleColor(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.rippleDrawable;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        } else if (drawable != null) {
            drawable.setTintList(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        }
    }

    public void setShadowPaddingEnabled(boolean z9) {
        this.shadowPaddingEnabled = z9;
        updatePadding();
    }

    public final void setShapeAppearance(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearance = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        Object obj = this.rippleDrawable;
        if (obj instanceof Shapeable) {
            ((Shapeable) obj).setShapeAppearanceModel(shapeAppearanceModel);
        }
        BorderDrawable borderDrawable = this.borderDrawable;
        if (borderDrawable != null) {
            borderDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    public final void setShowMotionSpec(@Nullable MotionSpec motionSpec) {
        this.showMotionSpec = motionSpec;
    }

    public boolean shouldAddPadding() {
        return this.shadowViewDelegate.isCompatPaddingEnabled() || ignoreExpandBoundsForA11y();
    }

    public void show(@Nullable final InternalVisibilityChangedListener internalVisibilityChangedListener, final boolean z9) {
        FloatingActionButtonImpl floatingActionButtonImpl;
        AnimatorSet createDefaultAnimator;
        if (isOrWillBeShown()) {
            return;
        }
        Animator animator = this.currentAnimator;
        if (animator != null) {
            animator.cancel();
        }
        int i = 0;
        boolean z10 = this.showMotionSpec == null;
        boolean shouldAnimateVisibilityChange = shouldAnimateVisibilityChange();
        FloatingActionButton floatingActionButton = this.view;
        if (!shouldAnimateVisibilityChange) {
            floatingActionButton.internalSetVisibility(0, z9);
            this.view.setAlpha(1.0f);
            this.view.setScaleY(1.0f);
            this.view.setScaleX(1.0f);
            setImageMatrixScale(1.0f);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.onShown();
                return;
            }
            return;
        }
        if (floatingActionButton.getVisibility() != 0) {
            this.view.setAlpha(0.0f);
            this.view.setScaleY(z10 ? 0.4f : 0.0f);
            this.view.setScaleX(z10 ? 0.4f : 0.0f);
            setImageMatrixScale(z10 ? 0.4f : 0.0f);
        }
        MotionSpec motionSpec = this.showMotionSpec;
        if (motionSpec != null) {
            createDefaultAnimator = createAnimator(motionSpec, 1.0f, 1.0f, 1.0f);
            floatingActionButtonImpl = this;
        } else {
            floatingActionButtonImpl = this;
            createDefaultAnimator = floatingActionButtonImpl.createDefaultAnimator(1.0f, 1.0f, 1.0f, SHOW_ANIM_DURATION_ATTR, SHOW_ANIM_EASING_ATTR);
        }
        createDefaultAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator2) {
                FloatingActionButtonImpl.this.animState = 0;
                FloatingActionButtonImpl.this.currentAnimator = null;
                InternalVisibilityChangedListener internalVisibilityChangedListener2 = internalVisibilityChangedListener;
                if (internalVisibilityChangedListener2 != null) {
                    internalVisibilityChangedListener2.onShown();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator2) {
                FloatingActionButtonImpl.this.view.internalSetVisibility(0, z9);
                FloatingActionButtonImpl.this.animState = 2;
                FloatingActionButtonImpl.this.currentAnimator = animator2;
            }
        });
        ArrayList<Animator.AnimatorListener> arrayList = floatingActionButtonImpl.showListeners;
        if (arrayList != null) {
            int size = arrayList.size();
            while (i < size) {
                Animator.AnimatorListener animatorListener = arrayList.get(i);
                i++;
                createDefaultAnimator.addListener(animatorListener);
            }
        }
        createDefaultAnimator.start();
    }

    public final void updateImageMatrixScale() {
        setImageMatrixScale(this.imageMatrixScale);
    }

    public final void updatePadding() {
        Rect rect = this.tmpRect;
        getPadding(rect);
        onPaddingUpdated(rect);
        this.shadowViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void updateShapeElevation(float f) {
        MaterialShapeDrawable materialShapeDrawable = this.shapeDrawable;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(f);
        }
    }
}
