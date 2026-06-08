package androidx.constraintlayout.core.utils;

import java.lang.reflect.Array;
import java.util.Arrays;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class GridEngine {
    private static final int DEFAULT_SIZE = 3;
    public static final int HORIZONTAL = 0;
    private static final int MAX_COLUMNS = 50;
    private static final int MAX_ROWS = 50;
    public static final int VERTICAL = 1;
    private int mColumns;
    private int mColumnsSet;
    private int[][] mConstraintMatrix;
    private int mNextAvailableIndex = 0;
    private int mNumWidgets;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private int mRows;
    private int mRowsSet;
    private String mStrSkips;
    private String mStrSpans;

    public GridEngine(int i, int i6, int i10) {
        this.mRowsSet = i;
        this.mColumnsSet = i6;
        this.mNumWidgets = i10;
        if (i > 50) {
            this.mRowsSet = 3;
        }
        if (i6 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        int i11 = this.mRows;
        int i12 = this.mColumns;
        if (i10 > i11 * i12 || i10 < 1) {
            this.mNumWidgets = i11 * i12;
        }
        initVariables();
        fillConstraintMatrix(false);
    }

    private void addAllConstraintPositions() {
        for (int i = 0; i < this.mNumWidgets; i++) {
            if (leftOfWidget(i) == -1) {
                int nextPosition = getNextPosition();
                int rowByIndex = getRowByIndex(nextPosition);
                int colByIndex = getColByIndex(nextPosition);
                if (nextPosition == -1) {
                    return;
                } else {
                    addConstraintPosition(i, rowByIndex, colByIndex, 1, 1);
                }
            }
        }
    }

    private void addConstraintPosition(int i, int i6, int i10, int i11, int i12) {
        int[] iArr = this.mConstraintMatrix[i];
        iArr[0] = i10;
        iArr[1] = i6;
        iArr[2] = (i10 + i12) - 1;
        iArr[3] = (i6 + i11) - 1;
    }

    private void fillConstraintMatrix(boolean z9) {
        int[][] parseSpans;
        int[][] parseSpans2;
        if (z9) {
            for (int i = 0; i < this.mPositionMatrix.length; i++) {
                int i6 = 0;
                while (true) {
                    boolean[][] zArr = this.mPositionMatrix;
                    if (i6 < zArr[0].length) {
                        zArr[i][i6] = true;
                        i6++;
                    }
                }
            }
            for (int i10 = 0; i10 < this.mConstraintMatrix.length; i10++) {
                int i11 = 0;
                while (true) {
                    int[][] iArr = this.mConstraintMatrix;
                    if (i11 < iArr[0].length) {
                        iArr[i10][i11] = -1;
                        i11++;
                    }
                }
            }
        }
        this.mNextAvailableIndex = 0;
        String str = this.mStrSkips;
        if (str != null && !str.trim().isEmpty() && (parseSpans2 = parseSpans(this.mStrSkips)) != null) {
            handleSkips(parseSpans2);
        }
        String str2 = this.mStrSpans;
        if (str2 != null && !str2.trim().isEmpty() && (parseSpans = parseSpans(this.mStrSpans)) != null) {
            handleSpans(parseSpans);
        }
        addAllConstraintPositions();
    }

    private int getColByIndex(int i) {
        return this.mOrientation == 1 ? i / this.mRows : i % this.mColumns;
    }

    private int getNextPosition() {
        boolean z9 = false;
        int i = 0;
        while (!z9) {
            i = this.mNextAvailableIndex;
            if (i >= this.mRows * this.mColumns) {
                return -1;
            }
            int rowByIndex = getRowByIndex(i);
            int colByIndex = getColByIndex(this.mNextAvailableIndex);
            boolean[] zArr = this.mPositionMatrix[rowByIndex];
            if (zArr[colByIndex]) {
                zArr[colByIndex] = false;
                z9 = true;
            }
            this.mNextAvailableIndex++;
        }
        return i;
    }

    private int getRowByIndex(int i) {
        return this.mOrientation == 1 ? i % this.mRows : i / this.mColumns;
    }

    private void handleSkips(int[][] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            int rowByIndex = getRowByIndex(iArr[i][0]);
            int colByIndex = getColByIndex(iArr[i][0]);
            int[] iArr2 = iArr[i];
            if (!invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                return;
            }
        }
    }

    private void handleSpans(int[][] iArr) {
        for (int i = 0; i < iArr.length; i++) {
            int rowByIndex = getRowByIndex(iArr[i][0]);
            int colByIndex = getColByIndex(iArr[i][0]);
            int[] iArr2 = iArr[i];
            if (!invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                return;
            }
            int[] iArr3 = iArr[i];
            addConstraintPosition(i, rowByIndex, colByIndex, iArr3[1], iArr3[2]);
        }
    }

    private void initVariables() {
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.mRows, this.mColumns);
        this.mPositionMatrix = zArr;
        for (boolean[] zArr2 : zArr) {
            Arrays.fill(zArr2, true);
        }
        int i = this.mNumWidgets;
        if (i > 0) {
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i, 4);
            this.mConstraintMatrix = iArr;
            for (int[] iArr2 : iArr) {
                Arrays.fill(iArr2, -1);
            }
        }
    }

    private boolean invalidatePositions(int i, int i6, int i10, int i11) {
        for (int i12 = i; i12 < i + i10; i12++) {
            for (int i13 = i6; i13 < i6 + i11; i13++) {
                boolean[][] zArr = this.mPositionMatrix;
                if (i12 < zArr.length && i13 < zArr[0].length) {
                    boolean[] zArr2 = zArr[i12];
                    if (zArr2[i13]) {
                        zArr2[i13] = false;
                    }
                }
                return false;
            }
        }
        return true;
    }

    private boolean isSpansValid(CharSequence charSequence) {
        return charSequence != null;
    }

    private int[][] parseSpans(String str) {
        if (!isSpansValid(str)) {
            return null;
        }
        String[] split = str.split(",");
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, split.length, 3);
        for (int i = 0; i < split.length; i++) {
            String[] split2 = split[i].trim().split(":");
            String[] split3 = split2[1].split("x");
            iArr[i][0] = Integer.parseInt(split2[0]);
            iArr[i][1] = Integer.parseInt(split3[0]);
            iArr[i][2] = Integer.parseInt(split3[1]);
        }
        return iArr;
    }

    private void updateActualRowsAndColumns() {
        int i;
        int i6 = this.mRowsSet;
        if (i6 != 0 && (i = this.mColumnsSet) != 0) {
            this.mRows = i6;
            this.mColumns = i;
            return;
        }
        int i10 = this.mColumnsSet;
        if (i10 > 0) {
            this.mColumns = i10;
            this.mRows = ((this.mNumWidgets + i10) - 1) / i10;
        } else if (i6 > 0) {
            this.mRows = i6;
            this.mColumns = ((this.mNumWidgets + i6) - 1) / i6;
        } else {
            int sqrt = (int) (Math.sqrt(this.mNumWidgets) + 1.5d);
            this.mRows = sqrt;
            this.mColumns = ((this.mNumWidgets + sqrt) - 1) / sqrt;
        }
    }

    public int bottomOfWidget(int i) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i >= iArr.length) {
            return 0;
        }
        return iArr[i][3];
    }

    public int leftOfWidget(int i) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i >= iArr.length) {
            return 0;
        }
        return iArr[i][0];
    }

    public int rightOfWidget(int i) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i >= iArr.length) {
            return 0;
        }
        return iArr[i][2];
    }

    public void setColumns(int i) {
        if (i <= 50 && this.mColumnsSet != i) {
            this.mColumnsSet = i;
            updateActualRowsAndColumns();
        }
    }

    public void setNumWidgets(int i) {
        if (i > this.mRows * this.mColumns) {
            return;
        }
        this.mNumWidgets = i;
    }

    public void setOrientation(int i) {
        if ((i == 0 || i == 1) && this.mOrientation != i) {
            this.mOrientation = i;
        }
    }

    public void setRows(int i) {
        if (i <= 50 && this.mRowsSet != i) {
            this.mRowsSet = i;
            updateActualRowsAndColumns();
        }
    }

    public void setSkips(String str) {
        String str2 = this.mStrSkips;
        if (str2 == null || !str2.equals(str)) {
            this.mStrSkips = str;
        }
    }

    public void setSpans(CharSequence charSequence) {
        String str = this.mStrSpans;
        if (str == null || !str.equals(charSequence.toString())) {
            this.mStrSpans = charSequence.toString();
        }
    }

    public void setup() {
        boolean[][] zArr;
        int[][] iArr = this.mConstraintMatrix;
        boolean z9 = false;
        if (iArr != null && iArr.length == this.mNumWidgets && (zArr = this.mPositionMatrix) != null && zArr.length == this.mRows && zArr[0].length == this.mColumns) {
            z9 = true;
        }
        if (!z9) {
            initVariables();
        }
        fillConstraintMatrix(z9);
    }

    public int topOfWidget(int i) {
        int[][] iArr = this.mConstraintMatrix;
        if (iArr == null || i >= iArr.length) {
            return 0;
        }
        return iArr[i][1];
    }

    public GridEngine(int i, int i6) {
        this.mRowsSet = i;
        this.mColumnsSet = i6;
        if (i > 50) {
            this.mRowsSet = 3;
        }
        if (i6 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        initVariables();
    }

    public GridEngine() {
    }
}
