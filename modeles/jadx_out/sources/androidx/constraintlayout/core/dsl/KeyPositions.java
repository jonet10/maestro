package androidx.constraintlayout.core.dsl;

import a4.x;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class KeyPositions extends Keys {
    private int[] mFrames;
    private String[] mTarget;
    private String mTransitionEasing = null;
    private Type mPositionType = null;
    private float[] mPercentWidth = null;
    private float[] mPercentHeight = null;
    private float[] mPercentX = null;
    private float[] mPercentY = null;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public enum Type {
        CARTESIAN,
        SCREEN,
        PATH
    }

    public KeyPositions(int i, String... strArr) {
        this.mFrames = null;
        this.mTarget = strArr;
        this.mFrames = new int[i];
        float length = 100.0f / (r3.length + 1);
        int i6 = 0;
        while (true) {
            int[] iArr = this.mFrames;
            if (i6 >= iArr.length) {
                return;
            }
            iArr[i6] = (int) ((i6 * length) + length);
            i6++;
        }
    }

    public int[] getFrames() {
        return this.mFrames;
    }

    public float[] getPercentHeight() {
        return this.mPercentHeight;
    }

    public float[] getPercentWidth() {
        return this.mPercentWidth;
    }

    public float[] getPercentX() {
        return this.mPercentX;
    }

    public float[] getPercentY() {
        return this.mPercentY;
    }

    public Type getPositionType() {
        return this.mPositionType;
    }

    public String[] getTarget() {
        return this.mTarget;
    }

    public String getTransitionEasing() {
        return this.mTransitionEasing;
    }

    public void setFrames(int... iArr) {
        this.mFrames = iArr;
    }

    public void setPercentHeight(float... fArr) {
        this.mPercentHeight = fArr;
    }

    public void setPercentWidth(float... fArr) {
        this.mPercentWidth = fArr;
    }

    public void setPercentX(float... fArr) {
        this.mPercentX = fArr;
    }

    public void setPercentY(float... fArr) {
        this.mPercentY = fArr;
    }

    public void setPositionType(Type type) {
        this.mPositionType = type;
    }

    public void setTransitionEasing(String str) {
        this.mTransitionEasing = str;
    }

    public String toString() {
        StringBuilder t9 = x.t("KeyPositions:{\n");
        append(t9, TypedValues.AttributesType.S_TARGET, this.mTarget);
        t9.append("frame:");
        t9.append(Arrays.toString(this.mFrames));
        t9.append(",\n");
        if (this.mPositionType != null) {
            t9.append("type:'");
            t9.append(this.mPositionType);
            t9.append("',\n");
        }
        append(t9, "easing", this.mTransitionEasing);
        append(t9, "percentX", this.mPercentX);
        append(t9, "percentX", this.mPercentY);
        append(t9, "percentWidth", this.mPercentWidth);
        append(t9, "percentHeight", this.mPercentHeight);
        t9.append("},\n");
        return t9.toString();
    }
}
