package androidx.leanback.widget;

import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
final class WindowAlignment {
    public final Axis horizontal;
    private Axis mMainAxis;
    private int mOrientation = 0;
    private Axis mSecondAxis;
    public final Axis vertical;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static final class Axis {
        private static final int PF_KEYLINE_OVER_HIGH_EDGE = 2;
        private static final int PF_KEYLINE_OVER_LOW_EDGE = 1;
        private int mMaxEdge;
        private int mMaxScroll;
        private int mMinEdge;
        private int mMinScroll;
        private int mPaddingMax;
        private int mPaddingMin;
        private boolean mReversedFlow;
        private int mSize;
        private int mPreferredKeyLine = 2;
        private int mWindowAlignment = 3;
        private int mWindowAlignmentOffset = 0;
        private float mWindowAlignmentOffsetPercent = 50.0f;

        public Axis(String str) {
            reset();
        }

        public int calculateKeyline() {
            boolean z9 = this.mReversedFlow;
            int i = this.mWindowAlignmentOffset;
            if (z9) {
                int i6 = i >= 0 ? this.mSize - i : -i;
                float f = this.mWindowAlignmentOffsetPercent;
                return f != -1.0f ? i6 - ((int) ((this.mSize * f) / 100.0f)) : i6;
            }
            if (i < 0) {
                i += this.mSize;
            }
            float f10 = this.mWindowAlignmentOffsetPercent;
            return f10 != -1.0f ? i + ((int) ((this.mSize * f10) / 100.0f)) : i;
        }

        public int calculateScrollToKeyLine(int i, int i6) {
            return i - i6;
        }

        public int getClientSize() {
            return (this.mSize - this.mPaddingMin) - this.mPaddingMax;
        }

        public int getMaxScroll() {
            return this.mMaxScroll;
        }

        public int getMinScroll() {
            return this.mMinScroll;
        }

        public int getPaddingMax() {
            return this.mPaddingMax;
        }

        public int getPaddingMin() {
            return this.mPaddingMin;
        }

        public int getScroll(int i) {
            int i6;
            int i10;
            int size = getSize();
            int calculateKeyline = calculateKeyline();
            boolean isMinUnknown = isMinUnknown();
            boolean isMaxUnknown = isMaxUnknown();
            if (!isMinUnknown) {
                int i11 = this.mPaddingMin;
                int i12 = calculateKeyline - i11;
                boolean z9 = this.mReversedFlow;
                int i13 = this.mWindowAlignment;
                if (z9 ? (i13 & 2) != 0 : (i13 & 1) != 0) {
                    int i14 = this.mMinEdge;
                    if (i - i14 <= i12) {
                        int i15 = i14 - i11;
                        return (isMaxUnknown || i15 <= (i10 = this.mMaxScroll)) ? i15 : i10;
                    }
                }
            }
            if (!isMaxUnknown) {
                int i16 = this.mPaddingMax;
                int i17 = (size - calculateKeyline) - i16;
                boolean z10 = this.mReversedFlow;
                int i18 = this.mWindowAlignment;
                if (z10 ? (i18 & 1) != 0 : (i18 & 2) != 0) {
                    int i19 = this.mMaxEdge;
                    if (i19 - i <= i17) {
                        int i20 = i19 - (size - i16);
                        return (isMinUnknown || i20 >= (i6 = this.mMinScroll)) ? i20 : i6;
                    }
                }
            }
            return calculateScrollToKeyLine(i, calculateKeyline);
        }

        public int getSize() {
            return this.mSize;
        }

        public int getWindowAlignment() {
            return this.mWindowAlignment;
        }

        public int getWindowAlignmentOffset() {
            return this.mWindowAlignmentOffset;
        }

        public float getWindowAlignmentOffsetPercent() {
            return this.mWindowAlignmentOffsetPercent;
        }

        public void invalidateScrollMax() {
            this.mMaxEdge = Integer.MAX_VALUE;
            this.mMaxScroll = Integer.MAX_VALUE;
        }

        public void invalidateScrollMin() {
            this.mMinEdge = Integer.MIN_VALUE;
            this.mMinScroll = Integer.MIN_VALUE;
        }

        public boolean isMaxUnknown() {
            return this.mMaxEdge == Integer.MAX_VALUE;
        }

        public boolean isMinUnknown() {
            return this.mMinEdge == Integer.MIN_VALUE;
        }

        public boolean isPreferKeylineOverHighEdge() {
            return (this.mPreferredKeyLine & 2) != 0;
        }

        public boolean isPreferKeylineOverLowEdge() {
            return (this.mPreferredKeyLine & 1) != 0;
        }

        public void reset() {
            this.mMinEdge = Integer.MIN_VALUE;
            this.mMaxEdge = Integer.MAX_VALUE;
        }

        public void setPadding(int i, int i6) {
            this.mPaddingMin = i;
            this.mPaddingMax = i6;
        }

        public void setPreferKeylineOverHighEdge(boolean z9) {
            int i = this.mPreferredKeyLine;
            this.mPreferredKeyLine = z9 ? i | 2 : i & (-3);
        }

        public void setPreferKeylineOverLowEdge(boolean z9) {
            int i = this.mPreferredKeyLine;
            this.mPreferredKeyLine = z9 ? i | 1 : i & (-2);
        }

        public void setReversedFlow(boolean z9) {
            this.mReversedFlow = z9;
        }

        public void setSize(int i) {
            this.mSize = i;
        }

        public void setWindowAlignment(int i) {
            this.mWindowAlignment = i;
        }

        public void setWindowAlignmentOffset(int i) {
            this.mWindowAlignmentOffset = i;
        }

        public void setWindowAlignmentOffsetPercent(float f) {
            if ((f < 0.0f || f > 100.0f) && f != -1.0f) {
                o.n();
            } else {
                this.mWindowAlignmentOffsetPercent = f;
            }
        }

        public String toString() {
            return " min:" + this.mMinEdge + " " + this.mMinScroll + " max:" + this.mMaxEdge + " " + this.mMaxScroll;
        }

        public void updateMinMax(int i, int i6, int i10, int i11) {
            this.mMinEdge = i;
            this.mMaxEdge = i6;
            int clientSize = getClientSize();
            int calculateKeyline = calculateKeyline();
            boolean isMinUnknown = isMinUnknown();
            boolean isMaxUnknown = isMaxUnknown();
            if (!isMinUnknown) {
                boolean z9 = this.mReversedFlow;
                int i12 = this.mWindowAlignment;
                if (z9 ? (i12 & 2) == 0 : (i12 & 1) == 0) {
                    this.mMinScroll = calculateScrollToKeyLine(i10, calculateKeyline);
                } else {
                    this.mMinScroll = this.mMinEdge - this.mPaddingMin;
                }
            }
            if (!isMaxUnknown) {
                boolean z10 = this.mReversedFlow;
                int i13 = this.mWindowAlignment;
                if (z10 ? (i13 & 1) == 0 : (i13 & 2) == 0) {
                    this.mMaxScroll = calculateScrollToKeyLine(i11, calculateKeyline);
                } else {
                    this.mMaxScroll = (this.mMaxEdge - this.mPaddingMin) - clientSize;
                }
            }
            if (isMaxUnknown || isMinUnknown) {
                return;
            }
            boolean z11 = this.mReversedFlow;
            int i14 = this.mWindowAlignment;
            if (z11) {
                if ((i14 & 1) != 0) {
                    if (isPreferKeylineOverLowEdge()) {
                        this.mMaxScroll = Math.max(this.mMaxScroll, calculateScrollToKeyLine(i10, calculateKeyline));
                    }
                    this.mMinScroll = Math.min(this.mMinScroll, this.mMaxScroll);
                    return;
                } else {
                    if ((i14 & 2) != 0) {
                        if (isPreferKeylineOverHighEdge()) {
                            this.mMinScroll = Math.min(this.mMinScroll, calculateScrollToKeyLine(i11, calculateKeyline));
                        }
                        this.mMaxScroll = Math.max(this.mMinScroll, this.mMaxScroll);
                        return;
                    }
                    return;
                }
            }
            if ((i14 & 1) != 0) {
                if (isPreferKeylineOverLowEdge()) {
                    this.mMinScroll = Math.min(this.mMinScroll, calculateScrollToKeyLine(i11, calculateKeyline));
                }
                this.mMaxScroll = Math.max(this.mMinScroll, this.mMaxScroll);
            } else if ((i14 & 2) != 0) {
                if (isPreferKeylineOverHighEdge()) {
                    this.mMaxScroll = Math.max(this.mMaxScroll, calculateScrollToKeyLine(i10, calculateKeyline));
                }
                this.mMinScroll = Math.min(this.mMinScroll, this.mMaxScroll);
            }
        }
    }

    public WindowAlignment() {
        Axis axis = new Axis("vertical");
        this.vertical = axis;
        Axis axis2 = new Axis("horizontal");
        this.horizontal = axis2;
        this.mMainAxis = axis2;
        this.mSecondAxis = axis;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public Axis mainAxis() {
        return this.mMainAxis;
    }

    public void reset() {
        mainAxis().reset();
    }

    public Axis secondAxis() {
        return this.mSecondAxis;
    }

    public void setOrientation(int i) {
        this.mOrientation = i;
        if (i == 0) {
            this.mMainAxis = this.horizontal;
            this.mSecondAxis = this.vertical;
        } else {
            this.mMainAxis = this.vertical;
            this.mSecondAxis = this.horizontal;
        }
    }

    public String toString() {
        return "horizontal=" + this.horizontal + "; vertical=" + this.vertical;
    }
}
