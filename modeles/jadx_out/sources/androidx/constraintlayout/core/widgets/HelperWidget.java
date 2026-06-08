package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.widgets.analyzer.Grouping;
import androidx.constraintlayout.core.widgets.analyzer.WidgetGroup;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class HelperWidget extends ConstraintWidget implements Helper {
    public ConstraintWidget[] mWidgets = new ConstraintWidget[4];
    public int mWidgetsCount = 0;

    @Override // androidx.constraintlayout.core.widgets.Helper
    public void add(ConstraintWidget constraintWidget) {
        if (constraintWidget == this || constraintWidget == null) {
            return;
        }
        int i = this.mWidgetsCount + 1;
        ConstraintWidget[] constraintWidgetArr = this.mWidgets;
        if (i > constraintWidgetArr.length) {
            this.mWidgets = (ConstraintWidget[]) Arrays.copyOf(constraintWidgetArr, constraintWidgetArr.length * 2);
        }
        ConstraintWidget[] constraintWidgetArr2 = this.mWidgets;
        int i6 = this.mWidgetsCount;
        constraintWidgetArr2[i6] = constraintWidget;
        this.mWidgetsCount = i6 + 1;
    }

    public void addDependents(ArrayList<WidgetGroup> arrayList, int i, WidgetGroup widgetGroup) {
        for (int i6 = 0; i6 < this.mWidgetsCount; i6++) {
            widgetGroup.add(this.mWidgets[i6]);
        }
        for (int i10 = 0; i10 < this.mWidgetsCount; i10++) {
            Grouping.findDependents(this.mWidgets[i10], i, arrayList, widgetGroup);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        HelperWidget helperWidget = (HelperWidget) constraintWidget;
        this.mWidgetsCount = 0;
        int i = helperWidget.mWidgetsCount;
        for (int i6 = 0; i6 < i; i6++) {
            add(hashMap.get(helperWidget.mWidgets[i6]));
        }
    }

    public int findGroupInDependents(int i) {
        int i6;
        int i10;
        for (int i11 = 0; i11 < this.mWidgetsCount; i11++) {
            ConstraintWidget constraintWidget = this.mWidgets[i11];
            if (i == 0 && (i10 = constraintWidget.horizontalGroup) != -1) {
                return i10;
            }
            if (i == 1 && (i6 = constraintWidget.verticalGroup) != -1) {
                return i6;
            }
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.widgets.Helper
    public void removeAllIds() {
        this.mWidgetsCount = 0;
        Arrays.fill(this.mWidgets, (Object) null);
    }

    @Override // androidx.constraintlayout.core.widgets.Helper
    public void updateConstraints(ConstraintWidgetContainer constraintWidgetContainer) {
    }
}
