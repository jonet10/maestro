package androidx.constraintlayout.core.utils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class GridCore extends VirtualLayout {
    private static final int DEFAULT_SIZE = 3;
    public static final int HORIZONTAL = 0;
    private static final int MAX_COLUMNS = 50;
    private static final int MAX_ROWS = 50;
    public static final int SPANS_RESPECT_WIDGET_ORDER = 2;
    public static final int SUB_GRID_BY_COL_ROW = 1;
    public static final int VERTICAL = 1;
    private ConstraintWidget[] mBoxWidgets;
    private String mColumnWeights;
    private int mColumns;
    private int mColumnsSet;
    private int[][] mConstraintMatrix;
    ConstraintWidgetContainer mContainer;
    private int mFlags;
    private float mHorizontalGaps;
    private int mOrientation;
    private boolean[][] mPositionMatrix;
    private String mRowWeights;
    private int mRows;
    private int mRowsSet;
    private String mSkips;
    private int[][] mSpanMatrix;
    private String mSpans;
    private float mVerticalGaps;
    private boolean mExtraSpaceHandled = false;
    private int mNextAvailableIndex = 0;
    Set<String> mSpanIds = new HashSet();
    private int mSpanIndex = 0;

    public GridCore(int i, int i6) {
        this.mRowsSet = i;
        this.mColumnsSet = i6;
        if (i > 50) {
            this.mRowsSet = 3;
        }
        if (i6 > 50) {
            this.mColumnsSet = 3;
        }
        updateActualRowsAndColumns();
        initMatrices();
    }

    private void addConstraints() {
        setBoxWidgetVerticalChains();
        setBoxWidgetHorizontalChains();
        arrangeWidgets();
    }

    private void arrangeWidgets() {
        int[][] iArr;
        int i;
        for (int i6 = 0; i6 < this.mWidgetsCount; i6++) {
            if (!this.mSpanIds.contains(this.mWidgets[i6].stringId)) {
                int nextPosition = getNextPosition();
                int rowByIndex = getRowByIndex(nextPosition);
                int colByIndex = getColByIndex(nextPosition);
                if (nextPosition == -1) {
                    return;
                }
                if (isSpansRespectWidgetOrder() && (iArr = this.mSpanMatrix) != null && (i = this.mSpanIndex) < iArr.length) {
                    int[] iArr2 = iArr[i];
                    if (iArr2[0] == nextPosition) {
                        this.mPositionMatrix[rowByIndex][colByIndex] = true;
                        if (invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                            ConstraintWidget constraintWidget = this.mWidgets[i6];
                            int[] iArr3 = this.mSpanMatrix[this.mSpanIndex];
                            connectWidget(constraintWidget, rowByIndex, colByIndex, iArr3[1], iArr3[2]);
                            this.mSpanIndex++;
                        }
                    }
                }
                connectWidget(this.mWidgets[i6], rowByIndex, colByIndex, 1, 1);
            }
        }
    }

    private void clearHorizontalAttributes(ConstraintWidget constraintWidget) {
        constraintWidget.setHorizontalWeight(-1.0f);
        constraintWidget.mLeft.reset();
        constraintWidget.mRight.reset();
    }

    private void clearVerticalAttributes(ConstraintWidget constraintWidget) {
        constraintWidget.setVerticalWeight(-1.0f);
        constraintWidget.mTop.reset();
        constraintWidget.mBottom.reset();
        constraintWidget.mBaseline.reset();
    }

    private void connectWidget(ConstraintWidget constraintWidget, int i, int i6, int i10, int i11) {
        constraintWidget.mLeft.connect(this.mBoxWidgets[i6].mLeft, 0);
        constraintWidget.mTop.connect(this.mBoxWidgets[i].mTop, 0);
        constraintWidget.mRight.connect(this.mBoxWidgets[(i6 + i11) - 1].mRight, 0);
        constraintWidget.mBottom.connect(this.mBoxWidgets[(i + i10) - 1].mBottom, 0);
    }

    private void createBoxes() {
        int max = Math.max(this.mRows, this.mColumns);
        ConstraintWidget[] constraintWidgetArr = this.mBoxWidgets;
        int i = 0;
        if (constraintWidgetArr == null) {
            this.mBoxWidgets = new ConstraintWidget[max];
            while (true) {
                ConstraintWidget[] constraintWidgetArr2 = this.mBoxWidgets;
                if (i >= constraintWidgetArr2.length) {
                    return;
                }
                constraintWidgetArr2[i] = makeNewWidget();
                i++;
            }
        } else {
            if (max == constraintWidgetArr.length) {
                return;
            }
            ConstraintWidget[] constraintWidgetArr3 = new ConstraintWidget[max];
            while (i < max) {
                ConstraintWidget[] constraintWidgetArr4 = this.mBoxWidgets;
                if (i < constraintWidgetArr4.length) {
                    constraintWidgetArr3[i] = constraintWidgetArr4[i];
                } else {
                    constraintWidgetArr3[i] = makeNewWidget();
                }
                i++;
            }
            while (true) {
                ConstraintWidget[] constraintWidgetArr5 = this.mBoxWidgets;
                if (max >= constraintWidgetArr5.length) {
                    this.mBoxWidgets = constraintWidgetArr3;
                    return;
                } else {
                    this.mContainer.remove(constraintWidgetArr5[max]);
                    max++;
                }
            }
        }
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
        String str = this.mSkips;
        if (str != null && !str.trim().isEmpty() && (parseSpans2 = parseSpans(this.mSkips, false)) != null) {
            handleSkips(parseSpans2);
        }
        String str2 = this.mSpans;
        if (str2 == null || str2.trim().isEmpty() || (parseSpans = parseSpans(this.mSpans, true)) == null) {
            return;
        }
        handleSpans(parseSpans);
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
        for (int[] iArr2 : iArr) {
            if (!invalidatePositions(getRowByIndex(iArr2[0]), getColByIndex(iArr2[0]), iArr2[1], iArr2[2])) {
                return;
            }
        }
    }

    private void handleSpans(int[][] iArr) {
        if (!isSpansRespectWidgetOrder()) {
            for (int i = 0; i < iArr.length; i++) {
                int rowByIndex = getRowByIndex(iArr[i][0]);
                int colByIndex = getColByIndex(iArr[i][0]);
                int[] iArr2 = iArr[i];
                if (!invalidatePositions(rowByIndex, colByIndex, iArr2[1], iArr2[2])) {
                    break;
                }
                ConstraintWidget constraintWidget = this.mWidgets[i];
                int[] iArr3 = iArr[i];
                connectWidget(constraintWidget, rowByIndex, colByIndex, iArr3[1], iArr3[2]);
                this.mSpanIds.add(this.mWidgets[i].stringId);
            }
        }
    }

    private void initMatrices() {
        boolean[][] zArr;
        int[][] iArr = this.mConstraintMatrix;
        boolean z9 = false;
        if (iArr != null && iArr.length == this.mWidgetsCount && (zArr = this.mPositionMatrix) != null && zArr.length == this.mRows && zArr[0].length == this.mColumns) {
            z9 = true;
        }
        if (!z9) {
            initVariables();
        }
        fillConstraintMatrix(z9);
    }

    private void initVariables() {
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, this.mRows, this.mColumns);
        this.mPositionMatrix = zArr;
        for (boolean[] zArr2 : zArr) {
            Arrays.fill(zArr2, true);
        }
        int i = this.mWidgetsCount;
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

    private boolean isSpansRespectWidgetOrder() {
        return (this.mFlags & 2) > 0;
    }

    private boolean isSubGridByColRow() {
        return (this.mFlags & 1) > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$parseSpans$0(String str, String str2) {
        return Integer.parseInt(str.split(":")[0]) - Integer.parseInt(str2.split(":")[0]);
    }

    private ConstraintWidget makeNewWidget() {
        ConstraintWidget constraintWidget = new ConstraintWidget();
        ConstraintWidget.DimensionBehaviour[] dimensionBehaviourArr = constraintWidget.mListDimensionBehaviors;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
        dimensionBehaviourArr[0] = dimensionBehaviour;
        dimensionBehaviourArr[1] = dimensionBehaviour;
        constraintWidget.stringId = String.valueOf(constraintWidget.hashCode());
        return constraintWidget;
    }

    private int[][] parseSpans(String str, boolean z9) {
        try {
            String[] split = str.split(",");
            Arrays.sort(split, new a(0));
            int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, split.length, 3);
            if (this.mRows != 1 && this.mColumns != 1) {
                for (int i = 0; i < split.length; i++) {
                    String[] split2 = split[i].trim().split(":");
                    String[] split3 = split2[1].split("x");
                    iArr[i][0] = Integer.parseInt(split2[0]);
                    if (isSubGridByColRow()) {
                        iArr[i][1] = Integer.parseInt(split3[1]);
                        iArr[i][2] = Integer.parseInt(split3[0]);
                    } else {
                        iArr[i][1] = Integer.parseInt(split3[0]);
                        iArr[i][2] = Integer.parseInt(split3[1]);
                    }
                }
                return iArr;
            }
            int i6 = 0;
            int i10 = 0;
            for (int i11 = 0; i11 < split.length; i11++) {
                String[] split4 = split[i11].trim().split(":");
                iArr[i11][0] = Integer.parseInt(split4[0]);
                int[] iArr2 = iArr[i11];
                iArr2[1] = 1;
                iArr2[2] = 1;
                if (this.mColumns == 1) {
                    iArr2[1] = Integer.parseInt(split4[1]);
                    i6 += iArr[i11][1];
                    if (z9) {
                        i6--;
                    }
                }
                if (this.mRows == 1) {
                    iArr[i11][2] = Integer.parseInt(split4[1]);
                    i10 += iArr[i11][2];
                    if (z9) {
                        i10--;
                    }
                }
            }
            if (i6 != 0 && !this.mExtraSpaceHandled) {
                setRows(this.mRows + i6);
            }
            if (i10 != 0 && !this.mExtraSpaceHandled) {
                setColumns(this.mColumns + i10);
            }
            this.mExtraSpaceHandled = true;
            return iArr;
        } catch (Exception unused) {
            return null;
        }
    }

    private float[] parseWeights(int i, String str) {
        if (str == null || str.trim().isEmpty()) {
            return null;
        }
        String[] split = str.split(",");
        float[] fArr = new float[i];
        for (int i6 = 0; i6 < i; i6++) {
            if (i6 < split.length) {
                try {
                    fArr[i6] = Float.parseFloat(split[i6]);
                } catch (Exception e10) {
                    System.err.println("Error parsing `" + split[i6] + "`: " + e10.getMessage());
                    fArr[i6] = 1.0f;
                }
            } else {
                fArr[i6] = 1.0f;
            }
        }
        return fArr;
    }

    private void setBoxWidgetHorizontalChains() {
        int i;
        int max = Math.max(this.mRows, this.mColumns);
        ConstraintWidget constraintWidget = this.mBoxWidgets[0];
        float[] parseWeights = parseWeights(this.mColumns, this.mColumnWeights);
        if (this.mColumns == 1) {
            clearHorizontalAttributes(constraintWidget);
            constraintWidget.mLeft.connect(this.mLeft, 0);
            constraintWidget.mRight.connect(this.mRight, 0);
            return;
        }
        int i6 = 0;
        while (true) {
            i = this.mColumns;
            if (i6 >= i) {
                break;
            }
            ConstraintWidget constraintWidget2 = this.mBoxWidgets[i6];
            clearHorizontalAttributes(constraintWidget2);
            if (parseWeights != null) {
                constraintWidget2.setHorizontalWeight(parseWeights[i6]);
            }
            if (i6 > 0) {
                constraintWidget2.mLeft.connect(this.mBoxWidgets[i6 - 1].mRight, 0);
            } else {
                constraintWidget2.mLeft.connect(this.mLeft, 0);
            }
            if (i6 < this.mColumns - 1) {
                constraintWidget2.mRight.connect(this.mBoxWidgets[i6 + 1].mLeft, 0);
            } else {
                constraintWidget2.mRight.connect(this.mRight, 0);
            }
            if (i6 > 0) {
                constraintWidget2.mLeft.mMargin = (int) this.mHorizontalGaps;
            }
            i6++;
        }
        while (i < max) {
            ConstraintWidget constraintWidget3 = this.mBoxWidgets[i];
            clearHorizontalAttributes(constraintWidget3);
            constraintWidget3.mLeft.connect(this.mLeft, 0);
            constraintWidget3.mRight.connect(this.mRight, 0);
            i++;
        }
    }

    private void setBoxWidgetVerticalChains() {
        int i;
        int max = Math.max(this.mRows, this.mColumns);
        ConstraintWidget constraintWidget = this.mBoxWidgets[0];
        float[] parseWeights = parseWeights(this.mRows, this.mRowWeights);
        if (this.mRows == 1) {
            clearVerticalAttributes(constraintWidget);
            constraintWidget.mTop.connect(this.mTop, 0);
            constraintWidget.mBottom.connect(this.mBottom, 0);
            return;
        }
        int i6 = 0;
        while (true) {
            i = this.mRows;
            if (i6 >= i) {
                break;
            }
            ConstraintWidget constraintWidget2 = this.mBoxWidgets[i6];
            clearVerticalAttributes(constraintWidget2);
            if (parseWeights != null) {
                constraintWidget2.setVerticalWeight(parseWeights[i6]);
            }
            if (i6 > 0) {
                constraintWidget2.mTop.connect(this.mBoxWidgets[i6 - 1].mBottom, 0);
            } else {
                constraintWidget2.mTop.connect(this.mTop, 0);
            }
            if (i6 < this.mRows - 1) {
                constraintWidget2.mBottom.connect(this.mBoxWidgets[i6 + 1].mTop, 0);
            } else {
                constraintWidget2.mBottom.connect(this.mBottom, 0);
            }
            if (i6 > 0) {
                constraintWidget2.mTop.mMargin = (int) this.mVerticalGaps;
            }
            i6++;
        }
        while (i < max) {
            ConstraintWidget constraintWidget3 = this.mBoxWidgets[i];
            clearVerticalAttributes(constraintWidget3);
            constraintWidget3.mTop.connect(this.mTop, 0);
            constraintWidget3.mBottom.connect(this.mBottom, 0);
            i++;
        }
    }

    private void setupGrid(boolean z9) {
        int[][] parseSpans;
        if (this.mRows < 1 || this.mColumns < 1) {
            return;
        }
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
            this.mSpanIds.clear();
        }
        this.mNextAvailableIndex = 0;
        String str = this.mSkips;
        if (str != null && !str.trim().isEmpty() && (parseSpans = parseSpans(this.mSkips, false)) != null) {
            handleSkips(parseSpans);
        }
        String str2 = this.mSpans;
        if (str2 != null && !str2.trim().isEmpty()) {
            this.mSpanMatrix = parseSpans(this.mSpans, true);
        }
        createBoxes();
        int[][] iArr = this.mSpanMatrix;
        if (iArr != null) {
            handleSpans(iArr);
        }
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
            this.mRows = ((this.mWidgetsCount + i10) - 1) / i10;
        } else if (i6 > 0) {
            this.mRows = i6;
            this.mColumns = ((this.mWidgetsCount + i6) - 1) / i6;
        } else {
            int sqrt = (int) (Math.sqrt(this.mWidgetsCount) + 1.5d);
            this.mRows = sqrt;
            this.mColumns = ((this.mWidgetsCount + sqrt) - 1) / sqrt;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(@Nullable LinearSystem linearSystem, boolean z9) {
        super.addToSolver(linearSystem, z9);
        addConstraints();
    }

    @Nullable
    public String getColumnWeights() {
        return this.mColumnWeights;
    }

    @Nullable
    public ConstraintWidgetContainer getContainer() {
        return this.mContainer;
    }

    public int getFlags() {
        return this.mFlags;
    }

    public float getHorizontalGaps() {
        return this.mHorizontalGaps;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    @Nullable
    public String getRowWeights() {
        return this.mRowWeights;
    }

    public float getVerticalGaps() {
        return this.mVerticalGaps;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i, int i6, int i10, int i11) {
        super.measure(i, i6, i10, i11);
        this.mContainer = (ConstraintWidgetContainer) getParent();
        setupGrid(false);
        this.mContainer.add(this.mBoxWidgets);
    }

    public void setColumnWeights(@NonNull String str) {
        String str2 = this.mColumnWeights;
        if (str2 == null || !str2.equals(str)) {
            this.mColumnWeights = str;
        }
    }

    public void setColumns(int i) {
        if (i <= 50 && this.mColumnsSet != i) {
            this.mColumnsSet = i;
            updateActualRowsAndColumns();
            initVariables();
        }
    }

    public void setContainer(@NonNull ConstraintWidgetContainer constraintWidgetContainer) {
        this.mContainer = constraintWidgetContainer;
    }

    public void setFlags(int i) {
        this.mFlags = i;
    }

    public void setHorizontalGaps(float f) {
        if (f >= 0.0f && this.mHorizontalGaps != f) {
            this.mHorizontalGaps = f;
        }
    }

    public void setOrientation(int i) {
        if ((i == 0 || i == 1) && this.mOrientation != i) {
            this.mOrientation = i;
        }
    }

    public void setRowWeights(@NonNull String str) {
        String str2 = this.mRowWeights;
        if (str2 == null || !str2.equals(str)) {
            this.mRowWeights = str;
        }
    }

    public void setRows(int i) {
        if (i <= 50 && this.mRowsSet != i) {
            this.mRowsSet = i;
            updateActualRowsAndColumns();
            initVariables();
        }
    }

    public void setSkips(@NonNull String str) {
        String str2 = this.mSkips;
        if (str2 == null || !str2.equals(str)) {
            this.mExtraSpaceHandled = false;
            this.mSkips = str;
        }
    }

    public void setSpans(@NonNull CharSequence charSequence) {
        String str = this.mSpans;
        if (str == null || !str.equals(charSequence.toString())) {
            this.mExtraSpaceHandled = false;
            this.mSpans = charSequence.toString();
        }
    }

    public void setVerticalGaps(float f) {
        if (f >= 0.0f && this.mVerticalGaps != f) {
            this.mVerticalGaps = f;
        }
    }

    public GridCore() {
        updateActualRowsAndColumns();
        initMatrices();
    }
}
