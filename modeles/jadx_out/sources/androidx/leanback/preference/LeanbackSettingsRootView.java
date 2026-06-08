package androidx.leanback.preference;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class LeanbackSettingsRootView extends FrameLayout {
    private View.OnKeyListener mOnBackKeyListener;

    public LeanbackSettingsRootView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        View.OnKeyListener onKeyListener;
        return ((keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 4 || (onKeyListener = this.mOnBackKeyListener) == null) ? false : onKeyListener.onKey(this, keyEvent.getKeyCode(), keyEvent)) || super.dispatchKeyEvent(keyEvent);
    }

    public void setOnBackKeyListener(View.OnKeyListener onKeyListener) {
        this.mOnBackKeyListener = onKeyListener;
    }

    public LeanbackSettingsRootView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LeanbackSettingsRootView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
