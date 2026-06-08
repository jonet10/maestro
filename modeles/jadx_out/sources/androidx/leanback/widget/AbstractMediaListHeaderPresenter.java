package androidx.leanback.widget;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.leanback.widget.RowPresenter;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes.dex */
public abstract class AbstractMediaListHeaderPresenter extends RowPresenter {
    private int mBackgroundColor;
    private boolean mBackgroundColorSet;
    private final Context mContext;

    /* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
    public static class ViewHolder extends RowPresenter.ViewHolder {
        private final TextView mHeaderView;

        public ViewHolder(View view) {
            super(view);
            this.mHeaderView = (TextView) view.findViewById(androidx.leanback.R.id.mediaListHeader);
        }

        public TextView getHeaderView() {
            return this.mHeaderView;
        }
    }

    public AbstractMediaListHeaderPresenter(Context context, int i) {
        this.mBackgroundColor = 0;
        this.mContext = new ContextThemeWrapper(context.getApplicationContext(), i);
        setHeaderPresenter(null);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        Context context = this.mContext;
        if (context == null) {
            context = viewGroup.getContext();
        }
        View inflate = LayoutInflater.from(context).inflate(androidx.leanback.R.layout.lb_media_list_header, viewGroup, false);
        inflate.setFocusable(false);
        inflate.setFocusableInTouchMode(false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        if (this.mBackgroundColorSet) {
            viewHolder.view.setBackgroundColor(this.mBackgroundColor);
        }
        return viewHolder;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public boolean isUsingDefaultSelectEffect() {
        return false;
    }

    public abstract void onBindMediaListHeaderViewHolder(ViewHolder viewHolder, Object obj);

    @Override // androidx.leanback.widget.RowPresenter
    public void onBindRowViewHolder(RowPresenter.ViewHolder viewHolder, Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        onBindMediaListHeaderViewHolder((ViewHolder) viewHolder, obj);
    }

    public void setBackgroundColor(int i) {
        this.mBackgroundColorSet = true;
        this.mBackgroundColor = i;
    }

    public AbstractMediaListHeaderPresenter() {
        this.mBackgroundColor = 0;
        this.mContext = null;
        setHeaderPresenter(null);
    }
}
