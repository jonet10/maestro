package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.widget.TextView;
import androidx.core.widget.TextViewCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class ResizingTextView extends TextView {
    public static final int TRIGGER_MAX_LINES = 1;
    private float mDefaultLineSpacingExtra;
    private int mDefaultPaddingBottom;
    private int mDefaultPaddingTop;
    private int mDefaultTextSize;
    private boolean mDefaultsInitialized;
    private boolean mIsResized;
    private boolean mMaintainLineSpacing;
    private int mResizedPaddingAdjustmentBottom;
    private int mResizedPaddingAdjustmentTop;
    private int mResizedTextSize;
    private int mTriggerConditions;

    @SuppressLint({"CustomViewStyleable"})
    public ResizingTextView(Context context, AttributeSet attributeSet, int i, int i6) {
        super(context, attributeSet, i);
        this.mIsResized = false;
        this.mDefaultsInitialized = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, androidx.leanback.R.styleable.lbResizingTextView, i, i6);
        try {
            this.mTriggerConditions = obtainStyledAttributes.getInt(androidx.leanback.R.styleable.lbResizingTextView_resizeTrigger, 1);
            this.mResizedTextSize = obtainStyledAttributes.getDimensionPixelSize(androidx.leanback.R.styleable.lbResizingTextView_resizedTextSize, -1);
            this.mMaintainLineSpacing = obtainStyledAttributes.getBoolean(androidx.leanback.R.styleable.lbResizingTextView_maintainLineSpacing, false);
            this.mResizedPaddingAdjustmentTop = obtainStyledAttributes.getDimensionPixelOffset(androidx.leanback.R.styleable.lbResizingTextView_resizedPaddingAdjustmentTop, 0);
            this.mResizedPaddingAdjustmentBottom = obtainStyledAttributes.getDimensionPixelOffset(androidx.leanback.R.styleable.lbResizingTextView_resizedPaddingAdjustmentBottom, 0);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    private void resizeParamsChanged() {
        if (this.mIsResized) {
            requestLayout();
        }
    }

    private void setPaddingTopAndBottom(int i, int i6) {
        if (isPaddingRelative()) {
            setPaddingRelative(getPaddingStart(), i, getPaddingEnd(), i6);
        } else {
            setPadding(getPaddingLeft(), i, getPaddingRight(), i6);
        }
    }

    public boolean getMaintainLineSpacing() {
        return this.mMaintainLineSpacing;
    }

    public int getResizedPaddingAdjustmentBottom() {
        return this.mResizedPaddingAdjustmentBottom;
    }

    public int getResizedPaddingAdjustmentTop() {
        return this.mResizedPaddingAdjustmentTop;
    }

    public int getResizedTextSize() {
        return this.mResizedTextSize;
    }

    public int getTriggerConditions() {
        return this.mTriggerConditions;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x009f  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onMeasure(int r7, int r8) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.leanback.widget.ResizingTextView.onMeasure(int, int):void");
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public void setMaintainLineSpacing(boolean z9) {
        if (this.mMaintainLineSpacing != z9) {
            this.mMaintainLineSpacing = z9;
            resizeParamsChanged();
        }
    }

    public void setResizedPaddingAdjustmentBottom(int i) {
        if (this.mResizedPaddingAdjustmentBottom != i) {
            this.mResizedPaddingAdjustmentBottom = i;
            resizeParamsChanged();
        }
    }

    public void setResizedPaddingAdjustmentTop(int i) {
        if (this.mResizedPaddingAdjustmentTop != i) {
            this.mResizedPaddingAdjustmentTop = i;
            resizeParamsChanged();
        }
    }

    public void setResizedTextSize(int i) {
        if (this.mResizedTextSize != i) {
            this.mResizedTextSize = i;
            resizeParamsChanged();
        }
    }

    public void setTriggerConditions(int i) {
        if (this.mTriggerConditions != i) {
            this.mTriggerConditions = i;
            requestLayout();
        }
    }

    public ResizingTextView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ResizingTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.textViewStyle);
    }

    public ResizingTextView(Context context) {
        this(context, null);
    }
}
