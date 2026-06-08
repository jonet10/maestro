package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.core.widget.PopupWindowCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class AppCompatPopupWindow extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR = false;
    private boolean mOverlapAnchor;

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i) {
        super(context, attributeSet, i);
        init(context, attributeSet, i, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i, int i6) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.PopupWindow, i, i6);
        if (obtainStyledAttributes.hasValue(R.styleable.PopupWindow_overlapAnchor)) {
            setSupportOverlapAnchor(obtainStyledAttributes.getBoolean(R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(R.styleable.PopupWindow_android_popupBackground));
        obtainStyledAttributes.recycle();
    }

    private void setSupportOverlapAnchor(boolean z9) {
        if (COMPAT_OVERLAP_ANCHOR) {
            this.mOverlapAnchor = z9;
        } else {
            PopupWindowCompat.setOverlapAnchor(this, z9);
        }
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i6) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i6 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i6);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i6, int i10, int i11) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i6 -= view.getHeight();
        }
        super.update(view, i, i6, i10, i11);
    }

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i, @StyleRes int i6) {
        super(context, attributeSet, i, i6);
        init(context, attributeSet, i, i6);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i6, int i10) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i6 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i6, i10);
    }
}
