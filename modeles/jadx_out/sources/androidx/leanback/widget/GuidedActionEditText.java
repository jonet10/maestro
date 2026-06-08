package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillValue;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import androidx.core.widget.TextViewCompat;
import androidx.leanback.widget.GuidedActionAutofillSupport;
import androidx.leanback.widget.ImeKeyMonitor;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class GuidedActionEditText extends EditText implements ImeKeyMonitor, GuidedActionAutofillSupport {
    private GuidedActionAutofillSupport.OnAutofillListener mAutofillListener;
    private ImeKeyMonitor.ImeKeyListener mKeyListener;
    private final Drawable mNoPaddingDrawable;
    private final Drawable mSavedBackground;

    public GuidedActionEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSavedBackground = getBackground();
        NoPaddingDrawable noPaddingDrawable = new NoPaddingDrawable();
        this.mNoPaddingDrawable = noPaddingDrawable;
        setBackground(noPaddingDrawable);
    }

    @Override // android.widget.TextView, android.view.View
    public void autofill(AutofillValue autofillValue) {
        super.autofill(autofillValue);
        GuidedActionAutofillSupport.OnAutofillListener onAutofillListener = this.mAutofillListener;
        if (onAutofillListener != null) {
            onAutofillListener.onAutofill(this);
        }
    }

    @Override // android.widget.TextView, android.view.View
    @RequiresApi(26)
    public int getAutofillType() {
        return 1;
    }

    @Override // android.widget.TextView, android.view.View
    public void onFocusChanged(boolean z9, int i, Rect rect) {
        super.onFocusChanged(z9, i, rect);
        if (z9) {
            setBackground(this.mSavedBackground);
        } else {
            setBackground(this.mNoPaddingDrawable);
        }
        if (z9) {
            return;
        }
        setFocusable(false);
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName((isFocused() ? EditText.class : TextView.class).getName());
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        ImeKeyMonitor.ImeKeyListener imeKeyListener = this.mKeyListener;
        boolean onKeyPreIme = imeKeyListener != null ? imeKeyListener.onKeyPreIme(this, i, keyEvent) : false;
        return !onKeyPreIme ? super.onKeyPreIme(i, keyEvent) : onKeyPreIme;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isInTouchMode() || isFocusableInTouchMode() || isTextSelectable()) {
            return super.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    @Override // androidx.leanback.widget.ImeKeyMonitor
    public void setImeKeyListener(ImeKeyMonitor.ImeKeyListener imeKeyListener) {
        this.mKeyListener = imeKeyListener;
    }

    @Override // androidx.leanback.widget.GuidedActionAutofillSupport
    public void setOnAutofillListener(GuidedActionAutofillSupport.OnAutofillListener onAutofillListener) {
        this.mAutofillListener = onAutofillListener;
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class NoPaddingDrawable extends Drawable {
        @Override // android.graphics.drawable.Drawable
        public int getOpacity() {
            return -2;
        }

        @Override // android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            rect.set(0, 0, 0, 0);
            return true;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas canvas) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int i) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter colorFilter) {
        }
    }

    public GuidedActionEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.R.attr.editTextStyle);
    }

    public GuidedActionEditText(Context context) {
        this(context, null);
    }
}
