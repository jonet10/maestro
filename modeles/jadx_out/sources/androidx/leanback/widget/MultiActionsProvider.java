package androidx.leanback.widget;

import android.graphics.drawable.Drawable;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public interface MultiActionsProvider {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class MultiAction {
        private Drawable[] mDrawables;
        private long mId;
        private int mIndex = 0;

        public MultiAction(long j) {
            this.mId = j;
        }

        public Drawable getCurrentDrawable() {
            return this.mDrawables[this.mIndex];
        }

        public Drawable[] getDrawables() {
            return this.mDrawables;
        }

        public long getId() {
            return this.mId;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public void incrementIndex() {
            int i = this.mIndex;
            setIndex(i < this.mDrawables.length + (-1) ? i + 1 : 0);
        }

        public void setDrawables(Drawable[] drawableArr) {
            this.mDrawables = drawableArr;
            if (this.mIndex > drawableArr.length - 1) {
                this.mIndex = drawableArr.length - 1;
            }
        }

        public void setIndex(int i) {
            this.mIndex = i;
        }
    }

    MultiAction[] getActions();
}
