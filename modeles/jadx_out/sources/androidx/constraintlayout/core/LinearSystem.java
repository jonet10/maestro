package androidx.constraintlayout.core;

import a4.x;
import androidx.constraintlayout.core.SolverVariable;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.lifecycle.l;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class LinearSystem {
    public static long ARRAY_ROW_CREATION = 0;
    public static final boolean DEBUG = false;
    private static final boolean DEBUG_CONSTRAINTS = false;
    private static final boolean DO_NOT_USE = false;
    public static final boolean FULL_DEBUG = false;
    public static long OPTIMIZED_ARRAY_ROW_CREATION = 0;
    public static boolean OPTIMIZED_ENGINE = false;
    public static boolean SIMPLIFY_SYNONYMS = true;
    public static boolean SKIP_COLUMNS = true;
    public static boolean USE_BASIC_SYNONYMS = true;
    public static boolean USE_DEPENDENCY_ORDERING = false;
    public static boolean USE_SYNONYMS = true;
    public static Metrics sMetrics;
    final Cache mCache;
    private Row mGoal;
    private Row mTempGoal;
    private int mPoolSize = 1000;
    public boolean hasSimpleDefinition = false;
    int mVariablesID = 0;
    private HashMap<String, SolverVariable> mVariables = null;
    private int mTableSize = 32;
    private int mMaxColumns = 32;
    public boolean graphOptimizer = false;
    public boolean newgraphOptimizer = false;
    private boolean[] mAlreadyTestedCandidates = new boolean[32];
    int mNumColumns = 1;
    int mNumRows = 0;
    private int mMaxRows = 32;
    private SolverVariable[] mPoolVariables = new SolverVariable[1000];
    private int mPoolVariablesCount = 0;
    ArrayRow[] mRows = new ArrayRow[32];

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public interface Row {
        void addError(SolverVariable solverVariable);

        void clear();

        SolverVariable getKey();

        SolverVariable getPivotCandidate(LinearSystem linearSystem, boolean[] zArr);

        void initFromRow(Row row);

        boolean isEmpty();

        void updateFromFinalVariable(LinearSystem linearSystem, SolverVariable solverVariable, boolean z9);

        void updateFromRow(LinearSystem linearSystem, ArrayRow arrayRow, boolean z9);

        void updateFromSystem(LinearSystem linearSystem);
    }

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class ValuesRow extends ArrayRow {
        public ValuesRow(Cache cache) {
            this.variables = new SolverVariableValues(this, cache);
        }
    }

    public LinearSystem() {
        releaseRows();
        Cache cache = new Cache();
        this.mCache = cache;
        this.mGoal = new PriorityGoalRow(cache);
        if (OPTIMIZED_ENGINE) {
            this.mTempGoal = new ValuesRow(cache);
        } else {
            this.mTempGoal = new ArrayRow(cache);
        }
    }

    private SolverVariable acquireSolverVariable(SolverVariable.Type type, String str) {
        SolverVariable acquire = this.mCache.mSolverVariablePool.acquire();
        if (acquire == null) {
            acquire = new SolverVariable(type, str);
            acquire.setType(type, str);
        } else {
            acquire.reset();
            acquire.setType(type, str);
        }
        int i = this.mPoolVariablesCount;
        int i6 = this.mPoolSize;
        if (i >= i6) {
            int i10 = i6 * 2;
            this.mPoolSize = i10;
            this.mPoolVariables = (SolverVariable[]) Arrays.copyOf(this.mPoolVariables, i10);
        }
        SolverVariable[] solverVariableArr = this.mPoolVariables;
        int i11 = this.mPoolVariablesCount;
        this.mPoolVariablesCount = i11 + 1;
        solverVariableArr[i11] = acquire;
        return acquire;
    }

    private void addRow(ArrayRow arrayRow) {
        int i;
        if (SIMPLIFY_SYNONYMS && arrayRow.mIsSimpleDefinition) {
            arrayRow.mVariable.setFinalValue(this, arrayRow.mConstantValue);
        } else {
            ArrayRow[] arrayRowArr = this.mRows;
            int i6 = this.mNumRows;
            arrayRowArr[i6] = arrayRow;
            SolverVariable solverVariable = arrayRow.mVariable;
            solverVariable.mDefinitionId = i6;
            this.mNumRows = i6 + 1;
            solverVariable.updateReferencesWithNewDefinition(this, arrayRow);
        }
        if (SIMPLIFY_SYNONYMS && this.hasSimpleDefinition) {
            int i10 = 0;
            while (i10 < this.mNumRows) {
                if (this.mRows[i10] == null) {
                    System.out.println("WTF");
                }
                ArrayRow arrayRow2 = this.mRows[i10];
                if (arrayRow2 != null && arrayRow2.mIsSimpleDefinition) {
                    arrayRow2.mVariable.setFinalValue(this, arrayRow2.mConstantValue);
                    boolean z9 = OPTIMIZED_ENGINE;
                    Cache cache = this.mCache;
                    if (z9) {
                        cache.mOptimizedArrayRowPool.release(arrayRow2);
                    } else {
                        cache.mArrayRowPool.release(arrayRow2);
                    }
                    this.mRows[i10] = null;
                    int i11 = i10 + 1;
                    int i12 = i11;
                    while (true) {
                        i = this.mNumRows;
                        if (i11 >= i) {
                            break;
                        }
                        ArrayRow[] arrayRowArr2 = this.mRows;
                        int i13 = i11 - 1;
                        ArrayRow arrayRow3 = arrayRowArr2[i11];
                        arrayRowArr2[i13] = arrayRow3;
                        SolverVariable solverVariable2 = arrayRow3.mVariable;
                        if (solverVariable2.mDefinitionId == i11) {
                            solverVariable2.mDefinitionId = i13;
                        }
                        i12 = i11;
                        i11++;
                    }
                    if (i12 < i) {
                        this.mRows[i12] = null;
                    }
                    this.mNumRows = i - 1;
                    i10--;
                }
                i10++;
            }
            this.hasSimpleDefinition = false;
        }
    }

    private void computeValues() {
        for (int i = 0; i < this.mNumRows; i++) {
            ArrayRow arrayRow = this.mRows[i];
            arrayRow.mVariable.computedValue = arrayRow.mConstantValue;
        }
    }

    public static ArrayRow createRowDimensionPercent(LinearSystem linearSystem, SolverVariable solverVariable, SolverVariable solverVariable2, float f) {
        return linearSystem.createRow().createRowDimensionPercent(solverVariable, solverVariable2, f);
    }

    private SolverVariable createVariable(String str, SolverVariable.Type type) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.variables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(type, null);
        acquireSolverVariable.setName(str);
        int i = this.mVariablesID + 1;
        this.mVariablesID = i;
        this.mNumColumns++;
        acquireSolverVariable.id = i;
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        this.mVariables.put(str, acquireSolverVariable);
        this.mCache.mIndexedVariables[this.mVariablesID] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    private void displayRows() {
        displaySolverVariables();
        String str = "";
        for (int i = 0; i < this.mNumRows; i++) {
            StringBuilder t9 = x.t(str);
            t9.append(this.mRows[i]);
            str = t9.toString().concat("\n");
        }
        StringBuilder t10 = x.t(str);
        t10.append(this.mGoal);
        t10.append("\n");
        System.out.println(t10.toString());
    }

    private void displaySolverVariables() {
        StringBuilder sb = new StringBuilder("Display Rows (");
        sb.append(this.mNumRows);
        sb.append("x");
        System.out.println(l.x(sb, ")\n", this.mNumColumns));
    }

    private int enforceBFS(Row row) throws Exception {
        float f;
        long j;
        for (int i = 0; i < this.mNumRows; i++) {
            ArrayRow arrayRow = this.mRows[i];
            if (arrayRow.mVariable.mType != SolverVariable.Type.UNRESTRICTED) {
                float f10 = 0.0f;
                if (arrayRow.mConstantValue < 0.0f) {
                    boolean z9 = false;
                    int i6 = 0;
                    while (!z9) {
                        Metrics metrics = sMetrics;
                        long j6 = 1;
                        if (metrics != null) {
                            metrics.bfs++;
                        }
                        i6++;
                        float f11 = Float.MAX_VALUE;
                        int i10 = 0;
                        int i11 = -1;
                        int i12 = -1;
                        int i13 = 0;
                        while (true) {
                            if (i10 >= this.mNumRows) {
                                break;
                            }
                            ArrayRow arrayRow2 = this.mRows[i10];
                            if (arrayRow2.mVariable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow2.mIsSimpleDefinition && arrayRow2.mConstantValue < f10) {
                                if (SKIP_COLUMNS) {
                                    int currentSize = arrayRow2.variables.getCurrentSize();
                                    int i14 = 0;
                                    while (i14 < currentSize) {
                                        float f12 = f10;
                                        SolverVariable variable = arrayRow2.variables.getVariable(i14);
                                        long j10 = j6;
                                        float f13 = arrayRow2.variables.get(variable);
                                        if (f13 > f12) {
                                            for (int i15 = 0; i15 < 9; i15++) {
                                                float f14 = variable.mStrengthVector[i15] / f13;
                                                if ((f14 < f11 && i15 == i13) || i15 > i13) {
                                                    i13 = i15;
                                                    i12 = variable.id;
                                                    i11 = i10;
                                                    f11 = f14;
                                                }
                                            }
                                        }
                                        i14++;
                                        f10 = f12;
                                        j6 = j10;
                                    }
                                } else {
                                    f = f10;
                                    j = j6;
                                    for (int i16 = 1; i16 < this.mNumColumns; i16++) {
                                        SolverVariable solverVariable = this.mCache.mIndexedVariables[i16];
                                        float f15 = arrayRow2.variables.get(solverVariable);
                                        if (f15 > f) {
                                            for (int i17 = 0; i17 < 9; i17++) {
                                                float f16 = solverVariable.mStrengthVector[i17] / f15;
                                                if ((f16 < f11 && i17 == i13) || i17 > i13) {
                                                    i13 = i17;
                                                    f11 = f16;
                                                    i11 = i10;
                                                    i12 = i16;
                                                }
                                            }
                                        }
                                    }
                                    i10++;
                                    f10 = f;
                                    j6 = j;
                                }
                            }
                            f = f10;
                            j = j6;
                            i10++;
                            f10 = f;
                            j6 = j;
                        }
                        float f17 = f10;
                        long j11 = j6;
                        if (i11 != -1) {
                            ArrayRow arrayRow3 = this.mRows[i11];
                            arrayRow3.mVariable.mDefinitionId = -1;
                            Metrics metrics2 = sMetrics;
                            if (metrics2 != null) {
                                metrics2.pivots += j11;
                            }
                            arrayRow3.pivot(this.mCache.mIndexedVariables[i12]);
                            SolverVariable solverVariable2 = arrayRow3.mVariable;
                            solverVariable2.mDefinitionId = i11;
                            solverVariable2.updateReferencesWithNewDefinition(this, arrayRow3);
                        } else {
                            z9 = true;
                        }
                        if (i6 > this.mNumColumns / 2) {
                            z9 = true;
                        }
                        f10 = f17;
                    }
                    return i6;
                }
            }
        }
        return 0;
    }

    private String getDisplaySize(int i) {
        int i6 = i * 4;
        int i10 = i6 / 1024;
        int i11 = i10 / 1024;
        return i11 > 0 ? x.g(i11, "", " Mb") : i10 > 0 ? x.g(i10, "", " Kb") : x.g(i6, "", " bytes");
    }

    private String getDisplayStrength(int i) {
        return i == 1 ? "LOW" : i == 2 ? "MEDIUM" : i == 3 ? "HIGH" : i == 4 ? "HIGHEST" : i == 5 ? "EQUALITY" : i == 8 ? "FIXED" : i == 6 ? "BARRIER" : "NONE";
    }

    public static Metrics getMetrics() {
        return sMetrics;
    }

    private void increaseTableSize() {
        int i = this.mTableSize * 2;
        this.mTableSize = i;
        this.mRows = (ArrayRow[]) Arrays.copyOf(this.mRows, i);
        Cache cache = this.mCache;
        cache.mIndexedVariables = (SolverVariable[]) Arrays.copyOf(cache.mIndexedVariables, this.mTableSize);
        int i6 = this.mTableSize;
        this.mAlreadyTestedCandidates = new boolean[i6];
        this.mMaxColumns = i6;
        this.mMaxRows = i6;
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.tableSizeIncrease++;
            metrics.maxTableSize = Math.max(metrics.maxTableSize, i6);
            Metrics metrics2 = sMetrics;
            metrics2.lastTableSize = metrics2.maxTableSize;
        }
    }

    private int optimize(Row row, boolean z9) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.optimize++;
        }
        for (int i = 0; i < this.mNumColumns; i++) {
            this.mAlreadyTestedCandidates[i] = false;
        }
        boolean z10 = false;
        int i6 = 0;
        while (!z10) {
            Metrics metrics2 = sMetrics;
            if (metrics2 != null) {
                metrics2.iterations++;
            }
            i6++;
            if (i6 < this.mNumColumns * 2) {
                if (row.getKey() != null) {
                    this.mAlreadyTestedCandidates[row.getKey().id] = true;
                }
                SolverVariable pivotCandidate = row.getPivotCandidate(this, this.mAlreadyTestedCandidates);
                if (pivotCandidate != null) {
                    boolean[] zArr = this.mAlreadyTestedCandidates;
                    int i10 = pivotCandidate.id;
                    if (!zArr[i10]) {
                        zArr[i10] = true;
                    }
                }
                if (pivotCandidate != null) {
                    float f = Float.MAX_VALUE;
                    int i11 = -1;
                    for (int i12 = 0; i12 < this.mNumRows; i12++) {
                        ArrayRow arrayRow = this.mRows[i12];
                        if (arrayRow.mVariable.mType != SolverVariable.Type.UNRESTRICTED && !arrayRow.mIsSimpleDefinition && arrayRow.hasVariable(pivotCandidate)) {
                            float f10 = arrayRow.variables.get(pivotCandidate);
                            if (f10 < 0.0f) {
                                float f11 = (-arrayRow.mConstantValue) / f10;
                                if (f11 < f) {
                                    i11 = i12;
                                    f = f11;
                                }
                            }
                        }
                    }
                    if (i11 > -1) {
                        ArrayRow arrayRow2 = this.mRows[i11];
                        arrayRow2.mVariable.mDefinitionId = -1;
                        Metrics metrics3 = sMetrics;
                        if (metrics3 != null) {
                            metrics3.pivots++;
                        }
                        arrayRow2.pivot(pivotCandidate);
                        SolverVariable solverVariable = arrayRow2.mVariable;
                        solverVariable.mDefinitionId = i11;
                        solverVariable.updateReferencesWithNewDefinition(this, arrayRow2);
                    }
                } else {
                    z10 = true;
                }
            }
            return i6;
        }
        return i6;
    }

    private void releaseRows() {
        int i = 0;
        if (OPTIMIZED_ENGINE) {
            while (i < this.mNumRows) {
                ArrayRow arrayRow = this.mRows[i];
                if (arrayRow != null) {
                    this.mCache.mOptimizedArrayRowPool.release(arrayRow);
                }
                this.mRows[i] = null;
                i++;
            }
            return;
        }
        while (i < this.mNumRows) {
            ArrayRow arrayRow2 = this.mRows[i];
            if (arrayRow2 != null) {
                this.mCache.mArrayRowPool.release(arrayRow2);
            }
            this.mRows[i] = null;
            i++;
        }
    }

    public void addCenterPoint(ConstraintWidget constraintWidget, ConstraintWidget constraintWidget2, float f, int i) {
        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
        SolverVariable createObjectVariable = createObjectVariable(constraintWidget.getAnchor(type));
        ConstraintAnchor.Type type2 = ConstraintAnchor.Type.TOP;
        SolverVariable createObjectVariable2 = createObjectVariable(constraintWidget.getAnchor(type2));
        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.RIGHT;
        SolverVariable createObjectVariable3 = createObjectVariable(constraintWidget.getAnchor(type3));
        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
        SolverVariable createObjectVariable4 = createObjectVariable(constraintWidget.getAnchor(type4));
        SolverVariable createObjectVariable5 = createObjectVariable(constraintWidget2.getAnchor(type));
        SolverVariable createObjectVariable6 = createObjectVariable(constraintWidget2.getAnchor(type2));
        SolverVariable createObjectVariable7 = createObjectVariable(constraintWidget2.getAnchor(type3));
        SolverVariable createObjectVariable8 = createObjectVariable(constraintWidget2.getAnchor(type4));
        ArrayRow createRow = createRow();
        double d10 = f;
        double d11 = i;
        createRow.createRowWithAngle(createObjectVariable2, createObjectVariable4, createObjectVariable6, createObjectVariable8, (float) (Math.sin(d10) * d11));
        addConstraint(createRow);
        ArrayRow createRow2 = createRow();
        createRow2.createRowWithAngle(createObjectVariable, createObjectVariable3, createObjectVariable5, createObjectVariable7, (float) (Math.cos(d10) * d11));
        addConstraint(createRow2);
    }

    public void addCentering(SolverVariable solverVariable, SolverVariable solverVariable2, int i, float f, SolverVariable solverVariable3, SolverVariable solverVariable4, int i6, int i10) {
        ArrayRow createRow = createRow();
        createRow.createRowCentering(solverVariable, solverVariable2, i, f, solverVariable3, solverVariable4, i6);
        if (i10 != 8) {
            createRow.addError(this, i10);
        }
        addConstraint(createRow);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:40:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void addConstraint(androidx.constraintlayout.core.ArrayRow r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L4
            goto La6
        L4:
            androidx.constraintlayout.core.Metrics r0 = androidx.constraintlayout.core.LinearSystem.sMetrics
            r1 = 1
            if (r0 == 0) goto L18
            long r3 = r0.constraints
            long r3 = r3 + r1
            r0.constraints = r3
            boolean r3 = r8.mIsSimpleDefinition
            if (r3 == 0) goto L18
            long r3 = r0.simpleconstraints
            long r3 = r3 + r1
            r0.simpleconstraints = r3
        L18:
            int r0 = r7.mNumRows
            r3 = 1
            int r0 = r0 + r3
            int r4 = r7.mMaxRows
            if (r0 >= r4) goto L27
            int r0 = r7.mNumColumns
            int r0 = r0 + r3
            int r4 = r7.mMaxColumns
            if (r0 < r4) goto L2a
        L27:
            r7.increaseTableSize()
        L2a:
            boolean r0 = r8.mIsSimpleDefinition
            r4 = 0
            if (r0 != 0) goto La1
            r8.updateFromSystem(r7)
            boolean r0 = r8.isEmpty()
            if (r0 == 0) goto L3a
            goto La6
        L3a:
            r8.ensurePositiveConstant()
            boolean r0 = r8.chooseSubject(r7)
            if (r0 == 0) goto L98
            androidx.constraintlayout.core.SolverVariable r0 = r7.createExtraVariable()
            r8.mVariable = r0
            int r5 = r7.mNumRows
            r7.addRow(r8)
            int r6 = r7.mNumRows
            int r5 = r5 + r3
            if (r6 != r5) goto L98
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.mTempGoal
            r4.initFromRow(r8)
            androidx.constraintlayout.core.LinearSystem$Row r4 = r7.mTempGoal
            r7.optimize(r4, r3)
            int r4 = r0.mDefinitionId
            r5 = -1
            if (r4 != r5) goto L99
            androidx.constraintlayout.core.SolverVariable r4 = r8.mVariable
            if (r4 != r0) goto L78
            androidx.constraintlayout.core.SolverVariable r0 = r8.pickPivot(r0)
            if (r0 == 0) goto L78
            androidx.constraintlayout.core.Metrics r4 = androidx.constraintlayout.core.LinearSystem.sMetrics
            if (r4 == 0) goto L75
            long r5 = r4.pivots
            long r5 = r5 + r1
            r4.pivots = r5
        L75:
            r8.pivot(r0)
        L78:
            boolean r0 = r8.mIsSimpleDefinition
            if (r0 != 0) goto L81
            androidx.constraintlayout.core.SolverVariable r0 = r8.mVariable
            r0.updateReferencesWithNewDefinition(r7, r8)
        L81:
            boolean r0 = androidx.constraintlayout.core.LinearSystem.OPTIMIZED_ENGINE
            androidx.constraintlayout.core.Cache r1 = r7.mCache
            if (r0 == 0) goto L8d
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r1.mOptimizedArrayRowPool
            r0.release(r8)
            goto L92
        L8d:
            androidx.constraintlayout.core.Pools$Pool<androidx.constraintlayout.core.ArrayRow> r0 = r1.mArrayRowPool
            r0.release(r8)
        L92:
            int r0 = r7.mNumRows
            int r0 = r0 - r3
            r7.mNumRows = r0
            goto L99
        L98:
            r3 = r4
        L99:
            boolean r0 = r8.hasKeyVariable()
            if (r0 != 0) goto La0
            goto La6
        La0:
            r4 = r3
        La1:
            if (r4 != 0) goto La6
            r7.addRow(r8)
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.LinearSystem.addConstraint(androidx.constraintlayout.core.ArrayRow):void");
    }

    public void addEquality(SolverVariable solverVariable, int i) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.mSimpleEquations++;
        }
        if (USE_BASIC_SYNONYMS && solverVariable.mDefinitionId == -1) {
            float f = i;
            solverVariable.setFinalValue(this, f);
            for (int i6 = 0; i6 < this.mVariablesID + 1; i6++) {
                SolverVariable solverVariable2 = this.mCache.mIndexedVariables[i6];
                if (solverVariable2 != null && solverVariable2.mIsSynonym && solverVariable2.mSynonym == solverVariable.id) {
                    solverVariable2.setFinalValue(this, solverVariable2.mSynonymDelta + f);
                }
            }
            return;
        }
        int i10 = solverVariable.mDefinitionId;
        if (i10 == -1) {
            ArrayRow createRow = createRow();
            createRow.createRowDefinition(solverVariable, i);
            addConstraint(createRow);
            return;
        }
        ArrayRow arrayRow = this.mRows[i10];
        if (arrayRow.mIsSimpleDefinition) {
            arrayRow.mConstantValue = i;
            return;
        }
        if (arrayRow.variables.getCurrentSize() == 0) {
            arrayRow.mIsSimpleDefinition = true;
            arrayRow.mConstantValue = i;
        } else {
            ArrayRow createRow2 = createRow();
            createRow2.createRowEquals(solverVariable, i);
            addConstraint(createRow2);
        }
    }

    public void addGreaterBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z9) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        addConstraint(createRow);
    }

    public void addGreaterThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i6) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowGreaterThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i6 != 8) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i6);
        }
        addConstraint(createRow);
    }

    public void addLowerBarrier(SolverVariable solverVariable, SolverVariable solverVariable2, int i, boolean z9) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        addConstraint(createRow);
    }

    public void addLowerThan(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i6) {
        ArrayRow createRow = createRow();
        SolverVariable createSlackVariable = createSlackVariable();
        createSlackVariable.strength = 0;
        createRow.createRowLowerThan(solverVariable, solverVariable2, createSlackVariable, i);
        if (i6 != 8) {
            addSingleError(createRow, (int) (createRow.variables.get(createSlackVariable) * (-1.0f)), i6);
        }
        addConstraint(createRow);
    }

    public void addRatio(SolverVariable solverVariable, SolverVariable solverVariable2, SolverVariable solverVariable3, SolverVariable solverVariable4, float f, int i) {
        ArrayRow createRow = createRow();
        createRow.createRowDimensionRatio(solverVariable, solverVariable2, solverVariable3, solverVariable4, f);
        if (i != 8) {
            createRow.addError(this, i);
        }
        addConstraint(createRow);
    }

    public void addSingleError(ArrayRow arrayRow, int i, int i6) {
        arrayRow.addSingleError(createErrorVariable(i6, null), i);
    }

    public void addSynonym(SolverVariable solverVariable, SolverVariable solverVariable2, int i) {
        if (solverVariable.mDefinitionId != -1 || i != 0) {
            addEquality(solverVariable, solverVariable2, i, 8);
            return;
        }
        if (solverVariable2.mIsSynonym) {
            solverVariable2 = this.mCache.mIndexedVariables[solverVariable2.mSynonym];
        }
        if (solverVariable.mIsSynonym) {
            SolverVariable solverVariable3 = this.mCache.mIndexedVariables[solverVariable.mSynonym];
        } else {
            solverVariable.setSynonym(this, solverVariable2, 0.0f);
        }
    }

    public final void cleanupRows() {
        int i;
        ArrayRow[] arrayRowArr;
        int i6 = 0;
        while (i6 < this.mNumRows) {
            ArrayRow arrayRow = this.mRows[i6];
            if (arrayRow.variables.getCurrentSize() == 0) {
                arrayRow.mIsSimpleDefinition = true;
            }
            if (arrayRow.mIsSimpleDefinition) {
                SolverVariable solverVariable = arrayRow.mVariable;
                solverVariable.computedValue = arrayRow.mConstantValue;
                solverVariable.removeFromRow(arrayRow);
                int i10 = i6;
                while (true) {
                    i = this.mNumRows;
                    int i11 = i - 1;
                    arrayRowArr = this.mRows;
                    if (i10 >= i11) {
                        break;
                    }
                    int i12 = i10 + 1;
                    arrayRowArr[i10] = arrayRowArr[i12];
                    i10 = i12;
                }
                arrayRowArr[i - 1] = null;
                this.mNumRows = i - 1;
                i6--;
                boolean z9 = OPTIMIZED_ENGINE;
                Cache cache = this.mCache;
                if (z9) {
                    cache.mOptimizedArrayRowPool.release(arrayRow);
                } else {
                    cache.mArrayRowPool.release(arrayRow);
                }
            }
            i6++;
        }
    }

    public SolverVariable createErrorVariable(int i, String str) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.errors++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.ERROR, str);
        int i6 = this.mVariablesID + 1;
        this.mVariablesID = i6;
        this.mNumColumns++;
        acquireSolverVariable.id = i6;
        acquireSolverVariable.strength = i;
        this.mCache.mIndexedVariables[i6] = acquireSolverVariable;
        this.mGoal.addError(acquireSolverVariable);
        return acquireSolverVariable;
    }

    public SolverVariable createExtraVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.extravariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i = this.mVariablesID + 1;
        this.mVariablesID = i;
        this.mNumColumns++;
        acquireSolverVariable.id = i;
        this.mCache.mIndexedVariables[i] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public SolverVariable createObjectVariable(Object obj) {
        SolverVariable solverVariable = null;
        if (obj == null) {
            return null;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        if (obj instanceof ConstraintAnchor) {
            ConstraintAnchor constraintAnchor = (ConstraintAnchor) obj;
            solverVariable = constraintAnchor.getSolverVariable();
            if (solverVariable == null) {
                constraintAnchor.resetSolverVariable(this.mCache);
                solverVariable = constraintAnchor.getSolverVariable();
            }
            int i = solverVariable.id;
            if (i != -1 && i <= this.mVariablesID && this.mCache.mIndexedVariables[i] != null) {
                return solverVariable;
            }
            if (i != -1) {
                solverVariable.reset();
            }
            int i6 = this.mVariablesID + 1;
            this.mVariablesID = i6;
            this.mNumColumns++;
            solverVariable.id = i6;
            solverVariable.mType = SolverVariable.Type.UNRESTRICTED;
            this.mCache.mIndexedVariables[i6] = solverVariable;
        }
        return solverVariable;
    }

    public ArrayRow createRow() {
        ArrayRow acquire;
        boolean z9 = OPTIMIZED_ENGINE;
        Cache cache = this.mCache;
        if (z9) {
            acquire = cache.mOptimizedArrayRowPool.acquire();
            if (acquire == null) {
                acquire = new ValuesRow(this.mCache);
                OPTIMIZED_ARRAY_ROW_CREATION++;
            } else {
                acquire.reset();
            }
        } else {
            acquire = cache.mArrayRowPool.acquire();
            if (acquire == null) {
                acquire = new ArrayRow(this.mCache);
                ARRAY_ROW_CREATION++;
            } else {
                acquire.reset();
            }
        }
        SolverVariable.increaseErrorId();
        return acquire;
    }

    public SolverVariable createSlackVariable() {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.slackvariables++;
        }
        if (this.mNumColumns + 1 >= this.mMaxColumns) {
            increaseTableSize();
        }
        SolverVariable acquireSolverVariable = acquireSolverVariable(SolverVariable.Type.SLACK, null);
        int i = this.mVariablesID + 1;
        this.mVariablesID = i;
        this.mNumColumns++;
        acquireSolverVariable.id = i;
        this.mCache.mIndexedVariables[i] = acquireSolverVariable;
        return acquireSolverVariable;
    }

    public void displayReadableRows() {
        displaySolverVariables();
        String x3 = l.x(new StringBuilder(" num vars "), "\n", this.mVariablesID);
        for (int i = 0; i < this.mVariablesID + 1; i++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[i];
            if (solverVariable != null && solverVariable.isFinalValue) {
                x3 = x3 + " $[" + i + "] => " + solverVariable + " = " + solverVariable.computedValue + "\n";
            }
        }
        String C = x.C(x3, "\n");
        for (int i6 = 0; i6 < this.mVariablesID + 1; i6++) {
            SolverVariable[] solverVariableArr = this.mCache.mIndexedVariables;
            SolverVariable solverVariable2 = solverVariableArr[i6];
            if (solverVariable2 != null && solverVariable2.mIsSynonym) {
                C = C + " ~[" + i6 + "] => " + solverVariable2 + " = " + solverVariableArr[solverVariable2.mSynonym] + " + " + solverVariable2.mSynonymDelta + "\n";
            }
        }
        String C2 = x.C(C, "\n\n #  ");
        for (int i10 = 0; i10 < this.mNumRows; i10++) {
            StringBuilder t9 = x.t(C2);
            t9.append(this.mRows[i10].toReadableString());
            C2 = t9.toString().concat("\n #  ");
        }
        if (this.mGoal != null) {
            StringBuilder u7 = x.u(C2, "Goal: ");
            u7.append(this.mGoal);
            u7.append("\n");
            C2 = u7.toString();
        }
        System.out.println(C2);
    }

    public void displaySystemInformation() {
        int i = 0;
        for (int i6 = 0; i6 < this.mTableSize; i6++) {
            ArrayRow arrayRow = this.mRows[i6];
            if (arrayRow != null) {
                i += arrayRow.sizeInBytes();
            }
        }
        int i10 = 0;
        for (int i11 = 0; i11 < this.mNumRows; i11++) {
            ArrayRow arrayRow2 = this.mRows[i11];
            if (arrayRow2 != null) {
                i10 += arrayRow2.sizeInBytes();
            }
        }
        PrintStream printStream = System.out;
        StringBuilder sb = new StringBuilder("Linear System -> Table size: ");
        sb.append(this.mTableSize);
        sb.append(" (");
        int i12 = this.mTableSize;
        sb.append(getDisplaySize(i12 * i12));
        sb.append(") -- row sizes: ");
        sb.append(getDisplaySize(i));
        sb.append(", actual size: ");
        sb.append(getDisplaySize(i10));
        sb.append(" rows: ");
        sb.append(this.mNumRows);
        sb.append("/");
        sb.append(this.mMaxRows);
        sb.append(" cols: ");
        sb.append(this.mNumColumns);
        sb.append("/");
        sb.append(this.mMaxColumns);
        sb.append(" 0 occupied cells, ");
        sb.append(getDisplaySize(0));
        printStream.println(sb.toString());
    }

    public void displayVariablesReadableRows() {
        displaySolverVariables();
        String str = "";
        for (int i = 0; i < this.mNumRows; i++) {
            if (this.mRows[i].mVariable.mType == SolverVariable.Type.UNRESTRICTED) {
                StringBuilder t9 = x.t(str);
                t9.append(this.mRows[i].toReadableString());
                str = t9.toString().concat("\n");
            }
        }
        StringBuilder t10 = x.t(str);
        t10.append(this.mGoal);
        t10.append("\n");
        System.out.println(t10.toString());
    }

    public void fillMetrics(Metrics metrics) {
        sMetrics = metrics;
    }

    public Cache getCache() {
        return this.mCache;
    }

    public Row getGoal() {
        return this.mGoal;
    }

    public int getMemoryUsed() {
        int i = 0;
        for (int i6 = 0; i6 < this.mNumRows; i6++) {
            ArrayRow arrayRow = this.mRows[i6];
            if (arrayRow != null) {
                i = arrayRow.sizeInBytes() + i;
            }
        }
        return i;
    }

    public int getNumEquations() {
        return this.mNumRows;
    }

    public int getNumVariables() {
        return this.mVariablesID;
    }

    public int getObjectVariableValue(Object obj) {
        SolverVariable solverVariable = ((ConstraintAnchor) obj).getSolverVariable();
        if (solverVariable != null) {
            return (int) (solverVariable.computedValue + 0.5f);
        }
        return 0;
    }

    public ArrayRow getRow(int i) {
        return this.mRows[i];
    }

    public float getValueFor(String str) {
        SolverVariable variable = getVariable(str, SolverVariable.Type.UNRESTRICTED);
        if (variable == null) {
            return 0.0f;
        }
        return variable.computedValue;
    }

    public SolverVariable getVariable(String str, SolverVariable.Type type) {
        if (this.mVariables == null) {
            this.mVariables = new HashMap<>();
        }
        SolverVariable solverVariable = this.mVariables.get(str);
        return solverVariable == null ? createVariable(str, type) : solverVariable;
    }

    public void minimize() throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimize++;
        }
        if (this.mGoal.isEmpty()) {
            computeValues();
            return;
        }
        if (!this.graphOptimizer && !this.newgraphOptimizer) {
            minimizeGoal(this.mGoal);
            return;
        }
        Metrics metrics2 = sMetrics;
        if (metrics2 != null) {
            metrics2.graphOptimizer++;
        }
        for (int i = 0; i < this.mNumRows; i++) {
            if (!this.mRows[i].mIsSimpleDefinition) {
                minimizeGoal(this.mGoal);
                return;
            }
        }
        Metrics metrics3 = sMetrics;
        if (metrics3 != null) {
            metrics3.fullySolved++;
        }
        computeValues();
    }

    public void minimizeGoal(Row row) throws Exception {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.minimizeGoal++;
            metrics.maxVariables = Math.max(metrics.maxVariables, this.mNumColumns);
            Metrics metrics2 = sMetrics;
            metrics2.maxRows = Math.max(metrics2.maxRows, this.mNumRows);
        }
        enforceBFS(row);
        optimize(row, false);
        computeValues();
    }

    public void removeRow(ArrayRow arrayRow) {
        SolverVariable solverVariable;
        int i;
        if (!arrayRow.mIsSimpleDefinition || (solverVariable = arrayRow.mVariable) == null) {
            return;
        }
        int i6 = solverVariable.mDefinitionId;
        if (i6 != -1) {
            while (true) {
                i = this.mNumRows;
                if (i6 >= i - 1) {
                    break;
                }
                ArrayRow[] arrayRowArr = this.mRows;
                int i10 = i6 + 1;
                ArrayRow arrayRow2 = arrayRowArr[i10];
                SolverVariable solverVariable2 = arrayRow2.mVariable;
                if (solverVariable2.mDefinitionId == i10) {
                    solverVariable2.mDefinitionId = i6;
                }
                arrayRowArr[i6] = arrayRow2;
                i6 = i10;
            }
            this.mNumRows = i - 1;
        }
        SolverVariable solverVariable3 = arrayRow.mVariable;
        if (!solverVariable3.isFinalValue) {
            solverVariable3.setFinalValue(this, arrayRow.mConstantValue);
        }
        boolean z9 = OPTIMIZED_ENGINE;
        Cache cache = this.mCache;
        if (z9) {
            cache.mOptimizedArrayRowPool.release(arrayRow);
        } else {
            cache.mArrayRowPool.release(arrayRow);
        }
    }

    public void reset() {
        Cache cache;
        int i = 0;
        while (true) {
            cache = this.mCache;
            SolverVariable[] solverVariableArr = cache.mIndexedVariables;
            if (i >= solverVariableArr.length) {
                break;
            }
            SolverVariable solverVariable = solverVariableArr[i];
            if (solverVariable != null) {
                solverVariable.reset();
            }
            i++;
        }
        cache.mSolverVariablePool.releaseAll(this.mPoolVariables, this.mPoolVariablesCount);
        this.mPoolVariablesCount = 0;
        Arrays.fill(this.mCache.mIndexedVariables, (Object) null);
        HashMap<String, SolverVariable> hashMap = this.mVariables;
        if (hashMap != null) {
            hashMap.clear();
        }
        this.mVariablesID = 0;
        this.mGoal.clear();
        this.mNumColumns = 1;
        for (int i6 = 0; i6 < this.mNumRows; i6++) {
            ArrayRow arrayRow = this.mRows[i6];
            if (arrayRow != null) {
                arrayRow.mUsed = false;
            }
        }
        releaseRows();
        this.mNumRows = 0;
        boolean z9 = OPTIMIZED_ENGINE;
        Cache cache2 = this.mCache;
        if (z9) {
            this.mTempGoal = new ValuesRow(cache2);
        } else {
            this.mTempGoal = new ArrayRow(cache2);
        }
    }

    public ArrayRow addEquality(SolverVariable solverVariable, SolverVariable solverVariable2, int i, int i6) {
        Metrics metrics = sMetrics;
        if (metrics != null) {
            metrics.mSimpleEquations++;
        }
        if (USE_BASIC_SYNONYMS && i6 == 8 && solverVariable2.isFinalValue && solverVariable.mDefinitionId == -1) {
            solverVariable.setFinalValue(this, solverVariable2.computedValue + i);
            return null;
        }
        ArrayRow createRow = createRow();
        createRow.createRowEquals(solverVariable, solverVariable2, i);
        if (i6 != 8) {
            createRow.addError(this, i6);
        }
        addConstraint(createRow);
        return createRow;
    }
}
