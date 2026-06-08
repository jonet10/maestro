package e5;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.leanback.R;
import androidx.leanback.widget.DetailsOverviewLogoPresenter;
import androidx.leanback.widget.DetailsOverviewRow;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.Presenter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class d extends DetailsOverviewLogoPresenter {
    @Override // androidx.leanback.widget.DetailsOverviewLogoPresenter, androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        FullWidthDetailsOverviewRowPresenter parentPresenter;
        viewHolder.getClass();
        if (obj == null) {
            return;
        }
        DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) obj;
        View view = viewHolder.view;
        view.getClass();
        ((ImageView) view).setImageDrawable(detailsOverviewRow.getImageDrawable());
        c cVar = (c) viewHolder;
        if (!isBoundToImage(cVar, detailsOverviewRow) || (parentPresenter = cVar.getParentPresenter()) == null) {
            return;
        }
        parentPresenter.notifyOnBindLogo(cVar.getParentViewHolder());
    }

    @Override // androidx.leanback.widget.DetailsOverviewLogoPresenter, androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        viewGroup.getClass();
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.lb_fullwidth_details_overview_logo, viewGroup, false);
        inflate.getClass();
        ImageView imageView = (ImageView) inflate;
        Resources resources = viewGroup.getResources();
        imageView.setLayoutParams(new ViewGroup.MarginLayoutParams(resources.getDimensionPixelSize(2131166559), resources.getDimensionPixelSize(2131166558)));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new c(imageView);
    }
}
