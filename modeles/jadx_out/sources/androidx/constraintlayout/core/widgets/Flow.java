package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class Flow extends VirtualLayout {
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_CHAIN_NEW = 3;
    public static final int WRAP_NONE = 0;
    private ConstraintWidget[] mDisplayedWidgets;
    private int mHorizontalStyle = -1;
    private int mVerticalStyle = -1;
    private int mFirstHorizontalStyle = -1;
    private int mFirstVerticalStyle = -1;
    private int mLastHorizontalStyle = -1;
    private int mLastVerticalStyle = -1;
    private float mHorizontalBias = 0.5f;
    private float mVerticalBias = 0.5f;
    private float mFirstHorizontalBias = 0.5f;
    private float mFirstVerticalBias = 0.5f;
    private float mLastHorizontalBias = 0.5f;
    private float mLastVerticalBias = 0.5f;
    private int mHorizontalGap = 0;
    private int mVerticalGap = 0;
    private int mHorizontalAlign = 2;
    private int mVerticalAlign = 2;
    private int mWrapMode = 0;
    private int mMaxElementsWrap = -1;
    private int mOrientation = 0;
    private ArrayList<WidgetsList> mChainList = new ArrayList<>();
    private ConstraintWidget[] mAlignedBiggestElementsInRows = null;
    private ConstraintWidget[] mAlignedBiggestElementsInCols = null;
    private int[] mAlignedDimensions = null;
    private int mDisplayedWidgetsCount = 0;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public class WidgetsList {
        private ConstraintAnchor mBottom;
        private ConstraintAnchor mLeft;
        private int mMax;
        private int mOrientation;
        private int mPaddingBottom;
        private int mPaddingLeft;
        private int mPaddingRight;
        private int mPaddingTop;
        private ConstraintAnchor mRight;
        private ConstraintAnchor mTop;
        private ConstraintWidget mBiggest = null;
        int mBiggestDimension = 0;
        private int mWidth = 0;
        private int mHeight = 0;
        private int mStartIndex = 0;
        private int mCount = 0;
        private int mNbMatchConstraintsWidgets = 0;

        public WidgetsList(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i6) {
            this.mPaddingLeft = 0;
            this.mPaddingTop = 0;
            this.mPaddingRight = 0;
            this.mPaddingBottom = 0;
            this.mMax = 0;
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = Flow.this.getPaddingLeft();
            this.mPaddingTop = Flow.this.getPaddingTop();
            this.mPaddingRight = Flow.this.getPaddingRight();
            this.mPaddingBottom = Flow.this.getPaddingBottom();
            this.mMax = i6;
        }

        private void recomputeDimensions() {
            this.mWidth = 0;
            this.mHeight = 0;
            this.mBiggest = null;
            this.mBiggestDimension = 0;
            int i = this.mCount;
            for (int i6 = 0; i6 < i && this.mStartIndex + i6 < Flow.this.mDisplayedWidgetsCount; i6++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i6];
                if (this.mOrientation == 0) {
                    int width = constraintWidget.getWidth();
                    int i10 = Flow.this.mHorizontalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i10 = 0;
                    }
                    this.mWidth = width + i10 + this.mWidth;
                    int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    if (this.mBiggest == null || this.mBiggestDimension < widgetHeight) {
                        this.mBiggest = constraintWidget;
                        this.mBiggestDimension = widgetHeight;
                        this.mHeight = widgetHeight;
                    }
                } else {
                    int widgetWidth = Flow.this.getWidgetWidth(constraintWidget, this.mMax);
                    int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                    int i11 = Flow.this.mVerticalGap;
                    if (constraintWidget.getVisibility() == 8) {
                        i11 = 0;
                    }
                    this.mHeight = widgetHeight2 + i11 + this.mHeight;
                    if (this.mBiggest == null || this.mBiggestDimension < widgetWidth) {
                        this.mBiggest = constraintWidget;
                        this.mBiggestDimension = widgetWidth;
                        this.mWidth = widgetWidth;
                    }
                }
            }
        }

        public void add(ConstraintWidget constraintWidget) {
            int i = this.mOrientation;
            Flow flow = Flow.this;
            if (i == 0) {
                int widgetWidth = flow.getWidgetWidth(constraintWidget, this.mMax);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetWidth = 0;
                }
                this.mWidth = widgetWidth + (constraintWidget.getVisibility() != 8 ? Flow.this.mHorizontalGap : 0) + this.mWidth;
                int widgetHeight = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (this.mBiggest == null || this.mBiggestDimension < widgetHeight) {
                    this.mBiggest = constraintWidget;
                    this.mBiggestDimension = widgetHeight;
                    this.mHeight = widgetHeight;
                }
            } else {
                int widgetWidth2 = flow.getWidgetWidth(constraintWidget, this.mMax);
                int widgetHeight2 = Flow.this.getWidgetHeight(constraintWidget, this.mMax);
                if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    this.mNbMatchConstraintsWidgets++;
                    widgetHeight2 = 0;
                }
                this.mHeight = widgetHeight2 + (constraintWidget.getVisibility() != 8 ? Flow.this.mVerticalGap : 0) + this.mHeight;
                if (this.mBiggest == null || this.mBiggestDimension < widgetWidth2) {
                    this.mBiggest = constraintWidget;
                    this.mBiggestDimension = widgetWidth2;
                    this.mWidth = widgetWidth2;
                }
            }
            this.mCount++;
        }

        public void clear() {
            this.mBiggestDimension = 0;
            this.mBiggest = null;
            this.mWidth = 0;
            this.mHeight = 0;
            this.mStartIndex = 0;
            this.mCount = 0;
            this.mNbMatchConstraintsWidgets = 0;
        }

        /* JADX WARN: Code restructure failed: missing block: B:82:0x0142, code lost:
        
            if (r18 != false) goto L86;
         */
        /* JADX WARN: Code restructure failed: missing block: B:83:0x0144, code lost:
        
            r11 = 1.0f - r11;
         */
        /* JADX WARN: Code restructure failed: missing block: B:89:0x015d, code lost:
        
            if (r18 != false) goto L86;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void createConstraints(boolean r18, int r19, boolean r20) {
            /*
                Method dump skipped, instructions count: 884
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.WidgetsList.createConstraints(boolean, int, boolean):void");
        }

        public int getHeight() {
            int i = this.mOrientation;
            int i6 = this.mHeight;
            return i == 1 ? i6 - Flow.this.mVerticalGap : i6;
        }

        public int getWidth() {
            int i = this.mOrientation;
            int i6 = this.mWidth;
            return i == 0 ? i6 - Flow.this.mHorizontalGap : i6;
        }

        public void measureMatchConstraints(int i) {
            int i6 = this.mNbMatchConstraintsWidgets;
            if (i6 == 0) {
                return;
            }
            int i10 = this.mCount;
            int i11 = i / i6;
            for (int i12 = 0; i12 < i10 && this.mStartIndex + i12 < Flow.this.mDisplayedWidgetsCount; i12++) {
                ConstraintWidget constraintWidget = Flow.this.mDisplayedWidgets[this.mStartIndex + i12];
                if (this.mOrientation == 0) {
                    if (constraintWidget != null && constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultWidth == 0) {
                        Flow.this.measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i11, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                    }
                } else if (constraintWidget != null && constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT && constraintWidget.mMatchConstraintDefaultHeight == 0) {
                    int i13 = i11;
                    Flow.this.measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i13);
                    i11 = i13;
                }
            }
            recomputeDimensions();
        }

        public void setStartIndex(int i) {
            this.mStartIndex = i;
        }

        public void setup(int i, ConstraintAnchor constraintAnchor, ConstraintAnchor constraintAnchor2, ConstraintAnchor constraintAnchor3, ConstraintAnchor constraintAnchor4, int i6, int i10, int i11, int i12, int i13) {
            this.mOrientation = i;
            this.mLeft = constraintAnchor;
            this.mTop = constraintAnchor2;
            this.mRight = constraintAnchor3;
            this.mBottom = constraintAnchor4;
            this.mPaddingLeft = i6;
            this.mPaddingTop = i10;
            this.mPaddingRight = i11;
            this.mPaddingBottom = i12;
            this.mMax = i13;
        }
    }

    private void createAlignedConstraints(boolean z9) {
        ConstraintWidget constraintWidget;
        float f;
        int i;
        if (this.mAlignedDimensions == null || this.mAlignedBiggestElementsInCols == null || this.mAlignedBiggestElementsInRows == null) {
            return;
        }
        for (int i6 = 0; i6 < this.mDisplayedWidgetsCount; i6++) {
            this.mDisplayedWidgets[i6].resetAnchors();
        }
        int[] iArr = this.mAlignedDimensions;
        int i10 = iArr[0];
        int i11 = iArr[1];
        float f10 = this.mHorizontalBias;
        ConstraintWidget constraintWidget2 = null;
        int i12 = 0;
        while (i12 < i10) {
            if (z9) {
                i = (i10 - i12) - 1;
                f = 1.0f - this.mHorizontalBias;
            } else {
                f = f10;
                i = i12;
            }
            ConstraintWidget constraintWidget3 = this.mAlignedBiggestElementsInCols[i];
            if (constraintWidget3 != null && constraintWidget3.getVisibility() != 8) {
                if (i12 == 0) {
                    constraintWidget3.connect(constraintWidget3.mLeft, this.mLeft, getPaddingLeft());
                    constraintWidget3.setHorizontalChainStyle(this.mHorizontalStyle);
                    constraintWidget3.setHorizontalBiasPercent(f);
                }
                if (i12 == i10 - 1) {
                    constraintWidget3.connect(constraintWidget3.mRight, this.mRight, getPaddingRight());
                }
                if (i12 > 0 && constraintWidget2 != null) {
                    constraintWidget3.connect(constraintWidget3.mLeft, constraintWidget2.mRight, this.mHorizontalGap);
                    constraintWidget2.connect(constraintWidget2.mRight, constraintWidget3.mLeft, 0);
                }
                constraintWidget2 = constraintWidget3;
            }
            i12++;
            f10 = f;
        }
        for (int i13 = 0; i13 < i11; i13++) {
            ConstraintWidget constraintWidget4 = this.mAlignedBiggestElementsInRows[i13];
            if (constraintWidget4 != null && constraintWidget4.getVisibility() != 8) {
                if (i13 == 0) {
                    constraintWidget4.connect(constraintWidget4.mTop, this.mTop, getPaddingTop());
                    constraintWidget4.setVerticalChainStyle(this.mVerticalStyle);
                    constraintWidget4.setVerticalBiasPercent(this.mVerticalBias);
                }
                if (i13 == i11 - 1) {
                    constraintWidget4.connect(constraintWidget4.mBottom, this.mBottom, getPaddingBottom());
                }
                if (i13 > 0 && constraintWidget2 != null) {
                    constraintWidget4.connect(constraintWidget4.mTop, constraintWidget2.mBottom, this.mVerticalGap);
                    constraintWidget2.connect(constraintWidget2.mBottom, constraintWidget4.mTop, 0);
                }
                constraintWidget2 = constraintWidget4;
            }
        }
        for (int i14 = 0; i14 < i10; i14++) {
            for (int i15 = 0; i15 < i11; i15++) {
                int i16 = (i15 * i10) + i14;
                if (this.mOrientation == 1) {
                    i16 = (i14 * i11) + i15;
                }
                ConstraintWidget[] constraintWidgetArr = this.mDisplayedWidgets;
                if (i16 < constraintWidgetArr.length && (constraintWidget = constraintWidgetArr[i16]) != null && constraintWidget.getVisibility() != 8) {
                    ConstraintWidget constraintWidget5 = this.mAlignedBiggestElementsInCols[i14];
                    ConstraintWidget constraintWidget6 = this.mAlignedBiggestElementsInRows[i15];
                    if (constraintWidget != constraintWidget5) {
                        constraintWidget.connect(constraintWidget.mLeft, constraintWidget5.mLeft, 0);
                        constraintWidget.connect(constraintWidget.mRight, constraintWidget5.mRight, 0);
                    }
                    if (constraintWidget != constraintWidget6) {
                        constraintWidget.connect(constraintWidget.mTop, constraintWidget6.mTop, 0);
                        constraintWidget.connect(constraintWidget.mBottom, constraintWidget6.mBottom, 0);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWidgetHeight(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i6 = constraintWidget.mMatchConstraintDefaultHeight;
            if (i6 == 0) {
                return 0;
            }
            if (i6 == 2) {
                int i10 = (int) (constraintWidget.mMatchConstraintPercentHeight * i);
                if (i10 != constraintWidget.getHeight()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, constraintWidget.getHorizontalDimensionBehaviour(), constraintWidget.getWidth(), ConstraintWidget.DimensionBehaviour.FIXED, i10);
                }
                return i10;
            }
            constraintWidget2 = constraintWidget;
            if (i6 == 1) {
                return constraintWidget2.getHeight();
            }
            if (i6 == 3) {
                return (int) ((constraintWidget2.getWidth() * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getWidgetWidth(ConstraintWidget constraintWidget, int i) {
        ConstraintWidget constraintWidget2;
        if (constraintWidget == null) {
            return 0;
        }
        if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
            int i6 = constraintWidget.mMatchConstraintDefaultWidth;
            if (i6 == 0) {
                return 0;
            }
            if (i6 == 2) {
                int i10 = (int) (constraintWidget.mMatchConstraintPercentWidth * i);
                if (i10 != constraintWidget.getWidth()) {
                    constraintWidget.setMeasureRequested(true);
                    measure(constraintWidget, ConstraintWidget.DimensionBehaviour.FIXED, i10, constraintWidget.getVerticalDimensionBehaviour(), constraintWidget.getHeight());
                }
                return i10;
            }
            constraintWidget2 = constraintWidget;
            if (i6 == 1) {
                return constraintWidget2.getWidth();
            }
            if (i6 == 3) {
                return (int) ((constraintWidget2.getHeight() * constraintWidget2.mDimensionRatio) + 0.5f);
            }
        } else {
            constraintWidget2 = constraintWidget;
        }
        return constraintWidget2.getWidth();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x005c  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x010b -> B:21:0x0057). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x010d -> B:21:0x0057). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:79:0x0113 -> B:21:0x0057). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:80:0x0115 -> B:21:0x0057). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[] r11, int r12, int r13, int r14, int[] r15) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.Flow.measureAligned(androidx.constraintlayout.core.widgets.ConstraintWidget[], int, int, int, int[]):void");
    }

    private void measureChainWrap(ConstraintWidget[] constraintWidgetArr, int i, int i6, int i10, int[] iArr) {
        int i11;
        Flow flow;
        int i12;
        ConstraintAnchor constraintAnchor;
        int i13;
        Flow flow2 = this;
        if (i == 0) {
            return;
        }
        flow2.mChainList.clear();
        int i14 = i10;
        WidgetsList widgetsList = flow2.new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i14);
        flow2.mChainList.add(widgetsList);
        if (i6 == 0) {
            i11 = 0;
            int i15 = 0;
            int i16 = 0;
            while (i16 < i) {
                ConstraintWidget constraintWidget = constraintWidgetArr[i16];
                int widgetWidth = flow2.getWidgetWidth(constraintWidget, i14);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i11++;
                }
                int i17 = i11;
                boolean z9 = (i15 == i14 || (flow2.mHorizontalGap + i15) + widgetWidth > i14) && widgetsList.mBiggest != null;
                if (!z9 && i16 > 0 && (i13 = flow2.mMaxElementsWrap) > 0 && i16 % i13 == 0) {
                    z9 = true;
                }
                if (z9) {
                    widgetsList = flow2.new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i14);
                    widgetsList.setStartIndex(i16);
                    flow2.mChainList.add(widgetsList);
                } else if (i16 > 0) {
                    i15 = flow2.mHorizontalGap + widgetWidth + i15;
                    widgetsList.add(constraintWidget);
                    i16++;
                    i11 = i17;
                }
                i15 = widgetWidth;
                widgetsList.add(constraintWidget);
                i16++;
                i11 = i17;
            }
        } else {
            i11 = 0;
            int i18 = 0;
            int i19 = 0;
            while (i19 < i) {
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i19];
                int widgetHeight = flow2.getWidgetHeight(constraintWidget2, i14);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i11++;
                }
                int i20 = i11;
                boolean z10 = (i18 == i14 || (flow2.mVerticalGap + i18) + widgetHeight > i14) && widgetsList.mBiggest != null;
                if (!z10 && i19 > 0 && (i12 = flow2.mMaxElementsWrap) > 0 && i19 % i12 == 0) {
                    z10 = true;
                }
                if (z10) {
                    widgetsList = flow2.new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i14);
                    flow = flow2;
                    widgetsList.setStartIndex(i19);
                    flow.mChainList.add(widgetsList);
                } else {
                    flow = flow2;
                    if (i19 > 0) {
                        i18 = flow.mVerticalGap + widgetHeight + i18;
                        widgetsList.add(constraintWidget2);
                        i19++;
                        i14 = i10;
                        i11 = i20;
                        flow2 = flow;
                    }
                }
                i18 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i19++;
                i14 = i10;
                i11 = i20;
                flow2 = flow;
            }
        }
        Flow flow3 = flow2;
        int size = flow3.mChainList.size();
        ConstraintAnchor constraintAnchor2 = flow3.mLeft;
        ConstraintAnchor constraintAnchor3 = flow3.mTop;
        ConstraintAnchor constraintAnchor4 = flow3.mRight;
        ConstraintAnchor constraintAnchor5 = flow3.mBottom;
        int paddingLeft = flow3.getPaddingLeft();
        int paddingTop = flow3.getPaddingTop();
        int paddingRight = flow3.getPaddingRight();
        int paddingBottom = flow3.getPaddingBottom();
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = flow3.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z11 = horizontalDimensionBehaviour == dimensionBehaviour || flow3.getVerticalDimensionBehaviour() == dimensionBehaviour;
        if (i11 > 0 && z11) {
            for (int i21 = 0; i21 < size; i21++) {
                WidgetsList widgetsList2 = flow3.mChainList.get(i21);
                if (i6 == 0) {
                    widgetsList2.measureMatchConstraints(i10 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i10 - widgetsList2.getHeight());
                }
            }
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchor2;
        int i22 = paddingBottom;
        int i23 = 0;
        int i24 = paddingRight;
        int i25 = paddingTop;
        int i26 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor5;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        ConstraintAnchor constraintAnchor9 = constraintAnchor3;
        int i27 = 0;
        for (int i28 = 0; i28 < size; i28++) {
            WidgetsList widgetsList3 = flow3.mChainList.get(i28);
            if (i6 == 0) {
                if (i28 < size - 1) {
                    constraintAnchor7 = flow3.mChainList.get(i28 + 1).mBiggest.mTop;
                    i22 = 0;
                } else {
                    constraintAnchor7 = flow3.mBottom;
                    i22 = flow3.getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor10 = widgetsList3.mBiggest.mBottom;
                int i29 = i27;
                widgetsList3.setup(i6, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i26, i25, i24, i22, i10);
                int max = Math.max(i23, widgetsList3.getWidth());
                int height = widgetsList3.getHeight() + i29;
                if (i28 > 0) {
                    height += flow3.mVerticalGap;
                }
                i27 = height;
                i23 = max;
                constraintAnchor9 = constraintAnchor10;
                i25 = 0;
            } else {
                int i30 = i23;
                int i31 = i27;
                if (i28 < size - 1) {
                    constraintAnchor = flow3.mChainList.get(i28 + 1).mBiggest.mLeft;
                    i24 = 0;
                } else {
                    constraintAnchor = flow3.mRight;
                    i24 = flow3.getPaddingRight();
                }
                constraintAnchor8 = constraintAnchor;
                ConstraintAnchor constraintAnchor11 = widgetsList3.mBiggest.mRight;
                widgetsList3.setup(i6, constraintAnchor6, constraintAnchor9, constraintAnchor8, constraintAnchor7, i26, i25, i24, i22, i10);
                int width = widgetsList3.getWidth() + i30;
                int max2 = Math.max(i31, widgetsList3.getHeight());
                if (i28 > 0) {
                    width += flow3.mHorizontalGap;
                }
                int i32 = width;
                i27 = max2;
                i23 = i32;
                i26 = 0;
                constraintAnchor6 = constraintAnchor11;
            }
        }
        iArr[0] = i23;
        iArr[1] = i27;
    }

    private void measureChainWrap_new(ConstraintWidget[] constraintWidgetArr, int i, int i6, int i10, int[] iArr) {
        int i11;
        Flow flow;
        int i12;
        boolean z9;
        ConstraintAnchor constraintAnchor;
        int i13;
        Flow flow2 = this;
        if (i == 0) {
            return;
        }
        flow2.mChainList.clear();
        int i14 = i10;
        WidgetsList widgetsList = flow2.new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i14);
        flow2.mChainList.add(widgetsList);
        boolean z10 = true;
        if (i6 == 0) {
            int i15 = 0;
            i11 = 0;
            int i16 = 0;
            int i17 = 0;
            while (i17 < i) {
                i15++;
                ConstraintWidget constraintWidget = constraintWidgetArr[i17];
                int widgetWidth = flow2.getWidgetWidth(constraintWidget, i14);
                if (constraintWidget.getHorizontalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i11++;
                }
                int i18 = i11;
                boolean z11 = (i16 == i14 || (flow2.mHorizontalGap + i16) + widgetWidth > i14) && widgetsList.mBiggest != null;
                if (!z11 && i17 > 0 && (i13 = flow2.mMaxElementsWrap) > 0 && i15 > i13) {
                    z11 = true;
                }
                if (z11) {
                    widgetsList = flow2.new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i14);
                    widgetsList.setStartIndex(i17);
                    flow2.mChainList.add(widgetsList);
                    i15 = 1;
                } else if (i17 > 0) {
                    i16 = flow2.mHorizontalGap + widgetWidth + i16;
                    widgetsList.add(constraintWidget);
                    i17++;
                    i11 = i18;
                }
                i16 = widgetWidth;
                widgetsList.add(constraintWidget);
                i17++;
                i11 = i18;
            }
        } else {
            int i19 = 0;
            i11 = 0;
            int i20 = 0;
            int i21 = 0;
            while (i21 < i) {
                i19++;
                ConstraintWidget constraintWidget2 = constraintWidgetArr[i21];
                int widgetHeight = flow2.getWidgetHeight(constraintWidget2, i14);
                if (constraintWidget2.getVerticalDimensionBehaviour() == ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT) {
                    i11++;
                }
                int i22 = i11;
                boolean z12 = (i20 == i14 || (flow2.mVerticalGap + i20) + widgetHeight > i14) && widgetsList.mBiggest != null;
                if (!z12 && i21 > 0 && (i12 = flow2.mMaxElementsWrap) > 0 && i19 > i12) {
                    z12 = true;
                }
                if (z12) {
                    widgetsList = flow2.new WidgetsList(i6, flow2.mLeft, flow2.mTop, flow2.mRight, flow2.mBottom, i14);
                    flow = flow2;
                    widgetsList.setStartIndex(i21);
                    flow.mChainList.add(widgetsList);
                    i19 = 1;
                } else {
                    flow = flow2;
                    if (i21 > 0) {
                        i20 = flow.mVerticalGap + widgetHeight + i20;
                        widgetsList.add(constraintWidget2);
                        i21++;
                        i14 = i10;
                        i11 = i22;
                        flow2 = flow;
                    }
                }
                i20 = widgetHeight;
                widgetsList.add(constraintWidget2);
                i21++;
                i14 = i10;
                i11 = i22;
                flow2 = flow;
            }
        }
        Flow flow3 = flow2;
        int size = flow3.mChainList.size();
        ConstraintAnchor constraintAnchor2 = flow3.mLeft;
        ConstraintAnchor constraintAnchor3 = flow3.mTop;
        ConstraintAnchor constraintAnchor4 = flow3.mRight;
        ConstraintAnchor constraintAnchor5 = flow3.mBottom;
        int paddingLeft = flow3.getPaddingLeft();
        int paddingTop = flow3.getPaddingTop();
        int paddingRight = flow3.getPaddingRight();
        int paddingBottom = flow3.getPaddingBottom();
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = flow3.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
        boolean z13 = horizontalDimensionBehaviour == dimensionBehaviour || flow3.getVerticalDimensionBehaviour() == dimensionBehaviour;
        if (i11 > 0 && z13) {
            for (int i23 = 0; i23 < size; i23++) {
                WidgetsList widgetsList2 = flow3.mChainList.get(i23);
                if (i6 == 0) {
                    widgetsList2.measureMatchConstraints(i10 - widgetsList2.getWidth());
                } else {
                    widgetsList2.measureMatchConstraints(i10 - widgetsList2.getHeight());
                }
            }
        }
        ConstraintAnchor constraintAnchor6 = constraintAnchor3;
        int i24 = paddingBottom;
        int i25 = 0;
        int i26 = 0;
        int i27 = paddingRight;
        int i28 = paddingTop;
        int i29 = paddingLeft;
        ConstraintAnchor constraintAnchor7 = constraintAnchor5;
        ConstraintAnchor constraintAnchor8 = constraintAnchor4;
        ConstraintAnchor constraintAnchor9 = constraintAnchor2;
        int i30 = 0;
        while (i26 < size) {
            WidgetsList widgetsList3 = flow3.mChainList.get(i26);
            if (i6 == 0) {
                if (i26 < size - 1) {
                    constraintAnchor7 = flow3.mChainList.get(i26 + 1).mBiggest.mTop;
                    i24 = 0;
                } else {
                    constraintAnchor7 = flow3.mBottom;
                    i24 = flow3.getPaddingBottom();
                }
                ConstraintAnchor constraintAnchor10 = widgetsList3.mBiggest.mBottom;
                z9 = z10;
                int i31 = i25;
                widgetsList3.setup(i6, constraintAnchor9, constraintAnchor6, constraintAnchor8, constraintAnchor7, i29, i28, i27, i24, i10);
                int max = Math.max(i30, widgetsList3.getWidth());
                int height = widgetsList3.getHeight() + i31;
                if (i26 > 0) {
                    height += flow3.mVerticalGap;
                }
                i25 = height;
                i30 = max;
                constraintAnchor6 = constraintAnchor10;
                i28 = 0;
            } else {
                int i32 = i25;
                z9 = z10;
                int i33 = i30;
                if (i26 < size - 1) {
                    constraintAnchor = flow3.mChainList.get(i26 + 1).mBiggest.mLeft;
                    i27 = 0;
                } else {
                    constraintAnchor = flow3.mRight;
                    i27 = flow3.getPaddingRight();
                }
                constraintAnchor8 = constraintAnchor;
                ConstraintAnchor constraintAnchor11 = widgetsList3.mBiggest.mRight;
                widgetsList3.setup(i6, constraintAnchor9, constraintAnchor6, constraintAnchor8, constraintAnchor7, i29, i28, i27, i24, i10);
                int width = widgetsList3.getWidth() + i33;
                int max2 = Math.max(i32, widgetsList3.getHeight());
                if (i26 > 0) {
                    width += flow3.mHorizontalGap;
                }
                int i34 = width;
                i25 = max2;
                i30 = i34;
                i29 = 0;
                constraintAnchor9 = constraintAnchor11;
            }
            i26++;
            z10 = z9;
        }
        iArr[0] = i30;
        iArr[z10 ? 1 : 0] = i25;
    }

    private void measureNoWrap(ConstraintWidget[] constraintWidgetArr, int i, int i6, int i10, int[] iArr) {
        WidgetsList widgetsList;
        if (i == 0) {
            return;
        }
        if (this.mChainList.size() == 0) {
            widgetsList = new WidgetsList(i6, this.mLeft, this.mTop, this.mRight, this.mBottom, i10);
            this.mChainList.add(widgetsList);
        } else {
            WidgetsList widgetsList2 = this.mChainList.get(0);
            widgetsList2.clear();
            widgetsList2.setup(i6, this.mLeft, this.mTop, this.mRight, this.mBottom, getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom(), i10);
            widgetsList = widgetsList2;
        }
        for (int i11 = 0; i11 < i; i11++) {
            widgetsList.add(constraintWidgetArr[i11]);
        }
        iArr[0] = widgetsList.getWidth();
        iArr[1] = widgetsList.getHeight();
    }

    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z9) {
        super.addToSolver(linearSystem, z9);
        boolean z10 = getParent() != null && ((ConstraintWidgetContainer) getParent()).isRtl();
        int i = this.mWrapMode;
        if (i != 0) {
            if (i == 1) {
                int size = this.mChainList.size();
                int i6 = 0;
                while (i6 < size) {
                    this.mChainList.get(i6).createConstraints(z10, i6, i6 == size + (-1));
                    i6++;
                }
            } else if (i == 2) {
                createAlignedConstraints(z10);
            } else if (i == 3) {
                int size2 = this.mChainList.size();
                int i10 = 0;
                while (i10 < size2) {
                    this.mChainList.get(i10).createConstraints(z10, i10, i10 == size2 + (-1));
                    i10++;
                }
            }
        } else if (this.mChainList.size() > 0) {
            this.mChainList.get(0).createConstraints(z10, 0, true);
        }
        needsCallbackFromSolver(false);
    }

    @Override // androidx.constraintlayout.core.widgets.HelperWidget, androidx.constraintlayout.core.widgets.ConstraintWidget
    public void copy(ConstraintWidget constraintWidget, HashMap<ConstraintWidget, ConstraintWidget> hashMap) {
        super.copy(constraintWidget, hashMap);
        Flow flow = (Flow) constraintWidget;
        this.mHorizontalStyle = flow.mHorizontalStyle;
        this.mVerticalStyle = flow.mVerticalStyle;
        this.mFirstHorizontalStyle = flow.mFirstHorizontalStyle;
        this.mFirstVerticalStyle = flow.mFirstVerticalStyle;
        this.mLastHorizontalStyle = flow.mLastHorizontalStyle;
        this.mLastVerticalStyle = flow.mLastVerticalStyle;
        this.mHorizontalBias = flow.mHorizontalBias;
        this.mVerticalBias = flow.mVerticalBias;
        this.mFirstHorizontalBias = flow.mFirstHorizontalBias;
        this.mFirstVerticalBias = flow.mFirstVerticalBias;
        this.mLastHorizontalBias = flow.mLastHorizontalBias;
        this.mLastVerticalBias = flow.mLastVerticalBias;
        this.mHorizontalGap = flow.mHorizontalGap;
        this.mVerticalGap = flow.mVerticalGap;
        this.mHorizontalAlign = flow.mHorizontalAlign;
        this.mVerticalAlign = flow.mVerticalAlign;
        this.mWrapMode = flow.mWrapMode;
        this.mMaxElementsWrap = flow.mMaxElementsWrap;
        this.mOrientation = flow.mOrientation;
    }

    public float getMaxElementsWrap() {
        return this.mMaxElementsWrap;
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i, int i6, int i10, int i11) {
        int i12;
        if (this.mWidgetsCount > 0 && !measureChildren()) {
            setMeasure(0, 0);
            needsCallbackFromSolver(false);
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int[] iArr = new int[2];
        int i13 = (i6 - paddingLeft) - paddingRight;
        int i14 = this.mOrientation;
        if (i14 == 1) {
            i13 = (i11 - paddingTop) - paddingBottom;
        }
        int i15 = i13;
        int i16 = this.mHorizontalStyle;
        if (i14 == 0) {
            if (i16 == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        } else {
            if (i16 == -1) {
                this.mHorizontalStyle = 0;
            }
            if (this.mVerticalStyle == -1) {
                this.mVerticalStyle = 0;
            }
        }
        ConstraintWidget[] constraintWidgetArr = this.mWidgets;
        int i17 = 0;
        int i18 = 0;
        while (true) {
            i12 = this.mWidgetsCount;
            if (i17 >= i12) {
                break;
            }
            if (this.mWidgets[i17].getVisibility() == 8) {
                i18++;
            }
            i17++;
        }
        if (i18 > 0) {
            constraintWidgetArr = new ConstraintWidget[i12 - i18];
            int i19 = 0;
            i12 = 0;
            while (i19 < this.mWidgetsCount) {
                ConstraintWidget constraintWidget = this.mWidgets[i19];
                ConstraintWidget[] constraintWidgetArr2 = constraintWidgetArr;
                if (constraintWidget.getVisibility() != 8) {
                    constraintWidgetArr2[i12] = constraintWidget;
                    i12++;
                }
                i19++;
                constraintWidgetArr = constraintWidgetArr2;
            }
        }
        int i20 = i12;
        this.mDisplayedWidgets = constraintWidgetArr;
        this.mDisplayedWidgetsCount = i20;
        int i21 = this.mWrapMode;
        if (i21 == 0) {
            measureNoWrap(constraintWidgetArr, i20, this.mOrientation, i15, iArr);
        } else if (i21 == 1) {
            measureChainWrap(constraintWidgetArr, i20, this.mOrientation, i15, iArr);
        } else if (i21 == 2) {
            measureAligned(constraintWidgetArr, i20, this.mOrientation, i15, iArr);
        } else if (i21 == 3) {
            measureChainWrap_new(constraintWidgetArr, i20, this.mOrientation, i15, iArr);
        }
        int i22 = iArr[0] + paddingLeft + paddingRight;
        int i23 = iArr[1] + paddingTop + paddingBottom;
        if (i == 1073741824) {
            i22 = i6;
        } else if (i == Integer.MIN_VALUE) {
            i22 = Math.min(i22, i6);
        } else if (i != 0) {
            i22 = 0;
        }
        if (i10 == 1073741824) {
            i23 = i11;
        } else if (i10 == Integer.MIN_VALUE) {
            i23 = Math.min(i23, i11);
        } else if (i10 != 0) {
            i23 = 0;
        }
        setMeasure(i22, i23);
        setWidth(i22);
        setHeight(i23);
        needsCallbackFromSolver(this.mWidgetsCount > 0);
    }

    public void setFirstHorizontalBias(float f) {
        this.mFirstHorizontalBias = f;
    }

    public void setFirstHorizontalStyle(int i) {
        this.mFirstHorizontalStyle = i;
    }

    public void setFirstVerticalBias(float f) {
        this.mFirstVerticalBias = f;
    }

    public void setFirstVerticalStyle(int i) {
        this.mFirstVerticalStyle = i;
    }

    public void setHorizontalAlign(int i) {
        this.mHorizontalAlign = i;
    }

    public void setHorizontalBias(float f) {
        this.mHorizontalBias = f;
    }

    public void setHorizontalGap(int i) {
        this.mHorizontalGap = i;
    }

    public void setHorizontalStyle(int i) {
        this.mHorizontalStyle = i;
    }

    public void setLastHorizontalBias(float f) {
        this.mLastHorizontalBias = f;
    }

    public void setLastHorizontalStyle(int i) {
        this.mLastHorizontalStyle = i;
    }

    public void setLastVerticalBias(float f) {
        this.mLastVerticalBias = f;
    }

    public void setLastVerticalStyle(int i) {
        this.mLastVerticalStyle = i;
    }

    public void setMaxElementsWrap(int i) {
        this.mMaxElementsWrap = i;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
    }

    public void setVerticalAlign(int i) {
        this.mVerticalAlign = i;
    }

    public void setVerticalBias(float f) {
        this.mVerticalBias = f;
    }

    public void setVerticalGap(int i) {
        this.mVerticalGap = i;
    }

    public void setVerticalStyle(int i) {
        this.mVerticalStyle = i;
    }

    public void setWrapMode(int i) {
        this.mWrapMode = i;
    }
}
