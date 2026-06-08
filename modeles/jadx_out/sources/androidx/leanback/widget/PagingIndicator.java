package androidx.leanback.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.ViewCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class PagingIndicator extends View {
    private static final TimeInterpolator DECELERATE_INTERPOLATOR = new DecelerateInterpolator();
    private static final Property<Dot, Float> DOT_ALPHA;
    private static final Property<Dot, Float> DOT_DIAMETER;
    private static final Property<Dot, Float> DOT_TRANSLATION_X;
    private static final long DURATION_ALPHA = 167;
    private static final long DURATION_DIAMETER = 417;
    private static final long DURATION_TRANSLATION_X = 417;
    private final AnimatorSet mAnimator;
    Bitmap mArrow;
    final int mArrowDiameter;
    private final int mArrowGap;
    Paint mArrowPaint;
    final int mArrowRadius;
    final Rect mArrowRect;
    final float mArrowToBgRatio;
    final Paint mBgPaint;
    private int mCurrentPage;
    int mDotCenterY;
    final int mDotDiameter;

    @ColorInt
    int mDotFgSelectColor;
    private final int mDotGap;
    final int mDotRadius;
    private int[] mDotSelectedNextX;
    private int[] mDotSelectedPrevX;
    private int[] mDotSelectedX;
    private Dot[] mDots;
    final Paint mFgPaint;
    private final AnimatorSet mHideAnimator;
    boolean mIsLtr;
    private int mPageCount;
    private int mPreviousPage;
    private final int mShadowRadius;
    private final AnimatorSet mShowAnimator;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public class Dot {
        static final float LEFT = -1.0f;
        static final float LTR = 1.0f;
        static final float RIGHT = 1.0f;
        static final float RTL = -1.0f;
        float mAlpha;
        float mArrowImageRadius;
        float mCenterX;
        float mDiameter;
        float mDirection = 1.0f;

        @ColorInt
        int mFgColor;
        float mLayoutDirection;
        float mRadius;
        float mTranslationX;

        public Dot() {
            this.mLayoutDirection = PagingIndicator.this.mIsLtr ? 1.0f : -1.0f;
        }

        public void adjustAlpha() {
            this.mFgColor = Color.argb(Math.round(this.mAlpha * 255.0f), Color.red(PagingIndicator.this.mDotFgSelectColor), Color.green(PagingIndicator.this.mDotFgSelectColor), Color.blue(PagingIndicator.this.mDotFgSelectColor));
        }

        public void deselect() {
            this.mTranslationX = 0.0f;
            this.mCenterX = 0.0f;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.mDiameter = pagingIndicator.mDotDiameter;
            float f = pagingIndicator.mDotRadius;
            this.mRadius = f;
            this.mArrowImageRadius = f * pagingIndicator.mArrowToBgRatio;
            this.mAlpha = 0.0f;
            adjustAlpha();
        }

        public void draw(Canvas canvas) {
            float f = this.mCenterX + this.mTranslationX;
            canvas.drawCircle(f, r1.mDotCenterY, this.mRadius, PagingIndicator.this.mBgPaint);
            if (this.mAlpha > 0.0f) {
                PagingIndicator.this.mFgPaint.setColor(this.mFgColor);
                canvas.drawCircle(f, r1.mDotCenterY, this.mRadius, PagingIndicator.this.mFgPaint);
                PagingIndicator pagingIndicator = PagingIndicator.this;
                Bitmap bitmap = pagingIndicator.mArrow;
                Rect rect = pagingIndicator.mArrowRect;
                float f10 = this.mArrowImageRadius;
                int i = PagingIndicator.this.mDotCenterY;
                canvas.drawBitmap(bitmap, rect, new Rect((int) (f - f10), (int) (i - f10), (int) (f + f10), (int) (i + f10)), PagingIndicator.this.mArrowPaint);
            }
        }

        public float getAlpha() {
            return this.mAlpha;
        }

        public float getDiameter() {
            return this.mDiameter;
        }

        public float getTranslationX() {
            return this.mTranslationX;
        }

        public void onRtlPropertiesChanged() {
            this.mLayoutDirection = PagingIndicator.this.mIsLtr ? 1.0f : -1.0f;
        }

        public void select() {
            this.mTranslationX = 0.0f;
            this.mCenterX = 0.0f;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.mDiameter = pagingIndicator.mArrowDiameter;
            float f = pagingIndicator.mArrowRadius;
            this.mRadius = f;
            this.mArrowImageRadius = f * pagingIndicator.mArrowToBgRatio;
            this.mAlpha = 1.0f;
            adjustAlpha();
        }

        public void setAlpha(float f) {
            this.mAlpha = f;
            adjustAlpha();
            PagingIndicator.this.invalidate();
        }

        public void setDiameter(float f) {
            this.mDiameter = f;
            float f10 = f / 2.0f;
            this.mRadius = f10;
            PagingIndicator pagingIndicator = PagingIndicator.this;
            this.mArrowImageRadius = f10 * pagingIndicator.mArrowToBgRatio;
            pagingIndicator.invalidate();
        }

        public void setTranslationX(float f) {
            this.mTranslationX = f * this.mDirection * this.mLayoutDirection;
            PagingIndicator.this.invalidate();
        }
    }

    static {
        Class<Float> cls = Float.class;
        DOT_ALPHA = new Property<Dot, Float>(cls, "alpha") { // from class: androidx.leanback.widget.PagingIndicator.1
            @Override // android.util.Property
            public Float get(Dot dot) {
                return Float.valueOf(dot.getAlpha());
            }

            @Override // android.util.Property
            public void set(Dot dot, Float f) {
                dot.setAlpha(f.floatValue());
            }
        };
        DOT_DIAMETER = new Property<Dot, Float>(cls, "diameter") { // from class: androidx.leanback.widget.PagingIndicator.2
            @Override // android.util.Property
            public Float get(Dot dot) {
                return Float.valueOf(dot.getDiameter());
            }

            @Override // android.util.Property
            public void set(Dot dot, Float f) {
                dot.setDiameter(f.floatValue());
            }
        };
        DOT_TRANSLATION_X = new Property<Dot, Float>(cls, "translation_x") { // from class: androidx.leanback.widget.PagingIndicator.3
            @Override // android.util.Property
            public Float get(Dot dot) {
                return Float.valueOf(dot.getTranslationX());
            }

            @Override // android.util.Property
            public void set(Dot dot, Float f) {
                dot.setTranslationX(f.floatValue());
            }
        };
    }

    public PagingIndicator(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AnimatorSet animatorSet = new AnimatorSet();
        this.mAnimator = animatorSet;
        Resources resources = getResources();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.leanback.R.styleable.PagingIndicator, i, 0);
        ViewCompat.saveAttributeDataForStyleable(this, context, androidx.leanback.R.styleable.PagingIndicator, attributeSet, obtainStyledAttributes, i, 0);
        int dimensionFromTypedArray = getDimensionFromTypedArray(obtainStyledAttributes, androidx.leanback.R.styleable.PagingIndicator_lbDotRadius, androidx.leanback.R.dimen.lb_page_indicator_dot_radius);
        this.mDotRadius = dimensionFromTypedArray;
        this.mDotDiameter = dimensionFromTypedArray * 2;
        int dimensionFromTypedArray2 = getDimensionFromTypedArray(obtainStyledAttributes, androidx.leanback.R.styleable.PagingIndicator_arrowRadius, androidx.leanback.R.dimen.lb_page_indicator_arrow_radius);
        this.mArrowRadius = dimensionFromTypedArray2;
        int i6 = dimensionFromTypedArray2 * 2;
        this.mArrowDiameter = i6;
        this.mDotGap = getDimensionFromTypedArray(obtainStyledAttributes, androidx.leanback.R.styleable.PagingIndicator_dotToDotGap, androidx.leanback.R.dimen.lb_page_indicator_dot_gap);
        this.mArrowGap = getDimensionFromTypedArray(obtainStyledAttributes, androidx.leanback.R.styleable.PagingIndicator_dotToArrowGap, androidx.leanback.R.dimen.lb_page_indicator_arrow_gap);
        int colorFromTypedArray = getColorFromTypedArray(obtainStyledAttributes, androidx.leanback.R.styleable.PagingIndicator_dotBgColor, androidx.leanback.R.color.lb_page_indicator_dot);
        Paint paint = new Paint(1);
        this.mBgPaint = paint;
        paint.setColor(colorFromTypedArray);
        this.mDotFgSelectColor = getColorFromTypedArray(obtainStyledAttributes, androidx.leanback.R.styleable.PagingIndicator_arrowBgColor, androidx.leanback.R.color.lb_page_indicator_arrow_background);
        if (this.mArrowPaint == null && obtainStyledAttributes.hasValue(androidx.leanback.R.styleable.PagingIndicator_arrowColor)) {
            setArrowColor(obtainStyledAttributes.getColor(androidx.leanback.R.styleable.PagingIndicator_arrowColor, 0));
        }
        obtainStyledAttributes.recycle();
        this.mIsLtr = resources.getConfiguration().getLayoutDirection() == 0;
        int color = resources.getColor(androidx.leanback.R.color.lb_page_indicator_arrow_shadow);
        int dimensionPixelSize = resources.getDimensionPixelSize(androidx.leanback.R.dimen.lb_page_indicator_arrow_shadow_radius);
        this.mShadowRadius = dimensionPixelSize;
        Paint paint2 = new Paint(1);
        this.mFgPaint = paint2;
        float dimensionPixelSize2 = resources.getDimensionPixelSize(androidx.leanback.R.dimen.lb_page_indicator_arrow_shadow_offset);
        paint2.setShadowLayer(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize2, color);
        this.mArrow = loadArrow();
        this.mArrowRect = new Rect(0, 0, this.mArrow.getWidth(), this.mArrow.getHeight());
        this.mArrowToBgRatio = this.mArrow.getWidth() / i6;
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.mShowAnimator = animatorSet2;
        animatorSet2.playTogether(createDotAlphaAnimator(0.0f, 1.0f), createDotDiameterAnimator(dimensionFromTypedArray * 2, dimensionFromTypedArray2 * 2), createDotTranslationXAnimator());
        AnimatorSet animatorSet3 = new AnimatorSet();
        this.mHideAnimator = animatorSet3;
        animatorSet3.playTogether(createDotAlphaAnimator(1.0f, 0.0f), createDotDiameterAnimator(dimensionFromTypedArray2 * 2, dimensionFromTypedArray * 2), createDotTranslationXAnimator());
        animatorSet.playTogether(animatorSet2, animatorSet3);
        setLayerType(1, null);
    }

    private void adjustDotPosition() {
        int i;
        Dot[] dotArr;
        int i6 = 0;
        while (true) {
            i = this.mCurrentPage;
            dotArr = this.mDots;
            if (i6 >= i) {
                break;
            }
            dotArr[i6].deselect();
            Dot dot = this.mDots[i6];
            if (i6 != this.mPreviousPage) {
                r3 = 1.0f;
            }
            dot.mDirection = r3;
            dot.mCenterX = this.mDotSelectedPrevX[i6];
            i6++;
        }
        dotArr[i].select();
        Dot[] dotArr2 = this.mDots;
        int i10 = this.mCurrentPage;
        Dot dot2 = dotArr2[i10];
        dot2.mDirection = this.mPreviousPage >= i10 ? 1.0f : -1.0f;
        dot2.mCenterX = this.mDotSelectedX[i10];
        while (true) {
            i10++;
            if (i10 >= this.mPageCount) {
                return;
            }
            this.mDots[i10].deselect();
            Dot dot3 = this.mDots[i10];
            dot3.mDirection = 1.0f;
            dot3.mCenterX = this.mDotSelectedNextX[i10];
        }
    }

    private void calculateDotPositions() {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int requiredWidth = getRequiredWidth();
        int i = (paddingLeft + width) / 2;
        int i6 = this.mPageCount;
        int[] iArr = new int[i6];
        this.mDotSelectedX = iArr;
        int[] iArr2 = new int[i6];
        this.mDotSelectedPrevX = iArr2;
        int[] iArr3 = new int[i6];
        this.mDotSelectedNextX = iArr3;
        boolean z9 = this.mIsLtr;
        int i10 = this.mDotRadius;
        int i11 = 1;
        if (z9) {
            int i12 = i - (requiredWidth / 2);
            int i13 = this.mDotGap;
            int i14 = this.mArrowGap;
            iArr[0] = ((i12 + i10) - i13) + i14;
            iArr2[0] = i12 + i10;
            iArr3[0] = (i14 * 2) + ((i12 + i10) - (i13 * 2));
            while (i11 < this.mPageCount) {
                int[] iArr4 = this.mDotSelectedX;
                int[] iArr5 = this.mDotSelectedPrevX;
                int i15 = i11 - 1;
                int i16 = iArr5[i15];
                int i17 = this.mArrowGap;
                iArr4[i11] = i16 + i17;
                iArr5[i11] = iArr5[i15] + this.mDotGap;
                this.mDotSelectedNextX[i11] = iArr4[i15] + i17;
                i11++;
            }
        } else {
            int i18 = (requiredWidth / 2) + i;
            int i19 = this.mDotGap;
            int i20 = this.mArrowGap;
            iArr[0] = ((i18 - i10) + i19) - i20;
            iArr2[0] = i18 - i10;
            iArr3[0] = ((i19 * 2) + (i18 - i10)) - (i20 * 2);
            while (i11 < this.mPageCount) {
                int[] iArr6 = this.mDotSelectedX;
                int[] iArr7 = this.mDotSelectedPrevX;
                int i21 = i11 - 1;
                int i22 = iArr7[i21];
                int i23 = this.mArrowGap;
                iArr6[i11] = i22 - i23;
                iArr7[i11] = iArr7[i21] - this.mDotGap;
                this.mDotSelectedNextX[i11] = iArr6[i21] - i23;
                i11++;
            }
        }
        this.mDotCenterY = paddingTop + this.mArrowRadius;
        adjustDotPosition();
    }

    private Animator createDotAlphaAnimator(float f, float f10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, DOT_ALPHA, f, f10);
        ofFloat.setDuration(DURATION_ALPHA);
        ofFloat.setInterpolator(DECELERATE_INTERPOLATOR);
        return ofFloat;
    }

    private Animator createDotDiameterAnimator(float f, float f10) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, DOT_DIAMETER, f, f10);
        ofFloat.setDuration(417L);
        ofFloat.setInterpolator(DECELERATE_INTERPOLATOR);
        return ofFloat;
    }

    private Animator createDotTranslationXAnimator() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat((Object) null, DOT_TRANSLATION_X, (-this.mArrowGap) + this.mDotGap, 0.0f);
        ofFloat.setDuration(417L);
        ofFloat.setInterpolator(DECELERATE_INTERPOLATOR);
        return ofFloat;
    }

    private int getColorFromTypedArray(TypedArray typedArray, int i, int i6) {
        return typedArray.getColor(i, getResources().getColor(i6));
    }

    private int getDesiredHeight() {
        return getPaddingBottom() + getPaddingTop() + this.mArrowDiameter + this.mShadowRadius;
    }

    private int getDesiredWidth() {
        return getPaddingRight() + getPaddingLeft() + getRequiredWidth();
    }

    private int getDimensionFromTypedArray(TypedArray typedArray, int i, int i6) {
        return typedArray.getDimensionPixelOffset(i, getResources().getDimensionPixelOffset(i6));
    }

    private int getRequiredWidth() {
        return ((this.mPageCount - 3) * this.mDotGap) + (this.mArrowGap * 2) + (this.mDotRadius * 2);
    }

    private Bitmap loadArrow() {
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), androidx.leanback.R.drawable.lb_ic_nav_arrow);
        if (this.mIsLtr) {
            return decodeResource;
        }
        Matrix matrix = new Matrix();
        matrix.preScale(-1.0f, 1.0f);
        return Bitmap.createBitmap(decodeResource, 0, 0, decodeResource.getWidth(), decodeResource.getHeight(), matrix, false);
    }

    private void setSelectedPage(int i) {
        if (i == this.mCurrentPage) {
            return;
        }
        this.mCurrentPage = i;
        adjustDotPosition();
    }

    @VisibleForTesting
    public int[] getDotSelectedLeftX() {
        return this.mDotSelectedPrevX;
    }

    @VisibleForTesting
    public int[] getDotSelectedRightX() {
        return this.mDotSelectedNextX;
    }

    @VisibleForTesting
    public int[] getDotSelectedX() {
        return this.mDotSelectedX;
    }

    @VisibleForTesting
    public int getPageCount() {
        return this.mPageCount;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        for (int i = 0; i < this.mPageCount; i++) {
            this.mDots[i].draw(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i6) {
        int desiredHeight = getDesiredHeight();
        int mode = View.MeasureSpec.getMode(i6);
        if (mode == Integer.MIN_VALUE) {
            desiredHeight = Math.min(desiredHeight, View.MeasureSpec.getSize(i6));
        } else if (mode == 1073741824) {
            desiredHeight = View.MeasureSpec.getSize(i6);
        }
        int desiredWidth = getDesiredWidth();
        int mode2 = View.MeasureSpec.getMode(i);
        if (mode2 == Integer.MIN_VALUE) {
            desiredWidth = Math.min(desiredWidth, View.MeasureSpec.getSize(i));
        } else if (mode2 == 1073741824) {
            desiredWidth = View.MeasureSpec.getSize(i);
        }
        setMeasuredDimension(desiredWidth, desiredHeight);
    }

    public void onPageSelected(int i, boolean z9) {
        if (this.mCurrentPage == i) {
            return;
        }
        if (this.mAnimator.isStarted()) {
            this.mAnimator.end();
        }
        int i6 = this.mCurrentPage;
        this.mPreviousPage = i6;
        if (z9) {
            this.mHideAnimator.setTarget(this.mDots[i6]);
            this.mShowAnimator.setTarget(this.mDots[i]);
            this.mAnimator.start();
        }
        setSelectedPage(i);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        boolean z9 = i == 0;
        if (this.mIsLtr != z9) {
            this.mIsLtr = z9;
            this.mArrow = loadArrow();
            Dot[] dotArr = this.mDots;
            if (dotArr != null) {
                for (Dot dot : dotArr) {
                    dot.onRtlPropertiesChanged();
                }
            }
            calculateDotPositions();
            invalidate();
        }
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i6, int i10, int i11) {
        setMeasuredDimension(i, i6);
        calculateDotPositions();
    }

    public void setArrowBackgroundColor(@ColorInt int i) {
        this.mDotFgSelectColor = i;
    }

    public void setArrowColor(@ColorInt int i) {
        if (this.mArrowPaint == null) {
            this.mArrowPaint = new Paint();
        }
        this.mArrowPaint.setColorFilter(new PorterDuffColorFilter(i, PorterDuff.Mode.SRC_IN));
    }

    public void setDotBackgroundColor(@ColorInt int i) {
        this.mBgPaint.setColor(i);
    }

    public void setPageCount(int i) {
        if (i <= 0) {
            com.google.gson.internal.a.p("The page count should be a positive integer");
            return;
        }
        this.mPageCount = i;
        this.mDots = new Dot[i];
        for (int i6 = 0; i6 < this.mPageCount; i6++) {
            this.mDots[i6] = new Dot();
        }
        calculateDotPositions();
        setSelectedPage(0);
    }

    public PagingIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PagingIndicator(Context context) {
        this(context, null, 0);
    }
}
