package androidx.leanback.widget;

import android.view.KeyEvent;
import android.widget.EditText;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface ImeKeyMonitor {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface ImeKeyListener {
        boolean onKeyPreIme(EditText editText, int i, KeyEvent keyEvent);
    }

    void setImeKeyListener(ImeKeyListener imeKeyListener);
}
