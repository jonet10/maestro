package androidx.constraintlayout.widget;

import a3.b;
import a4.x;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.gson.internal.a;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ConstraintProperties {
    public static final int BASELINE = 5;
    public static final int BOTTOM = 4;
    public static final int END = 7;
    public static final int LEFT = 1;
    public static final int MATCH_CONSTRAINT = 0;
    public static final int MATCH_CONSTRAINT_SPREAD = 0;
    public static final int MATCH_CONSTRAINT_WRAP = 1;
    public static final int PARENT_ID = 0;
    public static final int RIGHT = 2;
    public static final int START = 6;
    public static final int TOP = 3;
    public static final int UNSET = -1;
    public static final int WRAP_CONTENT = -2;
    ConstraintLayout.LayoutParams mParams;
    View mView;

    public ConstraintProperties(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof ConstraintLayout.LayoutParams)) {
            b.n("Only children of ConstraintLayout.LayoutParams supported");
            throw null;
        }
        this.mParams = (ConstraintLayout.LayoutParams) layoutParams;
        this.mView = view;
    }

    private String sideToString(int i) {
        switch (i) {
            case 1:
                return "left";
            case 2:
                return "right";
            case 3:
                return "top";
            case 4:
                return "bottom";
            case 5:
                return "baseline";
            case 6:
                return "start";
            case 7:
                return "end";
            default:
                return "undefined";
        }
    }

    public ConstraintProperties addToHorizontalChain(int i, int i6) {
        connect(1, i, i == 0 ? 1 : 2, 0);
        connect(2, i6, i6 == 0 ? 2 : 1, 0);
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i)).connect(2, this.mView.getId(), 1, 0);
        }
        if (i6 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i6)).connect(1, this.mView.getId(), 2, 0);
        }
        return this;
    }

    public ConstraintProperties addToHorizontalChainRTL(int i, int i6) {
        connect(6, i, i == 0 ? 6 : 7, 0);
        connect(7, i6, i6 == 0 ? 7 : 6, 0);
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i)).connect(7, this.mView.getId(), 6, 0);
        }
        if (i6 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i6)).connect(6, this.mView.getId(), 7, 0);
        }
        return this;
    }

    public ConstraintProperties addToVerticalChain(int i, int i6) {
        connect(3, i, i == 0 ? 3 : 4, 0);
        connect(4, i6, i6 == 0 ? 4 : 3, 0);
        if (i != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i)).connect(4, this.mView.getId(), 3, 0);
        }
        if (i6 != 0) {
            new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i6)).connect(3, this.mView.getId(), 4, 0);
        }
        return this;
    }

    public ConstraintProperties alpha(float f) {
        this.mView.setAlpha(f);
        return this;
    }

    public ConstraintProperties center(int i, int i6, int i10, int i11, int i12, int i13, float f) {
        if (i10 < 0) {
            a.p("margin must be > 0");
            return null;
        }
        if (i13 < 0) {
            a.p("margin must be > 0");
            return null;
        }
        if (f <= 0.0f || f > 1.0f) {
            a.p("bias must be between 0 and 1 inclusive");
            return null;
        }
        if (i6 == 1 || i6 == 2) {
            connect(1, i, i6, i10);
            connect(2, i11, i12, i13);
            this.mParams.horizontalBias = f;
            return this;
        }
        if (i6 == 6 || i6 == 7) {
            connect(6, i, i6, i10);
            connect(7, i11, i12, i13);
            this.mParams.horizontalBias = f;
            return this;
        }
        connect(3, i, i6, i10);
        connect(4, i11, i12, i13);
        this.mParams.verticalBias = f;
        return this;
    }

    public ConstraintProperties centerHorizontally(int i) {
        if (i == 0) {
            center(0, 1, 0, 0, 2, 0, 0.5f);
            return this;
        }
        center(i, 2, 0, i, 1, 0, 0.5f);
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i) {
        if (i == 0) {
            center(0, 6, 0, 0, 7, 0, 0.5f);
            return this;
        }
        center(i, 7, 0, i, 6, 0, 0.5f);
        return this;
    }

    public ConstraintProperties centerVertically(int i) {
        if (i == 0) {
            center(0, 3, 0, 0, 4, 0, 0.5f);
            return this;
        }
        center(i, 4, 0, i, 3, 0, 0.5f);
        return this;
    }

    public ConstraintProperties connect(int i, int i6, int i10, int i11) {
        switch (i) {
            case 1:
                if (i10 == 1) {
                    ConstraintLayout.LayoutParams layoutParams = this.mParams;
                    layoutParams.leftToLeft = i6;
                    layoutParams.leftToRight = -1;
                } else {
                    if (i10 != 2) {
                        a.p(x.n(new StringBuilder("Left to "), sideToString(i10), " undefined"));
                        return null;
                    }
                    ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                    layoutParams2.leftToRight = i6;
                    layoutParams2.leftToLeft = -1;
                }
                ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = i11;
                return this;
            case 2:
                if (i10 == 1) {
                    ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                    layoutParams3.rightToLeft = i6;
                    layoutParams3.rightToRight = -1;
                } else {
                    if (i10 != 2) {
                        a.p(x.n(new StringBuilder("right to "), sideToString(i10), " undefined"));
                        return null;
                    }
                    ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                    layoutParams4.rightToRight = i6;
                    layoutParams4.rightToLeft = -1;
                }
                ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = i11;
                return this;
            case 3:
                if (i10 == 3) {
                    ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                    layoutParams5.topToTop = i6;
                    layoutParams5.topToBottom = -1;
                    layoutParams5.baselineToBaseline = -1;
                    layoutParams5.baselineToTop = -1;
                    layoutParams5.baselineToBottom = -1;
                } else {
                    if (i10 != 4) {
                        a.p(x.n(new StringBuilder("right to "), sideToString(i10), " undefined"));
                        return null;
                    }
                    ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                    layoutParams6.topToBottom = i6;
                    layoutParams6.topToTop = -1;
                    layoutParams6.baselineToBaseline = -1;
                    layoutParams6.baselineToTop = -1;
                    layoutParams6.baselineToBottom = -1;
                }
                ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = i11;
                return this;
            case 4:
                if (i10 == 4) {
                    ConstraintLayout.LayoutParams layoutParams7 = this.mParams;
                    layoutParams7.bottomToBottom = i6;
                    layoutParams7.bottomToTop = -1;
                    layoutParams7.baselineToBaseline = -1;
                    layoutParams7.baselineToTop = -1;
                    layoutParams7.baselineToBottom = -1;
                } else {
                    if (i10 != 3) {
                        a.p(x.n(new StringBuilder("right to "), sideToString(i10), " undefined"));
                        return null;
                    }
                    ConstraintLayout.LayoutParams layoutParams8 = this.mParams;
                    layoutParams8.bottomToTop = i6;
                    layoutParams8.bottomToBottom = -1;
                    layoutParams8.baselineToBaseline = -1;
                    layoutParams8.baselineToTop = -1;
                    layoutParams8.baselineToBottom = -1;
                }
                ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = i11;
                return this;
            case 5:
                if (i10 == 5) {
                    ConstraintLayout.LayoutParams layoutParams9 = this.mParams;
                    layoutParams9.baselineToBaseline = i6;
                    layoutParams9.bottomToBottom = -1;
                    layoutParams9.bottomToTop = -1;
                    layoutParams9.topToTop = -1;
                    layoutParams9.topToBottom = -1;
                } else if (i10 == 3) {
                    ConstraintLayout.LayoutParams layoutParams10 = this.mParams;
                    layoutParams10.baselineToTop = i6;
                    layoutParams10.bottomToBottom = -1;
                    layoutParams10.bottomToTop = -1;
                    layoutParams10.topToTop = -1;
                    layoutParams10.topToBottom = -1;
                } else {
                    if (i10 != 4) {
                        a.p(x.n(new StringBuilder("right to "), sideToString(i10), " undefined"));
                        return null;
                    }
                    ConstraintLayout.LayoutParams layoutParams11 = this.mParams;
                    layoutParams11.baselineToBottom = i6;
                    layoutParams11.bottomToBottom = -1;
                    layoutParams11.bottomToTop = -1;
                    layoutParams11.topToTop = -1;
                    layoutParams11.topToBottom = -1;
                }
                this.mParams.baselineMargin = i11;
                return this;
            case 6:
                if (i10 == 6) {
                    ConstraintLayout.LayoutParams layoutParams12 = this.mParams;
                    layoutParams12.startToStart = i6;
                    layoutParams12.startToEnd = -1;
                } else {
                    if (i10 != 7) {
                        a.p(x.n(new StringBuilder("right to "), sideToString(i10), " undefined"));
                        return null;
                    }
                    ConstraintLayout.LayoutParams layoutParams13 = this.mParams;
                    layoutParams13.startToEnd = i6;
                    layoutParams13.startToStart = -1;
                }
                this.mParams.setMarginStart(i11);
                return this;
            case 7:
                if (i10 == 7) {
                    ConstraintLayout.LayoutParams layoutParams14 = this.mParams;
                    layoutParams14.endToEnd = i6;
                    layoutParams14.endToStart = -1;
                } else {
                    if (i10 != 6) {
                        a.p(x.n(new StringBuilder("right to "), sideToString(i10), " undefined"));
                        return null;
                    }
                    ConstraintLayout.LayoutParams layoutParams15 = this.mParams;
                    layoutParams15.endToStart = i6;
                    layoutParams15.endToEnd = -1;
                }
                this.mParams.setMarginEnd(i11);
                return this;
            default:
                StringBuilder sb = new StringBuilder();
                sb.append(sideToString(i));
                sb.append(" to ");
                a.p(x.n(sb, sideToString(i10), " unknown"));
                return null;
        }
    }

    public ConstraintProperties constrainDefaultHeight(int i) {
        this.mParams.matchConstraintDefaultHeight = i;
        return this;
    }

    public ConstraintProperties constrainDefaultWidth(int i) {
        this.mParams.matchConstraintDefaultWidth = i;
        return this;
    }

    public ConstraintProperties constrainHeight(int i) {
        ((ViewGroup.MarginLayoutParams) this.mParams).height = i;
        return this;
    }

    public ConstraintProperties constrainMaxHeight(int i) {
        this.mParams.matchConstraintMaxHeight = i;
        return this;
    }

    public ConstraintProperties constrainMaxWidth(int i) {
        this.mParams.matchConstraintMaxWidth = i;
        return this;
    }

    public ConstraintProperties constrainMinHeight(int i) {
        this.mParams.matchConstraintMinHeight = i;
        return this;
    }

    public ConstraintProperties constrainMinWidth(int i) {
        this.mParams.matchConstraintMinWidth = i;
        return this;
    }

    public ConstraintProperties constrainWidth(int i) {
        ((ViewGroup.MarginLayoutParams) this.mParams).width = i;
        return this;
    }

    public ConstraintProperties dimensionRatio(String str) {
        this.mParams.dimensionRatio = str;
        return this;
    }

    public ConstraintProperties elevation(float f) {
        this.mView.setElevation(f);
        return this;
    }

    public ConstraintProperties goneMargin(int i, int i6) {
        switch (i) {
            case 1:
                this.mParams.goneLeftMargin = i6;
                return this;
            case 2:
                this.mParams.goneRightMargin = i6;
                return this;
            case 3:
                this.mParams.goneTopMargin = i6;
                return this;
            case 4:
                this.mParams.goneBottomMargin = i6;
                return this;
            case 5:
                a.p("baseline does not support margins");
                return null;
            case 6:
                this.mParams.goneStartMargin = i6;
                return this;
            case 7:
                this.mParams.goneEndMargin = i6;
                return this;
            default:
                a.p("unknown constraint");
                return null;
        }
    }

    public ConstraintProperties horizontalBias(float f) {
        this.mParams.horizontalBias = f;
        return this;
    }

    public ConstraintProperties horizontalChainStyle(int i) {
        this.mParams.horizontalChainStyle = i;
        return this;
    }

    public ConstraintProperties horizontalWeight(float f) {
        this.mParams.horizontalWeight = f;
        return this;
    }

    public ConstraintProperties margin(int i, int i6) {
        switch (i) {
            case 1:
                ((ViewGroup.MarginLayoutParams) this.mParams).leftMargin = i6;
                return this;
            case 2:
                ((ViewGroup.MarginLayoutParams) this.mParams).rightMargin = i6;
                return this;
            case 3:
                ((ViewGroup.MarginLayoutParams) this.mParams).topMargin = i6;
                return this;
            case 4:
                ((ViewGroup.MarginLayoutParams) this.mParams).bottomMargin = i6;
                return this;
            case 5:
                a.p("baseline does not support margins");
                return null;
            case 6:
                this.mParams.setMarginStart(i6);
                return this;
            case 7:
                this.mParams.setMarginEnd(i6);
                return this;
            default:
                a.p("unknown constraint");
                return null;
        }
    }

    public ConstraintProperties removeConstraints(int i) {
        switch (i) {
            case 1:
                ConstraintLayout.LayoutParams layoutParams = this.mParams;
                layoutParams.leftToRight = -1;
                layoutParams.leftToLeft = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = -1;
                layoutParams.goneLeftMargin = Integer.MIN_VALUE;
                return this;
            case 2:
                ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
                layoutParams2.rightToRight = -1;
                layoutParams2.rightToLeft = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = -1;
                layoutParams2.goneRightMargin = Integer.MIN_VALUE;
                return this;
            case 3:
                ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
                layoutParams3.topToBottom = -1;
                layoutParams3.topToTop = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams3).topMargin = -1;
                layoutParams3.goneTopMargin = Integer.MIN_VALUE;
                return this;
            case 4:
                ConstraintLayout.LayoutParams layoutParams4 = this.mParams;
                layoutParams4.bottomToTop = -1;
                layoutParams4.bottomToBottom = -1;
                ((ViewGroup.MarginLayoutParams) layoutParams4).bottomMargin = -1;
                layoutParams4.goneBottomMargin = Integer.MIN_VALUE;
                return this;
            case 5:
                this.mParams.baselineToBaseline = -1;
                return this;
            case 6:
                ConstraintLayout.LayoutParams layoutParams5 = this.mParams;
                layoutParams5.startToEnd = -1;
                layoutParams5.startToStart = -1;
                layoutParams5.setMarginStart(-1);
                this.mParams.goneStartMargin = Integer.MIN_VALUE;
                return this;
            case 7:
                ConstraintLayout.LayoutParams layoutParams6 = this.mParams;
                layoutParams6.endToStart = -1;
                layoutParams6.endToEnd = -1;
                layoutParams6.setMarginEnd(-1);
                this.mParams.goneEndMargin = Integer.MIN_VALUE;
                return this;
            default:
                a.p("unknown constraint");
                return null;
        }
    }

    public ConstraintProperties removeFromHorizontalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.mParams;
        int i = layoutParams.leftToRight;
        int i6 = layoutParams.rightToLeft;
        if (i != -1 || i6 != -1) {
            ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i));
            ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i6));
            ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
            if (i != -1 && i6 != -1) {
                constraintProperties.connect(2, i6, 1, 0);
                constraintProperties2.connect(1, i, 2, 0);
            } else if (i != -1 || i6 != -1) {
                int i10 = layoutParams2.rightToRight;
                if (i10 != -1) {
                    constraintProperties.connect(2, i10, 2, 0);
                } else {
                    int i11 = layoutParams2.leftToLeft;
                    if (i11 != -1) {
                        constraintProperties2.connect(1, i11, 1, 0);
                    }
                }
            }
            removeConstraints(1);
            removeConstraints(2);
            return this;
        }
        int i12 = layoutParams.startToEnd;
        int i13 = layoutParams.endToStart;
        if (i12 != -1 || i13 != -1) {
            ConstraintProperties constraintProperties3 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i12));
            ConstraintProperties constraintProperties4 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i13));
            ConstraintLayout.LayoutParams layoutParams3 = this.mParams;
            if (i12 != -1 && i13 != -1) {
                constraintProperties3.connect(7, i13, 6, 0);
                constraintProperties4.connect(6, i, 7, 0);
            } else if (i != -1 || i13 != -1) {
                int i14 = layoutParams3.rightToRight;
                if (i14 != -1) {
                    constraintProperties3.connect(7, i14, 7, 0);
                } else {
                    int i15 = layoutParams3.leftToLeft;
                    if (i15 != -1) {
                        constraintProperties4.connect(6, i15, 6, 0);
                    }
                }
            }
        }
        removeConstraints(6);
        removeConstraints(7);
        return this;
    }

    public ConstraintProperties removeFromVerticalChain() {
        ConstraintLayout.LayoutParams layoutParams = this.mParams;
        int i = layoutParams.topToBottom;
        int i6 = layoutParams.bottomToTop;
        if (i != -1 || i6 != -1) {
            ConstraintProperties constraintProperties = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i));
            ConstraintProperties constraintProperties2 = new ConstraintProperties(((ViewGroup) this.mView.getParent()).findViewById(i6));
            ConstraintLayout.LayoutParams layoutParams2 = this.mParams;
            if (i != -1 && i6 != -1) {
                constraintProperties.connect(4, i6, 3, 0);
                constraintProperties2.connect(3, i, 4, 0);
            } else if (i != -1 || i6 != -1) {
                int i10 = layoutParams2.bottomToBottom;
                if (i10 != -1) {
                    constraintProperties.connect(4, i10, 4, 0);
                } else {
                    int i11 = layoutParams2.topToTop;
                    if (i11 != -1) {
                        constraintProperties2.connect(3, i11, 3, 0);
                    }
                }
            }
        }
        removeConstraints(3);
        removeConstraints(4);
        return this;
    }

    public ConstraintProperties rotation(float f) {
        this.mView.setRotation(f);
        return this;
    }

    public ConstraintProperties rotationX(float f) {
        this.mView.setRotationX(f);
        return this;
    }

    public ConstraintProperties rotationY(float f) {
        this.mView.setRotationY(f);
        return this;
    }

    public ConstraintProperties scaleX(float f) {
        this.mView.setScaleY(f);
        return this;
    }

    public ConstraintProperties transformPivot(float f, float f10) {
        this.mView.setPivotX(f);
        this.mView.setPivotY(f10);
        return this;
    }

    public ConstraintProperties transformPivotX(float f) {
        this.mView.setPivotX(f);
        return this;
    }

    public ConstraintProperties transformPivotY(float f) {
        this.mView.setPivotY(f);
        return this;
    }

    public ConstraintProperties translation(float f, float f10) {
        this.mView.setTranslationX(f);
        this.mView.setTranslationY(f10);
        return this;
    }

    public ConstraintProperties translationX(float f) {
        this.mView.setTranslationX(f);
        return this;
    }

    public ConstraintProperties translationY(float f) {
        this.mView.setTranslationY(f);
        return this;
    }

    public ConstraintProperties translationZ(float f) {
        this.mView.setTranslationZ(f);
        return this;
    }

    public ConstraintProperties verticalBias(float f) {
        this.mParams.verticalBias = f;
        return this;
    }

    public ConstraintProperties verticalChainStyle(int i) {
        this.mParams.verticalChainStyle = i;
        return this;
    }

    public ConstraintProperties verticalWeight(float f) {
        this.mParams.verticalWeight = f;
        return this;
    }

    public ConstraintProperties visibility(int i) {
        this.mView.setVisibility(i);
        return this;
    }

    public void apply() {
    }

    public ConstraintProperties scaleY(float f) {
        return this;
    }

    public ConstraintProperties centerHorizontally(int i, int i6, int i10, int i11, int i12, int i13, float f) {
        connect(1, i, i6, i10);
        connect(2, i11, i12, i13);
        this.mParams.horizontalBias = f;
        return this;
    }

    public ConstraintProperties centerHorizontallyRtl(int i, int i6, int i10, int i11, int i12, int i13, float f) {
        connect(6, i, i6, i10);
        connect(7, i11, i12, i13);
        this.mParams.horizontalBias = f;
        return this;
    }

    public ConstraintProperties centerVertically(int i, int i6, int i10, int i11, int i12, int i13, float f) {
        connect(3, i, i6, i10);
        connect(4, i11, i12, i13);
        this.mParams.verticalBias = f;
        return this;
    }
}
