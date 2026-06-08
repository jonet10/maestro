package e5;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.R;
import androidx.leanback.widget.ImageCardView;
import androidx.leanback.widget.Presenter;
import com.google.android.gms.internal.measurement.i5;
import j$.util.concurrent.ConcurrentHashMap;
import j5.t;

/* compiled from: r8-map-id-035a71e92ccd2a2b8039d43fa6fa76ac249b2a7f96061be914156707964ce49d */
/* loaded from: C:\Users\herod\Downloads\Jeux\classes3.dex */
public final class n extends Presenter {

    /* renamed from: a, reason: collision with root package name */
    public int f4746a;

    /* renamed from: b, reason: collision with root package name */
    public int f4747b;

    /* renamed from: l, reason: collision with root package name */
    public int f4748l;

    /* renamed from: m, reason: collision with root package name */
    public int f4749m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f4750n;

    public final void a(m mVar, boolean z9) {
        int i = z9 ? this.f4746a : this.f4747b;
        int i6 = z9 ? this.f4749m : this.f4748l;
        mVar.setBackgroundColor(i);
        mVar.findViewById(R.id.info_field).setBackgroundColor(i);
        View findViewById = mVar.findViewById(R.id.title_text);
        findViewById.getClass();
        ((TextView) findViewById).setTextColor(i6);
        View findViewById2 = mVar.findViewById(R.id.content_text);
        findViewById2.getClass();
        ((TextView) findViewById2).setTextColor(i6);
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        viewHolder.getClass();
        View view = viewHolder.view;
        view.getClass();
        ImageCardView imageCardView = (ImageCardView) view;
        if (obj instanceof x4.e) {
            x4.e eVar = (x4.e) obj;
            imageCardView.setTitleText(eVar.f11122b);
            Context context = imageCardView.getContext();
            context.getClass();
            imageCardView.setContentText(i5.H(context, eVar.f11133w));
            ConcurrentHashMap concurrentHashMap = t.f6708a;
            Context context2 = viewHolder.view.getContext();
            context2.getClass();
            String str = eVar.f11123l;
            str.getClass();
            Drawable b7 = t.b(context2, str);
            Resources resources = imageCardView.getResources();
            imageCardView.setMainImageDimensions(resources.getDimensionPixelSize(2131166557), resources.getDimensionPixelSize(2131166557));
            if (b7 != null) {
                imageCardView.setMainImage(b7);
            } else {
                imageCardView.setMainImage(this.f4750n);
            }
            imageCardView.setPadding(18, 18, 18, 18);
        }
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        viewGroup.getClass();
        this.f4747b = ContextCompat.getColor(viewGroup.getContext(), 2131099686);
        this.f4746a = ContextCompat.getColor(viewGroup.getContext(), 2131099686);
        this.f4748l = ContextCompat.getColor(viewGroup.getContext(), 2131100787);
        this.f4749m = ContextCompat.getColor(viewGroup.getContext(), 2131100789);
        this.f4750n = ContextCompat.getDrawable(viewGroup.getContext(), 2131231475);
        m mVar = new m(this, viewGroup.getContext());
        mVar.setFocusable(true);
        mVar.setFocusableInTouchMode(true);
        a(mVar, false);
        return new Presenter.ViewHolder(mVar);
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        viewHolder.getClass();
        View view = viewHolder.view;
        view.getClass();
        ImageCardView imageCardView = (ImageCardView) view;
        imageCardView.setBadgeImage(null);
        imageCardView.setMainImage(null);
    }
}
