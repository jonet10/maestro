package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.RestrictTo;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ThumbsBar extends LinearLayout {
    final SparseArray<Bitmap> mBitmaps;
    int mHeroThumbHeightInPixel;
    int mHeroThumbWidthInPixel;
    private boolean mIsUserSets;
    int mMeasuredMarginInPixel;
    int mNumOfThumbs;
    int mThumbHeightInPixel;
    int mThumbWidthInPixel;

    public ThumbsBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mNumOfThumbs = -1;
        this.mBitmaps = new SparseArray<>();
        this.mIsUserSets = false;
        this.mThumbWidthInPixel = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_thumbs_width);
        this.mThumbHeightInPixel = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_thumbs_height);
        this.mHeroThumbHeightInPixel = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_hero_thumbs_width);
        this.mHeroThumbWidthInPixel = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_hero_thumbs_height);
        this.mMeasuredMarginInPixel = context.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_playback_transport_thumbs_margin);
    }

    private int calculateNumOfThumbs(int i) {
        int roundUp = roundUp(i - this.mHeroThumbWidthInPixel, this.mThumbWidthInPixel + this.mMeasuredMarginInPixel);
        if (roundUp < 2) {
            roundUp = 2;
        } else if ((roundUp & 1) != 0) {
            roundUp++;
        }
        return roundUp + 1;
    }

    private static int roundUp(int i, int i6) {
        return ((i + i6) - 1) / i6;
    }

    private void setNumberOfThumbsInternal() {
        while (getChildCount() > this.mNumOfThumbs) {
            removeView(getChildAt(getChildCount() - 1));
        }
        while (getChildCount() < this.mNumOfThumbs) {
            addView(createThumbView(this), new LinearLayout.LayoutParams(this.mThumbWidthInPixel, this.mThumbHeightInPixel));
        }
        int heroIndex = getHeroIndex();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (heroIndex == i) {
                layoutParams.width = this.mHeroThumbWidthInPixel;
                layoutParams.height = this.mHeroThumbHeightInPixel;
            } else {
                layoutParams.width = this.mThumbWidthInPixel;
                layoutParams.height = this.mThumbHeightInPixel;
            }
            childAt.setLayoutParams(layoutParams);
        }
    }

    public void clearThumbBitmaps() {
        for (int i = 0; i < getChildCount(); i++) {
            setThumbBitmap(i, null);
        }
        this.mBitmaps.clear();
    }

    public View createThumbView(ViewGroup viewGroup) {
        return new ImageView(viewGroup.getContext());
    }

    public int getHeroIndex() {
        return getChildCount() / 2;
    }

    public Bitmap getThumbBitmap(int i) {
        return this.mBitmaps.get(i);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z9, int i, int i6, int i10, int i11) {
        super.onLayout(z9, i, i6, i10, i11);
        int heroIndex = getHeroIndex();
        View childAt = getChildAt(heroIndex);
        int width = (getWidth() / 2) - (childAt.getMeasuredWidth() / 2);
        int measuredWidth = (childAt.getMeasuredWidth() / 2) + (getWidth() / 2);
        childAt.layout(width, getPaddingTop(), measuredWidth, childAt.getMeasuredHeight() + getPaddingTop());
        int measuredHeight = (childAt.getMeasuredHeight() / 2) + getPaddingTop();
        for (int i12 = heroIndex - 1; i12 >= 0; i12--) {
            int i13 = width - this.mMeasuredMarginInPixel;
            View childAt2 = getChildAt(i12);
            childAt2.layout(i13 - childAt2.getMeasuredWidth(), measuredHeight - (childAt2.getMeasuredHeight() / 2), i13, (childAt2.getMeasuredHeight() / 2) + measuredHeight);
            width = i13 - childAt2.getMeasuredWidth();
        }
        while (true) {
            heroIndex++;
            if (heroIndex >= this.mNumOfThumbs) {
                return;
            }
            int i14 = measuredWidth + this.mMeasuredMarginInPixel;
            View childAt3 = getChildAt(heroIndex);
            childAt3.layout(i14, measuredHeight - (childAt3.getMeasuredHeight() / 2), childAt3.getMeasuredWidth() + i14, (childAt3.getMeasuredHeight() / 2) + measuredHeight);
            measuredWidth = i14 + childAt3.getMeasuredWidth();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i6) {
        int calculateNumOfThumbs;
        super.onMeasure(i, i6);
        int measuredWidth = getMeasuredWidth();
        if (this.mIsUserSets || this.mNumOfThumbs == (calculateNumOfThumbs = calculateNumOfThumbs(measuredWidth))) {
            return;
        }
        this.mNumOfThumbs = calculateNumOfThumbs;
        setNumberOfThumbsInternal();
    }

    public void setHeroThumbSize(int i, int i6) {
        boolean z9;
        this.mHeroThumbHeightInPixel = i6;
        this.mHeroThumbWidthInPixel = i;
        int heroIndex = getHeroIndex();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if (heroIndex == i10) {
                View childAt = getChildAt(i10);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                boolean z10 = true;
                if (layoutParams.height != i6) {
                    layoutParams.height = i6;
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                } else {
                    z10 = z9;
                }
                if (z10) {
                    childAt.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void setNumberOfThumbs(int i) {
        this.mIsUserSets = true;
        this.mNumOfThumbs = i;
        setNumberOfThumbsInternal();
    }

    public void setThumbBitmap(int i, Bitmap bitmap) {
        this.mBitmaps.put(i, bitmap);
        ((ImageView) getChildAt(i)).setImageBitmap(bitmap);
    }

    public void setThumbSize(int i, int i6) {
        boolean z9;
        this.mThumbHeightInPixel = i6;
        this.mThumbWidthInPixel = i;
        int heroIndex = getHeroIndex();
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if (heroIndex != i10) {
                View childAt = getChildAt(i10);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
                boolean z10 = true;
                if (layoutParams.height != i6) {
                    layoutParams.height = i6;
                    z9 = true;
                } else {
                    z9 = false;
                }
                if (layoutParams.width != i) {
                    layoutParams.width = i;
                } else {
                    z10 = z9;
                }
                if (z10) {
                    childAt.setLayoutParams(layoutParams);
                }
            }
        }
    }

    public void setThumbSpace(int i) {
        this.mMeasuredMarginInPixel = i;
        requestLayout();
    }

    public ThumbsBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
