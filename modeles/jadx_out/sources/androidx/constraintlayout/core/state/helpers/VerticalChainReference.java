package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class VerticalChainReference extends ChainReference {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: androidx.constraintlayout.core.state.helpers.VerticalChainReference$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$androidx$constraintlayout$core$state$State$Chain;

        static {
            int[] iArr = new int[State.Chain.values().length];
            $SwitchMap$androidx$constraintlayout$core$state$State$Chain = iArr;
            try {
                iArr[State.Chain.SPREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State.Chain.SPREAD_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$androidx$constraintlayout$core$state$State$Chain[State.Chain.PACKED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public VerticalChainReference(State state) {
        super(state, State.Helper.VERTICAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        ArrayList<Object> arrayList = this.mReferences;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            this.mHelperState.constraints(obj).clearVertical();
        }
        ArrayList<Object> arrayList2 = this.mReferences;
        int size2 = arrayList2.size();
        ConstraintReference constraintReference = null;
        int i6 = 0;
        ConstraintReference constraintReference2 = null;
        while (i6 < size2) {
            Object obj2 = arrayList2.get(i6);
            i6++;
            ConstraintReference constraints = this.mHelperState.constraints(obj2);
            if (constraintReference2 == null) {
                Object obj3 = this.mTopToTop;
                if (obj3 != null) {
                    constraints.topToTop(obj3).margin(this.mMarginTop).marginGone(this.mMarginTopGone);
                } else {
                    Object obj4 = this.mTopToBottom;
                    if (obj4 != null) {
                        constraints.topToBottom(obj4).margin(this.mMarginTop).marginGone(this.mMarginTopGone);
                    } else {
                        String obj5 = constraints.getKey().toString();
                        constraints.topToTop(State.PARENT).margin(Float.valueOf(getPreMargin(obj5))).marginGone(Float.valueOf(getPreGoneMargin(obj5)));
                    }
                }
                constraintReference2 = constraints;
            }
            if (constraintReference != null) {
                String obj6 = constraintReference.getKey().toString();
                String obj7 = constraints.getKey().toString();
                constraintReference.bottomToTop(constraints.getKey()).margin(Float.valueOf(getPostMargin(obj6))).marginGone(Float.valueOf(getPostGoneMargin(obj6)));
                constraints.topToBottom(constraintReference.getKey()).margin(Float.valueOf(getPreMargin(obj7))).marginGone(Float.valueOf(getPreGoneMargin(obj7)));
            }
            float weight = getWeight(obj2.toString());
            if (weight != -1.0f) {
                constraints.setVerticalChainWeight(weight);
            }
            constraintReference = constraints;
        }
        if (constraintReference != null) {
            Object obj8 = this.mBottomToTop;
            if (obj8 != null) {
                constraintReference.bottomToTop(obj8).margin(this.mMarginBottom).marginGone(this.mMarginBottomGone);
            } else {
                Object obj9 = this.mBottomToBottom;
                if (obj9 != null) {
                    constraintReference.bottomToBottom(obj9).margin(this.mMarginBottom).marginGone(this.mMarginBottomGone);
                } else {
                    String obj10 = constraintReference.getKey().toString();
                    constraintReference.bottomToBottom(State.PARENT).margin(Float.valueOf(getPostMargin(obj10))).marginGone(Float.valueOf(getPostGoneMargin(obj10)));
                }
            }
        }
        if (constraintReference2 == null) {
            return;
        }
        float f = this.mBias;
        if (f != 0.5f) {
            constraintReference2.verticalBias(f);
        }
        int i10 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Chain[this.mStyle.ordinal()];
        if (i10 == 1) {
            constraintReference2.setVerticalChainStyle(0);
        } else if (i10 == 2) {
            constraintReference2.setVerticalChainStyle(1);
        } else {
            if (i10 != 3) {
                return;
            }
            constraintReference2.setVerticalChainStyle(2);
        }
    }
}
