package androidx.leanback.widget;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.core.view.ViewCompat;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class ImageCardView extends BaseCardView {
    private static final String ALPHA = "alpha";
    public static final int CARD_TYPE_FLAG_CONTENT = 2;
    public static final int CARD_TYPE_FLAG_ICON_LEFT = 8;
    public static final int CARD_TYPE_FLAG_ICON_RIGHT = 4;
    public static final int CARD_TYPE_FLAG_IMAGE_ONLY = 0;
    public static final int CARD_TYPE_FLAG_TITLE = 1;
    private boolean mAttachedToWindow;
    private ImageView mBadgeImage;
    private TextView mContentView;
    ObjectAnimator mFadeInAnimator;
    private ImageView mImageView;
    private ViewGroup mInfoArea;
    private TextView mTitleView;

    @Deprecated
    public ImageCardView(Context context, int i) {
        this(new ContextThemeWrapper(context, i));
    }

    @SuppressLint({"CustomViewStyleable"})
    private void buildImageCardView(AttributeSet attributeSet, int i, int i6) {
        setFocusable(true);
        setFocusableInTouchMode(true);
        LayoutInflater from = LayoutInflater.from(getContext());
        from.inflate(androidx.leanback.R.layout.lb_image_card_view, this);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, androidx.leanback.R.styleable.lbImageCardView, i, i6);
        ViewCompat.saveAttributeDataForStyleable(this, getContext(), androidx.leanback.R.styleable.lbImageCardView, attributeSet, obtainStyledAttributes, i, i6);
        int i10 = obtainStyledAttributes.getInt(androidx.leanback.R.styleable.lbImageCardView_lbImageCardViewType, 0);
        boolean z9 = i10 == 0;
        boolean z10 = (i10 & 1) == 1;
        boolean z11 = (i10 & 2) == 2;
        boolean z12 = (i10 & 4) == 4;
        boolean z13 = !z12 && (i10 & 8) == 8;
        ImageView imageView = (ImageView) findViewById(androidx.leanback.R.id.main_image);
        this.mImageView = imageView;
        if (imageView.getDrawable() == null) {
            this.mImageView.setVisibility(4);
        }
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mImageView, "alpha", 1.0f);
        this.mFadeInAnimator = ofFloat;
        ofFloat.setDuration(this.mImageView.getResources().getInteger(android.R.integer.config_shortAnimTime));
        ViewGroup viewGroup = (ViewGroup) findViewById(androidx.leanback.R.id.info_field);
        this.mInfoArea = viewGroup;
        if (z9) {
            removeView(viewGroup);
            obtainStyledAttributes.recycle();
            return;
        }
        if (z10) {
            TextView textView = (TextView) from.inflate(androidx.leanback.R.layout.lb_image_card_view_themed_title, viewGroup, false);
            this.mTitleView = textView;
            this.mInfoArea.addView(textView);
        }
        if (z11) {
            TextView textView2 = (TextView) from.inflate(androidx.leanback.R.layout.lb_image_card_view_themed_content, this.mInfoArea, false);
            this.mContentView = textView2;
            this.mInfoArea.addView(textView2);
        }
        if (z12 || z13) {
            int i11 = androidx.leanback.R.layout.lb_image_card_view_themed_badge_right;
            if (z13) {
                i11 = androidx.leanback.R.layout.lb_image_card_view_themed_badge_left;
            }
            ImageView imageView2 = (ImageView) from.inflate(i11, this.mInfoArea, false);
            this.mBadgeImage = imageView2;
            this.mInfoArea.addView(imageView2);
        }
        if (z10 && !z11 && this.mBadgeImage != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTitleView.getLayoutParams();
            ImageView imageView3 = this.mBadgeImage;
            if (z13) {
                layoutParams.addRule(17, imageView3.getId());
            } else {
                layoutParams.addRule(16, imageView3.getId());
            }
            this.mTitleView.setLayoutParams(layoutParams);
        }
        if (z11) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.mContentView.getLayoutParams();
            if (!z10) {
                layoutParams2.addRule(10);
            }
            if (z13) {
                layoutParams2.removeRule(16);
                layoutParams2.removeRule(20);
                layoutParams2.addRule(17, this.mBadgeImage.getId());
            }
            this.mContentView.setLayoutParams(layoutParams2);
        }
        ImageView imageView4 = this.mBadgeImage;
        if (imageView4 != null) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) imageView4.getLayoutParams();
            if (z11) {
                layoutParams3.addRule(8, this.mContentView.getId());
            } else if (z10) {
                layoutParams3.addRule(8, this.mTitleView.getId());
            }
            this.mBadgeImage.setLayoutParams(layoutParams3);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(androidx.leanback.R.styleable.lbImageCardView_infoAreaBackground);
        if (drawable != null) {
            setInfoAreaBackground(drawable);
        }
        ImageView imageView5 = this.mBadgeImage;
        if (imageView5 != null && imageView5.getDrawable() == null) {
            this.mBadgeImage.setVisibility(8);
        }
        obtainStyledAttributes.recycle();
    }

    private void fadeIn() {
        this.mImageView.setAlpha(0.0f);
        if (this.mAttachedToWindow) {
            this.mFadeInAnimator.start();
        }
    }

    public Drawable getBadgeImage() {
        ImageView imageView = this.mBadgeImage;
        if (imageView == null) {
            return null;
        }
        return imageView.getDrawable();
    }

    public CharSequence getContentText() {
        TextView textView = this.mContentView;
        if (textView == null) {
            return null;
        }
        return textView.getText();
    }

    public Drawable getInfoAreaBackground() {
        ViewGroup viewGroup = this.mInfoArea;
        if (viewGroup != null) {
            return viewGroup.getBackground();
        }
        return null;
    }

    public Drawable getMainImage() {
        ImageView imageView = this.mImageView;
        if (imageView == null) {
            return null;
        }
        return imageView.getDrawable();
    }

    public final ImageView getMainImageView() {
        return this.mImageView;
    }

    public CharSequence getTitleText() {
        TextView textView = this.mTitleView;
        if (textView == null) {
            return null;
        }
        return textView.getText();
    }

    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mAttachedToWindow = true;
        if (this.mImageView.getAlpha() == 0.0f) {
            fadeIn();
        }
    }

    @Override // androidx.leanback.widget.BaseCardView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.mAttachedToWindow = false;
        this.mFadeInAnimator.cancel();
        this.mImageView.setAlpha(1.0f);
        super.onDetachedFromWindow();
    }

    public void setBadgeImage(Drawable drawable) {
        ImageView imageView = this.mBadgeImage;
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
        ImageView imageView2 = this.mBadgeImage;
        if (drawable != null) {
            imageView2.setVisibility(0);
        } else {
            imageView2.setVisibility(8);
        }
    }

    public void setContentText(CharSequence charSequence) {
        TextView textView = this.mContentView;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    public void setInfoAreaBackground(Drawable drawable) {
        ViewGroup viewGroup = this.mInfoArea;
        if (viewGroup != null) {
            viewGroup.setBackground(drawable);
        }
    }

    public void setInfoAreaBackgroundColor(@ColorInt int i) {
        ViewGroup viewGroup = this.mInfoArea;
        if (viewGroup != null) {
            viewGroup.setBackgroundColor(i);
        }
    }

    public void setMainImage(Drawable drawable, boolean z9) {
        ImageView imageView = this.mImageView;
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            this.mFadeInAnimator.cancel();
            this.mImageView.setAlpha(1.0f);
            this.mImageView.setVisibility(4);
        } else {
            this.mImageView.setVisibility(0);
            if (z9) {
                fadeIn();
            } else {
                this.mFadeInAnimator.cancel();
                this.mImageView.setAlpha(1.0f);
            }
        }
    }

    public void setMainImageAdjustViewBounds(boolean z9) {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setAdjustViewBounds(z9);
        }
    }

    public void setMainImageDimensions(int i, int i6) {
        ViewGroup.LayoutParams layoutParams = this.mImageView.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i6;
        this.mImageView.setLayoutParams(layoutParams);
    }

    public void setMainImageScaleType(ImageView.ScaleType scaleType) {
        ImageView imageView = this.mImageView;
        if (imageView != null) {
            imageView.setScaleType(scaleType);
        }
    }

    public void setTitleText(CharSequence charSequence) {
        TextView textView = this.mTitleView;
        if (textView == null) {
            return;
        }
        textView.setText(charSequence);
    }

    public ImageCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        buildImageCardView(attributeSet, i, androidx.leanback.R.style.Widget_Leanback_ImageCardView);
    }

    public ImageCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ImageCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, androidx.leanback.R.attr.imageCardViewStyle);
    }

    public void setMainImage(Drawable drawable) {
        setMainImage(drawable, true);
    }
}
