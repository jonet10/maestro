package androidx.constraintlayout.motion.utils;

import android.view.View;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ViewState {
    public int bottom;
    public int left;
    public int right;
    public float rotation;
    public int top;

    public void getState(View view) {
        this.left = view.getLeft();
        this.top = view.getTop();
        this.right = view.getRight();
        this.bottom = view.getBottom();
        this.rotation = view.getRotation();
    }

    public int height() {
        return this.bottom - this.top;
    }

    public int width() {
        return this.right - this.left;
    }
}
