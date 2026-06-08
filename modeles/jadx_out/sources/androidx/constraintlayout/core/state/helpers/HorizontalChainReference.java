package androidx.constraintlayout.core.state.helpers;

import androidx.constraintlayout.core.state.ConstraintReference;
import androidx.constraintlayout.core.state.State;
import java.util.ArrayList;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class HorizontalChainReference extends ChainReference {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    /* renamed from: androidx.constraintlayout.core.state.helpers.HorizontalChainReference$1, reason: invalid class name */
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

    public HorizontalChainReference(State state) {
        super(state, State.Helper.HORIZONTAL_CHAIN);
    }

    @Override // androidx.constraintlayout.core.state.HelperReference, androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
        ArrayList<Object> arrayList = this.mReferences;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            this.mHelperState.constraints(obj).clearHorizontal();
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
                Object obj3 = this.mStartToStart;
                if (obj3 != null) {
                    constraints.startToStart(obj3).margin(this.mMarginStart).marginGone(this.mMarginStartGone);
                } else {
                    Object obj4 = this.mStartToEnd;
                    if (obj4 != null) {
                        constraints.startToEnd(obj4).margin(this.mMarginStart).marginGone(this.mMarginStartGone);
                    } else {
                        Object obj5 = this.mLeftToLeft;
                        if (obj5 != null) {
                            constraints.startToStart(obj5).margin(this.mMarginLeft).marginGone(this.mMarginLeftGone);
                        } else {
                            Object obj6 = this.mLeftToRight;
                            if (obj6 != null) {
                                constraints.startToEnd(obj6).margin(this.mMarginLeft).marginGone(this.mMarginLeftGone);
                            } else {
                                String obj7 = constraints.getKey().toString();
                                constraints.startToStart(State.PARENT).margin(Float.valueOf(getPreMargin(obj7))).marginGone(Float.valueOf(getPreGoneMargin(obj7)));
                            }
                        }
                    }
                }
                constraintReference2 = constraints;
            }
            if (constraintReference != null) {
                String obj8 = constraintReference.getKey().toString();
                String obj9 = constraints.getKey().toString();
                constraintReference.endToStart(constraints.getKey()).margin(Float.valueOf(getPostMargin(obj8))).marginGone(Float.valueOf(getPostGoneMargin(obj8)));
                constraints.startToEnd(constraintReference.getKey()).margin(Float.valueOf(getPreMargin(obj9))).marginGone(Float.valueOf(getPreGoneMargin(obj9)));
            }
            float weight = getWeight(obj2.toString());
            if (weight != -1.0f) {
                constraints.setHorizontalChainWeight(weight);
            }
            constraintReference = constraints;
        }
        if (constraintReference != null) {
            Object obj10 = this.mEndToStart;
            if (obj10 != null) {
                constraintReference.endToStart(obj10).margin(this.mMarginEnd).marginGone(this.mMarginEndGone);
            } else {
                Object obj11 = this.mEndToEnd;
                if (obj11 != null) {
                    constraintReference.endToEnd(obj11).margin(this.mMarginEnd).marginGone(this.mMarginEndGone);
                } else {
                    Object obj12 = this.mRightToLeft;
                    if (obj12 != null) {
                        constraintReference.endToStart(obj12).margin(this.mMarginRight).marginGone(this.mMarginRightGone);
                    } else {
                        Object obj13 = this.mRightToRight;
                        if (obj13 != null) {
                            constraintReference.endToEnd(obj13).margin(this.mMarginRight).marginGone(this.mMarginRightGone);
                        } else {
                            String obj14 = constraintReference.getKey().toString();
                            constraintReference.endToEnd(State.PARENT).margin(Float.valueOf(getPostMargin(obj14))).marginGone(Float.valueOf(getPostGoneMargin(obj14)));
                        }
                    }
                }
            }
        }
        if (constraintReference2 == null) {
            return;
        }
        float f = this.mBias;
        if (f != 0.5f) {
            constraintReference2.horizontalBias(f);
        }
        int i10 = AnonymousClass1.$SwitchMap$androidx$constraintlayout$core$state$State$Chain[this.mStyle.ordinal()];
        if (i10 == 1) {
            constraintReference2.setHorizontalChainStyle(0);
        } else if (i10 == 2) {
            constraintReference2.setHorizontalChainStyle(1);
        } else {
            if (i10 != 3) {
                return;
            }
            constraintReference2.setHorizontalChainStyle(2);
        }
    }
}
