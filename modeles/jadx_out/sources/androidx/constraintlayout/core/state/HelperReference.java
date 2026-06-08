package androidx.constraintlayout.core.state;

import androidx.constraintlayout.core.state.State;
import androidx.constraintlayout.core.state.helpers.Facade;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class HelperReference extends ConstraintReference implements Facade {
    protected final State mHelperState;
    private HelperWidget mHelperWidget;
    protected ArrayList<Object> mReferences;
    final State.Helper mType;

    public HelperReference(State state, State.Helper helper) {
        super(state);
        this.mReferences = new ArrayList<>();
        this.mHelperState = state;
        this.mType = helper;
    }

    public HelperReference add(Object... objArr) {
        Collections.addAll(this.mReferences, objArr);
        return this;
    }

    public void applyBase() {
        super.apply();
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public ConstraintWidget getConstraintWidget() {
        return getHelperWidget();
    }

    public HelperWidget getHelperWidget() {
        return this.mHelperWidget;
    }

    public State.Helper getType() {
        return this.mType;
    }

    public void setHelperWidget(HelperWidget helperWidget) {
        this.mHelperWidget = helperWidget;
    }

    @Override // androidx.constraintlayout.core.state.ConstraintReference, androidx.constraintlayout.core.state.Reference
    public void apply() {
    }
}
