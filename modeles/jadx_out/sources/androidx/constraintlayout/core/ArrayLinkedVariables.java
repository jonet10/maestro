package androidx.constraintlayout.core;

import a4.x;
import androidx.constraintlayout.core.ArrayRow;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ArrayLinkedVariables implements ArrayRow.ArrayRowVariables {
    private static final boolean DEBUG = false;
    static final int NONE = -1;
    private static float sEpsilon = 0.001f;
    protected final Cache mCache;
    private final ArrayRow mRow;
    int mCurrentSize = 0;
    private int mRowSize = 8;
    private SolverVariable mCandidate = null;
    private int[] mArrayIndices = new int[8];
    private int[] mArrayNextIndices = new int[8];
    private float[] mArrayValues = new float[8];
    private int mHead = -1;
    private int mLast = -1;
    private boolean mDidFillOnce = false;

    public ArrayLinkedVariables(ArrayRow arrayRow, Cache cache) {
        this.mRow = arrayRow;
        this.mCache = cache;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void add(SolverVariable solverVariable, float f, boolean z9) {
        float f10 = sEpsilon;
        if (f <= (-f10) || f >= f10) {
            int i = this.mHead;
            if (i == -1) {
                this.mHead = 0;
                this.mArrayValues[0] = f;
                this.mArrayIndices[0] = solverVariable.id;
                this.mArrayNextIndices[0] = -1;
                solverVariable.usageInRowCount++;
                solverVariable.addToRow(this.mRow);
                this.mCurrentSize++;
                if (this.mDidFillOnce) {
                    return;
                }
                int i6 = this.mLast + 1;
                this.mLast = i6;
                int[] iArr = this.mArrayIndices;
                if (i6 >= iArr.length) {
                    this.mDidFillOnce = true;
                    this.mLast = iArr.length - 1;
                    return;
                }
                return;
            }
            int i10 = -1;
            for (int i11 = 0; i != -1 && i11 < this.mCurrentSize; i11++) {
                int i12 = this.mArrayIndices[i];
                int i13 = solverVariable.id;
                if (i12 == i13) {
                    float[] fArr = this.mArrayValues;
                    float f11 = fArr[i] + f;
                    float f12 = sEpsilon;
                    if (f11 > (-f12) && f11 < f12) {
                        f11 = 0.0f;
                    }
                    fArr[i] = f11;
                    if (f11 == 0.0f) {
                        int i14 = this.mHead;
                        int[] iArr2 = this.mArrayNextIndices;
                        if (i == i14) {
                            this.mHead = iArr2[i];
                        } else {
                            iArr2[i10] = iArr2[i];
                        }
                        if (z9) {
                            solverVariable.removeFromRow(this.mRow);
                        }
                        if (this.mDidFillOnce) {
                            this.mLast = i;
                        }
                        solverVariable.usageInRowCount--;
                        this.mCurrentSize--;
                        return;
                    }
                    return;
                }
                if (i12 < i13) {
                    i10 = i;
                }
                i = this.mArrayNextIndices[i];
            }
            int i15 = this.mLast;
            int i16 = i15 + 1;
            if (this.mDidFillOnce) {
                int[] iArr3 = this.mArrayIndices;
                if (iArr3[i15] != -1) {
                    i15 = iArr3.length;
                }
            } else {
                i15 = i16;
            }
            int[] iArr4 = this.mArrayIndices;
            if (i15 >= iArr4.length && this.mCurrentSize < iArr4.length) {
                int i17 = 0;
                while (true) {
                    int[] iArr5 = this.mArrayIndices;
                    if (i17 >= iArr5.length) {
                        break;
                    }
                    if (iArr5[i17] == -1) {
                        i15 = i17;
                        break;
                    }
                    i17++;
                }
            }
            int[] iArr6 = this.mArrayIndices;
            if (i15 >= iArr6.length) {
                i15 = iArr6.length;
                int i18 = this.mRowSize * 2;
                this.mRowSize = i18;
                this.mDidFillOnce = false;
                this.mLast = i15 - 1;
                this.mArrayValues = Arrays.copyOf(this.mArrayValues, i18);
                this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.mRowSize);
                this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.mRowSize);
            }
            this.mArrayIndices[i15] = solverVariable.id;
            this.mArrayValues[i15] = f;
            int[] iArr7 = this.mArrayNextIndices;
            if (i10 != -1) {
                iArr7[i15] = iArr7[i10];
                iArr7[i10] = i15;
            } else {
                iArr7[i15] = this.mHead;
                this.mHead = i15;
            }
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.mCurrentSize++;
            if (!this.mDidFillOnce) {
                this.mLast++;
            }
            int i19 = this.mLast;
            int[] iArr8 = this.mArrayIndices;
            if (i19 >= iArr8.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr8.length - 1;
            }
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void clear() {
        int i = this.mHead;
        for (int i6 = 0; i != -1 && i6 < this.mCurrentSize; i6++) {
            SolverVariable solverVariable = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
            if (solverVariable != null) {
                solverVariable.removeFromRow(this.mRow);
            }
            i = this.mArrayNextIndices[i];
        }
        this.mHead = -1;
        this.mLast = -1;
        this.mDidFillOnce = false;
        this.mCurrentSize = 0;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public boolean contains(SolverVariable solverVariable) {
        int i = this.mHead;
        if (i == -1) {
            return false;
        }
        for (int i6 = 0; i != -1 && i6 < this.mCurrentSize; i6++) {
            if (this.mArrayIndices[i] == solverVariable.id) {
                return true;
            }
            i = this.mArrayNextIndices[i];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void display() {
        int i = this.mCurrentSize;
        System.out.print("{ ");
        for (int i6 = 0; i6 < i; i6++) {
            SolverVariable variable = getVariable(i6);
            if (variable != null) {
                System.out.print(variable + " = " + getVariableValue(i6) + " ");
            }
        }
        System.out.println(" }");
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void divideByAmount(float f) {
        int i = this.mHead;
        for (int i6 = 0; i != -1 && i6 < this.mCurrentSize; i6++) {
            float[] fArr = this.mArrayValues;
            fArr[i] = fArr[i] / f;
            i = this.mArrayNextIndices[i];
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float get(SolverVariable solverVariable) {
        int i = this.mHead;
        for (int i6 = 0; i != -1 && i6 < this.mCurrentSize; i6++) {
            if (this.mArrayIndices[i] == solverVariable.id) {
                return this.mArrayValues[i];
            }
            i = this.mArrayNextIndices[i];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int getCurrentSize() {
        return this.mCurrentSize;
    }

    public int getHead() {
        return this.mHead;
    }

    public final int getId(int i) {
        return this.mArrayIndices[i];
    }

    public final int getNextIndice(int i) {
        return this.mArrayNextIndices[i];
    }

    public SolverVariable getPivotCandidate() {
        SolverVariable solverVariable = this.mCandidate;
        if (solverVariable != null) {
            return solverVariable;
        }
        int i = this.mHead;
        SolverVariable solverVariable2 = null;
        for (int i6 = 0; i != -1 && i6 < this.mCurrentSize; i6++) {
            if (this.mArrayValues[i] < 0.0f) {
                SolverVariable solverVariable3 = this.mCache.mIndexedVariables[this.mArrayIndices[i]];
                if (solverVariable2 == null || solverVariable2.strength < solverVariable3.strength) {
                    solverVariable2 = solverVariable3;
                }
            }
            i = this.mArrayNextIndices[i];
        }
        return solverVariable2;
    }

    public final float getValue(int i) {
        return this.mArrayValues[i];
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public SolverVariable getVariable(int i) {
        int i6 = this.mHead;
        for (int i10 = 0; i6 != -1 && i10 < this.mCurrentSize; i10++) {
            if (i10 == i) {
                return this.mCache.mIndexedVariables[this.mArrayIndices[i6]];
            }
            i6 = this.mArrayNextIndices[i6];
        }
        return null;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float getVariableValue(int i) {
        int i6 = this.mHead;
        for (int i10 = 0; i6 != -1 && i10 < this.mCurrentSize; i10++) {
            if (i10 == i) {
                return this.mArrayValues[i6];
            }
            i6 = this.mArrayNextIndices[i6];
        }
        return 0.0f;
    }

    public boolean hasAtLeastOnePositiveVariable() {
        int i = this.mHead;
        for (int i6 = 0; i != -1 && i6 < this.mCurrentSize; i6++) {
            if (this.mArrayValues[i] > 0.0f) {
                return true;
            }
            i = this.mArrayNextIndices[i];
        }
        return false;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int indexOf(SolverVariable solverVariable) {
        int i = this.mHead;
        if (i == -1) {
            return -1;
        }
        for (int i6 = 0; i != -1 && i6 < this.mCurrentSize; i6++) {
            if (this.mArrayIndices[i] == solverVariable.id) {
                return i;
            }
            i = this.mArrayNextIndices[i];
        }
        return -1;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public void invert() {
        int i = this.mHead;
        for (int i6 = 0; i != -1 && i6 < this.mCurrentSize; i6++) {
            float[] fArr = this.mArrayValues;
            fArr[i] = fArr[i] * (-1.0f);
            i = this.mArrayNextIndices[i];
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final void put(SolverVariable solverVariable, float f) {
        if (f == 0.0f) {
            remove(solverVariable, true);
            return;
        }
        int i = this.mHead;
        if (i == -1) {
            this.mHead = 0;
            this.mArrayValues[0] = f;
            this.mArrayIndices[0] = solverVariable.id;
            this.mArrayNextIndices[0] = -1;
            solverVariable.usageInRowCount++;
            solverVariable.addToRow(this.mRow);
            this.mCurrentSize++;
            if (this.mDidFillOnce) {
                return;
            }
            int i6 = this.mLast + 1;
            this.mLast = i6;
            int[] iArr = this.mArrayIndices;
            if (i6 >= iArr.length) {
                this.mDidFillOnce = true;
                this.mLast = iArr.length - 1;
                return;
            }
            return;
        }
        int i10 = -1;
        for (int i11 = 0; i != -1 && i11 < this.mCurrentSize; i11++) {
            int i12 = this.mArrayIndices[i];
            int i13 = solverVariable.id;
            if (i12 == i13) {
                this.mArrayValues[i] = f;
                return;
            }
            if (i12 < i13) {
                i10 = i;
            }
            i = this.mArrayNextIndices[i];
        }
        int i14 = this.mLast;
        int i15 = i14 + 1;
        if (this.mDidFillOnce) {
            int[] iArr2 = this.mArrayIndices;
            if (iArr2[i14] != -1) {
                i14 = iArr2.length;
            }
        } else {
            i14 = i15;
        }
        int[] iArr3 = this.mArrayIndices;
        if (i14 >= iArr3.length && this.mCurrentSize < iArr3.length) {
            int i16 = 0;
            while (true) {
                int[] iArr4 = this.mArrayIndices;
                if (i16 >= iArr4.length) {
                    break;
                }
                if (iArr4[i16] == -1) {
                    i14 = i16;
                    break;
                }
                i16++;
            }
        }
        int[] iArr5 = this.mArrayIndices;
        if (i14 >= iArr5.length) {
            i14 = iArr5.length;
            int i17 = this.mRowSize * 2;
            this.mRowSize = i17;
            this.mDidFillOnce = false;
            this.mLast = i14 - 1;
            this.mArrayValues = Arrays.copyOf(this.mArrayValues, i17);
            this.mArrayIndices = Arrays.copyOf(this.mArrayIndices, this.mRowSize);
            this.mArrayNextIndices = Arrays.copyOf(this.mArrayNextIndices, this.mRowSize);
        }
        this.mArrayIndices[i14] = solverVariable.id;
        this.mArrayValues[i14] = f;
        int[] iArr6 = this.mArrayNextIndices;
        if (i10 != -1) {
            iArr6[i14] = iArr6[i10];
            iArr6[i10] = i14;
        } else {
            iArr6[i14] = this.mHead;
            this.mHead = i14;
        }
        solverVariable.usageInRowCount++;
        solverVariable.addToRow(this.mRow);
        int i18 = this.mCurrentSize + 1;
        this.mCurrentSize = i18;
        if (!this.mDidFillOnce) {
            this.mLast++;
        }
        int[] iArr7 = this.mArrayIndices;
        if (i18 >= iArr7.length) {
            this.mDidFillOnce = true;
        }
        if (this.mLast >= iArr7.length) {
            this.mDidFillOnce = true;
            this.mLast = iArr7.length - 1;
        }
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public final float remove(SolverVariable solverVariable, boolean z9) {
        if (this.mCandidate == solverVariable) {
            this.mCandidate = null;
        }
        int i = this.mHead;
        if (i == -1) {
            return 0.0f;
        }
        int i6 = 0;
        int i10 = -1;
        while (i != -1 && i6 < this.mCurrentSize) {
            if (this.mArrayIndices[i] == solverVariable.id) {
                int i11 = this.mHead;
                int[] iArr = this.mArrayNextIndices;
                if (i == i11) {
                    this.mHead = iArr[i];
                } else {
                    iArr[i10] = iArr[i];
                }
                if (z9) {
                    solverVariable.removeFromRow(this.mRow);
                }
                solverVariable.usageInRowCount--;
                this.mCurrentSize--;
                this.mArrayIndices[i] = -1;
                if (this.mDidFillOnce) {
                    this.mLast = i;
                }
                return this.mArrayValues[i];
            }
            i6++;
            i10 = i;
            i = this.mArrayNextIndices[i];
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public int sizeInBytes() {
        return (this.mArrayIndices.length * 12) + 36;
    }

    public String toString() {
        int i = this.mHead;
        String str = "";
        for (int i6 = 0; i != -1 && i6 < this.mCurrentSize; i6++) {
            StringBuilder t9 = x.t(str.concat(" -> "));
            t9.append(this.mArrayValues[i]);
            t9.append(" : ");
            StringBuilder t10 = x.t(t9.toString());
            t10.append(this.mCache.mIndexedVariables[this.mArrayIndices[i]]);
            str = t10.toString();
            i = this.mArrayNextIndices[i];
        }
        return str;
    }

    @Override // androidx.constraintlayout.core.ArrayRow.ArrayRowVariables
    public float use(ArrayRow arrayRow, boolean z9) {
        float f = get(arrayRow.mVariable);
        remove(arrayRow.mVariable, z9);
        ArrayRow.ArrayRowVariables arrayRowVariables = arrayRow.variables;
        int currentSize = arrayRowVariables.getCurrentSize();
        for (int i = 0; i < currentSize; i++) {
            SolverVariable variable = arrayRowVariables.getVariable(i);
            add(variable, arrayRowVariables.get(variable) * f, z9);
        }
        return f;
    }
}
