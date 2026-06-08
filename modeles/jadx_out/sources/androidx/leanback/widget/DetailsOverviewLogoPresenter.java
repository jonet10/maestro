package androidx.leanback.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.Presenter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public class DetailsOverviewLogoPresenter extends Presenter {

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class ViewHolder extends Presenter.ViewHolder {
        protected FullWidthDetailsOverviewRowPresenter mParentPresenter;
        protected FullWidthDetailsOverviewRowPresenter.ViewHolder mParentViewHolder;
        private boolean mSizeFromDrawableIntrinsic;

        public ViewHolder(View view) {
            super(view);
        }

        public FullWidthDetailsOverviewRowPresenter getParentPresenter() {
            return this.mParentPresenter;
        }

        public FullWidthDetailsOverviewRowPresenter.ViewHolder getParentViewHolder() {
            return this.mParentViewHolder;
        }

        public boolean isSizeFromDrawableIntrinsic() {
            return this.mSizeFromDrawableIntrinsic;
        }

        public void setSizeFromDrawableIntrinsic(boolean z9) {
            this.mSizeFromDrawableIntrinsic = z9;
        }
    }

    public boolean isBoundToImage(ViewHolder viewHolder, DetailsOverviewRow detailsOverviewRow) {
        return (detailsOverviewRow == null || detailsOverviewRow.getImageDrawable() == null) ? false : true;
    }

    @Override // androidx.leanback.widget.Presenter
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) obj;
        ImageView imageView = (ImageView) viewHolder.view;
        imageView.setImageDrawable(detailsOverviewRow.getImageDrawable());
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (isBoundToImage(viewHolder2, detailsOverviewRow)) {
            if (viewHolder2.isSizeFromDrawableIntrinsic()) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.width = detailsOverviewRow.getImageDrawable().getIntrinsicWidth();
                layoutParams.height = detailsOverviewRow.getImageDrawable().getIntrinsicHeight();
                if (imageView.getMaxWidth() > 0 || imageView.getMaxHeight() > 0) {
                    float f = 1.0f;
                    float maxWidth = (imageView.getMaxWidth() <= 0 || layoutParams.width <= imageView.getMaxWidth()) ? 1.0f : imageView.getMaxWidth() / layoutParams.width;
                    if (imageView.getMaxHeight() > 0 && layoutParams.height > imageView.getMaxHeight()) {
                        f = imageView.getMaxHeight() / layoutParams.height;
                    }
                    float min = Math.min(maxWidth, f);
                    layoutParams.width = (int) (layoutParams.width * min);
                    layoutParams.height = (int) (layoutParams.height * min);
                }
                imageView.setLayoutParams(layoutParams);
            }
            viewHolder2.mParentPresenter.notifyOnBindLogo(viewHolder2.mParentViewHolder);
        }
    }

    public View onCreateView(ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_fullwidth_details_overview_logo, viewGroup, false);
    }

    @Override // androidx.leanback.widget.Presenter
    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View onCreateView = onCreateView(viewGroup);
        ViewHolder viewHolder = new ViewHolder(onCreateView);
        ViewGroup.LayoutParams layoutParams = onCreateView.getLayoutParams();
        viewHolder.setSizeFromDrawableIntrinsic(layoutParams.width == -2 && layoutParams.height == -2);
        return viewHolder;
    }

    public void setContext(ViewHolder viewHolder, FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder2, FullWidthDetailsOverviewRowPresenter fullWidthDetailsOverviewRowPresenter) {
        viewHolder.mParentViewHolder = viewHolder2;
        viewHolder.mParentPresenter = fullWidthDetailsOverviewRowPresenter;
    }

    @Override // androidx.leanback.widget.Presenter
    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
    }
}
