package androidx.constraintlayout.core;

import a4.x;
import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;
import java.util.Comparator;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class PriorityGoalRow extends ArrayRow {
    private static final boolean DEBUG = false;
    private static final float EPSILON = 1.0E-4f;
    static final int NOT_FOUND = -1;
    GoalVariableAccessor mAccessor;
    private SolverVariable[] mArrayGoals;
    Cache mCache;
    private int mNumGoals;
    private SolverVariable[] mSortArray;
    private int mTableSize;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public class GoalVariableAccessor {
        PriorityGoalRow mRow;
        SolverVariable mVariable;

        public GoalVariableAccessor(PriorityGoalRow priorityGoalRow) {
            this.mRow = priorityGoalRow;
        }

        public void add(SolverVariable solverVariable) {
            for (int i = 0; i < 9; i++) {
                float[] fArr = this.mVariable.mGoalStrengthVector;
                float f = fArr[i] + solverVariable.mGoalStrengthVector[i];
                fArr[i] = f;
                if (Math.abs(f) < 1.0E-4f) {
                    this.mVariable.mGoalStrengthVector[i] = 0.0f;
                }
            }
        }

        public boolean addToGoal(SolverVariable solverVariable, float f) {
            boolean z9 = true;
            if (!this.mVariable.inGoal) {
                for (int i = 0; i < 9; i++) {
                    float f10 = solverVariable.mGoalStrengthVector[i];
                    if (f10 != 0.0f) {
                        float f11 = f10 * f;
                        if (Math.abs(f11) < 1.0E-4f) {
                            f11 = 0.0f;
                        }
                        this.mVariable.mGoalStrengthVector[i] = f11;
                    } else {
                        this.mVariable.mGoalStrengthVector[i] = 0.0f;
                    }
                }
                return true;
            }
            for (int i6 = 0; i6 < 9; i6++) {
                float[] fArr = this.mVariable.mGoalStrengthVector;
                float f12 = (solverVariable.mGoalStrengthVector[i6] * f) + fArr[i6];
                fArr[i6] = f12;
                if (Math.abs(f12) < 1.0E-4f) {
                    this.mVariable.mGoalStrengthVector[i6] = 0.0f;
                } else {
                    z9 = false;
                }
            }
            if (z9) {
                PriorityGoalRow.this.removeGoal(this.mVariable);
            }
            return false;
        }

        public void init(SolverVariable solverVariable) {
            this.mVariable = solverVariable;
        }

        public final boolean isNegative() {
            for (int i = 8; i >= 0; i--) {
                float f = this.mVariable.mGoalStrengthVector[i];
                if (f > 0.0f) {
                    return false;
                }
                if (f < 0.0f) {
                    return true;
                }
            }
            return false;
        }

        public final boolean isNull() {
            for (int i = 0; i < 9; i++) {
                if (this.mVariable.mGoalStrengthVector[i] != 0.0f) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isSmallerThan(SolverVariable solverVariable) {
            int i = 8;
            while (true) {
                if (i < 0) {
                    break;
                }
                float f = solverVariable.mGoalStrengthVector[i];
                float f10 = this.mVariable.mGoalStrengthVector[i];
                if (f10 == f) {
                    i--;
                } else if (f10 < f) {
                    return true;
                }
            }
            return false;
        }

        public void reset() {
            Arrays.fill(this.mVariable.mGoalStrengthVector, 0.0f);
        }

        public String toString() {
            String str = "[ ";
            if (this.mVariable != null) {
                for (int i = 0; i < 9; i++) {
                    StringBuilder t9 = x.t(str);
                    t9.append(this.mVariable.mGoalStrengthVector[i]);
                    t9.append(" ");
                    str = t9.toString();
                }
            }
            StringBuilder u7 = x.u(str, "] ");
            u7.append(this.mVariable);
            return u7.toString();
        }
    }

    public PriorityGoalRow(Cache cache) {
        super(cache);
        this.mTableSize = 128;
        this.mArrayGoals = new SolverVariable[128];
        this.mSortArray = new SolverVariable[128];
        this.mNumGoals = 0;
        this.mAccessor = new GoalVariableAccessor(this);
        this.mCache = cache;
    }

    private void addToGoal(SolverVariable solverVariable) {
        int i;
        SolverVariable[] solverVariableArr;
        int i6 = this.mNumGoals + 1;
        SolverVariable[] solverVariableArr2 = this.mArrayGoals;
        if (i6 > solverVariableArr2.length) {
            SolverVariable[] solverVariableArr3 = (SolverVariable[]) Arrays.copyOf(solverVariableArr2, solverVariableArr2.length * 2);
            this.mArrayGoals = solverVariableArr3;
            this.mSortArray = (SolverVariable[]) Arrays.copyOf(solverVariableArr3, solverVariableArr3.length * 2);
        }
        SolverVariable[] solverVariableArr4 = this.mArrayGoals;
        int i10 = this.mNumGoals;
        solverVariableArr4[i10] = solverVariable;
        int i11 = i10 + 1;
        this.mNumGoals = i11;
        if (i11 > 1 && solverVariableArr4[i10].id > solverVariable.id) {
            int i12 = 0;
            while (true) {
                i = this.mNumGoals;
                solverVariableArr = this.mSortArray;
                if (i12 >= i) {
                    break;
                }
                solverVariableArr[i12] = this.mArrayGoals[i12];
                i12++;
            }
            Arrays.sort(solverVariableArr, 0, i, new Comparator<SolverVariable>() { // from class: androidx.constraintlayout.core.PriorityGoalRow.1
                @Override // java.util.Comparator
                public int compare(SolverVariable solverVariable2, SolverVariable solverVariable3) {
                    return solverVariable2.id - solverVariable3.id;
                }
            });
            for (int i13 = 0; i13 < this.mNumGoals; i13++) {
                this.mArrayGoals[i13] = this.mSortArray[i13];
            }
        }
        solverVariable.inGoal = true;
        solverVariable.addToRow(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void removeGoal(SolverVariable solverVariable) {
        int i = 0;
        while (i < this.mNumGoals) {
            if (this.mArrayGoals[i] == solverVariable) {
                while (true) {
                    int i6 = this.mNumGoals;
                    if (i >= i6 - 1) {
                        this.mNumGoals = i6 - 1;
                        solverVariable.inGoal = false;
                        return;
                    } else {
                        SolverVariable[] solverVariableArr = this.mArrayGoals;
                        int i10 = i + 1;
                        solverVariableArr[i] = solverVariableArr[i10];
                        i = i10;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void addError(SolverVariable solverVariable) {
        this.mAccessor.init(solverVariable);
        this.mAccessor.reset();
        solverVariable.mGoalStrengthVector[solverVariable.strength] = 1.0f;
        addToGoal(solverVariable);
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void clear() {
        this.mNumGoals = 0;
        this.mConstantValue = 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr) {
        int i = -1;
        for (int i6 = 0; i6 < this.mNumGoals; i6++) {
            SolverVariable solverVariable = this.mArrayGoals[i6];
            if (!zArr[solverVariable.id]) {
                this.mAccessor.init(solverVariable);
                GoalVariableAccessor goalVariableAccessor = this.mAccessor;
                if (i == -1) {
                    if (!goalVariableAccessor.isNegative()) {
                    }
                    i = i6;
                } else {
                    if (!goalVariableAccessor.isSmallerThan(this.mArrayGoals[i])) {
                    }
                    i = i6;
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.mArrayGoals[i];
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public boolean isEmpty() {
        return this.mNumGoals == 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow
    public String toString() {
        String str = " goal -> (" + this.mConstantValue + ") : ";
        for (int i = 0; i < this.mNumGoals; i++) {
            this.mAccessor.init(this.mArrayGoals[i]);
            StringBuilder t9 = x.t(str);
            t9.append(this.mAccessor);
            t9.append(" ");
            str = t9.toString();
        }
        return str;
    }

    @Override // androidx.constraintlayout.core.ArrayRow, androidx.constraintlayout.core.LinearSystem.Row
    public void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z9) {
        SolverVariable solverVariable = arrayRow.mVariable;
        if (solverVariable == null) {
            return;
        }
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i = 0; i < currentSize; i++) {
            SolverVariable variable = arrayRowVariables.getVariable(i);
            float variableValue = arrayRowVariables.getVariableValue(i);
            this.mAccessor.init(variable);
            if (this.mAccessor.addToGoal(solverVariable, variableValue)) {
                addToGoal(variable);
            }
            this.mConstantValue = (arrayRow.mConstantValue * variableValue) + this.mConstantValue;
        }
        removeGoal(solverVariable);
    }
}
