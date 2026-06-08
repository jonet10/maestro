package androidx.constraintlayout.core.widgets.analyzer;

import a4.x;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.Chain;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.lifecycle.l;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class WidgetGroup {
    private static final boolean DEBUG = false;
    static int sCount;
    int mId;
    int mOrientation;
    ArrayList<ConstraintWidget> mWidgets = new ArrayList<>();
    boolean mAuthoritative = false;
    ArrayList<MeasureResult> mResults = null;
    private int mMoveTo = -1;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class MeasureResult {
        int mBaseline;
        int mBottom;
        int mLeft;
        int mOrientation;
        int mRight;
        int mTop;
        WeakReference<ConstraintWidget> mWidgetRef;

        public MeasureResult(ConstraintWidget constraintWidget, LinearSystem linearSystem, int i) {
            this.mWidgetRef = new WeakReference<>(constraintWidget);
            this.mLeft = linearSystem.getObjectVariableValue(constraintWidget.mLeft);
            this.mTop = linearSystem.getObjectVariableValue(constraintWidget.mTop);
            this.mRight = linearSystem.getObjectVariableValue(constraintWidget.mRight);
            this.mBottom = linearSystem.getObjectVariableValue(constraintWidget.mBottom);
            this.mBaseline = linearSystem.getObjectVariableValue(constraintWidget.mBaseline);
            this.mOrientation = i;
        }

        public void apply() {
            ConstraintWidget constraintWidget = this.mWidgetRef.get();
            if (constraintWidget != null) {
                constraintWidget.setFinalFrame(this.mLeft, this.mTop, this.mRight, this.mBottom, this.mBaseline, this.mOrientation);
            }
        }
    }

    public WidgetGroup(int i) {
        int i6 = sCount;
        sCount = i6 + 1;
        this.mId = i6;
        this.mOrientation = i;
    }

    private boolean contains(ConstraintWidget constraintWidget) {
        return this.mWidgets.contains(constraintWidget);
    }

    private String getOrientationString() {
        int i = this.mOrientation;
        return i == 0 ? "Horizontal" : i == 1 ? "Vertical" : i == 2 ? "Both" : "Unknown";
    }

    private int measureWrap(int i, ConstraintWidget constraintWidget) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = constraintWidget.getDimensionBehaviour(i);
        if (dimensionBehaviour == ConstraintWidget.DimensionBehaviour.WRAP_CONTENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.MATCH_PARENT || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED) {
            return i == 0 ? constraintWidget.getWidth() : constraintWidget.getHeight();
        }
        return -1;
    }

    private int solverMeasure(LinearSystem linearSystem, ArrayList<ConstraintWidget> arrayList, int i) {
        int objectVariableValue;
        int objectVariableValue2;
        ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) arrayList.get(0).getParent();
        linearSystem.reset();
        constraintWidgetContainer.addToSolver(linearSystem, false);
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            arrayList.get(i6).addToSolver(linearSystem, false);
        }
        if (i == 0 && constraintWidgetContainer.mHorizontalChainsSize > 0) {
            Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 0);
        }
        if (i == 1 && constraintWidgetContainer.mVerticalChainsSize > 0) {
            Chain.applyChainConstraints(constraintWidgetContainer, linearSystem, arrayList, 1);
        }
        try {
            linearSystem.minimize();
        } catch (Exception e10) {
            System.err.println(e10.toString() + "\n" + Arrays.toString(e10.getStackTrace()).replace("[", "   at ").replace(",", "\n   at").replace("]", ""));
        }
        this.mResults = new ArrayList<>();
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            this.mResults.add(new MeasureResult(arrayList.get(i10), linearSystem, i));
        }
        if (i == 0) {
            objectVariableValue = linearSystem.getObjectVariableValue(constraintWidgetContainer.mLeft);
            objectVariableValue2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mRight);
            linearSystem.reset();
        } else {
            objectVariableValue = linearSystem.getObjectVariableValue(constraintWidgetContainer.mTop);
            objectVariableValue2 = linearSystem.getObjectVariableValue(constraintWidgetContainer.mBottom);
            linearSystem.reset();
        }
        return objectVariableValue2 - objectVariableValue;
    }

    public boolean add(ConstraintWidget constraintWidget) {
        if (this.mWidgets.contains(constraintWidget)) {
            return false;
        }
        this.mWidgets.add(constraintWidget);
        return true;
    }

    public void apply() {
        if (this.mResults != null && this.mAuthoritative) {
            for (int i = 0; i < this.mResults.size(); i++) {
                this.mResults.get(i).apply();
            }
        }
    }

    public void cleanup(ArrayList<WidgetGroup> arrayList) {
        int size = this.mWidgets.size();
        if (this.mMoveTo != -1 && size > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                WidgetGroup widgetGroup = arrayList.get(i);
                if (this.mMoveTo == widgetGroup.mId) {
                    moveTo(this.mOrientation, widgetGroup);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public void clear() {
        this.mWidgets.clear();
    }

    public int getId() {
        return this.mId;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean intersectWith(WidgetGroup widgetGroup) {
        for (int i = 0; i < this.mWidgets.size(); i++) {
            if (widgetGroup.contains(this.mWidgets.get(i))) {
                return true;
            }
        }
        return false;
    }

    public boolean isAuthoritative() {
        return this.mAuthoritative;
    }

    public void moveTo(int i, WidgetGroup widgetGroup) {
        ArrayList<ConstraintWidget> arrayList = this.mWidgets;
        int size = arrayList.size();
        int i6 = 0;
        while (i6 < size) {
            ConstraintWidget constraintWidget = arrayList.get(i6);
            i6++;
            ConstraintWidget constraintWidget2 = constraintWidget;
            widgetGroup.add(constraintWidget2);
            if (i == 0) {
                constraintWidget2.horizontalGroup = widgetGroup.getId();
            } else {
                constraintWidget2.verticalGroup = widgetGroup.getId();
            }
        }
        this.mMoveTo = widgetGroup.mId;
    }

    public void setAuthoritative(boolean z9) {
        this.mAuthoritative = z9;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public int size() {
        return this.mWidgets.size();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getOrientationString());
        sb.append(" [");
        String x3 = l.x(sb, "] <", this.mId);
        ArrayList<ConstraintWidget> arrayList = this.mWidgets;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            ConstraintWidget constraintWidget = arrayList.get(i);
            i++;
            StringBuilder u7 = x.u(x3, " ");
            u7.append(constraintWidget.getDebugName());
            x3 = u7.toString();
        }
        return x3.concat(" >");
    }

    public int measureWrap(LinearSystem linearSystem, int i) {
        if (this.mWidgets.size() == 0) {
            return 0;
        }
        return solverMeasure(linearSystem, this.mWidgets, i);
    }
}
