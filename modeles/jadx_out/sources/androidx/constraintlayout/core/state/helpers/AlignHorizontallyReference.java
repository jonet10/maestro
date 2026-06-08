package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.HelperReference;
import androidx.constraintlayout.core.state.State;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class AlignHorizontallyReference extends HelperReference {
    private float mBias;

    public AlignHorizontallyReference(State state) {
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
            constraints.clearHorizontal();
            Object obj2 = this.mStartToStart;
            if (obj2 != null) {
                constraints.startToStart(obj2);
            } else {
                Object obj3 = this.mStartToEnd;
                if (obj3 != null) {
                    constraints.startToEnd(obj3);
                } else {
                    constraints.startToStart(State.PARENT);
                }
            }
            Object obj4 = this.mEndToStart;
            if (obj4 != null) {
                constraints.endToStart(obj4);
            } else {
                Object obj5 = this.mEndToEnd;
                if (obj5 != null) {
                    constraints.endToEnd(obj5);
                } else {
                    constraints.endToEnd(State.PARENT);
                }
            }
            float f = this.mBias;
            if (f != 0.5f) {
                constraints.horizontalBias(f);
            }
        }
    }
}
