package androidx.appcompat.widget;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
class RtlSpacingHelper {
    public static final int UNDEFINED = Integer.MIN_VALUE;
    private int mLeft = 0;
    private int mRight = 0;
    private int mStart = Integer.MIN_VALUE;
    private int mEnd = Integer.MIN_VALUE;
    private int mExplicitLeft = 0;
    private int mExplicitRight = 0;
    private boolean mIsRtl = false;
    private boolean mIsRelative = false;

    public int getEnd() {
        return this.mIsRtl ? this.mLeft : this.mRight;
    }

    public int getLeft() {
        return this.mLeft;
    }

    public int getRight() {
        return this.mRight;
    }

    public int getStart() {
        return this.mIsRtl ? this.mRight : this.mLeft;
    }

    public void setAbsolute(int i, int i6) {
        this.mIsRelative = false;
        if (i != Integer.MIN_VALUE) {
            this.mExplicitLeft = i;
            this.mLeft = i;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.mExplicitRight = i6;
            this.mRight = i6;
        }
    }

    public void setDirection(boolean z9) {
        if (z9 == this.mIsRtl) {
            return;
        }
        this.mIsRtl = z9;
        if (!this.mIsRelative) {
            this.mLeft = this.mExplicitLeft;
            this.mRight = this.mExplicitRight;
            return;
        }
        if (z9) {
            int i = this.mEnd;
            if (i == Integer.MIN_VALUE) {
                i = this.mExplicitLeft;
            }
            this.mLeft = i;
            int i6 = this.mStart;
            if (i6 == Integer.MIN_VALUE) {
                i6 = this.mExplicitRight;
            }
            this.mRight = i6;
            return;
        }
        int i10 = this.mStart;
        if (i10 == Integer.MIN_VALUE) {
            i10 = this.mExplicitLeft;
        }
        this.mLeft = i10;
        int i11 = this.mEnd;
        if (i11 == Integer.MIN_VALUE) {
            i11 = this.mExplicitRight;
        }
        this.mRight = i11;
    }

    public void setRelative(int i, int i6) {
        this.mStart = i;
        this.mEnd = i6;
        this.mIsRelative = true;
        if (this.mIsRtl) {
            if (i6 != Integer.MIN_VALUE) {
                this.mLeft = i6;
            }
            if (i != Integer.MIN_VALUE) {
                this.mRight = i;
                return;
            }
            return;
        }
        if (i != Integer.MIN_VALUE) {
            this.mLeft = i;
        }
        if (i6 != Integer.MIN_VALUE) {
            this.mRight = i6;
        }
    }
}
