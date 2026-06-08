package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class AlignVerticallyReference extends HelperReference {
    private float mBias;

    public AlignVerticallyReference(State state) {
        super(state, State.Helper.ALIGN_VERTICALLY);
        this.mBias = 0.5f;
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        ArrayList<Object> arrayList = this.mReferences;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ConstraintReference constraints = this.mHelperState.constraints(obj);
            constraints.clearVertical();
            Object obj2 = this.mTopToTop;
            if (obj2 != null) {
                constraints.topToTop(obj2);
            } else {
                Object obj3 = this.mTopToBottom;
                if (obj3 != null) {
                    constraints.topToBottom(obj3);
                } else {
                    constraints.topToTop(State.PARENT);
                }
            }
            Object obj4 = this.mBottomToTop;
            if (obj4 != null) {
                constraints.bottomToTop(obj4);
            } else {
                Object obj5 = this.mBottomToBottom;
                if (obj5 != null) {
                    constraints.bottomToBottom(obj5);
                } else {
                    constraints.bottomToBottom(State.PARENT);
                }
            }
            float f = this.mBias;
            if (f != 0.5f) {
                constraints.verticalBias(f);
            }
        }
    }
}
