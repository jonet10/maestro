package androidx.constraintlayout.core;

import a4.x;
import androidx.exifinterface.media.ExifInterface;
import java.util.Arrays;
import java.util.HashSet;
import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class SolverVariable implements Comparable<SolverVariable> {
    private static final boolean DO_NOT_USE = false;
    private static final boolean INTERNAL_DEBUG = false;
    static final int MAX_STRENGTH = 9;
    public static final int STRENGTH_BARRIER = 6;
    public static final int STRENGTH_CENTERING = 7;
    public static final int STRENGTH_EQUALITY = 5;
    public static final int STRENGTH_FIXED = 8;
    public static final int STRENGTH_HIGH = 3;
    public static final int STRENGTH_HIGHEST = 4;
    public static final int STRENGTH_LOW = 1;
    public static final int STRENGTH_MEDIUM = 2;
    public static final int STRENGTH_NONE = 0;
    private static final boolean VAR_USE_HASH = false;
    private static int sUniqueConstantId = 1;
    private static int sUniqueErrorId = 1;
    private static int sUniqueId = 1;
    private static int sUniqueSlackId = 1;
    private static int sUniqueUnrestrictedId = 1;
    public float computedValue;
    public int id;
    public boolean inGoal;
    public boolean isFinalValue;
    ArrayRow[] mClientEquations;
    int mClientEquationsCount;
    int mDefinitionId;
    float[] mGoalStrengthVector;
    HashSet<ArrayRow> mInRows;
    boolean mIsSynonym;
    private String mName;
    float[] mStrengthVector;
    int mSynonym;
    float mSynonymDelta;
    Type mType;
    public int strength;
    public int usageInRowCount;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public enum Type {
        UNRESTRICTED,
        CONSTANT,
        SLACK,
        ERROR,
        UNKNOWN
    }

    public SolverVariable(String str, Type type) {
        this.id = -1;
        this.mDefinitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.mStrengthVector = new float[9];
        this.mGoalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.mIsSynonym = false;
        this.mSynonym = -1;
        this.mSynonymDelta = 0.0f;
        this.mInRows = null;
        this.mName = str;
        this.mType = type;
    }

    private static String getUniqueName(Type type, String str) {
        if (str != null) {
            StringBuilder t9 = x.t(str);
            t9.append(sUniqueErrorId);
            return t9.toString();
        }
        int ordinal = type.ordinal();
        if (ordinal == 0) {
            StringBuilder sb = new StringBuilder("U");
            int i = sUniqueUnrestrictedId + 1;
            sUniqueUnrestrictedId = i;
            sb.append(i);
            return sb.toString();
        }
        if (ordinal == 1) {
            StringBuilder sb2 = new StringBuilder("C");
            int i6 = sUniqueConstantId + 1;
            sUniqueConstantId = i6;
            sb2.append(i6);
            return sb2.toString();
        }
        if (ordinal == 2) {
            StringBuilder sb3 = new StringBuilder(ExifInterface.LATITUDE_SOUTH);
            int i10 = sUniqueSlackId + 1;
            sUniqueSlackId = i10;
            sb3.append(i10);
            return sb3.toString();
        }
        if (ordinal == 3) {
            StringBuilder sb4 = new StringBuilder("e");
            int i11 = sUniqueErrorId + 1;
            sUniqueErrorId = i11;
            sb4.append(i11);
            return sb4.toString();
        }
        if (ordinal != 4) {
            o.j(type.name());
            return null;
        }
        StringBuilder sb5 = new StringBuilder(ExifInterface.GPS_MEASUREMENT_INTERRUPTED);
        int i12 = sUniqueId + 1;
        sUniqueId = i12;
        sb5.append(i12);
        return sb5.toString();
    }

    public static void increaseErrorId() {
        sUniqueErrorId++;
    }

    public final void addToRow(ArrayRow arrayRow) {
        int i = 0;
        while (true) {
            int i6 = this.mClientEquationsCount;
            ArrayRow[] arrayRowArr = this.mClientEquations;
            if (i >= i6) {
                if (i6 >= arrayRowArr.length) {
                    this.mClientEquations = (ArrayRow[]) Arrays.copyOf(arrayRowArr, arrayRowArr.length * 2);
                }
                ArrayRow[] arrayRowArr2 = this.mClientEquations;
                int i10 = this.mClientEquationsCount;
                arrayRowArr2[i10] = arrayRow;
                this.mClientEquationsCount = i10 + 1;
                return;
            }
            if (arrayRowArr[i] == arrayRow) {
                return;
            } else {
                i++;
            }
        }
    }

    public void clearStrengths() {
        for (int i = 0; i < 9; i++) {
            this.mStrengthVector[i] = 0.0f;
        }
    }

    public String getName() {
        return this.mName;
    }

    public final void removeFromRow(ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        int i6 = 0;
        while (i6 < i) {
            if (this.mClientEquations[i6] == arrayRow) {
                while (i6 < i - 1) {
                    ArrayRow[] arrayRowArr = this.mClientEquations;
                    int i10 = i6 + 1;
                    arrayRowArr[i6] = arrayRowArr[i10];
                    i6 = i10;
                }
                this.mClientEquationsCount--;
                return;
            }
            i6++;
        }
    }

    public void reset() {
        this.mName = null;
        this.mType = Type.UNKNOWN;
        this.strength = 0;
        this.id = -1;
        this.mDefinitionId = -1;
        this.computedValue = 0.0f;
        this.isFinalValue = false;
        this.mIsSynonym = false;
        this.mSynonym = -1;
        this.mSynonymDelta = 0.0f;
        int i = this.mClientEquationsCount;
        for (int i6 = 0; i6 < i; i6++) {
            this.mClientEquations[i6] = null;
        }
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.inGoal = false;
        Arrays.fill(this.mGoalStrengthVector, 0.0f);
    }

    public void setFinalValue(LinearSystem linearSystem, float f) {
        this.computedValue = f;
        this.isFinalValue = true;
        this.mIsSynonym = false;
        this.mSynonym = -1;
        this.mSynonymDelta = 0.0f;
        int i = this.mClientEquationsCount;
        this.mDefinitionId = -1;
        for (int i6 = 0; i6 < i; i6++) {
            this.mClientEquations[i6].updateFromFinalVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
    }

    public void setName(String str) {
        this.mName = str;
    }

    public void setSynonym(LinearSystem linearSystem, SolverVariable solverVariable, float f) {
        this.mIsSynonym = true;
        this.mSynonym = solverVariable.id;
        this.mSynonymDelta = f;
        int i = this.mClientEquationsCount;
        this.mDefinitionId = -1;
        for (int i6 = 0; i6 < i; i6++) {
            this.mClientEquations[i6].updateFromSynonymVariable(linearSystem, this, false);
        }
        this.mClientEquationsCount = 0;
        linearSystem.displayReadableRows();
    }

    public void setType(Type type, String str) {
        this.mType = type;
    }

    public String strengthsToString() {
        String str = this + "[";
        int i = 0;
        boolean z9 = false;
        boolean z10 = true;
        while (i < this.mStrengthVector.length) {
            StringBuilder t9 = x.t(str);
            t9.append(this.mStrengthVector[i]);
            String sb = t9.toString();
            float[] fArr = this.mStrengthVector;
            float f = fArr[i];
            if (f > 0.0f) {
                z9 = false;
            } else if (f < 0.0f) {
                z9 = true;
            }
            if (f != 0.0f) {
                z10 = false;
            }
            str = i < fArr.length - 1 ? sb.concat(", ") : sb.concat("] ");
            i++;
        }
        if (z9) {
            str = str.concat(" (-)");
        }
        return z10 ? str.concat(" (*)") : str;
    }

    public String toString() {
        if (this.mName != null) {
            return "" + this.mName;
        }
        return "" + this.id;
    }

    public final void updateReferencesWithNewDefinition(LinearSystem linearSystem, ArrayRow arrayRow) {
        int i = this.mClientEquationsCount;
        for (int i6 = 0; i6 < i; i6++) {
            this.mClientEquations[i6].updateFromRow(linearSystem, arrayRow, false);
        }
        this.mClientEquationsCount = 0;
    }

    @Override // java.lang.Comparable
    public int compareTo(SolverVariable solverVariable) {
        return this.id - solverVariable.id;
    }

    public SolverVariable(Type type, String str) {
        this.id = -1;
        this.mDefinitionId = -1;
        this.strength = 0;
        this.isFinalValue = false;
        this.mStrengthVector = new float[9];
        this.mGoalStrengthVector = new float[9];
        this.mClientEquations = new ArrayRow[16];
        this.mClientEquationsCount = 0;
        this.usageInRowCount = 0;
        this.mIsSynonym = false;
        this.mSynonym = -1;
        this.mSynonymDelta = 0.0f;
        this.mInRows = null;
        this.mType = type;
    }
}
