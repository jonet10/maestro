package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.app.AppCompatViewInflater;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class LeanbackAppCompatViewInflater extends AppCompatViewInflater {
    @Override // androidx.appcompat.app.AppCompatViewInflater
    public View createView(Context context, String str, AttributeSet attributeSet) {
        str.getClass();
        if (str.equals("androidx.leanback.widget.GuidedActionEditText")) {
            return new GuidedActionAppCompatEditText(context, attributeSet);
        }
        return null;
    }
}
