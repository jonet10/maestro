package androidx.leanback.widget;

import s1.o;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public final class ItemAlignmentFacet {
    public static final float ITEM_ALIGN_OFFSET_PERCENT_DISABLED = -1.0f;
    private ItemAlignmentDef[] mAlignmentDefs = {new ItemAlignmentDef()};

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class ItemAlignmentDef {
        private boolean mAlignToBaseline;
        int mViewId = -1;
        int mFocusViewId = -1;
        int mOffset = 0;
        float mOffsetPercent = 50.0f;
        boolean mOffsetWithPadding = false;

        public final int getItemAlignmentFocusViewId() {
            int i = this.mFocusViewId;
            return i != -1 ? i : this.mViewId;
        }

        public final int getItemAlignmentOffset() {
            return this.mOffset;
        }

        public final float getItemAlignmentOffsetPercent() {
            return this.mOffsetPercent;
        }

        public final int getItemAlignmentViewId() {
            return this.mViewId;
        }

        public boolean isAlignedToTextViewBaseLine() {
            return this.mAlignToBaseline;
        }

        public final boolean isItemAlignmentOffsetWithPadding() {
            return this.mOffsetWithPadding;
        }

        public final void setAlignedToTextViewBaseline(boolean z9) {
            this.mAlignToBaseline = z9;
        }

        public final void setItemAlignmentFocusViewId(int i) {
            this.mFocusViewId = i;
        }

        public final void setItemAlignmentOffset(int i) {
            this.mOffset = i;
        }

        public final void setItemAlignmentOffsetPercent(float f) {
            if ((f < 0.0f || f > 100.0f) && f != -1.0f) {
                o.n();
            } else {
                this.mOffsetPercent = f;
            }
        }

        public final void setItemAlignmentOffsetWithPadding(boolean z9) {
            this.mOffsetWithPadding = z9;
        }

        public final void setItemAlignmentViewId(int i) {
            this.mViewId = i;
        }
    }

    public ItemAlignmentDef[] getAlignmentDefs() {
        return this.mAlignmentDefs;
    }

    public boolean isMultiAlignment() {
        return this.mAlignmentDefs.length > 1;
    }

    public void setAlignmentDefs(ItemAlignmentDef[] itemAlignmentDefArr) {
        if (itemAlignmentDefArr == null || itemAlignmentDefArr.length < 1) {
            o.n();
        } else {
            this.mAlignmentDefs = itemAlignmentDefArr;
        }
    }
}
