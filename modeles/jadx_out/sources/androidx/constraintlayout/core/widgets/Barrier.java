package androidx.constraintlayout.core.widgets;

import a4.x;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.HashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class Barrier extends HelperWidget {
    public static final int BOTTOM = 3;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int TOP = 2;
    private static final boolean USE_RELAX_GONE = false;
    private static final boolean USE_RESOLUTION = true;
    private int mBarrierType = 0;
    private boolean mAllowsGoneWidget = true;
    private int mMargin = 0;
    boolean mResolved = false;

    public Barrier(String str) {
        setDebugName(str);
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z9) {
        ConstraintAnchor[] constraintAnchorArr;
        boolean z10;
        int i;
        int i6;
        int i10;
        ConstraintAnchor[] constraintAnchorArr2 = this.mListAnchors;
        constraintAnchorArr2[0] = this.mLeft;
        constraintAnchorArr2[2] = this.mTop;
        constraintAnchorArr2[1] = this.mRight;
        constraintAnchorArr2[3] = this.mBottom;
        int i11 = 0;
        while (true) {
            constraintAnchorArr = this.mListAnchors;
            if (i11 >= constraintAnchorArr.length) {
                break;
            }
            ConstraintAnchor constraintAnchor = constraintAnchorArr[i11];
            constraintAnchor.mSolverVariable = linearSystem.createObjectVariable(constraintAnchor);
            i11++;
        }
        int i12 = this.mBarrierType;
        if (i12 < 0 || i12 >= 4) {
            return;
        }
        ConstraintAnchor constraintAnchor2 = constraintAnchorArr[i12];
        if (!this.mResolved) {
            allSolved();
        }
        if (this.mResolved) {
            this.mResolved = false;
            int i13 = this.mBarrierType;
            if (i13 == 0 || i13 == 1) {
                linearSystem.addEquality(this.mLeft.mSolverVariable, this.mX);
                linearSystem.addEquality(this.mRight.mSolverVariable, this.mX);
                return;
            } else {
                if (i13 == 2 || i13 == 3) {
                    linearSystem.addEquality(this.mTop.mSolverVariable, this.mY);
                    linearSystem.addEquality(this.mBottom.mSolverVariable, this.mY);
                    return;
                }
                return;
            }
        }
        for (int i14 = 0; i14 < this.mWidgetsCount; i14++) {
            ConstraintWidget constraintWidget = this.mWidgets[i14];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i6 = this.mBarrierType) == 0 || i6 == 1) && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mLeft.mTarget != null && constraintWidget.mRight.mTarget != null) || (((i10 = this.mBarrierType) == 2 || i10 == 3) && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mTop.mTarget != null && constraintWidget.mBottom.mTarget != null))) {
                z10 = true;
                break;
            }
        }
        z10 = false;
        boolean z11 = this.mLeft.hasCenteredDependents() || this.mRight.hasCenteredDependents();
        boolean z12 = this.mTop.hasCenteredDependents() || this.mBottom.hasCenteredDependents();
        int i15 = !(!z10 && (((i = this.mBarrierType) == 0 && z11) || ((i == 2 && z12) || ((i == 1 && z11) || (i == 3 && z12))))) ? 4 : 5;
        for (int i16 = 0; i16 < this.mWidgetsCount; i16++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i16];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                SolverVariable createObjectVariable = linearSystem.createObjectVariable(constraintWidget2.mListAnchors[this.mBarrierType]);
                ConstraintAnchor[] constraintAnchorArr3 = constraintWidget2.mListAnchors;
                int i17 = this.mBarrierType;
                ConstraintAnchor constraintAnchor3 = constraintAnchorArr3[i17];
                constraintAnchor3.mSolverVariable = createObjectVariable;
                ConstraintAnchor constraintAnchor4 = constraintAnchor3.mTarget;
                int i18 = (constraintAnchor4 == null || constraintAnchor4.mOwner != this) ? 0 : constraintAnchor3.mMargin;
                if (i17 == 0 || i17 == 2) {
                    linearSystem.addLowerBarrier(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin - i18, z10);
                } else {
                    linearSystem.addGreaterBarrier(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin + i18, z10);
                }
                linearSystem.addEquality(constraintAnchor2.mSolverVariable, createObjectVariable, this.mMargin + i18, i15);
            }
        }
        int i19 = this.mBarrierType;
        if (i19 == 0) {
            linearSystem.addEquality(this.mRight.mSolverVariable, this.mLeft.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 0);
            return;
        }
        if (i19 == 1) {
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mRight.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mLeft.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mLeft.mSolverVariable, this.mParent.mRight.mSolverVariable, 0, 0);
        } else if (i19 == 2) {
            linearSystem.addEquality(this.mBottom.mSolverVariable, this.mTop.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 0);
        } else if (i19 == 3) {
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mBottom.mSolverVariable, 0, 8);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mTop.mSolverVariable, 0, 4);
            linearSystem.addEquality(this.mTop.mSolverVariable, this.mParent.mBottom.mSolverVariable, 0, 0);
        }
    }

    public boolean allSolved() {
        int i;
        int i6;
        int i10;
        boolean z9 = true;
        int i11 = 0;
        while (true) {
            i = this.mWidgetsCount;
            if (i11 >= i) {
                break;
            }
            ConstraintWidget constraintWidget = this.mWidgets[i11];
            if ((this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) && ((((i6 = this.mBarrierType) == 0 || i6 == 1) && !constraintWidget.isResolvedHorizontally()) || (((i10 = this.mBarrierType) == 2 || i10 == 3) && !constraintWidget.isResolvedVertically()))) {
                z9 = false;
            }
            i11++;
        }
        if (!z9 || i <= 0) {
            return false;
        }
        int i12 = 0;
        boolean z10 = false;
        for (int i13 = 0; i13 < this.mWidgetsCount; i13++) {
            ConstraintWidget constraintWidget2 = this.mWidgets[i13];
            if (this.mAllowsGoneWidget || constraintWidget2.allowedInBarrier()) {
                if (!z10) {
                    int i14 = this.mBarrierType;
                    if (i14 == 0) {
                        i12 = constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue();
                    } else if (i14 == 1) {
                        i12 = constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue();
                    } else if (i14 == 2) {
                        i12 = constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue();
                    } else if (i14 == 3) {
                        i12 = constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue();
                    }
                    z10 = true;
                }
                int i15 = this.mBarrierType;
                if (i15 == 0) {
                    i12 = Math.min(i12, constraintWidget2.getAnchor(ConstraintAnchor.Type.LEFT).getFinalValue());
                } else if (i15 == 1) {
                    i12 = Math.max(i12, constraintWidget2.getAnchor(ConstraintAnchor.Type.RIGHT).getFinalValue());
                } else if (i15 == 2) {
                    i12 = Math.min(i12, constraintWidget2.getAnchor(ConstraintAnchor.Type.TOP).getFinalValue());
                } else if (i15 == 3) {
                    i12 = Math.max(i12, constraintWidget2.getAnchor(ConstraintAnchor.Type.BOTTOM).getFinalValue());
                }
            }
        }
        int i16 = i12 + this.mMargin;
        int i17 = this.mBarrierType;
        if (i17 == 0 || i17 == 1) {
            setFinalHorizontal(i16, i16);
        } else {
            setFinalVertical(i16, i16);
        }
        this.mResolved = true;
        return true;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean allowedInBarrier() {
        return true;
    }

    @Deprecated
    public boolean allowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Barrier barrier = (Barrier) constraintWidget;
        this.mBarrierType = barrier.mBarrierType;
        this.mAllowsGoneWidget = barrier.mAllowsGoneWidget;
        this.mMargin = barrier.mMargin;
    }

    public boolean getAllowsGoneWidget() {
        return this.mAllowsGoneWidget;
    }

    public int getBarrierType() {
        return this.mBarrierType;
    }

    public int getMargin() {
        return this.mMargin;
    }

    public int getOrientation() {
        int i = this.mBarrierType;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedHorizontally() {
        return this.mResolved;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public boolean isResolvedVertically() {
        return this.mResolved;
    }

    public void markWidgets() {
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (this.mAllowsGoneWidget || constraintWidget.allowedInBarrier()) {
                int i6 = this.mBarrierType;
                if (i6 == 0 || i6 == 1) {
                    constraintWidget.setInBarrier(0, true);
                } else if (i6 == 2 || i6 == 3) {
                    constraintWidget.setInBarrier(1, true);
                }
            }
        }
    }

    public void setAllowsGoneWidget(boolean z9) {
        this.mAllowsGoneWidget = z9;
    }

    public void setBarrierType(int i) {
        this.mBarrierType = i;
    }

    public void setMargin(int i) {
        this.mMargin = i;
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public String toString() {
        String str = "[Barrier] " + getDebugName() + " {";
        for (int i = 0; i < this.mWidgetsCount; i++) {
            ConstraintWidget constraintWidget = this.mWidgets[i];
            if (i > 0) {
                str = str.concat(", ");
            }
            StringBuilder t9 = x.t(str);
            t9.append(constraintWidget.getDebugName());
            str = t9.toString();
        }
        return str.concat("}");
    }

    public Barrier() {
    }
}
